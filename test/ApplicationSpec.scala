import org.scalatestplus.play._
import play.api.test._
import play.api.test.Helpers._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
class ApplicationSpec extends PlaySpec with OneAppPerTest {

  "Routes" should {

    "send 404 on a bad request" in  {
      val badRequest = route(app, FakeRequest(GET, "/boum")).get

      status(badRequest) mustBe NOT_FOUND
      contentType(badRequest) mustBe Some("application/json")
      contentAsString(badRequest) mustBe """{"code":"endpoint.not.found","message":"path not found: /boum"}"""
    }

    "send 400 on a if body is incorrect" in  {
      val badRequest = route(app, FakeRequest(PUT, "/", FakeHeaders(Seq("content-type" -> "application/json")), "{}")).get

      status(badRequest) mustBe BAD_REQUEST
      contentType(badRequest) mustBe Some("application/json")
      contentAsString(badRequest).contains("bad.Request") mustBe true
    }

    "send 422 on a unprocessable entity if content type header is missing" in  {
      val unprocessableEntity = route(app, FakeRequest(PUT, "/", FakeHeaders(), "{}")).get

      status(unprocessableEntity) mustBe UNPROCESSABLE_ENTITY
      contentType(unprocessableEntity) mustBe Some("application/json")
      contentAsString(unprocessableEntity) mustBe """{"code":"unprocessable.entity","message":"Expecting text/json or application/json body"}"""
    }

  }

  "HomeController" should {

    "render the index page" in {
      val home = route(app, FakeRequest(GET, "/")).get

      status(home) mustBe OK
      contentType(home) mustBe Some("application/json")
      contentAsString(home) mustBe """{"str":"hello world"}"""
    }

  }

}
