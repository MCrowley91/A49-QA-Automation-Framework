import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.*;

import java.net.URL;
import java.time.Duration;
import java.time.Instant;

public class BaseTest {
    public static WebDriver driver = null;
    public static String url;;
    public static WebDriverWait wait;
    public static Actions actions = null;
    BasePage basePage;
    AlbumArtistPage albumArtistPage;
    AllSongsPage allSongsPage;
    HomePage homePage;
    LoginPage loginPage;
    ProfilePreferencesPage profilePreferencesPage;
    RegistrationPage registrationPage;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})

    public void launchBrowser (String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        actions = new Actions(driver);
        url = BaseURL;
        basePage = new BasePage(driver, wait, actions);
        basePage.navigateToPage(url);
        loginPage = new LoginPage(driver, wait, actions);
        homePage = new HomePage(driver, wait, actions);
        albumArtistPage = new AlbumArtistPage(driver, wait, actions);
        allSongsPage = new AllSongsPage(driver, wait, actions);
        profilePreferencesPage = new ProfilePreferencesPage(driver, wait, actions);
        registrationPage = new RegistrationPage(driver, wait, actions);

    }

    @AfterMethod
    public void closeBrowser() {
        basePage.quitBrowser();
    }
}