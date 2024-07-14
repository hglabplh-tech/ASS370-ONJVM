(ns hgp.ass370.lang.instruction-formats-test
  (:require [clojure.test :refer :all]
            [hgp.ass370.lang.instruction_formats :as iform]))
(defn ascii->hex-string
  "Perform Hex Encoding of a string: String(208A) -> String(32303841)"
  [s]
  (->> s
       (map #(Integer/toHexString (int %)))
       ))
(defn to-machine-coded-rr [instruction]
  (let [result (iform/tok-rr (iform/do-rr instruction))]
     (map (fn [in]
            (format  "%x" in)) result)
     ))
(def balr-ex "BALR  R12,R15")
(println (to-machine-coded-rr balr-ex))
(deftest balr-test
  (is (= (iform/do-rr balr-ex) ["BALR" "R12" "R15"]))
  (is (= (to-machine-coded-rr balr-ex) ["5" "c" "f"])))

