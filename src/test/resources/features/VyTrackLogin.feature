@vytrack
Feature: VyTrack Login

  #@wip
  Scenario: Login as different roles
    Given user at login page
    When user provides "driver" information
    Then user should be able to login

  #@wip
  Scenario: Login as different roles
    Given user at login page
    When user provides "sales manager" information
    Then user should be able to login

  #@wip
  Scenario: Login as different roles
    Given user at login page
    When user provides "store manager" information
    Then user should be able to login