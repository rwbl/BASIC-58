B4R=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=4.2
@EndOfDesignText@
' ================================================================
' Code Module: EnvironmentProtocol
' Project:     EnvironmentMonitor
' Brief:       Shared five-byte serial protocol definitions.
' Author:      Robert W.B. Linn (c) 2026 MIT
' ================================================================

Sub Process_Globals
	' Frame
	Public Const FRAME_SIZE As Byte = 5
	Public Const FRAME_HEADER As Byte = 0x19
	Public Const FRAME_FOOTER As Byte = 0x58

	' Temperature sensor
	Public Const TEMP_ADR As Byte = 1
	Public Const TEMP_CMD As Byte = 1

	' Humidity sensor
	Public Const HUM_ADR As Byte = 2
	Public Const HUM_CMD As Byte = 1
	Public Const HUM_REQUEST As Byte = 0

	' LED
	Public Const LED_ADR As Byte = 18
	Public Const LED_CMD As Byte = 4
	Public Const STATE_OFF As Byte = 0
	Public Const STATE_ON As Byte = 1

	' Humidity request
	Public Const HUM_REQUEST_CMD As Byte = 0
	
	' States
	Public const STATE_ERR As Byte = 255
End Sub

' CreateFrame
' Create a five-byte protocol frame.
Public Sub CreateFrame(adr As Byte, cmd As Byte, val As Byte) As Byte()
	Dim frame(FRAME_SIZE) As Byte

	frame(0) = FRAME_HEADER
	frame(1) = adr
	frame(2) = cmd
	frame(3) = val
	frame(4) = FRAME_FOOTER

	Return frame
End Sub

' CheckFrame
' Check frame length, header and footer.
Public Sub CheckFrame(frame() As Byte) As Boolean
	If frame.Length <> FRAME_SIZE Then Return False
	If frame(0) <> FRAME_HEADER Then Return False
	If frame(4) <> FRAME_FOOTER Then Return False

	Return True
End Sub

' GetAdr
Public Sub GetAdr(frame() As Byte) As Byte
	Return frame(1)
End Sub

' GetCmd
Public Sub GetCmd(frame() As Byte) As Byte
	Return frame(2)
End Sub

' GetVal
Public Sub GetVal(frame() As Byte) As Byte
	Return frame(3)
End Sub

