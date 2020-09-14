package pageObjects.WebPages.Operations;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Controls.DailyView.AbsenceDailyView;
import pageObjects.Controls.DailyView.AnomaliesDailyView;
import pageObjects.Controls.DailyView.BookingDailyView;
import pageObjects.Controls.DailyView.CountersDailyView;
import pageObjects.Controls.SearchInTable;

import java.util.ArrayList;
import java.util.Map;

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



    @FindBy(xpath = "//*[contains(text(), 'Add project booking')]")
    private WebElement newProjectBookingBtn;

    @FindBy(xpath = "(//*[contains(@class, 'x-btn-split x-btn-split-right')])[2]")
    private WebElement openProjectBookingBtn;

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

    @FindBy(xpath = "(//*[contains(@id, 'counterview')]//*[contains(@id, 'gridview')]/table/tbody/tr[3]/td/table/tbody)[1]")
    private WebElement counterViewTable;

    @FindBy(xpath = "(//*[contains(@id, 'anomalies')]//*[contains(@id, 'gridview')]/table/tbody)[1]")
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

    @FindBy(xpath = "//*[contains(text(),'Calculate')]")
    private WebElement calculate;

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

    public void waitCalculations() {

        try {
            this.dvPageWait.until(ExpectedConditions.visibilityOf(calculate));
        } catch (Exception ignored) {
        }


        try {
            while (calculate.isDisplayed()) {

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

    public void clickNewProjectBooking() {
        this.dvPageWait.until(ExpectedConditions.visibilityOf(newBookingBtn));

        Actions btnBuilder = new Actions(dvPageDriver);
        btnBuilder.moveToElement(newBookingBtn, 30 ,0 );
        btnBuilder.click().perform();

        this.writeLog.info("Click \"New Project Booking\" ");
        this.newProjectBookingBtn.click();
    }

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

    public boolean checkIfBookingIsPresent(String searchedBooking) {
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

    public boolean checkIfBookingCompanySiteArePresent(String searchedBooking, String searchedCompanySite) {
        boolean isPresent = true;

        if(noRowsBookingTable.getAttribute("class").equals("noRowsToDisplay")){
            isPresent = false;
            this.writeLog.info("Booking \"" + searchedBooking + "\" NOT found");
            return isPresent;
        }

        this.dvPageWait.until(ExpectedConditions.visibilityOf(bookingViewTable));
        BookingDailyView bookingDailyView = new BookingDailyView(this.dvPageDriver, this.dvPageWait, writeLog);
        Map<String, String> bookingDetails = bookingDailyView.getBookingDetails(searchedBooking);

        if (bookingDetails.isEmpty()) {
            this.writeLog.info("Booking \"" + searchedBooking + "\" NOT found ");
            isPresent = false;
            return isPresent;
        }
        else if (!bookingDetails.get("CS").equals(searchedCompanySite)) {
            this.writeLog.info("Booking with Company Site: \"" + searchedCompanySite + "\" NOT found ");
            isPresent = false;
            return isPresent;
        }
        else{
            this.writeLog.info("Booking: \"" + searchedBooking + "\"" +" and " + "\"" + searchedCompanySite + "\" found in table ");
        }

        return isPresent;

    }

    public boolean checkIfBookingMCArePresent(String searchedBooking, String searchedMC) {
        boolean isPresent = true;

        if(noRowsBookingTable.getAttribute("class").equals("noRowsToDisplay")){
            isPresent = false;
            this.writeLog.info("Booking \"" + searchedBooking + "\" NOT found");
            return isPresent;
        }

        this.dvPageWait.until(ExpectedConditions.visibilityOf(bookingViewTable));
        BookingDailyView bookingDailyView = new BookingDailyView(this.dvPageDriver, this.dvPageWait, writeLog);
        Map<String, String> bookingDetails = bookingDailyView.getBookingDetails(searchedBooking);

        if (bookingDetails.isEmpty()) {
            this.writeLog.info("Booking \"" + searchedBooking + "\" NOT found ");
            isPresent = false;
            return isPresent;
        }
        else if (!bookingDetails.get("MC").equals(searchedMC)) {
            this.writeLog.info("Booking with MC Code: \"" + searchedMC + "\" NOT found ");
            isPresent = false;
            return isPresent;
        }
        else{
            this.writeLog.info("Booking: \"" + searchedBooking + "\"" +" and " + "\"" + searchedMC + "\" found in table ");
        }

        return isPresent;

    }

    public boolean checkIfBookingCCArePresent(String searchedBooking, String searchedCC) throws InterruptedException {
        waitCalculations();
        clickRefreshToolbar();
        Thread.sleep(2000);
        boolean isPresent = true;

        if(noRowsBookingTable.getAttribute("class").equals("noRowsToDisplay")){
            isPresent = false;
            this.writeLog.info("Booking \"" + searchedBooking + "\" NOT found");
            return isPresent;
        }

        this.dvPageWait.until(ExpectedConditions.visibilityOf(bookingViewTable));
        BookingDailyView bookingDailyView = new BookingDailyView(this.dvPageDriver, this.dvPageWait, writeLog);
        Map<String, String> bookingDetails = bookingDailyView.getBookingDetails(searchedBooking);

        if (bookingDetails.isEmpty()) {
            this.writeLog.info("Booking \"" + searchedBooking + "\" NOT found ");
            isPresent = false;
            return isPresent;
        }
        else if (!bookingDetails.get("CC").equals(searchedCC)) {
            this.writeLog.info("Booking with Cost Center: \"" + searchedCC + "\" NOT found ");
            isPresent = false;
            return isPresent;
        }
        else{
            this.writeLog.info("Booking: \"" + searchedBooking + "\"" +" and " + "\"" + searchedCC + "\" found in table ");
        }

        return isPresent;

    }

    public void clickSearchedBooking(String searchedBooking) {

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

    public boolean checkIfAbsenceDetailsArePresent(String searchedAbsence, String searchedAuth) {
        boolean isPresent = true;

        if(noRowsAbsenceTable.getAttribute("class").equals("noRowsToDisplay")){
            isPresent = false;
            this.writeLog.info("Absence \"" + searchedAbsence + "\" NOT found");
            return isPresent;
        }

        this.dvPageWait.until(ExpectedConditions.visibilityOf(bookingViewTable));
        AbsenceDailyView absenceDailyView = new AbsenceDailyView(this.dvPageDriver, this.dvPageWait, writeLog);
        Map<String, String> bookingDetails = absenceDailyView.getAbsenceDetails(searchedAbsence);

        if (bookingDetails.isEmpty()) {
            this.writeLog.info("Absence \"" + searchedAbsence + "\" NOT found ");
            isPresent = false;
            return isPresent;
        }
        else if (!bookingDetails.get("Auth").equals(searchedAuth)) {
            this.writeLog.info("Absence with Auth. Time: \"" + searchedAuth + "\" NOT found ");
            isPresent = false;
            return isPresent;
        }
        else{
            this.writeLog.info("Absence: \"" + searchedAbsence + "\"" +" and " + "\"" + searchedAuth + "\" found in table ");
        }

        return isPresent;

    }

    public boolean checkIfAbsenceDetailsArePresent(String searchedAbsence, String searchedAuth, String searchedTime)  {
        boolean isPresent = true;

        if(noRowsAbsenceTable.getAttribute("class").equals("noRowsToDisplay")){
            isPresent = false;
            this.writeLog.info("Absence \"" + searchedAbsence + "\" NOT found");
            return isPresent;
        }

        this.dvPageWait.until(ExpectedConditions.visibilityOf(absenceViewTable));
        AbsenceDailyView absenceDailyView = new AbsenceDailyView(this.dvPageDriver, this.dvPageWait, writeLog);
        Map<String, String> bookingDetails = absenceDailyView.getAbsenceDetails(searchedAbsence);

        if (bookingDetails.isEmpty()) {
            this.writeLog.info("Absence \"" + searchedAbsence + "\" NOT found ");
            isPresent = false;
            return isPresent;
        }
        else if (!bookingDetails.get("Auth").equals(searchedAuth)) {
            this.writeLog.info("Absence with Auth. Time: \"" + searchedAuth + "\" NOT found ");
            isPresent = false;
            return isPresent;
        }
        else if (!bookingDetails.get("Time").equals(searchedTime.replaceFirst("^0+(?!$)", ""))) {
            this.writeLog.info("Absence with Time: \"" + searchedTime + "\" NOT found ");
            isPresent = false;
            return isPresent;
        }
        else{
            this.writeLog.info("Absence: \"" + searchedAbsence + "\"" +" and " + "\"" + searchedAuth +" and " + "\"" + searchedTime + "\" found in table ");
        }

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

    public boolean checkCounterValue(String counter, String value){
        boolean isCorrect = false;
        this.dvPageWait.until(ExpectedConditions.visibilityOf(counterViewTable));

        CountersDailyView countersDailyView = new CountersDailyView(this.dvPageDriver, this.dvPageWait, writeLog);
        Map<String, String> countersDetails = countersDailyView.getCountersDetails();

        if (countersDetails.get(counter).equals(value)){
            isCorrect = true;
            this.writeLog.info("Counter " + counter + " = " + value + " - correct");
            return isCorrect;
        }
        else
            this.writeLog.info("Counter " + counter + " = " + value + " - NOT correct");
        return isCorrect;
    }

    public boolean checkIfAnomalyIsPresent(String anomaly){

        boolean isPresent = false;

        this.dvPageWait.until(ExpectedConditions.visibilityOf(anomaliesViewTable));
        AnomaliesDailyView anomaliesDailyView = new AnomaliesDailyView(this.dvPageDriver, this.dvPageWait, writeLog);
        ArrayList<String> anomaliesDetails = anomaliesDailyView.getAnomaliesDetails();

        for (String anomaliesDetail : anomaliesDetails) {
            if (anomaliesDetail.equals(anomaly)) {
                isPresent = true;
                this.writeLog.info("Anomaly " + anomaly + " found");
                break;
            }
            else
                this.writeLog.info("Anomaly " + anomaly + " NOT found");
        }

        return isPresent;
    }

}
