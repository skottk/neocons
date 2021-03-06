(ns clojurewerkz.neocons.rest.helpers
  (:import  [java.net URI URL]))


;;
;; API
;;

(defn extract-id
  [^String location]
  (let [url (URL. location)]
    (Long/valueOf ^String (first (re-seq #"\d+$" (.getPath url))))))

(defn maybe-append
  [^String s ^String prefix]
  (.toLowerCase (if (.endsWith (.toLowerCase s) (.toLowerCase prefix))
                  s
                  (str s prefix))))

(definline check-not-nil!
  [ref ^String message]
  `(when (nil? ~ref)
     (throw (IllegalArgumentException. ~message))))
