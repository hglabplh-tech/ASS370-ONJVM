(ns hgp.ass370.lang.directives-370)

;; control drectives
(def CSECT (gensym "CSECT"))

(def DSECT (gensym "DSECT"))

(def USING (gensym "USING"))

(def EQU (gensym "EQU"))

(def LTORG (gensym "LTORG"))

(def EJECT (gensym "EJECT"))

(def START (gensym "START"))

(def END (gensym "END"))

(def PRINT (gensym "PRINT"))

(def SPACE (gensym "SPACE"))

(def TITLE (gensym "TITLE"))

;; data directives
(def DC (gensym "DC"))

(def DS (gensym "DS"))

(def control-directive_to_code
  ^{:doc "Here the table mapping of the directives to symbols used later internally"}
  {"CSECT" CSECT
   "DSECT" DSECT
   "USING" USING
   "EQU"   EQU
   "LTORG" LTORG
   "EJECT" EJECT
   "START" START
   "END"   END
   "PRINT" PRINT
   "SPACE" SPACE
   "TITLE" TITLE
   })


(def data-definition-directive-to-code
  {"DC" DC
   "DS" DS})

(defn get-control-directive [directive-name]
  (get control-directive_to_code directive-name))

(defn get-data-definition-directive [directive-name]
  (get data-definition-directive-to-code directive-name))

