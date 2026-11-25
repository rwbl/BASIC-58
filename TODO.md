# TODO – BASIC-58

BASIC-58 already has a substantial feature set. The next step should be to demonstrate what it can do, not simply add more language features.

**Priority: Arduino examples first, then the loop constructs, then array INPUT.**


## ComboBox Cursor
The ComboBox cursor is not visible after requesting focus.
The following workaround currently works:

```vb
Sleep(50)
taOutput.RequestFocus
Sleep(20)
cbCommands.RequestFocus
```
### Status Low Priority.
Workaround available. Further investigation pending.
Revisit only if it becomes troublesome.

## INPUT – Array Elements
Allow array elements directly in INPUT statements.
Example:
```
INPUT A(I)
```
### Status Low Priority.
A small, well-defined language improvement. It can be handled independently.
Not started.

## Additional Loop Constructs
Add WHILE/WEND and REPEAT/UNTIL.  
Examples:
```
10 WHILE FUNFACT <= 90
20 LET FUNFACT = INT(RND(1) * 100)
30 WEND
```
```
10 REPEAT
20 LET FUNFACT = INT(RND(1) * 100)
30 UNTIL FUNFACT > 90
```
**Requirements:**
- Use one shared loop-management mechanism for FOR, WHILE and REPEAT.
- Support nested and mixed loop constructs.
- Ensure BREAK works with all loop types.
- Preserve existing FOR/NEXT behaviour.
Design principle: One interpreter, one loop-management mechanism.
### Status Medium Priority.
This is the most interesting interpreter development item. 
Decided to use one shared loop-management mechanism. It avoids creating separate mechanisms that become difficult to maintain.
Not started.

## Arduino IoT Examples
**Objective:** Create a progressive collection of practical IoT examples using an Arduino as a process simulator connected to BASIC-58 over USB serial.

### Communication
- Arduino -> BASIC-58: ASSIGN (receiving data).
- BASIC-58 -> Arduino: @SER (sending commands).

### Planned examples
1. LED control – Switch an Arduino LED ON/OFF.
2. Temperature monitor – Receive and display simulated temperatures.
3. Alarm system – Receive alarm states and react to them.
4. Tank level monitoring – Monitor simulated levels and generate alarms.
5. Pump control – Send pump ON/OFF commands.
6. Mini SCADA – Combine measurements, indicators, alarms and commands.

### Implementation principles:
- No real sensors required; Arduino acts as a simulator.
- Reuse the existing serial protocol.
- Keep examples independent and easy to understand.
- Provide both BASIC-58 programs and Arduino firmware.
- Introduce concepts progressively.
### Goal
A small, realistic IoT/SCADA demonstration connecting BASIC programming to the physical world.
### Status High Priority.
This is the next practical development project. 
It brings together several existing BASIC-58 features and gives users something tangible to experiment with.
- LED communication already proven.

## Further Host Integration
The initial embedded scripting interface is implemented and tested.
### Completed
- Host -> BASIC-58: SetVariable.
- BASIC-58 -> Host: GetVariable.
- BASIC-58 -> Host: @HOST STATE notifications.
- Integration with serial communication and ASSIGN.
### Possible future extensions
- External functions.
- Additional data types.
- Further host application examples.
### Status Low Priority.
Initial host bridge completed -> The first milestone is done. 
Future extensions pending.

---

## SubString
For consideration as provided by Anywhere Software:
```
'Returns the substring from StartIndex up to, but excluding, EndIndex.
'Negative indices count back from the end. Omit EndIndex or pass 0 to include the rest of the string.
'Indices are clamped to the string bounds.
Public Sub SubString(s As String, StartIndex As Int, EndIndex As Int = 0) As String
    If StartIndex < 0 Then 
        StartIndex = Max(0, s.Length + StartIndex)
    Else
        StartIndex = Min(s.Length, StartIndex)
    End If
    If EndIndex <= 0 Then
        EndIndex = Max(0, s.Length + EndIndex)
    Else
        EndIndex = Min(s.Length, EndIndex)
    End If
    If EndIndex <= StartIndex Then Return ""
    Return s.SubString2(StartIndex, EndIndex)
End Sub
```
### Status Low Priority.
Revisit only if it becomes troublesome.

## Text Graphics Support
For an 80×40 character screen, without introducing pixel graphics:
- Text graphics: draw walls, paths, objects and characters using ASCII characters.
- Screen positioning: LOCATE row, column.
- Character output: PRINT at a specific position.
- Keyboard interaction: read keys without waiting for Enter.
- Simple games: Pong-like games, Snake, maze exploration, reaction games.

B58TextGraphics.bas would be a dedicated class, keeping graphics functionality outside B58Interpreter.
A possible responsibility split:
- B58Interpreter: BASIC language commands and execution.
- B58TextGraphics: character screen, cursor positioning, clearing and drawing.
- HOST application: actual display and keyboard interaction.
That also leaves the door open for different host implementations without complicating the interpreter.
First milestone would simply be an 80×40 character screen with CLS, LOCATE and positioned text output.
### Status Low Priority.
Not started.

