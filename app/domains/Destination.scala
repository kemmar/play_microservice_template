package domains

import play.api.libs.json._

case class Destination(routes: Seq[Route] = Seq())

object Destination {
  implicit val formatDestination = Json.format[Destination]
}
