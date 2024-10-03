package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;
import java.util.List;

public class WishlistFeaturePOM extends ReusableMethods {
    public WishlistFeaturePOM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(id = "add-to-wishlist-button-submit")
    public WebElement addWishListBtn;

    @FindBy(xpath = "(//*[@class='a-size-medium-plus huc-atwl-header-main'])[1]")
    public WebElement wishListText;

    @FindBy(css = "[id='continue-shopping'] input")
    public WebElement continueShoppingBtn;

    @FindBy(css = "[class='a-size-base-plus a-color-base a-text-normal']")
    public List<WebElement> productList;

    @FindBy(css = "span[id='productTitle']")
    public WebElement productTitle;

    @FindBy(css = "[id='huc-view-your-list-button'] a")
    public WebElement viewListBtn;

    @FindBy(css = "h2[class='a-size-base'] a")
    public List<WebElement> wishlistItemText;

    @FindBy(name = "submit.deleteItem")
    public List<WebElement> deleteWishListBtn;

    @FindBy(css = "[class='nav-panel'] span")
    public WebElement wishlistBtn;

    @FindBy(css = "[class*='zero-items-text-section'] span")
    public WebElement listEmptyText;

}
