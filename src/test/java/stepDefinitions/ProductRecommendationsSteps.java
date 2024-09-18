package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.ProductRecommendationsPOM;
import utilities.ReusableMethods;

public class ProductRecommendationsSteps {

    ProductRecommendationsPOM pr = new ProductRecommendationsPOM();

    @Given("The User navigates down the site to product recommendations")
    public void theUserNavigatesDownTheSiteToProductRecommendations() {
        ReusableMethods.scrollToElement(pr.backToTop);
    }

    @When("The User clicks on see viewing history button")
    public void theUserClicksOnSeeViewingHistoryButton() {
        pr.clickFunction(pr.viewedProductsBtn);
    }

    @Then("The user should be able to verify whether they have navigated to the product list page.")
    public void theUserShouldBeAbleToVerifyWhetherTheyHaveNavigatedToTheProductListPage() {
        pr.verifyContainsText(pr.viewedProductsTitle, "Görüntülediğiniz Ürünler");
    }

    @And("The User clicks on any product in the product list based on purchases")
    public void theUserClicksOnAnyProductInTheProductListBasedOnPurchases() {
        pr.clickFunction(pr.viewedProducts.get(ReusableMethods.randomGenerator(pr.viewedProducts.size() - 1)));
    }

    @Then("The user should be able to verify that they can navigate to the product page")
    public void theUserShouldBeAbleToVerifyThatTheyCanNavigateToTheProductPage() {
        Assert.assertTrue(pr.addToCartBtn.isDisplayed());
    }
}
