package com.APIAutomation._04_RA_HTTP_Methods.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

/**
 * This class demonstrates how to perform a POST request
 * using Rest Assured in NON-BDD style.
 *
 * API Used:
 * POST https://restful-booker.herokuapp.com/auth
 *
 * Purpose:
 * - Send username & password as JSON payload
 * - Validate that the response status code is 200 (OK)
 */
public class ApiTest11_POST_NonBDDStyle {

    // RequestSpecification is used to build the HTTP request
    private RequestSpecification request;

    // Response stores the raw response received from the server
    private Response response;

    // ValidatableResponse is used for assertions/validations
    private ValidatableResponse validatableResponse;

    /**
     * Test method to validate the authentication API using the POST method
     */
    @Test
    public void testPostAuth() {

        // -------------------- Request Payload --------------------
        // JSON body required by the /auth API
        String payload = "{\n" +
                "  \"username\" : \"admin\",\n" +
                "  \"password\" : \"password123\"\n" +
                "}";

        // -------------------- PART 1: Pre-condition --------------------
        // Preparing the request: base URI, base path, headers, and body
        System.out.println("<---------Part 1 : Request Preparation----------->"); 
        // Console Output: Indicates start of request setup

        request = RestAssured.given();                 // Initialize request builder
        request.baseUri("https://restful-booker.herokuapp.com"); // Base URL of the API
        request.basePath("/auth");                     // Endpoint path
        request.contentType(ContentType.JSON);         // Inform server that payload is JSON
        request.body(payload);                         // Attach JSON payload to request
        request.log().all();                           // Console Output: Logs complete request details

        // -------------------- PART 2: Action --------------------
        // Sending the POST request to the server
        System.out.println("<---------Part 2 : HTTP Request----------->"); 
        // Console Output: Indicates API call execution

        //.when() is used only before HTTP method, while request and response objects can be used independently.
        
        response = request
                .when()                                // Specifies when the request is sent
                .post();                               // Executes POST request

        // response = request.when(); // ❌ wrong type
        // response.post();           // ❌ invalid

        // -------------------- PART 3: Verification --------------------
        // Validating the response received from the server
        System.out.println("<---------Part 3 : Response Validation----------->"); 
        // Console Output: Indicates start of validation

        validatableResponse = response.then();         // Convert response for validation
        validatableResponse.log().all();                // Console Output: Logs full response body + headers
        validatableResponse.statusCode(200);            // Assertion: API must return HTTP 200 OK
    }
}
