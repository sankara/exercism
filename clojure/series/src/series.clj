(ns series)

(defn slices [string n]
  (if (<= n 0)
    [""]
    (map clojure.string/join (partition n 1 string))))

;; (slices "49142" 3)
;; (slices "49142" 4)
;; (slices "12" 0)
