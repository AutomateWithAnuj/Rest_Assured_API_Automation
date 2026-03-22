# 🚀 rest-assured-api-automation

**Author:** Anuj Rajput  
**Repository Name:** AutomatedAPITestingPrograms  
**Language:** Java  
**Frameworks & Tools:** RestAssured, TestNG, Maven, Allure Report  

---

## 📘 Overview

This repository contains a comprehensive collection of **API Automation Testing programs** using **RestAssured** and **TestNG**. It serves as a complete learning guide for API automation testing, covering everything from basic REST API calls to advanced testing concepts, assertions, payload management, and reporting.

The repository is organized in a structured manner with each package representing specific API testing concepts and techniques.

---

## 🚀 Tech Stack for API Testing

| Technology | Description |
|------------|-------------|
| **Java** | Programming language for API automation |
| **RestAssured** | Java DSL for testing RESTful APIs |
| **TestNG** | Test framework for organizing and executing test cases |
| **Maven** | Build automation tool to manage dependencies |
| **Allure Report** | Reporting framework for detailed test execution reports |
| **GIT** | Version control system to manage codebase |
| **JSON** | Data format for API requests and responses |
| **HTTP Methods** | GET, POST, PUT, PATCH, DELETE |
| **Assertions** | RestAssured, TestNG, and AssertJ assertions |

---

## 📚 Topics Covered

### 🔹 1. RestAssured Basics
- Basic GET requests
- RestAssured setup and configuration
- Response validation basics

### 🔹 2. RestAssured Concepts
- Builder Pattern implementation
- Running multiple test cases
- Code organization patterns

### 🔹 3. TestNG Integration & Reporting
- TestNG annotations and configuration
- Running multiple test cases with TestNG
- Allure Report integration
- TestNG XML configurations

### 🔹 4. HTTP Methods Implementation
- **GET Requests**: BDDStyle and Non-BDDStyle
- **POST Requests**: BDDStyle and Non-BDDStyle  
- **PUT Requests**: BDDStyle and Non-BDDStyle
- **PATCH Requests**: BDDStyle and Non-BDDStyle
- **DELETE Requests**: BDDStyle and Non-BDDStyle

### 🔹 5. TestNG Advanced Features
- Runnable Test Cases vs Normal Methods
- BeforeTest and AfterTest annotations
- Test Priority management
- Test Groups configuration
- DependsOnMethod functionality
- Parameterized tests
- Enabled/Disabled tests
- AlwaysRun behavior
- InvocationCount usage
- Complete annotations overview

### 🔹 6. Test Assertions
- RestAssured built-in assertions
- TestNG assertions
- Combined RA-TestNG-AssertJ assertions
- Response validation techniques

### 🔹 7. Payload Management
- Class-based payloads
- HashMap payload management
- String payloads
- JSON payload creation and management

---

## 🗂 Complete Folder Structure

```text
AutomatedAPITestingPrograms/
│
├── 📁 src/test/java/com/APIAutomation/
│   ├── _01_RA_Basics/
│   │   ├── ApiTest01_BasicGet.java
│   │   └── ApiTest02_BasicGet.java
│   │
│   ├── _02_RA_Concepts/
│   │   ├── ApiTest03_NoPattern.java
│   │   ├── ApiTest04_BuilderPattern.java
│   │   └── ApiTest05_RunDupMulTestCases.java
│   │
│   ├── _03_TestNG_AllureReport/
│   │   ├── ApiTest06_RunMulTestCases.java
│   │   └── ApiTest07_RunMulTestCases.java
│   │
│   ├── _04_RA_HTTP_Methods/
│   │   ├── GET/
│   │   │   ├── ApiTest08_GET_BDDStyle.java
│   │   │   └── ApiTest09_GET_NonBDDStyle.java
│   │   ├── POST/
│   │   │   ├── ApiTest10_POST_BDDStyle.java
│   │   │   └── ApiTest11_POST_NonBDDStyle.java
│   │   ├── PUT/
│   │   │   └── ApiTest12_PUT_NonBDDStyle.java
│   │   ├── PATCH/
│   │   │   └── ApiTest13_PATCH_NonBDDStyle.java
│   │   └── DELETE/
│   │       └── ApiTest14_DELETE_NonBDDStyle.java
│   │
│   ├── _05_TestNG_Examples/
│   │   ├── ApiTest15_RunnableTC_vs_NormalMethod.java
│   │   ├── ApiTest16_BeforeTest_AfterTest.java
│   │   ├── ApiTest17_Priority.java
│   │   ├── ApiTest18_Groups.java
│   │   ├── ApiTest19_DependsOnMethod.java
│   │   ├── ApiTest20_Parameter.java
│   │   ├── ApiTest21_Enabled.java
│   │   ├── ApiTest22_AlwaysRun.java
│   │   ├── ApiTest23_AlwaysRun.java
│   │   ├── ApiTest24_InvocationCount.java
│   │   ├── ApiTest25_All_Annotations.java
│   │   └── ApiTest26_All_Annotations_Review.java
│   │
│   ├── _06_Test_Assertions/
│   │   ├── ApiTest27_RA_Assertions.java
│   │   ├── ApiTest28_TestNG_Assertions.java
│   │   └── ApiTest29_RA_TestNG_AssertJ_Assertions.java
│   │
│   └── _07_Payload_Management/
│       ├── Class/
│       ├── Hashmap/
│       └── String/
│
├── 📁 src/test/resources/
│   ├── testng.xml
│   ├── testng_ApiTest06.xml
│   ├── testng_ApiTest07.xml
│   ├── testng_ApiTest18_Groups_Sanity.xml
│   ├── testng_ApiTest20_Parameter_chrome.xml
│   └── testng_ApiTest20_Parameter_firefox.xml
│
├── 📁 allure-results/
├── 📁 .idea/
├── .gitignore
├── README.md
└── pom.xml
