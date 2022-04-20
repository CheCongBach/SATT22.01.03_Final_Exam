package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    /**
     * Locators
     */
    private By bookTicketTab = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
    private By registerTab = By.xpath("//a[@href='/Account/Register.cshtml']");
    private By loginPageTab = By.xpath("//a[@href='/Account/Login.cshtml']");
    private By myTicketTab = By.xpath("//a[@href='/Page/ManageTicket.cshtml']");

    /**
     * Elements
     */
    public WebElement getLinkBookTicketTab () {
        return Constant.WEBDRIVER.findElement(bookTicketTab);
    }

    public WebElement getRegisterTab () {
        return Constant.WEBDRIVER.findElement(registerTab);
    }

    public WebElement getLinkLoginTab () {
        return Constant.WEBDRIVER.findElement(loginPageTab);
    }

    public WebElement getMyTicketTab () {
        return Constant.WEBDRIVER.findElement(myTicketTab);
    }

    /**
     * Methods
     */
    public void moveToLoginPage () {
        getLinkLoginTab().click();
    }

    public void moveToBookTicketPage () {
        getLinkBookTicketTab().click();
    }

    public void moveToRegisterTab () {
        getRegisterTab().click();
    }

    public void moveToMyTicketTab () {
        getMyTicketTab().click();
    }
}
