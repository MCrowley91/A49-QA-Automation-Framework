package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePreferencesPage extends BasePage {
    public ProfilePreferencesPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }
    By currentPasswordField = By.cssSelector("#inputProfileCurrentPassword");
    By nameField = By.cssSelector("#inputProfileName");
    By emailAddressField = By.cssSelector("#inputProfileEmail");
    By newPasswordField = By.cssSelector("#inputProfileNewPassword");
    By saveButton = By.cssSelector(".btn-submit");


}
