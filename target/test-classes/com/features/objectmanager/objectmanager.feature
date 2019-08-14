@OBJECTS
Feature: Set Custom Object Data
  Description: The purpose of this is to confgure the custom objects for the ORG

  Background: User is Logged In
  Given I navigate to the Login page
  When I submit the username and password
  Then I should Logged In


  Scenario: Add Field
    Given I click on new field
    When I submit the field information
    Then I should create a new field

  Scenario: Add Js Button
    Given I click on new Js Button
    When I submit Js Button Informtion
    Then I should create a new Js Button
#
#  Scenario: Add action
#    Given I click on new Action
#    When I submit Action information
#    Then I should create a new Action
#
#  Scenario: Add Layout
#    Given I click on new Layout
#    When I submit Layout information
#    Then I should create a new layout
#
#
#  Scenario: Add Visualforce Page
#    Given I click on new Visualforce page
#    When I submit the Visualforce information
#    Then I should create a Visualforce page
#
#  Scenario: Add My Domain
#    Given I click on My Domain
#    When I configure My Domain
#    Then I deploy my domain for users
#
#  Scenario: Add Js Buttons and Action to the Layout
#    Given I click on the Layout
#    When I add the buttons and actions
#    Then I save the layout


