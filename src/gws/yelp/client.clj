(ns gws.yelp.client
  (:import [org.scribe.builder ServiceBuilder]
           [org.scribe.builder.api DefaultApi10a]
           [org.scribe.model Token]))

(def ^:private YelpApi2
  "OAuth 1.0a client for Yelp. A little odd in that it doesn't use any token
  endpoints or an authorization URL."
  (proxy [DefaultApi10a] []
    (getRequestTokenEndpoint [] nil)
    (getAccessTokenEndpoint [] nil)
    (getAuthorizationUrl [^Token t] nil)))

(defrecord YelpClient [service token])

(defn create
  "Build a Yelp client."
  [^String consumer-key ^String consumer-secret ^String token ^String token-secret]
  (let [service (.. (ServiceBuilder.)
                    (provider (class YelpApi2))
                    (apiKey consumer-key)
                    (apiSecret consumer-secret)
                    (build))
        token (Token. token token-secret)]
    (->YelpClient service token)))
