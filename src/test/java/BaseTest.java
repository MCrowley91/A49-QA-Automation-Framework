import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;

public class BaseTest {
    public WebDriver driver = null;
    public String url;;
    WebDriverWait wait;

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
        url = BaseURL;
    }

    public void navigateToPage() throws InterruptedException {
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        driver.quit();
    }
    public void provideEmailAddress(String email) throws InterruptedException {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) throws InterruptedException {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() throws InterruptedException {
        WebElement logInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']")));
        logInButton.click();
    }
}