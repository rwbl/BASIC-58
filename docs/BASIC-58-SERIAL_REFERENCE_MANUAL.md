# BASIC-58

## B58Serial --- Serial Interface Reference

**Version:** 1.0.0\
**Document:** B58Serial Reference\
**Status:** Release documentation\
**Protocol:** B58Protocol, five-byte binary frame

------------------------------------------------------------------------

> **BASIC-58**
>
> A small BASIC interpreter with a serial connection to the outside
> world.
>
> *So BASIC is being used to bring BASIC back.*

------------------------------------------------------------------------

## 1. Introduction

BASIC-58 provides a simple serial interface for communication between a
BASIC-58 application running on a computer and an external
microcontroller.

The serial interface is implemented by the B4J class **B58Serial**.
Communication uses the compact binary protocol defined in
**B58Protocol**. A controller-side implementation is provided as the B4R
example **B58Controller**.

The interface is deliberately small. It provides connection management,
command transmission, frame validation, acknowledgement handling, and
asynchronous coordination with BASIC program execution.

The serial interface is optional. BASIC-58 can be used as a BASIC
interpreter without a connected controller.

## 2. System Overview

The serial system consists of three principal parts:

  -----------------------------------------------------------------------
  Component               Environment             Responsibility
  ----------------------- ----------------------- -----------------------
  `B58Serial`             B4J                     Serial port, frame
                                                  transmission and
                                                  reception,
                                                  acknowledgements and
                                                  errors

  `B58Protocol`           B4J / B4R               Shared protocol
                                                  constants and frame
                                                  definitions

  `B58Controller`         B4R                     Example controller
                                                  firmware for an
                                                  Arduino-compatible
                                                  board
  -----------------------------------------------------------------------

The BASIC interpreter and serial transport are kept separate. The
interpreter raises a hardware-command event; the main application
forwards the command to `B58Serial`. When the serial operation completes
or fails, the application resumes the waiting interpreter.

This arrangement allows a BASIC program to issue hardware commands
without blocking the user interface.

### 2.1 Example Hardware

The supplied controller example uses:

-   Arduino UNO
-   115200 baud
-   LED connected to digital pin D4
-   Logical device address `0x12`

The protocol address is a logical device address. It is not the physical
Arduino pin number. The example firmware maps logical address `0x12` to
pin D4.

Other controllers can implement the same protocol and use different
hardware mappings.

## 3. Serial Commands

Serial commands are entered at the BASIC-58 command line. They begin
with the `@` character.

### 3.1 `@CONNECT`

Connect to a serial port.

**Syntax**

``` text
@CONNECT <port>
```

**Example**

``` text
@CONNECT COM10
```

The application opens the selected port and initializes serial
communication. The supplied Arduino UNO example may reset when the
serial port is opened; BASIC-58 allows time for the controller to
restart before continuing.

### 3.2 `@DISCONNECT`

Close the current serial connection.

**Syntax**

``` text
@DISCONNECT
```

**Example**

``` text
@DISCONNECT
```

The connection is closed and the application reports the disconnection.

### 3.3 `@LISTPORTS`

List the serial ports available to the application.

**Syntax**

``` text
@LISTPORTS
```

**Example output**

``` text
AVAILABLE SERIAL PORTS:
COM10
```

If no ports are available:

``` text
NO SERIAL PORTS FOUND.
```

The command can be used whether or not a controller is currently
connected.

### 3.4 `@LED`

Set the state of an LED addressed by its logical device address.

**Syntax**

``` text
@LED <address> ON
@LED <address> OFF
```

**Examples**

``` text
@LED 18 ON
@LED 18 OFF
```

Decimal address `18` is hexadecimal `0x12`, the logical LED address used
by the supplied controller example.

The command is translated into a B58Protocol frame and transmitted to
the controller. BASIC-58 waits for the matching acknowledgement before
continuing the program.

## 4. BASIC Program Timing

### 4.1 `@DELAY`

`@DELAY` is an interpreter command, not a serial-port command. It is
documented here because it is useful when writing programs that control
external hardware.

**Syntax**

``` text
@DELAY <milliseconds>
```

**Example**

``` basic
10 @LED 18 ON
20 @DELAY 500
30 @LED 18 OFF
40 @DELAY 500
```

The delay is asynchronous. It does not block the application interface.
The BASIC program resumes when the delay has elapsed.

Hardware commands also suspend program execution until the serial
operation completes or reports an error. This makes command sequences
predictable without introducing blocking waits into the user interface.

## 5. B58Protocol

B58Serial and B58Controller communicate using the shared B58Protocol
definition.

Each protocol frame contains exactly five bytes:

``` text
+------+------+------+------+------+
| HDR  | ADR  | CMD  | VAL  | FTR  |
+------+------+------+------+------+
```

  Field   Description
  ------- -------------------------
  `HDR`   Frame header
  `ADR`   Logical device address
  `CMD`   Command code
  `VAL`   Command value or status
  `FTR`   Frame footer

### 5.1 Frame Constants

  Constant         Value Description
  ------------- -------- ----------------------
  Header          `0x19` Start of frame
  Footer          `0x58` End of frame
  LED address     `0x12` Logical LED device
  LED command     `0x04` Set LED state
  OFF             `0x00` LED off
  ON              `0x01` LED on
  Error           `0xFF` Command error status

The protocol uses values from 0 to 127 for ordinary address and command
constants where compatibility with signed B4X `Byte` values is
important. The error status `0xFF` is a defined byte value and must be
interpreted as an unsigned value when displayed or compared across
environments.

### 5.2 LED Frames

LED ON:

``` text
19 12 04 01 58
```

LED OFF:

``` text
19 12 04 00 58
```

Error response:

``` text
19 12 04 FF 58
```

### 5.3 Acknowledgements

For a successful command, the controller echoes the request frame as its
acknowledgement.

B58Serial validates the received frame and matches the acknowledgement
against the outstanding command. A matching successful acknowledgement
completes the command.

If the controller reports an error, the response uses `0xFF` in the
value field. B58Serial reports the error to the application.

Frames with an invalid header, footer, or command match are not accepted
as successful acknowledgements.

## 6. Program Execution and Serial Operations

Serial operations are asynchronous.

When the interpreter encounters a hardware command, it raises its
hardware-command event and suspends program execution. The application
passes the command to B58Serial.

B58Serial transmits the frame and waits for the corresponding response.
On successful completion, or on a communication error, the application
informs the interpreter so that execution can resume.

This mechanism is important for sequences such as LED blinking. The next
BASIC statement is not executed until the preceding hardware command has
completed.

A serial command entered interactively at the command line uses the same
B58Serial command handling, but does not suspend a running BASIC
program.

## 7. Example Programs

The following examples are included with the B58Serial examples.

### 7.1 LED Blink

File: `Examples/LED_Blink/LED_Blink.bas`

``` basic
10 REM BASIC-58 LED BLINK EXAMPLE
20 @CONNECT COM10
30 FOR I = 1 TO 5
40 @LED 18 ON
50 @DELAY 500
60 @LED 18 OFF
70 @DELAY 500
80 NEXT I
90 @DISCONNECT
100 PRINT "BLINK COMPLETE"
110 END
```

The program connects to the controller, blinks the LED five times,
disconnects, and prints a completion message.

### 7.2 SOS

File: `Examples/LED_SOS/LED_SOS.bas`

The SOS example flashes the standard Morse-code sequence:

-   Three short flashes
-   Three long flashes
-   Three short flashes

The example uses `@DELAY 250` for a short interval and `@DELAY 750` for
a long interval. It disconnects after completing the sequence and prints
`SOS COMPLETE`.

## 8. Error Handling

B58Serial reports connection and communication problems to the BASIC-58
application.

Examples include:

``` text
[BASIC-58][E] COM port com99 not found.
[BASIC-58][E] COM port com10 is already in use.
```

A command that does not receive a matching acknowledgement within the
configured timeout is reported as a communication error.

Whether a hardware command succeeds or fails, the interpreter is
released from its waiting state. A failed hardware operation therefore
does not leave a BASIC program permanently suspended.

## 9. Design Notes

The serial implementation follows a few simple rules:

-   `B58Serial` owns serial communication and protocol frame handling.
-   `B58Protocol` contains definitions shared by the computer and
    controller implementations.
-   `B58Controller` is an example controller implementation, not part of
    the interpreter.
-   The serial class does not own BASIC program execution or the
    interpreter's delay handling.
-   The user interface remains responsive while serial commands and
    delays are in progress.
-   Diagnostic text must not be written to the controller's serial port
    while it is being used for binary protocol traffic.

The five-byte protocol is intentionally compact and easy to implement on
small microcontrollers.

## 10. Project Structure

A typical project layout is:

``` text
BASIC-58/
|
+-- B58Interpreter
|
+-- B58Serial/
|   |
|   +-- B58Serial
|   +-- Examples/
|       |
|       +-- LED_Blink/
|       |   +-- LED_Blink.bas
|       |
|       +-- LED_SOS/
|           +-- LED_SOS.bas
|
+-- B58Protocol
|
+-- B58Controller/
    |
    +-- B58Controller
```

The exact repository layout may vary as the project develops.

## 11. Future Development

The current implementation provides a serial transport using the
B58Protocol frame format.

The protocol definition is kept separate from the transport so that
other communication methods may be considered in the future. Possible
examples include Bluetooth Low Energy or Wi-Fi. Such transports are not
part of the current serial implementation.

------------------------------------------------------------------------

## END OF MANUAL

**BASIC-58 --- Version 1.0.0**

*So BASIC is being used to bring BASIC back.*
