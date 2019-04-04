(ns rest-api.controllers.deps
  (:use [compojure.core :only (defroutes GET POST)])
  (:require [clojure.string :as str]
            [ring.util.response :as ring]
            [rest-api.views.views :as views]
            [rest-api.models.dep :as model]))

(defn index
  "Home page for index"
  []
  ())

(defn create
  [dep]
  (when-not (str/blank? dep)
    (model/create dep))
  (ring/redirect "/"))
