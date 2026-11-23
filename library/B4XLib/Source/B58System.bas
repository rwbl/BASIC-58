B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.7
@EndOfDesignText@
' ================================================================
' Class Module:	B58System
' Project:		BASIC-58
' Brief:		System command handler for BASIC-58.
' Description:	Handles local system commands issued through @SYS.
'				Provides system information and utility functions,
'				such as SHOW TIME, SHOW DATE.
'				Communicates results through callbacks.
' ================================================================

Private Sub Class_Globals
	' A tiny BASIC interpreter
	Public APPNAME As String = "BASIC-58"
	Public APPVERSION As String = "v1.0.0 (Build 20261123)"
	Public APPCOPYRIGHT As String = "Copyright (c) 2026 Robert W.B. Linn - MIT Licence"

	' Event callback
	Private mCallback As Object
	Private mEventName As String

	' Settings
	Private Const SETTINGS_FILE As String = "basic58.set"
	Private mFileDir As String
	Private mClearRun As Boolean

	' Show Version	
	Private AppStartTime As Long

End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize(Callback As Object, EventName As String)
	' Callback and events.
	mCallback = Callback
	mEventName = EventName
	
	' Capture the time the app started
	AppStartTime = DateTime.Now
	
	' Load the settingsd from the JSOn file
	LoadSettings
End Sub

' EXECUTECOMMAND

Public Sub ExecuteCommand(Command As String)
	Dim Cmd As String = Command.Trim

	If Cmd.ToUpperCase.StartsWith("SET ") Then
		ProcessSetCommand(Cmd)
		Return
	End If

	Select Case Cmd.ToUpperCase
		Case "SHOW TIME"
			' Existing code

		Case "SHOW DATE"
			' Existing code

		Case "SHOW SETTINGS"
			Utils.CallSubMethod2(mCallback, mEventName, "_Output", GetShowSettingsText)

		Case "SHOW VERSION"
			Utils.CallSubMethod2(mCallback, mEventName, "_Output", GetShowVersionText)

		Case Else
			Log("[BASIC-58][E] Unknown system command.")
	End Select
End Sub

' ----------------------------------------------------------------
' PROCESSSETCOMMAND
' ----------------------------------------------------------------
' ProcessSetCommand
Private Sub ProcessSetCommand(Command As String)
	Dim Cmd As String = Command.Trim
	Dim Separator As Int = Cmd.IndexOf2(" ", 4)

	If Separator = -1 Then
		Utils.CallSubMethod2(mCallback, mEventName, "_Output", "ERROR: INVALID SET COMMAND")
		Return
	End If

	Dim SettingName As String = Cmd.SubString2(4, Separator).ToUpperCase
	Dim SettingValue As String = Cmd.SubString(Separator + 1).Trim

	Select Case SettingName

		Case "FILEDIR"
			Dim FirstQuote As Int = Cmd.IndexOf("""")
			Dim LastQuote As Int = Cmd.LastIndexOf("""")

			If FirstQuote = -1 Or LastQuote <= FirstQuote Then
				Utils.CallSubMethod2(mCallback, mEventName, "_Output", "ERROR: EXPECTED FILEDIR ""PATH""")
				Return
			End If

			Dim Value As String = Cmd.SubString2(FirstQuote + 1, LastQuote)
			Utils.CallSubMethod2(mCallback, mEventName, "_Output", GetSetFileDirText(Value))

		Case "RUNCLEAR"
			Select Case SettingValue.ToUpperCase
				Case "ON"
					mClearRun = True
					SaveSettings
					Utils.CallSubMethod2(mCallback, mEventName, "_Output", "RUNCLEAR SET TO ON")

				Case "OFF"
					mClearRun = False
					SaveSettings
					Utils.CallSubMethod2(mCallback, mEventName, "_Output", "RUNCLEAR SET TO OFF")

				Case Else
					Utils.CallSubMethod2(mCallback, mEventName, "_Output", "ERROR: EXPECTED RUNCLEAR ON OR OFF")
			End Select

		Case Else
			Utils.CallSubMethod2(mCallback, mEventName, "_Output", "ERROR: UNKNOWN SET COMMAND")

	End Select
End Sub

' ----------------------------------------------------------------
' SHOWVERSION
' ----------------------------------------------------------------
#Region ShowVersion
Public Sub GetShowVersionText As String
	Dim SB As StringBuilder
	SB.Initialize

	' 1. DEC-style Date & Time (e.g. 21-NOV-2026 11:29:00.00)
	Dim PrevDateFormat As String = DateTime.DateFormat
	Dim PrevTimeFormat As String = DateTime.TimeFormat
	DateTime.DateFormat = "dd-MMM-yyyy"
	DateTime.TimeFormat = "HH:mm:ss.SS"
	Dim Timestamp As String = (DateTime.Date(DateTime.Now) & " " & DateTime.Time(DateTime.Now)).ToUpperCase
	DateTime.DateFormat = PrevDateFormat
	DateTime.TimeFormat = PrevTimeFormat

	' 2. DEC VMS-style Uptime (DD HH:MM:SS.CC)
	Dim Elapsed As Long = DateTime.Now - AppStartTime
	Dim Days As Int = Elapsed / DateTime.TicksPerDay
	Dim Rem1 As Long = Elapsed Mod DateTime.TicksPerDay
	Dim Hours As Int = Rem1 / DateTime.TicksPerHour
	Dim Rem2 As Long = Rem1 Mod DateTime.TicksPerHour
	Dim Mins As Int = Rem2 / DateTime.TicksPerMinute
	Dim Rem3 As Long = Rem2 Mod DateTime.TicksPerMinute
	Dim Secs As Int = Rem3 / DateTime.TicksPerSecond
	Dim Hundredths As Int = (Rem3 Mod DateTime.TicksPerSecond) / 10
	Dim UptimeStr As String = $"$2.0{Days} $2.0{Hours}:$2.0{Mins}:$2.0{Secs}.$2.0{Hundredths}"$

	' 3. Live Host OS & Java Version
	Dim OsName As String = GetSystemProperty("os.name", "UNKNOWN").ToUpperCase
	Dim OsArch As String = GetSystemProperty("os.arch", "UNKNOWN").ToUpperCase
	Dim JavaVer As String = GetSystemProperty("java.version", "UNKNOWN").ToUpperCase

	' 4. Live JVM Memory (in MB)
	Dim RuntimeJO As JavaObject
	RuntimeJO.InitializeStatic("java.lang.Runtime")
	Dim RT As JavaObject = RuntimeJO.RunMethod("getRuntime", Null)
	Dim TotalMemMB As Long = RT.RunMethod("totalMemory", Null) / 1048576
	Dim FreeMemMB As Long = RT.RunMethod("freeMemory", Null) / 1048576

	' 5. Build DEC Output Block
	SB.Append($"${APPNAME} ${APPVERSION}"$).Append(CRLF)
	SB.Append($"${APPCOPYRIGHT}"$).Append(CRLF)
	SB.Append($"SYSTEM TIME: ${Timestamp}   UPTIME: ${UptimeStr}"$).Append(CRLF)
	SB.Append($"HOST SYSTEM: ${OsName} (${OsArch}) - JAVA ${JavaVer}"$).Append(CRLF)
	SB.Append("TERMINAL: EMULATION, 80 COLUMNS X 24 ROWS, P3 AMBER").Append(CRLF)
	SB.Append($"MEMORY: ${TotalMemMB} MB ALLOCATED, ${FreeMemMB} MB FREE"$).Append(CRLF)

	Return SB.ToString
End Sub
#End Region

' ----------------------------------------------------------------
' SETTINGS
' ----------------------------------------------------------------
#Region
Private Sub LoadSettings
	' Init globals
	mFileDir = File.DirApp
	mFileDir = File.DirApp
	mClearRun = True

	If File.Exists(File.DirApp, SETTINGS_FILE) = False Then
		SaveSettings
		Return
	End If

	Try
		Dim Parser As JSONParser
		Parser.Initialize(File.ReadString(File.DirApp, SETTINGS_FILE))

		' Read the settings map and assign to the globals
		Dim Settings As Map = Parser.NextObject
		mFileDir = Settings.GetDefault("FileDir", File.DirApp)
		mClearRun = Settings.GetDefault("RunClear", True)

		If Utils.IsValidDirectory(mFileDir) = False Then
			mFileDir = File.DirApp
		End If

	Catch
		Log("[BASIC-58][E] Error loading settings.")
		mFileDir = File.DirApp
	End Try
End Sub

Private Sub SaveSettings
	Try
		' Create settings map and assign the globals
		Dim Settings As Map
		Settings.Initialize
		Settings.Put("Version", "1.0")
		Settings.Put("FileDir", mFileDir)
		Settings.Put("RunClear", mClearRun)
		
		Dim JSON As JSONGenerator
		JSON.Initialize(Settings)

		File.WriteString(File.DirApp, SETTINGS_FILE, JSON.ToString)

	Catch
		Log("[BASIC-58][E] Error saving settings.")
	End Try
End Sub

' Get/Set filedir
Public Sub GetShowSettingsText As String
	Dim SB As StringBuilder
	SB.Initialize

	SB.Append("SYSTEM SETTINGS:").Append(CRLF)
	SB.Append("  FILEDIR: ").Append(mFileDir)
	SB.Append(CRLF)
	SB.Append("  RUNCLEAR: ").Append(mClearRun)
	
	Return SB.ToString
End Sub

Public Sub GetFileDir As String
	Return mFileDir
End Sub

Public Sub SetFileDir(Value As String) As Boolean
    If Utils.IsValidDirectory(Value) = False Then
		Log("[BASIC-58][E] Directory does not exist: " & Value)
        Return False
    End If

    mFileDir = Value
    SaveSettings
    Return True
End Sub

Public Sub GetSetFileDirText(Value As String) As String
    If SetFileDir(Value) Then
        Return "FILEDIR SET TO: " & mFileDir
    Else
        Return "ERROR: DIRECTORY NOT FOUND: " & Value
    End If
End Sub

Public Sub GetRunClear As Boolean
	Return mClearRun
End Sub
#End Region

