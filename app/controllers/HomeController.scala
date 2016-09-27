package controllers

import javax.inject._

import domains.jj
import play.api.libs.json.Json._
import play.api.mvc._
import services.Zoopla

@Singleton
class HomeController @Inject()(zoopla: Zoopla) extends Controller {


  def index = Action {
    Ok(toJson(jj(zoopla.apiKey)))
  }

  def body = Action(parse.json[jj]) { req =>
    Ok(toJson(req.body))
  }
}
