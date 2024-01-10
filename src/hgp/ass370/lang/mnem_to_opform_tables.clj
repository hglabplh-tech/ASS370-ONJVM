(ns hgp.ass370.lang.mnem_to_opform-tables)

^{:doc "Here the opcodes of ASM370 are defined by Name and 'HEX code"}
(def BALR 0x05)

(def BCTR 0x06)

(def BCR 0x07)

(def SVC 0x0A)

(def BSM 0x0B)

(def BASSM 0x0C)

(def MVCL 0x0E)

(def CLCL 0x0F)

(def LPR 0x10)

(def LNR 0x11)

(def LTR 0x12)

(def LCR 0x13)

(def NR  0x14)

(def CLR 0x15)

(def OR  0x16)

(def XR  0x17)

(def LR  0x18)

(def CR  0x19)

(def AR  0x1A)
;...............

(def A 0x5A)
(def ZAP 0xF8)

(def mnemonic_to_code
  ^{:doc "Here the table mapping of mnemnonics to their op-codes is defined.
  This table is used to translate the cmd's in the source to the op-codes
  of the binary format"}
  {"BALR"  BALR
   "BCTR"  BCTR
   "BCR"   BCR
   "SVC"   SVC
   "BSM"   BSM
   "BASSM" BASSM
   "MVCL"  MVCL
   "CLCL"  CLCL
   "LPR"   LPR
   "LNR"   LNR
   "LTR"   LTR
   "LCR"   LCR
   "NR"    NR
   "CLR"   CLR
   "OR"    OR
   "XR"    XR
   "LR"    LR
   "CR"    CR
   "AR"    AR
   "A"     A
   "ZAP"   ZAP})


^{:doc "Here the base registers  of ASM370 are defined by Name and 'HEX code"}
(def R0 0x00)
(def R1 0x01)
(def R2 0x02)
(def R3 0x03)
(def R4 0x04)
(def R5 0x05)
(def R6 0x06)
(def R7 0x07)
(def R8 0x08)
(def R9 0x09)
(def R10 0x0A)
(def R11 0x0B)
(def R12 0x0C)
(def R13 0x0D)
(def R14 0x0E)
(def R15 0x0F)

(def regs_to_hex
  ^{:doc "Here the table mapping of reg-names to their reg-codes is defined.
  This table is used to translate the reg-namees in the source to the reg-codes
  of the binary format"}
  {"R0"  R0
   "R1"  R1
   "R2"  R2
   "R3"  R3
   "R4"  R4
   "R5"  R5
   "R6"  R6
   "R7"  R7
   "R8"  R8
   "R9"  R9
   "R10" R10
   "R11" R11
   "R12" R12
   "R13" R13
   "R14" R14
   "R15" R15})


(println (get mnemonic_to_code "A"))
(println (get mnemonic_to_code "ZAP"))