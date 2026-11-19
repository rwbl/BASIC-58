B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.7
@EndOfDesignText@
Sub Class_Globals
	Private SerialLine As Serial
	Private AStreams As AsyncStreams
	Private bc As ByteConverter
End Sub

Public Sub Initialize
	SerialLine.Initialize("SerialLine")
End Sub

Public Sub Connect(Port As String)
	SerialLine.Open(Port)
	SerialLine.SetParams(115200, 8, 1, 0)
	AStreams.Initialize(SerialLine.GetInputStream, _
        SerialLine.GetOutputStream, "AStreams")
	Log("[B58SerialTest] Connected.")
End Sub

Private Sub AStreams_NewData(Buffer() As Byte)
	Log($"[B58SerialTest] RECEIVED: ${bc.HexFromBytes(Buffer)}"$)
End Sub
