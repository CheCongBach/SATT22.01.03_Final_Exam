package TestCases;

import Common.Log;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "data", description = "User can't login with blank 'Username' text box")
    public void TC002 (Object[] dataObjects) {
        Log.info("Navigate to login page");
        homePage.moveToLoginPage();

        String email = dataObjects[0].toString();
        String password = dataObjects[1].toString();

        Log.info("Login with blank 'Username' text box");
        loginPage.login(email, password);

        String expectedMessage = "There was a problem with your login and/or errors exist in your form.";
        String actualMessage = loginPage.getDisplayMessageError();

        Log.info("Compare actual message error with expected message error");
        Assert.assertEquals(actualMessage, expectedMessage);

        Log.info("Check message error is displayed or not");
        loginPage.checkDisplayMessageError();
    }
}
