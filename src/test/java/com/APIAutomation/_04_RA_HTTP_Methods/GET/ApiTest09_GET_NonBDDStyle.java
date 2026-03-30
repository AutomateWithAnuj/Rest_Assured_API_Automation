package com.APIAutomation._04_RA_HTTP_Methods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

/**
 * This class demonstrates GET API testing
 * using Rest Assured NON-BDD (classic) style.
 *
 * Here, request creation, execution, and validation
 * are handled in separate steps for better clarity.
 */
public class ApiTest09_GET_NonBDDStyle {

    // RequestSpecification is used to build the request
    private RequestSpecification request;

    // Response holds the raw API response
    private Response response;

    // ValidatableResponse is used for assertions
    private ValidatableResponse validatableResponse;

    /**
     * Positive test case
     * Scenario: Valid Indian pincode
     */
    @Test
    public void test_GET_NonBDD_Positive_TC1() {

        String pincode = "475673"; // Valid pincode input

        // ---------- GIVEN ----------
        request = RestAssured.given(); // Initialize request object
        request.baseUri("https://api.zippopotam.us"); // Set base URL
        request.basePath("/IN/" + pincode); // Set endpoint with pincode

        // ---------- WHEN ----------
        response = request.log().all().when().get();
        // .log().all() before .when() logs request details (recommended)
        // request.when().log().all().get(); → Not recommended, unclear logging order
        // request.when().get().log().all(); → Invalid for request logging, used for response logging after .then()
        //when() prepares execution, but HTTP method like .get() or .post() is required to send the request and receive response.        
        
        // Console Output: Full request details and response received

        System.out.println(response.statusCode());
        // Console Output: Prints HTTP status code (expected: 200)

        // ---------- THEN ----------
        validatableResponse = response.then(); // Prepare response for validation
        validatableResponse.log().all().statusCode(200);
        // Console Output: Full response body and status code validation
    }

    /**
     * Negative test case
     * Scenario: Invalid special character as pincode
     */
    @Test
    public void test_GET_NonBDD_Negative_TC2() {

        String pincode = "@"; // Invalid pincode input

        // ---------- GIVEN ----------
        request = RestAssured.given();
        request.baseUri("https://api.zippopotam.us/");
        request.basePath("/IN/" + pincode);

        // ---------- WHEN ----------
        response = request.when().log().all().get();
        // Console Output: Request + response details

        System.out.println(response.statusCode());
        // Console Output: Prints HTTP status code (expected: 404)

        // ---------- THEN ----------
        validatableResponse = response.then();
        validatableResponse.log().all().statusCode(404);
        // Console Output: Error response with status validation
    }

    /**
     * Negative test case
     * Scenario: Blank space as pincode
     */
    @Test
    public void test_GET_NonBDD_Negative_TC3() {

        String pincode = " "; // Blank input

        // ---------- GIVEN ----------
        request = RestAssured.given();
        request.baseUri("https://api.zippopotam.us/");
        request.basePath("/IN/" + pincode);

        // ---------- WHEN ----------
        response = request.when().log().all().get();
        // Console Output: Request + response details

        System.out.println(response.statusCode());
        // Console Output: Prints HTTP status code (expected: 404)

        // ---------- THEN ----------
        validatableResponse = response.then();
        validatableResponse.log().all().statusCode(404);
        // Console Output: Error response with status validation
    }
}
