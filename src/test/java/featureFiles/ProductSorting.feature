Feature: Function to filter and sort products

  Background:
    Given Navigate to the Amazon
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

  Scenario: Product Filtering and Sorting
    When User click units on the tab menu
      | computerBtn |
    And User hover over on the submenu
      | laptopBtn |
    And User click units on the tab menu
      | gamingLaptops |
    Then User should be able to verify the total number of products
    And User click on filtering units
      | msiSelectBtn      |
      | cpuIntelSelectBtn |
      | coreI7SelectBtn   |
      | ghz4SelectBtn     |
    Then User should be able to verify the total number of products
    When User sorts products from low to high price
    Then User should be able to verify the ranking criterion
    And User sorts products from high to low price
    Then User should be able to verify the ranking criterion
