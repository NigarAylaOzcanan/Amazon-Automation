Feature: Product Recommendations process

  Background:
    Given Navigate to the Amazon
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

  Scenario:Product Recommendations According to the Product Reviewed and Purchased
    Given The User navigates down the site to product recommendations
    When The User clicks on any product in the product list based on purchases
    Then The User performs verification
    And The user comes back to the home page
    When The User navigates down the site to product recommendations
    And The User clicks on see viewing history button
    Then Verifies if the user has navigated to the product list page

