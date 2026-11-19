package de.rwblinn.basic58;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class b58serial extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("de.rwblinn.basic58", "de.rwblinn.basic58.b58serial", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", de.rwblinn.basic58.b58serial.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4j.serial.Serial _serialline = null;
public boolean _misconnected = false;
public anywheresoftware.b4a.randomaccessfile.AsyncStreams _astreams = null;
public anywheresoftware.b4a.objects.collections.List _rxbuffer = null;
public Object _mcallback = null;
public String _meventname = "";
public boolean _pendingcommand = false;
public byte _pendingadr = (byte)0;
public byte _pendingcmd = (byte)0;
public byte _pendingval = (byte)0;
public anywheresoftware.b4a.objects.Timer _commandtimer = null;
public int _command_timeout_ms = 0;
public anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
public b4j.example.cssutils _cssutils = null;
public de.rwblinn.basic58.main _main = null;
public de.rwblinn.basic58.b4xpages _b4xpages = null;
public de.rwblinn.basic58.b4xcollections _b4xcollections = null;
public de.rwblinn.basic58.b58protocol _b58protocol = null;
public de.rwblinn.basic58.utils _utils = null;
public de.rwblinn.basic58.b58help _b58help = null;
public String  _astreams_error() throws Exception{
 //BA.debugLineNum = 220;BA.debugLine="Private Sub AStreams_Error";
 //BA.debugLineNum = 221;BA.debugLine="Log(\"[B58Serial][E] AsyncStreams error.\")";
__c.LogImpl("917891329","[B58Serial][E] AsyncStreams error.",0);
 //BA.debugLineNum = 222;BA.debugLine="Disconnect";
_disconnect();
 //BA.debugLineNum = 223;BA.debugLine="End Sub";
return "";
}
public String  _astreams_newdata(byte[] _buffer) throws Exception{
byte _b = (byte)0;
byte _receivedbyte = (byte)0;
byte _lastbyte = (byte)0;
byte[] _frame = null;
int _i = 0;
 //BA.debugLineNum = 132;BA.debugLine="Private Sub AStreams_NewData(Buffer() As Byte)";
 //BA.debugLineNum = 133;BA.debugLine="Log($\"[B58Serial.NewData] Length=${Buffer.Length}";
__c.LogImpl("917760257",("[B58Serial.NewData] Length="+__c.SmartStringFormatter("",(Object)(_buffer.length))+", Hex="+__c.SmartStringFormatter("",(Object)(_bc.HexFromBytes(_buffer)))+""),0);
 //BA.debugLineNum = 135;BA.debugLine="For Each b As Byte In Buffer";
{
final byte[] group2 = _buffer;
final int groupLen2 = group2.length
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_b = group2[index2];
 //BA.debugLineNum = 136;BA.debugLine="RxBuffer.Add(b)";
_rxbuffer.Add((Object)(_b));
 }
};
 //BA.debugLineNum = 139;BA.debugLine="Do While RxBuffer.Size >= B58Protocol.FRAME_SIZE";
while (_rxbuffer.getSize()>=_b58protocol._frame_size /*byte*/ ) {
 //BA.debugLineNum = 141;BA.debugLine="Dim receivedByte As Byte = RxBuffer.Get(0)";
_receivedbyte = (byte)(BA.ObjectToNumber(_rxbuffer.Get((int) (0))));
 //BA.debugLineNum = 144;BA.debugLine="If receivedByte <> B58Protocol.FRAME_HEADER Then";
if (_receivedbyte!=_b58protocol._frame_header /*byte*/ ) { 
 //BA.debugLineNum = 145;BA.debugLine="RxBuffer.RemoveAt(0)";
_rxbuffer.RemoveAt((int) (0));
 //BA.debugLineNum = 146;BA.debugLine="Continue";
if (true) continue;
 };
 //BA.debugLineNum = 150;BA.debugLine="Dim lastByte As Byte = RxBuffer.Get(B58Protocol.";
_lastbyte = (byte)(BA.ObjectToNumber(_rxbuffer.Get((int) (_b58protocol._frame_size /*byte*/ -1))));
 //BA.debugLineNum = 152;BA.debugLine="If lastByte <> B58Protocol.FRAME_FOOTER Then";
if (_lastbyte!=_b58protocol._frame_footer /*byte*/ ) { 
 //BA.debugLineNum = 153;BA.debugLine="RxBuffer.RemoveAt(0)";
_rxbuffer.RemoveAt((int) (0));
 //BA.debugLineNum = 154;BA.debugLine="Continue";
if (true) continue;
 };
 //BA.debugLineNum = 158;BA.debugLine="Dim Frame(B58Protocol.FRAME_SIZE) As Byte";
_frame = new byte[(int) (_b58protocol._frame_size /*byte*/ )];
;
 //BA.debugLineNum = 160;BA.debugLine="For i = 0 To B58Protocol.FRAME_SIZE - 1";
{
final int step17 = 1;
final int limit17 = (int) (_b58protocol._frame_size /*byte*/ -1);
_i = (int) (0) ;
for (;_i <= limit17 ;_i = _i + step17 ) {
 //BA.debugLineNum = 161;BA.debugLine="Frame(i) = RxBuffer.Get(i)";
_frame[_i] = (byte)(BA.ObjectToNumber(_rxbuffer.Get(_i)));
 }
};
 //BA.debugLineNum = 165;BA.debugLine="For i = 0 To B58Protocol.FRAME_SIZE - 1";
{
final int step20 = 1;
final int limit20 = (int) (_b58protocol._frame_size /*byte*/ -1);
_i = (int) (0) ;
for (;_i <= limit20 ;_i = _i + step20 ) {
 //BA.debugLineNum = 166;BA.debugLine="RxBuffer.RemoveAt(0)";
_rxbuffer.RemoveAt((int) (0));
 }
};
 //BA.debugLineNum = 169;BA.debugLine="ProcessIncomingFrame(Frame)";
_processincomingframe(_frame);
 }
;
 //BA.debugLineNum = 171;BA.debugLine="End Sub";
return "";
}
public String  _astreams_terminated() throws Exception{
 //BA.debugLineNum = 225;BA.debugLine="Private Sub AStreams_Terminated";
 //BA.debugLineNum = 226;BA.debugLine="Log(\"[B58Serial] AsyncStreams terminated.\")";
__c.LogImpl("917956865","[B58Serial] AsyncStreams terminated.",0);
 //BA.debugLineNum = 227;BA.debugLine="Disconnect";
_disconnect();
 //BA.debugLineNum = 228;BA.debugLine="End Sub";
return "";
}
public boolean  _astreamswrite(byte[] _data) throws Exception{
 //BA.debugLineNum = 230;BA.debugLine="Private Sub AStreamsWrite(Data() As Byte) As Boole";
 //BA.debugLineNum = 231;BA.debugLine="Try";
try { //BA.debugLineNum = 232;BA.debugLine="AStreams.Write(Data)";
_astreams.Write(_data);
 //BA.debugLineNum = 233;BA.debugLine="Log($\"[B58Serial.AStreamsWrite] ${bc.HexFromByte";
__c.LogImpl("918022403",("[B58Serial.AStreamsWrite] "+__c.SmartStringFormatter("",(Object)(_bc.HexFromBytes(_data)))+""),0);
 //BA.debugLineNum = 234;BA.debugLine="Return True";
if (true) return __c.True;
 } 
       catch (Exception e6) {
			ba.setLastException(e6); //BA.debugLineNum = 236;BA.debugLine="Log($\"[B58Serial.AStreamsWrite][E] ${LastExcepti";
__c.LogImpl("918022406",("[B58Serial.AStreamsWrite][E] "+__c.SmartStringFormatter("",(Object)(__c.LastException(ba).getObject()))+""),0);
 //BA.debugLineNum = 237;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 239;BA.debugLine="End Sub";
return false;
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 23;BA.debugLine="Private SerialLine As Serial";
_serialline = new anywheresoftware.b4j.serial.Serial();
 //BA.debugLineNum = 24;BA.debugLine="Private mIsConnected As Boolean = False";
_misconnected = __c.False;
 //BA.debugLineNum = 25;BA.debugLine="Private AStreams As AsyncStreams";
_astreams = new anywheresoftware.b4a.randomaccessfile.AsyncStreams();
 //BA.debugLineNum = 26;BA.debugLine="Private RxBuffer As List";
_rxbuffer = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 29;BA.debugLine="Private mCallback As Object";
_mcallback = new Object();
 //BA.debugLineNum = 30;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 33;BA.debugLine="Private PendingCommand As Boolean = False";
_pendingcommand = __c.False;
 //BA.debugLineNum = 34;BA.debugLine="Private PendingAdr As Byte";
_pendingadr = (byte)0;
 //BA.debugLineNum = 35;BA.debugLine="Private PendingCmd As Byte";
_pendingcmd = (byte)0;
 //BA.debugLineNum = 36;BA.debugLine="Private PendingVal As Byte";
_pendingval = (byte)0;
 //BA.debugLineNum = 38;BA.debugLine="Private CommandTimer As Timer";
_commandtimer = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 39;BA.debugLine="Private Const COMMAND_TIMEOUT_MS As Int = 2000";
_command_timeout_ms = (int) (2000);
 //BA.debugLineNum = 42;BA.debugLine="Private bc As ByteConverter";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return "";
}
public String  _commandtimer_tick() throws Exception{
 //BA.debugLineNum = 269;BA.debugLine="Private Sub CommandTimer_Tick";
 //BA.debugLineNum = 270;BA.debugLine="CommandTimer.Enabled = False";
_commandtimer.setEnabled(__c.False);
 //BA.debugLineNum = 272;BA.debugLine="If PendingCommand = False Then Return";
if (_pendingcommand==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 274;BA.debugLine="PendingCommand = False";
_pendingcommand = __c.False;
 //BA.debugLineNum = 276;BA.debugLine="Log(\"[B58Serial][E] Command timeout.\")";
__c.LogImpl("918153479","[B58Serial][E] Command timeout.",0);
 //BA.debugLineNum = 277;BA.debugLine="Utils.CallSubMethod2(mCallback, mEventName, \"_Com";
_utils._callsubmethod2 /*String*/ (_mcallback,_meventname,"_CommandError",(Object)("Command timeout."));
 //BA.debugLineNum = 278;BA.debugLine="End Sub";
return "";
}
public String  _connect(String _port) throws Exception{
String _errormessage = "";
String _usermessage = "";
 //BA.debugLineNum = 63;BA.debugLine="Public Sub Connect(Port As String)";
 //BA.debugLineNum = 65;BA.debugLine="Log($\"[B58Serial.Connect] Port: ${Port}\"$)";
__c.LogImpl("917563650",("[B58Serial.Connect] Port: "+__c.SmartStringFormatter("",(Object)(_port))+""),0);
 //BA.debugLineNum = 67;BA.debugLine="Disconnect";
_disconnect();
 //BA.debugLineNum = 69;BA.debugLine="Try";
try { //BA.debugLineNum = 70;BA.debugLine="SerialLine.Open(Port)";
_serialline.Open(_port);
 //BA.debugLineNum = 71;BA.debugLine="SerialLine.SetParams(115200, 8, 1, 0)";
_serialline.SetParams((int) (115200),(int) (8),(int) (1),(int) (0));
 //BA.debugLineNum = 73;BA.debugLine="AStreams.Initialize(SerialLine.GetInputStream, S";
_astreams.Initialize(ba,_serialline.GetInputStream(),_serialline.GetOutputStream(),"AStreams");
 //BA.debugLineNum = 74;BA.debugLine="Log(\"[B58Serial.Connect] AsyncStreams initialize";
__c.LogImpl("917563659","[B58Serial.Connect] AsyncStreams initialized: "+BA.ObjectToString(_astreams.IsInitialized()),0);
 //BA.debugLineNum = 76;BA.debugLine="mIsConnected = True";
_misconnected = __c.True;
 //BA.debugLineNum = 78;BA.debugLine="Log($\"[B58Serial.Connect] Connected: ${Port}\"$)";
__c.LogImpl("917563663",("[B58Serial.Connect] Connected: "+__c.SmartStringFormatter("",(Object)(_port))+""),0);
 //BA.debugLineNum = 79;BA.debugLine="Utils.CallSubMethod(mCallback, mEventName, \"_Con";
_utils._callsubmethod /*String*/ (_mcallback,_meventname,"_Connected");
 } 
       catch (Exception e12) {
			ba.setLastException(e12); //BA.debugLineNum = 82;BA.debugLine="Dim errorMessage As String = LastException.Messa";
_errormessage = __c.LastException(ba).getMessage();
 //BA.debugLineNum = 83;BA.debugLine="Dim userMessage As String";
_usermessage = "";
 //BA.debugLineNum = 85;BA.debugLine="Log($\"[B58Serial.Connect][E] ${errorMessage}\"$)";
__c.LogImpl("917563670",("[B58Serial.Connect][E] "+__c.SmartStringFormatter("",(Object)(_errormessage))+""),0);
 //BA.debugLineNum = 87;BA.debugLine="If errorMessage.Contains(\"Port not found\") Then";
if (_errormessage.contains("Port not found")) { 
 //BA.debugLineNum = 88;BA.debugLine="userMessage = $\"COM port ${Port} not found.\"$";
_usermessage = ("COM port "+__c.SmartStringFormatter("",(Object)(_port))+" not found.");
 }else if(_errormessage.contains("Port busy")) { 
 //BA.debugLineNum = 90;BA.debugLine="userMessage = $\"COM port ${Port} is already in";
_usermessage = ("COM port "+__c.SmartStringFormatter("",(Object)(_port))+" is already in use.");
 }else {
 //BA.debugLineNum = 92;BA.debugLine="userMessage = \"Unable to connect to \" & Port &";
_usermessage = "Unable to connect to "+_port+".";
 };
 //BA.debugLineNum = 95;BA.debugLine="Disconnect";
_disconnect();
 //BA.debugLineNum = 96;BA.debugLine="Utils.CallSubMethod2(mCallback, mEventName, \"_Er";
_utils._callsubmethod2 /*String*/ (_mcallback,_meventname,"_Error",(Object)(_usermessage));
 };
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return "";
}
public String  _disconnect() throws Exception{
boolean _wasconnected = false;
 //BA.debugLineNum = 101;BA.debugLine="Public Sub Disconnect";
 //BA.debugLineNum = 102;BA.debugLine="Dim WasConnected As Boolean = mIsConnected";
_wasconnected = _misconnected;
 //BA.debugLineNum = 104;BA.debugLine="CommandTimer.Enabled = False";
_commandtimer.setEnabled(__c.False);
 //BA.debugLineNum = 105;BA.debugLine="PendingCommand = False";
_pendingcommand = __c.False;
 //BA.debugLineNum = 106;BA.debugLine="RxBuffer.Clear";
_rxbuffer.Clear();
 //BA.debugLineNum = 108;BA.debugLine="Try";
try { //BA.debugLineNum = 109;BA.debugLine="If AStreams.IsInitialized Then AStreams.Close";
if (_astreams.IsInitialized()) { 
_astreams.Close();};
 } 
       catch (Exception e8) {
			ba.setLastException(e8); //BA.debugLineNum = 111;BA.debugLine="Log(\"[B58Serial.Disconnect][E] Error closing str";
__c.LogImpl("917629194","[B58Serial.Disconnect][E] Error closing streams.",0);
 };
 //BA.debugLineNum = 114;BA.debugLine="Try";
try { //BA.debugLineNum = 115;BA.debugLine="If mIsConnected Then SerialLine.Close";
if (_misconnected) { 
_serialline.Close();};
 } 
       catch (Exception e13) {
			ba.setLastException(e13); //BA.debugLineNum = 117;BA.debugLine="Log(\"[B58Serial.Disconnect][E] Error closing ser";
__c.LogImpl("917629200","[B58Serial.Disconnect][E] Error closing serial port.",0);
 };
 //BA.debugLineNum = 120;BA.debugLine="mIsConnected = False";
_misconnected = __c.False;
 //BA.debugLineNum = 122;BA.debugLine="If WasConnected Then";
if (_wasconnected) { 
 //BA.debugLineNum = 123;BA.debugLine="Log(\"[B58Serial] Disconnected.\")";
__c.LogImpl("917629206","[B58Serial] Disconnected.",0);
 //BA.debugLineNum = 124;BA.debugLine="Utils.CallSubMethod(mCallback, mEventName, \"_Dis";
_utils._callsubmethod /*String*/ (_mcallback,_meventname,"_Disconnected");
 };
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public String  _executecommand(String _command) throws Exception{
String[] _parts = null;
String _device = "";
anywheresoftware.b4a.objects.collections.List _ports = null;
int _adr = 0;
int _cmd = 0;
int _val = 0;
 //BA.debugLineNum = 280;BA.debugLine="Public Sub ExecuteCommand(Command As String)";
 //BA.debugLineNum = 282;BA.debugLine="Dim Parts() As String = Regex.Split(\" \", Command.";
_parts = __c.Regex.Split(" ",_command.trim());
 //BA.debugLineNum = 283;BA.debugLine="Dim Device As String = \"\"";
_device = "";
 //BA.debugLineNum = 285;BA.debugLine="If Parts.Length >= 2 Then Device = Parts(1).ToUpp";
if (_parts.length>=2) { 
_device = _parts[(int) (1)].toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);};
 //BA.debugLineNum = 287;BA.debugLine="Select Device";
switch (BA.switchObjectToInt(_device,"CONNECT","DISCONNECT","LISTPORTS")) {
case 0: {
 //BA.debugLineNum = 290;BA.debugLine="If Parts.Length <> 3 Then";
if (_parts.length!=3) { 
 //BA.debugLineNum = 291;BA.debugLine="Utils.CallSubMethod2(mCallback, mEventName, \"_";
_utils._callsubmethod2 /*String*/ (_mcallback,_meventname,"_CommandError",(Object)("Usage: @SER CONNECT COM10"));
 //BA.debugLineNum = 292;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 295;BA.debugLine="If mIsConnected Then";
if (_misconnected) { 
 //BA.debugLineNum = 296;BA.debugLine="Utils.CallSubMethod2(mCallback, mEventName, \"_";
_utils._callsubmethod2 /*String*/ (_mcallback,_meventname,"_CommandError",(Object)("Already connected."));
 //BA.debugLineNum = 297;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 300;BA.debugLine="Connect(Parts(2))";
_connect(_parts[(int) (2)]);
 break; }
case 1: {
 //BA.debugLineNum = 303;BA.debugLine="If Parts.Length <> 2 Then";
if (_parts.length!=2) { 
 //BA.debugLineNum = 304;BA.debugLine="Utils.CallSubMethod2(mCallback, mEventName, \"_";
_utils._callsubmethod2 /*String*/ (_mcallback,_meventname,"_CommandError",(Object)("Usage: @SER DISCONNECT"));
 //BA.debugLineNum = 305;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 308;BA.debugLine="If mIsConnected = False Then";
if (_misconnected==__c.False) { 
 //BA.debugLineNum = 309;BA.debugLine="Utils.CallSubMethod2(mCallback, mEventName, \"_";
_utils._callsubmethod2 /*String*/ (_mcallback,_meventname,"_CommandError",(Object)("Not connected."));
 //BA.debugLineNum = 310;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 313;BA.debugLine="Disconnect";
_disconnect();
 break; }
case 2: {
 //BA.debugLineNum = 316;BA.debugLine="If Parts.Length <> 2 Then";
if (_parts.length!=2) { 
 //BA.debugLineNum = 317;BA.debugLine="Utils.CallSubMethod2(mCallback, mEventName, \"_";
_utils._callsubmethod2 /*String*/ (_mcallback,_meventname,"_CommandError",(Object)("Usage: @SER LISTPORTS"));
 //BA.debugLineNum = 318;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 321;BA.debugLine="Dim Ports As List = GetAvailablePorts";
_ports = new anywheresoftware.b4a.objects.collections.List();
_ports = _getavailableports();
 //BA.debugLineNum = 323;BA.debugLine="If Ports.Size = 0 Then";
if (_ports.getSize()==0) { 
 //BA.debugLineNum = 324;BA.debugLine="Utils.CallSubMethod(mCallback, mEventName, \"_N";
_utils._callsubmethod /*String*/ (_mcallback,_meventname,"_NoPortsFound");
 //BA.debugLineNum = 325;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 329;BA.debugLine="If SubExists(mCallback, mEventName & \"_PortsFou";
if (__c.SubExists(ba,_mcallback,_meventname+"_PortsFound")) { 
 //BA.debugLineNum = 330;BA.debugLine="CallSubDelayed2(mCallback, mEventName & \"_Port";
__c.CallSubDelayed2(ba,_mcallback,_meventname+"_PortsFound",(Object)(_ports));
 };
 break; }
default: {
 //BA.debugLineNum = 334;BA.debugLine="If Parts.Length <> 4 Then";
if (_parts.length!=4) { 
 //BA.debugLineNum = 335;BA.debugLine="Utils.CallSubMethod2(mCallback, mEventName, \"_";
_utils._callsubmethod2 /*String*/ (_mcallback,_meventname,"_CommandError",(Object)("Usage: @SER ADR CMD VAL"));
 //BA.debugLineNum = 336;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 339;BA.debugLine="If IsNumber(Parts(1)) = False Or IsNumber(Parts";
if (__c.IsNumber(_parts[(int) (1)])==__c.False || __c.IsNumber(_parts[(int) (2)])==__c.False || __c.IsNumber(_parts[(int) (3)])==__c.False) { 
 //BA.debugLineNum = 340;BA.debugLine="Utils.CallSubMethod2(mCallback, mEventName, \"_";
_utils._callsubmethod2 /*String*/ (_mcallback,_meventname,"_CommandError",(Object)("ADR, CMD and VAL must be numeric."));
 //BA.debugLineNum = 341;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 344;BA.debugLine="Dim Adr As Int = Parts(1)";
_adr = (int)(Double.parseDouble(_parts[(int) (1)]));
 //BA.debugLineNum = 345;BA.debugLine="Dim Cmd As Int = Parts(2)";
_cmd = (int)(Double.parseDouble(_parts[(int) (2)]));
 //BA.debugLineNum = 346;BA.debugLine="Dim Val As Int = Parts(3)";
_val = (int)(Double.parseDouble(_parts[(int) (3)]));
 //BA.debugLineNum = 348;BA.debugLine="If Adr < 0 Or Adr > 255 Or Cmd < 0 Or Cmd > 255";
if (_adr<0 || _adr>255 || _cmd<0 || _cmd>255 || _val<0 || _val>255) { 
 //BA.debugLineNum = 349;BA.debugLine="Utils.CallSubMethod2(mCallback, mEventName, \"_";
_utils._callsubmethod2 /*String*/ (_mcallback,_meventname,"_CommandError",(Object)("ADR, CMD and VAL must be in the range 0-255."));
 //BA.debugLineNum = 350;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 353;BA.debugLine="SendCommand(Adr, Cmd, Val)";
_sendcommand((byte) (_adr),(byte) (_cmd),(byte) (_val));
 break; }
}
;
 //BA.debugLineNum = 357;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.collections.List  _getavailableports() throws Exception{
 //BA.debugLineNum = 59;BA.debugLine="Public Sub GetAvailablePorts As List";
 //BA.debugLineNum = 60;BA.debugLine="Return SerialLine.ListPorts";
if (true) return _serialline.ListPorts();
 //BA.debugLineNum = 61;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 45;BA.debugLine="Public Sub Initialize(Callback As Object, EventNam";
 //BA.debugLineNum = 47;BA.debugLine="mCallback = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 48;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 51;BA.debugLine="SerialLine.Initialize(\"SerialLine\")";
_serialline.Initialize("SerialLine");
 //BA.debugLineNum = 52;BA.debugLine="RxBuffer.Initialize";
_rxbuffer.Initialize();
 //BA.debugLineNum = 55;BA.debugLine="CommandTimer.Initialize(\"CommandTimer\", COMMAND_T";
_commandtimer.Initialize(ba,"CommandTimer",(long) (_command_timeout_ms));
 //BA.debugLineNum = 56;BA.debugLine="CommandTimer.Enabled = False";
_commandtimer.setEnabled(__c.False);
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
return "";
}
public boolean  _isconnected() throws Exception{
 //BA.debugLineNum = 128;BA.debugLine="Public Sub IsConnected As Boolean";
 //BA.debugLineNum = 129;BA.debugLine="Return mIsConnected";
if (true) return _misconnected;
 //BA.debugLineNum = 130;BA.debugLine="End Sub";
return false;
}
public String  _processincomingframe(byte[] _frame) throws Exception{
byte _adr = (byte)0;
byte _cmd = (byte)0;
byte _val = (byte)0;
 //BA.debugLineNum = 173;BA.debugLine="Private Sub ProcessIncomingFrame(Frame() As Byte)";
 //BA.debugLineNum = 174;BA.debugLine="Log($\"[B58Serial.ProcessIncomingFrame] frame=${bc";
__c.LogImpl("917825793",("[B58Serial.ProcessIncomingFrame] frame="+__c.SmartStringFormatter("",(Object)(_bc.HexFromBytes(_frame)))+""),0);
 //BA.debugLineNum = 176;BA.debugLine="If B58Protocol.CheckFrame(Frame) = False Then Ret";
if (_b58protocol._checkframe /*boolean*/ (_frame)==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 178;BA.debugLine="Dim Adr As Byte = B58Protocol.GetAdr(Frame)";
_adr = _b58protocol._getadr /*byte*/ (_frame);
 //BA.debugLineNum = 179;BA.debugLine="Dim Cmd As Byte = B58Protocol.GetCmd(Frame)";
_cmd = _b58protocol._getcmd /*byte*/ (_frame);
 //BA.debugLineNum = 180;BA.debugLine="Dim Val As Byte = B58Protocol.GetVal(Frame)";
_val = _b58protocol._getval /*byte*/ (_frame);
 //BA.debugLineNum = 182;BA.debugLine="Log($\"[B58Serial.Frame] ADR=${B58Protocol.ToUnsig";
__c.LogImpl("917825801",("[B58Serial.Frame] ADR="+__c.SmartStringFormatter("",(Object)(_b58protocol._tounsigned /*int*/ (_adr)))+" CMD="+__c.SmartStringFormatter("",(Object)(_b58protocol._tounsigned /*int*/ (_cmd)))+" VAL="+__c.SmartStringFormatter("",(Object)(_b58protocol._tounsigned /*int*/ (_val)))+""),0);
 //BA.debugLineNum = 185;BA.debugLine="If PendingCommand = False Then";
if (_pendingcommand==__c.False) { 
 //BA.debugLineNum = 186;BA.debugLine="If SubExists(mCallback, mEventName & \"_DataRecei";
if (__c.SubExists(ba,_mcallback,_meventname+"_DataReceived")) { 
 //BA.debugLineNum = 187;BA.debugLine="CallSubDelayed2(mCallback, mEventName & \"_DataR";
__c.CallSubDelayed2(ba,_mcallback,_meventname+"_DataReceived",(Object)(_frame));
 };
 //BA.debugLineNum = 189;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 193;BA.debugLine="If Adr <> PendingAdr Or Cmd <> PendingCmd Then";
if (_adr!=_pendingadr || _cmd!=_pendingcmd) { 
 //BA.debugLineNum = 194;BA.debugLine="If SubExists(mCallback, mEventName & \"_DataRecei";
if (__c.SubExists(ba,_mcallback,_meventname+"_DataReceived")) { 
 //BA.debugLineNum = 195;BA.debugLine="CallSubDelayed2(mCallback, mEventName & \"_DataR";
__c.CallSubDelayed2(ba,_mcallback,_meventname+"_DataReceived",(Object)(_frame));
 };
 //BA.debugLineNum = 197;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 200;BA.debugLine="CommandTimer.Enabled = False";
_commandtimer.setEnabled(__c.False);
 //BA.debugLineNum = 201;BA.debugLine="PendingCommand = False";
_pendingcommand = __c.False;
 //BA.debugLineNum = 203;BA.debugLine="If Val = B58Protocol.STATE_ERR Then";
if (_val==_b58protocol._state_err /*byte*/ ) { 
 //BA.debugLineNum = 204;BA.debugLine="Utils.CallSubMethod2(mCallback, mEventName, \"_Co";
_utils._callsubmethod2 /*String*/ (_mcallback,_meventname,"_CommandError",(Object)("Controller rejected command."));
 //BA.debugLineNum = 205;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 208;BA.debugLine="If Val <> PendingVal Then";
if (_val!=_pendingval) { 
 //BA.debugLineNum = 209;BA.debugLine="Utils.CallSubMethod2(mCallback, mEventName, \"_Co";
_utils._callsubmethod2 /*String*/ (_mcallback,_meventname,"_CommandError",(Object)("Unexpected response value."));
 //BA.debugLineNum = 210;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 214;BA.debugLine="If SubExists(mCallback, mEventName & \"_CommandCom";
if (__c.SubExists(ba,_mcallback,_meventname+"_CommandCompleted")) { 
 //BA.debugLineNum = 215;BA.debugLine="CallSubDelayed2(mCallback, mEventName & \"_Comman";
__c.CallSubDelayed2(ba,_mcallback,_meventname+"_CommandCompleted",(Object)(_frame));
 };
 //BA.debugLineNum = 218;BA.debugLine="End Sub";
return "";
}
public boolean  _sendcommand(byte _adr,byte _cmd,byte _val) throws Exception{
byte[] _frame = null;
 //BA.debugLineNum = 241;BA.debugLine="Public Sub SendCommand(Adr As Byte, Cmd As Byte, V";
 //BA.debugLineNum = 242;BA.debugLine="If mIsConnected = False Then";
if (_misconnected==__c.False) { 
 //BA.debugLineNum = 243;BA.debugLine="Log(\"[B58Serial.SendCommand][E] Not connected.\")";
__c.LogImpl("918087938","[B58Serial.SendCommand][E] Not connected.",0);
 //BA.debugLineNum = 244;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 247;BA.debugLine="If PendingCommand Then";
if (_pendingcommand) { 
 //BA.debugLineNum = 248;BA.debugLine="Log(\"[B58Serial.SendCommand][E] Command already";
__c.LogImpl("918087943","[B58Serial.SendCommand][E] Command already pending.",0);
 //BA.debugLineNum = 249;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 252;BA.debugLine="Dim Frame() As Byte = B58Protocol.CreateFrame(Adr";
_frame = _b58protocol._createframe /*byte[]*/ (_adr,_cmd,_val);
 //BA.debugLineNum = 254;BA.debugLine="PendingAdr = Adr";
_pendingadr = _adr;
 //BA.debugLineNum = 255;BA.debugLine="PendingCmd = Cmd";
_pendingcmd = _cmd;
 //BA.debugLineNum = 256;BA.debugLine="PendingVal = Val";
_pendingval = _val;
 //BA.debugLineNum = 257;BA.debugLine="PendingCommand = True";
_pendingcommand = __c.True;
 //BA.debugLineNum = 259;BA.debugLine="If AStreamsWrite(Frame) = False Then";
if (_astreamswrite(_frame)==__c.False) { 
 //BA.debugLineNum = 260;BA.debugLine="PendingCommand = False";
_pendingcommand = __c.False;
 //BA.debugLineNum = 261;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 264;BA.debugLine="CommandTimer.Enabled = True";
_commandtimer.setEnabled(__c.True);
 //BA.debugLineNum = 266;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 267;BA.debugLine="End Sub";
return false;
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
