Feature: Saved Payment Methods

  Background:
    Given Navigate to the Amazon
    When Enter the valid credentials and click the login button


  Scenario: Registering and Deleting a Payment Method
    Given The user clicks to my account
    When The user clicks to your payments
    And The user clicks add to payment method
    When The user clicks add to credit card or bank card
    And The user adds incorrect card date
    Then The user should be able to verify that the date entered is incorrect
    And The user adds incorrect card number
    Then The user should be able to verify that the card number entered is incorrect
    When The user adds the correct card details and then click Add to your card
    And The user clicks on save
    Then The user should be able to see successfully message
    When The user clicks edit to edit the card information
    And The user clicks remove from the wallet and then clicks remove
    Then User verifies that your payment method has been successfully removed



