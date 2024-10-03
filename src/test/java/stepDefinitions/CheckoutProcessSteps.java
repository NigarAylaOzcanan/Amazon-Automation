package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.CheckoutProcessPOM;
import pages.SavedPaymentMethodsPOM;
import utilities.ConfigReader;
import utilities.GWD;
import utilities.ReusableMethods;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.Objects;

public class CheckoutProcessSteps extends ReusableMethods {

    CheckoutProcessPOM cp = new CheckoutProcessPOM();
    SavedPaymentMethodsPOM sp = new SavedPaymentMethodsPOM();
    public WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(ConfigReader.getIntProperty("explicit.wait")));
    double doubleSubTotal = 0;

    @Given("The user enters keyword in the search bar")
    public void theUserEntersKeywordInTheSearchBar() {
        cp.sendKeysFunction(cp.searchTextBox, "ruffles");
    }

    @When("The user clicks on the search submit button")
    public void theUserClicksOnTheSearchSubmitButton() {
        cp.clickFunction(cp.searchSubmitBtn);
    }

    @And("The user adds the products to buy in the cart")
    public void theUserAddsTheProductsToBuyInTheCart() {
        for (int i = 2; i >= 0; i--) {
            cp.clickFunction(cp.addToCardBtn.get(i));
            wait.until(ExpectedConditions.attributeToBe(cp.waitAddCartButton, "style", "display: none;"));
        }
    }

    @And("The user goes to cart")
    public void theUserGoesToCart() {
        cp.clickFunction(cp.goToCartBtn);
    }

    @Then("The user should be able to control products in the cart")
    public void theUserShouldBeAbleToControlProductsInTheCart() {

        double subTotal = 0;
        int step = 2;

        for (int i = 0; i < cp.productPrice.size(); i++) {
            String strProductPrice = cp.productPrice.get(i).getText().replaceAll("[^0-9,.-]", "");
            strProductPrice = strProductPrice.replace(",", ".");
            double doubleProductPrice = Double.parseDouble(strProductPrice);
            double doubleProductQuantity = Double.parseDouble(cp.productQuantity.get(i).getText());

            if (doubleProductQuantity == 0) {
                subTotal = 0;
            }

            subTotal = (doubleProductPrice * doubleProductQuantity) + subTotal;
        }

        BigDecimal bdSubTotal = new BigDecimal(subTotal);
        bdSubTotal = bdSubTotal.setScale(step, RoundingMode.HALF_UP);

        String strSubTotal = cp.subTotal.getText().replaceAll("[^0-9,.-]", "");
        strSubTotal = strSubTotal.replace(",", ".");
        doubleSubTotal = Double.parseDouble(strSubTotal);

        BigDecimal bdResultSubTotal = new BigDecimal(doubleSubTotal);
        bdResultSubTotal = bdResultSubTotal.setScale(step, RoundingMode.HALF_UP);

        Assert.assertEquals(bdResultSubTotal, bdSubTotal, "The sum of product prices is not " +
                " the same as the intermediate total price");
    }

    @When("The user clicks complete shopping")
    public void theUserClicksCompleteShopping() {
        cp.clickFunction(cp.proceedToCheckout);
    }

    @And("The user clicks to add credit card or bank card")
    public void theUserClicksToAddCreditCardOrBankCard() {
        if (!Objects.equals(getCurrentURL(), "https://www.amazon.com.tr/gp/buy/payselect/handlers/display.html?_from=cheetah")) {
            cp.clickFunction(cp.continueToPaymentStp);
            wait.until(driver -> driver.findElement(By.xpath("//a[text()='Kredi kartı veya banka kartı ekleyin']")).getText().contains("banka kartı"));
            cp.waitUntilElementToBeClickable(cp.amazonLogo);
            cp.jsClick(cp.amazonLogo);
            cp.jsClick(cp.stayPage);
            cp.clickFunction(cp.addCreditOrBankCard);
        } else {
            wait.until(driver -> driver.findElement(By.xpath("//a[text()='Kredi kartı veya banka kartı ekleyin']")).getText().contains("banka kartı"));
            cp.waitUntilElementToBeClickable(cp.amazonLogo);
            cp.jsClick(cp.amazonLogo);
            cp.jsClick(cp.stayPage);
            cp.clickFunction(cp.addCreditOrBankCard);
        }
    }

    @When("The user enters card details")
    public void theUserEntersCardDetails() {
        sp.iframeSwitchByElement(sp.iframeCreditCard);
        sp.sendKeysFunction(sp.addCreditCardNumber, ConfigReader.getProperty("cardNumber"));
        sp.sendKeysFunction(sp.accountHolderName, ConfigReader.getProperty("cardholderName"));
        sp.selectByText(sp.expirationDateMonth, "01");
        sp.selectByText(sp.expirationDateYear, "2028");
    }

    @And("The user clicks on save or not save credit card details for the next purchase")
    public void theUserClicksOnSaveOrNotSaveCreditCardDetailsForTheNextPurchase() {
        cp.waitUntilVisibilityOf(cp.bankCardWarning);
        cp.clickFunction(cp.NoRadioBtn);
        sp.clickFunction(sp.addCreditCardEvent);
        GWD.getDriver().switchTo().defaultContent();
    }

    @Then("The user should be able to see the message that the card information has not been saved")
    public void theUserShouldBeAbleToSeeTheMessageThatTheCardInformationHasNotBeenSaved() {
        cp.verifyContainsText(cp.paymentMethodNotSave, "kaydedilmeyecek");
    }

    @When("The user clicks  on use this payment tool")
    public void theUserClicksOnUseThisPaymentTool() {
        cp.jsClick(cp.thisPaymentMethod);
    }

    @And("The user clicks on use this address")
    public void theUserClicksOnUseThisAddress() {
        cp.jsClick(cp.thisAddress);
    }

    @Then("The user should be able to control total price")
    public void theUserShouldBeAbleToControlTotalPrice() {
        String strShippingFee = cp.shippingFee.getText().replaceAll("[^0-9,.-]", "");
        strShippingFee = strShippingFee.replace(",", ".");
        double doubleShippingFee = Double.parseDouble(strShippingFee);

        String strTotalPrice = cp.totalPrice.getText().replaceAll("[^0-9,.-]", "");
        strTotalPrice = strTotalPrice.replace(",", ".");
        double doubleTotalPrice = Double.parseDouble(strTotalPrice);

        Assert.assertEquals(doubleTotalPrice, doubleSubTotal + doubleShippingFee, "subtotal and shipping costs are " +
                " not equal to the total price");
    }

    @When("The user removes products from the cart")
    public void theUserRemovesProductsFromTheCart() {
        cp.jsClick(cp.amazonLogo);
        cp.clickFunction(cp.backToCart);
        wait.until(ExpectedConditions.urlToBe("https://www.amazon.com.tr/gp/cart/view.html/ref=chk_logo_return_to_cart"));
        for (int i = cp.deleteProduct.size() - 1; i >= 0; i--) {

            cp.jsClick(cp.deleteProduct.get(i));
            if (i - 1 == -1) {
                break;
            } else {
                wait.until(ExpectedConditions.stalenessOf(cp.deleteProduct.get(i - 1)));
            }
        }
    }

    @Then("The user should be able to verify that the cart is empty")
    public void theUserShouldBeAbleToVerifyThatTheCartIsEmpty() {
        cp.verifyContainsText(cp.cartIsEmptyText, "sepetiniz boş");
    }
}
