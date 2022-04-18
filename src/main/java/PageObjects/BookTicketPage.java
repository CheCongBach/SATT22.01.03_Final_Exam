package PageObjects;

import Common.Constant;
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
    private By bookTicketSucessfully = By.xpath("//h1[@align='center'][text()='Ticket Booked Successfully!']");
    private By infoDepartStationTicket = By.xpath("//tr/td[count(//th[text()='Depart Station']/preceding-sibling::th) + 1]");
    private By infoArriveAtTicket = By.xpath("//tr/td[count(//th[text()='Arrive Station']/preceding-sibling::th) + 1]");
    private By infoSeatTypeTicket = By.xpath("//tr/td[count(//th[text()='Seat Type']/preceding-sibling::th) + 1]");
    private By infoDepartDateTicket = By.xpath("//tr/td[count(//th[text()='Depart Date']/preceding-sibling::th) + 1]");
    private By infoAmountTicket = By.xpath("//tr/td[count(//th[text()='Amount']/preceding-sibling::th) + 1]");

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

    public WebElement getBookTicketSucessfully () {
        return Constant.WEBDRIVER.findElement(bookTicketSucessfully);
    }

    public WebElement getInfoDepartStationTicket () {
        return Constant.WEBDRIVER.findElement(infoDepartStationTicket);
    }

    public WebElement getInfoArriveAtTicket () {
        return Constant.WEBDRIVER.findElement(infoArriveAtTicket);
    }

    public WebElement getInfoSeatTypeTicket () {
        return Constant.WEBDRIVER.findElement(infoSeatTypeTicket);
    }

    public WebElement getInfoDepartDateTicket () {
        return Constant.WEBDRIVER.findElement(infoDepartDateTicket);
    }

    public WebElement getInfoAmountTicket () {
        return Constant.WEBDRIVER.findElement(infoAmountTicket);
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

    public String getBookTicketSucessfullyText () {
        return getBookTicketSucessfully().getText();
    }

    public String[] getInfoTicket () {
        String departStation = getInfoDepartStationTicket().getText();
        String arriveAt = getInfoArriveAtTicket().getText();
        String seatType = getInfoSeatTypeTicket().getText();
        String departDate = getInfoDepartDateTicket().getText();
        String amount = getInfoAmountTicket().getText();
        String[] infoTicket = {departStation, arriveAt, seatType, departDate, amount};
        return infoTicket;
    }

    public void bookTicket (String departDate, String departFrom, String arriveAt, String seatType, String amount) throws InterruptedException {
        try {
            selectValueForDepartDateField(departDate);
            selectValueForDepartFromField(departFrom);
            Thread.sleep(1000);
            selectValueForArriveAtField(arriveAt);
            selectValueForSeatTypeField(seatType);
            selectValueForTicketAmountField(amount);
            clickBookTicketButton();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
