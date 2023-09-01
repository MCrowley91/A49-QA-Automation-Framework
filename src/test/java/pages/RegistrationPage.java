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

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }
        public void registrationNavigation() {
            WebElement registrationButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div > div > form > div:nth-child(5) > a")));
            registrationButton.click();
            Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/registration");
    }
}
