(defproject sori "0.1.0-SNAPSHOT"
            :description "Clojure WebNoir Project"
            :dependencies [[org.clojure/clojure "1.3.0"]
                           [noir "1.2.1"]
                           [enlive "1.0.0"]
                           [midje "1.4.0"]
                           [congomongo "0.3.2"]]
            :main sori.server
            :plugins [[lein-swank "1.4.4"]])

