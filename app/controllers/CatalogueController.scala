package controllers

import com.google.inject.Inject
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.CbsCatalogueService

import scala.concurrent.ExecutionContext.Implicits.global

class CatalogueController @Inject() (cbsCatalogueService: CbsCatalogueService) extends Controller {

  def index() = Action.async {
    cbsCatalogueService.getEvaluationCatalogue.map(k=> Ok(Json.toJson(k)))
  }

}
