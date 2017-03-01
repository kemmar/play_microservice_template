//import domains.Properties
//import org.scalatest.BeforeAndAfter
//import org.scalatestplus.play._
//import play.api.test.Helpers._
//import play.api.test._
//import stubs.ZooplaStub
//
//class ApplicationSpec extends PlaySpec with OneAppPerTest with BeforeAndAfter {
//
//  before {
//    ZooplaStub.wireMockServer.start()
//  }
//
//  "Routes" should {
//
//    "send 404 on a bad request" in {
//      val badRequest = route(app, FakeRequest(GET, "/boum")).get
//
//      status(badRequest) mustBe NOT_FOUND
//      contentType(badRequest) mustBe Some("application/json")
//      contentAsString(badRequest) mustBe """{"code":"endpoint.not.found","message":"path not found: /boum"}"""
//    }
//
//  }
//
//  "ZooplaController" should {
//
//    "zoopla service is down" in {
//      ZooplaStub.wireMockServer.stop()
//
//      val resp = route(app, FakeRequest(GET, "/area/tw8")).head
//
//        status(resp) mustBe SERVICE_UNAVAILABLE
//        contentType(resp) mustBe Some("application/json")
//    }
//
//    "get properties in area given" in {
//      ZooplaStub.getProperties("tw7", "testApiKey")
//
//      val resp = route(app, FakeRequest(GET, "/area/tw7")).get
//        status(resp) mustBe OK
//        contentType(resp) mustBe Some("application/json")
//
//        val properties = contentAsJson(resp).as[Properties]
//
//        properties.listing.head.price mustBe 120000000
//        properties.listing.size mustBe 1
//
//        properties.country mustBe "England"
//        properties.listing.head.agent_phone mustBe "020 8022 2986"
//    }
//
//    "no properties in area given" in {
//      ZooplaStub.getNoProperties("tw8", "testApiKey")
//
//      route(app, FakeRequest(GET, "/area/tw8")).map { resp =>
//        status(resp) mustBe OK
//        contentType(resp) mustBe Some("application/json")
//
//        val properties = contentAsJson(resp).as[Properties]
//
//        properties.country mustBe "England"
//        properties.listing.size mustBe 0
//      }
//
//    }
//
//  }

//}
