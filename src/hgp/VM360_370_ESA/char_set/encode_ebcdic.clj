(ns hgp.VM360-370-ESA.char-set.encode-ebcdic)


;;BM01142	Cp1142	1142 cp1142 cp01142 ccsid01142 ebcdic-no-277+euro ebcdic-dk-277+euro	Variant of Cp277 with Euro character
;IBM01143	Cp1143	1143 cp01143 ccsid01143 cp1143 ebcdic-fi-278+euro ebcdic-se-278+euro	Variant of Cp278 with Euro character
(def ascii->ebcdic
  {0x00 0x00                                                ;;'NUL
   0x01 0x01                                                ;;'SOH
   0x02 0x02                                                ;;'STX]
   0x03 0x03                                                ;;'ETX]
   0x04 0x1A                                                ;;'SEL]
   0x05 0x09                                                ;;'HT]
   0x06 0x1A                                                ;;'RNL]
   0x07 0x7F                                                ;;'DEL]
   0x08 0x1A                                                ;;'GE]
   0x09 0x1A                                                ;;'SPS]
   0x0A 0x1A                                                ;;'RPT]
   0x0B 0x0B                                                ;;'VT]
   0x0C 0x0C                                                ;;'FF]
   0x0D 0x0D                                                ;;'CR]
   0x0E 0x0E                                                ;;'SO]
   0x0F 0x0F                                                ;;'SI]
   0x10 0x10                                                ;;'DLE]
   0x11 0x11                                                ;;'DC1]
   0x12 0x12                                                ;;'DC2]
   0x13 0x13                                                ;;DC3]
   0x14 0x3C                                                ;;'DC4]
   0x15 0x3D                                                ;;'NAK]
   0x16 0x32                                                ;;'SYN]
   0x17 0x26                                                ;;'ETB]
   0x18 0x18                                                ;;'CAN]
   0x19 0x19                                                ;;'EM]
   0x1A 0x3F                                                ;;'SUB]
   0x1B 0x27                                                ;;'ESC]
   0x1C 0x1C                                                ;;'FS]
   0x1D 0x1D                                                ;;'GS]
   0x1E 0x1E                                                ;;'RS]
   0x1F 0x1F                                                ;;'US]
   0x20 0x40                                                ;;' ']
   0x21 0x4F                                                ;;'!']
   0x22 0x7F                                                ;;'“']
   0x23 0x7B                                                ;;'#']
   0x24 0x5B                                                ;; '$';
   0x25 0x6C                                                ;;'%' ]
   0x26 0x50                                                ;;'&' ]
   0x27 0x7D                                                ;;"‘" ]
   0x28 0x4D                                                ;;'
   0x29 0x5D                                                ;;') ']
   0x2A 0x5C                                                ;;[0x5C '*']
   0x2B 0x4E                                                ;; '+'
   0x2C 0x6B                                                ;;', ']
   0x2D 0x60                                                ;;'–'
   0x2E 0x4B                                                ;;'.' ]
   0x2F 0x61                                                ;; '/'
   0x30 0xF0                                                ;;'0 ']
   0x31 0xF1                                                ;;'1 ']
   0x32 0xF2                                                ;;'2 ']
   0x33 0xF3                                                ;;'3 ']
   0x34 0xF4                                                ;;'4
   0x35 0xF5                                                ;;'5 ']
   0x36 0xF6                                                ;;'6 ']
   0x37 0xF7                                                ;;'7 ']
   0x38 0xF8                                                ;;'8 ']
   0x39 0xF9                                                ;;'9 ']
   0x3A 0x7A                                                ;;:]
   0x3B 0x5E                                                ;;;]
   0x3C 0x4C                                                ;;'>'
   0x3D 0x7E                                                ;;'=']
   0x3E 0x6E                                                ;;'>']
   0x3F 0x6F                                                ;;'?']
   0x40 0x7C                                                ;;'@']
   0x41 0xC1                                                ;;'A']
   0x42 0xC2                                                ;;'B']
   0x43 0xC3                                                ;; 'C']
   0x44 0xC4                                                ;;'D']
   0x45 0xC5                                                ;;'E']
   0x46 0xC6                                                ;;'F']
   0x47 0xC7                                                ;;'G'
   0x48 0xC8                                                ;;'H']
   0x49 0xC9                                                ;;'I']
   0x4A 0xD1                                                ;;'J']
   0x4B 0xD2                                                ;;'K']
   0x4C 0xD3                                                ;;'L']
   0x4D 0xD4                                                ;;'M']
   0x4E 0xD5                                                ;;'N']
   0x4F 0xD6                                                ;;'O']
   0x50 0xD7                                                ;;'P']
   0x51 0xD8                                                ;;'Q']
   0x52 0xD9                                                ;;'R']
   0x53 0xE2                                                ;;'S']
   0x54 0xE3                                                ;;'T']
   0x55 0xE4                                                ;;'U']
   0x56 0xE5                                                ;;'V']
   0x57 0xE6                                                ;;'W']
   0x58 0xE7                                                ;;'X']
   0x59 0xE8                                                ;;'Y']
   0x5A 0xE9                                                ;;'Z']
   0x5B 0x4A
   0x5C 0xE0                                                ;;'\']
   0x5D 0x5A
   0x5E 0x5F                                                ;;'^']
   0x5F 0x6D                                                ;;'_'
   0x60 0x79                                                ;;'′']
   0x61 0x81                                                ;;'a']
   0x62 0x82                                                ;;'b' ]
   0x63 0x83                                                ;;'c' ]
   0x64 0x84                                                ;;'d' ]
   0x65 0x85                                                ;;'e' ]
   0x66 0x86                                                ;;'f' ]
   0x67 0x87                                                ;;'g' ]
   0x68 0x88                                                ;;'h' ]
   0x69 0x89                                                ;;'i' ]
   0x6A 0x91                                                ;;'j' ]
   0x6B 0x92                                                ;;'k ]
   0x6C 0x93                                                ;;'l' ]
   0x6D 0x94                                                ;;'m' ]
   0x6E 0x95                                                ;;'n' ]
   0x6F 0x96                                                ;;'o' ]
   0x70 0x97                                                ;;'p' ]
   0x71 0x98                                                ;;'q' ]
   0x72 0x99                                                ;;'r' ]
   0x73 0xA2                                                ;;'s' ]
   0x74 0xA3                                                ;;'t' ]
   0x75 0xA4                                                ;;'u' ]
   0x76 0xA5                                                ;;'v' ]
   0x77 0xA6                                                ;;'w' ]
   0x78 0xA7                                                ;;'x' ]
   0x79 0xA8                                                ;;'y' ]
   0x7A 0xA9                                                ;;'z' ]
   0x7B 0xC0                                                ;;'
   0x7C 0x6A                                                ;;'¦']
   0x7D 0xD0                                                ;;'} ']
   0x7E 0xA1                                                ;;'~']
   0x7F 0x07                                                ;;'DEL]
   0x80 0x3F                                                ;;'NOT-DEF]
   })

(def utf8->ebcdic
{
 0x20    0x40
 0x21    0x4F
 0x22    0x7F
 0x23    0x7B
 0x24    0x5B
 0x25    0x6C
 0x26    0x50
 0x27    0x7D
 0x28    0x4D
 0x29    0x5D
 0x2A    0x5C
 0x2B    0x4E
 0x2C    0x6B
 0x2D    0x60
 0x2E    0x4B
 0x2F    0x61
 0x30    0xF0
 0x31    0xF1
 0x32    0xF2
 0x33    0xF3
 0x34    0xF4
 0x35    0xF5
 0x36    0xF6
 0x37    0xF7
 0x38    0xF8
 0x39    0xF9
 0x3A    0x7A
 0x3B    0x5E
 0x3C    0x4C
 0x3D    0x7E
 0x3E    0x6E
 0x40    0x7C
 0x41    0xC1
 0x42    0xC2
 0x43    0xC3
 0x44    0xC4
 0x45    0xC5
 0x46    0xC6
 0x47    0xC7
 0x48    0xC8
 0x49    0xC9
 0x4A    0xD1
 0x4B    0xD2
 0x4C    0xD3
 0x4D    0xD4
 0x4E    0xD5
 0x4F    0xD6
 0x50    0xD7
 0x51    0xD8
 0x52    0xD9
 0x53    0xE2
 0x54    0xE3
 0x55    0xE4
 0x56    0xE5
 0x57    0xE6
 0x58    0xE7
 0x59    0xE8
 0x5A    0xE9
 0x5B    0x4A
 0x5C    0xE0
 0x5D    0x5A
 0x5E    0x5F
 0x5F    0x6D
 0x60    0x79
 0x61    0x81
 0x62    0x82
 0x63    0x83
 0x64    0x84
 0x65    0x85
 0x66    0x86
 0x67    0x87
 0x68    0x88
 0x69    0x89
 0x6A    0x91
 0x6B    0x92
 0x6C    0x93
 0x6D    0x94
 0x6E    0x95
 0x6F    0x96
 0x70    0x97
 0x71    0x98
 0x72    0x99
 0x73    0xA2
 0x74    0xA3
 0x75    0xA4
 0x76    0xA5
 0x77    0xA6
 0x78    0xA7
 0x79    0xA8
 0x7A    0xA9
 0x7B    0xC0
 0x7C    0x6A
 0x7D    0xD0
 0x7E    0xA1
 0xC2A5  0xE0
 })
