package de.rwblinn.basic58;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class b58interpreter extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4j.objects.FxBA("de.rwblinn.basic58", "de.rwblinn.basic58.b58interpreter", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", de.rwblinn.basic58.b58interpreter.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public Object _mcallback = null;
public String _meventname = "";
public int _max_var_length = 0;
public anywheresoftware.b4a.objects.collections.Map _programlines = null;
public anywheresoftware.b4a.objects.collections.Map _variables = null;
public anywheresoftware.b4a.objects.collections.Map _arrays = null;
public anywheresoftware.b4a.objects.collections.Map _functions = null;
public anywheresoftware.b4a.objects.collections.List _runlines = null;
public int _runposition = 0;
public boolean _waitingforinput = false;
public anywheresoftware.b4a.objects.collections.List _inputvariables = null;
public String _inputprompt = "";
public boolean _waitingfordelay = false;
public int _delaymilliseconds = 0;
public boolean _waitingforhardwarecommand = false;
public String _exprtext = "";
public int _exprpos = 0;
public boolean _exprerror = false;
public anywheresoftware.b4a.objects.collections.List _forstack = null;
public anywheresoftware.b4a.objects.collections.List _gosubstack = null;
public anywheresoftware.b4a.objects.collections.List _dataitems = null;
public int _dataposition = 0;
public int _dataerrorline = 0;
public boolean _waitingforexternaldata = false;
public String _externaldatatarget = "";
public String _externaldatatarget2 = "";
public String _externaldatatarget3 = "";
public boolean _traceenabled = false;
public int _errorhandlerline = 0;
public boolean _errorhandlerenabled = false;
public boolean _errorhandlerrunning = false;
public int _errorlineposition = 0;
public int _errornextposition = 0;
public int _errorcode = 0;
public int _errorlinenumber = 0;
public int _exprerrorcode = 0;
public String _readerrormessage = "";
public String _programerrormessage = "";
public b4j.example.cssutils _cssutils = null;
public de.rwblinn.basic58.main _main = null;
public de.rwblinn.basic58.b4xpages _b4xpages = null;
public de.rwblinn.basic58.b4xcollections _b4xcollections = null;
public de.rwblinn.basic58.b58protocol _b58protocol = null;
public de.rwblinn.basic58.utils _utils = null;
public de.rwblinn.basic58.b58help _b58help = null;
public boolean  _addinputvariable(String _variablename) throws Exception{
int _openpos = 0;
int _closepos = 0;
String _arrayname = "";
String _indextext = "";
double _indexvalue = 0;
int _arrayindex = 0;
anywheresoftware.b4a.objects.collections.List _values = null;
 //BA.debugLineNum = 2290;BA.debugLine="Private Sub AddInputVariable(VariableName As Strin";
 //BA.debugLineNum = 2292;BA.debugLine="VariableName = VariableName.ToUpperCase";
_variablename = _variablename.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 2295;BA.debugLine="Dim OpenPos As Int = VariableName.IndexOf(\"(\")";
_openpos = _variablename.indexOf("(");
 //BA.debugLineNum = 2296;BA.debugLine="Dim ClosePos As Int = VariableName.IndexOf(\")\")";
_closepos = _variablename.indexOf(")");
 //BA.debugLineNum = 2298;BA.debugLine="If OpenPos > 0 Then";
if (_openpos>0) { 
 //BA.debugLineNum = 2300;BA.debugLine="If ClosePos <> VariableName.Length - 1 Then Retu";
if (_closepos!=_variablename.length()-1) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2302;BA.debugLine="Dim ArrayName As String = VariableName.SubString";
_arrayname = _variablename.substring((int) (0),_openpos).trim();
 //BA.debugLineNum = 2303;BA.debugLine="Dim IndexText As String = VariableName.SubString";
_indextext = _variablename.substring((int) (_openpos+1),_closepos).trim();
 //BA.debugLineNum = 2305;BA.debugLine="If IsValidVariable(ArrayName) = False Then Retur";
if (_isvalidvariable(_arrayname)==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2306;BA.debugLine="If ArrayName.EndsWith(\"$\") Then Return False";
if (_arrayname.endsWith("$")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2307;BA.debugLine="If Arrays.ContainsKey(ArrayName) = False Then Re";
if (_arrays.ContainsKey((Object)(_arrayname))==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2309;BA.debugLine="Dim IndexValue As Double = EvaluateNumericExpres";
_indexvalue = _evaluatenumericexpression(_indextext);
 //BA.debugLineNum = 2311;BA.debugLine="If ExprError Then Return False";
if (_exprerror) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2312;BA.debugLine="If IndexValue < 1 Or IndexValue <> Floor(IndexVa";
if (_indexvalue<1 || _indexvalue!=__c.Floor(_indexvalue)) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2314;BA.debugLine="Dim ArrayIndex As Int = IndexValue";
_arrayindex = (int) (_indexvalue);
 //BA.debugLineNum = 2315;BA.debugLine="Dim Values As List = Arrays.Get(ArrayName)";
_values = new anywheresoftware.b4a.objects.collections.List();
_values = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_arrays.Get((Object)(_arrayname))));
 //BA.debugLineNum = 2317;BA.debugLine="If ArrayIndex > Values.Size Then Return False";
if (_arrayindex>_values.getSize()) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2320;BA.debugLine="VariableName = ArrayName & \"(\" & ArrayIndex & \")";
_variablename = _arrayname+"("+BA.NumberToString(_arrayindex)+")";
 }else {
 //BA.debugLineNum = 2324;BA.debugLine="If IsValidVariable(VariableName) = False Then Re";
if (_isvalidvariable(_variablename)==__c.False) { 
if (true) return __c.False;};
 };
 //BA.debugLineNum = 2328;BA.debugLine="InputVariables.Add(VariableName)";
_inputvariables.Add((Object)(_variablename));
 //BA.debugLineNum = 2330;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 2332;BA.debugLine="End Sub";
return false;
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 14;BA.debugLine="Private mCallback As Object";
_mcallback = new Object();
 //BA.debugLineNum = 15;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 18;BA.debugLine="Private MAX_VAR_LENGTH As Int = 8";
_max_var_length = (int) (8);
 //BA.debugLineNum = 21;BA.debugLine="Private ProgramLines As Map";
_programlines = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 22;BA.debugLine="Private Variables As Map";
_variables = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 23;BA.debugLine="Private Arrays As Map";
_arrays = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 24;BA.debugLine="Private Functions As Map";
_functions = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 27;BA.debugLine="Private RunLines As List";
_runlines = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 28;BA.debugLine="Private RunPosition As Int";
_runposition = 0;
 //BA.debugLineNum = 31;BA.debugLine="Private WaitingForInput As Boolean";
_waitingforinput = false;
 //BA.debugLineNum = 32;BA.debugLine="Private InputVariables As List";
_inputvariables = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 33;BA.debugLine="Private InputPrompt As String";
_inputprompt = "";
 //BA.debugLineNum = 36;BA.debugLine="Private WaitingForDelay As Boolean";
_waitingfordelay = false;
 //BA.debugLineNum = 37;BA.debugLine="Private DelayMilliseconds As Int";
_delaymilliseconds = 0;
 //BA.debugLineNum = 40;BA.debugLine="Private WaitingForHardwareCommand As Boolean";
_waitingforhardwarecommand = false;
 //BA.debugLineNum = 43;BA.debugLine="Private ExprText As String";
_exprtext = "";
 //BA.debugLineNum = 44;BA.debugLine="Private ExprPos As Int";
_exprpos = 0;
 //BA.debugLineNum = 45;BA.debugLine="Private ExprError As Boolean";
_exprerror = false;
 //BA.debugLineNum = 48;BA.debugLine="Private ForStack As List";
_forstack = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 51;BA.debugLine="Private GosubStack As List";
_gosubstack = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 54;BA.debugLine="Private DataItems As List";
_dataitems = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 55;BA.debugLine="Private DataPosition As Int";
_dataposition = 0;
 //BA.debugLineNum = 56;BA.debugLine="Private DataErrorLine As Int";
_dataerrorline = 0;
 //BA.debugLineNum = 59;BA.debugLine="Private WaitingForExternalData As Boolean";
_waitingforexternaldata = false;
 //BA.debugLineNum = 60;BA.debugLine="Private ExternalDataTarget As String";
_externaldatatarget = "";
 //BA.debugLineNum = 61;BA.debugLine="Private ExternalDataTarget2 As String";
_externaldatatarget2 = "";
 //BA.debugLineNum = 62;BA.debugLine="Private ExternalDataTarget3 As String";
_externaldatatarget3 = "";
 //BA.debugLineNum = 65;BA.debugLine="Private TraceEnabled As Boolean";
_traceenabled = false;
 //BA.debugLineNum = 68;BA.debugLine="Private ErrorHandlerLine As Int";
_errorhandlerline = 0;
 //BA.debugLineNum = 69;BA.debugLine="Private ErrorHandlerEnabled As Boolean";
_errorhandlerenabled = false;
 //BA.debugLineNum = 70;BA.debugLine="Private ErrorHandlerRunning As Boolean";
_errorhandlerrunning = false;
 //BA.debugLineNum = 71;BA.debugLine="Private ErrorLinePosition As Int";
_errorlineposition = 0;
 //BA.debugLineNum = 72;BA.debugLine="Private ErrorNextPosition As Int";
_errornextposition = 0;
 //BA.debugLineNum = 73;BA.debugLine="Private ErrorCode As Int";
_errorcode = 0;
 //BA.debugLineNum = 74;BA.debugLine="Private ErrorLineNumber As Int";
_errorlinenumber = 0;
 //BA.debugLineNum = 75;BA.debugLine="Private ExprErrorCode As Int";
_exprerrorcode = 0;
 //BA.debugLineNum = 76;BA.debugLine="Private ReadErrorMessage As String";
_readerrormessage = "";
 //BA.debugLineNum = 77;BA.debugLine="Private ProgramErrorMessage As String";
_programerrormessage = "";
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return "";
}
public String  _cleanupforstack(int _targetposition) throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _loopdata = null;
int _nextposition = 0;
 //BA.debugLineNum = 2118;BA.debugLine="Private Sub CleanupForStack(TargetPosition As Int)";
 //BA.debugLineNum = 2120;BA.debugLine="For i = ForStack.Size - 1 To 0 Step -1";
{
final int step1 = -1;
final int limit1 = (int) (0);
_i = (int) (_forstack.getSize()-1) ;
for (;_i >= limit1 ;_i = _i + step1 ) {
 //BA.debugLineNum = 2122;BA.debugLine="Dim LoopData As Map = ForStack.Get(i)";
_loopdata = new anywheresoftware.b4a.objects.collections.Map();
_loopdata = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_forstack.Get(_i)));
 //BA.debugLineNum = 2123;BA.debugLine="Dim NextPosition As Int = LoopData.Get(\"NextPosi";
_nextposition = (int)(BA.ObjectToNumber(_loopdata.Get((Object)("NextPosition"))));
 //BA.debugLineNum = 2125;BA.debugLine="If TargetPosition > NextPosition Then";
if (_targetposition>_nextposition) { 
 //BA.debugLineNum = 2126;BA.debugLine="ForStack.RemoveAt(i)";
_forstack.RemoveAt(_i);
 };
 }
};
 //BA.debugLineNum = 2131;BA.debugLine="End Sub";
return "";
}
public String  _clearprogram() throws Exception{
 //BA.debugLineNum = 3176;BA.debugLine="Public Sub ClearProgram";
 //BA.debugLineNum = 3177;BA.debugLine="ProgramLines.Clear";
_programlines.Clear();
 //BA.debugLineNum = 3178;BA.debugLine="Variables.Clear";
_variables.Clear();
 //BA.debugLineNum = 3179;BA.debugLine="Arrays.Clear";
_arrays.Clear();
 //BA.debugLineNum = 3181;BA.debugLine="RunLines.Clear";
_runlines.Clear();
 //BA.debugLineNum = 3182;BA.debugLine="InputVariables.Clear";
_inputvariables.Clear();
 //BA.debugLineNum = 3183;BA.debugLine="ForStack.Clear";
_forstack.Clear();
 //BA.debugLineNum = 3184;BA.debugLine="GosubStack.Clear";
_gosubstack.Clear();
 //BA.debugLineNum = 3185;BA.debugLine="DataItems.Clear";
_dataitems.Clear();
 //BA.debugLineNum = 3187;BA.debugLine="RunPosition = 0";
_runposition = (int) (0);
 //BA.debugLineNum = 3188;BA.debugLine="DataPosition = 0";
_dataposition = (int) (0);
 //BA.debugLineNum = 3189;BA.debugLine="WaitingForInput = False";
_waitingforinput = __c.False;
 //BA.debugLineNum = 3191;BA.debugLine="ResetErrorHandler";
_reseterrorhandler();
 //BA.debugLineNum = 3192;BA.debugLine="End Sub";
return "";
}
public boolean  _collectdata() throws Exception{
int _linenumber = 0;
String _linecode = "";
String _upperline = "";
String _datatext = "";
boolean _inquotes = false;
anywheresoftware.b4a.keywords.StringBuilderWrapper _currentitem = null;
int _i = 0;
String _currentchar = "";
 //BA.debugLineNum = 669;BA.debugLine="Private Sub CollectData As Boolean";
 //BA.debugLineNum = 671;BA.debugLine="DataItems.Initialize";
_dataitems.Initialize();
 //BA.debugLineNum = 672;BA.debugLine="DataPosition = 0";
_dataposition = (int) (0);
 //BA.debugLineNum = 673;BA.debugLine="DataErrorLine = 0";
_dataerrorline = (int) (0);
 //BA.debugLineNum = 675;BA.debugLine="For Each LineNumber As Int In RunLines";
{
final anywheresoftware.b4a.BA.IterableList group4 = _runlines;
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_linenumber = (int)(BA.ObjectToNumber(group4.Get(index4)));
 //BA.debugLineNum = 677;BA.debugLine="Dim LineCode As String = ProgramLines.Get(LineNu";
_linecode = (BA.ObjectToString(_programlines.Get((Object)(_linenumber)))).trim();
 //BA.debugLineNum = 678;BA.debugLine="Dim UpperLine As String = LineCode.ToUpperCase";
_upperline = _linecode.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 680;BA.debugLine="If UpperLine = \"DATA\" Or UpperLine.StartsWith(\"D";
if ((_upperline).equals("DATA") || _upperline.startsWith("DATA ")) { 
 //BA.debugLineNum = 682;BA.debugLine="Dim DataText As String = LineCode.SubString(4).";
_datatext = _linecode.substring((int) (4)).trim();
 //BA.debugLineNum = 684;BA.debugLine="If DataText = \"\" Then Continue";
if ((_datatext).equals("")) { 
if (true) continue;};
 //BA.debugLineNum = 686;BA.debugLine="Dim InQuotes As Boolean = False";
_inquotes = __c.False;
 //BA.debugLineNum = 687;BA.debugLine="Dim CurrentItem As StringBuilder";
_currentitem = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 688;BA.debugLine="CurrentItem.Initialize";
_currentitem.Initialize();
 //BA.debugLineNum = 690;BA.debugLine="For i = 0 To DataText.Length - 1";
{
final int step13 = 1;
final int limit13 = (int) (_datatext.length()-1);
_i = (int) (0) ;
for (;_i <= limit13 ;_i = _i + step13 ) {
 //BA.debugLineNum = 692;BA.debugLine="Dim CurrentChar As String = DataText.CharAt(i)";
_currentchar = BA.ObjectToString(_datatext.charAt(_i));
 //BA.debugLineNum = 694;BA.debugLine="If CurrentChar = \"\"\"\" Then";
if ((_currentchar).equals("\"")) { 
 //BA.debugLineNum = 695;BA.debugLine="InQuotes = Not(InQuotes)";
_inquotes = __c.Not(_inquotes);
 //BA.debugLineNum = 696;BA.debugLine="CurrentItem.Append(CurrentChar)";
_currentitem.Append(_currentchar);
 }else if((_currentchar).equals(",") && _inquotes==__c.False) { 
 //BA.debugLineNum = 700;BA.debugLine="If CurrentItem.ToString.Trim = \"\" Then";
if ((_currentitem.ToString().trim()).equals("")) { 
 //BA.debugLineNum = 701;BA.debugLine="DataErrorLine = LineNumber";
_dataerrorline = _linenumber;
 //BA.debugLineNum = 702;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 705;BA.debugLine="DataItems.Add(CurrentItem.ToString.Trim)";
_dataitems.Add((Object)(_currentitem.ToString().trim()));
 //BA.debugLineNum = 706;BA.debugLine="CurrentItem.Initialize";
_currentitem.Initialize();
 }else {
 //BA.debugLineNum = 709;BA.debugLine="CurrentItem.Append(CurrentChar)";
_currentitem.Append(_currentchar);
 };
 }
};
 //BA.debugLineNum = 715;BA.debugLine="If InQuotes Then";
if (_inquotes) { 
 //BA.debugLineNum = 716;BA.debugLine="DataErrorLine = LineNumber";
_dataerrorline = _linenumber;
 //BA.debugLineNum = 717;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 721;BA.debugLine="If CurrentItem.ToString.Trim = \"\" Then";
if ((_currentitem.ToString().trim()).equals("")) { 
 //BA.debugLineNum = 722;BA.debugLine="DataErrorLine = LineNumber";
_dataerrorline = _linenumber;
 //BA.debugLineNum = 723;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 726;BA.debugLine="DataItems.Add(CurrentItem.ToString.Trim)";
_dataitems.Add((Object)(_currentitem.ToString().trim()));
 };
 }
};
 //BA.debugLineNum = 737;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 739;BA.debugLine="End Sub";
return false;
}
public String  _continueprogram() throws Exception{
int _linenumber = 0;
String _linecode = "";
String _upperline = "";
String _targettext = "";
double _targetvalue = 0;
int _targetline = 0;
int _thenpos = 0;
boolean _instring = false;
int _i = 0;
String _c = "";
String _condition = "";
boolean _conditionresult = false;
String _device = "";
String[] _parts = null;
 //BA.debugLineNum = 741;BA.debugLine="Private Sub ContinueProgram";
 //BA.debugLineNum = 743;BA.debugLine="Do While RunPosition < RunLines.Size";
while (_runposition<_runlines.getSize()) {
 //BA.debugLineNum = 745;BA.debugLine="Dim LineNumber As Int = RunLines.Get(RunPosition";
_linenumber = (int)(BA.ObjectToNumber(_runlines.Get(_runposition)));
 //BA.debugLineNum = 746;BA.debugLine="RunPosition = RunPosition + 1";
_runposition = (int) (_runposition+1);
 //BA.debugLineNum = 748;BA.debugLine="Dim LineCode As String = ProgramLines.Get(LineNu";
_linecode = BA.ObjectToString(_programlines.Get((Object)(_linenumber)));
 //BA.debugLineNum = 749;BA.debugLine="If TraceEnabled Then RaiseOutput(\"[TRACE] \" & Li";
if (_traceenabled) { 
_raiseoutput("[TRACE] "+BA.NumberToString(_linenumber));};
 //BA.debugLineNum = 751;BA.debugLine="Dim UpperLine As String = LineCode.ToUpperCase.T";
_upperline = _linecode.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale).trim();
 //BA.debugLineNum = 753;BA.debugLine="Select Case True";
switch (BA.switchObjectToInt(__c.True,(_upperline).equals("TRACE ON"),(_upperline).equals("TRACE OFF"),(_upperline).equals("END"),(_upperline).equals("REM") || _upperline.startsWith("REM "),(_upperline).equals("READ") || _upperline.startsWith("READ "),(_upperline).equals("RESTORE"),(_upperline).equals("DATA") || _upperline.startsWith("DATA "),(_upperline).equals("RANDOMIZE") || _upperline.startsWith("RANDOMIZE "),_upperline.startsWith("ON ERROR "),(_upperline).equals("RESUME") || (_upperline).equals("RESUME NEXT"),_upperline.startsWith("ON "),_upperline.startsWith("GOSUB "),_upperline.startsWith("GOTO "),_upperline.startsWith("IF "),(_upperline).equals("PRINT") || _upperline.startsWith("PRINT "),_upperline.startsWith("INPUT "),_upperline.startsWith("ASSIGN "),_upperline.startsWith("DIM "),(_upperline).equals("ERASE") || _upperline.startsWith("ERASE "),(_upperline).equals("SWAP") || _upperline.startsWith("SWAP "),_upperline.startsWith("LET "),_upperline.startsWith("DEF FN "),_upperline.startsWith("FOR "),(_upperline).equals("NEXT") || _upperline.startsWith("NEXT "),(_upperline).equals("RETURN"),_upperline.startsWith("@SYS"),_upperline.startsWith("@DELAY"),_upperline.startsWith("@SER"),_upperline.startsWith("@"))) {
case 0: {
 //BA.debugLineNum = 755;BA.debugLine="TraceEnabled = True";
_traceenabled = __c.True;
 break; }
case 1: {
 //BA.debugLineNum = 758;BA.debugLine="TraceEnabled = False";
_traceenabled = __c.False;
 break; }
case 2: {
 //BA.debugLineNum = 761;BA.debugLine="RunPosition = RunLines.Size";
_runposition = _runlines.getSize();
 break; }
case 3: {
 break; }
case 4: {
 //BA.debugLineNum = 768;BA.debugLine="If ExecuteRead(LineCode) = False Then";
if (_executeread(_linecode)==__c.False) { 
 //BA.debugLineNum = 770;BA.debugLine="If HandleProgramError(\"?\" & ReadErrorMessage";
if (_handleprogramerror("?"+_readerrormessage+" IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 //BA.debugLineNum = 772;BA.debugLine="Exit";
if (true) break;
 };
 break; }
case 5: {
 //BA.debugLineNum = 776;BA.debugLine="If ExecuteRestore(LineCode) = False Then";
if (_executerestore(_linecode)==__c.False) { 
 //BA.debugLineNum = 777;BA.debugLine="If HandleProgramError(\"?SYNTAX ERROR IN LINE";
if (_handleprogramerror("?SYNTAX ERROR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 //BA.debugLineNum = 778;BA.debugLine="Exit";
if (true) break;
 };
 break; }
case 6: {
 break; }
case 7: {
 //BA.debugLineNum = 787;BA.debugLine="If ExecuteRandomize(LineCode) = False Then";
if (_executerandomize(_linecode)==__c.False) { 
 //BA.debugLineNum = 789;BA.debugLine="If ExprError Then";
if (_exprerror) { 
 //BA.debugLineNum = 790;BA.debugLine="If ExprErrorCode = 11 Then";
if (_exprerrorcode==11) { 
 //BA.debugLineNum = 791;BA.debugLine="If HandleProgramError(\"?DIVISION BY ZERO IN";
if (_handleprogramerror("?DIVISION BY ZERO IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 }else {
 //BA.debugLineNum = 793;BA.debugLine="If HandleProgramError(\"?ILLEGAL EXPRESSION";
if (_handleprogramerror("?ILLEGAL EXPRESSION IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 };
 }else {
 //BA.debugLineNum = 796;BA.debugLine="If HandleProgramError(\"?SYNTAX ERROR IN LINE";
if (_handleprogramerror("?SYNTAX ERROR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 };
 //BA.debugLineNum = 799;BA.debugLine="Exit";
if (true) break;
 };
 break; }
case 8: {
 //BA.debugLineNum = 803;BA.debugLine="If ExecuteOnError(LineCode) = False Then";
if (_executeonerror(_linecode)==__c.False) { 
 //BA.debugLineNum = 804;BA.debugLine="If HandleProgramError(\"?SYNTAX ERROR IN LINE";
if (_handleprogramerror("?SYNTAX ERROR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 //BA.debugLineNum = 805;BA.debugLine="Exit";
if (true) break;
 };
 break; }
case 9: {
 //BA.debugLineNum = 809;BA.debugLine="If ExecuteResume(LineCode) = False Then";
if (_executeresume(_linecode)==__c.False) { 
 //BA.debugLineNum = 810;BA.debugLine="If HandleProgramError(\"?RESUME WITHOUT ERROR";
if (_handleprogramerror("?RESUME WITHOUT ERROR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 //BA.debugLineNum = 811;BA.debugLine="Exit";
if (true) break;
 };
 break; }
case 10: {
 //BA.debugLineNum = 815;BA.debugLine="If ExecuteOn(LineCode) = False Then";
if (_executeon(_linecode)==__c.False) { 
 //BA.debugLineNum = 817;BA.debugLine="If ProgramErrorMessage <> \"\" Then";
if ((_programerrormessage).equals("") == false) { 
 //BA.debugLineNum = 818;BA.debugLine="If HandleProgramError(ProgramErrorMessage) T";
if (_handleprogramerror(_programerrormessage)) { 
if (true) continue;};
 }else if(_exprerror) { 
 //BA.debugLineNum = 820;BA.debugLine="If ExprErrorCode = 11 Then";
if (_exprerrorcode==11) { 
 //BA.debugLineNum = 821;BA.debugLine="If HandleProgramError(\"?DIVISION BY ZERO IN";
if (_handleprogramerror("?DIVISION BY ZERO IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 }else {
 //BA.debugLineNum = 823;BA.debugLine="If HandleProgramError(\"?ILLEGAL EXPRESSION";
if (_handleprogramerror("?ILLEGAL EXPRESSION IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 };
 }else {
 //BA.debugLineNum = 826;BA.debugLine="If HandleProgramError(\"?SYNTAX ERROR IN LINE";
if (_handleprogramerror("?SYNTAX ERROR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 };
 //BA.debugLineNum = 829;BA.debugLine="Exit";
if (true) break;
 };
 break; }
case 11: {
 //BA.debugLineNum = 833;BA.debugLine="Dim TargetText As String = LineCode.SubString(";
_targettext = _linecode.substring((int) (6)).trim();
 //BA.debugLineNum = 835;BA.debugLine="If IsNumber(TargetText) = False Then";
if (__c.IsNumber(_targettext)==__c.False) { 
 //BA.debugLineNum = 836;BA.debugLine="If HandleProgramError(\"?SYNTAX ERROR IN LINE";
if (_handleprogramerror("?SYNTAX ERROR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 //BA.debugLineNum = 837;BA.debugLine="Exit";
if (true) break;
 };
 //BA.debugLineNum = 840;BA.debugLine="Dim TargetValue As Double = TargetText";
_targetvalue = (double)(Double.parseDouble(_targettext));
 //BA.debugLineNum = 842;BA.debugLine="If TargetValue < 0 Or TargetValue <> Floor(Tar";
if (_targetvalue<0 || _targetvalue!=__c.Floor(_targetvalue)) { 
 //BA.debugLineNum = 843;BA.debugLine="If HandleProgramError(\"?SYNTAX ERROR IN LINE";
if (_handleprogramerror("?SYNTAX ERROR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 //BA.debugLineNum = 844;BA.debugLine="Exit";
if (true) break;
 };
 //BA.debugLineNum = 847;BA.debugLine="Dim TargetLine As Int = TargetValue";
_targetline = (int) (_targetvalue);
 //BA.debugLineNum = 849;BA.debugLine="GosubStack.Add(RunPosition)";
_gosubstack.Add((Object)(_runposition));
 //BA.debugLineNum = 851;BA.debugLine="If JumpToLine(TargetLine) = False Then";
if (_jumptoline(_targetline)==__c.False) { 
 //BA.debugLineNum = 852;BA.debugLine="GosubStack.RemoveAt(GosubStack.Size - 1)";
_gosubstack.RemoveAt((int) (_gosubstack.getSize()-1));
 //BA.debugLineNum = 854;BA.debugLine="If HandleProgramError(\"?UNDEFINED LINE \" & Ta";
if (_handleprogramerror("?UNDEFINED LINE "+BA.NumberToString(_targetline))) { 
if (true) continue;};
 //BA.debugLineNum = 855;BA.debugLine="Exit";
if (true) break;
 };
 break; }
case 12: {
 //BA.debugLineNum = 859;BA.debugLine="Dim TargetText As String = LineCode.SubString(";
_targettext = _linecode.substring((int) (5)).trim();
 //BA.debugLineNum = 861;BA.debugLine="If IsNumber(TargetText) = False Then";
if (__c.IsNumber(_targettext)==__c.False) { 
 //BA.debugLineNum = 862;BA.debugLine="If HandleProgramError(\"?SYNTAX ERROR IN LINE";
if (_handleprogramerror("?SYNTAX ERROR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 //BA.debugLineNum = 863;BA.debugLine="Exit";
if (true) break;
 };
 //BA.debugLineNum = 866;BA.debugLine="Dim TargetValue As Double = TargetText";
_targetvalue = (double)(Double.parseDouble(_targettext));
 //BA.debugLineNum = 868;BA.debugLine="If TargetValue < 0 Or TargetValue <> Floor(Tar";
if (_targetvalue<0 || _targetvalue!=__c.Floor(_targetvalue)) { 
 //BA.debugLineNum = 869;BA.debugLine="If HandleProgramError(\"?SYNTAX ERROR IN LINE";
if (_handleprogramerror("?SYNTAX ERROR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 //BA.debugLineNum = 870;BA.debugLine="Exit";
if (true) break;
 };
 //BA.debugLineNum = 873;BA.debugLine="Dim TargetLine As Int = TargetValue";
_targetline = (int) (_targetvalue);
 //BA.debugLineNum = 875;BA.debugLine="If JumpToLine(TargetLine) = False Then";
if (_jumptoline(_targetline)==__c.False) { 
 //BA.debugLineNum = 876;BA.debugLine="If HandleProgramError(\"?UNDEFINED LINE \" & Ta";
if (_handleprogramerror("?UNDEFINED LINE "+BA.NumberToString(_targetline))) { 
if (true) continue;};
 //BA.debugLineNum = 877;BA.debugLine="Exit";
if (true) break;
 };
 //BA.debugLineNum = 880;BA.debugLine="CleanupForStack(RunPosition)";
_cleanupforstack(_runposition);
 break; }
case 13: {
 //BA.debugLineNum = 883;BA.debugLine="Dim ThenPos As Int = -1";
_thenpos = (int) (-1);
 //BA.debugLineNum = 884;BA.debugLine="Dim InString As Boolean = False";
_instring = __c.False;
 //BA.debugLineNum = 887;BA.debugLine="For i = 0 To UpperLine.Length - 5";
{
final int step102 = 1;
final int limit102 = (int) (_upperline.length()-5);
_i = (int) (0) ;
for (;_i <= limit102 ;_i = _i + step102 ) {
 //BA.debugLineNum = 889;BA.debugLine="Dim c As String = UpperLine.SubString2(i, i +";
_c = _upperline.substring(_i,(int) (_i+1));
 //BA.debugLineNum = 891;BA.debugLine="If c = Chr(34) Then";
if ((_c).equals(BA.ObjectToString(__c.Chr((int) (34))))) { 
 //BA.debugLineNum = 892;BA.debugLine="InString = Not(InString)";
_instring = __c.Not(_instring);
 //BA.debugLineNum = 893;BA.debugLine="Continue";
if (true) continue;
 };
 //BA.debugLineNum = 896;BA.debugLine="If InString Then Continue";
if (_instring) { 
if (true) continue;};
 //BA.debugLineNum = 898;BA.debugLine="If UpperLine.SubString2(i, i + 5) = \"THEN \" T";
if ((_upperline.substring(_i,(int) (_i+5))).equals("THEN ")) { 
 //BA.debugLineNum = 899;BA.debugLine="ThenPos = i";
_thenpos = _i;
 //BA.debugLineNum = 900;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 905;BA.debugLine="If ThenPos < 0 Then";
if (_thenpos<0) { 
 //BA.debugLineNum = 906;BA.debugLine="If HandleProgramError(\"?SYNTAX ERROR IN LINE";
if (_handleprogramerror("?SYNTAX ERROR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 //BA.debugLineNum = 907;BA.debugLine="Exit";
if (true) break;
 };
 //BA.debugLineNum = 910;BA.debugLine="Dim Condition As String = LineCode.SubString2(";
_condition = _linecode.substring((int) (3),_thenpos).trim();
 //BA.debugLineNum = 911;BA.debugLine="Dim TargetText As String = LineCode.SubString(";
_targettext = _linecode.substring((int) (_thenpos+4)).trim();
 //BA.debugLineNum = 913;BA.debugLine="If IsNumber(TargetText) = False Then";
if (__c.IsNumber(_targettext)==__c.False) { 
 //BA.debugLineNum = 914;BA.debugLine="If HandleProgramError(\"?SYNTAX ERROR IN LINE";
if (_handleprogramerror("?SYNTAX ERROR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 //BA.debugLineNum = 915;BA.debugLine="Exit";
if (true) break;
 };
 //BA.debugLineNum = 918;BA.debugLine="Dim TargetValue As Double = TargetText";
_targetvalue = (double)(Double.parseDouble(_targettext));
 //BA.debugLineNum = 920;BA.debugLine="If TargetValue < 0 Or TargetValue <> Floor(Tar";
if (_targetvalue<0 || _targetvalue!=__c.Floor(_targetvalue)) { 
 //BA.debugLineNum = 921;BA.debugLine="If HandleProgramError(\"?SYNTAX ERROR IN LINE";
if (_handleprogramerror("?SYNTAX ERROR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 //BA.debugLineNum = 922;BA.debugLine="Exit";
if (true) break;
 };
 //BA.debugLineNum = 925;BA.debugLine="Dim ConditionResult As Boolean = EvaluateCondi";
_conditionresult = _evaluatecondition(_condition);
 //BA.debugLineNum = 927;BA.debugLine="If ExprError Then";
if (_exprerror) { 
 //BA.debugLineNum = 928;BA.debugLine="If ExprErrorCode = 11 Then";
if (_exprerrorcode==11) { 
 //BA.debugLineNum = 929;BA.debugLine="If HandleProgramError(\"?DIVISION BY ZERO IN";
if (_handleprogramerror("?DIVISION BY ZERO IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 }else {
 //BA.debugLineNum = 931;BA.debugLine="If HandleProgramError(\"?ILLEGAL EXPRESSION I";
if (_handleprogramerror("?ILLEGAL EXPRESSION IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 };
 //BA.debugLineNum = 933;BA.debugLine="Exit";
if (true) break;
 };
 //BA.debugLineNum = 936;BA.debugLine="If ConditionResult Then";
if (_conditionresult) { 
 //BA.debugLineNum = 937;BA.debugLine="Dim TargetLine As Int = TargetValue";
_targetline = (int) (_targetvalue);
 //BA.debugLineNum = 939;BA.debugLine="If JumpToLine(TargetLine) = False Then";
if (_jumptoline(_targetline)==__c.False) { 
 //BA.debugLineNum = 940;BA.debugLine="If HandleProgramError(\"?UNDEFINED LINE \" & T";
if (_handleprogramerror("?UNDEFINED LINE "+BA.NumberToString(_targetline))) { 
if (true) continue;};
 //BA.debugLineNum = 941;BA.debugLine="Exit";
if (true) break;
 };
 //BA.debugLineNum = 944;BA.debugLine="CleanupForStack(RunPosition)";
_cleanupforstack(_runposition);
 };
 break; }
case 14: {
 //BA.debugLineNum = 948;BA.debugLine="If PrintBasicText(LineCode) = False Then";
if (_printbasictext(_linecode)==__c.False) { 
 //BA.debugLineNum = 949;BA.debugLine="If ExprErrorCode = 11 Then";
if (_exprerrorcode==11) { 
 //BA.debugLineNum = 950;BA.debugLine="If HandleProgramError(\"?DIVISION BY ZERO IN";
if (_handleprogramerror("?DIVISION BY ZERO IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 }else {
 //BA.debugLineNum = 952;BA.debugLine="If HandleProgramError(\"?ILLEGAL EXPRESSION I";
if (_handleprogramerror("?ILLEGAL EXPRESSION IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 };
 //BA.debugLineNum = 954;BA.debugLine="Exit";
if (true) break;
 };
 break; }
case 15: {
 //BA.debugLineNum = 958;BA.debugLine="If ExecuteInput(LineCode) = False Then";
if (_executeinput(_linecode)==__c.False) { 
 //BA.debugLineNum = 959;BA.debugLine="If HandleProgramError(\"?SYNTAX ERROR IN LINE";
if (_handleprogramerror("?SYNTAX ERROR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 //BA.debugLineNum = 960;BA.debugLine="Exit";
if (true) break;
 };
 //BA.debugLineNum = 962;BA.debugLine="WaitingForInput = True";
_waitingforinput = __c.True;
 //BA.debugLineNum = 963;BA.debugLine="Return";
if (true) return "";
 break; }
case 16: {
 //BA.debugLineNum = 966;BA.debugLine="If ExecuteAssign(LineCode) = False Then";
if (_executeassign(_linecode)==__c.False) { 
 //BA.debugLineNum = 967;BA.debugLine="If HandleProgramError(\"?SYNTAX ERROR IN LINE";
if (_handleprogramerror("?SYNTAX ERROR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 //BA.debugLineNum = 968;BA.debugLine="Exit";
if (true) break;
 };
 //BA.debugLineNum = 970;BA.debugLine="Return";
if (true) return "";
 break; }
case 17: {
 //BA.debugLineNum = 973;BA.debugLine="If ExecuteDim(LineCode) = False Then";
if (_executedim(_linecode)==__c.False) { 
 //BA.debugLineNum = 974;BA.debugLine="If HandleProgramError(\"?SYNTAX ERROR IN LINE";
if (_handleprogramerror("?SYNTAX ERROR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 //BA.debugLineNum = 975;BA.debugLine="Exit";
if (true) break;
 };
 break; }
case 18: {
 //BA.debugLineNum = 979;BA.debugLine="If ExecuteErase(LineCode) = False Then";
if (_executeerase(_linecode)==__c.False) { 
 //BA.debugLineNum = 980;BA.debugLine="If HandleProgramError(\"?SYNTAX ERROR IN LINE";
if (_handleprogramerror("?SYNTAX ERROR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 //BA.debugLineNum = 981;BA.debugLine="Exit";
if (true) break;
 };
 break; }
case 19: {
 //BA.debugLineNum = 985;BA.debugLine="If ExecuteSwap(LineCode) = False Then";
if (_executeswap(_linecode)==__c.False) { 
 //BA.debugLineNum = 986;BA.debugLine="If HandleProgramError(\"?SYNTAX ERROR IN LINE";
if (_handleprogramerror("?SYNTAX ERROR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 //BA.debugLineNum = 987;BA.debugLine="Exit";
if (true) break;
 };
 break; }
case 20: {
 //BA.debugLineNum = 991;BA.debugLine="If ExecuteLet(LineCode) = False Then";
if (_executelet(_linecode)==__c.False) { 
 //BA.debugLineNum = 993;BA.debugLine="If ExprError Then";
if (_exprerror) { 
 //BA.debugLineNum = 994;BA.debugLine="If ExprErrorCode = 11 Then";
if (_exprerrorcode==11) { 
 //BA.debugLineNum = 995;BA.debugLine="If HandleProgramError(\"?DIVISION BY ZERO IN";
if (_handleprogramerror("?DIVISION BY ZERO IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 }else {
 //BA.debugLineNum = 997;BA.debugLine="If HandleProgramError(\"?ILLEGAL EXPRESSION";
if (_handleprogramerror("?ILLEGAL EXPRESSION IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 };
 }else {
 //BA.debugLineNum = 1000;BA.debugLine="If HandleProgramError(\"?SYNTAX ERROR IN LINE";
if (_handleprogramerror("?SYNTAX ERROR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 };
 //BA.debugLineNum = 1002;BA.debugLine="Exit";
if (true) break;
 };
 break; }
case 21: {
 //BA.debugLineNum = 1006;BA.debugLine="If ExecuteDefFn(LineCode) = False Then";
if (_executedeffn(_linecode)==__c.False) { 
 //BA.debugLineNum = 1007;BA.debugLine="If HandleProgramError(\"?SYNTAX ERROR IN LINE";
if (_handleprogramerror("?SYNTAX ERROR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 //BA.debugLineNum = 1008;BA.debugLine="Exit";
if (true) break;
 };
 break; }
case 22: {
 //BA.debugLineNum = 1012;BA.debugLine="If ExecuteFor(LineCode, RunPosition) = False T";
if (_executefor(_linecode,_runposition)==__c.False) { 
 //BA.debugLineNum = 1014;BA.debugLine="If ExprError Then";
if (_exprerror) { 
 //BA.debugLineNum = 1015;BA.debugLine="If ExprErrorCode = 11 Then";
if (_exprerrorcode==11) { 
 //BA.debugLineNum = 1016;BA.debugLine="If HandleProgramError(\"?DIVISION BY ZERO IN";
if (_handleprogramerror("?DIVISION BY ZERO IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 }else {
 //BA.debugLineNum = 1018;BA.debugLine="If HandleProgramError(\"?ILLEGAL EXPRESSION";
if (_handleprogramerror("?ILLEGAL EXPRESSION IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 };
 }else {
 //BA.debugLineNum = 1021;BA.debugLine="If HandleProgramError(\"?SYNTAX ERROR IN LINE";
if (_handleprogramerror("?SYNTAX ERROR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 };
 //BA.debugLineNum = 1024;BA.debugLine="Exit";
if (true) break;
 };
 break; }
case 23: {
 //BA.debugLineNum = 1028;BA.debugLine="If ExecuteNext(LineCode) = False Then";
if (_executenext(_linecode)==__c.False) { 
 //BA.debugLineNum = 1029;BA.debugLine="If HandleProgramError(\"?NEXT WITHOUT FOR IN L";
if (_handleprogramerror("?NEXT WITHOUT FOR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 //BA.debugLineNum = 1030;BA.debugLine="Exit";
if (true) break;
 };
 break; }
case 24: {
 //BA.debugLineNum = 1034;BA.debugLine="If GosubStack.Size = 0 Then";
if (_gosubstack.getSize()==0) { 
 //BA.debugLineNum = 1035;BA.debugLine="If HandleProgramError(\"?RETURN WITHOUT GOSUB";
if (_handleprogramerror("?RETURN WITHOUT GOSUB IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 //BA.debugLineNum = 1036;BA.debugLine="Exit";
if (true) break;
 };
 //BA.debugLineNum = 1039;BA.debugLine="RunPosition = GosubStack.Get(GosubStack.Size -";
_runposition = (int)(BA.ObjectToNumber(_gosubstack.Get((int) (_gosubstack.getSize()-1))));
 //BA.debugLineNum = 1040;BA.debugLine="GosubStack.RemoveAt(GosubStack.Size - 1)";
_gosubstack.RemoveAt((int) (_gosubstack.getSize()-1));
 break; }
case 25: {
 //BA.debugLineNum = 1045;BA.debugLine="RaiseSystemCommand(LineCode)";
_raisesystemcommand(_linecode);
 //BA.debugLineNum = 1046;BA.debugLine="Continue";
if (true) continue;
 break; }
case 26: {
 //BA.debugLineNum = 1051;BA.debugLine="If ExecuteDelay(LineCode) = False Then";
if (_executedelay(_linecode)==__c.False) { 
 //BA.debugLineNum = 1052;BA.debugLine="If HandleProgramError(\"?SYNTAX ERROR IN LINE";
if (_handleprogramerror("?SYNTAX ERROR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 //BA.debugLineNum = 1053;BA.debugLine="Exit";
if (true) break;
 };
 //BA.debugLineNum = 1056;BA.debugLine="WaitingForDelay = True";
_waitingfordelay = __c.True;
 //BA.debugLineNum = 1057;BA.debugLine="Utils.CallSubMethod(mCallback, mEventName, \"_W";
_utils._callsubmethod /*String*/ (_mcallback,_meventname,"_WaitingForDelay");
 //BA.debugLineNum = 1058;BA.debugLine="Return";
if (true) return "";
 break; }
case 27: {
 //BA.debugLineNum = 1063;BA.debugLine="Dim Device As String = \"\"";
_device = "";
 //BA.debugLineNum = 1065;BA.debugLine="Dim Parts() As String = Regex.Split(\" \", LineC";
_parts = __c.Regex.Split(" ",_linecode.trim());
 //BA.debugLineNum = 1067;BA.debugLine="If Parts.Length >= 2 Then Device = Parts(1).To";
if (_parts.length>=2) { 
_device = _parts[(int) (1)].toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);};
 //BA.debugLineNum = 1069;BA.debugLine="If Device = \"CONNECT\" Or _ 					Device = \"DISC";
if ((_device).equals("CONNECT") || (_device).equals("DISCONNECT") || (_device).equals("LISTPORTS")) { 
 //BA.debugLineNum = 1072;BA.debugLine="WaitingForHardwareCommand = True";
_waitingforhardwarecommand = __c.True;
 //BA.debugLineNum = 1073;BA.debugLine="RaiseHardwareCommand(LineCode)";
_raisehardwarecommand(_linecode);
 //BA.debugLineNum = 1074;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 1077;BA.debugLine="If PrepareSerialCommand(LineCode) = False Then";
if (_prepareserialcommand(_linecode)==__c.False) { 
 //BA.debugLineNum = 1078;BA.debugLine="If HandleProgramError(\"?ILLEGAL EXPRESSION IN";
if (_handleprogramerror("?ILLEGAL EXPRESSION IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 //BA.debugLineNum = 1079;BA.debugLine="Exit";
if (true) break;
 };
 //BA.debugLineNum = 1082;BA.debugLine="WaitingForHardwareCommand = True";
_waitingforhardwarecommand = __c.True;
 //BA.debugLineNum = 1083;BA.debugLine="Return";
if (true) return "";
 break; }
case 28: {
 //BA.debugLineNum = 1087;BA.debugLine="If HandleProgramError(\"?SYNTAX ERROR IN LINE \"";
if (_handleprogramerror("?SYNTAX ERROR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 //BA.debugLineNum = 1088;BA.debugLine="Exit";
if (true) break;
 break; }
default: {
 //BA.debugLineNum = 1091;BA.debugLine="If HandleProgramError(\"?SYNTAX ERROR IN LINE \"";
if (_handleprogramerror("?SYNTAX ERROR IN LINE "+BA.NumberToString(_linenumber))) { 
if (true) continue;};
 //BA.debugLineNum = 1092;BA.debugLine="Exit";
if (true) break;
 break; }
}
;
 }
;
 //BA.debugLineNum = 1098;BA.debugLine="WaitingForInput = False";
_waitingforinput = __c.False;
 //BA.debugLineNum = 1099;BA.debugLine="RaiseOutput(\"\")";
_raiseoutput("");
 //BA.debugLineNum = 1100;BA.debugLine="RaiseOutput(\"READY.\")";
_raiseoutput("READY.");
 //BA.debugLineNum = 1101;BA.debugLine="RaiseReady";
_raiseready();
 //BA.debugLineNum = 1102;BA.debugLine="End Sub";
return "";
}
public boolean  _evaluatecondition(String _condition) throws Exception{
String _operatorfound = "";
int _operatorpos = 0;
boolean _instring = false;
int _i = 0;
String _c = "";
String _twochars = "";
String _leftexpression = "";
String _rightexpression = "";
String _leftvalue = "";
String _rightvalue = "";
double _a = 0;
double _b = 0;
 //BA.debugLineNum = 1234;BA.debugLine="Private Sub EvaluateCondition(Condition As String)";
 //BA.debugLineNum = 1235;BA.debugLine="ExprError = False";
_exprerror = __c.False;
 //BA.debugLineNum = 1236;BA.debugLine="ExprErrorCode = 0";
_exprerrorcode = (int) (0);
 //BA.debugLineNum = 1238;BA.debugLine="Dim OperatorFound As String = \"\"";
_operatorfound = "";
 //BA.debugLineNum = 1239;BA.debugLine="Dim OperatorPos As Int = -1";
_operatorpos = (int) (-1);
 //BA.debugLineNum = 1240;BA.debugLine="Dim InString As Boolean = False";
_instring = __c.False;
 //BA.debugLineNum = 1243;BA.debugLine="For i = 0 To Condition.Length - 1";
{
final int step6 = 1;
final int limit6 = (int) (_condition.length()-1);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
 //BA.debugLineNum = 1244;BA.debugLine="Dim c As String = Condition.SubString2(i, i + 1)";
_c = _condition.substring(_i,(int) (_i+1));
 //BA.debugLineNum = 1246;BA.debugLine="If c = Chr(34) Then";
if ((_c).equals(BA.ObjectToString(__c.Chr((int) (34))))) { 
 //BA.debugLineNum = 1247;BA.debugLine="InString = Not(InString)";
_instring = __c.Not(_instring);
 //BA.debugLineNum = 1248;BA.debugLine="Continue";
if (true) continue;
 };
 //BA.debugLineNum = 1251;BA.debugLine="If InString Then Continue";
if (_instring) { 
if (true) continue;};
 //BA.debugLineNum = 1253;BA.debugLine="If i < Condition.Length - 1 Then";
if (_i<_condition.length()-1) { 
 //BA.debugLineNum = 1254;BA.debugLine="Dim TwoChars As String = Condition.SubString2(i";
_twochars = _condition.substring(_i,(int) (_i+2));
 //BA.debugLineNum = 1256;BA.debugLine="If TwoChars = \"<=\" Or TwoChars = \">=\" Or TwoCha";
if ((_twochars).equals("<=") || (_twochars).equals(">=") || (_twochars).equals("<>")) { 
 //BA.debugLineNum = 1257;BA.debugLine="OperatorFound = TwoChars";
_operatorfound = _twochars;
 //BA.debugLineNum = 1258;BA.debugLine="OperatorPos = i";
_operatorpos = _i;
 //BA.debugLineNum = 1259;BA.debugLine="Exit";
if (true) break;
 };
 };
 //BA.debugLineNum = 1263;BA.debugLine="If c = \"=\" Or c = \"<\" Or c = \">\" Then";
if ((_c).equals("=") || (_c).equals("<") || (_c).equals(">")) { 
 //BA.debugLineNum = 1264;BA.debugLine="OperatorFound = c";
_operatorfound = _c;
 //BA.debugLineNum = 1265;BA.debugLine="OperatorPos = i";
_operatorpos = _i;
 //BA.debugLineNum = 1266;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 1270;BA.debugLine="If OperatorPos < 0 Then";
if (_operatorpos<0) { 
 //BA.debugLineNum = 1271;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1272;BA.debugLine="ExprErrorCode = 20";
_exprerrorcode = (int) (20);
 //BA.debugLineNum = 1273;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 1276;BA.debugLine="Dim LeftExpression As String = Condition.SubStrin";
_leftexpression = _condition.substring((int) (0),_operatorpos).trim();
 //BA.debugLineNum = 1277;BA.debugLine="Dim RightExpression As String = Condition.SubStri";
_rightexpression = _condition.substring((int) (_operatorpos+_operatorfound.length())).trim();
 //BA.debugLineNum = 1279;BA.debugLine="If LeftExpression = \"\" Or RightExpression = \"\" Th";
if ((_leftexpression).equals("") || (_rightexpression).equals("")) { 
 //BA.debugLineNum = 1280;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1281;BA.debugLine="ExprErrorCode = 20";
_exprerrorcode = (int) (20);
 //BA.debugLineNum = 1282;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 1286;BA.debugLine="If IsStringExpression(LeftExpression) Or IsString";
if (_isstringexpression(_leftexpression) || _isstringexpression(_rightexpression)) { 
 //BA.debugLineNum = 1287;BA.debugLine="Dim LeftValue As String = EvaluateStringExpressi";
_leftvalue = _evaluatestringexpression(_leftexpression);
 //BA.debugLineNum = 1289;BA.debugLine="If ExprError Then Return False";
if (_exprerror) { 
if (true) return __c.False;};
 //BA.debugLineNum = 1291;BA.debugLine="Dim RightValue As String = EvaluateStringExpress";
_rightvalue = _evaluatestringexpression(_rightexpression);
 //BA.debugLineNum = 1293;BA.debugLine="If ExprError Then Return False";
if (_exprerror) { 
if (true) return __c.False;};
 //BA.debugLineNum = 1295;BA.debugLine="Select Case OperatorFound";
switch (BA.switchObjectToInt(_operatorfound,"=","<>")) {
case 0: {
 //BA.debugLineNum = 1297;BA.debugLine="Return LeftValue = RightValue";
if (true) return (_leftvalue).equals(_rightvalue);
 break; }
case 1: {
 //BA.debugLineNum = 1299;BA.debugLine="Return LeftValue <> RightValue";
if (true) return (_leftvalue).equals(_rightvalue) == false;
 break; }
default: {
 //BA.debugLineNum = 1301;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1302;BA.debugLine="ExprErrorCode = 20";
_exprerrorcode = (int) (20);
 //BA.debugLineNum = 1303;BA.debugLine="Return False";
if (true) return __c.False;
 break; }
}
;
 };
 //BA.debugLineNum = 1308;BA.debugLine="Dim A As Double = EvaluateNumericExpression(LeftE";
_a = _evaluatenumericexpression(_leftexpression);
 //BA.debugLineNum = 1310;BA.debugLine="If ExprError Then Return False";
if (_exprerror) { 
if (true) return __c.False;};
 //BA.debugLineNum = 1312;BA.debugLine="Dim B As Double = EvaluateNumericExpression(Right";
_b = _evaluatenumericexpression(_rightexpression);
 //BA.debugLineNum = 1314;BA.debugLine="If ExprError Then Return False";
if (_exprerror) { 
if (true) return __c.False;};
 //BA.debugLineNum = 1316;BA.debugLine="Select Case OperatorFound";
switch (BA.switchObjectToInt(_operatorfound,"=","<>","<",">","<=",">=")) {
case 0: {
 //BA.debugLineNum = 1318;BA.debugLine="Return A = B";
if (true) return _a==_b;
 break; }
case 1: {
 //BA.debugLineNum = 1320;BA.debugLine="Return A <> B";
if (true) return _a!=_b;
 break; }
case 2: {
 //BA.debugLineNum = 1322;BA.debugLine="Return A < B";
if (true) return _a<_b;
 break; }
case 3: {
 //BA.debugLineNum = 1324;BA.debugLine="Return A > B";
if (true) return _a>_b;
 break; }
case 4: {
 //BA.debugLineNum = 1326;BA.debugLine="Return A <= B";
if (true) return _a<=_b;
 break; }
case 5: {
 //BA.debugLineNum = 1328;BA.debugLine="Return A >= B";
if (true) return _a>=_b;
 break; }
}
;
 //BA.debugLineNum = 1331;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1332;BA.debugLine="ExprErrorCode = 20";
_exprerrorcode = (int) (20);
 //BA.debugLineNum = 1333;BA.debugLine="Return False";
if (true) return __c.False;
 //BA.debugLineNum = 1334;BA.debugLine="End Sub";
return false;
}
public double  _evaluatenumericexpression(String _expression) throws Exception{
double _result = 0;
 //BA.debugLineNum = 1931;BA.debugLine="Private Sub EvaluateNumericExpression(Expression A";
 //BA.debugLineNum = 1932;BA.debugLine="ExprText = Expression";
_exprtext = _expression;
 //BA.debugLineNum = 1933;BA.debugLine="ExprPos = 0";
_exprpos = (int) (0);
 //BA.debugLineNum = 1934;BA.debugLine="ExprError = False";
_exprerror = __c.False;
 //BA.debugLineNum = 1935;BA.debugLine="ExprErrorCode = 0";
_exprerrorcode = (int) (0);
 //BA.debugLineNum = 1937;BA.debugLine="Dim Result As Double = ParseExpression";
_result = _parseexpression();
 //BA.debugLineNum = 1939;BA.debugLine="SkipSpaces";
_skipspaces();
 //BA.debugLineNum = 1941;BA.debugLine="If ExprPos <> ExprText.Length Then ExprError = Tr";
if (_exprpos!=_exprtext.length()) { 
_exprerror = __c.True;};
 //BA.debugLineNum = 1944;BA.debugLine="If ExprError And ExprErrorCode = 0 Then";
if (_exprerror && _exprerrorcode==0) { 
 //BA.debugLineNum = 1945;BA.debugLine="ExprErrorCode = 20";
_exprerrorcode = (int) (20);
 };
 //BA.debugLineNum = 1948;BA.debugLine="Return Result";
if (true) return _result;
 //BA.debugLineNum = 1949;BA.debugLine="End Sub";
return 0;
}
public String  _evaluateprintitem(String _item) throws Exception{
String _stringresult = "";
double _numericresult = 0;
 //BA.debugLineNum = 1216;BA.debugLine="Private Sub EvaluatePrintItem(Item As String) As S";
 //BA.debugLineNum = 1217;BA.debugLine="ExprError = False";
_exprerror = __c.False;
 //BA.debugLineNum = 1218;BA.debugLine="ExprErrorCode = 0";
_exprerrorcode = (int) (0);
 //BA.debugLineNum = 1220;BA.debugLine="If Item = \"\" Then Return \"\"";
if ((_item).equals("")) { 
if (true) return "";};
 //BA.debugLineNum = 1222;BA.debugLine="If IsStringExpressionForPrint(Item) Then";
if (_isstringexpressionforprint(_item)) { 
 //BA.debugLineNum = 1223;BA.debugLine="Dim StringResult As String = EvaluateStringExpre";
_stringresult = _evaluatestringexpression(_item);
 //BA.debugLineNum = 1224;BA.debugLine="If ExprError Then Return \"?ILLEGAL STRING EXPRES";
if (_exprerror) { 
if (true) return "?ILLEGAL STRING EXPRESSION";};
 //BA.debugLineNum = 1225;BA.debugLine="Return StringResult";
if (true) return _stringresult;
 };
 //BA.debugLineNum = 1228;BA.debugLine="Dim NumericResult As Double = EvaluateNumericExpr";
_numericresult = _evaluatenumericexpression(_item);
 //BA.debugLineNum = 1229;BA.debugLine="If ExprError Then Return \"?ILLEGAL EXPRESSION\"";
if (_exprerror) { 
if (true) return "?ILLEGAL EXPRESSION";};
 //BA.debugLineNum = 1230;BA.debugLine="Return Utils.FormatNumber(NumericResult)";
if (true) return _utils._formatnumber /*String*/ (_numericresult);
 //BA.debugLineNum = 1231;BA.debugLine="End Sub";
return "";
}
public String  _evaluatestringexpression(String _expression) throws Exception{
anywheresoftware.b4a.objects.collections.List _parts = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _currentpart = null;
boolean _inquotes = false;
int _bracketlevel = 0;
boolean _hasconcatenation = false;
int _i = 0;
String _currentchar = "";
anywheresoftware.b4a.keywords.StringBuilderWrapper _combinedvalue = null;
String _part = "";
String _partvalue = "";
String _variablename = "";
String _functionname = "";
int _functionlength = 0;
String _arguments = "";
anywheresoftware.b4a.objects.collections.List _argumentlist = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _currentargument = null;
String _argumentchar = "";
int _expectedarguments = 0;
double _numericresult = 0;
double _binvalue = 0;
String _binresult = "";
double _octvalue = 0;
double _hexvalue = 0;
double _charactercode = 0;
double _spacecountvalue = 0;
int _spacecount = 0;
anywheresoftware.b4a.keywords.StringBuilderWrapper _spacebuilder = null;
double _repeatcountvalue = 0;
int _repeatcount = 0;
String _repeatchar = "";
String _repeatvariable = "";
double _repeatcharcode = 0;
anywheresoftware.b4a.keywords.StringBuilderWrapper _repeatbuilder = null;
String _casesource = "";
String _trimsource = "";
int _trimstart = 0;
int _trimend = 0;
String _stringargument = "";
String _stringvalue = "";
String _sourcevariable = "";
int _startposition = 0;
double _startvalue = 0;
int _lengthindex = 0;
double _requestedlength = 0;
int _charactercount = 0;
int _startindex = 0;
int _endindex = 0;
 //BA.debugLineNum = 2379;BA.debugLine="Private Sub EvaluateStringExpression(Expression As";
 //BA.debugLineNum = 2380;BA.debugLine="Expression = Expression.Trim";
_expression = _expression.trim();
 //BA.debugLineNum = 2382;BA.debugLine="If Expression = \"\" Then";
if ((_expression).equals("")) { 
 //BA.debugLineNum = 2383;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 2384;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 2388;BA.debugLine="Dim Parts As List";
_parts = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2389;BA.debugLine="Parts.Initialize";
_parts.Initialize();
 //BA.debugLineNum = 2391;BA.debugLine="Dim CurrentPart As StringBuilder";
_currentpart = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 2392;BA.debugLine="CurrentPart.Initialize";
_currentpart.Initialize();
 //BA.debugLineNum = 2394;BA.debugLine="Dim InQuotes As Boolean = False";
_inquotes = __c.False;
 //BA.debugLineNum = 2395;BA.debugLine="Dim BracketLevel As Int = 0";
_bracketlevel = (int) (0);
 //BA.debugLineNum = 2396;BA.debugLine="Dim HasConcatenation As Boolean = False";
_hasconcatenation = __c.False;
 //BA.debugLineNum = 2398;BA.debugLine="For i = 0 To Expression.Length - 1";
{
final int step13 = 1;
final int limit13 = (int) (_expression.length()-1);
_i = (int) (0) ;
for (;_i <= limit13 ;_i = _i + step13 ) {
 //BA.debugLineNum = 2399;BA.debugLine="Dim CurrentChar As String = Expression.SubString";
_currentchar = _expression.substring(_i,(int) (_i+1));
 //BA.debugLineNum = 2401;BA.debugLine="If CurrentChar = Chr(34) Then";
if ((_currentchar).equals(BA.ObjectToString(__c.Chr((int) (34))))) { 
 //BA.debugLineNum = 2402;BA.debugLine="InQuotes = Not(InQuotes)";
_inquotes = __c.Not(_inquotes);
 }else if(_inquotes==__c.False) { 
 //BA.debugLineNum = 2405;BA.debugLine="If CurrentChar = \"(\" Then BracketLevel = Bracke";
if ((_currentchar).equals("(")) { 
_bracketlevel = (int) (_bracketlevel+1);};
 //BA.debugLineNum = 2406;BA.debugLine="If CurrentChar = \")\" Then BracketLevel = Bracke";
if ((_currentchar).equals(")")) { 
_bracketlevel = (int) (_bracketlevel-1);};
 //BA.debugLineNum = 2408;BA.debugLine="If CurrentChar = \"+\" And BracketLevel = 0 Then";
if ((_currentchar).equals("+") && _bracketlevel==0) { 
 //BA.debugLineNum = 2409;BA.debugLine="Parts.Add(CurrentPart.ToString.Trim)";
_parts.Add((Object)(_currentpart.ToString().trim()));
 //BA.debugLineNum = 2410;BA.debugLine="CurrentPart.Initialize";
_currentpart.Initialize();
 //BA.debugLineNum = 2411;BA.debugLine="HasConcatenation = True";
_hasconcatenation = __c.True;
 //BA.debugLineNum = 2412;BA.debugLine="Continue";
if (true) continue;
 };
 };
 //BA.debugLineNum = 2416;BA.debugLine="CurrentPart.Append(CurrentChar)";
_currentpart.Append(_currentchar);
 }
};
 //BA.debugLineNum = 2419;BA.debugLine="Parts.Add(CurrentPart.ToString.Trim)";
_parts.Add((Object)(_currentpart.ToString().trim()));
 //BA.debugLineNum = 2421;BA.debugLine="If InQuotes Or BracketLevel <> 0 Then";
if (_inquotes || _bracketlevel!=0) { 
 //BA.debugLineNum = 2422;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 2423;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 2427;BA.debugLine="If HasConcatenation Then";
if (_hasconcatenation) { 
 //BA.debugLineNum = 2428;BA.debugLine="Dim CombinedValue As StringBuilder";
_combinedvalue = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 2429;BA.debugLine="CombinedValue.Initialize";
_combinedvalue.Initialize();
 //BA.debugLineNum = 2431;BA.debugLine="For Each Part As String In Parts";
{
final anywheresoftware.b4a.BA.IterableList group37 = _parts;
final int groupLen37 = group37.getSize()
;int index37 = 0;
;
for (; index37 < groupLen37;index37++){
_part = BA.ObjectToString(group37.Get(index37));
 //BA.debugLineNum = 2432;BA.debugLine="If Part = \"\" Then";
if ((_part).equals("")) { 
 //BA.debugLineNum = 2433;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 2434;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 2437;BA.debugLine="Dim PartValue As String = EvaluateStringExpress";
_partvalue = _evaluatestringexpression(_part);
 //BA.debugLineNum = 2439;BA.debugLine="If ExprError Then Return \"\"";
if (_exprerror) { 
if (true) return "";};
 //BA.debugLineNum = 2441;BA.debugLine="CombinedValue.Append(PartValue)";
_combinedvalue.Append(_partvalue);
 }
};
 //BA.debugLineNum = 2444;BA.debugLine="Return CombinedValue.ToString";
if (true) return _combinedvalue.ToString();
 };
 //BA.debugLineNum = 2448;BA.debugLine="If Expression.StartsWith(Chr(34)) And _ 		Express";
if (_expression.startsWith(BA.ObjectToString(__c.Chr((int) (34)))) && _expression.endsWith(BA.ObjectToString(__c.Chr((int) (34)))) && _expression.length()>=2) { 
 //BA.debugLineNum = 2451;BA.debugLine="Return Expression.SubString2(1, Expression.Lengt";
if (true) return _expression.substring((int) (1),(int) (_expression.length()-1));
 };
 //BA.debugLineNum = 2455;BA.debugLine="If Expression.EndsWith(\"$\") Then";
if (_expression.endsWith("$")) { 
 //BA.debugLineNum = 2456;BA.debugLine="Dim VariableName As String = Expression.ToUpperC";
_variablename = _expression.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 2458;BA.debugLine="If Variables.ContainsKey(VariableName) Then";
if (_variables.ContainsKey((Object)(_variablename))) { 
 //BA.debugLineNum = 2459;BA.debugLine="Return Variables.Get(VariableName)";
if (true) return BA.ObjectToString(_variables.Get((Object)(_variablename)));
 };
 //BA.debugLineNum = 2462;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 2463;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 2466;BA.debugLine="Dim FunctionName As String = Expression.ToUpperCa";
_functionname = _expression.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 2467;BA.debugLine="Dim FunctionLength As Int";
_functionlength = 0;
 //BA.debugLineNum = 2469;BA.debugLine="Select Case True";
switch (BA.switchObjectToInt(__c.True,_functionname.startsWith("LEFT$("),_functionname.startsWith("RIGHT$("),_functionname.startsWith("MID$("),_functionname.startsWith("STR$("),_functionname.startsWith("CHR$("),_functionname.startsWith("SPACE$("),_functionname.startsWith("STRING$("),_functionname.startsWith("UCASE$("),_functionname.startsWith("LCASE$("),_functionname.startsWith("LTRIM$("),_functionname.startsWith("RTRIM$("),_functionname.startsWith("TRIM$("),_functionname.startsWith("BIN("),_functionname.startsWith("HEX("),_functionname.startsWith("OCT("))) {
case 0: {
 //BA.debugLineNum = 2471;BA.debugLine="FunctionLength = 6";
_functionlength = (int) (6);
 break; }
case 1: {
 //BA.debugLineNum = 2473;BA.debugLine="FunctionLength = 7";
_functionlength = (int) (7);
 break; }
case 2: {
 //BA.debugLineNum = 2475;BA.debugLine="FunctionLength = 5";
_functionlength = (int) (5);
 break; }
case 3: {
 //BA.debugLineNum = 2477;BA.debugLine="FunctionLength = 5";
_functionlength = (int) (5);
 break; }
case 4: {
 //BA.debugLineNum = 2479;BA.debugLine="FunctionLength = 5";
_functionlength = (int) (5);
 break; }
case 5: {
 //BA.debugLineNum = 2481;BA.debugLine="FunctionLength = 7";
_functionlength = (int) (7);
 break; }
case 6: {
 //BA.debugLineNum = 2483;BA.debugLine="FunctionLength = 8";
_functionlength = (int) (8);
 break; }
case 7: {
 //BA.debugLineNum = 2485;BA.debugLine="FunctionLength = 7";
_functionlength = (int) (7);
 break; }
case 8: {
 //BA.debugLineNum = 2487;BA.debugLine="FunctionLength = 7";
_functionlength = (int) (7);
 break; }
case 9: {
 //BA.debugLineNum = 2489;BA.debugLine="FunctionLength = 7";
_functionlength = (int) (7);
 break; }
case 10: {
 //BA.debugLineNum = 2491;BA.debugLine="FunctionLength = 7";
_functionlength = (int) (7);
 break; }
case 11: {
 //BA.debugLineNum = 2493;BA.debugLine="FunctionLength = 6";
_functionlength = (int) (6);
 break; }
case 12: {
 //BA.debugLineNum = 2496;BA.debugLine="FunctionLength = 4";
_functionlength = (int) (4);
 break; }
case 13: {
 //BA.debugLineNum = 2498;BA.debugLine="FunctionLength = 4";
_functionlength = (int) (4);
 break; }
case 14: {
 //BA.debugLineNum = 2500;BA.debugLine="FunctionLength = 4";
_functionlength = (int) (4);
 break; }
default: {
 //BA.debugLineNum = 2502;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 2503;BA.debugLine="Return \"\"";
if (true) return "";
 break; }
}
;
 //BA.debugLineNum = 2506;BA.debugLine="If Expression.EndsWith(\")\") = False Then";
if (_expression.endsWith(")")==__c.False) { 
 //BA.debugLineNum = 2507;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 2508;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 2512;BA.debugLine="Dim Arguments As String = Expression.SubString2(F";
_arguments = _expression.substring(_functionlength,(int) (_expression.length()-1));
 //BA.debugLineNum = 2514;BA.debugLine="Dim ArgumentList As List";
_argumentlist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 2515;BA.debugLine="ArgumentList.Initialize";
_argumentlist.Initialize();
 //BA.debugLineNum = 2517;BA.debugLine="Dim CurrentArgument As StringBuilder";
_currentargument = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 2518;BA.debugLine="CurrentArgument.Initialize";
_currentargument.Initialize();
 //BA.debugLineNum = 2520;BA.debugLine="InQuotes = False";
_inquotes = __c.False;
 //BA.debugLineNum = 2521;BA.debugLine="BracketLevel = 0";
_bracketlevel = (int) (0);
 //BA.debugLineNum = 2523;BA.debugLine="For i = 0 To Arguments.Length - 1";
{
final int step107 = 1;
final int limit107 = (int) (_arguments.length()-1);
_i = (int) (0) ;
for (;_i <= limit107 ;_i = _i + step107 ) {
 //BA.debugLineNum = 2524;BA.debugLine="Dim ArgumentChar As String = Arguments.SubString";
_argumentchar = _arguments.substring(_i,(int) (_i+1));
 //BA.debugLineNum = 2526;BA.debugLine="If ArgumentChar = Chr(34) Then";
if ((_argumentchar).equals(BA.ObjectToString(__c.Chr((int) (34))))) { 
 //BA.debugLineNum = 2527;BA.debugLine="InQuotes = Not(InQuotes)";
_inquotes = __c.Not(_inquotes);
 }else if(_inquotes==__c.False) { 
 //BA.debugLineNum = 2529;BA.debugLine="If ArgumentChar = \"(\" Then BracketLevel = Brack";
if ((_argumentchar).equals("(")) { 
_bracketlevel = (int) (_bracketlevel+1);};
 //BA.debugLineNum = 2530;BA.debugLine="If ArgumentChar = \")\" Then BracketLevel = Brack";
if ((_argumentchar).equals(")")) { 
_bracketlevel = (int) (_bracketlevel-1);};
 //BA.debugLineNum = 2532;BA.debugLine="If ArgumentChar = \",\" And BracketLevel = 0 Then";
if ((_argumentchar).equals(",") && _bracketlevel==0) { 
 //BA.debugLineNum = 2533;BA.debugLine="ArgumentList.Add(CurrentArgument.ToString.Trim";
_argumentlist.Add((Object)(_currentargument.ToString().trim()));
 //BA.debugLineNum = 2534;BA.debugLine="CurrentArgument.Initialize";
_currentargument.Initialize();
 //BA.debugLineNum = 2535;BA.debugLine="Continue";
if (true) continue;
 };
 };
 //BA.debugLineNum = 2539;BA.debugLine="CurrentArgument.Append(ArgumentChar)";
_currentargument.Append(_argumentchar);
 }
};
 //BA.debugLineNum = 2542;BA.debugLine="ArgumentList.Add(CurrentArgument.ToString.Trim)";
_argumentlist.Add((Object)(_currentargument.ToString().trim()));
 //BA.debugLineNum = 2544;BA.debugLine="If InQuotes Or BracketLevel <> 0 Then";
if (_inquotes || _bracketlevel!=0) { 
 //BA.debugLineNum = 2545;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 2546;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 2550;BA.debugLine="Dim ExpectedArguments As Int = 2";
_expectedarguments = (int) (2);
 //BA.debugLineNum = 2552;BA.debugLine="If FunctionName.StartsWith(\"MID$(\") Then Expected";
if (_functionname.startsWith("MID$(")) { 
_expectedarguments = (int) (3);};
 //BA.debugLineNum = 2553;BA.debugLine="If FunctionName.StartsWith(\"STR$(\") Then Expected";
if (_functionname.startsWith("STR$(")) { 
_expectedarguments = (int) (1);};
 //BA.debugLineNum = 2554;BA.debugLine="If FunctionName.StartsWith(\"CHR$(\") Then Expected";
if (_functionname.startsWith("CHR$(")) { 
_expectedarguments = (int) (1);};
 //BA.debugLineNum = 2555;BA.debugLine="If FunctionName.StartsWith(\"SPACE$(\") Then Expect";
if (_functionname.startsWith("SPACE$(")) { 
_expectedarguments = (int) (1);};
 //BA.debugLineNum = 2556;BA.debugLine="If FunctionName.StartsWith(\"UCASE$(\") Then Expect";
if (_functionname.startsWith("UCASE$(")) { 
_expectedarguments = (int) (1);};
 //BA.debugLineNum = 2557;BA.debugLine="If FunctionName.StartsWith(\"LCASE$(\") Then Expect";
if (_functionname.startsWith("LCASE$(")) { 
_expectedarguments = (int) (1);};
 //BA.debugLineNum = 2558;BA.debugLine="If FunctionName.StartsWith(\"LTRIM$(\") Then Expect";
if (_functionname.startsWith("LTRIM$(")) { 
_expectedarguments = (int) (1);};
 //BA.debugLineNum = 2559;BA.debugLine="If FunctionName.StartsWith(\"RTRIM$(\") Then Expect";
if (_functionname.startsWith("RTRIM$(")) { 
_expectedarguments = (int) (1);};
 //BA.debugLineNum = 2560;BA.debugLine="If FunctionName.StartsWith(\"TRIM$(\") Then Expecte";
if (_functionname.startsWith("TRIM$(")) { 
_expectedarguments = (int) (1);};
 //BA.debugLineNum = 2562;BA.debugLine="If FunctionName.StartsWith(\"BIN(\") Then ExpectedA";
if (_functionname.startsWith("BIN(")) { 
_expectedarguments = (int) (1);};
 //BA.debugLineNum = 2563;BA.debugLine="If FunctionName.StartsWith(\"HEX(\") Then ExpectedA";
if (_functionname.startsWith("HEX(")) { 
_expectedarguments = (int) (1);};
 //BA.debugLineNum = 2564;BA.debugLine="If FunctionName.StartsWith(\"OCT(\") Then ExpectedA";
if (_functionname.startsWith("OCT(")) { 
_expectedarguments = (int) (1);};
 //BA.debugLineNum = 2566;BA.debugLine="If ArgumentList.Size <> ExpectedArguments Then";
if (_argumentlist.getSize()!=_expectedarguments) { 
 //BA.debugLineNum = 2567;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 2568;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 2572;BA.debugLine="If FunctionName.StartsWith(\"STR$(\") Then";
if (_functionname.startsWith("STR$(")) { 
 //BA.debugLineNum = 2573;BA.debugLine="Dim NumericResult As Double = EvaluateNumericExp";
_numericresult = _evaluatenumericexpression(BA.ObjectToString(_argumentlist.Get((int) (0))));
 //BA.debugLineNum = 2575;BA.debugLine="If ExprError Then Return \"\"";
if (_exprerror) { 
if (true) return "";};
 //BA.debugLineNum = 2577;BA.debugLine="Return NumberFormat(NumericResult, 1, 6)";
if (true) return __c.NumberFormat(_numericresult,(int) (1),(int) (6));
 };
 //BA.debugLineNum = 2581;BA.debugLine="If FunctionName.StartsWith(\"BIN(\") Then";
if (_functionname.startsWith("BIN(")) { 
 //BA.debugLineNum = 2582;BA.debugLine="Dim BinValue As Double = EvaluateNumericExpressi";
_binvalue = _evaluatenumericexpression(BA.ObjectToString(_argumentlist.Get((int) (0))));
 //BA.debugLineNum = 2584;BA.debugLine="If ExprError Then Return \"\"";
if (_exprerror) { 
if (true) return "";};
 //BA.debugLineNum = 2586;BA.debugLine="If BinValue < 0 Or BinValue <> Floor(BinValue) T";
if (_binvalue<0 || _binvalue!=__c.Floor(_binvalue)) { 
 //BA.debugLineNum = 2587;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 2588;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 2591;BA.debugLine="Dim BinResult As String = Bit.ToBinaryString(Bin";
_binresult = __c.Bit.ToBinaryString((int) (_binvalue));
 //BA.debugLineNum = 2593;BA.debugLine="Return BinResult";
if (true) return _binresult;
 };
 //BA.debugLineNum = 2597;BA.debugLine="If FunctionName.StartsWith(\"OCT(\") Then";
if (_functionname.startsWith("OCT(")) { 
 //BA.debugLineNum = 2598;BA.debugLine="Dim OctValue As Double = EvaluateNumericExpressi";
_octvalue = _evaluatenumericexpression(BA.ObjectToString(_argumentlist.Get((int) (0))));
 //BA.debugLineNum = 2600;BA.debugLine="If ExprError Then Return \"\"";
if (_exprerror) { 
if (true) return "";};
 //BA.debugLineNum = 2602;BA.debugLine="If OctValue < 0 Or OctValue <> Floor(OctValue) T";
if (_octvalue<0 || _octvalue!=__c.Floor(_octvalue)) { 
 //BA.debugLineNum = 2603;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 2604;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 2607;BA.debugLine="Return Bit.ToOctalString(OctValue)";
if (true) return __c.Bit.ToOctalString((int) (_octvalue));
 };
 //BA.debugLineNum = 2611;BA.debugLine="If FunctionName.StartsWith(\"HEX(\") Then";
if (_functionname.startsWith("HEX(")) { 
 //BA.debugLineNum = 2612;BA.debugLine="Dim HexValue As Double = EvaluateNumericExpressi";
_hexvalue = _evaluatenumericexpression(BA.ObjectToString(_argumentlist.Get((int) (0))));
 //BA.debugLineNum = 2614;BA.debugLine="If ExprError Then Return \"\"";
if (_exprerror) { 
if (true) return "";};
 //BA.debugLineNum = 2616;BA.debugLine="If HexValue <> Floor(HexValue) Then";
if (_hexvalue!=__c.Floor(_hexvalue)) { 
 //BA.debugLineNum = 2617;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 2618;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 2621;BA.debugLine="Return Bit.ToHexString(HexValue).ToUpperCase";
if (true) return __c.Bit.ToHexString((int) (_hexvalue)).toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 };
 //BA.debugLineNum = 2625;BA.debugLine="If FunctionName.StartsWith(\"CHR$(\") Then";
if (_functionname.startsWith("CHR$(")) { 
 //BA.debugLineNum = 2626;BA.debugLine="Dim CharacterCode As Double = EvaluateNumericExp";
_charactercode = _evaluatenumericexpression(BA.ObjectToString(_argumentlist.Get((int) (0))));
 //BA.debugLineNum = 2628;BA.debugLine="If ExprError Or CharacterCode < 0 Or CharacterCo";
if (_exprerror || _charactercode<0 || _charactercode>255) { 
 //BA.debugLineNum = 2629;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 2630;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 2633;BA.debugLine="Return Chr(Floor(CharacterCode))";
if (true) return BA.ObjectToString(__c.Chr((int) (__c.Floor(_charactercode))));
 };
 //BA.debugLineNum = 2637;BA.debugLine="If FunctionName.StartsWith(\"SPACE$(\") Then";
if (_functionname.startsWith("SPACE$(")) { 
 //BA.debugLineNum = 2638;BA.debugLine="Dim SpaceCountValue As Double = EvaluateNumericE";
_spacecountvalue = _evaluatenumericexpression(BA.ObjectToString(_argumentlist.Get((int) (0))));
 //BA.debugLineNum = 2640;BA.debugLine="If ExprError Or SpaceCountValue < 0 Or SpaceCoun";
if (_exprerror || _spacecountvalue<0 || _spacecountvalue>10000) { 
 //BA.debugLineNum = 2641;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 2642;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 2645;BA.debugLine="Dim SpaceCount As Int = Floor(SpaceCountValue)";
_spacecount = (int) (__c.Floor(_spacecountvalue));
 //BA.debugLineNum = 2646;BA.debugLine="Dim SpaceBuilder As StringBuilder";
_spacebuilder = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 2647;BA.debugLine="SpaceBuilder.Initialize";
_spacebuilder.Initialize();
 //BA.debugLineNum = 2649;BA.debugLine="For i = 1 To SpaceCount";
{
final int step194 = 1;
final int limit194 = _spacecount;
_i = (int) (1) ;
for (;_i <= limit194 ;_i = _i + step194 ) {
 //BA.debugLineNum = 2650;BA.debugLine="SpaceBuilder.Append(\" \")";
_spacebuilder.Append(" ");
 }
};
 //BA.debugLineNum = 2653;BA.debugLine="Return SpaceBuilder.ToString";
if (true) return _spacebuilder.ToString();
 };
 //BA.debugLineNum = 2657;BA.debugLine="If FunctionName.StartsWith(\"STRING$(\") Then";
if (_functionname.startsWith("STRING$(")) { 
 //BA.debugLineNum = 2658;BA.debugLine="Dim RepeatCountValue As Double = EvaluateNumeric";
_repeatcountvalue = _evaluatenumericexpression(BA.ObjectToString(_argumentlist.Get((int) (0))));
 //BA.debugLineNum = 2660;BA.debugLine="If ExprError Or RepeatCountValue < 0 Or RepeatCo";
if (_exprerror || _repeatcountvalue<0 || _repeatcountvalue>10000) { 
 //BA.debugLineNum = 2661;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 2662;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 2665;BA.debugLine="Dim RepeatCount As Int = Floor(RepeatCountValue)";
_repeatcount = (int) (__c.Floor(_repeatcountvalue));
 //BA.debugLineNum = 2666;BA.debugLine="Dim RepeatChar As String = ArgumentList.Get(1)";
_repeatchar = BA.ObjectToString(_argumentlist.Get((int) (1)));
 //BA.debugLineNum = 2669;BA.debugLine="If RepeatChar.StartsWith(Chr(34)) And _ 			Repea";
if (_repeatchar.startsWith(BA.ObjectToString(__c.Chr((int) (34)))) && _repeatchar.endsWith(BA.ObjectToString(__c.Chr((int) (34)))) && _repeatchar.length()>=2) { 
 //BA.debugLineNum = 2672;BA.debugLine="RepeatChar = RepeatChar.SubString2(1, RepeatCha";
_repeatchar = _repeatchar.substring((int) (1),(int) (_repeatchar.length()-1));
 }else if(_repeatchar.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale).endsWith("$")) { 
 //BA.debugLineNum = 2677;BA.debugLine="Dim RepeatVariable As String = RepeatChar.ToUpp";
_repeatvariable = _repeatchar.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 2679;BA.debugLine="If Variables.ContainsKey(RepeatVariable) = Fals";
if (_variables.ContainsKey((Object)(_repeatvariable))==__c.False) { 
 //BA.debugLineNum = 2680;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 2681;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 2684;BA.debugLine="RepeatChar = Variables.Get(RepeatVariable)";
_repeatchar = BA.ObjectToString(_variables.Get((Object)(_repeatvariable)));
 }else {
 //BA.debugLineNum = 2689;BA.debugLine="Dim RepeatCharCode As Double = EvaluateNumericE";
_repeatcharcode = _evaluatenumericexpression(_repeatchar);
 //BA.debugLineNum = 2691;BA.debugLine="If ExprError Or RepeatCharCode < 0 Or RepeatCha";
if (_exprerror || _repeatcharcode<0 || _repeatcharcode>255) { 
 //BA.debugLineNum = 2692;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 2693;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 2696;BA.debugLine="RepeatChar = Chr(Floor(RepeatCharCode))";
_repeatchar = BA.ObjectToString(__c.Chr((int) (__c.Floor(_repeatcharcode))));
 };
 //BA.debugLineNum = 2699;BA.debugLine="If RepeatChar.Length <> 1 Then";
if (_repeatchar.length()!=1) { 
 //BA.debugLineNum = 2700;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 2701;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 2704;BA.debugLine="Dim RepeatBuilder As StringBuilder";
_repeatbuilder = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 2705;BA.debugLine="RepeatBuilder.Initialize";
_repeatbuilder.Initialize();
 //BA.debugLineNum = 2707;BA.debugLine="For i = 1 To RepeatCount";
{
final int step230 = 1;
final int limit230 = _repeatcount;
_i = (int) (1) ;
for (;_i <= limit230 ;_i = _i + step230 ) {
 //BA.debugLineNum = 2708;BA.debugLine="RepeatBuilder.Append(RepeatChar)";
_repeatbuilder.Append(_repeatchar);
 }
};
 //BA.debugLineNum = 2711;BA.debugLine="Return RepeatBuilder.ToString";
if (true) return _repeatbuilder.ToString();
 };
 //BA.debugLineNum = 2715;BA.debugLine="If FunctionName.StartsWith(\"UCASE$(\") Then";
if (_functionname.startsWith("UCASE$(")) { 
 //BA.debugLineNum = 2716;BA.debugLine="Dim CaseSource As String = EvaluateStringExpress";
_casesource = _evaluatestringexpression(BA.ObjectToString(_argumentlist.Get((int) (0))));
 //BA.debugLineNum = 2718;BA.debugLine="If ExprError Then Return \"\"";
if (_exprerror) { 
if (true) return "";};
 //BA.debugLineNum = 2720;BA.debugLine="Return CaseSource.ToUpperCase";
if (true) return _casesource.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 };
 //BA.debugLineNum = 2724;BA.debugLine="If FunctionName.StartsWith(\"LCASE$(\") Then";
if (_functionname.startsWith("LCASE$(")) { 
 //BA.debugLineNum = 2725;BA.debugLine="Dim CaseSource As String = EvaluateStringExpress";
_casesource = _evaluatestringexpression(BA.ObjectToString(_argumentlist.Get((int) (0))));
 //BA.debugLineNum = 2727;BA.debugLine="If ExprError Then Return \"\"";
if (_exprerror) { 
if (true) return "";};
 //BA.debugLineNum = 2729;BA.debugLine="Return CaseSource.ToLowerCase";
if (true) return _casesource.toLowerCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 };
 //BA.debugLineNum = 2733;BA.debugLine="If FunctionName.StartsWith(\"LTRIM$(\") Then";
if (_functionname.startsWith("LTRIM$(")) { 
 //BA.debugLineNum = 2734;BA.debugLine="Dim TrimSource As String = EvaluateStringExpress";
_trimsource = _evaluatestringexpression(BA.ObjectToString(_argumentlist.Get((int) (0))));
 //BA.debugLineNum = 2736;BA.debugLine="If ExprError Then Return \"\"";
if (_exprerror) { 
if (true) return "";};
 //BA.debugLineNum = 2738;BA.debugLine="Dim TrimStart As Int = 0";
_trimstart = (int) (0);
 //BA.debugLineNum = 2740;BA.debugLine="Do While TrimStart < TrimSource.Length";
while (_trimstart<_trimsource.length()) {
 //BA.debugLineNum = 2741;BA.debugLine="If TrimSource.SubString2(TrimStart, TrimStart +";
if ((_trimsource.substring(_trimstart,(int) (_trimstart+1))).equals(" ") == false) { 
if (true) break;};
 //BA.debugLineNum = 2742;BA.debugLine="TrimStart = TrimStart + 1";
_trimstart = (int) (_trimstart+1);
 }
;
 //BA.debugLineNum = 2745;BA.debugLine="Return TrimSource.SubString(TrimStart)";
if (true) return _trimsource.substring(_trimstart);
 };
 //BA.debugLineNum = 2749;BA.debugLine="If FunctionName.StartsWith(\"RTRIM$(\") Then";
if (_functionname.startsWith("RTRIM$(")) { 
 //BA.debugLineNum = 2750;BA.debugLine="Dim TrimSource As String = EvaluateStringExpress";
_trimsource = _evaluatestringexpression(BA.ObjectToString(_argumentlist.Get((int) (0))));
 //BA.debugLineNum = 2752;BA.debugLine="If ExprError Then Return \"\"";
if (_exprerror) { 
if (true) return "";};
 //BA.debugLineNum = 2754;BA.debugLine="Dim TrimEnd As Int = TrimSource.Length";
_trimend = _trimsource.length();
 //BA.debugLineNum = 2756;BA.debugLine="Do While TrimEnd > 0";
while (_trimend>0) {
 //BA.debugLineNum = 2757;BA.debugLine="If TrimSource.SubString2(TrimEnd - 1, TrimEnd)";
if ((_trimsource.substring((int) (_trimend-1),_trimend)).equals(" ") == false) { 
if (true) break;};
 //BA.debugLineNum = 2758;BA.debugLine="TrimEnd = TrimEnd - 1";
_trimend = (int) (_trimend-1);
 }
;
 //BA.debugLineNum = 2761;BA.debugLine="Return TrimSource.SubString2(0, TrimEnd)";
if (true) return _trimsource.substring((int) (0),_trimend);
 };
 //BA.debugLineNum = 2765;BA.debugLine="If FunctionName.StartsWith(\"TRIM$(\") Then";
if (_functionname.startsWith("TRIM$(")) { 
 //BA.debugLineNum = 2766;BA.debugLine="Dim TrimSource As String = EvaluateStringExpress";
_trimsource = _evaluatestringexpression(BA.ObjectToString(_argumentlist.Get((int) (0))));
 //BA.debugLineNum = 2768;BA.debugLine="If ExprError Then Return \"\"";
if (_exprerror) { 
if (true) return "";};
 //BA.debugLineNum = 2770;BA.debugLine="Return TrimSource.Trim";
if (true) return _trimsource.trim();
 };
 //BA.debugLineNum = 2774;BA.debugLine="Dim StringArgument As String = ArgumentList.Get(0";
_stringargument = BA.ObjectToString(_argumentlist.Get((int) (0)));
 //BA.debugLineNum = 2775;BA.debugLine="Dim StringValue As String = \"\"";
_stringvalue = "";
 //BA.debugLineNum = 2777;BA.debugLine="If StringArgument.StartsWith(Chr(34)) And _ 		Str";
if (_stringargument.startsWith(BA.ObjectToString(__c.Chr((int) (34)))) && _stringargument.endsWith(BA.ObjectToString(__c.Chr((int) (34)))) && _stringargument.length()>=2) { 
 //BA.debugLineNum = 2780;BA.debugLine="StringValue = StringArgument.SubString2(1, Strin";
_stringvalue = _stringargument.substring((int) (1),(int) (_stringargument.length()-1));
 }else {
 //BA.debugLineNum = 2783;BA.debugLine="Dim SourceVariable As String = StringArgument.To";
_sourcevariable = _stringargument.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 2785;BA.debugLine="If SourceVariable.EndsWith(\"$\") = False Or Varia";
if (_sourcevariable.endsWith("$")==__c.False || _variables.ContainsKey((Object)(_sourcevariable))==__c.False) { 
 //BA.debugLineNum = 2786;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 2787;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 2790;BA.debugLine="StringValue = Variables.Get(SourceVariable)";
_stringvalue = BA.ObjectToString(_variables.Get((Object)(_sourcevariable)));
 };
 //BA.debugLineNum = 2794;BA.debugLine="Dim StartPosition As Int = 1";
_startposition = (int) (1);
 //BA.debugLineNum = 2796;BA.debugLine="If FunctionName.StartsWith(\"MID$(\") Then";
if (_functionname.startsWith("MID$(")) { 
 //BA.debugLineNum = 2797;BA.debugLine="Dim StartValue As Double = EvaluateNumericExpres";
_startvalue = _evaluatenumericexpression(BA.ObjectToString(_argumentlist.Get((int) (1))));
 //BA.debugLineNum = 2799;BA.debugLine="If ExprError Or StartValue < 1 Then";
if (_exprerror || _startvalue<1) { 
 //BA.debugLineNum = 2800;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 2801;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 2804;BA.debugLine="StartPosition = Floor(StartValue)";
_startposition = (int) (__c.Floor(_startvalue));
 };
 //BA.debugLineNum = 2808;BA.debugLine="Dim LengthIndex As Int = 1";
_lengthindex = (int) (1);
 //BA.debugLineNum = 2809;BA.debugLine="If FunctionName.StartsWith(\"MID$(\") Then LengthIn";
if (_functionname.startsWith("MID$(")) { 
_lengthindex = (int) (2);};
 //BA.debugLineNum = 2811;BA.debugLine="Dim RequestedLength As Double = EvaluateNumericEx";
_requestedlength = _evaluatenumericexpression(BA.ObjectToString(_argumentlist.Get(_lengthindex)));
 //BA.debugLineNum = 2813;BA.debugLine="If ExprError Or RequestedLength < 0 Then";
if (_exprerror || _requestedlength<0) { 
 //BA.debugLineNum = 2814;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 2815;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 2818;BA.debugLine="Dim CharacterCount As Int = Floor(RequestedLength";
_charactercount = (int) (__c.Floor(_requestedlength));
 //BA.debugLineNum = 2820;BA.debugLine="If FunctionName.StartsWith(\"LEFT$(\") Then";
if (_functionname.startsWith("LEFT$(")) { 
 //BA.debugLineNum = 2821;BA.debugLine="If CharacterCount > StringValue.Length Then Char";
if (_charactercount>_stringvalue.length()) { 
_charactercount = _stringvalue.length();};
 //BA.debugLineNum = 2823;BA.debugLine="Return StringValue.SubString2(0, CharacterCount)";
if (true) return _stringvalue.substring((int) (0),_charactercount);
 }else if(_functionname.startsWith("RIGHT$(")) { 
 //BA.debugLineNum = 2826;BA.debugLine="If CharacterCount > StringValue.Length Then Char";
if (_charactercount>_stringvalue.length()) { 
_charactercount = _stringvalue.length();};
 //BA.debugLineNum = 2828;BA.debugLine="Return StringValue.SubString(StringValue.Length";
if (true) return _stringvalue.substring((int) (_stringvalue.length()-_charactercount));
 }else {
 //BA.debugLineNum = 2832;BA.debugLine="Dim StartIndex As Int = StartPosition - 1";
_startindex = (int) (_startposition-1);
 //BA.debugLineNum = 2834;BA.debugLine="If StartIndex >= StringValue.Length Then Return";
if (_startindex>=_stringvalue.length()) { 
if (true) return "";};
 //BA.debugLineNum = 2836;BA.debugLine="Dim EndIndex As Int = StartIndex + CharacterCoun";
_endindex = (int) (_startindex+_charactercount);
 //BA.debugLineNum = 2838;BA.debugLine="If EndIndex > StringValue.Length Then EndIndex =";
if (_endindex>_stringvalue.length()) { 
_endindex = _stringvalue.length();};
 //BA.debugLineNum = 2840;BA.debugLine="Return StringValue.SubString2(StartIndex, EndInd";
if (true) return _stringvalue.substring(_startindex,_endindex);
 };
 //BA.debugLineNum = 2842;BA.debugLine="End Sub";
return "";
}
public double  _evaluateuserfunction(String _functionname,anywheresoftware.b4a.objects.collections.List _arguments) throws Exception{
anywheresoftware.b4a.objects.collections.Map _functiondefinition = null;
anywheresoftware.b4a.objects.collections.List _parameters = null;
String _functionexpression = "";
String _savedexprtext = "";
int _savedexprpos = 0;
boolean _savedexprerror = false;
int _savedexprerrorcode = 0;
anywheresoftware.b4a.objects.collections.Map _savedvariables = null;
anywheresoftware.b4a.objects.collections.List _existingparameters = null;
String _parameter = "";
int _i = 0;
double _argument = 0;
double _result = 0;
boolean _functionerror = false;
int _functionerrorcode = 0;
 //BA.debugLineNum = 3358;BA.debugLine="Private Sub EvaluateUserFunction(FunctionName As S";
 //BA.debugLineNum = 3360;BA.debugLine="If Functions.ContainsKey(FunctionName) = False Th";
if (_functions.ContainsKey((Object)(_functionname))==__c.False) { 
 //BA.debugLineNum = 3361;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 3362;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 3365;BA.debugLine="Dim FunctionDefinition As Map = Functions.Get(Fun";
_functiondefinition = new anywheresoftware.b4a.objects.collections.Map();
_functiondefinition = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_functions.Get((Object)(_functionname))));
 //BA.debugLineNum = 3366;BA.debugLine="Dim Parameters As List = FunctionDefinition.Get(\"";
_parameters = new anywheresoftware.b4a.objects.collections.List();
_parameters = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_functiondefinition.Get((Object)("Parameters"))));
 //BA.debugLineNum = 3367;BA.debugLine="Dim FunctionExpression As String = FunctionDefini";
_functionexpression = BA.ObjectToString(_functiondefinition.Get((Object)("Expression")));
 //BA.debugLineNum = 3370;BA.debugLine="If Arguments.Size <> Parameters.Size Then";
if (_arguments.getSize()!=_parameters.getSize()) { 
 //BA.debugLineNum = 3371;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 3372;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 3376;BA.debugLine="Dim SavedExprText As String = ExprText";
_savedexprtext = _exprtext;
 //BA.debugLineNum = 3377;BA.debugLine="Dim SavedExprPos As Int = ExprPos";
_savedexprpos = _exprpos;
 //BA.debugLineNum = 3378;BA.debugLine="Dim SavedExprError As Boolean = ExprError";
_savedexprerror = _exprerror;
 //BA.debugLineNum = 3379;BA.debugLine="Dim SavedExprErrorCode As Int = ExprErrorCode";
_savedexprerrorcode = _exprerrorcode;
 //BA.debugLineNum = 3382;BA.debugLine="Dim SavedVariables As Map";
_savedvariables = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 3383;BA.debugLine="SavedVariables.Initialize";
_savedvariables.Initialize();
 //BA.debugLineNum = 3385;BA.debugLine="Dim ExistingParameters As List";
_existingparameters = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 3386;BA.debugLine="ExistingParameters.Initialize";
_existingparameters.Initialize();
 //BA.debugLineNum = 3388;BA.debugLine="For Each Parameter As String In Parameters";
{
final anywheresoftware.b4a.BA.IterableList group20 = _parameters;
final int groupLen20 = group20.getSize()
;int index20 = 0;
;
for (; index20 < groupLen20;index20++){
_parameter = BA.ObjectToString(group20.Get(index20));
 //BA.debugLineNum = 3389;BA.debugLine="If Variables.ContainsKey(Parameter) Then";
if (_variables.ContainsKey((Object)(_parameter))) { 
 //BA.debugLineNum = 3390;BA.debugLine="ExistingParameters.Add(Parameter)";
_existingparameters.Add((Object)(_parameter));
 //BA.debugLineNum = 3391;BA.debugLine="SavedVariables.Put(Parameter, Variables.Get(Par";
_savedvariables.Put((Object)(_parameter),_variables.Get((Object)(_parameter)));
 };
 }
};
 //BA.debugLineNum = 3396;BA.debugLine="For i = 0 To Parameters.Size - 1";
{
final int step26 = 1;
final int limit26 = (int) (_parameters.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit26 ;_i = _i + step26 ) {
 //BA.debugLineNum = 3397;BA.debugLine="Dim Parameter As String = Parameters.Get(i)";
_parameter = BA.ObjectToString(_parameters.Get(_i));
 //BA.debugLineNum = 3398;BA.debugLine="Dim Argument As Double = Arguments.Get(i)";
_argument = (double)(BA.ObjectToNumber(_arguments.Get(_i)));
 //BA.debugLineNum = 3400;BA.debugLine="Variables.Put(Parameter, Utils.FormatNumber(Argu";
_variables.Put((Object)(_parameter),(Object)(_utils._formatnumber /*String*/ (_argument)));
 }
};
 //BA.debugLineNum = 3404;BA.debugLine="Dim Result As Double = EvaluateNumericExpression(";
_result = _evaluatenumericexpression(_functionexpression);
 //BA.debugLineNum = 3407;BA.debugLine="Dim FunctionError As Boolean = ExprError";
_functionerror = _exprerror;
 //BA.debugLineNum = 3408;BA.debugLine="Dim FunctionErrorCode As Int = ExprErrorCode";
_functionerrorcode = _exprerrorcode;
 //BA.debugLineNum = 3411;BA.debugLine="For Each Parameter As String In Parameters";
{
final anywheresoftware.b4a.BA.IterableList group34 = _parameters;
final int groupLen34 = group34.getSize()
;int index34 = 0;
;
for (; index34 < groupLen34;index34++){
_parameter = BA.ObjectToString(group34.Get(index34));
 //BA.debugLineNum = 3412;BA.debugLine="If ExistingParameters.IndexOf(Parameter) >= 0 Th";
if (_existingparameters.IndexOf((Object)(_parameter))>=0) { 
 //BA.debugLineNum = 3413;BA.debugLine="Variables.Put(Parameter, SavedVariables.Get(Par";
_variables.Put((Object)(_parameter),_savedvariables.Get((Object)(_parameter)));
 }else {
 //BA.debugLineNum = 3415;BA.debugLine="Variables.Remove(Parameter)";
_variables.Remove((Object)(_parameter));
 };
 }
};
 //BA.debugLineNum = 3420;BA.debugLine="ExprText = SavedExprText";
_exprtext = _savedexprtext;
 //BA.debugLineNum = 3421;BA.debugLine="ExprPos = SavedExprPos";
_exprpos = _savedexprpos;
 //BA.debugLineNum = 3422;BA.debugLine="ExprError = SavedExprError Or FunctionError";
_exprerror = _savedexprerror || _functionerror;
 //BA.debugLineNum = 3424;BA.debugLine="If FunctionError Then";
if (_functionerror) { 
 //BA.debugLineNum = 3425;BA.debugLine="ExprErrorCode = FunctionErrorCode";
_exprerrorcode = _functionerrorcode;
 }else {
 //BA.debugLineNum = 3427;BA.debugLine="ExprErrorCode = SavedExprErrorCode";
_exprerrorcode = _savedexprerrorcode;
 };
 //BA.debugLineNum = 3430;BA.debugLine="Return Result";
if (true) return _result;
 //BA.debugLineNum = 3432;BA.debugLine="End Sub";
return 0;
}
public boolean  _executeassign(String _linecode) throws Exception{
String _statement = "";
String _targettext = "";
String[] _targets = null;
String _target = "";
 //BA.debugLineNum = 3828;BA.debugLine="Private Sub ExecuteAssign(LineCode As String) As B";
 //BA.debugLineNum = 3830;BA.debugLine="Dim Statement As String = LineCode.Trim";
_statement = _linecode.trim();
 //BA.debugLineNum = 3832;BA.debugLine="If Statement.Length < 7 Then Return False";
if (_statement.length()<7) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3833;BA.debugLine="If Statement.SubString2(0, 6).ToUpperCase <> \"ASS";
if ((_statement.substring((int) (0),(int) (6)).toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale)).equals("ASSIGN") == false) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3835;BA.debugLine="Dim TargetText As String = Statement.SubString(6)";
_targettext = _statement.substring((int) (6)).trim().toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 3836;BA.debugLine="If TargetText = \"\" Then Return False";
if ((_targettext).equals("")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3838;BA.debugLine="Dim Targets() As String = Regex.Split(\",\", Target";
_targets = __c.Regex.Split(",",_targettext);
 //BA.debugLineNum = 3840;BA.debugLine="If Targets.Length <> 1 And Targets.Length <> 3 Th";
if (_targets.length!=1 && _targets.length!=3) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3842;BA.debugLine="For Each Target As String In Targets";
{
final String[] group8 = _targets;
final int groupLen8 = group8.length
;int index8 = 0;
;
for (; index8 < groupLen8;index8++){
_target = group8[index8];
 //BA.debugLineNum = 3843;BA.debugLine="If ValidateAssignTarget(Target.Trim) = False The";
if (_validateassigntarget(_target.trim())==__c.False) { 
if (true) return __c.False;};
 }
};
 //BA.debugLineNum = 3846;BA.debugLine="ExternalDataTarget = Targets(0).Trim";
_externaldatatarget = _targets[(int) (0)].trim();
 //BA.debugLineNum = 3848;BA.debugLine="If Targets.Length = 3 Then";
if (_targets.length==3) { 
 //BA.debugLineNum = 3849;BA.debugLine="ExternalDataTarget2 = Targets(1).Trim";
_externaldatatarget2 = _targets[(int) (1)].trim();
 //BA.debugLineNum = 3850;BA.debugLine="ExternalDataTarget3 = Targets(2).Trim";
_externaldatatarget3 = _targets[(int) (2)].trim();
 }else {
 //BA.debugLineNum = 3852;BA.debugLine="ExternalDataTarget2 = \"\"";
_externaldatatarget2 = "";
 //BA.debugLineNum = 3853;BA.debugLine="ExternalDataTarget3 = \"\"";
_externaldatatarget3 = "";
 };
 //BA.debugLineNum = 3856;BA.debugLine="WaitingForExternalData = True";
_waitingforexternaldata = __c.True;
 //BA.debugLineNum = 3858;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 3860;BA.debugLine="End Sub";
return false;
}
public String  _executecommand(String _command) throws Exception{
String _uppercommand = "";
int _spacepos = 0;
String _firsttoken = "";
double _linevalue = 0;
int _linenumber = 0;
String _linecode = "";
 //BA.debugLineNum = 233;BA.debugLine="Public Sub ExecuteCommand(Command As String)";
 //BA.debugLineNum = 234;BA.debugLine="Command = Command.Trim";
_command = _command.trim();
 //BA.debugLineNum = 236;BA.debugLine="If Command = \"\" Then Return";
if ((_command).equals("")) { 
if (true) return "";};
 //BA.debugLineNum = 238;BA.debugLine="Dim UpperCommand As String = Command.ToUpperCa";
_uppercommand = _command.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 241;BA.debugLine="Dim SpacePos As Int = Command.IndexOf(\" \")";
_spacepos = _command.indexOf(" ");
 //BA.debugLineNum = 243;BA.debugLine="If SpacePos > 0 Then";
if (_spacepos>0) { 
 //BA.debugLineNum = 244;BA.debugLine="Dim FirstToken As String = Command.SubStri";
_firsttoken = _command.substring((int) (0),_spacepos);
 //BA.debugLineNum = 246;BA.debugLine="If IsNumber(FirstToken) Then";
if (__c.IsNumber(_firsttoken)) { 
 //BA.debugLineNum = 248;BA.debugLine="Dim LineValue As Double = FirstToken";
_linevalue = (double)(Double.parseDouble(_firsttoken));
 //BA.debugLineNum = 250;BA.debugLine="If LineValue < 0 Or LineValue <> Floor(LineValu";
if (_linevalue<0 || _linevalue!=__c.Floor(_linevalue)) { 
 //BA.debugLineNum = 251;BA.debugLine="RaiseOutput(\"?INVALID LINE NUMBER\")";
_raiseoutput("?INVALID LINE NUMBER");
 //BA.debugLineNum = 252;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 255;BA.debugLine="Dim LineNumber As Int = LineValue";
_linenumber = (int) (_linevalue);
 //BA.debugLineNum = 257;BA.debugLine="Dim LineCode As String = Command.SubSt";
_linecode = _command.substring((int) (_spacepos+1)).trim();
 //BA.debugLineNum = 259;BA.debugLine="If LineCode = \"\" Then";
if ((_linecode).equals("")) { 
 //BA.debugLineNum = 260;BA.debugLine="ProgramLines.Remove(LineNumber)";
_programlines.Remove((Object)(_linenumber));
 }else {
 //BA.debugLineNum = 262;BA.debugLine="ProgramLines.Put(LineNumber, LineC";
_programlines.Put((Object)(_linenumber),(Object)(_linecode));
 //BA.debugLineNum = 263;BA.debugLine="RaiseOutput(\"STORED: \" & LineNumbe";
_raiseoutput("STORED: "+BA.NumberToString(_linenumber)+" = "+_linecode);
 };
 //BA.debugLineNum = 266;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 270;BA.debugLine="Select Case UpperCommand";
switch (BA.switchObjectToInt(_uppercommand,"HELP","RUN","BREAK","LIST","RENUM")) {
case 0: {
 //BA.debugLineNum = 272;BA.debugLine="ExecuteHelp";
_executehelp();
 break; }
case 1: {
 //BA.debugLineNum = 275;BA.debugLine="RunProgram";
_runprogram();
 break; }
case 2: {
 //BA.debugLineNum = 278;BA.debugLine="WaitingForExternalData = False";
_waitingforexternaldata = __c.False;
 //BA.debugLineNum = 279;BA.debugLine="ExternalDataTarget = \"\"";
_externaldatatarget = "";
 //BA.debugLineNum = 280;BA.debugLine="ExternalDataTarget2 = \"\"";
_externaldatatarget2 = "";
 //BA.debugLineNum = 281;BA.debugLine="ExternalDataTarget3 = \"\"";
_externaldatatarget3 = "";
 //BA.debugLineNum = 282;BA.debugLine="RunPosition = RunLines.Size";
_runposition = _runlines.getSize();
 //BA.debugLineNum = 283;BA.debugLine="WaitingForDelay = False";
_waitingfordelay = __c.False;
 //BA.debugLineNum = 284;BA.debugLine="WaitingForHardwareCommand = False";
_waitingforhardwarecommand = __c.False;
 //BA.debugLineNum = 285;BA.debugLine="RaiseOutput(\"BREAK\")";
_raiseoutput("BREAK");
 //BA.debugLineNum = 286;BA.debugLine="RaiseOutput(\"READY.\")";
_raiseoutput("READY.");
 break; }
case 3: {
 //BA.debugLineNum = 289;BA.debugLine="ListProgram(0, -1)";
_listprogram((int) (0),(int) (-1));
 break; }
case 4: {
 //BA.debugLineNum = 292;BA.debugLine="ExecuteRenumber(10, 10)";
_executerenumber((int) (10),(int) (10));
 break; }
default: {
 //BA.debugLineNum = 295;BA.debugLine="If UpperCommand.StartsWith(\"RENUM \") Then";
if (_uppercommand.startsWith("RENUM ")) { 
 //BA.debugLineNum = 296;BA.debugLine="ExecuteRenumberCommand(Command)";
_executerenumbercommand(_command);
 }else if(_uppercommand.startsWith("LIST ")) { 
 //BA.debugLineNum = 298;BA.debugLine="ExecuteList(Command)";
_executelist(_command);
 }else if((_uppercommand).equals("PRINT") || _uppercommand.startsWith("PRINT ")) { 
 //BA.debugLineNum = 300;BA.debugLine="PrintBasicText(Command)";
_printbasictext(_command);
 }else {
 //BA.debugLineNum = 302;BA.debugLine="RaiseOutput(\"?SYNTAX ERROR\")";
_raiseoutput("?SYNTAX ERROR");
 };
 break; }
}
;
 //BA.debugLineNum = 306;BA.debugLine="If UpperCommand <> \"RUN\" Then RaiseReady";
if ((_uppercommand).equals("RUN") == false) { 
_raiseready();};
 //BA.debugLineNum = 307;BA.debugLine="End Sub";
return "";
}
public boolean  _executedeffn(String _linecode) throws Exception{
String _statement = "";
String _definitiontext = "";
int _openpos = 0;
int _closepos = 0;
int _equalpos = 0;
String _functionname = "";
String _parametertext = "";
String _checkparametertext = "";
anywheresoftware.b4a.objects.collections.List _parameters = null;
String[] _parameteritems = null;
String _item = "";
String _parameter = "";
String _functionexpression = "";
anywheresoftware.b4a.objects.collections.Map _functiondefinition = null;
 //BA.debugLineNum = 3288;BA.debugLine="Private Sub ExecuteDefFn(LineCode As String) As Bo";
 //BA.debugLineNum = 3290;BA.debugLine="Dim Statement As String = LineCode.Trim";
_statement = _linecode.trim();
 //BA.debugLineNum = 3292;BA.debugLine="If Statement.ToUpperCase.StartsWith(\"DEF FN \") =";
if (_statement.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale).startsWith("DEF FN ")==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3294;BA.debugLine="Dim DefinitionText As String = Statement.SubStrin";
_definitiontext = _statement.substring((int) (7)).trim();
 //BA.debugLineNum = 3296;BA.debugLine="Dim OpenPos As Int = DefinitionText.IndexOf(\"(\")";
_openpos = _definitiontext.indexOf("(");
 //BA.debugLineNum = 3297;BA.debugLine="Dim ClosePos As Int = DefinitionText.IndexOf(\")\")";
_closepos = _definitiontext.indexOf(")");
 //BA.debugLineNum = 3298;BA.debugLine="Dim EqualPos As Int = DefinitionText.IndexOf(\"=\")";
_equalpos = _definitiontext.indexOf("=");
 //BA.debugLineNum = 3301;BA.debugLine="If OpenPos <= 0 Or ClosePos <= OpenPos Or EqualPo";
if (_openpos<=0 || _closepos<=_openpos || _equalpos<=_closepos) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3304;BA.debugLine="Dim FunctionName As String = DefinitionText.SubSt";
_functionname = _definitiontext.substring((int) (0),_openpos).trim().toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 3306;BA.debugLine="If IsValidVariable(FunctionName) = False Or Funct";
if (_isvalidvariable(_functionname)==__c.False || _functionname.endsWith("$")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3309;BA.debugLine="Dim ParameterText As String = DefinitionText.SubS";
_parametertext = _definitiontext.substring((int) (_openpos+1),_closepos).trim();
 //BA.debugLineNum = 3311;BA.debugLine="If ParameterText = \"\" Then Return False";
if ((_parametertext).equals("")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3314;BA.debugLine="Dim CheckParameterText As String = ParameterText.";
_checkparametertext = _parametertext.replace(" ","").replace(BA.ObjectToString(__c.Chr((int) (9))),"");
 //BA.debugLineNum = 3316;BA.debugLine="If CheckParameterText.StartsWith(\",\") Or _     Ch";
if (_checkparametertext.startsWith(",") || _checkparametertext.endsWith(",") || _checkparametertext.contains(",,")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3320;BA.debugLine="Dim Parameters As List";
_parameters = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 3321;BA.debugLine="Parameters.Initialize";
_parameters.Initialize();
 //BA.debugLineNum = 3323;BA.debugLine="Dim ParameterItems() As String = Regex.Split(\",\",";
_parameteritems = __c.Regex.Split(",",_parametertext);
 //BA.debugLineNum = 3325;BA.debugLine="For Each Item As String In ParameterItems";
{
final String[] group17 = _parameteritems;
final int groupLen17 = group17.length
;int index17 = 0;
;
for (; index17 < groupLen17;index17++){
_item = group17[index17];
 //BA.debugLineNum = 3327;BA.debugLine="Dim Parameter As String = Item.Trim.ToUpperCase";
_parameter = _item.trim().toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 3329;BA.debugLine="If IsValidVariable(Parameter) = False Or Paramet";
if (_isvalidvariable(_parameter)==__c.False || _parameter.endsWith("$")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3331;BA.debugLine="If Parameters.IndexOf(Parameter) >= 0 Then Retur";
if (_parameters.IndexOf((Object)(_parameter))>=0) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3333;BA.debugLine="Parameters.Add(Parameter)";
_parameters.Add((Object)(_parameter));
 }
};
 //BA.debugLineNum = 3338;BA.debugLine="If DefinitionText.SubString2(ClosePos + 1, EqualP";
if ((_definitiontext.substring((int) (_closepos+1),_equalpos).trim()).equals("") == false) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3341;BA.debugLine="Dim FunctionExpression As String = DefinitionText";
_functionexpression = _definitiontext.substring((int) (_equalpos+1)).trim();
 //BA.debugLineNum = 3343;BA.debugLine="If FunctionExpression = \"\" Then Return False";
if ((_functionexpression).equals("")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3346;BA.debugLine="Dim FunctionDefinition As Map";
_functiondefinition = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 3347;BA.debugLine="FunctionDefinition.Initialize";
_functiondefinition.Initialize();
 //BA.debugLineNum = 3348;BA.debugLine="FunctionDefinition.Put(\"Parameters\", Parameters)";
_functiondefinition.Put((Object)("Parameters"),(Object)(_parameters.getObject()));
 //BA.debugLineNum = 3349;BA.debugLine="FunctionDefinition.Put(\"Expression\", FunctionExpr";
_functiondefinition.Put((Object)("Expression"),(Object)(_functionexpression));
 //BA.debugLineNum = 3351;BA.debugLine="Functions.Put(FunctionName, FunctionDefinition)";
_functions.Put((Object)(_functionname),(Object)(_functiondefinition.getObject()));
 //BA.debugLineNum = 3353;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 3355;BA.debugLine="End Sub";
return false;
}
public boolean  _executedelay(String _linecode) throws Exception{
String[] _parts = null;
double _delayvalue = 0;
 //BA.debugLineNum = 3216;BA.debugLine="Private Sub ExecuteDelay(LineCode As String) As Bo";
 //BA.debugLineNum = 3218;BA.debugLine="Dim Parts() As String = Regex.Split(\" \", LineC";
_parts = __c.Regex.Split(" ",_linecode.trim());
 //BA.debugLineNum = 3220;BA.debugLine="If Parts.Length <> 2 Then Return False";
if (_parts.length!=2) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3221;BA.debugLine="If Parts(0).ToUpperCase <> \"@DELAY\" Then Retur";
if ((_parts[(int) (0)].toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale)).equals("@DELAY") == false) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3222;BA.debugLine="If IsNumber(Parts(1)) = False Then Return Fals";
if (__c.IsNumber(_parts[(int) (1)])==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3224;BA.debugLine="Dim DelayValue As Double = Parts(1)";
_delayvalue = (double)(Double.parseDouble(_parts[(int) (1)]));
 //BA.debugLineNum = 3226;BA.debugLine="If DelayValue < 1 Or DelayValue <> Floor(Delay";
if (_delayvalue<1 || _delayvalue!=__c.Floor(_delayvalue)) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3228;BA.debugLine="DelayMilliseconds = DelayValue";
_delaymilliseconds = (int) (_delayvalue);
 //BA.debugLineNum = 3230;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 3231;BA.debugLine="End Sub";
return false;
}
public boolean  _executedim(String _linecode) throws Exception{
String _statement = "";
String _declaration = "";
int _openpos = 0;
int _closepos = 0;
String _arrayname = "";
String _sizetext = "";
int _arraysize = 0;
anywheresoftware.b4a.objects.collections.List _values = null;
int _i = 0;
 //BA.debugLineNum = 3436;BA.debugLine="Private Sub ExecuteDim(LineCode As String) As Bool";
 //BA.debugLineNum = 3438;BA.debugLine="Dim Statement As String = LineCode.Trim.ToUpperCa";
_statement = _linecode.trim().toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 3440;BA.debugLine="If Statement.StartsWith(\"DIM \") = False Then Retu";
if (_statement.startsWith("DIM ")==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3442;BA.debugLine="Dim Declaration As String = Statement.SubString(4";
_declaration = _statement.substring((int) (4)).trim();
 //BA.debugLineNum = 3444;BA.debugLine="Dim OpenPos As Int = Declaration.IndexOf(\"(\")";
_openpos = _declaration.indexOf("(");
 //BA.debugLineNum = 3445;BA.debugLine="Dim ClosePos As Int = Declaration.IndexOf(\")\")";
_closepos = _declaration.indexOf(")");
 //BA.debugLineNum = 3447;BA.debugLine="If OpenPos <= 0 Or ClosePos <= OpenPos Then Retur";
if (_openpos<=0 || _closepos<=_openpos) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3449;BA.debugLine="Dim ArrayName As String = Declaration.SubString2(";
_arrayname = _declaration.substring((int) (0),_openpos).trim();
 //BA.debugLineNum = 3450;BA.debugLine="Dim SizeText As String = Declaration.SubString2(O";
_sizetext = _declaration.substring((int) (_openpos+1),_closepos).trim();
 //BA.debugLineNum = 3457;BA.debugLine="If IsValidVariable(ArrayName) = False Then Return";
if (_isvalidvariable(_arrayname)==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3458;BA.debugLine="If ArrayName.EndsWith(\"$\") Then Return False";
if (_arrayname.endsWith("$")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3461;BA.debugLine="If Arrays.ContainsKey(ArrayName) Then Return Fals";
if (_arrays.ContainsKey((Object)(_arrayname))) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3464;BA.debugLine="If IsNumber(SizeText) = False Then Return False";
if (__c.IsNumber(_sizetext)==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3466;BA.debugLine="Dim ArraySize As Int = SizeText";
_arraysize = (int)(Double.parseDouble(_sizetext));
 //BA.debugLineNum = 3468;BA.debugLine="If ArraySize <= 0 Then Return False";
if (_arraysize<=0) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3471;BA.debugLine="Dim Values As List";
_values = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 3472;BA.debugLine="Values.Initialize";
_values.Initialize();
 //BA.debugLineNum = 3474;BA.debugLine="For i = 1 To ArraySize";
{
final int step17 = 1;
final int limit17 = _arraysize;
_i = (int) (1) ;
for (;_i <= limit17 ;_i = _i + step17 ) {
 //BA.debugLineNum = 3475;BA.debugLine="Values.Add(0)";
_values.Add((Object)(0));
 }
};
 //BA.debugLineNum = 3480;BA.debugLine="Arrays.Put(ArrayName, Values)";
_arrays.Put((Object)(_arrayname),(Object)(_values.getObject()));
 //BA.debugLineNum = 3483;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 3485;BA.debugLine="End Sub";
return false;
}
public boolean  _executeerase(String _linecode) throws Exception{
String _statement = "";
String _arrayname = "";
 //BA.debugLineNum = 3488;BA.debugLine="Private Sub ExecuteErase(LineCode As String) As Bo";
 //BA.debugLineNum = 3490;BA.debugLine="Dim Statement As String = LineCode.Trim.ToUpperCa";
_statement = _linecode.trim().toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 3492;BA.debugLine="If Statement.StartsWith(\"ERASE \") = False Then Re";
if (_statement.startsWith("ERASE ")==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3494;BA.debugLine="Dim ArrayName As String = Statement.SubString(6).";
_arrayname = _statement.substring((int) (6)).trim();
 //BA.debugLineNum = 3497;BA.debugLine="If IsValidVariable(ArrayName) = False Then Return";
if (_isvalidvariable(_arrayname)==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3498;BA.debugLine="If ArrayName.EndsWith(\"$\") Then Return False";
if (_arrayname.endsWith("$")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3501;BA.debugLine="If Arrays.ContainsKey(ArrayName) = False Then Ret";
if (_arrays.ContainsKey((Object)(_arrayname))==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3504;BA.debugLine="Arrays.Remove(ArrayName)";
_arrays.Remove((Object)(_arrayname));
 //BA.debugLineNum = 3506;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 3508;BA.debugLine="End Sub";
return false;
}
public boolean  _executefor(String _linecode,int _bodyposition) throws Exception{
String _upperline = "";
int _equalpos = 0;
int _topos = 0;
int _steppos = 0;
String _variablename = "";
String _startexpression = "";
String _limitexpression = "";
String _stepexpression = "";
double _startvalue = 0;
double _limitvalue = 0;
double _stepvalue = 0;
int _nextposition = 0;
anywheresoftware.b4a.objects.collections.Map _loopdata = null;
int _matchingnextposition = 0;
 //BA.debugLineNum = 1960;BA.debugLine="Private Sub ExecuteFor(LineCode As String, BodyPos";
 //BA.debugLineNum = 1962;BA.debugLine="ExprError = False";
_exprerror = __c.False;
 //BA.debugLineNum = 1963;BA.debugLine="ExprErrorCode = 0";
_exprerrorcode = (int) (0);
 //BA.debugLineNum = 1965;BA.debugLine="Dim UpperLine As String = LineCode.ToUpperCase.Tr";
_upperline = _linecode.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale).trim();
 //BA.debugLineNum = 1967;BA.debugLine="Dim EqualPos As Int = UpperLine.IndexOf(\"=\")";
_equalpos = _upperline.indexOf("=");
 //BA.debugLineNum = 1968;BA.debugLine="Dim ToPos As Int = UpperLine.IndexOf(\" TO \")";
_topos = _upperline.indexOf(" TO ");
 //BA.debugLineNum = 1969;BA.debugLine="Dim StepPos As Int = UpperLine.IndexOf(\" STEP \")";
_steppos = _upperline.indexOf(" STEP ");
 //BA.debugLineNum = 1971;BA.debugLine="If EqualPos < 0 Or ToPos < 0 Or ToPos < EqualPos";
if (_equalpos<0 || _topos<0 || _topos<_equalpos) { 
if (true) return __c.False;};
 //BA.debugLineNum = 1973;BA.debugLine="Dim VariableName As String = UpperLine.SubString2";
_variablename = _upperline.substring((int) (4),_equalpos).trim();
 //BA.debugLineNum = 1976;BA.debugLine="If VariableName.Length <> 1 Then Return False";
if (_variablename.length()!=1) { 
if (true) return __c.False;};
 //BA.debugLineNum = 1978;BA.debugLine="If VariableName.CompareTo(\"A\") < 0 Or VariableNam";
if (_variablename.compareTo("A")<0 || _variablename.compareTo("Z")>0) { 
if (true) return __c.False;};
 //BA.debugLineNum = 1980;BA.debugLine="Dim StartExpression As String = LineCode.SubStrin";
_startexpression = _linecode.substring((int) (_equalpos+1),_topos).trim();
 //BA.debugLineNum = 1982;BA.debugLine="Dim LimitExpression As String";
_limitexpression = "";
 //BA.debugLineNum = 1984;BA.debugLine="If StepPos >= 0 Then";
if (_steppos>=0) { 
 //BA.debugLineNum = 1985;BA.debugLine="LimitExpression = LineCode.SubString2(ToPos + 4,";
_limitexpression = _linecode.substring((int) (_topos+4),_steppos).trim();
 }else {
 //BA.debugLineNum = 1987;BA.debugLine="LimitExpression = LineCode.SubString(ToPos + 4).";
_limitexpression = _linecode.substring((int) (_topos+4)).trim();
 };
 //BA.debugLineNum = 1990;BA.debugLine="Dim StepExpression As String = \"1\"";
_stepexpression = "1";
 //BA.debugLineNum = 1992;BA.debugLine="If StepPos >= 0 Then";
if (_steppos>=0) { 
 //BA.debugLineNum = 1993;BA.debugLine="StepExpression = LineCode.SubString(StepPos + 6)";
_stepexpression = _linecode.substring((int) (_steppos+6)).trim();
 };
 //BA.debugLineNum = 1996;BA.debugLine="If StartExpression = \"\" Or LimitExpression = \"\" O";
if ((_startexpression).equals("") || (_limitexpression).equals("") || (_stepexpression).equals("")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 1999;BA.debugLine="Dim StartValue As Double = EvaluateNumericExpress";
_startvalue = _evaluatenumericexpression(_startexpression);
 //BA.debugLineNum = 2000;BA.debugLine="If ExprError Then Return False";
if (_exprerror) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2003;BA.debugLine="Dim LimitValue As Double = EvaluateNumericExpress";
_limitvalue = _evaluatenumericexpression(_limitexpression);
 //BA.debugLineNum = 2004;BA.debugLine="If ExprError Then Return False";
if (_exprerror) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2007;BA.debugLine="Dim StepValue As Double = EvaluateNumericExpressi";
_stepvalue = _evaluatenumericexpression(_stepexpression);
 //BA.debugLineNum = 2008;BA.debugLine="If ExprError Then Return False";
if (_exprerror) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2011;BA.debugLine="If StepValue = 0 Then";
if (_stepvalue==0) { 
 //BA.debugLineNum = 2012;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 2013;BA.debugLine="ExprErrorCode = 20";
_exprerrorcode = (int) (20);
 //BA.debugLineNum = 2014;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 2017;BA.debugLine="Variables.Put(VariableName, Utils.FormatNumber(St";
_variables.Put((Object)(_variablename),(Object)(_utils._formatnumber /*String*/ (_startvalue)));
 //BA.debugLineNum = 2020;BA.debugLine="If (StepValue > 0 And StartValue > LimitValue) Or";
if ((_stepvalue>0 && _startvalue>_limitvalue) || (_stepvalue<0 && _startvalue<_limitvalue)) { 
 //BA.debugLineNum = 2023;BA.debugLine="Dim NextPosition As Int = FindNextPosition(Varia";
_nextposition = _findnextposition(_variablename);
 //BA.debugLineNum = 2025;BA.debugLine="If NextPosition < 0 Then Return False";
if (_nextposition<0) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2027;BA.debugLine="RunPosition = NextPosition";
_runposition = _nextposition;
 //BA.debugLineNum = 2028;BA.debugLine="Return True";
if (true) return __c.True;
 };
 //BA.debugLineNum = 2031;BA.debugLine="Dim LoopData As Map";
_loopdata = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 2032;BA.debugLine="LoopData.Initialize";
_loopdata.Initialize();
 //BA.debugLineNum = 2033;BA.debugLine="Dim MatchingNextPosition As Int = FindMatchingNex";
_matchingnextposition = _findmatchingnextposition(_variablename);
 //BA.debugLineNum = 2035;BA.debugLine="If MatchingNextPosition < 0 Then Return False";
if (_matchingnextposition<0) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2037;BA.debugLine="LoopData.Put(\"Variable\", VariableName)";
_loopdata.Put((Object)("Variable"),(Object)(_variablename));
 //BA.debugLineNum = 2038;BA.debugLine="LoopData.Put(\"Limit\", LimitValue)";
_loopdata.Put((Object)("Limit"),(Object)(_limitvalue));
 //BA.debugLineNum = 2039;BA.debugLine="LoopData.Put(\"Step\", StepValue)";
_loopdata.Put((Object)("Step"),(Object)(_stepvalue));
 //BA.debugLineNum = 2040;BA.debugLine="LoopData.Put(\"BodyPosition\", BodyPosition)";
_loopdata.Put((Object)("BodyPosition"),(Object)(_bodyposition));
 //BA.debugLineNum = 2041;BA.debugLine="LoopData.Put(\"NextPosition\", MatchingNextPosition";
_loopdata.Put((Object)("NextPosition"),(Object)(_matchingnextposition));
 //BA.debugLineNum = 2042;BA.debugLine="ForStack.Add(LoopData)";
_forstack.Add((Object)(_loopdata.getObject()));
 //BA.debugLineNum = 2044;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 2046;BA.debugLine="End Sub";
return false;
}
public String  _executehelp() throws Exception{
 //BA.debugLineNum = 3276;BA.debugLine="Public Sub ExecuteHelp";
 //BA.debugLineNum = 3277;BA.debugLine="RaiseOutput(B58Help.HelpText)";
_raiseoutput(_b58help._helptext /*String*/ );
 //BA.debugLineNum = 3278;BA.debugLine="End Sub";
return "";
}
public boolean  _executeinput(String _linecode) throws Exception{
String _value = "";
String _quotes = "";
int _quoteend = 0;
int _i = 0;
anywheresoftware.b4a.keywords.StringBuilderWrapper _currentvariable = null;
String _currentchar = "";
 //BA.debugLineNum = 2234;BA.debugLine="Private Sub ExecuteInput(LineCode As String) As Bo";
 //BA.debugLineNum = 2235;BA.debugLine="Dim Value As String = LineCode.SubString(6).Trim";
_value = _linecode.substring((int) (6)).trim();
 //BA.debugLineNum = 2236;BA.debugLine="Dim QUOTES As String = Chr(34)";
_quotes = BA.ObjectToString(__c.Chr((int) (34)));
 //BA.debugLineNum = 2238;BA.debugLine="InputPrompt = \"\"";
_inputprompt = "";
 //BA.debugLineNum = 2241;BA.debugLine="If Value.StartsWith(QUOTES) Then";
if (_value.startsWith(_quotes)) { 
 //BA.debugLineNum = 2242;BA.debugLine="Dim QuoteEnd As Int = -1";
_quoteend = (int) (-1);
 //BA.debugLineNum = 2244;BA.debugLine="For i = 1 To Value.Length - 1";
{
final int step6 = 1;
final int limit6 = (int) (_value.length()-1);
_i = (int) (1) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
 //BA.debugLineNum = 2245;BA.debugLine="If Value.SubString2(i, i + 1) = QUOTES Then";
if ((_value.substring(_i,(int) (_i+1))).equals(_quotes)) { 
 //BA.debugLineNum = 2246;BA.debugLine="QuoteEnd = i";
_quoteend = _i;
 //BA.debugLineNum = 2247;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 2251;BA.debugLine="If QuoteEnd < 0 Then Return False";
if (_quoteend<0) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2253;BA.debugLine="InputPrompt = Value.SubString2(1, QuoteEnd)";
_inputprompt = _value.substring((int) (1),_quoteend);
 //BA.debugLineNum = 2255;BA.debugLine="Value = Value.SubString(QuoteEnd + 1).Trim";
_value = _value.substring((int) (_quoteend+1)).trim();
 //BA.debugLineNum = 2257;BA.debugLine="If Value.StartsWith(\";\") = False Then Return Fal";
if (_value.startsWith(";")==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2259;BA.debugLine="Value = Value.SubString(1).Trim";
_value = _value.substring((int) (1)).trim();
 };
 //BA.debugLineNum = 2262;BA.debugLine="If Value = \"\" Then Return False";
if ((_value).equals("")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2265;BA.debugLine="InputVariables.Initialize";
_inputvariables.Initialize();
 //BA.debugLineNum = 2267;BA.debugLine="Dim CurrentVariable As StringBuilder";
_currentvariable = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 2268;BA.debugLine="CurrentVariable.Initialize";
_currentvariable.Initialize();
 //BA.debugLineNum = 2270;BA.debugLine="For i = 0 To Value.Length - 1";
{
final int step22 = 1;
final int limit22 = (int) (_value.length()-1);
_i = (int) (0) ;
for (;_i <= limit22 ;_i = _i + step22 ) {
 //BA.debugLineNum = 2271;BA.debugLine="Dim CurrentChar As String = Value.SubString2(i,";
_currentchar = _value.substring(_i,(int) (_i+1));
 //BA.debugLineNum = 2273;BA.debugLine="If CurrentChar = \",\" Then";
if ((_currentchar).equals(",")) { 
 //BA.debugLineNum = 2274;BA.debugLine="If AddInputVariable(CurrentVariable.ToString.Tr";
if (_addinputvariable(_currentvariable.ToString().trim())==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2275;BA.debugLine="CurrentVariable.Initialize";
_currentvariable.Initialize();
 }else {
 //BA.debugLineNum = 2277;BA.debugLine="CurrentVariable.Append(CurrentChar)";
_currentvariable.Append(_currentchar);
 };
 }
};
 //BA.debugLineNum = 2281;BA.debugLine="If AddInputVariable(CurrentVariable.ToString.Trim";
if (_addinputvariable(_currentvariable.ToString().trim())==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2284;BA.debugLine="RaiseOutput(InputPrompt & \"?\")";
_raiseoutput(_inputprompt+"?");
 //BA.debugLineNum = 2286;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 2287;BA.debugLine="End Sub";
return false;
}
public boolean  _executelet(String _linecode) throws Exception{
String _statement = "";
String _assignment = "";
int _equalpos = 0;
String _variablename = "";
String _expression = "";
int _openpos = 0;
int _closepos = 0;
String _arrayname = "";
String _indextext = "";
double _indexvalue = 0;
int _arrayindex = 0;
anywheresoftware.b4a.objects.collections.List _values = null;
double _result = 0;
String _stringvalue = "";
 //BA.debugLineNum = 431;BA.debugLine="Private Sub ExecuteLet(LineCode As String) As Bool";
 //BA.debugLineNum = 432;BA.debugLine="ExprError = False";
_exprerror = __c.False;
 //BA.debugLineNum = 433;BA.debugLine="ExprErrorCode = 0";
_exprerrorcode = (int) (0);
 //BA.debugLineNum = 435;BA.debugLine="Dim Statement As String = LineCode.Trim";
_statement = _linecode.trim();
 //BA.debugLineNum = 437;BA.debugLine="If Statement.Length < 4 Then Return False";
if (_statement.length()<4) { 
if (true) return __c.False;};
 //BA.debugLineNum = 439;BA.debugLine="If Statement.SubString2(0, 3).ToUpperCase <> \"LET";
if ((_statement.substring((int) (0),(int) (3)).toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale)).equals("LET") == false) { 
if (true) return __c.False;};
 //BA.debugLineNum = 442;BA.debugLine="Dim Assignment As String = Statement.SubString(3)";
_assignment = _statement.substring((int) (3)).trim();
 //BA.debugLineNum = 444;BA.debugLine="Dim EqualPos As Int = Assignment.IndexOf(\"=\")";
_equalpos = _assignment.indexOf("=");
 //BA.debugLineNum = 446;BA.debugLine="If EqualPos <= 0 Then Return False";
if (_equalpos<=0) { 
if (true) return __c.False;};
 //BA.debugLineNum = 448;BA.debugLine="Dim VariableName As String = Assignment.SubString";
_variablename = _assignment.substring((int) (0),_equalpos).trim().toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 449;BA.debugLine="Dim Expression As String = Assignment.SubString(E";
_expression = _assignment.substring((int) (_equalpos+1)).trim();
 //BA.debugLineNum = 451;BA.debugLine="If Expression = \"\" Then Return False";
if ((_expression).equals("")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 454;BA.debugLine="Dim OpenPos As Int = VariableName.IndexOf(\"(\")";
_openpos = _variablename.indexOf("(");
 //BA.debugLineNum = 455;BA.debugLine="Dim ClosePos As Int = VariableName.IndexOf(\")\")";
_closepos = _variablename.indexOf(")");
 //BA.debugLineNum = 457;BA.debugLine="If OpenPos > 0 And ClosePos > OpenPos Then";
if (_openpos>0 && _closepos>_openpos) { 
 //BA.debugLineNum = 459;BA.debugLine="Dim ArrayName As String = VariableName.SubString";
_arrayname = _variablename.substring((int) (0),_openpos).trim();
 //BA.debugLineNum = 460;BA.debugLine="Dim IndexText As String = VariableName.SubString";
_indextext = _variablename.substring((int) (_openpos+1),_closepos).trim();
 //BA.debugLineNum = 462;BA.debugLine="If IsValidVariable(ArrayName) = False Then Retur";
if (_isvalidvariable(_arrayname)==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 463;BA.debugLine="If Arrays.ContainsKey(ArrayName) = False Then Re";
if (_arrays.ContainsKey((Object)(_arrayname))==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 465;BA.debugLine="Dim IndexValue As Double = EvaluateNumericExpres";
_indexvalue = _evaluatenumericexpression(_indextext);
 //BA.debugLineNum = 467;BA.debugLine="If ExprError Then Return False";
if (_exprerror) { 
if (true) return __c.False;};
 //BA.debugLineNum = 469;BA.debugLine="If IndexValue < 1 Or IndexValue <> Floor(IndexVa";
if (_indexvalue<1 || _indexvalue!=__c.Floor(_indexvalue)) { 
if (true) return __c.False;};
 //BA.debugLineNum = 471;BA.debugLine="Dim ArrayIndex As Int = IndexValue";
_arrayindex = (int) (_indexvalue);
 //BA.debugLineNum = 472;BA.debugLine="Dim Values As List = Arrays.Get(ArrayName)";
_values = new anywheresoftware.b4a.objects.collections.List();
_values = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_arrays.Get((Object)(_arrayname))));
 //BA.debugLineNum = 474;BA.debugLine="If ArrayIndex > Values.Size Then Return False";
if (_arrayindex>_values.getSize()) { 
if (true) return __c.False;};
 //BA.debugLineNum = 476;BA.debugLine="Dim Result As Double = EvaluateNumericExpression";
_result = _evaluatenumericexpression(_expression);
 //BA.debugLineNum = 478;BA.debugLine="If ExprError Then Return False";
if (_exprerror) { 
if (true) return __c.False;};
 //BA.debugLineNum = 480;BA.debugLine="Values.Set(ArrayIndex - 1, Utils.FormatNumber(Re";
_values.Set((int) (_arrayindex-1),(Object)(_utils._formatnumber /*String*/ (_result)));
 //BA.debugLineNum = 482;BA.debugLine="Return True";
if (true) return __c.True;
 };
 //BA.debugLineNum = 486;BA.debugLine="If IsValidVariable(VariableName) = False Then Ret";
if (_isvalidvariable(_variablename)==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 489;BA.debugLine="If VariableName.EndsWith(\"$\") Then";
if (_variablename.endsWith("$")) { 
 //BA.debugLineNum = 490;BA.debugLine="Dim StringValue As String = EvaluateStringExpres";
_stringvalue = _evaluatestringexpression(_expression);
 //BA.debugLineNum = 492;BA.debugLine="If ExprError Then";
if (_exprerror) { 
 //BA.debugLineNum = 493;BA.debugLine="If ExprErrorCode = 0 Then ExprErrorCode = 20";
if (_exprerrorcode==0) { 
_exprerrorcode = (int) (20);};
 //BA.debugLineNum = 494;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 497;BA.debugLine="Variables.Put(VariableName, StringValue)";
_variables.Put((Object)(_variablename),(Object)(_stringvalue));
 //BA.debugLineNum = 498;BA.debugLine="Return True";
if (true) return __c.True;
 };
 //BA.debugLineNum = 502;BA.debugLine="Dim Result As Double = EvaluateNumericExpression(";
_result = _evaluatenumericexpression(_expression);
 //BA.debugLineNum = 504;BA.debugLine="If ExprError Then Return False";
if (_exprerror) { 
if (true) return __c.False;};
 //BA.debugLineNum = 506;BA.debugLine="Variables.Put(VariableName, Utils.FormatNumber(Re";
_variables.Put((Object)(_variablename),(Object)(_utils._formatnumber /*String*/ (_result)));
 //BA.debugLineNum = 508;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 509;BA.debugLine="End Sub";
return false;
}
public String  _executelist(String _command) throws Exception{
String _arguments = "";
int _startline = 0;
int _endline = 0;
int _commapos = 0;
String _starttext = "";
String _endtext = "";
double _startvalue = 0;
double _endvalue = 0;
 //BA.debugLineNum = 3083;BA.debugLine="Private Sub ExecuteList(Command As String)";
 //BA.debugLineNum = 3085;BA.debugLine="Dim Arguments As String = Command.SubString(4).Tr";
_arguments = _command.substring((int) (4)).trim();
 //BA.debugLineNum = 3087;BA.debugLine="Dim StartLine As Int";
_startline = 0;
 //BA.debugLineNum = 3088;BA.debugLine="Dim EndLine As Int = -1";
_endline = (int) (-1);
 //BA.debugLineNum = 3090;BA.debugLine="Dim CommaPos As Int = Arguments.IndexOf(\",\")";
_commapos = _arguments.indexOf(",");
 //BA.debugLineNum = 3092;BA.debugLine="If CommaPos >= 0 Then";
if (_commapos>=0) { 
 //BA.debugLineNum = 3094;BA.debugLine="Dim StartText As String = Arguments.SubString2(0";
_starttext = _arguments.substring((int) (0),_commapos).trim();
 //BA.debugLineNum = 3095;BA.debugLine="Dim EndText As String = Arguments.SubString(Comm";
_endtext = _arguments.substring((int) (_commapos+1)).trim();
 //BA.debugLineNum = 3097;BA.debugLine="If StartText = \"\" Or EndText = \"\" Then";
if ((_starttext).equals("") || (_endtext).equals("")) { 
 //BA.debugLineNum = 3098;BA.debugLine="RaiseOutput(\"?SYNTAX ERROR\")";
_raiseoutput("?SYNTAX ERROR");
 //BA.debugLineNum = 3099;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 3102;BA.debugLine="If IsNumber(StartText) = False Or IsNumber(EndTe";
if (__c.IsNumber(_starttext)==__c.False || __c.IsNumber(_endtext)==__c.False) { 
 //BA.debugLineNum = 3103;BA.debugLine="RaiseOutput(\"?SYNTAX ERROR\")";
_raiseoutput("?SYNTAX ERROR");
 //BA.debugLineNum = 3104;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 3107;BA.debugLine="Dim StartValue As Double = StartText";
_startvalue = (double)(Double.parseDouble(_starttext));
 //BA.debugLineNum = 3108;BA.debugLine="Dim EndValue As Double = EndText";
_endvalue = (double)(Double.parseDouble(_endtext));
 //BA.debugLineNum = 3110;BA.debugLine="If StartValue < 0 Or EndValue < 0 Or _";
if (_startvalue<0 || _endvalue<0 || _startvalue!=__c.Floor(_startvalue) || _endvalue!=__c.Floor(_endvalue) || _startvalue>_endvalue) { 
 //BA.debugLineNum = 3114;BA.debugLine="RaiseOutput(\"?INVALID LINE RANGE\")";
_raiseoutput("?INVALID LINE RANGE");
 //BA.debugLineNum = 3115;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 3118;BA.debugLine="StartLine = StartValue";
_startline = (int) (_startvalue);
 //BA.debugLineNum = 3119;BA.debugLine="EndLine = EndValue";
_endline = (int) (_endvalue);
 }else {
 //BA.debugLineNum = 3123;BA.debugLine="If IsNumber(Arguments) = False Then";
if (__c.IsNumber(_arguments)==__c.False) { 
 //BA.debugLineNum = 3124;BA.debugLine="RaiseOutput(\"?SYNTAX ERROR\")";
_raiseoutput("?SYNTAX ERROR");
 //BA.debugLineNum = 3125;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 3128;BA.debugLine="Dim StartValue As Double = Arguments";
_startvalue = (double)(Double.parseDouble(_arguments));
 //BA.debugLineNum = 3130;BA.debugLine="If StartValue < 0 Or StartValue <> Floor(StartVa";
if (_startvalue<0 || _startvalue!=__c.Floor(_startvalue)) { 
 //BA.debugLineNum = 3131;BA.debugLine="RaiseOutput(\"?INVALID LINE NUMBER\")";
_raiseoutput("?INVALID LINE NUMBER");
 //BA.debugLineNum = 3132;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 3135;BA.debugLine="StartLine = StartValue";
_startline = (int) (_startvalue);
 };
 //BA.debugLineNum = 3139;BA.debugLine="ListProgram(StartLine, EndLine)";
_listprogram(_startline,_endline);
 //BA.debugLineNum = 3141;BA.debugLine="End Sub";
return "";
}
public boolean  _executenext(String _linecode) throws Exception{
anywheresoftware.b4a.objects.collections.Map _loopdata = null;
String _variablename = "";
String _nextvariable = "";
double _currentvalue = 0;
double _limitvalue = 0;
double _stepvalue = 0;
boolean _continueloop = false;
 //BA.debugLineNum = 2048;BA.debugLine="Private Sub ExecuteNext(LineCode As String) As Boo";
 //BA.debugLineNum = 2050;BA.debugLine="If ForStack.IsInitialized = False Or ForStack.Siz";
if (_forstack.IsInitialized()==__c.False || _forstack.getSize()==0) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2052;BA.debugLine="Dim LoopData As Map = ForStack.Get(ForStack.Size";
_loopdata = new anywheresoftware.b4a.objects.collections.Map();
_loopdata = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_forstack.Get((int) (_forstack.getSize()-1))));
 //BA.debugLineNum = 2054;BA.debugLine="Dim VariableName As String = LoopData.Get(\"Variab";
_variablename = BA.ObjectToString(_loopdata.Get((Object)("Variable")));
 //BA.debugLineNum = 2055;BA.debugLine="Dim NextVariable As String = LineCode.SubString(4";
_nextvariable = _linecode.substring((int) (4)).trim().toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 2057;BA.debugLine="If NextVariable <> \"\" And NextVariable <> Variabl";
if ((_nextvariable).equals("") == false && (_nextvariable).equals(_variablename) == false) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2059;BA.debugLine="Dim CurrentValue As Double = Variables.Get(Variab";
_currentvalue = (double)(BA.ObjectToNumber(_variables.Get((Object)(_variablename))));
 //BA.debugLineNum = 2060;BA.debugLine="Dim LimitValue As Double = LoopData.Get(\"Limit\")";
_limitvalue = (double)(BA.ObjectToNumber(_loopdata.Get((Object)("Limit"))));
 //BA.debugLineNum = 2061;BA.debugLine="Dim StepValue As Double = LoopData.Get(\"Step\")";
_stepvalue = (double)(BA.ObjectToNumber(_loopdata.Get((Object)("Step"))));
 //BA.debugLineNum = 2063;BA.debugLine="CurrentValue = CurrentValue + StepValue";
_currentvalue = _currentvalue+_stepvalue;
 //BA.debugLineNum = 2065;BA.debugLine="Variables.Put(VariableName, Utils.FormatNumber(Cu";
_variables.Put((Object)(_variablename),(Object)(_utils._formatnumber /*String*/ (_currentvalue)));
 //BA.debugLineNum = 2067;BA.debugLine="Dim ContinueLoop As Boolean";
_continueloop = false;
 //BA.debugLineNum = 2069;BA.debugLine="If StepValue > 0 Then";
if (_stepvalue>0) { 
 //BA.debugLineNum = 2070;BA.debugLine="ContinueLoop = CurrentValue <= LimitValue";
_continueloop = _currentvalue<=_limitvalue;
 }else {
 //BA.debugLineNum = 2072;BA.debugLine="ContinueLoop = CurrentValue >= LimitValue";
_continueloop = _currentvalue>=_limitvalue;
 };
 //BA.debugLineNum = 2075;BA.debugLine="If ContinueLoop Then";
if (_continueloop) { 
 //BA.debugLineNum = 2076;BA.debugLine="RunPosition = LoopData.Get(\"BodyPosition\")";
_runposition = (int)(BA.ObjectToNumber(_loopdata.Get((Object)("BodyPosition"))));
 }else {
 //BA.debugLineNum = 2078;BA.debugLine="ForStack.RemoveAt(ForStack.Size - 1)";
_forstack.RemoveAt((int) (_forstack.getSize()-1));
 };
 //BA.debugLineNum = 2081;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 2083;BA.debugLine="End Sub";
return false;
}
public boolean  _executeon(String _linecode) throws Exception{
String _upperline = "";
int _operatorpos = 0;
int _operatorlength = 0;
boolean _isgosub = false;
boolean _instring = false;
int _i = 0;
String _c = "";
String _expression = "";
double _selector = 0;
String _targetlist = "";
String[] _targets = null;
String _target = "";
double _targetvalue = 0;
int _choice = 0;
int _targetline = 0;
 //BA.debugLineNum = 2133;BA.debugLine="Private Sub ExecuteOn(LineCode As String) As Boole";
 //BA.debugLineNum = 2134;BA.debugLine="ProgramErrorMessage = \"\"";
_programerrormessage = "";
 //BA.debugLineNum = 2135;BA.debugLine="ExprError = False";
_exprerror = __c.False;
 //BA.debugLineNum = 2136;BA.debugLine="ExprErrorCode = 0";
_exprerrorcode = (int) (0);
 //BA.debugLineNum = 2138;BA.debugLine="Dim UpperLine As String = LineCode.ToUpperCase.Tr";
_upperline = _linecode.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale).trim();
 //BA.debugLineNum = 2141;BA.debugLine="Dim OperatorPos As Int = -1";
_operatorpos = (int) (-1);
 //BA.debugLineNum = 2142;BA.debugLine="Dim OperatorLength As Int = 0";
_operatorlength = (int) (0);
 //BA.debugLineNum = 2143;BA.debugLine="Dim IsGosub As Boolean = False";
_isgosub = __c.False;
 //BA.debugLineNum = 2144;BA.debugLine="Dim InString As Boolean = False";
_instring = __c.False;
 //BA.debugLineNum = 2146;BA.debugLine="For i = 0 To UpperLine.Length - 1";
{
final int step9 = 1;
final int limit9 = (int) (_upperline.length()-1);
_i = (int) (0) ;
for (;_i <= limit9 ;_i = _i + step9 ) {
 //BA.debugLineNum = 2148;BA.debugLine="Dim c As String = UpperLine.SubString2(i, i + 1)";
_c = _upperline.substring(_i,(int) (_i+1));
 //BA.debugLineNum = 2150;BA.debugLine="If c = Chr(34) Then";
if ((_c).equals(BA.ObjectToString(__c.Chr((int) (34))))) { 
 //BA.debugLineNum = 2151;BA.debugLine="InString = Not(InString)";
_instring = __c.Not(_instring);
 //BA.debugLineNum = 2152;BA.debugLine="Continue";
if (true) continue;
 };
 //BA.debugLineNum = 2155;BA.debugLine="If InString Then Continue";
if (_instring) { 
if (true) continue;};
 //BA.debugLineNum = 2157;BA.debugLine="If i <= UpperLine.Length - 6 Then";
if (_i<=_upperline.length()-6) { 
 //BA.debugLineNum = 2158;BA.debugLine="If UpperLine.SubString2(i, i + 6) = \" GOTO \" Th";
if ((_upperline.substring(_i,(int) (_i+6))).equals(" GOTO ")) { 
 //BA.debugLineNum = 2159;BA.debugLine="OperatorPos = i";
_operatorpos = _i;
 //BA.debugLineNum = 2160;BA.debugLine="OperatorLength = 6";
_operatorlength = (int) (6);
 //BA.debugLineNum = 2161;BA.debugLine="Exit";
if (true) break;
 };
 };
 //BA.debugLineNum = 2165;BA.debugLine="If i <= UpperLine.Length - 7 Then";
if (_i<=_upperline.length()-7) { 
 //BA.debugLineNum = 2166;BA.debugLine="If UpperLine.SubString2(i, i + 7) = \" GOSUB \" T";
if ((_upperline.substring(_i,(int) (_i+7))).equals(" GOSUB ")) { 
 //BA.debugLineNum = 2167;BA.debugLine="OperatorPos = i";
_operatorpos = _i;
 //BA.debugLineNum = 2168;BA.debugLine="OperatorLength = 7";
_operatorlength = (int) (7);
 //BA.debugLineNum = 2169;BA.debugLine="IsGosub = True";
_isgosub = __c.True;
 //BA.debugLineNum = 2170;BA.debugLine="Exit";
if (true) break;
 };
 };
 }
};
 //BA.debugLineNum = 2176;BA.debugLine="If OperatorPos < 0 Then Return False";
if (_operatorpos<0) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2179;BA.debugLine="Dim Expression As String = LineCode.SubString2(3,";
_expression = _linecode.substring((int) (3),_operatorpos).trim();
 //BA.debugLineNum = 2181;BA.debugLine="If Expression = \"\" Then Return False";
if ((_expression).equals("")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2183;BA.debugLine="Dim Selector As Double = EvaluateNumericExpressio";
_selector = _evaluatenumericexpression(_expression);
 //BA.debugLineNum = 2185;BA.debugLine="If ExprError Then Return False";
if (_exprerror) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2188;BA.debugLine="Dim TargetList As String = LineCode.SubString(Ope";
_targetlist = _linecode.substring((int) (_operatorpos+_operatorlength)).trim();
 //BA.debugLineNum = 2190;BA.debugLine="If TargetList = \"\" Then Return False";
if ((_targetlist).equals("")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2192;BA.debugLine="Dim Targets() As String = Regex.Split(\",\", Target";
_targets = __c.Regex.Split(",",_targetlist);
 //BA.debugLineNum = 2194;BA.debugLine="If Targets.Length = 0 Then Return False";
if (_targets.length==0) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2197;BA.debugLine="For Each Target As String In Targets";
{
final String[] group41 = _targets;
final int groupLen41 = group41.length
;int index41 = 0;
;
for (; index41 < groupLen41;index41++){
_target = group41[index41];
 //BA.debugLineNum = 2199;BA.debugLine="Target = Target.Trim";
_target = _target.trim();
 //BA.debugLineNum = 2201;BA.debugLine="If Target = \"\" Or IsNumber(Target) = False Then";
if ((_target).equals("") || __c.IsNumber(_target)==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2203;BA.debugLine="Dim TargetValue As Double = Target";
_targetvalue = (double)(Double.parseDouble(_target));
 //BA.debugLineNum = 2205;BA.debugLine="If TargetValue < 0 Or TargetValue <> Floor(Targe";
if (_targetvalue<0 || _targetvalue!=__c.Floor(_targetvalue)) { 
if (true) return __c.False;};
 }
};
 //BA.debugLineNum = 2210;BA.debugLine="Dim Choice As Int = Selector";
_choice = (int) (_selector);
 //BA.debugLineNum = 2212;BA.debugLine="If Choice < 1 Or Choice > Targets.Length Then Ret";
if (_choice<1 || _choice>_targets.length) { 
if (true) return __c.True;};
 //BA.debugLineNum = 2214;BA.debugLine="Dim TargetLine As Int = Targets(Choice - 1).Trim";
_targetline = (int)(Double.parseDouble(_targets[(int) (_choice-1)].trim()));
 //BA.debugLineNum = 2216;BA.debugLine="If IsGosub Then";
if (_isgosub) { 
 //BA.debugLineNum = 2218;BA.debugLine="GosubStack.Add(RunPosition)";
_gosubstack.Add((Object)(_runposition));
 };
 //BA.debugLineNum = 2221;BA.debugLine="If JumpToLine(TargetLine) = False Then";
if (_jumptoline(_targetline)==__c.False) { 
 //BA.debugLineNum = 2223;BA.debugLine="If IsGosub Then";
if (_isgosub) { 
 //BA.debugLineNum = 2224;BA.debugLine="GosubStack.RemoveAt(GosubStack.Size - 1)";
_gosubstack.RemoveAt((int) (_gosubstack.getSize()-1));
 };
 //BA.debugLineNum = 2227;BA.debugLine="ProgramErrorMessage = \"?UNDEFINED LINE \" & Targe";
_programerrormessage = "?UNDEFINED LINE "+BA.NumberToString(_targetline);
 //BA.debugLineNum = 2228;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 2231;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 2232;BA.debugLine="End Sub";
return false;
}
public boolean  _executeonerror(String _linecode) throws Exception{
String _upperline = "";
String _targettext = "";
double _targetvalue = 0;
int _targetline = 0;
 //BA.debugLineNum = 2962;BA.debugLine="Private Sub ExecuteOnError(LineCode As String) As";
 //BA.debugLineNum = 2963;BA.debugLine="Dim UpperLine As String = LineCode.ToUpperCase.Tr";
_upperline = _linecode.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale).trim();
 //BA.debugLineNum = 2964;BA.debugLine="If UpperLine.StartsWith(\"ON ERROR GOTO \") = False";
if (_upperline.startsWith("ON ERROR GOTO ")==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2966;BA.debugLine="Dim TargetText As String = LineCode.SubString(14)";
_targettext = _linecode.substring((int) (14)).trim();
 //BA.debugLineNum = 2967;BA.debugLine="If IsNumber(TargetText) = False Then Return False";
if (__c.IsNumber(_targettext)==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2969;BA.debugLine="Dim TargetValue As Double = TargetText";
_targetvalue = (double)(Double.parseDouble(_targettext));
 //BA.debugLineNum = 2971;BA.debugLine="If TargetValue < 0 Or TargetValue <> Floor(Target";
if (_targetvalue<0 || _targetvalue!=__c.Floor(_targetvalue)) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2973;BA.debugLine="Dim TargetLine As Int = TargetValue";
_targetline = (int) (_targetvalue);
 //BA.debugLineNum = 2975;BA.debugLine="If TargetLine = 0 Then";
if (_targetline==0) { 
 //BA.debugLineNum = 2976;BA.debugLine="ErrorHandlerEnabled = False";
_errorhandlerenabled = __c.False;
 //BA.debugLineNum = 2977;BA.debugLine="ErrorHandlerLine = 0";
_errorhandlerline = (int) (0);
 //BA.debugLineNum = 2978;BA.debugLine="Return True";
if (true) return __c.True;
 };
 //BA.debugLineNum = 2981;BA.debugLine="If FindRunPosition(TargetLine) < 0 Then Return Fa";
if (_findrunposition(_targetline)<0) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2983;BA.debugLine="ErrorHandlerLine = TargetLine";
_errorhandlerline = _targetline;
 //BA.debugLineNum = 2984;BA.debugLine="ErrorHandlerEnabled = True";
_errorhandlerenabled = __c.True;
 //BA.debugLineNum = 2986;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 2987;BA.debugLine="End Sub";
return false;
}
public boolean  _executerandomize(String _linecode) throws Exception{
String _seedexpression = "";
double _seedvalue = 0;
long _seed = 0L;
 //BA.debugLineNum = 511;BA.debugLine="Private Sub ExecuteRandomize(LineCode As String) A";
 //BA.debugLineNum = 513;BA.debugLine="ExprError = False";
_exprerror = __c.False;
 //BA.debugLineNum = 514;BA.debugLine="ExprErrorCode = 0";
_exprerrorcode = (int) (0);
 //BA.debugLineNum = 516;BA.debugLine="Dim SeedExpression As String = LineCode.SubString";
_seedexpression = _linecode.substring((int) (9)).trim();
 //BA.debugLineNum = 519;BA.debugLine="If SeedExpression = \"\" Then";
if ((_seedexpression).equals("")) { 
 //BA.debugLineNum = 520;BA.debugLine="RndSeed(DateTime.Now)";
__c.RndSeed(__c.DateTime.getNow());
 //BA.debugLineNum = 521;BA.debugLine="Return True";
if (true) return __c.True;
 };
 //BA.debugLineNum = 525;BA.debugLine="Dim SeedValue As Double = EvaluateNumericExpressi";
_seedvalue = _evaluatenumericexpression(_seedexpression);
 //BA.debugLineNum = 527;BA.debugLine="If ExprError Then Return False";
if (_exprerror) { 
if (true) return __c.False;};
 //BA.debugLineNum = 529;BA.debugLine="Dim Seed As Long = SeedValue";
_seed = (long) (_seedvalue);
 //BA.debugLineNum = 531;BA.debugLine="RndSeed(Seed)";
__c.RndSeed(_seed);
 //BA.debugLineNum = 533;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 535;BA.debugLine="End Sub";
return false;
}
public boolean  _executeread(String _linecode) throws Exception{
String _variablelist = "";
anywheresoftware.b4a.objects.collections.List _readvariables = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _currentvariable = null;
int _i = 0;
String _currentchar = "";
anywheresoftware.b4a.objects.collections.List _readnames = null;
anywheresoftware.b4a.objects.collections.List _readvalues = null;
int _tempdataposition = 0;
String _variableitem = "";
String _variablename = "";
String _datavalue = "";
boolean _isstringdata = false;
double _numbervalue = 0;
 //BA.debugLineNum = 537;BA.debugLine="Private Sub ExecuteRead(LineCode As String) As Boo";
 //BA.debugLineNum = 539;BA.debugLine="ReadErrorMessage = \"ILLEGAL READ\"";
_readerrormessage = "ILLEGAL READ";
 //BA.debugLineNum = 541;BA.debugLine="Dim VariableList As String = LineCode.SubString(4";
_variablelist = _linecode.substring((int) (4)).trim();
 //BA.debugLineNum = 543;BA.debugLine="If VariableList = \"\" Then Return False";
if ((_variablelist).equals("")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 546;BA.debugLine="Dim ReadVariables As List";
_readvariables = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 547;BA.debugLine="ReadVariables.Initialize";
_readvariables.Initialize();
 //BA.debugLineNum = 549;BA.debugLine="Dim CurrentVariable As StringBuilder";
_currentvariable = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 550;BA.debugLine="CurrentVariable.Initialize";
_currentvariable.Initialize();
 //BA.debugLineNum = 552;BA.debugLine="For i = 0 To VariableList.Length - 1";
{
final int step8 = 1;
final int limit8 = (int) (_variablelist.length()-1);
_i = (int) (0) ;
for (;_i <= limit8 ;_i = _i + step8 ) {
 //BA.debugLineNum = 554;BA.debugLine="Dim CurrentChar As String = VariableList.CharAt(";
_currentchar = BA.ObjectToString(_variablelist.charAt(_i));
 //BA.debugLineNum = 556;BA.debugLine="If CurrentChar = \",\" Then";
if ((_currentchar).equals(",")) { 
 //BA.debugLineNum = 557;BA.debugLine="If CurrentVariable.ToString.Trim = \"\" Then Retu";
if ((_currentvariable.ToString().trim()).equals("")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 559;BA.debugLine="ReadVariables.Add(CurrentVariable.ToString.Trim";
_readvariables.Add((Object)(_currentvariable.ToString().trim()));
 //BA.debugLineNum = 560;BA.debugLine="CurrentVariable.Initialize";
_currentvariable.Initialize();
 }else {
 //BA.debugLineNum = 562;BA.debugLine="CurrentVariable.Append(CurrentChar)";
_currentvariable.Append(_currentchar);
 };
 }
};
 //BA.debugLineNum = 568;BA.debugLine="If CurrentVariable.ToString.Trim = \"\" Then Return";
if ((_currentvariable.ToString().trim()).equals("")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 570;BA.debugLine="ReadVariables.Add(CurrentVariable.ToString.Trim)";
_readvariables.Add((Object)(_currentvariable.ToString().trim()));
 //BA.debugLineNum = 572;BA.debugLine="If ReadVariables.Size = 0 Then Return False";
if (_readvariables.getSize()==0) { 
if (true) return __c.False;};
 //BA.debugLineNum = 575;BA.debugLine="Dim ReadNames As List";
_readnames = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 576;BA.debugLine="ReadNames.Initialize";
_readnames.Initialize();
 //BA.debugLineNum = 578;BA.debugLine="Dim ReadValues As List";
_readvalues = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 579;BA.debugLine="ReadValues.Initialize";
_readvalues.Initialize();
 //BA.debugLineNum = 581;BA.debugLine="Dim TempDataPosition As Int = DataPosition";
_tempdataposition = _dataposition;
 //BA.debugLineNum = 584;BA.debugLine="For Each VariableItem As String In ReadVariables";
{
final anywheresoftware.b4a.BA.IterableList group26 = _readvariables;
final int groupLen26 = group26.getSize()
;int index26 = 0;
;
for (; index26 < groupLen26;index26++){
_variableitem = BA.ObjectToString(group26.Get(index26));
 //BA.debugLineNum = 586;BA.debugLine="Dim VariableName As String = VariableItem.ToUppe";
_variablename = _variableitem.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale).trim();
 //BA.debugLineNum = 588;BA.debugLine="If IsValidReadVariable(VariableName) = False The";
if (_isvalidreadvariable(_variablename)==__c.False) { 
 //BA.debugLineNum = 589;BA.debugLine="ReadErrorMessage = \"ILLEGAL READ\"";
_readerrormessage = "ILLEGAL READ";
 //BA.debugLineNum = 590;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 593;BA.debugLine="If TempDataPosition >= DataItems.Size Then";
if (_tempdataposition>=_dataitems.getSize()) { 
 //BA.debugLineNum = 594;BA.debugLine="ReadErrorMessage = \"OUT OF DATA\"";
_readerrormessage = "OUT OF DATA";
 //BA.debugLineNum = 595;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 598;BA.debugLine="Dim DataValue As String = DataItems.Get(TempData";
_datavalue = (BA.ObjectToString(_dataitems.Get(_tempdataposition))).trim();
 //BA.debugLineNum = 600;BA.debugLine="Dim IsStringData As Boolean = DataValue.StartsWi";
_isstringdata = _datavalue.startsWith("\"") || _datavalue.endsWith("\"");
 //BA.debugLineNum = 602;BA.debugLine="If VariableName.EndsWith(\"$\") Then";
if (_variablename.endsWith("$")) { 
 //BA.debugLineNum = 604;BA.debugLine="If IsStringData = False Then";
if (_isstringdata==__c.False) { 
 //BA.debugLineNum = 605;BA.debugLine="ReadErrorMessage = \"TYPE MISMATCH\"";
_readerrormessage = "TYPE MISMATCH";
 //BA.debugLineNum = 606;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 609;BA.debugLine="If DataValue.StartsWith(\"\"\"\") = False Or DataVa";
if (_datavalue.startsWith("\"")==__c.False || _datavalue.endsWith("\"")==__c.False) { 
 //BA.debugLineNum = 610;BA.debugLine="ReadErrorMessage = \"TYPE MISMATCH\"";
_readerrormessage = "TYPE MISMATCH";
 //BA.debugLineNum = 611;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 614;BA.debugLine="DataValue = DataValue.SubString2(1, DataValue.L";
_datavalue = _datavalue.substring((int) (1),(int) (_datavalue.length()-1));
 //BA.debugLineNum = 616;BA.debugLine="ReadNames.Add(VariableName)";
_readnames.Add((Object)(_variablename));
 //BA.debugLineNum = 617;BA.debugLine="ReadValues.Add(DataValue)";
_readvalues.Add((Object)(_datavalue));
 }else {
 //BA.debugLineNum = 621;BA.debugLine="If IsStringData Then";
if (_isstringdata) { 
 //BA.debugLineNum = 622;BA.debugLine="ReadErrorMessage = \"TYPE MISMATCH\"";
_readerrormessage = "TYPE MISMATCH";
 //BA.debugLineNum = 623;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 626;BA.debugLine="Dim NumberValue As Double";
_numbervalue = 0;
 //BA.debugLineNum = 628;BA.debugLine="Try";
try { //BA.debugLineNum = 629;BA.debugLine="NumberValue = DataValue";
_numbervalue = (double)(Double.parseDouble(_datavalue));
 } 
       catch (Exception e59) {
			ba.setLastException(e59); //BA.debugLineNum = 631;BA.debugLine="ReadErrorMessage = \"TYPE MISMATCH\"";
_readerrormessage = "TYPE MISMATCH";
 //BA.debugLineNum = 632;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 635;BA.debugLine="ReadNames.Add(VariableName)";
_readnames.Add((Object)(_variablename));
 //BA.debugLineNum = 636;BA.debugLine="ReadValues.Add(NumberValue)";
_readvalues.Add((Object)(_numbervalue));
 };
 //BA.debugLineNum = 640;BA.debugLine="TempDataPosition = TempDataPosition + 1";
_tempdataposition = (int) (_tempdataposition+1);
 }
};
 //BA.debugLineNum = 645;BA.debugLine="For i = 0 To ReadNames.Size - 1";
{
final int step67 = 1;
final int limit67 = (int) (_readnames.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit67 ;_i = _i + step67 ) {
 //BA.debugLineNum = 646;BA.debugLine="Variables.Put(ReadNames.Get(i), ReadValues.Get(i";
_variables.Put(_readnames.Get(_i),_readvalues.Get(_i));
 }
};
 //BA.debugLineNum = 649;BA.debugLine="DataPosition = TempDataPosition";
_dataposition = _tempdataposition;
 //BA.debugLineNum = 651;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 653;BA.debugLine="End Sub";
return false;
}
public String  _executerenumber(int _newstart,int _increment) throws Exception{
anywheresoftware.b4a.objects.collections.List _oldlinenumbers = null;
Object _key = null;
anywheresoftware.b4a.objects.collections.Map _linenumbermap = null;
int _newlinenumber = 0;
int _oldlinenumber = 0;
anywheresoftware.b4a.objects.collections.Map _newprogramlines = null;
String _linecode = "";
 //BA.debugLineNum = 3649;BA.debugLine="Private Sub ExecuteRenumber(NewStart As Int, Incre";
 //BA.debugLineNum = 3651;BA.debugLine="If ProgramLines.Size = 0 Then";
if (_programlines.getSize()==0) { 
 //BA.debugLineNum = 3652;BA.debugLine="RaiseOutput(\"NO PROGRAM\")";
_raiseoutput("NO PROGRAM");
 //BA.debugLineNum = 3653;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 3657;BA.debugLine="Dim OldLineNumbers As List";
_oldlinenumbers = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 3658;BA.debugLine="OldLineNumbers.Initialize";
_oldlinenumbers.Initialize();
 //BA.debugLineNum = 3660;BA.debugLine="For Each Key As Object In ProgramLines.Keys";
{
final anywheresoftware.b4a.BA.IterableList group7 = _programlines.Keys();
final int groupLen7 = group7.getSize()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_key = group7.Get(index7);
 //BA.debugLineNum = 3661;BA.debugLine="OldLineNumbers.Add(Key)";
_oldlinenumbers.Add(_key);
 }
};
 //BA.debugLineNum = 3664;BA.debugLine="OldLineNumbers.Sort(True)";
_oldlinenumbers.Sort(__c.True);
 //BA.debugLineNum = 3667;BA.debugLine="Dim LineNumberMap As Map";
_linenumbermap = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 3668;BA.debugLine="LineNumberMap.Initialize";
_linenumbermap.Initialize();
 //BA.debugLineNum = 3670;BA.debugLine="Dim NewLineNumber As Int = NewStart";
_newlinenumber = _newstart;
 //BA.debugLineNum = 3672;BA.debugLine="For Each OldLineNumber As Int In OldLineNumbers";
{
final anywheresoftware.b4a.BA.IterableList group14 = _oldlinenumbers;
final int groupLen14 = group14.getSize()
;int index14 = 0;
;
for (; index14 < groupLen14;index14++){
_oldlinenumber = (int)(BA.ObjectToNumber(group14.Get(index14)));
 //BA.debugLineNum = 3673;BA.debugLine="LineNumberMap.Put(OldLineNumber, NewLineNumber)";
_linenumbermap.Put((Object)(_oldlinenumber),(Object)(_newlinenumber));
 //BA.debugLineNum = 3674;BA.debugLine="NewLineNumber = NewLineNumber + Increment";
_newlinenumber = (int) (_newlinenumber+_increment);
 }
};
 //BA.debugLineNum = 3678;BA.debugLine="Dim NewProgramLines As Map";
_newprogramlines = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 3679;BA.debugLine="NewProgramLines.Initialize";
_newprogramlines.Initialize();
 //BA.debugLineNum = 3681;BA.debugLine="For Each OldLineNumber As Int In OldLineNumbers";
{
final anywheresoftware.b4a.BA.IterableList group20 = _oldlinenumbers;
final int groupLen20 = group20.getSize()
;int index20 = 0;
;
for (; index20 < groupLen20;index20++){
_oldlinenumber = (int)(BA.ObjectToNumber(group20.Get(index20)));
 //BA.debugLineNum = 3683;BA.debugLine="Dim LineCode As String = ProgramLines.Get(OldLin";
_linecode = BA.ObjectToString(_programlines.Get((Object)(_oldlinenumber)));
 //BA.debugLineNum = 3684;BA.debugLine="NewLineNumber = LineNumberMap.Get(OldLineNumber)";
_newlinenumber = (int)(BA.ObjectToNumber(_linenumbermap.Get((Object)(_oldlinenumber))));
 //BA.debugLineNum = 3686;BA.debugLine="LineCode = UpdateLineReference(LineCode, \"GOTO\",";
_linecode = _updatelinereference(_linecode,"GOTO",_linenumbermap);
 //BA.debugLineNum = 3687;BA.debugLine="LineCode = UpdateLineReference(LineCode, \"GOSUB\"";
_linecode = _updatelinereference(_linecode,"GOSUB",_linenumbermap);
 //BA.debugLineNum = 3688;BA.debugLine="LineCode = UpdateLineReference(LineCode, \"THEN\",";
_linecode = _updatelinereference(_linecode,"THEN",_linenumbermap);
 //BA.debugLineNum = 3690;BA.debugLine="NewProgramLines.Put(NewLineNumber, LineCode)";
_newprogramlines.Put((Object)(_newlinenumber),(Object)(_linecode));
 }
};
 //BA.debugLineNum = 3694;BA.debugLine="ProgramLines = NewProgramLines";
_programlines = _newprogramlines;
 //BA.debugLineNum = 3695;BA.debugLine="Utils.CallSubMethod2(mCallback, mEventName, \"_Pro";
_utils._callsubmethod2 /*String*/ (_mcallback,_meventname,"_ProgramRenumbered",(Object)(_getprogramtext()));
 //BA.debugLineNum = 3697;BA.debugLine="RaiseOutput(\"PROGRAM RENUMBERED\")";
_raiseoutput("PROGRAM RENUMBERED");
 //BA.debugLineNum = 3698;BA.debugLine="End Sub";
return "";
}
public String  _executerenumbercommand(String _command) throws Exception{
String _arguments = "";
int _newstart = 0;
int _increment = 0;
int _commapos = 0;
String _starttext = "";
String _incrementtext = "";
double _startvalue = 0;
double _incrementvalue = 0;
 //BA.debugLineNum = 3700;BA.debugLine="Private Sub ExecuteRenumberCommand(Command As Stri";
 //BA.debugLineNum = 3702;BA.debugLine="Dim Arguments As String = Command.SubString(5)";
_arguments = _command.substring((int) (5)).trim();
 //BA.debugLineNum = 3704;BA.debugLine="Dim NewStart As Int = 10";
_newstart = (int) (10);
 //BA.debugLineNum = 3705;BA.debugLine="Dim Increment As Int = 10";
_increment = (int) (10);
 //BA.debugLineNum = 3707;BA.debugLine="Dim CommaPos As Int = Arguments.IndexOf(\",\")";
_commapos = _arguments.indexOf(",");
 //BA.debugLineNum = 3709;BA.debugLine="If CommaPos >= 0 Then";
if (_commapos>=0) { 
 //BA.debugLineNum = 3711;BA.debugLine="Dim StartText As String = Arguments.SubStr";
_starttext = _arguments.substring((int) (0),_commapos).trim();
 //BA.debugLineNum = 3712;BA.debugLine="Dim IncrementText As String = Arguments.Su";
_incrementtext = _arguments.substring((int) (_commapos+1)).trim();
 //BA.debugLineNum = 3714;BA.debugLine="If IsNumber(StartText) = False Or IsNumber";
if (__c.IsNumber(_starttext)==__c.False || __c.IsNumber(_incrementtext)==__c.False) { 
 //BA.debugLineNum = 3715;BA.debugLine="RaiseOutput(\"?SYNTAX ERROR\")";
_raiseoutput("?SYNTAX ERROR");
 //BA.debugLineNum = 3716;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 3719;BA.debugLine="Dim StartValue As Double = StartText";
_startvalue = (double)(Double.parseDouble(_starttext));
 //BA.debugLineNum = 3720;BA.debugLine="Dim IncrementValue As Double = IncrementTe";
_incrementvalue = (double)(Double.parseDouble(_incrementtext));
 //BA.debugLineNum = 3722;BA.debugLine="If StartValue < 0 Or IncrementValue <= 0 O";
if (_startvalue<0 || _incrementvalue<=0 || _startvalue!=__c.Floor(_startvalue) || _incrementvalue!=__c.Floor(_incrementvalue)) { 
 //BA.debugLineNum = 3725;BA.debugLine="RaiseOutput(\"?INVALID RENUMBER PARAMET";
_raiseoutput("?INVALID RENUMBER PARAMETERS");
 //BA.debugLineNum = 3726;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 3729;BA.debugLine="NewStart = StartValue";
_newstart = (int) (_startvalue);
 //BA.debugLineNum = 3730;BA.debugLine="Increment = IncrementValue";
_increment = (int) (_incrementvalue);
 }else {
 //BA.debugLineNum = 3734;BA.debugLine="If IsNumber(Arguments) = False Then";
if (__c.IsNumber(_arguments)==__c.False) { 
 //BA.debugLineNum = 3735;BA.debugLine="RaiseOutput(\"?SYNTAX ERROR\")";
_raiseoutput("?SYNTAX ERROR");
 //BA.debugLineNum = 3736;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 3739;BA.debugLine="Dim StartValue As Double = Arguments";
_startvalue = (double)(Double.parseDouble(_arguments));
 //BA.debugLineNum = 3741;BA.debugLine="If StartValue < 0 Or StartValue <> Floor(S";
if (_startvalue<0 || _startvalue!=__c.Floor(_startvalue)) { 
 //BA.debugLineNum = 3742;BA.debugLine="RaiseOutput(\"?INVALID START LINE\")";
_raiseoutput("?INVALID START LINE");
 //BA.debugLineNum = 3743;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 3746;BA.debugLine="NewStart = StartValue";
_newstart = (int) (_startvalue);
 };
 //BA.debugLineNum = 3750;BA.debugLine="ExecuteRenumber(NewStart, Increment)";
_executerenumber(_newstart,_increment);
 //BA.debugLineNum = 3752;BA.debugLine="End Sub";
return "";
}
public boolean  _executerestore(String _linecode) throws Exception{
 //BA.debugLineNum = 659;BA.debugLine="Private Sub ExecuteRestore(LineCode As String) As";
 //BA.debugLineNum = 661;BA.debugLine="If LineCode.Trim.ToUpperCase <> \"RESTORE\" Then Re";
if ((_linecode.trim().toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale)).equals("RESTORE") == false) { 
if (true) return __c.False;};
 //BA.debugLineNum = 663;BA.debugLine="DataPosition = 0";
_dataposition = (int) (0);
 //BA.debugLineNum = 665;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 667;BA.debugLine="End Sub";
return false;
}
public boolean  _executeresume(String _linecode) throws Exception{
String _resumecommand = "";
 //BA.debugLineNum = 2989;BA.debugLine="Private Sub ExecuteResume(LineCode As String) As B";
 //BA.debugLineNum = 2991;BA.debugLine="If ErrorHandlerRunning = False Then Return False";
if (_errorhandlerrunning==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2993;BA.debugLine="Dim ResumeCommand As String = LineCode.Trim.ToUpp";
_resumecommand = _linecode.trim().toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 2995;BA.debugLine="Select Case ResumeCommand";
switch (BA.switchObjectToInt(_resumecommand,"RESUME","RESUME NEXT")) {
case 0: {
 //BA.debugLineNum = 2998;BA.debugLine="If ErrorLinePosition < 0 Then Return False";
if (_errorlineposition<0) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2999;BA.debugLine="RunPosition = ErrorLinePosition";
_runposition = _errorlineposition;
 break; }
case 1: {
 //BA.debugLineNum = 3002;BA.debugLine="If ErrorNextPosition < 0 Then Return False";
if (_errornextposition<0) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3003;BA.debugLine="RunPosition = ErrorNextPosition";
_runposition = _errornextposition;
 break; }
default: {
 //BA.debugLineNum = 3006;BA.debugLine="Return False";
if (true) return __c.False;
 break; }
}
;
 //BA.debugLineNum = 3011;BA.debugLine="ErrorHandlerRunning = False";
_errorhandlerrunning = __c.False;
 //BA.debugLineNum = 3013;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 3015;BA.debugLine="End Sub";
return false;
}
public boolean  _executeswap(String _linecode) throws Exception{
String _statement = "";
String _arguments = "";
int _commapos = 0;
String _lefttarget = "";
String _righttarget = "";
String _leftvalue = "";
String _rightvalue = "";
 //BA.debugLineNum = 3511;BA.debugLine="Private Sub ExecuteSwap(LineCode As String) As Boo";
 //BA.debugLineNum = 3513;BA.debugLine="Dim Statement As String = LineCode.Trim.ToUpperCa";
_statement = _linecode.trim().toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 3515;BA.debugLine="If Statement.StartsWith(\"SWAP \") = False Then Ret";
if (_statement.startsWith("SWAP ")==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3517;BA.debugLine="Dim Arguments As String = Statement.SubString(5).";
_arguments = _statement.substring((int) (5)).trim();
 //BA.debugLineNum = 3520;BA.debugLine="Dim CommaPos As Int = Arguments.IndexOf(\",\")";
_commapos = _arguments.indexOf(",");
 //BA.debugLineNum = 3522;BA.debugLine="If CommaPos <= 0 Then Return False";
if (_commapos<=0) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3524;BA.debugLine="Dim LeftTarget As String = Arguments.SubString2(0";
_lefttarget = _arguments.substring((int) (0),_commapos).trim();
 //BA.debugLineNum = 3525;BA.debugLine="Dim RightTarget As String = Arguments.SubString(C";
_righttarget = _arguments.substring((int) (_commapos+1)).trim();
 //BA.debugLineNum = 3527;BA.debugLine="If LeftTarget = \"\" Or RightTarget = \"\" Then Retur";
if ((_lefttarget).equals("") || (_righttarget).equals("")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3529;BA.debugLine="If LeftTarget = RightTarget Then Return False";
if ((_lefttarget).equals(_righttarget)) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3532;BA.debugLine="Dim LeftValue As String = GetNumericTargetValue(L";
_leftvalue = _getnumerictargetvalue(_lefttarget);
 //BA.debugLineNum = 3534;BA.debugLine="If ExprError Then Return False";
if (_exprerror) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3536;BA.debugLine="Dim RightValue As String = GetNumericTargetValue(";
_rightvalue = _getnumerictargetvalue(_righttarget);
 //BA.debugLineNum = 3538;BA.debugLine="If ExprError Then Return False";
if (_exprerror) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3541;BA.debugLine="If SetNumericTargetValue(LeftTarget, RightValue)";
if (_setnumerictargetvalue(_lefttarget,_rightvalue)==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3542;BA.debugLine="If SetNumericTargetValue(RightTarget, LeftValue)";
if (_setnumerictargetvalue(_righttarget,_leftvalue)==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3544;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 3546;BA.debugLine="End Sub";
return false;
}
public String  _externaldatadisconnected() throws Exception{
 //BA.debugLineNum = 3253;BA.debugLine="Public Sub ExternalDataDisconnected";
 //BA.debugLineNum = 3255;BA.debugLine="If WaitingForExternalData = False Then Return";
if (_waitingforexternaldata==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 3257;BA.debugLine="WaitingForExternalData = False";
_waitingforexternaldata = __c.False;
 //BA.debugLineNum = 3258;BA.debugLine="ExternalDataTarget = \"\"";
_externaldatatarget = "";
 //BA.debugLineNum = 3260;BA.debugLine="HandleProgramError(\"?SERIAL CONNECTION LOST\")";
_handleprogramerror("?SERIAL CONNECTION LOST");
 //BA.debugLineNum = 3262;BA.debugLine="End Sub";
return "";
}
public int  _findmatchingnextposition(String _variablename) throws Exception{
int _nesting = 0;
int _i = 0;
int _linenumber = 0;
String _linecode = "";
String _upperline = "";
String _nextvariable = "";
 //BA.debugLineNum = 3040;BA.debugLine="Private Sub FindMatchingNextPosition(VariableName";
 //BA.debugLineNum = 3042;BA.debugLine="Dim Nesting As Int = 0";
_nesting = (int) (0);
 //BA.debugLineNum = 3044;BA.debugLine="For i = RunPosition To RunLines.Size - 1";
{
final int step2 = 1;
final int limit2 = (int) (_runlines.getSize()-1);
_i = _runposition ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 3046;BA.debugLine="Dim LineNumber As Int = RunLines.Get(i)";
_linenumber = (int)(BA.ObjectToNumber(_runlines.Get(_i)));
 //BA.debugLineNum = 3047;BA.debugLine="Dim LineCode As String = ProgramLines.Get(LineNu";
_linecode = BA.ObjectToString(_programlines.Get((Object)(_linenumber)));
 //BA.debugLineNum = 3048;BA.debugLine="Dim UpperLine As String = LineCode.ToUpperCase.T";
_upperline = _linecode.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale).trim();
 //BA.debugLineNum = 3050;BA.debugLine="If UpperLine.StartsWith(\"FOR \") Then";
if (_upperline.startsWith("FOR ")) { 
 //BA.debugLineNum = 3051;BA.debugLine="Nesting = Nesting + 1";
_nesting = (int) (_nesting+1);
 }else if((_upperline).equals("NEXT") || _upperline.startsWith("NEXT ")) { 
 //BA.debugLineNum = 3055;BA.debugLine="If Nesting = 0 Then";
if (_nesting==0) { 
 //BA.debugLineNum = 3056;BA.debugLine="Dim NextVariable As String = UpperLine.SubStri";
_nextvariable = _upperline.substring((int) (4)).trim();
 //BA.debugLineNum = 3058;BA.debugLine="If NextVariable = \"\" Or NextVariable = Variabl";
if ((_nextvariable).equals("") || (_nextvariable).equals(_variablename)) { 
 //BA.debugLineNum = 3059;BA.debugLine="Return i";
if (true) return _i;
 };
 }else {
 //BA.debugLineNum = 3062;BA.debugLine="Nesting = Nesting - 1";
_nesting = (int) (_nesting-1);
 };
 };
 }
};
 //BA.debugLineNum = 3069;BA.debugLine="Return -1";
if (true) return (int) (-1);
 //BA.debugLineNum = 3071;BA.debugLine="End Sub";
return 0;
}
public int  _findnextposition(String _variablename) throws Exception{
int _nesting = 0;
int _i = 0;
int _linenumber = 0;
String _linecode = "";
String _upperline = "";
String _nextvariable = "";
 //BA.debugLineNum = 2085;BA.debugLine="Private Sub FindNextPosition(VariableName As Strin";
 //BA.debugLineNum = 2087;BA.debugLine="Dim Nesting As Int = 0";
_nesting = (int) (0);
 //BA.debugLineNum = 2089;BA.debugLine="For i = RunPosition To RunLines.Size - 1";
{
final int step2 = 1;
final int limit2 = (int) (_runlines.getSize()-1);
_i = _runposition ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 2091;BA.debugLine="Dim LineNumber As Int = RunLines.Get(i)";
_linenumber = (int)(BA.ObjectToNumber(_runlines.Get(_i)));
 //BA.debugLineNum = 2092;BA.debugLine="Dim LineCode As String = ProgramLines.Get(LineNu";
_linecode = BA.ObjectToString(_programlines.Get((Object)(_linenumber)));
 //BA.debugLineNum = 2093;BA.debugLine="Dim UpperLine As String = LineCode.ToUpperCase.T";
_upperline = _linecode.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale).trim();
 //BA.debugLineNum = 2095;BA.debugLine="If UpperLine.StartsWith(\"FOR \") Then";
if (_upperline.startsWith("FOR ")) { 
 //BA.debugLineNum = 2096;BA.debugLine="Nesting = Nesting + 1";
_nesting = (int) (_nesting+1);
 }else if((_upperline).equals("NEXT") || _upperline.startsWith("NEXT ")) { 
 //BA.debugLineNum = 2100;BA.debugLine="If Nesting = 0 Then";
if (_nesting==0) { 
 //BA.debugLineNum = 2101;BA.debugLine="Dim NextVariable As String = UpperLine.SubStri";
_nextvariable = _upperline.substring((int) (4)).trim();
 //BA.debugLineNum = 2103;BA.debugLine="If NextVariable = \"\" Or NextVariable = Variabl";
if ((_nextvariable).equals("") || (_nextvariable).equals(_variablename)) { 
 //BA.debugLineNum = 2104;BA.debugLine="Return i + 1";
if (true) return (int) (_i+1);
 };
 }else {
 //BA.debugLineNum = 2107;BA.debugLine="Nesting = Nesting - 1";
_nesting = (int) (_nesting-1);
 };
 };
 }
};
 //BA.debugLineNum = 2114;BA.debugLine="Return -1";
if (true) return (int) (-1);
 //BA.debugLineNum = 2116;BA.debugLine="End Sub";
return 0;
}
public int  _findrunposition(int _targetline) throws Exception{
int _i = 0;
int _linenumber = 0;
 //BA.debugLineNum = 3030;BA.debugLine="Private Sub FindRunPosition(TargetLine As Int) As";
 //BA.debugLineNum = 3031;BA.debugLine="For i = 0 To RunLines.Size - 1";
{
final int step1 = 1;
final int limit1 = (int) (_runlines.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit1 ;_i = _i + step1 ) {
 //BA.debugLineNum = 3032;BA.debugLine="Dim LineNumber As Int = RunLines.Get(i)";
_linenumber = (int)(BA.ObjectToNumber(_runlines.Get(_i)));
 //BA.debugLineNum = 3034;BA.debugLine="If LineNumber = TargetLine Then Return i";
if (_linenumber==_targetline) { 
if (true) return _i;};
 }
};
 //BA.debugLineNum = 3037;BA.debugLine="Return -1";
if (true) return (int) (-1);
 //BA.debugLineNum = 3038;BA.debugLine="End Sub";
return 0;
}
public int  _getdelaymilliseconds() throws Exception{
 //BA.debugLineNum = 3234;BA.debugLine="Public Sub GetDelayMilliseconds As Int";
 //BA.debugLineNum = 3235;BA.debugLine="Return DelayMilliseconds";
if (true) return _delaymilliseconds;
 //BA.debugLineNum = 3236;BA.debugLine="End Sub";
return 0;
}
public String  _getnumerictargetvalue(String _target) throws Exception{
int _openpos = 0;
int _closepos = 0;
String _arrayname = "";
String _indextext = "";
double _indexvalue = 0;
anywheresoftware.b4a.objects.collections.List _values = null;
String _value = "";
 //BA.debugLineNum = 3586;BA.debugLine="Private Sub GetNumericTargetValue(Target As String";
 //BA.debugLineNum = 3588;BA.debugLine="ExprError = False";
_exprerror = __c.False;
 //BA.debugLineNum = 3590;BA.debugLine="Dim OpenPos As Int = Target.IndexOf(\"(\")";
_openpos = _target.indexOf("(");
 //BA.debugLineNum = 3591;BA.debugLine="Dim ClosePos As Int = Target.IndexOf(\")\")";
_closepos = _target.indexOf(")");
 //BA.debugLineNum = 3593;BA.debugLine="If OpenPos > 0 And ClosePos > OpenPos Then";
if (_openpos>0 && _closepos>_openpos) { 
 //BA.debugLineNum = 3595;BA.debugLine="Dim ArrayName As String = Target.SubString2(0, O";
_arrayname = _target.substring((int) (0),_openpos).trim();
 //BA.debugLineNum = 3596;BA.debugLine="Dim IndexText As String = Target.SubString2(Open";
_indextext = _target.substring((int) (_openpos+1),_closepos).trim();
 //BA.debugLineNum = 3598;BA.debugLine="If IsValidVariable(ArrayName) = False Then";
if (_isvalidvariable(_arrayname)==__c.False) { 
 //BA.debugLineNum = 3599;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 3600;BA.debugLine="Return \"0\"";
if (true) return "0";
 };
 //BA.debugLineNum = 3603;BA.debugLine="If Arrays.ContainsKey(ArrayName) = False Then";
if (_arrays.ContainsKey((Object)(_arrayname))==__c.False) { 
 //BA.debugLineNum = 3604;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 3605;BA.debugLine="Return \"0\"";
if (true) return "0";
 };
 //BA.debugLineNum = 3608;BA.debugLine="Dim IndexValue As Double = EvaluateNumericExpres";
_indexvalue = _evaluatenumericexpression(_indextext);
 //BA.debugLineNum = 3610;BA.debugLine="If ExprError Or IndexValue < 1 Or IndexValue <>";
if (_exprerror || _indexvalue<1 || _indexvalue!=__c.Floor(_indexvalue)) { 
 //BA.debugLineNum = 3611;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 3612;BA.debugLine="Return \"0\"";
if (true) return "0";
 };
 //BA.debugLineNum = 3615;BA.debugLine="Dim Values As List = Arrays.Get(ArrayName)";
_values = new anywheresoftware.b4a.objects.collections.List();
_values = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_arrays.Get((Object)(_arrayname))));
 //BA.debugLineNum = 3617;BA.debugLine="If IndexValue > Values.Size Then";
if (_indexvalue>_values.getSize()) { 
 //BA.debugLineNum = 3618;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 3619;BA.debugLine="Return \"0\"";
if (true) return "0";
 };
 //BA.debugLineNum = 3622;BA.debugLine="Return Values.Get(IndexValue - 1)";
if (true) return BA.ObjectToString(_values.Get((int) (_indexvalue-1)));
 };
 //BA.debugLineNum = 3626;BA.debugLine="If IsValidVariable(Target) = False Or Target.Ends";
if (_isvalidvariable(_target)==__c.False || _target.endsWith("$")) { 
 //BA.debugLineNum = 3627;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 3628;BA.debugLine="Return \"0\"";
if (true) return "0";
 };
 //BA.debugLineNum = 3631;BA.debugLine="If Variables.ContainsKey(Target) = False Then";
if (_variables.ContainsKey((Object)(_target))==__c.False) { 
 //BA.debugLineNum = 3632;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 3633;BA.debugLine="Return \"0\"";
if (true) return "0";
 };
 //BA.debugLineNum = 3636;BA.debugLine="Dim Value As String = Variables.Get(Target)";
_value = BA.ObjectToString(_variables.Get((Object)(_target)));
 //BA.debugLineNum = 3638;BA.debugLine="If IsNumber(Value) = False Then";
if (__c.IsNumber(_value)==__c.False) { 
 //BA.debugLineNum = 3639;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 3640;BA.debugLine="Return \"0\"";
if (true) return "0";
 };
 //BA.debugLineNum = 3643;BA.debugLine="Return Value";
if (true) return _value;
 //BA.debugLineNum = 3645;BA.debugLine="End Sub";
return "";
}
public int  _getprogramlinecount() throws Exception{
 //BA.debugLineNum = 3194;BA.debugLine="Public Sub GetProgramLineCount As Int";
 //BA.debugLineNum = 3195;BA.debugLine="Return ProgramLines.Size";
if (true) return _programlines.getSize();
 //BA.debugLineNum = 3196;BA.debugLine="End Sub";
return 0;
}
public String  _getprogramtext() throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _result = null;
anywheresoftware.b4a.objects.collections.List _linenumbers = null;
Object _key = null;
int _linenumber = 0;
 //BA.debugLineNum = 3754;BA.debugLine="Public Sub GetProgramText As String";
 //BA.debugLineNum = 3756;BA.debugLine="Dim Result As StringBuilder";
_result = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 3757;BA.debugLine="Result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 3759;BA.debugLine="Dim LineNumbers As List";
_linenumbers = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 3760;BA.debugLine="LineNumbers.Initialize";
_linenumbers.Initialize();
 //BA.debugLineNum = 3762;BA.debugLine="For Each Key As Object In ProgramLines.Keys";
{
final anywheresoftware.b4a.BA.IterableList group5 = _programlines.Keys();
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_key = group5.Get(index5);
 //BA.debugLineNum = 3763;BA.debugLine="LineNumbers.Add(Key)";
_linenumbers.Add(_key);
 }
};
 //BA.debugLineNum = 3766;BA.debugLine="LineNumbers.Sort(True)";
_linenumbers.Sort(__c.True);
 //BA.debugLineNum = 3768;BA.debugLine="For Each LineNumber As Int In LineNumbers";
{
final anywheresoftware.b4a.BA.IterableList group9 = _linenumbers;
final int groupLen9 = group9.getSize()
;int index9 = 0;
;
for (; index9 < groupLen9;index9++){
_linenumber = (int)(BA.ObjectToNumber(group9.Get(index9)));
 //BA.debugLineNum = 3769;BA.debugLine="Result.Append(LineNumber)";
_result.Append(BA.NumberToString(_linenumber));
 //BA.debugLineNum = 3770;BA.debugLine="Result.Append(\" \")";
_result.Append(" ");
 //BA.debugLineNum = 3771;BA.debugLine="Result.Append(ProgramLines.Get(LineNumber))";
_result.Append(BA.ObjectToString(_programlines.Get((Object)(_linenumber))));
 //BA.debugLineNum = 3772;BA.debugLine="Result.Append(CRLF)";
_result.Append(__c.CRLF);
 }
};
 //BA.debugLineNum = 3775;BA.debugLine="Return Result.ToString";
if (true) return _result.ToString();
 //BA.debugLineNum = 3776;BA.debugLine="End Sub";
return "";
}
public boolean  _handleprogramerror(String _message) throws Exception{
int _handlerposition = 0;
 //BA.debugLineNum = 2908;BA.debugLine="Private Sub HandleProgramError(Message As String)";
 //BA.debugLineNum = 2911;BA.debugLine="If ErrorHandlerRunning Or ErrorHandlerEnabled = F";
if (_errorhandlerrunning || _errorhandlerenabled==__c.False) { 
 //BA.debugLineNum = 2912;BA.debugLine="RaiseOutput(Message)";
_raiseoutput(_message);
 //BA.debugLineNum = 2913;BA.debugLine="RunPosition = RunLines.Size";
_runposition = _runlines.getSize();
 //BA.debugLineNum = 2914;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 2917;BA.debugLine="ErrorLinePosition = RunPosition - 1";
_errorlineposition = (int) (_runposition-1);
 //BA.debugLineNum = 2918;BA.debugLine="ErrorNextPosition = RunPosition";
_errornextposition = _runposition;
 //BA.debugLineNum = 2921;BA.debugLine="If ErrorLinePosition < 0 Or ErrorLinePosition >=";
if (_errorlineposition<0 || _errorlineposition>=_runlines.getSize()) { 
 //BA.debugLineNum = 2922;BA.debugLine="RaiseOutput(Message)";
_raiseoutput(_message);
 //BA.debugLineNum = 2923;BA.debugLine="RunPosition = RunLines.Size";
_runposition = _runlines.getSize();
 //BA.debugLineNum = 2924;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 2928;BA.debugLine="ErrorLineNumber = RunLines.Get(ErrorLinePosition)";
_errorlinenumber = (int)(BA.ObjectToNumber(_runlines.Get(_errorlineposition)));
 //BA.debugLineNum = 2931;BA.debugLine="If Message.Contains(\"UNDEFINED LINE\") Then";
if (_message.contains("UNDEFINED LINE")) { 
 //BA.debugLineNum = 2932;BA.debugLine="ErrorCode = 5";
_errorcode = (int) (5);
 }else if(_message.contains("DIVISION BY ZERO")) { 
 //BA.debugLineNum = 2934;BA.debugLine="ErrorCode = 11";
_errorcode = (int) (11);
 }else if(_message.contains("NEXT WITHOUT FOR")) { 
 //BA.debugLineNum = 2936;BA.debugLine="ErrorCode = 22";
_errorcode = (int) (22);
 }else if(_message.contains("RETURN WITHOUT GOSUB")) { 
 //BA.debugLineNum = 2938;BA.debugLine="ErrorCode = 23";
_errorcode = (int) (23);
 }else {
 //BA.debugLineNum = 2940;BA.debugLine="ErrorCode = 20";
_errorcode = (int) (20);
 };
 //BA.debugLineNum = 2944;BA.debugLine="ErrorHandlerRunning = True";
_errorhandlerrunning = __c.True;
 //BA.debugLineNum = 2946;BA.debugLine="Dim HandlerPosition As Int = FindRunPosition(Erro";
_handlerposition = _findrunposition(_errorhandlerline);
 //BA.debugLineNum = 2948;BA.debugLine="If HandlerPosition < 0 Then";
if (_handlerposition<0) { 
 //BA.debugLineNum = 2949;BA.debugLine="RaiseOutput(\"?UNDEFINED ERROR HANDLER LINE \" & E";
_raiseoutput("?UNDEFINED ERROR HANDLER LINE "+BA.NumberToString(_errorhandlerline));
 //BA.debugLineNum = 2950;BA.debugLine="RunPosition = RunLines.Size";
_runposition = _runlines.getSize();
 //BA.debugLineNum = 2951;BA.debugLine="ErrorHandlerRunning = False";
_errorhandlerrunning = __c.False;
 //BA.debugLineNum = 2952;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 2955;BA.debugLine="RunPosition = HandlerPosition";
_runposition = _handlerposition;
 //BA.debugLineNum = 2957;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 2959;BA.debugLine="End Sub";
return false;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 80;BA.debugLine="Public Sub Initialize(Callback As Object, EventNam";
 //BA.debugLineNum = 82;BA.debugLine="mCallback = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 83;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 86;BA.debugLine="ProgramLines.Initialize";
_programlines.Initialize();
 //BA.debugLineNum = 87;BA.debugLine="Variables.Initialize";
_variables.Initialize();
 //BA.debugLineNum = 88;BA.debugLine="Arrays.Initialize";
_arrays.Initialize();
 //BA.debugLineNum = 89;BA.debugLine="RunLines.Initialize";
_runlines.Initialize();
 //BA.debugLineNum = 90;BA.debugLine="InputVariables.Initialize";
_inputvariables.Initialize();
 //BA.debugLineNum = 91;BA.debugLine="ForStack.Initialize";
_forstack.Initialize();
 //BA.debugLineNum = 92;BA.debugLine="GosubStack.Initialize";
_gosubstack.Initialize();
 //BA.debugLineNum = 93;BA.debugLine="DataItems.Initialize";
_dataitems.Initialize();
 //BA.debugLineNum = 94;BA.debugLine="Functions.Initialize";
_functions.Initialize();
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return "";
}
public boolean  _isstringexpression(String _expression) throws Exception{
 //BA.debugLineNum = 1951;BA.debugLine="Private Sub IsStringExpression(Expression As Strin";
 //BA.debugLineNum = 1952;BA.debugLine="Expression = Expression.Trim";
_expression = _expression.trim();
 //BA.debugLineNum = 1954;BA.debugLine="If Expression.StartsWith(Chr(34)) Then Return Tru";
if (_expression.startsWith(BA.ObjectToString(__c.Chr((int) (34))))) { 
if (true) return __c.True;};
 //BA.debugLineNum = 1955;BA.debugLine="If Expression.EndsWith(\"$\") Then Return True";
if (_expression.endsWith("$")) { 
if (true) return __c.True;};
 //BA.debugLineNum = 1957;BA.debugLine="Return False";
if (true) return __c.False;
 //BA.debugLineNum = 1958;BA.debugLine="End Sub";
return false;
}
public boolean  _isstringexpressionforprint(String _item) throws Exception{
String _firstpart = "";
boolean _inquotes = false;
int _bracketlevel = 0;
int _i = 0;
String _currentchar = "";
String _upperpart = "";
 //BA.debugLineNum = 2844;BA.debugLine="Private Sub IsStringExpressionForPrint(Item As Str";
 //BA.debugLineNum = 2845;BA.debugLine="Dim FirstPart As String = Item.Trim";
_firstpart = _item.trim();
 //BA.debugLineNum = 2846;BA.debugLine="Dim InQuotes As Boolean = False";
_inquotes = __c.False;
 //BA.debugLineNum = 2847;BA.debugLine="Dim BracketLevel As Int = 0";
_bracketlevel = (int) (0);
 //BA.debugLineNum = 2849;BA.debugLine="For i = 0 To FirstPart.Length - 1";
{
final int step4 = 1;
final int limit4 = (int) (_firstpart.length()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 2850;BA.debugLine="Dim CurrentChar As String = FirstPart.SubString2";
_currentchar = _firstpart.substring(_i,(int) (_i+1));
 //BA.debugLineNum = 2852;BA.debugLine="If CurrentChar = Chr(34) Then";
if ((_currentchar).equals(BA.ObjectToString(__c.Chr((int) (34))))) { 
 //BA.debugLineNum = 2853;BA.debugLine="InQuotes = Not(InQuotes)";
_inquotes = __c.Not(_inquotes);
 }else if(_inquotes==__c.False) { 
 //BA.debugLineNum = 2856;BA.debugLine="If CurrentChar = \"(\" Then BracketLevel = Bracke";
if ((_currentchar).equals("(")) { 
_bracketlevel = (int) (_bracketlevel+1);};
 //BA.debugLineNum = 2857;BA.debugLine="If CurrentChar = \")\" Then BracketLevel = Bracke";
if ((_currentchar).equals(")")) { 
_bracketlevel = (int) (_bracketlevel-1);};
 //BA.debugLineNum = 2859;BA.debugLine="If CurrentChar = \"+\" And BracketLevel = 0 Then";
if ((_currentchar).equals("+") && _bracketlevel==0) { 
 //BA.debugLineNum = 2860;BA.debugLine="FirstPart = FirstPart.SubString2(0, i).Trim";
_firstpart = _firstpart.substring((int) (0),_i).trim();
 //BA.debugLineNum = 2861;BA.debugLine="Exit";
if (true) break;
 };
 };
 }
};
 //BA.debugLineNum = 2866;BA.debugLine="If FirstPart.StartsWith(Chr(34)) Then Return True";
if (_firstpart.startsWith(BA.ObjectToString(__c.Chr((int) (34))))) { 
if (true) return __c.True;};
 //BA.debugLineNum = 2868;BA.debugLine="Dim UpperPart As String = FirstPart.ToUpperCase";
_upperpart = _firstpart.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 2871;BA.debugLine="If UpperPart = \"ERR\" Or UpperPart = \"ERL\" Then Re";
if ((_upperpart).equals("ERR") || (_upperpart).equals("ERL")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2873;BA.debugLine="If UpperPart.EndsWith(\"$\") Then Return True";
if (_upperpart.endsWith("$")) { 
if (true) return __c.True;};
 //BA.debugLineNum = 2875;BA.debugLine="If UpperPart.StartsWith(\"LEFT$(\") Or _ 		UpperPar";
if (_upperpart.startsWith("LEFT$(") || _upperpart.startsWith("RIGHT$(") || _upperpart.startsWith("MID$(") || _upperpart.startsWith("STR$(") || _upperpart.startsWith("CHR$(") || _upperpart.startsWith("SPACE$(") || _upperpart.startsWith("STRING$(") || _upperpart.startsWith("UCASE$(") || _upperpart.startsWith("LCASE$(") || _upperpart.startsWith("LTRIM$(") || _upperpart.startsWith("RTRIM$(") || _upperpart.startsWith("TRIM$(") || _upperpart.startsWith("BIN(") || _upperpart.startsWith("HEX(") || _upperpart.startsWith("OCT(")) { 
 //BA.debugLineNum = 2891;BA.debugLine="Return True";
if (true) return __c.True;
 };
 //BA.debugLineNum = 2894;BA.debugLine="Return False";
if (true) return __c.False;
 //BA.debugLineNum = 2895;BA.debugLine="End Sub";
return false;
}
public boolean  _isvalidreadvariable(String _variablename) throws Exception{
 //BA.debugLineNum = 655;BA.debugLine="Private Sub IsValidReadVariable(VariableName As St";
 //BA.debugLineNum = 656;BA.debugLine="Return IsValidVariable(VariableName)";
if (true) return _isvalidvariable(_variablename);
 //BA.debugLineNum = 657;BA.debugLine="End Sub";
return false;
}
public boolean  _isvalidvariable(String _variablename) throws Exception{
String _namepart = "";
String _firstchar = "";
int _i = 0;
String _currentchar = "";
 //BA.debugLineNum = 2345;BA.debugLine="Private Sub IsValidVariable(VariableName As String";
 //BA.debugLineNum = 2347;BA.debugLine="VariableName = VariableName.ToUpperCase";
_variablename = _variablename.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 2349;BA.debugLine="If VariableName = \"\" Or VariableName.Length > MAX";
if ((_variablename).equals("") || _variablename.length()>_max_var_length) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2351;BA.debugLine="Dim NamePart As String = VariableName";
_namepart = _variablename;
 //BA.debugLineNum = 2354;BA.debugLine="If VariableName.EndsWith(\"$\") Then";
if (_variablename.endsWith("$")) { 
 //BA.debugLineNum = 2355;BA.debugLine="NamePart = VariableName.SubString2(0, VariableNa";
_namepart = _variablename.substring((int) (0),(int) (_variablename.length()-1));
 };
 //BA.debugLineNum = 2358;BA.debugLine="If NamePart.Length = 0 Then Return False";
if (_namepart.length()==0) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2361;BA.debugLine="Dim FirstChar As String = NamePart.SubString2(0,";
_firstchar = _namepart.substring((int) (0),(int) (1));
 //BA.debugLineNum = 2363;BA.debugLine="If FirstChar.CompareTo(\"A\") < 0 Or FirstChar.Comp";
if (_firstchar.compareTo("A")<0 || _firstchar.compareTo("Z")>0) { 
if (true) return __c.False;};
 //BA.debugLineNum = 2366;BA.debugLine="For i = 1 To NamePart.Length - 1";
{
final int step10 = 1;
final int limit10 = (int) (_namepart.length()-1);
_i = (int) (1) ;
for (;_i <= limit10 ;_i = _i + step10 ) {
 //BA.debugLineNum = 2368;BA.debugLine="Dim CurrentChar As String = NamePart.SubString2(";
_currentchar = _namepart.substring(_i,(int) (_i+1));
 //BA.debugLineNum = 2370;BA.debugLine="If (CurrentChar.CompareTo(\"A\") < 0 Or CurrentCha";
if ((_currentchar.compareTo("A")<0 || _currentchar.compareTo("Z")>0) && __c.IsNumber(_currentchar)==__c.False) { 
if (true) return __c.False;};
 }
};
 //BA.debugLineNum = 2375;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 2377;BA.debugLine="End Sub";
return false;
}
public boolean  _iswaitingfordelay() throws Exception{
 //BA.debugLineNum = 3203;BA.debugLine="Public Sub IsWaitingForDelay As Boolean";
 //BA.debugLineNum = 3204;BA.debugLine="Return WaitingForDelay";
if (true) return _waitingfordelay;
 //BA.debugLineNum = 3205;BA.debugLine="End Sub";
return false;
}
public boolean  _iswaitingforinput() throws Exception{
 //BA.debugLineNum = 427;BA.debugLine="Public Sub IsWaitingForInput As Boolean";
 //BA.debugLineNum = 428;BA.debugLine="Return WaitingForInput";
if (true) return _waitingforinput;
 //BA.debugLineNum = 429;BA.debugLine="End Sub";
return false;
}
public boolean  _jumptoline(int _targetline) throws Exception{
int _position = 0;
 //BA.debugLineNum = 3073;BA.debugLine="Private Sub JumpToLine(TargetLine As Int) As Boole";
 //BA.debugLineNum = 3074;BA.debugLine="Dim Position As Int = FindRunPosition(TargetLine)";
_position = _findrunposition(_targetline);
 //BA.debugLineNum = 3076;BA.debugLine="If Position < 0 Then Return False";
if (_position<0) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3078;BA.debugLine="RunPosition = Position";
_runposition = _position;
 //BA.debugLineNum = 3079;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 3080;BA.debugLine="End Sub";
return false;
}
public String  _listprogram(int _startline,int _endline) throws Exception{
anywheresoftware.b4a.objects.collections.List _linenumbers = null;
Object _key = null;
int _linenumber = 0;
String _linecode = "";
 //BA.debugLineNum = 3143;BA.debugLine="Private Sub ListProgram(StartLine As Int, EndLine";
 //BA.debugLineNum = 3145;BA.debugLine="If ProgramLines.Size = 0 Then";
if (_programlines.getSize()==0) { 
 //BA.debugLineNum = 3146;BA.debugLine="RaiseOutput(\"NO PROGRAM\")";
_raiseoutput("NO PROGRAM");
 //BA.debugLineNum = 3147;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 3151;BA.debugLine="Dim LineNumbers As List";
_linenumbers = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 3152;BA.debugLine="LineNumbers.Initialize";
_linenumbers.Initialize();
 //BA.debugLineNum = 3154;BA.debugLine="For Each Key As Object In ProgramLines.Keys";
{
final anywheresoftware.b4a.BA.IterableList group7 = _programlines.Keys();
final int groupLen7 = group7.getSize()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_key = group7.Get(index7);
 //BA.debugLineNum = 3155;BA.debugLine="LineNumbers.Add(Key)";
_linenumbers.Add(_key);
 }
};
 //BA.debugLineNum = 3159;BA.debugLine="LineNumbers.Sort(True)";
_linenumbers.Sort(__c.True);
 //BA.debugLineNum = 3162;BA.debugLine="For Each LineNumber As Int In LineNumbers";
{
final anywheresoftware.b4a.BA.IterableList group11 = _linenumbers;
final int groupLen11 = group11.getSize()
;int index11 = 0;
;
for (; index11 < groupLen11;index11++){
_linenumber = (int)(BA.ObjectToNumber(group11.Get(index11)));
 //BA.debugLineNum = 3164;BA.debugLine="If LineNumber < StartLine Then Continue";
if (_linenumber<_startline) { 
if (true) continue;};
 //BA.debugLineNum = 3166;BA.debugLine="If EndLine >= 0 And LineNumber > EndLine T";
if (_endline>=0 && _linenumber>_endline) { 
if (true) break;};
 //BA.debugLineNum = 3168;BA.debugLine="Dim LineCode As String = ProgramLines.Get(";
_linecode = BA.ObjectToString(_programlines.Get((Object)(_linenumber)));
 //BA.debugLineNum = 3169;BA.debugLine="RaiseOutput(LineNumber & \" \" & LineCode)";
_raiseoutput(BA.NumberToString(_linenumber)+" "+_linecode);
 }
};
 //BA.debugLineNum = 3173;BA.debugLine="End Sub";
return "";
}
public String  _loadprogram(String _source) throws Exception{
String[] _editorlines = null;
int _filelinenumber = 0;
int _nextlinenumber = 0;
String _editorline = "";
int _spacepos = 0;
int _linenumber = 0;
String _linecode = "";
boolean _isnumbered = false;
String _numbertext = "";
double _numbervalue = 0;
 //BA.debugLineNum = 120;BA.debugLine="Public Sub LoadProgram(Source As String)";
 //BA.debugLineNum = 122;BA.debugLine="ProgramLines.Clear";
_programlines.Clear();
 //BA.debugLineNum = 123;BA.debugLine="Functions.Clear";
_functions.Clear();
 //BA.debugLineNum = 125;BA.debugLine="Dim EditorLines() As String = Regex.Split(\"\\r\\n|\\";
_editorlines = __c.Regex.Split("\\r\\n|\\n|\\r",_source);
 //BA.debugLineNum = 127;BA.debugLine="Dim FileLineNumber As Int = 0";
_filelinenumber = (int) (0);
 //BA.debugLineNum = 128;BA.debugLine="Dim NextLineNumber As Int = 10";
_nextlinenumber = (int) (10);
 //BA.debugLineNum = 130;BA.debugLine="For Each EditorLine As String In EditorLines";
{
final String[] group6 = _editorlines;
final int groupLen6 = group6.length
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_editorline = group6[index6];
 //BA.debugLineNum = 132;BA.debugLine="FileLineNumber = FileLineNumber + 1";
_filelinenumber = (int) (_filelinenumber+1);
 //BA.debugLineNum = 133;BA.debugLine="EditorLine = EditorLine.Trim";
_editorline = _editorline.trim();
 //BA.debugLineNum = 136;BA.debugLine="If EditorLine = \"\" Then Continue";
if ((_editorline).equals("")) { 
if (true) continue;};
 //BA.debugLineNum = 138;BA.debugLine="Dim SpacePos As Int = EditorLine.IndexOf(\" \")";
_spacepos = _editorline.indexOf(" ");
 //BA.debugLineNum = 139;BA.debugLine="Dim LineNumber As Int";
_linenumber = 0;
 //BA.debugLineNum = 140;BA.debugLine="Dim LineCode As String";
_linecode = "";
 //BA.debugLineNum = 143;BA.debugLine="Dim IsNumbered As Boolean = False";
_isnumbered = __c.False;
 //BA.debugLineNum = 145;BA.debugLine="If SpacePos > 0 Then";
if (_spacepos>0) { 
 //BA.debugLineNum = 146;BA.debugLine="Dim NumberText As String = EditorLine.SubString";
_numbertext = _editorline.substring((int) (0),_spacepos);
 //BA.debugLineNum = 148;BA.debugLine="If IsNumber(NumberText) Then";
if (__c.IsNumber(_numbertext)) { 
 //BA.debugLineNum = 149;BA.debugLine="Dim NumberValue As Double = NumberText";
_numbervalue = (double)(Double.parseDouble(_numbertext));
 //BA.debugLineNum = 151;BA.debugLine="If NumberValue >= 0 And NumberValue = Floor(Nu";
if (_numbervalue>=0 && _numbervalue==__c.Floor(_numbervalue)) { 
 //BA.debugLineNum = 152;BA.debugLine="LineNumber = NumberValue";
_linenumber = (int) (_numbervalue);
 //BA.debugLineNum = 153;BA.debugLine="LineCode = EditorLine.SubString(SpacePos + 1)";
_linecode = _editorline.substring((int) (_spacepos+1)).trim();
 //BA.debugLineNum = 154;BA.debugLine="IsNumbered = LineCode <> \"\"";
_isnumbered = (_linecode).equals("") == false;
 };
 };
 };
 //BA.debugLineNum = 159;BA.debugLine="If IsNumbered = False Then";
if (_isnumbered==__c.False) { 
 //BA.debugLineNum = 161;BA.debugLine="LineNumber = NextLineNumber";
_linenumber = _nextlinenumber;
 //BA.debugLineNum = 162;BA.debugLine="LineCode = EditorLine";
_linecode = _editorline;
 };
 //BA.debugLineNum = 166;BA.debugLine="ProgramLines.Put(LineNumber, LineCode)";
_programlines.Put((Object)(_linenumber),(Object)(_linecode));
 //BA.debugLineNum = 169;BA.debugLine="If IsNumbered Then";
if (_isnumbered) { 
 //BA.debugLineNum = 170;BA.debugLine="NextLineNumber = Max(NextLineNumber, (Floor(Lin";
_nextlinenumber = (int) (__c.Max(_nextlinenumber,(__c.Floor(_linenumber/(double)10)+1)*10));
 }else {
 //BA.debugLineNum = 172;BA.debugLine="NextLineNumber = NextLineNumber + 10";
_nextlinenumber = (int) (_nextlinenumber+10);
 };
 }
};
 //BA.debugLineNum = 177;BA.debugLine="End Sub";
return "";
}
public double  _parseexpression() throws Exception{
double _result = 0;
String _op = "";
double _value = 0;
 //BA.debugLineNum = 1336;BA.debugLine="Private Sub ParseExpression As Double";
 //BA.debugLineNum = 1337;BA.debugLine="Dim Result As Double = ParseTerm";
_result = _parseterm();
 //BA.debugLineNum = 1339;BA.debugLine="Do While ExprPos < ExprText.Length And ExprError";
while (_exprpos<_exprtext.length() && _exprerror==__c.False) {
 //BA.debugLineNum = 1340;BA.debugLine="SkipSpaces";
_skipspaces();
 //BA.debugLineNum = 1342;BA.debugLine="If ExprPos >= ExprText.Length Then Exit";
if (_exprpos>=_exprtext.length()) { 
if (true) break;};
 //BA.debugLineNum = 1344;BA.debugLine="Dim Op As String = ExprText.SubString2(ExprPos,";
_op = _exprtext.substring(_exprpos,(int) (_exprpos+1));
 //BA.debugLineNum = 1346;BA.debugLine="If Op = \"+\" Or Op = \"-\" Then";
if ((_op).equals("+") || (_op).equals("-")) { 
 //BA.debugLineNum = 1347;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 //BA.debugLineNum = 1349;BA.debugLine="Dim Value As Double = ParseTerm";
_value = _parseterm();
 //BA.debugLineNum = 1351;BA.debugLine="If Op = \"+\" Then";
if ((_op).equals("+")) { 
 //BA.debugLineNum = 1352;BA.debugLine="Result = Result + Value";
_result = _result+_value;
 }else {
 //BA.debugLineNum = 1354;BA.debugLine="Result = Result - Value";
_result = _result-_value;
 };
 }else {
 //BA.debugLineNum = 1357;BA.debugLine="Exit";
if (true) break;
 };
 }
;
 //BA.debugLineNum = 1361;BA.debugLine="Return Result";
if (true) return _result;
 //BA.debugLineNum = 1362;BA.debugLine="End Sub";
return 0;
}
public double  _parsefactor() throws Exception{
String _ch = "";
double _result = 0;
int _startpos = 0;
String _numbertext = "";
String _name = "";
int _functionstart = 0;
String _functionname = "";
anywheresoftware.b4a.objects.collections.List _arguments = null;
double _argument = 0;
String _separator = "";
String _searchtext = "";
String _searchfor = "";
int _foundposition = 0;
int _stringargumentstart = 0;
int _stringargumentend = 0;
int _stringbracketlevel = 0;
boolean _stringinquotes = false;
String _scanchar = "";
String _stringexpressiontext = "";
String _savedexprtext = "";
int _savedexprpos = 0;
String _stringfunctionvalue = "";
double _indexvalue = 0;
anywheresoftware.b4a.objects.collections.List _values = null;
String _arrayvalue = "";
String _arrayname = "";
String _c = "";
String _variablevalue = "";
 //BA.debugLineNum = 1400;BA.debugLine="Private Sub ParseFactor As Double";
 //BA.debugLineNum = 1401;BA.debugLine="SkipSpaces";
_skipspaces();
 //BA.debugLineNum = 1403;BA.debugLine="If ExprPos >= ExprText.Length Then";
if (_exprpos>=_exprtext.length()) { 
 //BA.debugLineNum = 1404;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1405;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1408;BA.debugLine="Dim Ch As String = ExprText.SubString2(ExprPos, E";
_ch = _exprtext.substring(_exprpos,(int) (_exprpos+1));
 //BA.debugLineNum = 1411;BA.debugLine="If Ch = \"-\" Then";
if ((_ch).equals("-")) { 
 //BA.debugLineNum = 1412;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 //BA.debugLineNum = 1413;BA.debugLine="Return -ParseFactor";
if (true) return -_parsefactor();
 };
 //BA.debugLineNum = 1417;BA.debugLine="If Ch = \"+\" Then";
if ((_ch).equals("+")) { 
 //BA.debugLineNum = 1418;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 //BA.debugLineNum = 1419;BA.debugLine="Return ParseFactor";
if (true) return _parsefactor();
 };
 //BA.debugLineNum = 1423;BA.debugLine="If Ch = \"(\" Then";
if ((_ch).equals("(")) { 
 //BA.debugLineNum = 1424;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 //BA.debugLineNum = 1426;BA.debugLine="Dim Result As Double = ParseExpression";
_result = _parseexpression();
 //BA.debugLineNum = 1428;BA.debugLine="SkipSpaces";
_skipspaces();
 //BA.debugLineNum = 1430;BA.debugLine="If ExprPos >= ExprText.Length Then";
if (_exprpos>=_exprtext.length()) { 
 //BA.debugLineNum = 1431;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1432;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1435;BA.debugLine="If ExprText.SubString2(ExprPos, ExprPos + 1) <>";
if ((_exprtext.substring(_exprpos,(int) (_exprpos+1))).equals(")") == false) { 
 //BA.debugLineNum = 1436;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1437;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1440;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 //BA.debugLineNum = 1441;BA.debugLine="Return Result";
if (true) return _result;
 };
 //BA.debugLineNum = 1445;BA.debugLine="Dim StartPos As Int = ExprPos";
_startpos = _exprpos;
 //BA.debugLineNum = 1447;BA.debugLine="Do While ExprPos < ExprText.Length";
while (_exprpos<_exprtext.length()) {
 //BA.debugLineNum = 1448;BA.debugLine="Ch = ExprText.SubString2(ExprPos, ExprPos + 1)";
_ch = _exprtext.substring(_exprpos,(int) (_exprpos+1));
 //BA.debugLineNum = 1450;BA.debugLine="If (Ch.CompareTo(\"0\") >= 0 And Ch.CompareTo(\"9\")";
if ((_ch.compareTo("0")>=0 && _ch.compareTo("9")<=0) || (_ch).equals(".")) { 
 //BA.debugLineNum = 1451;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 }else {
 //BA.debugLineNum = 1453;BA.debugLine="Exit";
if (true) break;
 };
 }
;
 //BA.debugLineNum = 1457;BA.debugLine="If ExprPos > StartPos Then";
if (_exprpos>_startpos) { 
 //BA.debugLineNum = 1458;BA.debugLine="Dim NumberText As String = ExprText.SubString2(S";
_numbertext = _exprtext.substring(_startpos,_exprpos);
 //BA.debugLineNum = 1460;BA.debugLine="If IsNumber(NumberText) Then Return NumberText";
if (__c.IsNumber(_numbertext)) { 
if (true) return (double)(Double.parseDouble(_numbertext));};
 //BA.debugLineNum = 1462;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1463;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1467;BA.debugLine="Do While ExprPos < ExprText.Length";
while (_exprpos<_exprtext.length()) {
 //BA.debugLineNum = 1468;BA.debugLine="Ch = ExprText.SubString2(ExprPos, ExprPos + 1)";
_ch = _exprtext.substring(_exprpos,(int) (_exprpos+1));
 //BA.debugLineNum = 1470;BA.debugLine="If (Ch.CompareTo(\"A\") >= 0 And Ch.CompareTo(\"Z\")";
if ((_ch.compareTo("A")>=0 && _ch.compareTo("Z")<=0) || (_ch.compareTo("a")>=0 && _ch.compareTo("z")<=0) || __c.IsNumber(_ch) || (_ch).equals("$")) { 
 //BA.debugLineNum = 1473;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 }else {
 //BA.debugLineNum = 1475;BA.debugLine="Exit";
if (true) break;
 };
 }
;
 //BA.debugLineNum = 1479;BA.debugLine="If ExprPos = StartPos Then";
if (_exprpos==_startpos) { 
 //BA.debugLineNum = 1480;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1481;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1484;BA.debugLine="Dim Name As String = ExprText.SubString2(StartPos";
_name = _exprtext.substring(_startpos,_exprpos).toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 1486;BA.debugLine="SkipSpaces";
_skipspaces();
 //BA.debugLineNum = 1489;BA.debugLine="If Name = \"FN\" Then";
if ((_name).equals("FN")) { 
 //BA.debugLineNum = 1492;BA.debugLine="Dim FunctionStart As Int = ExprPos";
_functionstart = _exprpos;
 //BA.debugLineNum = 1494;BA.debugLine="Do While ExprPos < ExprText.Length";
while (_exprpos<_exprtext.length()) {
 //BA.debugLineNum = 1495;BA.debugLine="Ch = ExprText.SubString2(ExprPos, ExprPos + 1)";
_ch = _exprtext.substring(_exprpos,(int) (_exprpos+1));
 //BA.debugLineNum = 1497;BA.debugLine="If (Ch.CompareTo(\"A\") >= 0 And Ch.CompareTo(\"Z\"";
if ((_ch.compareTo("A")>=0 && _ch.compareTo("Z")<=0) || (_ch.compareTo("a")>=0 && _ch.compareTo("z")<=0) || __c.IsNumber(_ch)) { 
 //BA.debugLineNum = 1500;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 }else {
 //BA.debugLineNum = 1502;BA.debugLine="Exit";
if (true) break;
 };
 }
;
 //BA.debugLineNum = 1506;BA.debugLine="If ExprPos = FunctionStart Then";
if (_exprpos==_functionstart) { 
 //BA.debugLineNum = 1507;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1508;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1511;BA.debugLine="Dim FunctionName As String = _ 			ExprText.SubSt";
_functionname = _exprtext.substring(_functionstart,_exprpos).toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 1514;BA.debugLine="SkipSpaces";
_skipspaces();
 //BA.debugLineNum = 1517;BA.debugLine="If ExprPos >= ExprText.Length Or _ 			ExprText.S";
if (_exprpos>=_exprtext.length() || (_exprtext.substring(_exprpos,(int) (_exprpos+1))).equals("(") == false) { 
 //BA.debugLineNum = 1519;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1520;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1523;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 //BA.debugLineNum = 1526;BA.debugLine="Dim Arguments As List";
_arguments = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1527;BA.debugLine="Arguments.Initialize";
_arguments.Initialize();
 //BA.debugLineNum = 1529;BA.debugLine="Do While ExprError = False";
while (_exprerror==__c.False) {
 //BA.debugLineNum = 1531;BA.debugLine="Dim Argument As Double = ParseExpression";
_argument = _parseexpression();
 //BA.debugLineNum = 1533;BA.debugLine="If ExprError Then Return 0";
if (_exprerror) { 
if (true) return 0;};
 //BA.debugLineNum = 1535;BA.debugLine="Arguments.Add(Argument)";
_arguments.Add((Object)(_argument));
 //BA.debugLineNum = 1537;BA.debugLine="SkipSpaces";
_skipspaces();
 //BA.debugLineNum = 1539;BA.debugLine="If ExprPos >= ExprText.Length Then";
if (_exprpos>=_exprtext.length()) { 
 //BA.debugLineNum = 1540;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1541;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1544;BA.debugLine="Dim Separator As String = ExprText.SubString2(E";
_separator = _exprtext.substring(_exprpos,(int) (_exprpos+1));
 //BA.debugLineNum = 1546;BA.debugLine="If Separator = \")\" Then";
if ((_separator).equals(")")) { 
 //BA.debugLineNum = 1547;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 //BA.debugLineNum = 1548;BA.debugLine="Exit";
if (true) break;
 }else if((_separator).equals(",")) { 
 //BA.debugLineNum = 1550;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 }else {
 //BA.debugLineNum = 1552;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1553;BA.debugLine="Return 0";
if (true) return 0;
 };
 }
;
 //BA.debugLineNum = 1558;BA.debugLine="Return EvaluateUserFunction(FunctionName, Argume";
if (true) return _evaluateuserfunction(_functionname,_arguments);
 };
 //BA.debugLineNum = 1561;BA.debugLine="If ExprPos < ExprText.Length Then";
if (_exprpos<_exprtext.length()) { 
 };
 //BA.debugLineNum = 1566;BA.debugLine="If ExprPos < ExprText.Length Then";
if (_exprpos<_exprtext.length()) { 
 //BA.debugLineNum = 1567;BA.debugLine="If ExprText.SubString2(ExprPos, ExprPos + 1) = \"";
if ((_exprtext.substring(_exprpos,(int) (_exprpos+1))).equals("(")) { 
 //BA.debugLineNum = 1569;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 //BA.debugLineNum = 1572;BA.debugLine="If Name = \"INSTR\" Then";
if ((_name).equals("INSTR")) { 
 //BA.debugLineNum = 1573;BA.debugLine="Dim SearchText As String = ReadStringFunctionA";
_searchtext = _readstringfunctionargument();
 //BA.debugLineNum = 1575;BA.debugLine="If ExprError Then Return 0";
if (_exprerror) { 
if (true) return 0;};
 //BA.debugLineNum = 1577;BA.debugLine="SkipSpaces";
_skipspaces();
 //BA.debugLineNum = 1579;BA.debugLine="If ExprPos >= ExprText.Length Or _ 					ExprTe";
if (_exprpos>=_exprtext.length() || (_exprtext.substring(_exprpos,(int) (_exprpos+1))).equals(",") == false) { 
 //BA.debugLineNum = 1581;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1582;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1585;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 //BA.debugLineNum = 1587;BA.debugLine="Dim SearchFor As String = ReadStringFunctionAr";
_searchfor = _readstringfunctionargument();
 //BA.debugLineNum = 1589;BA.debugLine="If ExprError Then Return 0";
if (_exprerror) { 
if (true) return 0;};
 //BA.debugLineNum = 1591;BA.debugLine="SkipSpaces";
_skipspaces();
 //BA.debugLineNum = 1593;BA.debugLine="If ExprPos >= ExprText.Length Or _ 					ExprTe";
if (_exprpos>=_exprtext.length() || (_exprtext.substring(_exprpos,(int) (_exprpos+1))).equals(")") == false) { 
 //BA.debugLineNum = 1595;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1596;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1599;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 //BA.debugLineNum = 1601;BA.debugLine="Dim FoundPosition As Int = SearchText.IndexOf(";
_foundposition = _searchtext.indexOf(_searchfor);
 //BA.debugLineNum = 1603;BA.debugLine="If FoundPosition < 0 Then Return 0";
if (_foundposition<0) { 
if (true) return 0;};
 //BA.debugLineNum = 1605;BA.debugLine="Return FoundPosition + 1";
if (true) return _foundposition+1;
 };
 //BA.debugLineNum = 1609;BA.debugLine="If Name = \"LEN\" Or Name = \"VAL\" Or Name = \"ASC\"";
if ((_name).equals("LEN") || (_name).equals("VAL") || (_name).equals("ASC")) { 
 //BA.debugLineNum = 1611;BA.debugLine="Dim StringArgumentStart As Int = ExprPos";
_stringargumentstart = _exprpos;
 //BA.debugLineNum = 1612;BA.debugLine="Dim StringArgumentEnd As Int = -1";
_stringargumentend = (int) (-1);
 //BA.debugLineNum = 1613;BA.debugLine="Dim StringBracketLevel As Int = 0";
_stringbracketlevel = (int) (0);
 //BA.debugLineNum = 1614;BA.debugLine="Dim StringInQuotes As Boolean = False";
_stringinquotes = __c.False;
 //BA.debugLineNum = 1617;BA.debugLine="Do While ExprPos < ExprText.Length";
while (_exprpos<_exprtext.length()) {
 //BA.debugLineNum = 1618;BA.debugLine="Dim ScanChar As String = ExprText.SubString2(";
_scanchar = _exprtext.substring(_exprpos,(int) (_exprpos+1));
 //BA.debugLineNum = 1620;BA.debugLine="If ScanChar = Chr(34) Then";
if ((_scanchar).equals(BA.ObjectToString(__c.Chr((int) (34))))) { 
 //BA.debugLineNum = 1621;BA.debugLine="StringInQuotes = Not(StringInQuotes)";
_stringinquotes = __c.Not(_stringinquotes);
 }else if(_stringinquotes==__c.False) { 
 //BA.debugLineNum = 1624;BA.debugLine="If ScanChar = \"(\" Then";
if ((_scanchar).equals("(")) { 
 //BA.debugLineNum = 1625;BA.debugLine="StringBracketLevel = StringBracketLevel + 1";
_stringbracketlevel = (int) (_stringbracketlevel+1);
 }else if((_scanchar).equals(")")) { 
 //BA.debugLineNum = 1628;BA.debugLine="If StringBracketLevel = 0 Then";
if (_stringbracketlevel==0) { 
 //BA.debugLineNum = 1629;BA.debugLine="StringArgumentEnd = ExprPos";
_stringargumentend = _exprpos;
 //BA.debugLineNum = 1630;BA.debugLine="Exit";
if (true) break;
 }else {
 //BA.debugLineNum = 1632;BA.debugLine="StringBracketLevel = StringBracketLevel -";
_stringbracketlevel = (int) (_stringbracketlevel-1);
 };
 };
 };
 //BA.debugLineNum = 1637;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 }
;
 //BA.debugLineNum = 1640;BA.debugLine="If StringArgumentEnd < 0 Or StringInQuotes The";
if (_stringargumentend<0 || _stringinquotes) { 
 //BA.debugLineNum = 1641;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1642;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1645;BA.debugLine="Dim StringExpressionText As String = _ 					Ex";
_stringexpressiontext = _exprtext.substring(_stringargumentstart,_stringargumentend);
 //BA.debugLineNum = 1649;BA.debugLine="ExprPos = StringArgumentEnd + 1";
_exprpos = (int) (_stringargumentend+1);
 //BA.debugLineNum = 1652;BA.debugLine="Dim SavedExprText As String = ExprText";
_savedexprtext = _exprtext;
 //BA.debugLineNum = 1653;BA.debugLine="Dim SavedExprPos As Int = ExprPos";
_savedexprpos = _exprpos;
 //BA.debugLineNum = 1655;BA.debugLine="Dim StringFunctionValue As String = EvaluateSt";
_stringfunctionvalue = _evaluatestringexpression(_stringexpressiontext);
 //BA.debugLineNum = 1657;BA.debugLine="ExprText = SavedExprText";
_exprtext = _savedexprtext;
 //BA.debugLineNum = 1658;BA.debugLine="ExprPos = SavedExprPos";
_exprpos = _savedexprpos;
 //BA.debugLineNum = 1660;BA.debugLine="If ExprError Then Return 0";
if (_exprerror) { 
if (true) return 0;};
 //BA.debugLineNum = 1662;BA.debugLine="If Name = \"LEN\" Then";
if ((_name).equals("LEN")) { 
 //BA.debugLineNum = 1663;BA.debugLine="Return StringFunctionValue.Length";
if (true) return _stringfunctionvalue.length();
 }else if((_name).equals("ASC")) { 
 //BA.debugLineNum = 1666;BA.debugLine="If StringFunctionValue.Length = 0 Then";
if (_stringfunctionvalue.length()==0) { 
 //BA.debugLineNum = 1667;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1668;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1671;BA.debugLine="Return Asc(StringFunctionValue)";
if (true) return __c.Asc(BA.ObjectToChar(_stringfunctionvalue));
 }else {
 //BA.debugLineNum = 1675;BA.debugLine="If IsNumber(StringFunctionValue) = False Then";
if (__c.IsNumber(_stringfunctionvalue)==__c.False) { 
 //BA.debugLineNum = 1676;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1677;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1680;BA.debugLine="Return StringFunctionValue";
if (true) return (double)(Double.parseDouble(_stringfunctionvalue));
 };
 };
 //BA.debugLineNum = 1685;BA.debugLine="If Arrays.ContainsKey(Name) Then";
if (_arrays.ContainsKey((Object)(_name))) { 
 //BA.debugLineNum = 1687;BA.debugLine="Dim IndexValue As Double = ParseExpression";
_indexvalue = _parseexpression();
 //BA.debugLineNum = 1689;BA.debugLine="SkipSpaces";
_skipspaces();
 //BA.debugLineNum = 1691;BA.debugLine="If ExprError Or ExprPos >= ExprText.Length The";
if (_exprerror || _exprpos>=_exprtext.length()) { 
 //BA.debugLineNum = 1692;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1693;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1696;BA.debugLine="If ExprText.SubString2(ExprPos, ExprPos + 1) <";
if ((_exprtext.substring(_exprpos,(int) (_exprpos+1))).equals(")") == false) { 
 //BA.debugLineNum = 1697;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1698;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1701;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 //BA.debugLineNum = 1704;BA.debugLine="If IndexValue < 1 Or IndexValue <> Floor(Index";
if (_indexvalue<1 || _indexvalue!=__c.Floor(_indexvalue)) { 
 //BA.debugLineNum = 1705;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1706;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1709;BA.debugLine="Dim Values As List = Arrays.Get(Name)";
_values = new anywheresoftware.b4a.objects.collections.List();
_values = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_arrays.Get((Object)(_name))));
 //BA.debugLineNum = 1711;BA.debugLine="If IndexValue > Values.Size Then";
if (_indexvalue>_values.getSize()) { 
 //BA.debugLineNum = 1712;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1713;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1716;BA.debugLine="Dim ArrayValue As String = Values.Get(IndexVal";
_arrayvalue = BA.ObjectToString(_values.Get((int) (_indexvalue-1)));
 //BA.debugLineNum = 1718;BA.debugLine="If IsNumber(ArrayValue) = False Then";
if (__c.IsNumber(_arrayvalue)==__c.False) { 
 //BA.debugLineNum = 1719;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1720;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1723;BA.debugLine="Return ArrayValue";
if (true) return (double)(Double.parseDouble(_arrayvalue));
 };
 //BA.debugLineNum = 1728;BA.debugLine="If Name = \"UBOUND\" Then";
if ((_name).equals("UBOUND")) { 
 //BA.debugLineNum = 1730;BA.debugLine="SkipSpaces";
_skipspaces();
 //BA.debugLineNum = 1732;BA.debugLine="If ExprPos >= ExprText.Length Then";
if (_exprpos>=_exprtext.length()) { 
 //BA.debugLineNum = 1733;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1734;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1737;BA.debugLine="Dim ArrayName As String = \"\"";
_arrayname = "";
 //BA.debugLineNum = 1740;BA.debugLine="Do While ExprPos < ExprText.Length";
while (_exprpos<_exprtext.length()) {
 //BA.debugLineNum = 1742;BA.debugLine="Dim c As String = ExprText.SubString2(ExprPos";
_c = _exprtext.substring(_exprpos,(int) (_exprpos+1));
 //BA.debugLineNum = 1744;BA.debugLine="If c = \")\" Then Exit";
if ((_c).equals(")")) { 
if (true) break;};
 //BA.debugLineNum = 1746;BA.debugLine="ArrayName = ArrayName & c";
_arrayname = _arrayname+_c;
 //BA.debugLineNum = 1747;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 }
;
 //BA.debugLineNum = 1751;BA.debugLine="ArrayName = ArrayName.Trim";
_arrayname = _arrayname.trim();
 //BA.debugLineNum = 1753;BA.debugLine="If ExprPos >= ExprText.Length Then";
if (_exprpos>=_exprtext.length()) { 
 //BA.debugLineNum = 1754;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1755;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1758;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 //BA.debugLineNum = 1760;BA.debugLine="If Arrays.ContainsKey(ArrayName) = False Then";
if (_arrays.ContainsKey((Object)(_arrayname))==__c.False) { 
 //BA.debugLineNum = 1761;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1762;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1765;BA.debugLine="Dim Values As List = Arrays.Get(ArrayName)";
_values = new anywheresoftware.b4a.objects.collections.List();
_values = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_arrays.Get((Object)(_arrayname))));
 //BA.debugLineNum = 1767;BA.debugLine="Return Values.Size";
if (true) return _values.getSize();
 };
 //BA.debugLineNum = 1772;BA.debugLine="Dim Argument As Double = ParseExpression";
_argument = _parseexpression();
 //BA.debugLineNum = 1774;BA.debugLine="SkipSpaces";
_skipspaces();
 //BA.debugLineNum = 1776;BA.debugLine="If ExprError Or ExprPos >= ExprText.Length Then";
if (_exprerror || _exprpos>=_exprtext.length()) { 
 //BA.debugLineNum = 1777;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1778;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1781;BA.debugLine="If ExprText.SubString2(ExprPos, ExprPos + 1) <>";
if ((_exprtext.substring(_exprpos,(int) (_exprpos+1))).equals(")") == false) { 
 //BA.debugLineNum = 1782;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1783;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1786;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 //BA.debugLineNum = 1788;BA.debugLine="Select Case Name";
switch (BA.switchObjectToInt(_name,"SQR","ABS","INT","SIN","COS","TAN","LOG","EXP","SGN","RND")) {
case 0: {
 //BA.debugLineNum = 1790;BA.debugLine="If Argument < 0 Then";
if (_argument<0) { 
 //BA.debugLineNum = 1791;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1792;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1794;BA.debugLine="Return Sqrt(Argument)";
if (true) return __c.Sqrt(_argument);
 break; }
case 1: {
 //BA.debugLineNum = 1797;BA.debugLine="Return Abs(Argument)";
if (true) return __c.Abs(_argument);
 break; }
case 2: {
 //BA.debugLineNum = 1800;BA.debugLine="Return Floor(Argument)";
if (true) return __c.Floor(_argument);
 break; }
case 3: {
 //BA.debugLineNum = 1803;BA.debugLine="Return Sin(Argument * cPI / 180)";
if (true) return __c.Sin(_argument*__c.cPI/(double)180);
 break; }
case 4: {
 //BA.debugLineNum = 1806;BA.debugLine="Return Cos(Argument * cPI / 180)";
if (true) return __c.Cos(_argument*__c.cPI/(double)180);
 break; }
case 5: {
 //BA.debugLineNum = 1809;BA.debugLine="Return Tan(Argument * cPI / 180)";
if (true) return __c.Tan(_argument*__c.cPI/(double)180);
 break; }
case 6: {
 //BA.debugLineNum = 1812;BA.debugLine="If Argument <= 0 Then";
if (_argument<=0) { 
 //BA.debugLineNum = 1813;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1814;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1816;BA.debugLine="Return Logarithm(Argument, cE)";
if (true) return __c.Logarithm(_argument,__c.cE);
 break; }
case 7: {
 //BA.debugLineNum = 1819;BA.debugLine="Return Power(cE, Argument)";
if (true) return __c.Power(__c.cE,_argument);
 break; }
case 8: {
 //BA.debugLineNum = 1822;BA.debugLine="If Argument < 0 Then Return -1";
if (_argument<0) { 
if (true) return -1;};
 //BA.debugLineNum = 1823;BA.debugLine="If Argument > 0 Then Return 1";
if (_argument>0) { 
if (true) return 1;};
 //BA.debugLineNum = 1824;BA.debugLine="Return 0";
if (true) return 0;
 break; }
case 9: {
 //BA.debugLineNum = 1827;BA.debugLine="Return Rnd(0, 1000000) / 1000000";
if (true) return __c.Rnd((int) (0),(int) (1000000))/(double)1000000;
 break; }
default: {
 //BA.debugLineNum = 1830;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1831;BA.debugLine="Return 0";
if (true) return 0;
 break; }
}
;
 };
 };
 //BA.debugLineNum = 1837;BA.debugLine="If Name = \"ERR\" Then Return ErrorCode";
if ((_name).equals("ERR")) { 
if (true) return _errorcode;};
 //BA.debugLineNum = 1838;BA.debugLine="If Name = \"ERL\" Then Return ErrorLineNumber";
if ((_name).equals("ERL")) { 
if (true) return _errorlinenumber;};
 //BA.debugLineNum = 1841;BA.debugLine="If Variables.ContainsKey(Name) = False Then";
if (_variables.ContainsKey((Object)(_name))==__c.False) { 
 //BA.debugLineNum = 1842;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1843;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1846;BA.debugLine="Dim VariableValue As String = Variables.Get(Name)";
_variablevalue = BA.ObjectToString(_variables.Get((Object)(_name)));
 //BA.debugLineNum = 1849;BA.debugLine="If IsNumber(VariableValue) = False Then";
if (__c.IsNumber(_variablevalue)==__c.False) { 
 //BA.debugLineNum = 1850;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1851;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1854;BA.debugLine="Return VariableValue";
if (true) return (double)(Double.parseDouble(_variablevalue));
 //BA.debugLineNum = 1855;BA.debugLine="End Sub";
return 0;
}
public double  _parseterm() throws Exception{
double _result = 0;
String _op = "";
double _value = 0;
 //BA.debugLineNum = 1364;BA.debugLine="Private Sub ParseTerm As Double";
 //BA.debugLineNum = 1365;BA.debugLine="Dim Result As Double = ParseFactor";
_result = _parsefactor();
 //BA.debugLineNum = 1367;BA.debugLine="Do While ExprPos < ExprText.Length And ExprError";
while (_exprpos<_exprtext.length() && _exprerror==__c.False) {
 //BA.debugLineNum = 1368;BA.debugLine="SkipSpaces";
_skipspaces();
 //BA.debugLineNum = 1370;BA.debugLine="If ExprPos >= ExprText.Length Then Exit";
if (_exprpos>=_exprtext.length()) { 
if (true) break;};
 //BA.debugLineNum = 1372;BA.debugLine="Dim Op As String = ExprText.SubString2(ExprPos,";
_op = _exprtext.substring(_exprpos,(int) (_exprpos+1));
 //BA.debugLineNum = 1374;BA.debugLine="If Op = \"*\" Or Op = \"/\" Then";
if ((_op).equals("*") || (_op).equals("/")) { 
 //BA.debugLineNum = 1375;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 //BA.debugLineNum = 1377;BA.debugLine="Dim Value As Double = ParseFactor";
_value = _parsefactor();
 //BA.debugLineNum = 1379;BA.debugLine="If ExprError Then Return 0";
if (_exprerror) { 
if (true) return 0;};
 //BA.debugLineNum = 1381;BA.debugLine="If Op = \"*\" Then";
if ((_op).equals("*")) { 
 //BA.debugLineNum = 1382;BA.debugLine="Result = Result * Value";
_result = _result*_value;
 }else {
 //BA.debugLineNum = 1384;BA.debugLine="If Value = 0 Then";
if (_value==0) { 
 //BA.debugLineNum = 1385;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1386;BA.debugLine="ExprErrorCode = 11";
_exprerrorcode = (int) (11);
 //BA.debugLineNum = 1387;BA.debugLine="Return 0";
if (true) return 0;
 };
 //BA.debugLineNum = 1389;BA.debugLine="Result = Result / Value";
_result = _result/(double)_value;
 };
 }else {
 //BA.debugLineNum = 1392;BA.debugLine="Exit";
if (true) break;
 };
 }
;
 //BA.debugLineNum = 1396;BA.debugLine="Return Result";
if (true) return _result;
 //BA.debugLineNum = 1397;BA.debugLine="End Sub";
return 0;
}
public boolean  _prepareserialcommand(String _command) throws Exception{
anywheresoftware.b4a.objects.collections.List _parts = null;
String _text = "";
int _position = 0;
int _startpos = 0;
int _level = 0;
String _ch = "";
String _expression = "";
double _value = 0;
String _normalizedcommand = "";
 //BA.debugLineNum = 3941;BA.debugLine="Private Sub PrepareSerialCommand(Command As String";
 //BA.debugLineNum = 3943;BA.debugLine="Dim Parts As List";
_parts = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 3944;BA.debugLine="Parts.Initialize";
_parts.Initialize();
 //BA.debugLineNum = 3946;BA.debugLine="Dim Text As String = Command.Trim";
_text = _command.trim();
 //BA.debugLineNum = 3947;BA.debugLine="Dim Position As Int = 4";
_position = (int) (4);
 //BA.debugLineNum = 3949;BA.debugLine="Do While Position < Text.Length And Parts.Size <";
while (_position<_text.length() && _parts.getSize()<3) {
 //BA.debugLineNum = 3952;BA.debugLine="Do While Position < Text.Length And Text.SubStri";
while (_position<_text.length() && (_text.substring(_position,(int) (_position+1))).equals(" ")) {
 //BA.debugLineNum = 3953;BA.debugLine="Position = Position + 1";
_position = (int) (_position+1);
 }
;
 //BA.debugLineNum = 3956;BA.debugLine="If Position >= Text.Length Then Exit";
if (_position>=_text.length()) { 
if (true) break;};
 //BA.debugLineNum = 3958;BA.debugLine="Dim StartPos As Int = Position";
_startpos = _position;
 //BA.debugLineNum = 3959;BA.debugLine="Dim Level As Int = 0";
_level = (int) (0);
 //BA.debugLineNum = 3962;BA.debugLine="Do While Position < Text.Length";
while (_position<_text.length()) {
 //BA.debugLineNum = 3964;BA.debugLine="Dim Ch As String = Text.SubString2(Position, Po";
_ch = _text.substring(_position,(int) (_position+1));
 //BA.debugLineNum = 3966;BA.debugLine="If Ch = \"(\" Then";
if ((_ch).equals("(")) { 
 //BA.debugLineNum = 3967;BA.debugLine="Level = Level + 1";
_level = (int) (_level+1);
 }else if((_ch).equals(")")) { 
 //BA.debugLineNum = 3969;BA.debugLine="Level = Level - 1";
_level = (int) (_level-1);
 //BA.debugLineNum = 3970;BA.debugLine="If Level < 0 Then Return False";
if (_level<0) { 
if (true) return __c.False;};
 }else if((_ch).equals(" ") && _level==0) { 
 //BA.debugLineNum = 3972;BA.debugLine="Exit";
if (true) break;
 };
 //BA.debugLineNum = 3975;BA.debugLine="Position = Position + 1";
_position = (int) (_position+1);
 }
;
 //BA.debugLineNum = 3978;BA.debugLine="If Level <> 0 Then Return False";
if (_level!=0) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3980;BA.debugLine="Dim Expression As String = Text.SubString2(Start";
_expression = _text.substring(_startpos,_position).trim();
 //BA.debugLineNum = 3981;BA.debugLine="If Expression = \"\" Then Return False";
if ((_expression).equals("")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3983;BA.debugLine="Dim Value As Double = EvaluateNumericExpression(";
_value = _evaluatenumericexpression(_expression);
 //BA.debugLineNum = 3985;BA.debugLine="If ExprError Then Return False";
if (_exprerror) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3987;BA.debugLine="If Value < 0 Or Value > 255 Or Value <> Floor(Va";
if (_value<0 || _value>255 || _value!=__c.Floor(_value)) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3989;BA.debugLine="Parts.Add(Value)";
_parts.Add((Object)(_value));
 }
;
 //BA.debugLineNum = 3993;BA.debugLine="If Parts.Size <> 3 Then Return False";
if (_parts.getSize()!=3) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3996;BA.debugLine="Do While Position < Text.Length";
while (_position<_text.length()) {
 //BA.debugLineNum = 3997;BA.debugLine="If Text.SubString2(Position, Position + 1) <> \"";
if ((_text.substring(_position,(int) (_position+1))).equals(" ") == false) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3998;BA.debugLine="Position = Position + 1";
_position = (int) (_position+1);
 }
;
 //BA.debugLineNum = 4001;BA.debugLine="Dim NormalizedCommand As String = _         \"@SER";
_normalizedcommand = "@SER "+BA.ObjectToString(_parts.Get((int) (0)))+" "+BA.ObjectToString(_parts.Get((int) (1)))+" "+BA.ObjectToString(_parts.Get((int) (2)));
 //BA.debugLineNum = 4004;BA.debugLine="RaiseHardwareCommand(NormalizedCommand)";
_raisehardwarecommand(_normalizedcommand);
 //BA.debugLineNum = 4006;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 4008;BA.debugLine="End Sub";
return false;
}
public boolean  _printbasictext(String _linecode) throws Exception{
String _value = "";
anywheresoftware.b4a.objects.collections.List _items = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _currentitem = null;
boolean _inquotes = false;
int _bracketlevel = 0;
String _lastseparator = "";
int _i = 0;
String _currentchar = "";
String _output = "";
int _column = 0;
String _item = "";
int _spaces = 0;
String _argument = "";
double _targetcolumn = 0;
double _spacecount = 0;
String _itemvalue = "";
 //BA.debugLineNum = 1104;BA.debugLine="Private Sub PrintBasicText(LineCode As String) As";
 //BA.debugLineNum = 1106;BA.debugLine="If LineCode.Trim.ToUpperCase = \"PRINT\" Then";
if ((_linecode.trim().toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale)).equals("PRINT")) { 
 //BA.debugLineNum = 1107;BA.debugLine="RaiseOutput(\"\")";
_raiseoutput("");
 //BA.debugLineNum = 1108;BA.debugLine="Return True";
if (true) return __c.True;
 };
 //BA.debugLineNum = 1111;BA.debugLine="Dim Value As String = LineCode.SubString(6).Trim";
_value = _linecode.substring((int) (6)).trim();
 //BA.debugLineNum = 1112;BA.debugLine="Dim Items As List";
_items = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1113;BA.debugLine="Items.Initialize";
_items.Initialize();
 //BA.debugLineNum = 1115;BA.debugLine="Dim CurrentItem As StringBuilder";
_currentitem = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 1116;BA.debugLine="CurrentItem.Initialize";
_currentitem.Initialize();
 //BA.debugLineNum = 1118;BA.debugLine="Dim InQuotes As Boolean = False";
_inquotes = __c.False;
 //BA.debugLineNum = 1119;BA.debugLine="Dim BracketLevel As Int = 0";
_bracketlevel = (int) (0);
 //BA.debugLineNum = 1120;BA.debugLine="Dim LastSeparator As String = \"\"";
_lastseparator = "";
 //BA.debugLineNum = 1123;BA.debugLine="For i = 0 To Value.Length - 1";
{
final int step13 = 1;
final int limit13 = (int) (_value.length()-1);
_i = (int) (0) ;
for (;_i <= limit13 ;_i = _i + step13 ) {
 //BA.debugLineNum = 1124;BA.debugLine="Dim CurrentChar As String = Value.SubString2(i,";
_currentchar = _value.substring(_i,(int) (_i+1));
 //BA.debugLineNum = 1126;BA.debugLine="If CurrentChar = Chr(34) Then";
if ((_currentchar).equals(BA.ObjectToString(__c.Chr((int) (34))))) { 
 //BA.debugLineNum = 1127;BA.debugLine="InQuotes = Not(InQuotes)";
_inquotes = __c.Not(_inquotes);
 }else if(_inquotes==__c.False) { 
 //BA.debugLineNum = 1129;BA.debugLine="If CurrentChar = \"(\" Then BracketLevel = Bracke";
if ((_currentchar).equals("(")) { 
_bracketlevel = (int) (_bracketlevel+1);};
 //BA.debugLineNum = 1130;BA.debugLine="If CurrentChar = \")\" Then BracketLevel = Bracke";
if ((_currentchar).equals(")")) { 
_bracketlevel = (int) (_bracketlevel-1);};
 //BA.debugLineNum = 1132;BA.debugLine="If (CurrentChar = \";\" Or CurrentChar = \",\") And";
if (((_currentchar).equals(";") || (_currentchar).equals(",")) && _bracketlevel==0) { 
 //BA.debugLineNum = 1133;BA.debugLine="Items.Add(CurrentItem.ToString.Trim)";
_items.Add((Object)(_currentitem.ToString().trim()));
 //BA.debugLineNum = 1134;BA.debugLine="Items.Add(CurrentChar)";
_items.Add((Object)(_currentchar));
 //BA.debugLineNum = 1135;BA.debugLine="CurrentItem.Initialize";
_currentitem.Initialize();
 //BA.debugLineNum = 1136;BA.debugLine="LastSeparator = CurrentChar";
_lastseparator = _currentchar;
 //BA.debugLineNum = 1137;BA.debugLine="Continue";
if (true) continue;
 };
 };
 //BA.debugLineNum = 1141;BA.debugLine="CurrentItem.Append(CurrentChar)";
_currentitem.Append(_currentchar);
 //BA.debugLineNum = 1142;BA.debugLine="LastSeparator = \"\"";
_lastseparator = "";
 }
};
 //BA.debugLineNum = 1145;BA.debugLine="If CurrentItem.Length > 0 Then Items.Add(CurrentI";
if (_currentitem.getLength()>0) { 
_items.Add((Object)(_currentitem.ToString().trim()));};
 //BA.debugLineNum = 1148;BA.debugLine="Dim Output As String = \"\"";
_output = "";
 //BA.debugLineNum = 1149;BA.debugLine="Dim Column As Int = 0";
_column = (int) (0);
 //BA.debugLineNum = 1151;BA.debugLine="For Each Item As String In Items";
{
final anywheresoftware.b4a.BA.IterableList group34 = _items;
final int groupLen34 = group34.getSize()
;int index34 = 0;
;
for (; index34 < groupLen34;index34++){
_item = BA.ObjectToString(group34.Get(index34));
 //BA.debugLineNum = 1152;BA.debugLine="If Item = \";\" Then";
if ((_item).equals(";")) { 
 //BA.debugLineNum = 1153;BA.debugLine="Continue";
if (true) continue;
 }else if((_item).equals(",")) { 
 //BA.debugLineNum = 1156;BA.debugLine="Dim Spaces As Int = 14 - (Column Mod 14)";
_spaces = (int) (14-(_column%14));
 //BA.debugLineNum = 1157;BA.debugLine="Output = Output & SpaceString(Spaces)";
_output = _output+_spacestring(_spaces);
 //BA.debugLineNum = 1158;BA.debugLine="Column = Column + Spaces";
_column = (int) (_column+_spaces);
 }else if(_item.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale).startsWith("TAB(") && _item.endsWith(")")) { 
 //BA.debugLineNum = 1161;BA.debugLine="Dim Argument As String = Item.SubString2(4, Ite";
_argument = _item.substring((int) (4),(int) (_item.length()-1));
 //BA.debugLineNum = 1162;BA.debugLine="Dim TargetColumn As Double = EvaluateNumericExp";
_targetcolumn = _evaluatenumericexpression(_argument);
 //BA.debugLineNum = 1164;BA.debugLine="If ExprError Then Return False";
if (_exprerror) { 
if (true) return __c.False;};
 //BA.debugLineNum = 1166;BA.debugLine="If TargetColumn < 1 Then";
if (_targetcolumn<1) { 
 //BA.debugLineNum = 1167;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1168;BA.debugLine="ExprErrorCode = 20";
_exprerrorcode = (int) (20);
 //BA.debugLineNum = 1169;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 1172;BA.debugLine="Dim Spaces As Int = TargetColumn - 1 - Column";
_spaces = (int) (_targetcolumn-1-_column);
 //BA.debugLineNum = 1173;BA.debugLine="If Spaces > 0 Then Output = Output & SpaceStrin";
if (_spaces>0) { 
_output = _output+_spacestring(_spaces);};
 //BA.debugLineNum = 1174;BA.debugLine="If Spaces > 0 Then Column = Column + Spaces";
if (_spaces>0) { 
_column = (int) (_column+_spaces);};
 }else if(_item.toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale).startsWith("SPC(") && _item.endsWith(")")) { 
 //BA.debugLineNum = 1177;BA.debugLine="Dim Argument As String = Item.SubString2(4, Ite";
_argument = _item.substring((int) (4),(int) (_item.length()-1));
 //BA.debugLineNum = 1178;BA.debugLine="Dim SpaceCount As Double = EvaluateNumericExpre";
_spacecount = _evaluatenumericexpression(_argument);
 //BA.debugLineNum = 1180;BA.debugLine="If ExprError Then Return False";
if (_exprerror) { 
if (true) return __c.False;};
 //BA.debugLineNum = 1182;BA.debugLine="If SpaceCount < 0 Then";
if (_spacecount<0) { 
 //BA.debugLineNum = 1183;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1184;BA.debugLine="ExprErrorCode = 20";
_exprerrorcode = (int) (20);
 //BA.debugLineNum = 1185;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 1188;BA.debugLine="Dim Spaces As Int = SpaceCount";
_spaces = (int) (_spacecount);
 //BA.debugLineNum = 1189;BA.debugLine="Output = Output & SpaceString(Spaces)";
_output = _output+_spacestring(_spaces);
 //BA.debugLineNum = 1190;BA.debugLine="Column = Column + Spaces";
_column = (int) (_column+_spaces);
 }else {
 //BA.debugLineNum = 1193;BA.debugLine="Dim ItemValue As String = EvaluatePrintItem(Ite";
_itemvalue = _evaluateprintitem(_item);
 //BA.debugLineNum = 1195;BA.debugLine="If ExprError Then";
if (_exprerror) { 
 //BA.debugLineNum = 1196;BA.debugLine="If ExprErrorCode = 0 Then ExprErrorCode = 20";
if (_exprerrorcode==0) { 
_exprerrorcode = (int) (20);};
 //BA.debugLineNum = 1197;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 1200;BA.debugLine="Output = Output & ItemValue";
_output = _output+_itemvalue;
 //BA.debugLineNum = 1201;BA.debugLine="Column = Column + ItemValue.Length";
_column = (int) (_column+_itemvalue.length());
 };
 }
};
 //BA.debugLineNum = 1207;BA.debugLine="If LastSeparator = \";\" Or LastSeparator = \",\" The";
if ((_lastseparator).equals(";") || (_lastseparator).equals(",")) { 
 //BA.debugLineNum = 1208;BA.debugLine="RaiseOutputInline(Output)";
_raiseoutputinline(_output);
 }else {
 //BA.debugLineNum = 1210;BA.debugLine="RaiseOutput(Output)";
_raiseoutput(_output);
 };
 //BA.debugLineNum = 1213;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 1214;BA.debugLine="End Sub";
return false;
}
public String  _raisehardwarecommand(String _command) throws Exception{
 //BA.debugLineNum = 3241;BA.debugLine="Private Sub RaiseHardwareCommand(Command As String";
 //BA.debugLineNum = 3242;BA.debugLine="Utils.CallSubMethod2(mCallback, mEventName, \"_Har";
_utils._callsubmethod2 /*String*/ (_mcallback,_meventname,"_HardwareCommand",(Object)(_command));
 //BA.debugLineNum = 3243;BA.debugLine="End Sub";
return "";
}
public String  _raiseoutput(String _value) throws Exception{
 //BA.debugLineNum = 101;BA.debugLine="Private Sub RaiseOutput(Value As String)";
 //BA.debugLineNum = 102;BA.debugLine="Utils.CallSubMethod3(mCallback, mEventName, \"_Out";
_utils._callsubmethod3 /*String*/ (_mcallback,_meventname,"_Output",(Object)(_value),(Object)(__c.True));
 //BA.debugLineNum = 103;BA.debugLine="End Sub";
return "";
}
public String  _raiseoutputinline(String _value) throws Exception{
 //BA.debugLineNum = 105;BA.debugLine="Private Sub RaiseOutputInline(Value As String)";
 //BA.debugLineNum = 106;BA.debugLine="Utils.CallSubMethod3(mCallback, mEventName, \"_Out";
_utils._callsubmethod3 /*String*/ (_mcallback,_meventname,"_Output",(Object)(_value),(Object)(__c.False));
 //BA.debugLineNum = 107;BA.debugLine="End Sub";
return "";
}
public String  _raiseready() throws Exception{
 //BA.debugLineNum = 109;BA.debugLine="Private Sub RaiseReady";
 //BA.debugLineNum = 110;BA.debugLine="Utils.CallSubMethod(mCallback, mEventName, \"_Read";
_utils._callsubmethod /*String*/ (_mcallback,_meventname,"_Ready");
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return "";
}
public String  _raisesystemcommand(String _command) throws Exception{
 //BA.debugLineNum = 3267;BA.debugLine="Private Sub RaiseSystemCommand(Command As String)";
 //BA.debugLineNum = 3268;BA.debugLine="Utils.CallSubMethod2(mCallback, mEventName, \"_Sys";
_utils._callsubmethod2 /*String*/ (_mcallback,_meventname,"_SystemCommand",(Object)(_command));
 //BA.debugLineNum = 3269;BA.debugLine="End Sub";
return "";
}
public String  _readstringfunctionargument() throws Exception{
String _currentchar = "";
int _startstring = 0;
String _stringvalue = "";
int _startvariable = 0;
String _variablename = "";
 //BA.debugLineNum = 1857;BA.debugLine="Private Sub ReadStringFunctionArgument As String";
 //BA.debugLineNum = 1858;BA.debugLine="SkipSpaces";
_skipspaces();
 //BA.debugLineNum = 1860;BA.debugLine="If ExprPos >= ExprText.Length Then";
if (_exprpos>=_exprtext.length()) { 
 //BA.debugLineNum = 1861;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1862;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 1865;BA.debugLine="Dim CurrentChar As String = ExprText.SubString2(E";
_currentchar = _exprtext.substring(_exprpos,(int) (_exprpos+1));
 //BA.debugLineNum = 1868;BA.debugLine="If CurrentChar = Chr(34) Then";
if ((_currentchar).equals(BA.ObjectToString(__c.Chr((int) (34))))) { 
 //BA.debugLineNum = 1869;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 //BA.debugLineNum = 1871;BA.debugLine="Dim StartString As Int = ExprPos";
_startstring = _exprpos;
 //BA.debugLineNum = 1873;BA.debugLine="Do While ExprPos < ExprText.Length";
while (_exprpos<_exprtext.length()) {
 //BA.debugLineNum = 1874;BA.debugLine="CurrentChar = ExprText.SubString2(ExprPos, Expr";
_currentchar = _exprtext.substring(_exprpos,(int) (_exprpos+1));
 //BA.debugLineNum = 1876;BA.debugLine="If CurrentChar = Chr(34) Then Exit";
if ((_currentchar).equals(BA.ObjectToString(__c.Chr((int) (34))))) { 
if (true) break;};
 //BA.debugLineNum = 1878;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 }
;
 //BA.debugLineNum = 1881;BA.debugLine="If ExprPos >= ExprText.Length Then";
if (_exprpos>=_exprtext.length()) { 
 //BA.debugLineNum = 1882;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1883;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 1886;BA.debugLine="Dim StringValue As String = ExprText.SubString2(";
_stringvalue = _exprtext.substring(_startstring,_exprpos);
 //BA.debugLineNum = 1888;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 //BA.debugLineNum = 1890;BA.debugLine="Return StringValue";
if (true) return _stringvalue;
 };
 //BA.debugLineNum = 1894;BA.debugLine="Dim StartVariable As Int = ExprPos";
_startvariable = _exprpos;
 //BA.debugLineNum = 1896;BA.debugLine="Do While ExprPos < ExprText.Length";
while (_exprpos<_exprtext.length()) {
 //BA.debugLineNum = 1897;BA.debugLine="CurrentChar = ExprText.SubString2(ExprPos, ExprP";
_currentchar = _exprtext.substring(_exprpos,(int) (_exprpos+1));
 //BA.debugLineNum = 1899;BA.debugLine="If (CurrentChar.CompareTo(\"A\") >= 0 And CurrentC";
if ((_currentchar.compareTo("A")>=0 && _currentchar.compareTo("Z")<=0) || (_currentchar.compareTo("a")>=0 && _currentchar.compareTo("z")<=0) || __c.IsNumber(_currentchar) || (_currentchar).equals("$")) { 
 //BA.debugLineNum = 1903;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 }else {
 //BA.debugLineNum = 1905;BA.debugLine="Exit";
if (true) break;
 };
 }
;
 //BA.debugLineNum = 1909;BA.debugLine="Dim VariableName As String = ExprText.SubString2(";
_variablename = _exprtext.substring(_startvariable,_exprpos).toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 1911;BA.debugLine="If VariableName.EndsWith(\"$\") = False Or _ 		Vari";
if (_variablename.endsWith("$")==__c.False || _variables.ContainsKey((Object)(_variablename))==__c.False) { 
 //BA.debugLineNum = 1914;BA.debugLine="ExprError = True";
_exprerror = __c.True;
 //BA.debugLineNum = 1915;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 1918;BA.debugLine="Return Variables.Get(VariableName)";
if (true) return BA.ObjectToString(_variables.Get((Object)(_variablename)));
 //BA.debugLineNum = 1919;BA.debugLine="End Sub";
return "";
}
public String  _reseterrorhandler() throws Exception{
 //BA.debugLineNum = 3017;BA.debugLine="Private Sub ResetErrorHandler";
 //BA.debugLineNum = 3019;BA.debugLine="ErrorHandlerLine = 0";
_errorhandlerline = (int) (0);
 //BA.debugLineNum = 3020;BA.debugLine="ErrorHandlerEnabled = False";
_errorhandlerenabled = __c.False;
 //BA.debugLineNum = 3021;BA.debugLine="ErrorHandlerRunning = False";
_errorhandlerrunning = __c.False;
 //BA.debugLineNum = 3023;BA.debugLine="ErrorLinePosition = -1";
_errorlineposition = (int) (-1);
 //BA.debugLineNum = 3024;BA.debugLine="ErrorNextPosition = -1";
_errornextposition = (int) (-1);
 //BA.debugLineNum = 3025;BA.debugLine="ErrorCode = 0";
_errorcode = (int) (0);
 //BA.debugLineNum = 3026;BA.debugLine="ErrorLineNumber = 0";
_errorlinenumber = (int) (0);
 //BA.debugLineNum = 3028;BA.debugLine="End Sub";
return "";
}
public String  _resumehardwarecommand() throws Exception{
 //BA.debugLineNum = 3246;BA.debugLine="Public Sub ResumeHardwareCommand";
 //BA.debugLineNum = 3247;BA.debugLine="If WaitingForHardwareCommand = False Then Return";
if (_waitingforhardwarecommand==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 3249;BA.debugLine="WaitingForHardwareCommand = False";
_waitingforhardwarecommand = __c.False;
 //BA.debugLineNum = 3250;BA.debugLine="ContinueProgram";
_continueprogram();
 //BA.debugLineNum = 3251;BA.debugLine="End Sub";
return "";
}
public String  _resumeprogram() throws Exception{
 //BA.debugLineNum = 3208;BA.debugLine="Public Sub ResumeProgram";
 //BA.debugLineNum = 3209;BA.debugLine="If WaitingForDelay = False Then Return";
if (_waitingfordelay==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 3211;BA.debugLine="WaitingForDelay = False";
_waitingfordelay = __c.False;
 //BA.debugLineNum = 3212;BA.debugLine="ContinueProgram";
_continueprogram();
 //BA.debugLineNum = 3213;BA.debugLine="End Sub";
return "";
}
public String  _runprogram() throws Exception{
Object _key = null;
 //BA.debugLineNum = 180;BA.debugLine="Public Sub RunProgram";
 //BA.debugLineNum = 182;BA.debugLine="If ProgramLines.Size = 0 Then";
if (_programlines.getSize()==0) { 
 //BA.debugLineNum = 183;BA.debugLine="RaiseOutput(\"NO PROGRAM\")";
_raiseoutput("NO PROGRAM");
 //BA.debugLineNum = 184;BA.debugLine="RaiseReady";
_raiseready();
 //BA.debugLineNum = 185;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 188;BA.debugLine="Variables.Clear";
_variables.Clear();
 //BA.debugLineNum = 189;BA.debugLine="Arrays.Clear";
_arrays.Clear();
 //BA.debugLineNum = 191;BA.debugLine="WaitingForInput = False";
_waitingforinput = __c.False;
 //BA.debugLineNum = 192;BA.debugLine="WaitingForDelay = False";
_waitingfordelay = __c.False;
 //BA.debugLineNum = 193;BA.debugLine="WaitingForHardwareCommand = False";
_waitingforhardwarecommand = __c.False;
 //BA.debugLineNum = 195;BA.debugLine="RaiseOutput(\"\")";
_raiseoutput("");
 //BA.debugLineNum = 196;BA.debugLine="RaiseOutput(\"RUNNING...\")";
_raiseoutput("RUNNING...");
 //BA.debugLineNum = 197;BA.debugLine="RaiseOutput(\"\")";
_raiseoutput("");
 //BA.debugLineNum = 200;BA.debugLine="RunLines.Initialize";
_runlines.Initialize();
 //BA.debugLineNum = 202;BA.debugLine="For Each Key As Object In ProgramLines.Keys";
{
final anywheresoftware.b4a.BA.IterableList group15 = _programlines.Keys();
final int groupLen15 = group15.getSize()
;int index15 = 0;
;
for (; index15 < groupLen15;index15++){
_key = group15.Get(index15);
 //BA.debugLineNum = 203;BA.debugLine="RunLines.Add(Key)";
_runlines.Add(_key);
 }
};
 //BA.debugLineNum = 206;BA.debugLine="RunLines.Sort(True)";
_runlines.Sort(__c.True);
 //BA.debugLineNum = 208;BA.debugLine="If CollectData = False Then";
if (_collectdata()==__c.False) { 
 //BA.debugLineNum = 209;BA.debugLine="RaiseOutput(\"?SYNTAX ERROR IN LINE \" & DataError";
_raiseoutput("?SYNTAX ERROR IN LINE "+BA.NumberToString(_dataerrorline));
 //BA.debugLineNum = 210;BA.debugLine="RaiseReady";
_raiseready();
 //BA.debugLineNum = 211;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 214;BA.debugLine="RunPosition = 0";
_runposition = (int) (0);
 //BA.debugLineNum = 216;BA.debugLine="If ForStack.IsInitialized = False Then";
if (_forstack.IsInitialized()==__c.False) { 
 //BA.debugLineNum = 217;BA.debugLine="ForStack.Initialize";
_forstack.Initialize();
 }else {
 //BA.debugLineNum = 219;BA.debugLine="ForStack.Clear";
_forstack.Clear();
 };
 //BA.debugLineNum = 222;BA.debugLine="If GosubStack.IsInitialized = False Then";
if (_gosubstack.IsInitialized()==__c.False) { 
 //BA.debugLineNum = 223;BA.debugLine="GosubStack.Initialize";
_gosubstack.Initialize();
 }else {
 //BA.debugLineNum = 225;BA.debugLine="GosubStack.Clear";
_gosubstack.Clear();
 };
 //BA.debugLineNum = 228;BA.debugLine="ResetErrorHandler";
_reseterrorhandler();
 //BA.debugLineNum = 229;BA.debugLine="ContinueProgram";
_continueprogram();
 //BA.debugLineNum = 230;BA.debugLine="End Sub";
return "";
}
public boolean  _setnumerictargetvalue(String _target,String _value) throws Exception{
int _openpos = 0;
int _closepos = 0;
String _arrayname = "";
String _indextext = "";
double _indexvalue = 0;
anywheresoftware.b4a.objects.collections.List _values = null;
 //BA.debugLineNum = 3549;BA.debugLine="Private Sub SetNumericTargetValue(Target As String";
 //BA.debugLineNum = 3551;BA.debugLine="Dim OpenPos As Int = Target.IndexOf(\"(\")";
_openpos = _target.indexOf("(");
 //BA.debugLineNum = 3552;BA.debugLine="Dim ClosePos As Int = Target.IndexOf(\")\")";
_closepos = _target.indexOf(")");
 //BA.debugLineNum = 3554;BA.debugLine="If OpenPos > 0 And ClosePos > OpenPos Then";
if (_openpos>0 && _closepos>_openpos) { 
 //BA.debugLineNum = 3556;BA.debugLine="Dim ArrayName As String = Target.SubString2(0, O";
_arrayname = _target.substring((int) (0),_openpos).trim();
 //BA.debugLineNum = 3557;BA.debugLine="Dim IndexText As String = Target.SubString2(Open";
_indextext = _target.substring((int) (_openpos+1),_closepos).trim();
 //BA.debugLineNum = 3559;BA.debugLine="If IsValidVariable(ArrayName) = False Then Retur";
if (_isvalidvariable(_arrayname)==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3560;BA.debugLine="If Arrays.ContainsKey(ArrayName) = False Then Re";
if (_arrays.ContainsKey((Object)(_arrayname))==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3562;BA.debugLine="Dim IndexValue As Double = EvaluateNumericExpres";
_indexvalue = _evaluatenumericexpression(_indextext);
 //BA.debugLineNum = 3564;BA.debugLine="If ExprError Then Return False";
if (_exprerror) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3565;BA.debugLine="If IndexValue < 1 Or IndexValue <> Floor(IndexVa";
if (_indexvalue<1 || _indexvalue!=__c.Floor(_indexvalue)) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3567;BA.debugLine="Dim Values As List = Arrays.Get(ArrayName)";
_values = new anywheresoftware.b4a.objects.collections.List();
_values = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_arrays.Get((Object)(_arrayname))));
 //BA.debugLineNum = 3569;BA.debugLine="If IndexValue > Values.Size Then Return False";
if (_indexvalue>_values.getSize()) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3571;BA.debugLine="Values.Set(IndexValue - 1, Value)";
_values.Set((int) (_indexvalue-1),(Object)(_value));
 //BA.debugLineNum = 3573;BA.debugLine="Return True";
if (true) return __c.True;
 };
 //BA.debugLineNum = 3577;BA.debugLine="If IsValidVariable(Target) = False Or Target.Ends";
if (_isvalidvariable(_target)==__c.False || _target.endsWith("$")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3579;BA.debugLine="Variables.Put(Target, Value)";
_variables.Put((Object)(_target),(Object)(_value));
 //BA.debugLineNum = 3581;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 3583;BA.debugLine="End Sub";
return false;
}
public String  _skipspaces() throws Exception{
 //BA.debugLineNum = 1921;BA.debugLine="Private Sub SkipSpaces";
 //BA.debugLineNum = 1922;BA.debugLine="Do While ExprPos < ExprText.Length";
while (_exprpos<_exprtext.length()) {
 //BA.debugLineNum = 1923;BA.debugLine="If ExprText.SubString2(ExprPos, ExprPos + 1) = \"";
if ((_exprtext.substring(_exprpos,(int) (_exprpos+1))).equals(" ")) { 
 //BA.debugLineNum = 1924;BA.debugLine="ExprPos = ExprPos + 1";
_exprpos = (int) (_exprpos+1);
 }else {
 //BA.debugLineNum = 1926;BA.debugLine="Exit";
if (true) break;
 };
 }
;
 //BA.debugLineNum = 1929;BA.debugLine="End Sub";
return "";
}
public String  _spacestring(int _count) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _result = null;
int _i = 0;
 //BA.debugLineNum = 2897;BA.debugLine="Private Sub SpaceString(Count As Int) As String";
 //BA.debugLineNum = 2898;BA.debugLine="Dim Result As StringBuilder";
_result = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 2899;BA.debugLine="Result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 2901;BA.debugLine="For i = 1 To Count";
{
final int step3 = 1;
final int limit3 = _count;
_i = (int) (1) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 2902;BA.debugLine="Result.Append(\" \")";
_result.Append(" ");
 }
};
 //BA.debugLineNum = 2905;BA.debugLine="Return Result.ToString";
if (true) return _result.ToString();
 //BA.debugLineNum = 2906;BA.debugLine="End Sub";
return "";
}
public String  _submitexternaldata(int _adr,int _cmd,int _val) throws Exception{
anywheresoftware.b4a.objects.collections.List _targets = null;
anywheresoftware.b4a.objects.collections.List _values = null;
int _i = 0;
 //BA.debugLineNum = 3899;BA.debugLine="Public Sub SubmitExternalData(Adr As Int, Cmd As I";
 //BA.debugLineNum = 3901;BA.debugLine="If WaitingForExternalData = False Then Return";
if (_waitingforexternaldata==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 3903;BA.debugLine="Dim Targets As List";
_targets = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 3904;BA.debugLine="Targets.Initialize";
_targets.Initialize();
 //BA.debugLineNum = 3905;BA.debugLine="Targets.Add(ExternalDataTarget)";
_targets.Add((Object)(_externaldatatarget));
 //BA.debugLineNum = 3907;BA.debugLine="If ExternalDataTarget2 <> \"\" Then";
if ((_externaldatatarget2).equals("") == false) { 
 //BA.debugLineNum = 3908;BA.debugLine="Targets.Add(ExternalDataTarget2)";
_targets.Add((Object)(_externaldatatarget2));
 //BA.debugLineNum = 3909;BA.debugLine="Targets.Add(ExternalDataTarget3)";
_targets.Add((Object)(_externaldatatarget3));
 };
 //BA.debugLineNum = 3912;BA.debugLine="WaitingForExternalData = False";
_waitingforexternaldata = __c.False;
 //BA.debugLineNum = 3914;BA.debugLine="ExternalDataTarget = \"\"";
_externaldatatarget = "";
 //BA.debugLineNum = 3915;BA.debugLine="ExternalDataTarget2 = \"\"";
_externaldatatarget2 = "";
 //BA.debugLineNum = 3916;BA.debugLine="ExternalDataTarget3 = \"\"";
_externaldatatarget3 = "";
 //BA.debugLineNum = 3918;BA.debugLine="Dim Values As List";
_values = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 3919;BA.debugLine="Values.Initialize";
_values.Initialize();
 //BA.debugLineNum = 3921;BA.debugLine="If Targets.Size = 1 Then";
if (_targets.getSize()==1) { 
 //BA.debugLineNum = 3922;BA.debugLine="Values.Add(Val)";
_values.Add((Object)(_val));
 }else {
 //BA.debugLineNum = 3924;BA.debugLine="Values.Add(Adr)";
_values.Add((Object)(_adr));
 //BA.debugLineNum = 3925;BA.debugLine="Values.Add(Cmd)";
_values.Add((Object)(_cmd));
 //BA.debugLineNum = 3926;BA.debugLine="Values.Add(Val)";
_values.Add((Object)(_val));
 };
 //BA.debugLineNum = 3929;BA.debugLine="For i = 0 To Targets.Size - 1";
{
final int step22 = 1;
final int limit22 = (int) (_targets.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit22 ;_i = _i + step22 ) {
 //BA.debugLineNum = 3930;BA.debugLine="If ExecuteLet(\"LET \" & Targets.Get(i) & \" = \" &";
if (_executelet("LET "+BA.ObjectToString(_targets.Get(_i))+" = "+BA.ObjectToString(_values.Get(_i)))==__c.False) { 
 //BA.debugLineNum = 3931;BA.debugLine="HandleProgramError(\"?ILLEGAL EXPRESSION\")";
_handleprogramerror("?ILLEGAL EXPRESSION");
 //BA.debugLineNum = 3932;BA.debugLine="Return";
if (true) return "";
 };
 }
};
 //BA.debugLineNum = 3936;BA.debugLine="ContinueProgram";
_continueprogram();
 //BA.debugLineNum = 3938;BA.debugLine="End Sub";
return "";
}
public String  _submitinput(String _command) throws Exception{
anywheresoftware.b4a.objects.collections.List _inputvalues = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _currentvalue = null;
boolean _inquotes = false;
int _i = 0;
String _currentchar = "";
boolean _validinput = false;
String _variablename = "";
String _inputvalue = "";
int _openpos = 0;
int _closepos = 0;
String _arrayname = "";
int _arrayindex = 0;
anywheresoftware.b4a.objects.collections.List _values = null;
 //BA.debugLineNum = 310;BA.debugLine="Public Sub SubmitInput(Command As String)";
 //BA.debugLineNum = 312;BA.debugLine="If Command = \"\" And WaitingForInput = False Th";
if ((_command).equals("") && _waitingforinput==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 318;BA.debugLine="If WaitingForInput Then";
if (_waitingforinput) { 
 //BA.debugLineNum = 321;BA.debugLine="If Command.trim.ToUpperCase = \"BREAK\" Then";
if ((_command.trim().toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale)).equals("BREAK")) { 
 //BA.debugLineNum = 322;BA.debugLine="WaitingForInput = False";
_waitingforinput = __c.False;
 //BA.debugLineNum = 323;BA.debugLine="RunPosition = RunLines.Size";
_runposition = _runlines.getSize();
 //BA.debugLineNum = 324;BA.debugLine="InputVariables.Clear";
_inputvariables.Clear();
 //BA.debugLineNum = 325;BA.debugLine="RaiseOutput(\"BREAK\")";
_raiseoutput("BREAK");
 //BA.debugLineNum = 326;BA.debugLine="RaiseOutput(\"READY.\")";
_raiseoutput("READY.");
 //BA.debugLineNum = 327;BA.debugLine="RaiseReady";
_raiseready();
 //BA.debugLineNum = 328;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 332;BA.debugLine="RaiseOutput(Command)";
_raiseoutput(_command);
 //BA.debugLineNum = 334;BA.debugLine="Dim InputValues As List";
_inputvalues = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 335;BA.debugLine="InputValues.Initialize";
_inputvalues.Initialize();
 //BA.debugLineNum = 337;BA.debugLine="Dim CurrentValue As StringBuilder";
_currentvalue = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 338;BA.debugLine="CurrentValue.Initialize";
_currentvalue.Initialize();
 //BA.debugLineNum = 340;BA.debugLine="Dim InQuotes As Boolean = False";
_inquotes = __c.False;
 //BA.debugLineNum = 343;BA.debugLine="For i = 0 To Command.Length - 1";
{
final int step18 = 1;
final int limit18 = (int) (_command.length()-1);
_i = (int) (0) ;
for (;_i <= limit18 ;_i = _i + step18 ) {
 //BA.debugLineNum = 344;BA.debugLine="Dim CurrentChar As String = Command.SubString2(";
_currentchar = _command.substring(_i,(int) (_i+1));
 //BA.debugLineNum = 346;BA.debugLine="If CurrentChar = Chr(34) Then";
if ((_currentchar).equals(BA.ObjectToString(__c.Chr((int) (34))))) { 
 //BA.debugLineNum = 347;BA.debugLine="InQuotes = Not(InQuotes)";
_inquotes = __c.Not(_inquotes);
 };
 //BA.debugLineNum = 350;BA.debugLine="If CurrentChar = \",\" And InQuotes = False Then";
if ((_currentchar).equals(",") && _inquotes==__c.False) { 
 //BA.debugLineNum = 351;BA.debugLine="InputValues.Add(CurrentValue.ToString.Trim)";
_inputvalues.Add((Object)(_currentvalue.ToString().trim()));
 //BA.debugLineNum = 352;BA.debugLine="CurrentValue.Initialize";
_currentvalue.Initialize();
 }else {
 //BA.debugLineNum = 354;BA.debugLine="CurrentValue.Append(CurrentChar)";
_currentvalue.Append(_currentchar);
 };
 }
};
 //BA.debugLineNum = 358;BA.debugLine="InputValues.Add(CurrentValue.ToString.Trim)";
_inputvalues.Add((Object)(_currentvalue.ToString().trim()));
 //BA.debugLineNum = 361;BA.debugLine="Dim ValidInput As Boolean = True";
_validinput = __c.True;
 //BA.debugLineNum = 363;BA.debugLine="If InQuotes Or InputValues.Size <> InputVariable";
if (_inquotes || _inputvalues.getSize()!=_inputvariables.getSize()) { 
 //BA.debugLineNum = 364;BA.debugLine="ValidInput = False";
_validinput = __c.False;
 }else {
 //BA.debugLineNum = 366;BA.debugLine="For i = 0 To InputVariables.Size - 1";
{
final int step35 = 1;
final int limit35 = (int) (_inputvariables.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit35 ;_i = _i + step35 ) {
 //BA.debugLineNum = 367;BA.debugLine="Dim VariableName As String = InputVariables.Ge";
_variablename = BA.ObjectToString(_inputvariables.Get(_i));
 //BA.debugLineNum = 368;BA.debugLine="Dim InputValue As String = InputValues.Get(i)";
_inputvalue = BA.ObjectToString(_inputvalues.Get(_i));
 //BA.debugLineNum = 370;BA.debugLine="If VariableName.EndsWith(\"$\") Then";
if (_variablename.endsWith("$")) { 
 //BA.debugLineNum = 371;BA.debugLine="If InputValue.StartsWith(Chr(34)) Or InputVal";
if (_inputvalue.startsWith(BA.ObjectToString(__c.Chr((int) (34)))) || _inputvalue.endsWith(BA.ObjectToString(__c.Chr((int) (34))))) { 
 //BA.debugLineNum = 372;BA.debugLine="If InputValue.StartsWith(Chr(34)) And InputV";
if (_inputvalue.startsWith(BA.ObjectToString(__c.Chr((int) (34)))) && _inputvalue.endsWith(BA.ObjectToString(__c.Chr((int) (34)))) && _inputvalue.length()>=2) { 
 //BA.debugLineNum = 373;BA.debugLine="InputValue = InputValue.SubString2(1, Input";
_inputvalue = _inputvalue.substring((int) (1),(int) (_inputvalue.length()-1));
 //BA.debugLineNum = 374;BA.debugLine="InputValues.Set(i, InputValue)";
_inputvalues.Set(_i,(Object)(_inputvalue));
 }else {
 //BA.debugLineNum = 376;BA.debugLine="ValidInput = False";
_validinput = __c.False;
 };
 };
 }else {
 //BA.debugLineNum = 380;BA.debugLine="If IsNumber(InputValue) = False Then";
if (__c.IsNumber(_inputvalue)==__c.False) { 
 //BA.debugLineNum = 381;BA.debugLine="ValidInput = False";
_validinput = __c.False;
 };
 };
 }
};
 };
 //BA.debugLineNum = 387;BA.debugLine="If ValidInput = False Then";
if (_validinput==__c.False) { 
 //BA.debugLineNum = 388;BA.debugLine="RaiseOutput(\"?REDO FROM START\")";
_raiseoutput("?REDO FROM START");
 //BA.debugLineNum = 389;BA.debugLine="RaiseOutput(InputPrompt & \"?\")";
_raiseoutput(_inputprompt+"?");
 //BA.debugLineNum = 390;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 395;BA.debugLine="For i = 0 To InputVariables.Size - 1";
{
final int step59 = 1;
final int limit59 = (int) (_inputvariables.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit59 ;_i = _i + step59 ) {
 //BA.debugLineNum = 396;BA.debugLine="Dim VariableName As String = InputVariables.Get";
_variablename = BA.ObjectToString(_inputvariables.Get(_i));
 //BA.debugLineNum = 397;BA.debugLine="Dim InputValue As String = InputValues.Get(i)";
_inputvalue = BA.ObjectToString(_inputvalues.Get(_i));
 //BA.debugLineNum = 400;BA.debugLine="Dim OpenPos As Int = VariableName.IndexOf(\"(\")";
_openpos = _variablename.indexOf("(");
 //BA.debugLineNum = 402;BA.debugLine="If OpenPos > 0 Then";
if (_openpos>0) { 
 //BA.debugLineNum = 404;BA.debugLine="Dim ClosePos As Int = VariableName.IndexOf(\")\"";
_closepos = _variablename.indexOf(")");
 //BA.debugLineNum = 405;BA.debugLine="Dim ArrayName As String = VariableName.SubStri";
_arrayname = _variablename.substring((int) (0),_openpos);
 //BA.debugLineNum = 406;BA.debugLine="Dim ArrayIndex As Int = VariableName.SubString";
_arrayindex = (int)(Double.parseDouble(_variablename.substring((int) (_openpos+1),_closepos)));
 //BA.debugLineNum = 408;BA.debugLine="Dim Values As List = Arrays.Get(ArrayName)";
_values = new anywheresoftware.b4a.objects.collections.List();
_values = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_arrays.Get((Object)(_arrayname))));
 //BA.debugLineNum = 409;BA.debugLine="Values.Set(ArrayIndex - 1, InputValue)";
_values.Set((int) (_arrayindex-1),(Object)(_inputvalue));
 }else {
 //BA.debugLineNum = 413;BA.debugLine="Variables.Put(VariableName, InputValue)";
_variables.Put((Object)(_variablename),(Object)(_inputvalue));
 };
 }
};
 //BA.debugLineNum = 419;BA.debugLine="WaitingForInput = False";
_waitingforinput = __c.False;
 //BA.debugLineNum = 421;BA.debugLine="ContinueProgram";
_continueprogram();
 //BA.debugLineNum = 422;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 424;BA.debugLine="ExecuteCommand(Command)";
_executecommand(_command);
 //BA.debugLineNum = 425;BA.debugLine="End Sub";
return "";
}
public String  _updatelinereference(String _linecode,String _command,anywheresoftware.b4a.objects.collections.Map _linenumbermap) throws Exception{
String _upperline = "";
String _targettext = "";
int _thenpos = 0;
double _targetvalue = 0;
int _targetline = 0;
int _newtargetline = 0;
 //BA.debugLineNum = 3778;BA.debugLine="Private Sub UpdateLineReference(LineCode As String";
 //BA.debugLineNum = 3780;BA.debugLine="Dim UpperLine As String = LineCode.Trim.ToUpperCa";
_upperline = _linecode.trim().toUpperCase(anywheresoftware.b4a.keywords.Common.stringLocale);
 //BA.debugLineNum = 3781;BA.debugLine="Dim TargetText As String = \"\"";
_targettext = "";
 //BA.debugLineNum = 3783;BA.debugLine="Select Command";
switch (BA.switchObjectToInt(_command,"GOTO","GOSUB","THEN")) {
case 0: 
case 1: {
 //BA.debugLineNum = 3787;BA.debugLine="If UpperLine.StartsWith(Command & \" \") = False";
if (_upperline.startsWith(_command+" ")==__c.False) { 
if (true) return _linecode;};
 //BA.debugLineNum = 3789;BA.debugLine="TargetText = LineCode.Trim.SubString(Command.Le";
_targettext = _linecode.trim().substring(_command.length()).trim();
 break; }
case 2: {
 //BA.debugLineNum = 3793;BA.debugLine="If UpperLine.StartsWith(\"IF \") = False Then Ret";
if (_upperline.startsWith("IF ")==__c.False) { 
if (true) return _linecode;};
 //BA.debugLineNum = 3795;BA.debugLine="Dim ThenPos As Int = UpperLine.LastIndexOf(\"THE";
_thenpos = _upperline.lastIndexOf("THEN ");
 //BA.debugLineNum = 3797;BA.debugLine="If ThenPos < 0 Then Return LineCode";
if (_thenpos<0) { 
if (true) return _linecode;};
 //BA.debugLineNum = 3799;BA.debugLine="TargetText = LineCode.SubString(ThenPos + 5).Tr";
_targettext = _linecode.substring((int) (_thenpos+5)).trim();
 break; }
default: {
 //BA.debugLineNum = 3802;BA.debugLine="Return LineCode";
if (true) return _linecode;
 break; }
}
;
 //BA.debugLineNum = 3806;BA.debugLine="If IsNumber(TargetText) = False Then Return LineC";
if (__c.IsNumber(_targettext)==__c.False) { 
if (true) return _linecode;};
 //BA.debugLineNum = 3808;BA.debugLine="Dim TargetValue As Double = TargetText";
_targetvalue = (double)(Double.parseDouble(_targettext));
 //BA.debugLineNum = 3810;BA.debugLine="If TargetValue < 0 Or TargetValue <> Floor(Target";
if (_targetvalue<0 || _targetvalue!=__c.Floor(_targetvalue)) { 
if (true) return _linecode;};
 //BA.debugLineNum = 3812;BA.debugLine="Dim TargetLine As Int = TargetValue";
_targetline = (int) (_targetvalue);
 //BA.debugLineNum = 3814;BA.debugLine="If LineNumberMap.ContainsKey(TargetLine) = False";
if (_linenumbermap.ContainsKey((Object)(_targetline))==__c.False) { 
if (true) return _linecode;};
 //BA.debugLineNum = 3816;BA.debugLine="Dim NewTargetLine As Int = LineNumberMap.Get(Targ";
_newtargetline = (int)(BA.ObjectToNumber(_linenumbermap.Get((Object)(_targetline))));
 //BA.debugLineNum = 3818;BA.debugLine="If Command = \"THEN\" Then";
if ((_command).equals("THEN")) { 
 //BA.debugLineNum = 3819;BA.debugLine="Return LineCode.SubString2(0, ThenPos + 5) & New";
if (true) return _linecode.substring((int) (0),(int) (_thenpos+5))+BA.NumberToString(_newtargetline);
 }else {
 //BA.debugLineNum = 3821;BA.debugLine="Return Command & \" \" & NewTargetLine";
if (true) return _command+" "+BA.NumberToString(_newtargetline);
 };
 //BA.debugLineNum = 3824;BA.debugLine="End Sub";
return "";
}
public boolean  _validateassigntarget(String _target) throws Exception{
int _openpos = 0;
int _closepos = 0;
String _arrayname = "";
String _indextext = "";
double _indexvalue = 0;
anywheresoftware.b4a.objects.collections.List _values = null;
 //BA.debugLineNum = 3862;BA.debugLine="Private Sub ValidateAssignTarget(Target As String)";
 //BA.debugLineNum = 3864;BA.debugLine="If Target = \"\" Then Return False";
if ((_target).equals("")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3866;BA.debugLine="Dim OpenPos As Int = Target.IndexOf(\"(\")";
_openpos = _target.indexOf("(");
 //BA.debugLineNum = 3867;BA.debugLine="Dim ClosePos As Int = Target.IndexOf(\")\")";
_closepos = _target.indexOf(")");
 //BA.debugLineNum = 3869;BA.debugLine="If OpenPos > 0 And ClosePos = Target.Length - 1 T";
if (_openpos>0 && _closepos==_target.length()-1) { 
 //BA.debugLineNum = 3871;BA.debugLine="Dim ArrayName As String = Target.SubString2(0, O";
_arrayname = _target.substring((int) (0),_openpos).trim();
 //BA.debugLineNum = 3872;BA.debugLine="Dim IndexText As String = Target.SubString2(Open";
_indextext = _target.substring((int) (_openpos+1),_closepos).trim();
 //BA.debugLineNum = 3874;BA.debugLine="If IsValidVariable(ArrayName) = False Then Retur";
if (_isvalidvariable(_arrayname)==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3875;BA.debugLine="If ArrayName.EndsWith(\"$\") Then Return False";
if (_arrayname.endsWith("$")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3876;BA.debugLine="If Arrays.ContainsKey(ArrayName) = False Then Re";
if (_arrays.ContainsKey((Object)(_arrayname))==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3877;BA.debugLine="If IndexText = \"\" Then Return False";
if ((_indextext).equals("")) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3879;BA.debugLine="Dim IndexValue As Double = EvaluateNumericExpres";
_indexvalue = _evaluatenumericexpression(_indextext);
 //BA.debugLineNum = 3881;BA.debugLine="If ExprError Then Return False";
if (_exprerror) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3882;BA.debugLine="If IndexValue < 1 Or IndexValue <> Floor(IndexVa";
if (_indexvalue<1 || _indexvalue!=__c.Floor(_indexvalue)) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3884;BA.debugLine="Dim Values As List = Arrays.Get(ArrayName)";
_values = new anywheresoftware.b4a.objects.collections.List();
_values = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_arrays.Get((Object)(_arrayname))));
 //BA.debugLineNum = 3885;BA.debugLine="If IndexValue > Values.Size Then Return False";
if (_indexvalue>_values.getSize()) { 
if (true) return __c.False;};
 }else {
 //BA.debugLineNum = 3888;BA.debugLine="If IsValidVariable(Target) = False Then Return F";
if (_isvalidvariable(_target)==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 3889;BA.debugLine="If Target.EndsWith(\"$\") Then Return False";
if (_target.endsWith("$")) { 
if (true) return __c.False;};
 };
 //BA.debugLineNum = 3892;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 3894;BA.debugLine="End Sub";
return false;
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
