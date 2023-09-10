@navigation
Feature: Navigation

#  @wip
  Scenario: driver navigation menu
    Given user at login page
    When user provides "driver" information
    Then user should see below options
      | Fleet      |
      | Customers  |
      | Activities |
      | System     |

#  @wip
  Scenario: driver navigation menu
    Given user at login page
    When user provides "sales manager" information
    Then user should see below options
      | Dashboards        |
      | Fleet             |
      | Customers         |
      | Sales             |
      | Activities        |
      | Marketing         |
      | Reports & Segments|
      | System            |