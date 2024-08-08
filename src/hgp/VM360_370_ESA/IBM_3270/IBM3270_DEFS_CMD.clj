(ns hgp.VM360-370-ESA.IBM-3270.IBM3270-DEFS-CMD)

;; screen command and attribute definitions

(def NUL 0x00)
(def FF 0x0C)
;;(Form Feed) X'0C'
;;Start a new page (printing only)
(def SO 0x0E)
;;Starts a DBCS sub-field
(def SI 0x0F)
;;Ends a DBCS sub-field
(def NL 0x15)
;;Skips to the beginning of the next line (printing only)
(def EM 0x19)
;;End of print job (printing only)
(def SF 0x1D)
;;Start of a new field (see below)
(def SFE 0x29)
;;Start of a new field (see below)


;;3270 I/O Command

;;CCW op-code (EXCP), EBCDIC (SNA), ASCII (SNA)
(def not-applicapable 0xFF)
;Erase All Unprotected (EAU)

(def all-unprotected [0x0F 0x6F 0x3F] )

;;Erase/Write (EW)

(def erase-write [0x05 0xF5 0x35] )

;;Erase/Write Alternate (EWA)
(def erase-write-alt [0x00 0x7E 0x3D])

;;Read Buffer (RB)

(def read-buffer [0x02 0xF2 0x32])

;;Read Modified (RM)
(def read-modified [0x06 0xF6 0x36])

;;Read Modified All (RMA)

(def read-modified-all [not-applicapable 0x6E 0x3E])

;; Write (W)

(def write [0x01 0xF1 0x31])

;;Write Structured Field (WSF)

(def write-SF [0x11 0xF3 not-applicapable])

;;No Operation (NOP)

(def nop 0x03 not-applicapable not-applicapable)

;;Sense (SNS)

(def sense [0x04 not-applicapable not-applicapable])

;;Sense ID (SNSID)1

(def sense-id [0xE4 not-applicapable not-applicapable])

;;Color definitions// base
(def Neutral-Black_base 0x00)
(def Blue_base 0x01)
(def Red_base 0x02)
(def Pink_base 0x03)
(def Green_base 0x04)
(def Turquoise_base 0x05)
(def Yellow_base 0x06)
(def Neutral-White_base 0x07)
(def Black_base 0x08)
(def Deep-Blue_base 0x09)
(def Orange_base 0x0A)
(def Purple_base 0x0B)
(def Pale-Green_base 0x0C)
(def Pale-Turquoise_base 0x0D)
(def Gray_base 0x0E)
(def White_base 0x0F)

;;Color definitions// color screen
(def Neutral-Black 0xF0)
(def Blue 0xF1)
(def Red 0xF2)
(def Pink 0xF3)
(def Green 0xF4)
(def Turquoise 0xF5)
(def Yellow 0xF6)
(def Neutral-White 0xF7)
(def Black 0xF8)
(def Deep-Blue 0xF9)
(def Orange 0xFA)
(def Purple 0xFB)
(def Pale-Green 0xFC)
(def Pale-Turquoise 0xFD)
(def Gray 0xFE)
(def White 0xFF)

;; underline and friends
;; No highlighting (reset).

(def Default 0x00)
;;Blink highlighting.
(def Blink 0xF1)
;;Reverse video highlighting.
(def Reverse 0xF2)
;;Underscored highlighting.
(def Underscore 0xF4)

;; readonly

;; positioning