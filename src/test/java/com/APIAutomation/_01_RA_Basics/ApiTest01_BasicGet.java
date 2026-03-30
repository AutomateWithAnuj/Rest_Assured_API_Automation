package com.APIAutomation._01_RA_Basics;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

/**
 * This class demonstrates a very basic REST Assured GET API test.
 * It sends a GET request to the /ping endpoint and validates the response status code.
 */
public class ApiTest01_BasicGet {

    /**
     * Test method – execution starts from here.
     * This method is executed using TestNG @Test annotation.
     */
    @Test
    public void testBasicGetRequest() {

        // RestAssured.given() → Used to build the request specification
        RestAssured
            .given()
                // Base URI of the API endpoint we want to test
                // This endpoint is used to check whether the server is up or not
                .baseUri("https://restful-booker.herokuapp.com/ping")
            .when()
                // HTTP method to be executed
                // Here we are sending a GET request
                .get()
                // Other methods like .post(), .put(), .patch(), .delete() can also be used here
            .then()
                // Logs complete request and response details to the console
                // Useful for debugging and understanding API behavior
                .log().all()   // Console output: headers, body, status line, etc.

                // Validates that the response status code is 201
                // Test will fail if the actual status code is not 201
                .statusCode(201); // Console validation result
    }
}
