## Automation Task

## Overview

This repository contains automation tasks across three domains: Web Automation, Mobile Automation, and API Automation, utilizing Selenium, Appium, and RestAssured.

## Table of Contents

Web Automation Assignment
Mobile Automation Assignment
API Automation Assignment
API Performance Assignment
Setup Instructions
Running Tests
Sample Reports
Web Automation Assignment

# Project Details
URL: Testing Todorvachev
Design Pattern: Page Object Model (POM) and singleton 

## Test Scenarios:
Check if all elements are visible.
Fill out the registration form with INVALID data and verify registration failure.
Fill out the registration form with VALID data and verify registration success.

## Technologies Used
Selenium
Java/Maven/TestNG
Browser Support
Chrome
Firefox


## Mobile Automation Assignment

## Project Details
Platform: Mobile Device Browser
Design Pattern: Page Object Model (POM) and singleton

## Technologies Used
Appium
Java/Maven/TestNG 
## API Automation Assignment

API Details
Base URL: ReqRes
API Name	API URL	Method
List Users	https://reqres.in/api/users?page=2	GET
Create User	https://reqres.in/api/users	POST
Update User	https://reqres.in/api/users/2	PUT
## Technologies Used
RestAssured
Java/Maven/TestNG 



Clone the Repository:

## Web Automation Setup:
Ensure you have Java and Maven installed.
Navigate to the Web Automation folder and run:
mvn clean install

## Mobile Automation Setup:
Ensure you have Appium installed and configured.
Navigate to the Mobile Automation folder and run
mvn clean install

## API Automation Setup:
Ensure you have Java and Maven installed.
Navigate to the API Automation folder and run:

mvn clean install

## Performance Testing Setup:
Ensure you have JMeter installed.
Load the JMeter test scripts and run.
Running Tests

## Web Automation:

mvn test -Dtest=YourTestClassName
## Mobile Automation:

mvn test -Dtest=YourMobileTestClassName

## API Automation:

mvn test -Dtest=YourApiTestClassName
