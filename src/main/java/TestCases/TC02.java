package TestCases;

import Common.Log;
import Common.WebDriverCommon;
import Functions.GenerateData;
import PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();

    @Test(dataProvider = "data", description = "User can filter 'Manager ticket' table with Depart Station")
    public void TC001 (Object[] dataObjects) throws InterruptedException {
        Log.info("Navigate to register page");
        homePage.moveToRegisterTab();

        Log.info("Declare variable");
        String email = GenerateData.generateRandomEmail(dataObjects[0].toString());
        String password = dataObjects[1].toString();
        String confirmPass = dataObjects[2].toString();
        String PID = dataObjects[3].toString();
        String departDate = dataObjects[4].toString();
        String departFrom1 = dataObjects[5].toString();
        String arriveAt1 = dataObjects[6].toString();
        String departFrom2 = dataObjects[7].toString();
        String arriveAt2 = dataObjects[8].toString();
        String departFrom3 = dataObjects[8].toString();
        String arriveAt3 = dataObjects[9].toString();
        String seatType = dataObjects[10].toString();
        String departFrom4 = dataObjects[8].toString();
        String arriveAt4 = dataObjects[9].toString();
        String departFrom5 = dataObjects[9].toString();
        String arriveAt5 = dataObjects[8].toString();
        String departFrom6 = dataObjects[6].toString();
        String arriveAt6 = dataObjects[5].toString();
        String ticketAmount = dataObjects[11].toString();
        String status = dataObjects[12].toString();

        Log.info("Create new account with valid info");
        registerPage.register(email, password, confirmPass, PID);

        Log.info("Navigate to login page");
        homePage.moveToLoginPage();

        Log.info("Login with valid account");
        loginPage.login(email, password);

        Log.info("Navigate to book ticket page");
        homePage.moveToBookTicketPage();

        Log.info("Book ticket 1 with valid info");
        bookTicketPage.bookTicket(departDate, departFrom1, arriveAt1, seatType, ticketAmount);

        Log.info("Come back to book ticket page");
        homePage.moveToBookTicketPage();

        Log.info("Book ticket 2 with valid info");
        bookTicketPage.bookTicket(departDate, departFrom2, arriveAt2, seatType, ticketAmount);

        Log.info("Come back to book ticket page");
        homePage.moveToBookTicketPage();

        Log.info("Book ticket 3 with valid info");
        bookTicketPage.bookTicket(departDate, departFrom3, arriveAt3, seatType, ticketAmount);

        Log.info("Come back to book ticket page");
        homePage.moveToBookTicketPage();

        Log.info("Book ticket 4 with valid info");
        bookTicketPage.bookTicket(departDate, departFrom4, arriveAt4, seatType, ticketAmount);

        Log.info("Come back to book ticket page");
        homePage.moveToBookTicketPage();

        Log.info("Book ticket 5 with valid info");
        bookTicketPage.bookTicket(departDate, departFrom5, arriveAt5, seatType, ticketAmount);

        Log.info("Come back to book ticket page");
        homePage.moveToBookTicketPage();

        Log.info("Book ticket 6 with valid info");
        bookTicketPage.bookTicket(departDate, departFrom6, arriveAt6, seatType, ticketAmount);

        Log.info("Navigate to my ticket page");
        homePage.moveToMyTicketTab();

        Log.info("Sleep in 2s");
        WebDriverCommon.mediumTime(2000);

        Log.info("Select 'Paid' for status");
        myTicketPage.selectInfoForStatusField(status);

        Log.info("Click apply filter");
        myTicketPage.clickFilterButton();

        Log.info("Declare variable");
        String expectedErrorMessage = "Sorry, can't find any results that match your filters.\n" +
                "Please change the filters and try again.";
        String actualErrorMessage = myTicketPage.getTextErrorMessage();

        Log.info("Compare expected message with actual message");
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }
}
