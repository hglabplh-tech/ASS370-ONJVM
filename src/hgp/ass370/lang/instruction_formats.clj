(ns hgp.ass370.lang.instruction_formats
  (:require [clojure.string :as str]
            [hgp.general.opcodes-and-regs-hex :as codes]))

(def balr-ex "BALR  R12,R0")


(defn perl-split-on-space [s]
  (str/split (str/triml s) #"\s+"))

;; RR Format (opcode op1/reg , op2/reg)
(defn do-rr [expr]
  (let [temp (str/replace expr #"," " ")
        vector (perl-split-on-space temp)]
    vector
    )
  )

(defn tok-rr [stmt]
  (let [[op-code reg1 reg2] stmt
        m-op (codes/get-code op-code)
        m-r1  (codes/get-base-reg reg1)
        m-r2  (codes/get-base-reg reg2)]
    (byte-array 3 [m-op m-r1 m-r2])
    ))

(defn testit [cmd-arr]
  (println (aget cmd-arr 0))
  (println (aget cmd-arr 1))
  (println (aget cmd-arr 2))
  )
(testit (tok-rr (do-rr balr-ex)) )

