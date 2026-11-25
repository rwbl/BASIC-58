B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
' ================================================================
' Class Module:	B4XMainPage
' Project:		BASIC-58
' Brief:		B4XPages development program for BASIC-58.
' Date:			See module B58System > Class_Globals VERSION
' Author:		Robert W.B. Linn (c) 2026 MIT License
' Description:	This page is used to develop & test BASIC-58.
' DependsOn:	CSSUtils.
'				Interpreter owns the Basic program, variables, execution state And all Basic commands.
'				B4XMainPage owns the editor, terminal, command field, File dialogs And application state.
'				The interpreter communicates with the page through callbacks.
'				Made with curiosity, a little nostalgia, and the conviction that BASIC still has something to teach us.
' ================================================================

#if RELEASE
#CustomBuildAction: 2,  %WINDIR%\system32\xcopy.exe, /Y result.* "BASIC-58.*"
#End If

#Region Shared Files
' #CustomBuildAction: folders ready, %WINDIR%\System32\Robocopy.exe,"..\..\Shared Files" "..\Files"
' Ctrl + click to sync files: ide://run?file=%WINDIR%\System32\Robocopy.exe&args=..\..\Shared+Files&args=..\Files&FilesSync=True
#End Region

' #Macro: Title, Export B4XPages, ide://run?File=%B4X%\Zipper.jar&Args=%PROJECT_NAME%.zip

Private Sub Class_Globals

	' Core
	Private fx As JFX
	Private xui As XUI

	' UI
	Private Root As B4XView
	Private spMain As SplitPane
	Private pnTerminal As B4XView
	Private lblTerminal As B4XView
	Private taTerminal As B4XView
	
	Private pnEditor As B4XView
	Private lblEditor As B4XView
	Private taEditor As B4XView	' TextArea

	Private pnToolbar As B4XView
	Private lblToolbar As B4XView
	Private cbCommands As ComboBox

	Private lblStatus As B4XView

	' Toolbar
	Private DesignerUtils As DDD

	' Files & Editor
	Private CurrentFileName As String
	Private CurrentFilePath As String
	Private ProgramModified As Boolean
	Private LoadingProgram As Boolean
	Private UpdatingEditor As Boolean
	
	' BASIC-58 
	' Interpreter
	Private Interpreter As B58Interpreter

	' Serial Communication
	Private Serial As B58Serial
	
	' System
	Private System As B58System
	
	' Helper
	Private bc As ByteConverter
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
	' Splitpane
	spMain.LoadLayout("PanelEditor")     'Left pane
	spMain.LoadLayout("PanelTerminal")    'Right pane
	
	' BASIC-58 
	' Interpreter with event prefix Interpreter
	Interpreter.Initialize(Me, "Interpreter")

	' Serial communication with event prefix Serial
	Serial.Initialize(Me, "Serial")

	' System commands
	System.Initialize(Me, "System")
	
	' Create BASIC58 data directory
	' Initialize BASIC program directory from system settings.
	CurrentFilePath = System.GetFileDir ' instead File.DirApp
	CurrentFileName = "PROGRAM.BAS"
	ProgramModified = False
	
	' B4Xpages
	B4XPages.GetNativeParent(Me).Icon = xui.LoadBitmap(File.DirAssets, "Icon.png")
	' B4XPages.GetNativeParent(Me).Resizable = False
	AssignKeyboardShortcuts
	ApplyUIStyle

	' Textareas editable state
	taEditor.As(TextArea).Editable = True
	taTerminal.As(TextArea).Editable = False

	ComboBoxSetPromptText(cbCommands, "ENTER COMMAND OR INPUT...")

	' Labels
	lblStatus.Text = "READY"

	UpdatePageTitle
	
	ShowWelcomMessage
End Sub

Private Sub B4XPage_CloseRequest As ResumableSub
	If xui.IsB4A Then
	End If
	Serial.Disconnect
	Return True
End Sub

' ----------------------------------------------------------------
' UI Styling
' ----------------------------------------------------------------

' ApplyUIStyle
' Apply UI style like DEC VT220 Amber
Private Sub ApplyUIStyle
	
	' Load special styling from extarnal styling sheet
	B4XPages.GetNativeParent(Me).Stylesheets.Add(File.GetUri(File.DirAssets, "Main.css"))
	
	'--------------------------------------------------
	' Main application
	'--------------------------------------------------
	CSSUtils.SetBackgroundColor(Root, fx.Colors.From32Bit(0xFFDCD6C8))
	' Root.SetColorAndBorder(xui.Color_ARGB(0xFF,0xDC,0xD6,0xC8), 2, xui.Color_ARGB(0xFF,0x4A,0x48,0x45), 0)

	'--------------------------------------------------
	' Label Editor
	'--------------------------------------------------
	lblEditor.Font = fx.CreateFont("Consolas", 16, True, False)
	CSSUtils.SetStyleProperty(lblEditor, "-fx-text-fill", "#4A4845")

	'--------------------------------------------------
	' Editor Area
	'--------------------------------------------------
	pnEditor.SetColorAndBorder(xui.Color_ARGB(0xFF,0xDC,0xD6,0xC8), 2, xui.Color_LightGray, 5)
	CSSUtils.SetStyleProperty(taEditor, "-fx-control-inner-background", "#191713")
	CSSUtils.SetStyleProperty(taEditor, "-fx-text-fill", "#FFBF69")
	CSSUtils.SetStyleProperty(taEditor, "-fx-highlight-fill", "#80613A")
	CSSUtils.SetStyleProperty(taEditor, "-fx-highlight-text-fill", "#FFFFFF")
	CSSUtils.SetStyleProperty(taEditor, "-fx-border-color", "#80613A")
	CSSUtils.SetStyleProperty(taEditor, "-fx-border-width", "2")
	taEditor.Font = fx.CreateFont("Consolas", 16, False, False)

	'--------------------------------------------------
	' Label Output
	'--------------------------------------------------
	lblTerminal.Font = fx.CreateFont("Consolas", 14, True, False)
	CSSUtils.SetStyleProperty(lblTerminal, "-fx-text-fill", "#4A4845")
	
	'--------------------------------------------------
	' Output Area
	'--------------------------------------------------
	pnTerminal.SetColorAndBorder(xui.Color_ARGB(0xFF,0xDC,0xD6,0xC8), 2, xui.Color_LightGray, 5)
	CSSUtils.SetStyleProperty(taTerminal, "-fx-control-inner-background", "#191713")
	CSSUtils.SetStyleProperty(taTerminal, "-fx-text-fill", "#FFBF69")
	CSSUtils.SetStyleProperty(taTerminal, "-fx-highlight-fill", "#80613A")
	CSSUtils.SetStyleProperty(taTerminal, "-fx-highlight-text-fill", "#FFFFFF")
	CSSUtils.SetStyleProperty(taTerminal, "-fx-border-color", "#80613A")
	CSSUtils.SetStyleProperty(taTerminal, "-fx-border-width", "2")
	taTerminal.Font = fx.CreateFont("Consolas", 16, False, False)

	'--------------------------------------------------
	' Command input
	'--------------------------------------------------
	' This combobox styling is setusing external file Main.css.
	
	'--------------------------------------------------
	' Toolbar Label (aka text for the Buttons, like F5 RUN) 
	' See Class DesignerToolbar
	'--------------------------------------------------
	CSSUtils.SetBackgroundColor(pnToolbar, fx.Colors.From32Bit(0xFFDCD6C8))
	lblToolbar.Font = fx.CreateFont("Consolas", 16, True, False)
	CSSUtils.SetStyleProperty(lblToolbar, "-fx-text-fill", "#4A4845")

	'--------------------------------------------------
	' Status Label (botton of the form)
	'--------------------------------------------------
	lblStatus.Font = fx.CreateFont("Consolas", 12, True, False)
	CSSUtils.SetStyleProperty(lblStatus, "-fx-text-fill", "#4A4845")
	CSSUtils.SetStyleProperty(lblStatus, "-fx-background-color", "#D2CDC6")

	' Apply - esp show the combobox cursor requested via sleep workaround
	Sleep(50)
	taTerminal.RequestFocus
	Sleep(20)
	cbCommands.RequestFocus
End Sub

' ----------------------------------------------------------------
' Keyboard shortcuts
' ----------------------------------------------------------------

#Region ShortCuts
Private Sub AssignKeyboardShortcuts
	Dim R As Reflector
	R.Target = B4XPages.GetNativeParent(Me).RootPane
	R.AddEventFilter("MainKeyPressed", "javafx.scene.input.KeyEvent.KEY_PRESSED")
End Sub

Private Sub MainKeyPressed_Filter(E As Event)
    Dim R As Reflector
    R.Target = E

    Dim KeyCode As String = R.RunMethod("getCode")
    Dim ControlDown As Boolean = R.RunMethod("isControlDown")

    If ControlDown Then
        Select KeyCode
            Case "N", "O", "S"
                R.RunMethod("consume")

                Select KeyCode
                    Case "N"
                        NewProgram
                    Case "O"
                        Load
                    Case "S"
                        Save
                End Select
        End Select

    Else
        Select KeyCode
			Case "F1"
				R.RunMethod("consume")
				ShowHelp

			Case "F4"
				R.RunMethod("consume")
				ProcessCommand("RENUM")
				
            Case "F5"
                R.RunMethod("consume")
				LoadEditorProgram
				PrepareRun
				Interpreter.RunProgram

            Case "F6"
                R.RunMethod("consume")
                ProcessCommand("LIST")

            Case "F7"
                R.RunMethod("consume")
                Load

            Case "F8"
                R.RunMethod("consume")
                Save

            Case "F9"
                R.RunMethod("consume")
                NewProgram

            Case "F10"
                R.RunMethod("consume")
				taTerminal.Text = ""

			Case "F11"
				R.RunMethod("consume")

				Dim NativeForm As Form = B4XPages.GetNativeParent(B4XPages.MainPage)
				Dim Stage As JavaObject = NativeForm.As(JavaObject).GetField("stage")
				Dim FullScreen As Boolean = Stage.RunMethod("isFullScreen", Null)
				Stage.RunMethod("setFullScreen", Array(Not(FullScreen)))
				
			Case "F12"
				R.RunMethod("consume")
				ProcessCommand("@SYS SHOW VERSION")
		End Select
    End If
End Sub
#End Region

' ----------------------------------------------------------------
' INTERPRETERCALLBACKS
' ----------------------------------------------------------------
#Region InterpreterCallbacks
' Interpreter_Output
' Write string with newline option to the output textarea.
Private Sub Interpreter_Output(Value As String, NewLine As Boolean)
	Dim NativeTextArea As JavaObject = taTerminal
	Dim s As String = Value

	If NewLine Then s = s & CRLF

	NativeTextArea.RunMethod("appendText", Array(s))
	NativeTextArea.RunMethod("positionCaret", Array(NativeTextArea.RunMethod("getLength", Null)))

	Wait For (ScrollTextToBottom(taTerminal)) Complete (Success As Boolean)
End Sub

' Interpreter_Ready
' Update label status with ready message.
Private Sub Interpreter_Ready
	lblStatus.Text = "READY"
End Sub

Private Sub Interpreter_HardwareCommand(Command As String)
    Serial.ExecuteCommand(Command)
End Sub

Private Sub Interpreter_SystemCommand(Command As String)
	System.ExecuteCommand(Command)
End Sub

Private Sub Interpreter_ProgramRenumbered(ProgramText As String)
    taEditor.Text = ProgramText
End Sub
#End Region

' ----------------------------------------------------------------
' SYSTEM CALLBACKS
' ----------------------------------------------------------------
#Region System
Private Sub System_Output(Message As String)
	PrintText(taTerminal, Message)
End Sub
#End Region

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
	Select tag.ToUppercase
			Case "RUN"
				LoadEditorProgram
				PrepareRun
				Interpreter.RunProgram
			Case "LIST"
				ProcessCommand("LIST")
			Case "LOAD"
				Load
			Case "SAVE"
				Save
			Case "NEW"
				NewProgram
			Case "CLS"
				taTerminal.Text = ""
	End Select
	'B4XPages.SetTitle(Me, tag)
End Sub

Private Sub taEditor_TextChanged (Old As String, New As String)
	If UpdatingEditor Then Return

	If LoadingProgram Then
		LoadingProgram = False
		Return
	End If

	ProgramModified = True
	UpdatePageTitle

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

'Private Sub taEditor_MouseClicked (EventData As MouseEvent)
'	If EventData.ClickCount = 2 Then
'		taEditor.Text = ""
'	End If	
'End Sub
'
'Private Sub taTerminal_MouseClicked (EventData As MouseEvent)
'	If EventData.ClickCount = 2 Then
'		taTerminal.Text = ""
'	End If
'End Sub

Private Sub cbCommands_ValueChanged (Value As Object)
	If Value.As(String).Length = 0 Then Return
	' Log($"[cbCommands_ValueChanged] ${Value}"$)
	ProcessInput
End Sub

' No action because handled by processinput
Private Sub cbCommands_SelectedIndexChanged(Index As Int, Value As Object)
	' Log($"[cbCommands_SelectedIndexChanged] ${Value}"$)
End Sub

Private Sub AddCommandToHistory(Command As String)

    Dim Items As List = cbCommands.Items

    ' Avoid consecutive duplicates
    If Items.Size > 0 Then
        If Items.Get(Items.Size - 1) = Command Then Return
    End If

    Items.Add(Command)

    ' Limit history to 50 commands
    Do While Items.Size > 50
        Items.RemoveAt(0)
    Loop

End Sub
#End Region

' ----------------------------------------------------------------
' PROCESSING
' ----------------------------------------------------------------
#Region Processing
Private Sub ProcessCommand(Command As String)
	Dim UpperCommand As String = Command.Trim.ToUpperCase

	Select Case True
		Case UpperCommand = "HELP"
			ShowHelp

		Case UpperCommand = "HINTS"
			ShowHints
			
		Case UpperCommand = "SAVE" Or UpperCommand.StartsWith("SAVE ")
			SaveProgram(Command.SubString(4).Trim, CurrentFilePath)

		Case UpperCommand = "LOAD" Or UpperCommand.StartsWith("LOAD ")
			Wait For (ConfirmDiscardChanges) Complete (Confirmed As Boolean)
			If Confirmed = False Then Return
			LoadProgram(Command.SubString(4).Trim)

		Case UpperCommand = "CLS"
			taTerminal.Text = ""

		Case UpperCommand = "NEW"
			NewProgram

		Case UpperCommand = "RUN"
			LoadEditorProgram
			PrepareRun
			Interpreter.RunProgram

		Case UpperCommand = "BYE"
			Serial.Disconnect
			B4XPages.GetNativeParent(Me).Close
			
		Case UpperCommand = "BASIC-58"
			ShowEasterEgg
		Case UpperCommand.StartsWith("@SYS")
			System.ExecuteCommand(Command.Substring(4).Trim)

		Case UpperCommand.StartsWith("@SER")
			Serial.ExecuteCommand(Command)

		Case UpperCommand.StartsWith("@")
			PrintText(taTerminal, "[BASIC-58][E] Unknown command.")
			
		Case Else
			If UpperCommand = "LIST" Or UpperCommand.StartsWith("LIST ") Or _
				UpperCommand = "RENUM" Or UpperCommand.StartsWith("RENUM ") Then
				LoadEditorProgram
			End If

			Interpreter.ExecuteCommand(Command)
	End Select
End Sub

Private Sub ProcessInput

	Dim Command As String = cbCommands.Value.As(String).Trim

	If Command = "" And Interpreter.IsWaitingForInput = False Then Return

	cbCommands.Value = ""

	If Interpreter.IsWaitingForInput Then
		Interpreter.SubmitInput(Command)
	Else
		AddCommandToHistory(Command)
		ProcessCommand(Command)
	End If

End Sub

Private Sub LoadEditorProgram
	Interpreter.LoadProgram(taEditor.Text)
End Sub

Private Sub PrepareRun
    If System.GetRunClear Then taTerminal.Text = ""
End Sub
#End Region

' ----------------------------------------------------------------
' FILE MANAGEMENT
' ----------------------------------------------------------------
#Region FileManagement
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
	Interpreter.ClearProgram
	taTerminal.Text = ""

	' Reset program information.
	CurrentFileName = "PROGRAM.BAS"
	ProgramModified = False
	UpdatePageTitle
	lblStatus.Text = "READY"
End Sub
        
Private Sub SaveProgram(FileName As String, FilePath As String) As Boolean
	Interpreter.LoadProgram(taEditor.Text)

	'Log("EDITOR TEXT: " & taEditor.Text)
	'Log("PROGRAM LINES: " & ProgramLines.Size)

	If Interpreter.GetProgramLineCount = 0 Then
		PrintText(taTerminal, "NO PROGRAM")
		Return False
	End If

	If FileName = "" Then
		FileName = "PROGRAM.BAS"
	End If

	If FileName.Contains("/") Or FileName.Contains("\") Then
		PrintText(taTerminal, "?INVALID FILE NAME")
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
		ProgramModified = False
		UpdatePageTitle

		PrintText(taTerminal, "SAVED: " & FileName)
		
		Return True
		
	Catch
		PrintText(taTerminal, "?SAVE ERROR")
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
		PrintText(taTerminal, $"?INVALID FILE NAME - ${FileName}"$)
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
		PrintText(taTerminal, "?FILE NOT FOUND: " & FileName)
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
		Dim LoadedText As String = Utils.ConvertBasicTextToUpper(EditorText.ToString)

		If taEditor.Text <> LoadedText Then
			LoadingProgram = True
			taEditor.Text = LoadedText
		Else
			LoadingProgram = False
		End If
		
		'Rebuild the interpreter program.
		Interpreter.LoadProgram(taEditor.Text)

		CurrentFileName = FileName.ToUpperCase
		ProgramModified = False
		UpdatePageTitle

		PrintText(taTerminal, "LOADED: " & CurrentFileName)
		PrintText(taTerminal, "LINES: " & Interpreter.GetProgramLineCount)
	Catch
		LoadingProgram = False
		PrintText(taTerminal, "?LOAD ERROR")
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
		'Log($"[Load] path=${CurrentFilePath}, file=${CurrentFileName}"$)
		LoadProgram(CurrentFileName)
	Catch
		Log("[Load][E] Failed - " & LastException.Message)
	End Try
	Return
End Sub

' Save Content TextArea To a TextFile
' Dim Str As String = "Hello World"
' StringToTextFile(MainForm, Str)
Private Sub Save
	Dim Filename As String
	Dim FileChoose As FileChooser
	FileChoose.Initialize
	FileChoose.InitialDirectory = CurrentFilePath
	FileChoose.InitialFileName = CurrentFileName
	FileChoose.SetExtensionFilter("BAS", Array As String("*.bas"))
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

Private Sub ConfirmDiscardChanges As ResumableSub
	' Log($"[ConfirmDiscardChanges] ProgramModified=${ProgramModified}"$)

	If ProgramModified = False Then Return True

	xui.Msgbox2Async("Discard unsaved changes?", "CONFIRM", _
        "Yes", "", "No", Null)
	Wait For Msgbox_Result (Result As Int)

	Return Result = xui.DialogResponse_Positive
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

	If Target.Tag = taTerminal.Tag Then
		Wait For (ScrollTextToBottom(taTerminal)) Complete (Success As Boolean)
	End If
End Sub

Private Sub UpdatePageTitle
	Dim PageTitle As String = $"${System.APPNAME} - ${CurrentFileName}"$

	If ProgramModified Then
		PageTitle = PageTitle & " *"
	End If

	B4XPages.SetTitle(Me, PageTitle)
End Sub
#End Region

' ----------------------------------------------------------------
' SERIAL COMMUNICATION
' ----------------------------------------------------------------
#Region B58Serial
Private Sub Serial_Connected
	PrintText(taTerminal, "[BASIC-58] Controller connected.")
	Sleep(2000) ' Allow Arduino UNO reset
	Interpreter.ResumeHardwareCommand
End Sub

Private Sub Serial_CommandCompleted(Frame() As Byte)
	PrintText(taTerminal, $"[BASIC-58] ACK received: ${bc.HexFromBytes(Frame)}"$)
	Interpreter.ResumeHardwareCommand
End Sub

Private Sub Serial_CommandError(Message As String)
	PrintText(taTerminal, "[BASIC-58][E] " & Message)
	Interpreter.ResumeHardwareCommand
End Sub

Private Sub Serial_Disconnected
	PrintText(taTerminal, "[BASIC-58] Controller disconnected.")
    Interpreter.ResumeHardwareCommand
    Interpreter.ExternalDataDisconnected
End Sub

Private Sub Serial_Error(Message As String)
	PrintText(taTerminal, "[BASIC-58][E] " & Message)
End Sub

Private Sub Serial_PortsFound(Ports As List)
	PrintText(taTerminal, "AVAILABLE SERIAL PORTS:")
	For Each Port As String In Ports
		PrintText(taTerminal, Port)
	Next
End Sub

Private Sub Serial_NoPortsFound
	PrintText(taTerminal, "NO SERIAL PORTS FOUND.")
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
' MESSAGES OUTPUT TERMINAL
' ----------------------------------------------------------------
#Region Messages
Private Sub ShowWelcomMessage
	taTerminal.Text = ""
	PrintText(taTerminal, "BASIC-58 - RETRO BASIC INTERPRETER")
	PrintText(taTerminal, "VERSION " & System.APPVERSION)
	PrintText(taTerminal, System.APPCOPYRIGHT)
	PrintText(taTerminal, "---------------------------")
	PrintText(taTerminal, "TYPE HELP FOR COMMANDS")
	PrintText(taTerminal, "READY.")
	Wait For (ScrollTextToTop(taTerminal)) Complete (Success As Boolean)
	lblStatus.Text = "READY"
End Sub

Private Sub ShowHelp
	taTerminal.Text = ""
	Interpreter.ExecuteHelp
	Sleep(50)
	ScrollTextToTop(taTerminal)
	lblStatus.Text = "HELP"
End Sub

Private Sub ShowHints
	taTerminal.Text = ""
	Interpreter.ExecuteHints
	Sleep(50)
	ScrollTextToTop(taTerminal)
	lblStatus.Text = "HINTS"
End Sub

Private Sub ShowEasterEgg
	taTerminal.Text = B58Help.EasterEggText
	Wait For (ScrollTextToTop(taTerminal)) Complete (Success As Boolean)
	lblStatus.Text = "ENJOY BASIC-58"
End Sub
#End Region

' ----------------------------------------------------------------
' UI HELPERS
' ----------------------------------------------------------------
#Region UIHelpers
Public Sub ScrollTextToBottom(Target As B4XView) As ResumableSub
	Dim NativeTextArea As JavaObject = Target
	NativeTextArea.RunMethod("setScrollTop", Array(100000.0))
	Return True
End Sub

Public Sub ScrollTextToTop(Target As B4XView) As ResumableSub
	Dim NativeTextArea As JavaObject = Target
	NativeTextArea.RunMethod("setScrollTop", Array(0.0))
	Return True
End Sub

Public Sub ComboBoxSetPromptText(box As ComboBox, text As String)
	Dim joCB As JavaObject = box
	joCB.RunMethod("setPromptText", Array(text))
End Sub
#End Region
