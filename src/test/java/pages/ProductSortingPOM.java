package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

public class ProductSortingPOM extends ReusableMethods {
    public ProductSortingPOM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "[id='nav-xshop-container']>div>:nth-child(5)")
    public WebElement computerBtn;

    @FindBy(css = "[id='nav-subnav']>a:nth-child(3)")
    public WebElement laptopBtn;

    @FindBy(css = "[id*='pclaptops'] ul :nth-child(3) div")
    public WebElement gamingLaptops;

    @FindBy(css = "[aria-label='MSI'] i")
    public WebElement MsiSelectBtn;

    @FindBy(xpath = "(//*[@aria-label='Intel'])[1]//i")
    public WebElement CpuIntelSelectBtn;

    @FindBy(css = "[aria-label='Intel Core i7'] i")
    public WebElement Corei7SelectBtn;

    @FindBy(css = "[aria-label*='4.0 GHz'] i")
    public WebElement Ghz4SelectBtn;
}
