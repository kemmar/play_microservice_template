import com.google.inject.AbstractModule
import services.{Google, Zoopla}

class Module extends AbstractModule {

  override def configure() = {
    bind(classOf[Zoopla]).asEagerSingleton()

    bind(classOf[Google]).asEagerSingleton()
  }

}
