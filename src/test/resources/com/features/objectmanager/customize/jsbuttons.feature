@JsButtons
Feature: Home Page
  In order to add multiple objects
  As a Salesforce user
  I want to specify the features of home page

  Scenario: New Js Button
    Given user is on Salesforce home page
    Then user gets a GitHub bootcamp section
    And username is also displayed on right corner

  Scenario: New Action
    Given user is on Salesforce home page
    When user focuses on GitHub Bootcamp Section
    Then user gets an option to setup git
    And user gets an option to create repository
    And user gets an option to Fork Repository
    And user gets an option to work together

  Scenario: New Page layout
    Given user is on Salesforce home page
    When user focuses on Top Banner
    Then user gets an option of home page
    And user gets an option to search
    And user gets settings options
    And user gets an option to logout