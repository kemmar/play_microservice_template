package controllers

import javax.inject.Inject

import play.api.mvc.{Action, Controller}
import services.Zoopla

import scala.concurrent.ExecutionContext.Implicits.global

class ZooplaController @Inject()(zoopla: Zoopla) extends Controller {

  def findProperties(area: String) = Action.async {
    zoopla
      .getProperties(area)
      .map(Ok(_))
  }

  def findPropertiesWithDirections(area: String, destination: String) = Action.async {
    zoopla
      .getProperties(area, destination)
      .map(Ok(_))
  }

}
