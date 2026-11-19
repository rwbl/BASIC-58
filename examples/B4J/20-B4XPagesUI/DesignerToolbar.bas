B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=10.7
@EndOfDesignText@
#Region Class Notes
'DesignerToolbar Class
'Customized DesignerUtils.CreateToolbar method with label as parameter for toolbarname_click event.
'This enables to get the label properties and change them, i.e. set textcolor, change fonticon.
'See https://www.b4x.com/android/forum/threads/ddd-createtoolbar-recognize-label-properties.141708/#content

'Designer Script General Code Example.
'Note the usage of DDD object because the methods ToChr etc are not defined in the DesignerToolbar class.
'DesignerToolbar.CreateToolbar(pnBottomToolbar, "BottomToolbar", DDD.ToChr(0xF015), "home", _
'	DDD.ToChr(0xF217) & " abc", "cart", DDD.ToChr(0xF1D9), "send")
'DDD.SpreadControlsHorizontally(pnBottomToolbar, 120dip, 10dip)
'
'DesignerToolbar.CreateToolbar(pnTopToolbar, "TopToolbar",  DDD.ToChr(0xF037), "align-center", _
'	DDD.ToChr(0xF039), "align-justify", DDD.ToChr(0xF036), "align-left", _
'	DDD.ToChr(0xF038), "align-right")
'DDD.SpreadControlsHorizontally(pnTopToolbar, 120dip, 10dip)
'
'DDD.CollectViewsData
#End Region

Sub Class_Globals
	Private fx As JFX
	Private xui As XUI
	Private du As DDD
	'This will cause the compiler to treat it as a class with an activity context.
	Private stub As B4XView 'ignore
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize
	du.Initialize
End Sub

Private Sub CreateToolbar (DesignerArgs As DesignerArgs)
	Dim pnl As B4XView = DesignerArgs.GetViewFromArgs(0)
	If DesignerArgs.FirstRun Then
		Dim StubLabel As B4XView = pnl.GetView(0)
		StubLabel.RemoveViewFromParent
		Dim EventName As String = DesignerArgs.Arguments.Get(1)
		Dim fnt As B4XFont = StubLabel.Font
		For i = 2 To DesignerArgs.Arguments.Size - 1 Step 2
			Dim textitems() As String = Regex.Split(" ", DesignerArgs.Arguments.Get(i))
			Dim text As String = $"${textitems(0)}${CRLF}${textitems(1)}"$
			Dim tag As String = DesignerArgs.Arguments.Get(i + 1)

			Dim lbl As B4XView = CreateLabel
			lbl.Font = fnt
			lbl.Text = text
			' lbl.TextColor = StubLabel.TextColor
			CSSUtils.SetStyleProperty(lbl, "-fx-text-fill", "#FFBF69")
			CSSUtils.SetStyleProperty(lbl, "-fx-background-color", "#58544E")	'"#E0E2DC")
			lbl.SetColorAndBorder(xui.Color_ARGB(0xFF,0x58,0x54,0x4E), 1,xui.Color_ARGB(0xFF,0x58,0x54,0x4E), 5)
			lbl.SetTextAlignment("CENTER", "CENTER")
			lbl.Tag = Array(DesignerArgs.LayoutModule, EventName, tag)
			pnl.AddView(lbl, 0, 0, 40dip, pnl.Height)
		Next
	Else
		For i = 0 To pnl.NumberOfViews - 1
			pnl.GetView(i).Height = pnl.Height
		Next
	End If
End Sub

'Create the label. The properties are set in the CreateToolbar with the designer defined label properties, i.e. font is FontAwesome etc.
Private Sub CreateLabel As B4XView
	Dim lbl As Label
	lbl.Initialize("lbl")
	Return lbl
End Sub

#if B4J
Private Sub lbl_MouseClicked (EventData As MouseEvent)
	RaiseToolbarEvent(Sender, Sender.As(B4XView).Tag)
	EventData.Consume
End Sub
#else
Private Sub lbl_Click
    RaiseToolbarEvent(Sender, Sender.As(B4XView).Tag)
End Sub
#End If

'If the label is clicked the toolbar event raises toolbarname_click with the label as parameter.
'Example: <code>
'Private Sub BottomToolbar_Click (Lbl As B4XView)
'	Log(Lbl.Tag)
'	Lbl.TextColor = xui.Color_Red
'	B4XPages.SetTitle(Me, Lbl.Tag)
'End Sub
'</code>
Private Sub RaiseToolbarEvent (lbl As B4XView, Data() As Object)
	CallSubDelayed2(Data(0), Data(1) & "_click", lbl)
End Sub
