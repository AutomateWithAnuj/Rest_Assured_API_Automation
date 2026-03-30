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
import io.restassured.specification.RequestSpecification;

// TestNG → Used for test execution
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * This class demonstrates:
 * 1. How to send POST request using Rest Assured
 * 2. How to validate response using TestNG Hard & Soft assertions
 * 3. How to integrate Allure reporting annotations
 */
public class ApiTest29_TestNG_Assertions_With_RA {

    // RequestSpecification → Used to build HTTP request
    private RequestSpecification request;

    // Response → Stores actual response
    private Response response;

    /**
     * HARD ASSERT EXAMPLE
     * If assertion fails → execution stops immediately
     */
    @Owner("Anuj")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC#1 - Verify booking creation using Hard Assertions")
    @Test(enabled = false)
    public void testCreateBooking_HardAssert() {

        System.out.println("Start of Hard Assertion Test");

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

        // ======================= REQUEST =======================

        request = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .body(payload);

        // ======================= RESPONSE =======================

        response = request.when().post();

        // ======================= HARD ASSERTIONS =======================

        Assert.assertEquals(response.getStatusCode(), 200);

        Assert.assertEquals(response.jsonPath().getString("booking.firstname"), "James");

        Assert.assertEquals(response.jsonPath().getString("booking.lastname"), "Brown");

        Assert.assertEquals(response.jsonPath().getBoolean("booking.depositpaid"), true);

        Assert.assertNotNull(response.jsonPath().get("bookingid"));

        System.out.println("End of Hard Assertion Test");
    }


    /**
     * SOFT ASSERT EXAMPLE
     * If assertion fails → execution continues
     */
    @Owner("Anuj")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC#2 - Verify booking creation using Soft Assertions")
    @Test
    public void testCreateBooking_SoftAssert() {

        System.out.println("Start of Soft Assertion Test");

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

        // ======================= REQUEST =======================

        request = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .body(payload);

        // ======================= RESPONSE =======================

        response = request.when().post();

        // ======================= SOFT ASSERT =======================

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.getStatusCode(), 200);

        softAssert.assertEquals(response.jsonPath().getString("booking.firstname"), "James");

        softAssert.assertEquals(response.jsonPath().getString("booking.lastname"), "Brown");

        softAssert.assertEquals(response.jsonPath().getBoolean("booking.depositpaid"), true);

        softAssert.assertNotNull(response.jsonPath().get("bookingid"));

        System.out.println("End of Soft Assertion Test");

        // Important
        softAssert.assertAll();
    }
}
