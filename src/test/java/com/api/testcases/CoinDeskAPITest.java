
package com.api.testcases;

import com.api.base.BaseAPI;
import com.api.utils.JSONUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CoinDeskAPITest extends BaseAPI {

    @Test
    public void testCurrentPrice() {
        // Send the GET request to the endpoint
        Response response = RestAssured.given()
                                        .when()
                                        .get("/v1/bpi/currentprice.json");

        // Assert that the response code is 200
        Assert.assertEquals(response.statusCode(), 200);

        // Get the 'bpi' object from the response
        String bpiResponse = response.jsonPath().getString("bpi");

        // Verify there are 3 BPIs (USD, GBP, EUR)
        Assert.assertTrue(bpiResponse.contains("USD"));
        Assert.assertTrue(bpiResponse.contains("GBP"));
        Assert.assertTrue(bpiResponse.contains("EUR"));

        // Verify that the GBP description is 'British Pound Sterling'
        String gbpDescription = JSONUtils.extractValueFromJson(response.asString(), "bpi.GBP.description");
        Assert.assertEquals(gbpDescription, "British Pound Sterling");
    }
}
