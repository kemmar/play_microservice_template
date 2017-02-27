package controllers

import play.api.mvc.{Action, Controller}
import services.CbsCatalogueService

class CatalogueController(cbsCatalogueService: CbsCatalogueService) extends Controller {

  def index() = Action {
    Ok(cbsCatalogueService.getEvaluationCatalogue)
  }

}
