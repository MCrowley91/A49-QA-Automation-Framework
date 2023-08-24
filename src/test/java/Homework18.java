import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

@Test (description = "Homework 18")
    public void playSong() throws InterruptedException{
navigateToPage();
provideEmailAddress("mary.crowley@testpro.io");
providePassword("Password");
clickSubmit();
Thread.sleep(2000);
clickPlayNextSong();
clickPlay();
WebElement pauseButton = driver.findElement(By.cssSelector("[title='Pause']"));
Assert.assertTrue(pauseButton.isDisplayed());

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
