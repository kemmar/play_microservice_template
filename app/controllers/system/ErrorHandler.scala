package controllers.system

import javax.inject._

import domains.Errors
import play.api._
import play.api.http.DefaultHttpErrorHandler
import play.api.http.Status._
import play.api.libs.json.Json.toJson
import play.api.mvc.Results._
import play.api.mvc._
import play.api.routing.Router

import scala.concurrent._

@Singleton
class ErrorHandler @Inject()(
                              env: Environment,
                              config: Configuration,
                              sourceMapper: OptionalSourceMapper,
                              router: Provider[Router]
                            ) extends DefaultHttpErrorHandler(env, config, sourceMapper, router) {

  override def onProdServerError(request: RequestHeader, exception: UsefulException) = {
    println(exception.cause)
    Future.successful(
      InternalServerError(toJson(Errors.UnknownError))
    )
  }

  override def onForbidden(request: RequestHeader, message: String) = {
    println(message)
    Future.successful(
      Forbidden(toJson(Errors.Forbidden))
    )
  }

  override def onNotFound(request: RequestHeader, message: String): Future[Result] = {
    println(message)
    Future.successful {
      NotFound(toJson(Errors.NotFound(request.path)))
    }
  }

  override def onBadRequest(request: RequestHeader, message: String): Future[Result] = {
    println(message)
    Future.successful {
      BadRequest(toJson(Errors.BadRequest(message)))
    }
  }

  override def onServerError(request: RequestHeader, exception: Throwable): Future[Result] = {
    println(exception)
    Future.successful {
      InternalServerError(toJson(Errors.UnknownError))
    }
  }

  def unprocessableEntity(request: RequestHeader, message: String): Future[Result] = {
    println(message)
    Future.successful {
      UnprocessableEntity(toJson(Errors.UnprocessableEntity(message)))
    }
  }

  override def onClientError(request: RequestHeader, statusCode: Int, message: String): Future[Result] = statusCode match {
    case BAD_REQUEST => onBadRequest(request, message)
    case FORBIDDEN => onForbidden(request, message)
    case NOT_FOUND => onNotFound(request, message)
    case clientError if statusCode >= 400 && statusCode < 500 => unprocessableEntity(request, message)
    case nonClientError => Future.successful {
      InternalServerError(toJson(Errors.UnknownError))
    }
  }
}