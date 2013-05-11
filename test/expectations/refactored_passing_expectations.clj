(ns expectations.refactored-passing-expectations
  (:use expectations refactored))

(expect {:legally-drunk?* [pure-legally-drunk? 0.04]}
        (with-redefs [state (atom {})
                      partial vector]
          (update-bac 0.04)))

(expect false (with-redefs [state (atom {})]
                (legally-drunk? 0.02)))

(expect false (with-redefs [state (atom {})]
                (update-bac 0.00)
                (legally-drunk? 0.02)))
