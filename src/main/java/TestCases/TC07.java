package TestCases;

import Common.Log;
import Functions.GenerateData;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "data", description = "User can create new account")
    public void TC007 (Object[] dataObjects) {
        Log.info("Navigate to register page");
        homePage.moveToRegisterTab();

        String email = GenerateData.generateRandomEmail(dataObjects[0].toString());
        String password = dataObjects[1].toString();
        String confirmPasword = dataObjects[2].toString();
        String PID = dataObjects[3].toString();

        Log.info("Register new account");
        registerPage.register(email, password, confirmPasword, PID);

        String exceptedMessage = "You're here";
        String actualMessage = registerPage.getConfirmRegisterContent();

        Log.info("Compare actual message with expected message");
        Assert.assertEquals(actualMessage, exceptedMessage);
    }
}
