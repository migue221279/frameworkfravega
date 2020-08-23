package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseApi {

    public static Response doGetRequest(String endpoint) {
        RestAssured.defaultParser = Parser.JSON;
        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        when().get(endpoint).
                        then().contentType(ContentType.JSON).extract().response();
        }

        public Response PathParamExample(String id) {
            RestAssured.baseURI = "https://api.openbrewerydb.org/breweries/";
            Response response = null;
            try {
                response = RestAssured.given()
                        .pathParam("id", id)
                        .when()
                        .get("/{id}");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return response;
        }


}
