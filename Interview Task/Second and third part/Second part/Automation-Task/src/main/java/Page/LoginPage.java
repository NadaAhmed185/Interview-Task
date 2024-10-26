
package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    private By signINButton = By.id("userProfileMenu");
    private By emailFieldLocator = By.id("username");
    private By passwordFieldLocator = By.id("password");
    private By submitButtonLocator = By.id("submitBtn");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSignINButton() {
        driver.findElement(signINButton).click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailFieldLocator).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }

    public void clickOnSubmitButton() {
        driver.findElement(submitButtonLocator).click();
    }

    public void login(String email, String password) {
        clickOnSignINButton();
        enterEmail(email);
        enterPassword(password);
        clickOnSubmitButton();
    }
}
