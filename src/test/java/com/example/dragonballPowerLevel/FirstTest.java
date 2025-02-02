package com.example.dragonballPowerLevel;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(classes = application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class FirstTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "http://localhost:" + port;
    }

    @Test
    public void testGetDragonBallData() {
        given()
                .when()
                .get("/api/dragonball/data")
                .then()
                .statusCode(200)
                .body("character", equalTo("Goku"))
                .body("powerLevel", equalTo("Over 9000!"));
    }

    @Test
    public void testPostDragonBallData() {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("character", "Vegeta");
        requestBody.put("powerLevel", "8500");

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/dragonball/data")
                .then()
                .statusCode(200)
                .body("message", equalTo("Vegeta has a power level of 8500"));
    }

    @Test
    public void testPutDragonBallData() {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("character", "Gohan");
        requestBody.put("powerLevel", "Super Saiyan 2");

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("/api/dragonball/data")
                .then()
                .statusCode(200)
                .body("message", equalTo("Gohan's power level has been updated to Super Saiyan 2"));
    }

    @Test
    public void testDeleteDragonBallData() {
        given()
                .when()
                .delete("/api/dragonball/data")
                .then()
                .statusCode(200)
                .body("message", equalTo("The Dragon Ball character data has been erased!"));
    }
}