package de.rwblinn.basic58;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class b58system extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("de.rwblinn.basic58", "de.rwblinn.basic58.b58system", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", de.rwblinn.basic58.b58system.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public Object _mcallback = null;
public String _meventname = "";
public b4j.example.cssutils _cssutils = null;
public de.rwblinn.basic58.main _main = null;
public de.rwblinn.basic58.b4xpages _b4xpages = null;
public de.rwblinn.basic58.b4xcollections _b4xcollections = null;
public de.rwblinn.basic58.b58protocol _b58protocol = null;
public de.rwblinn.basic58.utils _utils = null;
public de.rwblinn.basic58.b58help _b58help = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 11;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 13;BA.debugLine="Private mCallback As Object";
_mcallback = new Object();
 //BA.debugLineNum = 14;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return "";
}
public String  _executecommand(String _command) throws Exception{
String _systime = "";
 //BA.debugLineNum = 24;BA.debugLine="Public Sub ExecuteCommand(Command As String)";
 //BA.debugLineNum = 26;BA.debugLine="Select Case Command.Trim.ToUpperCase";
switch (BA.switchObjectToInt(_command.trim().toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale),"SHOW TIME","SHOW DATE")) {
case 0: {
 //BA.debugLineNum = 28;BA.debugLine="Dim systime As String = $\"SYSTEM TIME: ${DateTi";
_systime = ("SYSTEM TIME: "+__c.SmartStringFormatter("",(Object)(__c.DateTime.Time(__c.DateTime.getNow())))+"");
 //BA.debugLineNum = 29;BA.debugLine="Utils.CallSubMethod2(mCallback, mEventName, \"_O";
_utils._callsubmethod2 /*String*/ (_mcallback,_meventname,"_Output",(Object)(_systime));
 break; }
case 1: {
 //BA.debugLineNum = 31;BA.debugLine="Dim systime As String = $\"SYSTEM DATE: ${DateTi";
_systime = ("SYSTEM DATE: "+__c.SmartStringFormatter("",(Object)(__c.DateTime.Date(__c.DateTime.getNow())))+"");
 //BA.debugLineNum = 32;BA.debugLine="Utils.CallSubMethod2(mCallback, mEventName, \"_O";
_utils._callsubmethod2 /*String*/ (_mcallback,_meventname,"_Output",(Object)(_systime));
 break; }
default: {
 //BA.debugLineNum = 34;BA.debugLine="Log(\"[BASIC-58][E] Unknown system command.\")";
__c.LogImpl("923724042","[BASIC-58][E] Unknown system command.",0);
 break; }
}
;
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 18;BA.debugLine="Public Sub Initialize(Callback As Object, EventNam";
 //BA.debugLineNum = 20;BA.debugLine="mCallback = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 21;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
