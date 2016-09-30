package domains

import play.api.libs.json.Json._
import play.api.libs.ws.WSClient

import scala.concurrent.Await
import scala.concurrent.duration._

case class Properties(country: String,
                      result_count: BigDecimal,
                      area_name: String,
                      listing: Seq[Property],
                      street: String,
                      town: String,
                      county: String,
                      postcode: String) {
  def findDestination(destination: String)(implicit ws: WSClient) = this
    .copy(listing = listing.map(a => Await.result(a.buildDestination(destination), Duration(10, SECONDS))))
}

object Properties {
  implicit val formatProperties = format[Properties]
}

