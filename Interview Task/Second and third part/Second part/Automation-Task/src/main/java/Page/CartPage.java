package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    WebDriver driver;

    By cartIcon = By.className("cart-btn");
    By cartItems = By.xpath("(//input[contains(@class, 'counter-disabled')])");
    By proceedToCheckoutButton = By.className("checkout-btn");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    public int getItemsCount() {
        List<WebElement> items = driver.findElements(cartItems);
        return items.size();
    }
    public boolean isProceedToCheckoutButtonPresent() {
        List<WebElement> elements = driver.findElements(proceedToCheckoutButton);
        return !elements.isEmpty();
    }

}

