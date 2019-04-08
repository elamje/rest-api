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
               [:p "Don't forget to run postgres -D pg & before working with the db"]))

(defn four-oh-four
  []
  (base-layout "Page Not Found"
               [:div {:id "four-oh-four"}
                "The page you requested could not be found"]))

