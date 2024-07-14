(ns hgp.ass370.compile.370-bin.internal-inst-forms
  (:require [hgp.ass370.lang.format-ops-table :refer :all]))

(defrecord BinaryRepresentation [id schema-str in-form bits-per-unit filler-bits])

(def rr-represent (BinaryRepresentation. op-form-RR ["$inst" "$reg" "$reg"]
                                         [{"$inst" 8} {"$reg" 8} {"$reg" 8}]
                                         16 0))
(def bit-tab {
              "$reg" 4
              "$inst" 8
              "$addr" 16
              })
(def rr-in-form ([{"$inst" 8} {"$reg" 8} {"$reg" 8}]))


