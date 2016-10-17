package com.lonelyplanet.openplanet.client.apis

import com.lonelyplanet.openplanet.client.{Activities, OpenPlanetClient}
import spray.json.JsValue

trait OpActivities extends Activities {
  val client: OpenPlanetClient

  override def activity(id: String, include: Option[String] = None): JsValue = {
    client.getSingle(s"/partner-activities/$id", include)
  }
}

