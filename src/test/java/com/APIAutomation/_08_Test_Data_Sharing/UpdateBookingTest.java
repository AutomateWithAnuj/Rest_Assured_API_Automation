// ======================= CLASS 2 =======================
package com.APIAutomation.listeners;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class UpdateBookingTest {

    @Test
    public void updateBooking(ITestContext context) {

        int bookingId = (int) context.getAttribute("bookingId");

        String payload = "{\n" +
                "    \"firstname\": \"Anuj\",\n" +
                "    \"lastname\": \"Rajput\",\n" +
                "    \"totalprice\": 222,\n" +
                "    \"depositpaid\": false,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2023-01-01\",\n" +
                "        \"checkout\": \"2025-10-10\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Lunch\"\n" +
                "}";

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/" + bookingId)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .put()
                .then()
                .statusCode(200);
    }
}
