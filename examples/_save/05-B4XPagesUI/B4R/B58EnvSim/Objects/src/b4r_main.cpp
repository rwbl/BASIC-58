#include "B4RDefines.h"

B4R::Serial* b4r_main::_serialline;
B4R::Pin* b4r_main::_ledd4;
Byte b4r_main::_temp_address;
Byte b4r_main::_temp_command;
B4R::Timer* b4r_main::_simtimer;
B4R::ByteConverter* b4r_main::_bc;
b4r_b58protocol* b4r_main::_b58protocol;
b4r_commuart* b4r_main::_commuart;
static B4R::Serial be_gann1_3;
static B4R::Pin be_gann2_3;
static B4R::Timer be_gann5_3;
static B4R::ByteConverter be_gann6_3;


 void b4r_main::_appstart(){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 39;BA.debugLine="Private Sub AppStart";
 //BA.debugLineNum = 41;BA.debugLine="SerialLine.Initialize(115200)";
b4r_main::_serialline->Initialize((ULong) (115200));
 //BA.debugLineNum = 44;BA.debugLine="LedD4.Initialize(B58Protocol.LEDD4_PINNR, LedD4.M";
b4r_main::_ledd4->Initialize(b4r_main::_b58protocol->_ledd4_pinnr /*Byte*/ ,Pin_MODE_OUTPUT);
 //BA.debugLineNum = 45;BA.debugLine="LedD4.DigitalWrite(False)";
b4r_main::_ledd4->DigitalWrite(Common_False);
 //BA.debugLineNum = 48;BA.debugLine="CommUart.Initialize(SerialLine.Stream, B58Protoco";
b4r_main::_commuart->_initialize /*void*/ (b4r_main::_serialline->getStream(),(Int) (b4r_main::_b58protocol->_frame_size /*Byte*/ ));
 //BA.debugLineNum = 50;BA.debugLine="SimTimer.Initialize(\"SimTimer_Tick\", 2000)";
b4r_main::_simtimer->Initialize(_simtimer_tick,(ULong) (2000));
 //BA.debugLineNum = 51;BA.debugLine="SimTimer.Enabled = True";
b4r_main::_simtimer->setEnabled(Common_True);
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_main::_commuart_onerror(){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 123;BA.debugLine="Public Sub CommUART_OnError";
 //BA.debugLineNum = 124;BA.debugLine="Log(\"[Main.CommUART_OnError][E]\")";
B4R::Common::LogHelper(1,102,F("[Main.CommUART_OnError][E]"));
 //BA.debugLineNum = 125;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_main::_commuart_onreceived(B4R::Array* _frame){
const UInt cp = B4R::StackMemory::cp;
Byte _adr = 0;
Byte _cmd = 0;
Byte _val = 0;
B4R::Object be_ann29_1;
B4R::Object be_ann30_3;
B4R::Object be_ann31_1;
B4R::Object be_ann32_3;
 //BA.debugLineNum = 88;BA.debugLine="Public Sub CommUART_OnReceived(frame() As Byte)";
 //BA.debugLineNum = 91;BA.debugLine="If Not(B58Protocol.CheckFrame(frame)) Then Return";
if (Common_Not(b4r_main::_b58protocol->_checkframe /*bool*/ (_frame))) { 
B4R::StackMemory::cp = cp;
if (true) return ;};
 //BA.debugLineNum = 93;BA.debugLine="Dim adr As Byte = B58Protocol.GetAdr(frame)";
_adr = b4r_main::_b58protocol->_getadr /*Byte*/ (_frame);
 //BA.debugLineNum = 94;BA.debugLine="Dim cmd As Byte = B58Protocol.GetCmd(frame)";
_cmd = b4r_main::_b58protocol->_getcmd /*Byte*/ (_frame);
 //BA.debugLineNum = 95;BA.debugLine="Dim val As Byte = B58Protocol.GetVal(frame)";
_val = b4r_main::_b58protocol->_getval /*Byte*/ (_frame);
 //BA.debugLineNum = 97;BA.debugLine="Select adr";
switch (B4R::BR::switchObjectToInt(2,be_ann29_1.wrapNumber((Long)_adr),be_ann30_3.wrapNumber((Long)b4r_main::_b58protocol->_ledd4_adr /*Byte*/ ))) {
case 0: {
 //BA.debugLineNum = 99;BA.debugLine="Select cmd";
switch (B4R::BR::switchObjectToInt(2,be_ann31_1.wrapNumber((Long)_cmd),be_ann32_3.wrapNumber((Long)b4r_main::_b58protocol->_cmd_led_set_state /*Byte*/ ))) {
case 0: {
 //BA.debugLineNum = 101;BA.debugLine="If val = B58Protocol.STATE_OFF Or val = B58Pr";
if (_val==b4r_main::_b58protocol->_state_off /*Byte*/  || _val==b4r_main::_b58protocol->_state_on /*Byte*/ ) { 
 //BA.debugLineNum = 102;BA.debugLine="LedD4.DigitalWrite(val = B58Protocol.STATE_O";
b4r_main::_ledd4->DigitalWrite(_val==b4r_main::_b58protocol->_state_on /*Byte*/ );
 //BA.debugLineNum = 105;BA.debugLine="CommUART_Write(B58Protocol.CreateFrame(adr,";
_commuart_write(b4r_main::_b58protocol->_createframe /*B4R::Array**/ (_adr,_cmd,_val));
 }else {
 //BA.debugLineNum = 108;BA.debugLine="CommUART_Write(B58Protocol.CreateFrame(adr,";
_commuart_write(b4r_main::_b58protocol->_createframe /*B4R::Array**/ (_adr,_cmd,b4r_main::_b58protocol->_state_err /*Byte*/ ));
 };
 break; }
default: {
 //BA.debugLineNum = 113;BA.debugLine="CommUART_Write(B58Protocol.CreateFrame(adr, c";
_commuart_write(b4r_main::_b58protocol->_createframe /*B4R::Array**/ (_adr,_cmd,b4r_main::_b58protocol->_state_err /*Byte*/ ));
 break; }
}
;
 break; }
default: {
 //BA.debugLineNum = 118;BA.debugLine="CommUART_Write(B58Protocol.CreateFrame(adr, cmd";
_commuart_write(b4r_main::_b58protocol->_createframe /*B4R::Array**/ (_adr,_cmd,b4r_main::_b58protocol->_state_err /*Byte*/ ));
 break; }
}
;
 //BA.debugLineNum = 120;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_main::_commuart_write(B4R::Array* _data){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 131;BA.debugLine="Private Sub CommUART_Write(data() As Byte)";
 //BA.debugLineNum = 132;BA.debugLine="CommUart.Write(data)";
b4r_main::_commuart->_write /*void*/ (_data);
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}

void b4r_main::initializeProcessGlobals() {
     B4R::StackMemory::buffer = (byte*)malloc(STACK_BUFFER_SIZE);
     b4r_main::_process_globals();
b4r_b58protocol::_process_globals();
b4r_commuart::_process_globals();

   
}
void b4r_main::_process_globals(){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 21;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 22;BA.debugLine="Public SerialLine 			As Serial			' UART0 (Port 0)";
b4r_main::_serialline = &be_gann1_3;
 //BA.debugLineNum = 26;BA.debugLine="Private LedD4 				As Pin				' See B58 protocol";
b4r_main::_ledd4 = &be_gann2_3;
 //BA.debugLineNum = 29;BA.debugLine="Private Const TEMP_ADDRESS As Byte = 0x20";
b4r_main::_temp_address = (Byte) (((Int)0x20));
 //BA.debugLineNum = 30;BA.debugLine="Private Const TEMP_COMMAND As Byte = 0x01";
b4r_main::_temp_command = (Byte) (((Int)0x01));
 //BA.debugLineNum = 33;BA.debugLine="Private SimTimer 			As Timer";
b4r_main::_simtimer = &be_gann5_3;
 //BA.debugLineNum = 36;BA.debugLine="Private bc					As ByteConverter	'ignore. For test";
b4r_main::_bc = &be_gann6_3;
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
}
void b4r_main::_simtimer_tick(){
const UInt cp = B4R::StackMemory::cp;
Byte _tempvalue = 0;
B4R::Array* _frame = NULL;
 //BA.debugLineNum = 68;BA.debugLine="Sub SimTimer_Tick";
 //BA.debugLineNum = 70;BA.debugLine="Dim TempValue As Byte = Rnd(18, 31)";
_tempvalue = (Byte) (Common_Rnd((Long) (18),(Long) (31)));
 //BA.debugLineNum = 73;BA.debugLine="Dim Frame() As Byte = B58Protocol.CreateFrame(TEM";
_frame = b4r_main::_b58protocol->_createframe /*B4R::Array**/ (b4r_main::_temp_address,b4r_main::_temp_command,_tempvalue);
 //BA.debugLineNum = 76;BA.debugLine="CommUART_Write(Frame)";
_commuart_write(_frame);
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_main::_test(Byte _adr,Byte _cmd,Byte _val){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 61;BA.debugLine="Private Sub Test(adr As Byte, cmd As Byte, val As";
 //BA.debugLineNum = 62;BA.debugLine="CommUART_OnReceived(B58Protocol.CreateFrame(adr,";
_commuart_onreceived(b4r_main::_b58protocol->_createframe /*B4R::Array**/ (_adr,_cmd,_val));
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
