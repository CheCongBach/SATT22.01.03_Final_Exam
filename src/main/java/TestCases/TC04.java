package TestCases;

import Common.Constant;
import Common.Log;
import Functions.GenerateData;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "data", description = "User is redirected to Book ticket page after logging in")
    public void TC004 (Object[] dataObjects) {
        Log.info("Navigate to register page");
        homePage.moveToRegisterTab();

        String email = GenerateData.generateRandomEmail(dataObjects[0].toString());
        String password = dataObjects[1].toString();
        String confirmPasword = dataObjects[2].toString();
        String PID = dataObjects[3].toString();

        Log.info("Register new account");
        registerPage.register(email, password, confirmPasword, PID);

        Log.info("Navigate to book ticket page");
        homePage.moveToBookTicketPage();

        Log.info("Loggin with valid account");
        loginPage.login(email, password);

        String expectedURL = "http://www.raillog.somee.com/Page/BookTicketPage.cshtml";
        String actualURL = Constant.WEBDRIVER.getCurrentUrl();

        Log.info("Compare actual URL with expected URL");
        Assert.assertEquals(actualURL, expectedURL);
    }
}
