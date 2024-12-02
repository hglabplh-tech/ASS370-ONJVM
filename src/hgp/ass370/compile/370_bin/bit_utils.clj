(ns hgp.ass370.compile.370-bin.bit-utils)


(defn calc-half-byte-high [the-byte]
  (:doc "get the high half byte part")
  (bit-and (bit-shift-left the-byte 0x04) 0xF0))

(defn calc-half-byte-low [the-byte]
  (:doc "get the low half byte part")
  (bit-and the-byte 0x0F))

(defn get-regs-byte [lo hi]
  (:doc "merge two bytes low (first reg) high (second reg) in one byte
  as two half bytes")
  (bit-and (bit-or
             (calc-half-byte-low lo)
             (calc-half-byte-high hi))
           0xFF))