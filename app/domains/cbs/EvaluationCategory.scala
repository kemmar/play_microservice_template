package domains.cbs

import play.api.libs.json.Json._

case class EvaluationCategory(id: String,
                              name: String,
                              categories: List[EvaluationCategory],
                              products: List[EvaluationProduct])

object EvaluationCategory {
  implicit val ecFormat = format[EvaluationCategory]
}
