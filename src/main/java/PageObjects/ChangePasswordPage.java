package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage {
    /**
     * Locators
     */
    private By currentPasswordElement = By.xpath("//input[@id='currentPassword']");
    private By newPasswordElement = By.xpath("//input[@id='newPassword']");
    private By confirmPasswordElement = By.xpath("//input[@id='confirmPassword']");
    private By changePasswordButton = By.xpath("//input[@value='Change Password']");
    private By messageError = By.xpath("//p[@class='message error']");

    /**
     * Elements
     */
    public WebElement getCurrentPasswordTab () {
        return Constant.WEBDRIVER.findElement(currentPasswordElement);
    }

    public WebElement getNewPasswordElement () {
        return Constant.WEBDRIVER.findElement(newPasswordElement);
    }

    public WebElement getConfirmPasswordElement () {
        return Constant.WEBDRIVER.findElement(confirmPasswordElement);
    }

    public WebElement getChangePasswordButton () {
        return Constant.WEBDRIVER.findElement(changePasswordButton);
    }

    public WebElement getMessageErrorElement () {
        return Constant.WEBDRIVER.findElement(messageError);
    }

    /**
     * Methods
     */
    public void typeCurrentPasswordField (String currentPassword) {
        getCurrentPasswordTab().sendKeys(currentPassword);
    }

    public void typeNewPasswordField (String newPassword) {
        getNewPasswordElement().sendKeys(newPassword);
    }

    public void typeConfirmPasswordField (String confirmPassword) {
        getConfirmPasswordElement().sendKeys(confirmPassword);
    }

    public void clickChangePasswordButton () {
        getChangePasswordButton().click();
    }

    public String getMessageErrorText () {
        return getMessageErrorElement().getText();
    }

    public void changePassword (String currentPass, String newPass, String confirmNewPass) {
        typeCurrentPasswordField(currentPass);
        typeNewPasswordField(newPass);
        typeConfirmPasswordField(confirmNewPass);
        clickChangePasswordButton();
    }
}
