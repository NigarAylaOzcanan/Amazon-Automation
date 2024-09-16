Feature: Function to filter and sort products

  Background:
    Given Navigate to the Amazon
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

    Scenario: Product Filtering and Sorting
      When User click units on the tab menu
      And User hover over on the submenu
      And User click units on the tab menu
      Then User should be able to verify the total number of products
      And User click on filtering units
      Then User should be able to verify the total number of products
      When User sorts products from low to high price
      Then User should be able to verify the ranking criterion
      And User sorts products from high to low price
      Then User should be able to verify the ranking criterion
