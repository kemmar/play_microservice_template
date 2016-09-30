package services

import javax.inject.Inject

import play.api.libs.ws.WSClient
import system.Service

import scala.concurrent.ExecutionContext.Implicits.global

class Google @Inject()(val ws: WSClient) extends Service {
  override val serviceName: String = "google"

  lazy val apiKey = getValue("apiKey")

  lazy val url = getValue("url")

  lazy val getDestinationUrl = { (property: String, destination: String) => url + getValue("get-destinations") format(property, destination, apiKey) }

  def getDestination(property: String, destination: String) = service(getDestinationUrl(property, destination)){ res =>
    res
      .map(_.json)

  }
}
