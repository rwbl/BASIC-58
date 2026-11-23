#include "B4RDefines.h"

bool b4r_commuart::_debug;
Byte b4r_commuart::_frame_header;
Byte b4r_commuart::_frame_footer;
Byte b4r_commuart::_status_ok;
Byte b4r_commuart::_status_err;
Byte b4r_commuart::_status_busy;
B4R::Array* b4r_commuart::_statustxframe;
Int b4r_commuart::_framesize;
Int b4r_commuart::_frameheader;
Int b4r_commuart::_framefooter;
B4R::AsyncStreams* b4r_commuart::_astreamline;
B4R::Array* b4r_commuart::_rxbuffer;
Int b4r_commuart::_rxlen;
B4R::Array* b4r_commuart::_activeframe;
UInt b4r_commuart::_totalbytes;
UInt b4r_commuart::_overflowcount;
B4R::ByteConverter* b4r_commuart::_byteconv;
b4r_main* b4r_commuart::_main;
b4r_b58protocol* b4r_commuart::_b58protocol;
static Byte be_gann7_4e1[3];
static B4R::Array be_gann7_4e2;
static B4R::AsyncStreams be_gann11_3;
static Byte be_gann12_4e1[64];
static B4R::Array be_gann12_4e2;
static Byte be_gann14_4e1[16];
static B4R::Array be_gann14_4e2;
static B4R::ByteConverter be_gann17_3;


 void b4r_commuart::_initialize(B4R::B4RStream* _stream,Int _size){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 81;BA.debugLine="Public Sub Initialize(stream As Stream, size As In";
 //BA.debugLineNum = 82;BA.debugLine="FrameSize = size";
b4r_commuart::_framesize = _size;
 //BA.debugLineNum = 83;BA.debugLine="AStreamLine.Initialize(stream, \"OnReceived\", \"OnE";
b4r_commuart::_astreamline->Initialize(_stream,_onreceived,_onerror);
 //BA.debugLineNum = 84;BA.debugLine="If Debug Then";
if (b4r_commuart::_debug) { 
 //BA.debugLineNum = 85;BA.debugLine="Log(\"[CommUART.Initialize][I] Module ready. Fram";
B4R::Common::LogHelper(2,102,F("[CommUART.Initialize][I] Module ready. Frame size: "),3,b4r_commuart::_framesize);
 };
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_commuart::_onerror(){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 161;BA.debugLine="Public Sub OnError";
 //BA.debugLineNum = 162;BA.debugLine="If Debug Then Log(\"[CommUART.OnError][E] Stream d";
if (b4r_commuart::_debug) { 
B4R::Common::LogHelper(1,102,F("[CommUART.OnError][E] Stream disconnected or I/O failure."));};
 //BA.debugLineNum = 163;BA.debugLine="Main.CommUART_OnError";
b4r_commuart::_main->_commuart_onerror /*void*/ ();
 //BA.debugLineNum = 164;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_commuart::_onreceived(B4R::Array* _buffer){
const UInt cp = B4R::StackMemory::cp;
Int _i = 0;
B4R::Array be_ann54_4e2;
B4R::Array* _framebuffer = NULL;
 //BA.debugLineNum = 101;BA.debugLine="Public Sub OnReceived(buffer() As Byte)";
 //BA.debugLineNum = 102;BA.debugLine="TotalBytes = TotalBytes + buffer.Length";
b4r_commuart::_totalbytes = (UInt) (b4r_commuart::_totalbytes+_buffer->length);
 //BA.debugLineNum = 104;BA.debugLine="If Debug Then";
if (b4r_commuart::_debug) { 
 //BA.debugLineNum = 105;BA.debugLine="Log(\"[CommUART.OnReceived][I] len=\", buffer.Leng";
B4R::Common::LogHelper(4,102,F("[CommUART.OnReceived][I] len="),3,_buffer->length,102,F(" bytes="),101,b4r_commuart::_byteconv->HexFromBytes(_buffer)->data);
 };
 //BA.debugLineNum = 111;BA.debugLine="For i = 0 To buffer.Length - 1";
{
const int step5 = 1;
const int limit5 = (Int) (_buffer->length-1);
_i = 0 ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 112;BA.debugLine="If RXLen >= RXBuffer.Length Then";
if (b4r_commuart::_rxlen>=b4r_commuart::_rxbuffer->length) { 
 //BA.debugLineNum = 113;BA.debugLine="OverflowCount = OverflowCount + 1";
b4r_commuart::_overflowcount = (UInt) (b4r_commuart::_overflowcount+1);
 //BA.debugLineNum = 114;BA.debugLine="Log(\"[CommUART.OnReceived][E] RX buffer overflo";
B4R::Common::LogHelper(2,102,F("[CommUART.OnReceived][E] RX buffer overflow -> flushing. Count="),4,b4r_commuart::_overflowcount);
 //BA.debugLineNum = 115;BA.debugLine="RXLen = 0";
b4r_commuart::_rxlen = 0;
 //BA.debugLineNum = 116;BA.debugLine="Exit";
if (true) break;
 };
 //BA.debugLineNum = 119;BA.debugLine="RXBuffer(RXLen) = buffer(i)";
((Byte*)b4r_commuart::_rxbuffer->getData((UInt) (b4r_commuart::_rxlen)))[B4R::Array::staticIndex] = ((Byte*)_buffer->getData((UInt) (_i)))[B4R::Array::staticIndex];
 //BA.debugLineNum = 120;BA.debugLine="RXLen = RXLen + 1";
b4r_commuart::_rxlen = (Int) (b4r_commuart::_rxlen+1);
 }
};
 //BA.debugLineNum = 126;BA.debugLine="Do While RXLen >= FrameSize";
while (b4r_commuart::_rxlen>=b4r_commuart::_framesize) {
 //BA.debugLineNum = 129;BA.debugLine="If RXBuffer(0) <> FrameHeader Then";
if (((Byte*)b4r_commuart::_rxbuffer->getData((UInt) (0)))[B4R::Array::staticIndex]!=b4r_commuart::_frameheader) { 
 //BA.debugLineNum = 130;BA.debugLine="ShiftLeft(1)";
_shiftleft((UInt) (1));
 //BA.debugLineNum = 131;BA.debugLine="Continue";
if (true) continue;
 };
 //BA.debugLineNum = 135;BA.debugLine="If RXBuffer(FrameSize - 1) <> FrameFooter Then";
if (((Byte*)b4r_commuart::_rxbuffer->getData((UInt) (b4r_commuart::_framesize-1)))[B4R::Array::staticIndex]!=b4r_commuart::_framefooter) { 
 //BA.debugLineNum = 136;BA.debugLine="ShiftLeft(1)";
_shiftleft((UInt) (1));
 //BA.debugLineNum = 137;BA.debugLine="Continue";
if (true) continue;
 };
 //BA.debugLineNum = 141;BA.debugLine="For i = 0 To FrameSize - 1";
{
const int step24 = 1;
const int limit24 = (Int) (b4r_commuart::_framesize-1);
_i = 0 ;
for (;_i <= limit24 ;_i = _i + step24 ) {
 //BA.debugLineNum = 142;BA.debugLine="ActiveFrame(i) = RXBuffer(i)";
((Byte*)b4r_commuart::_activeframe->getData((UInt) (_i)))[B4R::Array::staticIndex] = ((Byte*)b4r_commuart::_rxbuffer->getData((UInt) (_i)))[B4R::Array::staticIndex];
 }
};
 //BA.debugLineNum = 145;BA.debugLine="ShiftLeft(FrameSize)";
_shiftleft((UInt) (b4r_commuart::_framesize));
 //BA.debugLineNum = 150;BA.debugLine="Dim framebuffer(FrameSize) As Byte";
_framebuffer =be_ann54_4e2.wrapDynamic(b4r_commuart::_framesize, sizeof(Byte));
 //BA.debugLineNum = 151;BA.debugLine="For i = 0 To FrameSize - 1";
{
const int step29 = 1;
const int limit29 = (Int) (b4r_commuart::_framesize-1);
_i = 0 ;
for (;_i <= limit29 ;_i = _i + step29 ) {
 //BA.debugLineNum = 152;BA.debugLine="framebuffer(i) = ActiveFrame(i)";
((Byte*)_framebuffer->getData((UInt) (_i)))[B4R::Array::staticIndex] = ((Byte*)b4r_commuart::_activeframe->getData((UInt) (_i)))[B4R::Array::staticIndex];
 }
};
 //BA.debugLineNum = 155;BA.debugLine="Main.CommUART_OnReceived(framebuffer)";
b4r_commuart::_main->_commuart_onreceived /*void*/ (_framebuffer);
 }
;
 //BA.debugLineNum = 158;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_commuart::_process_globals(){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 27;BA.debugLine="Private Sub Process_Globals";
 //BA.debugLineNum = 29;BA.debugLine="Public Debug As Boolean = False";
b4r_commuart::_debug = Common_False;
 //BA.debugLineNum = 32;BA.debugLine="Private FRAME_HEADER As Byte = 0x19	' Example: ST";
b4r_commuart::_frame_header = (Byte) (((Int)0x19));
 //BA.debugLineNum = 33;BA.debugLine="Private FRAME_FOOTER As Byte = 0x58	' Example: ET";
b4r_commuart::_frame_footer = (Byte) (((Int)0x58));
 //BA.debugLineNum = 36;BA.debugLine="Private Const STATUS_OK   As Byte = 0x06 ' ASCII";
b4r_commuart::_status_ok = (Byte) (((Int)0x06));
 //BA.debugLineNum = 37;BA.debugLine="Private Const STATUS_ERR  As Byte = 0x15 ' ASCII";
b4r_commuart::_status_err = (Byte) (((Int)0x15));
 //BA.debugLineNum = 38;BA.debugLine="Private Const STATUS_BUSY As Byte = 0x16 ' ASCII";
b4r_commuart::_status_busy = (Byte) (((Int)0x16));
 //BA.debugLineNum = 41;BA.debugLine="Private StatusTXFrame(3) As Byte	' Frame used to";
b4r_commuart::_statustxframe =be_gann7_4e2.wrap(be_gann7_4e1,3);
 //BA.debugLineNum = 44;BA.debugLine="Public FrameSize As Int = 5					' Default size 5";
b4r_commuart::_framesize = 5;
 //BA.debugLineNum = 45;BA.debugLine="Public FrameHeader As Int = FRAME_HEADER	' Defaul";
b4r_commuart::_frameheader = (Int) (b4r_commuart::_frame_header);
 //BA.debugLineNum = 46;BA.debugLine="Public FrameFooter As Int = FRAME_FOOTER	' Defaul";
b4r_commuart::_framefooter = (Int) (b4r_commuart::_frame_footer);
 //BA.debugLineNum = 59;BA.debugLine="Private AStreamLine As AsyncStreams";
b4r_commuart::_astreamline = &be_gann11_3;
 //BA.debugLineNum = 62;BA.debugLine="Private RXBuffer(64) As Byte";
b4r_commuart::_rxbuffer =be_gann12_4e2.wrap(be_gann12_4e1,64);
 //BA.debugLineNum = 63;BA.debugLine="Private RXLen As Int = 0";
b4r_commuart::_rxlen = 0;
 //BA.debugLineNum = 66;BA.debugLine="Private ActiveFrame(16) As Byte";
b4r_commuart::_activeframe =be_gann14_4e2.wrap(be_gann14_4e1,16);
 //BA.debugLineNum = 67;BA.debugLine="Private TotalBytes As UInt = 0";
b4r_commuart::_totalbytes = (UInt) (0);
 //BA.debugLineNum = 68;BA.debugLine="Private OverflowCount As UInt = 0";
b4r_commuart::_overflowcount = (UInt) (0);
 //BA.debugLineNum = 71;BA.debugLine="Private ByteConv As ByteConverter";
b4r_commuart::_byteconv = &be_gann17_3;
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
}
void b4r_commuart::_shiftleft(UInt _count){
const UInt cp = B4R::StackMemory::cp;
Int _i = 0;
 //BA.debugLineNum = 397;BA.debugLine="Private Sub ShiftLeft(count As UInt)";
 //BA.debugLineNum = 398;BA.debugLine="For i = count To RXLen - 1";
{
const int step1 = 1;
const int limit1 = (Int) (b4r_commuart::_rxlen-1);
_i = (Int) (_count) ;
for (;_i <= limit1 ;_i = _i + step1 ) {
 //BA.debugLineNum = 399;BA.debugLine="RXBuffer(i - count) = RXBuffer(i)";
((Byte*)b4r_commuart::_rxbuffer->getData((UInt) (_i-_count)))[B4R::Array::staticIndex] = ((Byte*)b4r_commuart::_rxbuffer->getData((UInt) (_i)))[B4R::Array::staticIndex];
 }
};
 //BA.debugLineNum = 401;BA.debugLine="RXLen = RXLen - count";
b4r_commuart::_rxlen = (Int) (b4r_commuart::_rxlen-_count);
 //BA.debugLineNum = 402;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_commuart::_write(B4R::Array* _data){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 172;BA.debugLine="Public Sub Write(data() As Byte)";
 //BA.debugLineNum = 173;BA.debugLine="If data.Length > 0 Then";
if (_data->length>0) { 
 //BA.debugLineNum = 174;BA.debugLine="AStreamLine.Write(data)";
b4r_commuart::_astreamline->Write(_data);
 //BA.debugLineNum = 175;BA.debugLine="If Debug Then";
if (b4r_commuart::_debug) { 
 //BA.debugLineNum = 176;BA.debugLine="Log(\"[CommUART.Write][I] data=\", ByteConv.HexFr";
B4R::Common::LogHelper(4,102,F("[CommUART.Write][I] data="),101,b4r_commuart::_byteconv->HexFromBytes(_data)->data,102,F(" length="),3,_data->length);
 };
 };
 //BA.debugLineNum = 179;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_commuart::_writestatusbusy(){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 205;BA.debugLine="Public Sub WriteStatusBusy";
 //BA.debugLineNum = 206;BA.debugLine="StatusTXFrame(0) = FrameHeader";
((Byte*)b4r_commuart::_statustxframe->getData((UInt) (0)))[B4R::Array::staticIndex] = (Byte) (b4r_commuart::_frameheader);
 //BA.debugLineNum = 207;BA.debugLine="StatusTXFrame(1) = STATUS_BUSY";
((Byte*)b4r_commuart::_statustxframe->getData((UInt) (1)))[B4R::Array::staticIndex] = b4r_commuart::_status_busy;
 //BA.debugLineNum = 208;BA.debugLine="StatusTXFrame(2) = FrameFooter";
((Byte*)b4r_commuart::_statustxframe->getData((UInt) (2)))[B4R::Array::staticIndex] = (Byte) (b4r_commuart::_framefooter);
 //BA.debugLineNum = 209;BA.debugLine="AStreamLine.Write(StatusTXFrame)";
b4r_commuart::_astreamline->Write(b4r_commuart::_statustxframe);
 //BA.debugLineNum = 211;BA.debugLine="If Debug Then Log(\"[CommUART.WriteStatusBusy][W]";
if (b4r_commuart::_debug) { 
B4R::Common::LogHelper(1,102,F("[CommUART.WriteStatusBusy][W] BUSY frame sent."));};
 //BA.debugLineNum = 212;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_commuart::_writestatuserr(){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 194;BA.debugLine="Public Sub WriteStatusErr";
 //BA.debugLineNum = 195;BA.debugLine="StatusTXFrame(0) = FrameHeader";
((Byte*)b4r_commuart::_statustxframe->getData((UInt) (0)))[B4R::Array::staticIndex] = (Byte) (b4r_commuart::_frameheader);
 //BA.debugLineNum = 196;BA.debugLine="StatusTXFrame(1) = STATUS_ERR";
((Byte*)b4r_commuart::_statustxframe->getData((UInt) (1)))[B4R::Array::staticIndex] = b4r_commuart::_status_err;
 //BA.debugLineNum = 197;BA.debugLine="StatusTXFrame(2) = FrameFooter";
((Byte*)b4r_commuart::_statustxframe->getData((UInt) (2)))[B4R::Array::staticIndex] = (Byte) (b4r_commuart::_framefooter);
 //BA.debugLineNum = 198;BA.debugLine="AStreamLine.Write(StatusTXFrame)";
b4r_commuart::_astreamline->Write(b4r_commuart::_statustxframe);
 //BA.debugLineNum = 200;BA.debugLine="If Debug Then Log(\"[CommUART.WriteStatusErr][E] E";
if (b4r_commuart::_debug) { 
B4R::Common::LogHelper(1,102,F("[CommUART.WriteStatusErr][E] ERR frame sent."));};
 //BA.debugLineNum = 201;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
void b4r_commuart::_writestatusok(){
const UInt cp = B4R::StackMemory::cp;
 //BA.debugLineNum = 183;BA.debugLine="Public Sub WriteStatusOk";
 //BA.debugLineNum = 184;BA.debugLine="StatusTXFrame(0) = FrameHeader";
((Byte*)b4r_commuart::_statustxframe->getData((UInt) (0)))[B4R::Array::staticIndex] = (Byte) (b4r_commuart::_frameheader);
 //BA.debugLineNum = 185;BA.debugLine="StatusTXFrame(1) = STATUS_OK";
((Byte*)b4r_commuart::_statustxframe->getData((UInt) (1)))[B4R::Array::staticIndex] = b4r_commuart::_status_ok;
 //BA.debugLineNum = 186;BA.debugLine="StatusTXFrame(2) = FrameFooter";
((Byte*)b4r_commuart::_statustxframe->getData((UInt) (2)))[B4R::Array::staticIndex] = (Byte) (b4r_commuart::_framefooter);
 //BA.debugLineNum = 187;BA.debugLine="AStreamLine.Write(StatusTXFrame)";
b4r_commuart::_astreamline->Write(b4r_commuart::_statustxframe);
 //BA.debugLineNum = 189;BA.debugLine="If Debug Then Log(\"[CommUART.WriteStatusOk][I] AC";
if (b4r_commuart::_debug) { 
B4R::Common::LogHelper(1,102,F("[CommUART.WriteStatusOk][I] ACK frame sent."));};
 //BA.debugLineNum = 190;BA.debugLine="End Sub";
B4R::StackMemory::cp = cp;
}
