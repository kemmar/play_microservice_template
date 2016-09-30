package domains

import play.api.libs.json.{JsValue, Json}
import play.api.libs.ws.WSClient
import services.Google

import scala.concurrent.ExecutionContext.Implicits.global

case class Property(latitude: BigDecimal,
                    longitude: BigDecimal,
                    image_url: String,
                    agent_logo: String,
                    agent_phone: String,
                    description: String,
                    status: String,
                    price: BigDecimal,
                    distance: Option[Destination] = None) {

  def buildDestination(destination: String)(implicit ws: WSClient) = {
    val google: Google = new Google(ws)
    google.getDestination(s"$latitude,$longitude", destination).map(dest => this.copy(distance = Some(dest.as[Destination])))
  }
}

object Property {
  implicit val formatProperty = Json.format[Property]
}
