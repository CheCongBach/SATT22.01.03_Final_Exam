package TestCases;

import Common.Log;
import Common.WebDriverCommon;
import Functions.GenerateData;
import PageObjects.*;
import org.testng.annotations.Test;

public class TC03 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();

    @Test(dataProvider = "data", description = "User can book more ticket")
    public void TC003 (Object[] dataObjects) throws InterruptedException {
        Log.info("Navigate to register page");
        homePage.moveToRegisterTab();

        Log.info("Declare variable");
        String email = GenerateData.generateRandomEmail(dataObjects[0].toString());
        String pass = dataObjects[1].toString();
        String confirmPass = dataObjects[2].toString();
        String PID = dataObjects[3].toString();
        String departFrom = dataObjects[9].toString();

        Log.info("Create new account with valid info");
        registerPage.register(email, pass, confirmPass, PID);

        Log.info("Navigate to login page");
        homePage.moveToLoginPage();

        Log.info("Login with valid account");
        loginPage.login(email, pass);

        Log.info("Navigate to book ticket page and book ticket with different depart station in 6 time");
        bookTicketPage.bookTicketWithMoreTime(dataObjects);

        Log.info("Sleep in 2s");
        WebDriverCommon.mediumTime(2000);

        Log.info("Select 'Nha Trang' for depart station");
        myTicketPage.selectInfoForDepartStationField(departFrom);

        Log.info("Click apply filter");
        myTicketPage.clickFilterButton();
    }
}
