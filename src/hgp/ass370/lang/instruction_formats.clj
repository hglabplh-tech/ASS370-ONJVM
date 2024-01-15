(ns hgp.ass370.lang.instruction_formats
  (:require [clojure.string :as str]
            [hgp.general.opcodes-and-regs-hex :as codes]))

(def balr-ex "BALR  R12,R0")

(def two-rand-delimiter "#-#ff")
(defn perl-split-on-space [s]
  ^{:doc "split the string by space characters and trim each word"}
  (str/split (str/triml s) #"\s+"))

(defn get-lead-and-in-between-to-vector [str start-char end-char]
  (let [start-index (str/index-of str start-char)
        end-index  (str/index-of (subs str (+ start-index 1))  end-char)
        between (subs str (+ start-index 1) end-index)
        lead (subs str 0, start-index)]
    [lead between]
    ))

;; RR Format (opcode op1/reg , op2/reg)
(defn do-rr [expr]
  (let [temp (str/replace expr #"," " ")
        vector (perl-split-on-space temp)]
    vector
    )
  )


;; RS Format example (CLM) --> Form 1
;; later we have o define a way of parsing which respects that there may be no '(' or ')'
(defn do-rs-f1 [expr]
  (let [temp (str/replace expr #"," " ")
        vector (perl-split-on-space temp)
        sub-expr (get-lead-and-in-between-to-vector temp "(" ")")
        opcode (get-in [vector] 0  0)
        reg-1 (get-in [vector] 0  1)
        reg-2 (get-in [vector] 0  2)]
    [opcode reg-1 reg-2 sub-expr]
  ))

;; RR Format (opcode op1/reg , op2/reg)
(defn tok-rr [stmt]
  (let [[op-code reg1 reg2] stmt
        m-op (codes/get-code op-code)
        m-r1  (codes/get-base-reg reg1)
        m-r2  (codes/get-base-reg reg2)]
    (byte-array [m-op m-r1 m-r2])
    ))

;; RS Format example (CLM)
(defn tok-rs [stmt]
  (let [[op-code reg1 reg2 sub-expr] stmt
        m-op (codes/get-code op-code)
        m-r1  (codes/get-base-reg reg1)
        m-r2  (codes/get-base-reg reg2)
        [lead between] sub-expr
        tail-rand (str lead two-rand-delimiter between)
        tail-rand-to-bytes (.getBytes tail-rand "UTF-8")
        leading-part (byte-array [m-op m-r1 m-r2])
        ]
    (byte-array (mapcat seq leading-part tail-rand-to-bytes))
    )
  )

;; The different formats we have to implement:
;; I Format example (SVC)
;; RX Format example (LA)
;; SI Format example (HIO)
;; RI-a Format example (VCD)

;; SS-d Format example (MVCP)
;; SS-a Format example (ED, EDMK)
;; SSE Format example (MVCSK)
;; SS-c Format example (SRP)
;; SS-b Format example (ZAP)
;; S Format example (LRA, LPSW)

(defn testit [cmd-arr]
  (println (aget cmd-arr 0))
  (println (aget cmd-arr 1))
  (println (aget cmd-arr 2))
  )
(testit (tok-rr (do-rr balr-ex)) )

