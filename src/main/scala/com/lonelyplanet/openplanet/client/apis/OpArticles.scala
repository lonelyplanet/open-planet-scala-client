package com.lonelyplanet.openplanet.client.apis

import com.lonelyplanet.openplanet.client.{Articles, OpenPlanetClient}
import spray.json.JsValue

trait OpArticles extends Articles {
  val client: OpenPlanetClient

  override def articles(limit: Int = 10, offset: Int = 0): JsValue = {
    client.getCollection("/articles", limit, offset)
  }

  override def article(id: String, include: Option[String] = None): JsValue = {
    client.getSingle(s"/articles/$id", include)
  }

  override def articlesCategories(limit: Int = 10, offset: Int = 0): JsValue = {
    client.getCollection("/articles/categories", limit, offset)
  }

  override def articlesCategory(id: String, include: Option[String] = None): JsValue = {
    client.getSingle(s"/articles/categories/$id", include)
  }
}

