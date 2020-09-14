package tests.Configuration;

import org.testng.annotations.Test;
import pageObjects.Controls.Buttons;
import pageObjects.Menu.Configuration;
import pageObjects.ToolBars.TopSideBar;
import pageObjects.WebPages.Configuration.DayProgramPage;
import pageObjects.WebPages.Configuration.PayGroupPage;
import pageObjects.WebPages.LoginPage;
import utils.AppParams;
import utils.ExtentManager;

import static org.testng.Assert.assertTrue;

public class PayGroupTests extends ExtentManager {

    @Test
    public void addBasicPayGroup() throws InterruptedException {
        this.createTestReport("Add the basic PayGroup - Flex", "Add a new basic Pay Group - Flex");

        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Configuration configuration = new Configuration(this.driver, this.wait, writeLog.get());
        TopSideBar topSideBar = new TopSideBar(this.driver, this.wait, writeLog.get());
        PayGroupPage payGroupPage = new PayGroupPage(this.driver, this.wait, writeLog.get());
        Buttons buttons = new Buttons(this.driver, this.wait, writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "hr", "1");

        configuration.clickConfiguration();
        configuration.clickPayGroup();

        topSideBar.clickNew();

        payGroupPage.setPayGroupName("New Flex");
        payGroupPage.selectPayPeriodType(1, "Monthly");
        payGroupPage.setPayPeriodEndingDay1("31");
        payGroupPage.selectWeekEndingDay(2, "Sunday");
        payGroupPage.selectStartDate(1, "1", "September", "2020");
        payGroupPage.selectCalculationType(3, "Flex");

        //buttons.clickSave();

        //assertTrue(dayProgramPage.checkIfItemIsPresentInTable(2, "01A") && (dayProgramPage.checkIfItemIsPresentInTable(3, "Basic DP")), "New item added not found in the list");
    }

}
