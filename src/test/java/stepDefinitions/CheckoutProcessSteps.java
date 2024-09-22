package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutProcessPOM;

public class CheckoutProcessSteps {

    CheckoutProcessPOM cp = new CheckoutProcessPOM();

    @Given("The user enters keyword in the search bar")
    public void theUserEntersKeywordInTheSearchBar() {
    }

    @When("The user clicks on the search submit button")
    public void theUserClicksOnTheSearchSubmitButton() {
    }

    @And("The user adds the products to buy in the cart")
    public void theUserAddsTheProductsToBuyInTheCart() {
    }

    @And("The user goes to cart")
    public void theUserGoesToCart() {
    }

    @Then("The user should be able to control products in the cart")
    public void theUserShouldBeAbleToControlProductsInTheCart() {
    }

    @When("The user clicks complete shopping")
    public void theUserClicksCompleteShopping() {
    }

    @And("The user clicks continue to the payment step")
    public void theUserClicksContinueToThePaymentStep() {
    }

    @And("The user clicks to add credit card or bank card")
    public void theUserClicksToAddCreditCardOrBankCard() {
    }

    @And("The user clicks on save or not save credit card details for the next purchase")
    public void theUserClicksOnSaveOrNotSaveCreditCardDetailsForTheNextPurchase() {
    }

    @Then("The user should be able to see the message that the card information has not been saved")
    public void theUserShouldBeAbleToSeeTheMessageThatTheCardInformationHasNotBeenSaved() {
    }

    @When("The user clicks  on use this payment tool")
    public void theUserClicksOnUseThisPaymentTool() {
    }

    @And("The user clicks on use this address")
    public void theUserClicksOnUseThisAddress() {
    }

    @Then("The user should be able to control total price")
    public void theUserShouldBeAbleToControlTotalPrice() {
    }

    @When("The user removes products from the cart")
    public void theUserRemovesProductsFromTheCart() {
    }

    @Then("The user should be able to verify that the cart is empty")
    public void theUserShouldBeAbleToVerifyThatTheCartIsEmpty() {
    }
}
