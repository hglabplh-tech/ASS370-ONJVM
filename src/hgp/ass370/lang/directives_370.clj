(ns hgp.ass370.lang.directives-370
  (:require [clojure.string :as str]))

(def control-directive_to_code
  ^{:doc "Here the table mapping of the directives to symbols used later internally"}
  {:CSECT "CSECT"
   :DSECT "DSECT"
   :USING "USING"
   :EQU   "EQU"
   :LTORG "LTORG"
   :EJECT "EJECT"
   :START "START"
   :END   "END"
   :PRINT "PRINT"
   :SPACE "SPACE"
   :TITLE "TITLE"
   })


(def data-definition-directive-to-code
  ^{:doc "the data definition table contains the directives for data definitions"}
  {:DC "DC"
   :DS "DS"
   :L  "L"
   :A  "A"
   :C  "C"
   :F  "F"
   :H  "H"
   :P  "P"
   :X  "X"
   })

(defn get-control-directive [directive-name]
  (get control-directive_to_code directive-name))




(defn get-data-definition-directive [directive-name]
  (get data-definition-directive-to-code directive-name))

(def data-format-record "([A-Za-z]+)\\w*DS\\d*CL\\d*")
;; have to read more about
;; the clojure version of regex

(def control-directive_to_code
  ^{:doc "Here the table mapping of the directives to symbols used later internally"}
  {:CSECT "CSECT"
   :DSECT "DSECT"
   :USING "USING"
   :EQU   "EQU"
   :LTORG "LTORG"
   :EJECT "EJECT"
   :START "START"
   :END   "END"
   :PRINT "PRINT"
   :SPACE "SPACE"
   :TITLE "TITLE"
   })


(def data-definition-directive-to-code
  ^{:doc "the data definition table contains the directives for data definitions"}
  {:DC "DC"
   :DS "DS"
   :L  "L"
   :A  "A"
   :C  "C"
   :F  "F"
   :H  "H"
   :P  "P"
   :X  "X"
   })

(defn get-control-directive [directive-name]
  (get control-directive_to_code directive-name))




(defn get-data-definition-directive [directive-name]
  (get data-definition-directive-to-code directive-name))

(def data-format-record "([A-Za-z]+)\\w*DS\\d*CL\\d*")
;; have to read more about
;; the clojure version of regex

