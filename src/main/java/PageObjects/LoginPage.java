package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
    /**
     * Locators
     */
    private By emailElement = By.xpath("//input[@id='username']");
    private By passwordElement = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//input[@value='Login']");
    private By messageError = By.xpath("//p[@class='message error LoginForm']");

    /**
     * Elements
     */
    public WebElement getEmailOfLoginPage () {
        return Constant.WEBDRIVER.findElement(emailElement);
    }

    public WebElement getPasswordOfLoginPage () {
        return Constant.WEBDRIVER.findElement(passwordElement);
    }

    public WebElement getLoginButton () {
        return Constant.WEBDRIVER.findElement(loginButton);
    }

    public WebElement getMessageError () { return Constant.WEBDRIVER.findElement(messageError); }

    /**
     * Methods
     */
    public void typeEmailFieldForLoginForm(String email) {
        getEmailOfLoginPage().sendKeys(email);
    }

    public void typePasswordFieldForLoginForm(String password) {
        getPasswordOfLoginPage().sendKeys(password);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    public String getDisplayMessageError () {
        return getMessageError().getText();
    }

    public void checkDisplayMessageError () {
        Boolean message = getMessageError().isDisplayed();
        System.out.println("Message error displayed is " + message);
    }

    public void login (String email, String password) {
        typeEmailFieldForLoginForm(email);
        typePasswordFieldForLoginForm(password);
        clickLoginButton();
    }

    public void repeatLoginWith3Time (String email, String password, Integer time) {
        typeEmailFieldForLoginForm(email);
        for (int i = 0; i < time; i++) {
            typePasswordFieldForLoginForm(password);
            clickLoginButton();
        }
    }
}
