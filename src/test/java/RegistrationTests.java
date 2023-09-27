import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegistrationTests extends BaseTest{
    LoginPage loginPage;
    HomePage homePage;
    RegistrationPage registrationPage;

    @BeforeMethod
    public void testSetup(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }
    @Test(priority = 2, description = "Registration page test")
    public void registrationButtonTest(){
        registrationPage = new RegistrationPage(driver);
        registrationPage.clickRegistrationButton();
        wait.until(ExpectedConditions.urlMatches("https://qa.koel.app/registration"));
        //Assert.assertEquals(getThreadDriver().getCurrentUrl(), "https://qa.koel.app/registration"));
    }
}
