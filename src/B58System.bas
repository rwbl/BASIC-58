B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.7
@EndOfDesignText@

Sub Class_Globals
	' Event callback
	Private mCallback As Object
	Private mEventName As String
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize(Callback As Object, EventName As String)
	' Callback and events.
	mCallback = Callback
	mEventName = EventName
End Sub

Public Sub ExecuteCommand(Command As String)

	Select Case Command.Trim.ToUpperCase
		Case "SHOW TIME"
			Dim systime As String = $"SYSTEM TIME: ${DateTime.Time(DateTime.Now)}"$
			CallSub2(mCallback, mEventName & "_Output", systime)
		Case "SHOW DATE"
			Dim systime As String = $"SYSTEM DATE: ${DateTime.Date(DateTime.Now)}"$
			CallSub2(mCallback, mEventName & "_Output", systime)
		Case Else
			Log("[BASIC-58][E] Unknown system command.")
	End Select

End Sub

