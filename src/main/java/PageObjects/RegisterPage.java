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
    private By confirmRegisterSuccessfully = By.xpath("//div[@id='content']/descendant::p");
    private By messageError = By.xpath("//p[@class='message error']");
    private By invalidPasswordMessage = By.xpath("//label[@for='password'][@class='validation-error']");
    private By invalidIDMessage = By.xpath("//label[@for='pid'][@class='validation-error']");

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

    public WebElement getConfirmRegisterSuccessfully () {
        return Constant.WEBDRIVER.findElement(confirmRegisterSuccessfully);
    }

    public WebElement getMessageError () {
        return Constant.WEBDRIVER.findElement(messageError);
    }

    public WebElement getInvalidPasswordMessage () {
        return Constant.WEBDRIVER.findElement(invalidPasswordMessage);
    }

    public WebElement getInvalidIDMessage () {
        return Constant.WEBDRIVER.findElement(invalidIDMessage);
    }

    /**
     * Methods
     */
    public void typeEmailFieldForRegisterForm (String email) {
        getEmailOfRegisterForm().sendKeys(email);
    }

    public void typePasswordFieldForRegisterForm (String password) {
        getPasswordOfRegisterForm().sendKeys(password);
    }

    public void typeConfirmPasswordFieldForRegisterForm (String confirmPassword) {
        getConfirmPasswordOfRegisterForm().sendKeys(confirmPassword);
    }

    public void typePidFieldForRegisterForm (String pid) {
        getPidOfRegisterForm().sendKeys(pid);
    }

    public void clickRegisterButton () {
        getRegisterButton().click();
    }

    public String getConfirmRegisterContent () {
        return getConfirmRegisterSuccessfully().getText();
    }

    public String getMessageErrorText () {
        return getMessageError().getText();
    }

    public String getInvalidPasswordText () {
        return getInvalidPasswordMessage().getText();
    }

    public String getInvalidIDText () {
        return getInvalidIDMessage().getText();
    }

    public void register (String email, String password, String confirmPass, String PID) {
        typeEmailFieldForRegisterForm(email);
        typePasswordFieldForRegisterForm(password);
        typeConfirmPasswordFieldForRegisterForm(confirmPass);
        typePidFieldForRegisterForm(PID);
        clickRegisterButton();
    }
}
