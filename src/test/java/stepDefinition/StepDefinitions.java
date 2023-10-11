package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

import java.time.Duration;

public class StepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    public Actions actions = null;
    @Before
    public void openBrowser() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            actions = new Actions(driver);
        }
    @After
    public void closeBrowser(){
        driver.quit();
    }
    @Given("I open Login page")
    public void openLoginPage(){
        driver.get("https:/qa.koel.app");
    }
    @When("I enter email {string}")
    public void iEnterMyEmail(String email){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }
    @And("I enter password {string}")
    public void iEnterMyPassword(String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }
    @And("I submit")
    public void iClickSubmit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmit();
    }
    @Then("I am logged in")
    public void userIsLoggedIn(){
        HomePage homePage = new HomePage(driver);
        homePage.checkAvatarIsDisplayed();
    }
    @Then("I remain on the login page")
    public void userRemainsOnLoginPage(){
        LoginPage loginPage = new LoginPage(driver);
        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
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

    @And("I click Play Next Song button")
    public void clickPlayNextSong(){
        HomePage homePage = new HomePage(driver);
        homePage.clickPlayNextSong();
    }
    @And("I click Play button")
    public void clickPlay(){
        HomePage homePage = new HomePage(driver);
        homePage.clickPlay();
    }
    @Then("the Pause button appears")
    public void pauseButtonAppears(){
        HomePage homePage = new HomePage(driver);
        homePage.checkPauseButtonIsDisplayed();
    }
}