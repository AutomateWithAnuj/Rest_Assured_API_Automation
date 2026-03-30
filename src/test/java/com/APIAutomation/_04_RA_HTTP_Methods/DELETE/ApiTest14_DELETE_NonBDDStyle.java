package com.APIAutomation._04_RA_HTTP_Methods.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

/**
 * This class demonstrates how to perform a DELETE request
 * using Rest Assured in NON-BDD style.
 *
 * API Used:
 * DELETE https://restful-booker.herokuapp.com/booking/{bookingId}
 *
 * Purpose:
 * - Delete an existing booking using bookingId in URL
 * - Authenticate using Basic Auth and token (cookie)
 * - Validate successful deletion via status code
 */
public class ApiTest14_DELETE_NonBDDStyle {

    // Used to build and configure the HTTP request
    private RequestSpecification request;

    // Holds the raw HTTP response returned by the server
    private Response response;

    // Used to validate response (status code, body, headers)
    private ValidatableResponse validatableResponse;

    /**
     * Test method to delete a booking using NON-BDD style
     */
    @Test
    public void testDeleteBooking() {

        // Token received from auth API (required by DELETE booking API)
        String cookieToken = "8d8d22c8e4ced60";

        // Booking ID that will be deleted (passed in URL)
        String bookingId = "609";

        // -------------------- PART 1: Pre-condition --------------------
        // Preparing request: base URI, endpoint, auth, headers
        request = RestAssured.given();                         //Initialise request builder
        request.baseUri("https://restful-booker.herokuapp.com"); // Base URL of the API
        request.basePath("/booking/" + bookingId);              // Booking delete endpoint
        request.contentType(ContentType.JSON);                  // Inform server request uses JSON

        // Basic authentication (username & password)
        request.auth()
               .preemptive()
               .basic("admin", "password123");                  // Required for delete permission

        // Token passed as cookie for authorization
        request.cookie("token", cookieToken);                   // Auth token sent as cookie

        // -------------------- PART 2: Action --------------------
        // Sending DELETE request to server
        response = request
                .when()                                         // Switch to execution phase
                .delete();                                      // Executes DELETE request
                .log().all()                                    // Console Output: Logs full request


        // -------------------- PART 3: Verification --------------------
        // Validating server response
        validatableResponse = response.then()
                .log().all()                                    // Console Output: Logs full response
                .statusCode(201);                                // Assertion: Booking deleted successfully
    }
}
