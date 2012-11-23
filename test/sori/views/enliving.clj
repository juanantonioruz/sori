(ns sori.views.enliving
  
  (:use  [clojure.pprint] [net.cgrand.enlive-html ] )
  (:use  [midje.sweet :as midje :exclude [has before after]]))

(midje/fact (+ 0  1) => 1)

(def base-template (html-resource "public/templates/base.html"))
(pprint base-template)
(def seleccion (select base-template [:nav :li  [(attr= :href "home")]]))
(pprint seleccion)
(def transformed-node (transform base-template seleccion  (add-class "current")))
(pprint transformed-node)
