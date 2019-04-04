(ns rest-api.models.migration
  (:require [clojure.java.jdbc :as sql]
            [rest-api.models.dep :as dep]
            ))

(defn migrated? 
  "Check if db is migrated"
  []
  (-> (sql/query dep/spec
                 [(str "select count(*) from information_schema.tables "
                       "where table_name='deps'")])
      first :count pos?))

(defn migrate 
  "Perform Migration"
  []
  (when (not (migrated?))
    (print "Creating database structure..." "for table deps") (flush)
    (sql/db-do-commands dep/spec
                        (sql/create-table-ddl
                         :deps
                         [[:id :serial "PRIMARY KEY"]
                          [:maven :varchar]
                          [:clojars :varchar]
                          [:lein :varchar "NOT NULL"]
                          [:created_at :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"]]))
    (println "Migration complete.")))
