package domains.cbs

import play.api.libs.json.Json._

case class EvaluationAttributes(`upper-estimated-speed-kbps`: Option[String] = None,
                      `minimum-speed-kbps`: Option[String]  = None,
                      `lower-estimated-speed-kbps`: Option[String] = None)

object EvaluationAttributes {
  implicit val evaluationAttributeFormat = format[EvaluationAttributes]
}
