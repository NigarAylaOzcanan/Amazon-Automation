package stepDefinitions;

import io.cucumber.java.en.*;


public class SearchSteps {
    @Given("User is on the Amazon home page")
    public void onAmazonHomePage() {
    }

    @When("User enters {string} in the search bar")
    public void enterKeyword(String arg0) {
    }

    @And("User clicks on the search button")
    public void clickSearch() {
    }

    @Then("User should see a list of products related to the keyword")
    public void verifySearchResults() {

    }

    @And("User clicks on the first product in the search results")
    public void clickFirstProduct() {
    }

    @Then("User should be taken to the product's detail page")
    public void verifyProductDetailPage() {
    }

    @And("User should see the product details including name, price, and description")
    public void verifyProductDetails() {
    }

    @Then("User should see a message indicating that no products were found")
    public void verifyNoResultsMessage() {
    }

    @When("User clicks on the search button without entering a keyword")
    public void clickSearchWithoutKeyword() {
    }

    @Then("User should be redirected back to the amazon home page")
    public void verifyRedirectToHomePage() {
    }
}
