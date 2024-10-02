## Registration Test Suite

This project contains automated tests for the registration functionality of a web application using Selenium and TestNG. The tests are designed to validate the visibility of registration elements and ensure proper handling of both valid and invalid registration data.

## Technologies Used

** Java: Programming language for test implementation.
** Selenium WebDriver: For browser automation.
** TestNG: Test framework for organizing and running tests.
** Extent Reports: For generating HTML reports.

## Test Structure

The main test class is RegistrationTest located in com.demo.tests. It includes the following tests:

testAllElementsVisible: Validates that all registration form elements are displayed.
testRegistrationWithInvalidAddress: Tests the registration process with invalid data and checks for appropriate error messages.
testRegistrationWithValidData: Tests the registration process with valid data to ensure successful registration.


## TestNG Suite Configuration
The TestNG XML configuration file, testng.xml, defines the suite for parallel execution across multiple browsers. It contains two test cases:

Chrome Test
Firefox Test

## Clone the repository:

git clone <repository-url>
cd  Website-Framework/


## Running Tests

To run the tests, execute the TestNG suite defined in testng.xml. You can do this from the command line using Maven:

mvn test -DsuiteXmlFile=testng.xml