import com.fasterxml.jackson.databind.ser.Serializers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
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

import java.time.Duration;
import java.util.concurrent.locks.Condition;

public class PlaylistTests extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    BasePage basePage;
    @BeforeMethod
    public void launchBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }
    @Test(description = "Create empty playlist")
    public void createEmptyPlaylist() {
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        basePage.navigateToPage(url);
        loginPage.login();
        homePage.createEmptyPlaylist();
        Assert.assertEquals(homePage.getSuccessMessage(), homePage.playlistCreatedMessage);
    }
    @Test(description = "Rename playlist")
    public void renamePlaylist(){
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        basePage.navigateToPage(url);
        loginPage.login();
        homePage.createEmptyPlaylist()
                .clickToClearSuccessMessage()
                .doubleClickPlaylist()
                .inputNewPlaylistName();
        Assert.assertEquals(homePage.getSuccessMessage(), homePage.renamedPlaylistMessage);
    }
    @Test(description = "Add song to playlist--requires song that does not already exist in Mary's Playlist to run successfully")
    public void addSongToPlaylist(){
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        basePage.navigateToPage(url);
        loginPage.login();
        homePage.searchSong("bornking")
                .clickViewAllButton()
                .selectFirstSong()
                .clickAddToButton()
                .selectPlaylist();
        Assert.assertEquals(homePage.getSuccessMessage(), homePage.songAddedMessage);
    }
    @Test(description = "Delete empty playlist")
    public void deleteEmptyPlaylist() {
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        basePage.navigateToPage(url);
        loginPage.login();
        homePage.createEmptyPlaylist()
                .clickToClearSuccessMessage()
                .selectEmptyPlaylistToDelete()
                .clickDeleteButton();
        Assert.assertEquals(homePage.getSuccessMessage(), homePage.deletedEmptyPlaylistMessage);
    }
    @AfterMethod
    public void quitBrowser(){
        HomePage homePage = new HomePage(driver);
        homePage.selectEmptyPlaylistToDelete()
                        .clickDeleteButton();
        driver.quit();
    }
}
