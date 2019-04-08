(ns rest-api.core
  (:require [rest-api.views.views :as views]
            [rest-api.models.migration :as schema]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.adapter.jetty :as ring])
  (:gen-class))

(defroutes app-routes
  (GET "/" 
       []
       (views/home))
  (GET "/cv"
       []
       (views/cv))
  (route/not-found (views/four-oh-four)))

(def app
  (wrap-defaults app-routes site-defaults))

(defonce server (ring/run-jetty #'app {:port 8080 :join? false}))

(defn -main []
  (schema/migrate)
  (.start server))

