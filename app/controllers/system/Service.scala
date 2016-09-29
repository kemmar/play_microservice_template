package controllers.system

import play.api.libs.ws.{WSClient, WSRequest, WSResponse}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

abstract class Service(implicit ws: WSClient) extends Config {
  val serviceName: String
  lazy val path: String = serviceName

  val url: String

  def service[T](url: String, method: String = "GET") = (send: Future[WSResponse] => Future[T]) => send {
      LogRequest {
        ws
          .url(url)
          .withHeaders(("Accept", "application/json"))
          .withMethod(method.toUpperCase)
      }
        .execute()
        .map(LogResponse)
    }


  def LogResponse(res: WSResponse) = {
    println(
      s"""
         |Headers: ${res.allHeaders.mkString(",")}
         |Status: ${res.status}:  ${res.statusText}
      """.stripMargin)
    res
  }

  def LogRequest(req: WSRequest) = {
    println(
      s"""
         |Headers: ${req.headers.mkString(",")}
         |Request: ${req.method}:  ${req.url}
      """.stripMargin)
    req
  }
}
