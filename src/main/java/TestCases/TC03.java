package TestCases;

import Common.Log;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "data", description = "User cannot log into Railway with invalid password")
    public void TC003 (Object[] dataObjects) {
        Log.info("Navigate to login page");
        homePage.moveToLoginPage();

        Log.info("Loggin with invalid password");
        loginPage.login(dataObjects[0].toString(), dataObjects[1].toString());

        String expectedMessage = "Invalid username or password. Please try again.";
        String actualMessage = loginPage.getDisplayMessageError();

        Log.info("Compare actual message error with expected message error");
        Assert.assertEquals(actualMessage, expectedMessage);

        Log.info("Check message error is displayed or not");
        loginPage.checkDisplayMessageError();
    }
}
