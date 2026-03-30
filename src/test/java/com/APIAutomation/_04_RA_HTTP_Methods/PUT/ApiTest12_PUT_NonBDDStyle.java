package com.APIAutomation._04_RA_HTTP_Methods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

/**
 * This class demonstrates how to perform a PUT request
 * using Rest Assured in Non-BDD style.
 *
 * Purpose:
 * - Update an existing booking using bookingId
 * - Authenticate using Basic Auth + token cookie
 * - Validate response status code
 * - first checking the URL - https://restful-booker.herokuapp.com/booking/1180 - got this output - I'm a Teapot
 */
public class ApiTest12_PUT_NonBDDStyle {

    // Used to build and configure the HTTP request
    private RequestSpecification request;

    // Holds the raw HTTP response returned by the server
    private Response response;

    // Used to validate response (status code, body, etc.)
    private ValidatableResponse validatableResponse;

    /**
     * Test method to update an existing booking
     * using PUT HTTP method (Non-BDD style).
     */
    @Test
    public void test_PUT_NonBDDStyle_Update_Booking() {

         // first create the Strings for what data you want to send in the request
       
        // Token received earlier from /auth API (used for authorisation)
        String cookieToken = "83eef0426f058f8";

        // Existing booking ID that we want to update
        String bookingId = "1180";

        // PUT request payload (updated booking details)
        // This JSON body is sent to the server to update the booking
        // whatever we send the payload will always be sent in json only
        String putPayload = "{\n" +
                "  \"firstname\" : \"James\",\n" +
                "  \"lastname\" : \"Brown\",\n" +
                "  \"totalprice\" : 111,\n" +
                "  \"depositpaid\" : true,\n" +
                "  \"bookingdates\" : {\n" +
                "    \"checkin\" : \"2018-01-01\",\n" +
                "    \"checkout\" : \"2019-01-01\"\n" +
                "  },\n" +
                "  \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        // Step 1: Create RequestSpecification object
        // given() initialises request building in Rest Assured
        request = RestAssured.given();

        // Base URI of the application under test
        request.baseUri("https://restful-booker.herokuapp.com");

        // Base path with booking ID to update a specific booking
        request.basePath("/booking/" + bookingId);

        // Attach JSON payload to the request body
        // Even though the payload is written as a Java String, it contains valid JSON text,
        // and Rest Assured sends it as JSON when Content-Type is application/json.
        request.body(putPayload);

        // Set Content-Type header to JSON
        // This tells the server that the request body is in JSON format
        request.contentType(ContentType.JSON);

        // Basic Authentication (username & password)
        // Required by Restful Booker for PUT operation
        // preemptive() sends Basic Auth credentials in the first request itself, avoiding an extra 401 challenge and improving performance.
        request.auth().preemptive().basic("admin", "password123");

        // PUT operations require authentication. While the API supports both Basic Auth and token-based auth, 
        // using both together ensures stability and avoids intermittent authorization failures.
       
        // Token authentication using cookie
        // Token is mandatory along with Basic Auth for update
        request.cookie("token", cookieToken);

        // Step 2: Send PUT request
        // log().all() prints complete request details on the console
        response = request
                    .log().all()   // Logs request details
                    .when()
                    .put();

        // Step 3: Validate response
        validatableResponse = response
                .then()
                .log().all()   // Console Output: Status, headers, body of response
                .statusCode(200); // Validate that booking update is successful
    }
}
