Open Planet Scala Client
================
[![Join the chat at https://gitter.im/lonelyplanet/open-planet-scala-client](https://badges.gitter.im/lonelyplanet/open-planet-scala-client.svg)](https://gitter.im/lonelyplanet/open-planet-scala-client?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Build Status](https://travis-ci.org/lonelyplanet/open-planet-scala-client.svg?branch=master)](https://travis-ci.org/lonelyplanet/open-planet-scala-client)
[ ![Download](https://api.bintray.com/packages/lonelyplanet/maven/open-planet-scala-client/images/download.svg) ](https://bintray.com/lonelyplanet/maven/open-planet-scala-client/_latestVersion)

This is the Scala client for the Open Planet API

# Downloading

    "com.lonelyplanet" %% "open-planet-scala-client" % "0.1.2"


You might need to also add our repository:

```
resolvers ++= Seq(
  Resolver.bintrayRepo("lonelyplanet", "maven")
)
```

You can use it to get access to following resources:
* Activities
* Articles
* Places
* Images
* Lodgings
* and few other ones

## Current state of the client

At the moment the client should be treated as experimental (which means that it will change rapidly).

It's implemented using RestAssured library and will be migrated to the proper HTTP client library soon.