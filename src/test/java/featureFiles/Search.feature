@SmokeTest
Feature: Search Functionality
  As a customer,
  I want to search for products by keyword,
  so that I can quickly find items that meet my needs.

  Background:
    Given Navigate to the Amazon
    When Enter the valid credentials and click the login button


  Scenario: Search for the product by keyword
    Given the user is on the Amazon home page
    When the user enters "laptop" in the search bar
    And the user clicks on the search button
    Then the user should see a list of products related to the keyword

  Scenario: Navigate to the product page from search results
    Given the user enters "laptop" in the search bar
    When the user clicks on the search button
    And the user clicks on the first product in the search results
    Then the user should be taken to the product's detail page
    And  the user should see the product details including name, price, and description

  Scenario: Search for a product that does not exist
    Given the user is on the Amazon home page
    When the user enters "xyz2345bcd" in the search bar
    And the user clicks on the search button
    Then the user should see a message indicating that no products were found

  Scenario: Search without entering a keyword
    Given the user is on the Amazon home page
    When the user clicks on the search button without entering a keyword
    Then the user should be redirected back to the Amazon home page

