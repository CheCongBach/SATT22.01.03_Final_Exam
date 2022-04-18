package TestCases;

import Common.Constant;
import Common.Log;
import Common.WebDriverCommon;
import Functions.GenerateData;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "data", description = "User can log into Railway with valid username and password")
    public void TC001 (Object[] dataObjects) throws InterruptedException {
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

        String expectedURL = "http://www.raillog.somee.com/Page/HomePage.cshtml";
        String actualURL = Constant.WEBDRIVER.getCurrentUrl();

        Log.info("Compare expected URL with actual URL");
        Assert.assertEquals(actualURL, expectedURL);
        Thread.sleep(3000);

        Log.info("Execute zoom in screen with 130%");
        WebDriverCommon.zoomInScreen();

        String expectedWelcomeElement = "Welcome" + " " + email;
        String actualWelcomeElement = homePage.getWelcomeElement();

        Log.info("Compare actual Welcome Guest text with expected Welcome Guest text");
        Assert.assertEquals(actualWelcomeElement, expectedWelcomeElement);
    }
}
