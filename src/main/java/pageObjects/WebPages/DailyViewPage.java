package pageObjects.WebPages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Controls.SearchInTable;
import utils.ExtentManager;
import utils.GenericDriver;

public class DailyViewPage {

    private final WebDriver dvPageDriver;
    private final WebDriverWait dvPageWait;
    private final ExtentTest writeLog;

    //toolbar---------------------------------------------------------

    @FindBy(xpath = "(//*[contains(@id, 'toolbar')]//*[contains(@class,'clsAddNewItem')])[1]")
    private WebElement addNote;

    @FindBy(xpath = "//*[contains(@id, 'toolbar')]//*[contains(@class,'clsAddNote')]")
    private WebElement notesList;

    @FindBy(xpath = "//*[contains(@id, 'toolbar')]//*[contains(@class,'clsDepartmentRegistration')]")
    private WebElement registerDepartment;

    @FindBy(xpath = "//*[contains(@id, 'toolbar')]//*[contains(@class,'clsDataCollection')]")
    private WebElement dataCollection;

    @FindBy(xpath = "(//*[contains(@id, 'toolbar')]//*[contains(@class,'clsRefreshList')])[1]")
    private WebElement refreshToolbar;

    @FindBy(xpath = "(//*[contains(@id, 'toolbar')]//*[contains(@class,'clsRefreshList')])[2]")
    private WebElement refreshCounters;

    @FindBy(xpath = "(//*[contains(@id, 'DayView')]//*[contains(@class, 'clsNavigateBackPeriod')]")
    private WebElement navigateBackPeriod;

    @FindBy(xpath = "(//*[contains(@id, 'DayView')]//*[contains(@class, 'clsNavigateBackDay')]")
    private WebElement navigateBackDay;

    @FindBy(xpath = "(//*[contains(@id, 'DayView')]//*[contains(@class, 'clsNavigateToday')]")
    private WebElement navigateToday;

    @FindBy(xpath = "(//*[contains(@id, 'DayView')]//*[contains(@class, 'clsNavigateForwardDay')]")
    private WebElement navigateForwardDay;

    @FindBy(xpath = "(//*[contains(@id, 'DayView')]//*[contains(@class, 'clsNavigateForwardPeriod')]")
    private WebElement navigateForwardPeriod;

    @FindBy(xpath = "(//*[contains(@id, 'DayView')]//*[contains(@class, 'clsNavigateFirstEmployee')]")
    private WebElement navigateFirstEmployee;

    @FindBy(xpath = "(//*[contains(@id, 'DayView')]//*[contains(@class, 'clsNavigateUpEmployee')]")
    private WebElement navigateUpEmployee;

    @FindBy(xpath = "(//*[contains(@id, 'DayView')]//*[contains(@class, 'clsNavigateDownEmployee')]")
    private WebElement navigateDownEmployee;

    @FindBy(xpath = "(//*[contains(@id, 'DayView')]//*[contains(@class, 'clsNavigateLastEmployee')]")
    private WebElement navigateLastEmployee;

    @FindBy(xpath = "(//*[contains(@id, 'DayView')]//*[contains(@class, 'clsChangeDayProgram')]")
    private WebElement changeDayprogram;

    //Bookings---------------------------------------------------------

    @FindBy(xpath = "//*[contains(@id, 'bookingview')]//*[contains(text(),'New')]")
    private WebElement newBookingBtn;

    @FindBy(xpath = "//*[contains(@id, 'bookingview')]//*[contains(text(),'Delete')]")
    private WebElement deleteBookingBtn;

    @FindBy(xpath = "//*[contains(@id, 'bookingview')]//*[contains(text(),'Edit')]")
    private WebElement editBookingBtn;

    @FindBy(xpath = "//*[contains(@id, 'bookingview')]//*[contains(text(),'Authorize MC')]")
    private WebElement authorizeMCBtn;

    @FindBy(xpath = "//*[contains(@id, 'bookingview')]//*[contains(text(),'Reject MC')]")
    private WebElement rejectMCBtn;

    @FindBy(xpath = "//*[contains(@id, 'bookingview')]//*[contains(@id, 'toolbar')]//*[contains(@class, 'clsBkEditHistory')]")
    private WebElement bookingHistoryBtn;

    @FindBy(xpath = "//*[contains(@id, 'bookingview')]//*[contains(@id, 'toolbar')]//*[contains(@class, 'clsRealBooking')]")
    private WebElement realBookingsBtn;

    @FindBy(xpath = "//*[contains(@id, 'bookingview')]//*[contains(@id, 'toolbar')]//*[contains(@class, 'clsGPS')]")
    private WebElement bookingLocationBtn;

    //Absences---------------------------------------------------------

    @FindBy(xpath = "//*[contains(@id, 'absenceview')]//*[contains(text(),'New')]")
    private WebElement newAbsenceBtn;

    @FindBy(xpath = "//*[contains(@id, 'absenceview')]//*[contains(text(),'Delete')]")
    private WebElement deleteAbsenceBtn;

    @FindBy(xpath = "//*[contains(@id, 'absenceview')]//*[contains(text(),'Edit')]")
    private WebElement editAbsenceBtn;

    //tables---------------------------------------------------------

    @FindBy(xpath = "//*[contains(@id, 'counterview')]//*[contains(@id, 'gridview')]/table/tbody")
    private WebElement conterViewTable;

    @FindBy(xpath = "//*[contains(@id, 'anomalies')]//*[contains(@id, 'gridview')]/table/tbody")
    private WebElement anomaliesViewTable;

    @FindBy(xpath = "//*[contains(@id, 'absenceview')]//*[contains(@id, 'gridview')]/table/tbody")
    private WebElement absenceViewTable;

    @FindBy(xpath = "//*[contains(@id, 'absenceview')]//*[contains(@id, 'gridview')]/child::*")
    private WebElement noRowsAbsenceTable;

    @FindBy(xpath = "//*[contains(@id, 'bookingview')]//*[contains(@id, 'gridview')]/table/tbody")
    private WebElement bookingViewTable;

    @FindBy(xpath = "//*[contains(@id, 'bookingview')]//*[contains(@id, 'gridview')]/child::*")
    private WebElement noRowsBookingTable;

    @FindBy(xpath = "//*[contains(text(),'Please wait')]")
    private WebElement pleaseWait;

    @FindBy(xpath = "//*[contains(text(),'Loading')]")
    private WebElement loading;


    // constructor
    public DailyViewPage(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d, this);
        this.dvPageDriver = d;
        this.dvPageWait = w;
        this.writeLog = l;
    }

    public void waitPageToBeLoaded() {

        try {
            this.dvPageWait.until(ExpectedConditions.visibilityOf(loading));
        } catch (Exception ignored) {
        }

        try {
            this.dvPageWait.until(ExpectedConditions.visibilityOf(pleaseWait));
        } catch (Exception ignored) {
        }

        try {
            while ((pleaseWait.isDisplayed()) | (loading).isDisplayed()) {

                Thread.sleep(1000);
            }
        } catch (Exception ignored) {
        }
    }

    //ToolBar----------------------------------------------------------
    public void clickAddNote() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(addNote));
        this.writeLog.info("Click \"Add Note\" ");
        this.addNote.click();
    }

    public void clickNotes() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(notesList));
        this.writeLog.info("Click \"Notes\" ");
        this.notesList.click();
    }

    public void clickRegisterDepartment() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(registerDepartment));
        this.writeLog.info("Click \"Register Department\" ");
        this.registerDepartment.click();
    }

    public void clickDataCollection() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(dataCollection));
        this.writeLog.info("Click \"Data Collection\" ");
        this.dataCollection.click();
    }

    public void clickRefreshToolbar() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(refreshToolbar));
        this.writeLog.info("Click \"Refresh from Toolbar\" ");
        this.refreshToolbar.click();
    }

    public void clickRefreshCounters() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(refreshCounters));
        this.writeLog.info("Click \"Refresh Counters\" ");
        this.refreshCounters.click();
    }

    public void clickNavigateBackPeriod() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(navigateBackPeriod));
        this.writeLog.info("Click \"Navigate back period\" ");
        this.navigateBackPeriod.click();
    }

    public void clickNavigateBackDay() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(navigateBackDay));
        this.writeLog.info("Click \"Navigate back day\" ");
        this.navigateBackDay.click();
    }

    public void clickNavigateToday() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(navigateToday));
        this.writeLog.info("Click \"Navigate today\" ");
        this.navigateToday.click();
    }

    public void clickNavigateForwardDay() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(navigateForwardDay));
        this.writeLog.info("Click \"Navigate forward day\" ");
        this.navigateForwardDay.click();
    }

    public void clickNavigateForwardPeriod() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(navigateForwardPeriod));
        this.writeLog.info("Click \"Navigate forward period\" ");
        this.navigateForwardPeriod.click();
    }

    public void clickNavigateFirstEmployee() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(navigateFirstEmployee));
        this.writeLog.info("Click \"Navigate first employee\" ");
        this.navigateFirstEmployee.click();
    }

    public void clickNavigateUpEmployee() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(navigateUpEmployee));
        this.writeLog.info("Click \"Navigate up employee\" ");
        this.navigateUpEmployee.click();
    }

    public void clickNavigateDownEmployee() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(navigateDownEmployee));
        this.writeLog.info("Click \"Navigate down employee\" ");
        this.navigateDownEmployee.click();
    }

    public void clickNavigateLastEmployee() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(navigateLastEmployee));
        this.writeLog.info("Click \"Navigate last employee\" ");
        this.navigateLastEmployee.click();
    }

    public void clickChangeDayProgram() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(changeDayprogram));
        this.writeLog.info("Click \"Change Day program\" ");
        this.changeDayprogram.click();
    }


    //Bookings---------------------------------------------------------

    public void clickNewBooking() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(newBookingBtn));
        this.writeLog.info("Click \"New Booking\" ");
        this.newBookingBtn.click();
    }

    public void clickDeleteBooking() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(deleteBookingBtn));
        this.writeLog.info("Click \"Delete Booking\" ");
        this.deleteBookingBtn.click();
    }

    public void clickEditBooking() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(editBookingBtn));
        this.writeLog.info("Click \"Edit Booking\" ");
        this.editBookingBtn.click();
    }

    public void clickAuthorizeMC() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(authorizeMCBtn));
        this.writeLog.info("Click \"Authorize MC\" ");
        this.authorizeMCBtn.click();
    }

    public void clickRejectMC() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(rejectMCBtn));
        this.writeLog.info("Click \"Reject MC\" ");
        this.rejectMCBtn.click();
    }

    public void clickBookingHistory() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(bookingHistoryBtn));
        this.writeLog.info("Click \"Booking History\" ");
        this.bookingHistoryBtn.click();
    }

    public void clickRealBookings() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(realBookingsBtn));
        this.writeLog.info("Click \"Real Bookings\" ");
        this.realBookingsBtn.click();
    }

    public void clickBookingLocation() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(bookingLocationBtn));
        this.writeLog.info("Click \"Booking Location\" ");
        this.bookingLocationBtn.click();
    }

    //Absences---------------------------------------------------------

    public void clickNewAbsence() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(newAbsenceBtn));
        this.writeLog.info("Click \"New Absence\" ");
        this.newAbsenceBtn.click();
    }

    public void clickDeleteAbsence() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(deleteAbsenceBtn));
        this.writeLog.info("Click \"Delete Absence\" ");
        this.deleteAbsenceBtn.click();
    }

    public void clickEditAbsence() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(editAbsenceBtn));
        this.writeLog.info("Click \"Edit Absence\" ");
        this.editAbsenceBtn.click();
    }

    //Methods----------------------------------------------------------------

    public boolean checkIfBookingIsPresent(String searchedBooking) throws InterruptedException {
        boolean isPresent = true;

        if(noRowsBookingTable.getAttribute("class").equals("noRowsToDisplay")){
            isPresent = false;
            this.writeLog.info("Item \"" + searchedBooking + "\" NOT found");
            return isPresent;
        }

        this.dvPageWait.until(ExpectedConditions.visibilityOf(bookingViewTable));
        SearchInTable searchInTable = new SearchInTable(this.dvPageDriver, this.dvPageWait, writeLog);

        int row = searchInTable.searchItem(bookingViewTable, 6, searchedBooking);
        if (row == -1){
            this.writeLog.info("Item \"" + searchedBooking + "\" NOT found in column ");
            isPresent = false;
            return isPresent;
        }
        else
            this.writeLog.info("Item \"" + searchedBooking + "\" found in searched column ");

        return isPresent;

    }

    public boolean checkIfBookingCompanySiteArePresent(String searchedBooking, String searchedCompanySite) throws InterruptedException {
        boolean isPresent = true;

        if(noRowsBookingTable.getAttribute("class").equals("noRowsToDisplay")){
            isPresent = false;
            this.writeLog.info("Item \"" + searchedBooking + "\" NOT found");
            return isPresent;
        }

        this.dvPageWait.until(ExpectedConditions.visibilityOf(bookingViewTable));
        SearchInTable searchInTable = new SearchInTable(this.dvPageDriver, this.dvPageWait, writeLog);

        int rowBooking = searchInTable.searchItem(bookingViewTable, 6, searchedBooking);
        int rowCompanySite = searchInTable.searchItem(bookingViewTable, 12, searchedBooking);

        if (rowBooking == -1) {
            this.writeLog.info("Item \"" + searchedBooking + "\" NOT found in column ");
            isPresent = false;
            return isPresent;
        }
        else if(rowCompanySite == -1){
            this.writeLog.info("Item \"" + searchedCompanySite + "\" NOT found in column ");
            isPresent = false;
            return isPresent;
        }
        else
            this.writeLog.info("Items: \"" + searchedBooking + "\"" +" and " + "\"" + searchedCompanySite + "\" found in searched column ");

        return isPresent;

    }

    public void clickSearchedBooking(String searchedBooking) throws InterruptedException {

        this.dvPageWait.until(ExpectedConditions.visibilityOf(bookingViewTable));
        SearchInTable searchInTable = new SearchInTable(this.dvPageDriver, this.dvPageWait, writeLog);

        int row = searchInTable.searchItem(bookingViewTable, 6, searchedBooking);
        if (row == -1){
            this.writeLog.info("Item \"" + searchedBooking + "\" NOT found in column ");
        }
        else
            this.writeLog.info("Item \"" + searchedBooking + "\" found in searched column ");

        WebElement tableElement = bookingViewTable.findElements(By.tagName("tr")).get(row).findElements(By.tagName("td")).get(6);
        this.writeLog.info("Find the " + searchedBooking + " and click on it");
        tableElement.click();

    }

    public boolean checkIfAbsenceIsPresent(String searchedAbsence){
        boolean isPresent = true;

        if(noRowsAbsenceTable.getAttribute("class").equals("noRowsToDisplay")){
            isPresent = false;
            this.writeLog.info("Item \"" + searchedAbsence + "\" NOT found");
            return isPresent;
        }

        this.dvPageWait.until(ExpectedConditions.visibilityOf(absenceViewTable));
        SearchInTable searchInTable = new SearchInTable(this.dvPageDriver, this.dvPageWait, writeLog);

        int row = searchInTable.searchItem(absenceViewTable, 1, searchedAbsence);
        if (row == -1){
            this.writeLog.info("Item \"" + searchedAbsence + "\" NOT found in column ");
            isPresent = false;
            return isPresent;
        }
        else
            this.writeLog.info("Item \"" + searchedAbsence + "\" found in searched column ");

        return isPresent;

    }

    public void clickSearchedAbsence(String searchedAbsence){

        this.dvPageWait.until(ExpectedConditions.visibilityOf(absenceViewTable));
        SearchInTable searchInTable = new SearchInTable(this.dvPageDriver, this.dvPageWait, writeLog);

        int row = searchInTable.searchItem(absenceViewTable, 1, searchedAbsence);
        if (row == -1){
            this.writeLog.error("Item \"" + searchedAbsence + "\" NOT found in column ");
        }
        else
            this.writeLog.info("Item \"" + searchedAbsence + "\" found in searched column ");

        WebElement tableElement = absenceViewTable.findElements(By.tagName("tr")).get(row).findElements(By.tagName("td")).get(1);
        this.writeLog.info("Find the " + searchedAbsence + " and click on it");
        tableElement.click();

    }

}
