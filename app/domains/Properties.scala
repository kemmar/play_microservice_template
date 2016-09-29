package domains

import play.api.libs.json.Json._

case class Properties( country: String,
                       result_count: BigDecimal,
                       area_name: String,
                       listing: Seq[Property],
                       street: String,
                       town: String,
                       county: String,
                       postcode: String)

object Properties {
  implicit val formatProperties = format[Properties]
}

