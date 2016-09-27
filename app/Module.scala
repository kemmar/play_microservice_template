import com.google.inject.AbstractModule
import services.Zoopla

class Module extends AbstractModule {

  override def configure() = {
    bind(classOf[Zoopla]).asEagerSingleton()
  }

}
