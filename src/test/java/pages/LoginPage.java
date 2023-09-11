package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginPage extends BasePage {
    WebDriverWait wait;
    public LoginPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    @FindBy(css = "input[type='email']")
    private WebElement emailField;
    @FindBy(css = "input[type='password']")
    private WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    public LoginPage provideEmail(String email) {
        findElement(emailField).clear();
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage providePassword(String password) {
        findElement(passwordField).clear();
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmit() {
        findElement(submitButton).click();
        return this;
    }
    public LoginPage login() {
        provideEmail("mary.crowley@testpro.io");
        providePassword("Password");
        clickSubmit();
        return this;
    }
}
