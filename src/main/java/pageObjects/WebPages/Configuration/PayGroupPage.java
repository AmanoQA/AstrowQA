package pageObjects.WebPages.Configuration;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Controls.Calendar.Calendar;
import pageObjects.Controls.DropDown;
import pageObjects.Controls.DropDownWithoutNone;
import pageObjects.Controls.EnterTime;
import pageObjects.Controls.SearchInTable;

import java.util.List;

public class PayGroupPage {
    private final WebDriver pgPageDriver;
    private final WebDriverWait pgPageWait;
    private final ExtentTest writeLog;

    //--Add/Edit--------------------------------------------------------------

    @FindBy(xpath = "//input[@name = 'name1']")
    private WebElement namePGField;

    @FindBy(xpath = "//input[@name = 'nrperiods']")
    private WebElement nrPeriodsField;

    @FindBy(xpath = "//input[@name = 'type']/parent::*/div")
    private WebElement payPeriodTypeField;

    @FindBy(xpath = "//input[@name = 'lastxday']/parent::*/div")
    private WebElement lastXDayField;

    @FindBy(xpath = "//input[@name = 'payendday1']")
    private WebElement payPeriodEndingDay1Field;

    @FindBy(xpath = "//input[@name = 'payendday2']")
    private WebElement payPeriodEndingDay2Field;

    @FindBy(xpath = "//input[@name = 'weekending']/parent::*/div")
    private WebElement weekEndingDayField;

    @FindBy(xpath = "//input[@name = 'startdate']/parent::*/div")
    private WebElement startDateField;

    @FindBy(xpath = "//input[@name = 'calctype']/parent::*/div")
    private WebElement calculationTypeField;

    @FindBy(xpath = "//input[@name = 'pcarrymax']")
    private WebElement carryOverMaxField;

    @FindBy(xpath = "//input[@name = 'pcarrymin']")
    private WebElement carryOverMinField;

    @FindBy(xpath = "//input[@name = 'tcntmax']")
    private WebElement tLostMaxField;

    @FindBy(xpath = "//input[@name = 'tcntmin']")
    private WebElement tLostMinField;

    @FindBy(xpath = "(//*[contains(@class, 'x-form-item-body x-form-cb-wrap')])[1]/input")
    private WebElement authorizationQuantityBasedOvertimeCheckBox;

    @FindBy(xpath = "(//*[contains(@class, 'x-form-item-body x-form-cb-wrap')])[2]/input")
    private WebElement authorizationZoneBasedOvertimeCheckBox;

    @FindBy(xpath = "(//*[contains(@class, 'x-form-item-body x-form-cb-wrap')])[3]/input")
    private WebElement authorizationHolidayWorkCheckBox;

    @FindBy(xpath = "(//*[contains(@class, 'x-form-item-body x-form-cb-wrap')])[4]/input")
    private WebElement acceptOvertimeMCFromTerminalCheckBox;

    @FindBy(xpath = "(//*[contains(@class, 'x-form-item-body x-form-cb-wrap')])[5]/input")
    private WebElement acceptAbsenceMCFromTerminalCheckBox;

    @FindBy(xpath = "//div[@class = 'list-ct']/ul")
    private List<WebElement> dropDownList;

    @FindBy(xpath = "//table[@class = 'x-datepicker-inner']/tbody")
    private List<WebElement> calendarTable;


    //--Pay Group List --------------------------------------------------------------

    @FindBy(xpath = "//div[contains(@id, 'gridview')]/table/tbody")
    private WebElement pgTable;

    // constructor
    public PayGroupPage(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d, this);
        this.pgPageDriver = d;
        this.pgPageWait = w;
        this.writeLog = l;
    }

    public void setPayGroupName(String payGroupName) {
        this.pgPageWait.until(ExpectedConditions.visibilityOf(namePGField));
        this.namePGField.clear();
        this.writeLog.info("Enter Pay Group Name: " + payGroupName);
        this.namePGField.sendKeys(payGroupName);
    }

    public void selectPayPeriodType(int index, String payPeriodType) throws InterruptedException {
        this.pgPageWait.until(ExpectedConditions.visibilityOf(payPeriodTypeField));
        this.writeLog.info("Open the Pay Period Type dropdown list");
        payPeriodTypeField.click();
        Thread.sleep(2000);
        WebElement dropDownListElement = dropDownList.get(index-1);

        DropDownWithoutNone dropDown = new DropDownWithoutNone(this.pgPageDriver, this.pgPageWait, this.writeLog);
        this.writeLog.info("Select Pay Period Type: " + payPeriodType);
        dropDown.dropDownSelect(dropDownListElement, payPeriodType);
    }

    public void setPayPeriodEndingDay1(String payPeriodEndingDay1){
        this.pgPageWait.until(ExpectedConditions.visibilityOf(payPeriodEndingDay1Field));
        this.payPeriodEndingDay1Field.clear();
        this.writeLog.info("Enter Pay period ending day1: " + payPeriodEndingDay1);
        this.payPeriodEndingDay1Field.sendKeys(payPeriodEndingDay1);
    }

    public void selectWeekEndingDay(int index, String weekEndingDay) throws InterruptedException {
        this.pgPageWait.until(ExpectedConditions.visibilityOf(weekEndingDayField));
        this.writeLog.info("Open the Week Ending Day dropdown list");
        weekEndingDayField.click();
        Thread.sleep(2000);
        WebElement dropDownListElement = dropDownList.get(index-1);

        DropDownWithoutNone dropDown = new DropDownWithoutNone(this.pgPageDriver, this.pgPageWait, this.writeLog);
        this.writeLog.info("Select Week Ending day: " + weekEndingDay);
        dropDown.dropDownSelect(dropDownListElement, weekEndingDay);
    }


    public void selectStartDate(int index, String day, String month, String year) {

        this.pgPageWait.until(ExpectedConditions.elementToBeClickable(startDateField));
        this.writeLog.info("Click on Start Date Calendar ");
        this.startDateField.click();

        WebElement calendarListElement = calendarTable.get(index - 1);

        Calendar calendar = new Calendar(this.pgPageDriver, this.pgPageWait, this.writeLog);
        this.writeLog.info("Select date from calendar: " + day + " ," + month + " ," + year);
        calendar.selectDateFromCalendar(calendarListElement, day, month, year);
    }

    public void selectCalculationType(int index, String calculationType) throws InterruptedException {

        this.pgPageWait.until(ExpectedConditions.visibilityOf(calculationTypeField));
        this.writeLog.info("Open the Calculation Type dropdown list");
        calculationTypeField.click();
        Thread.sleep(2000);
        WebElement dropDownListElement = dropDownList.get(index-1);

        DropDownWithoutNone dropDown = new DropDownWithoutNone(this.pgPageDriver, this.pgPageWait, this.writeLog);
        this.writeLog.info("Select Calculation Type: " + calculationType);
        dropDown.dropDownSelect(dropDownListElement, calculationType);
    }

    public void setCarryOverMax(String carryOverMax) throws InterruptedException {
        EnterTime enterTime = new EnterTime(this.pgPageDriver, this.pgPageWait);

        this.pgPageWait.until(ExpectedConditions.visibilityOf(carryOverMaxField));
        this.writeLog.info("Set Carry Over Max: " + carryOverMax);
        enterTime.enterTime(carryOverMaxField, carryOverMax, "yes");
    }

    public void setCarryOverMin(String carryOverMin) throws InterruptedException {
        EnterTime enterTime = new EnterTime(this.pgPageDriver, this.pgPageWait);

        this.pgPageWait.until(ExpectedConditions.visibilityOf(carryOverMinField));
        this.writeLog.info("Set Carry Over Min: " + carryOverMin);
        enterTime.enterTime(carryOverMinField, carryOverMin, "yes");
    }

    public void setTLostMax(String tLostMax) {
        this.pgPageWait.until(ExpectedConditions.visibilityOf(tLostMaxField));
        this.tLostMaxField.clear();
        this.writeLog.info("Enter T Lost Max: " + tLostMax);
        this.tLostMaxField.sendKeys(tLostMax);
    }

    public void setTLostMin(String tLostMin) {
        this.pgPageWait.until(ExpectedConditions.visibilityOf(tLostMinField));
        this.tLostMinField.clear();
        this.writeLog.info("Enter T Lost Min: " + tLostMin);
        this.tLostMinField.sendKeys(tLostMin);
    }

    public void clickCheckboxAuthQBOT(String option) {
        this.pgPageWait.until(ExpectedConditions.visibilityOf(authorizationQuantityBasedOvertimeCheckBox));
        if (option.equals("check")){
            if (authorizationQuantityBasedOvertimeCheckBox.getAttribute("aria-checked").equals("false")){
                this.writeLog.info("Checkbox Authorization Quantity Based Overtime: " + option);
                this.authorizationQuantityBasedOvertimeCheckBox.click();
            }
        }
        else if (option.equals("uncheck")){
            if (authorizationQuantityBasedOvertimeCheckBox.getAttribute("aria-checked").equals("true")){
                this.writeLog.info("Checkbox Authorization Quantity Based Overtime: " + option);
                this.authorizationQuantityBasedOvertimeCheckBox.click();
            }
        }
    }

    public void clickCheckboxAuthZBOT(String option) {
        this.pgPageWait.until(ExpectedConditions.visibilityOf(authorizationZoneBasedOvertimeCheckBox));
        if (option.equals("check")){
            if (authorizationZoneBasedOvertimeCheckBox.getAttribute("aria-checked").equals("false")){
                this.writeLog.info("Checkbox Authorization Zone Based Overtime: " + option);
                this.authorizationZoneBasedOvertimeCheckBox.click();
            }
        }
        else if (option.equals("uncheck")){
            if (authorizationZoneBasedOvertimeCheckBox.getAttribute("aria-checked").equals("true")){
                this.writeLog.info("Checkbox Authorization Zone Based Overtime: " + option);
                this.authorizationZoneBasedOvertimeCheckBox.click();
            }
        }
    }

    public void clickCheckboxAuthHolWork(String option) {
        this.pgPageWait.until(ExpectedConditions.visibilityOf(authorizationHolidayWorkCheckBox));
        if (option.equals("check")){
            if (authorizationHolidayWorkCheckBox.getAttribute("aria-checked").equals("false")){
                this.writeLog.info("Checkbox Authorization Holiday Work: " + option);
                this.authorizationHolidayWorkCheckBox.click();
            }
        }
        else if (option.equals("uncheck")){
            if (authorizationHolidayWorkCheckBox.getAttribute("aria-checked").equals("true")){
                this.writeLog.info("Checkbox Authorization Holiday Work: " + option);
                this.authorizationHolidayWorkCheckBox.click();
            }
        }
    }

    public void clickCheckboxAcceptOvertimeMCFromTerminal(String option) {
        this.pgPageWait.until(ExpectedConditions.visibilityOf(acceptOvertimeMCFromTerminalCheckBox));
        if (option.equals("check")){
            if (acceptOvertimeMCFromTerminalCheckBox.getAttribute("aria-checked").equals("false")){
                this.writeLog.info("Checkbox Accept overtime MC from terminal: " + option);
                this.acceptOvertimeMCFromTerminalCheckBox.click();
            }
        }
        else if (option.equals("uncheck")){
            if (acceptOvertimeMCFromTerminalCheckBox.getAttribute("aria-checked").equals("true")){
                this.writeLog.info("Checkbox Accept overtime MC from terminal: " + option);
                this.acceptOvertimeMCFromTerminalCheckBox.click();
            }
        }
    }

    public void clickCheckboxAcceptAbsenceMCFromTerminal(String option) {
        this.pgPageWait.until(ExpectedConditions.visibilityOf(acceptAbsenceMCFromTerminalCheckBox));
        if (option.equals("check")){
            if (acceptAbsenceMCFromTerminalCheckBox.getAttribute("aria-checked").equals("false")){
                this.writeLog.info("Accept absence MC from terminal: " + option);
                this.acceptAbsenceMCFromTerminalCheckBox.click();
            }
        }
        else if (option.equals("uncheck")){
            if (acceptAbsenceMCFromTerminalCheckBox.getAttribute("aria-checked").equals("true")){
                this.writeLog.info("Accept absence MC from terminal: " + option);
                this.acceptAbsenceMCFromTerminalCheckBox.click();
            }
        }
    }

    public void clickSearchedElementInDPTable(String searchedItem) {

        //Search the element you need in the given column (by column_index) and then click on it in order to select it.

        SearchInTable searchInTable = new SearchInTable(this.pgPageDriver, this.pgPageWait, this.writeLog);
        this.pgPageWait.until(ExpectedConditions.visibilityOfAllElements(pgTable));

        int row = searchInTable.searchItem(pgTable, 1, searchedItem);
        if (row == -1){
            this.writeLog.info("Element " + searchedItem + " not found");
            return;
        }

        WebElement tableElement = pgTable.findElements(By.tagName("tr")).get(row).findElements(By.tagName("td")).get(1);
        this.writeLog.info("Find the " + searchedItem + " and click on it");
        tableElement.click();

//        Actions actions = new Actions(this.dpPageDriver);
//        actions.moveToElement(tableElement).doubleClick().perform();

    }

    public Boolean checkIfItemIsPresentInTable(String searchedItem){

        //Search the element you need in the given column (by column_index) and return false if item is not found and true if the item is found.

        boolean isPresent = true;

        SearchInTable searchInTable = new SearchInTable(this.pgPageDriver, this.pgPageWait, this.writeLog);
        this.pgPageWait.until(ExpectedConditions.visibilityOfAllElements(pgTable));

        int row = searchInTable.searchItem(pgTable, 1, searchedItem);
        //If the item searched is not found, it will return false
        if (row == -1){
            this.writeLog.info("Item \"" + searchedItem + "\" NOT found in column Name ");
            isPresent = false;
            return isPresent;
        }
        else
            this.writeLog.info("Item \"" + searchedItem + "\" found in searched column Name ");

        return isPresent;
    }

}
