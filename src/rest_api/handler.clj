(ns rest-api.handler
  (:require [rest-api.views :as views]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

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
