package tests.Operations;

import org.testng.annotations.Test;
import pageObjects.Controls.Buttons;
import pageObjects.Menu.TeamManager.ContextMenu;
import pageObjects.Menu.Operations;
import pageObjects.WebPages.Operations.AddEditAbsencePage;
import pageObjects.WebPages.Operations.AddEditBookingPage;
import pageObjects.WebPages.LoginPage;
import pageObjects.WebPages.Operations.TeamManagerPage;
import utils.AppParams;
import utils.ExtentManager;

import static org.testng.Assert.assertFalse;
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
        teamManagerPage.waitPageToBeLoaded();

        teamManagerPage.clickSearchedElementInTMTable("ACHIM ALIN", 6);
        //teamManagerPage.clickSearchedElementInTMTable("61000378", 2);

        contextMenu.clickAddAbsence();
        addEditAbsencePage.addAbsence("Blood donation", "(1) Adjust to normtime");

//        addEditAbsencePage.selectAbsence(1, "Blood donation");
//        addEditAbsencePage.selectAuthTime(2, "(1) Adjust to normtime");
//        buttons.clickSave();

        teamManagerPage.waitPageToBeLoaded();

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
    public void deleteAbsence() throws InterruptedException {
        this.createTestReport("Delete Absence for an employee", "Employee: ACHIM ALIN, day: 10, Absence - Business trip");

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

        teamManagerPage.clickSearchedElementInTMTable("ACHIM ALIN", 10);
        //teamManagerPage.clickSearchedElementInTMTable("61000378", 2);

        contextMenu.clickAddAbsence();
        addEditAbsencePage.addAbsence("Business trip", "(h) Custom time", "0745");
        teamManagerPage.waitPageToBeLoaded();

        teamManagerPage.clickSearchedElementInTMTable("ACHIM ALIN", 10);
        contextMenu.clickRemoveAbsence();
        addEditAbsencePage.deleteAbsence("Business trip");
        teamManagerPage.waitPageToBeLoaded();

        assertFalse(teamManagerPage.checkIfItemIsPresentInSelectedDay("ACHIM ALIN", 10, "BT"), "Absence not found");

    }

    @Test
    public void deleteAbsenceWithAuth() throws InterruptedException {
        this.createTestReport("Delete Absence for an employee with Auth time \"(1) Adjust to normtime\"", "Employee: ACHIM ALIN, day: 11, Absence - Business trip");

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

        teamManagerPage.clickSearchedElementInTMTable("ACHIM ALIN", 11);
        //teamManagerPage.clickSearchedElementInTMTable("61000378", 2);

        contextMenu.clickAddAbsence();
        addEditAbsencePage.addAbsence("Business trip", "(1) Adjust to normtime");
        teamManagerPage.waitPageToBeLoaded();

        teamManagerPage.clickSearchedElementInTMTable("ACHIM ALIN", 11);
        contextMenu.clickRemoveAbsence();
        addEditAbsencePage.deleteAbsence("Business trip", "(1) Adjust to normtime");
        teamManagerPage.waitPageToBeLoaded();

        assertFalse(teamManagerPage.checkIfItemIsPresentInSelectedDay("ACHIM ALIN", 11, "BT"), "Absence not found");

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
    public void addBookingWithCompanySite() throws InterruptedException {
        this.createTestReport("Add booking + Company Site for an employee ", "Employee: AGACHE MIHAI, day: 5, Booking - 10:25");

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

        teamManagerPage.clickSearchedElementInTMTable("AGACHE MIHAI", 5);

        contextMenu.clickAddBooking();
        addEditBookingPage.addBooking("1025", "C", "HARMAN RO");
        teamManagerPage.waitPageToBeLoaded();
        buttons.clickOK();

        assertTrue(teamManagerPage.checkIfItemIsPresentInSelectedDay("AGACHE MIHAI", 5, "10:25"), "Booking not found");

    }

    @Test
    public void addBookingWithMCCode() throws InterruptedException {
        this.createTestReport("Add booking + MC for an employee", "Employee: AGACHE MIHAI, day: 6, Booking - 10:25");

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

        teamManagerPage.clickSearchedElementInTMTable("AGACHE MIHAI", 6);

        contextMenu.clickAddBooking();
        addEditBookingPage.addBookingMC("1025", "C", "Absence");
        teamManagerPage.waitPageToBeLoaded();
        buttons.clickOK();

        assertTrue(teamManagerPage.checkIfItemIsPresentInSelectedDay("AGACHE MIHAI", 6, "10:25"), "Booking not found");

    }

    @Test
    public void addBookingWithCCCode() throws InterruptedException {
        this.createTestReport("Add booking + CC for an employee", "Employee: AGACHE MIHAI, day: 7, Booking - 10:25");

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

        teamManagerPage.clickSearchedElementInTMTable("AGACHE MIHAI", 7);

        contextMenu.clickAddBooking();
        addEditBookingPage.addBookingCC("1025", "C", "CC");
        teamManagerPage.waitPageToBeLoaded();
        buttons.clickOK();

        assertTrue(teamManagerPage.checkIfItemIsPresentInSelectedDay("AGACHE MIHAI", 7, "10:25"), "Booking not found");

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
