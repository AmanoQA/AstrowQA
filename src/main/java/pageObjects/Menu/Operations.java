package pageObjects.Menu;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ExtentManager;
import utils.GenericDriver;

public class Operations {
    private final WebDriver operationDriver;
    private final WebDriverWait operationWait;
    private final ExtentTest writeLog;


    @FindBy(xpath = "//span[@class ='x-tab-inner' and text()='Operations']")
    private WebElement operationBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsAuthorization')]")
    private WebElement manageRequestBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsGroupOverview')]")
    private WebElement teamManagerBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsHolidayManager')]")
    private WebElement holidayPlannerBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsSiteOccupancyManagement')]")
    private WebElement occupancyMonitorBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsAnomalies')]")
    private WebElement teamAnomaliesBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsEmails')]")
    private WebElement communicateStatusBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsPeriodicConfirmationMSS')]")
    private WebElement teamTAStatusBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsJobScheduler')]")
    private WebElement taskSchedulerBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsUploadFiles')]")
    private WebElement bulkDocumentsUploadBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsFreezePeriod')]")
    private WebElement freezePeriodBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsTeamFiles')]")
    private WebElement employeeFilesBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsVisitorCheckIn')]")
    private WebElement visitorCheckInBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsVisitorCheckOut')]")
    private WebElement visitorCheckOutBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsNotification')]")
    private WebElement notificationsBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsBackUp')]")
    private WebElement assignDeputyBtn;

    // constructor
    public Operations(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d,this);
        this.operationDriver = d;
        this.operationWait = w;
        this.writeLog = l;
    }

    public void clickOperation(){
        this.operationWait.until(ExpectedConditions.visibilityOf(operationBtn));
        this.writeLog.info("Click on Operation tab");
        this.operationBtn.click();
    }

    public void clickManageRequest(){
        this.operationWait.until(ExpectedConditions.visibilityOf(manageRequestBtn));
        this.writeLog.info("Click on Manage Request button");
        this.manageRequestBtn.click();
    }

    public void clickTeamManager(){
        this.operationWait.until(ExpectedConditions.visibilityOf(teamManagerBtn));
        this.writeLog.info("Click on Team Manager button");
        this.teamManagerBtn.click();
    }

    public void clickHolidayPlanner(){
        this.operationWait.until(ExpectedConditions.visibilityOf(holidayPlannerBtn));
        this.writeLog.info("Click on Holiday Planner button");
        this.holidayPlannerBtn.click();
    }

    public void clickOccupancyMonitor(){
        this.operationWait.until(ExpectedConditions.visibilityOf(occupancyMonitorBtn));
        this.writeLog.info("Click on Occupancy Monitor button");
        this.occupancyMonitorBtn.click();
    }

    public void clickTeamAnomalies(){
        this.operationWait.until(ExpectedConditions.visibilityOf(teamAnomaliesBtn));
        this.writeLog.info("Click on Team Anomalies button");
        this.teamAnomaliesBtn.click();
    }

    public void clickCommunicateStatus(){
        this.operationWait.until(ExpectedConditions.visibilityOf(communicateStatusBtn));
        this.writeLog.info("Click on Communicate Status button");
        this.communicateStatusBtn.click();
    }

    public void clickTeamTAStatus(){
        this.operationWait.until(ExpectedConditions.visibilityOf(teamTAStatusBtn));
        this.writeLog.info("Click on Team T&A Status button");
        this.teamTAStatusBtn.click();
    }

    public void clickTaskScheduler(){
        this.operationWait.until(ExpectedConditions.visibilityOf(taskSchedulerBtn));
        this.writeLog.info("Click on Task Scheduler button");
        this.taskSchedulerBtn.click();
    }

    public void clickBulkDocumentsUpload(){
        this.operationWait.until(ExpectedConditions.visibilityOf(bulkDocumentsUploadBtn));
        this.writeLog.info("Click on Bulk Documents button");
        this.bulkDocumentsUploadBtn.click();
    }

    public void clickFreezePeriod(){
        this.operationWait.until(ExpectedConditions.visibilityOf(freezePeriodBtn));
        this.writeLog.info("Click on Freeze Period button");
        this.freezePeriodBtn.click();
    }

    public void clickEmployeeFiles(){
        this.operationWait.until(ExpectedConditions.visibilityOf(employeeFilesBtn));
        this.writeLog.info("Click on Employee Files button");
        this.employeeFilesBtn.click();
    }

    public void clickVisitorCheckIn(){
        this.operationWait.until(ExpectedConditions.visibilityOf(visitorCheckInBtn));
        this.writeLog.info("Click on Visitor Check In button");
        this.visitorCheckInBtn.click();
    }

    public void clickVisitorCheckOut(){
        this.operationWait.until(ExpectedConditions.visibilityOf(visitorCheckOutBtn));
        this.writeLog.info("Click on Visitor Check Out button");
        this.visitorCheckOutBtn.click();
    }

    public void clickNotifications(){
        this.operationWait.until(ExpectedConditions.visibilityOf(notificationsBtn));
        this.writeLog.info("Click on Notifications button");
        this.notificationsBtn.click();
    }

    public void clickAssignDeputy(){
        this.operationWait.until(ExpectedConditions.visibilityOf(assignDeputyBtn));
        this.writeLog.info("Click on Assign Deputy button");
        this.assignDeputyBtn.click();
    }

}
