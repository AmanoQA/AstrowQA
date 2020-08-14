package pageObjects.ToolBars;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopSideBar {

    private final WebDriver toolBarDriver;
    private final WebDriverWait toolBarWait;
    private final ExtentTest writeLog;

    @FindBy(xpath = "//span[@class = 'x-btn-inner clsAddNewItem'][contains(text(), 'New')]")
    private WebElement newBtn;

    @FindBy(xpath = "//span[@class = 'x-btn-inner clsEditItem'][contains(text(), 'Edit')]")
    private WebElement editBtn;

    @FindBy(xpath = "//span[@class = 'x-btn-inner clsDeleteItem'][contains(text(), 'Delete')]")
    private WebElement deleteBtn;

    @FindBy(xpath = "//span[contains(@class, 'clsUndelete') and text()='Undelete']")
    private WebElement undeleteBtn;

    @FindBy(xpath = "//span[@class='x-btn-inner'][contains(text(), 'Yes')]")
    private WebElement deleteYes;

    @FindBy(xpath = "//span[@class='x-btn-inner'][contains(text(), 'No')] ")
    private WebElement deleteNo;

    @FindBy(xpath = "//span[@class = 'x-btn-inner clsRefreshList'][contains(text(), 'Refresh')]")
    private WebElement refreshBtn;



    // constructor
    public TopSideBar(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d,this);
        this.toolBarDriver = d;
        this.toolBarWait = w;
        this.writeLog = l;
    }

    public void clickNew() throws InterruptedException {

        this.toolBarWait.until(ExpectedConditions.visibilityOf(newBtn));
        this.writeLog.info("Click on New button to add a new item");
        this.newBtn.click();
        Thread.sleep(2000);

    }

    public void clickEdit() throws InterruptedException {

        this.toolBarWait.until(ExpectedConditions.visibilityOf(editBtn));
        this.writeLog.info("Click on Edit button to edit an item");
        this.editBtn.click();
        Thread.sleep(2000);
    }

    public void clickDelete() throws InterruptedException {

        this.toolBarWait.until(ExpectedConditions.visibilityOf(deleteBtn));
        this.writeLog.info("Click on Delete button to remove an item");
        this.deleteBtn.click();
        Thread.sleep(2000);
    }

    public void clickDeleteYes() throws InterruptedException {

        this.toolBarWait.until(ExpectedConditions.visibilityOf(deleteYes));
        this.deleteYes.click();
        this.writeLog.info("Click on Yes button to confirm the deletion");
        Thread.sleep(2000);
    }

    public void clickUndelete() throws InterruptedException {

        this.toolBarWait.until(ExpectedConditions.visibilityOf(undeleteBtn));
        this.undeleteBtn.click();
        this.writeLog.info("Click on Undelete button");
        Thread.sleep(2000);
    }

    public void clickDeleteNo() throws InterruptedException {

        this.toolBarWait.until(ExpectedConditions.visibilityOf(deleteNo));
        this.writeLog.info("Click on No button to cancel the deletion");
        this.deleteNo.click();
        Thread.sleep(2000);
    }

    public void clickRefresh() throws InterruptedException {

        this.toolBarWait.until(ExpectedConditions.visibilityOf(refreshBtn));
        this.writeLog.info("Click on Refresh button to refresh the page");
        this.refreshBtn.click();
        Thread.sleep(2000);
    }

}
