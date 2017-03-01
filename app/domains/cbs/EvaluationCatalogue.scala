package domains.cbs

import com.nowtv.njp.cs.domain.{Attributes, Product => MyProduct, ProductCatalogue}
import play.api.libs.json.Json._

import scala.math.BigDecimal.RoundingMode

case class EvaluationCatalogue(productRoot: EvaluationCategory) {

  def transform = {
    def flattenedCategory(categories: List[EvaluationCategory], categoryPath: String = ""): List[MyProduct] = categories match {
      case EvaluationCategory(_, name, childCategories, products) :: tail =>
        val currentPath = categoryPath + "/" + name
        products.map(transformProduct(currentPath)) ++ flattenedCategory(childCategories, currentPath) ++ flattenedCategory(tail, categoryPath)
      case Nil => Nil
    }

    def transformProduct(categoryPath: String): (EvaluationProduct => MyProduct) = evalautionProduct => {


      val k = evalautionProduct.prices
      evalautionProduct.attributes match {
        case _: Some[EvaluationAttributes] =>
          val attributes = Attributes(convertKbpsToMbps(evalautionProduct.attributes.get.`upper-estimated-speed-kbps`), convertKbpsToMbps(evalautionProduct.attributes.get.`minimum-speed-kbps`), convertKbpsToMbps(evalautionProduct.attributes.get.`lower-estimated-speed-kbps`))
          MyProduct(evalautionProduct.id, evalautionProduct.name, evalautionProduct.billName, k, attributes, categoryPath, evalautionProduct.resourceIdentifier)
        case None =>
          MyProduct(evalautionProduct.id, evalautionProduct.name, evalautionProduct.billName, k, Attributes(), categoryPath, evalautionProduct.resourceIdentifier)
      }
    }

    def convertKbpsToMbps(lineSpeed: Option[String]) = {
      lineSpeed.map(speed => (BigDecimal(speed) / 1000).setScale(1, RoundingMode.HALF_UP).toString())
    }

    ProductCatalogue(flattenedCategory(List(productRoot)))
  }
}

object EvaluationCatalogue {
  implicit val evaluationCatalogueFormat = format[EvaluationCatalogue]
}
