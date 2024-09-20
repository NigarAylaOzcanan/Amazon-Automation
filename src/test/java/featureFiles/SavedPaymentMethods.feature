Feature: Saved Payment Methods

  Background:
    Given Navigate to the Amazon
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

  Scenario: Registering and Deleting a Payment Method
    Given The user clicks to my account
    When The user clicks to your payments
    And The user clicks add to payment method
    When The user clicks add to credit card or bank card
    And The user add incorrect the card informations and click add your cart
    Then The user should be able to see warning the message
    When The user adds correct the card informations and click add your cart
    And The user clicks to save button
    Then The user should be able to see successfully message
    When The user clicks edit to edit the card information
    And The user clicks remove from the wallet and then clicks remove
    Then The user should be able to see successfully message



