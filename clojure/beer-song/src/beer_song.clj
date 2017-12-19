(ns beer-song)

(defn- line1 [n]
  (cond (> n 1) (format "%s bottles of beer on the wall, %<s bottles of beer.\n" n)
        (= n 1) "1 bottle of beer on the wall, 1 bottle of beer.\n"
        :else "No more bottles of beer on the wall, no more bottles of beer.\n"))

;;(line1 2)
;;(line1 1)
;;(line1 0)

(defn- line2 [n]
  (cond (> n 2) (format "Take one down and pass it around, %s bottles of beer on the wall.\n" (- n 1))
        (= n 2) (format "Take one down and pass it around, %s bottle of beer on the wall.\n" (- n 1))
        (= n 1) (format "Take it down and pass it around, no more bottles of beer on the wall.\n")
        (= n 0) "Go to the store and buy some more, 99 bottles of beer on the wall.\n"))

;;(line2 2)
;;(line2 1)
;;(line2 0)

(defn verse [n]
  (str (line1 n) (line2 n)))

;; (verse 9)
;; (verse 2)
;; (verse 1)
;; (verse 0)

(defn sing
  ([n]
   (sing n 0))
  ([start end]
   (clojure.string/join "\n" (map verse (range start (dec end) -1)))))

;; (sing 8 6)
;; (sing 3)
    
