package TestCases;

import Common.Log;
import Functions.GenerateData;
import PageObjects.ChangePasswordPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test(dataProvider = "data", description = "User can't change password when 'New Password' and 'Confirm Password' are different.")
    public void TC009 (Object[] dataObjects) {
        Log.info("Navigate to register page");
        homePage.moveToRegisterTab();

        String email = GenerateData.generateRandomEmail(dataObjects[0].toString());
        String password = dataObjects[1].toString();
        String confirmPasword = dataObjects[2].toString();
        String PID = dataObjects[3].toString();
        String newPassword = dataObjects[4].toString();
        String confirmNewPassword = dataObjects[5].toString();

        Log.info("Register new account");
        registerPage.register(email, password, confirmPasword, PID);

        Log.info("Navigate to login page");
        homePage.moveToLoginPage();

        Log.info("Login with valid account");
        loginPage.login(email, password);

        Log.info("Navigate to change password page");
        homePage.moveToChangePasswordTab();

        Log.info("Change new password");
        changePasswordPage.changePassword(password, newPassword, confirmNewPassword);

        String exceptedMessage = "Password change failed. Please correct the errors and try again.";
        String actualMessage = changePasswordPage.getMessageErrorText();

        Log.info("Compare actual message with expected message");
        Assert.assertEquals(actualMessage, exceptedMessage);
    }
}
