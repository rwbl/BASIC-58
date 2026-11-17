B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.7
@EndOfDesignText@
' ================================================================
' File:			B58Serial
' Brief:		
' Description:	
' DependsOn:	
' ================================================================

Sub Class_Globals

	' Communication
	Private SerialLine As Serial
	Private mIsConnected As Boolean = False
	Private AStreams As AsyncStreams
	Private RxBuffer As List
	
	' Event callback
	Private mCallback As Object
	Private mEventName As String

	' Command Handling
	Private PendingCommand As Boolean = False
	Private PendingAdr As Byte
	Private PendingCmd As Byte
	Private PendingVal As Byte

	Private CommandTimer As Timer
	Private Const COMMAND_TIMEOUT_MS As Int = 2000
	
	' Helper
	Private bc As ByteConverter
End Sub

Public Sub Initialize(Callback As Object, EventName As String)
	mCallback = Callback
	mEventName = EventName
	RxBuffer.Initialize
	CommandTimer.Initialize("CommandTimer", COMMAND_TIMEOUT_MS)
	CommandTimer.Enabled = False
End Sub

Public Sub GetAvailablePorts As List
	Return SerialLine.ListPorts
End Sub

Public Sub Connect(Port As String)

	Log($"[B58Serial.Connect] Port: ${Port}"$)

	Disconnect

	SerialLine.Initialize("SerialLine")

	Try
		SerialLine.Open(Port)
		SerialLine.SetParams(115200, 8, 1, 0)

		AStreams.Initialize(SerialLine.GetInputStream, SerialLine.GetOutputStream, "AStreams")
	
		mIsConnected = True

		Log($"[B58Serial.Connect] Connected: ${Port}"$)
		CallSub(mCallback, mEventName & "_Connected")

	Catch
		Dim errorMessage As String = LastException.Message
		Dim userMessage As String

		Log($"[B58Serial.Connect][E] ${errorMessage}"$)

		If errorMessage.Contains("Port not found") Then
			userMessage = $"COM port ${Port} not found."$
		Else If errorMessage.Contains("Port busy") Then
			userMessage = $"COM port ${Port} is already in use."$
		Else
			userMessage = "Unable to connect to " & Port & "."
		End If

		Disconnect
		CallSub2(mCallback, mEventName & "_Error", userMessage)
	End Try
	
End Sub

Public Sub Disconnect
	Dim WasConnected As Boolean = mIsConnected

	CommandTimer.Enabled = False
	PendingCommand = False
	RxBuffer.Clear
	
	Try
		If AStreams.IsInitialized Then AStreams.Close
	Catch
		Log("[B58Serial.Disconnect][E] Error closing streams.")
	End Try

	Try
		If mIsConnected Then SerialLine.Close
	Catch
		Log("[B58Serial.Disconnect][E] Error closing serial port.")
	End Try

	mIsConnected = False

	If WasConnected Then
		Log("[B58Serial] Disconnected.")
		CallSub(mCallback, mEventName & "_Disconnected")
	End If
End Sub

Public Sub IsConnected As Boolean
	Return mIsConnected
End Sub

Private Sub AStreams_NewData(Buffer() As Byte)
	Log($"[B58Serial.NewData] Length=${Buffer.Length}, Hex=${bc.HexFromBytes(Buffer)}"$)

	For Each b As Byte In Buffer
		RxBuffer.Add(b)
	Next

	Do While RxBuffer.Size >= B58Protocol.FRAME_SIZE

		Dim receivedByte As Byte = RxBuffer.Get(0)

		' Find frame header.
		If receivedByte <> B58Protocol.FRAME_HEADER Then
			RxBuffer.RemoveAt(0)
			Continue
		End If

		' Check frame footer.
		Dim lastByte As Byte = RxBuffer.Get(B58Protocol.FRAME_SIZE - 1)

		If lastByte <> B58Protocol.FRAME_FOOTER Then
			RxBuffer.RemoveAt(0)
			Continue
		End If

		' Extract complete frame.
		Dim Frame(B58Protocol.FRAME_SIZE) As Byte

		For i = 0 To B58Protocol.FRAME_SIZE - 1
			Frame(i) = RxBuffer.Get(i)
		Next

		' Remove processed bytes.
		For i = 0 To B58Protocol.FRAME_SIZE - 1
			RxBuffer.RemoveAt(0)
		Next

		ProcessIncomingFrame(Frame)
	Loop
End Sub

Private Sub ProcessIncomingFrame(Frame() As Byte)
	If B58Protocol.CheckFrame(Frame) = False Then Return

	Dim Adr As Byte = B58Protocol.GetAdr(Frame)
	Dim Cmd As Byte = B58Protocol.GetCmd(Frame)
	Dim Val As Byte = B58Protocol.GetVal(Frame)

	Log($"[B58Serial.Frame] ADR=${B58Protocol.ToUnsigned(Adr)} CMD=${B58Protocol.ToUnsigned(Cmd)} VAL=${B58Protocol.ToUnsigned(Val)}"$)

	If PendingCommand = False Then
		Log("[B58Serial.Frame] Unexpected response.")
		Return
	End If

	If Adr <> PendingAdr Or Cmd <> PendingCmd Then
		Log("[B58Serial.Frame] Response does not match pending command.")
		Return
	End If

	CommandTimer.Enabled = False
	PendingCommand = False

	If Val = B58Protocol.STATE_ERR Then
		CallSub2(mCallback, mEventName & "_CommandError", "Controller rejected command.")
		Return
	End If

	If Val <> PendingVal Then
		CallSub2(mCallback, mEventName & "_CommandError", "Unexpected response value.")
		Return
	End If

	' Successful acknowledgement.
	CallSub2(mCallback, mEventName & "_CommandCompleted", Frame)
End Sub

Private Sub AStreams_Error
	Log("[B58Serial][E] AsyncStreams error.")
	Disconnect
End Sub

Private Sub AStreams_Terminated
	Log("[B58Serial] AsyncStreams terminated.")
	Disconnect
End Sub

Private Sub AStreamsWrite(Data() As Byte) As Boolean
	Try
		AStreams.Write(Data)
		Log($"[B58Serial.AStreamsWrite] ${bc.HexFromBytes(Data)}"$)
		Return True
	Catch
		Log($"[B58Serial.AStreamsWrite][E] ${LastException}"$)
		Return False
	End Try
End Sub

Public Sub SendCommand(Adr As Byte, Cmd As Byte, Val As Byte) As Boolean
	If mIsConnected = False Then
		Log("[B58Serial.SendCommand][E] Not connected.")
		Return False
	End If

	If PendingCommand Then
		Log("[B58Serial.SendCommand][E] Command already pending.")
		Return False
	End If

	Dim Frame() As Byte = B58Protocol.CreateFrame(Adr, Cmd, Val)

	PendingAdr = Adr
	PendingCmd = Cmd
	PendingVal = Val
	PendingCommand = True

	If AStreamsWrite(Frame) = False Then
		PendingCommand = False
		Return False
	End If

	CommandTimer.Enabled = True

	Return True
End Sub

Private Sub CommandTimer_Tick
	CommandTimer.Enabled = False

	If PendingCommand = False Then Return

	PendingCommand = False

	Log("[B58Serial][E] Command timeout.")

	CallSub2(mCallback, mEventName & "_CommandError", "Command timeout.")
End Sub

Public Sub ExecuteCommand(Command As String)

	Dim Parts() As String = Regex.Split(" ", Command.Trim)
	Dim Device As String = ""

	If Parts.Length >= 2 Then Device = Parts(1).ToUpperCase

	Select Device

		Case "CONNECT"
			If Parts.Length <> 3 Then
				CallSub2(mCallback, mEventName & "_CommandError", "Usage: @SER CONNECT COM10")
				Return
			End If

			If mIsConnected Then
				CallSub2(mCallback, mEventName & "_CommandError", "Already connected.")
				Return
			End If

			Connect(Parts(2))

		Case "DISCONNECT"
			If Parts.Length <> 2 Then
				CallSub2(mCallback, mEventName & "_CommandError", "Usage: @SER DISCONNECT")
				Return
			End If

			If mIsConnected = False Then
				CallSub2(mCallback, mEventName & "_CommandError", "Not connected.")
				Return
			End If

			Disconnect

		Case "LED"
			If Parts.Length <> 4 Then
				CallSub2(mCallback, mEventName & "_CommandError", "Usage: @SER LED 18 ON/OFF")
				Return
			End If

			Dim Adr As Int = -1
			If IsNumber(Parts(2)) Then Adr = Parts(2)

			If Adr <> B58Protocol.ToUnsigned(B58Protocol.LEDD4_ADR) Then
				CallSub2(mCallback, mEventName & "_CommandError", "Unknown LED address.")
				Return
			End If

			Dim Val As Byte

			Select Parts(3).ToUpperCase
				Case "ON"
					Val = B58Protocol.STATE_ON
				Case "OFF"
					Val = B58Protocol.STATE_OFF
				Case Else
					CallSub2(mCallback, mEventName & "_CommandError", "Invalid LED state. Use ON or OFF.")
					Return
			End Select

			SendCommand(B58Protocol.LEDD4_ADR, B58Protocol.CMD_LED_SET_STATE, Val)

		Case "LISTPORTS"
			If Parts.Length <> 2 Then
				CallSub2(mCallback, mEventName & "_CommandError", "Usage: @SER LISTPORTS")
				Return
			End If

			Dim Ports As List = GetAvailablePorts

			If Ports.Size = 0 Then
				CallSub(mCallback, mEventName & "_NoPortsFound")
				Return
			End If

			CallSub2(mCallback, mEventName & "_PortsFound", Ports)

		Case Else
			CallSub2(mCallback, mEventName & "_CommandError", "Unknown serial command.")

	End Select

End Sub
