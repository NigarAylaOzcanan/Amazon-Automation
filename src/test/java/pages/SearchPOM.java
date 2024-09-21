package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;

public class SearchPOM extends GWD {
    public SearchPOM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "div[class='nav-search-field']")
    public WebElement searchBar;

    @FindBy(css = "[class='nav-search-submit nav-sprite']")
    public WebElement searchButton;

}
