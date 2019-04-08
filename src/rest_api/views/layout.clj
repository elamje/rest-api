(ns rest-api.views.layout
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css)]))

(defn base-layout 
  [title & body]
  (html5
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
    [:meta {:name "viewport" :content "width=device-width, initial-scale=1, maximum-scale=1"}]
    [:title title]
    (include-css "https://cdn.jsdelivr.net/gh/kognise/water.css@latest/dist/dark.css")
    (include-css "http://fonts.googleapis.com/css?family=Sigmar+One&v1")
    [:body
     [:div {:id "header"}
      [:h1 {:class "container"} "API"]]
     [:div {:id "content" :class "container"} body]]]))

(defn four-oh-four
  []
  (base-layout "Page Not Found"
               [:div {:id "four-oh-four"}
                "The page you requested could not be found"]))
