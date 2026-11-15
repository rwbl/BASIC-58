B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' File:			B4XMainPage
' Project:		BASIC-58
' Brief:		Development program for BASIC-58.
' Date:			See Class_Globals VERSION
' Author:		Robert W.B. Linn (c) 2026 MIT License
' Description:	This page is used to develop & test BASIC-58.
' DependsOn:	CSSUtils.
'				Interpreter owns the Basic program, variables, execution state And all Basic commands.
'				B4XMainPage owns the editor, terminal, command field, File dialogs And application state.
'				The interpreter communicates with the page through callbacks.
' Note:
'				Made with curiosity, a little nostalgia, and the conviction that BASIC still has something to teach us.
' ================================================================

#Region Shared Files
' #CustomBuildAction: folders ready, %WINDIR%\System32\Robocopy.exe,"..\..\Shared Files" "..\Files"
' Ctrl + click to sync files: ide://run?file=%WINDIR%\System32\Robocopy.exe&args=..\..\Shared+Files&args=..\Files&FilesSync=True
#End Region

#Macro: Title, Export B4XPages, ide://run?File=%B4X%\Zipper.jar&Args=%PROJECT_NAME%.zip

Sub Class_Globals
	' A tiny BASIC interpreter
	Private VERSION As String = "BASIC-58"

	' Core
	Private fx As JFX
	Private xui As XUI

	' UI
	Private Root As B4XView
	Private pnToolbar As B4XView
	Private lblToolbar As B4XView
	Private tfCommand As B4XView
	Private taEditor As B4XView
	Private taOutput As B4XView
	Private lblFile As B4XView
	Private lblEditor As B4XView
	Private pnEditor As B4XView
	Private pnOutput As B4XView
	Private lblStatus As B4XView

	' Toolbar
	Private DesignerUtils As DDD

	' Files & Editor
	Private CurrentFileName As String
	Private CurrentFilePath As String
	Private ProgramModified As Boolean
	Private LoadingProgram As Boolean
	Private UpdatingEditor As Boolean
	
	' BASIC-58 Interpreter
	Private Basic58 As Basic58Interpreter
End Sub

Public Sub Initialize
'	B4XPages.GetManager.LogEvents = True
End Sub

'This event will be called once, before the page becomes visible.
Private Sub B4XPage_Created (Root1 As B4XView)
	' UI Base
	Root = Root1
	DesignerUtils.Initialize
	Root.LoadLayout("MainPage")

	' Interpreter	
	Basic58.Initialize(Me, "Interpreter")
	' Log(GetSystemProperty("javafx.runtime.version", "unknown"))

	' Create BASIC58 data directory.
	CurrentFilePath = File.DirApp
	CurrentFileName = "PROGRAM.BAS"
	ProgramModified = False
	
	' UI
	B4XPages.GetNativeParent(Me).Resizable = False
	taEditor.As(TextArea).Editable = True
	lblFile.Text = CurrentFileName
	lblStatus.Text = "READY"
	UpdatePageTitle
		
	' For tests
'	tfCommand.Text = "LOAD"
'	tfCommand_Action
'	tfCommand.Text = "LIST"
'	tfCommand_Action
'	tfCommand.Text = "RUN"
'	tfCommand_Action
	
	InitializeUIStyle
	
	' Welcome Message
	InitializeScreen
End Sub

' ----------------------------------------------------------------
' UI Styling
' ----------------------------------------------------------------

' InitializeUIStyle
' VT220 Amber
Private Sub InitializeUIStyle
	'--------------------------------------------------
	' Main application
	'--------------------------------------------------
	CSSUtils.SetBackgroundColor(Root, fx.Colors.From32Bit(0xFFDCD6C8))
	' Root.SetColorAndBorder(xui.Color_ARGB(0xFF,0xDC,0xD6,0xC8), 2, xui.Color_ARGB(0xFF,0x4A,0x48,0x45), 0)

	'--------------------------------------------------
	' Toolbar Label (aka Buttons) See Class DesignerToolbar
	'--------------------------------------------------
	CSSUtils.SetBackgroundColor(pnToolbar, fx.Colors.From32Bit(0xFFDCD6C8))
	lblToolbar.Font = fx.CreateFont("Consolas", 16, True, False)
	CSSUtils.SetStyleProperty(lblToolbar, "-fx-text-fill", "#4A4845")

	'--------------------------------------------------
	' PROGRAM & FILE
	'--------------------------------------------------
	lblEditor.Font = fx.CreateFont("Consolas", 16, True, False)
	CSSUtils.SetStyleProperty(lblEditor, "-fx-text-fill", "#4A4845")
	lblFile.Font = fx.CreateFont("Consolas", 16, True, False)
	CSSUtils.SetStyleProperty(lblFile, "-fx-text-fill", "#4A4845")

	'--------------------------------------------------
	' Editor Area
	'--------------------------------------------------
	CSSUtils.SetStyleProperty(taEditor, "-fx-control-inner-background", "#191713")
	CSSUtils.SetStyleProperty(taEditor, "-fx-text-fill", "#FFBF69")
	CSSUtils.SetStyleProperty(taEditor, "-fx-highlight-fill", "#80613A")
	CSSUtils.SetStyleProperty(taEditor, "-fx-highlight-text-fill", "#FFFFFF")
	CSSUtils.SetStyleProperty(taEditor, "-fx-border-color", "#80613A")
	CSSUtils.SetStyleProperty(taEditor, "-fx-border-width", "2")
	taEditor.Font = fx.CreateFont("Consolas", 16, False, False)
	
	'--------------------------------------------------
	' Output Area
	'--------------------------------------------------
	CSSUtils.SetStyleProperty(taOutput, "-fx-control-inner-background", "#191713")
	CSSUtils.SetStyleProperty(taOutput, "-fx-text-fill", "#FFBF69")
	CSSUtils.SetStyleProperty(taOutput, "-fx-highlight-fill", "#80613A")
	CSSUtils.SetStyleProperty(taOutput, "-fx-highlight-text-fill", "#FFFFFF")
	CSSUtils.SetStyleProperty(taOutput, "-fx-border-color", "#80613A")
	CSSUtils.SetStyleProperty(taOutput, "-fx-border-width", "2")
	taOutput.Font = fx.CreateFont("Consolas", 16, False, False)

	'--------------------------------------------------
	' Command input
	'--------------------------------------------------
	CSSUtils.SetStyleProperty(tfCommand, "-fx-background-color", "#211B13")
	CSSUtils.SetStyleProperty(tfCommand, "-fx-text-fill", "#FFBF69")
	CSSUtils.SetStyleProperty(tfCommand, "-fx-prompt-text-fill", "#C9954A")
	CSSUtils.SetStyleProperty(tfCommand, "-fx-border-color", "#80613A")
	CSSUtils.SetStyleProperty(tfCommand, "-fx-border-width", "1")
	tfCommand.Font = fx.CreateFont("Consolas", 17, False, False)

	'--------------------------------------------------
	' Status
	'--------------------------------------------------
	lblStatus.Font = fx.CreateFont("Consolas", 12, True, False)
	CSSUtils.SetStyleProperty(lblStatus, "-fx-text-fill", "#4A4845")

End Sub

Private Sub InitializeScreen	'ignore

	PrintText(taOutput, "**** BASIC-58 ****")
	PrintText(taOutput, "BASIC INTERPRETER")
	PrintText(taOutput, "TYPE HELP FOR COMMANDS")
	PrintText(taOutput, "")
	PrintText(taOutput, "READY.")

	lblStatus.Text = "READY"
End Sub

' ----------------------------------------------------------------
' CALLBACKS
' ----------------------------------------------------------------

Private Sub Interpreter_Output(Value As String, NewLine As Boolean)
	Dim NativeTextArea As JavaObject = taOutput
	Dim s As String = Value

	If NewLine Then s = s & CRLF

	NativeTextArea.RunMethod("appendText", Array(s))
	NativeTextArea.RunMethod("positionCaret", Array(NativeTextArea.RunMethod("getLength", Null)))

	Wait For (Utils.ScrollTextToBottom(taOutput)) Complete (Success As Boolean)
End Sub

Private Sub Interpreter_Ready
	lblStatus.Text = "READY"
End Sub

' ----------------------------------------------------------------
' UI EVENTS
' ----------------------------------------------------------------
#Region UI Events
'Handle click of a toolbar label
'Label tag is an array object with 3 entries: Layoutmodule (map), eventname (string), tag (string)
'The label tag is assigned to an array object from which the entry with index 2 is assigned to string.
Private Sub Toolbar_Click (lbl As B4XView)
	Dim o() As Object = lbl.Tag
	Dim tag As String = o(2)
	'Log($"[Toolbar_Click] tag=${tag}, text=${lbl.Text}"$)
	Select tag.ToLowerCase
		Case "edit"
			taEditor.As(TextArea).Editable = Not(taEditor.As(TextArea).Editable)
		Case "load"
			Load
		Case "save"
			Save
		Case "run"
			Basic58.LoadProgram(taEditor.Text)
			Basic58.RunProgram
	End Select
	'B4XPages.SetTitle(Me, tag)
End Sub

Private Sub taEditor_TextChanged (Old As String, New As String)
	If UpdatingEditor Then Return

	If LoadingProgram = False Then
		ProgramModified = True
		UpdatePageTitle
	End If

	Dim UpperText As String = Utils.ConvertBasicTextToUpper(New)

	If New <> UpperText Then
		Dim TextArea As JavaObject = taEditor
		Dim CursorPosition As Int = TextArea.RunMethod("getCaretPosition", Null)

		UpdatingEditor = True
		taEditor.Text = UpperText
		TextArea.RunMethod("positionCaret", Array(CursorPosition))
		UpdatingEditor = False
	End If
End Sub

Private Sub tfCommand_Action
	ProcessInput
End Sub
#End Region

' ----------------------------------------------------------------
' PROCESSING
' ----------------------------------------------------------------
#Region Processing
Private Sub ProcessCommand(Command As String)
	Dim UpperCommand As String = Command.Trim.ToUpperCase

	Select Case True
		Case UpperCommand = "SAVE" Or UpperCommand.StartsWith("SAVE ")
			SaveProgram(Command.SubString(4).Trim, CurrentFilePath)

		Case UpperCommand = "LOAD" Or UpperCommand.StartsWith("LOAD ")
			Wait For (ConfirmDiscardChanges) Complete (Confirmed As Boolean)
			If Confirmed = False Then Return
			LoadProgram(Command.SubString(4).Trim)

		Case UpperCommand = "CLS"
			taOutput.Text = ""

		Case UpperCommand = "NEW"
			NewProgram

		Case UpperCommand = "RUN"
			Basic58.LoadProgram(taEditor.Text)
			Basic58.RunProgram

		Case Else
			Basic58.ExecuteCommand(Command)
	End Select
End Sub

Private Sub ProcessInput

	Dim Command As String = tfCommand.Text.Trim

	If Command = "" And Basic58.IsWaitingForInput = False Then Return

	tfCommand.Text = ""

	If Basic58.IsWaitingForInput Then
		Basic58.SubmitInput(Command)
	Else
		ProcessCommand(Command)
	End If

End Sub
#End Region

Private Sub PrintText(Target As B4XView, Value As String)
	Dim NativeTextArea As JavaObject = Target
	NativeTextArea.RunMethod("appendText", Array(Value & CRLF))
	NativeTextArea.RunMethod("positionCaret", Array(NativeTextArea.RunMethod("getLength", Null)))

	If Target.Tag = taOutput.Tag Then
		Wait For (Utils.ScrollTextToBottom(taOutput)) Complete (Success As Boolean)
	End If
End Sub

Private Sub NewProgram
	If ProgramModified Then
		Wait For (ConfirmDiscardChanges) Complete (Confirmed As Boolean)
		If Confirmed = False Then Return
	End If

	' Clear editor.
	LoadingProgram = True
	taEditor.Text = ""
	LoadingProgram = False

	' Clear interpreter and output.
	Basic58.ClearProgram
	taOutput.Text = ""

	' Reset program information.
	CurrentFileName = "PROGRAM.BAS"
	lblFile.Text = CurrentFileName
	ProgramModified = False

	UpdatePageTitle
	lblStatus.Text = "READY"
End Sub
        
Private Sub SaveProgram(FileName As String, FilePath As String) As Boolean
	Basic58.LoadProgram(taEditor.Text)

	'Log("EDITOR TEXT: " & taEditor.Text)
	'Log("PROGRAM LINES: " & ProgramLines.Size)

	If Basic58.GetProgramLineCount = 0 Then
		PrintText(taOutput, "NO PROGRAM")
		Return False
	End If

	If FileName = "" Then
		FileName = "PROGRAM.BAS"
	End If

	If FileName.Contains("/") Or FileName.Contains("\") Then
		PrintText(taOutput, "?INVALID FILE NAME")
		Return False
	End If

	FileName = FileName.Trim

	If FileName.ToUpperCase.EndsWith(".BAS") = False Then
		Dim DotPosition As Int = FileName.LastIndexOf(".")
		If DotPosition > 0 Then
			FileName = FileName.SubString2(0, DotPosition)
		End If
		FileName = FileName & ".BAS"
	End If

	FileName = FileName.ToUpperCase

	Try
		Dim SavedLines As List
		SavedLines.Initialize

		Dim EditorLines() As String = Regex.Split(CRLF, taEditor.Text)

		For Each EditorLine As String In EditorLines
			SavedLines.Add(EditorLine)
		Next

		File.WriteList(FilePath, FileName, SavedLines)

		'Log("[SaveProgram] Exists: " & File.Exists(CurrentFilePath, FileName))
		'Log("[SaveProgram] Size: " & File.Size(CurrentFilePath, FileName))
		
		CurrentFilePath = FilePath
		CurrentFileName = FileName
		lblFile.Text = CurrentFileName
		ProgramModified = False
		UpdatePageTitle

		PrintText(taOutput, "SAVED: " & FileName)
		
		Return True
		
	Catch
		PrintText(taOutput, "?SAVE ERROR")
		'Log($"[SaveProgram][E] ${LastException}"$)
		Return False
	End Try
End Sub

Private Sub LoadProgram(FileName As String)
	If FileName = "" Then
		FileName = "PROGRAM.BAS"
		CurrentFileName = FileName
	End If

	If FileName.Contains("/") Or FileName.Contains("\") Then
		PrintText(taOutput, $"?INVALID FILE NAME - ${FileName}"$)
		Return
	End If

	FileName = FileName.Trim

	If FileName.ToUpperCase.EndsWith(".BAS") = False Then
		Dim DotPosition As Int = FileName.LastIndexOf(".")
		If DotPosition > 0 Then
			FileName = FileName.SubString2(0, DotPosition)
		End If
		FileName = FileName & ".BAS"
	End If

	FileName = FileName.ToUpperCase

	If File.Exists(CurrentFilePath, FileName) = False Then
		PrintText(taOutput, "?FILE NOT FOUND: " & FileName)
		Return
	End If

	Try
		Dim SavedLines As List = File.ReadList(CurrentFilePath, FileName)

		'Restore the complete source code in the editor.
		Dim EditorText As StringBuilder
		EditorText.Initialize

		For Each SavedLine As String In SavedLines
			If EditorText.Length > 0 Then
				EditorText.Append(CRLF)
			End If

			EditorText.Append(SavedLine)
		Next

		'Restore the complete source code in the editor.
		LoadingProgram = True
		taEditor.Text = EditorText.ToString
		LoadingProgram = False

		'Rebuild the interpreter program.
		Basic58.LoadProgram(taEditor.Text)

		CurrentFileName = FileName.ToUpperCase
		lblFile.Text = CurrentFileName

		ProgramModified = False
		UpdatePageTitle

		PrintText(taOutput, "LOADED: " & CurrentFileName)
		PrintText(taOutput, "LINES: " & Basic58.GetProgramLineCount)
	Catch
		LoadingProgram = False
		PrintText(taOutput, "?LOAD ERROR")
		Log($"[LoadProgram][E] ${LastException}"$)
	End Try
End Sub

Private Sub Load
	Dim Filename As String
	Dim FileChoose As FileChooser
	FileChoose.Initialize
	FileChoose.InitialDirectory = CurrentFilePath
	FileChoose.SetExtensionFilter("BAS", Array As String("*.bas"))
	FileChoose.Title = "Load Program"
	Filename = FileChoose.ShowOpen(B4XPages.GetNativeParent(Me))
	If Filename.Length = 0 Then
		Return
	End If
	Wait For (ConfirmDiscardChanges) Complete (Confirmed As Boolean)
	If Confirmed = False Then Return
	Try
		CurrentFileName = Utils.GetFileName(Filename).ToUpperCase
		CurrentFilePath = Utils.GetFilePath(Filename)
		lblFile.Text = CurrentFileName
		'Log($"[Load] path=${CurrentFilePath}, file=${CurrentFileName}"$)
		LoadProgram(CurrentFileName)
	Catch
		Log("[Load][E] Failed - " & LastException.Message)
	End Try
	Return
End Sub

'# Save Content TextArea To a TextFile
' Dim Str As String = "Hello World"
' StringToTextFile(MainForm, Str)
Private Sub Save
	Dim Filename As String
	Dim FileChoose As FileChooser
	FileChoose.Initialize
	FileChoose.InitialDirectory = CurrentFilePath
	FileChoose.InitialFileName = CurrentFileName
	FileChoose.Title = "Save Program"

	Filename = FileChoose.ShowSave(B4XPages.GetNativeParent(Me))
	If Filename.Length = 0 Then Return

	Try
		Dim SelectedFileName As String = Utils.GetFileName(Filename).ToUpperCase
		Dim SelectedFilePath As String = Utils.GetFilePath(Filename)

		SaveProgram(SelectedFileName, SelectedFilePath)

	Catch
		Log($"[Save][E] Failed - ${LastException.Message}"$)
	End Try
End Sub

Private Sub UpdatePageTitle
	Dim PageTitle As String = $"${VERSION} - ${CurrentFileName}"$

	If ProgramModified Then
		PageTitle = PageTitle & " *"
	End If

	B4XPages.SetTitle(Me, PageTitle)
End Sub

Private Sub ConfirmDiscardChanges As ResumableSub
	If ProgramModified = False Then Return True

	xui.Msgbox2Async("Discard unsaved changes?", "CONFIRM", _
        "Yes", "", "No", Null)
	Wait For Msgbox_Result (Result As Int)

	Return Result = xui.DialogResponse_Positive
End Sub

