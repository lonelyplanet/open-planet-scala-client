package com.lonelyplanet.openplanet.client.apis

import com.lonelyplanet.openplanet.client.{Images, OpenPlanetClient}
import spray.json.JsValue

trait OpImages extends Images {
  val client: OpenPlanetClient

  override def image(id: String, include: Option[String] = None): JsValue = {
    client.getSingle(s"/images/$id", include)
  }
}