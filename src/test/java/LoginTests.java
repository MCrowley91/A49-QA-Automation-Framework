import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    RegistrationPage registrationPage;

    @BeforeMethod
    public void testSetup(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test (priority = 1, description = "Login correct credentials")
    public void loginTest(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.provideEmail("mary.crowley@testpro.io")
                .providePassword("Password")
                .clickSubmit();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
}
