(ns run-length-encoding)

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [s]
  (->> s
       (partition-by identity)
       (mapcat (juxt count first))
       (remove #{1})      
       (clojure.string/join)))

;; (run-length-encode "WWBBBADASD")
;; (run-length-encode "AA")
;; (run-length-encode "A")
;; (run-length-encode nil)

(defn run-length-decode
  "decodes a run-length-encoded string"
  [s]
  (->> s
       (re-seq #"(\d+)?(\D)")
       (mapcat (fn [[_ c-str character]] (repeat (Integer/parseInt (or c-str "1")) character)))
       (clojure.string/join)))

;; (run-length-decode "2ABC3G")
;; (run-length-decode "ABC")
