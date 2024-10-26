package steps;

import Page.HomePage;
import Page.CartPage;
import Page.LoginPage;
import io.cucumber.java.en.*;
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class StepDefinitions {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;


    @Given("the user is on the Vodafone eShop homepage")
    public void the_user_is_on_the_Vodafone_eShop_homepage() {
        driver = DriverFactory.getDriver();
        driver.get("https://eshop.vodafone.com.eg/ar/");
        homePage = new HomePage(driver);
        loginPage  = new LoginPage(driver);
        cartPage = new CartPage(driver);

    }
    @And("the user closes cookie popUp")
    public void the_user_closes_cookie_popUp() {
        homePage.closeCookiePopUp();

    }
    @And("the user is logged in with mobile phone  and password")
    public void theUserIsLoggedInWithmobilephoneAndPassword() {
        loginPage.login("01067816977", "Nada123@ahmed");
    }
    @When("the user selects {int} items to add to the cart")
    public void the_user_selects_items_to_add_to_the_cart(int itemsToAdd) {
        if (itemsToAdd > 0) {
            homePage.addFirstProductToCart();
        }
    }
    @When("the user searches for another item to add to the cart")
    public void the_user_searches_for_another_item_to_add_to_the_cart() {
            homePage.searchAndAddProductToCart("Apple Watch Series");
        }
    @Then("the items should be added to the cart successfully")
    public void the_items_should_be_added_to_the_cart_successfully() {
        cartPage.openCart();
        int itemsCount = cartPage.getItemsCount();
        Assert.assertEquals(2, itemsCount);

    }
    @After
    public void tearDown() {
        DriverFactory.closeDriver();
    }

}
