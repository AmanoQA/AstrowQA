package pageObjects.Menu.TeamManager;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContextMenu {

    private final WebDriver contextMenuDriver;
    private final WebDriverWait contextMenuWait;
    private final ExtentTest writeLog;

    @FindBy(xpath = "//*[contains(@class, 'x-menu-item-text') and text() = 'Add booking']")
    private WebElement addBooking;

    @FindBy(xpath = "//*[contains(@class, 'x-menu-item-text') and text() = 'Add absence']")
    private WebElement addAbsence;

    @FindBy(xpath = "//*[contains(@class, 'x-menu-item-text') and text() = 'Absence operations']")
    private WebElement absenceOperations;

    @FindBy(xpath = "//*[contains(@class, 'x-menu-item-text') and text() = 'Absence by period']")
    private WebElement addAbsenceByPeriod;

    @FindBy(xpath = "//*[contains(@class, 'x-menu-item-text') and text() = 'Remove absence']")
    private WebElement removeAbsence;

    @FindBy(xpath = "//*[contains(@class, 'x-menu-item-text') and text() = 'View holiday card']")
    private WebElement viewHolidayCard;

    @FindBy(xpath = "//*[contains(@class, 'x-menu-item-text') and text() = 'Daily view']")
    private WebElement dailyView;


    // constructor
    public ContextMenu(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d,this);
        this.contextMenuDriver = d;
        this.contextMenuWait = w;
        this.writeLog = l;
    }


    public void clickAddBooking(){
        this.contextMenuWait.until(ExpectedConditions.visibilityOf(addBooking));
        this.writeLog.info("Click on Add Booking option");
        this.addBooking.click();
    }

    public void clickAddAbsence(){
        this.contextMenuWait.until(ExpectedConditions.visibilityOf(addAbsence));
        this.writeLog.info("Click on Add Absence option");
        this.addAbsence.click();
    }

    public void clickAddAbsenceByPeriod(){
        this.contextMenuWait.until(ExpectedConditions.visibilityOf(absenceOperations));
        this.writeLog.info("Click on Add Absence by period option");

        Actions actions = new Actions(this.contextMenuDriver);
        actions.moveToElement(absenceOperations).perform();
        this.addAbsenceByPeriod.click();
    }

    public void clickRemoveAbsence(){
        this.contextMenuWait.until(ExpectedConditions.visibilityOf(absenceOperations));
        this.writeLog.info("Click on Add Remove absence option");

        Actions actions = new Actions(this.contextMenuDriver);
        actions.moveToElement(removeAbsence).perform();
        this.removeAbsence.click();
    }

    public void clickViewHolidayCard(){
        this.contextMenuWait.until(ExpectedConditions.visibilityOf(viewHolidayCard));
        this.writeLog.info("Click on View holiday card option");
        this.viewHolidayCard.click();
    }

    public void clickDailyView(){
        this.contextMenuWait.until(ExpectedConditions.visibilityOf(dailyView));
        this.writeLog.info("Click on Daily View option");
        this.dailyView.click();
    }

}
