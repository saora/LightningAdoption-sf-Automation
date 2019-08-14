@RegressionTest
Feature: Log in Salesforce
  In order to get access into Salesforce Org
  I want to be able to login with a valid account

  Scenario: Login with valid credentials
    Given I am in the login page
    When I fill and send the org account data
    And I verify the user account
    Then I should be on salesforce home page


