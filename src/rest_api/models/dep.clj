(ns rest-api.models.dep
  (:require [clojure.java.jdbc :as sql]))

(def spec (or (System/getenv "DATABASE_URL")
              "postgresql://localhost:5432/api-v1"))

(defn all
  []
  (into [] (sql/query spec ["select * from deps order by id desc"])))

(defn create
  [dep]
  (sql/insert! spec :deps [:body] [dep]))
