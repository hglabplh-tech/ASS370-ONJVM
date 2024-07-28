(ns hgp.ass370.compile.370-bin.bit-utils)


(defn calc-half-byte-high [the-byte]
  (bit-and the-byte 0xF0))

(defn calc-half-byte-low [the-byte]
  (bit-and the-byte 0x0F))