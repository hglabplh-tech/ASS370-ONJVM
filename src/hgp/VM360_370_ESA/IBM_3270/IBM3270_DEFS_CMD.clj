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


;;Color definitions
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
(def Gray 0x0E)
(def White_base 0x0F)

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