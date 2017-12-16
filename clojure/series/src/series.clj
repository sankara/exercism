(ns series)

(defn slices [string n]
  (loop [s string
         series []]
    (cond
      (<= n 0) [""]
      (empty? s) series
      :else (let [substr (apply str (take n s))
                  series (if (= n (count substr))
                           (conj series substr)
                           series)]
              (recur (rest s) series)))))

;; (slices "49142" 3)
;; (slices "49142" 4)
;; (slices "12" 0)
