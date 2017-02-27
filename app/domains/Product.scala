package com.nowtv.njp.cs.domain

import com.nowtv.njp.cs.domain.cbs.LocalisedPrice
import play.api.libs.json.Json._

case class Product(id: String,
                   name: String,
                   displayName: Option[String],
                   prices: Seq[LocalisedPrice] = Nil,
                   freeTrialPeriod: Option[String],
                   freeTrialDisqualifyPeriod: Option[String],
                   attributes: Attributes,
                   category: String,
                   resourceIdentifier: Option[String] = None)

object Product {
  implicit val pFormat = format[Product]
}
