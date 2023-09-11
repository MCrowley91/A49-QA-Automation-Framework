import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;

public class BaseTest {
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static WebDriver getThreadDriver(){
        return threadDriver.get();
    }
    public static WebDriver driver = null;
    public String url = "https://qa.koel.app/";
    WebDriverWait wait = null;
    Actions actions = null;
    BasePage basePage;
    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;

    @BeforeTest
    public void setupTest() throws MalformedURLException {
        threadDriver.set(setupBrowser(System.getProperty("browser")));
        wait = new WebDriverWait(getThreadDriver(), Duration.ofSeconds(10));
        actions = new Actions(getThreadDriver());
        getThreadDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getThreadDriver().get(url);

    }
    @AfterMethod
    public void closeBrowser(){
        threadDriver.get().close();
        threadDriver.remove();
    }
//    public void closeBrowser() {
//        driver.quit();
//    }
        WebDriver setupBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.215:4444";
        switch(browser){
            case "firefox":
                return setupFirefox();
            case "chrome":
                return setupChrome();
            case "safari":
                return setupSafari();
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            default:
                return setupChrome();
        }
    }
    public void launchBrowser () {
        basePage = new BasePage(driver);
        basePage.navigateToPage(url);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    public WebDriver setupFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;
    }

    public WebDriver setupSafari() {
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        return driver;
    }
    public WebDriver setupChrome(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        return driver;
    }
}