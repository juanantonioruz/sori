(ns sori.views.welcome
  (:require  [sori.views.common :as common])
  (:require [net.cgrand.enlive-html :as html])
  (use noir.core
       hiccup.core
       hiccup.page-helpers
       )
  (:use [sori.models.db])
  (:use somnium.congomongo)
  )


(defpage "/welcome" []
  (maybe-init url_db )
  (let [counter 
	(fetch-and-modify 
	 :firstcollection ;; In the collection named 'firstcollection',
	 {:_id "counter"} ;; find the counter record.
	 {:$inc {:value 1} } ;; Increment it.
	 :return-new true :upsert? true)] ;; Insert if not there.
    (common/layout
     [:p (str "Welcome to noir-heroku, you're visitor " (or (:value counter) 0))])))

(defpage "/welcome-sori" []
         (common/layout
          [:p "Welcome to sori"]))

(html/deftemplate index "public/templates/index.html"
  [ctxt]
  [:p#message] (html/content (:message ctxt)))



(defpage "/" []
  (index {:message "ey hola"})
  )