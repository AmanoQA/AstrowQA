package tests;

import org.testng.annotations.Test;
import pageObjects.Controls.Buttons;
import pageObjects.Controls.ValidationMessage;
import pageObjects.ToolBars.TopSideBar;
import pageObjects.WebPages.DayProgramPage;
import pageObjects.Menu.Configuration;
import pageObjects.WebPages.LoginPage;
import utils.AppParams;
import utils.ExtentManager;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class DayProgramTests extends ExtentManager {

    @Test
    public void addBasicDayProgram() throws InterruptedException {
        this.createTestReport("Add the basic Day program", "Add a new basic Day program");

        Configuration configuration = new Configuration(this.driver, this.wait, writeLog.get());
        TopSideBar topSideBar = new TopSideBar(this.driver, this.wait, writeLog.get());
        DayProgramPage dayProgramPage = new DayProgramPage(this.driver, this.wait, writeLog.get());
        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Buttons buttons = new Buttons(this.driver, this.wait, writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "hr", "1");

        configuration.clickConfiguration();
        configuration.clickDayPrograms();

        topSideBar.clickNew();

        dayProgramPage.setCode("01A");
        dayProgramPage.setPayrollCode("01A");
        dayProgramPage.setName("Basic DP");
        dayProgramPage.setNormtime("0800");
        dayProgramPage.clickZonesTab();
        dayProgramPage.setZoneTime1("0800");
        dayProgramPage.setZoneTime2("1700");
        dayProgramPage.clickCheckbox1("check");
        buttons.clickSave();

        assertTrue(dayProgramPage.checkIfItemIsPresentInTable(2, "01A") && (dayProgramPage.checkIfItemIsPresentInTable(3, "Basic DP")), "New item added not found in the list");
    }

    @Test
    public void addDayProgramWithPaidBreak() throws InterruptedException {
        this.createTestReport("Add Day program with Paid Break", "Add a new Day program with Paid Break ");

        Configuration configuration = new Configuration(this.driver, this.wait, writeLog.get());
        TopSideBar topSideBar = new TopSideBar(this.driver, this.wait, writeLog.get());
        DayProgramPage dayProgramPage = new DayProgramPage(this.driver, this.wait, writeLog.get());
        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Buttons buttons = new Buttons(this.driver, this.wait, writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "hr", "1");

        configuration.clickConfiguration();
        configuration.clickDayPrograms();

        topSideBar.clickNew();
        dayProgramPage.setCode("03A");
        dayProgramPage.setPayrollCode("03A");
        dayProgramPage.setName("Paid Break | Norm - 07:30");
        dayProgramPage.setNormtime("0730");
        dayProgramPage.clickBreakRoundTab();
        dayProgramPage.selectBreak1(1,"Paid Break");
        dayProgramPage.setBreak1Time("1000", "1200");
        dayProgramPage.clickZonesTab();
        dayProgramPage.setZoneTime1("0800");
        dayProgramPage.setZoneTime2("1800");
        dayProgramPage.clickCheckbox1("check");
        buttons.clickSave();

        assertTrue(dayProgramPage.checkIfItemIsPresentInTable(2, "03A") && (dayProgramPage.checkIfItemIsPresentInTable(3, "Paid Break | Norm - 07:30")), "New item added not found in the list");

    }

    @Test(dependsOnMethods = {"addDayProgramWithPaidBreak"})
    public void editDayProgramWithPaidBreak() throws InterruptedException {
        this.createTestReport("Edit Day program with Paid Break", "Edit a Day program with Paid Break ");

        Configuration configuration = new Configuration(this.driver, this.wait, writeLog.get());
        TopSideBar topSideBar = new TopSideBar(this.driver, this.wait, writeLog.get());
        DayProgramPage dayProgramPage = new DayProgramPage(this.driver, this.wait, writeLog.get());
        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Buttons buttons = new Buttons(this.driver, this.wait, writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "hr", "1");
        configuration.clickConfiguration();
        configuration.clickDayPrograms();

        dayProgramPage.clickSearchedElementInDPTable(3,"Paid Break | Norm - 07:30");

        topSideBar.clickEdit();

        dayProgramPage.setPayrollCode("03A");
        dayProgramPage.setName("Paid Break | Norm - 07:30-edited");
        dayProgramPage.setNormtime("0730");
        dayProgramPage.clickBreakRoundTab();
        dayProgramPage.selectBreak1(1,"Paid Break");
        dayProgramPage.setBreak1Time("1000", "1200");
        dayProgramPage.clickZonesTab();
        dayProgramPage.setZoneTime1("0800");
        dayProgramPage.setZoneTime2("1800");
        dayProgramPage.clickCheckbox1("uncheck");
        buttons.clickSave();

        assertTrue(dayProgramPage.checkIfItemIsPresentInTable(2, "03A") && (dayProgramPage.checkIfItemIsPresentInTable(3, "Paid Break | Norm - 07:30-edited")), "New item added not found in the list");

    }

    @Test
    public void checkDuplicateValidationMessage() throws InterruptedException{
        this.createTestReport("Duplicated DP Code", "Check if the \"Duplicate day program code!\" is displayed when using a duplicated DP Code");

        Configuration configuration = new Configuration(this.driver, this.wait, writeLog.get());
        TopSideBar topSideBar = new TopSideBar(this.driver, this.wait, writeLog.get());
        DayProgramPage dayProgramPage = new DayProgramPage(this.driver, this.wait, writeLog.get());
        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Buttons buttons = new Buttons(this.driver, this.wait, writeLog.get());
        ValidationMessage validationMessage = new ValidationMessage(this.driver, this.wait, writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "hr", "1");
        configuration.clickConfiguration();
        configuration.clickDayPrograms();

        topSideBar.clickNew();

        dayProgramPage.setCode("01A");
        dayProgramPage.setName("Paid Break | Norm - 07:30");
        buttons.clickSave();

        assertTrue(validationMessage.checkValidationMessage("Duplicate day program code!"), "Message is not displayed");

    }

    @Test
    public void checkMissingNameValidationMessage() throws InterruptedException{
        this.createTestReport("Missing Name DP ", "Check if the \"You must enter correct values in all required fields!\" is displayed when missing to fill the Name");

        Configuration configuration = new Configuration(this.driver, this.wait, writeLog.get());
        TopSideBar topSideBar = new TopSideBar(this.driver, this.wait, writeLog.get());
        DayProgramPage dayProgramPage = new DayProgramPage(this.driver, this.wait, writeLog.get());
        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Buttons buttons = new Buttons(this.driver, this.wait, writeLog.get());
        ValidationMessage validationMessage = new ValidationMessage(this.driver, this.wait, writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "hr", "1");
        configuration.clickConfiguration();
        configuration.clickDayPrograms();

        topSideBar.clickNew();
        dayProgramPage.setCode("05A");
        buttons.clickSave();

        assertTrue(validationMessage.checkValidationMessage("You must enter correct values in all required fields!"), "Message is not displayed");

    }

    @Test
    public void deleteYesDP() throws InterruptedException {
        this.createTestReport("Delete DP", "Delete a DP from the list");

        Configuration configuration = new Configuration(this.driver, this.wait, writeLog.get());
        TopSideBar topSideBar = new TopSideBar(this.driver, this.wait, writeLog.get());
        DayProgramPage dayProgramPage = new DayProgramPage(this.driver, this.wait, writeLog.get());
        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Buttons buttons = new Buttons(this.driver, this.wait, writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "hr", "1");
        configuration.clickConfiguration();
        configuration.clickDayPrograms();

        topSideBar.clickNew();

        dayProgramPage.setCode("07A");
        dayProgramPage.setPayrollCode("07A");
        dayProgramPage.setName("Basic 07A DP");
        dayProgramPage.setNormtime("0800");
        dayProgramPage.clickZonesTab();
        dayProgramPage.setZoneTime1("0800");
        dayProgramPage.setZoneTime2("1700");
        dayProgramPage.clickCheckbox1("check");
        buttons.clickSave();

        dayProgramPage.clickSearchedElementInDPTable(2, "07A");

        topSideBar.clickDelete();
        topSideBar.clickDeleteYes();

        assertFalse(dayProgramPage.checkIfItemIsPresentInTable(2, "07A"), "DP not deleted");
    }

}
