package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;

    public WebElement getUserAvatar() {
        return userAvatarIcon;
    }

    public void checkAvatarIsDisplayed() {
        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[alt='Avatar of student']")));
        Assert.assertTrue(avatar.isDisplayed());
    }

    public  String confirmationMessage = "Updated playlist \"New Name.\"";
    public String deletionConfirmation = "Deleted playlist \"Playlist homework20.\"";
    public String songAddedMessage = "Added 1 song into \"Mary's Playlist.\"";

//    public void selectPlaylist() {
//        WebElement maryPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#songsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li:nth-child(6)")));
//        maryPlaylist.click();
//    }
//
//    public void clickAddToButton() {
//        WebElement addToButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > span > button.btn-add-to")));
//        addToButton.click();
//    }
//
//    public void selectFirstSong() {
//        WebElement firstSong = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr > td.title")));
//        firstSong.click();
//    }
//
//    public void clickViewAllButton() {
//        WebElement viewAllButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button")));
//        viewAllButton.click();
//    }
//
//    public void searchSong(String name) {
//        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='search']")));
//        searchField.clear();
//        searchField.sendKeys(name);
//    }
//    public void clickPlay() {
//        WebElement playButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Play or resume']")));
//        playButton.click();
//    }
//
//    public void clickPlayNextSong() {
//        WebElement playNextButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Play next song']")));
//        playNextButton.click();
//    }
//
//    public void doubleClickPlaylist() {
//        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(4) > a")));
//        actions.doubleClick(playlist).perform();
//    }
//
//    public void inputNewName() {
//        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
//        playlistInputField.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
//        playlistInputField.sendKeys("New Name");
//        playlistInputField.sendKeys(Keys.ENTER);
//    }
//
//    public void confirmDeletion() {
//        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ok")));
//        okButton.click();
//    }
//
//    public String getSuccessMessage() {
//        WebElement notificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show")));
//        return notificationMessage.getText();
//    }
//
//    public void selectPlaylistToDelete() {
//        WebElement playlistToDelete = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists > ul > li:nth-child(3) > a")));
//        playlistToDelete.click();
//    }
//
//    public void clickDeleteButton() {
//        WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Delete this playlist']")));
//        deletePlaylistButton.click();
//    }
}