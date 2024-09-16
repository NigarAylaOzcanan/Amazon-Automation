Feature: Login Functionality

  @SmokeTest
  Scenario: Login with valid credentials
    Given Navigate to the Amazon
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully