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
public static anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
public static b4j.example.b58protocol _b58protocol = null;
public static b4j.example.utils _utils = null;
public static b4j.example.b58help _b58help = null;
public static String  _appstart(String[] _args) throws Exception{
 //BA.debugLineNum = 25;BA.debugLine="Sub AppStart (Args() As String)";
 //BA.debugLineNum = 26;BA.debugLine="Log(\"AppStart\")";
anywheresoftware.b4a.keywords.Common.LogImpl("565537","AppStart",0);
 //BA.debugLineNum = 29;BA.debugLine="Serial.Initialize(Me, \"Serial\")";
_serial._initialize(ba,main.getObject(),"Serial");
 //BA.debugLineNum = 30;BA.debugLine="System.Initialize(Me, \"System\")";
_system._initialize(ba,main.getObject(),"System");
 //BA.debugLineNum = 31;BA.debugLine="DelayTimer.Initialize(\"DelayTimer\", 100)";
_delaytimer.Initialize(ba,"DelayTimer",(long) (100));
 //BA.debugLineNum = 33;BA.debugLine="Interpreter.Initialize(Me, \"Interpreter\")";
_interpreter._initialize(ba,main.getObject(),"Interpreter");
 //BA.debugLineNum = 35;BA.debugLine="ListPorts";
_listports();
 //BA.debugLineNum = 37;BA.debugLine="SendCommand";
_sendcommand();
 //BA.debugLineNum = 39;BA.debugLine="StartMessageLoop";
anywheresoftware.b4a.keywords.Common.StartMessageLoop(ba);
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return "";
}
public static String  _connect() throws Exception{
String _src = "";
 //BA.debugLineNum = 79;BA.debugLine="Sub Connect	'ignored Passed";
 //BA.debugLineNum = 80;BA.debugLine="Dim src As String = $\" 		10 @SER CONNECT COM10";
_src = ("\n"+"		10 @SER CONNECT COM10\n"+"		20 @DELAY 2000\n"+"		30 @SER DISCONNECT\n"+"		40 End\n"+"		");
 //BA.debugLineNum = 87;BA.debugLine="Interpreter.LoadProgram(src)";
_interpreter._loadprogram(_src);
 //BA.debugLineNum = 88;BA.debugLine="Interpreter.RunProgram";
_interpreter._runprogram();
 //BA.debugLineNum = 89;BA.debugLine="End Sub";
return "";
}
public static String  _delaytimer_tick() throws Exception{
 //BA.debugLineNum = 213;BA.debugLine="Private Sub DelayTimer_Tick";
 //BA.debugLineNum = 214;BA.debugLine="DelayTimer.Enabled = False";
_delaytimer.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 215;BA.debugLine="Interpreter.ResumeProgram";
_interpreter._resumeprogram();
 //BA.debugLineNum = 216;BA.debugLine="End Sub";
return "";
}
public static String  _interpreter_hardwarecommand(String _command) throws Exception{
 //BA.debugLineNum = 134;BA.debugLine="Private Sub Interpreter_HardwareCommand(Command As";
 //BA.debugLineNum = 135;BA.debugLine="Serial.ExecuteCommand(Command)";
_serial._executecommand(_command);
 //BA.debugLineNum = 136;BA.debugLine="End Sub";
return "";
}
public static String  _interpreter_output(String _value,boolean _newline) throws Exception{
 //BA.debugLineNum = 111;BA.debugLine="Private Sub Interpreter_Output(Value As String, Ne";
 //BA.debugLineNum = 112;BA.debugLine="If Value = \"\" Then";
if ((_value).equals("")) { 
 //BA.debugLineNum = 113;BA.debugLine="Log(\"[Interpreter_Output] <empty line>\")";
anywheresoftware.b4a.keywords.Common.LogImpl("5327682","[Interpreter_Output] <empty line>",0);
 }else if(_newline) { 
 //BA.debugLineNum = 115;BA.debugLine="Log($\"[Interpreter_Output] ${Value}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("5327684",("[Interpreter_Output] "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_value))+""),0);
 }else {
 //BA.debugLineNum = 117;BA.debugLine="Log($\"[Interpreter_Output] ${Value}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("5327686",("[Interpreter_Output] "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_value))+""),0);
 };
 //BA.debugLineNum = 119;BA.debugLine="End Sub";
return "";
}
public static String  _interpreter_programrenumbered(String _programtext) throws Exception{
 //BA.debugLineNum = 142;BA.debugLine="Private Sub Interpreter_ProgramRenumbered(ProgramT";
 //BA.debugLineNum = 143;BA.debugLine="Log($\"[Interpreter_ProgramRenumbered] ${ProgramTe";
anywheresoftware.b4a.keywords.Common.LogImpl("5655361",("[Interpreter_ProgramRenumbered] "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_programtext))+""),0);
 //BA.debugLineNum = 144;BA.debugLine="End Sub";
return "";
}
public static String  _interpreter_ready() throws Exception{
 //BA.debugLineNum = 123;BA.debugLine="Private Sub Interpreter_Ready";
 //BA.debugLineNum = 124;BA.debugLine="Log($\"[Interpreter_Ready]READY\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("5393217",("[Interpreter_Ready]READY"),0);
 //BA.debugLineNum = 125;BA.debugLine="End Sub";
return "";
}
public static String  _interpreter_systemcommand(String _command) throws Exception{
 //BA.debugLineNum = 138;BA.debugLine="Private Sub Interpreter_SystemCommand(Command As S";
 //BA.debugLineNum = 139;BA.debugLine="System.ExecuteCommand(Command)";
_system._executecommand(_command);
 //BA.debugLineNum = 140;BA.debugLine="End Sub";
return "";
}
public static String  _interpreter_waitingfordelay() throws Exception{
 //BA.debugLineNum = 129;BA.debugLine="Private Sub Interpreter_WaitingForDelay";
 //BA.debugLineNum = 130;BA.debugLine="DelayTimer.Interval = Interpreter.GetDelayMillise";
_delaytimer.setInterval((long) (_interpreter._getdelaymilliseconds()));
 //BA.debugLineNum = 131;BA.debugLine="DelayTimer.Enabled = True";
_delaytimer.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
return "";
}
public static String  _listports() throws Exception{
String _src = "";
 //BA.debugLineNum = 48;BA.debugLine="Sub ListPorts	' Passed";
 //BA.debugLineNum = 49;BA.debugLine="Dim src As String = $\" 		10 @SER LISTPORTS 		20 E";
_src = ("\n"+"		10 @SER LISTPORTS\n"+"		20 End\n"+"		");
 //BA.debugLineNum = 54;BA.debugLine="Interpreter.LoadProgram(src)";
_interpreter._loadprogram(_src);
 //BA.debugLineNum = 55;BA.debugLine="Interpreter.RunProgram";
_interpreter._runprogram();
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 22;BA.debugLine="Private bc As ByteConverter";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return "";
}
public static String  _sendcommand() throws Exception{
String _src = "";
 //BA.debugLineNum = 91;BA.debugLine="Sub SendCommand	'ignore";
 //BA.debugLineNum = 92;BA.debugLine="Dim src As String = $\" 		10 @SER CONNECT COM10";
_src = ("\n"+"		10 @SER CONNECT COM10\n"+"		20 @SER 18 4 1\n"+"		30 @DELAY 2000\n"+"		40 @SER 18 4 0\n"+"		50 @SER DISCONNECT\n"+"		60 End\n"+"		");
 //BA.debugLineNum = 101;BA.debugLine="Interpreter.LoadProgram(src)";
_interpreter._loadprogram(_src);
 //BA.debugLineNum = 102;BA.debugLine="Interpreter.RunProgram";
_interpreter._runprogram();
 //BA.debugLineNum = 103;BA.debugLine="End Sub";
return "";
}
public static String  _serial_commandcompleted(byte[] _frame) throws Exception{
 //BA.debugLineNum = 166;BA.debugLine="Private Sub Serial_CommandCompleted(Frame() As Byt";
 //BA.debugLineNum = 167;BA.debugLine="Log($\"[BASIC-58] ACK received: ${bc.HexFromBytes(";
anywheresoftware.b4a.keywords.Common.LogImpl("5851969",("[BASIC-58] ACK received: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_bc.HexFromBytes(_frame)))+""),0);
 //BA.debugLineNum = 168;BA.debugLine="Interpreter.ResumeHardwareCommand";
_interpreter._resumehardwarecommand();
 //BA.debugLineNum = 169;BA.debugLine="End Sub";
return "";
}
public static String  _serial_commanderror(String _message) throws Exception{
 //BA.debugLineNum = 171;BA.debugLine="Private Sub Serial_CommandError(Message As String)";
 //BA.debugLineNum = 172;BA.debugLine="Log(\"[BASIC-58][E] \" & Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("5917505","[BASIC-58][E] "+_message,0);
 //BA.debugLineNum = 173;BA.debugLine="Interpreter.ResumeHardwareCommand";
_interpreter._resumehardwarecommand();
 //BA.debugLineNum = 174;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 161;BA.debugLine="Log(\"[BASIC-58] Controller connected.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("5786433","[BASIC-58] Controller connected.",0);
 //BA.debugLineNum = 162;BA.debugLine="Sleep(2000) ' Allow Arduino UNO reset";
anywheresoftware.b4a.keywords.Common.Sleep(ba,this,(int) (2000));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 163;BA.debugLine="Interpreter.ResumeHardwareCommand";
parent._interpreter._resumehardwarecommand();
 //BA.debugLineNum = 164;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _serial_datareceived(byte[] _frame) throws Exception{
byte _adr = (byte)0;
byte _cmd = (byte)0;
byte _val = (byte)0;
 //BA.debugLineNum = 197;BA.debugLine="Private Sub Serial_DataReceived(Frame() As Byte)";
 //BA.debugLineNum = 199;BA.debugLine="Dim Adr As Byte = B58Protocol.GetAdr(Frame)";
_adr = _b58protocol._getadr(_frame);
 //BA.debugLineNum = 200;BA.debugLine="Dim Cmd As Byte = B58Protocol.GetCmd(Frame)";
_cmd = _b58protocol._getcmd(_frame);
 //BA.debugLineNum = 201;BA.debugLine="Dim Val As Byte = B58Protocol.GetVal(Frame)";
_val = _b58protocol._getval(_frame);
 //BA.debugLineNum = 203;BA.debugLine="Log($\"[BASIC-58] Received: ADR=${B58Protocol.ToUn";
anywheresoftware.b4a.keywords.Common.LogImpl("51245190",("[BASIC-58] Received: ADR="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_b58protocol._tounsigned(_adr)))+" CMD="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_b58protocol._tounsigned(_cmd)))+" VAL="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_b58protocol._tounsigned(_val)))+""),0);
 //BA.debugLineNum = 205;BA.debugLine="Interpreter.SubmitExternalData( _     	B58Protoco";
_interpreter._submitexternaldata(_b58protocol._tounsigned(_adr),_b58protocol._tounsigned(_cmd),_b58protocol._tounsigned(_val));
 //BA.debugLineNum = 209;BA.debugLine="End Sub";
return "";
}
public static String  _serial_disconnected() throws Exception{
 //BA.debugLineNum = 176;BA.debugLine="Private Sub Serial_Disconnected";
 //BA.debugLineNum = 177;BA.debugLine="Log(\"[BASIC-58] Controller disconnected.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("5983041","[BASIC-58] Controller disconnected.",0);
 //BA.debugLineNum = 178;BA.debugLine="Interpreter.ResumeHardwareCommand";
_interpreter._resumehardwarecommand();
 //BA.debugLineNum = 179;BA.debugLine="Interpreter.ExternalDataDisconnected";
_interpreter._externaldatadisconnected();
 //BA.debugLineNum = 180;BA.debugLine="End Sub";
return "";
}
public static String  _serial_error(String _message) throws Exception{
 //BA.debugLineNum = 182;BA.debugLine="Private Sub Serial_Error(Message As String)";
 //BA.debugLineNum = 183;BA.debugLine="Log(\"[BASIC-58][E] \" & Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("51048577","[BASIC-58][E] "+_message,0);
 //BA.debugLineNum = 184;BA.debugLine="End Sub";
return "";
}
public static String  _serial_noportsfound() throws Exception{
 //BA.debugLineNum = 193;BA.debugLine="Private Sub Serial_NoPortsFound";
 //BA.debugLineNum = 194;BA.debugLine="Log(\"NO SERIAL PORTS FOUND.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("51179649","NO SERIAL PORTS FOUND.",0);
 //BA.debugLineNum = 195;BA.debugLine="End Sub";
return "";
}
public static String  _serial_portsfound(anywheresoftware.b4a.objects.collections.List _ports) throws Exception{
String _port = "";
 //BA.debugLineNum = 186;BA.debugLine="Private Sub Serial_PortsFound(Ports As List)";
 //BA.debugLineNum = 187;BA.debugLine="Log(\"AVAILABLE SERIAL PORTS:\")";
anywheresoftware.b4a.keywords.Common.LogImpl("51114113","AVAILABLE SERIAL PORTS:",0);
 //BA.debugLineNum = 188;BA.debugLine="For Each Port As String In Ports";
{
final anywheresoftware.b4a.BA.IterableList group2 = _ports;
final int groupLen2 = group2.getSize()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_port = BA.ObjectToString(group2.Get(index2));
 //BA.debugLineNum = 189;BA.debugLine="Log(Port)";
anywheresoftware.b4a.keywords.Common.LogImpl("51114115",_port,0);
 }
};
 //BA.debugLineNum = 191;BA.debugLine="End Sub";
return "";
}
public static String  _system_output(String _message) throws Exception{
 //BA.debugLineNum = 151;BA.debugLine="Private Sub System_Output(Message As String)";
 //BA.debugLineNum = 152;BA.debugLine="Log($\"[System_Output] ${Message}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("5720897",("[System_Output] "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_message))+""),0);
 //BA.debugLineNum = 153;BA.debugLine="End Sub";
return "";
}
}
