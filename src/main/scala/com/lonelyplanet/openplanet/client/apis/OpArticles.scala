package com.lonelyplanet.openplanet.client.apis

import com.lonelyplanet.openplanet.client.{Articles, FilterParameter, IncludeParameter, OpenPlanetClient}
import spray.json.JsValue

import scala.collection.immutable.Seq

trait OpArticles extends Articles {
  val client: OpenPlanetClient

  override def articles(limit: Int = 10, offset: Int = 0, filter: Seq[FilterParameter] = Seq.empty, include: Seq[IncludeParameter] = Seq.empty): JsValue = {
    client.getCollection("/articles", limit, offset, filter, include)
  }

  override def article(id: String, include: Seq[IncludeParameter] = Seq.empty): JsValue = {
    client.getSingle(s"/articles/$id", include)
  }

  override def articlesCategories(limit: Int = 10, offset: Int = 0, filter: Seq[FilterParameter] = Seq.empty, include: Seq[IncludeParameter] = Seq.empty): JsValue = {
    client.getCollection("/articles/categories", limit, offset, filter, include)
  }

  override def articlesCategory(id: String, include: Seq[IncludeParameter] = Seq.empty): JsValue = {
    client.getSingle(s"/articles/categories/$id", include)
  }
}

