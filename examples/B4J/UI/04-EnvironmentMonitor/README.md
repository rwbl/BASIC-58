# EnvironmentMonitor

A small B4J/B4R example demonstrating **bidirectional serial communication** between a BASIC-58 host application and an Arduino environment simulator.

The example focuses on two simple operations:

1. **Temperature (T):** The Arduino sends temperature readings automatically. The host receives and logs them.
2. **Humidity (H):** The host requests humidity when needed. The Arduino replies with its current humidity value.

The distinction is intentional: temperature is sent spontaneously, while humidity is sent only in response to a request.

## Project structure

```text
EnvironmentMonitor/
├── B4J/
│   └── EnvironmentMonitor.b4j
├── B4R/
│   └── EnvironmentMonitor.b4r
├── Shared/
│   └── EnvironmentProtocol.bas
└── README.md
```

`EnvironmentProtocol.bas` is shared by the B4J and B4R projects. It contains the common frame definitions and helper methods.

## Serial protocol

Each message is a five-byte frame:

```text
[ HEADER | ADR | CMD | VAL | FOOTER ]
```

| Field | Value |
|---|---:|
| HEADER | `0x19` |
| ADR | Device address |
| CMD | Command |
| VAL | Data value |
| FOOTER | `0x58` |

All values are transmitted as single bytes.

### Temperature

The Arduino generates a simulated temperature value and sends it periodically.

| Field | Value |
|---|---:|
| ADR | `1` |
| CMD | `1` |
| VAL | `10`–`20` |

Direction: **Arduino → Host**

### Humidity

The Arduino updates its simulated humidity value internally. It does not transmit humidity periodically.

The host requests the current value using:

| Field | Value |
|---|---:|
| ADR | `2` |
| CMD | `0` |
| VAL | `0` |

Direction: **Host → Arduino**

The Arduino responds with:

| Field | Value |
|---|---:|
| ADR | `2` |
| CMD | `1` |
| VAL | `0`–`100` |

Direction: **Arduino → Host**

In BASIC-58, the request is sent with:

```basic
@SER 2 0 0
```

The serial component reports the command acknowledgement, and the returned humidity frame is delivered to the host.

## How it works

### Arduino simulator (B4R)

- Generates a new simulated temperature periodically.
- Sends each temperature reading to the host using the temperature frame.
- Updates the humidity value internally.
- Sends the humidity value only when it receives a humidity request.
- Validates incoming frames and returns an error value for unsupported commands.

### Host application (B4J)

- Connects to the Arduino through the serial port.
- Receives and logs incoming temperature readings.
- Can request the current humidity value explicitly.
- Receives and logs the humidity response.

The host uses the BASIC-58 serial support and the shared `EnvironmentProtocol` definitions. The BASIC-58 `B58Protocol` library is not modified by this example.

## Example output

Temperature logging:

```text
TEMPERATURE MONITOR
TEMPERATURE: 20 C
TEMPERATURE: 10 C
TEMPERATURE: 18 C
```

Humidity requests and responses:

```text
[Serial Connected] Controller connected.
[Serial CommandCompleted] ACK received: 1902000058
[Serial DataReceived] H=41
[Serial CommandCompleted] ACK received: 1902000058
[Serial DataReceived] H=15
[Serial Disconnected] Controller disconnected.
```

The acknowledgement `1902000058` confirms the humidity request frame:

```text
19 02 00 00 58
```

The humidity values are returned in separate response frames:

```text
19 02 01 29 58   ; H = 41
19 02 01 0F 58   ; H = 15
```

(The humidity values shown are examples from a test run.)

## What this example demonstrates

- Sharing one protocol definition between B4J and B4R.
- Sending unsolicited data from an Arduino to a host.
- Requesting data from the host and returning a response.
- Using BASIC-58 serial commands and external data handling.
- Keeping the protocol simple and easy to extend.

**EnvironmentMonitor** is deliberately a small example: one automatically reported value and one value retrieved on demand.
