package stepDefinitions;

import io.cucumber.java.en.*;

public class SearchSteps {
    @Given("the user is on the Amazon home page")
    public void onAmazonHomePage() {
    }

    @When("the user enters {string} in the search bar")
    public void enterKeyword(String arg0) {
    }

    @And("the user clicks on the search button")
    public void clickSearch() {
    }

    @Then("the user should see a list of products related to the keyword")
    public void verifySearchResults() {

    }

    @And("the user clicks on the first product in the search results")
    public void clickFirstProduct() {
    }

    @Then("the user should be taken to the product's detail page")
    public void verifyProductDetailPage() {
    }

    @And("the user should see the product details including name, price, and description")
    public void verifyProductDetails() {
    }

    @Then("the user should see a message indicating that no products were found")
    public void verifyNoResultsMessage() {
    }

    @When("the user clicks on the search button without entering a keyword")
    public void clickSearchWithoutKeyword() {
    }

    @Then("the user should be redirected back to the Amazon home page")
    public void verifyRedirectToHomePage() {
    }
}
