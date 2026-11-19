package de.rwblinn.basic58;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class designertoolbar extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("de.rwblinn.basic58", "de.rwblinn.basic58.designertoolbar", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", de.rwblinn.basic58.designertoolbar.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4j.objects.JFX _fx = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public de.rwblinn.basic58.ddd _du = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _stub = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.b58protocol _b58protocol = null;
public b4j.example.utils _utils = null;
public b4j.example.b58help _b58help = null;
public de.rwblinn.basic58.main _main = null;
public de.rwblinn.basic58.b4xpages _b4xpages = null;
public de.rwblinn.basic58.b4xcollections _b4xcollections = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 22;BA.debugLine="Private fx As JFX";
_fx = new anywheresoftware.b4j.objects.JFX();
 //BA.debugLineNum = 23;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 24;BA.debugLine="Private du As DDD";
_du = new de.rwblinn.basic58.ddd();
 //BA.debugLineNum = 26;BA.debugLine="Private stub As B4XView 'ignore";
_stub = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _createlabel() throws Exception{
anywheresoftware.b4j.objects.LabelWrapper _lbl = null;
 //BA.debugLineNum = 65;BA.debugLine="Private Sub CreateLabel As B4XView";
 //BA.debugLineNum = 66;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4j.objects.LabelWrapper();
 //BA.debugLineNum = 67;BA.debugLine="lbl.Initialize(\"lbl\")";
_lbl.Initialize(ba,"lbl");
 //BA.debugLineNum = 68;BA.debugLine="Return lbl";
if (true) return (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 69;BA.debugLine="End Sub";
return null;
}
public String  _createtoolbar(anywheresoftware.b4j.objects.DesignerArgs _designerargs) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _pnl = null;
anywheresoftware.b4a.objects.B4XViewWrapper _stublabel = null;
String _eventname = "";
anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _fnt = null;
int _i = 0;
String[] _textitems = null;
String _text = "";
String _tag = "";
anywheresoftware.b4a.objects.B4XViewWrapper _lbl = null;
 //BA.debugLineNum = 34;BA.debugLine="Private Sub CreateToolbar (DesignerArgs As Designe";
 //BA.debugLineNum = 35;BA.debugLine="Dim pnl As B4XView = DesignerArgs.GetViewFromArgs";
_pnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_pnl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_designerargs.GetViewFromArgs((int) (0))));
 //BA.debugLineNum = 36;BA.debugLine="If DesignerArgs.FirstRun Then";
if (_designerargs.getFirstRun()) { 
 //BA.debugLineNum = 37;BA.debugLine="Dim StubLabel As B4XView = pnl.GetView(0)";
_stublabel = new anywheresoftware.b4a.objects.B4XViewWrapper();
_stublabel = _pnl.GetView((int) (0));
 //BA.debugLineNum = 38;BA.debugLine="StubLabel.RemoveViewFromParent";
_stublabel.RemoveViewFromParent();
 //BA.debugLineNum = 39;BA.debugLine="Dim EventName As String = DesignerArgs.Arguments";
_eventname = BA.ObjectToString(_designerargs.getArguments().Get((int) (1)));
 //BA.debugLineNum = 40;BA.debugLine="Dim fnt As B4XFont = StubLabel.Font";
_fnt = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont();
_fnt = _stublabel.getFont();
 //BA.debugLineNum = 41;BA.debugLine="For i = 2 To DesignerArgs.Arguments.Size - 1 Ste";
{
final int step7 = 2;
final int limit7 = (int) (_designerargs.getArguments().getSize()-1);
_i = (int) (2) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
 //BA.debugLineNum = 42;BA.debugLine="Dim textitems() As String = Regex.Split(\" \", De";
_textitems = __c.Regex.Split(" ",BA.ObjectToString(_designerargs.getArguments().Get(_i)));
 //BA.debugLineNum = 43;BA.debugLine="Dim text As String = $\"${textitems(0)}${CRLF}${";
_text = (""+__c.SmartStringFormatter("",(Object)(_textitems[(int) (0)]))+""+__c.SmartStringFormatter("",(Object)(__c.CRLF))+""+__c.SmartStringFormatter("",(Object)(_textitems[(int) (1)]))+"");
 //BA.debugLineNum = 44;BA.debugLine="Dim tag As String = DesignerArgs.Arguments.Get(";
_tag = BA.ObjectToString(_designerargs.getArguments().Get((int) (_i+1)));
 //BA.debugLineNum = 46;BA.debugLine="Dim lbl As B4XView = CreateLabel";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = _createlabel();
 //BA.debugLineNum = 47;BA.debugLine="lbl.Font = fnt";
_lbl.setFont(_fnt);
 //BA.debugLineNum = 48;BA.debugLine="lbl.Text = text";
_lbl.setText(_text);
 //BA.debugLineNum = 50;BA.debugLine="CSSUtils.SetStyleProperty(lbl, \"-fx-text-fill\",";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_lbl.getObject())),"-fx-text-fill","#FFBF69");
 //BA.debugLineNum = 51;BA.debugLine="CSSUtils.SetStyleProperty(lbl, \"-fx-background-";
_cssutils._setstyleproperty((anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.objects.NodeWrapper.ConcreteNodeWrapper(), (javafx.scene.Node)(_lbl.getObject())),"-fx-background-color","#58544E");
 //BA.debugLineNum = 52;BA.debugLine="lbl.SetColorAndBorder(xui.Color_ARGB(0xFF,0x58,";
_lbl.SetColorAndBorder(_xui.Color_ARGB(((int)0xff),((int)0x58),((int)0x54),((int)0x4e)),1,_xui.Color_ARGB(((int)0xff),((int)0x58),((int)0x54),((int)0x4e)),5);
 //BA.debugLineNum = 53;BA.debugLine="lbl.SetTextAlignment(\"CENTER\", \"CENTER\")";
_lbl.SetTextAlignment("CENTER","CENTER");
 //BA.debugLineNum = 54;BA.debugLine="lbl.Tag = Array(DesignerArgs.LayoutModule, Even";
_lbl.setTag((Object)(new Object[]{_designerargs.getLayoutModule(),(Object)(_eventname),(Object)(_tag)}));
 //BA.debugLineNum = 55;BA.debugLine="pnl.AddView(lbl, 0, 0, 40dip, pnl.Height)";
_pnl.AddView((javafx.scene.Node)(_lbl.getObject()),0,0,__c.DipToCurrent((int) (40)),_pnl.getHeight());
 }
};
 }else {
 //BA.debugLineNum = 58;BA.debugLine="For i = 0 To pnl.NumberOfViews - 1";
{
final int step22 = 1;
final int limit22 = (int) (_pnl.getNumberOfViews()-1);
_i = (int) (0) ;
for (;_i <= limit22 ;_i = _i + step22 ) {
 //BA.debugLineNum = 59;BA.debugLine="pnl.GetView(i).Height = pnl.Height";
_pnl.GetView(_i).setHeight(_pnl.getHeight());
 }
};
 };
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 30;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 31;BA.debugLine="du.Initialize";
_du._initialize /*String*/ (ba);
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public String  _lbl_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 72;BA.debugLine="Private Sub lbl_MouseClicked (EventData As MouseEv";
 //BA.debugLineNum = 73;BA.debugLine="RaiseToolbarEvent(Sender, Sender.As(B4XView).Tag)";
_raisetoolbarevent((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(__c.Sender(ba))),(Object[])(((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(__c.Sender(ba)))).getTag()));
 //BA.debugLineNum = 74;BA.debugLine="EventData.Consume";
_eventdata.Consume();
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public String  _raisetoolbarevent(anywheresoftware.b4a.objects.B4XViewWrapper _lbl,Object[] _data) throws Exception{
 //BA.debugLineNum = 90;BA.debugLine="Private Sub RaiseToolbarEvent (lbl As B4XView, Dat";
 //BA.debugLineNum = 91;BA.debugLine="CallSubDelayed2(Data(0), Data(1) & \"_click\", lbl)";
__c.CallSubDelayed2(ba,_data[(int) (0)],BA.ObjectToString(_data[(int) (1)])+"_click",(Object)(_lbl));
 //BA.debugLineNum = 92;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
