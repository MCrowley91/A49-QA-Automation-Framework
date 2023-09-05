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
        url = BaseURL;
        basePage = new BasePage(driver);
        basePage.navigateToPage(url);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        albumArtistPage = new AlbumArtistPage(driver);
        allSongsPage = new AllSongsPage(driver);
        profilePreferencesPage = new ProfilePreferencesPage(driver);
        registrationPage = new RegistrationPage(driver);

    }

    @AfterMethod
    public void closeBrowser() {
        basePage.quitBrowser();
    }
}