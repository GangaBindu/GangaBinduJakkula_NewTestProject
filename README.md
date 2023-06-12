
# Automation Testing for Borrowing Calculator

This project aims on building automated tests for a borrowing calculator and verify proper functioning of the calculator with few use cases. 


## Prerequisites

- Java Development Kit (JDK) installed
- Maven installed
- WebDriver (e.g:  ChromeDriver, Edge) installed
- IDE (e.g: Eclipse) installed
- Cucumber Eclipse Plugin to be installed in IDE (e.g: Eclipse) from Help--> Eclipse Marketplace
## Installation

1. Clone the project from the repository:
git clone : https://github.com/GangaBindu/GangaBinduJakkula_NewTestProject.git

2. Import the project into your preferred IDE.

3. Resolve dependencies using Maven:
 mvn clean install

 Note: WebDrivers(e.g: ChromeDriver, Edge) path is set to relative user directory path
## Project Structure

- `src/test/java/stepDefintions`: Contains the test steps (StepDefintiion file) code corresponding to the feature files with file name "BorrowingCalculatorSteps.java".
- `src/test/java/stepDefintions`: Contains the test Runner file to run tests.
- `src/test/resources/features`: Contains the Gherkin feature file with file name "borrowingCalculator.feature"
## Output Reports

This project generates Cucumber HTML/json reports after each test run. The reports can be found in the `target/cucumber-reports.html and target/Json_Output/cucumber-reports.json`directory.
## Sample Test case

Example of a feature file:

Gherkin:

 @ESTIMATEBORROWEDAMOUNT
 
 Scenario: verify estimate of how much amount can be borrowed for a person
 
    Given Navigate to borrowing calculator page
    When Select application type in your details section for "single"
    And Select number of dependants in your details section as "0"
    And Select buying a property in your details section as "livein"
    And Enter annual income in your earnings section of "100000"
    And Enter other income in your earnings section of "10000"
    And Enter living expenses in your expenses section of "500"
    And Enter current home loan repayments in your expenses section of "0"
    And Enter other loan repayments in your expenses section of "100"
    And Enter other commitments in your expenses section of "0"
    And Enter total credit card limits in your expenses section of "10000"
    And Submit work out how much i could borrow
    And Wait for the page to be loaded
    Then Validate borrowing amount estimate of "$492,000"
## Test run

To run the tests, use the following command:

mvn clean test
## Troubleshooting

If you encounter any issues, try the following troubleshooting steps:

1.Verify that the required software and dependencies are installed correctly.

2.Check the configuration files for any errors or missing settings.

3.Ensure the correct browser version and WebDriver version compatibility.
## Author

Ganga Bindu Jakkula
## Project Structure

- `src/test/java/stepDefintions`: Contains the test steps (StepDefintiion file) code corresponding to the feature files with file name "BorrowingCalculatorSteps.java".
- `src/test/java/stepDefintions`: Contains the test Runner file to run tests.
- `src/test/resources/features`: Contains the Gherkin feature file with file name "borrowingCalculator.feature"