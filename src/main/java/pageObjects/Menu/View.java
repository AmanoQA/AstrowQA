package pageObjects.Menu;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ExtentManager;

public class View {

    private final WebDriver viewDriver;
    private final WebDriverWait viewWait;
    private final ExtentTest writeLog;

    @FindBy(xpath = "//span[@class ='x-tab-inner' and text()='View']")
    private WebElement viewBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsDashboard')]")
    private WebElement dashboardBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsMyMessages')]")
    private WebElement messagesBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsRequestsHistory')]")
    private WebElement requestsHistoryBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsPIP')]")
    private WebElement pipBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsNote')]")
    private WebElement notesBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsOperationLog')]")
    private WebElement operationLogBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsFiles')]")
    private WebElement myFilesBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsVisitors')]")
    private WebElement visitorsListBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsHolidayCard')]")
    private WebElement holidayCardBtn;


    // constructor
    public View(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d,this);
        this.viewDriver = d;
        this.viewWait = w;
        this.writeLog = l;
    }

    public void clickView(){
        this.viewWait.until(ExpectedConditions.visibilityOf(viewBtn));
        this.writeLog.info("Click on View tab");
        this.viewBtn.click();
    }

    public void clickDashboard(){
        this.viewWait.until(ExpectedConditions.visibilityOf(dashboardBtn));
        this.writeLog.info("Click on Dashboard button");
        this.dashboardBtn.click();
    }

    public void clickMessages(){
        this.viewWait.until(ExpectedConditions.visibilityOf(messagesBtn));
        this.writeLog.info("Click on Messages button");
        this.messagesBtn.click();
    }

    public void clickRequestsHistory(){
        this.viewWait.until(ExpectedConditions.visibilityOf(requestsHistoryBtn));
        this.writeLog.info("Click on Requests History button");
        this.requestsHistoryBtn.click();
    }

    public void clickPIP(){
        this.viewWait.until(ExpectedConditions.visibilityOf(pipBtn));
        this.writeLog.info("Click on PIP button");
        this.pipBtn.click();
    }

    public void clickNotes(){
        this.viewWait.until(ExpectedConditions.visibilityOf(notesBtn));
        this.writeLog.info("Click on Notes button");
        this.notesBtn.click();
    }

    public void clickOperationLog(){
        this.viewWait.until(ExpectedConditions.visibilityOf(operationLogBtn));
        this.writeLog.info("Click on Operation Log button");
        this.operationLogBtn.click();
    }

    public void clickMyFiles(){
        this.viewWait.until(ExpectedConditions.visibilityOf(myFilesBtn));
        this.writeLog.info("Click on My Files button");
        this.myFilesBtn.click();
    }

    public void clickVisitorsList(){
        this.viewWait.until(ExpectedConditions.visibilityOf(visitorsListBtn));
        this.writeLog.info("Click on Visitor List button");
        this.visitorsListBtn.click();
    }

    public void clickHolidayCard(){
        this.viewWait.until(ExpectedConditions.visibilityOf(holidayCardBtn));
        this.writeLog.info("Click on Holiday Card button");
        this.holidayCardBtn.click();
    }
}
