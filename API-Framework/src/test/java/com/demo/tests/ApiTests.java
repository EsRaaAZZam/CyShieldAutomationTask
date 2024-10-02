package com.demo.tests;

import com.demo.tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ApiTests extends BaseTest {

    @BeforeClass
    public void setup() {
        super.setup();
    }

    @Test
    @Description("Test to list users from API")
    @Severity(SeverityLevel.NORMAL)
    public void testListUsers() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/users?page=2")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("data").size() > 0);
    }

    @Test
    @Description("Test to create a new user")
    @Severity(SeverityLevel.CRITICAL)
    public void testCreateUser() throws IOException {
        String requestBody = new String(Files.readAllBytes(Paths.get("resources/config/CreateUser.json")));
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/users")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.jsonPath().getString("name"), "morpheus");
        Assert.assertEquals(response.jsonPath().getString("job"), "leader");
    }

    @Test
    @Description("Test to create a new user")
    @Severity(SeverityLevel.CRITICAL)
    public void testUpdateUser() throws IOException {


            String requestBody = new String(Files.readAllBytes(Paths.get("resources/config/UpdateUser.json")));

            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .when()
                    .put("/users/2")
                    .then()
                    .extract().response();

            Assert.assertEquals(response.getStatusCode(), 200);
            Assert.assertEquals(response.jsonPath().getString("name"), "morpheus");
            Assert.assertEquals(response.jsonPath().getString("job"), "zion resident");
        }

}
