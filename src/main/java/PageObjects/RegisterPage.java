package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    /**
     * Locators
     */
    private By emailRegisterForm = By.xpath("//input[@id='email']");
    private By passwordRegisterForm = By.xpath("//input[@id='password']");
    private By confirmPasswordRegisterForm = By.xpath("//input[@id='confirmPassword']");
    private By pidRegisterForm = By.xpath("//input[@id='pid']");
    private By registerButton = By.xpath("//input[@value='Register']");

    /**
     * Elements
     */
    public WebElement getEmailOfRegisterForm () {
        return Constant.WEBDRIVER.findElement(emailRegisterForm);
    }

    public WebElement getPasswordOfRegisterForm () {
        return Constant.WEBDRIVER.findElement(passwordRegisterForm);
    }

    public WebElement getConfirmPasswordOfRegisterForm () {
        return Constant.WEBDRIVER.findElement(confirmPasswordRegisterForm);
    }

    public WebElement getPidOfRegisterForm () {
        return Constant.WEBDRIVER.findElement(pidRegisterForm);
    }

    public WebElement getRegisterButton () {
        return Constant.WEBDRIVER.findElement(registerButton);
    }

    /**
     * Methods
     */
    public void typeInfoForEmailField (String email) {
        getEmailOfRegisterForm().sendKeys(email);
    }

    public void typeInfoForPasswordField (String password) {
        getPasswordOfRegisterForm().sendKeys(password);
    }

    public void typeInfoForConfirmPassField (String confirmPass) {
        getConfirmPasswordOfRegisterForm().sendKeys(confirmPass);
    }

    public void typeInfoForPIDField (String PID) {
        getPidOfRegisterForm().sendKeys(PID);
    }

    public void clickRegisterButton () {
        getRegisterButton().click();
    }

    public void register (String email, String password, String confirmPass, String PID) {
        typeInfoForEmailField(email);
        typeInfoForPasswordField(password);
        typeInfoForConfirmPassField(confirmPass);
        typeInfoForPIDField(PID);
        clickRegisterButton();
    }
}
