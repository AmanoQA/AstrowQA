package tests;

import org.testng.annotations.Test;
import pageObjects.Controls.Buttons;
import pageObjects.Menu.Operations;
import pageObjects.Menu.TeamManager.ContextMenu;
import pageObjects.WebPages.*;
import utils.AppParams;
import utils.ExtentManager;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DailyViewTests extends ExtentManager {

    @Test
    public void checkAddBooking() throws InterruptedException {
        this.createTestReport("Check Add Booking", "Check Add Booking");
        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Operations operations = new Operations(this.driver, this.wait, writeLog.get());
        TeamManagerPage teamManagerPage = new TeamManagerPage(this.driver, this.wait, writeLog.get());
        ContextMenu contextMenu = new ContextMenu(this.driver, this.wait, writeLog.get());
        AddEditBookingPage addEditBookingPage = new AddEditBookingPage(this.driver, this.wait, writeLog.get());
        DailyViewPage dailyViewPage = new DailyViewPage(this.driver, this.wait, writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "eumarin", "1");

        operations.clickOperation();
        operations.clickTeamManager();
        waitPageToBeLoaded();

        teamManagerPage.clickSearchedElementInTMTable("BALULESCU PATRICK CLAUDIU", 12);
        contextMenu.clickDailyView();
        dailyViewPage.clickNewBooking();
        addEditBookingPage.addBooking("1425", "C");
        dailyViewPage.waitPageToBeLoaded();

        assertTrue(dailyViewPage.checkIfBookingIsPresent("14:25"));

    }
    @Test
    public void checkAddBookingWithCompanySite() throws InterruptedException {
        this.createTestReport("Check Add Booking + Company Site", "Check Add Booking");
        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Operations operations = new Operations(this.driver, this.wait, writeLog.get());
        TeamManagerPage teamManagerPage = new TeamManagerPage(this.driver, this.wait, writeLog.get());
        ContextMenu contextMenu = new ContextMenu(this.driver, this.wait, writeLog.get());
        AddEditBookingPage addEditBookingPage = new AddEditBookingPage(this.driver, this.wait, writeLog.get());
        DailyViewPage dailyViewPage = new DailyViewPage(this.driver, this.wait, writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "eumarin", "1");

        operations.clickOperation();
        operations.clickTeamManager();
        waitPageToBeLoaded();

        teamManagerPage.clickSearchedElementInTMTable("BALULESCU PATRICK CLAUDIU", 10);
        contextMenu.clickDailyView();
        dailyViewPage.clickNewBooking();
        addEditBookingPage.addBooking("1425", "C", "HARMAN RO");
        dailyViewPage.waitPageToBeLoaded();

        assertTrue(dailyViewPage.checkIfBookingCompanySiteArePresent("14:25", "HARMAN RO"));

    }


    @Test
    public void editBooking() throws InterruptedException {
        this.createTestReport("Edit a Booking", "Edit a Booking");
        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Operations operations = new Operations(this.driver, this.wait, writeLog.get());
        TeamManagerPage teamManagerPage = new TeamManagerPage(this.driver, this.wait, writeLog.get());
        ContextMenu contextMenu = new ContextMenu(this.driver, this.wait, writeLog.get());
        AddEditBookingPage addEditBookingPage = new AddEditBookingPage(this.driver, this.wait, writeLog.get());
        DailyViewPage dailyViewPage = new DailyViewPage(this.driver, this.wait, writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "eumarin", "1");

        operations.clickOperation();
        operations.clickTeamManager();
        waitPageToBeLoaded();

        teamManagerPage.clickSearchedElementInTMTable("BALULESCU PATRICK CLAUDIU", 12);
        contextMenu.clickDailyView();
        dailyViewPage.clickNewBooking();
        addEditBookingPage.addBooking("1425", "C");
        dailyViewPage.waitPageToBeLoaded();

        dailyViewPage.clickSearchedBooking("14:25");
        dailyViewPage.clickEditBooking();
        addEditBookingPage.addBooking("1545", "C");
        dailyViewPage.waitPageToBeLoaded();

        assertTrue(dailyViewPage.checkIfBookingIsPresent("15:45"));

    }

    @Test
    public void deleteBooking() throws InterruptedException {
        this.createTestReport("Delete a Booking", "Delete a Booking");
        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Operations operations = new Operations(this.driver, this.wait, writeLog.get());
        TeamManagerPage teamManagerPage = new TeamManagerPage(this.driver, this.wait, writeLog.get());
        ContextMenu contextMenu = new ContextMenu(this.driver, this.wait, writeLog.get());
        AddEditBookingPage addEditBookingPage = new AddEditBookingPage(this.driver, this.wait, writeLog.get());
        DailyViewPage dailyViewPage = new DailyViewPage(this.driver, this.wait, writeLog.get());
        Buttons buttons = new Buttons(this.driver, this.wait, writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "eumarin", "1");

        operations.clickOperation();
        operations.clickTeamManager();
        waitPageToBeLoaded();

        teamManagerPage.clickSearchedElementInTMTable("BALULESCU PATRICK CLAUDIU", 14);
        contextMenu.clickDailyView();
        dailyViewPage.clickNewBooking();
        addEditBookingPage.addBooking("1230", "C");
        dailyViewPage.waitPageToBeLoaded();

        dailyViewPage.clickSearchedBooking("12:30");
        dailyViewPage.clickDeleteBooking();
        buttons.clickYes();
        dailyViewPage.waitPageToBeLoaded();

        assertFalse(dailyViewPage.checkIfBookingIsPresent("12:30"));

    }

    @Test(dependsOnMethods = {"editBooking"})
    public void checkBooking() throws InterruptedException {
        this.createTestReport("Check a Booking", "Check a Booking");
        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Operations operations = new Operations(this.driver, this.wait, writeLog.get());
        TeamManagerPage teamManagerPage = new TeamManagerPage(this.driver, this.wait, writeLog.get());
        ContextMenu contextMenu = new ContextMenu(this.driver, this.wait, writeLog.get());
        AddEditBookingPage addEditBookingPage = new AddEditBookingPage(this.driver, this.wait, writeLog.get());
        DailyViewPage dailyViewPage = new DailyViewPage(this.driver, this.wait, writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "eumarin", "1");

        operations.clickOperation();
        operations.clickTeamManager();
        waitPageToBeLoaded();

        teamManagerPage.clickSearchedElementInTMTable("BALULESCU PATRICK CLAUDIU", 12);
        contextMenu.clickDailyView();

        assertTrue(dailyViewPage.checkIfBookingIsPresent("15:45"));

    }

    @Test
    public void checkAddAbsence() throws InterruptedException {
        this.createTestReport("Check Add an Absence", "Check Add an absence");
        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Operations operations = new Operations(this.driver, this.wait, writeLog.get());
        TeamManagerPage teamManagerPage = new TeamManagerPage(this.driver, this.wait, writeLog.get());
        ContextMenu contextMenu = new ContextMenu(this.driver, this.wait, writeLog.get());
        AddEditAbsencePage addEditAbsencePage = new AddEditAbsencePage(this.driver, this.wait, writeLog.get());
        DailyViewPage dailyViewPage = new DailyViewPage(this.driver, this.wait, writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "eumarin", "1");

        operations.clickOperation();
        operations.clickTeamManager();
        waitPageToBeLoaded();

        teamManagerPage.clickSearchedElementInTMTable("BALULESCU PATRICK CLAUDIU", 12);
        contextMenu.clickDailyView();
        dailyViewPage.clickNewAbsence();
        addEditAbsencePage.addAbsence("Business trip", "(h) Custom time", "05:45");
        dailyViewPage.waitPageToBeLoaded();

        assertTrue(dailyViewPage.checkIfAbsenceIsPresent("Business trip"));

    }

    @Test
    public void editAbsence() throws InterruptedException {
        this.createTestReport("Edit an absence", "Edit an absence");
        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Operations operations = new Operations(this.driver, this.wait, writeLog.get());
        TeamManagerPage teamManagerPage = new TeamManagerPage(this.driver, this.wait, writeLog.get());
        ContextMenu contextMenu = new ContextMenu(this.driver, this.wait, writeLog.get());
        AddEditAbsencePage addEditAbsencePage = new AddEditAbsencePage(this.driver, this.wait, writeLog.get());
        DailyViewPage dailyViewPage = new DailyViewPage(this.driver, this.wait, writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "eumarin", "1");

        operations.clickOperation();
        operations.clickTeamManager();
        waitPageToBeLoaded();

        teamManagerPage.clickSearchedElementInTMTable("BALULESCU PATRICK CLAUDIU", 10);
        contextMenu.clickDailyView();
        dailyViewPage.clickNewAbsence();
        addEditAbsencePage.addAbsence("Business trip", "(h) Custom time", "05:45");
        dailyViewPage.waitPageToBeLoaded();

        dailyViewPage.clickSearchedAbsence("Business trip");
        dailyViewPage.clickEditAbsence();
        addEditAbsencePage.addAbsence("Medical leave", "(1) Adjust to normtime");
        dailyViewPage.waitPageToBeLoaded();

        assertTrue(dailyViewPage.checkIfAbsenceIsPresent("Medical leave"));

    }

    @Test
    public void deleteAbsence() throws InterruptedException {
        this.createTestReport("Delete an absence", "Delete an absence");
        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Operations operations = new Operations(this.driver, this.wait, writeLog.get());
        TeamManagerPage teamManagerPage = new TeamManagerPage(this.driver, this.wait, writeLog.get());
        ContextMenu contextMenu = new ContextMenu(this.driver, this.wait, writeLog.get());
        AddEditAbsencePage addEditAbsencePage = new AddEditAbsencePage(this.driver, this.wait, writeLog.get());
        DailyViewPage dailyViewPage = new DailyViewPage(this.driver, this.wait, writeLog.get());
        Buttons buttons = new Buttons(this.driver, this.wait,writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "eumarin", "1");

        operations.clickOperation();
        operations.clickTeamManager();
        waitPageToBeLoaded();

        teamManagerPage.clickSearchedElementInTMTable("BALULESCU PATRICK CLAUDIU", 14);
        contextMenu.clickDailyView();
        dailyViewPage.clickNewAbsence();
        addEditAbsencePage.addAbsence("Business trip", "(h) Custom time", "05:45");
        dailyViewPage.waitPageToBeLoaded();

        dailyViewPage.clickSearchedAbsence("Business trip");
        dailyViewPage.clickDeleteAbsence();
        buttons.clickYes();
        //dailyViewPage.waitPageToBeLoaded();

        assertFalse(dailyViewPage.checkIfAbsenceIsPresent("Business trip"));

    }
}
