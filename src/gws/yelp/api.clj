(ns gws.yelp.api
  (:require [cheshire.core :as json]
            [gws.yelp.client])
  (:import [gws.yelp.client YelpClient]
           [org.scribe.oauth OAuth10aServiceImpl]
           [org.scribe.model OAuthRequest
                             Verb]))

(def ^:private base-url
  "http://api.yelp.com/v2/")

(defn ^:private endpoint
  [subpath]
  (str base-url subpath))

(defn ^:private api-call
  [client ^OAuthRequest req params]
  (doseq [[k v] params]
    (.addQuerystringParameter req (name k) (str v)))
  (.signRequest ^OAuth10aServiceImpl (:service client) (:token client) req)
  (json/parse-string (.. req send getBody) true))

(defn business
  "http://www.yelp.com/developers/documentation/v2/business

   params correspond directly with the Yelp API documentation."
  [client id & [{:as params :or {}}]]
  (let [req (OAuthRequest. (Verb/GET) (endpoint (str "business/" id)))]
    (api-call client req params)))

(defn search
  "http://www.yelp.com/developers/documentation/v2/search_api

   params correspond directly with the Yelp API documentation."
  [client params]
  (let [req (OAuthRequest. (Verb/GET) (endpoint "search"))]
    (api-call client req params)))
