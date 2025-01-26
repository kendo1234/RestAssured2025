import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FirstTest {
    static {
        RestAssured.baseURI = "http://localhost:3000"; // Base URI for the mock server
    }

    @Test
    public void testGetEndpoint() {
        given()
                .when()
                .get("/api/data")
                .then()
                .statusCode(200)
                .body("message", equalTo("Hello, World!"));
    }

    @Test
    public void testPostEndpoint() {
        given()
                .contentType("application/json")
                .body("{\"name\":\"Alice\"}")
                .when()
                .post("/api/data")
                .then()
                .statusCode(200)
                .body("message", equalTo("Hello, Alice!"));
    }

    @Test
    public void testResponseLogging() {
        Response response =
                given()
                        .when()
                        .get("/api/data")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        System.out.println("Response Body: " + response.asString());
    }
}
