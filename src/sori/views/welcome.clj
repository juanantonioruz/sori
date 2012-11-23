(ns sori.views.welcome
  (:require  [sori.views.common :as common])
  (:require [net.cgrand.enlive-html :as html])
  (:require noir.request)
    (:require [noir.response :exlude [empty]])
  (use noir.core
       hiccup.core
       hiccup.page-helpers
       noir.request
       
      
       )
  (:use [ noir.response :exclude [empty]])
  (:use [sori.models.db])
  (:use somnium.congomongo)
  )





(defpage "/welcome" []
  (println "pasa por welcome")
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

(html/deftemplate form-user "public/templates/contact.html"
  [ctxt]
  [:p#message] (html/content (:message ctxt)))

(html/deftemplate base "public/templates/base.html"
  [ctxt]
  
  [:div.wrapper] (html/content (:message ctxt))
   [:ul#nav :li ] (html/add-class "current")

  )

(defn plantilla []
  (let [
        option (:uri (ring-request))
        menu-plantilla (common/plantillea option)
        result-html (common/submenu menu-plantilla option)]
(html/emit* result-html)
    )
  
     ; (base {:message "ey hola"})
  )

(defpage "/home" []
  (plantilla) 
   )
(defpage "/about" []
   (plantilla)
   )
(defpage "/menu" []
   (plantilla)
   )
(defpage "/gallery" []
   (plantilla)
  )
(defpage "/reviews" []
   (plantilla)
   )
(defpage "/contact" []
   (plantilla)
  )
(defpage "/new-user" []
  (form-user {:message "ey hola"})
  )

(defpage [:post "/new-user" ] {:as user}
  (maybe-init url_db )
  (insert! :users user)
  (str "<h1>INSERTADO OK</h1>")
    ;(str "recibido tio!" (:name user) (:password user) (:email user) "<br>" (str user))
  )
