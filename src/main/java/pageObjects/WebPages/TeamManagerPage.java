package pageObjects.WebPages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Controls.*;
import pageObjects.Controls.Calendar.Calendar;

import java.util.ArrayList;
import java.util.List;

public class TeamManagerPage {

    private final WebDriver tmPageDriver;
    private final WebDriverWait tmPageWait;
    private final ExtentTest writeLog;

    //--Team manager table --------------------------------------------------------------

    @FindBy(xpath = "//div[contains(@id, 'teammanager')]//*[contains(@id, 'monthDataTM')]/table/tbody")
    private WebElement tmTable;

    @FindBy(xpath = "//div[contains(@id, 'teammanager')]//*[contains(@id, 'dataview')]/table/tbody")
    private WebElement tmDataView;

    @FindBy(xpath = "(//div[@class='x-form-trigger-wrap']/div[1])[6]")
    private WebElement absenceClick;

    @FindBy(xpath = "(//div[@class='x-form-trigger-wrap']/div[1])[7]")
    private WebElement authTimeClick;

    @FindBy(xpath = "//div[contains(@id, 'timefieldpick')]/div/input")
    private WebElement customTime;

    @FindBy(xpath = "//div[@class = 'list-ct']/ul")
    private List<WebElement> dropDownList;

    @FindBy(xpath = "(//div[@class = 'x-form-item-body ']/div)[2]")
    private WebElement calendarBtn;

    @FindBy(xpath = "//table[@class = 'x-datepicker-inner']/tbody")
    private List<WebElement> calendarTable;

    @FindBy(xpath = "//*[contains(text(),'Please wait')]")
    private WebElement pleaseWait;

    @FindBy(xpath = "//*[contains(text(),'Loading')]")
    private WebElement loading;

    @FindBy(xpath = "//*[contains(@name,'booktime')]")
    private WebElement bookingTime;

    @FindBy(xpath = "//*[contains(@class,'clsBtnBooking')]")
    private WebElement saveBookingBtn;

    @FindBy(xpath = "//*[contains(@class,'clsPrevoiusBookingDay')]")
    private WebElement previousBookingDay;

    @FindBy(xpath = "//*[contains(@class,'clsTodayBookingDay')]")
    private WebElement todayBookingDay;

    @FindBy(xpath = "//*[contains(@class,'clsNextBookingDay')]")
    private WebElement nextBookingDay;

    // constructor
    public TeamManagerPage(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d, this);
        this.tmPageDriver = d;
        this.tmPageWait = w;
        this.writeLog = l;
    }

        public void selectDateFromTMCalendar(int index, String day, String month, String year) {

        this.tmPageWait.until(ExpectedConditions.elementToBeClickable(calendarBtn));
        this.writeLog.info("Click on Calendar option ");
        this.calendarBtn.click();

        WebElement calendarListElement = calendarTable.get(index-1);

        Calendar calendar = new Calendar(this.tmPageDriver, this.tmPageWait, this.writeLog);
        this.writeLog.info("Select date from calendar: " + day + " ," + month + " ,"+ year );
        calendar.selectDateFromCalendar(calendarListElement, day, month, year);
    }



    public void waitPageToBeLoaded() {

        try {
            this.tmPageWait.until(ExpectedConditions.visibilityOf(loading));
        }
        catch(Exception ignored) {
        }

        try {
            this.tmPageWait.until(ExpectedConditions.visibilityOf(pleaseWait));
        }
        catch(Exception ignored) {
        }

        try {
            while ((tmPageDriver.findElement(By.xpath("//*[contains(text(),'Please wait')]")).isDisplayed()) | (tmPageDriver.findElement(By.xpath("//*[contains(text(),'Loading')]")).isDisplayed())){
                Thread.sleep(2000);
            }
        }
        catch(Exception ignored) {
        }
    }


    public void checkPageIsReady() {

        JavascriptExecutor js = (JavascriptExecutor) this.tmPageDriver;

        //check ready state  - complete and visibilityState - visible
        if ((js.executeScript("return document.visibilityState").toString().equals("visible")) && (js.executeScript("return document.readyState").toString().equals("complete"))) {
            System.out.println("Page Is loaded.");
            //return;
        }
    }
        public void clickCalendar() {

        this.tmPageWait.until(ExpectedConditions.elementToBeClickable(calendarBtn));
        this.writeLog.info("Click on Calendar option ");
        this.calendarBtn.click();
    }

    public void clickSearchedElementInTMTable(String searchedItem, int day) {

        //Search by Employee Name or by Employee Number

        SearchInTeamManagerTable searchInTeamManagerTable = new SearchInTeamManagerTable(this.tmPageDriver, this.tmPageWait, this.writeLog);
        this.tmPageWait.until(ExpectedConditions.visibilityOfAllElements(tmTable));

        int row = searchInTeamManagerTable.searchItem(tmTable, searchedItem);
        if (row == -1) {
            return;
        }

        Actions actions = new Actions(this.tmPageDriver);
        WebElement tableElement = tmDataView.findElements(By.tagName("tr")).get(row).findElements(By.tagName("td")).get(day-1);

        this.writeLog.info("Find " + searchedItem + " and click");
        actions.contextClick(tableElement).perform();
        //actions.doubleClick(tableElement).perform()

    }

    public void selectAbsence(int index, String absence) throws InterruptedException {

        this.tmPageWait.until(ExpectedConditions.visibilityOf(absenceClick));
        this.writeLog.info("Open the Absence dropdown list");
        absenceClick.click();
        Thread.sleep(2000);
        WebElement dropDownListElement = dropDownList.get(index-1);

        DropDownWithoutNone dropDown = new DropDownWithoutNone(this.tmPageDriver, this.tmPageWait, this.writeLog);
        this.writeLog.info("Select Absence: " + absence);
        dropDown.dropDownSelect(dropDownListElement, absence);
    }

    public void selectAuthTime(int index, String authTime) throws InterruptedException {

        this.tmPageWait.until(ExpectedConditions.visibilityOf(authTimeClick));
        this.writeLog.info("Open the Absence dropdown list");
        authTimeClick.click();
        Thread.sleep(2000);
        WebElement dropDownListElement = dropDownList.get(index-1);

        DropDownWithoutNone dropDown = new DropDownWithoutNone(this.tmPageDriver, this.tmPageWait, this.writeLog);
        this.writeLog.info("Select Absence: " + authTime);
        dropDown.dropDownSelect(dropDownListElement, authTime);
    }


    public void selectAuthTime(int index, String authTime, String time) throws InterruptedException {

        this.tmPageWait.until(ExpectedConditions.visibilityOf(authTimeClick));
        this.writeLog.info("Open the Absence dropdown list");
        authTimeClick.click();
        Thread.sleep(2000);
        WebElement dropDownListElement = dropDownList.get(index-1);

        DropDownWithoutNone dropDown = new DropDownWithoutNone(this.tmPageDriver, this.tmPageWait, this.writeLog);
        this.writeLog.info("Select Absence: " + authTime);
        dropDown.dropDownSelect(dropDownListElement, authTime);

        this.tmPageWait.until(ExpectedConditions.elementToBeClickable(customTime));
        EnterTime enterTime = new EnterTime(this.tmPageDriver, this.tmPageWait);
        enterTime.enterTime(customTime, time, "no");

        this.writeLog.info("Set CustomTime: " + time);
    }

    public void addBooking(String time, String day){
        this.tmPageWait.until(ExpectedConditions.elementToBeClickable(bookingTime));
        EnterTime enterTime = new EnterTime(this.tmPageDriver, this.tmPageWait);
        enterTime.enterTime(bookingTime, time, "no");

        switch (day){
            case "P":
                previousBookingDay.click();
                break;

            case "C":
                todayBookingDay.click();
                break;

            case "N":
                nextBookingDay.click();
                break;

            default:
                todayBookingDay.click();
        }

        saveBookingBtn.click();
    }


    public Boolean checkIfItemIsPresentInSelectedDay(String searchedEmployee, int day, String searchedItem){

        boolean isPresent = false;

        SearchInTeamManagerTable searchInTeamManagerTable = new SearchInTeamManagerTable(this.tmPageDriver, this.tmPageWait, this.writeLog);

        this.tmPageWait.until(ExpectedConditions.visibilityOfAllElements(tmTable));

        int row = searchInTeamManagerTable.searchItem(tmTable, searchedEmployee);
//        if (row == -1) {
//            return;
//        }

        WebElement tableElement = tmDataView.findElements(By.tagName("tr")).get(row).findElements(By.tagName("td")).get(day-1);
        String[] element = tableElement.getText().split("\\n");

        outloop:
        for (int i = 0; i < element.length; i++){

            if(i == 1){
                List<String> bookings = new ArrayList<>();
                int j = 0;
                while (j < element[1].length()) {
                    bookings.add(element[1].substring(j, Math.min(j+5,element[1].length())));
                    j=j+5;
                }
                for (String booking : bookings) {
                    if (booking.trim().equals(searchedItem)) {
                        isPresent = true;
                        break outloop;
                    }
                }

            }
            else if (element[i].trim().equals(searchedItem)){
                isPresent = true;
                break;
            }
        }
        return isPresent;
    }

}
