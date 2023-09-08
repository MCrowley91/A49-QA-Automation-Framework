import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

import java.net.MalformedURLException;
import java.net.URI;

public class Homework25 extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void testSetup(){
        loginPage = new LoginPage(getThreadDriver());
        driver.get(url);
        homePage = new HomePage(getThreadDriver());
    }

    @Test (priority = 1, description = "Homework 25")
    public void loginTest(){
        loginPage.provideEmail("mary.crowley@testpro.io")
                .providePassword("Password")
                .clickSubmit();
        homePage.checkAvatarIsDisplayed();
    }

    @Test (priority = 2, description = "Another Homework 25 Test")
    public void registrationButtonTest(){
        registrationPage = new RegistrationPage(getThreadDriver());

        registrationPage.registrationNavigation();
    }
}
