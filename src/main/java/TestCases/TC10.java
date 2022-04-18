package TestCases;

import Common.Log;
import Functions.GenerateData;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "data", description = "User can't create account with an already in-use email")
    public void TC010 (Object[] dataObjects) throws InterruptedException {
        Log.info("Navigate to register page");
        homePage.moveToRegisterTab();

        String email = GenerateData.generateRandomEmail(dataObjects[0].toString());
        String password = dataObjects[1].toString();
        String confirmPasword = dataObjects[2].toString();
        String PID = dataObjects[3].toString();

        Log.info("Register new account");
        registerPage.register(email, password, confirmPasword, PID);

        Thread.sleep(1000);

        Log.info("Navigate to register page");
        homePage.moveToRegisterTab();

        Log.info("Register new account with email is used");
        registerPage.register(email, password, confirmPasword, PID);

        String expectedMessageError = "This email address is already in use.";
        String actualMessageError = registerPage.getMessageErrorText();

        Log.info("Compare actual message error with expected message error");
        Assert.assertEquals(actualMessageError, expectedMessageError);
    }
}
