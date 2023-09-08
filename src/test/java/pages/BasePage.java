package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void navigateToPage(String url) {
        driver.get(url);
    }
//    public void quitBrowser() {
//        driver.quit();
//    }
//
//    public void clickOnElement(By locator){
//        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
//        el.click();
//    }
//    public void enterText(By locator, String text) {
//        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
//        el.click();
//        el.clear();
//        el.sendKeys(text);
//    }
//    public void clickOnOk() {
//        WebElement okButton = driver.findElement(By.cssSelector(".ok"));
//        okButton.click();
//    }
//    public void checkShowSuccess() {
//        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
//        Assert.assertTrue(notification.isDisplayed());
//    }
}
