
[B]BASIC-58 – An experimental BASIC interpreter written in BASIC[/B]

[B]Introduction[/B]

Hi all,

I'd like to share a small hobby project I've been working on: [B]BASIC-58[/B], an experimental BASIC interpreter developed with B4X/B4J.

The idea started with my interest in retro computing and the classic home computers of the past. I wanted to explore how a BASIC interpreter actually works, while also creating something that I could share with my grandchild as a simple way to discover programming.

There is also a little bit of retro irony involved: BASIC-58 is itself written in BASIC, using B4X/B4J!

[B]What is BASIC-58?[/B]

BASIC-58 is a small, evolving BASIC interpreter with a familiar line-numbered programming style.

It currently supports features such as:

- Numeric and string variables
- Numeric arrays
- Arithmetic expressions and built-in functions
- PRINT and INPUT
- ASSIGN for external numeric data acquisition
- IF...THEN, GOTO, GOSUB and RETURN
- FOR...NEXT loops
- DATA, READ and RESTORE
- User-defined functions (DEF FN)
- Random numbers and RANDOMIZE
- Program editing, LIST, RUN, SAVE and LOAD
- Basic error handling

[B]BASIC-58 extensions[/B]

In addition to the traditional BASIC statements, BASIC-58 provides a small set of extended commands using the @ prefix.

These add functionality beyond the BASIC language itself:

- [B]@SYS[/B] – Local system commands, currently including SHOW TIME and SHOW DATE.
- [B]@SER[/B] – Serial communication with an external controller, including connection management and LED control.
- [B]@DELAY[/B] – An asynchronous execution delay, allowing BASIC programs to pause without blocking the application.

The serial interface uses a simple five-byte binary protocol. A BASIC program can connect to a controller, send commands, receive acknowledgements and acquire numeric data from external devices using the ASSIGN statement.

For example:

[CODE]
10 @SER CONNECT COM10
20 @SER LED 18 ON
30 @DELAY 1000
40 @SER LED 18 OFF
50 @SER DISCONNECT
60 END
[/CODE]

This makes it possible to combine a small BASIC interpreter with real hardware interaction.

[B]Source code and examples[/B]

The source code, documentation and example BASIC programs are available on GitHub:

[URL=https://github.com/YOUR-GITHUB-NAME/BASIC-58]BASIC-58 on GitHub[/URL]

[B]A final thought[/B]

My aim is to keep the project simple, approachable and fun – much like programming on the home computers that inspired it.

Comments, suggestions and ideas are very welcome!

Best regards
