(ns rest-api.core
  (:require [rest-api.views.views :as views]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.adapter.jetty :as ring]))

(defroutes app-routes
  (GET "/" 
       [] 
       (views/home))
  (GET "/cv"
       []
       (views/cv))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))

(defonce server (ring/run-jetty #'app {:port 8080 :join? false}))

(defn -main []
  (.start server))
