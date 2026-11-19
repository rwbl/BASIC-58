package b4j.example;


import anywheresoftware.b4a.BA;

public class main extends Object{
public static main mostCurrent = new main();

public static BA ba;
static {
		ba = new  anywheresoftware.b4a.StandardBA("b4j.example", "b4j.example.main", null);
		ba.loadHtSubs(main.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "b4j.example.main", ba);
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}

 
    public static void main(String[] args) throws Exception{
        try {
            anywheresoftware.b4a.keywords.Common.LogDebug("Program started.");
            initializeProcessGlobals();
            ba.raiseEvent(null, "appstart", (Object)args);
        } catch (Throwable t) {
			BA.printException(t, true);
		
        } finally {
            anywheresoftware.b4a.keywords.Common.LogDebug("Program terminated (StartMessageLoop was not called).");
        }
    }
public static anywheresoftware.b4a.keywords.Common __c = null;
public static b4j.example.b58interpreter _interpreter = null;
public static b4j.example.b58serial _serial = null;
public static b4j.example.b58system _system = null;
public static anywheresoftware.b4a.objects.Timer _delaytimer = null;
public static b4j.example.b58protocol _b58protocol = null;
public static b4j.example.utils _utils = null;
public static b4j.example.b58help _b58help = null;
public static String  _appstart(String[] _args) throws Exception{
 //BA.debugLineNum = 23;BA.debugLine="Sub AppStart (Args() As String)";
 //BA.debugLineNum = 24;BA.debugLine="Log(\"AppStart\")";
anywheresoftware.b4a.keywords.Common.LogImpl("165537","AppStart",0);
 //BA.debugLineNum = 27;BA.debugLine="Serial.Initialize(Me, \"Serial\")";
_serial._initialize(ba,main.getObject(),"Serial");
 //BA.debugLineNum = 28;BA.debugLine="System.Initialize(Me, \"System\")";
_system._initialize(ba,main.getObject(),"System");
 //BA.debugLineNum = 29;BA.debugLine="DelayTimer.Initialize(\"DelayTimer\", 100)";
_delaytimer.Initialize(ba,"DelayTimer",(long) (100));
 //BA.debugLineNum = 31;BA.debugLine="Interpreter.Initialize(Me, \"Interpreter\")";
_interpreter._initialize(ba,main.getObject(),"Interpreter");
 //BA.debugLineNum = 33;BA.debugLine="ProgramTest";
_programtest();
 //BA.debugLineNum = 36;BA.debugLine="StartMessageLoop";
anywheresoftware.b4a.keywords.Common.StartMessageLoop(ba);
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
return "";
}
public static String  _helptest() throws Exception{
 //BA.debugLineNum = 49;BA.debugLine="Sub HelpTest	'ignore";
 //BA.debugLineNum = 50;BA.debugLine="Interpreter.ExecuteHelp";
_interpreter._executehelp();
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return "";
}
public static String  _interpreter_hardwarecommand(String _command) throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Private Sub Interpreter_HardwareCommand(Command As";
 //BA.debugLineNum = 83;BA.debugLine="Serial.ExecuteCommand(Command)";
_serial._executecommand(_command);
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return "";
}
public static String  _interpreter_output(String _value,boolean _newline) throws Exception{
 //BA.debugLineNum = 59;BA.debugLine="Private Sub Interpreter_Output(Value As String, Ne";
 //BA.debugLineNum = 60;BA.debugLine="If Value = \"\" Then";
if ((_value).equals("")) { 
 //BA.debugLineNum = 61;BA.debugLine="Log(\"[Interpreter_Output] <empty line>\")";
anywheresoftware.b4a.keywords.Common.LogImpl("1262146","[Interpreter_Output] <empty line>",0);
 }else if(_newline) { 
 //BA.debugLineNum = 63;BA.debugLine="Log($\"[Interpreter_Output] ${Value}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("1262148",("[Interpreter_Output] "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_value))+""),0);
 }else {
 //BA.debugLineNum = 65;BA.debugLine="Log($\"[Interpreter_Output] ${Value}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("1262150",("[Interpreter_Output] "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_value))+""),0);
 };
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public static String  _interpreter_programrenumbered(String _programtext) throws Exception{
 //BA.debugLineNum = 90;BA.debugLine="Private Sub Interpreter_ProgramRenumbered(ProgramT";
 //BA.debugLineNum = 91;BA.debugLine="Log($\"[Interpreter_ProgramRenumbered] ${ProgramTe";
anywheresoftware.b4a.keywords.Common.LogImpl("1589825",("[Interpreter_ProgramRenumbered] "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_programtext))+""),0);
 //BA.debugLineNum = 92;BA.debugLine="End Sub";
return "";
}
public static String  _interpreter_ready() throws Exception{
 //BA.debugLineNum = 71;BA.debugLine="Private Sub Interpreter_Ready";
 //BA.debugLineNum = 72;BA.debugLine="Log($\"[Interpreter_Ready]READY\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("1327681",("[Interpreter_Ready]READY"),0);
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public static String  _interpreter_systemcommand(String _command) throws Exception{
 //BA.debugLineNum = 86;BA.debugLine="Private Sub Interpreter_SystemCommand(Command As S";
 //BA.debugLineNum = 87;BA.debugLine="System.ExecuteCommand(Command)";
_system._executecommand(_command);
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
return "";
}
public static String  _interpreter_waitingfordelay() throws Exception{
 //BA.debugLineNum = 77;BA.debugLine="Private Sub Interpreter_WaitingForDelay";
 //BA.debugLineNum = 78;BA.debugLine="DelayTimer.Interval = Interpreter.GetDelayMillise";
_delaytimer.setInterval((long) (_interpreter._getdelaymilliseconds()));
 //BA.debugLineNum = 79;BA.debugLine="DelayTimer.Enabled = True";
_delaytimer.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return "";
}

private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        b4j.example.b58protocol._process_globals();
b4j.example.utils._process_globals();
b4j.example.b58help._process_globals();
main._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 17;BA.debugLine="Private Interpreter As B58Interpreter";
_interpreter = new b4j.example.b58interpreter();
 //BA.debugLineNum = 18;BA.debugLine="Private Serial As B58Serial";
_serial = new b4j.example.b58serial();
 //BA.debugLineNum = 19;BA.debugLine="Private System As B58System";
_system = new b4j.example.b58system();
 //BA.debugLineNum = 20;BA.debugLine="Private DelayTimer As Timer";
_delaytimer = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public static String  _programtest() throws Exception{
String _src = "";
 //BA.debugLineNum = 39;BA.debugLine="Sub ProgramTest";
 //BA.debugLineNum = 40;BA.debugLine="Dim src As String = $\" 		10 PRINT \"HELLO\" 		20 En";
_src = ("\n"+"		10 PRINT \"HELLO\"\n"+"		20 End\n"+"		");
 //BA.debugLineNum = 45;BA.debugLine="Interpreter.LoadProgram(src)";
_interpreter._loadprogram(_src);
 //BA.debugLineNum = 46;BA.debugLine="Interpreter.RunProgram";
_interpreter._runprogram();
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return "";
}
public static String  _system_output(String _message) throws Exception{
 //BA.debugLineNum = 99;BA.debugLine="Private Sub System_Output(Message As String)";
 //BA.debugLineNum = 100;BA.debugLine="Log($\"[System_Output] ${Message}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("1655361",("[System_Output] "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_message))+""),0);
 //BA.debugLineNum = 101;BA.debugLine="End Sub";
return "";
}
}
