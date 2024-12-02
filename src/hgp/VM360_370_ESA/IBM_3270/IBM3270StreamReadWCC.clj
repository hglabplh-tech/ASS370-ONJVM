(ns hgp.VM360-370-ESA.IBM-3270.IBM3270StreamReadWCC
  (:require [active.clojure.record :refer :all]
            [ hgp.VM360-370-ESA.IBM-3270.IBM3270-DEFS-CMD :refer :all]))
(define-record-type WCC
                    (make-WCC first-bit reset-bit reserved1 reserved2
                              start-prn alarm kbd-restore reset-mdt)
                    WCC?
                    [ first-bit WCC-first-bit
                     reset-bit WCC-reset-bit
                     reserved1 WCC-reserved1
                     reserved2 WCC-reserved2
                     start-prn WCC-start-prn
                     sound-alarm WCC-sound-alarm
                     kbd-restore WCC-kbd-restore
                     reset-mdt WCC-reset-mdt])



