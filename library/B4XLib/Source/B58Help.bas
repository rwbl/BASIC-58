B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=10.7
@EndOfDesignText@
' ================================================================
' Class Module:	B58Help
' Project:		BASIC-58
' Brief:		Help text for BASIC-58.
' Description:	Provides global help text.
'				Direct included in the library and will be updated
'				on every library change.
' ================================================================

Sub Process_Globals

	Public HelpText As String = $"BASIC-58 :: HELP
==================================================

1. COMMANDS

Commands entered directly at the BASIC prompt.

  HELP              Display this help
  LIST [start-line [, end-line]]
                    List the program or a selected range of lines
  RUN               Run the current program
  NEW               Create a new BASIC program
  LOAD [filename]   Load a program
  SAVE [filename]   Save a program
  CLS               Clear the terminal
  PRINT expression  Evaluate and print an expression
  BYE               Close BASIC-58 and return to the desktop

2. PROGRAM LINE NUMBERS

  Program lines can be entered with or without line numbers.
  Unnumbered lines are automatically numbered starting at 10,
  in increments of 10.
  Explicit line numbers are preserved.
  LIST displays program lines in ascending line-number order.
  RENUM renumbers the entire program, updates line references and sorts program lines by their existing line numbers before assigning new sequential line numbers. Execution order is therefore determined by line numbers, not by the order in which lines were entered.


3. KEYBOARD SHORTCUTS

  Key     Action
  F1      HELP
  F4      RENUM
  F5      RUN
  F6      LIST
  F7      LOAD
  F8      SAVE
  F9      NEW
  F10     CLS
  F11     FULLSCREEN TOGGLE
  F12     SHOW VERSION

4. PROGRAM STATEMENTS

Program statements are entered with a line number.

  LET variable = expression
      Assign a numeric or string value

  DIM arrayname(size)
      Declare a one-dimensional numeric array

  ERASE arrayname
      Remove an array from memory

  SWAP variable1, variable2
      Exchange two numeric variable or array element values

  INPUT [prompt;] variables
      Read values from the keyboard

  ASSIGN variable
      Wait for external numeric data and assign it to a variable
      or numeric array element

  PRINT expressions
      Display values and text

  IF condition THEN line
      Conditional branch

  GOTO line
      Jump to a program line

  GOSUB line
      Call a subroutine

  RETURN
      Return from a subroutine

  FOR variable = start TO limit [STEP value]
      Start a counting loop

  NEXT [variable]
      Continue or finish a FOR loop

  ON expression GOTO line,...
      Computed branch

  ON expression GOSUB line,...
      Computed subroutine call

  DATA value,...
      Define data values

  READ variable,...
      Read values from DATA

  RESTORE
      Reset DATA reading position

  RANDOMIZE [expression]
      Initialize the random number generator

  REM comment
      Add a program comment

  TRACE ON
      Enable execution tracing

  TRACE OFF
      Disable execution tracing

  END
      End program execution


5. USER-DEFINED FUNCTIONS

Define your own numeric functions.

  DEF FN name(parameter) = expression

  DEF FN name(parameter,parameter,...) = expression

Example:

  10 DEF FN DOUBLE(X) = X * 2
  20 DEF FN ADD(X,Y) = X + Y
  30 PRINT FN DOUBLE(21)
  40 PRINT FN ADD(12,30)

Notes:
  - Functions accept one or more numeric parameters.
  - Arguments can be expressions.
  - Functions can call other user-defined functions.
  - A function must be defined before it is called.
  - A new definition replaces an existing definition.


6. NUMERIC ARRAYS

Declare a one-dimensional numeric array using DIM.

  DIM arrayname(size)

Example:

  10 DIM A(10)

This creates an array with exactly 10 elements.

Array indexing starts at 1.

  A(1)       First element
  A(10)      Last element

All elements are initialized to zero.

Assign values to array elements using LET:

  10 DIM A(5)
  20 LET A(1) = 100
  30 LET A(2) = 200

Read array elements in expressions:

  40 PRINT A(1)
  50 LET B = A(1) + A(2)

Array indices can be variables or numeric expressions:

  10 DIM A(10)
  20 FOR I = 1 TO 10
  30 LET A(I) = I * I
  40 NEXT I

Array commands and functions:

  ERASE A
      Remove array A from memory

  UBOUND(A)
      Return the upper array index (number of elements)

  SWAP A(1), A(2)
      Exchange two array elements

  SWAP A(1), B
      Exchange an array element and a numeric variable

Notes:
  - Array indices start at 1.
  - Index 0 is not valid.
  - Indices must be integer values.
  - Access outside the declared range causes an error.
  - Arrays must be declared before use.
  - An array cannot be declared twice while it exists.
  - ERASE allows an array to be declared again.
  - Arrays are cleared by RUN and NEW.
  - Only one-dimensional numeric arrays are supported.
  - String arrays and multidimensional arrays are not supported.
  - ERASE removes a declared array from memory.
  - UBOUND(array) returns the number of elements in an array.


7. NUMERIC FUNCTIONS

  ABS(x)        Absolute value
  INT(x)        Integer part
  SGN(x)        Sign of a number
  SQR(x)        Square root

  ROUND(n)	    Round to the nearest integer
  ROUND(n,m)    Round to m decimal places; negative m rounds to tens, hundreds, etc.

  MAX(n,m)      Return the larger of two numbers
  MIN(n,m)      Return the smaller of two numbers

  MOD(a,b)      Returns the remainder after integer division.
  DIV(a,b)      Returns the integer quotient after division.

  SIN(x)        Sine
  COS(x)        Cosine
  TAN(x)        Tangent

  LOG(x)        Natural logarithm
  EXP(x)        Exponential
  RND(x)        Random number

  UBOUND(array) Return the upper array index


8. STRING AND CONVERSION FUNCTIONS

  LEN(s)        String length
  LEFT$(s,n)    Leftmost n characters
  RIGHT$(s,n)   Rightmost n characters
  MID$(s,p,n)   Extract part of a string

  STR$(x)       Convert number to string
  VAL(s)        Convert string to number
  ASC(s)        Character code
  CHR$(n)       Character from code

  SPACE$(n)     String of spaces
  STRING$(n,c)  Repeated character

  UCASE$(s)     Convert to uppercase
  LCASE$(s)     Convert to lowercase
  LTRIM$(s)     Remove leading spaces
  RTRIM$(s)     Remove trailing spaces
  TRIM$(s)      Remove leading and trailing spaces

  INSTR(s,t)    Find a substring

  HEX(x)        Convert integer to hexadecimal string
  BIN(x)        Convert integer to binary string
  OCT(x)        Convert integer to octal string
  
9. PRINT FORMATTING

  TAB(n)        Move to column n
  SPC(n)        Print n spaces

  ;             Separate items without advancing
  ,             Advance to the next print zone


10. ERROR HANDLING

  ON ERROR GOTO line
      Enable error handling at the specified line

  ON ERROR GOTO 0
      Disable error handling

  RESUME
      Retry the statement that caused the error

  RESUME NEXT
      Continue with the next statement

  ERR
      Error code

  ERL
      Line number where the error occurred


11. SYSTEM COMMANDS

  @SYS SHOW TIME
      Display system time

  @SYS SHOW DATE
      Display system date

  @SYS SHOW VERSION
      Display version information

  @SYS SHOW SETTINGS	Display current application settings.
  @SYS SET FILEDIR "path"	Set and save the BASIC program directory.
       The directory must already exist. The setting is stored in basic58.set and restored automatically at startup.

  @SYS SET RUNCLEAR ON
       Clear the terminal automatically when RUN starts

  @SYS SET RUNCLEAR OFF
       Keep existing terminal output when RUN starts
	   
12. EXECUTION COMMANDS

  @DELAY milliseconds
      Pause program execution asynchronously

13. SERIAL COMMANDS

  @SER CONNECT COMx
      Connect to a serial controller

  @SER DISCONNECT
      Disconnect the controller

  @SER LISTPORTS
      List available COM ports

  @SER ADR CMD VAL
      Send a generic command to the serial controller.

      ADR   Device address (0-255)
      CMD   Command code (0-255)
      VAL   Command value (0-255)

      The command is transmitted using the BASIC-58
      five-byte serial protocol:

        0x19 | ADR | CMD | VAL | 0x58

      Parameters can be numeric literals, variables
      or parenthesized numeric expressions.

      Examples:

        10 LET LED = 18
        20 LET CMD = 4
        30 LET STATE = 1
        40 @SER LED CMD STATE
        50 @SER LED (2 + 2) STATE

      Expressions containing spaces must be enclosed
      in parentheses.

      All three parameters must evaluate to integer
      values in the range 0-255.
      Exactly three parameters are required.


  ASSIGN variable
      Wait for the next external numeric value.
      The received VAL field is assigned to a numeric
      variable or an existing numeric array element.

      Examples:

        100 ASSIGN TEMP
        110 ASSIGN TEMP(1)

	A value received through ASSIGN becomes a normal BASIC-58 numeric variable. 
	A host application can retrieve thi	s value using the GetVariable method. 
	For asynchronous programs, the host should retrieve it after the interpreter signals completion.

  ASSIGN ADR,CMD,VAL
      Wait for the next external serial frame.
      Assign all three fields from the received frame
      to numeric variables:

        ADR   Device address
        CMD   Command code
        VAL   Command value

      Example:

        200 ASSIGN ADR,CMD,VAL
        210 IF ADR = 32 THEN 230
        220 GOTO 200
        230 IF CMD = 1 THEN 250
        240 GOTO 200
        250 PRINT "VALUE: "; VAL

      This allows BASIC programs to filter incoming
      frames by address and command.

      ASSIGN does not accept string variables.

      If the serial connection is lost while waiting,
      program execution stops with:

        ?SERIAL CONNECTION LOST

      BREAK cancels the pending ASSIGN and stops
      program execution.

14. HOST COMMANDS

BASIC-58 can communicate with its host application using
the @HOST command.

14.1 @HOST STATE

Syntax:

    @HOST STATE "NAME" VALUE

Sends a state-change notification to the host application.

Parameters:

    NAME    State name enclosed in quotation marks.
    VALUE   Numeric value or numeric expression.

Example:

    100 @HOST STATE "PUMP" 1
    110 @HOST STATE "ALARM" 0

The command raises the HostStateChanged event in the
host application.

The host application receives the state name and numeric
value and decides what action to perform.

For example, the host could:
    - Switch a hardware output.
    - Send an OPC UA write request.
    - Publish an MQTT message.
    - Send a command to an Arduino.
    - Update an application status.

IMPORTANT:

The @HOST STATE command only sends a notification.
It does not directly control hardware.

Changing a BASIC-58 variable does not automatically
generate a host notification.

15. A FEW BASIC-58 REMINDERS
   - BASIC statements are numbered.
   - Use `LET` for assignments, for example `LET TOTAL = A + B`.
   - `IF` branches to a line number, for example `IF ANSWER = 42 THEN 100`.
   - `FOR` and `NEXT` repeat a group of lines.
   - `RND(1)` produces a random value; these examples use `INT(RND(1) * N) + 1`
        to produce an integer from 1 through N.
   - `INPUT` asks the player to enter a value.
   - Variable names: maximum 8 characters.
   - FOR loop variables: single letters only.
   - When joining text and a value with `;` in a `PRINT` statement, include a trailing space in the text if you want a space in the output.
	  For example: `PRINT "SAVED "; SAVED`.

==================================================
END OF HELP
.
"$

Public HintsText As String = $"A FEW BASIC-58 REMINDERS
- BASIC statements are numbered.
- Use `LET` for assignments, for example `LET TOTAL = A + B`.
- `IF` branches to a line number, for example `IF ANSWER = 42 THEN 100`.
- `FOR` and `NEXT` repeat a group of lines.
- `RND(1)` produces a random value; these examples use `INT(RND(1) * N) + 1` to produce an integer from 1 through N.
- `INPUT` asks the player to enter a value.
- Variable names: maximum 8 characters.
- FOR loop variables: single letters only.
- When joining text and a value with `;` in a `PRINT` statement, include a trailing space in the text if you want a space in the output.
  - For example: `PRINT "SAVED "; SAVED`.
"$

Public EasterEggText As String = $"================================
       B A S I C - 5 8
================================

HELLO, RETRO PROGRAMMER!

SOME THINGS NEVER GET OLD.
ESPECIALLY A GOOD BASIC PROGRAM.

KEEP CODING And HAVE FUN!

        :-)
================================
"$

End Sub	' Process_Globals
