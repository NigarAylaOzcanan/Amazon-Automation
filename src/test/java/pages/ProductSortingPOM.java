package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

import java.util.List;

public class ProductSortingPOM extends ReusableMethods {
    public ProductSortingPOM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Bilgisayar']")
    public WebElement computerBtn;

    @FindBy(css = "[id='nav-subnav']>a:nth-child(3)")
    public WebElement laptopBtn;

    @FindBy(css = "[id*='pclaptops'] ul :nth-child(3) div")
    public WebElement gamingLaptops;

    @FindBy(css = "[aria-label='MSI'] i")
    public WebElement msiSelectBtn;

    @FindBy(xpath = "(//*[@aria-label='Intel'])[1]//i")
    public WebElement cpuIntelSelectBtn;

    @FindBy(css = "[aria-label='Intel Core i7'] i")
    public WebElement coreI7SelectBtn;

    @FindBy(css = "[aria-label*='4.0 GHz'] i")
    public WebElement ghz4SelectBtn;

    @FindBy(css = "[class='a-section a-spacing-small a-spacing-top-small'] span:nth-child(1)")
    public WebElement totalProductNumber;

    @FindBy(css = "[class='s-result-list-placeholder sg-row aok-hidden']")
    public WebElement loadingBar;

    @FindBy(css = "[data-cy='price-recipe'] span:nth-child(2)>span:nth-child(1)")
    public List<WebElement> productPrices;

    @FindBy(css = "[class='a-button-text a-declarative']")
    public WebElement sortingCriteriaBtn;

    @FindBy(xpath = "(//*[@class='a-nostyle a-list-link']/li)[2]/a")
    public WebElement fromLowToHigh;

    @FindBy(xpath = "(//a[contains(@id,'s-result-sort-select')])[9]")
    public WebElement fromHighToLow;

    public WebElement getWebElement(String strElement) {
        switch (strElement) {
            case "computerBtn":
                return this.computerBtn;
            case "laptopBtn":
                return this.laptopBtn;
            case "gamingLaptops":
                return this.gamingLaptops;
            case "msiSelectBtn":
                return this.msiSelectBtn;
            case "cpuIntelSelectBtn":
                return this.cpuIntelSelectBtn;
            case "coreI7SelectBtn":
                return this.coreI7SelectBtn;
            case "ghz4SelectBtn":
                return this.ghz4SelectBtn;
            case "totalProductNumber":
                return this.totalProductNumber;
            case "loadingBar":
                return this.loadingBar;

        }

        return null;
    }
}
