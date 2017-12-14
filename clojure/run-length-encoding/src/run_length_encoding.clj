(ns run-length-encoding)

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [s]
  ;; If current same as previous, inc count, else append, reset counter.
  (loop [current-str (seq s)
         count-tuples []]
  (if (empty? current-str)
    (apply str (flatten count-tuples))
    (let [[count prev] (last count-tuples)
          current-char (first current-str)]
      (recur (rest current-str)
             (if (= prev current-char)
               (conj (pop count-tuples) [(+ (or count 1) 1) current-char])
               (conj count-tuples [nil current-char])))))))

;; (run-length-encode "WWBBBADASD")
;; (run-length-encode "AA")
;; (run-length-encode "A")
;; (run-length-encode nil)

(defn run-length-decode
  "decodes a run-length-encoded string"
  [s]
  (loop [encoded-seq (re-seq #"(\d+)?(\D)" s)
         decoded-str ""]
    (if (empty? encoded-seq)
      decoded-str
      (let [[_ c-str character] (first encoded-seq)
            count (if (nil? c-str) 1 (Integer/parseInt c-str))]
        (recur
         (rest encoded-seq)
         (apply str decoded-str (repeat count character)))))))

;; (run-length-decode "2ABC3G")
;; (run-length-decode "ABC")
