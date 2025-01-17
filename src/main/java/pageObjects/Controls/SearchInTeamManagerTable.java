package pageObjects.Controls;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchInTeamManagerTable {
    private final WebDriver searchInTableDriver;
    private final WebDriverWait searchInTableWait;
    private final ExtentTest writeLog;

    // constructor
    public SearchInTeamManagerTable(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d, this);
        this.searchInTableDriver = d;
        this.searchInTableWait = w;
        this.writeLog = l;
    }

    static int row = 0;
    static int column = 0;

    public int searchItem(WebElement table, String searchedItem) {
        //It will return the row number where the item searched was found.

        this.searchInTableWait.until(ExpectedConditions.visibilityOf(table));

        List<WebElement> rows_table = table.findElements(By.tagName("tr"));
        //Calculate no of rows in table.
        int rows_count = rows_table.size();
        int found_row_index = -1;


            outloopExit:
            for (int row = 1; row < rows_count; row++) {

                List<WebElement> columns_row = rows_table.get(row).findElements(By.tagName("td"));
                int columns_count = columns_row.size();

                //Loop will execute till the last cell of that specific row
                for (int column = 0; column < columns_count; column++) {

                    // Retrieve text from that specific cell
                    String cellText = columns_row.get(column).getText();
                    boolean isSelected = columns_row.get(column).isSelected();

                    if ((cellText.split("\\n")[0].equals(searchedItem)) | (cellText.split("\\n")[1].equals(searchedItem))){
                        found_row_index = row;
                        this.writeLog.info(searchedItem + " was found in the list");
                        break outloopExit;
                    }
                }
            }

        return found_row_index;
    }


}
