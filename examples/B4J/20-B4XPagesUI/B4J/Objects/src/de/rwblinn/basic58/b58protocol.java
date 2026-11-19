package de.rwblinn.basic58;


import anywheresoftware.b4a.BA;

public class b58protocol extends Object{
public static b58protocol mostCurrent = new b58protocol();

public static BA ba;
static {
		ba = new  anywheresoftware.b4j.objects.FxBA("de.rwblinn.basic58", "de.rwblinn.basic58.b58protocol", null);
		ba.loadHtSubs(b58protocol.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "de.rwblinn.basic58.b58protocol", ba);
		}
	}
    public static Class<?> getObject() {
		return b58protocol.class;
	}

 public static anywheresoftware.b4a.keywords.Common __c = null;
public static byte _frame_size = (byte)0;
public static byte _frame_header = (byte)0;
public static byte _frame_adr_pos = (byte)0;
public static byte _frame_cmd_pos = (byte)0;
public static byte _frame_val_pos = (byte)0;
public static byte _frame_footer = (byte)0;
public static byte _ledd4_pinnr = (byte)0;
public static byte _ledd4_adr = (byte)0;
public static byte _cmd_led_set_state = (byte)0;
public static byte _state_off = (byte)0;
public static byte _state_on = (byte)0;
public static byte _state_err = (byte)0;
public static b4j.example.cssutils _cssutils = null;
public static de.rwblinn.basic58.main _main = null;
public static de.rwblinn.basic58.b4xpages _b4xpages = null;
public static de.rwblinn.basic58.b4xcollections _b4xcollections = null;
public static de.rwblinn.basic58.utils _utils = null;
public static de.rwblinn.basic58.b58help _b58help = null;
public static boolean  _checkframe(byte[] _frame) throws Exception{
 //BA.debugLineNum = 46;BA.debugLine="Public Sub CheckFrame(frame() As Byte) As Boolean";
 //BA.debugLineNum = 47;BA.debugLine="If frame.Length <> FRAME_SIZE Then";
if (_frame.length!=_frame_size) { 
 //BA.debugLineNum = 48;BA.debugLine="Log(\"[CheckFrame][E] Invalid frame received. Exp";
anywheresoftware.b4a.keywords.Common.LogImpl("917039362","[CheckFrame][E] Invalid frame received. Expect 5 bytes",0);
 //BA.debugLineNum = 49;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 52;BA.debugLine="If frame(0) <> FRAME_HEADER Or frame(FRAME_SIZE -";
if (_frame[(int) (0)]!=_frame_header || _frame[(int) (_frame_size-1)]!=_frame_footer) { 
 //BA.debugLineNum = 53;BA.debugLine="Log(\"[CommUART_OnReceived][E] Invalid frame rece";
anywheresoftware.b4a.keywords.Common.LogImpl("917039367","[CommUART_OnReceived][E] Invalid frame received.",0);
 //BA.debugLineNum = 54;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 57;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return false;
}
public static byte[]  _createframe(byte _adr,byte _cmd,byte _val) throws Exception{
 //BA.debugLineNum = 37;BA.debugLine="Public Sub CreateFrame(adr As Byte, cmd As Byte, v";
 //BA.debugLineNum = 38;BA.debugLine="Return Array As Byte( _ 		FRAME_HEADER, _ 		adr,";
if (true) return new byte[]{_frame_header,_adr,_cmd,_val,_frame_footer};
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return null;
}
public static byte  _getadr(byte[] _frame) throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Public Sub GetAdr(frame() As Byte) As Byte";
 //BA.debugLineNum = 61;BA.debugLine="Return frame(FRAME_ADR_POS)";
if (true) return _frame[(int) (_frame_adr_pos)];
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return (byte)0;
}
public static byte  _getcmd(byte[] _frame) throws Exception{
 //BA.debugLineNum = 64;BA.debugLine="Public Sub GetCmd(frame() As Byte) As Byte";
 //BA.debugLineNum = 65;BA.debugLine="Return frame(FRAME_CMD_POS)";
if (true) return _frame[(int) (_frame_cmd_pos)];
 //BA.debugLineNum = 66;BA.debugLine="End Sub";
return (byte)0;
}
public static byte  _getval(byte[] _frame) throws Exception{
 //BA.debugLineNum = 68;BA.debugLine="Public Sub GetVal(frame() As Byte) As Byte";
 //BA.debugLineNum = 69;BA.debugLine="Return frame(FRAME_VAL_POS)";
if (true) return _frame[(int) (_frame_val_pos)];
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return (byte)0;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Private Sub Process_Globals";
 //BA.debugLineNum = 15;BA.debugLine="Public FRAME_SIZE 			As Byte = 5";
_frame_size = (byte) (5);
 //BA.debugLineNum = 16;BA.debugLine="Public FRAME_HEADER 		As Byte = 0x19		' Fix";
_frame_header = (byte) (((int)0x19));
 //BA.debugLineNum = 17;BA.debugLine="Public FRAME_ADR_POS		As Byte = 1";
_frame_adr_pos = (byte) (1);
 //BA.debugLineNum = 18;BA.debugLine="Public FRAME_CMD_POS		As Byte = 2";
_frame_cmd_pos = (byte) (2);
 //BA.debugLineNum = 19;BA.debugLine="Public FRAME_VAL_POS		As Byte = 3";
_frame_val_pos = (byte) (3);
 //BA.debugLineNum = 20;BA.debugLine="Public FRAME_FOOTER 		As Byte = 0x58		' Fix";
_frame_footer = (byte) (((int)0x58));
 //BA.debugLineNum = 23;BA.debugLine="Public LEDD4_PINNR			As Byte = 4";
_ledd4_pinnr = (byte) (4);
 //BA.debugLineNum = 24;BA.debugLine="Public LEDD4_ADR			As Byte = 0x12		' HEX value 0x";
_ledd4_adr = (byte) (((int)0x12));
 //BA.debugLineNum = 27;BA.debugLine="Public CMD_LED_SET_STATE	As Byte = 0x04";
_cmd_led_set_state = (byte) (((int)0x04));
 //BA.debugLineNum = 30;BA.debugLine="Public STATE_OFF 			As Byte = 0x00";
_state_off = (byte) (((int)0x00));
 //BA.debugLineNum = 31;BA.debugLine="Public STATE_ON 			As Byte = 0x01";
_state_on = (byte) (((int)0x01));
 //BA.debugLineNum = 32;BA.debugLine="Public STATE_ERR			As Byte = 0xFF		' Error respon";
_state_err = (byte) (((int)0xff));
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public static int  _tounsigned(byte _b) throws Exception{
 //BA.debugLineNum = 77;BA.debugLine="Public Sub ToUnsigned(b As Byte) As Int";
 //BA.debugLineNum = 78;BA.debugLine="Return Bit.And(0xFF, b)";
if (true) return anywheresoftware.b4a.keywords.Common.Bit.And(((int)0xff),(int) (_b));
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return 0;
}
}
