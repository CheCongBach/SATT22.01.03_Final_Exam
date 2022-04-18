package TestCases;

import Common.Constant;
import Common.Log;
import Functions.GenerateData;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "data", description = "User is redirected to Home page after logging out")
    public void TC006 (Object[] dataObjects) {
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

        Log.info("Navigate to contact page");
        homePage.moveToContactTab();

        Log.info("Click logout tab");
        homePage.clickLogOutTab();

        String exceptedURL = "http://www.raillog.somee.com/Page/HomePage.cshtml";
        String actualURL = Constant.WEBDRIVER.getCurrentUrl();

        Log.info("Compare actual URL with expected URL");
        Assert.assertEquals(actualURL, exceptedURL);

        Log.info("Check Logout tab is appear or not");
        homePage.checkLogoutTabStatus();
    }
}
