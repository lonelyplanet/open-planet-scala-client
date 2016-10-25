package com.lonelyplanet.openplanet.client.apis

import com.lonelyplanet.openplanet.client.{FilterParameter, IncludeParameter, Lodgings, OpenPlanetClient}
import spray.json.JsValue

import scala.collection.immutable.Seq

trait OpLodgings extends Lodgings {
  val client: OpenPlanetClient

  override def lodgings(limit: Int = 10, offset: Int = 0, filter: Seq[FilterParameter], include: Seq[IncludeParameter]): JsValue = {
    client.getCollection("/lodgings", limit, offset, filter, include)
  }
}