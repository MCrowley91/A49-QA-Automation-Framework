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

import java.time.Duration;

public class PlaySongStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    public Actions actions = null;
//    @Before
//    public void openBrowser() {
//            WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--remote-allow-origins=*");
//            options.addArguments("--disable-popup-blocking");
//            options.addArguments("--disable-notifications");
//            driver = new ChromeDriver(options);
//            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            actions = new Actions(driver);
//        }
//    @After
//    public void closeBrowser(){
//        driver.quit();
//    }

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