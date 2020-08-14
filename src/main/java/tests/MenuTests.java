package tests;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import pageObjects.Menu.Configuration;
import pageObjects.Menu.Operations;
import pageObjects.Menu.View;
import pageObjects.WebPages.LoginPage;
import utils.ExtentManager;

public class MenuTests extends ExtentManager {
    @Test
    public void clickOnOperationMenu(){
        this.createTestReport("Operation menu buttons", "Click on all Operations menu buttons.");

        Operations operations = new Operations(this.driver, this.wait, writeLog.get());
        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());

        loginPage.doLogin("hr", "");

        operations.clickOperation();
        operations.clickManageRequest();
        operations.clickTeamManager();
        operations.clickHolidayPlanner();
        operations.clickOccupancyMonitor();
        operations.clickTeamAnomalies();
        operations.clickCommunicateStatus();
        operations.clickTeamTAStatus();
        operations.clickTaskScheduler();
        operations.clickBulkDocumentsUpload();
        operations.clickFreezePeriod();
        operations.clickEmployeeFiles();
        operations.clickVisitorCheckIn();
        operations.clickVisitorCheckOut();
        operations.clickNotifications();
        operations.clickAssignDeputy();

    }

    @Test
    private void clickOnViewMenu(){
        this.createTestReport("View menu buttons", "Click on all View menu buttons.");

        View view = new View(this.driver, this.wait, writeLog.get());
        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());

        loginPage.doLogin("hr", "");

        view.clickView();
        view.clickDashboard();
        view.clickMessages();
        view.clickRequestsHistory();
        view.clickPIP();
        view.clickNotes();
        view.clickOperationLog();
        view.clickMyFiles();
        view.clickVisitorsList();

    }

    @Test
    private void clickOnConfigurationMenu() {
        this.createTestReport("Configuration menu buttons", "Click on all Configuration menu buttons.");

        Configuration configuration = new Configuration(this.driver, this.wait, writeLog.get());
        LoginPage loginPage = new LoginPage(this.driver, this.wait, writeLog.get());

        loginPage.doLogin("hr", "");

        configuration.clickConfiguration();
        configuration.clickEmployees();
        configuration.clickDepartments();
        configuration.clickGroups();
        configuration.clickAuthorization();
        configuration.clickDayPrograms();
        configuration.clickPayGroup();
        configuration.clickCycle();
        configuration.clickEmployeeContract();
        configuration.clickBreakGroups();
        configuration.clickBankHolidays();
        configuration.clickOvertimeGroups();
        configuration.clickChopGroups();
        configuration.clickRoundingGroups();
        configuration.clickAutoDP();
        configuration.clickAbsences();
        configuration.clickSenioritySchemes();
        configuration.clickHolidaySettings();
        configuration.clickCounterDefinition();
        configuration.clickCounterOperations();
        configuration.clickMC();
        configuration.clickCC();
        configuration.clickCompanySites();

    }

}
