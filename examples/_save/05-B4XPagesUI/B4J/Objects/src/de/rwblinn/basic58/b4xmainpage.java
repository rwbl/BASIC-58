package de.rwblinn.basic58;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class b4xmainpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("de.rwblinn.basic58", "de.rwblinn.basic58.b4xmainpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", de.rwblinn.basic58.b4xmainpage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _appname = "";
public String _appversion = "";
public String _appcopyright = "";
public anywheresoftware.b4j.objects.JFX _fx = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _pntoolbar = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lbltoolbar = null;
public anywheresoftware.b4j.objects.ComboBoxWrapper _cbcommands = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _taeditor = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _taoutput = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lbloutput = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lbleditor = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _pneditor = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _pnoutput = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lblstatus = null;
public de.rwblinn.basic58.ddd _designerutils = null;
public String _currentfilename = "";
public String _currentfilepath = "";
public boolean _programmodified = false;
public boolean _loadingprogram = false;
public boolean _updatingeditor = false;
public b4j.example.b58interpreter _interpreter = null;
public b4j.example.b58serial _serial = null;
public b4j.example.b58system _system = null;
public anywheresoftware.b4a.objects.Timer _delaytimer = null;
public long _delay_interval = 0L;
public anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.b58protocol _b58protocol = null;
public b4j.example.utils _utils = null;
public b4j.example.b58help _b58help = null;
public de.rwblinn.basic58.main _main = null;
public de.rwblinn.basic58.b4xpages _b4xpages = null;
public de.rwblinn.basic58.b4xcollections _b4xcollections = null;
public String  _addcommandtohistory(String _command) throws Exception{
anywheresoftware.b4a.objects.collections.List _items = null;
 //BA.debugLineNum = 363;BA.debugLine="Private Sub AddCommandToHistory(Command As String)";
 //BA.debugLineNum = 365;BA.debugLine="Dim Items As List = cbCommands.Items";
_items = new anywheresoftware.b4a.objects.collections.List();
_items = _cbcommands.getItems();
 //BA.debugLineNum = 368;BA.debugLine="If Items.Size > 0 Then";
if (_items.getSize()>0) { 
 //BA.debugLineNum = 369;BA.debugLine="If Items.Get(Items.Size - 1) = Command The";
if ((_items.Get((int) (_items.getSize()-1))).equals((Object)(_command))) { 
if (true) return "";};
 };
 //BA.debugLineNum = 372;BA.debugLine="Items.Add(Command)";
_items.Add((Object)(_command));
 //BA.debugLineNum = 375;BA.debugLine="Do While Items.Size > 50";
while (_items.getSize()>50) {
 //BA.debugLineNum = 376;BA.debugLine="Items.RemoveAt(0)";
_items.RemoveAt((int) (0));
 }
;
 //BA.debugLineNum = 379;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _b4xpage_closerequest() throws Exception{
ResumableSub_B4XPage_CloseRequest rsub = new ResumableSub_B4XPage_CloseRequest(this);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_B4XPage_CloseRequest extends BA.ResumableSub {
public ResumableSub_B4XPage_CloseRequest(de.rwblinn.basic58.b4xmainpage parent) {
this.parent = parent;
}
de.rwblinn.basic58.b4xmainpage parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
 //BA.debugLineNum = 128;BA.debugLine="If xui.IsB4A Then";
if (true) break;

case 1:
//if
this.state = 4;
if (parent._xui.getIsB4A()) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 130;BA.debugLine="Serial.Disconnect";
parent._serial._disconnect();
 //BA.debugLineNum = 131;BA.debugLine="Return True";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.True));return;};
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Private Sub B4XPage_Created (Root1 As B4XView)";
 //BA.debugLineNum = 84;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 85;BA.debugLine="DesignerUtils.Initialize";
_designerutils._initialize /*String*/ (ba);
 //BA.debugLineNum = 86;BA.debugLine="Root.LoadLayout(\"MainPage\")";
_root.LoadLayout("MainPage",ba);
 //BA.debugLineNum = 91;BA.debugLine="Serial.Initialize(Me, \"Serial\")";
_serial._initialize(ba,this,"Serial");
 //BA.debugLineNum = 93;BA.debugLine="System.Initialize(Me, \"System\")";
_system._initialize(ba,this,"System");
 //BA.debugLineNum = 95;BA.debugLine="DelayTimer.Initialize(\"DelayTimer\", DELAY_INTERVA";
_delaytimer.Initialize(ba,"DelayTimer",_delay_interval);
 //BA.debugLineNum = 96;BA.debugLine="DelayTimer.Enabled = False";
_delaytimer.setEnabled(__c.False);
 //BA.debugLineNum = 98;BA.debugLine="Interpreter.Initialize(Me, \"Interpreter\")";
_interpreter._initialize(ba,this,"Interpreter");
 //BA.debugLineNum = 101;BA.debugLine="CurrentFilePath = File.DirApp";
_currentfilepath = __c.File.getDirApp();
 //BA.debugLineNum = 102;BA.debugLine="CurrentFileName = \"PROGRAM.BAS\"";
_currentfilename = "PROGRAM.BAS";
 //BA.debugLineNum = 103;BA.debugLine="ProgramModified = False";
_programmodified = __c.False;
 //BA.debugLineNum = 106;BA.debugLine="B4XPages.GetNativeParent(Me).Icon = xui.LoadBitma";
_b4xpages._getnativeparent /*anywheresoftware.b4j.objects.Form*/ (this).setIcon((javafx.scene.image.Image)(_xui.LoadBitmap(__c.File.getDirAssets(),"Icon.png").getObject()));
 //BA.debugLineNum = 109;BA.debugLine="InitializeKeyboardShortcuts";
_initializekeyboardshortcuts();
 //BA.debugLineNum = 111;BA.debugLine="InitializeUIStyle";
_initializeuistyle();
 //BA.debugLineNum = 114;BA.debugLine="taEditor.As(TextArea).Editable = True";
((anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper(), (javafx.scene.control.TextArea)(_taeditor.getObject()))).setEditable(__c.True);
 //BA.debugLineNum = 115;BA.debugLine="taOutput.As(TextArea).Editable = False";
((anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper(), (javafx.scene.control.TextArea)(_taoutput.getObject()))).setEditable(__c.False);
 //BA.debugLineNum = 117;BA.debugLine="ComboBoxSetPromptText(cbCommands, \"Enter BASIC co";
_comboboxsetprompttext(_cbcommands,"Enter BASIC command...");
 //BA.debugLineNum = 120;BA.debugLine="lblStatus.Text = \"READY\"";
_lblstatus.setText("READY");
 //BA.debugLineNum = 122;BA.debugLine="UpdatePageTitle";
_updatepagetitle();
 //BA.debugLineNum = 124;BA.debugLine="ShowWelcomMessage";
_showwelcommessage();
 //BA.debugLineNum = 125;BA.debugLine="End Sub";
return "";
}
public String  _cbcommands_selectedindexchanged(int _index,Object _value) throws Exception{
 //BA.debugLineNum = 359;BA.debugLine="Private Sub cbCommands_SelectedIndexChanged(Index";
 //BA.debugLineNum = 361;BA.debugLine="End Sub";
return "";
}
public String  _cbcommands_valuechanged(Object _value) throws Exception{
 //BA.debugLineNum = 352;BA.debugLine="Private Sub cbCommands_ValueChanged (Value As Obje";
 //BA.debugLineNum = 353;BA.debugLine="If Value.As(String).Length = 0 Then Return";
if ((BA.ObjectToString(_value)).length()==0) { 
if (true) return "";};
 //BA.debugLineNum = 355;BA.debugLine="ProcessInput";
_processinput();
 //BA.debugLineNum = 356;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 26;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 28;BA.debugLine="Private APPNAME As String = \"BASIC-58\"";
_appname = "BASIC-58";
 //BA.debugLineNum = 29;BA.debugLine="Private APPVERSION As String = \"v1.0.0 (Build 202";
_appversion = "v1.0.0 (Build 20261119)";
 //BA.debugLineNum = 30;BA.debugLine="Private APPCOPYRIGHT As String = \"Copyright (c) 2";
_appcopyright = "Copyright (c) 2026 Robert W.B. Linn - MIT Licence";
 //BA.debugLineNum = 33;BA.debugLine="Private fx As JFX";
_fx = new anywheresoftware.b4j.objects.JFX();
 //BA.debugLineNum = 34;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 37;BA.debugLine="Private Root As B4XView";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private pnToolbar As B4XView";
_pntoolbar = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private lblToolbar As B4XView";
_lbltoolbar = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private cbCommands As ComboBox";
_cbcommands = new anywheresoftware.b4j.objects.ComboBoxWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private taEditor As B4XView";
_taeditor = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Private taOutput As B4XView";
_taoutput = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private lblOutput As B4XView";
_lbloutput = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private lblEditor As B4XView";
_lbleditor = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private pnEditor As B4XView";
_pneditor = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private pnOutput As B4XView";
_pnoutput = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private lblStatus As B4XView";
_lblstatus = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 50;BA.debugLine="Private DesignerUtils As DDD";
_designerutils = new de.rwblinn.basic58.ddd();
 //BA.debugLineNum = 53;BA.debugLine="Private CurrentFileName As String";
_currentfilename = "";
 //BA.debugLineNum = 54;BA.debugLine="Private CurrentFilePath As String";
_currentfilepath = "";
 //BA.debugLineNum = 55;BA.debugLine="Private ProgramModified As Boolean";
_programmodified = false;
 //BA.debugLineNum = 56;BA.debugLine="Private LoadingProgram As Boolean";
_loadingprogram = false;
 //BA.debugLineNum = 57;BA.debugLine="Private UpdatingEditor As Boolean";
_updatingeditor = false;
 //BA.debugLineNum = 61;BA.debugLine="Private Interpreter As B58Interpreter";
_interpreter = new b4j.example.b58interpreter();
 //BA.debugLineNum = 64;BA.debugLine="Private Serial As B58Serial";
_serial = new b4j.example.b58serial();
 //BA.debugLineNum = 67;BA.debugLine="Private System As B58System";
_system = new b4j.example.b58system();
 //BA.debugLineNum = 70;BA.debugLine="Private DelayTimer As Timer";
_delaytimer = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 71;BA.debugLine="Private DELAY_INTERVAL As Long = 100";
_delay_interval = (long) (100);
 //BA.debugLineNum = 74;BA.debugLine="Private bc As ByteConverter";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public String  _comboboxsetprompttext(anywheresoftware.b4j.objects.ComboBoxWrapper _box,String _text) throws Exception{
anywheresoftware.b4j.object.JavaObject _jocb = null;
 //BA.debugLineNum = 884;BA.debugLine="Public Sub ComboBoxSetPromptText(box As ComboBox,";
 //BA.debugLineNum = 885;BA.debugLine="Dim joCB As JavaObject = box";
_jocb = new anywheresoftware.b4j.object.JavaObject();
_jocb = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_box.getObject()));
 //BA.debugLineNum = 886;BA.debugLine="joCB.RunMethod(\"setPromptText\", Array(text))";
_jocb.RunMethod("setPromptText",new Object[]{(Object)(_text)});
 //BA.debugLineNum = 887;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _confirmdiscardchanges() throws Exception{
ResumableSub_ConfirmDiscardChanges rsub = new ResumableSub_ConfirmDiscardChanges(this);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_ConfirmDiscardChanges extends BA.ResumableSub {
public ResumableSub_ConfirmDiscardChanges(de.rwblinn.basic58.b4xmainpage parent) {
this.parent = parent;
}
de.rwblinn.basic58.b4xmainpage parent;
int _result;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
 //BA.debugLineNum = 669;BA.debugLine="If ProgramModified = False Then Return True";
if (true) break;

case 1:
//if
this.state = 6;
if (parent._programmodified==parent.__c.False) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.True));return;};
if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 671;BA.debugLine="xui.Msgbox2Async(\"Discard unsaved changes?\", \"CON";
parent._xui.Msgbox2Async(ba,"Discard unsaved changes?","CONFIRM","Yes","","No",(javafx.scene.image.Image)(parent.__c.Null));
 //BA.debugLineNum = 673;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
parent.__c.WaitFor("msgbox_result", ba, this, null);
this.state = 7;
return;
case 7:
//C
this.state = -1;
_result = (int) result[0];
;
 //BA.debugLineNum = 675;BA.debugLine="Return Result = xui.DialogResponse_Positive";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_result==parent._xui.DialogResponse_Positive));return;};
 //BA.debugLineNum = 676;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _msgbox_result(int _result) throws Exception{
}
public String  _delaytimer_tick() throws Exception{
 //BA.debugLineNum = 814;BA.debugLine="Private Sub DelayTimer_Tick";
 //BA.debugLineNum = 815;BA.debugLine="DelayTimer.Enabled = False";
_delaytimer.setEnabled(__c.False);
 //BA.debugLineNum = 816;BA.debugLine="Interpreter.ResumeProgram";
_interpreter._resumeprogram();
 //BA.debugLineNum = 817;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 77;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return "";
}
public String  _initializekeyboardshortcuts() throws Exception{
anywheresoftware.b4j.agraham.reflection.Reflection _r = null;
 //BA.debugLineNum = 220;BA.debugLine="Private Sub InitializeKeyboardShortcuts";
 //BA.debugLineNum = 221;BA.debugLine="Dim R As Reflector";
_r = new anywheresoftware.b4j.agraham.reflection.Reflection();
 //BA.debugLineNum = 222;BA.debugLine="R.Target = B4XPages.GetNativeParent(Me).RootPane";
_r.Target = (Object)(_b4xpages._getnativeparent /*anywheresoftware.b4j.objects.Form*/ (this).getRootPane().getObject());
 //BA.debugLineNum = 223;BA.debugLine="R.AddEventFilter(\"MainKeyPressed\", \"javafx.scene.";
_r.AddEventFilter(ba,"MainKeyPressed","javafx.scene.input.KeyEvent.KEY_PRESSED");
 //BA.debugLineNum = 224;BA.debugLine="End Sub";
return "";
}
public String  _initializeuistyle() throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _editor = null;
 //BA.debugLineNum = 140;BA.debugLine="Private Sub InitializeUIStyle";
 //BA.debugLineNum = 142;BA.debugLine="B4XPages.GetNativeParent(Me).Stylesheets.Add(File";
_b4xpages._getnativeparent /*anywheresoftware.b4j.objects.Form*/ (this).getStylesheets().Add((Object)(__c.File.GetUri(__c.File.getDirAssets(),"Main.css")));
 //BA.debugLineNum = 147;BA.debugLine="CSSUtils.SetBackgroundColor(Root, fx.Colors.From3";
_cssutils._setbackgroundcolor((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_root.getObject())),(anywheresoftware.b4j.objects.JFX.PaintWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.JFX.PaintWrapper(), (javafx.scene.paint.Paint)(_fx.Colors.From32Bit(((int)0xffdcd6c8)))));
 //BA.debugLineNum = 153;BA.debugLine="lblEditor.Font = fx.CreateFont(\"Consolas\", 16, Tr";
_lbleditor.setFont((anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont(), (javafx.scene.text.Font)(_fx.CreateFont("Consolas",16,__c.True,__c.False).getObject())));
 //BA.debugLineNum = 154;BA.debugLine="CSSUtils.SetStyleProperty(lblEditor, \"-fx-text-fi";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_lbleditor.getObject())),"-fx-text-fill","#4A4845");
 //BA.debugLineNum = 159;BA.debugLine="pnEditor.SetColorAndBorder(xui.Color_ARGB(0xFF,0x";
_pneditor.SetColorAndBorder(_xui.Color_ARGB(((int)0xff),((int)0xdc),((int)0xd6),((int)0xc8)),2,_xui.Color_LightGray,5);
 //BA.debugLineNum = 160;BA.debugLine="CSSUtils.SetStyleProperty(taEditor, \"-fx-control-";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_taeditor.getObject())),"-fx-control-inner-background","#191713");
 //BA.debugLineNum = 161;BA.debugLine="CSSUtils.SetStyleProperty(taEditor, \"-fx-text-fil";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_taeditor.getObject())),"-fx-text-fill","#FFBF69");
 //BA.debugLineNum = 162;BA.debugLine="CSSUtils.SetStyleProperty(taEditor, \"-fx-highligh";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_taeditor.getObject())),"-fx-highlight-fill","#80613A");
 //BA.debugLineNum = 163;BA.debugLine="CSSUtils.SetStyleProperty(taEditor, \"-fx-highligh";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_taeditor.getObject())),"-fx-highlight-text-fill","#FFFFFF");
 //BA.debugLineNum = 164;BA.debugLine="CSSUtils.SetStyleProperty(taEditor, \"-fx-border-c";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_taeditor.getObject())),"-fx-border-color","#80613A");
 //BA.debugLineNum = 165;BA.debugLine="CSSUtils.SetStyleProperty(taEditor, \"-fx-border-w";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_taeditor.getObject())),"-fx-border-width","2");
 //BA.debugLineNum = 166;BA.debugLine="taEditor.Font = fx.CreateFont(\"Consolas\", 16, Fal";
_taeditor.setFont((anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont(), (javafx.scene.text.Font)(_fx.CreateFont("Consolas",16,__c.False,__c.False).getObject())));
 //BA.debugLineNum = 171;BA.debugLine="lblOutput.Font = fx.CreateFont(\"Consolas\", 14, Tr";
_lbloutput.setFont((anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont(), (javafx.scene.text.Font)(_fx.CreateFont("Consolas",14,__c.True,__c.False).getObject())));
 //BA.debugLineNum = 172;BA.debugLine="CSSUtils.SetStyleProperty(lblOutput, \"-fx-text-fi";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_lbloutput.getObject())),"-fx-text-fill","#4A4845");
 //BA.debugLineNum = 177;BA.debugLine="pnOutput.SetColorAndBorder(xui.Color_ARGB(0xFF,0x";
_pnoutput.SetColorAndBorder(_xui.Color_ARGB(((int)0xff),((int)0xdc),((int)0xd6),((int)0xc8)),2,_xui.Color_LightGray,5);
 //BA.debugLineNum = 178;BA.debugLine="CSSUtils.SetStyleProperty(taOutput, \"-fx-control-";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_taoutput.getObject())),"-fx-control-inner-background","#191713");
 //BA.debugLineNum = 179;BA.debugLine="CSSUtils.SetStyleProperty(taOutput, \"-fx-text-fil";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_taoutput.getObject())),"-fx-text-fill","#FFBF69");
 //BA.debugLineNum = 180;BA.debugLine="CSSUtils.SetStyleProperty(taOutput, \"-fx-highligh";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_taoutput.getObject())),"-fx-highlight-fill","#80613A");
 //BA.debugLineNum = 181;BA.debugLine="CSSUtils.SetStyleProperty(taOutput, \"-fx-highligh";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_taoutput.getObject())),"-fx-highlight-text-fill","#FFFFFF");
 //BA.debugLineNum = 182;BA.debugLine="CSSUtils.SetStyleProperty(taOutput, \"-fx-border-c";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_taoutput.getObject())),"-fx-border-color","#80613A");
 //BA.debugLineNum = 183;BA.debugLine="CSSUtils.SetStyleProperty(taOutput, \"-fx-border-w";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_taoutput.getObject())),"-fx-border-width","2");
 //BA.debugLineNum = 184;BA.debugLine="taOutput.Font = fx.CreateFont(\"Consolas\", 16, Fal";
_taoutput.setFont((anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont(), (javafx.scene.text.Font)(_fx.CreateFont("Consolas",16,__c.False,__c.False).getObject())));
 //BA.debugLineNum = 189;BA.debugLine="Dim JO As JavaObject = cbCommands";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_cbcommands.getObject()));
 //BA.debugLineNum = 190;BA.debugLine="Dim Editor As JavaObject = JO.RunMethod(\"getEdito";
_editor = new anywheresoftware.b4j.object.JavaObject();
_editor = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_jo.RunMethod("getEditor",(Object[])(__c.Null))));
 //BA.debugLineNum = 191;BA.debugLine="Editor.RunMethod(\"setStyle\", Array(\"-fx-font-fami";
_editor.RunMethod("setStyle",new Object[]{(Object)("-fx-font-family: 'Consolas'; -fx-font-size: 16px;")});
 //BA.debugLineNum = 193;BA.debugLine="CSSUtils.SetStyleProperty(cbCommands, \"-fx-backgr";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_cbcommands.getObject())),"-fx-background-color","#211B13");
 //BA.debugLineNum = 194;BA.debugLine="CSSUtils.SetStyleProperty(cbCommands, \"-fx-text-f";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_cbcommands.getObject())),"-fx-text-fill","#FFBF69");
 //BA.debugLineNum = 195;BA.debugLine="CSSUtils.SetStyleProperty(cbCommands, \"-fx-prompt";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_cbcommands.getObject())),"-fx-prompt-text-fill","#C9954A");
 //BA.debugLineNum = 196;BA.debugLine="CSSUtils.SetStyleProperty(cbCommands, \"-fx-border";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_cbcommands.getObject())),"-fx-border-color","#80613A");
 //BA.debugLineNum = 197;BA.debugLine="CSSUtils.SetStyleProperty(cbCommands, \"-fx-border";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_cbcommands.getObject())),"-fx-border-width","1");
 //BA.debugLineNum = 202;BA.debugLine="CSSUtils.SetBackgroundColor(pnToolbar, fx.Colors.";
_cssutils._setbackgroundcolor((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_pntoolbar.getObject())),(anywheresoftware.b4j.objects.JFX.PaintWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.JFX.PaintWrapper(), (javafx.scene.paint.Paint)(_fx.Colors.From32Bit(((int)0xffdcd6c8)))));
 //BA.debugLineNum = 203;BA.debugLine="lblToolbar.Font = fx.CreateFont(\"Consolas\", 16, T";
_lbltoolbar.setFont((anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont(), (javafx.scene.text.Font)(_fx.CreateFont("Consolas",16,__c.True,__c.False).getObject())));
 //BA.debugLineNum = 204;BA.debugLine="CSSUtils.SetStyleProperty(lblToolbar, \"-fx-text-f";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_lbltoolbar.getObject())),"-fx-text-fill","#4A4845");
 //BA.debugLineNum = 209;BA.debugLine="lblStatus.Font = fx.CreateFont(\"Consolas\", 12, Tr";
_lblstatus.setFont((anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont(), (javafx.scene.text.Font)(_fx.CreateFont("Consolas",12,__c.True,__c.False).getObject())));
 //BA.debugLineNum = 210;BA.debugLine="CSSUtils.SetStyleProperty(lblStatus, \"-fx-text-fi";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_lblstatus.getObject())),"-fx-text-fill","#4A4845");
 //BA.debugLineNum = 211;BA.debugLine="CSSUtils.SetStyleProperty(lblStatus, \"-fx-backgro";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_lblstatus.getObject())),"-fx-background-color","#D2CDC6");
 //BA.debugLineNum = 213;BA.debugLine="End Sub";
return "";
}
public String  _interpreter_hardwarecommand(String _command) throws Exception{
 //BA.debugLineNum = 735;BA.debugLine="Private Sub Interpreter_HardwareCommand(Command As";
 //BA.debugLineNum = 736;BA.debugLine="Serial.ExecuteCommand(Command)";
_serial._executecommand(_command);
 //BA.debugLineNum = 737;BA.debugLine="End Sub";
return "";
}
public void  _interpreter_output(String _value,boolean _newline) throws Exception{
ResumableSub_Interpreter_Output rsub = new ResumableSub_Interpreter_Output(this,_value,_newline);
rsub.resume(ba, null);
}
public static class ResumableSub_Interpreter_Output extends BA.ResumableSub {
public ResumableSub_Interpreter_Output(de.rwblinn.basic58.b4xmainpage parent,String _value,boolean _newline) {
this.parent = parent;
this._value = _value;
this._newline = _newline;
}
de.rwblinn.basic58.b4xmainpage parent;
String _value;
boolean _newline;
anywheresoftware.b4j.object.JavaObject _nativetextarea = null;
String _s = "";
boolean _success;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 711;BA.debugLine="Dim NativeTextArea As JavaObject = taOutput";
_nativetextarea = new anywheresoftware.b4j.object.JavaObject();
_nativetextarea = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(parent._taoutput.getObject()));
 //BA.debugLineNum = 712;BA.debugLine="Dim s As String = Value";
_s = _value;
 //BA.debugLineNum = 714;BA.debugLine="If NewLine Then s = s & CRLF";
if (true) break;

case 1:
//if
this.state = 6;
if (_newline) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
_s = _s+parent.__c.CRLF;
if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 716;BA.debugLine="NativeTextArea.RunMethod(\"appendText\", Array(s))";
_nativetextarea.RunMethod("appendText",new Object[]{(Object)(_s)});
 //BA.debugLineNum = 717;BA.debugLine="NativeTextArea.RunMethod(\"positionCaret\", Array(N";
_nativetextarea.RunMethod("positionCaret",new Object[]{_nativetextarea.RunMethod("getLength",(Object[])(parent.__c.Null))});
 //BA.debugLineNum = 719;BA.debugLine="Wait For (ScrollTextToBottom(taOutput)) Complete";
parent.__c.WaitFor("complete", ba, this, parent._scrolltexttobottom(parent._taoutput));
this.state = 7;
return;
case 7:
//C
this.state = -1;
_success = (boolean) result[0];
;
 //BA.debugLineNum = 720;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _complete(boolean _success) throws Exception{
}
public String  _interpreter_programrenumbered(String _programtext) throws Exception{
 //BA.debugLineNum = 743;BA.debugLine="Private Sub Interpreter_ProgramRenumbered(ProgramT";
 //BA.debugLineNum = 744;BA.debugLine="taEditor.Text = ProgramText";
_taeditor.setText(_programtext);
 //BA.debugLineNum = 745;BA.debugLine="End Sub";
return "";
}
public String  _interpreter_ready() throws Exception{
 //BA.debugLineNum = 724;BA.debugLine="Private Sub Interpreter_Ready";
 //BA.debugLineNum = 725;BA.debugLine="lblStatus.Text = \"READY\"";
_lblstatus.setText("READY");
 //BA.debugLineNum = 726;BA.debugLine="End Sub";
return "";
}
public String  _interpreter_systemcommand(String _command) throws Exception{
 //BA.debugLineNum = 739;BA.debugLine="Private Sub Interpreter_SystemCommand(Command As S";
 //BA.debugLineNum = 740;BA.debugLine="System.ExecuteCommand(Command)";
_system._executecommand(_command);
 //BA.debugLineNum = 741;BA.debugLine="End Sub";
return "";
}
public String  _interpreter_waitingfordelay() throws Exception{
 //BA.debugLineNum = 730;BA.debugLine="Private Sub Interpreter_WaitingForDelay";
 //BA.debugLineNum = 731;BA.debugLine="DelayTimer.Interval = Interpreter.GetDelayMillise";
_delaytimer.setInterval((long) (_interpreter._getdelaymilliseconds()));
 //BA.debugLineNum = 732;BA.debugLine="DelayTimer.Enabled = True";
_delaytimer.setEnabled(__c.True);
 //BA.debugLineNum = 733;BA.debugLine="End Sub";
return "";
}
public void  _load() throws Exception{
ResumableSub_Load rsub = new ResumableSub_Load(this);
rsub.resume(ba, null);
}
public static class ResumableSub_Load extends BA.ResumableSub {
public ResumableSub_Load(de.rwblinn.basic58.b4xmainpage parent) {
this.parent = parent;
}
de.rwblinn.basic58.b4xmainpage parent;
String _filename = "";
anywheresoftware.b4j.objects.FileChooserWrapper _filechoose = null;
boolean _confirmed;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 618;BA.debugLine="Dim Filename As String";
_filename = "";
 //BA.debugLineNum = 619;BA.debugLine="Dim FileChoose As FileChooser";
_filechoose = new anywheresoftware.b4j.objects.FileChooserWrapper();
 //BA.debugLineNum = 620;BA.debugLine="FileChoose.Initialize";
_filechoose.Initialize();
 //BA.debugLineNum = 621;BA.debugLine="FileChoose.InitialDirectory = CurrentFilePath";
_filechoose.setInitialDirectory(parent._currentfilepath);
 //BA.debugLineNum = 622;BA.debugLine="FileChoose.SetExtensionFilter(\"BAS\", Array As Str";
_filechoose.SetExtensionFilter("BAS",anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"*.bas"}));
 //BA.debugLineNum = 623;BA.debugLine="FileChoose.Title = \"Load Program\"";
_filechoose.setTitle("Load Program");
 //BA.debugLineNum = 624;BA.debugLine="Filename = FileChoose.ShowOpen(B4XPages.GetNative";
_filename = _filechoose.ShowOpen(parent._b4xpages._getnativeparent /*anywheresoftware.b4j.objects.Form*/ (parent));
 //BA.debugLineNum = 625;BA.debugLine="If Filename.Length = 0 Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_filename.length()==0) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 626;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 4:
//C
this.state = 5;
;
 //BA.debugLineNum = 628;BA.debugLine="Wait For (ConfirmDiscardChanges) Complete (Confir";
parent.__c.WaitFor("complete", ba, this, parent._confirmdiscardchanges());
this.state = 17;
return;
case 17:
//C
this.state = 5;
_confirmed = (boolean) result[0];
;
 //BA.debugLineNum = 629;BA.debugLine="If Confirmed = False Then Return";
if (true) break;

case 5:
//if
this.state = 10;
if (_confirmed==parent.__c.False) { 
this.state = 7;
;}if (true) break;

case 7:
//C
this.state = 10;
if (true) return ;
if (true) break;

case 10:
//C
this.state = 11;
;
 //BA.debugLineNum = 630;BA.debugLine="Try";
if (true) break;

case 11:
//try
this.state = 16;
this.catchState = 15;
this.state = 13;
if (true) break;

case 13:
//C
this.state = 16;
this.catchState = 15;
 //BA.debugLineNum = 631;BA.debugLine="CurrentFileName = Utils.GetFileName(Filename).To";
parent._currentfilename = parent._utils._getfilename(_filename).toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 632;BA.debugLine="CurrentFilePath = Utils.GetFilePath(Filename)";
parent._currentfilepath = parent._utils._getfilepath(_filename);
 //BA.debugLineNum = 634;BA.debugLine="LoadProgram(CurrentFileName)";
parent._loadprogram(parent._currentfilename);
 if (true) break;

case 15:
//C
this.state = 16;
this.catchState = 0;
 //BA.debugLineNum = 636;BA.debugLine="Log(\"[Load][E] Failed - \" & LastException.Messag";
parent.__c.LogImpl("31900563","[Load][E] Failed - "+parent.__c.LastException(ba).getMessage(),0);
 if (true) break;
if (true) break;

case 16:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 638;BA.debugLine="Return";
if (true) return ;
 //BA.debugLineNum = 639;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
ba.setLastException(e0);}
            }
        }
    }
}
public String  _loadeditorprogram() throws Exception{
 //BA.debugLineNum = 454;BA.debugLine="Private Sub LoadEditorProgram";
 //BA.debugLineNum = 455;BA.debugLine="Interpreter.LoadProgram(taEditor.Text)";
_interpreter._loadprogram(_taeditor.getText());
 //BA.debugLineNum = 456;BA.debugLine="End Sub";
return "";
}
public String  _loadprogram(String _filename) throws Exception{
int _dotposition = 0;
anywheresoftware.b4a.objects.collections.List _savedlines = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _editortext = null;
String _savedline = "";
String _loadedtext = "";
 //BA.debugLineNum = 548;BA.debugLine="Private Sub LoadProgram(FileName As String)";
 //BA.debugLineNum = 549;BA.debugLine="If FileName = \"\" Then";
if ((_filename).equals("")) { 
 //BA.debugLineNum = 550;BA.debugLine="FileName = \"PROGRAM.BAS\"";
_filename = "PROGRAM.BAS";
 //BA.debugLineNum = 551;BA.debugLine="CurrentFileName = FileName";
_currentfilename = _filename;
 };
 //BA.debugLineNum = 554;BA.debugLine="If FileName.Contains(\"/\") Or FileName.Contains(\"\\";
if (_filename.contains("/") || _filename.contains("\\")) { 
 //BA.debugLineNum = 555;BA.debugLine="PrintText(taOutput, $\"?INVALID FILE NAME - ${Fil";
_printtext(_taoutput,("?INVALID FILE NAME - "+__c.SmartStringFormatter("",(Object)(_filename))+""));
 //BA.debugLineNum = 556;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 559;BA.debugLine="FileName = FileName.Trim";
_filename = _filename.trim();
 //BA.debugLineNum = 561;BA.debugLine="If FileName.ToUpperCase.EndsWith(\".BAS\") = False";
if (_filename.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale).endsWith(".BAS")==__c.False) { 
 //BA.debugLineNum = 562;BA.debugLine="Dim DotPosition As Int = FileName.LastIndexOf(\".";
_dotposition = _filename.lastIndexOf(".");
 //BA.debugLineNum = 563;BA.debugLine="If DotPosition > 0 Then";
if (_dotposition>0) { 
 //BA.debugLineNum = 564;BA.debugLine="FileName = FileName.SubString2(0, DotPosition)";
_filename = _filename.substring((int) (0),_dotposition);
 };
 //BA.debugLineNum = 566;BA.debugLine="FileName = FileName & \".BAS\"";
_filename = _filename+".BAS";
 };
 //BA.debugLineNum = 569;BA.debugLine="FileName = FileName.ToUpperCase";
_filename = _filename.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 571;BA.debugLine="If File.Exists(CurrentFilePath, FileName) = False";
if (__c.File.Exists(_currentfilepath,_filename)==__c.False) { 
 //BA.debugLineNum = 572;BA.debugLine="PrintText(taOutput, \"?FILE NOT FOUND: \" & FileNa";
_printtext(_taoutput,"?FILE NOT FOUND: "+_filename);
 //BA.debugLineNum = 573;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 576;BA.debugLine="Try";
try { //BA.debugLineNum = 577;BA.debugLine="Dim SavedLines As List = File.ReadList(CurrentFi";
_savedlines = new anywheresoftware.b4a.objects.collections.List();
_savedlines = __c.File.ReadList(_currentfilepath,_filename);
 //BA.debugLineNum = 580;BA.debugLine="Dim EditorText As StringBuilder";
_editortext = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 581;BA.debugLine="EditorText.Initialize";
_editortext.Initialize();
 //BA.debugLineNum = 583;BA.debugLine="For Each SavedLine As String In SavedLines";
{
final anywheresoftware.b4a.BA.IterableList group26 = _savedlines;
final int groupLen26 = group26.getSize()
;int index26 = 0;
;
for (; index26 < groupLen26;index26++){
_savedline = BA.ObjectToString(group26.Get(index26));
 //BA.debugLineNum = 584;BA.debugLine="If EditorText.Length > 0 Then";
if (_editortext.getLength()>0) { 
 //BA.debugLineNum = 585;BA.debugLine="EditorText.Append(CRLF)";
_editortext.Append(__c.CRLF);
 };
 //BA.debugLineNum = 588;BA.debugLine="EditorText.Append(SavedLine)";
_editortext.Append(_savedline);
 }
};
 //BA.debugLineNum = 592;BA.debugLine="Dim LoadedText As String = Utils.ConvertBasicTex";
_loadedtext = _utils._convertbasictexttoupper(_editortext.ToString());
 //BA.debugLineNum = 594;BA.debugLine="If taEditor.Text <> LoadedText Then";
if ((_taeditor.getText()).equals(_loadedtext) == false) { 
 //BA.debugLineNum = 595;BA.debugLine="LoadingProgram = True";
_loadingprogram = __c.True;
 //BA.debugLineNum = 596;BA.debugLine="taEditor.Text = LoadedText";
_taeditor.setText(_loadedtext);
 }else {
 //BA.debugLineNum = 598;BA.debugLine="LoadingProgram = False";
_loadingprogram = __c.False;
 };
 //BA.debugLineNum = 602;BA.debugLine="Interpreter.LoadProgram(taEditor.Text)";
_interpreter._loadprogram(_taeditor.getText());
 //BA.debugLineNum = 604;BA.debugLine="CurrentFileName = FileName.ToUpperCase";
_currentfilename = _filename.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 605;BA.debugLine="ProgramModified = False";
_programmodified = __c.False;
 //BA.debugLineNum = 606;BA.debugLine="UpdatePageTitle";
_updatepagetitle();
 //BA.debugLineNum = 608;BA.debugLine="PrintText(taOutput, \"LOADED: \" & CurrentFileName";
_printtext(_taoutput,"LOADED: "+_currentfilename);
 //BA.debugLineNum = 609;BA.debugLine="PrintText(taOutput, \"LINES: \" & Interpreter.GetP";
_printtext(_taoutput,"LINES: "+BA.NumberToString(_interpreter._getprogramlinecount()));
 } 
       catch (Exception e46) {
			ba.setLastException(e46); //BA.debugLineNum = 611;BA.debugLine="LoadingProgram = False";
_loadingprogram = __c.False;
 //BA.debugLineNum = 612;BA.debugLine="PrintText(taOutput, \"?LOAD ERROR\")";
_printtext(_taoutput,"?LOAD ERROR");
 //BA.debugLineNum = 613;BA.debugLine="Log($\"[LoadProgram][E] ${LastException}\"$)";
__c.LogImpl("31835073",("[LoadProgram][E] "+__c.SmartStringFormatter("",(Object)(__c.LastException(ba).getObject()))+""),0);
 };
 //BA.debugLineNum = 615;BA.debugLine="End Sub";
return "";
}
public String  _mainkeypressed_filter(anywheresoftware.b4j.objects.NodeWrapper.ConcreteEventWrapper _e) throws Exception{
anywheresoftware.b4j.agraham.reflection.Reflection _r = null;
String _keycode = "";
boolean _controldown = false;
 //BA.debugLineNum = 226;BA.debugLine="Private Sub MainKeyPressed_Filter(E As Event)";
 //BA.debugLineNum = 227;BA.debugLine="Dim R As Reflector";
_r = new anywheresoftware.b4j.agraham.reflection.Reflection();
 //BA.debugLineNum = 228;BA.debugLine="R.Target = E";
_r.Target = (Object)(_e.getObject());
 //BA.debugLineNum = 230;BA.debugLine="Dim KeyCode As String = R.RunMethod(\"getCode\")";
_keycode = BA.ObjectToString(_r.RunMethod("getCode"));
 //BA.debugLineNum = 231;BA.debugLine="Dim ControlDown As Boolean = R.RunMethod(\"isCo";
_controldown = BA.ObjectToBoolean(_r.RunMethod("isControlDown"));
 //BA.debugLineNum = 233;BA.debugLine="If ControlDown Then";
if (_controldown) { 
 //BA.debugLineNum = 234;BA.debugLine="Select KeyCode";
switch (BA.switchObjectToInt(_keycode,"N","O","S")) {
case 0: 
case 1: 
case 2: {
 //BA.debugLineNum = 236;BA.debugLine="R.RunMethod(\"consume\")";
_r.RunMethod("consume");
 //BA.debugLineNum = 238;BA.debugLine="Select KeyCode";
switch (BA.switchObjectToInt(_keycode,"N","O","S")) {
case 0: {
 //BA.debugLineNum = 240;BA.debugLine="NewProgram";
_newprogram();
 break; }
case 1: {
 //BA.debugLineNum = 242;BA.debugLine="Load";
_load();
 break; }
case 2: {
 //BA.debugLineNum = 244;BA.debugLine="Save";
_save();
 break; }
}
;
 break; }
}
;
 }else {
 //BA.debugLineNum = 249;BA.debugLine="Select KeyCode";
switch (BA.switchObjectToInt(_keycode,"F1","F4","F5","F6","F7","F8","F9","F10")) {
case 0: {
 //BA.debugLineNum = 251;BA.debugLine="R.RunMethod(\"consume\")";
_r.RunMethod("consume");
 //BA.debugLineNum = 252;BA.debugLine="ShowHelp";
_showhelp();
 break; }
case 1: {
 //BA.debugLineNum = 255;BA.debugLine="R.RunMethod(\"consume\")";
_r.RunMethod("consume");
 //BA.debugLineNum = 256;BA.debugLine="ProcessCommand(\"RENUM\")";
_processcommand("RENUM");
 break; }
case 2: {
 //BA.debugLineNum = 259;BA.debugLine="R.RunMethod(\"consume\")";
_r.RunMethod("consume");
 //BA.debugLineNum = 260;BA.debugLine="LoadEditorProgram";
_loadeditorprogram();
 //BA.debugLineNum = 261;BA.debugLine="Interpreter.RunProgram";
_interpreter._runprogram();
 break; }
case 3: {
 //BA.debugLineNum = 264;BA.debugLine="R.RunMethod(\"consume\")";
_r.RunMethod("consume");
 //BA.debugLineNum = 265;BA.debugLine="ProcessCommand(\"LIST\")";
_processcommand("LIST");
 break; }
case 4: {
 //BA.debugLineNum = 268;BA.debugLine="R.RunMethod(\"consume\")";
_r.RunMethod("consume");
 //BA.debugLineNum = 269;BA.debugLine="Load";
_load();
 break; }
case 5: {
 //BA.debugLineNum = 272;BA.debugLine="R.RunMethod(\"consume\")";
_r.RunMethod("consume");
 //BA.debugLineNum = 273;BA.debugLine="Save";
_save();
 break; }
case 6: {
 //BA.debugLineNum = 276;BA.debugLine="R.RunMethod(\"consume\")";
_r.RunMethod("consume");
 //BA.debugLineNum = 277;BA.debugLine="NewProgram";
_newprogram();
 break; }
case 7: {
 //BA.debugLineNum = 280;BA.debugLine="R.RunMethod(\"consume\")";
_r.RunMethod("consume");
 //BA.debugLineNum = 281;BA.debugLine="taOutput.Text = \"\"";
_taoutput.setText("");
 break; }
}
;
 };
 //BA.debugLineNum = 284;BA.debugLine="End Sub";
return "";
}
public void  _newprogram() throws Exception{
ResumableSub_NewProgram rsub = new ResumableSub_NewProgram(this);
rsub.resume(ba, null);
}
public static class ResumableSub_NewProgram extends BA.ResumableSub {
public ResumableSub_NewProgram(de.rwblinn.basic58.b4xmainpage parent) {
this.parent = parent;
}
de.rwblinn.basic58.b4xmainpage parent;
boolean _confirmed;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 464;BA.debugLine="If ProgramModified Then";
if (true) break;

case 1:
//if
this.state = 10;
if (parent._programmodified) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 465;BA.debugLine="Wait For (ConfirmDiscardChanges) Complete (Confi";
parent.__c.WaitFor("complete", ba, this, parent._confirmdiscardchanges());
this.state = 11;
return;
case 11:
//C
this.state = 4;
_confirmed = (boolean) result[0];
;
 //BA.debugLineNum = 466;BA.debugLine="If Confirmed = False Then Return";
if (true) break;

case 4:
//if
this.state = 9;
if (_confirmed==parent.__c.False) { 
this.state = 6;
;}if (true) break;

case 6:
//C
this.state = 9;
if (true) return ;
if (true) break;

case 9:
//C
this.state = 10;
;
 if (true) break;

case 10:
//C
this.state = -1;
;
 //BA.debugLineNum = 470;BA.debugLine="LoadingProgram = True";
parent._loadingprogram = parent.__c.True;
 //BA.debugLineNum = 471;BA.debugLine="taEditor.Text = \"\"";
parent._taeditor.setText("");
 //BA.debugLineNum = 472;BA.debugLine="LoadingProgram = False";
parent._loadingprogram = parent.__c.False;
 //BA.debugLineNum = 475;BA.debugLine="Interpreter.ClearProgram";
parent._interpreter._clearprogram();
 //BA.debugLineNum = 476;BA.debugLine="taOutput.Text = \"\"";
parent._taoutput.setText("");
 //BA.debugLineNum = 479;BA.debugLine="CurrentFileName = \"PROGRAM.BAS\"";
parent._currentfilename = "PROGRAM.BAS";
 //BA.debugLineNum = 480;BA.debugLine="ProgramModified = False";
parent._programmodified = parent.__c.False;
 //BA.debugLineNum = 481;BA.debugLine="UpdatePageTitle";
parent._updatepagetitle();
 //BA.debugLineNum = 482;BA.debugLine="lblStatus.Text = \"READY\"";
parent._lblstatus.setText("READY");
 //BA.debugLineNum = 483;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _printtext(anywheresoftware.b4a.objects.B4XViewWrapper _target,String _value) throws Exception{
ResumableSub_PrintText rsub = new ResumableSub_PrintText(this,_target,_value);
rsub.resume(ba, null);
}
public static class ResumableSub_PrintText extends BA.ResumableSub {
public ResumableSub_PrintText(de.rwblinn.basic58.b4xmainpage parent,anywheresoftware.b4a.objects.B4XViewWrapper _target,String _value) {
this.parent = parent;
this._target = _target;
this._value = _value;
}
de.rwblinn.basic58.b4xmainpage parent;
anywheresoftware.b4a.objects.B4XViewWrapper _target;
String _value;
anywheresoftware.b4j.object.JavaObject _nativetextarea = null;
boolean _success;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 684;BA.debugLine="Dim NativeTextArea As JavaObject = Target";
_nativetextarea = new anywheresoftware.b4j.object.JavaObject();
_nativetextarea = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_target.getObject()));
 //BA.debugLineNum = 685;BA.debugLine="NativeTextArea.RunMethod(\"appendText\", Array(Valu";
_nativetextarea.RunMethod("appendText",new Object[]{(Object)(_value+parent.__c.CRLF)});
 //BA.debugLineNum = 686;BA.debugLine="NativeTextArea.RunMethod(\"positionCaret\", Array(N";
_nativetextarea.RunMethod("positionCaret",new Object[]{_nativetextarea.RunMethod("getLength",(Object[])(parent.__c.Null))});
 //BA.debugLineNum = 688;BA.debugLine="If Target.Tag = taOutput.Tag Then";
if (true) break;

case 1:
//if
this.state = 4;
if ((_target.getTag()).equals(parent._taoutput.getTag())) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 689;BA.debugLine="Wait For (ScrollTextToBottom(taOutput)) Complete";
parent.__c.WaitFor("complete", ba, this, parent._scrolltexttobottom(parent._taoutput));
this.state = 5;
return;
case 5:
//C
this.state = 4;
_success = (boolean) result[0];
;
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 691;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _processcommand(String _command) throws Exception{
ResumableSub_ProcessCommand rsub = new ResumableSub_ProcessCommand(this,_command);
rsub.resume(ba, null);
}
public static class ResumableSub_ProcessCommand extends BA.ResumableSub {
public ResumableSub_ProcessCommand(de.rwblinn.basic58.b4xmainpage parent,String _command) {
this.parent = parent;
this._command = _command;
}
de.rwblinn.basic58.b4xmainpage parent;
String _command;
String _uppercommand = "";
boolean _confirmed;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 387;BA.debugLine="Dim UpperCommand As String = Command.Trim.ToUpper";
_uppercommand = _command.trim().toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 389;BA.debugLine="Select Case True";
if (true) break;

case 1:
//select
this.state = 36;
switch (BA.switchObjectToInt(parent.__c.True,(_uppercommand).equals("HELP"),(_uppercommand).equals("SAVE") || _uppercommand.startsWith("SAVE "),(_uppercommand).equals("LOAD") || _uppercommand.startsWith("LOAD "),(_uppercommand).equals("CLS"),(_uppercommand).equals("NEW"),(_uppercommand).equals("RUN"),(_uppercommand).equals("BYE"),(_uppercommand).equals("BASIC-58"),_uppercommand.startsWith("@SYS"),_uppercommand.startsWith("@SER"),_uppercommand.startsWith("@"))) {
case 0: {
this.state = 3;
if (true) break;
}
case 1: {
this.state = 5;
if (true) break;
}
case 2: {
this.state = 7;
if (true) break;
}
case 3: {
this.state = 15;
if (true) break;
}
case 4: {
this.state = 17;
if (true) break;
}
case 5: {
this.state = 19;
if (true) break;
}
case 6: {
this.state = 21;
if (true) break;
}
case 7: {
this.state = 23;
if (true) break;
}
case 8: {
this.state = 25;
if (true) break;
}
case 9: {
this.state = 27;
if (true) break;
}
case 10: {
this.state = 29;
if (true) break;
}
default: {
this.state = 31;
if (true) break;
}
}
if (true) break;

case 3:
//C
this.state = 36;
 //BA.debugLineNum = 391;BA.debugLine="ShowHelp";
parent._showhelp();
 if (true) break;

case 5:
//C
this.state = 36;
 //BA.debugLineNum = 394;BA.debugLine="SaveProgram(Command.SubString(4).Trim, CurrentF";
parent._saveprogram(_command.substring((int) (4)).trim(),parent._currentfilepath);
 if (true) break;

case 7:
//C
this.state = 8;
 //BA.debugLineNum = 397;BA.debugLine="Wait For (ConfirmDiscardChanges) Complete (Conf";
parent.__c.WaitFor("complete", ba, this, parent._confirmdiscardchanges());
this.state = 37;
return;
case 37:
//C
this.state = 8;
_confirmed = (boolean) result[0];
;
 //BA.debugLineNum = 398;BA.debugLine="If Confirmed = False Then Return";
if (true) break;

case 8:
//if
this.state = 13;
if (_confirmed==parent.__c.False) { 
this.state = 10;
;}if (true) break;

case 10:
//C
this.state = 13;
if (true) return ;
if (true) break;

case 13:
//C
this.state = 36;
;
 //BA.debugLineNum = 399;BA.debugLine="LoadProgram(Command.SubString(4).Trim)";
parent._loadprogram(_command.substring((int) (4)).trim());
 if (true) break;

case 15:
//C
this.state = 36;
 //BA.debugLineNum = 402;BA.debugLine="taOutput.Text = \"\"";
parent._taoutput.setText("");
 if (true) break;

case 17:
//C
this.state = 36;
 //BA.debugLineNum = 405;BA.debugLine="NewProgram";
parent._newprogram();
 if (true) break;

case 19:
//C
this.state = 36;
 //BA.debugLineNum = 408;BA.debugLine="LoadEditorProgram";
parent._loadeditorprogram();
 //BA.debugLineNum = 409;BA.debugLine="Interpreter.RunProgram";
parent._interpreter._runprogram();
 if (true) break;

case 21:
//C
this.state = 36;
 //BA.debugLineNum = 412;BA.debugLine="Serial.Disconnect";
parent._serial._disconnect();
 //BA.debugLineNum = 413;BA.debugLine="B4XPages.GetNativeParent(Me).Close";
parent._b4xpages._getnativeparent /*anywheresoftware.b4j.objects.Form*/ (parent).Close();
 if (true) break;

case 23:
//C
this.state = 36;
 //BA.debugLineNum = 416;BA.debugLine="ShowEasterEgg";
parent._showeasteregg();
 if (true) break;

case 25:
//C
this.state = 36;
 //BA.debugLineNum = 419;BA.debugLine="System.ExecuteCommand(Command.Substring(4).Trim";
parent._system._executecommand(_command.substring((int) (4)).trim());
 if (true) break;

case 27:
//C
this.state = 36;
 //BA.debugLineNum = 422;BA.debugLine="Serial.ExecuteCommand(Command)";
parent._serial._executecommand(_command);
 if (true) break;

case 29:
//C
this.state = 36;
 //BA.debugLineNum = 425;BA.debugLine="PrintText(taOutput, \"[BASIC-58][E] Unknown comm";
parent._printtext(parent._taoutput,"[BASIC-58][E] Unknown command.");
 if (true) break;

case 31:
//C
this.state = 32;
 //BA.debugLineNum = 428;BA.debugLine="If UpperCommand = \"LIST\" Or UpperCommand.Starts";
if (true) break;

case 32:
//if
this.state = 35;
if ((_uppercommand).equals("LIST") || _uppercommand.startsWith("LIST ") || (_uppercommand).equals("RENUM") || _uppercommand.startsWith("RENUM ")) { 
this.state = 34;
}if (true) break;

case 34:
//C
this.state = 35;
 //BA.debugLineNum = 430;BA.debugLine="LoadEditorProgram";
parent._loadeditorprogram();
 if (true) break;

case 35:
//C
this.state = 36;
;
 //BA.debugLineNum = 433;BA.debugLine="Interpreter.ExecuteCommand(Command)";
parent._interpreter._executecommand(_command);
 if (true) break;

case 36:
//C
this.state = -1;
;
 //BA.debugLineNum = 435;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _processinput() throws Exception{
String _command = "";
 //BA.debugLineNum = 437;BA.debugLine="Private Sub ProcessInput";
 //BA.debugLineNum = 439;BA.debugLine="Dim Command As String = cbCommands.Value.As(Strin";
_command = (BA.ObjectToString(_cbcommands.getValue())).trim();
 //BA.debugLineNum = 441;BA.debugLine="If Command = \"\" And Interpreter.IsWaitingForInput";
if ((_command).equals("") && _interpreter._iswaitingforinput()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 443;BA.debugLine="cbCommands.Value = \"\"";
_cbcommands.setValue((Object)(""));
 //BA.debugLineNum = 445;BA.debugLine="If Interpreter.IsWaitingForInput Then";
if (_interpreter._iswaitingforinput()) { 
 //BA.debugLineNum = 446;BA.debugLine="Interpreter.SubmitInput(Command)";
_interpreter._submitinput(_command);
 }else {
 //BA.debugLineNum = 448;BA.debugLine="AddCommandToHistory(Command)";
_addcommandtohistory(_command);
 //BA.debugLineNum = 449;BA.debugLine="ProcessCommand(Command)";
_processcommand(_command);
 };
 //BA.debugLineNum = 452;BA.debugLine="End Sub";
return "";
}
public String  _save() throws Exception{
String _filename = "";
anywheresoftware.b4j.objects.FileChooserWrapper _filechoose = null;
String _selectedfilename = "";
String _selectedfilepath = "";
 //BA.debugLineNum = 644;BA.debugLine="Private Sub Save";
 //BA.debugLineNum = 645;BA.debugLine="Dim Filename As String";
_filename = "";
 //BA.debugLineNum = 646;BA.debugLine="Dim FileChoose As FileChooser";
_filechoose = new anywheresoftware.b4j.objects.FileChooserWrapper();
 //BA.debugLineNum = 647;BA.debugLine="FileChoose.Initialize";
_filechoose.Initialize();
 //BA.debugLineNum = 648;BA.debugLine="FileChoose.InitialDirectory = CurrentFilePath";
_filechoose.setInitialDirectory(_currentfilepath);
 //BA.debugLineNum = 649;BA.debugLine="FileChoose.InitialFileName = CurrentFileName";
_filechoose.setInitialFileName(_currentfilename);
 //BA.debugLineNum = 650;BA.debugLine="FileChoose.Title = \"Save Program\"";
_filechoose.setTitle("Save Program");
 //BA.debugLineNum = 652;BA.debugLine="Filename = FileChoose.ShowSave(B4XPages.GetNative";
_filename = _filechoose.ShowSave(_b4xpages._getnativeparent /*anywheresoftware.b4j.objects.Form*/ (this));
 //BA.debugLineNum = 653;BA.debugLine="If Filename.Length = 0 Then Return";
if (_filename.length()==0) { 
if (true) return "";};
 //BA.debugLineNum = 655;BA.debugLine="Try";
try { //BA.debugLineNum = 656;BA.debugLine="Dim SelectedFileName As String = Utils.GetFileNa";
_selectedfilename = _utils._getfilename(_filename).toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 657;BA.debugLine="Dim SelectedFilePath As String = Utils.GetFilePa";
_selectedfilepath = _utils._getfilepath(_filename);
 //BA.debugLineNum = 659;BA.debugLine="SaveProgram(SelectedFileName, SelectedFilePath)";
_saveprogram(_selectedfilename,_selectedfilepath);
 } 
       catch (Exception e14) {
			ba.setLastException(e14); //BA.debugLineNum = 662;BA.debugLine="Log($\"[Save][E] Failed - ${LastException.Message";
__c.LogImpl("31966098",("[Save][E] Failed - "+__c.SmartStringFormatter("",(Object)(__c.LastException(ba).getMessage()))+""),0);
 };
 //BA.debugLineNum = 664;BA.debugLine="End Sub";
return "";
}
public boolean  _saveprogram(String _filename,String _filepath) throws Exception{
int _dotposition = 0;
anywheresoftware.b4a.objects.collections.List _savedlines = null;
String[] _editorlines = null;
String _editorline = "";
 //BA.debugLineNum = 485;BA.debugLine="Private Sub SaveProgram(FileName As String, FilePa";
 //BA.debugLineNum = 486;BA.debugLine="Interpreter.LoadProgram(taEditor.Text)";
_interpreter._loadprogram(_taeditor.getText());
 //BA.debugLineNum = 491;BA.debugLine="If Interpreter.GetProgramLineCount = 0 Then";
if (_interpreter._getprogramlinecount()==0) { 
 //BA.debugLineNum = 492;BA.debugLine="PrintText(taOutput, \"NO PROGRAM\")";
_printtext(_taoutput,"NO PROGRAM");
 //BA.debugLineNum = 493;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 496;BA.debugLine="If FileName = \"\" Then";
if ((_filename).equals("")) { 
 //BA.debugLineNum = 497;BA.debugLine="FileName = \"PROGRAM.BAS\"";
_filename = "PROGRAM.BAS";
 };
 //BA.debugLineNum = 500;BA.debugLine="If FileName.Contains(\"/\") Or FileName.Contains(\"\\";
if (_filename.contains("/") || _filename.contains("\\")) { 
 //BA.debugLineNum = 501;BA.debugLine="PrintText(taOutput, \"?INVALID FILE NAME\")";
_printtext(_taoutput,"?INVALID FILE NAME");
 //BA.debugLineNum = 502;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 505;BA.debugLine="FileName = FileName.Trim";
_filename = _filename.trim();
 //BA.debugLineNum = 507;BA.debugLine="If FileName.ToUpperCase.EndsWith(\".BAS\") = False";
if (_filename.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale).endsWith(".BAS")==__c.False) { 
 //BA.debugLineNum = 508;BA.debugLine="Dim DotPosition As Int = FileName.LastIndexOf(\".";
_dotposition = _filename.lastIndexOf(".");
 //BA.debugLineNum = 509;BA.debugLine="If DotPosition > 0 Then";
if (_dotposition>0) { 
 //BA.debugLineNum = 510;BA.debugLine="FileName = FileName.SubString2(0, DotPosition)";
_filename = _filename.substring((int) (0),_dotposition);
 };
 //BA.debugLineNum = 512;BA.debugLine="FileName = FileName & \".BAS\"";
_filename = _filename+".BAS";
 };
 //BA.debugLineNum = 515;BA.debugLine="FileName = FileName.ToUpperCase";
_filename = _filename.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 517;BA.debugLine="Try";
try { //BA.debugLineNum = 518;BA.debugLine="Dim SavedLines As List";
_savedlines = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 519;BA.debugLine="SavedLines.Initialize";
_savedlines.Initialize();
 //BA.debugLineNum = 521;BA.debugLine="Dim EditorLines() As String = Regex.Split(CRLF,";
_editorlines = __c.Regex.Split(__c.CRLF,_taeditor.getText());
 //BA.debugLineNum = 523;BA.debugLine="For Each EditorLine As String In EditorLines";
{
final String[] group26 = _editorlines;
final int groupLen26 = group26.length
;int index26 = 0;
;
for (; index26 < groupLen26;index26++){
_editorline = group26[index26];
 //BA.debugLineNum = 524;BA.debugLine="SavedLines.Add(EditorLine)";
_savedlines.Add((Object)(_editorline));
 }
};
 //BA.debugLineNum = 527;BA.debugLine="File.WriteList(FilePath, FileName, SavedLines)";
__c.File.WriteList(_filepath,_filename,_savedlines);
 //BA.debugLineNum = 532;BA.debugLine="CurrentFilePath = FilePath";
_currentfilepath = _filepath;
 //BA.debugLineNum = 533;BA.debugLine="CurrentFileName = FileName";
_currentfilename = _filename;
 //BA.debugLineNum = 534;BA.debugLine="ProgramModified = False";
_programmodified = __c.False;
 //BA.debugLineNum = 535;BA.debugLine="UpdatePageTitle";
_updatepagetitle();
 //BA.debugLineNum = 537;BA.debugLine="PrintText(taOutput, \"SAVED: \" & FileName)";
_printtext(_taoutput,"SAVED: "+_filename);
 //BA.debugLineNum = 539;BA.debugLine="Return True";
if (true) return __c.True;
 } 
       catch (Exception e37) {
			ba.setLastException(e37); //BA.debugLineNum = 542;BA.debugLine="PrintText(taOutput, \"?SAVE ERROR\")";
_printtext(_taoutput,"?SAVE ERROR");
 //BA.debugLineNum = 544;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 546;BA.debugLine="End Sub";
return false;
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _scrolltexttobottom(anywheresoftware.b4a.objects.B4XViewWrapper _target) throws Exception{
ResumableSub_ScrollTextToBottom rsub = new ResumableSub_ScrollTextToBottom(this,_target);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_ScrollTextToBottom extends BA.ResumableSub {
public ResumableSub_ScrollTextToBottom(de.rwblinn.basic58.b4xmainpage parent,anywheresoftware.b4a.objects.B4XViewWrapper _target) {
this.parent = parent;
this._target = _target;
}
de.rwblinn.basic58.b4xmainpage parent;
anywheresoftware.b4a.objects.B4XViewWrapper _target;
anywheresoftware.b4j.object.JavaObject _nativetextarea = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = -1;
 //BA.debugLineNum = 867;BA.debugLine="Sleep(50)";
parent.__c.Sleep(ba,this,(int) (50));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 869;BA.debugLine="Dim NativeTextArea As JavaObject = Target";
_nativetextarea = new anywheresoftware.b4j.object.JavaObject();
_nativetextarea = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_target.getObject()));
 //BA.debugLineNum = 870;BA.debugLine="NativeTextArea.RunMethod(\"setScrollTop\", Array(10";
_nativetextarea.RunMethod("setScrollTop",new Object[]{(Object)(100000.0)});
 //BA.debugLineNum = 872;BA.debugLine="Return True";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.True));return;};
 //BA.debugLineNum = 873;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _scrolltexttotop(anywheresoftware.b4a.objects.B4XViewWrapper _target) throws Exception{
ResumableSub_ScrollTextToTop rsub = new ResumableSub_ScrollTextToTop(this,_target);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_ScrollTextToTop extends BA.ResumableSub {
public ResumableSub_ScrollTextToTop(de.rwblinn.basic58.b4xmainpage parent,anywheresoftware.b4a.objects.B4XViewWrapper _target) {
this.parent = parent;
this._target = _target;
}
de.rwblinn.basic58.b4xmainpage parent;
anywheresoftware.b4a.objects.B4XViewWrapper _target;
anywheresoftware.b4j.object.JavaObject _nativetextarea = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = -1;
 //BA.debugLineNum = 876;BA.debugLine="Sleep(50)";
parent.__c.Sleep(ba,this,(int) (50));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 878;BA.debugLine="Dim NativeTextArea As JavaObject = Target";
_nativetextarea = new anywheresoftware.b4j.object.JavaObject();
_nativetextarea = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_target.getObject()));
 //BA.debugLineNum = 879;BA.debugLine="NativeTextArea.RunMethod(\"setScrollTop\", Array(0.";
_nativetextarea.RunMethod("setScrollTop",new Object[]{(Object)(0.0)});
 //BA.debugLineNum = 881;BA.debugLine="Return True";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.True));return;};
 //BA.debugLineNum = 882;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _serial_commandcompleted(byte[] _frame) throws Exception{
 //BA.debugLineNum = 767;BA.debugLine="Private Sub Serial_CommandCompleted(Frame() As Byt";
 //BA.debugLineNum = 768;BA.debugLine="PrintText(taOutput, $\"[BASIC-58] ACK received: ${";
_printtext(_taoutput,("[BASIC-58] ACK received: "+__c.SmartStringFormatter("",(Object)(_bc.HexFromBytes(_frame)))+""));
 //BA.debugLineNum = 769;BA.debugLine="Interpreter.ResumeHardwareCommand";
_interpreter._resumehardwarecommand();
 //BA.debugLineNum = 770;BA.debugLine="End Sub";
return "";
}
public String  _serial_commanderror(String _message) throws Exception{
 //BA.debugLineNum = 772;BA.debugLine="Private Sub Serial_CommandError(Message As String)";
 //BA.debugLineNum = 773;BA.debugLine="PrintText(taOutput, \"[BASIC-58][E] \" & Message)";
_printtext(_taoutput,"[BASIC-58][E] "+_message);
 //BA.debugLineNum = 774;BA.debugLine="Interpreter.ResumeHardwareCommand";
_interpreter._resumehardwarecommand();
 //BA.debugLineNum = 775;BA.debugLine="End Sub";
return "";
}
public void  _serial_connected() throws Exception{
ResumableSub_Serial_Connected rsub = new ResumableSub_Serial_Connected(this);
rsub.resume(ba, null);
}
public static class ResumableSub_Serial_Connected extends BA.ResumableSub {
public ResumableSub_Serial_Connected(de.rwblinn.basic58.b4xmainpage parent) {
this.parent = parent;
}
de.rwblinn.basic58.b4xmainpage parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 //BA.debugLineNum = 762;BA.debugLine="PrintText(taOutput, \"[BASIC-58] Controller connec";
parent._printtext(parent._taoutput,"[BASIC-58] Controller connected.");
 //BA.debugLineNum = 763;BA.debugLine="Sleep(2000) ' Allow Arduino UNO reset";
parent.__c.Sleep(ba,this,(int) (2000));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 764;BA.debugLine="Interpreter.ResumeHardwareCommand";
parent._interpreter._resumehardwarecommand();
 //BA.debugLineNum = 765;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _serial_datareceived(byte[] _frame) throws Exception{
byte _adr = (byte)0;
byte _cmd = (byte)0;
byte _val = (byte)0;
 //BA.debugLineNum = 798;BA.debugLine="Private Sub Serial_DataReceived(Frame() As Byte)";
 //BA.debugLineNum = 800;BA.debugLine="Dim Adr As Byte = B58Protocol.GetAdr(Frame)";
_adr = _b58protocol._getadr(_frame);
 //BA.debugLineNum = 801;BA.debugLine="Dim Cmd As Byte = B58Protocol.GetCmd(Frame)";
_cmd = _b58protocol._getcmd(_frame);
 //BA.debugLineNum = 802;BA.debugLine="Dim Val As Byte = B58Protocol.GetVal(Frame)";
_val = _b58protocol._getval(_frame);
 //BA.debugLineNum = 804;BA.debugLine="Log($\"[BASIC-58] Received: ADR=${B58Protocol.ToUn";
__c.LogImpl("33145734",("[BASIC-58] Received: ADR="+__c.SmartStringFormatter("",(Object)(_b58protocol._tounsigned(_adr)))+" CMD="+__c.SmartStringFormatter("",(Object)(_b58protocol._tounsigned(_cmd)))+" VAL="+__c.SmartStringFormatter("",(Object)(_b58protocol._tounsigned(_val)))+""),0);
 //BA.debugLineNum = 806;BA.debugLine="Interpreter.SubmitExternalData( _     	B58Protoco";
_interpreter._submitexternaldata(_b58protocol._tounsigned(_adr),_b58protocol._tounsigned(_cmd),_b58protocol._tounsigned(_val));
 //BA.debugLineNum = 810;BA.debugLine="End Sub";
return "";
}
public String  _serial_disconnected() throws Exception{
 //BA.debugLineNum = 777;BA.debugLine="Private Sub Serial_Disconnected";
 //BA.debugLineNum = 778;BA.debugLine="PrintText(taOutput, \"[BASIC-58] Controller discon";
_printtext(_taoutput,"[BASIC-58] Controller disconnected.");
 //BA.debugLineNum = 779;BA.debugLine="Interpreter.ResumeHardwareCommand";
_interpreter._resumehardwarecommand();
 //BA.debugLineNum = 780;BA.debugLine="Interpreter.ExternalDataDisconnected";
_interpreter._externaldatadisconnected();
 //BA.debugLineNum = 781;BA.debugLine="End Sub";
return "";
}
public String  _serial_error(String _message) throws Exception{
 //BA.debugLineNum = 783;BA.debugLine="Private Sub Serial_Error(Message As String)";
 //BA.debugLineNum = 784;BA.debugLine="PrintText(taOutput, \"[BASIC-58][E] \" & Message)";
_printtext(_taoutput,"[BASIC-58][E] "+_message);
 //BA.debugLineNum = 785;BA.debugLine="End Sub";
return "";
}
public String  _serial_noportsfound() throws Exception{
 //BA.debugLineNum = 794;BA.debugLine="Private Sub Serial_NoPortsFound";
 //BA.debugLineNum = 795;BA.debugLine="PrintText(taOutput, \"NO SERIAL PORTS FOUND.\")";
_printtext(_taoutput,"NO SERIAL PORTS FOUND.");
 //BA.debugLineNum = 796;BA.debugLine="End Sub";
return "";
}
public String  _serial_portsfound(anywheresoftware.b4a.objects.collections.List _ports) throws Exception{
String _port = "";
 //BA.debugLineNum = 787;BA.debugLine="Private Sub Serial_PortsFound(Ports As List)";
 //BA.debugLineNum = 788;BA.debugLine="PrintText(taOutput, \"AVAILABLE SERIAL PORTS:\")";
_printtext(_taoutput,"AVAILABLE SERIAL PORTS:");
 //BA.debugLineNum = 789;BA.debugLine="For Each Port As String In Ports";
{
final anywheresoftware.b4a.BA.IterableList group2 = _ports;
final int groupLen2 = group2.getSize()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_port = BA.ObjectToString(group2.Get(index2));
 //BA.debugLineNum = 790;BA.debugLine="PrintText(taOutput, Port)";
_printtext(_taoutput,_port);
 }
};
 //BA.debugLineNum = 792;BA.debugLine="End Sub";
return "";
}
public void  _showeasteregg() throws Exception{
ResumableSub_ShowEasterEgg rsub = new ResumableSub_ShowEasterEgg(this);
rsub.resume(ba, null);
}
public static class ResumableSub_ShowEasterEgg extends BA.ResumableSub {
public ResumableSub_ShowEasterEgg(de.rwblinn.basic58.b4xmainpage parent) {
this.parent = parent;
}
de.rwblinn.basic58.b4xmainpage parent;
boolean _success;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 //BA.debugLineNum = 844;BA.debugLine="taOutput.Text = \"\"";
parent._taoutput.setText("");
 //BA.debugLineNum = 845;BA.debugLine="PrintText(taOutput, \"============================";
parent._printtext(parent._taoutput,"================================");
 //BA.debugLineNum = 846;BA.debugLine="PrintText(taOutput, \"       B A S I C - 5 8\")";
parent._printtext(parent._taoutput,"       B A S I C - 5 8");
 //BA.debugLineNum = 847;BA.debugLine="PrintText(taOutput, \"============================";
parent._printtext(parent._taoutput,"================================");
 //BA.debugLineNum = 848;BA.debugLine="PrintText(taOutput, \"\")";
parent._printtext(parent._taoutput,"");
 //BA.debugLineNum = 849;BA.debugLine="PrintText(taOutput, \"HELLO, RETRO PROGRAMMER!\")";
parent._printtext(parent._taoutput,"HELLO, RETRO PROGRAMMER!");
 //BA.debugLineNum = 850;BA.debugLine="PrintText(taOutput, \"\")";
parent._printtext(parent._taoutput,"");
 //BA.debugLineNum = 851;BA.debugLine="PrintText(taOutput, \"SOME THINGS NEVER GET OLD.\")";
parent._printtext(parent._taoutput,"SOME THINGS NEVER GET OLD.");
 //BA.debugLineNum = 852;BA.debugLine="PrintText(taOutput, \"ESPECIALLY A GOOD BASIC PROG";
parent._printtext(parent._taoutput,"ESPECIALLY A GOOD BASIC PROGRAM.");
 //BA.debugLineNum = 853;BA.debugLine="PrintText(taOutput, \"\")";
parent._printtext(parent._taoutput,"");
 //BA.debugLineNum = 854;BA.debugLine="PrintText(taOutput, \"KEEP CODING AND HAVE FUN!\")";
parent._printtext(parent._taoutput,"KEEP CODING AND HAVE FUN!");
 //BA.debugLineNum = 855;BA.debugLine="PrintText(taOutput, \"\")";
parent._printtext(parent._taoutput,"");
 //BA.debugLineNum = 856;BA.debugLine="PrintText(taOutput, \"              :-)\")";
parent._printtext(parent._taoutput,"              :-)");
 //BA.debugLineNum = 857;BA.debugLine="PrintText(taOutput, \"============================";
parent._printtext(parent._taoutput,"================================");
 //BA.debugLineNum = 858;BA.debugLine="Wait For (ScrollTextToTop(taOutput)) Complete (Su";
parent.__c.WaitFor("complete", ba, this, parent._scrolltexttotop(parent._taoutput));
this.state = 1;
return;
case 1:
//C
this.state = -1;
_success = (boolean) result[0];
;
 //BA.debugLineNum = 859;BA.debugLine="lblStatus.Text = \"ENJOY BASIC-58\"";
parent._lblstatus.setText("ENJOY BASIC-58");
 //BA.debugLineNum = 860;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _showhelp() throws Exception{
 //BA.debugLineNum = 836;BA.debugLine="Private Sub ShowHelp";
 //BA.debugLineNum = 837;BA.debugLine="taOutput.Text = \"\"";
_taoutput.setText("");
 //BA.debugLineNum = 838;BA.debugLine="Interpreter.ExecuteHelp";
_interpreter._executehelp();
 //BA.debugLineNum = 839;BA.debugLine="ScrollTextToTop(taOutput)";
_scrolltexttotop(_taoutput);
 //BA.debugLineNum = 840;BA.debugLine="lblStatus.Text = \"HELP\"";
_lblstatus.setText("HELP");
 //BA.debugLineNum = 841;BA.debugLine="End Sub";
return "";
}
public void  _showwelcommessage() throws Exception{
ResumableSub_ShowWelcomMessage rsub = new ResumableSub_ShowWelcomMessage(this);
rsub.resume(ba, null);
}
public static class ResumableSub_ShowWelcomMessage extends BA.ResumableSub {
public ResumableSub_ShowWelcomMessage(de.rwblinn.basic58.b4xmainpage parent) {
this.parent = parent;
}
de.rwblinn.basic58.b4xmainpage parent;
boolean _success;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 //BA.debugLineNum = 825;BA.debugLine="taOutput.Text = \"\"";
parent._taoutput.setText("");
 //BA.debugLineNum = 826;BA.debugLine="PrintText(taOutput, \"BASIC-58  BASIC INTERPRETER\"";
parent._printtext(parent._taoutput,"BASIC-58  BASIC INTERPRETER");
 //BA.debugLineNum = 827;BA.debugLine="PrintText(taOutput, \"VERSION \" & APPVERSION)";
parent._printtext(parent._taoutput,"VERSION "+parent._appversion);
 //BA.debugLineNum = 828;BA.debugLine="PrintText(taOutput, APPCOPYRIGHT)";
parent._printtext(parent._taoutput,parent._appcopyright);
 //BA.debugLineNum = 829;BA.debugLine="PrintText(taOutput, \"---------------------------\"";
parent._printtext(parent._taoutput,"---------------------------");
 //BA.debugLineNum = 830;BA.debugLine="PrintText(taOutput, \"TYPE HELP FOR COMMANDS\")";
parent._printtext(parent._taoutput,"TYPE HELP FOR COMMANDS");
 //BA.debugLineNum = 831;BA.debugLine="PrintText(taOutput, \"READY.\")";
parent._printtext(parent._taoutput,"READY.");
 //BA.debugLineNum = 832;BA.debugLine="Wait For (ScrollTextToTop(taOutput)) Complete (Su";
parent.__c.WaitFor("complete", ba, this, parent._scrolltexttotop(parent._taoutput));
this.state = 1;
return;
case 1:
//C
this.state = -1;
_success = (boolean) result[0];
;
 //BA.debugLineNum = 833;BA.debugLine="lblStatus.Text = \"READY\"";
parent._lblstatus.setText("READY");
 //BA.debugLineNum = 834;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _system_output(String _message) throws Exception{
 //BA.debugLineNum = 752;BA.debugLine="Private Sub System_Output(Message As String)";
 //BA.debugLineNum = 753;BA.debugLine="PrintText(taOutput, Message)";
_printtext(_taoutput,_message);
 //BA.debugLineNum = 754;BA.debugLine="End Sub";
return "";
}
public String  _taeditor_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 340;BA.debugLine="Private Sub taEditor_MouseClicked (EventData As Mo";
 //BA.debugLineNum = 341;BA.debugLine="If EventData.ClickCount = 2 Then";
if (_eventdata.getClickCount()==2) { 
 //BA.debugLineNum = 342;BA.debugLine="taEditor.Text = \"\"";
_taeditor.setText("");
 };
 //BA.debugLineNum = 344;BA.debugLine="End Sub";
return "";
}
public String  _taeditor_textchanged(String _old,String _new) throws Exception{
String _uppertext = "";
anywheresoftware.b4j.object.JavaObject _textarea = null;
int _cursorposition = 0;
 //BA.debugLineNum = 316;BA.debugLine="Private Sub taEditor_TextChanged (Old As String, N";
 //BA.debugLineNum = 317;BA.debugLine="If UpdatingEditor Then Return";
if (_updatingeditor) { 
if (true) return "";};
 //BA.debugLineNum = 319;BA.debugLine="If LoadingProgram Then";
if (_loadingprogram) { 
 //BA.debugLineNum = 320;BA.debugLine="LoadingProgram = False";
_loadingprogram = __c.False;
 //BA.debugLineNum = 321;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 324;BA.debugLine="ProgramModified = True";
_programmodified = __c.True;
 //BA.debugLineNum = 325;BA.debugLine="UpdatePageTitle";
_updatepagetitle();
 //BA.debugLineNum = 327;BA.debugLine="Dim UpperText As String = Utils.ConvertBasicTextT";
_uppertext = _utils._convertbasictexttoupper(_new);
 //BA.debugLineNum = 329;BA.debugLine="If New <> UpperText Then";
if ((_new).equals(_uppertext) == false) { 
 //BA.debugLineNum = 330;BA.debugLine="Dim TextArea As JavaObject = taEditor";
_textarea = new anywheresoftware.b4j.object.JavaObject();
_textarea = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_taeditor.getObject()));
 //BA.debugLineNum = 331;BA.debugLine="Dim CursorPosition As Int = TextArea.RunMethod(\"";
_cursorposition = (int)(BA.ObjectToNumber(_textarea.RunMethod("getCaretPosition",(Object[])(__c.Null))));
 //BA.debugLineNum = 333;BA.debugLine="UpdatingEditor = True";
_updatingeditor = __c.True;
 //BA.debugLineNum = 334;BA.debugLine="taEditor.Text = UpperText";
_taeditor.setText(_uppertext);
 //BA.debugLineNum = 335;BA.debugLine="TextArea.RunMethod(\"positionCaret\", Array(Cursor";
_textarea.RunMethod("positionCaret",new Object[]{(Object)(_cursorposition)});
 //BA.debugLineNum = 336;BA.debugLine="UpdatingEditor = False";
_updatingeditor = __c.False;
 };
 //BA.debugLineNum = 338;BA.debugLine="End Sub";
return "";
}
public String  _taoutput_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 346;BA.debugLine="Private Sub taOutput_MouseClicked (EventData As Mo";
 //BA.debugLineNum = 347;BA.debugLine="If EventData.ClickCount = 2 Then";
if (_eventdata.getClickCount()==2) { 
 //BA.debugLineNum = 348;BA.debugLine="taOutput.Text = \"\"";
_taoutput.setText("");
 };
 //BA.debugLineNum = 350;BA.debugLine="End Sub";
return "";
}
public String  _toolbar_click(anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
Object[] _o = null;
String _tag = "";
 //BA.debugLineNum = 294;BA.debugLine="Private Sub Toolbar_Click (lbl As B4XView)";
 //BA.debugLineNum = 295;BA.debugLine="Dim o() As Object = lbl.Tag";
_o = (Object[])(_lbl.getTag());
 //BA.debugLineNum = 296;BA.debugLine="Dim tag As String = o(2)";
_tag = BA.ObjectToString(_o[(int) (2)]);
 //BA.debugLineNum = 298;BA.debugLine="Select tag.ToUppercase";
switch (BA.switchObjectToInt(_tag.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale),"RUN","LIST","LOAD","SAVE","NEW","CLS")) {
case 0: {
 //BA.debugLineNum = 300;BA.debugLine="LoadEditorProgram";
_loadeditorprogram();
 //BA.debugLineNum = 301;BA.debugLine="Interpreter.RunProgram";
_interpreter._runprogram();
 break; }
case 1: {
 //BA.debugLineNum = 303;BA.debugLine="ProcessCommand(\"LIST\")";
_processcommand("LIST");
 break; }
case 2: {
 //BA.debugLineNum = 305;BA.debugLine="Load";
_load();
 break; }
case 3: {
 //BA.debugLineNum = 307;BA.debugLine="Save";
_save();
 break; }
case 4: {
 //BA.debugLineNum = 309;BA.debugLine="NewProgram";
_newprogram();
 break; }
case 5: {
 //BA.debugLineNum = 311;BA.debugLine="taOutput.Text = \"\"";
_taoutput.setText("");
 break; }
}
;
 //BA.debugLineNum = 314;BA.debugLine="End Sub";
return "";
}
public String  _updatepagetitle() throws Exception{
String _pagetitle = "";
 //BA.debugLineNum = 693;BA.debugLine="Private Sub UpdatePageTitle";
 //BA.debugLineNum = 694;BA.debugLine="Dim PageTitle As String = $\"${APPNAME} - ${Curren";
_pagetitle = (""+__c.SmartStringFormatter("",(Object)(_appname))+" - "+__c.SmartStringFormatter("",(Object)(_currentfilename))+"");
 //BA.debugLineNum = 696;BA.debugLine="If ProgramModified Then";
if (_programmodified) { 
 //BA.debugLineNum = 697;BA.debugLine="PageTitle = PageTitle & \" *\"";
_pagetitle = _pagetitle+" *";
 };
 //BA.debugLineNum = 700;BA.debugLine="B4XPages.SetTitle(Me, PageTitle)";
_b4xpages._settitle /*String*/ (this,(Object)(_pagetitle));
 //BA.debugLineNum = 701;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
