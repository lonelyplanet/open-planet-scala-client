package com.lonelyplanet.openplanet.client.apis

import com.lonelyplanet.openplanet.client.{IncludeParameter, OpenPlanetClient, Slugs}
import spray.json.JsValue

import scala.collection.immutable.Seq

trait OpSlugs extends Slugs {
  val client: OpenPlanetClient

  override def slug(id: String, include: Seq[IncludeParameter] = Seq.empty): JsValue = {
    client.getSingle(s"/slugs/$id", include)
  }
}
