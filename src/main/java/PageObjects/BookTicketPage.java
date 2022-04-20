package PageObjects;

import Common.Constant;
import Common.WebDriverCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage {
    /**
     * Locators
     */
    private By departDateField = By.xpath("//select[@name='Date']");
    private By departFromField = By.xpath("//select[@name='DepartStation']");
    private By arriveAtField = By.xpath("//select[@name='ArriveStation']");
    private By seatTypeField = By.xpath("//select[@name='SeatType']");
    private By ticketAmountField = By.xpath("//select[@name='TicketAmount']");
    private By bookTicketButton = By.xpath("//input[@value='Book ticket']");

    /**
     * Elements
     */
    public WebElement getDepartDateField () {
        return Constant.WEBDRIVER.findElement(departDateField);
    }

    public WebElement getDepartFromField () {
        return Constant.WEBDRIVER.findElement(departFromField);
    }

    public WebElement getArriveAtField () {
        return Constant.WEBDRIVER.findElement(arriveAtField);
    }

    public WebElement getSeatTypeField () {
        return Constant.WEBDRIVER.findElement(seatTypeField);
    }

    public WebElement getTicketAmountField () {
        return Constant.WEBDRIVER.findElement(ticketAmountField);
    }

    public WebElement getBookTicketButton () {
        return Constant.WEBDRIVER.findElement(bookTicketButton);
    }

    /**
     * Methods
     */
    public void selectValueForDepartDateField (String departDate) {
        Select valueOfDepartDateField = new Select(getDepartDateField());
        valueOfDepartDateField.selectByVisibleText(departDate);
    }

    public void selectValueForDepartFromField (String departFrom) {
        Select valueOfDepartFromField = new Select(getDepartFromField());
        valueOfDepartFromField.selectByVisibleText(departFrom);
    }

    public void selectValueForArriveAtField (String arriveAt) {
        Select valueOfArriveAtField = new Select(getArriveAtField());
        valueOfArriveAtField.selectByVisibleText(arriveAt);
    }

    public void selectValueForSeatTypeField (String seatType) {
        Select valueOfSeatTypeField = new Select(getSeatTypeField());
        valueOfSeatTypeField.selectByVisibleText(seatType);
    }

    public void selectValueForTicketAmountField (String ticletAmount) {
        Select valueOfTicketAmountField = new Select(getTicketAmountField());
        valueOfTicketAmountField.selectByVisibleText(ticletAmount);
    }

    public void clickBookTicketButton () {
        getBookTicketButton().click();
    }

    public void bookTicket (String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) throws InterruptedException {
        try {
            selectValueForDepartDateField(departDate);
            selectValueForDepartFromField(departFrom);
            WebDriverCommon.shortTime(1000);
            selectValueForArriveAtField(arriveAt);
            selectValueForSeatTypeField(seatType);
            selectValueForTicketAmountField(ticketAmount);
            clickBookTicketButton();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
