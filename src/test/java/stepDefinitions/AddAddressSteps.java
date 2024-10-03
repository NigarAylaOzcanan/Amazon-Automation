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

public class AddAddressSteps extends ReusableMethods {

    AddAdressPOM aap = new AddAdressPOM();
    public WebDriverWait wait;


    @Given("The user clicks on the My Account button from the drop-down menu")
    public void theUserClicksOnTheMyAccountButtonFromTheDropDownMenu() {
        aap.clickFunction(aap.myAccountList);
    }

    @When("The user presses the address button on the opened page and clicks on add address")
    public void theUserPressesTheAddressButtonOnTheOpenedPageAndClicksOnAddAddress() {
        jsClick(aap.addAddressBtn);
        jsClick(aap.newAddAddressBtn);
    }

    @Then("User enters address details")
    public void userEntersAddressDetails() {

        sendKeysFunction(aap.fullNameTxt, "Ahmet Kaya");
        sendKeysFunction(aap.phoneTxt, "5315865656");
        sendKeysFunction(aap.addressTxt, "dsadsa");
        sendKeysFunction(aap.cityTxt, "İs");
        wait(2);
        downKeyMultiplePress(3);
        enterKeyMultiplePress(1);
        sendKeysFunction(aap.districtTxt, "ü");
        wait(2);
        downKeyMultiplePress(3);
        enterKeyMultiplePress(1);
        sendKeysFunction(aap.neighbourhoodTxt, "y");
        wait(2);
        downKeyMultiplePress(2);
        enterKeyMultiplePress(1);
        wait(2);
        clickFunction(aap.saveBtn);
    }

    @And("The user sees the address saved text on the screen")
    public void theUserSeesTheAddressSavedTextOnTheScreen() {
        verifyContainsText(aap.verifyAddressTxt, "Adres kaydedildi");
    }
}
