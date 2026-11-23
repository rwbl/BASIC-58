B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
#Region Shared Files
#CustomBuildAction: folders ready, %WINDIR%\System32\Robocopy.exe,"..\..\Shared Files" "..\Files"
'Ctrl + click to sync files: ide://run?file=%WINDIR%\System32\Robocopy.exe&args=..\..\Shared+Files&args=..\Files&FilesSync=True
#End Region

#Macro: Title, Export B4XPages, ide://run?File=%B4X%\Zipper.jar&Args=%PROJECT_NAME%.zip

Sub Class_Globals
	Private fx As JFX
	Private Root As B4XView
	Private xui As XUI
	Private cbCommands As ComboBox
End Sub

Public Sub Initialize
'	B4XPages.GetManager.LogEvents = True
End Sub

'This event will be called once, before the page becomes visible.
Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("MainPage")

	ComboBoxSetPromptText(cbCommands, "ENTER COMMAND OR INPUT...")

	SetUIStyling
End Sub

'You can see the list of page related events in the B4XPagesManager object. The event name is B4XPage.

Private Sub Button1_Click
	xui.MsgboxAsync("Hello world!", "B4X")
End Sub

private Sub SetUIStyling
	
	' Load special styling
	B4XPages.GetNativeParent(Me).Stylesheets.Add(File.GetUri(File.DirAssets, "Main.css"))

	'--------------------------------------------------
	' Main application
	'--------------------------------------------------
	CSSUtils.SetBackgroundColor(Root, fx.Colors.From32Bit(0xFFDCD6C8))
	' Root.SetColorAndBorder(xui.Color_ARGB(0xFF,0xDC,0xD6,0xC8), 2, xui.Color_ARGB(0xFF,0x4A,0x48,0x45), 0)
	
	'--------------------------------------------------
	' Command input
	'--------------------------------------------------
'	Dim JO As JavaObject = cbCommands
'	Dim Editor As JavaObject = JO.RunMethod("getEditor", Null)
'	Editor.RunMethod("setStyle", Array("-fx-font-family: 'Consolas'; -fx-font-size: 16px; -fx-text-fill: #FFBF69; -fx-prompt-text-fill: #C9954A; -fx-control-inner-background: #211B13;"))

'	Dim JO As JavaObject = cbCommands
'	Dim Editor As JavaObject = JO.RunMethod("getEditor", Null)
'	Editor.RunMethod("setStyle", Array("-fx-font-family: 'Consolas'; -fx-font-size: 16px;"))
	'Editor.RunMethod("setStyle", Array("-fx-font-family: 'Glass_TTY_VT220'; -fx-font-size: 16px; -fx-text-inner-color: #FFBF69"))
	
'	CSSUtils.SetStyleProperty(cbCommands, "-fx-background-color", "#211B13")
'	CSSUtils.SetStyleProperty(cbCommands, "-fx-text-fill", "#FFBF69")
'	CSSUtils.SetStyleProperty(cbCommands, "-fx-prompt-text-fill", "#C9954A")
'	CSSUtils.SetStyleProperty(cbCommands, "-fx-border-color", "#80613A")
'	CSSUtils.SetStyleProperty(cbCommands, "-fx-border-width", "1")
'	CSSUtils.SetStyleProperty(cbCommands, "-fx-text-inner-color", "#FFBF69")

End Sub

Public Sub ComboBoxSetPromptText(box As ComboBox, text As String)
	Dim joCB As JavaObject = box
	joCB.RunMethod("setPromptText", Array(text))
End Sub
