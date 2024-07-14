(ns hgp.VM360-370-ESA.machine-part.environment
  (:require [hgp.VM360-370-ESA.machine-part.opcodes-and-regs-hex :as codes]
            [hgp.VM360-370-ESA.machine-part.psw-utils :as pu])
  (:import (hgp.utils VMMemory)
           )
  )


(def load-reg-fun (gensym "load-reg-fun"))

(def store-reg-fun (gensym "store-reg-fun"))

(def psw-init-fun (gensym "psw-init"))

(def alloc-fun (gensym "alloc-fun"))

(def free-fun (gensym "free-fun"))

(def sys-alloc-fun (gensym "sys-alloc-fun"))

(def sys-free-fun (gensym "sys-free-fun"))

(def mem-size (cast Long (* 1024 2048 2048)))

(def sys-mem-size (cast Long (* 1024 2048)))
;;TODO next will be the registers
(defn vm-env []
  (let [vm-mem (VMMemory. mem-size)
        vm-sys-mem (VMMemory. sys-mem-size)
        sys-mem-src (.memSource vm-sys-mem)
        mem-src (.memSource vm-mem)
        opcodes codes/mnemonic_to_code
        regs-def codes/base-regs-to-hex
        psw (atom {'p-stat-word (byte-array 8)})
        base-regs (atom {codes/R0  (byte-array 4) codes/R1 (byte-array 4)
                         codes/R2  (byte-array 4) codes/R3 (byte-array 4)
                         codes/R4  (byte-array 4) codes/R5 (byte-array 4)
                         codes/R6  (byte-array 4) codes/R7 (byte-array 4)
                         codes/R8  (byte-array 4) codes/R9 (byte-array 4)
                         codes/R10 (byte-array 4) codes/R11 (byte-array 4)
                         codes/R12 (byte-array 4) codes/R13 (byte-array 4)
                         codes/R14 (byte-array 4) codes/R15 (byte-array 4)})
        alloc (fn [stor-label start len] (.allocateMemory mem-src stor-label
                                                          start len)) ;; rewrite
        free (fn [stor-label mem-descr] (.freeMemory mem-src stor-label mem-descr))
        sys-alloc (fn [stor-label start len] (.allocateMemory sys-mem-src stor-label
                                                              start len)) ;; rewrite
        sys-free (fn [stor-label mem-descr] (.freeMemory sys-mem-src stor-label mem-descr)) ;; rewrite
        psw-init (fn [] (pu/init-psw (get @psw 'p-stat-word)) @psw)
        load-reg (fn [reg stor-addr]
                   (let [reg-target (get base-regs reg)]
                     (.loadRegister mem-src reg-target stor-addr)))
        store-reg (fn [reg stor-addr]
                    (let [reg-source (get @base-regs reg)]
                      (.storeRegister mem-src reg-source stor-addr)))
        manipulate (fn [cmd & args]
                     (cond (= cmd alloc-fun)
                           (alloc (args))
                           (= cmd free-fun)
                           (free (args))
                           (= cmd sys-alloc-fun)
                           (sys-alloc (args))
                           (= cmd sys-free-fun)
                           (sys-free (args))
                           (= cmd load-reg-fun)
                           (load-reg (first args))
                           (= cmd store-reg-fun)
                           (store-reg (first args))
                           (= cmd psw-init-fun)
                           (psw-init)
                           ))]
    manipulate))

(defn process-loop [machine-env]


        )
(defn start-machine
        []
        (let [machine-env (vm-env)]
          (process-loop vm-env)
          )
        )

