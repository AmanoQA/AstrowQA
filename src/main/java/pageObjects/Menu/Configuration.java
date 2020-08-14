package pageObjects.Menu;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ExtentManager;

public class Configuration extends ExtentManager {

    private final WebDriver configurationDriver;
    private final WebDriverWait configurationWait;
    private final ExtentTest writeLog;

    @FindBy(xpath = "//span[@class ='x-tab-inner' and text()='Configuration']")
    private WebElement configurationBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsEmployees')]")
    private WebElement employeesBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsDepartment')]")
    private WebElement departmentsBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsDataGroups')]")
    private WebElement groupsBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsAuthorizationDefinition')]")
    private WebElement authorizationBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsDayProgram')]")
    private WebElement dayProgramsBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsPaygroup')]")
    private WebElement payGroupBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsCycle')]")
    private WebElement cycleBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsContract')]")
    private WebElement employeeContractBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsBreakGroup')]")
    private WebElement breakGroupsBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsBankHoliday')]")
    private WebElement bankHolidaysBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsOvertimeGroup')]")
    private WebElement overtimeGroupsBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsChopGroup')]")
    private WebElement chopGroupsBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsRoundingGroup')]")
    private WebElement roundingGroupsBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsAutoDPTable')]")
    private WebElement autoDPBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsAbsence')]")
    private WebElement absencesBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsHolidaySchemes')]")
    private WebElement senioritySchemesBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsHolidaySettings')]")
    private WebElement holidaySettingsBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsCounterDefinition')]")
    private WebElement counterDefinitionBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsCounterOperation')]")
    private WebElement counterOperationsBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsMCDefinition')]")
    private WebElement mcBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsCostCenter')]")
    private WebElement ccBtn;

    @FindBy(xpath = "//*[contains(@class, 'clsCompanySite')]")
    private WebElement companySitesBtn;


    // constructor
    public Configuration(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d,this);
        this.configurationDriver = d;
        this.configurationWait = w;
        this.writeLog = l;
    }

    public void clickConfiguration(){
        this.configurationWait.until(ExpectedConditions.visibilityOf(configurationBtn));
        this.writeLog.info("Click on Configuration tab");
        this.configurationBtn.click();
    }

    public void clickEmployees(){
        this.configurationWait.until(ExpectedConditions.visibilityOf(employeesBtn));
        this.writeLog.info("Click on Employees button");
        this.employeesBtn.click();
    }

    public void clickDepartments(){
        this.configurationWait.until(ExpectedConditions.visibilityOf(departmentsBtn));
        this.writeLog.info("Click on Departments button");
        this.departmentsBtn.click();
    }

    public void clickGroups(){
        this.configurationWait.until(ExpectedConditions.visibilityOf(groupsBtn));
        this.writeLog.info("Click on Groups button");
        this.groupsBtn.click();
    }

    public void clickAuthorization(){
        this.configurationWait.until(ExpectedConditions.visibilityOf(authorizationBtn));
        this.writeLog.info("Click on Authorization button");
        this.authorizationBtn.click();
    }

    public void clickDayPrograms(){
        this.configurationWait.until(ExpectedConditions.visibilityOf(dayProgramsBtn));
        this.writeLog.info("Click on Day Program button");
        this.dayProgramsBtn.click();
    }

    public void clickPayGroup(){
        this.configurationWait.until(ExpectedConditions.visibilityOf(payGroupBtn));
        this.writeLog.info("Click on Pay Group button");
        this.payGroupBtn.click();
    }

    public void clickCycle(){
        this.configurationWait.until(ExpectedConditions.visibilityOf(cycleBtn));
        this.writeLog.info("Click on Cycle button");
        this.cycleBtn.click();
    }

    public void clickEmployeeContract(){
        this.configurationWait.until(ExpectedConditions.visibilityOf(employeeContractBtn));
        this.writeLog.info("Click on Employee Contract button");
        this.employeeContractBtn.click();
    }

    public void clickBreakGroups(){
        this.configurationWait.until(ExpectedConditions.visibilityOf(breakGroupsBtn));
        this.writeLog.info("Click on Break Groups button");
        this.breakGroupsBtn.click();
    }

    public void clickBankHolidays(){
        this.configurationWait.until(ExpectedConditions.visibilityOf(bankHolidaysBtn));
        this.writeLog.info("Click on Bank Holiday button");
        this.bankHolidaysBtn.click();
    }

    public void clickOvertimeGroups(){
        this.configurationWait.until(ExpectedConditions.visibilityOf(overtimeGroupsBtn));
        this.writeLog.info("Click on Overtime button");
        this.overtimeGroupsBtn.click();
    }

    public void clickChopGroups(){
        this.configurationWait.until(ExpectedConditions.visibilityOf(chopGroupsBtn));
        this.writeLog.info("Click on Chop Groups button");
        this.chopGroupsBtn.click();
    }

    public void clickRoundingGroups(){
        this.configurationWait.until(ExpectedConditions.visibilityOf(roundingGroupsBtn));
        this.writeLog.info("Click on Rounding Groups button");
        this.roundingGroupsBtn.click();
    }

    public void clickAutoDP(){
        this.configurationWait.until(ExpectedConditions.visibilityOf(autoDPBtn));
        this.writeLog.info("Click on Auto DP button");
        this.autoDPBtn.click();
    }

    public void clickAbsences(){
        this.configurationWait.until(ExpectedConditions.visibilityOf(absencesBtn));
        this.writeLog.info("Click on Absences button");
        this.absencesBtn.click();
    }

    public void clickSenioritySchemes(){
        this.configurationWait.until(ExpectedConditions.visibilityOf(senioritySchemesBtn));
        this.writeLog.info("Click on Seniority Schemes button");
        this.senioritySchemesBtn.click();
    }

    public void clickHolidaySettings(){
        this.configurationWait.until(ExpectedConditions.visibilityOf(holidaySettingsBtn));
        this.writeLog.info("Click on Holiday Settings button");
        this.holidaySettingsBtn.click();
    }

    public void clickCounterDefinition(){
        this.configurationWait.until(ExpectedConditions.visibilityOf(counterDefinitionBtn));
        this.writeLog.info("Click on Counter Definitions button");
        this.counterDefinitionBtn.click();
    }

    public void clickCounterOperations(){
        this.configurationWait.until(ExpectedConditions.visibilityOf(counterOperationsBtn));
        this.writeLog.info("Click on Counter Operations button");
        this.counterOperationsBtn.click();
    }

    public void clickMC(){
        this.configurationWait.until(ExpectedConditions.visibilityOf(mcBtn));
        this.writeLog.info("Click on Master Codes button");
        this.mcBtn.click();
    }

    public void clickCC(){
        this.configurationWait.until(ExpectedConditions.visibilityOf(ccBtn));
        this.writeLog.info("Click on Cost Centers button");
        this.ccBtn.click();
    }

    public void clickCompanySites(){
        this.configurationWait.until(ExpectedConditions.visibilityOf(companySitesBtn));
        this.writeLog.info("Click on Company Sites button");
        this.companySitesBtn.click();
    }

}
