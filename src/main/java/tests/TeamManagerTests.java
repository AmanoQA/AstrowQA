package tests;

import org.testng.annotations.Test;
import pageObjects.Controls.Buttons;
import pageObjects.Menu.TeamManager.ContextMenu;
import pageObjects.Menu.Operations;
import pageObjects.WebPages.AddEditAbsencePage;
import pageObjects.WebPages.AddEditBookingPage;
import pageObjects.WebPages.LoginPage;
import pageObjects.WebPages.TeamManagerPage;
import utils.AppParams;
import utils.ExtentManager;

import static org.testng.Assert.assertTrue;

public class TeamManagerTests extends ExtentManager {

    @Test
    public void addAbsenceAdjustToNormtime() throws InterruptedException {
        this.createTestReport("Add Absence with \"(1) Adjust to normtime\" for an employee", "Employee: ACHIM ALIN, day: 6, Absence - Blood Donation");

        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Operations operations = new Operations(this.driver, this.wait, writeLog.get());
        TeamManagerPage teamManagerPage = new TeamManagerPage(this.driver, this.wait, writeLog.get());
        ContextMenu contextMenu = new ContextMenu(this.driver, this.wait, writeLog.get());
        //Buttons buttons = new Buttons(this.driver, this.wait, writeLog.get());
        AddEditAbsencePage addEditAbsencePage = new AddEditAbsencePage(this.driver, this.wait, writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "hr", "1");

        operations.clickOperation();
        operations.clickTeamManager();
        teamManagerPage.checkPageIsReady();

        teamManagerPage.clickSearchedElementInTMTable("ACHIM ALIN", 6);
        //teamManagerPage.clickSearchedElementInTMTable("61000378", 2);

        contextMenu.clickAddAbsence();
        addEditAbsencePage.addAbsence("Blood donation", "(1) Adjust to normtime");

//        addEditAbsencePage.selectAbsence(1, "Blood donation");
//        addEditAbsencePage.selectAuthTime(2, "(1) Adjust to normtime");
//        buttons.clickSave();

        //teamManagerPage.waitPageToBeLoaded();
        this.waitPageToBeLoaded();

        assertTrue(teamManagerPage.checkIfItemIsPresentInSelectedDay("ACHIM ALIN", 6, "BD"), "Absence not found");


    }

    @Test
    public void addAbsenceCustomTime() throws InterruptedException {
        this.createTestReport("Add Absence with \"(h) Custom time\" for an employee", "Employee: ACHIM ALIN, day: 7, Absence - Business trip");

        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Operations operations = new Operations(this.driver, this.wait, writeLog.get());
        TeamManagerPage teamManagerPage = new TeamManagerPage(this.driver, this.wait, writeLog.get());
        ContextMenu contextMenu = new ContextMenu(this.driver, this.wait, writeLog.get());
        //Buttons buttons = new Buttons(this.driver, this.wait, writeLog.get());
        AddEditAbsencePage addEditAbsencePage = new AddEditAbsencePage(this.driver, this.wait, writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "hr", "1");

        operations.clickOperation();
        operations.clickTeamManager();
        teamManagerPage.waitPageToBeLoaded();

        teamManagerPage.clickSearchedElementInTMTable("ACHIM ALIN", 7);
        //teamManagerPage.clickSearchedElementInTMTable("61000378", 2);

        contextMenu.clickAddAbsence();

        addEditAbsencePage.addAbsence("Business trip", "(h) Custom time", "0745");

//        addEditAbsencePage.selectAbsence(1, "Business trip");
//        addEditAbsencePage.selectAuthTime(2, "(h) Custom time", "0745");
//        buttons.clickSave();

        teamManagerPage.waitPageToBeLoaded();

        assertTrue(teamManagerPage.checkIfItemIsPresentInSelectedDay("ACHIM ALIN", 7, "BT"), "Absence not found");

    }

    @Test
    public void addBooking() throws InterruptedException {
        this.createTestReport("Add booking for an employee", "Employee: AGACHE MIHAI, day: 4, Booking - 10:25");

        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Operations operations = new Operations(this.driver, this.wait, writeLog.get());
        TeamManagerPage teamManagerPage = new TeamManagerPage(this.driver, this.wait, writeLog.get());
        ContextMenu contextMenu = new ContextMenu(this.driver, this.wait, writeLog.get());
        Buttons buttons = new Buttons(this.driver, this.wait, writeLog.get());
        AddEditBookingPage addEditBookingPage = new AddEditBookingPage(this.driver, this.wait, writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "hr", "1");

        operations.clickOperation();
        operations.clickTeamManager();
        teamManagerPage.waitPageToBeLoaded();

        teamManagerPage.clickSearchedElementInTMTable("AGACHE MIHAI", 4);

        contextMenu.clickAddBooking();
        addEditBookingPage.addBooking("1025", "C");
        teamManagerPage.waitPageToBeLoaded();
        buttons.clickOK();

        assertTrue(teamManagerPage.checkIfItemIsPresentInSelectedDay("AGACHE MIHAI", 4, "10:25"), "Booking not found");

    }

    @Test
    public void checkBookingForEmployee(){
        this.createTestReport("Check Booking on an Employee", "Employee: ACHIM ALIN, day: 10, booking: 15:25");

        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Operations operations = new Operations(this.driver, this.wait, writeLog.get());
        TeamManagerPage teamManagerPage = new TeamManagerPage(this.driver, this.wait, writeLog.get());
        ContextMenu contextMenu = new ContextMenu(this.driver, this.wait, writeLog.get());
        Buttons buttons = new Buttons(this.driver, this.wait, writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "hr", "1");

        operations.clickOperation();
        operations.clickTeamManager();

        teamManagerPage.waitPageToBeLoaded();

        //teamManagerPage.clickSearchedElementInTMTable("BALULESCU PATRICK CLAUDIU");
        assertTrue(teamManagerPage.checkIfItemIsPresentInSelectedDay("ACHIM ALIN", 10, "15:25"), "Booking not found");

    }

    @Test
    public void selectDateFromCalendar() throws InterruptedException {
        this.createTestReport("Select date from calendar", "Select a date from calendar and click on Apply button");

        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Operations operations = new Operations(this.driver, this.wait, writeLog.get());
        TeamManagerPage teamManagerPage = new TeamManagerPage(this.driver, this.wait, writeLog.get());
        ContextMenu contextMenu = new ContextMenu(this.driver, this.wait, writeLog.get());
        Buttons buttons = new Buttons(this.driver, this.wait, writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "hr", "1");

        operations.clickOperation();
        operations.clickTeamManager();

        teamManagerPage.waitPageToBeLoaded();

        teamManagerPage.selectDateFromTMCalendar(1, "29", "June", "2020");
        buttons.clickApply();


    }


}
