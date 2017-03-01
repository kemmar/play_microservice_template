package services

import javax.inject.Inject

import com.nowtv.njp.cs.domain.ProductCatalogue
import domains.cbs.EvaluationCatalogue
import play.api.cache.CacheApi
import play.api.libs.ws.WSClient
import system.Service

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.duration._

class CbsCatalogueService @Inject()(cache: CacheApi, val ws: WSClient) extends Service {

  override val serviceName: String = "cbs-catalogue-service"

  override val url: String = "https://lwscese02.gss.bskyb.com"
  private lazy val endpointPath: String = "/cbs-catalogue-evaluation-service/v1/catalogues/NOW_TV"

  private lazy val getCatalogue = url + endpointPath

  def getEvaluationCatalogue: Future[ProductCatalogue]  = cache.get[Future[ProductCatalogue]]("catalogue") match {
    case Some(e) => e onFailure { case _ => cache.remove("catalogue")}; e
    case None => {
      cache.set("catalogue", getCatalogueCall, 1.hour)
      getEvaluationCatalogue
    }
  }


  def getCatalogueCall: Future[ProductCatalogue] = {
    val k = service(getCatalogue) { res =>
      println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++1")
      println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++2")
      res
        .map(_.json.as[EvaluationCatalogue].transform)
    }

    k.onFailure { case e => println(e.toString) }

    k
  }

}
