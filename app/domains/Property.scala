package domains

import play.api.libs.json.Json

case class Property(latitude: BigDecimal,
                    longitude: BigDecimal,
                    image_url: String,
                    agent_logo: String,
                    agent_phone: String,
                    description: String,
                    status: String,
                    price: BigDecimal )

object Property {
  implicit val formatProperty = Json.format[Property]
}
