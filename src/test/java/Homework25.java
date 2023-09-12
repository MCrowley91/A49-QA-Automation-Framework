import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
    HomePage homePage;
    RegistrationPage registrationPage;

    @BeforeMethod
    public void testSetup(){
        loginPage = new LoginPage(getThreadDriver());
        homePage = new HomePage(getThreadDriver());
    }

    @Test (priority = 1, description = "Homework 25")
    public void loginTest(){
        loginPage = new LoginPage(getThreadDriver());
        homePage = new HomePage(getThreadDriver());
        loginPage.provideEmail("mary.crowley@testpro.io")
                .providePassword("Password")
                .clickSubmit();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test (priority = 2, description = "Another Homework 25 Test")
    public void registrationButtonTest(){
        registrationPage = new RegistrationPage(getThreadDriver());
        registrationPage.clickRegistrationButton();
        wait.until(ExpectedConditions.urlMatches("https://qa.koel.app/registration"));
                //Assert.assertEquals(getThreadDriver().getCurrentUrl(), "https://qa.koel.app/registration"));
    }
}
