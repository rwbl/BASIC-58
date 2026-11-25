B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' Class Module:	B4XMainPage
' Project:		BASIC-58
' Brief:		Host control example.
' Date:			See Class_Globals VERSION
' Author:		Robert W.B. Linn (c) 2026 MIT License
' Description:	Bi-directional Host Bridge demonstration:
'				1. Host → BASIC-58: SetVariable
'				2. BASIC-58 → Host: GetVariables
' ================================================================

#Region Shared Files
#CustomBuildAction: folders ready, %WINDIR%\System32\Robocopy.exe,"..\..\Shared Files" "..\Files"
'Ctrl + click to sync files: ide://run?file=%WINDIR%\System32\Robocopy.exe&args=..\..\Shared+Files&args=..\Files&FilesSync=True
#End Region

#Macro: Title, Export B4XPages, ide://run?File=%B4X%\Zipper.jar&Args=%PROJECT_NAME%.zip

Sub Class_Globals
	Private VERSION As String = "HOSTControl v20261124"
	Private ABOUT As String = "BASIC-58 Example (c) Robert W.B. Linn 2026 - MIT"
	
	' UI Base
	Private xui As XUI
	Private Root As B4XView

	' UI Views
	Private btnHostControlReset As B4XView
	Private btnHostControlRun As B4XView
	Private btnHostControlStop As B4XView
	Private btnProgramOutputClear As B4XView
	Private btnHostOutputClear As B4XView
	Private taB58SourceEditor As TextArea
	Private taB58ProgramOutput As TextArea
	Private taHostOutput As TextArea
	Private lblAbout As B4XView

	' Helper
	Private bc As ByteConverter

	' BASIC-58
	Private Interpreter As B58Interpreter
	Private Serial As B58Serial
	
'	Private TestCode As String = $"05 REM Test
'10 PRINT "HOST CONTROL TEST"
'20 IF STOP = 1 THEN 60
'30 PRINT "PROGRAM CONTINUES"
'40 GOTO 20
'60 PRINT "STOP REQUEST RECEIVED"
'70 END
'"$

'	Private TestCode As String = $"05 REM Test
'10 PRINT "HOST NOTIFICATION TEST"
'20 @HOST STATE "PUMP" 1
'30 @HOST STATE "PUMP" 0
	'40 End
	'"$

	Private TestCode As String = $"05 REM Test
10 @SER CONNECT COM10
20 LET LED = 18
30 PRINT "SWITCH LED ON"
40 @SER LED 4 1
50 @DELAY 1000
60 PRINT "SWITCH LED OFF"
70 @SER LED 4 0
80 @SER DISCONNECT
90 PRINT "DONE"
100 END
"$
End Sub

Public Sub Initialize
'	B4XPages.GetManager.LogEvents = True
End Sub

'This event will be called once, before the page becomes visible.
Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("MainPage")

	' BASIC-58 Interpreter with event prefix Interpreter
	Interpreter.Initialize(Me, "Interpreter")
	' BASIC-58 Serial with event prefix Serial
	Serial.Initialize(Me, "Serial")

	' UI
	B4XPages.GetNativeParent(Me).Resizable = False
	B4XPages.SetTitle(Me, VERSION)
	lblAbout.Text = ABOUT
	
	taB58SourceEditor.Text = TestCode
End Sub

' ----------------------------------------------------------------
' UI Styling
' ----------------------------------------------------------------
' Not used (yet)

' ----------------------------------------------------------------
' UI Events
' ----------------------------------------------------------------

Private Sub btnHostControlRun_Click
    taHostOutput.Text = ""
    Interpreter.LoadProgram(taB58SourceEditor.Text)
    Interpreter.RunProgram
End Sub

Private Sub btnHostControlStop_Click
	Interpreter.ExecuteCommand("BREAK")
	PrintText(taB58ProgramOutput, "STOP")
End Sub

Private Sub btnHostControlReset_Click
	PrintText(taB58ProgramOutput, "RESET")
End Sub

Private Sub btnProgramOutputClear_Click
	taB58ProgramOutput.Text = ""	
End Sub

Private Sub btnHostOutputClear_Click
	taHostOutput.Text = ""
End Sub

' ----------------------------------------------------------------
' INTERPRETERCALLBACKS
' ----------------------------------------------------------------
#Region InterpreterCallbacks
' Interpreter_Output
' Write string with newline option to the output textarea.
Private Sub Interpreter_Output(Value As String, NewLine As Boolean)
	Dim NativeTextArea As JavaObject = taB58ProgramOutput
	Dim s As String = Value

	If NewLine Then s = s & CRLF

	NativeTextArea.RunMethod("appendText", Array(s))
	NativeTextArea.RunMethod("positionCaret", Array(NativeTextArea.RunMethod("getLength", Null)))

	Wait For (ScrollTextToBottom(taB58ProgramOutput)) Complete (Success As Boolean)
End Sub

' Interpreter_Ready
' Add to the program output
Private Sub Interpreter_Ready
    Dim Vars As Map = Interpreter.GetVariables
    For Each Name As String In Vars.Keys
        PrintText(taHostOutput, Name & " = " & Vars.Get(Name))
    Next
End Sub

 Private Sub Interpreter_ProgramRenumbered(ProgramText As String)
	taB58SourceEditor.Text = ProgramText
End Sub

' Interpreter_HostStateChanged
' Listen to host variable state changes
Private Sub Interpreter_HostStateChanged(Name As String, Value As Double)
	PrintText(taHostOutput, Name & " = " & Value)
End Sub

Private Sub Interpreter_HardwareCommand(Command As String)
	Serial.ExecuteCommand(Command)
End Sub

#End Region

' ----------------------------------------------------------------
' SERIAL COMMUNICATION
' ----------------------------------------------------------------
#Region B58Serial
Private Sub Serial_Connected
	PrintText(taHostOutput, "[BASIC-58] Controller connected.")
	Sleep(2000) ' Allow Arduino UNO reset
	Interpreter.ResumeHardwareCommand
End Sub

Private Sub Serial_CommandCompleted(Frame() As Byte)
	PrintText(taHostOutput, $"[BASIC-58] ACK received: ${bc.HexFromBytes(Frame)}"$)
	Interpreter.ResumeHardwareCommand
End Sub

Private Sub Serial_CommandError(Message As String)
	PrintText(taHostOutput, "[BASIC-58][E] " & Message)
	Interpreter.ResumeHardwareCommand
End Sub

Private Sub Serial_Disconnected
	PrintText(taHostOutput, "[BASIC-58] Controller disconnected.")
	Interpreter.ResumeHardwareCommand
	Interpreter.ExternalDataDisconnected
End Sub

Private Sub Serial_Error(Message As String)
	PrintText(taHostOutput, "[BASIC-58][E] " & Message)
End Sub

Private Sub Serial_PortsFound(Ports As List)
	PrintText(taHostOutput, "AVAILABLE SERIAL PORTS:")
	For Each Port As String In Ports
		PrintText(taHostOutput, Port)
	Next
End Sub

Private Sub Serial_NoPortsFound
	PrintText(taHostOutput, "NO SERIAL PORTS FOUND.")
End Sub

Private Sub Serial_DataReceived(Frame() As Byte)

	Dim Adr As Byte = B58Protocol.GetAdr(Frame)
	Dim Cmd As Byte = B58Protocol.GetCmd(Frame)
	Dim Val As Byte = B58Protocol.GetVal(Frame)

	Log($"[BASIC-58] Received: ADR=${B58Protocol.ToUnsigned(Adr)} CMD=${B58Protocol.ToUnsigned(Cmd)} VAL=${B58Protocol.ToUnsigned(Val)}"$)

	Interpreter.SubmitExternalData( _
    	B58Protocol.ToUnsigned(Adr), _
    	B58Protocol.ToUnsigned(Cmd), _
    	B58Protocol.ToUnsigned(Val))
End Sub
#End Region

' ----------------------------------------------------------------
' PRINT & OUTPUT
' ----------------------------------------------------------------
#Region PrintAndOutput
Private Sub PrintText(Target As B4XView, Value As String)
	Dim NativeTextArea As JavaObject = Target
	NativeTextArea.RunMethod("appendText", Array(Value & CRLF))
	NativeTextArea.RunMethod("positionCaret", Array(NativeTextArea.RunMethod("getLength", Null)))

	Wait For (ScrollTextToBottom(Target)) Complete (Success As Boolean)
End Sub
#End Region

' ----------------------------------------------------------------
' UI HELPER
' ----------------------------------------------------------------
#Region UIHelper
Public Sub ScrollTextToBottom(Target As B4XView) As ResumableSub
	Sleep(50)

	Dim NativeTextArea As JavaObject = Target
	NativeTextArea.RunMethod("setScrollTop", Array(100000.0))

	Return True
End Sub

Public Sub ScrollTextToTop(Target As B4XView) As ResumableSub
	Sleep(50)

	Dim NativeTextArea As JavaObject = Target
	NativeTextArea.RunMethod("setScrollTop", Array(0.0))

	Return True
End Sub
#End Region
