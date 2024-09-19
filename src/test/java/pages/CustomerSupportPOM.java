package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

public class CustomerSupportPOM extends ReusableMethods {
    public CustomerSupportPOM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(linkText = "Müşteri Hizmetleri")
    public WebElement customerSupportBtn;

    @FindBy(css = "[class='sic-container']>button")
    public WebElement anotherHelpBtn;

    @FindBy(css = "ul[class='issue-card-container']>:nth-of-type(9) div+div div")
    public WebElement otherBtn;

    @FindBy(xpath = "//span[text()='Bize Ulaşın']")
    public WebElement contactUsBtn;

    @FindBy(css = "[class='fs-heading']")
    public WebElement pageTitle;
}
