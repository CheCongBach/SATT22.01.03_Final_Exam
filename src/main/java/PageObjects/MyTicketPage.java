package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage {
    /**
     * Locators
     */
    private By cancelButton = By.xpath("//tr/td[count(//th[text()='Depart Station']/preceding-sibling::th) + 1][text()='Đà Nẵng']" +
            "/..//td[count(//th[text()='Arrive Station']/preceding-sibling::th) + 1][text()='Nha Trang']" +
            "/../td[count(//th[text()='Operation']/preceding-sibling::th) + 1]/descendant::input");

    /**
     * Elements
     */
    public WebElement getCancelButton () {
        return Constant.WEBDRIVER.findElement(cancelButton);
    }

    /**
     * Methods
     */
    public void clickCancelButton () {
        getCancelButton().click();
    }
}
