(defproject gws/clj-yelp "0.3.0"
  :description "A Clojure implementation of the Yelp API"
  :url "https://gitlab.com/gws/clj-yelp"
  :min-lein-version "2.0.0"
  :license {:name "Apache 2.0"
            :url "https://www.apache.org/licenses/LICENSE-2.0"}
  :profiles {:dev {:global-vars {*warn-on-reflection* true}}}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/data.json "0.2.5"]
                 [org.scribe/scribe "1.3.5"]])
