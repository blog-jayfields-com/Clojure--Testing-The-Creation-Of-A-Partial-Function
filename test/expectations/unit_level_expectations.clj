(ns expectations.unit-level-expectations
  (:use expectations refactored))

(expect (not (pure-legally-drunk? 0.01 0.02)))
(expect (pure-legally-drunk? 0.01 0.07))
(expect (pure-legally-drunk? 0.01 0.08))

(expect {:legally-drunk?* [pure-legally-drunk? 0.04]}
        (with-redefs [state (atom {})
                      partial vector]
          (update-bac 0.04)))

(expect (interaction (a-fn 0.02))
        (with-redefs [state (atom {:legally-drunk?* a-fn})]
          (legally-drunk? 0.02)))

(expect (interaction (a-fn 0 0.02))
        (with-redefs [state (atom {})
                      pure-legally-drunk? a-fn]
          (legally-drunk? 0.02)))
