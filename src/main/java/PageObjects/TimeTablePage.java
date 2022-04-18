package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTablePage {
    /**
     * Locators
     */
    private By checkTicketButton = By.xpath("//tr/td[count(//th[text()='Depart Station']/preceding-sibling::th) + 1][text()='Sài Gòn']" +
            "/..//td[count(//th[text()='Arrive Station']/preceding-sibling::th) + 1][text()='Phan Thiết']" +
            "/../td[count(//th[text()='Check Price']/preceding-sibling::th) + 1]/descendant::a");

    /**
     * Elements
     */
    public WebElement getCheckTicketButton () {
        return Constant.WEBDRIVER.findElement(checkTicketButton);
    }

    /**
     * Methods
     */
    public void clickCheckTicketButton () {
        getCheckTicketButton().click();
    }
}
