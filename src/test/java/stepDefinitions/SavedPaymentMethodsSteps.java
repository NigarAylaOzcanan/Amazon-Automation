package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPOM;
import pages.SavedPaymentMethodsPOM;
import utilities.ConfigReader;
import utilities.GWD;
import java.time.Duration;


public class SavedPaymentMethodsSteps {

    SavedPaymentMethodsPOM sp = new SavedPaymentMethodsPOM();
    LoginPOM login = new LoginPOM();
    public WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(ConfigReader.getIntProperty("explicit.wait")));

    @Given("The user clicks to my account")
    public void theUserClicksToMyAccount() {
        login.clickFunction(login.loginButton);
    }

    @When("The user clicks to your payments")
    public void theUserClicksToYourPayments() {
        sp.clickFunction(sp.paymentsBtn);
    }

    @And("The user clicks add to payment method")
    public void theUserClicksAddToPaymentMethod() {
        sp.jsClick(sp.addPaymentMethodBtn);
    }

    @When("The user clicks add to credit card or bank card")
    public void theUserClicksAddToCreditCardOrBankCard() {
        sp.jsClick(sp.addCreditCardBtn);
    }

    @And("The user adds incorrect card date")
    public void theUserAddsIncorrectCardDate() {
        sp.iframeSwitchByElement(sp.iframeCreditCard);
        sp.sendKeysFunction(sp.addCreditCardNumber, "4242424242424242");
        sp.sendKeysFunction(sp.accountHolderName, ConfigReader.getProperty("cardholderName"));
        sp.selectByText(sp.expirationDateMonth, "02");
        sp.selectByText(sp.expirationDateYear, "2024");
        sp.clickFunction(sp.addCreditCardEvent);

    }

    @Then("The user should be able to verify that the date entered is incorrect")
    public void theUserShouldBeAbleToVerifyThatTheDateEnteredIsIncorrect() {
        wait.until(ExpectedConditions.textToBePresentInElement(sp.incorrectCredentials, "Son kullanma tarihi doğru değil"));
        Assert.assertTrue(sp.incorrectCredentials.getText().toLowerCase().contains("Son kullanma tarihi doğru değil".toLowerCase()));
    }

    @And("The user adds incorrect card number")
    public void theUserAddsIncorrectCardNumber() {
        sp.sendKeysFunction(sp.addCreditCardNumber, "1111111111111111");
        sp.sendKeysFunction(sp.accountHolderName, ConfigReader.getProperty("cardholderName"));
        sp.selectByText(sp.expirationDateMonth, "01");
        sp.selectByText(sp.expirationDateYear, "2028");
        sp.clickFunction(sp.addCreditCardEvent);
    }

    @Then("The user should be able to verify that the card number entered is incorrect")
    public void theUserShouldBeAbleToVerifyThatTheCardNumberEnteredIsIncorrect() {
        wait.until(ExpectedConditions.textToBePresentInElement(sp.incorrectCredentials, "Kart numarası doğru değil"));
        Assert.assertTrue(sp.incorrectCredentials.getText().toLowerCase().contains("Kart numarası doğru değil".toLowerCase()));
    }

    @When("The user adds the correct card details and then click Add to your card")
    public void theUserAddsTheCorrectCardDetailsAndThenClickAddToYourCard() {
        sp.sendKeysFunction(sp.addCreditCardNumber, ConfigReader.getProperty("cardNumber"));
        sp.sendKeysFunction(sp.accountHolderName, ConfigReader.getProperty("cardholderName"));
        sp.selectByText(sp.expirationDateMonth, "01");
        sp.selectByText(sp.expirationDateYear, "2028");
        sp.clickFunction(sp.addCreditCardEvent);
    }

    @And("The user clicks on save")
    public void theUserClicksOnSave() {
        sp.clickFunction(sp.savePaymentMethod);
        GWD.getDriver().switchTo().defaultContent();
    }

    @Then("The user should be able to see successfully message")
    public void theUserShouldBeAbleToSeeSuccessfullyMessage() {
        sp.verifyContainsText(sp.SuccessText, "Ödeme aracı eklendi");
    }

    @When("The user clicks edit to edit the card information")
    public void theUserClicksEditToEditTheCardInformation() {
        sp.jsClick(sp.editBtn);
    }

    @And("The user clicks remove from the wallet and then clicks remove")
    public void theUserClicksRemoveFromTheWalletAndThenClicksRemove() {
        wait.until(ExpectedConditions.visibilityOf(sp.deleteCardBtn));
        sp.jsClick(sp.deleteCardBtn);
        sp.jsClick(sp.removeBtn);
    }

    @Then("User verifies that your payment method has been successfully removed")
    public void userVerifiesThatYourPaymentMethodHasBeenSuccessfullyRemoved() {
        sp.verifyContainsText(sp.SuccessText, "Ödeme yönteminiz başarıyla kaldırıldı");

    }
}
