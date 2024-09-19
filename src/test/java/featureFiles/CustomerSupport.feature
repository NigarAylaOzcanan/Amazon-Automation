Feature: Customer Service Functionality

  Background:
    Given Navigate to the Amazon
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

  Scenario:Reaching the Customer Service Interface
    Given The user click customer support on the tab menu
    When The user click to Help with something else button
    Then The user should be able to see different help options
    When The user click to other button
    And The user click to contact us button
    Then The user should be able to see the page where they can contact customer service