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

public class AbsenceDailyView {
    private final WebDriver absDVDriver;
    private final WebDriverWait absDVWait;
    private final ExtentTest writeLog;

    @FindBy(xpath = "//*[contains(@id, 'absenceview')]//*[contains(@id, 'gridview')]/table/tbody")
    private WebElement absenceViewTable;


    // constructor
    public AbsenceDailyView(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d, this);
        this.absDVDriver = d;
        this.absDVWait = w;
        this.writeLog = l;
    }

    static int row = 0;
    static Map<String, String> absenceDetails;

    public Map<String, String> getAbsenceDetails(String searchedItem) {
        //It will return the row number where the item searched was found.

        this.absDVWait.until(ExpectedConditions.visibilityOf(absenceViewTable));

        List<WebElement> rows_table = absenceViewTable.findElements(By.tagName("tr"));
        //Calculate no of rows in table.
        int rows_count = rows_table.size();
        absenceDetails = new HashMap<>();

        for (row = 1; row < rows_count; row++) {

            //Locate cells of a specific row
            List<WebElement> columns_row = rows_table.get(row).findElements(By.tagName("td"));

            //Retrieve text from that specific cell
            String cellText = columns_row.get(1).getText();

            if (cellText.equals(searchedItem)) {

                absenceDetails.put("Absence", cellText);
                absenceDetails.put("Auth", columns_row.get(3).getText());
                absenceDetails.put("Time", columns_row.get(4).getText());

                this.writeLog.info(searchedItem + " was found in the list");
                break;
            }

        }

        return absenceDetails;
    }

}
