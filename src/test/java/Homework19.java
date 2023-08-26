import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test (description = "Homework19")
    public void deletePlaylist() throws InterruptedException {

        String deletionConfirmation = "Deleted playlist \"Playlist to be deleted.\"";

        navigateToPage();
        provideEmailAddress("mary.crowley@testpro.io");
        providePassword("Password");
        clickSubmit();
        Thread.sleep(2000);
        selectPlaylistToDelete();
        Thread.sleep(2000);
        clickDeleteButton();
        Assert.assertEquals(getSuccessMessage(), deletionConfirmation);
    }

    public String getSuccessMessage() {
        WebElement notificationMessage = driver.findElement(By.cssSelector(".success.show"));
        return notificationMessage.getText();
    }
    public void selectPlaylistToDelete() throws InterruptedException {
        WebElement playlistToDelete = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(5) > a"));
        playlistToDelete.click();
    }
    public void clickDeleteButton() throws InterruptedException {
        WebElement deletePlaylistButton = driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        deletePlaylistButton.click();
    }
}
