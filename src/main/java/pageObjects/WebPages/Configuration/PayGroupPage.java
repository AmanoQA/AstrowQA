package pageObjects.WebPages.Configuration;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Controls.Calendar.Calendar;
import pageObjects.Controls.DropDown;
import pageObjects.Controls.DropDownWithoutNone;

import java.util.List;

public class PayGroupPage {
    private final WebDriver pgPageDriver;
    private final WebDriverWait pgPageWait;
    private final ExtentTest writeLog;

    //--Add/Edit--------------------------------------------------------------

    @FindBy(xpath = "//input[@name = 'name1']")
    private WebElement namePG;

    @FindBy(xpath = "//input[@name = 'nrperiods']")
    private WebElement nrPeriods;

    @FindBy(xpath = "//input[@name = 'type']/parent::*/div")
    private WebElement payPeriodType;

    @FindBy(xpath = "//input[@name = 'lastxday']/parent::*/div")
    private WebElement lastXDay;

    @FindBy(xpath = "//input[@name = 'payendday1']")
    private WebElement payPeriodEndingDay1;

    @FindBy(xpath = "//input[@name = 'payendday2']")
    private WebElement payPeriodEndingDay2;

    @FindBy(xpath = "//input[@name = 'weekending']/parent::*/div")
    private WebElement weekEndingDay;

    @FindBy(xpath = "//input[@name = 'startdate']/parent::*/div")
    private WebElement startDate;

    @FindBy(xpath = "//input[@name = 'calctype']/parent::*/div")
    private WebElement calculationType;

    @FindBy(xpath = "//input[@name = 'pcarrymax']")
    private WebElement carryOverMax;

    @FindBy(xpath = "//input[@name = 'pcarrymin']")
    private WebElement carryOverMin;

    @FindBy(xpath = "//input[@name = 'tcntmax']")
    private WebElement tLostMax;

    @FindBy(xpath = "//input[@name = 'tcntmin']")
    private WebElement tLostMin;

    @FindBy(xpath = "(//*[contains(@class, 'x-form-item-body x-form-cb-wrap')])[1]/input")
    private WebElement authorizationQuantityBasedOvertime;

    @FindBy(xpath = "(//*[contains(@class, 'x-form-item-body x-form-cb-wrap')])[2]/input")
    private WebElement authorizationZoneBasedOvertime;

    @FindBy(xpath = "(//*[contains(@class, 'x-form-item-body x-form-cb-wrap')])[3]/input")
    private WebElement authorizationHolidayWork;

    @FindBy(xpath = "(//*[contains(@class, 'x-form-item-body x-form-cb-wrap')])[4]/input")
    private WebElement acceptOvertimeMCFromTerminal;

    @FindBy(xpath = "(//*[contains(@class, 'x-form-item-body x-form-cb-wrap')])[5]/input")
    private WebElement acceptAbsenceMCFromTerminal;

    @FindBy(xpath = "//div[@class = 'list-ct']/ul")
    private List<WebElement> dropDownList;

    @FindBy(xpath = "//table[@class = 'x-datepicker-inner']/tbody")
    private List<WebElement> calendarTable;

    // constructor
    public PayGroupPage(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d, this);
        this.pgPageDriver = d;
        this.pgPageWait = w;
        this.writeLog = l;
    }

    public void setPayGroupName(String pgName) {

        this.pgPageWait.until(ExpectedConditions.visibilityOf(namePG));
        //this.codeField.clear();
        this.writeLog.info("Enter Pay Group Name: " + pgName);
        this.namePG.sendKeys(pgName);
    }

    public void selectPayPeriodType(int index, String ppType) throws InterruptedException {

        this.pgPageWait.until(ExpectedConditions.visibilityOf(payPeriodType));
        this.writeLog.info("Open the Pay Period Type dropdown list");
        payPeriodType.click();
        Thread.sleep(2000);
        WebElement dropDownListElement = dropDownList.get(index-1);

        DropDownWithoutNone dropDown = new DropDownWithoutNone(this.pgPageDriver, this.pgPageWait, this.writeLog);
        this.writeLog.info("Select Pay Period Type: " + ppType);
        dropDown.dropDownSelect(dropDownListElement, ppType);
    }

    public void setPayPeriodEndingDay1(String ppEndingDay1){
        this.pgPageWait.until(ExpectedConditions.visibilityOf(payPeriodEndingDay1));
        this.payPeriodEndingDay1.clear();
        this.writeLog.info("Enter Pay period ending day1: " + ppEndingDay1);
        this.payPeriodEndingDay1.sendKeys(ppEndingDay1);
    }

    public void selectWeekEndingDay(int index, String wEndingDay) throws InterruptedException {

        this.pgPageWait.until(ExpectedConditions.visibilityOf(weekEndingDay));
        this.writeLog.info("Open the Week Ending Day dropdown list");
        weekEndingDay.click();
        Thread.sleep(2000);
        WebElement dropDownListElement = dropDownList.get(index-1);

        DropDownWithoutNone dropDown = new DropDownWithoutNone(this.pgPageDriver, this.pgPageWait, this.writeLog);
        this.writeLog.info("Select Week Ending day: " + wEndingDay);
        dropDown.dropDownSelect(dropDownListElement, wEndingDay);
    }


    public void selectStartDate(int index, String day, String month, String year) {

        this.pgPageWait.until(ExpectedConditions.elementToBeClickable(startDate));
        this.writeLog.info("Click on Start Date Calendar ");
        this.startDate.click();

        WebElement calendarListElement = calendarTable.get(index - 1);

        Calendar calendar = new Calendar(this.pgPageDriver, this.pgPageWait, this.writeLog);
        this.writeLog.info("Select date from calendar: " + day + " ," + month + " ," + year);
        calendar.selectDateFromCalendar(calendarListElement, day, month, year);
    }

    public void selectCalculationType(int index, String calcType) throws InterruptedException {

        this.pgPageWait.until(ExpectedConditions.visibilityOf(calculationType));
        this.writeLog.info("Open the Calculation Type dropdown list");
        calculationType.click();
        Thread.sleep(2000);
        WebElement dropDownListElement = dropDownList.get(index-1);

        DropDownWithoutNone dropDown = new DropDownWithoutNone(this.pgPageDriver, this.pgPageWait, this.writeLog);
        this.writeLog.info("Select Calculation Type: " + calcType);
        dropDown.dropDownSelect(dropDownListElement, calcType);
    }

}
