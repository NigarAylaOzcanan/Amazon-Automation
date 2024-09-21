@SmokeTest
Feature: Search Functionality
  As a customer,
  I want to search for products by keyword,
  so that I can quickly find items that meet my needs.

  Background:
    Given Navigate to the Amazon
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

  Scenario: Search for the product by keyword
    Given User is on the Amazon home page
    When User enters "laptop" in the search bar
    And User clicks on the search button
    Then User should see a list of products related to the keyword

  Scenario: Navigate to the product page from search results
    Given User enters "laptop" in the search bar
    When User clicks on the search button
    And User clicks on the first product in the search results
    Then User should be taken to the product's detail page
    And  User should see the product details including name, price, and description

  Scenario: Search for a product that does not exist
    Given User is on the Amazon home page
    When User enters "xyz2345bcd" in the search bar
    And User clicks on the search button
    Then User should see a message indicating that no products were found

  Scenario: Search without entering a keyword
    Given User is on the Amazon home page
    When User clicks on the search button without entering a keyword
    Then User should be redirected back to the amazon home page

