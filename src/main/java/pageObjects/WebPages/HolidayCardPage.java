package pageObjects.WebPages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HolidayCardPage {

    private final WebDriver hcPageDriver;
    private final WebDriverWait hcPageWait;
    private final ExtentTest writeLog;

    @FindBy(xpath = "(//div[contains(@id, 'HolidayCardfromGroupOverview')]//table[contains(@class, 'x-grid-table x-grid-table-resizer')]/tbody)[1]")
    private WebElement holidayTypesTable;

    @FindBy(xpath = "(//div[contains(@id, 'HolidayCardfromGroupOverview')]//table[contains(@class, 'x-grid-table x-grid-table-resizer')]/tbody)[2]")
    private WebElement holidayDataTable;

    @FindBy(xpath = "(//div[contains(@id, 'HolidayCardfromGroupOverview')]//table[contains(@class, 'x-grid-table x-grid-table-resizer')]/tbody)[3]")
    private WebElement holidaysTable;

    @FindBy(xpath = "//*[contains(@class, 'clsHolidayPrevPeriod')]")
    private WebElement holidayPrevPeriod;

    @FindBy(xpath = "//*[contains(@class, 'clsHolidayCurrentPeriod')]")
    private WebElement holidayCurrentPeriod;

    @FindBy(xpath = "//*[contains(@class, 'clsHolidayNextPeriod')]")
    private WebElement holidayNextPeriod;

    @FindBy(xpath = "//*[contains(@class, 'clsNavigateFirstEmployee')]")
    private WebElement navigateFirstEmployee;

    @FindBy(xpath = "//*[contains(@class, 'clsNavigateUpEmployee')]")
    private WebElement navigateUpEmployee;

    @FindBy(xpath = "//*[contains(@class, 'clsNavigateDownEmployee')]")
    private WebElement navigateDownEmployee;

    @FindBy(xpath = "//*[contains(@class, 'clsNavigateLastEmployee')]")
    private WebElement navigateLastEmployee;

    @FindBy(xpath = "//*[text()='Up to date']")
    private WebElement upToDateBtn;


    // constructor
    public HolidayCardPage(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d, this);
        this.hcPageDriver = d;
        this.hcPageWait = w;
        this.writeLog = l;
    }

    public void clickHolidayPrevPeriod() {
        this.hcPageWait.until(ExpectedConditions.visibilityOf(holidayPrevPeriod));
        this.writeLog.info("Click on \"Holiday Previous Period\" option ");
        this.holidayPrevPeriod.click();
    }

    public void clickHolidayCurrentPeriod() {
        this.hcPageWait.until(ExpectedConditions.visibilityOf(holidayCurrentPeriod));
        this.writeLog.info("Click on \"Holiday Current Period\" option ");
        this.holidayCurrentPeriod.click();
    }

    public void clickHolidayNextPeriod() {
        this.hcPageWait.until(ExpectedConditions.visibilityOf(holidayNextPeriod));
        this.writeLog.info("Click on \"Holiday Next Period\" option ");
        this.holidayNextPeriod.click();
    }

    public void clickNavigateFirstEmployee() {
        this.hcPageWait.until(ExpectedConditions.visibilityOf(navigateFirstEmployee));
        this.writeLog.info("Click on \"Navigate First Employee\" option ");
        this.navigateFirstEmployee.click();
    }

    public void clickNavigateLastEmployee() {
        this.hcPageWait.until(ExpectedConditions.visibilityOf(navigateLastEmployee));
        this.writeLog.info("Click on \"Navigate Last Employee\" option ");
        this.navigateLastEmployee.click();
    }

    public void clickNavigateDownEmployee() {
        this.hcPageWait.until(ExpectedConditions.visibilityOf(navigateDownEmployee));
        this.writeLog.info("Click on \"Navigate Down Employee\" option ");
        this.navigateDownEmployee.click();
    }

    public void clickNavigateUpEmployee() {
        this.hcPageWait.until(ExpectedConditions.visibilityOf(navigateUpEmployee));
        this.writeLog.info("Click on \"Navigate Up Employee\" option ");
        this.navigateUpEmployee.click();
    }

}
