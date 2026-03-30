package com.APIAutomation._06_Test_Assertions;

// ======================= IMPORTS =======================

// Allure annotations → Used for reporting purpose
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

// Rest Assured → Used for API automation
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

// Hamcrest Matchers → Used for assertions
import org.hamcrest.Matchers;

// TestNG → Used for test execution
import org.testng.annotations.Test;

/**
 * This class demonstrates:
 * 1. How to send POST request using Rest Assured
 * 2. How to validate response using Hamcrest matchers
 * 3. How to integrate Allure reporting annotations
 */
public class ApiTest27_RA_Assertions {

    // RequestSpecification → Used to build the HTTP request
    private RequestSpecification request;

    // Response → Stores actual response received from server
    private Response response;

    // ValidatableResponse → Used for performing assertions
    private ValidatableResponse validatableResponse;

    /**
     * Test Case:
     * Verify that booking is created successfully
     * and important fields in response are correct.
     */
    @Owner("Anuj")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC#1 - Verify booking creation & bookingId is not null")
    @Test
    public void testCreateBooking_POST() {

        // ======================= TEST DATA =======================

        String payload = "{\n" +
                "    \"firstname\": \"James\",\n" +
                "    \"lastname\": \"Brown\",\n" +
                "    \"totalprice\": 111,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2018-01-01\",\n" +
                "        \"checkout\": \"2025-10-10\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";

        // ======================= BUILD REQUEST =======================

        request = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .body(payload);

        // ======================= SEND REQUEST =======================

        response = request.when().post();

        // ======================= VALIDATE STATUS CODE =======================

        validatableResponse = response.then()
                .statusCode(200);

        // ======================= VALIDATE RESPONSE BODY =======================

        validatableResponse
                .body("booking.firstname", Matchers.equalTo("James"))
                .body("booking.lastname", Matchers.equalTo("Brown"))
                .body("booking.depositpaid", Matchers.equalTo(true))
                .body("bookingid", Matchers.notNullValue());

    }
}
