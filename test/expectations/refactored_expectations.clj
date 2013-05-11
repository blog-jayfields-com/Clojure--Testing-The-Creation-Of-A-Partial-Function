(ns expectations.refactored-expectations
  (:use expectations refactored))

;;; "hmmm, how do I rewrite this?"
(expect {:bac 0.04} (with-redefs [state (atom {:bac 0.02})]
                      (update-bac 0.04)))

;; Ran 3 tests. 1 failures, 0 errors.
;;       expected: {:bac 0.04}
;;       was: {:legally-drunk?* #<clojure.core$partial$fn__4070>, :bac 0.02}
;;
;;       :legally-drunk?* with val #<clojure.core$partial$fn__4070>
;;                        is in actual, but not in expected
;;       :bac expected: 0.04
;;       was: 0.02

(expect false (with-redefs [state (atom {})]
                (legally-drunk? 0.02)))

(expect false (with-redefs [state (atom {})]
                (update-bac 0.00)
                (legally-drunk? 0.02)))
