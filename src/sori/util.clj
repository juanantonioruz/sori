(ns sori.util)

(defn remove-first-character [sample]
 (apply str (rest sample))  )