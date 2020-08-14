package pageObjects.ToolBars;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RightSideBar {
    private final WebDriver rightSideBarDriver;
    private final WebDriverWait rightSideBarWait;
    private final ExtentTest writeLog;

    @FindBy(xpath = "//span[contains(@class, 'clsDuplicate')][contains(text(), 'Duplicate')]")
    private WebElement duplicateBtn;

    @FindBy(xpath = "//span[@class = 'x-btn-inner clsPrintSelected'][contains(text(), 'Print selected')]")
    private WebElement printSelectedBtn;

    @FindBy(xpath = "//span[@class = 'x-btn-inner clsPrint'][contains(text(), 'Print all')]")
    private WebElement printAllBtn;

    // constructor
    public RightSideBar(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d,this);
        this.rightSideBarDriver = d;
        this.rightSideBarWait = w;
        this.writeLog = l;
    }

    public void clickDuplicate() throws InterruptedException {

        this.rightSideBarWait.until(ExpectedConditions.visibilityOf(duplicateBtn));
        this.writeLog.info("Click on Duplicate button to duplicate an item");
        this.duplicateBtn.click();
        Thread.sleep(2000);
    }

    public void clickPrintSelected() throws InterruptedException {

        this.rightSideBarWait.until(ExpectedConditions.visibilityOf(printSelectedBtn));
        this.writeLog.info("Click on Print Selected button to print only the selected items");
        this.printSelectedBtn.click();
        Thread.sleep(2000);
    }
    public void clickPrintAll() throws InterruptedException {

        this.rightSideBarWait.until(ExpectedConditions.visibilityOf(printAllBtn));
        this.writeLog.info("Click on Print All button to print all the items from the list");
        this.printAllBtn.click();
        Thread.sleep(2000);
    }


}
