package b4j.example;


import anywheresoftware.b4a.BA;

public class main extends javafx.application.Application{
public static main mostCurrent = new main();

public static BA ba;
static {
		ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.main", null);
		ba.loadHtSubs(main.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "b4j.example.main", ba);
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
            frm.initWithStage(ba, stage, 600, 600);
            ba.raiseEvent(null, "appstart", frm, (String[])getParameters().getRaw().toArray(new String[0]));
        } catch (Throwable t) {
            BA.printException(t, true);
            System.exit(1);
        }
    }
public static anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4j.objects.JFX _fx = null;
public static anywheresoftware.b4j.objects.Form _mainform = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper _button1 = null;
public static b4j.example.b58interpreter _interpreter = null;
public static b4j.example.b58serial _serial = null;
public static b4j.example.b58system _system = null;
public static anywheresoftware.b4a.objects.Timer _delaytimer = null;
public static anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
public static b4j.example.b58protocol _b58protocol = null;
public static b4j.example.utils _utils = null;
public static b4j.example.b58help _b58help = null;
public static String  _appstart(anywheresoftware.b4j.objects.Form _form1,String[] _args) throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub AppStart (Form1 As Form, Args() As String)";
 //BA.debugLineNum = 23;BA.debugLine="Log(\"[AppStart]\")";
anywheresoftware.b4a.keywords.Common.LogImpl("765537","[AppStart]",0);
 //BA.debugLineNum = 24;BA.debugLine="MainForm = Form1";
_mainform = _form1;
 //BA.debugLineNum = 25;BA.debugLine="MainForm.RootPane.LoadLayout(\"Layout1\")";
_mainform.getRootPane().LoadLayout(ba,"Layout1");
 //BA.debugLineNum = 28;BA.debugLine="Serial.Initialize(Me, \"Serial\")";
_serial._initialize(ba,main.getObject(),"Serial");
 //BA.debugLineNum = 29;BA.debugLine="System.Initialize(Me, \"System\")";
_system._initialize(ba,main.getObject(),"System");
 //BA.debugLineNum = 30;BA.debugLine="DelayTimer.Initialize(\"DelayTimer\", 100)";
_delaytimer.Initialize(ba,"DelayTimer",(long) (100));
 //BA.debugLineNum = 31;BA.debugLine="Interpreter.Initialize(Me, \"Interpreter\")";
_interpreter._initialize(ba,main.getObject(),"Interpreter");
 //BA.debugLineNum = 37;BA.debugLine="SendCommand";
_sendcommand();
 //BA.debugLineNum = 40;BA.debugLine="Log(\"[AppStart] DONE\")";
anywheresoftware.b4a.keywords.Common.LogImpl("765554","[AppStart] DONE",0);
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return "";
}
public static String  _button1_click() throws Exception{
 //BA.debugLineNum = 43;BA.debugLine="Sub Button1_Click";
 //BA.debugLineNum = 44;BA.debugLine="xui.MsgboxAsync(\"Hello World!\", \"B4X\")";
_xui.MsgboxAsync(ba,"Hello World!","B4X");
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}
public static String  _connect() throws Exception{
String _src = "";
 //BA.debugLineNum = 63;BA.debugLine="Sub Connect	'ignore";
 //BA.debugLineNum = 64;BA.debugLine="Dim src As String = $\" 		10 @SER CONNECT COM10";
_src = ("\n"+"		10 @SER CONNECT COM10\n"+"		20 @DELAY 4000\n"+"		30 @SER DISCONNECT\n"+"		40 End\n"+"		");
 //BA.debugLineNum = 71;BA.debugLine="Interpreter.LoadProgram(src)";
_interpreter._loadprogram(_src);
 //BA.debugLineNum = 72;BA.debugLine="Interpreter.RunProgram";
_interpreter._runprogram();
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public static String  _delaytimer_tick() throws Exception{
 //BA.debugLineNum = 199;BA.debugLine="Private Sub DelayTimer_Tick";
 //BA.debugLineNum = 200;BA.debugLine="DelayTimer.Enabled = False";
_delaytimer.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 201;BA.debugLine="Interpreter.ResumeProgram";
_interpreter._resumeprogram();
 //BA.debugLineNum = 202;BA.debugLine="End Sub";
return "";
}
public static String  _interpreter_hardwarecommand(String _command) throws Exception{
 //BA.debugLineNum = 120;BA.debugLine="Private Sub Interpreter_HardwareCommand(Command As";
 //BA.debugLineNum = 121;BA.debugLine="Serial.ExecuteCommand(Command)";
_serial._executecommand(_command);
 //BA.debugLineNum = 122;BA.debugLine="End Sub";
return "";
}
public static String  _interpreter_output(String _value,boolean _newline) throws Exception{
 //BA.debugLineNum = 97;BA.debugLine="Private Sub Interpreter_Output(Value As String, Ne";
 //BA.debugLineNum = 98;BA.debugLine="If Value = \"\" Then";
if ((_value).equals("")) { 
 //BA.debugLineNum = 99;BA.debugLine="Log(\"[Interpreter_Output] <empty line>\")";
anywheresoftware.b4a.keywords.Common.LogImpl("7458754","[Interpreter_Output] <empty line>",0);
 }else if(_newline) { 
 //BA.debugLineNum = 101;BA.debugLine="Log($\"[Interpreter_Output] ${Value}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("7458756",("[Interpreter_Output] "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_value))+""),0);
 }else {
 //BA.debugLineNum = 103;BA.debugLine="Log($\"[Interpreter_Output] ${Value}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("7458758",("[Interpreter_Output] "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_value))+""),0);
 };
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
return "";
}
public static String  _interpreter_programrenumbered(String _programtext) throws Exception{
 //BA.debugLineNum = 128;BA.debugLine="Private Sub Interpreter_ProgramRenumbered(ProgramT";
 //BA.debugLineNum = 129;BA.debugLine="Log($\"[Interpreter_ProgramRenumbered] ${ProgramTe";
anywheresoftware.b4a.keywords.Common.LogImpl("7786433",("[Interpreter_ProgramRenumbered] "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_programtext))+""),0);
 //BA.debugLineNum = 130;BA.debugLine="End Sub";
return "";
}
public static String  _interpreter_ready() throws Exception{
 //BA.debugLineNum = 109;BA.debugLine="Private Sub Interpreter_Ready";
 //BA.debugLineNum = 110;BA.debugLine="Log($\"[Interpreter_Ready]READY\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("7524289",("[Interpreter_Ready]READY"),0);
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return "";
}
public static String  _interpreter_systemcommand(String _command) throws Exception{
 //BA.debugLineNum = 124;BA.debugLine="Private Sub Interpreter_SystemCommand(Command As S";
 //BA.debugLineNum = 125;BA.debugLine="System.ExecuteCommand(Command)";
_system._executecommand(_command);
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public static String  _interpreter_waitingfordelay() throws Exception{
 //BA.debugLineNum = 115;BA.debugLine="Private Sub Interpreter_WaitingForDelay";
 //BA.debugLineNum = 116;BA.debugLine="DelayTimer.Interval = Interpreter.GetDelayMillise";
_delaytimer.setInterval((long) (_interpreter._getdelaymilliseconds()));
 //BA.debugLineNum = 117;BA.debugLine="DelayTimer.Enabled = True";
_delaytimer.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 118;BA.debugLine="End Sub";
return "";
}
public static String  _listports() throws Exception{
String _src = "";
 //BA.debugLineNum = 53;BA.debugLine="Sub ListPorts	'ignore Passed";
 //BA.debugLineNum = 54;BA.debugLine="Dim src As String = $\" 		10 @SER LISTPORTS 		20 E";
_src = ("\n"+"		10 @SER LISTPORTS\n"+"		20 End\n"+"		");
 //BA.debugLineNum = 59;BA.debugLine="Interpreter.LoadProgram(src)";
_interpreter._loadprogram(_src);
 //BA.debugLineNum = 60;BA.debugLine="Interpreter.RunProgram";
_interpreter._runprogram();
 //BA.debugLineNum = 61;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Private fx As JFX";
_fx = new anywheresoftware.b4j.objects.JFX();
 //BA.debugLineNum = 8;BA.debugLine="Private MainForm As Form";
_mainform = new anywheresoftware.b4j.objects.Form();
 //BA.debugLineNum = 9;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 10;BA.debugLine="Private Button1 As B4XView";
_button1 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private Interpreter As B58Interpreter";
_interpreter = new b4j.example.b58interpreter();
 //BA.debugLineNum = 14;BA.debugLine="Private Serial As B58Serial";
_serial = new b4j.example.b58serial();
 //BA.debugLineNum = 15;BA.debugLine="Private System As B58System";
_system = new b4j.example.b58system();
 //BA.debugLineNum = 16;BA.debugLine="Private DelayTimer As Timer";
_delaytimer = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 18;BA.debugLine="Private bc As ByteConverter";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
public static String  _sendcommand() throws Exception{
String _src = "";
 //BA.debugLineNum = 75;BA.debugLine="Sub SendCommand	'ignore";
 //BA.debugLineNum = 76;BA.debugLine="Dim src As String = $\" 		10 @SER CONNECT COM10";
_src = ("\n"+"		10 @SER CONNECT COM10\n"+"		11 @DELAY 2000\n"+"		20 @SER 18 4 0\n"+"		30 @SER 18 4 1\n"+"		40 @DELAY 2000\n"+"		50 @SER 18 4 0\n"+"		60 @SER DISCONNECT\n"+"		70 End\n"+"		");
 //BA.debugLineNum = 87;BA.debugLine="Interpreter.LoadProgram(src)";
_interpreter._loadprogram(_src);
 //BA.debugLineNum = 88;BA.debugLine="Interpreter.RunProgram";
_interpreter._runprogram();
 //BA.debugLineNum = 89;BA.debugLine="End Sub";
return "";
}
public static String  _serial_commandcompleted(byte[] _frame) throws Exception{
 //BA.debugLineNum = 152;BA.debugLine="Private Sub Serial_CommandCompleted(Frame() As Byt";
 //BA.debugLineNum = 153;BA.debugLine="Log($\"[BASIC-58] ACK received: ${bc.HexFromBytes(";
anywheresoftware.b4a.keywords.Common.LogImpl("71572865",("[BASIC-58] ACK received: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_bc.HexFromBytes(_frame)))+""),0);
 //BA.debugLineNum = 154;BA.debugLine="Interpreter.ResumeHardwareCommand";
_interpreter._resumehardwarecommand();
 //BA.debugLineNum = 155;BA.debugLine="End Sub";
return "";
}
public static String  _serial_commanderror(String _message) throws Exception{
 //BA.debugLineNum = 157;BA.debugLine="Private Sub Serial_CommandError(Message As String)";
 //BA.debugLineNum = 158;BA.debugLine="Log(\"[BASIC-58][E] \" & Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("71638401","[BASIC-58][E] "+_message,0);
 //BA.debugLineNum = 159;BA.debugLine="Interpreter.ResumeHardwareCommand";
_interpreter._resumehardwarecommand();
 //BA.debugLineNum = 160;BA.debugLine="End Sub";
return "";
}
public static void  _serial_connected() throws Exception{
ResumableSub_Serial_Connected rsub = new ResumableSub_Serial_Connected(null);
rsub.resume(ba, null);
}
public static class ResumableSub_Serial_Connected extends BA.ResumableSub {
public ResumableSub_Serial_Connected(b4j.example.main parent) {
this.parent = parent;
}
b4j.example.main parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 //BA.debugLineNum = 147;BA.debugLine="Log(\"[BASIC-58] Controller connected.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("71507329","[BASIC-58] Controller connected.",0);
 //BA.debugLineNum = 148;BA.debugLine="Sleep(2000) ' Allow Arduino UNO reset";
anywheresoftware.b4a.keywords.Common.Sleep(ba,this,(int) (2000));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 149;BA.debugLine="Interpreter.ResumeHardwareCommand";
parent._interpreter._resumehardwarecommand();
 //BA.debugLineNum = 150;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _serial_datareceived(byte[] _frame) throws Exception{
byte _adr = (byte)0;
byte _cmd = (byte)0;
byte _val = (byte)0;
 //BA.debugLineNum = 183;BA.debugLine="Private Sub Serial_DataReceived(Frame() As Byte)";
 //BA.debugLineNum = 185;BA.debugLine="Dim Adr As Byte = B58Protocol.GetAdr(Frame)";
_adr = _b58protocol._getadr(_frame);
 //BA.debugLineNum = 186;BA.debugLine="Dim Cmd As Byte = B58Protocol.GetCmd(Frame)";
_cmd = _b58protocol._getcmd(_frame);
 //BA.debugLineNum = 187;BA.debugLine="Dim Val As Byte = B58Protocol.GetVal(Frame)";
_val = _b58protocol._getval(_frame);
 //BA.debugLineNum = 189;BA.debugLine="Log($\"[BASIC-58] Received: ADR=${B58Protocol.ToUn";
anywheresoftware.b4a.keywords.Common.LogImpl("71966086",("[BASIC-58] Received: ADR="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_b58protocol._tounsigned(_adr)))+" CMD="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_b58protocol._tounsigned(_cmd)))+" VAL="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_b58protocol._tounsigned(_val)))+""),0);
 //BA.debugLineNum = 191;BA.debugLine="Interpreter.SubmitExternalData( _     	B58Protoco";
_interpreter._submitexternaldata(_b58protocol._tounsigned(_adr),_b58protocol._tounsigned(_cmd),_b58protocol._tounsigned(_val));
 //BA.debugLineNum = 195;BA.debugLine="End Sub";
return "";
}
public static String  _serial_disconnected() throws Exception{
 //BA.debugLineNum = 162;BA.debugLine="Private Sub Serial_Disconnected";
 //BA.debugLineNum = 163;BA.debugLine="Log(\"[BASIC-58] Controller disconnected.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("71703937","[BASIC-58] Controller disconnected.",0);
 //BA.debugLineNum = 164;BA.debugLine="Interpreter.ResumeHardwareCommand";
_interpreter._resumehardwarecommand();
 //BA.debugLineNum = 165;BA.debugLine="Interpreter.ExternalDataDisconnected";
_interpreter._externaldatadisconnected();
 //BA.debugLineNum = 166;BA.debugLine="End Sub";
return "";
}
public static String  _serial_error(String _message) throws Exception{
 //BA.debugLineNum = 168;BA.debugLine="Private Sub Serial_Error(Message As String)";
 //BA.debugLineNum = 169;BA.debugLine="Log(\"[BASIC-58][E] \" & Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("71769473","[BASIC-58][E] "+_message,0);
 //BA.debugLineNum = 170;BA.debugLine="End Sub";
return "";
}
public static String  _serial_noportsfound() throws Exception{
 //BA.debugLineNum = 179;BA.debugLine="Private Sub Serial_NoPortsFound";
 //BA.debugLineNum = 180;BA.debugLine="Log(\"NO SERIAL PORTS FOUND.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("71900545","NO SERIAL PORTS FOUND.",0);
 //BA.debugLineNum = 181;BA.debugLine="End Sub";
return "";
}
public static String  _serial_portsfound(anywheresoftware.b4a.objects.collections.List _ports) throws Exception{
String _port = "";
 //BA.debugLineNum = 172;BA.debugLine="Private Sub Serial_PortsFound(Ports As List)";
 //BA.debugLineNum = 173;BA.debugLine="Log(\"AVAILABLE SERIAL PORTS:\")";
anywheresoftware.b4a.keywords.Common.LogImpl("71835009","AVAILABLE SERIAL PORTS:",0);
 //BA.debugLineNum = 174;BA.debugLine="For Each Port As String In Ports";
{
final anywheresoftware.b4a.BA.IterableList group2 = _ports;
final int groupLen2 = group2.getSize()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_port = BA.ObjectToString(group2.Get(index2));
 //BA.debugLineNum = 175;BA.debugLine="Log(Port)";
anywheresoftware.b4a.keywords.Common.LogImpl("71835011",_port,0);
 }
};
 //BA.debugLineNum = 177;BA.debugLine="End Sub";
return "";
}
public static String  _system_output(String _message) throws Exception{
 //BA.debugLineNum = 137;BA.debugLine="Private Sub System_Output(Message As String)";
 //BA.debugLineNum = 138;BA.debugLine="Log($\"[System_Output] ${Message}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("7851969",("[System_Output] "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_message))+""),0);
 //BA.debugLineNum = 139;BA.debugLine="End Sub";
return "";
}
}
