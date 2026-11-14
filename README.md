# expBASIC

**Version 0.1.0**

An experimental BASIC interpreter written in BASIC (B4X), inspired by retro computing.

## About the project

expBASIC is a personal hobby project inspired by retro computing and projects such as [MEGS65](https://github.com/MEGS65) and [Xemu](https://github.com/theretroweb/xemu).

The project has two main goals:

- **Learning:** exploring how to write a BASIC interpreter, from parsing expressions and handling variables to executing program lines and managing program flow.
- **Sharing:** creating a simple programming environment that I can share with my grandchild, encouraging experimentation and learning by writing small BASIC programs.

I also simply enjoy retro computing and the atmosphere of classic home computers, where you could switch on a machine, get a BASIC prompt and start programming.

expBASIC is not intended to be a complete implementation of a historical BASIC dialect. It is an evolving learning project, developed step by step.

The idea is simple: keep BASIC approachable, make it fun to experiment with, and perhaps inspire someone else to discover programming.

The ultimate goal is to make expBASIC a small, reliable, educational BASIC interpreter with a nostalgic terminal experience. 
... and not a huge language implementation.

## A little bit of retro irony

There is something rather fitting about this project: **expBASIC is itself written in BASIC.**

The interpreter is developed using [B4J](https://www.b4x.com/b4j.html), a modern BASIC-based development environment.

So here we have a BASIC interpreter, written in BASIC, bringing BASIC back to life on a modern computer.

**BASIC is being used to bring BASIC back.**

## Features

expBASIC currently supports:

- Interactive BASIC command prompt
- Numbered program lines
- Program editing, listing and deletion
- Program execution
- SAVE and LOAD
- BREAK to interrupt program execution, including while waiting for INPUT
- Numeric and string variables
- Arithmetic expressions and operator precedence
- String expressions and string concatenation
- Numeric and string functions
- INPUT with multiple variables
- PRINT with formatting options
- IF / THEN conditional branching
- GOTO and GOSUB / RETURN
- FOR / NEXT loops, including nested loops
- ON GOTO and ON GOSUB
- DATA, READ and RESTORE
- RANDOMIZE and RND
- Error handling with ON ERROR GOTO
- RESUME and RESUME NEXT

--- 

<p align="center">
  <img src="images/expbasic-game.png"
       alt="expBASIC running the Number Guessing Game"
       width="700">
</p>

--- 

## Requirements

- B4J
- B4XPages framework
- A Java runtime supported by your B4J installation

## Getting started

Open the expBASIC project in B4J and run it.

The interpreter provides an interactive command prompt.

You can enter commands directly or create a numbered BASIC program.

For example:

```basic
10 PRINT "HELLO expBASIC"
20 PRINT 10 + 20
30 END
```

Enter:

```text
RUN
```

Expected output:

```text
RUNNING...

HELLO expBASIC
30

READY.
```

## Direct commands

These commands are entered directly at the interpreter prompt.

| Command | Description |
|---|---|
| HELP | Display available commands |
| LIST | List the current program |
| RUN | Execute the current program |
| NEW | Clear the current program |
| SAVE [filename] | Save the program |
| LOAD [filename] | Load a program |
| CLS | Clear the terminal |
| PRINT expression | Print an expression immediately |

### Editing programs

Enter a line number followed by a BASIC statement to add or replace a program line.

```text
10 PRINT "HELLO"
20 PRINT "WORLD"
```

Entering an existing line number with no statement deletes that line.

```text
20
```

Use `LIST` to display the current program.

### Saving and loading

```text
SAVE
```

Saves the program using the default filename `PROGRAM.BAS`.

You can also specify a filename:

```text
SAVE TEST.BAS
```

To load a program:

```text
LOAD TEST.BAS
```

Program files are stored in the application's directory.

## BASIC language reference

### Variables

expBASIC supports numeric and string variables.

```basic
10 LET A = 123
20 LET NAME$ = "ROBERT"
30 PRINT A
40 PRINT NAME$
50 END
```

String variable names end with `$`.

### Arithmetic operators

| Operator | Description |
|---|---|
| `+` | Addition |
| `-` | Subtraction |
| `*` | Multiplication |
| `/` | Division |

Parentheses can be used to control expression evaluation.

```basic
10 LET A = 10 + 5 * 2
20 LET B = (10 + 5) * 2
30 PRINT A
40 PRINT B
50 END
```

Expected output:

```text
20
30
```

### Program control

| Statement | Description |
|---|---|
| IF ... THEN | Conditional branching |
| GOTO | Jump to a program line |
| GOSUB | Call a subroutine |
| RETURN | Return from a subroutine |
| FOR / NEXT | Repeat a block of statements |
| ON ... GOTO | Computed branch |
| ON ... GOSUB | Computed subroutine call |
| BREAK | Interrupt program execution and return to the command prompt |
| END | End program execution |
| REM | Comment |

### Input and output

| Statement | Description |
|---|---|
| PRINT | Display text and expressions |
| INPUT | Read user input |

PRINT supports:

- Semicolon-separated output items
- Comma-separated print zones
- `TAB(n)` for positioning
- `SPC(n)` for inserting spaces
- Suppression of the final newline using `;` or `,`

### DATA handling

| Statement | Description |
|---|---|
| DATA | Define constant data items |
| READ | Assign DATA items to variables |
| RESTORE | Reset the DATA read position |

`RESTORE` currently resets the DATA pointer to the beginning of the DATA list.

### Random numbers

| Statement / Function | Description |
|---|---|
| RANDOMIZE | Initialize the random number generator |
| RANDOMIZE expression | Initialize it using a numeric seed |
| RND(1) | Generate a random number |

Using the same seed produces the same random sequence.

### Error handling

| Statement / Variable | Description |
|---|---|
| ON ERROR GOTO line | Enable an error handler |
| ON ERROR GOTO 0 | Disable error handling |
| RESUME | Retry the failed statement |
| RESUME NEXT | Continue with the next statement |
| ERR | Current error code |
| ERL | Line number where the error occurred |

Supported error codes:

| Code | Description |
|---|---|
| 5 | Undefined line |
| 11 | Division by zero |
| 20 | Syntax or expression error |
| 22 | NEXT without FOR |
| 23 | RETURN without GOSUB |

## Numeric functions

| Function | Description |
|---|---|
| ABS(x) | Absolute value |
| INT(x) | Integer part |
| SGN(x) | Sign of a number |
| SQR(x) | Square root |
| SIN(x) | Sine |
| COS(x) | Cosine |
| TAN(x) | Tangent |
| LOG(x) | Natural logarithm |
| EXP(x) | Exponential function |
| RND(1) | Random number |
| LEN(s$) | String length |
| VAL(s$) | Convert string to number |
| ASC(s$) | Character code |
| INSTR(s$, t$) | Find a substring |

## String functions

| Function | Description |
|---|---|
| LEFT$(s$, n) | Return leftmost characters |
| RIGHT$(s$, n) | Return rightmost characters |
| MID$(s$, start, n) | Return part of a string |
| STR$(x) | Convert number to string |
| CHR$(n) | Convert character code to string |
| SPACE$(n) | Generate spaces |
| STRING$(n, c) | Generate repeated characters |
| UCASE$(s$) | Convert to uppercase |
| LCASE$(s$) | Convert to lowercase |
| LTRIM$(s$) | Remove leading spaces |
| RTRIM$(s$) | Remove trailing spaces |
| TRIM$(s$) | Remove leading and trailing spaces |

# Examples

The following examples are based on the expBASIC regression tests.

They are intended to demonstrate the currently implemented language features and provide small programs to experiment with.

## 1. Hello, expBASIC!

A first BASIC program.

```basic
10 PRINT "HELLO expBASIC"
20 PRINT "WELCOME TO BASIC"
30 END
```

Expected output:

```text
HELLO expBASIC
WELCOME TO BASIC
```

## 2. Variables and arithmetic

```basic
10 LET A = 10
20 LET B = 20
30 LET C = A + B
40 PRINT "RESULT: "; C
50 PRINT "MULTIPLICATION: "; A * B
60 END
```

Expected output:

```text
RESULT: 30
MULTIPLICATION: 200
```

## 3. Expression evaluation

Demonstrates operator precedence and parentheses.

```basic
10 LET A = 10 + 5 * 2
20 LET B = (10 + 5) * 2
30 PRINT A
40 PRINT B
50 PRINT 100 / 5 + 3
60 END
```

Expected output:

```text
20
30
23
```

## 4. String variables and concatenation

```basic
10 LET NAME$ = "ROBERT"
20 LET TEXT$ = "HELLO " + "WORLD"
30 PRINT TEXT$
40 LET TEXT$ = CHR$(72) + CHR$(73)
50 PRINT TEXT$
60 LET TEXT$ = LEFT$(NAME$, 3) + "!"
70 PRINT TEXT$
80 END
```

Expected output:

```text
HELLO WORLD
HI
ROB!
```

## 5. Numeric functions

```basic
10 PRINT "SQUARE ROOT: "; SQR(144)
20 PRINT "ABSOLUTE: "; ABS(-25)
30 PRINT "INTEGER: "; INT(12.8)
40 PRINT "SIGN: "; SGN(-10)
50 PRINT "VALUE: "; VAL("123")
60 PRINT "LENGTH: "; LEN("expBASIC")
70 END
```

Expected output:

```text
SQUARE ROOT: 12
ABSOLUTE: 25
INTEGER: 12
SIGN: -1
VALUE: 123
LENGTH: 9
```

## 6. String functions

```basic
10 LET NAME$ = "expBASIC"
20 PRINT LEFT$(NAME$, 4)
30 PRINT RIGHT$(NAME$, 4)
40 PRINT MID$(NAME$, 3, 4)
50 PRINT UCASE$("hello")
60 PRINT LCASE$("WORLD")
70 PRINT TRIM$("  BASIC  ")
80 PRINT INSTR(NAME$, "BASIC")
90 END
```

Expected output:

```text
MONO
BASIC
NOBA
HELLO
world
BASIC
5
```

## 7. INPUT

Ask the user for a name and an age.

```basic
10 INPUT "ENTER NAME"; NAME$
20 INPUT "ENTER AGE"; AGE
30 PRINT "HELLO "; NAME$
40 PRINT "YOU ARE "; AGE; " YEARS OLD"
50 END
```

Example interaction:

```text
ENTER NAME?
Robert
ENTER AGE?
68
HELLO Robert
YOU ARE 68 YEARS OLD
```

INPUT also supports multiple variables in one statement.

```basic
10 INPUT "NAME AND AGE"; NAME$, AGE
20 PRINT "HELLO "; NAME$
30 PRINT "YOU ARE "; AGE; " YEARS OLD"
40 END
```

Example interaction:

```text
NAME AND AGE?
Robert, 68
HELLO Robert
YOU ARE 68 YEARS OLD
```

## 8. IF / THEN

Conditional execution.

```basic
10 LET A = 10
20 IF A > 5 THEN 50
30 PRINT "A IS FIVE OR LESS"
40 GOTO 60
50 PRINT "A IS GREATER THAN FIVE"
60 END
```

Expected output:

```text
A IS GREATER THAN FIVE
```

Supported comparison operators:

| Operator | Meaning |
|---|---|
| `=` | Equal |
| `<>` | Not equal |
| `<` | Less than |
| `>` | Greater than |
| `<=` | Less than or equal |
| `>=` | Greater than or equal |

Numeric comparisons and string equality/inequality are supported.

## 9. FOR / NEXT loops

A simple counting loop.

```basic
10 FOR A = 1 TO 5
20 PRINT A
30 NEXT A
40 END
```

Expected output:

```text
1
2
3
4
5
```

A loop with STEP:

```basic
10 FOR A = 10 TO 50 STEP 10
20 PRINT A
30 NEXT A
40 END
```

Expected output:

```text
10
20
30
40
50
```

Negative STEP is also supported.

```basic
10 FOR A = 5 TO 1 STEP -1
20 PRINT A
30 NEXT A
40 END
```

Expected output:

```text
5
4
3
2
1
```

Nested loops are supported:

```basic
10 FOR A = 1 TO 3
20 FOR B = 1 TO 2
30 PRINT A; B
40 NEXT B
50 NEXT A
60 END
```

Expected output:

```text
11
12
21
22
31
32
```

## 10. GOSUB / RETURN

Subroutines allow code to be reused.

```basic
10 PRINT "MAIN PROGRAM"
20 GOSUB 100
30 PRINT "BACK IN MAIN"
40 END
100 PRINT "INSIDE SUBROUTINE"
110 RETURN
```

Expected output:

```text
MAIN PROGRAM
INSIDE SUBROUTINE
BACK IN MAIN
```

Nested GOSUB calls are supported.

## 11. ON GOTO

Select a program branch using an expression.

```basic
10 LET A = 2
20 ON A GOTO 100, 200, 300
30 PRINT "NO BRANCH SELECTED"
40 END
100 PRINT "OPTION ONE"
110 END
200 PRINT "OPTION TWO"
210 END
300 PRINT "OPTION THREE"
310 END
```

Expected output:

```text
OPTION TWO
```

The selection is one-based. An out-of-range selector continues with the next program line.

## 12. ON GOSUB

Select a subroutine using an expression.

```basic
10 LET A = 2
20 ON A GOSUB 100, 200, 300
30 PRINT "BACK IN MAIN"
40 END
100 PRINT "SUBROUTINE ONE"
110 RETURN
200 PRINT "SUBROUTINE TWO"
210 RETURN
300 PRINT "SUBROUTINE THREE"
310 RETURN
```

Expected output:

```text
SUBROUTINE TWO
BACK IN MAIN
```

## 13. DATA and READ

DATA statements provide values that can be read into variables.

```basic
10 DATA 10, 20, 30, "HELLO", "WORLD"
20 READ A, B, C, A$, B$
30 PRINT A; B; C
40 PRINT A$; " "; B$
50 END
```

Expected output:

```text
102030
HELLO WORLD
```

DATA can be defined in multiple program lines.

Quoted strings can contain commas:

```basic
10 DATA 100, "HAMBURG, GERMANY"
20 READ A, CITY$
30 PRINT A
40 PRINT CITY$
50 END
```

Expected output:

```text
100
HAMBURG, GERMANY
```

RESTORE resets the DATA pointer.

```basic
10 DATA 10, 20, 30
20 READ A
30 PRINT A
40 RESTORE
50 READ B
60 PRINT B
70 END
```

Expected output:

```text
10
10
```

## 14. RANDOMIZE and RND

Generate random numbers:

```basic
10 RANDOMIZE
20 FOR A = 1 TO 5
30 PRINT RND(1)
40 NEXT A
50 END
```

The values change between runs when RANDOMIZE is called without a seed.

A fixed seed produces a repeatable sequence:

```basic
10 RANDOMIZE 12345
20 FOR A = 1 TO 5
30 PRINT RND(1)
40 NEXT A
50 END
```

Expected output:

```text
0.966251
0.10908
0.588241
0.488828
0.050055
```

Running the program again with the same seed produces the same sequence.

## 15. PRINT formatting

TAB and SPC can be used to format output.

```basic
10 PRINT "NAME"; TAB(15); "VALUE"
20 PRINT "TEMP"; TAB(15); "23.5"
30 PRINT "HUMIDITY"; TAB(15); "60"
40 PRINT "LEFT"; SPC(5); "RIGHT"
50 END
```

Expected output (spaces shown as normal terminal spacing):

```text
NAME          VALUE
TEMP          23.5
HUMIDITY      60
LEFT     RIGHT
```

PRINT also supports comma-separated print zones and suppressing the final newline with a trailing semicolon or comma.

## 16. Error handling

Errors can be handled by an error-handling routine.

```basic
10 ON ERROR GOTO 100
20 LET A = 10 / 0
30 PRINT "PROGRAM CONTINUES"
40 END
100 PRINT "ERROR CODE: "; ERR
110 PRINT "ERROR LINE: "; ERL
120 RESUME NEXT
```

Expected output:

```text
ERROR CODE: 11
ERROR LINE: 20
PROGRAM CONTINUES
```

`RESUME NEXT` continues execution at the next program line.

## 17. SAVE and LOAD

Programs can be saved and loaded.

Example program:

```basic
10 PRINT "SAVE AND LOAD TEST"
20 LET A = 123
30 PRINT A
40 END
```

Example workflow:

```text
SAVE PROGRAM.BAS
SAVED: PROGRAM.BAS

NEW
NEW PROGRAM

LIST
NO PROGRAM

LOAD PROGRAM.BAS
LOADED: PROGRAM.BAS
LINES: 4

LIST
10 PRINT "SAVE AND LOAD TEST"
20 LET A = 123
30 PRINT A
40 END

RUN
RUNNING...

SAVE AND LOAD TEST
123

READY.
```

## Regression testing

expBASIC has been tested with a collection of regression programs covering the implemented language features.

The tests include:

1. Numeric and string variables, arithmetic and expression precedence.
2. Numeric and string functions.
3. PRINT formatting, TAB, SPC and print zones.
4. INPUT with custom prompts and multiple mixed variables.
5. IF / THEN, GOTO and GOSUB / RETURN.
6. FOR / NEXT, positive and negative STEP values, and nested loops.
7. ON GOTO and ON GOSUB, including out-of-range selection.
8. RANDOMIZE and repeatable RND sequences.
9. DATA, READ and RESTORE, including quoted strings and commas.
10. Error handling, ERR, ERL, RESUME and RESUME NEXT.
11. SAVE, NEW, LIST, LOAD, RUN and immediate PRINT.

All eleven regression test areas have passed.

## Project status

expBASIC is an evolving hobby and learning project.

The interpreter is being developed incrementally, with new features tested before moving on to the next step.

The focus is on keeping the implementation understandable and the programming environment approachable.

Perhaps the best test of the project will be whether someone who has never used a BASIC computer can sit down, type a few lines and discover the fun of programming.

## License

This project is licensed under the MIT License.
See the [LICENSE](LICENSE) file for details.

---

## Credits and acknowledgements

- [Anywhere Software](https://www.b4x.com/) for the B4X suite of RAD development tools.
- [MEGS65](https://github.com/MEGS65) and [Xemu](https://github.com/theretroweb/xemu) for inspiration from the retro-computing community.
- [OpenAI](https://openai.com/) and ChatGPT for AI-assisted engineering collaboration, problem solving and development discussions.
- The wider programming and open-source communities for sharing knowledge, ideas and experience.

---

## Disclaimer

expBASIC is an experimental hobby project developed for educational and learning purposes.

- The software is provided "AS IS", without warranty of any kind.
- It is not intended for professional, commercial, safety-critical or industrial control applications.
- It has not been designed, tested or certified for use in critical or production environments.
- Use of the software is entirely at your own risk.

All product names, logos, trademarks and brands mentioned in this project are the property of their respective owners.

---

> *Made with curiosity, a little nostalgia, and the conviction that BASIC still has something to teach us.*

---
