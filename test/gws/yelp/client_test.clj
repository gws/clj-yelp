(ns gws.yelp.client-test
  (:require [clojure.test :refer :all]
            [gws.yelp.client :as c])
  (:import [gws.yelp.client YelpClient]))

(def ^:private consumer-key
  (System/getenv "YELP_CONSUMER_KEY"))

(def ^:private consumer-secret
  (System/getenv "YELP_CONSUMER_SECRET"))

(def ^:private token
  (System/getenv "YELP_TOKEN"))

(def ^:private token-secret
  (System/getenv "YELP_TOKEN_SECRET"))

(defn create-client
  []
  (c/create consumer-key consumer-secret token token-secret))

(deftest create
  (is (instance? YelpClient (create-client))))
