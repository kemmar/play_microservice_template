import javax.inject._
import play.api._
import play.api.http.HttpFilters


@Singleton
class Filters @Inject() (
  env: Environment) extends HttpFilters {

  override val filters = {
    if (env.mode == Mode.Dev) Seq() else Seq.empty
  }

}
