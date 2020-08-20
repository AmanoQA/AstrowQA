package pageObjects.WebPages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Controls.EnterTime;
import pageObjects.Controls.SearchInTable;

public class AddEditProjectBooking {

    private final WebDriver pbkPageDriver;
    private final WebDriverWait pbkPageWait;
    private final ExtentTest writeLog;

    @FindBy(xpath = "//*[@name = 'booktime']")
    private WebElement prjBookingTime;

    @FindBy(xpath = "//*[@name = 'quantity']")
    private WebElement prjQuantity;

    @FindBy(xpath = "//*[contains(@id, 'treeview')]/table/tbody")
    private WebElement treeView;


    // constructor
    public AddEditProjectBooking(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d, this);
        this.pbkPageDriver = d;
        this.pbkPageWait = w;
        this.writeLog = l;
    }

    public void addProjectBooking(String time, String quantity, String project, String component, String activity) throws InterruptedException {
        this.pbkPageWait.until(ExpectedConditions.elementToBeClickable(prjBookingTime));
        EnterTime enterTime = new EnterTime(this.pbkPageDriver, this.pbkPageWait);
        enterTime.enterTime(prjBookingTime, time, "yes");

        prjQuantity.sendKeys(quantity);
        //clickProjectComponentActivity(project, component, activity);
    }


    //NOT WORKING YET
//    public void clickProjectComponentActivity(String project, String component, String activity){
//
//        this.pbkPageWait.until(ExpectedConditions.visibilityOf(treeView));
//
//        //Search by Projects
//        SearchInTable searchInTable = new SearchInTable(this.pbkPageDriver, this.pbkPageWait, writeLog);
//
//        int row = searchInTable.searchItem(treeView, 0, "Projects");
//        if (row == -1){
//            this.writeLog.info("Projects \"" + project + "\" NOT found in column ");
//        }
//        else
//            this.writeLog.info("Projects \"" + project + "\" found in searched column ");
//
//        WebElement tableElement = treeView.findElements(By.tagName("tr")).get(row).findElements(By.tagName("td")).get(0).findElements(By.tagName("div")).get(0).findElements(By.tagName("img")).get(0);
//        this.writeLog.info("Find the " + project + " and click on it");
//        tableElement.click();
//
//        //Search by Project Name
//        int rowProject = searchInTable.searchItem(treeView, 0, project);
//        if (rowProject == -1){
//            this.writeLog.info("Project \"" + project + "\" NOT found in column ");
//        }
//        else
//            this.writeLog.info("Project \"" + project + "\" found in searched column ");
//
//        WebElement tableElementProject = treeView.findElements(By.tagName("tr")).get(row).findElements(By.tagName("td")).get(0).findElements(By.tagName("div")).get(0).findElements(By.tagName("img")).get(0);
//        this.writeLog.info("Find the " + project + " and click on it");
//        tableElementProject.click();
//
//    }

}
