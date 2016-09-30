package services

import javax.inject.Inject

import domains.Properties
import play.api.libs.json.Json
import play.api.libs.ws.WSClient
import system.Service

import scala.concurrent.ExecutionContext.Implicits.global

class Zoopla @Inject()(implicit val ws: WSClient) extends Service {
  override val serviceName: String = "zoopla"

  lazy val apiKey = getValue("apiKey")

  lazy val url = getValue("url")

  lazy val getPropertiesUrl = { area: String => url + getValue("get-properties") format(area, apiKey) }

  def getProperties(area: String) = service(getPropertiesUrl(area)){ res =>
    res
      .map(_.json.as[Properties])
      .map(Json.toJson(_))
  }

  def getProperties(area: String, destination: String) = service(getPropertiesUrl(area)){ res =>
    res
      .map(_.json.as[Properties].findDestination(destination))
      .map(Json.toJson(_))
  }
}
