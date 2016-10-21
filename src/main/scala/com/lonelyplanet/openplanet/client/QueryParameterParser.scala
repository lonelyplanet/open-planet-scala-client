package com.lonelyplanet.openplanet.client

import scala.collection.immutable.Seq

object QueryParameterParser {
  def parseFilter(filter: Seq[FilterParameter]): Map[String, String] = {
    filter.map { f =>
      "filter" + f.key -> f.value
    }.toMap
  }

  def parseInclude(include: Seq[IncludeParameter]): Option[(String, String)] = {
    if (include.isEmpty) {
      None
    } else {
      Some(("include", include.map(_.value).mkString(",")))
    }
  }
}
