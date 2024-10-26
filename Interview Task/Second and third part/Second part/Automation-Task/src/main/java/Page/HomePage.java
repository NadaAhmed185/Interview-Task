package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    By product1 = By.xpath("(//p[contains(@class, 'main-text main-text-trim bodyFont')])[1]");
    By addToCartButton = By.xpath("//button[contains(@class, 'add-to-cart')]");

    By searchBox = By.id("searchInput");
    By searchButton = By.xpath("(//p['Apple Watch Series 8 GPS 45mm'])[8]");
    By closeCookie = By.xpath("//button[@class='onetrust-close-btn-handler banner-close-button ot-close-icon']");

    public HomePage(WebDriver driver) {
        this.driver = driver;

    }

    public void addFirstProductToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productElement = wait.until(ExpectedConditions.elementToBeClickable(product1));
        productElement.click();
        WebElement addToCartElement = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartElement.click();
        driver.navigate().back();
}

    public void searchAndAddProductToCart(String productName) {
        WebElement searchBoxElement = driver.findElement(searchBox);
        searchBoxElement.click();
        searchBoxElement.sendKeys(productName);
        driver.findElement(searchButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCartButtonElement = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButtonElement.click();
    }

    public void closeCookiePopUp() {
        driver.findElement(closeCookie).click();
    }

}
