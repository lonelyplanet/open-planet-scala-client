package com.lonelyplanet.openplanet.client.apis

import com.lonelyplanet.openplanet.client.{Lodgings, OpenPlanetClient}
import spray.json.JsValue

trait OpLodgings extends Lodgings {
  val client: OpenPlanetClient

  override def lodgings(limit: Int = 10, offset: Int = 0): JsValue = {
    client.getCollection("/lodgings")
  }
}