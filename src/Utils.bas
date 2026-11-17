B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=10.7
@EndOfDesignText@
'Static code module

' Log(GetSystemProperty("javafx.runtime.version", "unknown"))

Sub Process_Globals
	Private fx As JFX
End Sub

Public Sub FormatNumber(Value As Double) As String
	Dim Result As String = NumberFormat2(Value, 1, 0, 6, False)

	Do While Result.Contains(".") And Result.EndsWith("0")
		Result = Result.SubString2(0, Result.Length - 1)
	Loop

	If Result.EndsWith(".") Then
		Result = Result.SubString2(0, Result.Length - 1)
	End If

	Return Result
End Sub

' Returns the filename from a fullpath
Public Sub GetFileName(path As String) As String
	' Define the JavaObject
	Dim fileO As JavaObject
	' Get the fileio class
	fileO.InitializeNewInstance("java.io.File", Array As Object(path))
	' Getthe filename
	Return fileO.RunMethod("getName", Null)
End Sub

' Returns the filepath from a fullpath
Public Sub GetFilePath(path As String) As String
	' Define the JavaObject
	Dim fileO As JavaObject
	' Get the fileio class
	fileO.InitializeNewInstance("java.io.File", Array As Object(path))
	' Getthe filename and path
	Dim n As String = fileO.RunMethod("getName", Null)
	Dim p As String = fileO.RunMethod("getPath", Null)
	p = p.Replace(n, "")
	Return p
End Sub

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


Public Sub ConvertBasicTextToUpper(Source As String) As String
	Dim Result As StringBuilder
	Result.Initialize

	Dim InString As Boolean = False

	For i = 0 To Source.Length - 1
		Dim c As String = Source.SubString2(i, i + 1)

		If c = Chr(34) Then
			InString = Not(InString)
			Result.Append(c)
		Else If InString Then
			Result.Append(c)
		Else
			Result.Append(c.ToUpperCase)
		End If
	Next

	Return Result.ToString
End Sub

Public Sub ComboBoxSetPromptText(box As ComboBox, text As String)
	Dim joCB As JavaObject = box
	joCB.RunMethod("setPromptText", Array(text))
End Sub
