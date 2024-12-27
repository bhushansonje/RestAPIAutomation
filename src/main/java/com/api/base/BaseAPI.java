
package com.api.base;

import io.restassured.RestAssured;

public class BaseAPI {
    public BaseAPI() {
        // Set base URI for the API
        RestAssured.baseURI = "https://api.coindesk.com";
    }

    // Common reusable methods for making API requests
    public static String getBaseURI() {
        return RestAssured.baseURI;
    }
}
