(ns gws.yelp.client
  (:require [clojure.data.json :as json])
  (:import [org.scribe.builder ServiceBuilder]
           [org.scribe.builder.api DefaultApi10a]
           [org.scribe.model OAuthRequest Token Verb]))

(defrecord YelpClient [service token])

(def ^:private base-url "http://api.yelp.com/v2/")

(def ^:private YelpApi2
  (class
    (proxy [DefaultApi10a] []
      (getAccesTokenEndpoint [] nil)
      (getAuthorizationUrl [t] nil)
      (getRequestTokenEndpoint [] nil))))

(defn- build-endpoint
  [call]
  (str base-url call))

(defn create
  "Build a Yelp client."
  [consumer-key consumer-secret token token-secret]
  (let [service (.. (ServiceBuilder.)
                    (provider YelpApi2)
                    (apiKey consumer-key)
                    (apiSecret consumer-secret)
                    (build))
        token (Token. token token-secret)]
    (->YelpClient service token)))

(defn business-lookup
  "http://www.yelp.com/developers/documentation/v2/business

   Pass a map with the optional parameters as key-value pairs."
  [client id & [params]]
  {:pre [(instance? YelpClient client)]}
  (let [req (OAuthRequest. (Verb/GET) (build-endpoint (str "business/" id)))]
    (doseq [[k, v] params]
      (.addQuerystringParameter req (str k) (str v)))
    (.signRequest (:service client) (:token client) req)
    (-> req .send .getBody (json/read-str :key-fn keyword))))
