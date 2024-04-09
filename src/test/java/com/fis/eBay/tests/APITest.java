package com.fis.eBay.tests;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class APITest {
    @Test
    public void testBPIInformation() {
        given()
                .when()
                .get("https://api.coindesk.com/v1/bpi/currentprice.json")
                .then()
                .statusCode(200)
                .body("bpi.size()", equalTo(3))
                .body("bpi.USD", notNullValue())
                .body("bpi.GBP", notNullValue())
                .body("bpi.EUR", notNullValue())
                .body("bpi.GBP.description", equalTo("British Pound Sterling"));
    }
}
