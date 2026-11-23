B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=10.7
@EndOfDesignText@
' ================================================================
' Code Module:	Utils
' Project:		BASIC-58
' Brief:		Shared utility functions for BASIC-58.
' Description:	Provides general-purpose helper functions used
'				throughout the application.
' ================================================================

' Scribbles:
' Log(GetSystemProperty("javafx.runtime.version", "unknown"))

Private Sub Process_Globals
	'
End Sub

' Return fomatted number without . and , characters.
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

' FILESYSTEM

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

Public Sub IsValidDirectory(Path As String) As Boolean
	Dim Dir As JavaObject
	Dir.InitializeNewInstance("java.io.File", Array(Path))
	Return Dir.RunMethod("isDirectory", Null)
End Sub

' CONVERSION

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

' ----------------------------------------------------------------
' CALLBACKS
' ----------------------------------------------------------------

' CallSubMethod
' Call a sub if exists.
' Parameters:
' callback - Object as the target
' event - Method
' name - Methodname
Public Sub CallSubMethod(callback As Object, event As String, name As String)
	Dim eventname As String = $"${event}${name}"$
	If SubExists(callback, eventname) Then
		' Log($"[CallSubMethod] ${eventname}"$)
		CallSubDelayed(callback, eventname)
	End If
End Sub

Public Sub CallSubMethod2(callback As Object, event As String, name As String, arg1 As Object)
	Dim eventname As String = $"${event}${name}"$
	If SubExists(callback, eventname) Then
		' Log($"[CallSubMethod2] ${eventname}, arg1=${arg1}"$)
		CallSubDelayed2(callback, eventname, arg1)
	End If
End Sub

Public Sub CallSubMethod3(callback As Object, event As String, name As String, arg1 As Object, arg2 As Object)
	Dim eventname As String = $"${event}${name}"$
	If SubExists(callback, eventname) Then
		' Log($"[CallSubMethod3] ${eventname}, arg1=${arg1}, arg2=${arg2}"$)
		CallSubDelayed3(callback, eventname, arg1, arg2)
	End If
End Sub

