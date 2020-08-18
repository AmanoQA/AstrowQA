package pageObjects.WebPages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Controls.EnterTime;
import utils.ExtentManager;
import utils.GenericDriver;

public class AddEditBookingPage {

    private final WebDriver bkPageDriver;
    private final WebDriverWait bkPageWait;
    private final ExtentTest writeLog;

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
    public AddEditBookingPage(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d, this);
        this.bkPageDriver = d;
        this.bkPageWait = w;
        this.writeLog = l;
    }

    public void addBooking(String time, String day) throws InterruptedException {
        this.bkPageWait.until(ExpectedConditions.elementToBeClickable(bookingTime));
        EnterTime enterTime = new EnterTime(this.bkPageDriver, this.bkPageWait);
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
        Thread.sleep(3000);

    }

}
