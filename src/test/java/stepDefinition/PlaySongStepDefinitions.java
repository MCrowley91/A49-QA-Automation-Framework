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
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class PlaySongStepDefinitions {
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
    @Given("I go to Login page")
    public void goToLoginPage(){
        driver.get("https:/qa.koel.app");
    }
    @When("I enter the email {string}")
    public void iEnterAnEmail1(String email){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }
    @And("I enter the password {string}")
    public void iEnterAPassword1(String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }
    @And("I click submit")
    public void clickSubmitButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmit();
    }
    @And("I click Play Next Song button")
    public void playNextSong(){
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