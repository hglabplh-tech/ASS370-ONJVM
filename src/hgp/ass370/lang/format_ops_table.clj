(ns hgp.ass370.lang.format-ops-table)

(def op-form-RR (gensym "RR"))
(def op-form-RX-a (gensym "RX-a"))
(def op-form-RX-b (gensym "RX-b"))
(def op-form-RI (gensym "RI"))

(def op-form-I (gensym "I"))

(def op-form-RS (gensym "RS"))

(def op-form-SS (gensym "SS"))
(def op-form-SS-a (gensym "SS-a"))

(def op-form-SS-b (gensym "SS-b"))

(def op-form-SS-c (gensym "SS-c"))

(def op-form-SI (gensym "SI"))
(def op-name-format
  {"BALR"  op-form-RR
   "BCTR"  op-form-RR
   "BCR"   op-form-RR
   "SVC"   op-form-I
   "BSM"   op-form-RR
   "BASSM" op-form-RR
   "MVCL"  op-form-RR
   "CLCL"  op-form-RR
   "LPR"   op-form-RR
   "LNR"   op-form-RR
   "LTR"   op-form-RR
   "LCR"   op-form-RR
   "NR"    op-form-RR
   "CLR"   op-form-RR
   "OR"    op-form-RR
   "XR"    op-form-RR
   "LR"    op-form-RR
   "CR"    op-form-RR
   "AR"    op-form-RR
   "SR"    op-form-RR
   "MR"    op-form-RR
   "DR"    op-form-RR
   "ALR"   op-form-RR
   "SLR"   op-form-RR
   "STH"   op-form-RX-a
   "LA"    op-form-RX-a
   "STC"   op-form-RX-a
   "IC"    op-form-RX-a
   "EX"    op-form-RX-a
   "BAL"   op-form-RX-a
   "BCT"   op-form-RX-a
   "BC"    op-form-RX-a
   "LH"    op-form-RX-a
   "CH"    op-form-RX-a
   "AH"    op-form-RX-a
   "SH"    op-form-RX-a
   "MH"    op-form-RX-a
   "BAS"   op-form-RX-a
   "CVD"   op-form-RX-a
   "CVB"   op-form-RX-a
   "ST"    op-form-RX-a
   "N"     op-form-RX-a
   "CL"    op-form-RX-a
   "O"     op-form-RX-a
   "X"     op-form-RX-a
   "L"     op-form-RX-a
   "C"     op-form-RX-a
   "A"     op-form-RX-a
   "S"     op-form-RX-a
   "M"     op-form-RX-a
   "D"     op-form-RX-a
   "AL"    op-form-RX-a
   "SL"    op-form-RX-a
   "BXH"   op-form-RS
   "BXLE"  op-form-RS
   "SRL"   op-form-RS
   "SLL"   op-form-RS
   "SRA"   op-form-RS
   "SLA"   op-form-RS
   "SRLD"  op-form-RS
   "SLDL"  op-form-RS
   "SRDA"  op-form-RS
   "SLDA"  op-form-RS
   "STM"   op-form-RS
   "TM"    op-form-SI
   "MVI"   op-form-SI
   "NI"    op-form-SI
   "CLI"   op-form-SI
   "OI"    op-form-SI
   "XI"    op-form-SI
   "LM"    op-form-RS
   "CS"    op-form-RS
   "CDS"   op-form-RS
   "CLM"   op-form-RS
   "STCM"  op-form-RS
   "ICM"   op-form-RS
   "MVN"   op-form-SS-a
   "MVC"   op-form-SS-a
   "MVZ"   op-form-SS-a
   "NC"    op-form-SS-a
   "CLC"   op-form-SS-a
   "OC"    op-form-SS-a
   "XC"    op-form-SS-a
   "TR"    op-form-SS-a
   "TRT"   op-form-SS-a
   "ED"    op-form-SS-a
   "EDMK"  op-form-SS-a
   "MVCIN" op-form-SS
   "SRP"   op-form-SS-c
   "MVO"   op-form-SS-b
   "PACK"  op-form-SS-b
   "UNPK"  op-form-SS-b
   "ZAP"   op-form-SS-b
   "CP"    op-form-SS-b
   "AP"    op-form-SS-b
   "SP"    op-form-SS-b
   "MP"    op-form-SS-b
   "DP"    op-form-SS-b})
