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
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        actions = new Actions(driver);
    }
@FindBy(css = "img.avatar")
private WebElement userAvatarIcon;
@FindBy(css=".side.player-controls")
private WebElement sidePlayerControlPanel;
@FindBy(css = "[title='Play next song']")
private WebElement playNextSongButton;
@FindBy(css ="[title='Play or resume']")
private WebElement playButton;
@FindBy(css = "[title='Pause']")
private WebElement pauseButton;
@FindBy(xpath = "//*[contains(text(),'New Playlist')]")
private WebElement newPlaylistMenuButton;
@FindBy(css = "[type=\"text\"]")
private WebElement newPlaylistNameField;
@FindBy(css = ".success.show")
private WebElement successMessagePopUp1;
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
public  String renamedPlaylistMessage = "Updated playlist \"New Name.\"";
public String deletedEmptyPlaylistMessage = "Deleted playlist \"Empty Playlist.\"";
public String songAddedMessage = "Added 1 song into \"Mary's Playlist.\"";
public String playlistCreatedMessage = "Created playlist \"Empty Playlist.\"";

public HomePage selectPlaylist() {
    WebElement maryPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),\"Mary's Playlist\")]")));
    maryPlaylist.click();
    return this;
}
public HomePage clickAddToButton() {
    WebElement addToButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title=\"Add selected songs to…\"]")));
    addToButton.click();
    return this;
}
public HomePage selectFirstSong() {
    WebElement firstSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]")));
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
    public void clickPlayNextSong(){
    WebElement sidePlayerControlPanel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".side.player-controls")));
    sidePlayerControlPanel.click();
    findElement(playNextSongButton).click();
    }
public HomePage clickPlay() {
    findElement(playButton).click();
    return this;
}
public HomePage doubleClickPlaylist() {
    WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(4) > a")));
    actions.doubleClick(playlist).perform();
    return this;
}
public HomePage inputNewPlaylistName() {
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
public HomePage createEmptyPlaylist(){
    WebElement createNewPlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Create a new playlist']")));
    createNewPlaylistButton.click();
    newPlaylistMenuButton.click();
    newPlaylistNameField.sendKeys("Empty Playlist");
    newPlaylistNameField.sendKeys(Keys.ENTER);
//    WebElement newEmptyPlaylistHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),\"Empty Playlist\")]")));
//    Assert.assertTrue(newEmptyPlaylistHeader.isDisplayed());
    return this;
}
public HomePage selectEmptyPlaylistToDelete() {
    WebElement emptyPlaylistToDelete = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists > ul > li:nth-child(4) > a")));
    emptyPlaylistToDelete.click();
    return this;
}
public HomePage clickDeleteButton() {
    WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Delete this playlist']")));
    deletePlaylistButton.click();
    return this;
}
public HomePage clickToClearSuccessMessage(){
    WebElement successMessagePopUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show")));
    successMessagePopUp.click();
    return this;
}
}