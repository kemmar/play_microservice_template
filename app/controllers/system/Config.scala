package controllers.system

import com.typesafe.config.ConfigFactory

trait Config {
  val serviceName: String

  lazy val config = ConfigFactory.load().getConfig(serviceName)

  def getValue(str: String) = config.getString(str)

}
