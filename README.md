# yelp

A Clojure library for consuming the
[Yelp API](http://www.yelp.com/developers/documentation/v2/overview).

## Usage

Available on [Clojars](http://clojars.org/gws/yelp).

```clojure
[gws/yelp "0.2.0"]
```

```clojure
(ns your.app
  (:require [gws.yelp.client :as client]))

; Create a Yelp client with your API v2.0 access keys.
(def yelp (client/create "CONSUMER KEY" "CONSUMER SECRET" "TOKEN" "TOKEN SECRET"))

; Make an interesting request.
(client/business-lookup yelp msg)
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

Distributed under the [ISC License](http://opensource.org/licenses/ISC)
