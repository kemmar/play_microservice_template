package domains

import play.api.libs.json.Json._

case class jj(str: String)

object jj {
  implicit val formatJj = format[jj]
}

