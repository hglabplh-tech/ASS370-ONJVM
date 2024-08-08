(ns hgp.ass370.lang.directives-parse
  (:require [clojure.string :as str]))

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

