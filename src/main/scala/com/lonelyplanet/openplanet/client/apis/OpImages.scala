package com.lonelyplanet.openplanet.client.apis

import com.lonelyplanet.openplanet.client.{Images, IncludeParameter, OpenPlanetClient}
import spray.json.JsValue

import scala.collection.immutable.Seq

trait OpImages extends Images {
  val client: OpenPlanetClient

  override def image(id: String, include: Seq[IncludeParameter] = Seq.empty): JsValue = {
    client.getSingle(s"/images/$id", include)
  }
}