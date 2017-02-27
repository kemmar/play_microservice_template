import com.google.inject.AbstractModule
import services.CbsCatalogueService

class Module extends AbstractModule {

  override def configure() = {
    bind(classOf[CbsCatalogueService]).asEagerSingleton()

  }

}
