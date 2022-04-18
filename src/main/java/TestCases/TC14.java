package TestCases;

import Common.Log;
import Functions.GenerateData;
import PageObjects.BookTicketPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test(dataProvider = "data", description = "User can book many tickets at a time")
    public void TC014 (Object[] dataObjects) throws InterruptedException {
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

        Log.info("Login with valid account");
        loginPage.login(email, password);

        Log.info("Navigate to book ticket page");
        homePage.moveToBookTicketPage();

        String departDate = dataObjects[4].toString();
        String departFrom = dataObjects[5].toString();
        String arriveAt = dataObjects[6].toString();
        String seatType = dataObjects[7].toString();
        String amount = dataObjects[8].toString();

        Log.info("Execute book ticket with valid info");
        bookTicketPage.bookTicket(departDate, departFrom, arriveAt, seatType, amount);

        String expectedNoti = "Ticket Booked Successfully!";
        String actualNoti = bookTicketPage.getBookTicketSucessfullyText();

        Log.info("Compare actual noti with expected noti");
        Assert.assertEquals(actualNoti, expectedNoti);

        String[] expectedInfoTicket = {departFrom, arriveAt, seatType, departDate, amount};
        String[] actualInfoTicket = bookTicketPage.getInfoTicket();

        Log.info("Compare actual info ticket with expected info ticket");
        Assert.assertEquals(actualInfoTicket, expectedInfoTicket);
    }
}
