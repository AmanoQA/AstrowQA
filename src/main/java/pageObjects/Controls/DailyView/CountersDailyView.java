package pageObjects.Controls.DailyView;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountersDailyView {

    private final WebDriver cntDVDriver;
    private final WebDriverWait cntDVWait;
    private final ExtentTest writeLog;

    @FindBy(xpath = "(//*[contains(@id, 'counterview')]//*[contains(@id, 'gridview')]/table/tbody/tr[3]/td/table/tbody)[1]")
    private WebElement counterViewTable;


    // constructor
    public CountersDailyView(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d, this);
        this.cntDVDriver = d;
        this.cntDVWait = w;
        this.writeLog = l;
    }

    static int row = 0;
    static Map<String, String> countersDetails;

    public Map<String, String> getCountersDetails() {
        //It will return the row number where the item searched was found.

        this.cntDVWait.until(ExpectedConditions.visibilityOf(counterViewTable));

        List<WebElement> rows_table = counterViewTable.findElements(By.tagName("tr"));
        //Calculate no of rows in table.
        int rows_count = rows_table.size();
        countersDetails = new HashMap<>();

        for (row = 1; row < rows_count; row++) {

            //Locate cells of a specific row
            List<WebElement> columns_row = rows_table.get(row).findElements(By.tagName("td"));

            countersDetails.put(columns_row.get(0).getText(), columns_row.get(2).getText());

        }

        return countersDetails;
    }

}
