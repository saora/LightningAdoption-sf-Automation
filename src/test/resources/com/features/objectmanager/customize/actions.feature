#@RegressionTest
Feature: Add a new action
  In order to get add a new action
  I want to be able to login with an admin account user

  Scenario: Add a new action type Create a Record
    Given Menu action type Create a Record
    |Create a Record|
    When I click on new action and fill out the informaction
    Then I create a new button link or Action

  Scenario: Add a new action type Send Email
    Given Menu action type Send Email
    |Send Email|
    When I click on new action and fill out the informaction
    Then I create a new button link or Action