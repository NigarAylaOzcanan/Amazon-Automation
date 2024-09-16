package stepDefinitions;

import io.cucumber.java.en.*;
import pages.LoginPOM;
import utilities.ConfigReader;
import utilities.GWD;

public class LoginSteps {
    LoginPOM login = new LoginPOM();

    @Given("Navigate to the Amazon")
    public void navigateToTheAmazon() {
        GWD.getDriver().get(ConfigReader.getProperty("URL"));
    }

    @When("Enter the valid credentials and click the login button")
    public void enterTheValidCredentialsAndClickTheLoginButton() {
        login.clickFunction(login.loginButton);
        login.sendKeysFunction(login.emailBox, ConfigReader.getProperty("e-mail"));
        login.clickFunction(login.continueButton);
        login.sendKeysFunction(login.passwordBox, ConfigReader.getProperty("password"));
        login.clickFunction(login.signInButton);
    }

    @Then("User should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        login.verifyContainsText(login.accountName, "onur");
    }
}
