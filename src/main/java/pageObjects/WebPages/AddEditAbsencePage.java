package pageObjects.WebPages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Controls.Buttons;
import pageObjects.Controls.DropDownWithoutNone;
import pageObjects.Controls.EnterTime;

import java.util.List;

public class AddEditAbsencePage {

    private final WebDriver absPageDriver;
    private final WebDriverWait absPageWait;
    private final ExtentTest writeLog;

    @FindBy(xpath = "(//*[contains(@id, 'absenceedit')]//div[@class='x-form-trigger-wrap']/div[1])[3]")
    private WebElement absenceClick;

    @FindBy(xpath = "(//*[contains(@id, 'absenceedit')]//div[@class='x-form-trigger-wrap']/div[1])[4]")
    private WebElement authTimeClick;

    @FindBy(xpath = "//div[contains(@id, 'timefieldpick')]/div/input")
    private WebElement customTime;

    @FindBy(xpath = "//div[@class = 'list-ct']/ul")
    private List<WebElement> dropDownList;

    @FindBy(xpath = "//div[contains(@id, 'absenceedit')]//*[contains(@class, 'clsAddNewItem')]")
    private WebElement addAuthMore;

    @FindBy(xpath = "//div[contains(@id, 'absenceedit')]//*[contains(@class, 'clsDeleteItem')]")
    private WebElement deleteAuth;


    // constructor
    public AddEditAbsencePage(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d, this);
        this.absPageDriver = d;
        this.absPageWait = w;
        this.writeLog = l;
    }

    public void clickAddMoreAuthTime(){
        this.absPageWait.until(ExpectedConditions.visibilityOf(addAuthMore));
        this.writeLog.info("Click \"Add More Auth Time\" ");
        this.addAuthMore.click();
    }

    public void clickDeleteAuthTime(){
        this.absPageWait.until(ExpectedConditions.visibilityOf(deleteAuth));
        this.writeLog.info("Click \"Delete Auth Time\" ");
        this.deleteAuth.click();
    }

    public void addAbsence(String absence, String authTime, String time) throws InterruptedException {

        Buttons buttons = new Buttons(this.absPageDriver, this.absPageWait, writeLog);

        this.selectAbsence(1, absence);
        this.selectAuthTime(2, authTime, time);
        buttons.clickSave();

    }

    public void addAbsence(String absence, String authTime) throws InterruptedException {

        Buttons buttons = new Buttons(this.absPageDriver, this.absPageWait, writeLog);

        this.selectAbsence(1, absence);
        this.selectAuthTime(2, authTime);
        buttons.clickSave();

    }

    public void deleteAbsence(String absence) throws InterruptedException {

        Buttons buttons = new Buttons(this.absPageDriver, this.absPageWait, writeLog);

        this.selectAbsence(1, absence);
        buttons.clickDelete();

    }


    public void deleteAbsence(String absence, String authTime) throws InterruptedException {

        Buttons buttons = new Buttons(this.absPageDriver, this.absPageWait, writeLog);

        this.selectAbsence(1, absence);
        this.clickAddMoreAuthTime();
        this.selectAuthTime(2, authTime);
        buttons.clickDelete();

    }

    public void deleteAbsence(String absence, String authTime, String time) throws InterruptedException {

        Buttons buttons = new Buttons(this.absPageDriver, this.absPageWait, writeLog);

        this.selectAbsence(1, absence);
        this.clickAddMoreAuthTime();
        this.selectAuthTime(2, authTime, time);
        buttons.clickDelete();

    }

    public void selectAbsence(int index, String absence) throws InterruptedException {

        this.absPageWait.until(ExpectedConditions.visibilityOf(absenceClick));
        this.writeLog.info("Open the Absence dropdown list");
        absenceClick.click();
        Thread.sleep(2000);
        WebElement dropDownListElement = dropDownList.get(index-1);

        DropDownWithoutNone dropDown = new DropDownWithoutNone(this.absPageDriver, this.absPageWait, this.writeLog);
        this.writeLog.info("Select Absence: " + absence);
        dropDown.dropDownSelect(dropDownListElement, absence);
    }

    public void selectAuthTime(int index, String authTime) throws InterruptedException {

        this.absPageWait.until(ExpectedConditions.visibilityOf(authTimeClick));
        this.writeLog.info("Open the Absence dropdown list");
        authTimeClick.click();
        Thread.sleep(2000);
        WebElement dropDownListElement = dropDownList.get(index-1);

        DropDownWithoutNone dropDown = new DropDownWithoutNone(this.absPageDriver, this.absPageWait, this.writeLog);
        this.writeLog.info("Select Absence: " + authTime);
        dropDown.dropDownSelect(dropDownListElement, authTime);
    }


    public void selectAuthTime(int index, String authTime, String time) throws InterruptedException {

        this.absPageWait.until(ExpectedConditions.visibilityOf(authTimeClick));
        this.writeLog.info("Open the Absence dropdown list");
        authTimeClick.click();
        Thread.sleep(2000);
        WebElement dropDownListElement = dropDownList.get(index-1);

        DropDownWithoutNone dropDown = new DropDownWithoutNone(this.absPageDriver, this.absPageWait, this.writeLog);
        this.writeLog.info("Select Absence: " + authTime);
        dropDown.dropDownSelect(dropDownListElement, authTime);

        this.absPageWait.until(ExpectedConditions.elementToBeClickable(customTime));
        EnterTime enterTime = new EnterTime(this.absPageDriver, this.absPageWait);
        enterTime.enterTime(customTime, time, "no");

        this.writeLog.info("Set CustomTime: " + time);
    }

}
