Feature: Add Address Functionality

  Background:
    Given Navigate to the Amazon
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

  Scenario:Adding an address to the account
    Given The user clicks on the My Account button from the drop-down menu
    When The user presses the address button on the opened page and clicks on add address
    Then User enters address details
    And The user sees the address saved text on the screen
