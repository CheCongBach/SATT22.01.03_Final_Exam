package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage {
    /**
     * Locators
     */
    private By titleOfTicketPrice = By.xpath("//table[@class='MyTable MedTable']//th[text()='Ticket price from Sài Gòn to Phan Thiết']");
    private By HS = By.xpath("//table[@class='MyTable MedTable']//td[count(//td[text()='HS']/preceding-sibling::td) + 1][text()='90000']");
    private By SS = By.xpath("//table[@class='MyTable MedTable']//td[count(//td[text()='SS']/preceding-sibling::td) + 1][text()='115000']");
    private By SSC = By.xpath("//table[@class='MyTable MedTable']//td[count(//td[text()='SSC']/preceding-sibling::td) + 1][text()='140000']");
    private By HB = By.xpath("//table[@class='MyTable MedTable']//td[count(//td[text()='HB']/preceding-sibling::td) + 1][text()='190000']");
    private By SB = By.xpath("//table[@class='MyTable MedTable']//td[count(//td[text()='SB']/preceding-sibling::td) + 1][text()='240000']");
    private By SBC = By.xpath("//table[@class='MyTable MedTable']//td[count(//td[text()='SBC']/preceding-sibling::td) + 1][text()='290000']");

    /**
     * Elements
     */
    public WebElement getTitleOfTicketPrice () {
        return Constant.WEBDRIVER.findElement(titleOfTicketPrice);
    }

    public WebElement getHS () {
        return Constant.WEBDRIVER.findElement(HS);
    }

    public WebElement getSS () {
        return Constant.WEBDRIVER.findElement(SS);
    }

    public WebElement getSSC () {
        return Constant.WEBDRIVER.findElement(SSC);
    }

    public WebElement getHB () {
        return Constant.WEBDRIVER.findElement(HB);
    }

    public WebElement getSB () {
        return Constant.WEBDRIVER.findElement(SB);
    }

    public WebElement getSBC () {
        return Constant.WEBDRIVER.findElement(SBC);
    }

    /**
     * Methods
     */
    public String getTextTitleOfTicketPrice () {
        return getTitleOfTicketPrice().getText();
    }

    public String[] getTicketPrice () {
        String HS = getHS().getText();
        String SS = getSS().getText();
        String SSC = getSSC().getText();
        String HB = getHB().getText();
        String SB = getSB().getText();
        String SBC = getSBC().getText();
        String[] ticketPrice = {HS, SS, SSC, HB, SB, SBC};
        return ticketPrice;
    }
}
