package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddAdressPOM;
import utilities.GWD;
import utilities.ReusableMethods;

public class AddAddressSteps {

    AddAdressPOM aap = new AddAdressPOM();
    public WebDriverWait wait;


    @Given("The user clicks on the My Account button from the drop-down menu")
    public void theUserClicksOnTheMyAccountButtonFromTheDropDownMenu() {
        aap.clickFunction(aap.myAccountList);
    }

    @When("The user presses the address button on the opened page and clicks on add address")
    public void theUserPressesTheAddressButtonOnTheOpenedPageAndClicksOnAddAddress() {
        aap.jsClick(aap.addAddressBtn);
        aap.jsClick(aap.newAddAddressBtn);
    }

    @Then("User enters address details")
    public void userEntersAddressDetails() {

        aap.sendKeysFunction(aap.fullNameTxt, "Ahmet Kaya");
        aap.sendKeysFunction(aap.phoneTxt, "5315865656");
        aap.sendKeysFunction(aap.addressTxt, "dsadsa");
        aap.sendKeysFunction(aap.cityTxt, "İs");
        ReusableMethods.wait(2);
        ReusableMethods.downKeyMultiplePress(3);
        ReusableMethods.enterKeyMultiplePress(1);
        aap.sendKeysFunction(aap.districtTxt, "ü");
        ReusableMethods.wait(2);
        ReusableMethods.downKeyMultiplePress(3);
        ReusableMethods.enterKeyMultiplePress(1);
        aap.sendKeysFunction(aap.neighbourhoodTxt, "y");
        ReusableMethods.wait(2);
        ReusableMethods.downKeyMultiplePress(2);
        ReusableMethods.enterKeyMultiplePress(1);
        ReusableMethods.wait(2);
        aap.clickFunction(aap.saveBtn);

    }

    @And("The user sees the address saved text on the screen")
    public void theUserSeesTheAddressSavedTextOnTheScreen() {
        aap.verifyContainsText(aap.verifyAddressTxt, "Adres kaydedildi");
    }
}
