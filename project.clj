(defproject gws/clj-yelp "0.3.4"
  :description "A Clojure implementation of the Yelp API"
  :url "https://gitlab.com/gws/clj-yelp"
  :min-lein-version "2.0.0"
  :license {:name "Apache 2.0"
            :url "https://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[cheshire "5.6.3"]
                 [org.scribe/scribe "1.3.7"]]
  :profiles {:dev {:plugins [[jonase/eastwood "0.2.3"]]
                   :global-vars {*warn-on-reflection* true}}
             :provided {:dependencies [[org.clojure/clojure "1.8.0"]]}})
