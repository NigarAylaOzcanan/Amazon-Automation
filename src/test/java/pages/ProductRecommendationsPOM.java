package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;
import java.util.List;

public class ProductRecommendationsPOM extends ReusableMethods {
    public ProductRecommendationsPOM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//*[@class='a-row a-carousel-controls a-carousel-row a-carousel-has-buttons'])[1]//li/span")
    public List<WebElement> similarProduct;

    @FindBy(xpath = "//*[text()='Görüntüleme geçmişini gör veya düzenle']")
    public WebElement viewedProductsBtn;

    @FindBy(css = "[class*='_cDEzb_page-title']")
    public WebElement viewedProductsTitle;

    @FindBy(css = "[class*='sc-uncoverable-faceout']")
    public List<WebElement> viewedProducts;


}
