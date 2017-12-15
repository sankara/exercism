(ns word-count)

(defn word-count [sentence]
  (frequencies
   (clojure.string/split
    (clojure.string/lower-case sentence)
    #"[^\w]+")))

;; (def sentence "olly, olly")
;; (word-count "olly olly in come free")
