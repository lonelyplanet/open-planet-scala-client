package com.lonelyplanet.openplanet.client

import io.restassured.RestAssured
import io.restassured.RestAssured._
import io.restassured.config.EncoderConfig
import spray.json._

class OpenPlanetClient(baseUrl: String, apiKey: String) {
  RestAssured.baseURI = baseUrl

  RestAssured.config = RestAssured.config().encoderConfig(
    new EncoderConfig()
      .appendDefaultContentCharsetToContentTypeIfUndefined(false)
  )

  def this(baseUrl: String) = {
    this(baseUrl, "")
  }

  def getSingle(path: String, include: Option[String] = None): JsValue = {
    include match {
      case None =>
        given().urlEncodingEnabled(false).get(path).body.asString.parseJson
      case Some(includeParam) =>
        given().param("include", includeParam).urlEncodingEnabled(false).get(path).body.asString.parseJson
    }
  }

  def getCollection(path: String, limit: Int = 10, offset: Int = 0): JsValue = {
    given().urlEncodingEnabled(false)
      .params("page[limit]", limit).params("page[offset]", offset)
      .get(path).body.asString.parseJson
  }

  def getCollectionWithFilter(path: String, limit: Int, offset: Int, filterKey: String, filterValue: String): JsValue = {
    given().urlEncodingEnabled(false)
      .params("page[limit]", limit).params("page[offset]", offset)
      .param("filter" + filterKey, filterValue)
      .get(path).body.asString.parseJson
  }

  def post(path: String, body: String): JsValue = {
    given()
      .contentType("application/vnd.api+json")
      .body(body)
      .post(path)
      .body.asString.parseJson
  }
}
