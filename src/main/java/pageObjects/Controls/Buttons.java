package pageObjects.Controls;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Buttons {

    private final WebDriver buttonsDriver;
    private final WebDriverWait buttonsWait;
    private final ExtentTest writeLog;

    //--Save/Cancel--------------------------------------------------------------
    @FindBy(xpath = "//span[text() = 'Save']")
    private WebElement saveBtn;

    @FindBy(xpath = "//span[text() = 'Cancel']")
    private WebElement cancelBtn;

    @FindBy(xpath = "//span[text() = 'Apply']")
    private WebElement applyBtn;

    @FindBy(xpath = "//span[text() = 'OK']")
    private WebElement OKBtn;

    @FindBy(xpath = "//span[text()='Yes']")
    private WebElement yesBtn;

    @FindBy(xpath = "//span[text()='No']")
    private WebElement noBtn;

    @FindBy(xpath = "//span[text() = 'Delete']")
    private WebElement deleteBtn;

    // constructor
    public Buttons(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d,this);
        this.buttonsDriver = d;
        this.buttonsWait = w;
        this.writeLog = l;
    }

    //--Save/Cancel--------------------------------------------------------------
    public void clickSave() throws InterruptedException {

        this.buttonsWait.until(ExpectedConditions.visibilityOf(saveBtn));
        this.writeLog.info("Click on Save");
        this.saveBtn.click();
        Thread.sleep(3000);
    }

    public void clickCancel() throws InterruptedException {

        this.buttonsWait.until(ExpectedConditions.visibilityOf(cancelBtn));
        this.writeLog.info("Click on Cancel");
        this.cancelBtn.click();
        Thread.sleep(2000);
    }

    public void clickApply() throws InterruptedException {

        this.buttonsWait.until(ExpectedConditions.visibilityOf(applyBtn));
        this.writeLog.info("Click on Apply");
        this.applyBtn.click();
        Thread.sleep(2000);
    }

    public void clickOK() throws InterruptedException {

        this.buttonsWait.until(ExpectedConditions.visibilityOf(OKBtn));
        this.writeLog.info("Click on OK");
        this.OKBtn.click();
        Thread.sleep(2000);
    }

    public void clickYes() throws InterruptedException {

        this.buttonsWait.until(ExpectedConditions.visibilityOf(yesBtn));
        this.writeLog.info("Click on Yes");
        this.yesBtn.click();
        Thread.sleep(2000);
    }

    public void clickNo() throws InterruptedException {

        this.buttonsWait.until(ExpectedConditions.visibilityOf(noBtn));
        this.writeLog.info("Click on No");
        this.noBtn.click();
        Thread.sleep(2000);
    }

    public void clickDelete() throws InterruptedException {

        this.buttonsWait.until(ExpectedConditions.visibilityOf(deleteBtn));
        this.writeLog.info("Click on Delete");
        this.deleteBtn.click();
        Thread.sleep(2000);
    }
}
