(ns collatz-conjecture)

(defn collatz [n]
  (if (<= n 0) (throw (IllegalArgumentException.)))
  (loop [n n
         count 0]
    (if (= n 1)
      count
      (if (even? n)
        (recur (/ n 2) (+ count 1))
        (recur (+ 1 (* 3 n)) (+ count 1))))))


;; (collatz 1)
;; (collatz 12)
;; (collatz 0)
            
