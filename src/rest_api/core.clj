(ns rest-api.core
  (:require [rest-api.views.views :as views]
            [rest-api.views.layout :as layout]
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
  (route/not-found (layout/four-oh-four)))

(def app
  (wrap-defaults app-routes site-defaults))

(defonce server (ring/run-jetty #'app {:port 8080 :join? false}))

(defn -main []
  (.start server))

