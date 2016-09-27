package controllers

import javax.inject._

import domains.jj
import play.api.libs.json.Json._
import play.api.mvc._

@Singleton
class HomeController @Inject() extends Controller {


  def index = Action {
    Ok(toJson(jj("hello world")))
  }

  def body = Action(parse.json[jj]) { req =>
    Ok(toJson(req.body))
  }
}
