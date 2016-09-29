package stubs

import com.github.tomakehurst.wiremock.client.WireMock._

class ZooplaStubOps extends StubBase(8010, 8011)  {

  def getProperties(area: String, key: String) = {
    wireMockServer.stubFor(get(urlEqualTo(s"/property_listings.json?area=$area&api_key=$key"))
      .willReturn(aResponse()
        .withStatus(200)
          .withHeader("content-type", "application/json")
          .withBody(
            """
              |{
              |  "country": "England",
              |  "result_count": 412505,
              |  "area_name": "",
              |  "listing": [
              |    {
              |      "image_caption": "",
              |      "status": "for_sale",
              |      "num_floors": "0",
              |      "listing_status": "sale",
              |      "num_bedrooms": "0",
              |      "agent_name": "The Crown London",
              |      "latitude": 51.510956,
              |      "agent_address": "313 Ballards Lane, London",
              |      "num_recepts": "0",
              |      "property_type": "Block of flats",
              |      "country": "England",
              |      "longitude": -0.186928,
              |      "first_published_date": "2016-03-14 13:39:01",
              |      "displayable_address": "Hyde Park, London W2",
              |      "price_modifier": "fixed_price",
              |      "street_name": "hyde park",
              |      "num_bathrooms": "0",
              |      "thumbnail_url": "",
              |      "description": "The Crown London is pleased to offer great Hotel right opposite Hyde Park.For viewings and more information please contact us. Loi is required.",
              |      "post_town": "London",
              |      "details_url": "http://www.zoopla.co.uk/for-sale/details/39806895?utm_source=v1:5qbLASTOWRTV_ECwL7oi5SLtKxhr1LLb&utm_medium=api",
              |      "agent_logo": "http://st.zoocdn.com/zoopla_static_agent_logo_(257368).png",
              |      "price_change": [
              |        {
              |          "direction": "",
              |          "date": "2016-03-14 13:38:06",
              |          "percent": "0%",
              |          "price": "120000000"
              |        }
              |      ],
              |      "short_description": "The Crown London is pleased to offer great Hotel right opposite Hyde Park. For viewings and more information please contact us. Loi is required. ",
              |      "agent_phone": "020 8022 2986",
              |      "outcode": "W2",
              |      "image_url": "",
              |      "last_published_date": "2016-06-10 10:18:19",
              |      "county": "London",
              |      "price": "120000000",
              |      "listing_id": "39806895"
              |    }
              |  ],
              |  "street": "",
              |  "town": "",
              |  "county": "",
              |  "postcode": ""
              |}
            """.stripMargin)
      ))
  }

  def getNoProperties(area: String, key: String) = {
    wireMockServer.stubFor(get(urlEqualTo(s"/property_listings.json?area=$area&api_key=$key"))
      .willReturn(aResponse()
        .withStatus(200)
        .withHeader("content-type", "application/json")
        .withBody(
          """
            |{
            |  "country": "England",
            |  "result_count": 412505,
            |  "area_name": "",
            |  "listing": [],
            |  "street": "",
            |  "town": "",
            |  "county": "",
            |  "postcode": ""
            |}
          """.stripMargin)
      ))
  }

}

object ZooplaStub extends ZooplaStubOps {
  def main(args: Array[String]): Unit = {
    ZooplaStub.getProperties("tw7", "testApiKey")
  }
}





