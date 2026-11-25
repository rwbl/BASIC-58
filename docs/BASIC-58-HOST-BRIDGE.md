# BASIC-58 Host Bridge

**Version:** 1.0.0\
**Build:** 20261125\
**Document:** Host Bridge Manual

------------------------------------------------------------------------

## Overview

The BASIC-58 Host Bridge allows an external application to communicate directly with the BASIC-58 interpreter.

It makes it possible to use BASIC-58 as an embedded scripting engine inside another application.

The host application can:

- Supply numeric data to BASIC-58.
- Execute a BASIC-58 program that processes the supplied data.
- Retrieve numeric variables after BASIC-58 has calculated or received them.
- Receive state-change notifications when BASIC-58 executes an `@HOST STATE` command.
- Combine the host bridge with serial communication and the BASIC-58 `ASSIGN` statement.

This provides a simple way to separate application logic from application-specific hardware and communication interfaces.

For example, a B4J application could use BASIC-58 to implement control logic for a small automation system:

- The host reads a tank level from a sensor or an external system.
- The host supplies the measured value to BASIC-58.
- BASIC-58 evaluates the tank level and decides whether a pump should run.
- BASIC-58 sends a pump state request to the host.
- The host performs the actual operation, for example through OPC UA, MQTT, serial communication or another interface.

The same bridge can also be used in the opposite direction for data acquisition. For example, an Arduino can send a temperature over a serial connection, BASIC-58 can receive it with `ASSIGN TEMP`, and the host can retrieve the resulting value with `GetVariable("TEMP")`.

**BASIC-58 handles the logic. The host application handles the outside world.**

## Design principles

The bridge is deliberately small and independent of the host application's implementation.

Its main principles are:

- Keep the existing BASIC-58 interpreter and execution model intact.
- Do not introduce dependencies on specific communication protocols.
- Keep the host interface simple.
- Use normal BASIC-58 variables for program logic.
- Let the host application decide how to handle notifications.
- Avoid unnecessary changes to existing BASIC-58 language syntax.

The bridge does not require the interpreter to know whether the host application uses OPC UA, MQTT, Arduino, databases, sensors or any other external system.

## Communication model

The host bridge provides three basic mechanisms. Serial communication can be combined with these mechanisms to receive data from an external device.

| Direction | Interface | Purpose |
| --- | --- | --- |
| Host → BASIC-58 | `SetVariable` | Supply a numeric value |
| BASIC-58 → Host | `@HOST STATE` | Send a state-change notification |
| Host ← BASIC-58 | `GetVariable` | Retrieve a numeric value |
| Serial device → BASIC-58 | `ASSIGN` | Receive external numeric data through the serial interface |

These mechanisms have different responsibilities:

- `SetVariable` supplies a value from the host before a program run.
- `ASSIGN` receives external data and assigns it to a BASIC-58 variable.
- `GetVariable` lets the host read the current value of a BASIC-58 variable.
- `@HOST STATE` explicitly notifies the host that BASIC-58 has reached a state or wants the host to handle a request.

In particular, `GetVariable` does not require an `@HOST STATE` command. A host can retrieve a variable after the BASIC-58 program has completed.

## 1. Host → BASIC-58: SetVariable

The host application supplies a numeric value to the interpreter:

```vb
Interpreter.SetVariable("LEVEL", 20)
```

This stores the supplied value in the interpreter's separate host-variable map.

When BASIC-58 executes `RUN`, the host-supplied values are copied into the normal BASIC-58 variable map. The BASIC program can then use these variables like ordinary numeric variables.

For example:

```basic
10 PRINT "TANK LEVEL: "; LEVEL
20 LET LEVEL = LEVEL + 5
30 END
```

The host can supply values before starting the program.

**Important:** Host-supplied values are copied into the normal variable map when `RUN` starts. Calling `SetVariable` while a program is already executing does not immediately update its active BASIC variable. The new value will be available at the next `RUN`.

### Using host variables in BASIC-58

Variables supplied by the host application are available directly to BASIC-58 programs. There is no need to assign them again using `LET`.

The host application sets a variable before starting the BASIC-58 program:

```vb
Interpreter.SetVariable("STOP", 1)
Interpreter.LoadProgram(taB58SourceEditor.Text)
Interpreter.RunProgram
```

The BASIC-58 program can use the variable directly in expressions and conditions:

```basic
10 PRINT "HOST CONTROL TEST"
20 IF STOP = 1 THEN 60
30 PRINT "PROGRAM CONTINUES"
40 GOTO 20
60 PRINT "STOP REQUEST RECEIVED"
70 END
```

**Important:**

- `SetVariable` stores the value supplied by the host.
- At the beginning of `RunProgram`, host variables are copied into the BASIC-58 variable table.
- Host variables can be used directly in BASIC-58 expressions and conditions.
- No explicit `LET` statement is required to initialize a host-provided variable.
- `GetVariable` can retrieve the current value after program execution.

This allows the host application to influence BASIC-58 program flow without introducing additional BASIC statements or special syntax.

## 2. BASIC-58 → Host: @HOST STATE

BASIC-58 can notify the host application about a state change or an action request.

Command syntax:

```basic
@HOST STATE "NAME" VALUE
```

Parameters:

| Parameter | Description |
| --- | --- |
| `NAME` | State name enclosed in quotation marks |
| `VALUE` | Numeric value or numeric expression |

Example:

```basic
@HOST STATE "PUMP" 1
```

This raises the `HostStateChanged` event in the host application.

The host receives:

```text
Name  = "PUMP"
Value = 1
```

The notification itself does not control any hardware. The host application decides what action to perform.

For example, it could:

- Switch a physical output.
- Write a value to an OPC UA variable.
- Publish an MQTT message.
- Send a command to an Arduino.
- Update an application status indicator.
- Store an event in a database.

The host application is responsible for implementing the actual operation.

**The `@HOST STATE` command raises the host event synchronously during BASIC-58 execution.**

This is an explicit notification. Merely changing a BASIC-58 variable does not automatically raise `HostStateChanged`.

## 3. Host ← BASIC-58: GetVariable

The host application can retrieve the current value of a BASIC-58 numeric variable:

```vb
Dim Level As Double = Interpreter.GetVariable("LEVEL")
```

The method returns:

- The current value if the variable exists.
- `0` if the variable does not exist.

This allows the host to read values that BASIC-58 has received or calculated.

For example:

```basic
10 LET LEVEL = LEVEL + 5
20 END
```

After the program has finished, the host can retrieve the updated value using `GetVariable`.

`GetVariable` is independent of `@HOST STATE`. The BASIC program does not need to send a state notification just to make a variable available to the host.

**For programs that perform asynchronous operations, such as waiting for serial data with `ASSIGN`, retrieve the variable after the interpreter reports that the program has finished. See the serial temperature example below.**

## Host bridge API

The initial host bridge exposes two public methods and one interpreter-to-host notification event.

### SetVariable

```vb
Public Sub SetVariable(Name As String, Value As Double)
```

Stores a numeric value supplied by the host application.

| Parameter | Description |
| --- | --- |
| `Name` | BASIC-58 variable name |
| `Value` | Numeric value supplied by the host |

Example:

```vb
Interpreter.SetVariable("TEMP", 75)
Interpreter.SetVariable("LEVEL", 20)
```

Variable names are case-insensitive and are stored using uppercase names.

The values are copied into the normal interpreter variable map when `RUN` starts.

### GetVariable

```vb
Public Sub GetVariable(Name As String) As Double
```

Returns the current value of a BASIC-58 numeric variable.

| Parameter | Description |
| --- | --- |
| `Name` | BASIC-58 variable name |

Return value:

- Current numeric variable value.
- `0` if the variable does not exist.

Example:

```vb
Dim Temperature As Double = Interpreter.GetVariable("TEMP")
Log(Temperature)
```

### GetVariables
```
Public Sub GetVariables As Map
```
Returns all current BASIC-58 numeric variables and their values.

The returned Map is a snapshot of the interpreter's current variable state. 
Modifying the returned Map does not affect the interpreter.

Return value:
- Map containing variable names and their current numeric values.
- Empty Map if no variables exist.

Example:
```
Dim Variables As Map = Interpreter.GetVariables

For Each Name As String In Variables.Keys
    Log(Name & " = " & Variables.Get(Name))
Next
```

### HostStateChanged

The interpreter raises the following event when it executes an `@HOST STATE` command:

```vb
Private Sub Interpreter_HostStateChanged(Name As String, Value As Double)
```

| Parameter | Description |
| --- | --- |
| `Name` | State name supplied by the BASIC program |
| `Value` | Numeric state value |

The event name follows the normal B4J callback naming convention. For an interpreter initialized with the event name `Interpreter`, the host implements:

```vb
Private Sub Interpreter_HostStateChanged(Name As String, Value As Double)
    ' Handle the notification.
End Sub
```

The host application decides what to do with the received information.

# Example: Tank Level Control

This example demonstrates communication between a B4J host application and the BASIC-58 interpreter.

The host supplies a simulated tank level. BASIC-58 evaluates the measurement and requests a pump state change.

## 1. BASIC-58 control program

```basic
10 PRINT "TANK LEVEL CONTROL"
20 PRINT "LEVEL: "; LEVEL; " %"
30 IF LEVEL < 30 THEN 100
40 IF LEVEL > 80 THEN 200
50 END

100 PRINT "LOW LEVEL - START PUMP"
110 @HOST STATE "PUMP" 1
120 END

200 PRINT "HIGH LEVEL - STOP PUMP"
210 @HOST STATE "PUMP" 0
220 END
```

### Control logic

| Tank level | BASIC-58 action |
| --- | --- |
| Below 30% | Request pump ON |
| Above 80% | Request pump OFF |
| 30% to 80% | No action |

The program uses the host-supplied variable `LEVEL`.

When the tank level is below 30%, BASIC-58 sends:

```basic
@HOST STATE "PUMP" 1
```

When the tank level is above 80%, BASIC-58 sends:

```basic
@HOST STATE "PUMP" 0
```

For levels between these limits, no notification is sent.

## 2. Communication flow

The following sequence illustrates the interaction between the host and the interpreter:

```text
        B4J HOST APPLICATION
                 |
                 |  1. SetVariable("LEVEL", 20)
                 |
                 v
          BASIC-58 INTERPRETER
                 |
                 |  2. RUN
                 |
                 v
          BASIC-58 PROGRAM
                 |
                 |  3. Evaluate LEVEL
                 |     LEVEL < 30 ?
                 |
                 v
          @HOST STATE "PUMP" 1
                 |
                 |  4. HostStateChanged
                 |
                 v
        B4J HOST APPLICATION
                 |
                 |  5. Handle pump request
                 |
                 v
          EXTERNAL SYSTEM
          (OPC UA / MQTT /
           Arduino / Hardware)
```

The host can also independently retrieve interpreter variables using `GetVariable`.

### Step 1 – Host supplies the tank level

The B4J application supplies the current measurement:

```vb
Interpreter.SetVariable("LEVEL", 20)
```

The value is stored for the next interpreter execution.

### Step 2 – Host loads and executes the program

```vb
Interpreter.LoadProgram(Source)
Interpreter.ExecuteCommand("RUN")
```

When `RUN` starts, the host-supplied variables are copied into the normal BASIC-58 variable map.

### Step 3 – BASIC-58 processes the measurement

For a supplied level of 20:

```basic
30 IF LEVEL < 30 THEN 100
```

The condition is true, so execution continues at line 100.

### Step 4 – BASIC-58 notifies the host

BASIC-58 executes:

```basic
110 @HOST STATE "PUMP" 1
```

The interpreter raises the `HostStateChanged` event.

The B4J application receives:

```text
Name  = "PUMP"
Value = 1
```

The host can now handle the pump ON request.

### Step 5 – Host reads a BASIC-58 variable

The host can retrieve the current value of `LEVEL`:

```vb
Log(Interpreter.GetVariable("LEVEL"))
```

This is an independent read operation. It does not require an `@HOST STATE` notification.

## 3. B4J host application

The following example demonstrates the interaction.

### TestHost

```vb
Private Sub TestHost    'ignore
    Log("[TestHost] Start")

    ' =================================================
    ' STEP 1: HOST -> BASIC-58
    ' The host application supplies the tank level.
    '
    ' In a real application, this value could come from
    ' a sensor, OPC UA, MQTT, or another data source.
    ' =================================================
    Interpreter.SetVariable("LEVEL", 20)

    ' =================================================
    ' STEP 2: DEFINE THE BASIC-58 CONTROL PROGRAM
    ' =================================================
    Dim Source As String = $"
10 PRINT "TANK LEVEL CONTROL"
20 PRINT "LEVEL: "; LEVEL; " %"
30 IF LEVEL < 30 THEN 100
40 IF LEVEL > 80 THEN 200
50 END
100 PRINT "LOW LEVEL - START PUMP"
110 @HOST STATE "PUMP" 1
120 END
200 PRINT "HIGH LEVEL - STOP PUMP"
210 @HOST STATE "PUMP" 0
220 END
"$

    ' =================================================
    ' STEP 3: HOST -> INTERPRETER
    ' Load the BASIC-58 program and execute it.
    ' =================================================
    Interpreter.LoadProgram(Source)
    Interpreter.ExecuteCommand("RUN")

    ' The host can read the variable after execution.
    Log($"[TestHost] Host reads LEVEL: ${Interpreter.GetVariable("LEVEL")}"$)

    Stop
End Sub
```

### HostStateChanged event

The B4J application implements the callback that receives notifications from BASIC-58.

```vb
' =====================================================
' STEP 4: BASIC-58 -> HOST
'
' BASIC-58 raises this event when it executes
' an @HOST STATE command.
'
' Name  : State name, for example "PUMP"
' Value : Requested state, for example 1 = ON, 0 = OFF
'
' The host application decides what to do with the event.
' =====================================================
Private Sub Interpreter_HostStateChanged(Name As String, Value As Double)
    Log($"[HostStateChanged] ${Name} = ${Value}"$)

    If Name = "PUMP" Then
        If Value = 1 Then
            Log("[HOST] Pump ON requested")
        Else
            Log("[HOST] Pump OFF requested")
        End If
    End If
End Sub
```

## 4. Test results

The tank-level example was tested with three different input values.

### Test 1 – Low tank level

Host input:

```vb
Interpreter.SetVariable("LEVEL", 20)
```

Expected behaviour: Request pump ON.

Result:

```text
[TestHost] Start
[TestHost] Host reads LEVEL: 20.0
[Interpreter_Output] RUNNING...
[Interpreter_Output] TANK LEVEL CONTROL
[Interpreter_Output] LEVEL: 20 %
[Interpreter_Output] LOW LEVEL - START PUMP
[HostStateChanged] PUMP = 1.0
[HOST] Pump ON requested
[Interpreter_Output] READY.
[Interpreter_Ready] READY
```

**Passed.**

### Test 2 – High tank level

Host input:

```vb
Interpreter.SetVariable("LEVEL", 90)
```

Expected behaviour: Request pump OFF.

Result:

```text
[TestHost] Start
[TestHost] Host reads LEVEL: 90.0
[Interpreter_Output] RUNNING...
[Interpreter_Output] TANK LEVEL CONTROL
[Interpreter_Output] LEVEL: 90 %
[Interpreter_Output] HIGH LEVEL - STOP PUMP
[HostStateChanged] PUMP = 0.0
[HOST] Pump OFF requested
[Interpreter_Output] READY.
[Interpreter_Ready] READY
```

**Passed.**

### Test 3 – Normal tank level

Host input:

```vb
Interpreter.SetVariable("LEVEL", 50)
```

Expected behaviour: No pump command.

Result:

```text
[TestHost] Start
[TestHost] Host reads LEVEL: 50.0
[Interpreter_Output] RUNNING...
[Interpreter_Output] TANK LEVEL CONTROL
[Interpreter_Output] LEVEL: 50 %
[Interpreter_Output] READY.
[Interpreter_Ready] READY
```

**Passed.**

All three scenarios passed.

# Example: Serial Temperature Monitor

This example demonstrates how the host bridge can be combined with the BASIC-58 serial interface.

An Arduino acts as a simple process simulator and sends a temperature value to the B4J application over a serial connection. The host forwards the received frame to BASIC-58. The BASIC-58 `ASSIGN` statement stores the received value in a BASIC variable. After the program finishes, the host retrieves the temperature using `GetVariable`.

This example is important because it demonstrates a complete data path from an external device, through BASIC-58, and back to the host application.

## 1. BASIC-58 program

```basic
5 PRINT "START"
10 @SER CONNECT COM3
20 PRINT "WAITING FOR TEMPERATURE..."
30 ASSIGN TEMP
40 PRINT "TEMPERATURE: "; TEMP
50 @SER DISCONNECT
55 PRINT "STOP"
60 END
```

The serial port name is an example. Use the COM port assigned to the connected device on the host computer.

Program sequence:

1. `@SER CONNECT COM3` asks the host application to open the serial connection.
2. BASIC-58 prints a waiting message.
3. `ASSIGN TEMP` waits for external numeric data to be submitted by the host.
4. The received value is assigned to the BASIC-58 variable `TEMP`.
5. BASIC-58 prints the temperature.
6. `@SER DISCONNECT` asks the host to close the serial connection.
7. The program finishes.

## 2. Serial data frame

The example uses the BASIC-58 serial frame:

```text
[ HEADER | ADR | CMD | VAL | FOOTER ]
```

For example, a temperature value of 29 can be sent in this frame:

```text
19 20 01 1D 58
```

| Byte | Value | Meaning |
| --- | --- | --- |
| HEADER | `0x19` | Frame header |
| ADR | `0x20` | Address 32 |
| CMD | `0x01` | Command 1 |
| VAL | `0x1D` | Decimal value 29 |
| FOOTER | `0x58` | Frame footer |

The serial layer receives and validates the frame. It then forwards the address, command and value to the interpreter.

The interpreter does not need to know about the physical serial port or the serial frame format. Its `SubmitExternalData` method receives the decoded values.

## 3. B4J host application

The host application initializes the interpreter and serial interface.

### Initialization

For the console application, the message loop must be started before the test is executed. `CallSubDelayed` schedules the test so that it starts after the message loop is running.

```vb
Sub AppStart (Args() As String)
    Interpreter.Initialize(Me, "Interpreter")
    Serial.Initialize(Me, "Serial")
    System.Initialize(Me, "System")

    CallSubDelayed(Me, "TestHostSerial")

    StartMessageLoop
End Sub
```

The UI application uses the same interpreter and serial interfaces, but it must not call `StartMessageLoop`; JavaFX already has its own event loop.

### TestHostSerial

```vb
Private Sub TestSerial    'ignore
    Log("[TestSerial] Start")

    Dim Source As String = $"
5 PRINT "START"
10 @SER CONNECT COM3
20 PRINT "WAITING FOR TEMPERATURE..."
30 ASSIGN TEMP
40 PRINT "TEMPERATURE: "; TEMP
50 @SER DISCONNECT
55 PRINT "STOP"
60 END
"$

    ' Load the program.
    Interpreter.LoadProgram(Source)

    ' Start execution.
    Interpreter.ExecuteCommand("RUN")
End Sub
```

The interpreter will pause at asynchronous hardware commands while the host performs the requested operation. The host must resume the interpreter when the operation has completed.

### Serial connection callbacks

```vb
Private Sub Serial_Connected
    Log("[Serial_Connected]")

    ' The asynchronous CONNECT operation has completed.
    Interpreter.ResumeHardwareCommand
End Sub

Private Sub Serial_Disconnected
    Log("[Serial_Disconnected]")

    ' The asynchronous DISCONNECT operation has completed.
    Interpreter.ResumeHardwareCommand
End Sub
```

**Important:** Calling `ResumeHardwareCommand` in these completion callbacks is essential. The interpreter deliberately waits after raising an asynchronous hardware command. If the host does not resume it after the serial connection operation completes, BASIC-58 will remain paused and the statements following the command will not execute.

### Serial data callback

```vb
Private Sub Serial_DataReceived(Buffer() As Byte)
    Log($"[Serial_DataReceived] ${bc.HexFromBytes(Buffer)}"$)

    ' Forward the decoded frame fields to BASIC-58.
    Interpreter.SubmitExternalData(Buffer(1), Buffer(2), Buffer(3))
End Sub
```

The serial layer forwards the three data fields to the interpreter:

- `Buffer(1)` – address
- `Buffer(2)` – command
- `Buffer(3)` – value

For the example frame `19 20 01 1D 58`, the interpreter receives address 32, command 1 and value 29.

The `ASSIGN TEMP` statement can then assign the received value to the BASIC-58 variable `TEMP`.

The host should not call `ResumeHardwareCommand` from `Serial_DataReceived` for this `ASSIGN` operation. The serial data submission satisfies the pending external-data assignment; the separate hardware-command resume is used for completion of `@SER CONNECT` and `@SER DISCONNECT`.

## 4. Retrieving TEMP in the host application

This is the key host-bridge step.

Receiving a value with `ASSIGN TEMP` updates the BASIC-58 variable. It does not automatically raise `HostStateChanged`.

The host retrieves the value using:

```vb
Interpreter.GetVariable("TEMP")
```

Because the serial operation and `ASSIGN` are asynchronous, the host must wait until BASIC-58 has completed the program before reading the variable.

The interpreter raises its `Ready` callback when execution has finished. The host can retrieve `TEMP` there:

```vb
Private Sub Interpreter_Ready
    Dim Temperature As Double = Interpreter.GetVariable("TEMP")

    Log($"[HOST] Temperature received: ${Temperature}"$)
End Sub
```

This gives the complete sequence:

1. Arduino sends the temperature over serial.
2. The B4J serial layer receives the frame.
3. `Serial_DataReceived` forwards the address, command and value to BASIC-58 using `SubmitExternalData`.
4. `ASSIGN TEMP` stores the received value in the BASIC-58 variable `TEMP`.
5. BASIC-58 continues, prints the temperature and disconnects the serial port.
6. The interpreter finishes and raises `Interpreter_Ready`.
7. The host calls `GetVariable("TEMP")` and retrieves the temperature.

**Do not read `TEMP` immediately after `ExecuteCommand("RUN")` in this example.** At that point the interpreter may still be waiting for the serial device and the `ASSIGN` operation. Read it in `Interpreter_Ready`, after the program has completed.

## 5. Example test output

The serial temperature example was tested with an Arduino sending a value of 29.

The received frame was:

```text
19 20 01 1D 58
```

The successful console log included:

```text
[TestSerial] Start
[Main.Interpreter_Output]
[Main.Interpreter_Output] RUNNING...
[Main.Interpreter_Output]
[Main.Interpreter_Output] START
[Main.Interpreter_HardwareCommand] @SER CONNECT COM3
[Main.Serial_Connected]
[Main.Interpreter_Output] WAITING FOR TEMPERATURE...
[Main.Serial_DataReceived] 1920011D58
[Main.Interpreter_Output] TEMPERATURE: 29
[Main.Interpreter_HardwareCommand] @SER DISCONNECT
[Main.Serial_Disconnected]
[Main.Interpreter_Output] STOP
[Main.Interpreter_Output] READY.
[Main.Interpreter_Ready] READY
[HOST] Temperature received: 29
```

**Passed.** The host successfully retrieved the temperature value received by BASIC-58 through `ASSIGN TEMP`.

## 6. The two ways to get data back to the host

The tank-level and serial-temperature examples demonstrate two different ways for the host to obtain information.

### Retrieve a variable with GetVariable

Use this when the host needs to read a BASIC-58 variable:

```vb
Dim Temperature As Double = Interpreter.GetVariable("TEMP")
```

For asynchronous programs, retrieve the value in `Interpreter_Ready`.

### Receive an explicit notification with @HOST STATE

Use this when BASIC-58 needs to notify the host that an event or requested state has occurred:

```basic
@HOST STATE "PUMP" 1
```

The host receives the `Interpreter_HostStateChanged` callback.

These mechanisms are complementary. `GetVariable` retrieves a value; `@HOST STATE` raises an explicit notification. One does not replace the other.

# Current implementation and limitations

The initial host bridge is intentionally limited to numeric variables and state notifications.

| Feature | Status |
| --- | --- |
| Host supplies numeric variables | Implemented |
| BASIC-58 reads host-supplied variables | Implemented |
| BASIC-58 modifies variables normally | Implemented |
| Host retrieves numeric variables | Implemented |
| Missing variables return zero | Implemented |
| Host values restored at `RUN` | Implemented |
| BASIC-58 sends host state notifications | Implemented |
| Host receives `HostStateChanged` callback | Implemented |
| Serial data can be assigned to BASIC variables using `ASSIGN` | Implemented |
| Host can retrieve serial-received variables using `GetVariable` | Implemented |
| Asynchronous serial connect/disconnect can resume BASIC execution | Implemented |
| String variables through the host bridge | Not implemented |
| Live host-variable updates during execution | Not implemented |
| Host-to-interpreter event notifications | Not implemented |

## Important behaviour

### Host variable lifetime

Host-supplied values are maintained separately from the normal interpreter variables.

At the beginning of `RUN`, the normal variable map is cleared as usual. The host-supplied values are then copied into it.

This means that host-supplied values are available again on subsequent runs, even though the normal variable map is cleared.

### BASIC assignments

Once the values have been copied into the normal variable map, BASIC-58 treats them like ordinary numeric variables.

For example:

```basic
10 LET LEVEL = LEVEL + 5
```

The host can retrieve the modified value using `GetVariable`.

### Serial-received values

A value received through the serial interface and assigned with `ASSIGN` becomes a normal BASIC-58 numeric variable.

The host can retrieve it using `GetVariable`. If the program is waiting for serial data, the host should wait for `Interpreter_Ready` before retrieving the final value.

### State notifications

An `@HOST STATE` command sends a notification to the host application. It does not directly operate hardware or modify an external system.

The host application is responsible for interpreting and handling the notification.

Changing a BASIC-58 variable does not automatically generate a state notification.

### Synchronous callback

The host callback is raised while BASIC-58 executes the `@HOST STATE` command. The host receives the notification immediately through the configured callback mechanism.

### Asynchronous hardware commands

Commands such as `@SER CONNECT` and `@SER DISCONNECT` require the host application to perform an asynchronous operation.

The interpreter pauses while the host performs the operation. When the operation has completed, the host calls `ResumeHardwareCommand` from the corresponding completion callback.

This allows BASIC-58 to continue with the next statement only after the requested hardware operation has completed.

# Possible applications

The bridge is not limited to tank-level control or serial temperature monitoring.

It can be used wherever an application needs a small, configurable scripting engine.

| Application | Host supplies or receives | BASIC-58 sends or calculates |
| --- | --- | --- |
| Tank monitoring | Tank level | Pump request |
| Temperature control | Temperature | Heater request |
| Alarm handling | Alarm status | Alarm acknowledgement or action request |
| Energy monitoring | Power and energy values | Load control request |
| Home automation | Sensor values | Device state request |
| Process simulation | Process measurements | Control commands |
| Test systems | Test measurements | Test status or result |
| Serial data acquisition | Data received from a device | Calculated or evaluated values |

The host application remains responsible for communication with the actual devices and external systems.

# Design philosophy

The BASIC-58 Host Bridge is intended to remain a small and straightforward interface.

It does not attempt to turn BASIC-58 into a complete automation framework.

Instead, it provides a simple way to combine:

- The BASIC-58 interpreter and its programming language.
- The host application's data and services.
- External hardware and communication interfaces.

This separation allows BASIC-58 programs to contain the application-specific logic while the host application handles the technical details.

**Small interpreter. Simple interface. Flexible applications.**

*BASIC-58 – An embedded BASIC scripting engine.*
