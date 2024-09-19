package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CustomerSupportPOM;

public class CustomerSupportSteps {

    CustomerSupportPOM cs = new CustomerSupportPOM();

    @Given("The user click customer support on the tab menu")
    public void theUserClickCustomerSupportOnTheTabMenu() {
        cs.clickFunction(cs.customerSupportBtn);
    }

    @When("The user click to Help with something else button")
    public void theUserClickToHelpWithSomethingElseButton() {
        cs.clickFunction(cs.anotherHelpBtn);
    }

    @Then("The user should be able to see different help options")
    public void theUserShouldBeAbleToSeeDifferentHelpOptions() {
        cs.verifyContainsText(cs.someOtherTopicText, "diğer bazı konular");
    }

    @When("The user click to other button")
    public void theUserClickToOtherButton() {
        cs.clickFunction(cs.otherBtn);
    }

    @And("The user click to contact us button")
    public void theUserClickToContactUsButton() {
        cs.clickFunction(cs.contactUsBtn);
    }

    @Then("The user should be able to see the page where they can contact customer service")
    public void theUserShouldBeAbleToSeeThePageWhereTheyCanContactCustomerService() {
        cs.verifyContainsText(cs.pageTitle, "Nasıl yardım almak istersiniz?");
    }
}
