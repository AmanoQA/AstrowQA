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

public class BookingDailyView {

    private final WebDriver bkDVDriver;
    private final WebDriverWait bkDVWait;
    private final ExtentTest writeLog;

    @FindBy(xpath = "//*[contains(@id, 'bookingview')]//*[contains(@id, 'gridview')]/table/tbody")
    private WebElement bookingViewTable;


    // constructor
    public BookingDailyView(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d, this);
        this.bkDVDriver = d;
        this.bkDVWait = w;
        this.writeLog = l;
    }

    static int row = 0;
    static Map<String, String> bookingDetails;

    public Map<String, String> getBookingDetails(String searchedItem) {
        //It will return the row number where the item searched was found.

        this.bkDVWait.until(ExpectedConditions.visibilityOf(bookingViewTable));

        List<WebElement> rows_table = bookingViewTable.findElements(By.tagName("tr"));
        //Calculate no of rows in table.
        int rows_count = rows_table.size();
        bookingDetails = new HashMap<>();

            for (row = 1; row < rows_count; row++) {

                //Locate cells of a specific row
                List<WebElement> columns_row = rows_table.get(row).findElements(By.tagName("td"));

                //Retrieve text from that specific cell
                String cellText = columns_row.get(6).getText();

                if (cellText.equals(searchedItem)) {

                    bookingDetails.put("BK", cellText);
                    bookingDetails.put("Type", columns_row.get(9).getText());
                    bookingDetails.put("MC", columns_row.get(10).getText());
                    bookingDetails.put("CC", columns_row.get(11).getText() );
                    bookingDetails.put("CS", columns_row.get(12).getText());
                    bookingDetails.put("Prj", columns_row.get(13).getText());
                    this.writeLog.info(searchedItem + " was found in the list");
                    break;
                }

            }

        return bookingDetails;
    }

}
