package services

import controllers.system.Config

class Zoopla extends Config {
  override val serviceName: String = "zoopla"
  lazy val apiKey = getValue("apiKey")
}
