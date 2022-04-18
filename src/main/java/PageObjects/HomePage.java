package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    /**
     * Locators
     */
    private By welcomeGuestElement = By.xpath("//div[@class='account']/descendant::strong");

    /**
     * Elements
     */
    public WebElement findWelcomeGuestElement () {
        return Constant.WEBDRIVER.findElement(welcomeGuestElement);
    }

    /**
     * Methods
     */
    public String getWelcomeElement () {
        return findWelcomeGuestElement().getText();
    }
}
