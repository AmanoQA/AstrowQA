package tests;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.Controls.Buttons;
import pageObjects.WebPages.LoginPage;
import utils.AppParams;
import utils.ExtentManager;

import static org.testng.Assert.assertTrue;

public class LoginTests extends ExtentManager {

    @Test
    public void loginTestHR() {
        this.createTestReport("Login with HR user", "Make a login using HR user.");

        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        loginPage.doLogin(AppParams.domainCloud, "hr", "1");

        assertTrue(loginPage.checkAccount("hr"), "Not able to confirm the login");

    }

    @Test
    public void loginTestAdministrator() {
        this.createTestReport("Login with Administrator user", "Make a login using Administrator user.");

        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        loginPage.doLogin(AppParams.domainCloud, "administrator", "1");

        assertTrue(loginPage.checkAccount("administrator"), "Not able to confirm the login");

    }

    @Test
    public void checkRememberMe() throws InterruptedException {
        this.createTestReport("Check remember me", "Check remember me Login option");
        LoginPage loginPage= new LoginPage(this.driver, this.wait, writeLog.get());
        Buttons buttons = new Buttons(this.driver, this.wait, writeLog.get());

        loginPage.setUserName("hr");
        loginPage.setPassword("");
        loginPage.clickRememberMe();
        loginPage.clickLogin();

        loginPage.clickLogout();
        buttons.clickYes();

        assertTrue(loginPage.checkRememberMe("hr"));

    }

}
