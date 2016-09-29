package services

import javax.inject.Inject

import controllers.system.Service
import domains.Properties
import play.api.libs.json.Json
import play.api.libs.ws.WSClient

import scala.concurrent.ExecutionContext.Implicits.global

class Zoopla @Inject()(implicit ws: WSClient) extends Service {
  override val serviceName: String = "zoopla"

  lazy val apiKey = getValue("apiKey")

  lazy val url = getValue("url")

  lazy val getPropertiesUrl = { area: String => url + getValue("get-properties") format(area, apiKey) }

  def getProperties(area: String) = service(getPropertiesUrl(area)){ res =>
    res
      .map(_.json.as[Properties])
      .map(Json.toJson(_))
  }


}
