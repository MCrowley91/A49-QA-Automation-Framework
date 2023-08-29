import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{

    String confirmationMessage = "Updated playlist \"New Name.\"";

    @Test (description = "Homework21")
    public void renamePlaylist() {
        navigateToPage();
        provideEmailAddress("mary.crowley@testpro.io");
        providePassword("Password");
        clickSubmit();
        doubleClickPlaylist();
        inputNewName();
        Assert.assertEquals(getSuccessMessage(), confirmationMessage);
    }

    public void doubleClickPlaylist() {
    WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(4) > a")));
    actions.doubleClick(playlist).perform();
}
public void inputNewName() {
    WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
    playlistInputField.sendKeys(Keys.chord(Keys.COMMAND,"A",Keys.BACK_SPACE));
    playlistInputField.sendKeys("New Name");
    playlistInputField.sendKeys(Keys.ENTER);
}
public String getSuccessMessage() {
        WebElement notificationMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div.alertify-logs.top.right > div")));
        return notificationMessage.getText();
}
}
