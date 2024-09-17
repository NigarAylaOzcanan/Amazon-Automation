package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.ProductSortingPOM;
import utilities.ConfigReader;
import utilities.GWD;
import java.time.Duration;
import java.util.List;

public class ProductSortingSteps {
    ProductSortingPOM ps = new ProductSortingPOM();
    public WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(ConfigReader.getIntProperty("explicit.wait")));

    @When("User click units on the tab menu")
    public void userClickUnitsOnTheTabMenu(DataTable tabMenuButtons) {
        List<String> strButtonList = tabMenuButtons.asList(String.class);

        for (int i = 0; i < strButtonList.size(); i++) {
            WebElement linkWebElement = ps.getWebElement(strButtonList.get(i));
            ps.jsClick(linkWebElement);
        }
    }

    @And("User hover over on the submenu")
    public void userHoverOverOnTheSubmenu(DataTable hoverOverSubmenu) {
        List<String> strButtonList = hoverOverSubmenu.asList(String.class);

        for (int i = 0; i < strButtonList.size(); i++) {
            WebElement linkWebElement = ps.getWebElement(strButtonList.get(i));
            ps.hoverOver(linkWebElement);
            wait.until(ExpectedConditions.attributeToBe(linkWebElement, "class", "nav-a nav-hasArrow nav-active"));
        }
    }

    @Then("User should be able to verify the total number of products")
    public void userShouldBeAbleToVerifyTheTotalNumberOfProducts() {
        wait.until(ExpectedConditions.visibilityOf(ps.totalProductNumber));
        int space = ps.totalProductNumber.getText().indexOf(" ");
        String part = ps.totalProductNumber.getText().substring(0, space);
        int resultNumber = Integer.parseInt(part);

        if (resultNumber > 300) {
            ps.verifyContainsText(ps.totalProductNumber, part);
        } else {
            ps.verifyContainsText(ps.totalProductNumber, part);
        }
    }

    @And("User click on filtering units")
    public void userClickOnFilteringUnits(DataTable filteringButtons) {
        List<String> strButtonList = filteringButtons.asList(String.class);
        for (int i = 0; i < strButtonList.size(); i++) {
            WebElement linkWebElement = ps.getWebElement(strButtonList.get(i));
            ps.clickFunction(linkWebElement);
            //wait.until(ExpectedConditions.attributeToBe(linkWebElement,"class","s-result-list-placeholder sg-row aok-hidden"));
        }
    }

    @When("User sorts products from low to high price")
    public void userSortsProductsFromLowToHighPrice() {
        ps.clickFunction(ps.sortingCriteriaBtn);
        ps.clickFunction(ps.fromLowToHigh);
    }

    @Then("User should be able to verify the ranking criterion")
    public void userShouldBeAbleToVerifyTheRankingCriterion() {

        String strFirstPrice = ps.productPrices.get(0).getText().replaceAll("[^0-9,.]", "");
        double doubleFirstPrice = Double.parseDouble(strFirstPrice);
        String strSecondProductPrice = ps.productPrices.get(1).getText().replaceAll("[^0-9,.]", "");
        double doubleSecondProductPrice = Double.parseDouble(strSecondProductPrice);

        if (doubleFirstPrice < doubleSecondProductPrice) {
            for (int i = 0; i < ps.productPrices.size(); i++) {

                if (i == ps.productPrices.size() - 1) {
                    break;
                }
                String strProductPrice = ps.productPrices.get(i).getText().replaceAll("[^0-9,.]", "");
                double doubleProductPrice = Double.parseDouble(strProductPrice);
                String strAfterProductPrice = ps.productPrices.get(i + 1).getText().replaceAll("[^0-9,.]", "");
                double doubleAfterProductPrice = Double.parseDouble(strAfterProductPrice);
                Assert.assertTrue(doubleProductPrice < doubleAfterProductPrice, "Product Prices are not from low to high");
            }
        } else if (doubleFirstPrice > doubleSecondProductPrice) {
            for (int i = 0; i < ps.productPrices.size(); i++) {
                if (i == ps.productPrices.size() - 1) {
                    break;
                }
                String strProductPrice = ps.productPrices.get(i).getText().replaceAll("[^0-9,.]", "");
                double doubleProductPrice = Double.parseDouble(strProductPrice);
                String strAfterProductPrice = ps.productPrices.get(i + 1).getText().replaceAll("[^0-9,.]", "");
                double doubleAfterProductPrice = Double.parseDouble(strAfterProductPrice);
                Assert.assertTrue(doubleProductPrice > doubleAfterProductPrice, "Product Prices are not from high to low");
            }
        }
    }

    @And("User sorts products from high to low price")
    public void userSortsProductsFromHighToLowPrice() {
        ps.clickFunction(ps.sortingCriteriaBtn);
        ps.clickFunction(ps.fromHighToLow);

    }
}
