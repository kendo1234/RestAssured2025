# Rest Assured API Testing Project

This project demonstrates how to use the **Rest Assured** framework for API testing, including setting up a Gradle-based Java project, mocking APIs, and writing GET/POST tests.

## Features
- Mock API with GET and POST endpoints.
- Automated API tests using Rest Assured.
- Gradle-based project setup.

## Prerequisites
- **Java Development Kit (JDK):** Version 17 or later.
- **Gradle:** For dependency management and test execution.
- **IntelliJ IDEA** or another Java IDE.

## Quick Start

### 1. Clone the Repository
```bash
git clone <repository-url>
cd <repository-folder>
```

### 2. Set Up the Environment
1. Ensure JDK and Gradle are installed.
2. Run `gradle build` to download dependencies.

### 3. Run the Mock API
(Optional if testing against a real API.)
```bash
node mock-api.js
```

### 4. Run the Tests
Run the tests using Gradle:
```bash
gradle test
```

## Project Structure
- **`src/test/java`**: Contains the test cases written with Rest Assured.
- **`build.gradle`**: Dependency and project configuration.

## Example Test Case
Sample GET test:
```java
@Test
public void testGetEndpoint() {
    given()
        .when()
            .get("/api/data")
        .then()
            .statusCode(200)
            .body("message", equalTo("Hello, World!"));
}
```

