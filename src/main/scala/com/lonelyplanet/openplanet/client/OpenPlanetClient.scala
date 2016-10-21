package com.lonelyplanet.openplanet.client

import io.restassured.RestAssured
import io.restassured.RestAssured._
import io.restassured.config.EncoderConfig
import spray.json._
import collection.immutable.Seq
import collection.JavaConversions._
import QueryParameterParser._

class OpenPlanetClient(baseUrl: String, apiKey: String) {

  RestAssured.baseURI = baseUrl

  RestAssured.config = RestAssured.config().encoderConfig(
    new EncoderConfig()
      .appendDefaultContentCharsetToContentTypeIfUndefined(false)
  )

  def this(baseUrl: String) = {
    this(baseUrl, "")
  }

  def getSingle(path: String, include: Seq[IncludeParameter] = Seq.empty): JsValue = {
    val includes = parseInclude(include)

    if (includes.isEmpty) {
      given().urlEncodingEnabled(false).get(path).body.asString.parseJson
    } else {
      given().params(includes.get._1, includes.get._2).urlEncodingEnabled(false).get(path).body.asString.parseJson
    }
  }

  def getCollection(path: String, limit: Int, offset: Int, filter: Seq[FilterParameter], include: Seq[IncludeParameter]): JsValue = {
    val includes = parseInclude(include)

    val urlPartWithoutInclude = given().urlEncodingEnabled(false)
      .params("page[limit]", limit).params("page[offset]", offset)
      .params(parseFilter(filter))

    val urlPartWithMaybeInclude = if (includes.isDefined) {
      urlPartWithoutInclude.params(includes.get._1, includes.get._2)
    } else {
      urlPartWithoutInclude
    }

    urlPartWithMaybeInclude.get(path).body.asString.parseJson
  }

  def getCollection(path: String, limit: Int = 10, offset: Int = 0): JsValue = {
    given().urlEncodingEnabled(false)
      .params("page[limit]", limit).params("page[offset]", offset)
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
