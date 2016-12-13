package com.lonelyplanet.openplanet.client

import spray.json._

import scala.collection.immutable.Seq
import scala.language.postfixOps

class OpenPlanetClient(baseUrl: String, apiKey: String) {
  val client = new OpenPlanetClientWithoutBaseUrl(apiKey)

  def getSingle(relativeUrl: String, include: Seq[IncludeParameter] = Seq.empty): JsValue = {
    client.getSingle(baseUrl + relativeUrl, include)
  }

  def getCollection(relativeUrl: String, limit: Int, offset: Int, filter: Seq[FilterParameter], include: Seq[IncludeParameter]): JsValue = {
    client.getCollection(baseUrl + relativeUrl, limit, offset, filter, include)
  }

  def post(relativeUrl: String, body: String): JsValue = {
    client.post(baseUrl + relativeUrl, body)
  }
}
