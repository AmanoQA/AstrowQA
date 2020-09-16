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

import static org.testng.Assert.assertFalse;
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
        payGroupPage.setCarryOverMax("0600");
        payGroupPage.setCarryOverMin("99959");
        payGroupPage.setTLostMax("T2");
        payGroupPage.setTLostMin("T4");
        payGroupPage.clickCheckboxAuthQBOT("uncheck");
        payGroupPage.clickCheckboxAuthZBOT("uncheck");
        payGroupPage.clickCheckboxAuthHolWork("uncheck");
        payGroupPage.clickCheckboxAcceptOvertimeMCFromTerminal("uncheck");
        payGroupPage.clickCheckboxAcceptAbsenceMCFromTerminal("uncheck");

        buttons.clickSave();
        assertTrue(payGroupPage.checkIfItemIsPresentInTable("New Flex"), "New item added not found in the list");
    }

    @Test(dependsOnMethods = {"addBasicPayGroup"})
    public void editBasicPayGroup() throws InterruptedException {
        this.createTestReport("Edit the basic PayGroup - Flex", "Edit a basic Pay Group - Flex");

        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Configuration configuration = new Configuration(this.driver, this.wait, writeLog.get());
        TopSideBar topSideBar = new TopSideBar(this.driver, this.wait, writeLog.get());
        PayGroupPage payGroupPage = new PayGroupPage(this.driver, this.wait, writeLog.get());
        Buttons buttons = new Buttons(this.driver, this.wait, writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "hr", "1");

        configuration.clickConfiguration();
        configuration.clickPayGroup();

        payGroupPage.clickSearchedElementInDPTable("New Flex");

        topSideBar.clickEdit();

        payGroupPage.setPayGroupName("New Flex - edited");
        payGroupPage.selectPayPeriodType(1, "Monthly");
        payGroupPage.setPayPeriodEndingDay1("31");
        payGroupPage.selectWeekEndingDay(2, "Monday");
        payGroupPage.selectCalculationType(3, "Flex");
        payGroupPage.setCarryOverMax("0500");
        payGroupPage.setCarryOverMin("00000");
        payGroupPage.setTLostMax("T1");
        payGroupPage.setTLostMin("");
        payGroupPage.clickCheckboxAuthQBOT("check");
        payGroupPage.clickCheckboxAuthZBOT("check");
        payGroupPage.clickCheckboxAuthHolWork("check");
        payGroupPage.clickCheckboxAcceptOvertimeMCFromTerminal("check");
        payGroupPage.clickCheckboxAcceptAbsenceMCFromTerminal("check");

        buttons.clickSave();
        assertTrue(payGroupPage.checkIfItemIsPresentInTable("New Flex - edited"), "The edited item not found in the list");
    }

    @Test
    public void deleteBasicPayGroup() throws InterruptedException {
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

        payGroupPage.setPayGroupName("Deleted Flex");
        payGroupPage.selectPayPeriodType(1, "Monthly");
        payGroupPage.setPayPeriodEndingDay1("31");
        payGroupPage.selectWeekEndingDay(2, "Sunday");
        payGroupPage.selectCalculationType(3, "Flex");
        buttons.clickSave();

        payGroupPage.clickSearchedElementInDPTable( "Deleted Flex");
        topSideBar.clickDelete();
        topSideBar.clickDeleteYes();


        assertFalse(payGroupPage.checkIfItemIsPresentInTable("Deleted Flex"), "The deleted item was found in the list");
    }

}
