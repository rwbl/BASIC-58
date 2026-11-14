# expBASIC Examples

This folder contains small BASIC programs for exploring expBASIC.

## How to use

1. Start expBASIC.
2. Enter `LOAD filename.BAS` using one of the filenames below.
3. Enter `LIST` if you want to inspect the program.
4. Enter `RUN` to execute it.

The files are numbered roughly from beginner examples to language-feature demonstrations.

## Programs and expected output

### `01_HELLO.BAS`

**Purpose:** 01 Hello.

Expected output:

```text
HELLO expBASIC
WELCOME TO BASIC
```

### `02_ARITHMETIC.BAS`

**Purpose:** 02 Arithmetic.

Expected output:

```text
RESULT: 30
MULTIPLICATION: 200
```

### `03_EXPRESSIONS.BAS`

**Purpose:** 03 Expressions.

Expected output:

```text
20
30
23
```

### `04_STRINGS.BAS`

**Purpose:** 04 Strings.

Expected output:

```text
HELLO WORLD
HI
ROB!
```

### `05_NUMERIC_FUNCTIONS.BAS`

**Purpose:** 05 Numeric Functions.

Expected output:

```text
SQUARE ROOT: 12
ABSOLUTE: 25
INTEGER: 12
SIGN: -1
VALUE: 123
LENGTH: 9
```

### `06_STRING_FUNCTIONS.BAS`

**Purpose:** 06 String Functions.

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

### `07_INPUT.BAS`

**Purpose:** 07 Input.

Interactive: enter a name and then an age at the prompts.

### `08_IF_THEN.BAS`

**Purpose:** 08 If Then.

Expected output:

```text
A IS GREATER THAN FIVE
```

### `09_FOR_NEXT.BAS`

**Purpose:** 09 For Next.

Expected output:

```text
1
2
3
4
5
```

### `10_NESTED_LOOPS.BAS`

**Purpose:** 10 Nested Loops.

Expected output:

```text
11
12
21
22
31
32
```

### `11_GOSUB_RETURN.BAS`

**Purpose:** 11 Gosub Return.

Expected output:

```text
MAIN PROGRAM
INSIDE SUBROUTINE
BACK IN MAIN
```

### `12_ON_GOTO.BAS`

**Purpose:** 12 On Goto.

Expected output:

```text
OPTION TWO
```

### `13_ON_GOSUB.BAS`

**Purpose:** 13 On Gosub.

Expected output:

```text
SUBROUTINE TWO
BACK IN MAIN
```

### `14_DATA_READ.BAS`

**Purpose:** 14 Data Read.

Expected output:

```text
102030
HELLO WORLD
```

### `15_RESTORE.BAS`

**Purpose:** 15 Restore.

Expected output:

```text
10
10
```

### `16_RANDOM_NUMBERS.BAS`

**Purpose:** 16 Random Numbers.

Expected output:

```text
0.966251
0.10908
0.588241
0.488828
0.050055
```

### `17_PRINT_FORMATTING.BAS`

**Purpose:** 17 Print Formatting.

Spacing is significant; inspect the terminal output.

### `18_ERROR_HANDLING.BAS`

**Purpose:** 18 Error Handling.

Expected output:

```text
ERROR CODE: 11
ERROR LINE: 30
PROGRAM CONTINUES
```

### `19_SAVE_LOAD_TEST.BAS`

**Purpose:** 19 Save Load Test.

Expected output:

```text
SAVE AND LOAD TEST
123
```

## Notes

- `07_INPUT.BAS` pauses for user input. The entered values determine the displayed result.
- `16_RANDOM_NUMBERS.BAS` uses a fixed seed, so the tested sequence is repeatable.
- `17_PRINT_FORMATTING.BAS` demonstrates spacing and tab positioning; exact visual spacing depends on the terminal display.
- `15_RESTORE.BAS` uses the currently implemented plain `RESTORE` form, which resets DATA reading to the beginning.
- `50_...BAS` some example games.
