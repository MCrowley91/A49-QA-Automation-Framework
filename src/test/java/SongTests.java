import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class SongTests extends BaseTest {

    @Test(description = "Play Song")
    public void playSong() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail("mary.crowley@testpro.io")
                 .providePassword("Password")
                 .clickSubmit();
        homePage.clickPlayNextSong();
        homePage.checkPauseButtonIsDisplayed();
    }

    public void clickPlay() throws InterruptedException{
        WebElement playButton = driver.findElement(By.cssSelector("[title='Play or resume']"));
        playButton.click();
        Thread.sleep(2000);
    }

    public void clickPlayNextSong() throws InterruptedException{
        WebElement playNextButton = driver.findElement(By.cssSelector("[title='Play next song']"));
        playNextButton.click();
        Thread.sleep(2000);
    }
}

