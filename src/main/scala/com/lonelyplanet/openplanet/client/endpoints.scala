package com.lonelyplanet.openplanet.client

import spray.json.JsValue

import scala.collection.immutable.Seq

trait Activities {
  def activity(id: String, include: Seq[IncludeParameter] = Seq.empty): JsValue
  def activities(limit: Int = 10, offset: Int = 0, filter: Seq[FilterParameter] = Seq.empty, include: Seq[IncludeParameter] = Seq.empty): JsValue
  def activitiesAggregation(limit: Int = 10, offset: Int = 0, filter: Seq[FilterParameter] = Seq.empty, include: Seq[IncludeParameter] = Seq.empty): JsValue
}

trait Annotate {
  def annotationRequest(body: String): JsValue
  def annotationMatches(id: String, include: Seq[IncludeParameter] = Seq.empty): JsValue
}

trait Articles {
  def articles(limit: Int = 10, offset: Int = 0, filter: Seq[FilterParameter], include: Seq[IncludeParameter]): JsValue
  def article(id: String, include: Seq[IncludeParameter] = Seq.empty): JsValue
  def articlesCategories(limit: Int = 10, offset: Int = 0, filter: Seq[FilterParameter], include: Seq[IncludeParameter]): JsValue
  def articlesCategory(id: String, include: Seq[IncludeParameter] = Seq.empty): JsValue
}

trait Atlas {
  def places(limit: Int = 10, offset: Int = 0, filter: Seq[FilterParameter], include: Seq[IncludeParameter]): JsValue
  def place(id: String, include: Seq[IncludeParameter] = Seq.empty): JsValue
  def placeIds(limit: Int = 10, offset: Int = 0, filter: Seq[FilterParameter], include: Seq[IncludeParameter]): JsValue
  def poi(id: String, include: Seq[IncludeParameter] = Seq.empty): JsValue
  def pois(limit: Int = 10, offset: Int = 0, filter: Seq[FilterParameter], include: Seq[IncludeParameter]): JsValue
  def placeIdImageAssociations(id: String, include: Seq[IncludeParameter] = Seq.empty): JsValue
  def placeIdAncestry(id: String, include: Seq[IncludeParameter] = Seq.empty): JsValue
  def placeIdDescendants(id: String, include: Seq[IncludeParameter] = Seq.empty): JsValue
  def placeIdTopExperiences(id: String, include: Seq[IncludeParameter] = Seq.empty): JsValue
  def placeIdPois(id: String, include: Seq[IncludeParameter] = Seq.empty): JsValue
  def poisNearby(id: String, limit: Int, offset: Int, filter: Seq[FilterParameter], include: Seq[IncludeParameter] = Seq.empty): JsValue
  def poisAggregation(limit: Int = 10, offset: Int = 10, filter: Seq[FilterParameter], include: Seq[IncludeParameter] = Seq.empty): JsValue
}

trait Images {
  def image(id: String, include: Seq[IncludeParameter] = Seq.empty): JsValue
}

trait Lodgings {
  def lodgings(limit: Int = 10, offset: Int = 0, filter: Seq[FilterParameter], include: Seq[IncludeParameter]): JsValue
}

trait Slugs {
  def slug(id: String, include: Seq[IncludeParameter] = Seq.empty): JsValue
}

trait Shop {
  def product(id: String, include: Seq[IncludeParameter] = Seq.empty): JsValue
  def products(limit: Int = 10, offset: Int = 0, filter: Seq[FilterParameter], include: Seq[IncludeParameter]): JsValue
}