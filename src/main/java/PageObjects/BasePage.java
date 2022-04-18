package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    /**
     * Locators
     */
    private By homeTab = By.xpath("//a[@href='../']/descendant::span");
    private By FAQTab = By.xpath("//a[@href='#']/descendant::span");
    private By contactTab = By.xpath("//a[@href='/Page/Contact.cshtml']");
    private By trainTimeTableTab = By.xpath("//a[@href='TrainTimeListPage.cshtml']");
    private By ticketPriceTab = By.xpath("//a[@href='/Page/TrainPriceListPage.cshtml']/descendant::span");
    private By bookTicketTab = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
    private By registerTab = By.xpath("//a[@href='/Account/Register.cshtml']");
    private By loginPageTab = By.xpath("//a[@href='/Account/Login.cshtml']");
    private By myTicketTab = By.xpath("//a[@href='/Page/ManageTicket.cshtml']");
    private By changePasswordTab = By.xpath("//a[@href='/Account/ChangePassword.cshtml']");
    private By logOutTab = By.xpath("//a[@href='/Account/Logout']");

    /**
     * Elements
     */
    public WebElement getHomeTab () {
        return Constant.WEBDRIVER.findElement(homeTab);
    }

    public WebElement getFAQTab () {
        return Constant.WEBDRIVER.findElement(FAQTab);
    }

    public WebElement getContactTab () { return Constant.WEBDRIVER.findElement(contactTab); }

    public WebElement getLinkTimeTableTab () {
        return Constant.WEBDRIVER.findElement(trainTimeTableTab);
    }

    public WebElement getTicketPriceTab () {
        return Constant.WEBDRIVER.findElement(ticketPriceTab);
    }

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

    public WebElement getChangePasswordTab () {
        return Constant.WEBDRIVER.findElement(changePasswordTab);
    }

    public WebElement getLogOutTab () {
        return Constant.WEBDRIVER.findElement(logOutTab);
    }

    /**
     * Methods
     */
    public void moveToTimeTablePage () {
        getLinkTimeTableTab().click();
    }

    public void moveToLoginPage () {
        getLinkLoginTab().click();
    }

    public void moveToBookTicketPage () {
        getLinkBookTicketTab().click();
    }

    public void moveToContactTab () {
        getContactTab().click();
    }

    public void moveToRegisterTab () {
        getRegisterTab().click();
    }

    public void moveToChangePasswordTab () {
        getChangePasswordTab().click();
    }

    public void moveToMyTicketTab () {
        getMyTicketTab().click();
    }

    public void clickLogOutTab () {
        getLogOutTab().click();
    }

    public void checkLogoutTabStatus () {
        try {
            Boolean check = getLogOutTab().isDisplayed();
            if (check) {
                System.out.println("Logout tab is appear");
            }
        } catch (Exception e) {
            System.out.println("Logout tab is hide");
            System.out.println(e.getMessage());
        }
    }
}
