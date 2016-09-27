package domains

import play.api.libs.json.Json.format

case class Error(code: String, message: String)

object Error { implicit val formatError = format[Error] }

object Errors {

  val NotFound = { str: String => Error("endpoint.not.found",s"path not found: ${str}") }
  val UnprocessableEntity = { str: String => Error("unprocessable.entity", str) }
  val BadRequest = { str: String => Error("bad.Request", str) }
  val UnknownError = Error("unknown.error","unknown system error")
  val Forbidden = Error("unable.to.access","unable to access this endpoint")

}

