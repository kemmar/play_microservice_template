package com.nowtv.njp.cs.domain

import play.api.libs.json.Json._

case class ProductCatalogue(products: List[Product])

object ProductCatalogue {
  implicit val pcFormat = format[ProductCatalogue]
}
