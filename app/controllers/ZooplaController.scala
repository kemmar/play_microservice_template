package controllers

import javax.inject.Inject

import play.api.mvc.{Action, Controller}
import services.Zoopla

import scala.concurrent.ExecutionContext.Implicits.global

class ZooplaController @Inject()(zoopla: Zoopla) extends Controller {

  def findProperties(area: String) = Action.async { search =>
    zoopla
      .getProperties(area)
      .map(
        res => Ok(res)
      )
  }

}
