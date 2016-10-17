package com.lonelyplanet.openplanet.client.apis

import com.lonelyplanet.openplanet.client.{OpenPlanetClient, Slugs}
import spray.json.JsValue

trait OpSlugs extends Slugs {
  val client: OpenPlanetClient

  override def slug(id: String, include: Option[String] = None): JsValue = {
    client.getSingle(s"/slugs/$id", include)
  }
}
