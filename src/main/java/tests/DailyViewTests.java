package tests;

import org.testng.annotations.Test;
import pageObjects.Menu.Operations;
import pageObjects.Menu.TeamManager.ContextMenu;
import pageObjects.Menu.View;
import pageObjects.WebPages.*;
import utils.ExtentManager;

public class DailyViewTests extends ExtentManager {

    @Test
    public void checkAddBooking(){
        this.createTestReport("Check Add Booking", "Check Add Booking");
        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Operations operations = new Operations(this.driver, this.wait, writeLog.get());
        TeamManagerPage teamManagerPage = new TeamManagerPage(this.driver, this.wait, writeLog.get());
        HolidayCardPage holidayCardPage = new HolidayCardPage(this.driver, this.wait, writeLog.get());
        ContextMenu contextMenu = new ContextMenu(this.driver, this.wait, writeLog.get());
        AddEditBookingPage addEditBookingPage = new AddEditBookingPage(this.driver, this.wait, writeLog.get());
        DailyViewPage dailyViewPage = new DailyViewPage(this.driver, this.wait, writeLog.get());


        loginPage.doLogin("eumarin", "");

        operations.clickOperation();
        operations.clickTeamManager();
        teamManagerPage.waitPageToBeLoaded();

        teamManagerPage.clickSearchedElementInTMTable("BALULESCU PATRICK CLAUDIU", 12);
        contextMenu.clickDailyView();
        dailyViewPage.clickNewBooking();
        addEditBookingPage.addBooking("1425", "C");


    }
}
