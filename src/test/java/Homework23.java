import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class Homework23 extends BaseTest {

    @Test (priority = 1, description = "Homework 23")
        public void loginTest(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        loginPage.provideEmail("mary.crowley@testpro.io")
                 .providePassword("Password")
                 .clickSubmit();
        homePage.checkAvatarIsDisplayed();
        }

    @Test (priority = 2, description = "Another Homework 23 Test")
    public void registrationButtonTest(){
        registrationPage = new RegistrationPage(driver);

        registrationPage.registrationNavigation();
    }
    }
