#Author: Ganga Bindu Jakkula
@BORROWINGCALCULATOR
Feature: Borrowing calculator
	
  @Smoke
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
    
  @STAROVERBUTTON
  Scenario: verify form cleared by clicking 'start over' button
    Given Navigate to borrowing calculator page
    When Select application type in your details section for "single"
    And Select number of dependants in your details section as "0"
    And Select buying a property in your details section as "livein	"
    And Enter annual income in your earnings section of "100000"
    And Enter other income in your earnings section of "10000"
    And Enter living expenses in your expenses section of "500"
    And Enter current home loan repayments in your expenses section of "0"
    And Enter other loan repayments in your expenses section of "100"
    And Enter other commitments in your expenses section of "0"
    And Enter total credit card limits in your expenses section of "10000"
    And Submit work out how much i could borrow
    And Wait for the page to be loaded
    And Click on start over button
    And Wait for the page to be loaded
    Then Validate the borrowing calculation page fields are set to defaulted