package com.lonelyplanet.openplanet.client.apis

import com.lonelyplanet.openplanet.client.{Annotate, IncludeParameter, OpenPlanetClient}
import spray.json.JsValue

import scala.collection.immutable.Seq

trait OpAnnotate extends Annotate {
  val client: OpenPlanetClient

  override def annotationRequest(body: String): JsValue = {
    client.post("/annotations", body)
  }

  override def annotationMatches(id: String, include: Seq[IncludeParameter] = Seq.empty): JsValue = {
    client.getSingle(s"/annotations/$id/matches")
  }
}

