# new feature
# Tags: optional
@setUp #tags
Feature: Products page functionality

  @Login
  Scenario: User can go to Login page
    Given User is on Login page
    Then Page title is Login

  @Login @Good
  Scenario: User can Login
    Given User is on Login page
    When User enters Email "bob@example.com"
    And User enters Password "10203040"
    And User clicks Login
    Then User is logged in and redirected to Product Page


  @Login @Bad
  Scenario: User can't Login bad credentials
    Given User is on Login page
    When User enters Email "bobas@example.com"
    And User enters Password "10203040as"
    And User clicks Login
    Then Error message is displayed


  @Login @Bad
  Scenario: User can't Login old credentials
    Given User is on Login page
    When User enters Email "alice@example.com"
    And User enters Password "10203040"
    And User clicks Login
    Then Error message is displayed lockedout