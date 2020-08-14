package pageObjects.WebPages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
}
