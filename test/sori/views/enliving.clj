(ns sori.views.enliving
  (:use clojure.string :as str)
  
  (:use  [clojure.pprint] [net.cgrand.enlive-html ] [sori.util] )
  (:use  [midje.sweet :as midje :exclude [has before after]]))

(midje/fact (+ 0  1) => 1)
(midje/fact (remove-first-character "hola") => "ola")

(def base-template (html-resource "public/templates/base.html"))
;(pprint base-template)

(def nav-seleccion (select base-template [:nav]))
;(pprint seleccion)
(def transformed-node (transform nav-seleccion  [:li [(attr= :href "contact")]]  (add-class "current")))
;(pprint transformed-node)

