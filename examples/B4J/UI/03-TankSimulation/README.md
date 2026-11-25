# HOSTControl – Pump Simulation

## Overview

The Pump Simulation is a B4J example demonstrating how BASIC-58 can act as the control logic for a simulated tank process.

The example uses the BASIC-58 Host Bridge:

1. The host supplies process values to BASIC-58 using `SetVariable()`.
2. BASIC-58 evaluates the tank level and decides whether the pump should start or stop.
3. BASIC-58 notifies the host of a pump state change using `@HOST STATE`.
4. The host updates the simulated pump and tank level.

The process is simulated entirely in the host application. No physical pump or controller is required.

## Process simulation

The host maintains two process values:

- `TankLevel` – the simulated tank level, in percent.
- `PumpRunning` – whether the simulated pump is running.

The simulation starts with a tank level of 20% and the pump OFF.

Every second, the host updates the tank level:

| Pump state | Tank level change |
|---|---:|
| ON | +2 percentage points |
| OFF | -1 percentage point |

The tank level is limited to the range 0% to 100%.

## BASIC-58 control program

The BASIC-58 program uses two thresholds:

- Start the pump when the tank level is below 30%.
- Stop the pump when the tank level is above 80%.
- Between these thresholds, keep the current pump state.

The program also checks the current `PUMP` value before sending a command. This avoids repeatedly notifying the host when the pump is already in the requested state.

```basic
05 REM TANK LEVEL CONTROL
10 PRINT "TANK LEVEL CONTROL"
20 PRINT "LEVEL: "; LEVEL; " %"
30 IF LEVEL < 30 THEN 100
40 IF LEVEL > 80 THEN 200
50 END

100 IF PUMP = 1 THEN 50
110 PRINT "LOW LEVEL - START PUMP"
120 @HOST STATE "PUMP" 1
130 END

200 IF PUMP = 0 THEN 50
210 PRINT "HIGH LEVEL - STOP PUMP"
220 @HOST STATE "PUMP" 0
230 END
```

## Host and interpreter interaction

### Initialisation

The host initializes the interpreter and the simulation timer. The timer is initially disabled.

When the user starts the simulation, the host resets the initial process values, supplies them to BASIC-58, loads the program and runs it:

```vb
Private Sub btnHostControlRun_Click
    taHostOutput.Text = ""
    Interpreter.SetVariable("LEVEL", 20)
    Interpreter.SetVariable("PUMP", 0)
    Interpreter.LoadProgram(taB58SourceEditor.Text)
    Interpreter.RunProgram
End Sub
```

### Receiving pump commands

The host receives state notifications through `Interpreter_HostStateChanged`.

```vb
Private Sub Interpreter_HostStateChanged(Name As String, Value As Double)
    PrintText(taHostOutput, Name & " = " & Value)

    If Name = "PUMP" Then
        PumpRunning = (Value = 1)
        TankTimer.Enabled = True
    End If
End Sub
```

When BASIC-58 requests a pump state change, the host updates `PumpRunning` and enables the simulation timer.

### Updating the simulated process

The timer fires once per second. It updates the tank level, supplies the current process values to BASIC-58, and runs the control program again.

```vb
Private Sub TankTimer_Tick
    If PumpRunning Then
        TankLevel = Min(100, TankLevel + 2)
    Else
        TankLevel = Max(0, TankLevel - 1)
    End If

    Interpreter.SetVariable("LEVEL", TankLevel)
    Interpreter.SetVariable("PUMP", IIf(PumpRunning, 1, 0))
    Interpreter.RunProgram

    PrintText(taHostOutput, "TANK LEVEL = " & TankLevel & " %")
End Sub
```

At the start of each run, BASIC-58 receives the host-supplied values. It then evaluates the control conditions and sends a new pump notification only when a state change is needed.

### Reading variables after execution

The host also uses the `Interpreter_Ready` callback to retrieve the current BASIC-58 variables:

```vb
Private Sub Interpreter_Ready
    Dim Vars As Map = Interpreter.GetVariables
    For Each Name As String In Vars.Keys
        PrintText(taHostOutput, Name & " = " & Vars.Get(Name))
    Next
End Sub
```

`GetVariables()` returns a snapshot of the current numeric scalar variables.

## Test observations

The simulation was tested successfully:

1. Initial level: 20%, pump OFF.
2. BASIC-58 detects that the level is below 30% and requests `PUMP = 1`.
3. The host starts the simulated pump. The level increases by 2 percentage points per second.
4. At 82%, BASIC-58 detects that the level is above 80% and requests `PUMP = 0`.
5. The host stops the pump. The level then decreases by 1 percentage point per second.
6. At 78%, the pump remains OFF. It will only restart when the level falls below 30%.

This demonstrates the intended control band: the pump starts below 30% and stops above 80%, retaining its previous state between the thresholds.

## What the example demonstrates

| Feature | Demonstration |
|---|---|
| Host → BASIC-58 | `SetVariable()` supplies `LEVEL` and `PUMP` |
| BASIC-58 control logic | Evaluates process values and applies the two thresholds |
| BASIC-58 → Host | `@HOST STATE` sends pump state changes |
| Host process simulation | Timer models tank filling and draining |
| Host reads interpreter state | `GetVariables()` retrieves current numeric variables |

The example illustrates a simple but useful architecture: BASIC-58 contains the control decisions, while the host application owns the process simulation and carries out the requested actions.
