(ns hgp.VM360-370-ESA.machine-part.environment
  (:require [hgp.VM360-370-ESA.machine-part.opcodes-and-regs-hex :as codes]
            [hgp.VM360-370-ESA.machine-part.psw-sutils :as pu])
  (:import (java.util Arrays)
            (hgp.utils VMMemory))
  )


(def alloc-fun (gensym "alloc-fun"))

(def free-fun (gensym "free-fun"))

(def load-reg-fun (gensym "load-reg-fun"))

(def store-reg-fun (gensym "store-reg-fun"))

(def psw-init-fun (gensym "psw-init"))
;;TODO next will be the registers
(defn vm-env []
  (let [vm-mem (VMMemory. 1024 * 2048 * 2048)
        mem-src (.memSource vm-mem)
        opcodes codes/mnemonic_to_code
        regs-def codes/base-regs-to-hex
        psw (atom {'p-stat-word (byte-array 8)})
        base-regs (atom {codes/R0 (byte-array 4) codes/R1 (byte-array 4)
                         codes/R2 (byte-array 4) codes/R3 (byte-array 4)
                         codes/R4 (byte-array 4) codes/R5 (byte-array 4)
                         codes/R6 (byte-array 4) codes/R7 (byte-array 4)
                         codes/R8 (byte-array 4) codes/R9 (byte-array 4)
                         codes/R10 (byte-array 4) codes/R11 (byte-array 4)
                         codes/R12 (byte-array 4) codes/R13 (byte-array 4)
                         codes/R14 (byte-array 4) codes/R15 (byte-array 4)})
        alloc (fn  [val] (swap! storage conj val))          ;; rewrite
        free (fn [key] (swap! storage dissoc key))          ;; rewrite
        psw-init (fn [] (pu/init-psw (get  @psw 'p-stat-word )) @psw)
        load-reg (fn [reg stor-addr]
                   (let [reg-target (get base-regs reg)]
                     (.loadRegister mem-src reg-target stor-addr)))
        store-reg (fn [reg stor-addr]
                  (let [reg-source (get @base-regs reg)]
                    (.storeRegister mem-src reg-source stor-addr)))
        manipulate (fn [cmd & args]
                 (cond (= cmd alloc-fun)
                       (alloc (first args))
                       (= cmd free-fun)
                       (free (first args))
                       (= cmd load-reg-fun)
                       (load-reg (first args))
                       (= cmd store-reg-fun)
                       (store-reg (first args))
                       (= cmd psw-init-fun)
                       (psw-init)
                       ))]
manipulate))

(def vm-environment (vm-env))
(vm-environment psw-init-fun)