import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class Homework17 extends BaseTest{
 @Test
 public void addSongToPlaylist() throws InterruptedException{

  String songAddedMessage = "Added 1 song into \"Mary's Playlist.\"";

  navigateToPage();
  provideEmailAddress("mary.crowley@testpro.io");
  providePassword("Password");
  clickSubmit();
  Thread.sleep(2000);
  searchSong("cinematic");
  clickViewAllButton();
  selectFirstSong();
  clickAddToButton();
  selectPlaylist();
  Assert.assertEquals(getSuccessMessage(), songAddedMessage);
 }

 public String getSuccessMessage() {
  WebElement notificationMessage = driver.findElement(By.cssSelector("body > div.alertify-logs.top.right > div"));
  return notificationMessage.getText();
 }
 public void selectPlaylist() throws InterruptedException{
  WebElement maryPlaylist = driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li.playlist"));
  maryPlaylist.click();
  Thread.sleep(2000);
 }

 public void clickAddToButton() throws InterruptedException{
  WebElement addToButton = driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > span > button.btn-add-to"));
  addToButton.click();
  Thread.sleep(2000);
 }

 public void selectFirstSong() throws InterruptedException{
  WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr > td.title"));
  firstSong.click();
  Thread.sleep(2000);
 }

 public void clickViewAllButton() throws InterruptedException{
  WebElement viewAllButton = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button"));
  viewAllButton.click();
  Thread.sleep(2000);
 }

 public void searchSong(String name) throws InterruptedException{
  WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
  searchField.clear();
  searchField.sendKeys(name);
  Thread.sleep(2000);
 }

}
