(use '[datomic.api :only [q db] :as d])
(use 'clojure.pprint)

(def uri "datomic:mem://people")
(d/create-database uri)
(def conn (d/connect uri))

(def schema (read-string (slurp "project/schema.dtm")))

(first schema)

@(d/transact conn schema)

(def data (read-string (slurp "project/data.dtm")))

(first data)
(second data)
(nth data 2)

@(d/transact conn data)

(def results (q '[:find ?c :where [?c :community/name]] (db conn)))
(count results)

(def id (ffirst results))
(def entity (-> conn db (d/entity id)))

(keys entity)
(:community/name entity)
