Oh, arrays! 😎 I was hoping we'd get to that one.

I think **arrays should be the next major language feature of BASIC-58**. They add a lot of possibilities without changing the character of the interpreter.

And given the direction of BASIC-58, I'd plan the next development steps around three areas:

1. Improving the BASIC language.
2. Making hardware interaction more useful.
3. Adding a few quality-of-life features to the programming environment.

I would resist adding too many things at once. BASIC-58 should remain small, understandable and enjoyable to work with.

## **Proposed BASIC-58 roadmap**

### **1. Arrays — my first priority**

Top priority

I'd start with classic BASIC-style numeric arrays using `DIM`.

For example:

```
10 DIM TEMPERATURE(10)
20 FOR I = 1 TO 10
30 LET TEMPERATURE(I) = 20 + I
40 NEXT I
50 PRINT TEMPERATURE(5)
60 END
```

Then extend the concept to two-dimensional arrays:

```
10 DIM GRID(5,5)
20 LET GRID(2,3) = 123
30 PRINT GRID(2,3)
40 END
```

Potential scope:

- `DIM` declaration.
- One-dimensional arrays.
- Two-dimensional arrays.
- Numeric arrays initially.
- String arrays later, if useful.
- Array bounds checking.
- Clear error messages for undeclared arrays and invalid indices.

I'd deliberately keep the first implementation simple. No dynamic arrays, no complicated memory management and no unnecessary features.

Arrays would immediately make statistics, tables, sorting, simulations and small games much more interesting.

### **2. Better array operations**

After the basic array implementation, I'd consider a few useful additions:

- `ERASE` — remove an array from memory.
- `UBOUND` — retrieve the upper array index.
- `SWAP` — exchange two variable or array values.

I would not implement these together with `DIM`. First get array storage, assignment, reading and bounds checking working reliably.

One design decision to make before implementation: whether arrays start at index 0 or index 1. I'd document one consistent rule and avoid adding `OPTION BASE` initially.

### **3. More serial communication capabilities**

High priority

This is another area with considerable potential.

The five-byte protocol already gives us a good foundation. I'd develop it in stages:

- Test communication with a standard Python script.
- Test communication with MicroPython.
- Improve incoming data handling.
- Support sensor readings from the controller.
- Extend device addressing and commands.
- Add examples for LEDs, temperature sensors, servos and other maker projects.

For example, imagine a BASIC program reading a temperature sensor and displaying its values:

```
10 REM TEMPERATURE MONITOR
20 @SER CONNECT COM10
30 REM READ SENSOR VALUE
40 REM DISPLAY TEMPERATURE
50 END
```

The exact BASIC commands for receiving sensor data still need to be designed. I'd keep the communication details inside `B58Serial`, rather than burdening the interpreter with protocol handling.

### **4. Additional BASIC language features**

These are useful candidates, but I wouldn't put them ahead of arrays.

| Feature        | Why it could be useful     |
| -------------- | -------------------------- |
| `WHILE / WEND` | Condition-controlled loops |
| `SWAP`         | Exchange variable values   |
| `INKEY$`       | Read a keyboard key        |
| `ERASE`        | Remove arrays              |
| `UBOUND`       | Get array upper bound      |
| `OPEN / CLOSE` | Runtime file access        |

Of these, `WHILE / WEND` and `INKEY$` would be particularly interesting for interactive programs and games.

### **5. User-defined commands**

You previously considered a persistent `mycommands.json` file.

I still like this idea. It could allow users to define their own application commands without modifying the interpreter.

For example, a user could define a shortcut for a frequently used system or hardware operation.

I'd keep this separate from BASIC language statements and implement it later.

### **6. More system commands**

The `@SYS` namespace could gradually gain a few useful commands:

- `@SYS SHOW TIME`
- `@SYS SHOW DATE`
- `@SYS SHOW VERSION`
- `@SYS SHOW MEMORY`

This would give BASIC-58 a little of that old DEC/VMS command-line flavour without trying to recreate an entire operating system.

## **Suggested development sequence**

Here is how I would organize the work:

## **BASIC-58 development roadmap**

1. **Arrays — v1.1**

   `DIM`, numeric arrays, one and two dimensions, array access and bounds checking.

   Next feature
2. **Serial communication — v1.1.x**

   Python and MicroPython compatibility, incoming data and sensor examples.
3. **Language enhancements — v1.2**

   `WHILE/WEND`, `SWAP`, `INKEY$` and selected additional functions.
4. **User-defined commands — v1.3**

   Persistent commands through `mycommands.json` and additional `@SYS` functionality.
5. **Maker projects — ongoing**

   Sensor monitoring, LEDs, servos, small automation projects and practical examples.

## **One thing I'd particularly like to see**

Imagine this little program once arrays and serial sensor input are available:

```
10 DIM TEMP(10)
20 REM COLLECT 10 TEMPERATURE READINGS
30 FOR I = 1 TO 10
40 REM READ SENSOR
50 REM STORE VALUE IN TEMP(I)
60 NEXT I
70 REM CALCULATE AVERAGE
80 LET TOTAL = 0
90 FOR I = 1 TO 10
100 LET TOTAL = TOTAL + TEMP(I)
110 NEXT I
120 PRINT "AVERAGE: "; TOTAL / 10
130 END
```

That's where BASIC-58 becomes particularly interesting: a simple BASIC program can work with real measurements from external hardware.

## **My final recommendation**

I'd concentrate on just two things for the next milestone:

1. **Arrays** — because they significantly extend the language and open up many programming possibilities.
2. **Serial input** — because it opens the door to real-world hardware projects.

Everything else can wait.

And one important principle: every new feature should come with a small example program and a few targeted tests. That keeps BASIC-58 maintainable as it grows.

I would much rather see BASIC-58 become a small, capable and well-designed BASIC system than a huge collection of half-implemented language features.
