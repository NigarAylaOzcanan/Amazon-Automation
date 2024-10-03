package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import pages.CheckoutProcessPOM;
import pages.LoginPOM;
import pages.WishlistFeaturePOM;
import utilities.GWD;
import java.util.ArrayList;
import java.util.List;

public class WishlistFeatureSteps {

    CheckoutProcessPOM cp = new CheckoutProcessPOM();
    WishlistFeaturePOM wf = new WishlistFeaturePOM();
    LoginPOM login = new LoginPOM();

    List<String> nameOfProducts = new ArrayList<>();

    @Given("The user enters the product name in the search bar")
    public void theUserEntersTheProductNameInTheSearchBar() {
        cp.sendKeysFunction(cp.searchTextBox, "Telefon Kılıfı");
    }

    @And("The user adds products to wishlist")
    public void theUserAddsProductsToWishlist() {

        nameOfProducts = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            wf.safeClick(wf.productList.get(wf.randomGenerator(wf.productList.size())));
            nameOfProducts.add(wf.productTitle.getText());
            wf.safeClick(wf.addWishListBtn);
            wf.verifyContainsText(wf.wishListText, "eklendi");
            if (i == 2) {
                wf.safeClick(wf.viewListBtn);
            } else {
                wf.safeClick(wf.continueShoppingBtn);
                GWD.getDriver().navigate().back();
            }

        }
    }

    @Then("The user should be able to verify the products added to the wish list")
    public void theUserShouldBeAbleToVerifyTheProductsAddedToTheWishList() {

        for (int i = 0; i < nameOfProducts.size(); i++) {
            wf.listContainsString(wf.wishlistItemText, nameOfProducts.get(i));
        }

        for (String a : nameOfProducts) { // Seçilen Ürün Adları
            System.out.println(a);
        }

        for (WebElement b : wf.wishlistItemText) { // İstek Listesindeki Ürün Adları
            System.out.println(b.getText());
        }

    }

    @Given("The user clicks the wishlist that is in the submenu of the account")
    public void theUserClicksTheWishlistThatIsInTheSubmenuOfTheAccount() {
        login.hoverOver(login.loginButton);
        wf.safeClick(wf.wishlistBtn);

    }

    @When("The user removes products from the wishlist")
    public void theUserRemovesProductsFromTheWishlist() {
        for (int i = 0; i < wf.deleteWishListBtn.size(); i++) {
            wf.safeClick(wf.deleteWishListBtn.get(i));
        }
        wf.refreshPage();
    }

    @Then("The user should be able to verify that the wishlist is empty")
    public void theUserShouldBeAbleToVerifyThatTheWishlistIsEmpty() {
        wf.verifyContainsText(wf.listEmptyText, "Bu Liste boş.\n" +
                "Satın almak istediğiniz ürünleri ekleyin.");
    }
}
