package com.APIAutomation._02_RA_Concepts;

import org.testng.annotations.Test;

/*
This code demonstrates:
Java Execution happens step by step
Methods are called in sequence
Data can be passed from one step to another, but not in this method here
No structure, no chaining, no pattern is followed
*/
/*This no-pattern example helps understand API execution flow step by step. 
Rest Assured improves this by returning objects at each step, enabling chaining, readability, and maintainability.*/
public class ApiTest03_NoPattern {

    /**
     * Step 1 method
     * Purpose: Represents the first step in execution
     */
    public void step1() {
        System.out.println("Step 1"); // Output: Step 1
    }

    /**
     * Step 2 method
     * Purpose: Represents the second step in execution
     */
    public void step2() {
        System.out.println("Step 2"); // Output: Step 2
    }

    /**
     * Step 3 method
     * Purpose: Represents the third step and accepts input data
     *
     * @param param1 Input parameter passed from main method
     */
    public void step3(String param1) {
        System.out.println("Step 3"); // Output: Step 3
        // Note: param1 is passed to show parameter usage, not printed here
    }

    /**
     * Test method
     * Purpose: Entry point of execution using TestNG
     */
    @Test
    public void testNoPatternExecution() {

        // Creating object of the class to call non-static methods
        ApiTest03_NoPattern test = new ApiTest03_NoPattern();

        // Calling methods one by one in sequence
        test.step1();                 // Executes Step 1
        test.step2();                 // Executes Step 2
        test.step3("Anuj");           // Executes Step 3 with input parameter
        /*Step 1 → Setup
        Step 2 → Action
        Step 3 → Validation*/
    }
}

/*
given() → returns RequestSpecification
when()  → returns Response
then()  → returns ValidatableResponse
In Rest Assured, each method returns an object, 
and that returned object is implicitly passed to the next method in the chain.
*/
