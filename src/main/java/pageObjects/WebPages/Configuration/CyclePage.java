package pageObjects.WebPages.Configuration;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Controls.Calendar.Calendar;
import pageObjects.Controls.DropDownWithoutNone;
import pageObjects.Controls.EnterTime;
import pageObjects.Controls.SearchInTable;

import java.util.List;

public class CyclePage {
    private final WebDriver cyclePageDriver;
    private final WebDriverWait cyclePageWait;
    private final ExtentTest writeLog;

    //--Add/Edit--------------------------------------------------------------

    @FindBy(xpath = "//input[@name = 'name1']")
    private WebElement nameCycleField;

    @FindBy(xpath = "//input[@name = 'nrdays']")
    private WebElement noOfDaysField;

    @FindBy(xpath = "//div[contains(@id, 'numberfield')]/label")
    private WebElement noOfDaysLabel;

    @FindBy(xpath = "//input[@name = 'startdate']/parent::*/div")
    private WebElement startDateField;

    @FindBy(xpath = "//table[@class = 'x-datepicker-inner']/tbody")
    private List<WebElement> calendarTable;

    @FindBy(xpath = "//div[contains(@id, 'cycleedit')]//div[contains(@id, 'gridview')]/table/tbody")
    private WebElement dpTable;

    @FindBy(xpath = "(//div[contains(@id, 'timefieldpick')]/div/input)[1]")
    private WebElement timeField;

    @FindBy(xpath = "(//div[contains(@id, 'combobox')]//div[contains(@class, 'x-form-trigger-wrap')])[6]")
    private WebElement dayProgramClick;

    @FindBy(xpath = "//div[@class = 'list-ct']/ul")
    private List<WebElement> dropDownList;

    //--Cycle List --------------------------------------------------------------

    @FindBy(xpath = "//div[contains(@id, 'gridview')]/table/tbody")
    private WebElement cycleTable;


    // constructor
    public CyclePage(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d, this);
        this.cyclePageDriver = d;
        this.cyclePageWait = w;
        this.writeLog = l;
    }

    public void setCycleName(String cycleName) {
        this.cyclePageWait.until(ExpectedConditions.visibilityOf(nameCycleField));
        this.nameCycleField.clear();
        this.writeLog.info("Enter Cycle Name: " + cycleName);
        this.nameCycleField.sendKeys(cycleName);
    }

    public void setNoOfDays(String noOfDays) {
        this.cyclePageWait.until(ExpectedConditions.visibilityOf(noOfDaysField));
        this.noOfDaysField.clear();
        this.writeLog.info("Enter Number of Days: " + noOfDays);
        this.noOfDaysField.sendKeys(noOfDays);
        this.noOfDaysLabel.click();
    }

    public void selectStartDate(String day, String month, String year) {

        this.cyclePageWait.until(ExpectedConditions.elementToBeClickable(startDateField));
        this.writeLog.info("Click on Start Date Calendar ");
        this.startDateField.click();

        WebElement calendarListElement = calendarTable.get(0);

        Calendar calendar = new Calendar(this.cyclePageDriver, this.cyclePageWait, this.writeLog);
        this.writeLog.info("Select date from calendar: " + day + " ," + month + " ," + year);
        calendar.selectDateFromCalendar(calendarListElement, day, month, year);
    }

    public void setDayPrograms(int firstDay, int lastDay, String dayStart, String dayProgram) throws InterruptedException {
        this.cyclePageWait.until(ExpectedConditions.elementToBeClickable(dpTable));

        for (int i = firstDay; i < lastDay+1; i++){
            Actions actions = new Actions(this.cyclePageDriver);
            actions.keyDown(Keys.CONTROL).build().perform();
            WebElement dayElement = dpTable.findElements(By.tagName("tr")).get(i + 1).findElements(By.tagName("td")).get(0);
            dayElement.click();
            actions.keyUp(Keys.CONTROL).build().perform();
        }

        timeField.click();
        EnterTime enterTime = new EnterTime(this.cyclePageDriver, this.cyclePageWait);
        this.cyclePageWait.until(ExpectedConditions.visibilityOf(timeField));
        this.writeLog.info("Enter Day Start: " + timeField);
        enterTime.enterTime(timeField, dayStart, "no");

        dayProgramClick.click();

        WebElement dropDownListElement = dropDownList.get(0);

        DropDownWithoutNone dropDown = new DropDownWithoutNone(this.cyclePageDriver, this.cyclePageWait, this.writeLog);
        this.writeLog.info("Select Day program: " + dayProgram);
        dropDown.dropDownSelect(dropDownListElement, dayProgram);

    }


    public Boolean checkIfItemIsPresentInTable(String searchedItem){

        //Search the element you need in the given column (by column_index) and return false if item is not found and true if the item is found.

        boolean isPresent = true;

        SearchInTable searchInTable = new SearchInTable(this.cyclePageDriver, this.cyclePageWait, this.writeLog);
        this.cyclePageWait.until(ExpectedConditions.visibilityOfAllElements(cycleTable));

        int row = searchInTable.searchItem(cycleTable, 1, searchedItem);
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
