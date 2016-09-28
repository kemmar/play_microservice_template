package controllers.system

import play.api.libs.ws.WSClient

abstract class Service(implicit ws: WSClient) extends Config {
  val serviceName: String
  lazy val path: String = serviceName

  val url: String

  lazy val service = ws

}
