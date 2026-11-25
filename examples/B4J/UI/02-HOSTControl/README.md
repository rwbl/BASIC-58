# HOSTControl – BASIC-58 Host Integration Tests

## Overview

HOSTControl is a B4J example application demonstrating bidirectional communication between a host application and the BASIC-58 interpreter.

The tests demonstrate:

1. Passing numeric variables from the host to BASIC-58.
2. Sending state notifications from BASIC-58 to the host.
3. Controlling an Arduino through the BASIC-58 serial interface.

The examples use the BASIC-58 Host Bridge API and, for Test 3, the `B58Serial` library.

---

## Test 1 – Host controls BASIC-58

### Purpose

Demonstrate how the host application supplies a numeric variable to BASIC-58 before program execution.

### BASIC program

```vb
Private TestCode As String = $"05 REM HOST CONTROL TEST
10 PRINT "HOST CONTROL TEST"
20 IF STOP = 1 THEN 60
30 PRINT "PROGRAM CONTINUES"
40 GOTO 20
60 PRINT "STOP REQUEST RECEIVED"
70 END
"$
```

### Host code

```vb
Private Sub btnHostControlRun_Click
    taHostOutput.Text = ""

    Interpreter.SetVariable("STOP", 1)
    Interpreter.LoadProgram(TestCode)
    Interpreter.RunProgram
End Sub
```

### Expected result

BASIC-58 receives `STOP = 1` from the host and branches to line 60.

`SetVariable` stores the supplied value for the next program run. It does not change a variable in a program that is already running.

---

## Test 2 – BASIC-58 notifies the host

### Purpose

Demonstrate how a BASIC-58 program sends state changes to the host application using `@HOST STATE`.

### BASIC program

```vb
Private TestCode As String = $"05 REM HOST NOTIFICATION TEST
10 PRINT "HOST NOTIFICATION TEST"
20 @HOST STATE "PUMP" 1
30 @HOST STATE "PUMP" 0
40 END
"$
```

### Host callback

```vb
Private Sub Interpreter_HostStateChanged(Name As String, Value As Double)
    PrintText(taHostOutput, Name & " = " & Value)
End Sub
```

### Host code

```vb
Private Sub btnHostControlRun_Click
    taHostOutput.Text = ""

    Interpreter.LoadProgram(TestCode)
    Interpreter.RunProgram
End Sub
```

### Expected result

The host receives and displays the two notifications:

```text
PUMP = 1
PUMP = 0
```

The host decides what action to perform when it receives a notification. In this test, it simply displays the name and value.

---

## Test 3 – BASIC-58 controls an Arduino

### Purpose

Demonstrate serial communication between BASIC-58, the host application and an Arduino UNO.

The BASIC-58 program sends commands to the Arduino, waits for acknowledgements, pauses for one second, and then sends the next command.

### BASIC program

```vb
Private TestCode As String = $"05 REM ARDUINO LED TEST
10 @SER CONNECT COM10
20 LET LED = 18
30 PRINT "SWITCH LED ON"
40 @SER LED 4 1
50 @DELAY 1000
60 PRINT "SWITCH LED OFF"
70 @SER LED 4 0
80 @SER DISCONNECT
90 PRINT "DONE"
100 END
"$
```

### Host initialization and command forwarding

Initialize the serial component once:

```vb
Private Serial As B58Serial

Serial.Initialize(Me, "Serial")
```

Forward hardware commands from the interpreter to `B58Serial`:

```vb
Private Sub Interpreter_HardwareCommand(Command As String)
    Serial.ExecuteCommand(Command)
End Sub
```

### Host serial callbacks

The host must resume interpreter execution when a pending serial operation completes or fails.

```vb
Private Sub Serial_Connected
    PrintText(taHostOutput, "[BASIC-58] Controller connected.")
    Sleep(2000) ' Allow Arduino UNO reset
    Interpreter.ResumeHardwareCommand
End Sub

Private Sub Serial_CommandCompleted(Frame() As Byte)
    PrintText(taHostOutput, "[BASIC-58] ACK received.")
    Interpreter.ResumeHardwareCommand
End Sub

Private Sub Serial_CommandError(Message As String)
    PrintText(taHostOutput, "[BASIC-58][E] " & Message)
    Interpreter.ResumeHardwareCommand
End Sub

Private Sub Serial_Disconnected
    PrintText(taHostOutput, "[BASIC-58] Controller disconnected.")
    Interpreter.ResumeHardwareCommand
    Interpreter.ExternalDataDisconnected
End Sub

Private Sub Serial_Error(Message As String)
    PrintText(taHostOutput, "[BASIC-58][E] " & Message)
End Sub
```

### Host run code

```vb
Private Sub btnHostControlRun_Click
    taHostOutput.Text = ""

    Interpreter.LoadProgram(TestCode)
    Interpreter.RunProgram
End Sub
```

### Expected result

1. BASIC-58 connects to the Arduino on `COM10`.
2. The Arduino LED switches ON.
3. BASIC-58 waits for one second.
4. The Arduino LED switches OFF.
5. BASIC-58 disconnects the serial connection and prints `DONE`.

The serial command/acknowledgement sequence allows the interpreter to continue only after the host reports completion of the pending hardware operation.

---

## Summary

| Test | Communication direction | Demonstrated feature |
|---|---|---|
| 1 | Host → BASIC-58 | `SetVariable()` |
| 2 | BASIC-58 → Host | `@HOST STATE` and `Interpreter_HostStateChanged` |
| 3 | BASIC-58 → Host → Arduino | `@SER`, `B58Serial` and hardware-command resumption |

These examples show how BASIC-58 can act as an embedded scripting engine: the host application supplies data and hardware access, while the BASIC-58 program contains the control logic.
