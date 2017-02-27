package services

import javax.inject.Inject

import com.nowtv.njp.cs.domain.cbs.EvaluationCatalogue
import play.api.libs.ws.WSClient
import system.Service

import scala.concurrent.ExecutionContext.Implicits.global

class CbsCatalogueService @Inject()(val ws: WSClient) extends Service {

  override val serviceName: String = "cbs-catalogue-service"

  override val url: String = getValue("url")
  private lazy val endpointPath: String = "/v1/catalogues/NOW_TV"

  private lazy val getCatalogue = url + endpointPath

  def getEvaluationCatalogue = service(getCatalogue){ res =>
    res
      .map(_.json.as[EvaluationCatalogue].transform)
  }

}
