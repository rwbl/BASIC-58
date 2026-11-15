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
' ================================================================

#Region Shared Files
' #CustomBuildAction: folders ready, %WINDIR%\System32\Robocopy.exe,"..\..\Shared Files" "..\Files"
' Ctrl + click to sync files: ide://run?file=%WINDIR%\System32\Robocopy.exe&args=..\..\Shared+Files&args=..\Files&FilesSync=True
#End Region

#Macro: Title, Export B4XPages, ide://run?File=%B4X%\Zipper.jar&Args=%PROJECT_NAME%.zip

Sub Class_Globals
	' A tiny BASIC interpreter
	Private VERSION As String = "BASIC-58"
	'Private VERSION As String = "BASIC-58 v20261115 ALPHA"

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

	' Constants
	Private MAX_VAR_LENGTH As Int = 8

	Private ProgramLines As Map
	Private Variables As Map

	'Program execution state
	Private RunLines As List
	Private RunPosition As Int

	'INPUT handling
	Private WaitingForInput As Boolean
	Private InputVariables As List
	Private InputPrompt As String
	'Arithmetic expression parser
	Private ExprText As String
	Private ExprPos As Int
	Private ExprError As Boolean

	'FOR / NEXT handling
	Private ForStack As List

	'GOSUB / RETURN handling
	Private GosubStack As List

	'DATA / READ handling.
	Private DataItems As List
	Private DataPosition As Int

	' Files & Editor
	Private CurrentFileName As String
	Private CurrentFilePath As String
	Private ProgramModified As Boolean
	Private LoadingProgram As Boolean
	Private UpdatingEditor As Boolean
	
	'Error handling.
	Private ErrorHandlerLine As Int				'BASIC line number of the error handler
	Private ErrorHandlerEnabled As Boolean		'Indicates whether an error handler Is registered
	Private ErrorHandlerRunning As Boolean		'Prevents recursive error handling
	Private ErrorLinePosition As Int			'Position of the statement that caused the error
	Private ErrorNextPosition As Int			'Position of the following statement
	Private ErrorCode As Int					'5:Undefined line number,11:Division by zero,20:Syntax error,22:Next without For,23:Return without GOSUB
	Private ErrorLineNumber As Int				'Line number of the last error
	Private ExprErrorCode As Int				'0:No expression error,11:Division by zero,20:Other expression errors
	Private ReadErrorMessage As String
End Sub

Public Sub Initialize
'	B4XPages.GetManager.LogEvents = True
End Sub

'This event will be called once, before the page becomes visible.
Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	DesignerUtils.Initialize
	Root.LoadLayout("MainPage")
	
	' Log(GetSystemProperty("javafx.runtime.version", "unknown"))
	
	ProgramLines.Initialize
	RunLines.Initialize
	Variables.Initialize
	
	'Create BASIC58 data directory.
	CurrentFilePath = File.DirApp
	' File.Combine(File.DirApp, "BASIC58")
	' File.MakeDir(File.DirUserHome, "BASIC58")
	ProgramModified = False
	
	' UI
	' BASIC-58 - NUMBERGAME.BAS *
	UpdatePageTitle
	B4XPages.GetNativeParent(Me).Resizable = False
	lblStatus.Text = "READY"
		
	' For tests
	tfCommand.Text = "LOAD"
	tfCommand_Action
'	tfCommand.Text = "LIST"
'	tfCommand_Action
'	tfCommand.Text = "RUN"
'	tfCommand_Action
	
	InitializeUIStyle
	
	' Welcome Message
	' InitializeScreen
End Sub

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
	PrintText(taOutput, "")
	PrintText(taOutput, "BASIC INTERPRETER")
	PrintText(taOutput, "")
	PrintText(taOutput, "TYPE HELP FOR COMMANDS")
	PrintText(taOutput, "")
	PrintText(taOutput, "READY.")

	lblStatus.Text = "READY"
End Sub

Private Sub btnRun_Click
    ProcessInput
End Sub

Private Sub tfCommand_Action
    ProcessInput
End Sub

Private Sub ProcessInput
	Dim Command As String = tfCommand.Text.Trim

	If Command = "" Then Return

	' Log("INPUT: " & Command)

	tfCommand.Text = ""

	'If the BASIC program is waiting for INPUT,
	'treat the entered text as the variable value.
	If WaitingForInput Then

		'Allow the user to abort a running program.
		'Allow the user to abort a running program.
		If Command.ToUpperCase = "BREAK" Then
			WaitingForInput = False
			RunPosition = RunLines.Size
			InputVariables.Clear
			PrintText(taOutput, "BREAK")
			PrintText(taOutput, "READY.")
			tfCommand.RequestFocus
			Return
		End If
		
		'Display the entered input in the terminal.
		PrintText(taEditor, Command)
		
		Dim InputValues As List
		InputValues.Initialize

		Dim CurrentValue As StringBuilder
		CurrentValue.Initialize

		Dim InQuotes As Boolean = False

		'Split entered values at commas outside quotes.
		For i = 0 To Command.Length - 1
			Dim CurrentChar As String = Command.SubString2(i, i + 1)

			If CurrentChar = Chr(34) Then
				InQuotes = Not(InQuotes)
			End If

			If CurrentChar = "," And InQuotes = False Then
				InputValues.Add(CurrentValue.ToString.Trim)
				CurrentValue.Initialize
			Else
				CurrentValue.Append(CurrentChar)
			End If
		Next

		InputValues.Add(CurrentValue.ToString.Trim)

		'Validate input.
		Dim ValidInput As Boolean = True

		If InQuotes Or InputValues.Size <> InputVariables.Size Then
			ValidInput = False
		Else
			For i = 0 To InputVariables.Size - 1
				Dim VariableName As String = InputVariables.Get(i)
				Dim InputValue As String = InputValues.Get(i)

				If VariableName.EndsWith("$") Then
					If InputValue.StartsWith(Chr(34)) Or InputValue.EndsWith(Chr(34)) Then
						If InputValue.StartsWith(Chr(34)) And InputValue.EndsWith(Chr(34)) And InputValue.Length >= 2 Then
							InputValue = InputValue.SubString2(1, InputValue.Length - 1)
							InputValues.Set(i, InputValue)
						Else
							ValidInput = False
						End If
					End If
				Else
					If IsNumber(InputValue) = False Then
						ValidInput = False
					End If
				End If
			Next
		End If

		If ValidInput = False Then
			PrintText(taOutput, "?REDO FROM START")
			PrintText(taOutput, InputPrompt & "?")
			tfCommand.RequestFocus
			Return
		End If

		'Assign values to variables.
		For i = 0 To InputVariables.Size - 1
			Dim VariableName As String = InputVariables.Get(i)
			Dim InputValue As String = InputValues.Get(i)

			Variables.Put(VariableName, InputValue)
		Next

		WaitingForInput = False

		ContinueProgram

		tfCommand.RequestFocus
		Return
	End If
	
	ExecuteCommand(Command)

	tfCommand.RequestFocus
End Sub

Private Sub ExecuteCommand(Command As String)
	Command = Command.Trim

	If Command = "" Then Return

	Dim UpperCommand As String = Command.ToUpperCase

	'Check whether this is a numbered BASIC program line.
	Dim SpacePos As Int = Command.IndexOf(" ")

	If SpacePos > 0 Then
		Dim FirstToken As String = Command.SubString2(0, SpacePos)

		If IsNumber(FirstToken) Then
			Dim LineNumber As Int = FirstToken
			Dim LineCode As String = Command.SubString(SpacePos + 1).Trim

			If LineCode = "" Then
				ProgramLines.Remove(LineNumber)
			Else
				ProgramLines.Put(LineNumber, LineCode)
				PrintText(taOutput, "STORED: " & LineNumber & " = " & LineCode)
			End If

			Return
		End If
	End If

	' Load and Save
	If UpperCommand = "SAVE" Or UpperCommand.StartsWith("SAVE ") Then
		SaveProgram(Command.SubString(4).Trim)
		Return
	End If

	If UpperCommand = "LOAD" Or UpperCommand.StartsWith("LOAD ") Then
		LoadProgram(Command.SubString(4).Trim)
		Return
	End If

	' Other commands
	Select Case UpperCommand
		Case "CLS"
			taOutput.Text = ""

		Case "HELP"
			ExecuteHelp
			
		Case "LIST"
			ListProgram

		Case "RUN"
			RunProgram

		Case "NEW"
			If ProgramModified Then
				Dim sf As Object = xui.Msgbox2Async("Save program?", "Confirm", "Yes", "Cancel", "No", Null)
				Wait For (sf) Msgbox_Result (Result As Int)
				If Result = xui.DialogResponse_Positive Then
					Save
				End If
			End If
			ProgramLines.Clear
			Variables.Clear
			WaitingForInput = False
			taEditor.Text = ""
			CurrentFileName = "NEWPROGRAM.BAS"
			CurrentFilePath = File.DirApp
			PrintText(taOutput, "NEW PROGRAM")
			
		Case Else
			If UpperCommand.StartsWith("PRINT ") Then
				PrintBasicText(Command)
			Else
				PrintText(taOutput, "?SYNTAX ERROR")
			End If
	End Select

	lblStatus.Text = "READY"
End Sub

Private Sub ExecuteLet(LineCode As String) As Boolean
	ExprError = False
	ExprErrorCode = 0

	Dim EqualPos As Int = LineCode.IndexOf("=")

	If EqualPos < 0 Then Return False

	Dim VariableName As String = LineCode.SubString2(4, EqualPos).Trim.ToUpperCase
	Dim Expression As String = LineCode.SubString(EqualPos + 1).Trim

	If VariableName = "" Or Expression = "" Then Return False

	If VariableName.Length > MAX_VAR_LENGTH Then Return False

	Dim FirstChar As String = VariableName.SubString2(0, 1)

	If FirstChar.CompareTo("A") < 0 Or FirstChar.CompareTo("Z") > 0 Then Return False

	If VariableName.Length = MAX_VAR_LENGTH And VariableName.EndsWith("$") = False Then Return False

	'String variable.
	If VariableName.EndsWith("$") Then
		ExprErrorCode = 0
		Dim StringValue As String = EvaluateStringExpression(Expression)

		If ExprError Then
			If ExprErrorCode = 0 Then ExprErrorCode = 20
			Return False
		End If
		
		Variables.Put(VariableName, StringValue)
		Return True
	End If

	' Log("LET: Variable=" & VariableName & ", Expression=" & Expression)

	'Numeric expression.
	Dim Result As Double = EvaluateNumericExpression(Expression)
	If ExprError Then Return False

	' Log("LET: " & VariableName & " = " & NumberFormat(Result, 1, 6))	
	Variables.Put(VariableName, NumberFormat2(Result, 1, 0, 10, False))
	
	Return True
End Sub

Private Sub ExecuteRandomize(LineCode As String) As Boolean

	ExprError = False
	ExprErrorCode = 0

	Dim SeedExpression As String = LineCode.SubString(9).Trim

	'No seed supplied: use the current time.
	If SeedExpression = "" Then
		RndSeed(DateTime.Now)
		Return True
	End If

	'Evaluate the supplied seed.
	Dim SeedValue As Double = EvaluateNumericExpression(SeedExpression)

	If ExprError Then Return False

	Dim Seed As Long = SeedValue

	RndSeed(Seed)

	Return True

End Sub

Private Sub ExecuteRead(LineCode As String) As Boolean

	ReadErrorMessage = "ILLEGAL READ"

	Dim VariableList As String = LineCode.SubString(4).Trim

	If VariableList = "" Then Return False

	'Split the variable list.
	Dim ReadVariables As List
	ReadVariables.Initialize

	Dim CurrentVariable As StringBuilder
	CurrentVariable.Initialize

	For i = 0 To VariableList.Length - 1

		Dim CurrentChar As String = VariableList.CharAt(i)

		If CurrentChar = "," Then
			ReadVariables.Add(CurrentVariable.ToString.Trim)
			CurrentVariable.Initialize
		Else
			CurrentVariable.Append(CurrentChar)
		End If

	Next

	If CurrentVariable.Length > 0 Then
		ReadVariables.Add(CurrentVariable.ToString.Trim)
	End If

	If ReadVariables.Size = 0 Then Return False

	'Temporary storage. Nothing is assigned yet.
	Dim ReadNames As List
	ReadNames.Initialize

	Dim ReadValues As List
	ReadValues.Initialize

	Dim TempDataPosition As Int = DataPosition

	'Validate all variables and DATA values first.
	For Each VariableItem As String In ReadVariables

		Dim VariableName As String = VariableItem.ToUpperCase.Trim

		If IsValidReadVariable(VariableName) = False Then
			ReadErrorMessage = "ILLEGAL READ"
			Return False
		End If

		If TempDataPosition >= DataItems.Size Then
			ReadErrorMessage = "OUT OF DATA"
			Return False
		End If

		Dim DataValue As String = DataItems.Get(TempDataPosition).as(String).Trim

		Dim IsStringData As Boolean = DataValue.StartsWith("""") Or DataValue.EndsWith("""")

		If VariableName.EndsWith("$") Then

			If IsStringData = False Then
				ReadErrorMessage = "TYPE MISMATCH"
				Return False
			End If

			If DataValue.StartsWith("""") = False Or DataValue.EndsWith("""") = False Then
				ReadErrorMessage = "TYPE MISMATCH"
				Return False
			End If

			DataValue = DataValue.SubString2(1, DataValue.Length - 1)

			ReadNames.Add(VariableName)
			ReadValues.Add(DataValue)

		Else

			If IsStringData Then
				ReadErrorMessage = "TYPE MISMATCH"
				Return False
			End If

			Dim NumberValue As Double

			Try
				NumberValue = DataValue
			Catch
				ReadErrorMessage = "TYPE MISMATCH"
				Return False
			End Try

			ReadNames.Add(VariableName)
			ReadValues.Add(NumberValue)

		End If

		TempDataPosition = TempDataPosition + 1

	Next

	'Everything is valid. Commit the assignments.
	For i = 0 To ReadNames.Size - 1
		Variables.Put(ReadNames.Get(i), ReadValues.Get(i))
	Next

	DataPosition = TempDataPosition

	Return True

End Sub

Private Sub IsValidReadVariable(VariableName As String) As Boolean

	If VariableName = "" Then Return False

	Dim NamePart As String = VariableName

	If VariableName.EndsWith("$") Then
		NamePart = VariableName.SubString2(0, VariableName.Length - 1)
	End If

	If NamePart.Length = 0 Or NamePart.Length > MAX_VAR_LENGTH Then Return False

	Dim AllowedChars As String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

	For i = 0 To NamePart.Length - 1

		Dim CurrentChar As String = NamePart.CharAt(i)

		If AllowedChars.IndexOf(CurrentChar) = -1 Then Return False

		If i = 0 And "ABCDEFGHIJKLMNOPQRSTUVWXYZ".IndexOf(CurrentChar) = -1 Then
			Return False
		End If

	Next

	Return True

End Sub

Private Sub ExecuteRestore(LineCode As String) As Boolean

	If LineCode.Trim.ToUpperCase <> "RESTORE" Then Return False

	DataPosition = 0

	Return True

End Sub

Private Sub CollectData

	DataItems.Initialize
	DataPosition = 0

	For Each LineNumber As Int In RunLines

		Dim LineCode As String = ProgramLines.Get(LineNumber).As(String).Trim
		Dim UpperLine As String = LineCode.ToUpperCase

		If UpperLine = "DATA" Or UpperLine.StartsWith("DATA ") Then

			Dim DataText As String = LineCode.SubString(4).Trim

			If DataText = "" Then Continue

			Dim InQuotes As Boolean = False
			Dim CurrentItem As StringBuilder
			CurrentItem.Initialize

			For i = 0 To DataText.Length - 1

				Dim CurrentChar As String = DataText.CharAt(i)

				If CurrentChar = """" Then
					InQuotes = Not(InQuotes)
					CurrentItem.Append(CurrentChar)

				Else If CurrentChar = "," And InQuotes = False Then
					DataItems.Add(CurrentItem.ToString.Trim)
					CurrentItem.Initialize

				Else
					CurrentItem.Append(CurrentChar)
				End If

			Next

			If CurrentItem.Length > 0 Then
				DataItems.Add(CurrentItem.ToString.Trim)
			End If

		End If

	Next
'	PrintText("DATA ITEMS: " & DataItems.Size)
'	For Each Item As String In DataItems
'		PrintText("[" & Item & "]")
'	Next
End Sub

Private Sub RunProgram
	UpdateProgramLines
	
	If ProgramLines.Size = 0 Then
		PrintText(taOutput, "NO PROGRAM")
		Return
	End If

	Variables.Clear
	WaitingForInput = False

	PrintText(taOutput, "")
	PrintText(taOutput, "RUNNING...")
	PrintText(taOutput, "")

	'Get program line numbers in numerical order.
	RunLines.Initialize

	For Each Key As Object In ProgramLines.Keys
		RunLines.Add(Key)
	Next

	RunLines.Sort(True)
	
	CollectData

	RunPosition = 0

	If ForStack.IsInitialized = False Then
		ForStack.Initialize
	Else
		ForStack.Clear
	End If
	
	If GosubStack.IsInitialized = False Then
		GosubStack.Initialize
	Else
		GosubStack.Clear
	End If

	ResetErrorHandler
	ContinueProgram
End Sub

Private Sub ContinueProgram

	Do While RunPosition < RunLines.Size

		Dim LineNumber As Int = RunLines.Get(RunPosition)
		RunPosition = RunPosition + 1

		Dim LineCode As String = ProgramLines.Get(LineNumber)
		Dim UpperLine As String = LineCode.ToUpperCase.Trim

		Select Case True

			Case UpperLine = "END"
				RunPosition = RunLines.Size

			Case UpperLine = "REM" Or UpperLine.StartsWith("REM ")
				'Comment.

			Case UpperLine = "READ" Or UpperLine.StartsWith("READ ")

				If ExecuteRead(LineCode) = False Then

					If HandleProgramError("?" & ReadErrorMessage & " IN LINE " & LineNumber) Then Continue

					Exit
				End If
				
			Case UpperLine = "RESTORE"

				If ExecuteRestore(LineCode) = False Then
					If HandleProgramError("?SYNTAX ERROR IN LINE " & LineNumber) Then Continue
					Exit
				End If
				
			Case UpperLine = "DATA" Or UpperLine.StartsWith("DATA ")
				'DATA statements are processed by CollectData.
				'Nothing to execute here.

			Case UpperLine = "RANDOMIZE" Or UpperLine.StartsWith("RANDOMIZE ")

				If ExecuteRandomize(LineCode) = False Then

					If ExprError Then
						If ExprErrorCode = 11 Then
							If HandleProgramError("?DIVISION BY ZERO IN LINE " & LineNumber) Then Continue
						Else
							If HandleProgramError("?ILLEGAL EXPRESSION IN LINE " & LineNumber) Then Continue
						End If
					Else
						If HandleProgramError("?SYNTAX ERROR IN LINE " & LineNumber) Then Continue
					End If

					Exit
				End If

			Case UpperLine.StartsWith("ON ERROR ")
				If ExecuteOnError(LineCode) = False Then
					If HandleProgramError("?SYNTAX ERROR IN LINE " & LineNumber) Then Continue
					Exit
				End If

			Case UpperLine = "RESUME" Or UpperLine = "RESUME NEXT"
				If ExecuteResume(LineCode) = False Then
					If HandleProgramError("?RESUME WITHOUT ERROR IN LINE " & LineNumber) Then Continue
					Exit
				End If

			Case UpperLine.StartsWith("ON ")
				If ExecuteOn(LineCode) = False Then

					If ExprError Then
						If ExprErrorCode = 11 Then
							If HandleProgramError("?DIVISION BY ZERO IN LINE " & LineNumber) Then Continue
						Else
							If HandleProgramError("?ILLEGAL EXPRESSION IN LINE " & LineNumber) Then Continue
						End If
					Else
						If HandleProgramError("?SYNTAX ERROR IN LINE " & LineNumber) Then Continue
					End If

					Exit
				End If
				
			Case UpperLine.StartsWith("GOSUB ")
				Dim TargetText As String = LineCode.SubString(6).Trim

				If IsNumber(TargetText) = False Then
					If HandleProgramError("?SYNTAX ERROR IN LINE " & LineNumber) Then Continue
					Exit
				End If

				Dim TargetLine As Int = TargetText

				GosubStack.Add(RunPosition)

				If JumpToLine(TargetLine) = False Then
					GosubStack.RemoveAt(GosubStack.Size - 1)

					If HandleProgramError("?UNDEFINED LINE " & TargetLine) Then Continue
					Exit
				End If

			Case UpperLine.StartsWith("GOTO ")
				Dim TargetText As String = LineCode.SubString(5).Trim

				If IsNumber(TargetText) = False Then
					If HandleProgramError("?SYNTAX ERROR IN LINE " & LineNumber) Then Continue
					Exit
				End If

				Dim TargetLine As Int = TargetText

				If JumpToLine(TargetLine) = False Then
					If HandleProgramError("?UNDEFINED LINE " & TargetLine) Then Continue
					Exit
				End If

			Case UpperLine.StartsWith("IF ")
				Dim ThenPos As Int = UpperLine.IndexOf("THEN")

				If ThenPos < 0 Then
					If HandleProgramError("?SYNTAX ERROR IN LINE " & LineNumber) Then Continue
					Exit
				End If

				Dim Condition As String = LineCode.SubString2(3, ThenPos).Trim
				Dim TargetText As String = LineCode.SubString(ThenPos + 4).Trim

				If IsNumber(TargetText) = False Then
					If HandleProgramError("?SYNTAX ERROR IN LINE " & LineNumber) Then Continue
					Exit
				End If

				Dim ConditionResult As Boolean = EvaluateCondition(Condition)

				If ExprError Then
					If ExprErrorCode = 11 Then
						If HandleProgramError("?DIVISION BY ZERO IN LINE " & LineNumber) Then Continue
					Else
						If HandleProgramError("?ILLEGAL EXPRESSION IN LINE " & LineNumber) Then Continue
					End If
					Exit
				End If

				If ConditionResult Then
					Dim TargetLine As Int = TargetText

					If JumpToLine(TargetLine) = False Then
						If HandleProgramError("?UNDEFINED LINE " & TargetLine) Then Continue
						Exit
					End If
				End If
				
			Case UpperLine = "PRINT" Or UpperLine.StartsWith("PRINT ")
				If PrintBasicText(LineCode) = False Then
					If ExprErrorCode = 11 Then
						If HandleProgramError("?DIVISION BY ZERO IN LINE " & LineNumber) Then Continue
					Else
						If HandleProgramError("?ILLEGAL EXPRESSION IN LINE " & LineNumber) Then Continue
					End If
					Exit
				End If			
				
			Case UpperLine.StartsWith("INPUT ")
				If ExecuteInput(LineCode) = False Then
					If HandleProgramError("?SYNTAX ERROR IN LINE " & LineNumber) Then Continue
					Exit
				End If

				WaitingForInput = True
				Return

			Case UpperLine.StartsWith("LET ")
				If ExecuteLet(LineCode) = False Then

					If ExprError Then
						If ExprErrorCode = 11 Then
							If HandleProgramError("?DIVISION BY ZERO IN LINE " & LineNumber) Then Continue
						Else
							If HandleProgramError("?ILLEGAL EXPRESSION IN LINE " & LineNumber) Then Continue
						End If
					Else
						If HandleProgramError("?SYNTAX ERROR IN LINE " & LineNumber) Then Continue
					End If
					Exit
				End If
				
			Case UpperLine.StartsWith("FOR ")
				If ExecuteFor(LineCode, RunPosition) = False Then

					If ExprError Then
						If ExprErrorCode = 11 Then
							If HandleProgramError("?DIVISION BY ZERO IN LINE " & LineNumber) Then Continue
						Else
							If HandleProgramError("?ILLEGAL EXPRESSION IN LINE " & LineNumber) Then Continue
						End If
					Else
						If HandleProgramError("?SYNTAX ERROR IN LINE " & LineNumber) Then Continue
					End If

					Exit
				End If
				
			Case UpperLine = "NEXT" Or UpperLine.StartsWith("NEXT ")
				If ExecuteNext(LineCode) = False Then
					If HandleProgramError("?NEXT WITHOUT FOR IN LINE " & LineNumber) Then Continue
					Exit
				End If

			Case UpperLine = "RETURN"
				If GosubStack.Size = 0 Then
					If HandleProgramError("?RETURN WITHOUT GOSUB IN LINE " & LineNumber) Then Continue
					Exit
				End If

				RunPosition = GosubStack.Get(GosubStack.Size - 1)
				GosubStack.RemoveAt(GosubStack.Size - 1)

			Case Else
				If HandleProgramError("?SYNTAX ERROR IN LINE " & LineNumber) Then Continue
				Exit

		End Select

	Loop

	WaitingForInput = False
	PrintText(taOutput, "")
	PrintText(taOutput, "READY.")
End Sub

Private Sub PrintBasicText(LineCode As String) As Boolean
	'Empty PRINT statement produces a blank line.
	If LineCode.Trim.ToUpperCase = "PRINT" Then
		PrintText(taOutput, "")
		Return True
	End If

	Dim Value As String = LineCode.SubString(6).Trim
	Dim Items As List
	Items.Initialize

	Dim CurrentItem As StringBuilder
	CurrentItem.Initialize

	Dim InQuotes As Boolean = False
	Dim BracketLevel As Int = 0
	Dim LastSeparator As String = ""

	'Split PRINT arguments.
	For i = 0 To Value.Length - 1
		Dim CurrentChar As String = Value.SubString2(i, i + 1)

		If CurrentChar = Chr(34) Then
			InQuotes = Not(InQuotes)
		Else If InQuotes = False Then
			If CurrentChar = "(" Then BracketLevel = BracketLevel + 1
			If CurrentChar = ")" Then BracketLevel = BracketLevel - 1

			If (CurrentChar = ";" Or CurrentChar = ",") And BracketLevel = 0 Then
				Items.Add(CurrentItem.ToString.Trim)
				Items.Add(CurrentChar)
				CurrentItem.Initialize
				LastSeparator = CurrentChar
				Continue
			End If
		End If

		CurrentItem.Append(CurrentChar)
		LastSeparator = ""
	Next

	If CurrentItem.Length > 0 Then Items.Add(CurrentItem.ToString.Trim)

	'Print arguments.
	Dim Output As String = ""
	Dim Column As Int = 0

	For Each Item As String In Items
		If Item = ";" Then
			Continue

		Else If Item = "," Then
			Dim Spaces As Int = 14 - (Column Mod 14)
			Output = Output & SpaceString(Spaces)
			Column = Column + Spaces

		Else If Item.ToUpperCase.StartsWith("TAB(") And Item.EndsWith(")") Then
			Dim Argument As String = Item.SubString2(4, Item.Length - 1)
			Dim TargetColumn As Double = EvaluateNumericExpression(Argument)

			If ExprError Then Return False

			If TargetColumn < 1 Then
				ExprError = True
				ExprErrorCode = 20
				Return False
			End If

			Dim Spaces As Int = TargetColumn - 1 - Column
			If Spaces > 0 Then Output = Output & SpaceString(Spaces)
			If Spaces > 0 Then Column = Column + Spaces

		Else If Item.ToUpperCase.StartsWith("SPC(") And Item.EndsWith(")") Then
			Dim Argument As String = Item.SubString2(4, Item.Length - 1)
			Dim SpaceCount As Double = EvaluateNumericExpression(Argument)

			If ExprError Then Return False

			If SpaceCount < 0 Then
				ExprError = True
				ExprErrorCode = 20
				Return False
			End If

			Dim Spaces As Int = SpaceCount
			Output = Output & SpaceString(Spaces)
			Column = Column + Spaces

		Else
			Dim ItemValue As String = EvaluatePrintItem(Item)

			If ExprError Then
				If ExprErrorCode = 0 Then ExprErrorCode = 20
				Return False
			End If

			Output = Output & ItemValue
			Column = Column + ItemValue.Length
		End If
	Next

	'Print result.
	If LastSeparator = ";" Or LastSeparator = "," Then
		taOutput.Text = taEditor.Text & Output
		taOutput.SetSelection(taEditor.Text.Length, 0)
	Else
		PrintText(taOutput, Output)
	End If
	
	Return True
End Sub

Private Sub EvaluatePrintItem(Item As String) As String
	ExprError = False
	ExprErrorCode = 0

	If Item = "" Then Return ""

	If IsStringExpressionForPrint(Item) Then
		Dim StringResult As String = EvaluateStringExpression(Item)
		If ExprError Then Return "?ILLEGAL STRING EXPRESSION"
		Return StringResult
	End If

	Dim NumericResult As Double = EvaluateNumericExpression(Item)
	If ExprError Then Return "?ILLEGAL EXPRESSION"
	Return FormatNumber(NumericResult)
End Sub

Private Sub PrintText(Target As B4XView, Value As String)
	Dim NativeTextArea As JavaObject = Target
	NativeTextArea.RunMethod("appendText", Array(Value & CRLF))
	NativeTextArea.RunMethod("positionCaret", Array(NativeTextArea.RunMethod("getLength", Null)))

	If Target.Tag = taOutput.Tag Then
		Wait For (ScrollTextToBottom(taOutput)) Complete (Success As Boolean)		
	End If
End Sub
        
Private Sub ListProgram
	If ProgramLines.Size = 0 Then
		PrintText(taOutput, "NO PROGRAM")
		Return
	End If

	'Copy Map keys into a List.
	Dim LineNumbers As List
	LineNumbers.Initialize

	For Each Key As Object In ProgramLines.Keys
		LineNumbers.Add(Key)
	Next

	'Sort line numbers numerically.
	LineNumbers.Sort(True)

	'Display the BASIC program.
	For Each LineNumber As Int In LineNumbers
		Dim LineCode As String = ProgramLines.Get(LineNumber)
		PrintText(taOutput, LineNumber & " " & LineCode)
	Next
	
	Wait For (ScrollTextToBottom(taOutput)) Complete (Success As Boolean)
End Sub

Private Sub SaveProgram(FileName As String) As Boolean
	UpdateProgramLines

	'Log("EDITOR TEXT: " & taEditor.Text)
	'Log("PROGRAM LINES: " & ProgramLines.Size)

	If ProgramLines.Size = 0 Then
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

	If FileName.Contains(".") = False Then
		FileName = FileName & ".bas"
	End If

	FileName = FileName.ToUpperCase

	Try
		Dim SavedLines As List
		SavedLines.Initialize

		Dim EditorLines() As String = Regex.Split(CRLF, taEditor.Text)

		For Each EditorLine As String In EditorLines
			SavedLines.Add(EditorLine)
		Next

		File.WriteList(CurrentFilePath, FileName, SavedLines)

		'Log("[SaveProgram] Exists: " & File.Exists(CurrentFilePath, FileName))
		'Log("[SaveProgram] Size: " & File.Size(CurrentFilePath, FileName))
		
		CurrentFileName = FileName
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

	If FileName.Contains(".") = False Then
		FileName = FileName & ".bas"
	End If

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

		taEditor.Text = EditorText.ToString

		'Rebuild the interpreter program.
		UpdateProgramLines

		lblFile.Text = FileName

		PrintText(taOutput, "LOADED: " & FileName)
		PrintText(taOutput, "LINES: " & ProgramLines.Size)

	Catch
		PrintText(taOutput, "?LOAD ERROR")
		'Log($"[LoadProgram][E] ${LastException}"$)
	End Try
End Sub

Private Sub JumpToLine(TargetLine As Int) As Boolean
	Dim Position As Int = FindRunPosition(TargetLine)

	If Position < 0 Then Return False

	RunPosition = Position
	Return True
End Sub

Private Sub EvaluateCondition(Condition As String) As Boolean
	ExprError = False
	ExprErrorCode = 0

	Dim Operators As List = Array As String("<=", ">=", "<>", "=", "<", ">")

	Dim OperatorFound As String = ""
	Dim OperatorPos As Int = -1

	'Find the comparison operator.
	For Each Op As String In Operators
		OperatorPos = Condition.IndexOf(Op)

		If OperatorPos >= 0 Then
			OperatorFound = Op
			Exit
		End If
	Next

	If OperatorPos < 0 Then
		ExprError = True
		ExprErrorCode = 20
		Return False
	End If

	Dim LeftExpression As String = Condition.SubString2(0, OperatorPos).Trim
	Dim RightExpression As String = Condition.SubString(OperatorPos + OperatorFound.Length).Trim

	If LeftExpression = "" Or RightExpression = "" Then
		ExprError = True
		ExprErrorCode = 20
		Return False
	End If

	'String comparison.
	If IsStringExpression(LeftExpression) Or IsStringExpression(RightExpression) Then
		Dim LeftValue As String = GetBasicValue(LeftExpression)
		Dim RightValue As String = GetBasicValue(RightExpression)

		Select Case OperatorFound
			Case "="
				Return LeftValue = RightValue
			Case "<>"
				Return LeftValue <> RightValue
			Case Else
				ExprError = True
				ExprErrorCode = 20
				Return False
		End Select
	End If

	'Numeric comparison.
	Dim A As Double = EvaluateNumericExpression(LeftExpression)

	If ExprError Then Return False

	Dim B As Double = EvaluateNumericExpression(RightExpression)

	If ExprError Then Return False

	Select Case OperatorFound
		Case "="
			Return A = B
		Case "<>"
			Return A <> B
		Case "<"
			Return A < B
		Case ">"
			Return A > B
		Case "<="
			Return A <= B
		Case ">="
			Return A >= B
	End Select

	ExprError = True
	ExprErrorCode = 20
	Return False
End Sub

Private Sub GetBasicValue(Expression As String) As String
	Expression = Expression.Trim

	Dim QUOTES As String = Chr(34)

	'String literal.
	If Expression.StartsWith(QUOTES) And Expression.EndsWith(QUOTES) And Expression.Length >= 2 Then
		Return Expression.SubString2(1, Expression.Length - 1)
	End If

	'Variable.
	Dim VariableName As String = Expression.ToUpperCase

	If Variables.ContainsKey(VariableName) Then
		Return Variables.Get(VariableName)
	End If

	'Numeric literal or other value.
	Return Expression
End Sub

Private Sub ParseExpression As Double
	Dim Result As Double = ParseTerm

	Do While ExprPos < ExprText.Length And ExprError = False
		SkipSpaces

		If ExprPos >= ExprText.Length Then Exit

		Dim Op As String = ExprText.SubString2(ExprPos, ExprPos + 1)

		If Op = "+" Or Op = "-" Then
			ExprPos = ExprPos + 1

			Dim Value As Double = ParseTerm

			If Op = "+" Then
				Result = Result + Value
			Else
				Result = Result - Value
			End If
		Else
			Exit
		End If
	Loop

	Return Result
End Sub

Private Sub ParseTerm As Double
	Dim Result As Double = ParseFactor

	Do While ExprPos < ExprText.Length And ExprError = False
		SkipSpaces

		If ExprPos >= ExprText.Length Then Exit

		Dim Op As String = ExprText.SubString2(ExprPos, ExprPos + 1)

		If Op = "*" Or Op = "/" Then
			ExprPos = ExprPos + 1

			Dim Value As Double = ParseFactor

			If ExprError Then Return 0

			If Op = "*" Then
				Result = Result * Value
			Else
				If Value = 0 Then
					ExprError = True
					ExprErrorCode = 11
					Return 0
				End If
				Result = Result / Value
			End If
		Else
			Exit
		End If
	Loop

	Return Result
End Sub


Private Sub ParseFactor As Double
	SkipSpaces

	If ExprPos >= ExprText.Length Then
		ExprError = True
		Return 0
	End If

	Dim Ch As String = ExprText.SubString2(ExprPos, ExprPos + 1)

	'Unary minus.
	If Ch = "-" Then
		ExprPos = ExprPos + 1
		Return -ParseFactor
	End If

	'Unary plus.
	If Ch = "+" Then
		ExprPos = ExprPos + 1
		Return ParseFactor
	End If

	'Parenthesized expression.
	If Ch = "(" Then
		ExprPos = ExprPos + 1

		Dim Result As Double = ParseExpression

		SkipSpaces

		If ExprPos >= ExprText.Length Then
			ExprError = True
			Return 0
		End If

		If ExprText.SubString2(ExprPos, ExprPos + 1) <> ")" Then
			ExprError = True
			Return 0
		End If

		ExprPos = ExprPos + 1
		Return Result
	End If

	'Read a number.
	Dim StartPos As Int = ExprPos

	Do While ExprPos < ExprText.Length
		Ch = ExprText.SubString2(ExprPos, ExprPos + 1)

		If (Ch.CompareTo("0") >= 0 And Ch.CompareTo("9") <= 0) Or Ch = "." Then
			ExprPos = ExprPos + 1
		Else
			Exit
		End If
	Loop

	If ExprPos > StartPos Then
		Dim NumberText As String = ExprText.SubString2(StartPos, ExprPos)

		If IsNumber(NumberText) Then Return NumberText

		ExprError = True
		Return 0
	End If

	'Read a variable or function name.
	Do While ExprPos < ExprText.Length
		Ch = ExprText.SubString2(ExprPos, ExprPos + 1)

		If (Ch.CompareTo("A") >= 0 And Ch.CompareTo("Z") <= 0) Or _
			(Ch.CompareTo("a") >= 0 And Ch.CompareTo("z") <= 0) Or Ch = "$" Then
			ExprPos = ExprPos + 1
		Else
			Exit
		End If
	Loop

	If ExprPos = StartPos Then
		ExprError = True
		Return 0
	End If

	Dim Name As String = ExprText.SubString2(StartPos, ExprPos).ToUpperCase

	SkipSpaces

	If ExprPos < ExprText.Length Then
		'Log("NEXT CHAR: " & ExprText.SubString2(ExprPos, ExprPos + 1))
	End If

	'Function.
	If ExprPos < ExprText.Length Then
		If ExprText.SubString2(ExprPos, ExprPos + 1) = "(" Then

			ExprPos = ExprPos + 1

			'INSTR: Search for a substring.
			If Name = "INSTR" Then
				Dim SearchText As String = ReadStringFunctionArgument

				If ExprError Then Return 0

				SkipSpaces

				If ExprPos >= ExprText.Length Or _
					ExprText.SubString2(ExprPos, ExprPos + 1) <> "," Then
					ExprError = True
					Return 0
				End If

				ExprPos = ExprPos + 1

				Dim SearchFor As String = ReadStringFunctionArgument

				If ExprError Then Return 0

				SkipSpaces

				If ExprPos >= ExprText.Length Or _
					ExprText.SubString2(ExprPos, ExprPos + 1) <> ")" Then
					ExprError = True
					Return 0
				End If

				ExprPos = ExprPos + 1

				Dim FoundPosition As Int = SearchText.IndexOf(SearchFor)

				If FoundPosition < 0 Then Return 0

				Return FoundPosition + 1
			End If

			'LEN, VAL and ASC: Evaluate a complete string expression.
			If Name = "LEN" Or Name = "VAL" Or Name = "ASC" Then

				Dim StringArgumentStart As Int = ExprPos
				Dim StringArgumentEnd As Int = -1
				Dim StringBracketLevel As Int = 0
				Dim StringInQuotes As Boolean = False

				'Find the closing bracket of the function.
				Do While ExprPos < ExprText.Length
					Dim ScanChar As String = ExprText.SubString2(ExprPos, ExprPos + 1)

					If ScanChar = Chr(34) Then
						StringInQuotes = Not(StringInQuotes)

					Else If StringInQuotes = False Then
						If ScanChar = "(" Then
							StringBracketLevel = StringBracketLevel + 1

						Else If ScanChar = ")" Then
							If StringBracketLevel = 0 Then
								StringArgumentEnd = ExprPos
								Exit
							Else
								StringBracketLevel = StringBracketLevel - 1
							End If
						End If
					End If

					ExprPos = ExprPos + 1
				Loop

				If StringArgumentEnd < 0 Or StringInQuotes Then
					ExprError = True
					Return 0
				End If

				Dim StringExpressionText As String = _
					ExprText.SubString2(StringArgumentStart, StringArgumentEnd)

				'Move past the closing bracket.
				ExprPos = StringArgumentEnd + 1

				'Evaluate the string expression.
				Dim StringFunctionValue As String = _
					EvaluateStringExpression(StringExpressionText)

				If ExprError Then Return 0

				If Name = "LEN" Then
					Return StringFunctionValue.Length

				Else If Name = "ASC" Then
					If StringFunctionValue.Length = 0 Then
						ExprError = True
						Return 0
					End If

					Return Asc(StringFunctionValue)

				Else
					'VAL: Convert string to number.
					If IsNumber(StringFunctionValue) = False Then
						ExprError = True
						Return 0
					End If

					Return StringFunctionValue
				End If
			End If

			'Mathematical function.
			Dim Argument As Double = ParseExpression

			SkipSpaces

			If ExprError Or ExprPos >= ExprText.Length Then
				ExprError = True
				Return 0
			End If

			If ExprText.SubString2(ExprPos, ExprPos + 1) <> ")" Then
				ExprError = True
				Return 0
			End If

			ExprPos = ExprPos + 1

			Select Case Name
				Case "SQR"
					If Argument < 0 Then
						ExprError = True
						Return 0
					End If
					Return Sqrt(Argument)

				Case "ABS"
					Return Abs(Argument)

				Case "INT"
					Return Floor(Argument)

				Case "SIN"
					Return Sin(Argument * cPI / 180)

				Case "COS"
					Return Cos(Argument * cPI / 180)

				Case "TAN"
					Return Tan(Argument * cPI / 180)

				Case "LOG"
					If Argument <= 0 Then
						ExprError = True
						Return 0
					End If
					Return Logarithm(Argument, cE)

				Case "EXP"
					Return Power(cE, Argument)

				Case "SGN"
					If Argument < 0 Then Return -1
					If Argument > 0 Then Return 1
					Return 0

				Case "RND"
					Return Rnd(0, 1000000) / 1000000

				Case Else
					ExprError = True
					Return 0
			End Select
		End If
	End If

	'Predefined BASIC error variables.
	If Name = "ERR" Then Return ErrorCode
	If Name = "ERL" Then Return ErrorLineNumber

	'Ordinary variable.
	If Variables.ContainsKey(Name) = False Then
		ExprError = True
		Return 0
	End If

	Dim VariableValue As String = Variables.Get(Name)
	'Log("FACTOR: Variable=" & Name & ", Value=" & VariableValue)

	If IsNumber(VariableValue) = False Then
		Log("INVALID NUMBER: " & Name & " = [" & VariableValue & "]")
		ExprError = True
		Return 0
	End If
	
	If IsNumber(VariableValue) = False Then
		ExprError = True
		Return 0
	End If

	Return VariableValue
End Sub

Private Sub ReadStringFunctionArgument As String
	SkipSpaces

	If ExprPos >= ExprText.Length Then
		ExprError = True
		Return ""
	End If

	Dim CurrentChar As String = ExprText.SubString2(ExprPos, ExprPos + 1)

	'String literal.
	If CurrentChar = Chr(34) Then
		ExprPos = ExprPos + 1

		Dim StartString As Int = ExprPos

		Do While ExprPos < ExprText.Length
			CurrentChar = ExprText.SubString2(ExprPos, ExprPos + 1)

			If CurrentChar = Chr(34) Then Exit

			ExprPos = ExprPos + 1
		Loop

		If ExprPos >= ExprText.Length Then
			ExprError = True
			Return ""
		End If

		Dim StringValue As String = ExprText.SubString2(StartString, ExprPos)

		ExprPos = ExprPos + 1

		Return StringValue
	End If

	'String variable.
	Dim StartVariable As Int = ExprPos

	Do While ExprPos < ExprText.Length
		CurrentChar = ExprText.SubString2(ExprPos, ExprPos + 1)

		If (CurrentChar.CompareTo("A") >= 0 And CurrentChar.CompareTo("Z") <= 0) Or _
			(CurrentChar.CompareTo("a") >= 0 And CurrentChar.CompareTo("z") <= 0) Or _
			IsNumber(CurrentChar) Or CurrentChar = "$" Then

			ExprPos = ExprPos + 1
		Else
			Exit
		End If
	Loop

	Dim VariableName As String = ExprText.SubString2(StartVariable, ExprPos).ToUpperCase

	If VariableName.EndsWith("$") = False Or _
		Variables.ContainsKey(VariableName) = False Then

		ExprError = True
		Return ""
	End If

	Return Variables.Get(VariableName)
End Sub

Private Sub SkipSpaces
	Do While ExprPos < ExprText.Length
		If ExprText.SubString2(ExprPos, ExprPos + 1) = " " Then
			ExprPos = ExprPos + 1
		Else
			Exit
		End If
	Loop
End Sub

Private Sub EvaluateNumericExpression(Expression As String) As Double
	ExprText = Expression.ToUpperCase
	ExprPos = 0
	ExprError = False
	ExprErrorCode = 0

	Dim Result As Double = ParseExpression

	SkipSpaces

	If ExprPos <> ExprText.Length Then ExprError = True

	'Assign a general expression error if no specific code exists.
	If ExprError And ExprErrorCode = 0 Then
		ExprErrorCode = 20
	End If

	Return Result
End Sub

Private Sub IsStringExpression(Expression As String) As Boolean
	Expression = Expression.Trim

	If Expression.StartsWith(Chr(34)) Then Return True
	If Expression.EndsWith("$") Then Return True

	Return False
End Sub

Private Sub ExecuteFor(LineCode As String, BodyPosition As Int) As Boolean

	ExprError = False
	ExprErrorCode = 0

	Dim UpperLine As String = LineCode.ToUpperCase.Trim

	Dim EqualPos As Int = UpperLine.IndexOf("=")
	Dim ToPos As Int = UpperLine.IndexOf(" TO ")
	Dim StepPos As Int = UpperLine.IndexOf(" STEP ")

	If EqualPos < 0 Or ToPos < 0 Or ToPos < EqualPos Then Return False

	Dim VariableName As String = UpperLine.SubString2(4, EqualPos).Trim

	'FOR variables must be single letters.
	If VariableName.Length <> 1 Then Return False

	If VariableName.CompareTo("A") < 0 Or VariableName.CompareTo("Z") > 0 Then Return False

	Dim StartExpression As String = LineCode.SubString2(EqualPos + 1, ToPos).Trim

	Dim LimitExpression As String

	If StepPos >= 0 Then
		LimitExpression = LineCode.SubString2(ToPos + 4, StepPos).Trim
	Else
		LimitExpression = LineCode.SubString(ToPos + 4).Trim
	End If

	Dim StepExpression As String = "1"

	If StepPos >= 0 Then
		StepExpression = LineCode.SubString(StepPos + 6).Trim
	End If

	If StartExpression = "" Or LimitExpression = "" Or StepExpression = "" Then Return False

	'Evaluate start expression.
	Dim StartValue As Double = EvaluateNumericExpression(StartExpression)
	If ExprError Then Return False

	'Evaluate limit expression.
	Dim LimitValue As Double = EvaluateNumericExpression(LimitExpression)
	If ExprError Then Return False

	'Evaluate STEP expression.
	Dim StepValue As Double = EvaluateNumericExpression(StepExpression)
	If ExprError Then Return False

	'STEP cannot be zero.
	If StepValue = 0 Then
		ExprError = True
		ExprErrorCode = 20
		Return False
	End If

	Variables.Put(VariableName, NumberFormat2(StartValue, 1, 0, 10, False))
	
	'Check whether the loop should execute.
	If (StepValue > 0 And StartValue > LimitValue) Or _
		(StepValue < 0 And StartValue < LimitValue) Then

		Dim NextPosition As Int = FindNextPosition(VariableName)

		If NextPosition < 0 Then Return False

		RunPosition = NextPosition
		Return True
	End If

	Dim LoopData As Map
	LoopData.Initialize
	LoopData.Put("Variable", VariableName)
	LoopData.Put("Limit", LimitValue)
	LoopData.Put("Step", StepValue)
	LoopData.Put("BodyPosition", BodyPosition)

	ForStack.Add(LoopData)

	Return True

End Sub

Private Sub ExecuteNext(LineCode As String) As Boolean

	If ForStack.IsInitialized = False Or ForStack.Size = 0 Then Return False

	Dim LoopData As Map = ForStack.Get(ForStack.Size - 1)

	Dim VariableName As String = LoopData.Get("Variable")
	Dim NextVariable As String = LineCode.SubString(4).Trim.ToUpperCase

	If NextVariable <> "" And NextVariable <> VariableName Then Return False

	Dim CurrentValue As Double = Variables.Get(VariableName)
	Dim LimitValue As Double = LoopData.Get("Limit")
	Dim StepValue As Double = LoopData.Get("Step")

	CurrentValue = CurrentValue + StepValue

	Variables.Put(VariableName, NumberFormat2(CurrentValue, 1, 0, 10, False))
	
	Dim ContinueLoop As Boolean

	If StepValue > 0 Then
		ContinueLoop = CurrentValue <= LimitValue
	Else
		ContinueLoop = CurrentValue >= LimitValue
	End If

	If ContinueLoop Then
		RunPosition = LoopData.Get("BodyPosition")
	Else
		ForStack.RemoveAt(ForStack.Size - 1)
	End If

	Return True

End Sub

Private Sub FindNextPosition(VariableName As String) As Int

	Dim Nesting As Int = 0

	For i = RunPosition To RunLines.Size - 1

		Dim LineNumber As Int = RunLines.Get(i)
		Dim LineCode As String = ProgramLines.Get(LineNumber)
		Dim UpperLine As String = LineCode.ToUpperCase.Trim

		If UpperLine.StartsWith("FOR ") Then
			Nesting = Nesting + 1

		Else If UpperLine = "NEXT" Or UpperLine.StartsWith("NEXT ") Then

			If Nesting = 0 Then
				Dim NextVariable As String = UpperLine.SubString(4).Trim

				If NextVariable = "" Or NextVariable = VariableName Then
					Return i + 1
				End If
			Else
				Nesting = Nesting - 1
			End If

		End If

	Next

	Return -1

End Sub

Private Sub ExecuteOn(LineCode As String) As Boolean

	ExprError = False
	ExprErrorCode = 0

	Dim UpperLine As String = LineCode.ToUpperCase.Trim

	Dim GotoPos As Int = UpperLine.IndexOf(" GOTO ")
	Dim GosubPos As Int = UpperLine.IndexOf(" GOSUB ")

	Dim IsGosub As Boolean = False
	Dim OperatorPos As Int
	Dim OperatorLength As Int

	If GotoPos >= 0 Then
		OperatorPos = GotoPos
		OperatorLength = 6
	Else If GosubPos >= 0 Then
		OperatorPos = GosubPos
		OperatorLength = 7
		IsGosub = True
	Else
		Return False
	End If

	'Get selector expression.
	Dim Expression As String = LineCode.SubString2(3, OperatorPos).Trim

	Dim Selector As Double = EvaluateNumericExpression(Expression)

	If ExprError Then Return False

	'Get target line list.
	Dim TargetList As String = LineCode.SubString(OperatorPos + OperatorLength)
	Dim Targets() As String = Regex.Split(",", TargetList)

	If Targets.Length = 0 Then Return False

	'Validate all target line numbers.
	For Each Target As String In Targets
		Target = Target.Trim
		If IsNumber(Target) = False Then Return False
	Next

	'BASIC ON selection is 1-based.
	Dim Choice As Int = Selector

	If Choice < 1 Or Choice > Targets.Length Then Return True

	Dim TargetLine As Int = Targets(Choice - 1)

	If IsGosub Then
		'Remember the position of the next BASIC line.
		GosubStack.Add(RunPosition)
	End If

	If JumpToLine(TargetLine) = False Then
		If IsGosub Then
			GosubStack.RemoveAt(GosubStack.Size - 1)
		End If
		Return False
	End If

	Return True

End Sub

Private Sub ExecuteInput(LineCode As String) As Boolean
	Dim Value As String = LineCode.SubString(6).Trim
	Dim QUOTES As String = Chr(34)

	InputPrompt = ""

	'Optional prompt.
	If Value.StartsWith(QUOTES) Then
		Dim QuoteEnd As Int = -1

		For i = 1 To Value.Length - 1
			If Value.SubString2(i, i + 1) = QUOTES Then
				QuoteEnd = i
				Exit
			End If
		Next

		If QuoteEnd < 0 Then Return False

		InputPrompt = Value.SubString2(1, QuoteEnd)

		Value = Value.SubString(QuoteEnd + 1).Trim

		If Value.StartsWith(";") = False Then Return False

		Value = Value.SubString(1).Trim
	End If

	If Value = "" Then Return False

	'Extract variable names.
	InputVariables.Initialize

	Dim CurrentVariable As StringBuilder
	CurrentVariable.Initialize

	For i = 0 To Value.Length - 1
		Dim CurrentChar As String = Value.SubString2(i, i + 1)

		If CurrentChar = "," Then
			If AddInputVariable(CurrentVariable.ToString.Trim) = False Then Return False
			CurrentVariable.Initialize
		Else
			CurrentVariable.Append(CurrentChar)
		End If
	Next

	If AddInputVariable(CurrentVariable.ToString.Trim) = False Then Return False

	'Display prompt.
	PrintText(taOutput, InputPrompt & "?")

	Return True
End Sub

Private Sub AddInputVariable(VariableName As String) As Boolean
	VariableName = VariableName.ToUpperCase

	If VariableName = "" Or VariableName.Length > 8 Then Return False

	Dim FirstChar As String = VariableName.SubString2(0, 1)

	If FirstChar.CompareTo("A") < 0 Or FirstChar.CompareTo("Z") > 0 Then Return False

	For i = 0 To VariableName.Length - 1
		Dim CurrentChar As String = VariableName.SubString2(i, i + 1)

		If CurrentChar = "$" Then
			If i <> VariableName.Length - 1 Then Return False
		Else If (CurrentChar.CompareTo("A") < 0 Or CurrentChar.CompareTo("Z") > 0) And IsNumber(CurrentChar) = False Then
			Return False
		End If
	Next

	InputVariables.Add(VariableName)

	Return True
End Sub



Private Sub EvaluateStringExpression(Expression As String) As String
	Expression = Expression.Trim

	If Expression = "" Then
		ExprError = True
		Return ""
	End If

	'Split string expression at + signs outside quotes and brackets.
	Dim Parts As List
	Parts.Initialize

	Dim CurrentPart As StringBuilder
	CurrentPart.Initialize

	Dim InQuotes As Boolean = False
	Dim BracketLevel As Int = 0
	Dim HasConcatenation As Boolean = False

	For i = 0 To Expression.Length - 1
		Dim CurrentChar As String = Expression.SubString2(i, i + 1)

		If CurrentChar = Chr(34) Then
			InQuotes = Not(InQuotes)

		Else If InQuotes = False Then
			If CurrentChar = "(" Then BracketLevel = BracketLevel + 1
			If CurrentChar = ")" Then BracketLevel = BracketLevel - 1

			If CurrentChar = "+" And BracketLevel = 0 Then
				Parts.Add(CurrentPart.ToString.Trim)
				CurrentPart.Initialize
				HasConcatenation = True
				Continue
			End If
		End If

		CurrentPart.Append(CurrentChar)
	Next

	Parts.Add(CurrentPart.ToString.Trim)

	If InQuotes Or BracketLevel <> 0 Then
		ExprError = True
		Return ""
	End If

	'Concatenate string expressions.
	If HasConcatenation Then
		Dim CombinedValue As StringBuilder
		CombinedValue.Initialize

		For Each Part As String In Parts
			If Part = "" Then
				ExprError = True
				Return ""
			End If

			Dim PartValue As String = EvaluateStringExpression(Part)

			If ExprError Then Return ""

			CombinedValue.Append(PartValue)
		Next

		Return CombinedValue.ToString
	End If

	'String literal.
	If Expression.StartsWith(Chr(34)) And _
		Expression.EndsWith(Chr(34)) And Expression.Length >= 2 Then

		Return Expression.SubString2(1, Expression.Length - 1)
	End If

	'String variable.
	If Expression.EndsWith("$") Then
		Dim VariableName As String = Expression.ToUpperCase

		If Variables.ContainsKey(VariableName) Then
			Return Variables.Get(VariableName)
		End If

		ExprError = True
		Return ""
	End If

	Dim FunctionName As String = Expression.ToUpperCase
	Dim FunctionLength As Int

	Select Case True
		Case FunctionName.StartsWith("LEFT$(")
			FunctionLength = 6
		Case FunctionName.StartsWith("RIGHT$(")
			FunctionLength = 7
		Case FunctionName.StartsWith("MID$(")
			FunctionLength = 5
		Case FunctionName.StartsWith("STR$(")
			FunctionLength = 5
		Case FunctionName.StartsWith("CHR$(")
			FunctionLength = 5
		Case FunctionName.StartsWith("SPACE$(")
			FunctionLength = 7
		Case FunctionName.StartsWith("STRING$(")
			FunctionLength = 8
		Case FunctionName.StartsWith("UCASE$(")
			FunctionLength = 7
		Case FunctionName.StartsWith("LCASE$(")
			FunctionLength = 7
		Case FunctionName.StartsWith("LTRIM$(")
			FunctionLength = 7
		Case FunctionName.StartsWith("RTRIM$(")
			FunctionLength = 7
		Case FunctionName.StartsWith("TRIM$(")
			FunctionLength = 6
		Case Else
			ExprError = True
			Return ""
	End Select

	If Expression.EndsWith(")") = False Then
		ExprError = True
		Return ""
	End If

	'Extract function arguments.
	Dim Arguments As String = Expression.SubString2(FunctionLength, Expression.Length - 1)

	Dim ArgumentList As List
	ArgumentList.Initialize

	Dim CurrentArgument As StringBuilder
	CurrentArgument.Initialize

	InQuotes = False
	BracketLevel = 0

	For i = 0 To Arguments.Length - 1
		Dim ArgumentChar As String = Arguments.SubString2(i, i + 1)

		If ArgumentChar = Chr(34) Then
			InQuotes = Not(InQuotes)
		Else If InQuotes = False Then
			If ArgumentChar = "(" Then BracketLevel = BracketLevel + 1
			If ArgumentChar = ")" Then BracketLevel = BracketLevel - 1

			If ArgumentChar = "," And BracketLevel = 0 Then
				ArgumentList.Add(CurrentArgument.ToString.Trim)
				CurrentArgument.Initialize
				Continue
			End If
		End If

		CurrentArgument.Append(ArgumentChar)
	Next

	ArgumentList.Add(CurrentArgument.ToString.Trim)

	If InQuotes Or BracketLevel <> 0 Then
		ExprError = True
		Return ""
	End If

	'Check number of arguments.
	Dim ExpectedArguments As Int = 2

	If FunctionName.StartsWith("MID$(") Then ExpectedArguments = 3
	If FunctionName.StartsWith("STR$(") Then ExpectedArguments = 1
	If FunctionName.StartsWith("CHR$(") Then ExpectedArguments = 1
	If FunctionName.StartsWith("SPACE$(") Then ExpectedArguments = 1
	If FunctionName.StartsWith("UCASE$(") Then ExpectedArguments = 1
	If FunctionName.StartsWith("LCASE$(") Then ExpectedArguments = 1
	If FunctionName.StartsWith("LTRIM$(") Then ExpectedArguments = 1
	If FunctionName.StartsWith("RTRIM$(") Then ExpectedArguments = 1
	If FunctionName.StartsWith("TRIM$(") Then ExpectedArguments = 1

	If ArgumentList.Size <> ExpectedArguments Then
		ExprError = True
		Return ""
	End If

	'STR$: Convert numeric expression to string.
	If FunctionName.StartsWith("STR$(") Then
		Dim NumericResult As Double = EvaluateNumericExpression(ArgumentList.Get(0))

		If ExprError Then Return ""

		Return NumberFormat(NumericResult, 1, 6)
	End If

	'CHR$: Convert number to character.
	If FunctionName.StartsWith("CHR$(") Then
		Dim CharacterCode As Double = EvaluateNumericExpression(ArgumentList.Get(0))

		If ExprError Or CharacterCode < 0 Or CharacterCode > 255 Then
			ExprError = True
			Return ""
		End If

		Return Chr(Floor(CharacterCode))
	End If

	'SPACE$: Generate spaces.
	If FunctionName.StartsWith("SPACE$(") Then
		Dim SpaceCountValue As Double = EvaluateNumericExpression(ArgumentList.Get(0))

		If ExprError Or SpaceCountValue < 0 Or SpaceCountValue > 10000 Then
			ExprError = True
			Return ""
		End If

		Dim SpaceCount As Int = Floor(SpaceCountValue)
		Dim SpaceBuilder As StringBuilder
		SpaceBuilder.Initialize

		For i = 1 To SpaceCount
			SpaceBuilder.Append(" ")
		Next

		Return SpaceBuilder.ToString
	End If

	'STRING$: Repeat a character.
	If FunctionName.StartsWith("STRING$(") Then
		Dim RepeatCountValue As Double = EvaluateNumericExpression(ArgumentList.Get(0))

		If ExprError Or RepeatCountValue < 0 Or RepeatCountValue > 10000 Then
			ExprError = True
			Return ""
		End If

		Dim RepeatCount As Int = Floor(RepeatCountValue)
		Dim RepeatChar As String = ArgumentList.Get(1)

		'Character supplied as a string literal.
		If RepeatChar.StartsWith(Chr(34)) And _
			RepeatChar.EndsWith(Chr(34)) And RepeatChar.Length >= 2 Then

			RepeatChar = RepeatChar.SubString2(1, RepeatChar.Length - 1)

		Else If RepeatChar.ToUpperCase.EndsWith("$") Then

			'Character supplied as a string variable.
			Dim RepeatVariable As String = RepeatChar.ToUpperCase

			If Variables.ContainsKey(RepeatVariable) = False Then
				ExprError = True
				Return ""
			End If

			RepeatChar = Variables.Get(RepeatVariable)

		Else

			'Character supplied as an ASCII code.
			Dim RepeatCharCode As Double = EvaluateNumericExpression(RepeatChar)

			If ExprError Or RepeatCharCode < 0 Or RepeatCharCode > 255 Then
				ExprError = True
				Return ""
			End If

			RepeatChar = Chr(Floor(RepeatCharCode))
		End If

		If RepeatChar.Length <> 1 Then
			ExprError = True
			Return ""
		End If

		Dim RepeatBuilder As StringBuilder
		RepeatBuilder.Initialize

		For i = 1 To RepeatCount
			RepeatBuilder.Append(RepeatChar)
		Next

		Return RepeatBuilder.ToString
	End If

	'UCASE$: Convert string to uppercase.
	If FunctionName.StartsWith("UCASE$(") Then
		Dim CaseSource As String = EvaluateStringExpression(ArgumentList.Get(0))

		If ExprError Then Return ""

		Return CaseSource.ToUpperCase
	End If

	'LCASE$: Convert string to lowercase.
	If FunctionName.StartsWith("LCASE$(") Then
		Dim CaseSource As String = EvaluateStringExpression(ArgumentList.Get(0))

		If ExprError Then Return ""

		Return CaseSource.ToLowerCase
	End If

	'LTRIM$: Remove leading spaces.
	If FunctionName.StartsWith("LTRIM$(") Then
		Dim TrimSource As String = EvaluateStringExpression(ArgumentList.Get(0))

		If ExprError Then Return ""

		Dim TrimStart As Int = 0

		Do While TrimStart < TrimSource.Length
			If TrimSource.SubString2(TrimStart, TrimStart + 1) <> " " Then Exit
			TrimStart = TrimStart + 1
		Loop

		Return TrimSource.SubString(TrimStart)
	End If

	'RTRIM$: Remove trailing spaces.
	If FunctionName.StartsWith("RTRIM$(") Then
		Dim TrimSource As String = EvaluateStringExpression(ArgumentList.Get(0))

		If ExprError Then Return ""

		Dim TrimEnd As Int = TrimSource.Length

		Do While TrimEnd > 0
			If TrimSource.SubString2(TrimEnd - 1, TrimEnd) <> " " Then Exit
			TrimEnd = TrimEnd - 1
		Loop

		Return TrimSource.SubString2(0, TrimEnd)
	End If

	'TRIM$: Remove leading and trailing spaces.
	If FunctionName.StartsWith("TRIM$(") Then
		Dim TrimSource As String = EvaluateStringExpression(ArgumentList.Get(0))

		If ExprError Then Return ""

		Return TrimSource.Trim
	End If

	'Evaluate source string.
	Dim StringArgument As String = ArgumentList.Get(0)
	Dim StringValue As String = ""

	If StringArgument.StartsWith(Chr(34)) And _
		StringArgument.EndsWith(Chr(34)) And StringArgument.Length >= 2 Then

		StringValue = StringArgument.SubString2(1, StringArgument.Length - 1)

	Else
		Dim SourceVariable As String = StringArgument.ToUpperCase

		If SourceVariable.EndsWith("$") = False Or Variables.ContainsKey(SourceVariable) = False Then
			ExprError = True
			Return ""
		End If

		StringValue = Variables.Get(SourceVariable)
	End If

	'Evaluate start position for MID$.
	Dim StartPosition As Int = 1

	If FunctionName.StartsWith("MID$(") Then
		Dim StartValue As Double = EvaluateNumericExpression(ArgumentList.Get(1))

		If ExprError Or StartValue < 1 Then
			ExprError = True
			Return ""
		End If

		StartPosition = Floor(StartValue)
	End If

	'Evaluate number of characters.
	Dim LengthIndex As Int = 1
	If FunctionName.StartsWith("MID$(") Then LengthIndex = 2

	Dim RequestedLength As Double = EvaluateNumericExpression(ArgumentList.Get(LengthIndex))

	If ExprError Or RequestedLength < 0 Then
		ExprError = True
		Return ""
	End If

	Dim CharacterCount As Int = Floor(RequestedLength)

	If FunctionName.StartsWith("LEFT$(") Then
		If CharacterCount > StringValue.Length Then CharacterCount = StringValue.Length

		Return StringValue.SubString2(0, CharacterCount)

	Else If FunctionName.StartsWith("RIGHT$(") Then
		If CharacterCount > StringValue.Length Then CharacterCount = StringValue.Length

		Return StringValue.SubString(StringValue.Length - CharacterCount)

	Else
		'MID$: BASIC positions start at 1.
		Dim StartIndex As Int = StartPosition - 1

		If StartIndex >= StringValue.Length Then Return ""

		Dim EndIndex As Int = StartIndex + CharacterCount

		If EndIndex > StringValue.Length Then EndIndex = StringValue.Length

		Return StringValue.SubString2(StartIndex, EndIndex)
	End If
End Sub

Private Sub IsStringExpressionForPrint(Item As String) As Boolean
	Dim FirstPart As String = Item.Trim
	Dim InQuotes As Boolean = False
	Dim BracketLevel As Int = 0

	For i = 0 To FirstPart.Length - 1
		Dim CurrentChar As String = FirstPart.SubString2(i, i + 1)

		If CurrentChar = Chr(34) Then
			InQuotes = Not(InQuotes)

		Else If InQuotes = False Then
			If CurrentChar = "(" Then BracketLevel = BracketLevel + 1
			If CurrentChar = ")" Then BracketLevel = BracketLevel - 1

			If CurrentChar = "+" And BracketLevel = 0 Then
				FirstPart = FirstPart.SubString2(0, i).Trim
				Exit
			End If
		End If
	Next

	If FirstPart.StartsWith(Chr(34)) Then Return True

	Dim UpperPart As String = FirstPart.ToUpperCase

	'Predefined numeric variables.
	If UpperPart = "ERR" Or UpperPart = "ERL" Then Return False

	If UpperPart.EndsWith("$") Then Return True

	If UpperPart.StartsWith("LEFT$(") Or _
		UpperPart.StartsWith("RIGHT$(") Or _
		UpperPart.StartsWith("MID$(") Or _
		UpperPart.StartsWith("STR$(") Or _
		UpperPart.StartsWith("CHR$(") Or _
		UpperPart.StartsWith("SPACE$(") Or _
		UpperPart.StartsWith("STRING$(") Or _
		UpperPart.StartsWith("UCASE$(") Or _
		UpperPart.StartsWith("LCASE$(") Or _
		UpperPart.StartsWith("LTRIM$(") Or _
		UpperPart.StartsWith("RTRIM$(") Or _
		UpperPart.StartsWith("TRIM$(") Then

		Return True
	End If

	Return False
End Sub

Private Sub SpaceString(Count As Int) As String
	Dim Result As StringBuilder
	Result.Initialize

	For i = 1 To Count
		Result.Append(" ")
	Next

	Return Result.ToString
End Sub

Private Sub HandleProgramError(Message As String) As Boolean

	'Do not allow recursive error handling.
	If ErrorHandlerRunning Or ErrorHandlerEnabled = False Then
		PrintText(taOutput, Message)
		RunPosition = RunLines.Size
		Return False
	End If

	ErrorLinePosition = RunPosition - 1
	ErrorNextPosition = RunPosition

	'Validate the failing BASIC line position.
	If ErrorLinePosition < 0 Or ErrorLinePosition >= RunLines.Size Then
		PrintText(taOutput, Message)
		RunPosition = RunLines.Size
		Return False
	End If

	'Get the BASIC line number.
	ErrorLineNumber = RunLines.Get(ErrorLinePosition)

	'Determine BASIC error code.
	If Message.Contains("UNDEFINED LINE") Then
		ErrorCode = 5
	Else If Message.Contains("DIVISION BY ZERO") Then
		ErrorCode = 11
	Else If Message.Contains("NEXT WITHOUT FOR") Then
		ErrorCode = 22
	Else If Message.Contains("RETURN WITHOUT GOSUB") Then
		ErrorCode = 23
	Else
		ErrorCode = 20
	End If

	'Activate the error handler.
	ErrorHandlerRunning = True

	Dim HandlerPosition As Int = FindRunPosition(ErrorHandlerLine)

	If HandlerPosition < 0 Then
		PrintText(taOutput, "?UNDEFINED ERROR HANDLER LINE " & ErrorHandlerLine)
		RunPosition = RunLines.Size
		ErrorHandlerRunning = False
		Return False
	End If

	RunPosition = HandlerPosition

	Return True

End Sub

Private Sub ExecuteOnError(LineCode As String) As Boolean
	Dim UpperLine As String = LineCode.ToUpperCase.Trim

	If UpperLine.StartsWith("ON ERROR GOTO ") = False Then Return False

	Dim TargetText As String = LineCode.SubString(14).Trim

	If IsNumber(TargetText) = False Then Return False

	Dim TargetLine As Int = TargetText

	If TargetLine = 0 Then
		ErrorHandlerEnabled = False
		ErrorHandlerLine = 0
		Return True
	End If

	If FindRunPosition(TargetLine) < 0 Then Return False

	ErrorHandlerLine = TargetLine
	ErrorHandlerEnabled = True

	Return True
End Sub

Private Sub ExecuteResume(LineCode As String) As Boolean

	If ErrorHandlerRunning = False Then Return False

	Dim ResumeCommand As String = LineCode.Trim.ToUpperCase

	Select Case ResumeCommand

		Case "RESUME"
			If ErrorLinePosition < 0 Then Return False
			RunPosition = ErrorLinePosition

		Case "RESUME NEXT"
			If ErrorNextPosition < 0 Then Return False
			RunPosition = ErrorNextPosition

		Case Else
			Return False

	End Select

	'The handler has completed its work.
	ErrorHandlerRunning = False

	Return True

End Sub

Private Sub ResetErrorHandler

	ErrorHandlerLine = 0
	ErrorHandlerEnabled = False
	ErrorHandlerRunning = False

	ErrorLinePosition = -1
	ErrorNextPosition = -1
	ErrorCode = 0
	ErrorLineNumber = 0

End Sub

Private Sub FindRunPosition(TargetLine As Int) As Int
	For i = 0 To RunLines.Size - 1
		Dim LineNumber As Int = RunLines.Get(i)

		If LineNumber = TargetLine Then Return i
	Next

	Return -1
End Sub



Private Sub ExecuteHelp
'
'	PrintText("BASIC-58 :: HELP")
'	PrintText("==============================")
'
'	PrintText("")
'	PrintText("DIRECT COMMANDS")
'	PrintText("HELP              Show this help")
'	PrintText("LIST              List program")
'	PrintText("RUN               Run program")
'	PrintText("NEW               Create NEW BASIC program")
'	PrintText("SAVE [filename]   Save program")
'	PrintText("LOAD [filename]   Load program")
'	PrintText("CLS               Clear output")
'	PrintText("PRINT expression  Print immediately")
'
'	PrintText("")
'	PrintText("PROGRAM STATEMENTS")
'	PrintText("LET variable = expression")
'	PrintText("INPUT [prompt;] variables")
'	PrintText("PRINT expressions")
'	PrintText("IF condition THEN line")
'	PrintText("GOTO line")
'	PrintText("GOSUB line")
'	PrintText("RETURN")
'	PrintText("FOR variable = start TO limit [STEP value]")
'	PrintText("NEXT [variable]")
'	PrintText("ON expression GOTO line,...")
'	PrintText("ON expression GOSUB line,...")
'	PrintText("DATA value,...")
'	PrintText("READ variable,...")
'	PrintText("RESTORE")
'	PrintText("RANDOMIZE [expression]")
'	PrintText("REM comment")
'	PrintText("END")
'
'	PrintText("")
'	PrintText("ERROR HANDLING")
'	PrintText("ON ERROR GOTO line")
'	PrintText("ON ERROR GOTO 0")
'	PrintText("RESUME")
'	PrintText("RESUME NEXT")
'	PrintText("ERR     Error code")
'	PrintText("ERL     Error line number")
'
'	PrintText("")
'	PrintText("NUMERIC FUNCTIONS")
'	PrintText("ABS  INT  SGN  SQR")
'	PrintText("SIN  COS  TAN")
'	PrintText("LOG  EXP  RND")
'	PrintText("LEN  VAL  ASC  INSTR")
'
'	PrintText("")
'	PrintText("STRING FUNCTIONS")
'	PrintText("LEFT$  RIGHT$  MID$")
'	PrintText("STR$   CHR$    SPACE$")
'	PrintText("STRING$  UCASE$  LCASE$")
'	PrintText("LTRIM$  RTRIM$  TRIM$")
'
'	PrintText("")
'	PrintText("PRINT FORMATTING")
'	PrintText("TAB(n)  Move to column n")
'	PrintText("SPC(n)  Print n spaces")
'	PrintText(";       Separate output items")
'	PrintText(",       Advance to next print zone")
'
'	PrintText("")
'	PrintText("END OF HELP")
'	PrintText("==============================")
End Sub

Private Sub ScrollTextToBottom(Target As B4XView) As ResumableSub
	Sleep(50)

	Dim NativeTextArea As JavaObject = Target
	NativeTextArea.RunMethod("setScrollTop", Array(100000.0))

	Return True
End Sub


'Handle click of a toolbar label
'Label tag is an array object with 3 entries: Layoutmodule (map), eventname (string), tag (string)
'The label tag is assigned to an array object from which the entry with index 2 is assigned to string.
Private Sub Toolbar_Click (lbl As B4XView)
	Dim o() As Object = lbl.Tag
	Dim tag As String = o(2)
	'Log($"[Toolbar_Click] tag=${tag}, text=${lbl.Text}"$)
	Select tag.ToLowerCase
		Case "load"
			Load
		Case "save"
			Save
		Case "run"
			RunProgram
	End Select
	'B4XPages.SetTitle(Me, tag)
End Sub

Private Sub Load
	Dim Filename As String
	Dim FileChoose As FileChooser
	FileChoose.Initialize
	FileChoose.InitialDirectory = File.DirApp
	FileChoose.SetExtensionFilter("BAS", Array As String("*.bas"))
	FileChoose.Title = "Load Program"
	Filename = FileChoose.ShowOpen(B4XPages.GetNativeParent(Me))
	If Filename.Length = 0 Then 
		Return
	End If
	Try
		CurrentFileName = GetFileName(Filename).ToUpperCase
		CurrentFilePath = GetFilePath(Filename)
		lblFile.Text = CurrentFileName
		'Log($"[Load] path=${CurrentFilePath}, file=${CurrentFileName}"$)
		LoadProgram(CurrentFileName)
		ProgramModified = False
		LoadingProgram = True
		UpdatePageTitle
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
		CurrentFileName = GetFileName(Filename).ToUpperCase
		CurrentFilePath = GetFilePath(Filename)
		'Log("[Save] Selected: " & Filename)
		'Log("[Save] Directory: " & CurrentFilePath)
		'Log("[Save] Filename: " & CurrentFileName)
		
		If SaveProgram(CurrentFileName) Then
			lblFile.Text = CurrentFileName
			ProgramModified = False
			UpdatePageTitle			
		End If
	Catch
		Log($"[Save][E] Failed - ${LastException.Message}"$)
	End Try
End Sub
           
' Returns the filename from a fullpath
Sub GetFileName(path As String) As String
	' Define the JavaObject
	Dim fileO As JavaObject
	' Get the fileio class
	fileO.InitializeNewInstance("java.io.File", Array As Object(path))
	' Getthe filename
	Return fileO.RunMethod("getName", Null)
End Sub

' Returns the filepath from a fullpath
Sub GetFilePath(path As String) As String
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

Private Sub taEditor_TextChanged (Old As String, New As String)
	If UpdatingEditor Then Return

	If LoadingProgram = False Then
		ProgramModified = True
		UpdatePageTitle
	End If

	Dim UpperText As String = New.ToUpperCase

	If New <> UpperText Then
		Dim TextArea As JavaObject = taEditor
		Dim CursorPosition As Int = TextArea.RunMethod("getCaretPosition", Null)

		UpdatingEditor = True
		taEditor.Text = UpperText
		TextArea.RunMethod("positionCaret", Array(CursorPosition))
		UpdatingEditor = False
	End If
End Sub

Private Sub UpdateProgramLines
	ProgramLines.Clear

	Dim EditorLines() As String = Regex.Split(CRLF, taEditor.Text)

	For Each EditorLine As String In EditorLines
		EditorLine = EditorLine.Trim

		If EditorLine = "" Then Continue

		Dim SpacePos As Int = EditorLine.IndexOf(" ")

		If SpacePos <= 0 Then Continue

		Dim NumberText As String = EditorLine.SubString2(0, SpacePos)
		Dim LineCode As String = EditorLine.SubString(SpacePos + 1).Trim

		If IsNumber(NumberText) And LineCode <> "" Then
			Dim LineNumber As Int = NumberText
			ProgramLines.Put(LineNumber, LineCode)
		End If
	Next
End Sub

Private Sub UpdatePageTitle
	Dim PageTitle As String = $"${VERSION} - ${CurrentFileName}"$

	If ProgramModified Then
		PageTitle = PageTitle & " *"
	End If

	B4XPages.SetTitle(Me, PageTitle)
End Sub

Private Sub FormatNumber(Value As Double) As String
	Dim Result As String = NumberFormat2(Value, 1, 0, 6, False)

	Do While Result.Contains(".") And Result.EndsWith("0")
		Result = Result.SubString2(0, Result.Length - 1)
	Loop

	If Result.EndsWith(".") Then
		Result = Result.SubString2(0, Result.Length - 1)
	End If

	Return Result
End Sub