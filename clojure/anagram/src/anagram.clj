(ns anagram)
  
(defn- sort-word [word]
  (sort (clojure.string/lower-case word)))

(defn- anagram-match? [w1 w2]
  (= (sort-word w1) (sort-word w2)))

(defn anagrams-for [word dict]
  (->> dict
       (filterv (partial anagram-match? word))
       (remove #(.equalsIgnoreCase word %))))

;; (def word "listen")
;; (def sorted-word (sort word))
;; (def dict ["enlists" "google" "inlets" "listen"])
;; (anagrams-for "listen" ["enlists" "google" "inlets" "listen"])
