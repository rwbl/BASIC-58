# BASIC-58 Reference Manual

**Version:** 1.0.0\
**Build:** 20261125\
**Document:** Language and environment reference

------------------------------------------------------------------------

## 1. Introduction

BASIC-58 is a compact, retro-inspired BASIC interpreter developed with
B4J. It implements a practical subset of classic BASIC, with additional
facilities for serial communication, external data acquisition, host
application integration and system settings.

BASIC-58 is intentionally not a complete implementation of GW-BASIC,
Commodore BASIC or any other historical dialect. Its syntax and
behaviour are defined by this manual and by the implemented interpreter.

The interpreter itself is written in B4X/B4J BASIC --- a small example
of BASIC being used to bring BASIC back.

### 1.1 Design principles

-   Keep the language small and approachable.
-   Prefer familiar, readable BASIC statements.
-   Keep the interpreter independent of specific hardware.
-   Provide simple interfaces to external devices and host applications.
-   Preserve a straightforward programming experience.

### 1.2 Conventions used in this manual

-   BASIC keywords and command names are shown in uppercase.
-   Items in square brackets are optional.
-   `...` indicates that an item can be repeated.
-   `variable`, `expression` and `line` represent values supplied by the
    programmer.
-   Examples use numbered program lines.

------------------------------------------------------------------------

## 2. Using the BASIC-58 environment

BASIC-58 provides an interactive prompt and an editor/terminal
application.

The welcome message identifies the interpreter and version. Enter `HELP`
to display the built-in help information.

### 2.1 Environment commands

These commands are entered directly at the BASIC prompt.

  Command                       Description
  ----------------------------- --------------------------------------
  `HELP`                        Display built-in help
  `LIST`                        List the current program
  `LIST start-line`             List from the specified line onwards
  `LIST start-line, end-line`   List an inclusive line range
  `RUN`                         Execute the current program
  `NEW`                         Create a new empty program
  `LOAD [filename]`             Load a BASIC program
  `SAVE [filename]`             Save the current BASIC program
  `RENUM`                       Renumber the current program
  `CLS`                         Clear the terminal
  `BREAK`                       Interrupt program execution
  `BYE`                         Close BASIC-58

`PRINT expression` can also be entered directly to evaluate and display
an expression.

Examples:

``` basic
PRINT 10 + 20
PRINT "HELLO FROM BASIC-58"
```

### 2.2 Entering and editing program lines

A BASIC program consists of numbered lines. Entering a line with an
existing line number replaces that line.

``` basic
10 PRINT "HELLO"
20 PRINT "WORLD"
```

Entering a line number without a statement deletes that line:

``` basic
20
```

`LIST` displays the current program in ascending line-number order.

### 2.3 Automatic line numbering

When source is loaded from the editor, lines without explicit line
numbers are automatically numbered, starting at 10 and increasing in
steps of 10.

For example:

``` basic
LET A = 10
PRINT A
END
```

is interpreted as:

``` basic
10 LET A = 10
20 PRINT A
30 END
```

Explicit line numbers are preserved.

### 2.4 Renumbering programs

`RENUM` renumbers the program and updates line references in supported
statements such as `GOTO`, `GOSUB` and `IF ... THEN`.

  -----------------------------------------------------------------------
  Syntax                              Description
  ----------------------------------- -----------------------------------
  `RENUM`                             Start at 10, increment by 10

  `RENUM new-start`                   Use the specified starting line,
                                      increment by 10

  `RENUM new-start, increment`        Specify both starting line and
                                      increment
  -----------------------------------------------------------------------

Examples:

``` text
RENUM
RENUM 100
RENUM 100,5
```

Program lines are sorted by their existing line numbers before
renumbering. Execution order is therefore determined by line numbers,
not by the order in which lines were entered.

### 2.5 Saving and loading

Use `SAVE` to save the current program and `LOAD` to load a previously
saved program. The application supports program-file selection.

The editor tracks modifications so unsaved changes can be identified.
When an operation would discard modified source code, BASIC-58 asks for
confirmation.

------------------------------------------------------------------------

## 3. BASIC language fundamentals

### 3.1 Program structure

A BASIC-58 program is a sequence of numbered statements. Statements
execute in ascending line-number order unless a control-flow statement
changes the execution position.

A minimal program:

``` basic
10 PRINT "HELLO FROM BASIC-58"
20 END
```

### 3.2 Variables

BASIC-58 supports numeric and string variables.

Numeric variables use names without a type suffix. String variable names
end with `$`.

``` basic
10 LET TOTAL = 100
20 LET NAME$ = "BASIC-58"
30 PRINT TOTAL
40 PRINT NAME$
50 END
```

Variable names are case-insensitive. Numeric variable names can be
descriptive, subject to the interpreter's maximum variable-name length
of eight characters.

### 3.3 Assignment with LET

Ordinary variable assignments require the `LET` keyword.

Correct:

``` basic
10 LET A = 10
20 LET B = A * 2
```

Incorrect:

``` basic
10 A = 10
20 B = A * 2
```

`FOR` loop initialization and assignments performed by `READ` are
exceptions and do not require `LET`.

Array elements are assigned with `LET` as well:

``` basic
10 DIM VALUES(5)
20 LET VALUES(1) = 100
```

### 3.4 Expressions

Expressions can contain numeric constants, variables, array elements,
function calls, operators and parentheses.

``` basic
10 LET A = 10 + 5 * 2
20 LET B = (10 + 5) * 2
30 PRINT A
40 PRINT B
50 END
```

Expected output:

``` text
20
30
```

Parentheses can be used to make evaluation order explicit.

### 3.5 Arithmetic operators

  Operator   Description
  ---------- ----------------
  `+`        Addition
  `-`        Subtraction
  `*`        Multiplication
  `/`        Division

### 3.6 Comparison operators

Comparison operators are used in conditional expressions.

  Operator   Description
  ---------- -----------------------
  `=`        Equal
  `<>`       Not equal
  `<`        Less than
  `>`        Greater than
  `<=`       Less than or equal
  `>=`       Greater than or equal

------------------------------------------------------------------------

## 4. Program statements

### 4.1 LET

Assign a numeric or string expression to a variable or numeric array
element.

``` basic
LET variable = expression
```

Examples:

``` basic
10 LET COUNT = 10
20 LET TOTAL = COUNT * 5
30 LET TITLE$ = "BASIC-58"
```

### 4.2 PRINT

Display text, numeric expressions and string expressions.

``` basic
PRINT expression [, expression ...]
```

`PRINT` supports these separators and formatting functions:

  Feature    Description
  ---------- ---------------------------------------------------------------
  `;`        Separate output items without automatically inserting a space
  `,`        Advance output to the next print zone
  `TAB(n)`   Position output at the specified column
  `SPC(n)`   Insert the specified number of spaces

A trailing semicolon or comma suppresses the automatic newline at the
end of a `PRINT` statement.

**Important:** The semicolon does not insert a space. Include a trailing
space in a text literal when one is required before the next output
item.

``` basic
10 LET SAVED = 100
20 PRINT "YOU HAVE SAVED "; SAVED
```

Output:

``` text
YOU HAVE SAVED 100
```

### 4.3 INPUT

Read values from the keyboard.

``` basic
INPUT [prompt;] variable [, variable ...]
```

Example:

``` basic
10 INPUT "WHAT IS YOUR NAME? "; NAME$
20 PRINT "HELLO "; NAME$
30 END
```

`INPUT` is intended for interactive keyboard input. It is separate from
`ASSIGN`, which receives external numeric data.

### 4.4 IF ... THEN

Perform a conditional branch to a program line.

``` basic
IF condition THEN line
```

Example:

``` basic
10 IF LEVEL < 30 THEN 100
20 PRINT "LEVEL IS NORMAL"
30 END
100 PRINT "LOW LEVEL"
110 END
```

**BASIC-58 rule:** The target after `THEN` must be a line number. Inline
statements and `THEN GOTO` are not supported.

Correct:

``` basic
10 IF A > 10 THEN 100
```

Not supported:

``` basic
10 IF A > 10 THEN GOTO 100
20 IF A > 10 THEN LET B = 5
30 IF A > 10 THEN PRINT A
```

Use separate lines for the actions.

### 4.5 GOTO

Jump to a specified program line.

``` basic
GOTO line
```

Example:

``` basic
10 PRINT "START"
20 GOTO 50
30 PRINT "SKIPPED"
50 PRINT "END"
60 END
```

### 4.6 GOSUB and RETURN

Call a subroutine and return to the statement following the `GOSUB`.

``` basic
GOSUB line
RETURN
```

Example:

``` basic
10 PRINT "MAIN PROGRAM"
20 GOSUB 100
30 PRINT "BACK IN MAIN"
40 END
100 PRINT "INSIDE SUBROUTINE"
110 RETURN
```

### 4.7 FOR and NEXT

Repeat a group of statements using a counted loop.

``` basic
FOR variable = start TO limit [STEP value]
...
NEXT [variable]
```

Examples:

``` basic
10 FOR I = 1 TO 5
20 PRINT I
30 NEXT I
40 END
```

A step value can be positive or negative:

``` basic
10 FOR I = 10 TO 0 STEP -2
20 PRINT I
30 NEXT I
40 END
```

Loop variables must be single letters from `A` to `Z`. Nested
`FOR`/`NEXT` loops are supported.

### 4.8 ON ... GOTO

Select a line from a list using a numeric expression.

``` basic
ON expression GOTO line1, line2, ...
```

### 4.9 ON ... GOSUB

Select and call a subroutine from a list using a numeric expression.

``` basic
ON expression GOSUB line1, line2, ...
```

### 4.10 DATA, READ and RESTORE

`DATA` defines values in a program. `READ` assigns successive values to
variables. `RESTORE` resets the DATA read position.

``` basic
10 DATA 10,20,30,40,50
20 FOR I = 1 TO 5
30 READ A
40 PRINT A
50 NEXT I
60 RESTORE
70 READ B
80 PRINT "FIRST VALUE AGAIN: "; B
90 END
```

### 4.11 DIM

Declare a one-dimensional numeric array.

``` basic
DIM arrayname(size)
```

Example:

``` basic
10 DIM TEMPERATURE(10)
20 LET TEMPERATURE(1) = 21.5
30 LET TEMPERATURE(2) = 22
40 PRINT TEMPERATURE(1)
50 END
```

Array indices start at 1. All elements are initialized to zero. Arrays
must be declared before use and cannot be declared a second time while
they exist.

### 4.12 ERASE

Remove a declared array from memory.

``` basic
ERASE arrayname
```

After an array is erased, it can be declared again using `DIM`.

### 4.13 SWAP

Exchange the values of two numeric variables or array elements.

``` basic
SWAP variable1, variable2
```

`SWAP` supports numeric variables, array elements, and combinations of a
numeric variable and an array element.

``` basic
10 LET A = 10
20 LET B = 20
30 SWAP A, B
40 PRINT A
50 PRINT B
60 END
```

### 4.14 RANDOMIZE

Initialize the random number generator.

``` basic
RANDOMIZE [expression]
```

### 4.15 REM

Add a comment to a program line.

``` basic
10 REM THIS IS A COMMENT
```

### 4.16 END

End program execution.

``` basic
END
```

------------------------------------------------------------------------

## 5. Arrays

BASIC-58 supports one-dimensional numeric arrays.

### 5.1 Declaration and indexing

Declare an array with `DIM` before using it.

``` basic
10 DIM A(10)
```

The declared size is the number of elements. Indices start at 1:

-   `A(1)` is the first element.
-   `A(10)` is the tenth element.

Index 0 is not valid. Array indices must be integer values. Access
outside the declared range causes an error.

### 5.2 Assignment and access

Use `LET` to assign an array element:

``` basic
10 DIM A(5)
20 LET A(1) = 100
30 LET A(2) = 200
40 PRINT A(1)
50 LET B = A(1) + A(2)
60 END
```

Indices can be variables or numeric expressions:

``` basic
10 DIM A(10)
20 FOR I = 1 TO 10
30 LET A(I) = I * I
40 NEXT I
50 END
```

### 5.3 UBOUND

Return the upper array index, which is also the number of elements
because BASIC-58 arrays start at index 1.

``` basic
PRINT UBOUND(A)
```

### 5.4 Array limitations

-   Only one-dimensional numeric arrays are supported.
-   String arrays and multidimensional arrays are not supported.
-   Arrays are initialized with zero values.
-   Arrays are cleared by `RUN` and `NEW`.
-   `ERASE` removes an array so it can be declared again.

------------------------------------------------------------------------

## 6. User-defined numeric functions

BASIC-58 supports user-defined numeric functions using `DEF FN`.

### 6.1 Definition

``` basic
DEF FN name(parameter) = expression
DEF FN name(parameter, parameter, ...) = expression
```

Functions accept one or more numeric parameters and return the result of
a numeric expression.

Example:

``` basic
10 DEF FN DOUBLE(X) = X * 2
20 DEF FN ADD(X,Y) = X + Y
30 PRINT FN DOUBLE(21)
40 PRINT FN ADD(12,30)
50 END
```

Expected output:

``` text
42
42
```

### 6.2 Function behaviour

-   Arguments can be expressions.
-   Functions can call other user-defined functions.
-   Nested function calls are supported.
-   A function must be defined before it is called during program
    execution.
-   Defining an existing function again replaces its previous
    definition.
-   User-defined functions return numeric results.

------------------------------------------------------------------------

## 7. Numeric functions

The following numeric functions are available.

  Function          Description
  ----------------- -----------------------------------
  `ABS(x)`          Absolute value
  `INT(x)`          Integer part
  `SGN(x)`          Sign of a number
  `SQR(x)`          Square root
  `SIN(x)`          Sine
  `COS(x)`          Cosine
  `TAN(x)`          Tangent
  `LOG(x)`          Natural logarithm
  `EXP(x)`          Exponential
  `RND(1)`          Random number
  `ROUND(n)`        Round to the nearest integer
  `ROUND(n,m)`      Round to `m` decimal places
  `MAX(a,b)`        Return the larger of two numbers
  `MIN(a,b)`        Return the smaller of two numbers
  `MOD(a,b)`        Remainder of integer division
  `DIV(a,b)`        Integer quotient of division
  `UBOUND(array)`   Return the upper array index

Trigonometric functions use radians.

### 7.1 ROUND

`ROUND(n)` rounds to the nearest integer.

`ROUND(n,m)` rounds to the specified number of decimal places. A
negative precision rounds to tens, hundreds, and so on.

Examples:

``` basic
10 PRINT ROUND(3.7)
20 PRINT ROUND(3.14159, 2)
30 PRINT ROUND(123.456, -1)
40 END
```

Results:

``` text
4
3.14
120
```

### 7.2 MAX and MIN

``` basic
MAX(a,b)
MIN(a,b)
```

Both arguments are numeric expressions.

### 7.3 MOD and DIV

`MOD(a,b)` returns the remainder of integer division. `DIV(a,b)` returns
the integer quotient, truncated toward zero.

Examples:

  Expression      Result
  ------------- --------
  `17 MOD 5`         `2`
  `17 DIV 5`         `3`
  `-17 MOD 5`       `-2`
  `-17 DIV 5`       `-3`
  `17 MOD -5`        `2`
  `17 DIV -5`       `-3`

The second argument must be non-zero. Division by zero produces a
BASIC-58 runtime expression error.

### 7.4 Random numbers

Use `RANDOMIZE` to initialize the random number generator and `RND(1)`
to obtain a random value.

Example: generate a dice value from 1 through 6.

``` basic
10 RANDOMIZE
20 LET DICE = INT(RND(1) * 6) + 1
30 PRINT "DICE: "; DICE
40 END
```

------------------------------------------------------------------------

## 8. String and conversion functions

BASIC-58 provides the following string functions.

  Function         Description
  ---------------- -------------------------------------------------
  `LEN(s)`         Return string length
  `LEFT$(s,n)`     Return the leftmost `n` characters
  `RIGHT$(s,n)`    Return the rightmost `n` characters
  `MID$(s,p,n)`    Extract `n` characters starting at position `p`
  `INSTR(s,t)`     Find a substring
  `STR$(x)`        Convert a number to a string
  `VAL(s)`         Convert a string to a number
  `ASC(s)`         Return a character code
  `CHR$(n)`        Return the character for a code
  `SPACE$(n)`      Create a string containing spaces
  `STRING$(n,c)`   Create a repeated-character string
  `UCASE$(s)`      Convert to uppercase
  `LCASE$(s)`      Convert to lowercase
  `LTRIM$(s)`      Remove leading spaces
  `RTRIM$(s)`      Remove trailing spaces
  `TRIM$(s)`       Remove leading and trailing spaces

### 8.1 Number base conversion

BASIC-58 provides functions that convert integer values to strings in
different number bases.

  Function   Description
  ---------- -----------------------------------
  `HEX(x)`   Convert an integer to hexadecimal
  `BIN(x)`   Convert an integer to binary
  `OCT(x)`   Convert an integer to octal

Example:

``` basic
10 LET VALUE = 1958
20 PRINT "DECIMAL: "; VALUE
30 PRINT "HEX: "; HEX(VALUE)
40 PRINT "BINARY: "; BIN(VALUE)
50 PRINT "OCTAL: "; OCT(VALUE)
60 END
```

These functions return strings and can be used in `PRINT` statements and
string expressions.

------------------------------------------------------------------------

## 9. Error handling

BASIC-58 supports BASIC-style runtime error handling.

### 9.1 ON ERROR GOTO

Enable an error handler at the specified line.

``` basic
ON ERROR GOTO line
```

Disable the error handler:

``` basic
ON ERROR GOTO 0
```

### 9.2 RESUME

Retry the statement that caused the error.

``` basic
RESUME
```

### 9.3 RESUME NEXT

Continue execution at the statement following the one that caused the
error.

``` basic
RESUME NEXT
```

### 9.4 ERR and ERL

  Function   Description
  ---------- ----------------------------------------------
  `ERR`      Current error code
  `ERL`      Program line number where the error occurred

Example:

``` basic
10 ON ERROR GOTO 100
20 LET A = 10
30 LET B = 0
40 LET C = A / B
50 PRINT C
60 END
100 PRINT "ERROR "; ERR
110 PRINT "IN LINE "; ERL
120 END
```

Runtime errors are reported by the interpreter. When an error handler is
enabled, the program can inspect the error information and decide
whether to resume execution.

------------------------------------------------------------------------

## 10. Execution tracing

`TRACE ON` and `TRACE OFF` control execution tracing.

  Statement     Description
  ------------- ---------------------------
  `TRACE ON`    Enable execution tracing
  `TRACE OFF`   Disable execution tracing

While tracing is enabled, BASIC-58 displays the line number of each
executed program statement using the `[TRACE]` prefix. A line executed
repeatedly in a loop is displayed each time.

Example:

``` basic
10 TRACE ON
20 FOR I = 1 TO 3
30 PRINT I
40 NEXT I
50 TRACE OFF
60 END
```

------------------------------------------------------------------------

## 11. BASIC-58 system and execution commands

System commands begin with `@SYS`. The execution delay command is
`@DELAY`.

### 11.1 Display system information

``` text
@SYS SHOW TIME
@SYS SHOW DATE
@SYS SHOW VERSION
@SYS SHOW SETTINGS
```

  Command                Description
  ---------------------- --------------------------------------
  `@SYS SHOW TIME`       Display system time
  `@SYS SHOW DATE`       Display system date
  `@SYS SHOW VERSION`    Display BASIC-58 version information
  `@SYS SHOW SETTINGS`   Display current application settings

### 11.2 Set the program directory

``` text
@SYS SET FILEDIR "path"
```

Set the directory used for BASIC program files. The directory must
already exist.

Example:

``` text
@SYS SET FILEDIR "D:\BASIC58\Programs"
```

The setting is stored in `basic58.set` and restored automatically at
startup.

### 11.3 Clear terminal automatically on RUN

``` text
@SYS SET RUNCLEAR ON
@SYS SET RUNCLEAR OFF
```

  Setting   Behaviour
  --------- ---------------------------------------------------------
  `ON`      Clear the terminal automatically when a program starts
  `OFF`     Preserve existing terminal output when a program starts

`RUNCLEAR` defaults to `ON`. Its value is stored in `basic58.set` and
restored at startup.

### 11.4 Execution delay

``` basic
@DELAY milliseconds
```

Pause program execution asynchronously for the specified number of
milliseconds.

The application remains responsive while the delay is in progress.

Example:

``` basic
10 PRINT "WAITING..."
20 @DELAY 1000
30 PRINT "CONTINUING"
40 END
```

------------------------------------------------------------------------

## 12. Serial communication and hardware control

BASIC-58 provides serial communication through the `@SER` commands. The
serial transport is independent of the meaning of individual device
commands.

### 12.1 Serial connection commands

``` text
@SER CONNECT COMx
@SER DISCONNECT
@SER LISTPORTS
```

  Command               Description
  --------------------- --------------------------------------
  `@SER CONNECT COMx`   Connect to the specified serial port
  `@SER DISCONNECT`     Disconnect from the controller
  `@SER LISTPORTS`      List available serial ports

Replace `COMx` with the port assigned to the connected device, for
example `COM10`.

Connect and disconnect operations are handled asynchronously by the host
application. BASIC-58 waits for the operation to complete before
continuing.

### 12.2 Generic serial command

``` basic
@SER ADR CMD VAL
```

Send a command consisting of three numeric byte values.

  Parameter   Description                     Range
  ----------- ---------------------------- --------
  `ADR`       Device address                 0--255
  `CMD`       Command code                   0--255
  `VAL`       Command value or parameter     0--255

Each parameter accepts a numeric literal, numeric variable or
parenthesized numeric expression. Expressions containing spaces must be
enclosed in parentheses.

Exactly three parameters are required. Each parameter must evaluate to
an integer in the range 0--255.

Example using literals:

``` basic
10 @SER CONNECT COM10
20 @SER 18 4 1
30 @DELAY 1000
40 @SER 18 4 0
50 @SER DISCONNECT
60 END
```

Example using variables and expressions:

``` basic
10 @SER CONNECT COM10
20 LET LED = 18
30 LET CMD = 4
40 LET STATE = 1
50 @SER LED CMD STATE
60 @SER LED (2 + 2) STATE
70 @SER DISCONNECT
80 END
```

BASIC-58 does not assign a hardware-specific meaning to `ADR`, `CMD` or
`VAL`. The connected controller decides what action a command
represents.

### 12.3 Five-byte protocol

Each serial message uses the BASIC-58 five-byte frame:

    Byte Description
  ------ ------------------------
       1 Header: `0x19`
       2 Device address (`ADR`)
       3 Command (`CMD`)
       4 Value (`VAL`)
       5 Footer: `0x58`

Frame layout:

``` text
0x19 | ADR | CMD | VAL | 0x58
```

The protocol is compact and independent of a particular microcontroller
or programming language. Any controller implementing the same frame
format can communicate with BASIC-58.

Communication is bi-directional. BASIC-58 sends commands and receives
frames from the connected device. The host application handles serial
transport, framing, acknowledgement handling and communication timeouts.

### 12.4 ASSIGN --- external numeric data

`ASSIGN` waits for the next incoming serial frame and assigns its
numeric data to BASIC-58 variables.

`ASSIGN` is separate from keyboard `INPUT`:

-   `INPUT` reads values entered by the user.
-   `ASSIGN` receives numeric values from an external device.

#### Single-value assignment

``` basic
ASSIGN variable
```

The `VAL` field of the next incoming frame is assigned to a numeric
variable or an existing numeric array element.

Examples:

``` basic
100 ASSIGN TEMP
110 ASSIGN TEMPERATURE(1)
```

Complete example:

``` basic
10 @SER CONNECT COM10
20 DIM TEMPERATURE(10)
30 FOR I = 1 TO 10
40 ASSIGN TEMPERATURE(I)
50 PRINT "TEMPERATURE: "; TEMPERATURE(I)
60 NEXT I
70 @SER DISCONNECT
80 END
```

#### Three-field assignment

``` basic
ASSIGN ADR,CMD,VAL
```

The next incoming frame is received and its address, command and value
fields are assigned to three numeric variables.

  Variable   Received field
  ---------- ----------------
  `ADR`      Device address
  `CMD`      Command code
  `VAL`      Command value

Example:

``` basic
10 @SER CONNECT COM10
20 PRINT "WAITING FOR TEMPERATURE..."
30 ASSIGN ADR,CMD,VAL
40 IF ADR = 32 THEN 60
50 GOTO 30
60 IF CMD = 1 THEN 80
70 GOTO 30
80 PRINT "TEMPERATURE: "; VAL
90 @SER DISCONNECT
100 END
```

This example accepts a frame with address 32 and command 1. Other frames
are ignored and the program waits for another frame.

`ASSIGN` does not accept string variables.

If the serial connection is lost while `ASSIGN` is waiting, BASIC-58
stops program execution with:

``` text
?SERIAL CONNECTION LOST
```

The `BREAK` command cancels a pending `ASSIGN` and stops program
execution.

A value received through `ASSIGN` becomes a normal BASIC-58 numeric
variable. A host application can retrieve it using `GetVariable` after
execution has completed.

------------------------------------------------------------------------

## 13. Host application integration

BASIC-58 can be embedded in a host application. The host can supply
numeric values, execute BASIC-58 logic, retrieve numeric results and
receive state-change notifications.

The host bridge is deliberately independent of specific communication
protocols. The host application remains responsible for external
services and hardware.

### 13.1 Host bridge API

  ----------------------------------------------------------------------------
  Interface                    Direction               Purpose
  ---------------------------- ----------------------- -----------------------
  `SetVariable(Name, Value)`   Host → BASIC-58         Supply a numeric value

  `GetVariable(Name)`          Host ← BASIC-58         Retrieve a numeric
                                                       variable

  `@HOST STATE "NAME" VALUE`   BASIC-58 → Host         Send a state-change
                                                       notification
  ----------------------------------------------------------------------------

### 13.2 SetVariable

``` vb
Interpreter.SetVariable("LEVEL", 20)
```

`SetVariable` stores a numeric value in a separate host-variable map.

When `RUN` starts, host-supplied values are copied into the normal
BASIC-58 variable map. The BASIC program can then read and modify them
like ordinary numeric variables.

Calling `SetVariable` while a program is already executing does not
immediately update the active BASIC variable. The new value is available
at the next `RUN`.

### 13.3 GetVariable

``` vb
Dim Level As Double = Interpreter.GetVariable("LEVEL")
```

`GetVariable` returns the current value of a numeric BASIC-58 variable.
It returns zero if the variable does not exist.

For asynchronous programs, retrieve the value after the interpreter
signals that execution has completed, for example in the host's
`Interpreter_Ready` callback.

### 13.4 @HOST STATE

``` basic
@HOST STATE "NAME" VALUE
```

`NAME` is a state name enclosed in quotation marks. `VALUE` is a numeric
value or numeric expression.

Example:

``` basic
100 @HOST STATE "PUMP" 1
110 @HOST STATE "ALARM" 0
```

When BASIC-58 executes this command, it raises the host's
`HostStateChanged` callback with the supplied name and value.

Example B4J callback:

``` vb
Private Sub Interpreter_HostStateChanged(Name As String, Value As Double)
    Log($"[HostStateChanged] ${Name} = ${Value}"$)
End Sub
```

The callback is raised synchronously during execution of the
`@HOST STATE` command.

**Important:** `@HOST STATE` sends a notification only. It does not
directly control hardware or modify an external system. The host
application decides how to handle the notification. Changing a BASIC-58
variable does not automatically generate a notification.

### 13.5 Combining the host bridge with serial data

A serial device can send a measurement to the host application. The host
forwards the received frame to BASIC-58, where `ASSIGN` stores the value
in a BASIC variable.

After the program completes, the host can retrieve the value with
`GetVariable`.

For asynchronous serial operations, the host must resume BASIC-58 after
the relevant connection or disconnection callback has completed. The
interpreter provides `ResumeHardwareCommand` for this purpose.

For the complete B4J API, callback implementation, communication flow
and tested host examples, see the separate **BASIC-58 Host Bridge**
document.

------------------------------------------------------------------------

## 14. Keyboard shortcuts

The B4XPages application provides the following function-key shortcuts.

  Key     Action
  ------- ----------------------------
  `F1`    Display help
  `F4`    Renumber program (`RENUM`)
  `F5`    Run program
  `F6`    List program
  `F7`    Load program
  `F8`    Save program
  `F9`    Create a new program
  `F10`   Clear terminal
  `F11`   Toggle full-screen mode

------------------------------------------------------------------------

## 15. Language limitations and compatibility

BASIC-58 is inspired by classic line-numbered BASIC dialects, but it is
not intended to be a complete implementation of any historical BASIC.

Important language characteristics include:

-   `LET` is required for ordinary variable assignments.
-   Numeric variable names can contain up to eight characters.
-   `FOR` loop variables must be single letters from `A` to `Z`.
-   `IF ... THEN` branches to a line number; inline statements are not
    supported.
-   Arrays are one-dimensional numeric arrays with indices starting at
    1.
-   User-defined functions return numeric values.
-   `ASSIGN` receives external numeric data and does not accept string
    variables.
-   `PRINT` semicolons do not insert spaces automatically.

The language is intentionally kept small, readable and practical.
Hardware and host integration are provided through explicit extensions
rather than by making the core language dependent on a particular
device.

------------------------------------------------------------------------

## 16. Example programs

The BASIC-58 project includes example programs covering language
features and practical applications.

Typical categories include:

-   Language fundamentals and expressions.
-   Mathematical and practical calculations.
-   Games and interactive examples.
-   Serial communication and hardware control.
-   Development and regression tests.

The examples are intended to be read, modified and run. They provide
practical demonstrations of the statements and functions described in
this manual.

------------------------------------------------------------------------

## 17. Version information

This manual describes BASIC-58 **Version 1.0.0**, Build **20261123**.

The implementation is developed with B4J and uses a B4XPages application
for its graphical user interface.

For project background, installation information, release notes and
examples, see the project `README.md`.

------------------------------------------------------------------------

## 18. License

BASIC-58 is distributed under the MIT License. See the project's
`LICENSE` file for the complete license text.

------------------------------------------------------------------------

*BASIC-58 --- Retro BASIC Interpreter*\
*Made with curiosity, a little nostalgia, and the conviction that BASIC
still has something to teach us.*
