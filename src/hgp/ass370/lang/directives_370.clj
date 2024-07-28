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

(defn parse-format-cl [input-line]
  (let [splitted (str/split input-line #" ")
        label (get splitted 0)
        stor-type (get splitted 1)
        thing (get splitted 2)
        sfield (str/split thing #"CL")
        fcount (get sfield 0)
        cl-length (get sfield 1)]
    (if (= fcount nil)
      [thing stor-type label cl-length]
      [thing stor-type label fcount cl-length])))


(println (parse-format-cl "label DS 1CL24"))
(println (parse-format-cl "label DS CL8"))
