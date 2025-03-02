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

### 3. Run the Mock API (DEPRECATED)
(Optional if testing against a real API.)
```bash
node mock-api.js
```

### 4. Access Swagger Documentation
Once the service is running, open the following URLs:
- **Swagger UI:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **OpenAPI JSON:** [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)


### 5. Run the Tests
Run the tests using Gradle:
```bash
./gradlew test
```

## Project Structure
- **`java/com/example/dragonballPowerLevel`**: Contains the test cases written with Rest Assured.
- **`build.gradle`**: Dependency and project configuration.

## Example Test Case
Sample GET test:
```java
    @Test
    public void testGetDragonBallData() {
    given()
            .when()
            .get("/api/dragonball/data")
            .then()
            .statusCode(200)
            .body("character", equalTo("Goku"))
            .body("powerLevel", equalTo("Over 9000!"));
}
```

