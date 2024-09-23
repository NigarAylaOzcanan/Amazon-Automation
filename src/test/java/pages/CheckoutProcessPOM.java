package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

import java.util.List;

public class CheckoutProcessPOM extends ReusableMethods {
    public CheckoutProcessPOM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchTextBox;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchSubmitBtn;

    @FindBy(xpath = "//span[@class='a-button a-button-primary a-button-icon']//button")
    public List<WebElement> addToCardBtn;

    @FindBy(css = "[class='a-box-inner a-alert-container'] strong")
    public WebElement bankCardWarning;

    @FindBy(css = "[class*='go-to-cart'] span>a")
    public WebElement goToCartBtn;

    @FindBy(name = "proceedToRetailCheckout")
    public WebElement proceedToCheckout;

    @FindBy(xpath = "(//*[@id='sc-byc-ptc-button-lower']//a)[1]")
    public WebElement continueToPaymentStp;

    @FindBy(xpath = "//a[text()='Kredi kartı veya banka kartı ekleyin']")
    public WebElement addCreditOrBankCard;

    @FindBy(xpath = "//*[text()='Hayır']")
    public WebElement NoRadioBtn;

    @FindBy(css = "[class*='alert-inline-info'] i+div")
    public WebElement paymentMethodNotSave;

    @FindBy(xpath = "//span[text()='Bu ödeme aracını kullan']")
    public WebElement thisPaymentMethod;

    @FindBy(xpath = "(//*[text()='Bu adresi kullan'])[2]")
    public WebElement thisAddress;

    @FindBy(xpath = "(//*[@class='a-text-right aok-nowrap a-nowrap'])[2]")
    public WebElement shippingFee;

    @FindBy(xpath = "(//td[contains(@class,'total-price')])[1]")
    public WebElement totalPrice;

    @FindBy(css = "[name*='submit.delete']")
    public List<WebElement> deleteProduct;

    @FindBy(css = "[class*='extra-large']")
    public WebElement cartIsEmptyText;

    @FindBy(css = "[class*='sc-product-price a-text-bold']")
    public List<WebElement> productPrice;

    @FindBy(xpath = "(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[2]")
    public WebElement subTotal;

    @FindBy(css = "[class='a-icon a-icon-logo clickable-heading']")
    public WebElement amazonLogo;

    @FindBy(css = "[class='a-popover-content'] a")
    public WebElement backToCart;
}
