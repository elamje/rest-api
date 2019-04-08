(ns rest-api.views.views
  (:require [hiccup.page :as page]
            [ring.util.anti-forgery :as util]
            [rest-api.views.layout :refer [base-layout]]))

(defn generate-header
  [title]
  [:head
   [:title (str title)]])

(defn cv
  []
  (base-layout "CV"
               [:h1 "CV"]
               [:a {:href "/"} "HOME" ]
               [:br]
               [:p "here we want a dynamic list of data"]))

(defn home
  []
  (base-layout "HOME"
               [:h1 "HOME"]
               [:a {:href "/cv"} "CV"]
               [:br]
               [:p "here we want to display a hyperlink to the data models in our db"]))
