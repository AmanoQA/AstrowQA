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
import utils.GenericDriver;

public class DailyViewPage {

    private final WebDriver dvPageDriver;
    private final WebDriverWait dvPageWait;
    private final ExtentTest writeLog;

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

    @FindBy(xpath = "//*[contains(@id, 'bookingview')]//*[contains(@id, 'gridview')]/table/tbody")
    private WebElement bookingViewTable;


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

    public boolean checkIfBookingIsPresent(String searchedBooking){
        boolean isPresent = true;

        this.dvPageWait.until(ExpectedConditions.visibilityOf(bookingViewTable));
        SearchInTable searchInTable = new SearchInTable(this.dvPageDriver, this.dvPageWait, writeLog);

        int row = searchInTable.searchItem(bookingViewTable, 6, searchedBooking);
        if (row == -1){
            this.writeLog.error("Item \"" + searchedBooking + "\" NOT found in column ");
            isPresent = false;
            return isPresent;
        }
        else
            this.writeLog.info("Item \"" + searchedBooking + "\" found in searched column ");

        return isPresent;

    }

    public void clickSearchedBooking(String searchedBooking){

        this.dvPageWait.until(ExpectedConditions.visibilityOf(bookingViewTable));
        SearchInTable searchInTable = new SearchInTable(this.dvPageDriver, this.dvPageWait, writeLog);

        int row = searchInTable.searchItem(bookingViewTable, 6, searchedBooking);
        if (row == -1){
            this.writeLog.error("Item \"" + searchedBooking + "\" NOT found in column ");
        }
        else
            this.writeLog.info("Item \"" + searchedBooking + "\" found in searched column ");

        WebElement tableElement = bookingViewTable.findElements(By.tagName("tr")).get(row).findElements(By.tagName("td")).get(6);
        this.writeLog.info("Find the " + searchedBooking + " and click on it");
        tableElement.click();

    }

    public boolean checkIfAbsenceIsPresent(String searchedAbsence){
        boolean isPresent = true;

        this.dvPageWait.until(ExpectedConditions.visibilityOf(absenceViewTable));
        SearchInTable searchInTable = new SearchInTable(this.dvPageDriver, this.dvPageWait, writeLog);

        int row = searchInTable.searchItem(absenceViewTable, 1, searchedAbsence);
        if (row == -1){
            this.writeLog.error("Item \"" + searchedAbsence + "\" NOT found in column ");
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
