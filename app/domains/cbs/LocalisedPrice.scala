package domains.cbs

import play.api.libs.json.Json._

case class LocalisedPrice(currency: String = "GBP", value: BigDecimal)

object LocalisedPrice{
  implicit val priceFormat = format[LocalisedPrice]
}
