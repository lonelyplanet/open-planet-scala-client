package com.lonelyplanet.openplanet.client.apis

import com.lonelyplanet.openplanet.client.{Activities, IncludeParameter, OpenPlanetClient}
import spray.json.JsValue

import scala.collection.immutable.Seq

trait OpActivities extends Activities {
  val client: OpenPlanetClient

  override def activity(id: String, include: Seq[IncludeParameter] = Seq.empty): JsValue = {
    client.getSingle(s"/partner-activities/$id", include)
  }
}

