package com.APIAutomation._02_RA_Concepts;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

/**
 * This class demonstrates a drawback of using BDD style directly
 * when running multiple test cases with different data.
 *
 * Drawback:
 * - The same given() → when() → then() code is repeated again and again
 * - Only test data (pincode) is changing
 * - This reduces reusability and increases maintenance effort
 */
public class ApiTest05_RunDupMulTestCases {

    @Test
    public void testRunDuplicateMultipleTestCases() {

        // ---------------- POSITIVE TEST CASE ----------------
        String pincode = "110048"; // valid pincode

        RestAssured
                .given() // given(): used to prepare the request
                .baseUri("https://api.zippopotam.us") // setting base URI
                .basePath("/IN/" + pincode) // setting base path using pincode
                .when() // when(): triggers the HTTP action
                .get() // sending GET request
                .then() // then(): used for validation
                .log().all() // prints full response on console
                .statusCode(200); // expected HTTP status code is 200 (PASS)

        // ---------------- NEGATIVE TEST CASE ----------------
        pincode = "@"; // invalid pincode

        RestAssured
                .given() // same request preparation code repeated
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all() // prints error response on console
                .statusCode(200); // still validating 200 (will FAIL logically)

        // ---------------- NEGATIVE TEST CASE ----------------
        pincode = " "; // blank pincode

        RestAssured
                .given() // same BDD flow repeated again
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all() // prints error response on console
                .statusCode(200); // validation remains same

        /*
         * Key Observation / Drawback of BDD Style Here:
         * - given(), baseUri(), basePath(), when(), get(), then() are duplicated
         * - Only input data (pincode) is changing
         * - This violates the DRY (Don't Repeat Yourself) principle
         * - A better approach would be to reuse via methods, loops, or data-driven tests
         */
    }
}
