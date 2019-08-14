@FunctionalTest
Feature: Create a new ORG
  In order to create a new Salesforce Org
  I want to be able to fill out the org information

  Scenario: Should Salesforce signup page allows to fill out the information required
    Given I open the the signup salesforce page
    When I fill in the information
    Then I get the signup confirmation
