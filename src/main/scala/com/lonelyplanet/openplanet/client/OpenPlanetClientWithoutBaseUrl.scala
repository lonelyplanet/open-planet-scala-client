package com.lonelyplanet.openplanet.client

import spray.json._

import collection.immutable.Seq
import QueryParameterParser._
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

import scala.concurrent.Await
import akka.http.scaladsl.model._
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.Uri.Query
import akka.http.scaladsl.model.headers.RawHeader
import akka.http.scaladsl.unmarshalling.Unmarshal

import scala.concurrent.duration._
import scala.language.postfixOps
import scala.concurrent.ExecutionContext.Implicits.global
import akka.http.scaladsl.model.MediaTypes.`application/vnd.api+json`

class OpenPlanetClientWithoutBaseUrl(apiKey: String) {
  private val apiKeyHeader = "apikey"

  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()

  private def withInclude(uri: Uri, maybeIncludeParam: Option[(String, String)]): Uri =
    maybeIncludeParam.map { ip =>
      val query = uri.query()
      uri.withQuery(query.+:(ip._1, ip._2))
    }.getOrElse(uri)

  private def withPagination(uri: Uri, limit: Int, offset: Int): Uri = {
    val query = uri.query()
    uri.withQuery(query.+:("page[limit]", limit.toString).+:("page[offset]", offset.toString))
  }

  private def withFilters(uri: Uri, filters: Map[String, String]): Uri = {
    val query = uri.query()
    uri.withQuery(Query(query.toMap ++ filters))
  }

  private def getResponseBody(request: HttpRequest): JsValue = {
    val response = Await.result(Http().singleRequest(request), 30 seconds)
    Await.result(Unmarshal(response).to[String].map(_.parseJson), 30 seconds)
  }

  def getSingle(path: String, include: Seq[IncludeParameter] = Seq.empty): JsValue = {
    val includes = parseInclude(include)
    getResponseBody(HttpRequest(uri = withInclude(path, includes), headers = Seq(RawHeader(apiKeyHeader, apiKey))))
  }

  def getCollection(path: String, limit: Int, offset: Int, filter: Seq[FilterParameter], include: Seq[IncludeParameter]): JsValue = {
    val includes = parseInclude(include)
    getResponseBody(HttpRequest(uri = withFilters(withPagination(withInclude(path, includes), limit, offset), parseFilter(filter)), headers = Seq(RawHeader(apiKeyHeader, apiKey))))
  }

  def post(path: String, body: String): JsValue = {
    getResponseBody(HttpRequest(method = HttpMethods.POST, uri = path, headers = Seq(RawHeader(apiKeyHeader, apiKey)), entity = HttpEntity(ContentType(`application/vnd.api+json`), body)))
  }
}
