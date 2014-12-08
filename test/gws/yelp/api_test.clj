(ns gws.yelp.api-test
  (:require [clojure.test :refer :all]
            [gws.yelp.api :as api]
            [gws.yelp.client-test :as client-test]))

(deftest business
  (let [client (client-test/create-client)
        response (api/business client "pok-pok-portland")]
    (is (= "pok-pok-portland" (:id response)))))

(deftest search
  (let [client (client-test/create-client)
        response (api/search client {:location "new york"
                                     :term "pok pok"})]
    (is (contains? response :businesses))
    (is (> (count (:businesses response)) 0))))
