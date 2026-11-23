
#ifndef b4r_b58protocol_h
#define b4r_b58protocol_h
class b4r_main;
class b4r_commuart;

class b4r_b58protocol {
public:

static bool _checkframe(B4R::Array* _frame);
static B4R::Array* _createframe(Byte _adr,Byte _cmd,Byte _val);
static Byte _getadr(B4R::Array* _frame);
static Byte _getcmd(B4R::Array* _frame);
static Byte _getval(B4R::Array* _frame);
static void _process_globals();
static Byte _frame_size;
static Byte _frame_header;
static Byte _frame_adr_pos;
static Byte _frame_cmd_pos;
static Byte _frame_val_pos;
static Byte _frame_footer;
static Byte _ledd4_pinnr;
static Byte _ledd4_adr;
static Byte _cmd_led_set_state;
static Byte _state_off;
static Byte _state_on;
static Byte _state_err;
static b4r_main* _main;
static b4r_commuart* _commuart;
static Int _tounsigned(Byte _b);
};

#endif