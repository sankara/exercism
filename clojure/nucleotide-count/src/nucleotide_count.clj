(ns nucleotide-count)

(def ^:const nucleotides #{\A \C \G \T})

(def ^:const defaults (apply assoc {} (interleave nucleotides (repeat 0))))

(defn- valid-nucleotide? [nucleotide]
  (if (nucleotides nucleotide)
    true
    (throw (java.lang.IllegalArgumentException. (str "Not a valid nucleotide: " nucleotide)))))

;; (valid-nucleotide? \A)
;; (valid-nucleotide? \X)

(defn- valid-sequence? [sequence]
  (every? valid-nucleotide? sequence))

;; (valid-sequence? "GACT")
;; (valid-sequence? "XGACT")

(defn count [nucleotide sequence]
  (valid-nucleotide? nucleotide)
  (valid-sequence? sequence)

  (->> sequence
       (filter #{nucleotide})
       (clojure.core/count)))

;; (count \C "CCCCX")
;; (count \X "GACT")
;; (count \C "CCCC")
;; (count \C "GACT")

(defn nucleotide-counts [sequence]
  (valid-sequence? sequence)
  (merge defaults (frequencies sequence)))

;; (nucleotide-counts "GACT")
;; (nucleotide-counts "GAXCT")
;; (nucleotide-counts "")
