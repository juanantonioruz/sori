(ns sori.server
  (:require [noir.server :as server]))

(server/load-views "src/sori/views/")

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    (server/start port {:mode mode
                        :ns 'sori})))

(defn arranca []
  (server/start 8080))

