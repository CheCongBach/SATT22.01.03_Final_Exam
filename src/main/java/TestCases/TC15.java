package TestCases;

import Common.Log;
import Functions.GenerateData;
import PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC15 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    TimeTablePage timeTableTab = new TimeTablePage();
    TicketPricePage ticketPrice = new TicketPricePage();

    @Test(dataProvider = "data", description = "Ticket price page displays with ticket details after clicking on 'check price' link in 'Train timetable' page")
    public void TC015 (Object[] dataObjects) {
        Log.info("Navigate to register page");
        homePage.moveToRegisterTab();

        String email = GenerateData.generateRandomEmail(dataObjects[0].toString());
        String password = dataObjects[1].toString();
        String confirmPasword = dataObjects[2].toString();
        String PID = dataObjects[3].toString();

        Log.info("Register new account");
        registerPage.register(email, password, confirmPasword, PID);

        Log.info("Navigate to login page");
        homePage.moveToLoginPage();

        Log.info("Loggin with valid account");
        loginPage.login(email, password);

        Log.info("Navigate to time table page");
        homePage.moveToTimeTablePage();

        Log.info("Click check ticket button");
        timeTableTab.clickCheckTicketButton();

        String expectedTitle = ticketPrice.getTextTitleOfTicketPrice();
        String actualTitle = "Ticket price from Sài Gòn to Phan Thiết";

        Log.info("Compare actual title with expected title");
        Assert.assertEquals(actualTitle, expectedTitle);

        String HS = dataObjects[4].toString();
        String SS = dataObjects[5].toString();
        String SSC = dataObjects[6].toString();
        String HB = dataObjects[7].toString();
        String SB = dataObjects[8].toString();
        String SBC = dataObjects[9].toString();
        String[] expectedTicketPrice = {HS, SS, SSC, HB, SB, SBC};
        String[] actualTicketPrice = ticketPrice.getTicketPrice();

        Log.info("Compare actual ticket price with expected ticket price");
        Assert.assertEquals(actualTicketPrice, expectedTicketPrice);
    }
}
