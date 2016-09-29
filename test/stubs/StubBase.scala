package stubs

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.core.WireMockConfiguration._

class StubBase(port: Int, securePort: Int) {
  val wireMockServer = new WireMockServer(wireMockConfig().port(port).httpsPort(securePort))
  wireMockServer.start()
}
