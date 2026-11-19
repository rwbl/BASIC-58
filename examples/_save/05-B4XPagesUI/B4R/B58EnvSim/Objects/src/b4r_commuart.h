
#ifndef b4r_commuart_h
#define b4r_commuart_h
class b4r_main;
class b4r_b58protocol;

class b4r_commuart {
public:

static void _initialize(B4R::B4RStream* _stream,Int _size);
static void _onerror();
static void _onreceived(B4R::Array* _buffer);
static void _process_globals();
static bool _debug;
static Byte _frame_header;
static Byte _frame_footer;
static Byte _status_ok;
static Byte _status_err;
static Byte _status_busy;
static B4R::Array* _statustxframe;
static Int _framesize;
static Int _frameheader;
static Int _framefooter;
static B4R::AsyncStreams* _astreamline;
static B4R::Array* _rxbuffer;
static Int _rxlen;
static B4R::Array* _activeframe;
static UInt _totalbytes;
static UInt _overflowcount;
static B4R::ByteConverter* _byteconv;
static b4r_main* _main;
static b4r_b58protocol* _b58protocol;
static void _shiftleft(UInt _count);
static void _write(B4R::Array* _data);
static void _writestatusbusy();
static void _writestatuserr();
static void _writestatusok();
};

#endif