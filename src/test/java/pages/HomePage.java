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

import java.time.Duration;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        actions = new Actions(driver);
    }


    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;

    @FindBy(css = "[title='Play next song']")
    private WebElement playNextSongButton;
    @FindBy(css ="[title='Play or resume']")
    private WebElement playButton;
    @FindBy(css = "[title='Pause']")
    private WebElement pauseButton;
    public WebElement getUserAvatar() {

        return findElement(userAvatarIcon);
    }

    public void checkAvatarIsDisplayed() {
        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[alt='Avatar of student']")));
        Assert.assertTrue(avatar.isDisplayed());
    }
    public void checkPauseButtonIsDisplayed(){
        findElement(pauseButton);
        Assert.assertTrue(pauseButton.isDisplayed());
    }

    public  String confirmationMessage = "Updated playlist \"New Name.\"";
    public String deletionConfirmation = "Deleted playlist \"Playlist homework20.\"";
    public String songAddedMessage = "Added 1 song into \"Mary's Playlist.\"";

    public HomePage selectPlaylist() {
        WebElement maryPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#songsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li:nth-child(6)")));
        maryPlaylist.click();
        return this;
    }

    public HomePage clickAddToButton() {
        WebElement addToButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > span > button.btn-add-to")));
        addToButton.click();
        return this;
    }

    public HomePage selectFirstSong() {
        WebElement firstSong = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr > td.title")));
        firstSong.click();
        return this;
    }

    public HomePage clickViewAllButton() {
        WebElement viewAllButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button")));
        viewAllButton.click();
        return this;
    }

    public HomePage searchSong(String name) {
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='search']")));
        searchField.clear();
        searchField.sendKeys(name);
        return this;
    }
    public HomePage clickPlay() {
        findElement(playButton).click();
        return this;
    }

    public void clickPlayNextSong() {
        findElement(playNextSongButton).click();
    }

    public HomePage doubleClickPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(4) > a")));
        actions.doubleClick(playlist).perform();
        return this;
    }

    public HomePage inputNewName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys("New Name");
        playlistInputField.sendKeys(Keys.ENTER);
        return this;
    }

    public HomePage confirmDeletion() {
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ok")));
        okButton.click();
        return this;
    }

    public String getSuccessMessage() {
        WebElement notificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show")));
        return notificationMessage.getText();
    }

    public HomePage selectPlaylistToDelete() {
        WebElement playlistToDelete = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists > ul > li:nth-child(3) > a")));
        playlistToDelete.click();
        return this;
    }

    public HomePage clickDeleteButton() {
        WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Delete this playlist']")));
        deletePlaylistButton.click();
        return this;
    }
}