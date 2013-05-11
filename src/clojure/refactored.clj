(ns refactored)

(def state (atom {}))

(defn pure-legally-drunk? [bac bac-increase]
  (-> bac (+ bac-increase) (> 0.08)))

(defn update-bac [x]
  (swap! state assoc :legally-drunk?* (partial pure-legally-drunk? x)))

(defn legally-drunk? [bac-increase]
  ((:legally-drunk?* @state) bac-increase))
