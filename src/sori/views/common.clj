(ns sori.views.common

  (:use [noir.core :only [defpartial]] [net.cgrand.enlive-html ] [sori.util]
        [hiccup.page-helpers :only [include-css html5]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "sori"]
               (include-css "/css/reset.css")]
              [:body
               [:div#wrapper
                content]]))


(def base-template (html-resource "public/templates/base.html"))
(defn plantillea [option]
  (let [uri (remove-first-character option)]
;    (println uri "------------")
    (transform base-template [:nav :li [(attr= :href uri)]]  (add-class "current"))
    ))

(defn submenu [template option]
  
  (-> (transform template [:hgroup.intro :h3.tagline] (content option))
      (transform  [:div.wrapper] (prepend option)))
  )

