package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

public class LoginPOM extends ReusableMethods {
    public LoginPOM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(id = "nav-link-accountList")
    public WebElement loginButton;

    @FindBy(id = "ap_email")
    public WebElement emailBox;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(id = "ap_password")
    public WebElement passwordBox;

    @FindBy(id = "signInSubmit")
    public WebElement signInButton;

}
