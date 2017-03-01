package domains.cbs

import play.api.libs.json.Json._

case class EvaluationProduct(id: String,
                             name: String,
                             billName: Option[String],
                             prices: Seq[LocalisedPrice],
                             attributes: Option[EvaluationAttributes],
                             resourceIdentifier: Option[String] = None)

object EvaluationProduct {
  implicit val pFormat = format[EvaluationProduct]
}


