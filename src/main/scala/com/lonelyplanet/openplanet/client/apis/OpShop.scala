package com.lonelyplanet.openplanet.client.apis

import com.lonelyplanet.openplanet.client.{FilterParameter, IncludeParameter, OpenPlanetClient, Shop}
import spray.json.JsValue

import scala.collection.immutable.Seq

trait OpShop extends Shop {
  val client: OpenPlanetClient

  override def product(id: String, include: Seq[IncludeParameter] = Seq.empty): JsValue = {
    client.getSingle(s"/products/$id", include)
  }

  override def products(limit: Int, offset: Int, filter: Seq[FilterParameter], include: Seq[IncludeParameter]): JsValue = {
    client.getCollection(s"/products", limit, offset, filter, include)
  }
}
