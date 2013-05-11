(ns original)

(def state (atom {}))

(defn pure-legally-drunk? [bac bac-increase]
  (-> bac (+ bac-increase) (> 0.08)))

(defn update-bac [x]
  (swap! state assoc :bac x))

(defn legally-drunk? [bac-increase]
  (pure-legally-drunk? (:bac @state) bac-increase))
