#include "B4RDefines.h"

Byte b4r_b58protocol::_frame_size;
Byte b4r_b58protocol::_frame_header;
Byte b4r_b58protocol::_frame_adr_pos;
Byte b4r_b58protocol::_frame_cmd_pos;
Byte b4r_b58protocol::_frame_val_pos;
Byte b4r_b58protocol::_frame_footer;
Byte b4r_b58protocol::_ledd4_pinnr;
Byte b4r_b58protocol::_ledd4_adr;
Byte b4r_b58protocol::_cmd_led_set_state;
Byte b4r_b58protocol::_state_off;
Byte b4r_b58protocol::_state_on;
Byte b4r_b58protocol::_state_err;
b4r_main* b4r_b58protocol::_main;
b4r_commuart* b4r_b58protocol::_commuart;


 bool b4r_b58protocol::_checkframe(B4R::Array* _frame){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 46;BA.debugLine="Public Sub CheckFrame(frame() As Byte) As Boolean";
 //BA.debugLineNum = 47;BA.debugLine="If frame.Length <> FRAME_SIZE Then";
if (_frame->length!=b4r_b58protocol::_frame_size) { 
 //BA.debugLineNum = 48;BA.debugLine="Log(\"[CheckFrame][E] Invalid frame received. Exp";
B4R::Common::LogHelper(1,102,F("[CheckFrame][E] Invalid frame received. Expect 5 bytes"));
 //BA.debugLineNum = 49;BA.debugLine="Return False";
B4R::StackMemory::cp = cp;
bool res3 = Common_False;
if (true) return res3;
 };
 //BA.debugLineNum = 52;BA.debugLine="If frame(0) <> FRAME_HEADER Or frame(FRAME_SIZE -";
if (((Byte*)_frame->getData((UInt) (0)))[B4R::Array::staticIndex]!=b4r_b58protocol::_frame_header || ((Byte*)_frame->getData((UInt) (b4r_b58protocol::_frame_size-1)))[B4R::Array::staticIndex]!=b4r_b58protocol::_frame_footer) { 
 //BA.debugLineNum = 53;BA.debugLine="Log(\"[CommUART_OnReceived][E] Invalid frame rece";
B4R::Common::LogHelper(1,102,F("[CommUART_OnReceived][E] Invalid frame received."));
 //BA.debugLineNum = 54;BA.debugLine="Return False";
B4R::StackMemory::cp = cp;
bool res7 = Common_False;
if (true) return res7;
 };
 //BA.debugLineNum = 57;BA.debugLine="Return True";
B4R::StackMemory::cp = cp;
bool res9 = Common_True;
if (true) return res9;
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return false;
}
B4R::Array* b4r_b58protocol::_createframe(Byte _adr,Byte _cmd,Byte _val){
const UInt cp = B4R::StackMemory::cp;
Byte be_ann15_14e1[5];
B4R::Array be_ann15_14e2;
 //BA.debugLineNum = 37;BA.debugLine="Public Sub CreateFrame(adr As Byte, cmd As Byte, v";
 //BA.debugLineNum = 38;BA.debugLine="Return Array As Byte( _ 		FRAME_HEADER, _ 		adr,";
B4R::StackMemory::cp = cp;
B4R::Array* res1 = B4R::StackMemory::ReturnArrayOnStack(be_ann15_14e2.create(be_ann15_14e1,5,1,b4r_b58protocol::_frame_header,_adr,_cmd,_val,b4r_b58protocol::_frame_footer), sizeof(Byte));
if (true) return res1;
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return NULL;
}
Byte b4r_b58protocol::_getadr(B4R::Array* _frame){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 60;BA.debugLine="Public Sub GetAdr(frame() As Byte) As Byte";
 //BA.debugLineNum = 61;BA.debugLine="Return frame(FRAME_ADR_POS)";
B4R::StackMemory::cp = cp;
Byte res1 = ((Byte*)_frame->getData((UInt) (b4r_b58protocol::_frame_adr_pos)))[B4R::Array::staticIndex];
if (true) return res1;
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0;
}
Byte b4r_b58protocol::_getcmd(B4R::Array* _frame){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 64;BA.debugLine="Public Sub GetCmd(frame() As Byte) As Byte";
 //BA.debugLineNum = 65;BA.debugLine="Return frame(FRAME_CMD_POS)";
B4R::StackMemory::cp = cp;
Byte res1 = ((Byte*)_frame->getData((UInt) (b4r_b58protocol::_frame_cmd_pos)))[B4R::Array::staticIndex];
if (true) return res1;
 //BA.debugLineNum = 66;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0;
}
Byte b4r_b58protocol::_getval(B4R::Array* _frame){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 68;BA.debugLine="Public Sub GetVal(frame() As Byte) As Byte";
 //BA.debugLineNum = 69;BA.debugLine="Return frame(FRAME_VAL_POS)";
B4R::StackMemory::cp = cp;
Byte res1 = ((Byte*)_frame->getData((UInt) (b4r_b58protocol::_frame_val_pos)))[B4R::Array::staticIndex];
if (true) return res1;
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0;
}
void b4r_b58protocol::_process_globals(){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 13;BA.debugLine="Private Sub Process_Globals";
 //BA.debugLineNum = 15;BA.debugLine="Public FRAME_SIZE 			As Byte = 5";
b4r_b58protocol::_frame_size = (Byte) (5);
 //BA.debugLineNum = 16;BA.debugLine="Public FRAME_HEADER 		As Byte = 0x19		' Fix";
b4r_b58protocol::_frame_header = (Byte) (((Int)0x19));
 //BA.debugLineNum = 17;BA.debugLine="Public FRAME_ADR_POS		As Byte = 1";
b4r_b58protocol::_frame_adr_pos = (Byte) (1);
 //BA.debugLineNum = 18;BA.debugLine="Public FRAME_CMD_POS		As Byte = 2";
b4r_b58protocol::_frame_cmd_pos = (Byte) (2);
 //BA.debugLineNum = 19;BA.debugLine="Public FRAME_VAL_POS		As Byte = 3";
b4r_b58protocol::_frame_val_pos = (Byte) (3);
 //BA.debugLineNum = 20;BA.debugLine="Public FRAME_FOOTER 		As Byte = 0x58		' Fix";
b4r_b58protocol::_frame_footer = (Byte) (((Int)0x58));
 //BA.debugLineNum = 23;BA.debugLine="Public LEDD4_PINNR			As Byte = 4";
b4r_b58protocol::_ledd4_pinnr = (Byte) (4);
 //BA.debugLineNum = 24;BA.debugLine="Public LEDD4_ADR			As Byte = 0x12		' HEX value 0x";
b4r_b58protocol::_ledd4_adr = (Byte) (((Int)0x12));
 //BA.debugLineNum = 27;BA.debugLine="Public CMD_LED_SET_STATE	As Byte = 0x04";
b4r_b58protocol::_cmd_led_set_state = (Byte) (((Int)0x04));
 //BA.debugLineNum = 30;BA.debugLine="Public STATE_OFF 			As Byte = 0x00";
b4r_b58protocol::_state_off = (Byte) (((Int)0x00));
 //BA.debugLineNum = 31;BA.debugLine="Public STATE_ON 			As Byte = 0x01";
b4r_b58protocol::_state_on = (Byte) (((Int)0x01));
 //BA.debugLineNum = 32;BA.debugLine="Public STATE_ERR			As Byte = 0xFF		' Error respon";
b4r_b58protocol::_state_err = (Byte) (((Int)0xff));
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
}
Int b4r_b58protocol::_tounsigned(Byte _b){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 77;BA.debugLine="Public Sub ToUnsigned(b As Byte) As Int";
 //BA.debugLineNum = 78;BA.debugLine="Return Bit.And(0xFF, b)";
B4R::StackMemory::cp = cp;
Int res1 = (Int) (BitClass_And((UInt) (((Int)0xff)),(UInt) (_b)));
if (true) return res1;
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
return 0;
}
