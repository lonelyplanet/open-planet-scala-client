package com.lonelyplanet.openplanet.client.apis

import com.lonelyplanet.openplanet.client.{Activities, FilterParameter, IncludeParameter, OpenPlanetClient}
import spray.json.JsValue

import scala.collection.immutable.Seq

trait OpActivities extends Activities {
  val client: OpenPlanetClient

  override def activity(id: String, include: Seq[IncludeParameter] = Seq.empty): JsValue = {
    client.getSingle(s"/partner-activities/$id", include)
  }

  override def activities(limit: Int = 10, offset: Int = 0, filter: Seq[FilterParameter] = Seq.empty, include: Seq[IncludeParameter] = Seq.empty): JsValue = {
    client.getCollection("/partner-activities", limit, offset, filter, include)
  }

  override def activitiesAggregation(limit: Int = 10, offset: Int = 0, filter: Seq[FilterParameter] = Seq.empty, include: Seq[IncludeParameter] = Seq.empty): JsValue = {
    client.getCollection("/partner-activities/aggregation", limit, offset, filter, include)
  }
}

