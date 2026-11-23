
#ifndef b4r_main_h
#define b4r_main_h
class b4r_b58protocol;
class b4r_commuart;

class b4r_main {
public:

static void initializeProcessGlobals();
static void _appstart();
static void _commuart_onerror();
static void _commuart_onreceived(B4R::Array* _frame);
static void _commuart_write(B4R::Array* _data);
static void _process_globals();
static B4R::Serial* _serialline;
static B4R::Pin* _ledd4;
static Byte _temp_address;
static Byte _temp_command;
static B4R::Timer* _simtimer;
static B4R::ByteConverter* _bc;
static b4r_b58protocol* _b58protocol;
static b4r_commuart* _commuart;
static void _simtimer_tick();
static void _test(Byte _adr,Byte _cmd,Byte _val);
};

#endif