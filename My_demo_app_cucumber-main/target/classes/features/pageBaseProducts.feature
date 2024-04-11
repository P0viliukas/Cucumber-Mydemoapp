#run tests via arrow in TestRunner or mvn test or via arrow in feature file

@setUp #tags
Feature: Products page functionality

  @DoTests
  Scenario Outline: User sorts products by all sort options
    Given User is on "Products" page
    When User clicks "sort button" button
    And User clicks "<sort>" button
    Then First product title is "<title>"

    Examples:
      | sort      | title                       |
      | nameAsc   | Sauce Labs Backpack         |
      | nameDesc  | Test.allTheThings() T-Shirt |
      | priceAsc  | Sauce Labs Onesie           |
      | priceDesc | Sauce Labs Fleece Jacket    |

  @Login_Success
  Scenario: Broken test
    Given User is on "Products" page
    Then First product title is "Sauce Labs Backpack"