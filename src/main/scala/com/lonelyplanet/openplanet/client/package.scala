package com.lonelyplanet.openplanet

package object client {
  case class FilterParameter(key: String, value: String)
  case class IncludeParameter(value: String) extends AnyVal
}
