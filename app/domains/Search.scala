package domains

import play.api.libs.json.Json

case class Search(area: String)

object Search {
  implicit val formatSearch = Json.format[Search]
}
