Feature: Wishlist Check Functionality
  As a customer, I want to add items to my wishlist
  so that I can save products for future purchases.

  Background:
    Given Navigate to the Amazon
    When Enter the valid credentials and click the login button

  Scenario: Add products to the wish list
    Given The user enters the product name in the search bar
    When The user clicks on the search submit button
    And The user adds products to wishlist
    Then The user should be able to verify the products added to the wish list

  Scenario: Remove products from the wish list
    Given The user clicks the wishlist that is in the submenu of the account
    Then The user should be able to verify that the wishlist is empty
