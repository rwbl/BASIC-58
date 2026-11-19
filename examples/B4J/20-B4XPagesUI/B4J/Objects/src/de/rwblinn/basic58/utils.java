package de.rwblinn.basic58;


import anywheresoftware.b4a.BA;

public class utils extends Object{
public static utils mostCurrent = new utils();

public static BA ba;
static {
		ba = new  anywheresoftware.b4j.objects.FxBA("de.rwblinn.basic58", "de.rwblinn.basic58.utils", null);
		ba.loadHtSubs(utils.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "de.rwblinn.basic58.utils", ba);
		}
	}
    public static Class<?> getObject() {
		return utils.class;
	}

 public static anywheresoftware.b4a.keywords.Common __c = null;
public static b4j.example.cssutils _cssutils = null;
public static de.rwblinn.basic58.main _main = null;
public static de.rwblinn.basic58.b4xpages _b4xpages = null;
public static de.rwblinn.basic58.b4xcollections _b4xcollections = null;
public static de.rwblinn.basic58.b58protocol _b58protocol = null;
public static de.rwblinn.basic58.b58help _b58help = null;
public static String  _callsubmethod(Object _callback,String _event,String _name) throws Exception{
String _eventname = "";
 //BA.debugLineNum = 87;BA.debugLine="Public Sub CallSubMethod(callback As Object, event";
 //BA.debugLineNum = 88;BA.debugLine="Dim eventname As String = $\"${event}${name}\"$";
_eventname = (""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_event))+""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_name))+"");
 //BA.debugLineNum = 89;BA.debugLine="If SubExists(callback, eventname) Then";
if (anywheresoftware.b4a.keywords.Common.SubExists(ba,_callback,_eventname)) { 
 //BA.debugLineNum = 91;BA.debugLine="CallSubDelayed(callback, eventname)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(ba,_callback,_eventname);
 };
 //BA.debugLineNum = 93;BA.debugLine="End Sub";
return "";
}
public static String  _callsubmethod2(Object _callback,String _event,String _name,Object _arg1) throws Exception{
String _eventname = "";
 //BA.debugLineNum = 95;BA.debugLine="Public Sub CallSubMethod2(callback As Object, even";
 //BA.debugLineNum = 96;BA.debugLine="Dim eventname As String = $\"${event}${name}\"$";
_eventname = (""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_event))+""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_name))+"");
 //BA.debugLineNum = 97;BA.debugLine="If SubExists(callback, eventname) Then";
if (anywheresoftware.b4a.keywords.Common.SubExists(ba,_callback,_eventname)) { 
 //BA.debugLineNum = 99;BA.debugLine="CallSubDelayed2(callback, eventname, arg1)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(ba,_callback,_eventname,_arg1);
 };
 //BA.debugLineNum = 101;BA.debugLine="End Sub";
return "";
}
public static String  _callsubmethod3(Object _callback,String _event,String _name,Object _arg1,Object _arg2) throws Exception{
String _eventname = "";
 //BA.debugLineNum = 103;BA.debugLine="Public Sub CallSubMethod3(callback As Object, even";
 //BA.debugLineNum = 104;BA.debugLine="Dim eventname As String = $\"${event}${name}\"$";
_eventname = (""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_event))+""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_name))+"");
 //BA.debugLineNum = 105;BA.debugLine="If SubExists(callback, eventname) Then";
if (anywheresoftware.b4a.keywords.Common.SubExists(ba,_callback,_eventname)) { 
 //BA.debugLineNum = 107;BA.debugLine="CallSubDelayed3(callback, eventname, arg1, arg2)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed3(ba,_callback,_eventname,_arg1,_arg2);
 };
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
return "";
}
public static String  _convertbasictexttoupper(String _source) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _result = null;
boolean _instring = false;
int _i = 0;
String _c = "";
 //BA.debugLineNum = 55;BA.debugLine="Public Sub ConvertBasicTextToUpper(Source As Strin";
 //BA.debugLineNum = 56;BA.debugLine="Dim Result As StringBuilder";
_result = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 57;BA.debugLine="Result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 59;BA.debugLine="Dim InString As Boolean = False";
_instring = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 61;BA.debugLine="For i = 0 To Source.Length - 1";
{
final int step4 = 1;
final int limit4 = (int) (_source.length()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 62;BA.debugLine="Dim c As String = Source.SubString2(i, i + 1)";
_c = _source.substring(_i,(int) (_i+1));
 //BA.debugLineNum = 64;BA.debugLine="If c = Chr(34) Then";
if ((_c).equals(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (34))))) { 
 //BA.debugLineNum = 65;BA.debugLine="InString = Not(InString)";
_instring = anywheresoftware.b4a.keywords.Common.Not(_instring);
 //BA.debugLineNum = 66;BA.debugLine="Result.Append(c)";
_result.Append(_c);
 }else if(_instring) { 
 //BA.debugLineNum = 68;BA.debugLine="Result.Append(c)";
_result.Append(_c);
 }else {
 //BA.debugLineNum = 70;BA.debugLine="Result.Append(c.ToUpperCase)";
_result.Append(_c.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale));
 };
 }
};
 //BA.debugLineNum = 74;BA.debugLine="Return Result.ToString";
if (true) return _result.ToString();
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public static String  _formatnumber(double _value) throws Exception{
String _result = "";
 //BA.debugLineNum = 17;BA.debugLine="Public Sub FormatNumber(Value As Double) As String";
 //BA.debugLineNum = 18;BA.debugLine="Dim Result As String = NumberFormat2(Value, 1, 0,";
_result = anywheresoftware.b4a.keywords.Common.NumberFormat2(_value,(int) (1),(int) (0),(int) (6),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 20;BA.debugLine="Do While Result.Contains(\".\") And Result.EndsWith";
while (_result.contains(".") && _result.endsWith("0")) {
 //BA.debugLineNum = 21;BA.debugLine="Result = Result.SubString2(0, Result.Length - 1)";
_result = _result.substring((int) (0),(int) (_result.length()-1));
 }
;
 //BA.debugLineNum = 24;BA.debugLine="If Result.EndsWith(\".\") Then";
if (_result.endsWith(".")) { 
 //BA.debugLineNum = 25;BA.debugLine="Result = Result.SubString2(0, Result.Length - 1)";
_result = _result.substring((int) (0),(int) (_result.length()-1));
 };
 //BA.debugLineNum = 28;BA.debugLine="Return Result";
if (true) return _result;
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
public static String  _getfilename(String _path) throws Exception{
anywheresoftware.b4j.object.JavaObject _fileo = null;
 //BA.debugLineNum = 32;BA.debugLine="Public Sub GetFileName(path As String) As String";
 //BA.debugLineNum = 34;BA.debugLine="Dim fileO As JavaObject";
_fileo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 36;BA.debugLine="fileO.InitializeNewInstance(\"java.io.File\", Array";
_fileo.InitializeNewInstance("java.io.File",new Object[]{(Object)(_path)});
 //BA.debugLineNum = 38;BA.debugLine="Return fileO.RunMethod(\"getName\", Null)";
if (true) return BA.ObjectToString(_fileo.RunMethod("getName",(Object[])(anywheresoftware.b4a.keywords.Common.Null)));
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
return "";
}
public static String  _getfilepath(String _path) throws Exception{
anywheresoftware.b4j.object.JavaObject _fileo = null;
String _n = "";
String _p = "";
 //BA.debugLineNum = 42;BA.debugLine="Public Sub GetFilePath(path As String) As String";
 //BA.debugLineNum = 44;BA.debugLine="Dim fileO As JavaObject";
_fileo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 46;BA.debugLine="fileO.InitializeNewInstance(\"java.io.File\", Array";
_fileo.InitializeNewInstance("java.io.File",new Object[]{(Object)(_path)});
 //BA.debugLineNum = 48;BA.debugLine="Dim n As String = fileO.RunMethod(\"getName\", Null";
_n = BA.ObjectToString(_fileo.RunMethod("getName",(Object[])(anywheresoftware.b4a.keywords.Common.Null)));
 //BA.debugLineNum = 49;BA.debugLine="Dim p As String = fileO.RunMethod(\"getPath\", Null";
_p = BA.ObjectToString(_fileo.RunMethod("getPath",(Object[])(anywheresoftware.b4a.keywords.Common.Null)));
 //BA.debugLineNum = 50;BA.debugLine="p = p.Replace(n, \"\")";
_p = _p.replace(_n,"");
 //BA.debugLineNum = 51;BA.debugLine="Return p";
if (true) return _p;
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Private Sub Process_Globals";
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return "";
}
}
