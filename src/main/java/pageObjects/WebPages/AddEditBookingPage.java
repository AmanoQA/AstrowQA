package pageObjects.WebPages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Controls.DropDown;
import pageObjects.Controls.EnterTime;
import utils.ExtentManager;
import utils.GenericDriver;

import java.util.List;

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

    @FindBy(xpath = "//*[contains(@placeholder, 'MC')]/parent::*/div")
    private WebElement mcCodeClick;

    @FindBy(xpath = "//*[contains(@placeholder, 'CC')]/parent::*/div")
    private WebElement ccCodeClick;

    @FindBy(xpath = "//*[contains(@placeholder, 'Company')]/parent::*/div")
    private WebElement companySiteClick;

    @FindBy(xpath = "//div[@class = 'list-ct']/ul")
    private List<WebElement> dropDownList;


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
        Thread.sleep(2000);

    }

    public void addBooking(String time, String day, String companySite) throws InterruptedException {
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

        this.companySiteClick.click();
        Thread.sleep(1000);
        WebElement dropDownListElement = dropDownList.get(0);

        DropDown dropDown = new DropDown(this.bkPageDriver, this.bkPageWait, this.writeLog);
        this.writeLog.info("Select Company Site: " + companySite);
        dropDown.dropDownSelect(dropDownListElement, companySite);

        saveBookingBtn.click();
        Thread.sleep(2000);

    }

    public void addBookingMC(String time, String day, String mcCode) throws InterruptedException {
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

        this.mcCodeClick.click();
        Thread.sleep(1000);
        WebElement dropDownListElement = dropDownList.get(0);

        DropDown dropDown = new DropDown(this.bkPageDriver, this.bkPageWait, this.writeLog);
        this.writeLog.info("Select MC Code Site: " + mcCode);
        dropDown.dropDownSelect(dropDownListElement, mcCode);

        saveBookingBtn.click();
        Thread.sleep(2000);

    }

    public void addBookingCC(String time, String day, String ccCode) throws InterruptedException {
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

        this.ccCodeClick.click();
        Thread.sleep(1000);
        WebElement dropDownListElement = dropDownList.get(0);

        DropDown dropDown = new DropDown(this.bkPageDriver, this.bkPageWait, this.writeLog);
        this.writeLog.info("Select MC Code Site: " + ccCode);
        dropDown.dropDownSelect(dropDownListElement, ccCode);

        saveBookingBtn.click();
        Thread.sleep(2000);

    }

}
