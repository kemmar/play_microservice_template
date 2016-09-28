package controllers.system

import com.typesafe.config.ConfigFactory

trait Config {
  val path: String

  lazy val config = ConfigFactory.load().getConfig(path)

  def getValue(str: String) = config.getString(str)
}
