@OBJECTS
Feature: LECC Configration
  Description: The purpose of this feature is to test the Background keyword

  Scenario: : User is Logged In
    Given I navigate to the sf Login page
    When I submit the login data
    Then I should Logged In Salesforce

