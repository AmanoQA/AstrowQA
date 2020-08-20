package pageObjects.Controls.DailyView;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnomaliesDailyView {

    private final WebDriver anomDVDriver;
    private final WebDriverWait anomDVWait;
    private final ExtentTest writeLog;

    @FindBy(xpath = "(//*[contains(@id, 'anomalies')]//*[contains(@id, 'gridview')]/table/tbody)[1]")
    private WebElement anomaliesViewTable;


    // constructor
    public AnomaliesDailyView(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d, this);
        this.anomDVDriver = d;
        this.anomDVWait = w;
        this.writeLog = l;
    }

    static int row = 0;
    static ArrayList<String> anomaliesDetails;

    public ArrayList<String> getAnomaliesDetails() {
        //It will return the row number where the item searched was found.

        this.anomDVWait.until(ExpectedConditions.visibilityOf(anomaliesViewTable));

        List<WebElement> rows_table = anomaliesViewTable.findElements(By.tagName("tr"));
        //Calculate no of rows in table.
        int rows_count = rows_table.size();
        anomaliesDetails = new ArrayList<String>();

        for (row = 1; row < rows_count; row++) {

            //Locate cells of a specific row
            List<WebElement> columns_row = rows_table.get(row).findElements(By.tagName("td"));
            anomaliesDetails.add(columns_row.get(3).getText());
        }

        return anomaliesDetails;
    }
}
