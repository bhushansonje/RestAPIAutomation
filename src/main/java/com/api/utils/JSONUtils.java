
package com.api.utils;

import io.restassured.path.json.JsonPath;

public class JSONUtils {
    // Method to extract a value from JSON response based on the JSONPath
    public static String extractValueFromJson(String jsonResponse, String jsonPath) {
        JsonPath path = new JsonPath(jsonResponse);
        return path.getString(jsonPath);
    }
}
