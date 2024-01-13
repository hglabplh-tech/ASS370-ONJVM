(ns hgp.vm370.psw-utils-test
  (:require [clojure.test :refer :all]
            [hgp.vm370.psw-utils :refer :all ]))


(deftest test-cc-flags []
(let [test-arr (byte-array [0 255 255])
      arr-equal (set-cc-equal test-arr)
      arr-overflow (set-cc-overflow arr-equal)
      element-equal (get-cc (set-cc-equal arr-overflow))
      arr-overflow (set-cc-overflow arr-equal)
      element-cc-low-clear  (get-cc (clear-cc-low arr-overflow))
      arr-overflow (set-cc-overflow arr-equal)
      element-cc-high-clear  (get-cc (clear-cc-high arr-overflow))
      element-overflow (get-cc (set-cc-overflow test-arr))
      arr-equal (set-cc-equal test-arr)
      element-cc-high-set (get-cc (set-cc-high arr-equal))
      arr-equal (set-cc-equal test-arr)
      element-cc-low-set (get-cc (set-cc-low arr-equal))

      ]

  (assert-any "Error" (is (= 0 element-equal) "The value of cc should now be 243"))
  (assert-any "Error" (is (= 4 element-cc-low-set) "The value of cc should now be 247"))
  (assert-any "Error" (is (= 8 element-cc-high-set) "The value of cc should now be 251"))
  (assert-any "Error" (is (= 12 element-overflow) "The value of cc should now be 12"))

                       ))


