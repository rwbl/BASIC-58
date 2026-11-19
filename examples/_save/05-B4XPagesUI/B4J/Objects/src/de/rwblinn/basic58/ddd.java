package de.rwblinn.basic58;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class ddd extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("de.rwblinn.basic58", "de.rwblinn.basic58.ddd", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", de.rwblinn.basic58.ddd.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XCanvas _cvs = null;
public boolean _cvscreated = false;
public float[] _textsizessteps = null;
public int _textwidthgap = 0;
public anywheresoftware.b4a.objects.collections.Map _layoutsmap = null;
public anywheresoftware.b4a.objects.collections.Map _viewsdata = null;
public int _toolbarpressedcolor = 0;
public anywheresoftware.b4a.objects.collections.Map _colormap = null;
public b4j.example.cssutils _cssutils = null;
public b4j.example.b58protocol _b58protocol = null;
public b4j.example.utils _utils = null;
public b4j.example.b58help _b58help = null;
public de.rwblinn.basic58.main _main = null;
public de.rwblinn.basic58.b4xpages _b4xpages = null;
public de.rwblinn.basic58.b4xcollections _b4xcollections = null;
public static class _dddinternalviewsdata{
public boolean IsInitialized;
public anywheresoftware.b4a.objects.collections.Map NamesMap;
public anywheresoftware.b4a.objects.collections.Map ClassesMap;
public void Initialize() {
IsInitialized = true;
NamesMap = new anywheresoftware.b4a.objects.collections.Map();
ClassesMap = new anywheresoftware.b4a.objects.collections.Map();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _dddviewdata{
public boolean IsInitialized;
public String Name;
public anywheresoftware.b4a.objects.collections.List Classes;
public anywheresoftware.b4a.objects.B4XViewWrapper LayoutParent;
public void Initialize() {
IsInitialized = true;
Name = "";
Classes = new anywheresoftware.b4a.objects.collections.List();
LayoutParent = new anywheresoftware.b4a.objects.B4XViewWrapper();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public String  _addclass(anywheresoftware.b4j.objects.DesignerArgs _designerargs) throws Exception{
String _cls = "";
de.rwblinn.basic58.ddd._dddinternalviewsdata _data = null;
int _i = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _view = null;
 //BA.debugLineNum = 175;BA.debugLine="Private Sub AddClass(DesignerArgs As DesignerArgs)";
 //BA.debugLineNum = 176;BA.debugLine="If DesignerArgs.FirstRun = False Then Return";
if (_designerargs.getFirstRun()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 177;BA.debugLine="Dim cls As String = DesignerArgs.Arguments.Get(0)";
_cls = (BA.ObjectToString(_designerargs.getArguments().Get((int) (0)))).toLowerCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 178;BA.debugLine="Dim Data As DDDInternalViewsData = GetViewsData(D";
_data = _getviewsdata((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_designerargs.getParent())),__c.True);
 //BA.debugLineNum = 179;BA.debugLine="For i = 1 To DesignerArgs.Arguments.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_designerargs.getArguments().getSize()-1);
_i = (int) (1) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 180;BA.debugLine="Dim View As B4XView = DesignerArgs.GetViewFromAr";
_view = new anywheresoftware.b4a.objects.B4XViewWrapper();
_view = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_designerargs.GetViewFromArgs(_i)));
 //BA.debugLineNum = 181;BA.debugLine="AddClassImpl(cls, Data, View)";
_addclassimpl(_cls,_data,_view);
 }
};
 //BA.debugLineNum = 183;BA.debugLine="End Sub";
return "";
}
public String  _addclassimpl(String _cls,de.rwblinn.basic58.ddd._dddinternalviewsdata _data,anywheresoftware.b4a.objects.B4XViewWrapper _view) throws Exception{
anywheresoftware.b4a.objects.collections.List _lst = null;
de.rwblinn.basic58.ddd._dddviewdata _vd = null;
 //BA.debugLineNum = 185;BA.debugLine="Private Sub AddClassImpl(cls As String, Data As DD";
 //BA.debugLineNum = 186;BA.debugLine="Dim lst As List = Data.ClassesMap.Get(cls)";
_lst = new anywheresoftware.b4a.objects.collections.List();
_lst = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_data.ClassesMap /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)(_cls))));
 //BA.debugLineNum = 187;BA.debugLine="If lst.IsInitialized = False Then";
if (_lst.IsInitialized()==__c.False) { 
 //BA.debugLineNum = 188;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 189;BA.debugLine="Data.ClassesMap.Put(cls, lst)";
_data.ClassesMap /*anywheresoftware.b4a.objects.collections.Map*/ .Put((Object)(_cls),(Object)(_lst.getObject()));
 };
 //BA.debugLineNum = 191;BA.debugLine="lst.Add(view)";
_lst.Add((Object)(_view.getObject()));
 //BA.debugLineNum = 192;BA.debugLine="Dim vd As DDDViewData = GetViewDataImpl(view, Tru";
_vd = _getviewdataimpl(_view,__c.True);
 //BA.debugLineNum = 193;BA.debugLine="vd.Classes.Add(cls)";
_vd.Classes /*anywheresoftware.b4a.objects.collections.List*/ .Add((Object)(_cls));
 //BA.debugLineNum = 194;BA.debugLine="End Sub";
return "";
}
public String  _addcolor(String _name,int _value) throws Exception{
 //BA.debugLineNum = 44;BA.debugLine="Public Sub AddColor(Name As String, Value As Int)";
 //BA.debugLineNum = 45;BA.debugLine="ColorMap.Put(Name.ToLowerCase, Value)";
_colormap.Put((Object)(_name.toLowerCase(anywheresoftware.b4a.keywords.Common.stringLocale)),(Object)(_value));
 //BA.debugLineNum = 46;BA.debugLine="End Sub";
return "";
}
public String  _addruntimeview(anywheresoftware.b4a.objects.B4XViewWrapper _view,String _name,anywheresoftware.b4a.objects.B4XViewWrapper _layoutparent,anywheresoftware.b4a.objects.collections.List _classes) throws Exception{
de.rwblinn.basic58.ddd._dddinternalviewsdata _data = null;
String _cls = "";
 //BA.debugLineNum = 150;BA.debugLine="Public Sub AddRuntimeView(View As B4XView, Name As";
 //BA.debugLineNum = 151;BA.debugLine="Dim Data As DDDInternalViewsData = GetViewsData(L";
_data = _getviewsdata(_layoutparent,__c.True);
 //BA.debugLineNum = 152;BA.debugLine="SetViewNameAndParent(Data, View, Name, LayoutPare";
_setviewnameandparent(_data,_view,_name,_layoutparent);
 //BA.debugLineNum = 153;BA.debugLine="If Classes.IsInitialized Then";
if (_classes.IsInitialized()) { 
 //BA.debugLineNum = 154;BA.debugLine="For Each cls As String In Classes";
{
final anywheresoftware.b4a.BA.IterableList group4 = _classes;
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_cls = BA.ObjectToString(group4.Get(index4));
 //BA.debugLineNum = 155;BA.debugLine="AddClassImpl(cls, Data, View)";
_addclassimpl(_cls,_data,_view);
 }
};
 };
 //BA.debugLineNum = 158;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 3;BA.debugLine="Private cvs As B4XCanvas";
_cvs = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 4;BA.debugLine="Private cvsCreated As Boolean";
_cvscreated = false;
 //BA.debugLineNum = 5;BA.debugLine="Private textSizesSteps() As Float = Array As Floa";
_textsizessteps = new float[]{(float) (1),(float) (0.8)};
 //BA.debugLineNum = 6;BA.debugLine="Public TextWidthGap As Int = 30dip";
_textwidthgap = __c.DipToCurrent((int) (30));
 //BA.debugLineNum = 7;BA.debugLine="Private LayoutsMap As Map 'LayoutParent -> DDDInt";
_layoutsmap = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 8;BA.debugLine="Private ViewsData As Map 'View -> DDDViewData";
_viewsdata = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 9;BA.debugLine="Type DDDInternalViewsData (NamesMap As Map, Class";
;
 //BA.debugLineNum = 10;BA.debugLine="Type DDDViewData (Name As String, Classes As List";
;
 //BA.debugLineNum = 11;BA.debugLine="Public ToolbarPressedColor As Int = 0x6600A3FF";
_toolbarpressedcolor = ((int)0x6600a3ff);
 //BA.debugLineNum = 15;BA.debugLine="Private ColorMap As Map";
_colormap = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
public String  _collectviewsdata(anywheresoftware.b4j.objects.DesignerArgs _designerargs) throws Exception{
de.rwblinn.basic58.ddd._dddinternalviewsdata _data = null;
String _s = "";
anywheresoftware.b4a.objects.B4XViewWrapper _v = null;
 //BA.debugLineNum = 134;BA.debugLine="Private Sub CollectViewsData(DesignerArgs As Desig";
 //BA.debugLineNum = 135;BA.debugLine="Dim Data As DDDInternalViewsData = GetViewsData(D";
_data = _getviewsdata((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_designerargs.getParent())),__c.True);
 //BA.debugLineNum = 136;BA.debugLine="For Each s As String In DesignerArgs.ViewsNames";
{
final anywheresoftware.b4a.BA.IterableList group2 = _designerargs.getViewsNames();
final int groupLen2 = group2.getSize()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_s = BA.ObjectToString(group2.Get(index2));
 //BA.debugLineNum = 137;BA.debugLine="Dim v As B4XView = DesignerArgs.GetViewByName(s)";
_v = new anywheresoftware.b4a.objects.B4XViewWrapper();
_v = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_designerargs.GetViewByName(_s)));
 //BA.debugLineNum = 138;BA.debugLine="SetViewNameAndParent(Data, v, s, DesignerArgs.Pa";
_setviewnameandparent(_data,_v,_s,(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_designerargs.getParent())));
 }
};
 //BA.debugLineNum = 140;BA.debugLine="End Sub";
return "";
}
public String  _color(anywheresoftware.b4j.objects.DesignerArgs _designerargs) throws Exception{
String _name = "";
 //BA.debugLineNum = 54;BA.debugLine="Private Sub Color(DesignerArgs As DesignerArgs) As";
 //BA.debugLineNum = 55;BA.debugLine="Dim Name As String = DesignerArgs.Arguments.Get(0";
_name = (BA.ObjectToString(_designerargs.getArguments().Get((int) (0)))).toLowerCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 56;BA.debugLine="If Name.StartsWith(\"0x\") Then";
if (_name.startsWith("0x")) { 
 //BA.debugLineNum = 57;BA.debugLine="Return GetIntFromString(Name)";
if (true) return BA.NumberToString(_getintfromstring(_name));
 };
 //BA.debugLineNum = 59;BA.debugLine="Return GetColor(Name)";
if (true) return BA.NumberToString(_getcolor(_name));
 //BA.debugLineNum = 60;BA.debugLine="End Sub";
return "";
}
public String  _createcvsifneeded() throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
 //BA.debugLineNum = 35;BA.debugLine="Private Sub CreateCVSIfNeeded";
 //BA.debugLineNum = 36;BA.debugLine="If cvsCreated Then Return";
if (_cvscreated) { 
if (true) return "";};
 //BA.debugLineNum = 37;BA.debugLine="cvsCreated = True";
_cvscreated = __c.True;
 //BA.debugLineNum = 38;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _xui.CreatePanel(ba,"");
 //BA.debugLineNum = 39;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 2dip, 2dip)";
_p.SetLayoutAnimated((int) (0),0,0,__c.DipToCurrent((int) (2)),__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 40;BA.debugLine="cvs.Initialize(p)";
_cvs.Initialize(ba,_p);
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _createlabel() throws Exception{
anywheresoftware.b4j.objects.LabelWrapper _lbl = null;
 //BA.debugLineNum = 89;BA.debugLine="Private Sub CreateLabel As B4XView";
 //BA.debugLineNum = 90;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4j.objects.LabelWrapper();
 //BA.debugLineNum = 91;BA.debugLine="lbl.Initialize(\"lbl\")";
_lbl.Initialize(ba,"lbl");
 //BA.debugLineNum = 92;BA.debugLine="Return lbl";
if (true) return (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 93;BA.debugLine="End Sub";
return null;
}
public String  _createtoolbar(anywheresoftware.b4j.objects.DesignerArgs _designerargs) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _pnl = null;
anywheresoftware.b4a.objects.B4XViewWrapper _stublabel = null;
String _eventname = "";
anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _fnt = null;
int _i = 0;
String _text = "";
String _tag = "";
anywheresoftware.b4a.objects.B4XViewWrapper _lbl = null;
 //BA.debugLineNum = 64;BA.debugLine="Private Sub CreateToolbar (DesignerArgs As Designe";
 //BA.debugLineNum = 65;BA.debugLine="Dim pnl As B4XView = DesignerArgs.GetViewFromArgs";
_pnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_pnl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_designerargs.GetViewFromArgs((int) (0))));
 //BA.debugLineNum = 66;BA.debugLine="If DesignerArgs.FirstRun Then";
if (_designerargs.getFirstRun()) { 
 //BA.debugLineNum = 67;BA.debugLine="Dim StubLabel As B4XView = pnl.GetView(0)";
_stublabel = new anywheresoftware.b4a.objects.B4XViewWrapper();
_stublabel = _pnl.GetView((int) (0));
 //BA.debugLineNum = 68;BA.debugLine="StubLabel.RemoveViewFromParent";
_stublabel.RemoveViewFromParent();
 //BA.debugLineNum = 69;BA.debugLine="Dim EventName As String = DesignerArgs.Arguments";
_eventname = BA.ObjectToString(_designerargs.getArguments().Get((int) (1)));
 //BA.debugLineNum = 70;BA.debugLine="Dim fnt As B4XFont = StubLabel.Font";
_fnt = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont();
_fnt = _stublabel.getFont();
 //BA.debugLineNum = 71;BA.debugLine="For i = 2 To DesignerArgs.Arguments.Size - 1 Ste";
{
final int step7 = 2;
final int limit7 = (int) (_designerargs.getArguments().getSize()-1);
_i = (int) (2) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
 //BA.debugLineNum = 72;BA.debugLine="Dim text As String = DesignerArgs.Arguments.Get";
_text = BA.ObjectToString(_designerargs.getArguments().Get(_i));
 //BA.debugLineNum = 73;BA.debugLine="Dim tag As String = DesignerArgs.Arguments.Get(";
_tag = BA.ObjectToString(_designerargs.getArguments().Get((int) (_i+1)));
 //BA.debugLineNum = 74;BA.debugLine="Dim lbl As B4XView = CreateLabel";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = _createlabel();
 //BA.debugLineNum = 75;BA.debugLine="lbl.Font = fnt";
_lbl.setFont(_fnt);
 //BA.debugLineNum = 76;BA.debugLine="lbl.Text = text";
_lbl.setText(_text);
 //BA.debugLineNum = 77;BA.debugLine="lbl.TextColor = StubLabel.TextColor";
_lbl.setTextColor(_stublabel.getTextColor());
 //BA.debugLineNum = 78;BA.debugLine="lbl.SetTextAlignment(\"CENTER\", \"CENTER\")";
_lbl.SetTextAlignment("CENTER","CENTER");
 //BA.debugLineNum = 79;BA.debugLine="lbl.Tag = Array(DesignerArgs.LayoutModule, Even";
_lbl.setTag((Object)(new Object[]{_designerargs.getLayoutModule(),(Object)(_eventname),(Object)(_tag)}));
 //BA.debugLineNum = 80;BA.debugLine="pnl.AddView(lbl, 0, 0, 40dip, pnl.Height)";
_pnl.AddView((javafx.scene.Node)(_lbl.getObject()),0,0,__c.DipToCurrent((int) (40)),_pnl.getHeight());
 }
};
 }else {
 //BA.debugLineNum = 83;BA.debugLine="For i = 0 To pnl.NumberOfViews - 1";
{
final int step19 = 1;
final int limit19 = (int) (_pnl.getNumberOfViews()-1);
_i = (int) (0) ;
for (;_i <= limit19 ;_i = _i + step19 ) {
 //BA.debugLineNum = 84;BA.debugLine="pnl.GetView(i).Height = pnl.Height";
_pnl.GetView(_i).setHeight(_pnl.getHeight());
 }
};
 };
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.collections.List  _getalllayoutparents() throws Exception{
anywheresoftware.b4a.objects.collections.List _res = null;
anywheresoftware.b4a.objects.B4XViewWrapper _v = null;
 //BA.debugLineNum = 218;BA.debugLine="Public Sub GetAllLayoutParents As List";
 //BA.debugLineNum = 219;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 220;BA.debugLine="res.Initialize";
_res.Initialize();
 //BA.debugLineNum = 221;BA.debugLine="For Each v As B4XView In LayoutsMap.Keys";
_v = new anywheresoftware.b4a.objects.B4XViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group3 = _layoutsmap.Keys();
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_v = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(group3.Get(index3)));
 //BA.debugLineNum = 222;BA.debugLine="res.Add(v)";
_res.Add((Object)(_v.getObject()));
 }
};
 //BA.debugLineNum = 224;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 225;BA.debugLine="End Sub";
return null;
}
public int  _getcolor(String _name) throws Exception{
 //BA.debugLineNum = 49;BA.debugLine="Public Sub GetColor(Name As String) As Int";
 //BA.debugLineNum = 50;BA.debugLine="Return ColorMap.GetDefault(Name.ToLowerCase, xui.";
if (true) return (int)(BA.ObjectToNumber(_colormap.GetDefault((Object)(_name.toLowerCase(anywheresoftware.b4a.keywords.Common.stringLocale)),(Object)(_xui.Color_Black))));
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return 0;
}
public int  _getintfromstring(String _n) throws Exception{
 //BA.debugLineNum = 120;BA.debugLine="Private Sub GetIntFromString (n As String) As Int";
 //BA.debugLineNum = 121;BA.debugLine="If n.StartsWith(\"0x\") Then";
if (_n.startsWith("0x")) { 
 //BA.debugLineNum = 122;BA.debugLine="Return Bit.ParseLong(n.SubString(2), 16)";
if (true) return (int) (__c.Bit.ParseLong(_n.substring((int) (2)),(int) (16)));
 };
 //BA.debugLineNum = 124;BA.debugLine="Return n";
if (true) return (int)(Double.parseDouble(_n));
 //BA.debugLineNum = 125;BA.debugLine="End Sub";
return 0;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _getviewbyname(anywheresoftware.b4a.objects.B4XViewWrapper _layoutparent,String _name) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _res = null;
de.rwblinn.basic58.ddd._dddinternalviewsdata _data = null;
 //BA.debugLineNum = 258;BA.debugLine="Public Sub GetViewByName(LayoutParent As B4XView,";
 //BA.debugLineNum = 259;BA.debugLine="Dim res As B4XView";
_res = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 260;BA.debugLine="Name = Name.ToLowerCase";
_name = _name.toLowerCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 261;BA.debugLine="Dim data As DDDInternalViewsData = GetViewsData(L";
_data = _getviewsdata(_layoutparent,__c.False);
 //BA.debugLineNum = 262;BA.debugLine="If data <> Null Then";
if (_data!= null) { 
 //BA.debugLineNum = 263;BA.debugLine="res = data.NamesMap.Get(Name)";
_res = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_data.NamesMap /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)(_name))));
 };
 //BA.debugLineNum = 265;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 266;BA.debugLine="End Sub";
return null;
}
public de.rwblinn.basic58.ddd._dddviewdata  _getviewdata(anywheresoftware.b4a.objects.B4XViewWrapper _view) throws Exception{
 //BA.debugLineNum = 228;BA.debugLine="Public Sub GetViewData (View As B4XView) As DDDVie";
 //BA.debugLineNum = 229;BA.debugLine="Return GetViewDataImpl(View, False)";
if (true) return _getviewdataimpl(_view,__c.False);
 //BA.debugLineNum = 230;BA.debugLine="End Sub";
return null;
}
public de.rwblinn.basic58.ddd._dddviewdata  _getviewdataimpl(anywheresoftware.b4a.objects.B4XViewWrapper _view,boolean _createifneeded) throws Exception{
de.rwblinn.basic58.ddd._dddviewdata _vd = null;
 //BA.debugLineNum = 234;BA.debugLine="Private Sub GetViewDataImpl(View As B4XView, Creat";
 //BA.debugLineNum = 235;BA.debugLine="Dim vd As DDDViewData = ViewsData.Get(View)";
_vd = (de.rwblinn.basic58.ddd._dddviewdata)(_viewsdata.Get((Object)(_view.getObject())));
 //BA.debugLineNum = 236;BA.debugLine="If vd = Null And CreateIfNeeded Then";
if (_vd== null && _createifneeded) { 
 //BA.debugLineNum = 237;BA.debugLine="Dim vd As DDDViewData";
_vd = new de.rwblinn.basic58.ddd._dddviewdata();
 //BA.debugLineNum = 238;BA.debugLine="vd.Initialize";
_vd.Initialize();
 //BA.debugLineNum = 239;BA.debugLine="vd.Classes.Initialize";
_vd.Classes /*anywheresoftware.b4a.objects.collections.List*/ .Initialize();
 //BA.debugLineNum = 240;BA.debugLine="ViewsData.Put(View, vd)";
_viewsdata.Put((Object)(_view.getObject()),(Object)(_vd));
 };
 //BA.debugLineNum = 242;BA.debugLine="Return vd";
if (true) return _vd;
 //BA.debugLineNum = 243;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _getviewsbyclass(String _class,anywheresoftware.b4a.objects.B4XViewWrapper _layoutparent) throws Exception{
anywheresoftware.b4a.objects.collections.List _res = null;
de.rwblinn.basic58.ddd._dddinternalviewsdata _d = null;
de.rwblinn.basic58.ddd._dddinternalviewsdata _data = null;
 //BA.debugLineNum = 198;BA.debugLine="Public Sub GetViewsByClass(Class As String, Layout";
 //BA.debugLineNum = 199;BA.debugLine="Class = Class.ToLowerCase";
_class = _class.toLowerCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 200;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 201;BA.debugLine="res.Initialize";
_res.Initialize();
 //BA.debugLineNum = 202;BA.debugLine="If Initialized(LayoutParent) Then";
if (__c.Initialized((Object)(_layoutparent))) { 
 //BA.debugLineNum = 203;BA.debugLine="Dim d As DDDInternalViewsData = GetViewsData(Lay";
_d = _getviewsdata(_layoutparent,__c.False);
 //BA.debugLineNum = 204;BA.debugLine="If Initialized(d) And d.ClassesMap.ContainsKey(C";
if (__c.Initialized((Object)(_d)) && _d.ClassesMap /*anywheresoftware.b4a.objects.collections.Map*/ .ContainsKey((Object)(_class))) { 
 //BA.debugLineNum = 205;BA.debugLine="res.AddAll(d.ClassesMap.Get(Class))";
_res.AddAll((anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_d.ClassesMap /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)(_class)))));
 };
 }else {
 //BA.debugLineNum = 208;BA.debugLine="For Each data As DDDInternalViewsData In Layouts";
{
final anywheresoftware.b4a.BA.IterableList group10 = _layoutsmap.Values();
final int groupLen10 = group10.getSize()
;int index10 = 0;
;
for (; index10 < groupLen10;index10++){
_data = (de.rwblinn.basic58.ddd._dddinternalviewsdata)(group10.Get(index10));
 //BA.debugLineNum = 209;BA.debugLine="If data.ClassesMap.ContainsKey(Class) Then";
if (_data.ClassesMap /*anywheresoftware.b4a.objects.collections.Map*/ .ContainsKey((Object)(_class))) { 
 //BA.debugLineNum = 210;BA.debugLine="res.AddAll(data.ClassesMap.Get(Class))";
_res.AddAll((anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_data.ClassesMap /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)(_class)))));
 };
 }
};
 };
 //BA.debugLineNum = 214;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 215;BA.debugLine="End Sub";
return null;
}
public de.rwblinn.basic58.ddd._dddinternalviewsdata  _getviewsdata(anywheresoftware.b4a.objects.B4XViewWrapper _parent,boolean _createifneeded) throws Exception{
de.rwblinn.basic58.ddd._dddinternalviewsdata _data = null;
 //BA.debugLineNum = 245;BA.debugLine="Private Sub GetViewsData(parent As B4XView, create";
 //BA.debugLineNum = 246;BA.debugLine="Dim data As DDDInternalViewsData = LayoutsMap.Get";
_data = (de.rwblinn.basic58.ddd._dddinternalviewsdata)(_layoutsmap.Get((Object)(_parent.getObject())));
 //BA.debugLineNum = 247;BA.debugLine="If data = Null And createIfNeeded Then";
if (_data== null && _createifneeded) { 
 //BA.debugLineNum = 248;BA.debugLine="Dim data As DDDInternalViewsData";
_data = new de.rwblinn.basic58.ddd._dddinternalviewsdata();
 //BA.debugLineNum = 249;BA.debugLine="data.Initialize";
_data.Initialize();
 //BA.debugLineNum = 250;BA.debugLine="data.NamesMap.Initialize";
_data.NamesMap /*anywheresoftware.b4a.objects.collections.Map*/ .Initialize();
 //BA.debugLineNum = 251;BA.debugLine="data.ClassesMap.Initialize";
_data.ClassesMap /*anywheresoftware.b4a.objects.collections.Map*/ .Initialize();
 //BA.debugLineNum = 252;BA.debugLine="LayoutsMap.Put(parent, data)";
_layoutsmap.Put((Object)(_parent.getObject()),(Object)(_data));
 };
 //BA.debugLineNum = 254;BA.debugLine="Return data";
if (true) return _data;
 //BA.debugLineNum = 255;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 18;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 19;BA.debugLine="LayoutsMap.Initialize";
_layoutsmap.Initialize();
 //BA.debugLineNum = 20;BA.debugLine="ViewsData.Initialize";
_viewsdata.Initialize();
 //BA.debugLineNum = 21;BA.debugLine="ColorMap = CreateMap(\"black\": xui.Color_Black, _";
_colormap = __c.createMap(new Object[] {(Object)("black"),(Object)(_xui.Color_Black),(Object)("darkgray"),(Object)(_xui.Color_DarkGray),(Object)("gray"),(Object)(_xui.Color_Gray),(Object)("lightgray"),(Object)(_xui.Color_LightGray),(Object)("white"),(Object)(_xui.Color_White),(Object)("red"),(Object)(_xui.Color_Red),(Object)("green"),(Object)(_xui.Color_Green),(Object)("blue"),(Object)(_xui.Color_Blue),(Object)("yellow"),(Object)(_xui.Color_Yellow),(Object)("cyan"),(Object)(_xui.Color_Cyan),(Object)("magenta"),(Object)(_xui.Color_Magenta),(Object)("transparent"),(Object)(_xui.Color_Transparent)});
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public boolean  _isfirstrun(anywheresoftware.b4j.objects.DesignerArgs _designerargs) throws Exception{
 //BA.debugLineNum = 128;BA.debugLine="Private Sub IsFirstRun(DesignerArgs As DesignerArg";
 //BA.debugLineNum = 129;BA.debugLine="Return DesignerArgs.FirstRun";
if (true) return _designerargs.getFirstRun();
 //BA.debugLineNum = 130;BA.debugLine="End Sub";
return false;
}
public String  _lbl_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 96;BA.debugLine="Private Sub lbl_MouseClicked (EventData As MouseEv";
 //BA.debugLineNum = 97;BA.debugLine="RaiseToolbarEvent(Sender, Sender.As(B4XView).Tag)";
_raisetoolbarevent((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(__c.Sender(ba))),(Object[])(((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(__c.Sender(ba)))).getTag()));
 //BA.debugLineNum = 98;BA.debugLine="EventData.Consume";
_eventdata.Consume();
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return "";
}
public void  _raisetoolbarevent(anywheresoftware.b4a.objects.B4XViewWrapper _lbl,Object[] _data) throws Exception{
ResumableSub_RaiseToolbarEvent rsub = new ResumableSub_RaiseToolbarEvent(this,_lbl,_data);
rsub.resume(ba, null);
}
public static class ResumableSub_RaiseToolbarEvent extends BA.ResumableSub {
public ResumableSub_RaiseToolbarEvent(de.rwblinn.basic58.ddd parent,anywheresoftware.b4a.objects.B4XViewWrapper _lbl,Object[] _data) {
this.parent = parent;
this._lbl = _lbl;
this._data = _data;
}
de.rwblinn.basic58.ddd parent;
anywheresoftware.b4a.objects.B4XViewWrapper _lbl;
Object[] _data;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 107;BA.debugLine="CallSubDelayed2(Data(0), Data(1) & \"_click\", Data";
parent.__c.CallSubDelayed2(ba,_data[(int) (0)],BA.ObjectToString(_data[(int) (1)])+"_click",_data[(int) (2)]);
 //BA.debugLineNum = 108;BA.debugLine="If ToolbarPressedColor <> 0 Then";
if (true) break;

case 1:
//if
this.state = 4;
if (parent._toolbarpressedcolor!=0) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 109;BA.debugLine="lbl.SetColorAnimated(100, xui.Color_Transparent,";
_lbl.SetColorAnimated((int) (100),parent._xui.Color_Transparent,parent._toolbarpressedcolor);
 //BA.debugLineNum = 110;BA.debugLine="Sleep(100)";
parent.__c.Sleep(ba,this,(int) (100));
this.state = 5;
return;
case 5:
//C
this.state = 4;
;
 //BA.debugLineNum = 111;BA.debugLine="lbl.SetColorAnimated(100, ToolbarPressedColor, x";
_lbl.SetColorAnimated((int) (100),parent._toolbarpressedcolor,parent._xui.Color_Transparent);
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 113;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _removelayoutdata(anywheresoftware.b4a.objects.B4XViewWrapper _layoutparent) throws Exception{
de.rwblinn.basic58.ddd._dddinternalviewsdata _data = null;
anywheresoftware.b4a.objects.B4XViewWrapper _v = null;
 //BA.debugLineNum = 162;BA.debugLine="Public Sub RemoveLayoutData(LayoutParent As B4XVie";
 //BA.debugLineNum = 163;BA.debugLine="Dim Data As DDDInternalViewsData = GetViewsData(L";
_data = _getviewsdata(_layoutparent,__c.False);
 //BA.debugLineNum = 164;BA.debugLine="If Data = Null Then Return";
if (_data== null) { 
if (true) return "";};
 //BA.debugLineNum = 165;BA.debugLine="For Each v As B4XView In Data.NamesMap.Values";
_v = new anywheresoftware.b4a.objects.B4XViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group3 = _data.NamesMap /*anywheresoftware.b4a.objects.collections.Map*/ .Values();
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_v = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(group3.Get(index3)));
 //BA.debugLineNum = 166;BA.debugLine="ViewsData.Remove(v)";
_viewsdata.Remove((Object)(_v.getObject()));
 }
};
 //BA.debugLineNum = 168;BA.debugLine="LayoutsMap.Remove(LayoutParent)";
_layoutsmap.Remove((Object)(_layoutparent.getObject()));
 //BA.debugLineNum = 169;BA.debugLine="End Sub";
return "";
}
public String  _settext(anywheresoftware.b4j.objects.DesignerArgs _designerargs) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _v = null;
String _text = "";
anywheresoftware.b4a.objects.collections.List _fnt = null;
int _i = 0;
 //BA.debugLineNum = 298;BA.debugLine="Private Sub SetText(DesignerArgs As DesignerArgs)";
 //BA.debugLineNum = 299;BA.debugLine="Dim v As B4XView = DesignerArgs.GetViewFromArgs(0";
_v = new anywheresoftware.b4a.objects.B4XViewWrapper();
_v = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_designerargs.GetViewFromArgs((int) (0))));
 //BA.debugLineNum = 300;BA.debugLine="If v.IsInitialized = False Then Return";
if (_v.IsInitialized()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 301;BA.debugLine="Dim Text As String";
_text = "";
 //BA.debugLineNum = 302;BA.debugLine="Dim fnt As List = Array(v.Font)";
_fnt = new anywheresoftware.b4a.objects.collections.List();
_fnt = anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_v.getFont().getObject())});
 //BA.debugLineNum = 303;BA.debugLine="For i = 1 To DesignerArgs.Arguments.Size - 1";
{
final int step5 = 1;
final int limit5 = (int) (_designerargs.getArguments().getSize()-1);
_i = (int) (1) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 304;BA.debugLine="Text = DesignerArgs.Arguments.Get(i)";
_text = BA.ObjectToString(_designerargs.getArguments().Get(_i));
 //BA.debugLineNum = 305;BA.debugLine="If SetTextHelper(v, Text, fnt) Then Exit";
if (_settexthelper(_v,_text,_fnt)) { 
if (true) break;};
 }
};
 //BA.debugLineNum = 307;BA.debugLine="End Sub";
return "";
}
public String  _settextandsize(anywheresoftware.b4j.objects.DesignerArgs _designerargs) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _v = null;
int _originaltextsize = 0;
String _text = "";
anywheresoftware.b4a.objects.collections.List _fnts = null;
float _f = 0f;
int _i = 0;
 //BA.debugLineNum = 310;BA.debugLine="Private Sub SetTextAndSize(DesignerArgs As Designe";
 //BA.debugLineNum = 311;BA.debugLine="Dim v As B4XView = DesignerArgs.GetViewFromArgs(0";
_v = new anywheresoftware.b4a.objects.B4XViewWrapper();
_v = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_designerargs.GetViewFromArgs((int) (0))));
 //BA.debugLineNum = 312;BA.debugLine="Dim OriginalTextSize As Int = DesignerArgs.Argume";
_originaltextsize = (int)(BA.ObjectToNumber(_designerargs.getArguments().Get((int) (1))));
 //BA.debugLineNum = 313;BA.debugLine="If v.IsInitialized = False Then Return";
if (_v.IsInitialized()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 314;BA.debugLine="Dim Text As String";
_text = "";
 //BA.debugLineNum = 315;BA.debugLine="Dim fnts As List";
_fnts = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 324;BA.debugLine="If fnts.IsInitialized = False Then";
if (_fnts.IsInitialized()==__c.False) { 
 //BA.debugLineNum = 325;BA.debugLine="fnts.Initialize";
_fnts.Initialize();
 //BA.debugLineNum = 326;BA.debugLine="For Each f As Float In textSizesSteps";
{
final float[] group8 = _textsizessteps;
final int groupLen8 = group8.length
;int index8 = 0;
;
for (; index8 < groupLen8;index8++){
_f = group8[index8];
 //BA.debugLineNum = 327;BA.debugLine="fnts.Add(xui.CreateFont2(v.Font, OriginalTextSi";
_fnts.Add((Object)(_xui.CreateFont2(_v.getFont(),(float) (_originaltextsize*_f)).getObject()));
 }
};
 };
 //BA.debugLineNum = 330;BA.debugLine="For i = 2 To DesignerArgs.Arguments.Size - 1";
{
final int step12 = 1;
final int limit12 = (int) (_designerargs.getArguments().getSize()-1);
_i = (int) (2) ;
for (;_i <= limit12 ;_i = _i + step12 ) {
 //BA.debugLineNum = 331;BA.debugLine="Text = DesignerArgs.Arguments.Get(i)";
_text = BA.ObjectToString(_designerargs.getArguments().Get(_i));
 //BA.debugLineNum = 332;BA.debugLine="If SetTextHelper(v, Text, fnts) Then Exit";
if (_settexthelper(_v,_text,_fnts)) { 
if (true) break;};
 }
};
 //BA.debugLineNum = 334;BA.debugLine="v.Text = Text";
_v.setText(_text);
 //BA.debugLineNum = 335;BA.debugLine="End Sub";
return "";
}
public boolean  _settexthelper(anywheresoftware.b4a.objects.B4XViewWrapper _view,String _text,anywheresoftware.b4a.objects.collections.List _fonts) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _fnt = null;
int _width = 0;
 //BA.debugLineNum = 337;BA.debugLine="Private Sub SetTextHelper(View As B4XView, text As";
 //BA.debugLineNum = 338;BA.debugLine="CreateCVSIfNeeded";
_createcvsifneeded();
 //BA.debugLineNum = 339;BA.debugLine="For Each fnt As B4XFont In Fonts";
_fnt = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont();
{
final anywheresoftware.b4a.BA.IterableList group2 = _fonts;
final int groupLen2 = group2.getSize()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_fnt = (anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont(), (javafx.scene.text.Font)(group2.Get(index2)));
 //BA.debugLineNum = 340;BA.debugLine="Dim width As Int = cvs.MeasureText(text, fnt).Wi";
_width = (int) (_cvs.MeasureText(_text,_fnt).getWidth());
 //BA.debugLineNum = 341;BA.debugLine="If width + 30dip < View.Width Then";
if (_width+__c.DipToCurrent((int) (30))<_view.getWidth()) { 
 //BA.debugLineNum = 342;BA.debugLine="If Fonts.Size > 1 Then";
if (_fonts.getSize()>1) { 
 //BA.debugLineNum = 343;BA.debugLine="View.Font = fnt";
_view.setFont(_fnt);
 };
 //BA.debugLineNum = 345;BA.debugLine="Return True";
if (true) return __c.True;
 };
 }
};
 //BA.debugLineNum = 348;BA.debugLine="Return False";
if (true) return __c.False;
 //BA.debugLineNum = 349;BA.debugLine="End Sub";
return false;
}
public String  _settextsizesteps(anywheresoftware.b4j.objects.DesignerArgs _designerargs) throws Exception{
int _i = 0;
 //BA.debugLineNum = 269;BA.debugLine="Private Sub SetTextSizeSteps(DesignerArgs As Desig";
 //BA.debugLineNum = 270;BA.debugLine="If textSizesSteps.Length <> DesignerArgs.Argument";
if (_textsizessteps.length!=_designerargs.getArguments().getSize()) { 
 //BA.debugLineNum = 271;BA.debugLine="Dim textSizesSteps(DesignerArgs.Arguments.Size)";
_textsizessteps = new float[_designerargs.getArguments().getSize()];
;
 };
 //BA.debugLineNum = 273;BA.debugLine="For i = 0 To textSizesSteps.Length - 1";
{
final int step4 = 1;
final int limit4 = (int) (_textsizessteps.length-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 274;BA.debugLine="textSizesSteps(i) = DesignerArgs.Arguments.Get(i";
_textsizessteps[_i] = (float)(BA.ObjectToNumber(_designerargs.getArguments().Get(_i)));
 }
};
 //BA.debugLineNum = 276;BA.debugLine="End Sub";
return "";
}
public String  _setviewnameandparent(de.rwblinn.basic58.ddd._dddinternalviewsdata _data,anywheresoftware.b4a.objects.B4XViewWrapper _view,String _name,anywheresoftware.b4a.objects.B4XViewWrapper _layoutparent) throws Exception{
de.rwblinn.basic58.ddd._dddviewdata _vd = null;
 //BA.debugLineNum = 142;BA.debugLine="Private Sub SetViewNameAndParent(Data As DDDIntern";
 //BA.debugLineNum = 143;BA.debugLine="Data.NamesMap.Put(Name, View)";
_data.NamesMap /*anywheresoftware.b4a.objects.collections.Map*/ .Put((Object)(_name),(Object)(_view.getObject()));
 //BA.debugLineNum = 144;BA.debugLine="Dim vd As DDDViewData = GetViewDataImpl(View, Tru";
_vd = _getviewdataimpl(_view,__c.True);
 //BA.debugLineNum = 145;BA.debugLine="vd.Name = Name";
_vd.Name /*String*/  = _name;
 //BA.debugLineNum = 146;BA.debugLine="vd.LayoutParent = LayoutParent";
_vd.LayoutParent /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = _layoutparent;
 //BA.debugLineNum = 147;BA.debugLine="End Sub";
return "";
}
public String  _spreadcontrolshorizontally(anywheresoftware.b4j.objects.DesignerArgs _designerargs) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _panel = null;
int _maxsize = 0;
int _mingap = 0;
int _allwidth = 0;
int _w = 0;
int _gap = 0;
int _i = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _v = null;
 //BA.debugLineNum = 280;BA.debugLine="Private Sub SpreadControlsHorizontally (DesignerAr";
 //BA.debugLineNum = 281;BA.debugLine="Dim Panel As B4XView = DesignerArgs.GetViewFromAr";
_panel = new anywheresoftware.b4a.objects.B4XViewWrapper();
_panel = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_designerargs.GetViewFromArgs((int) (0))));
 //BA.debugLineNum = 282;BA.debugLine="If Panel.IsInitialized = False Then Return";
if (_panel.IsInitialized()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 283;BA.debugLine="Dim MaxSize As Int = DesignerArgs.Arguments.Get(1";
_maxsize = (int)(BA.ObjectToNumber(_designerargs.getArguments().Get((int) (1))));
 //BA.debugLineNum = 284;BA.debugLine="If MaxSize = 0 Then MaxSize = 0x7fffffff";
if (_maxsize==0) { 
_maxsize = ((int)0x7fffffff);};
 //BA.debugLineNum = 285;BA.debugLine="Dim MinGap As Int = DesignerArgs.Arguments.Get(2)";
_mingap = (int)(BA.ObjectToNumber(_designerargs.getArguments().Get((int) (2))));
 //BA.debugLineNum = 286;BA.debugLine="Dim AllWidth As Int = Panel.Width";
_allwidth = (int) (_panel.getWidth());
 //BA.debugLineNum = 287;BA.debugLine="Dim w As Int = Min(AllWidth / Panel.NumberOfViews";
_w = (int) (__c.Min(_allwidth/(double)_panel.getNumberOfViews()-_mingap,_maxsize));
 //BA.debugLineNum = 288;BA.debugLine="Dim gap As Int = (AllWidth - Panel.NumberOfViews";
_gap = (int) ((_allwidth-_panel.getNumberOfViews()*_w)/(double)_panel.getNumberOfViews());
 //BA.debugLineNum = 289;BA.debugLine="For i = 0 To Panel.NumberOfViews - 1";
{
final int step9 = 1;
final int limit9 = (int) (_panel.getNumberOfViews()-1);
_i = (int) (0) ;
for (;_i <= limit9 ;_i = _i + step9 ) {
 //BA.debugLineNum = 290;BA.debugLine="Dim v As B4XView = Panel.GetView(i)";
_v = new anywheresoftware.b4a.objects.B4XViewWrapper();
_v = _panel.GetView(_i);
 //BA.debugLineNum = 291;BA.debugLine="v.SetLayoutAnimated(0, (i + 0.5) * gap + i * w,";
_v.SetLayoutAnimated((int) (0),(_i+0.5)*_gap+_i*_w,_v.getTop(),_w,_v.getHeight());
 }
};
 //BA.debugLineNum = 293;BA.debugLine="End Sub";
return "";
}
public String  _tochr(anywheresoftware.b4j.objects.DesignerArgs _designerargs) throws Exception{
 //BA.debugLineNum = 116;BA.debugLine="Private Sub ToChr(DesignerArgs As DesignerArgs) As";
 //BA.debugLineNum = 117;BA.debugLine="Return \"\" & Chr(GetIntFromString(DesignerArgs.Arg";
if (true) return ""+BA.ObjectToString(__c.Chr(_getintfromstring(BA.ObjectToString(_designerargs.getArguments().Get((int) (0))))));
 //BA.debugLineNum = 118;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
