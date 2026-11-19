package de.rwblinn.basic58;


import anywheresoftware.b4a.BA;

public class main extends javafx.application.Application{
public static main mostCurrent = new main();

public static BA ba;
static {
		ba = new  anywheresoftware.b4j.objects.FxBA("de.rwblinn.basic58", "de.rwblinn.basic58.main", null);
		ba.loadHtSubs(main.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "de.rwblinn.basic58.main", ba);
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}

 
    public static void main(String[] args) {
    	launch(args);
    }
    public void start (javafx.stage.Stage stage) {
        try {
            if (!false)
                System.setProperty("prism.lcdtext", "false");
            anywheresoftware.b4j.objects.FxBA.application = this;
		    anywheresoftware.b4a.keywords.Common.setDensity(javafx.stage.Screen.getPrimary().getDpi());
            anywheresoftware.b4a.keywords.Common.LogDebug("Program started.");
            initializeProcessGlobals();
            anywheresoftware.b4j.objects.Form frm = new anywheresoftware.b4j.objects.Form();
            frm.initWithStage(ba, stage, 800, 700);
            ba.raiseEvent(null, "appstart", frm, (String[])getParameters().getRaw().toArray(new String[0]));
        } catch (Throwable t) {
            BA.printException(t, true);
            System.exit(1);
        }
    }
public static anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4j.objects.JFX _fx = null;
public static anywheresoftware.b4j.objects.Form _mainform = null;
public static b4j.example.cssutils _cssutils = null;
public static b4j.example.b58protocol _b58protocol = null;
public static b4j.example.utils _utils = null;
public static b4j.example.b58help _b58help = null;
public static de.rwblinn.basic58.b4xpages _b4xpages = null;
public static de.rwblinn.basic58.b4xcollections _b4xcollections = null;
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
 //BA.debugLineNum = 38;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
 //BA.debugLineNum = 39;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return false;
}
public static String  _appstart(anywheresoftware.b4j.objects.Form _form1,String[] _args) throws Exception{
de.rwblinn.basic58.b4xpagesmanager _pagesmanager = null;
 //BA.debugLineNum = 30;BA.debugLine="Sub AppStart (Form1 As Form, Args() As String)";
 //BA.debugLineNum = 31;BA.debugLine="MainForm = Form1";
_mainform = _form1;
 //BA.debugLineNum = 32;BA.debugLine="MainForm.Show";
_mainform.Show();
 //BA.debugLineNum = 33;BA.debugLine="Dim PagesManager As B4XPagesManager";
_pagesmanager = new de.rwblinn.basic58.b4xpagesmanager();
 //BA.debugLineNum = 34;BA.debugLine="PagesManager.Initialize(MainForm)";
_pagesmanager._initialize /*String*/ (ba,_mainform);
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return "";
}
public static String  _cbcommands_valuechanged(Object _value) throws Exception{
 //BA.debugLineNum = 65;BA.debugLine="Private Sub cbCommands_ValueChanged (Value As Obje";
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public static String  _mainform_closed() throws Exception{
 //BA.debugLineNum = 52;BA.debugLine="Sub MainForm_Closed";
 //BA.debugLineNum = 53;BA.debugLine="B4XPages.Delegate.MainForm_Closed";
_b4xpages._delegate /*de.rwblinn.basic58.b4xpagesdelegator*/ ._mainform_closed /*String*/ ();
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}
public static String  _mainform_closerequest(anywheresoftware.b4j.objects.NodeWrapper.ConcreteEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 56;BA.debugLine="Sub MainForm_CloseRequest (EventData As Event)";
 //BA.debugLineNum = 57;BA.debugLine="B4XPages.Delegate.MainForm_CloseRequest(EventData";
_b4xpages._delegate /*de.rwblinn.basic58.b4xpagesdelegator*/ ._mainform_closerequest /*String*/ (_eventdata);
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public static String  _mainform_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 44;BA.debugLine="Sub MainForm_FocusChanged (HasFocus As Boolean)";
 //BA.debugLineNum = 45;BA.debugLine="B4XPages.Delegate.MainForm_FocusChanged(HasFocus)";
_b4xpages._delegate /*de.rwblinn.basic58.b4xpagesdelegator*/ ._mainform_focuschanged /*String*/ (_hasfocus);
 //BA.debugLineNum = 46;BA.debugLine="End Sub";
return "";
}
public static String  _mainform_iconifiedchanged(boolean _iconified) throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Public Sub MainForm_IconifiedChanged (Iconified As";
 //BA.debugLineNum = 61;BA.debugLine="B4XPages.Delegate.MainForm_IconifiedChanged(Iconi";
_b4xpages._delegate /*de.rwblinn.basic58.b4xpagesdelegator*/ ._mainform_iconifiedchanged /*String*/ (_iconified);
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public static String  _mainform_resize(double _width,double _height) throws Exception{
 //BA.debugLineNum = 48;BA.debugLine="Sub MainForm_Resize (Width As Double, Height As Do";
 //BA.debugLineNum = 49;BA.debugLine="B4XPages.Delegate.MainForm_Resize(Width, Height)";
_b4xpages._delegate /*de.rwblinn.basic58.b4xpagesdelegator*/ ._mainform_resize /*String*/ (_width,_height);
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return "";
}

private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        b4j.example.cssutils._process_globals();
b4j.example.b58protocol._process_globals();
b4j.example.utils._process_globals();
b4j.example.b58help._process_globals();
main._process_globals();
b4xpages._process_globals();
b4xcollections._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 25;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 26;BA.debugLine="Private fx As JFX";
_fx = new anywheresoftware.b4j.objects.JFX();
 //BA.debugLineNum = 27;BA.debugLine="Private MainForm As Form";
_mainform = new anywheresoftware.b4j.objects.Form();
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
}
