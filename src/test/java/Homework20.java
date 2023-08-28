import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework20 extends BaseTest{
    @Test (description = "Homework20")
    public void deletePlaylist() throws InterruptedException {

        String deletionConfirmation = "Deleted playlist \"Playlist homework20.\"";

        navigateToPage();
        provideEmailAddress("mary.crowley@testpro.io");
        providePassword("Password");
        clickSubmit();
        selectPlaylistToDelete();
        clickDeleteButton();
        confirmDeletion();
        Assert.assertEquals(getSuccessMessage(), deletionConfirmation);
    }

    public void confirmDeletion() throws InterruptedException {
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ok")));
        okButton.click();
    }
    public String getSuccessMessage() {
        WebElement notificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show")));
        return notificationMessage.getText();
    }
    public void selectPlaylistToDelete() throws InterruptedException {
        WebElement playlistToDelete = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists > ul > li:nth-child(3) > a")));
        playlistToDelete.click();
    }
    public void clickDeleteButton() throws InterruptedException {
        WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Delete this playlist']")));
        deletePlaylistButton.click();
    }
}