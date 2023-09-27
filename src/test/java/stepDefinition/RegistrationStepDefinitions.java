package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

import java.time.Duration;

public class RegistrationStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
//    @Before
//    public void openBrowser() {
//            WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--remote-allow-origins=*");
//            options.addArguments("--disable-popup-blocking");
//            options.addArguments("--disable-notifications");
//            driver = new ChromeDriver(options);
//            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        }
//    @After
//    public void closeBrowser(){
//        driver.quit();
//    }
    @When("I click Registration button")
    public void iClickRegistrationButton(){
        RegistrationPage registrationPagePage = new RegistrationPage(driver);
        registrationPagePage.clickRegistrationButton();
    }
    @Then("I am directed to Register new account or Reset your password page")
    public void registrationPageRedirect(){
       RegistrationPage registrationPage = new RegistrationPage(driver);
       registrationPage.verifyRegistrationPageURL();
    }
}