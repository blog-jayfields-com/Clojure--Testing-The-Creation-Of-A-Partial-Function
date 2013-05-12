(ns refactored-with-typo)

(def state (atom {}))

(defn pure-legally-drunk? [bac bac-increase]
  (-> bac (+ bac-increase) (>= 0.08)))

(defn update-bac [x]
  (swap! state assoc :legally-drunk?* (partial pure-legally-drunk? x)))

(defn legally-drunk? [bac-increase]
  (let [{:keys [legally-drunk?**]
         :or {legally-drunk?** (partial pure-legally-drunk? 0)}} @state]
    (legally-drunk?* bac-increase)))
