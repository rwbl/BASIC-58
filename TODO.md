# TODO BASIC-58

## ComboBox Cursor
The combobox cursor is not visible after requesting focus.
This workaround in works:
```
' Apply - esp show the combobox cursor requested via sleep workaround
Sleep(50)
taOutput.RequestFocus
Sleep(20)
cbCommands.RequestFocus
```
#### Status
Not started.

## ARRAY elements to INPUT
Support array elements directly in INPUT, so INPUT A(I) becomes valid. 
#### Status
Not started.

## Add WHILE/WEND and REPEAT/UNTIL loop constructs
Extend BASIC-58 with two additional loop structures while maintaining a single, consistent loop-management mechanism.
Planned syntax:
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

Implementation requirements:
- Use the existing FOR/NEXT loop infrastructure where practical.
- One shared loop stack and consistent loop management.
- Support nested loops, including mixed FOR, WHILE and REPEAT loops.
- Ensure BREAK works correctly with all loop types.
- Preserve existing FOR/NEXT behaviour.

Design principle: 
No separate loop engines. One interpreter, one loop-management mechanism.

## 
Excellent! Let's add this as a dedicated section in the BASIC-58 TODO list.

## Arduino IoT examples**
**Objective:** Build a progressive collection of practical IoT examples using an Arduino as a process simulator connected to BASIC-58 over USB serial.
The examples will demonstrate both communication directions:

- Arduino → BASIC-58: `ASSIGN` (receiving external data).
- BASIC-58 → Arduino: `@SER` (sending commands).

### **Planned examples**

1. **LED control**
   Communication proven
   BASIC-58 switches an Arduino LED ON and OFF. Turn the existing working serial command/acknowledgement test into a documented beginner example.

2. **Temperature monitor**
   Arduino sends simulated temperature values. BASIC-58 receives and displays them using `ASSIGN`.

3. **Alarm system**
   Arduino sends alarm status. BASIC-58 detects and reacts to alarm conditions.

4. **Tank level monitoring**
   Simulated level measurements with high-level and low-level alarms.

5. **Pump control**
   BASIC-58 sends pump ON/OFF commands to the Arduino using `@SER`.

6. **Mini SCADA**

   Combine measurements, status indicators, alarms and commands into one small process-control application.

### **Implementation principles**

- Arduino acts as a simulator; no real sensors are required.
- Reuse the existing serial protocol and BASIC-58 commands.
- Keep each example independent and easy to understand.
- Introduce concepts progressively.
- Provide both the BASIC-58 program and Arduino firmware.

**Final goal:** A small but realistic IoT/SCADA demonstration built with BASIC-58 and an Arduino.
This gives BASIC-58 something beyond traditional BASIC exercises: a practical connection to the physical world.
#### Status
Not started.

## BASIC-58 as an embedded IoT scripting engine

1. Define the host-to-interpreter interface.
2. Implement setting and retrieving numeric variables.
3. Implement interpreter-to-host state notifications.
4. Add a small B4J host application as a demonstration.
5. Later consider external functions and other data types.

Deliberately start with numeric values. Extend it when there is a real need.
#### Status
Not started.
