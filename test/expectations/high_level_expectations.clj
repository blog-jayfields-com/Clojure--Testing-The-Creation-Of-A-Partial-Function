(ns expectations.high-level-expectations
  (:use expectations refactored))

(expect (not (legally-drunk? 0.02)))
(expect (legally-drunk? 0.08))
(expect (legally-drunk? 0.09))


(expect false
        (with-redefs [state (atom {})]
          (update-bac 0.01)
          (legally-drunk? 0.02)))

(expect true
        (with-redefs [state (atom {})]
          (update-bac 0.01)
          (legally-drunk? 0.07)))

(expect true
        (with-redefs [state (atom {})]
          (update-bac 0.01)
          (legally-drunk? 0.08)))
