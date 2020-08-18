package pageObjects.WebPages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Controls.DropDown;
import pageObjects.Controls.EnterTime;
import pageObjects.Controls.SearchInTable;

import java.util.List;

public class DayProgramPage {

    private final WebDriver dpPageDriver;
    private final WebDriverWait dpPageWait;
    private final ExtentTest writeLog;

    //--Core--------------------------------------------------------------

    @FindBy(xpath = "//span[text() = 'Core']")
    private WebElement coreTab;

    @FindBy(xpath = "//input[@name = 'code']")
    private WebElement codeField;

    @FindBy(xpath = "//input[@name = 'payrollcode']")
    private WebElement payrollCodeField;

    @FindBy(xpath = "//input[@name = 'color']")
    private WebElement colorField;

    @FindBy(xpath = "//input[@name = 'name1']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@name = 'normtime']")
    private WebElement normtimeField;

    @FindBy(xpath = "//input[@name = 'corefrom']")
    private WebElement coreFromField;

    @FindBy(xpath = "//input[@name = 'coreto']")
    private WebElement coreToField;

    @FindBy(xpath = "//input[@name = 'ststart']")
    private WebElement stFromField;

    @FindBy(xpath = "//input[@name = 'stend']")
    private WebElement stToField;

    @FindBy(xpath = "//input[@name = 'dayend']")
    private WebElement dayEndingField;

    @FindBy(xpath = "//div[@class = 'list-ct']/ul")
    private List<WebElement> dropDownList;

    @FindBy(xpath = "//div[@class='x-form-trigger-wrap']/div[1]")
    private WebElement overtimeClick;

    @FindBy(xpath = "//input[@name = 'daymax']")
    private WebElement balanceLimitField;

    @FindBy(xpath = "//input[@name = 'daymin']")
    private WebElement dayMinField;

    //--Break/Round--------------------------------------------------------------

    @FindBy(xpath = "//span[text() = 'Break/Round']")
    private WebElement breakRoundTab;

    @FindBy(xpath = "(//div[@class='x-form-trigger-wrap']/div[1])[2]")
    private WebElement break1Click;

    @FindBy(xpath = "//input[@name = 'break0from']")
    private WebElement break1FromField;

    @FindBy(xpath = "//input[@name = 'break0to']")
    private WebElement break1ToField;

    @FindBy(xpath = "(//div[@class='x-form-trigger-wrap']/div[1])[7]")
    private WebElement roundingClick;

    @FindBy(xpath = "//input[@name = 'revis0from']")
    private WebElement revisionDown1FromField;

    @FindBy(xpath = "//input[@name = 'revis0to']")
    private WebElement revisionDown1ToField;

    @FindBy(xpath = "//input[@name = 'revis5from']")
    private WebElement revisionUP1FromField;

    @FindBy(xpath = "//input[@name = 'revis5to']")
    private WebElement revisionUP1ToField;

    //--Auto--------------------------------------------------------------
    @FindBy(xpath = "//span[text() = 'Auto']")
    private WebElement autoTab;

    //--Zones--------------------------------------------------------------
    @FindBy(xpath = "//span[text() = 'Zones']")
    private WebElement zonesTab;

    @FindBy(xpath = "//input[@name = 'ztime0']")
    private WebElement zoneTime1Field;

    @FindBy(xpath = "//input[@name = 'ztime1']")
    private WebElement zoneTime2Field;

    @FindBy(xpath = "(((//*[contains(@class, 'clsGivenHours')])[3]/div/div)[1]/div)[1]/input")
    private WebElement checkbox1;

    //--Day Program List --------------------------------------------------------------

    @FindBy(xpath = "//*[@class ='x-grid-table x-grid-table-resizer']/tbody")
    private WebElement dpTable;


    // constructor
    public DayProgramPage(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d, this);
        this.dpPageDriver = d;
        this.dpPageWait = w;
        this.writeLog = l;
    }
//----------------------------------------------------------------

    public void setCode(String code) {

        this.dpPageWait.until(ExpectedConditions.visibilityOf(codeField));
        //this.codeField.clear();
        this.writeLog.info("Enter DP Code: " + code);
        this.codeField.sendKeys(code);
    }

    public void setPayrollCode(String payrollCode) {

        this.dpPageWait.until(ExpectedConditions.visibilityOf(payrollCodeField));
        this.writeLog.info("Enter Payroll Code: " + payrollCode);
        this.payrollCodeField.clear();
        this.payrollCodeField.sendKeys(payrollCode);
    }

    public void clickColor() {

        this.dpPageWait.until(ExpectedConditions.visibilityOf(codeField));
        this.writeLog.info("Click on Color option ");
        this.codeField.click();
    }

    public void setName(String name) {

        this.dpPageWait.until(ExpectedConditions.visibilityOf(nameField));
        this.writeLog.info("Enter Name: " + name);
        this.nameField.clear();
        this.nameField.sendKeys(name);
    }

    public void setNormtime(String normtime) throws InterruptedException {
        EnterTime enterTime = new EnterTime(this.dpPageDriver, this.dpPageWait);

        this.dpPageWait.until(ExpectedConditions.visibilityOf(normtimeField));

        this.writeLog.info("Set Normtime: " + normtime);
        enterTime.enterTime(normtimeField, normtime, "yes");
    }

    public void setCoreTime(String coreFrom, String coreTo) throws InterruptedException {
        EnterTime enterTime = new EnterTime(this.dpPageDriver, this.dpPageWait);

        this.dpPageWait.until(ExpectedConditions.visibilityOf(coreFromField));
        this.writeLog.info("Set Core Time From: " + coreFrom);
        enterTime.enterTime(coreFromField, coreFrom, "yes");

        this.dpPageWait.until(ExpectedConditions.visibilityOf(coreToField));
        this.writeLog.info("Set Core Time To: " + coreTo);
        enterTime.enterTime(coreToField, coreTo, "yes");
    }

    public void setStandardTime(String standardFrom, String standardTo) throws InterruptedException {
        EnterTime enterTime = new EnterTime(this.dpPageDriver, this.dpPageWait);

        this.dpPageWait.until(ExpectedConditions.visibilityOf(stFromField));
        this.writeLog.info("Set Standard Start: " + standardFrom);
        enterTime.enterTime(stFromField, standardFrom, "yes");

        this.dpPageWait.until(ExpectedConditions.visibilityOf(stToField));
        this.writeLog.info("Set Standard End: " + standardTo);
        enterTime.enterTime(stToField, standardTo, "yes");
    }

    public void setDayEnding(String dayEnding) throws InterruptedException {
        EnterTime enterTime = new EnterTime(this.dpPageDriver, this.dpPageWait);

        this.dpPageWait.until(ExpectedConditions.visibilityOf(dayEndingField));
        this.writeLog.info("Set Day Ending: " + dayEnding);
        enterTime.enterTime(dayEndingField, dayEnding, "yes");
    }

    public void selectOvertime(int index, String overtime) throws InterruptedException {

        this.dpPageWait.until(ExpectedConditions.visibilityOf(overtimeClick));
        this.writeLog.info("Open the Overtime dropdown list");
        overtimeClick.click();
        Thread.sleep(2000);
        WebElement dropDownListElement = dropDownList.get(index-1);

        DropDown dropDown = new DropDown(this.dpPageDriver, this.dpPageWait, this.writeLog);
        this.writeLog.info("Select Overtime Group: " + overtime);
        dropDown.dropDownSelect(dropDownListElement, overtime);
    }

    public void setBalanceLimit(String balanceLimit) throws InterruptedException {
        EnterTime enterTime = new EnterTime(this.dpPageDriver, this.dpPageWait);

        this.dpPageWait.until(ExpectedConditions.visibilityOf(balanceLimitField));
        this.writeLog.info("Set Balance Limit: " + balanceLimit);
        enterTime.enterTime(balanceLimitField, balanceLimit, "yes");
    }

    public void setDayMin(String dayMin) throws InterruptedException {
        EnterTime enterTime = new EnterTime(this.dpPageDriver, this.dpPageWait);

        this.dpPageWait.until(ExpectedConditions.visibilityOf(dayMinField));
        this.writeLog.info("Set Day Minimum: " + dayMin);
        enterTime.enterTime(dayMinField, dayMin, "yes");
    }

//--Break/Round--------------------------------------------------------------

    public void clickBreakRoundTab() {

        this.dpPageWait.until(ExpectedConditions.visibilityOf(breakRoundTab));
        this.writeLog.info("Click on Break\\Round tab");
        this.breakRoundTab.click();
    }

    public void selectBreak1(int index, String break1) throws InterruptedException {

        this.dpPageWait.until(ExpectedConditions.visibilityOf(break1Click));

        this.writeLog.info("Open the Break1 dropdown list");
        break1Click.click();
        Thread.sleep(2000);
        WebElement dropDownListBK = dropDownList.get(index-1);

        DropDown dropDown = new DropDown(this.dpPageDriver, this.dpPageWait, this.writeLog);
        this.writeLog.info("Select Break1: " + break1);
        dropDown.dropDownSelect(dropDownListBK, break1);
    }

    public void setBreak1Time(String break1From, String break1To) throws InterruptedException {
        EnterTime enterTime = new EnterTime(this.dpPageDriver, this.dpPageWait);

        this.dpPageWait.until(ExpectedConditions.visibilityOf(break1FromField));
        this.writeLog.info("Set Break1 Zone From: " + break1From);
        enterTime.enterTime(break1FromField, break1From, "yes");

        this.dpPageWait.until(ExpectedConditions.visibilityOf(break1ToField));
        this.writeLog.info("Set Break1 Zone To: " + break1To);
        enterTime.enterTime(break1ToField, break1To, "ÿes");
    }

    public void selectRounding(int index, String rounding) throws InterruptedException {

        this.dpPageWait.until(ExpectedConditions.visibilityOf(roundingClick));
        this.writeLog.info("Open the Rounding dropdown list");
        roundingClick.click();
        Thread.sleep(2000);

        WebElement dropDownListRound = dropDownList.get(index-1);

        DropDown dropDown = new DropDown(this.dpPageDriver, this.dpPageWait, this.writeLog);
        this.writeLog.info("Select Rouding: " + rounding);
        dropDown.dropDownSelect(dropDownListRound, rounding);
    }

    public void setRevisionDown1Time(String revisionDown1From, String revisionDown1To) throws InterruptedException {
        EnterTime enterTime = new EnterTime(this.dpPageDriver, this.dpPageWait);

        this.dpPageWait.until(ExpectedConditions.visibilityOf(break1FromField));
        this.writeLog.info("Set Revision1 Down: " + revisionDown1From);
        enterTime.enterTime(revisionDown1FromField, revisionDown1From, "yes");

        this.dpPageWait.until(ExpectedConditions.visibilityOf(break1ToField));
        this.writeLog.info("Set Revision1 Down: " + revisionDown1To);
        enterTime.enterTime(revisionDown1ToField, revisionDown1To, "yes");
    }

    public void setRevisionUP1Time(String revisionUP1From, String revisionUP1To) throws InterruptedException {
        EnterTime enterTime = new EnterTime(this.dpPageDriver, this.dpPageWait);

        this.dpPageWait.until(ExpectedConditions.visibilityOf(break1FromField));
        this.writeLog.info("Set Revision1 Up: " + revisionUP1From);
        enterTime.enterTime(revisionUP1FromField, revisionUP1From, "yes");

        this.dpPageWait.until(ExpectedConditions.visibilityOf(break1ToField));
        this.writeLog.info("Set Revision1 Up: " + revisionUP1To);
        enterTime.enterTime(revisionUP1ToField, revisionUP1To, "yes");
    }


    //--Auto--------------------------------------------------------------
    public void clickAutoTab() {

        this.dpPageWait.until(ExpectedConditions.visibilityOf(autoTab));
        this.writeLog.info("Click on Auto DP tab");
        this.autoTab.click();
    }

//--Zones--------------------------------------------------------------

    public void clickZonesTab() {

        this.dpPageWait.until(ExpectedConditions.visibilityOf(zonesTab));
        this.writeLog.info("Click on Zones tab");
        this.zonesTab.click();
    }

    public void setZoneTime1(String zoneTime1) throws InterruptedException {
        EnterTime enterTime = new EnterTime(this.dpPageDriver, this.dpPageWait);

        this.dpPageWait.until(ExpectedConditions.visibilityOf(zoneTime1Field));
        this.writeLog.info("Set Zone1: " + zoneTime1);
        enterTime.enterTime(zoneTime1Field, zoneTime1, "yes");
    }

    public void setZoneTime2(String zoneTime2) throws InterruptedException {
        EnterTime enterTime = new EnterTime(this.dpPageDriver, this.dpPageWait);

        this.dpPageWait.until(ExpectedConditions.visibilityOf(zoneTime2Field));
        this.writeLog.info("Set Zone2: " + zoneTime2);
        enterTime.enterTime(zoneTime2Field, zoneTime2, "yes");
    }

    public void clickCheckbox1(String option) {

        this.dpPageWait.until(ExpectedConditions.visibilityOf(checkbox1));
        if (option.equals("check")){
            if (checkbox1.getAttribute("aria-checked").equals("false")){
                this.writeLog.info("Checkbox 1: " + option);
                this.checkbox1.click();
            }
        }
        else if (option.equals("uncheck")){
            if (checkbox1.getAttribute("aria-checked").equals("true")){
                this.writeLog.info("Checkbox 1: " + option);
                this.checkbox1.click();
            }
        }
    }

    //--Methods--------------------------------------------------------------


    public void clickSearchedElementInDPTable(int column_index, String searchedItem) {

        //Search the element you need in the given column (by column_index) and then click on it in order to select it. If column_index = 0, it will search in entire table

        SearchInTable searchInTable = new SearchInTable(this.dpPageDriver, this.dpPageWait, this.writeLog);
        this.dpPageWait.until(ExpectedConditions.visibilityOfAllElements(dpTable));

        int row = searchInTable.searchItem(dpTable, column_index, searchedItem);
        if (row == -1){
            this.writeLog.error("Element " + searchedItem + " not found");
            return;
        }

        WebElement tableElement = dpTable.findElements(By.tagName("tr")).get(row).findElements(By.tagName("td")).get(column_index);
        this.writeLog.info("Find the " + searchedItem + " and click on it");
        tableElement.click();

//        Actions actions = new Actions(this.dpPageDriver);
//        actions.moveToElement(tableElement).doubleClick().perform();

    }

    public Boolean checkIfItemIsPresentInTable(int column_index, String searchedItem){

        //Search the element you need in the given column (by column_index) and return false if item is not found and true if the item is found. If column_index = 0, it will search in entire table

        boolean isPresent = true;

        SearchInTable searchInTable = new SearchInTable(this.dpPageDriver, this.dpPageWait, this.writeLog);
        this.dpPageWait.until(ExpectedConditions.visibilityOfAllElements(dpTable));

        int row = searchInTable.searchItem(dpTable, column_index, searchedItem);
        //If the item searched is not found, it will return false
        if (row == -1){
            this.writeLog.error("Item \"" + searchedItem + "\" NOT found in column " + column_index);
            isPresent = false;
            return isPresent;
        }
        else
            this.writeLog.info("Item \"" + searchedItem + "\" found in searched column " + column_index);

        return isPresent;
    }


}
