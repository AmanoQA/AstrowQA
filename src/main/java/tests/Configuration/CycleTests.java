package tests.Configuration;

import org.testng.annotations.Test;
import pageObjects.Controls.Buttons;
import pageObjects.Menu.Configuration;
import pageObjects.ToolBars.TopSideBar;
import pageObjects.WebPages.Configuration.CyclePage;
import pageObjects.WebPages.Configuration.PayGroupPage;
import pageObjects.WebPages.LoginPage;
import utils.AppParams;
import utils.ExtentManager;

import static org.testng.Assert.assertTrue;

public class CycleTests extends ExtentManager {

    @Test
    public void addBasicCycle() throws InterruptedException {
        this.createTestReport("Add the basic Cycle", "Add a new basic Cycle");

        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Configuration configuration = new Configuration(this.driver, this.wait, writeLog.get());
        TopSideBar topSideBar = new TopSideBar(this.driver, this.wait, writeLog.get());
        CyclePage cyclePage = new CyclePage(this.driver, this.wait, writeLog.get());
        Buttons buttons = new Buttons(this.driver, this.wait, writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "hr", "1");

        configuration.clickConfiguration();
        configuration.clickCycle();

        topSideBar.clickNew();

        cyclePage.setCycleName("New Cycle");
        cyclePage.setNoOfDays("6");
        cyclePage.selectStartDate("31", "August", "2020");
        cyclePage.setDayPrograms(1,4, "0100", "02A - Duplicate-For test");
        cyclePage.setDayPrograms(5,6, "0100", "90A - Non working day");

        buttons.clickSave();
        assertTrue(cyclePage.checkIfItemIsPresentInTable("New Cycle"), "New item added not found in the list");
    }
}
