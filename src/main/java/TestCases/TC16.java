package TestCases;

import Common.Constant;
import Common.Log;
import Functions.GenerateData;
import PageObjects.*;
import org.testng.annotations.Test;

public class TC16 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test(dataProvider = "data", description = "User can cancel a ticket")
    public void TC016 (Object[] dataObjects) throws InterruptedException {
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

        Log.info("Book ticket with valid info");
        bookTicketPage.bookTicket(departDate, departFrom, arriveAt, seatType, amount);

        Log.info("Navigate to my ticket page");
        homePage.moveToMyTicketTab();

        Log.info("Click cancel button");
        myTicketPage.clickCancelButton();

        Log.info("Click 'ok' button on aleart");
        Constant.WEBDRIVER.switchTo().alert().accept();
    }
}
