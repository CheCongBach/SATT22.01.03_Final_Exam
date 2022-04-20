package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyTicketPage {
    /**
     * Locators
     */
    private By valueDepartStation = By.xpath("//tr/td[count(//th[text()='Depart Station']/preceding-sibling::th) + 1][text()='Sài Gòn']");

    private By filterDepartStation = By.xpath("//td/select[@name='FilterDpStation']");

    private By filterStatus = By.xpath("//td/select[@name='FilterStatus']");

    private By applyFilterButton = By.xpath("//input[@value='Apply Filter']");

    private By errorMessage = By.xpath("//div[@align='center']/descendant::div");

    /**
     * Elements
     */
    public WebElement getFilterDepartStation () {
        return Constant.WEBDRIVER.findElement(filterDepartStation);
    }

    public WebElement getFilterButton () {
        return Constant.WEBDRIVER.findElement(applyFilterButton);
    }

    public WebElement getFilterStatus () {
        return Constant.WEBDRIVER.findElement(filterStatus);
    }

    public WebElement getErrorMessage () {
        return Constant.WEBDRIVER.findElement(errorMessage);
    }

    public WebElement getValueDepartStation () {
        return Constant.WEBDRIVER.findElement(valueDepartStation);
    }

    /**
     * Methods
     */
    public void selectInfoForDepartStationField (String departStation) {
        Select valueOfdepartStationField = new Select(getFilterDepartStation());
        valueOfdepartStationField.selectByVisibleText(departStation);
    }

    public void selectInfoForStatusField (String status) {
        Select valueOfFilterStatus = new Select(getFilterStatus());
        valueOfFilterStatus.selectByVisibleText(status);
    }

    public void clickFilterButton () {
        getFilterButton().click();
    }

    public String getTextErrorMessage () {
        String message = getErrorMessage().getText();
        return message;
    }

    public String getTextValueOfDepartStation () {
        String departStation = getValueDepartStation().getText();
        return departStation;
    }
}
