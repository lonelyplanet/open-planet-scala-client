package com.lonelyplanet.openplanet.client.apis

import com.lonelyplanet.openplanet.client.{Annotate, OpenPlanetClient}
import spray.json.JsValue

trait OpAnnotate extends Annotate {
  val client: OpenPlanetClient

  override def annotationRequest(body: String): JsValue = {
    client.post("/annotations", body)
  }

  override def annotationMatches(id: String, include: Option[String] = None): JsValue = {
    client.getSingle(s"/annotations/$id/matches")
  }
}

