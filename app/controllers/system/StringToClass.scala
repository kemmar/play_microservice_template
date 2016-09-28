package controllers.system

import play.api.libs.json.{Json, Reads}

object String {

  implicit class StringToClass(str: String) {

    implicit def stringToJson = Json.parse(str)

    def as[T](implicit fjs: Reads[T]) = stringToJson.as[T]

  }

}
