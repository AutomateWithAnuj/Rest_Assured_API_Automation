package com.APIAutomation._01_RA_Basics;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import java.util.Scanner;

/**
 * This class demonstrates a basic GET API test using Rest Assured.
 * It accepts a pincode from the user and validates the API response.
 */
public class ApiTest02_BasicGet {

    /**
     * Test method – execution starts from here.
     * This method is executed using TestNG @Test annotation.
     */
    @Test
    public void testGetPincodeDetails() {

        // Scanner is used to take user input from the console
        Scanner scanner = new Scanner(System.in);

        // Prompt shown on console asking user to enter a pincode
        System.out.println("Enter the pincode!"); // Console output

        // Reads the pincode entered by the user
        String pincode = scanner.next();

        /*
         * REST Assured follows the Builder Pattern:
         * given() → prerequisites (URI, headers, auth, body)
         * when()  → action (HTTP method)
         * then()  → validations (status code, response, etc.)
         */
        RestAssured
            .given()
                // Base URI of the API (common part of the URL)
                .baseUri("https://api.zippopotam.us")

                // Base Path contains country code and user-entered pincode
                .basePath("/IN/" + pincode)
            .when()
                // Sends a GET request to the constructed URL
                .get()
            .then()
                // Prints full request and response details in console
                .log().all() // Console output: status, headers, response body

                // Validates that the response status code is 200 (OK)
                .statusCode(200); // Test passes only if status code is 200

        // Closing the scanner to release system resources
        scanner.close();
    }
}
