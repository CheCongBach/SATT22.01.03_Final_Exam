package TestCases;

import Common.Log;
import Functions.GenerateData;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "data", description = "System shows message when user enters wrong password several times")
    public void TC005 (Object[] dataObjects) {
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

        Log.info("Repeat login with 3 time");
        loginPage.repeatLoginWith3Time(email, "1234", 3);

        String expectedMessageError = "Invalid username or password. Please try again.";
        String actualMessageError = loginPage.getDisplayMessageError();

        Log.info("Compare actual message error with expected message error");
        Assert.assertEquals(actualMessageError, expectedMessageError);
    }
}
