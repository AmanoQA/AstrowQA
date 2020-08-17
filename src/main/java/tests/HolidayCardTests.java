package tests;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pageObjects.Menu.Operations;
import pageObjects.Menu.TeamManager.ContextMenu;
import pageObjects.Menu.View;
import pageObjects.WebPages.HolidayCardPage;
import pageObjects.WebPages.LoginPage;
import pageObjects.WebPages.TeamManagerPage;
import utils.AppParams;
import utils.ExtentManager;

public class HolidayCardTests extends ExtentManager {

    @Test
    public void checkHolidayCardBtns(){
        this.createTestReport("Check Holiday card", "Check Holiday card");
        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        View view = new View(this.driver, this.wait, writeLog.get());
        HolidayCardPage holidayCardPage = new HolidayCardPage(this.driver, this.wait, writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "eumarin", "1");

        view.clickView();
        view.clickHolidayCard();
        holidayCardPage.clickHolidayPrevPeriod();
        holidayCardPage.clickHolidayCurrentPeriod();
        holidayCardPage.clickHolidayNextPeriod();

    }

    @Test
    public void checkHolidayCardBtnsFromTeamManager(){
        this.createTestReport("Check from Team manager", "Check Holiday card from Team manager");
        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());
        Operations operations = new Operations(this.driver, this.wait, writeLog.get());
        TeamManagerPage teamManagerPage = new TeamManagerPage(this.driver, this.wait, writeLog.get());
        HolidayCardPage holidayCardPage = new HolidayCardPage(this.driver, this.wait, writeLog.get());
        ContextMenu contextMenu = new ContextMenu(this.driver, this.wait, writeLog.get());

        loginPage.doLogin(AppParams.domainCloud, "eumarin", "1");

        operations.clickOperation();
        operations.clickTeamManager();
        teamManagerPage.waitPageToBeLoaded();

        teamManagerPage.clickSearchedElementInTMTable("BALULESCU PATRICK CLAUDIU", 12);
        contextMenu.clickViewHolidayCard();

        holidayCardPage.clickHolidayPrevPeriod();
        holidayCardPage.clickHolidayCurrentPeriod();
        holidayCardPage.clickHolidayNextPeriod();

    }
}
