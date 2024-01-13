(ns hgp.vm370.psw-utils-test
  (:require [clojure.test :refer :all]
            [hgp.vm370.psw-utils :refer :all ]))


(deftest test-cc-flags []
(let [test-arr (byte-array [0 255 255])]

  (assert-any "Error" (is (= 243 (get-cc (set-cc-equal test-arr))) "The value of cc should now be 243"))
                       ))
