# BASIC-58 — GetStarted

Ten small BASIC-58 programs for young beginners (around age 10).

The examples are arranged as a gentle progression. Run them, try them, and then
change the programs to see what happens.

## The ten examples

| File | Program | What it introduces |
|---|---|---|
| `01_HELLO.BAS` | Hello | `PRINT`, text input and string variables |
| `02_MY_AGE.BAS` | My age in ten years | Numeric input, variables and arithmetic |
| `03_ROCKET.BAS` | Rocket countdown | `FOR` / `NEXT` loops and negative steps |
| `04_TIMES_TABLE.BAS` | Multiplication challenge | Random numbers, multiplication and `IF` |
| `05_GUESS_NUMBER.BAS` | Guess my number | Random numbers, comparisons, branching and attempts |
| `06_DICE_ROLLS.BAS` | Ten dice rolls | Loops, random numbers and counting |
| `07_MINI_CALCULATOR.BAS` | Mini calculator | Choices, arithmetic and branching |
| `08_TREASURE_HUNT.BAS` | Treasure hunt | Coordinates, comparisons and hints |
| `09_SAVING_GOAL.BAS` | Saving goal | Repeated calculations and a loop |
| `10_ROCK_PAPER_SCISSORS.BAS` | Rock, Paper, Scissors | Random choices and game rules |

## How to use

1. Open BASIC-58.
2. Load one of the `.BAS` files from this folder.
3. Run the program.
4. Try changing the program and run it again.

## A few BASIC-58 reminders

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
  
## Try changing the programs

- Change the rocket countdown to start at 20.
- Make the multiplication challenge use numbers up to 12.
- Give the number-guessing player 10 attempts instead of 7.
- Roll the dice 100 times instead of 10.
- Add another calculator operation or another game rule.
- Change the treasure hunt grid from 5 by 5 to 10 by 10.

Have fun — and remember: the computer does exactly what the program tells it to do!
