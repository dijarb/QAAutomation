@login
Feature: Login


  Background:
    Given user go to the login page

  Scenario: positive login test
    When user enter correct credentials
    Then user should be in "Secure Area"


  Scenario: negative login test
    When user enters wrong credentials
    Then user should be at "Login Page"