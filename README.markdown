# clj-yelp

A Clojure library for consuming the
[Yelp API](http://www.yelp.com/developers/documentation/v2/overview).

## Installation

[![Clojars Project](https://clojars.org/gws/clj-yelp/latest-version.svg)](https://clojars.org/gws/clj-yelp)

## Usage

```clojure
(ns your.app
  (:require [gws.yelp.client :as client]
            [gws.yelp.api :as api]))

; Create a Yelp client with your API v2 access keys.
(def yelp-client (client/create "CONSUMER KEY" "CONSUMER SECRET" "TOKEN" "TOKEN SECRET"))

; Look up Portland's Pok Pok by ID
(api/business yelp-client "pok-pok-portland")

; Search for New York's Pok Pok
(api/search yelp-client {:term "pok pok", :location "new york"})
```

## Testing

Most of the tests are run against the actual Yelp API, so you need to obtain API
credentials. Once you’ve done this, you can supply the credentials as environment
variables:

```sh
YELP_CONSUMER_KEY=... YELP_CONSUMER_SECRET=... YELP_TOKEN=... YELP_TOKEN_SECRET=... lein test
```

## License

Copyright © 2014 Gordon Stratton

Licensed under the [Apache License version 2.0](https://www.apache.org/licenses/LICENSE-2.0).
