
[B]BASIC-58 – An experimental BASIC interpreter written in BASIC[/B]

[B]Introduction[/B]

Hi all,

I'd like to share a small hobby project I've been working on: [B]BASIC-58[/B], an experimental BASIC interpreter developed with B4X/B4J.

The idea started with my interest in retro computing and the classic home computers of the past. 
I wanted to explore how a BASIC interpreter actually works, while also creating something simple and approachable that encourages learning and experimentation.

There is also a little bit of retro irony involved: BASIC-58 is itself written in BASIC, using B4X/B4J!

[B]What is BASIC-58?[/B]

BASIC-58 is a small, evolving BASIC interpreter with a familiar line-numbered programming style.

It is available as a reusable B4X library, so it can be integrated into other B4J applications as well as used in its own BASIC-58 application.

It currently supports features such as:

- Numeric and string variables
- Numeric arrays
- Arithmetic expressions and built-in functions
- PRINT and INPUT
- ASSIGN for external numeric data acquisition
- IF...THEN, GOTO, GOSUB and RETURN
- FOR...NEXT loops, including nested loops
- DATA, READ and RESTORE
- User-defined functions (DEF FN)
- Random numbers and RANDOMIZE
- Program editing, LIST, RUN, SAVE and LOAD
- Error handling and recovery
- Execution tracing
- Number base conversion (HEX, BIN and OCT)

[B]BASIC-58 extensions[/B]

In addition to the traditional BASIC statements, BASIC-58 provides a small set of extended commands using the @ prefix.

These add functionality beyond the BASIC language itself:

- [B]@SYS[/B] – Host system commands, including SHOW TIME, SHOW DATE, SHOW VERSION and SHOW SETTINGS, as well as program directory configuration.
- [B]@SER[/B] – Serial communication with external controllers, including connection management and sending commands.
- [B]@DELAY[/B] – An asynchronous execution delay, allowing BASIC programs to pause without blocking the application.
- [B]@HOST STATE[/B] – Send named numeric state-change notifications from a BASIC program to its host application.

The serial interface uses a simple five-byte binary frame. 
A BASIC program can connect to a controller, send commands, receive acknowledgements and acquire numeric data from external devices using the ASSIGN statement.

For example, the following program switches an LED on and off:

[CODE]
10 @SER CONNECT COM10
20 LET LED = 18
30 LET CMD = 4
40 LET STATE = 1
50 @SER LED CMD STATE
60 @DELAY 1000
70 LET STATE = 0
80 @SER LED CMD STATE
90 @SER DISCONNECT
100 END
[/CODE]

The actual meaning of the address, command and value is determined by the connected controller.

[B]BASIC-58 as an embedded scripting engine[/B]

One interesting aspect of the project is that the interpreter can also be used as a scripting engine inside another B4J application.

The host application can:

- Supply numeric variables to a BASIC-58 program.
- Retrieve numeric variables after execution.
- Receive state-change notifications through a callback.
- Handle external communication and hardware operations independently of the interpreter.

For example, a B4J application could supply a tank level to BASIC-58. The BASIC program evaluates the value and sends a pump ON/OFF request back to the host application.

This keeps the BASIC program responsible for the application logic while the host handles the actual communication with external systems.

[B]Source code, documentation and examples[/B]

The source code, B4X library, documentation and example BASIC programs are available on GitHub:

[URL=https://github.com/YOUR-GITHUB-NAME/BASIC-58]BASIC-58 on GitHub[/URL]

[B]A final thought[/B]

My aim is to keep the project simple, approachable and fun – much like programming on the home computers that inspired it.

It is still an evolving hobby project, and there is plenty of room for further experiments and improvements.

Comments, suggestions and ideas are very welcome!

Best regards
