# Shuffle and Log Microservices

This project consists of two microservices:
1. `service-shuffle`: Processes incoming requests and returns a shuffled array of integers.
2. `service-log`: Logs the requests received from `service-shuffle`.

## Prerequisites
- Java 11 or higher installed
- Maven installed
- IntelliJ IDEA or any preferred Java IDE
- Postman or curl for testing

## How to Run the Services
Start each service in separate instances of IntelliJ IDEA or terminals:

## Run service-log:
Navigate to the class LogApplication in the package com.example.log.
Right-click on the main method and select Run.
Confirm the service is running on http://localhost:8081.

## Run service-shuffle:
Navigate to the class ShuffleApplication in the package com.example.shuffle.
Right-click on the main method and select Run.
Confirm the service is running on http://localhost:8080.

## How to Test the Services
Test with Postman
Open Postman.
Create a new POST request:
URL: http://localhost:8080/shuffle

Method: POST
{
"number": 5
}

Send the request.
Verify the response contains a shuffled array of integers: Example response:
[4, 1, 5, 3, 2]

Test with curl
You can use the terminal to test with curl:

curl -X POST http://localhost:8080/shuffle \
-H "Content-Type: application/json" \
-d '{"number":5}'

## Verify Logs in service-log
Check the console output of service-log.
You should see a log entry similar to:

Received request: ShuffleRequest{number=5}

## Project Structure

src/main/java/com/example/
├── log/
│   ├── LogApplication.java        # Main application class for service-log
│   ├── LogController.java         # Controller for logging requests
├── shuffle/
│   ├── ShuffleApplication.java    # Main application class for service-shuffle
│   ├── ShuffleController.java     # Controller for handling shuffle requests
│   ├── ShuffleService.java        # Service for generating shuffled arrays
│   ├── ShuffleRequest.java        # Model for request validation
src/main/resources/
├── application.properties          # Config for service-shuffle
├── application-log.properties      # Config for service-log

## Technologies Used
Java 11
Spring Boot
Maven