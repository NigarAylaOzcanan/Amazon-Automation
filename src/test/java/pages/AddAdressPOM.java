package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

public class AddAdressPOM extends ReusableMethods {

    public AddAdressPOM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='Hesap ve Listeler']")
    public WebElement myAccountList;

    @FindBy(xpath = "//span[contains(text(),'adres')]")
    public WebElement addAddressBtn;

    @FindBy(xpath = "//div[text()='Adres Ekleyin']")
    public WebElement newAddAddressBtn;

    @FindBy(xpath = "//input[@autocomplete='name']")
    public WebElement fullNameTxt;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
    public WebElement phoneTxt;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine1']")
    public WebElement addressTxt;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressCity']")
    public WebElement cityTxt;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressStateOrRegion']")
    public WebElement districtTxt;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressDistrictOrCounty']")
    public WebElement neighbourhoodTxt;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement saveBtn;

    @FindBy(xpath = "//h4[text()='Adres kaydedildi']")
    public WebElement verifyAddressTxt;


}
