package com.lonelyplanet.openplanet.client.apis

import com.lonelyplanet.openplanet.client.{OpenPlanetClient, Shop}
import spray.json.JsValue

trait OpShop extends Shop {
  val client: OpenPlanetClient

  override def product(id: String, include: Option[String]): JsValue = {
    client.getSingle(s"/products/$id", include)
  }

  override def products(limit: Int, offset: Int): JsValue = {
    client.getCollection(s"/products", limit, offset)
  }
}
