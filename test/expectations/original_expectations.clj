(ns expectations.original-expectations
  (:use expectations original))

(expect {:bac 0.04} (with-redefs [state (atom {:bac 0.02})]
             (update-bac 0.04)))

(expect false (with-redefs [state (atom {})]
                (update-bac 0.00)
                (legally-drunk? 0.02)))
