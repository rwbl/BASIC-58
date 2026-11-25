# CHANGELOG BASIC-58

---

## 1.0.1 (Build 20261125)

- NEW: `B58Interpreter` - Host Bridge `GetVariables()` method to retrieve a snapshot of all current numeric scalar variables.
- NEW: Numeric function `FIX(x)` to truncate a value toward zero.
- NEW: Predefined numeric constants `PI` and `E`.
- NEW: String functions `DATE$(0)` and `TIME$(0)` to retrieve the current system date and time.
- NEW: Examples > B4J > UI > HOSTControl, TankSimulation, EnvironmentMonitor
- UPD: Moved `@DELAY` timing into `B58Interpreter`. Program execution now resumes automatically when the internal delay timer expires.
- DEL: Removed the host-side `_WaitingForDelay` callback. Host applications no longer need to implement delay timing.

## 1.0.0 (Build 20261124)

- NEW: First version.
    - Published [B4J Forum](https://www.b4x.com/android/forum/threads/basic-58.172657/#post-1055450)
	