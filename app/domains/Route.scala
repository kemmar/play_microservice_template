package domains

import play.api.libs.json.{JsValue, Json}

case class Route(legs: Seq[JsValue])

object Route {
  implicit val formatRoute = Json.format[Route]
}
