Feature: Product Recommendations process

  Background:
    Given Navigate to the Amazon
    When Enter the valid credentials and click the login button


  Scenario:Product Recommendations According to the Product Reviewed and Browser History
    Given The User navigates down the site to product recommendations
    When The User clicks on see viewing history button
    Then The user should be able to verify whether they have navigated to the product list page.
    And The User clicks on any product in the product list based on purchases
    Then The user should be able to verify that they can navigate to the product page



