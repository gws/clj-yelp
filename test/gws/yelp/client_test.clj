(ns gws.yelp.client-test
  (:require [clojure.test :refer :all]
            [gws.yelp.client :as c])
  (:import (gws.yelp.client YelpClient)))

(def ^:private test-consumer-key
  (System/getenv "YELP_CONSUMER_KEY"))

(def ^:private test-consumer-secret
  (System/getenv "YELP_CONSUMER_SECRET"))

(def ^:private test-token
  (System/getenv "YELP_TOKEN"))

(def ^:private test-token-secret
  (System/getenv "YELP_TOKEN_SECRET"))

(defn- create-test-client
  []
  (c/create test-consumer-key
            test-consumer-secret
            test-token
            test-token-secret))

(deftest create
  (is (instance? YelpClient (create-test-client))))

(deftest business-lookup
  (let [client (create-test-client)
        response (c/business-lookup client "mothers-bistro-and-bar-portland")]
    (is (= "mothers-bistro-and-bar-portland" (:id response)))))
