# new feature
# Tags: optional
@setUp
Feature: Logout

  Background: login
    Given User is on Login page
    When User enters Email "bob@example.com"
    And User enters Password "10203040"
    And User clicks Login

    Scenario: User can logout
      Given User in open menu dropdown
      When User clicks Logout button
      And Clicks Logout
      Then User is Logged out

  Scenario: User can cancel logout
    Given User in open menu dropdown
    When User clicks Logout button
    And User clicks Cancel
    Then User is still logged in