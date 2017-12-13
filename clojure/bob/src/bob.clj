(ns bob
  (:require [clojure.string :as s]))

(defn- question? [str]
  (s/ends-with? str "?"))

(defn- yelling? [str]
  (and
   (re-matches #".*[a-zA-Z].*" str)
   (= str (s/upper-case str))))
  
(defn response-for [statement]
  (cond
    (s/blank? statement) "Fine. Be that way!"
    (yelling? statement) "Whoa, chill out!"
    (question? statement) "Sure."
    :else "Whatever."))


