(ns rest-api.views.views
  (:require [hiccup.page :as page]
            [ring.util.anti-forgery :as util]))

(defn generate-header
  [title]
  [:head
   [:title (str title)]])

(defn cv
  []
  (page/html5
   (generate-header "CV")
   [:h1 "CV"]
   [:a {:href "/"} "HOME" ]
   [:br]
   [:p "here we want a dynamic list of data"]))

(defn home
  []
  (page/html5
   (generate-header "HOME")
   [:h1 "HOME"]
   [:a {:href "/cv"} "CV"]
   [:br]
   [:p "here we want to display a hyperlink to the data models in our db"]))
