# BASIC-58

```{=html}
<p align="center">
```
`<img src="images/BASIC-58-Logo.png"
       alt="BASIC-58"
       width="200">`{=html}
```{=html}
</p>
```
**Version 1.0.0**

**BASIC-58 - Retro BASIC Interpreter**

An experimental BASIC interpreter written in BASIC (B4X), inspired by
retro computing.

------------------------------------------------------------------------

## About BASIC-58

**BASIC-58** is a small, retro-inspired BASIC interpreter developed as a
hobby project using [B4J](https://www.b4x.com/b4j.html).

The project explores how a BASIC interpreter works internally, from
parsing and evaluating expressions to managing program flow and handling
runtime errors. It was inspired by classic computers and projects such
as [MEGS65](https://github.com/MEGS65) and
[Xemu](https://github.com/theretroweb/xemu).

**BASIC-58** is also an educational project, designed to encourage learning through experimentation. 
It provides a simple environment to explore programming concepts, write small programs, and understand how computers execute instructions.

### A little bit of retro irony

BASIC-58 is itself written in BASIC --- specifically, B4J.

`So BASIC is being used to bring BASIC back.`

------------------------------------------------------------------------

## Features

BASIC-58 implements a practical subset of classic, line-numbered BASIC,
with extensions for hardware and host application integration.

### Programming environment

-   Interactive BASIC command prompt.
-   Numbered program lines, including automatic line numbering when
    loading editor source.
-   Immediate-mode commands and expressions.
-   Program editing, listing, renumbering, saving and loading.
-   Program interruption with `BREAK`.
-   Configurable terminal clearing when `RUN` starts.
-   B4XPages user interface with function-key shortcuts and full-screen
    mode.

### BASIC language

-   Numeric and string variables.
-   Arithmetic and string expressions.
-   `LET`, `PRINT` and `INPUT`.
-   `IF ... THEN` line-number branching.
-   `GOTO`, `GOSUB` and `RETURN`.
-   `FOR ... NEXT` loops.
-   `ON ... GOTO` and `ON ... GOSUB`.
-   `DATA`, `READ` and `RESTORE`.
-   One-dimensional numeric arrays.
-   User-defined numeric functions with `DEF FN`.
-   Numeric and string functions.
-   Runtime error handling and recovery.
-   Execution tracing with `TRACE ON` and `TRACE OFF`.

### Hardware and host integration

-   Serial communication using the `@SER` commands.
-   External numeric data acquisition using `ASSIGN`.
-   Asynchronous execution delay using `@DELAY`.
-   Host-supplied numeric variables using `SetVariable`.
-   Numeric variable retrieval using `GetVariable`.
-   Host notifications using `@HOST STATE`.
-   System information and persistent application settings using `@SYS`.

------------------------------------------------------------------------

## Screenshot

```{=html}
<p align="center">
```
`<img src="images/BASIC-58-1.png"
       alt="BASIC-58 running a temperature conversion program"
       width="400">`{=html}
```{=html}
</p>
```

------------------------------------------------------------------------

## Requirements

-   Windows
-   Java runtime compatible with B4J
-   B4J 64-bit for development
-   B4XPages

The application is developed with B4J.

------------------------------------------------------------------------

## Getting started

Start BASIC-58 to open the interactive command prompt. You can enter
commands directly or create a numbered BASIC program.

Try this first program:

``` basic
10 REM FIRST BASIC-58 PROGRAM
20 LET A = 10
30 LET B = 20
40 PRINT "HELLO FROM BASIC-58"
50 PRINT "THE SUM IS "; A + B
60 END
```

Enter:

``` text
RUN
```

Expected output:

``` text
HELLO FROM BASIC-58
THE SUM IS 30
```

### A few BASIC-58 reminders

-   BASIC statements are numbered.
-   Use `LET` for ordinary assignments, for example `LET TOTAL = A + B`.
-   `IF` branches to a line number, for example
    `IF ANSWER = 42 THEN 100`.
-   `FOR` loop variables must be single letters.
-   Variable names can contain up to eight characters.
-   `INPUT` reads keyboard input; `ASSIGN` receives external numeric
    data.
-   `RND(1)` produces a random value. `INT(RND(1) * N) + 1` produces an
    integer from 1 through N.
-   A `PRINT` semicolon does not insert a space. Include a trailing
    space in the text when needed, for example `PRINT "SAVED "; SAVED`.

------------------------------------------------------------------------

## Environment commands

The following commands are entered directly at the BASIC prompt.

  Command                        Description
  ------------------------------ ----------------------------------------------------------
  `HELP`                         Display help information
  `RUN`                          Execute the current program
  `NEW`                          Create a new empty program
  `LIST`                         List the entire program
  `LIST start-line`              List from the specified line onwards
  `LIST start-line, end-line`    List an inclusive line range
  `RENUM`                        Renumber the program, starting at 10 in increments of 10
  `RENUM new-start`              Renumber from the specified starting line
  `RENUM new-start, increment`   Specify starting line and increment
  `SAVE`                         Save the current BASIC program
  `LOAD`                         Load a BASIC program
  `CLS`                          Clear the terminal
  `BREAK`                        Interrupt program execution
  `BYE`                          Close BASIC-58

Expressions can also be evaluated directly:

``` basic
PRINT 10 + 20
PRINT "HELLO"
```

Program lines are stored and listed in ascending line-number order.
Entering an existing line number replaces that line; entering a line
number without a statement deletes it.

------------------------------------------------------------------------

## Hardware communication

BASIC-58 can communicate with external controllers over a serial
connection. The serial interface is designed to be simple and
independent of the specific hardware.

The basic commands are:

``` text
@SER CONNECT COMx
@SER DISCONNECT
@SER LISTPORTS
@SER ADR CMD VAL
```

The generic `@SER ADR CMD VAL` command sends a device address, command
code and value. Each parameter accepts a numeric literal, numeric
variable or parenthesized numeric expression.

BASIC-58 uses a fixed five-byte frame:

``` text
0x19 | ADR | CMD | VAL | 0x58
```

External numeric data is received with `ASSIGN`:

``` basic
10 @SER CONNECT COM10
20 PRINT "WAITING FOR TEMPERATURE..."
30 ASSIGN TEMP
40 PRINT "TEMPERATURE: "; TEMP
50 @SER DISCONNECT
60 END
```

`ASSIGN TEMP` assigns the value field of the next incoming frame to the
BASIC variable `TEMP`. The three-field form, `ASSIGN ADR,CMD,VAL`,
assigns all three frame fields.

The host application handles the serial transport, framing and
asynchronous connection operations. The connected controller defines the
meaning of individual commands.

------------------------------------------------------------------------

## Host application integration

BASIC-58 can be embedded in a host application. The host bridge provides
a small interface:

  ----------------------------------------------------------------------------
  Interface                    Direction               Purpose
  ---------------------------- ----------------------- -----------------------
  `SetVariable(Name, Value)`   Host → BASIC-58         Supply a numeric value

  `GetVariable(Name)`          Host ← BASIC-58         Retrieve a numeric
                                                       variable

  `@HOST STATE "NAME" VALUE`   BASIC-58 → Host         Send a state-change
                                                       notification
  ----------------------------------------------------------------------------

Host-supplied values are copied into the BASIC variable set when `RUN`
starts. `@HOST STATE` raises a callback; the host application decides
what action to perform.

For the complete API, callback examples, serial integration details and
implementation notes, see the [BASIC-58 Host Bridge
documentation](docs/BASIC-58-HOST-BRIDGE.md).

------------------------------------------------------------------------

## Example programs

The project includes BASIC programs organized by topic. The examples are
intended to be loaded, run, read and modified.

  -----------------------------------------------------------------------
  Folder                              Contents
  ----------------------------------- -----------------------------------
  `00_GETSTARTED`                     Ten small introductory programs for
                                      young beginners

  `01_LANGUAGE`                       Language statements, expressions,
                                      functions and control flow

  `02_PRACTICAL`                      Mathematics and everyday
                                      calculation examples

  `03_GAMES`                          Small interactive games

  `04_HARDWARE`                       Serial communication and hardware
                                      examples

  `99_DEVELOPMENT`                    Development, debugging and
                                      regression-test programs
  -----------------------------------------------------------------------

The `00_GETSTARTED` collection includes Hello, My Age, Rocket Countdown,
Times Table, Guess Number, Dice Rolls, Mini Calculator, Treasure Hunt,
Saving Goal, and Rock Paper Scissors.

------------------------------------------------------------------------

## Documentation

The README introduces the project and provides a quick start. The
detailed language and command descriptions are maintained separately.

-   **[BASIC-58 Reference Manual](docs/BASIC-58-REFERENCE-MANUAL.md)**
    --- complete language and environment reference, including
    statements, functions, arrays, error handling, system commands,
    serial communication and host integration.
-   **[BASIC-58 Host
    Bridge](Documentation/BASIC58_Host_Bridge_README.md)** --- host API,
    callbacks and integration examples.
-   `HELP.TXT` --- quick reference available from the BASIC-58
    application.

------------------------------------------------------------------------

## Testing

BASIC-58 has been tested incrementally during development.

Application acceptance tests cover startup and the user interface,
editor behaviour, immediate commands, program creation, saving and
loading, error handling, keyboard shortcuts and application lifecycle.

BASIC program regression tests cover language statements, numeric and
string expressions, functions, arrays, loops, branching, DATA
processing, runtime error recovery, serial data acquisition, host
variables and host notifications.

The example programs are also used as practical language tests.

------------------------------------------------------------------------

## BASIC-58 and classic BASIC

BASIC-58 is inspired by traditional line-numbered BASIC dialects such as
Microsoft GW-BASIC. It is not intended to be a complete implementation
of GW-BASIC or any other historical BASIC dialect.

It keeps the familiar programming style while deliberately limiting the
language to a manageable set of statements, expressions and functions.

Some important distinctions:

-   `LET` is required for ordinary assignments.
-   Variable names are limited to eight characters.
-   `FOR` loop variables must be single letters.
-   `IF ... THEN` branches to a line number; inline statements after
    `THEN` are not supported.
-   Arrays are one-dimensional numeric arrays.
-   `ASSIGN`, `@SER`, `@DELAY`, `@HOST STATE` and `@SYS` provide
    extensions for external data, hardware and host applications.

The goal is simplicity, readability and experimentation.

**Small enough to understand, powerful enough to be useful, and fun to
program!**

------------------------------------------------------------------------

## Project status

**BASIC-58 Version 1.0.0** is a working hobby project and a learning
exercise in interpreter development. The current release represents a
tested and usable implementation of its BASIC language subset.

The project is intentionally kept small and approachable. Further
development will focus on examples and practical applications,
particularly serial communication and Arduino-based IoT experiments.

------------------------------------------------------------------------

## License

This project is licensed under the MIT License.

See the [LICENSE](LICENSE) file for details.

------------------------------------------------------------------------

## Credits, acknowledgements and inspiration

-   [Anywhere Software](https://www.b4x.com/) for the B4X suite of RAD
    development tools.
-   [MEGS65](https://github.com/MEGS65) and
    [Xemu](https://github.com/theretroweb/xemu) for inspiration from the
    retro-computing community.
-   [OpenAI](https://openai.com/) and ChatGPT for AI-assisted
    engineering collaboration, problem solving and development
    discussions.
-   The wider programming and open-source communities for sharing
    knowledge, ideas and experience.

------------------------------------------------------------------------

## Disclaimer

**BASIC-58** is an experimental hobby project developed for educational
and learning purposes.

-   The software is provided "AS IS", without warranty of any kind.
-   It is not intended for professional, commercial, safety-critical or
    industrial control applications.
-   It has not been designed, tested or certified for use in critical or
    production environments.
-   Use of the software is entirely at your own risk.

All product names, logos, trademarks and brands mentioned in this
project are the property of their respective owners.

------------------------------------------------------------------------

> *BASIC-58 --- Made with curiosity, a little nostalgia, and the
> conviction that BASIC still has something to teach us.*
