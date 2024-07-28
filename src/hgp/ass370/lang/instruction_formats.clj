(ns hgp.ass370.lang.instruction_formats
  (:require [clojure.string :as str]
            [hgp.general.opcodes-and-regs-hex :as codes]
            [hgp.ass370.lang.format-ops-table :as fot]))


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
;; I Format (SVC)
(defn do-i [expr]
  (let [vector (perl-split-on-space expr)
        opcode (get-in [vector] 0  0)
        code (get-in [vector] 0  1)]
    [opcode code]
    ))

;; RX Format example (LA)
(defn do-rx [expr]
  (let [temp (str/replace expr #"," " ")
        vector (perl-split-on-space temp)
        sub-expr (get-lead-and-in-between-to-vector temp "(" ")")
        opcode (get-in [vector] 0  0)
        reg (get-in [vector] 0  1)
        address (get-in [vector] 0 2)
        [reg-index reg-base] sub-expr]
    [opcode reg address reg-index reg-base]
    ))

;; RR Format (opcode op1/reg , op2/reg)
(defn do-rr [expr]
  (let [temp (str/replace expr #"," " ")
        vector (perl-split-on-space temp)]
    vector
    )
  )


;; RS Format example (CLM) --> Form 1
;; later we have o define a way of parsing which respects
;; that there may be no '(' or ')'
(defn do-rs-f1 [expr]
  (let [temp (str/replace expr #"," " ")
        vector (perl-split-on-space temp)
        sub-expr (get-lead-and-in-between-to-vector temp "(" ")")
        opcode (get-in [vector] 0  0)
        reg-1 (get-in [vector] 0  1)
        reg-2 (get-in [vector] 0  2)]
    [opcode reg-1 reg-2 sub-expr]
  ))

;; I Format (SVC)
(defn tok-i [stmt]
  (let [[op-code code] stmt
        m-op (codes/get-code op-code)]
    [m-op code]
    ))

;; RR Format (opcode op1/reg , op2/reg)
(defn tok-rr [stmt]
  (let [[op-code reg1 reg2] stmt
        m-op (codes/get-code op-code)
        m-r1  (codes/get-base-reg reg1)
        m-r2  (codes/get-base-reg reg2)]
    (byte-array [m-op m-r1 m-r2])
    ))

(defn tok-rx-a [stmt]
  (let )
  )

;; RX Format example (LA)
(defn do-rx-a [stmt]
  (let [[op-code reg address reg-index reg-base] stmt
        m-op (codes/get-code op-code)
        m-reg  (codes/get-base-reg reg)
        m-addr address
        m-index  (codes/get-base-reg reg-index)
        m-base (codes/get-base-reg reg-base)
        ]
    [m-op m-reg m-addr m-index m-base]
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


;; SI Format example (HIO)
;; RI-a Format example (VCD)

;; SS-d Format example (MVCP)
;; SS-a Format example (ED, EDMK)
;; SSE Format example (MVCSK)
;; SS-c Format example (SRP)
;; SS-b Format example (ZAP)
;; S Format example (LRA, LPSW)

(def format-to-fun
  {fot/op-form-RR [do-rr tok-rr]
   fot/op-form-RX-a [do-rx-a nil]
   fot/op-form-RX-b [nil nil]
   fot/op-form-I [do-i tok-i]
   fot/op-form-RS [do-rs-f1 tok-rs]
   fot/op-form-SS [nil nil]
   fot/op-form-SS-a [nil nil]
   fot/op-form-SS-b [nil nil]
   fot/op-form-SS-c [nil nil]
   fot/op-form-SI [nil nil]})

