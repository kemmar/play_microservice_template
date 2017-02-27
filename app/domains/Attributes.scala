package com.nowtv.njp.cs.domain

import play.api.libs.json.Json.format

case class Attributes(`upper-estimated-speed-mbps`: Option[String] = None,
                      `minimum-speed-mbps`: Option[String]  = None,
                      `lower-estimated-speed-mbps`: Option[String] = None)

object Attributes {
  implicit val attributeFormat = format[Attributes]
}