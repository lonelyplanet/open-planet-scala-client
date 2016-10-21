package com.lonelyplanet.openplanet.client

import org.scalatest.{FlatSpec, Matchers}
import QueryParameterParser._
import scala.collection.immutable.Seq

class QueryParameterParserSpec extends FlatSpec with Matchers {

  it should "parse filter query parameters" in {
    val input = Seq(FilterParameter("[a]", "3"))
    val output = parseFilter(input)

    output shouldBe Map("filter[a]" -> "3")
  }

  it should "parse empty filter query parameters" in {
    val input = Seq.empty
    val output = parseFilter(input)

    output shouldBe Map.empty
  }

  it should "parse include query parameters" in {
    val input = Seq(IncludeParameter("user"), IncludeParameter("place"), IncludeParameter("poi"))
    val output = parseInclude(input)
    output shouldBe Some("include" -> "user,place,poi")
  }

  it should "parse empty include query parameters" in {
    val input = Seq.empty
    val output = parseInclude(input)
    output shouldBe None
  }
}
