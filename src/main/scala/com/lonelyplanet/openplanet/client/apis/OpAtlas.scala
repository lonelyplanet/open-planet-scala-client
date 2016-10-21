package com.lonelyplanet.openplanet.client.apis

import com.lonelyplanet.openplanet.client.{Atlas, FilterParameter, IncludeParameter, OpenPlanetClient}
import spray.json.JsValue

import collection.immutable.Seq

trait OpAtlas extends Atlas {
  val client: OpenPlanetClient

  override def places(limit: Int = 10, offset: Int = 0): JsValue = {
    client.getCollection("/places", limit, offset)
  }

  override def place(id: String, include: Seq[IncludeParameter] = Seq.empty): JsValue = {
    client.getSingle(s"/places/$id", include)
  }

  override def placeIds(limit: Int = 10, offset: Int = 0): JsValue = {
    client.getCollection("/places/ids")
  }

  override def pois(limit: Int = 10, offset: Int = 0): JsValue = {
    client.getCollection("/pois", limit, offset)
  }

  override def pois(limit: Int, offset: Int, filter: Seq[FilterParameter], include: Seq[IncludeParameter]): JsValue = {
    client.getCollection("/pois", limit, offset, filter, include)
  }

  override def placeIdImageAssociations(id: String, include: Seq[IncludeParameter] = Seq.empty) = {
    client.getSingle(s"/places/$id/image_associations", include)
  }

  override def placeIdAncestry(id: String, include: Seq[IncludeParameter] = Seq.empty) = {
    client.getSingle(s"/places/$id/ancestry", include)
  }

  override def placeIdDescendants(id: String, include: Seq[IncludeParameter] = Seq.empty) = {
    client.getSingle(s"/places/$id/descendants", include)
  }

  override def placeIdTopExperiences(id: String, include: Seq[IncludeParameter] = Seq.empty) = {
    client.getSingle(s"/places/$id/top_experiences", include)
  }

  override def placeIdPois(id: String, include: Seq[IncludeParameter] = Seq.empty) = {
    client.getSingle(s"/places/$id/pois", include)
  }
}