package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitButton = By.cssSelector("button[type='submit']");

    public void provideEmail(String email) {
    findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password) {
    findElement(passwordField).sendKeys(password);
    }
    public void clickSubmit() {
        findElement(submitButton).click();
    }
    public void login() {
        provideEmail("mary.crowley@testpro.io");
        providePassword("Password");
        clickSubmit();
    }
}
