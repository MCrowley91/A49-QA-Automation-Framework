import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest {

@Test (priority = 1, description = "Homework22 - POM Test")
public void pomTest() {
    loginPage.login();
    homePage.checkAvatarIsDisplayed();
}
@Test (priority = 2, description = "Test to validate the Registration link")
public void registrationLinkTest(){
    registrationPage.registrationNavigation();
    }

}