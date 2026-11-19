B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=10.7
@EndOfDesignText@
' ================================================================
' Class Module:	B58Protocol
' Project:		BASIC-58
' Brief:		Shared definitions for the BASIC-58 serial protocol.
' Description:	Communication using 5-Byte-Frame
'				Byte 0: HDR  0x19  Frame header
'				Byte 1: ADR  0x12  Address - LED device
'				Byte 2: CMD  0x04  Command - Set LED state
'				Byte 3: VAL  0x01  State - 0=OFF, 1=ON
'				Byte 4: FTR  0x58  Frame footer
' ================================================================

Private Sub Process_Globals

	Public FRAME_SIZE 			As Byte = 5			
	Public FRAME_HEADER 		As Byte = 0x19		' Fix
	Public FRAME_ADR_POS		As Byte = 1
	Public FRAME_CMD_POS		As Byte = 2
	Public FRAME_VAL_POS		As Byte = 3
	Public FRAME_FOOTER 		As Byte = 0x58		' Fix

	' Devices
	Public LEDD4_PINNR			As Byte = 4
	Public LEDD4_ADR			As Byte = 0x12		' HEX value 0x12 > DEC 18 (HEX 0x12 = from right to left > 1x16 pwr1 (16) + 2x16 pwr0 (1) = 16 + 2 = DEC 18)

	' Commands
	Public CMD_LED_SET_STATE	As Byte = 0x04

	' States
	Public STATE_OFF 			As Byte = 0x00
	Public STATE_ON 			As Byte = 0x01
	Public STATE_ERR			As Byte = 0xFF		' Error response. IMPORTANT in B4J range -127 to 128, in B4R 0-255
End Sub

' CreateFrame
' Create the 5-Byte frame
Public Sub CreateFrame(adr As Byte, cmd As Byte, val As Byte) As Byte()
	Return Array As Byte( _
		FRAME_HEADER, _
		adr, _ 
		cmd, _  
		val, _  
		FRAME_FOOTER)
End Sub

Public Sub CheckFrame(frame() As Byte) As Boolean
	If frame.Length <> FRAME_SIZE Then
		Log("[CheckFrame][E] Invalid frame received. Expect 5 bytes")
		Return False
	End If

	If frame(0) <> FRAME_HEADER Or frame(FRAME_SIZE - 1) <> FRAME_FOOTER Then
		Log("[CommUART_OnReceived][E] Invalid frame received.")
		Return False
	End If

	Return True
End Sub

Public Sub GetAdr(frame() As Byte) As Byte
	Return frame(FRAME_ADR_POS)
End Sub

Public Sub GetCmd(frame() As Byte) As Byte
	Return frame(FRAME_CMD_POS)
End Sub

Public Sub GetVal(frame() As Byte) As Byte
	Return frame(FRAME_VAL_POS)
End Sub


' CONVERSIONS

' B4J
' Convert byte -127 - 128 to unsigned int 0-255
Public Sub ToUnsigned(b As Byte) As Int
	Return Bit.And(0xFF, b)
End Sub
