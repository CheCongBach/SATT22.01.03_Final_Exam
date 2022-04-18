package TestCases;

import Common.Log;
import Functions.GenerateData;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "data", description = "User can't create account while password and PID fields are empty")
    public void TC011 (Object[] dataObjects) {
        Log.info("Navigate to register page");
        homePage.moveToRegisterTab();

        String email = GenerateData.generateRandomEmail(dataObjects[0].toString());
        String password = dataObjects[1].toString();
        String confirmPasword = dataObjects[2].toString();
        String PID = dataObjects[3].toString();

        Log.info("Register new account");
        registerPage.register(email, password, confirmPasword, PID);

        String expectedMessageError = "There're errors in the form. Please correct the errors and try again.";
        String actualMessageError = registerPage.getMessageErrorText();

        Log.info("Compare actual message error with expected message error");
        Assert.assertEquals(actualMessageError, expectedMessageError);

        String expectedInvalidPasswordMessage = "Invalid password length";
        String actualInvalidPasswordMessage = registerPage.getInvalidPasswordText();

        Log.info("Compare actual invalid password message with expected invalid password message");
        Assert.assertEquals(actualInvalidPasswordMessage, expectedInvalidPasswordMessage);

        String expectedInvalidIDMessage = "Invalid ID length";
        String actualInvalidIDMessage = registerPage.getInvalidIDText();

        Log.info("Compare actual invalid ID message witth expected invalid ID message");
        Assert.assertEquals(actualInvalidIDMessage, expectedInvalidIDMessage);
    }
}
