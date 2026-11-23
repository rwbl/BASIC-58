package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class b4xmainpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.b4xmainpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.b4xmainpage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4j.objects.JFX _fx = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4j.objects.ComboBoxWrapper _cbcommands = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.main _main = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Private Sub B4XPage_Created (Root1 As B4XView)";
 //BA.debugLineNum = 21;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 22;BA.debugLine="Root.LoadLayout(\"MainPage\")";
_root.LoadLayout("MainPage",ba);
 //BA.debugLineNum = 24;BA.debugLine="ComboBoxSetPromptText(cbCommands, \"ENTER COMMAND";
_comboboxsetprompttext(_cbcommands,"ENTER COMMAND OR INPUT...");
 //BA.debugLineNum = 26;BA.debugLine="SetUIStyling";
_setuistyling();
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return "";
}
public String  _button1_click() throws Exception{
 //BA.debugLineNum = 31;BA.debugLine="Private Sub Button1_Click";
 //BA.debugLineNum = 32;BA.debugLine="xui.MsgboxAsync(\"Hello world!\", \"B4X\")";
_xui.MsgboxAsync(ba,"Hello world!","B4X");
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 8;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private fx As JFX";
_fx = new anywheresoftware.b4j.objects.JFX();
 //BA.debugLineNum = 10;BA.debugLine="Private Root As B4XView";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 11;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 12;BA.debugLine="Private cbCommands As ComboBox";
_cbcommands = new anywheresoftware.b4j.objects.ComboBoxWrapper();
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return "";
}
public String  _comboboxsetprompttext(anywheresoftware.b4j.objects.ComboBoxWrapper _box,String _text) throws Exception{
anywheresoftware.b4j.object.JavaObject _jocb = null;
 //BA.debugLineNum = 67;BA.debugLine="Public Sub ComboBoxSetPromptText(box As ComboBox,";
 //BA.debugLineNum = 68;BA.debugLine="Dim joCB As JavaObject = box";
_jocb = new anywheresoftware.b4j.object.JavaObject();
_jocb = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_box.getObject()));
 //BA.debugLineNum = 69;BA.debugLine="joCB.RunMethod(\"setPromptText\", Array(text))";
_jocb.RunMethod("setPromptText",new Object[]{(Object)(_text)});
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 15;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _setuistyling() throws Exception{
 //BA.debugLineNum = 35;BA.debugLine="private Sub SetUIStyling";
 //BA.debugLineNum = 38;BA.debugLine="B4XPages.GetNativeParent(Me).Stylesheets.Add(File";
_b4xpages._getnativeparent /*anywheresoftware.b4j.objects.Form*/ (this).getStylesheets().Add((Object)(__c.File.GetUri(__c.File.getDirAssets(),"Main.css")));
 //BA.debugLineNum = 43;BA.debugLine="CSSUtils.SetBackgroundColor(Root, fx.Colors.From3";
_cssutils._setbackgroundcolor((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_root.getObject())),(anywheresoftware.b4j.objects.JFX.PaintWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.JFX.PaintWrapper(), (javafx.scene.paint.Paint)(_fx.Colors.From32Bit(((int)0xffdcd6c8)))));
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
