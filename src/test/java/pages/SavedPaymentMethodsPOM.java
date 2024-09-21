package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

public class SavedPaymentMethodsPOM extends ReusableMethods {
    public SavedPaymentMethodsPOM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//*[@class='a-box-inner']//div/h2)[5]")
    public WebElement paymentsBtn;

    @FindBy(css = "[class='a-button a-spacing-top-large a-button-primary'] :nth-child(2)")
    public WebElement addPaymentMethodBtn;

    @FindBy(css = "[class*='content-trigger-js'] :nth-child(2)")
    public WebElement addCreditCardBtn;

    @FindBy(css = "[name*='ApxSecureIframe']")
    public WebElement iframeCreditCard;

    @FindBy(css = "[name='addCreditCardNumber']")
    public WebElement addCreditCardNumber;

    @FindBy(css = "[name*='accountHolderName']")
    public WebElement accountHolderName;

    @FindBy(css = "[name*='expirationDate_month']")
    public WebElement expirationDateMonth;

    @FindBy(css = "[name*='expirationDate_year']")
    public WebElement expirationDateYear;

    @FindBy(css = "[name*='Event:AddCreditCardEvent']")
    public WebElement addCreditCardEvent;

    @FindBy(xpath = "(//*[@class='a-unordered-list a-vertical']//span)[1]")
    public WebElement incorrectCredentials;

    @FindBy(css = "[name*='Event:SavePaymentMethod']")
    public WebElement savePaymentMethod;

    @FindBy(css = "[class='a-color-success']")
    public WebElement SuccessText;

    @FindBy(xpath = "//*[text()='Düzenle']")
    public WebElement editBtn;

    @FindBy(css = "[class='apx-remove-link-button']")
    public WebElement deleteCardBtn;

    @FindBy(xpath = "//*[text()='Kaldır']")
    public WebElement removeBtn;

    @FindBy(css = "[name*='CancelAddCreditCardEvent']")
    public WebElement cancelBtn;
}
