Feature: Checkout Process Functionality
  As a customer, I want to complete my purchase through
  a seamless checkout process so that I can quickly
  and securely pay for my items

  Background:
    Given Navigate to the Amazon
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

  Scenario: Successful purchase of the product
    Given The user enters keyword in the search bar
    When The user clicks on the search submit button
    And The user adds the products to buy in the cart
    And The user goes to cart
    Then The user should be able to control products in the cart
    When The user clicks complete shopping
    And The user clicks continue to the payment step
    And The user clicks to add credit card or bank card
    And The user clicks on save or not save credit card details for the next purchase
    When The user adds the correct card details and then click Add to your card
    Then The user should be able to see the message that the card information has not been saved
    When The user clicks  on use this payment tool
    And The user clicks on use this address
    Then The user should be able to control total price
    When The user removes products from the cart
    Then The user should be able to verify that the cart is empty
