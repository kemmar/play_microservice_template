package controllers

import javax.inject._

import play.api.mvc._
import services.Zoopla

import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class HomeController @Inject()(zoopla: Zoopla) extends Controller {

  def index = Action.async {
    zoopla
      .getProperties("tw7")
      .map(Ok(_))
  }

}
