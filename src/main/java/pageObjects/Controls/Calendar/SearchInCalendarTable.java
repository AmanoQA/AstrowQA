package pageObjects.Controls.Calendar;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchInCalendarTable {

    private final WebDriver searchInCalendarTableDriver;
    private final WebDriverWait searchInCalendarTableWait;
    private final ExtentTest writeLog;

    // constructor
    public SearchInCalendarTable(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d, this);
        this.searchInCalendarTableDriver = d;
        this.searchInCalendarTableWait = w;
        this.writeLog = l;
    }

    static int row = 0;
    static int column = 0;

    public int[] searchItem(WebElement table, String searchedItem) {
        //It will return the row number where the item searched was found.

        this.searchInCalendarTableWait.until(ExpectedConditions.visibilityOf(table));

        List<WebElement> rows_table = table.findElements(By.tagName("tr"));
        //Calculate no of rows in table.
        int rows_count = rows_table.size();
        int found_row_index = -1;
        int found_column_index = -1;


        outloopExit:
        for (int row = 0; row < rows_count; row++) {

            List<WebElement> columns_row = rows_table.get(row).findElements(By.tagName("td"));
            int columns_count = columns_row.size();

            //Loop will execute till the last cell of that specific row
            for (int column = 0; column < columns_count; column++) {

                // Retrieve text from that specific cell
                String cellText = columns_row.get(column).getText();
                String attributText = columns_row.get(column).getAttribute("class");
                boolean isSelected = columns_row.get(column).isSelected();

                if (cellText.equals(searchedItem) && attributText.equals("x-datepicker-active")){
                    found_row_index = row;
                    found_column_index = column;
                    //columns_row.get(column).click();
                    //this.writeLog.info(searchedItem + " was found in the list");
                    break outloopExit;
                }
            }
        }

        return new int[] {found_row_index, found_column_index};
    }

}
