package com.demo.tests;

import io.restassured.RestAssured;

public class BaseTest {
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/api";
    }
}
