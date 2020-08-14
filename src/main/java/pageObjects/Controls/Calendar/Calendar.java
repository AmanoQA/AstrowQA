package pageObjects.Controls.Calendar;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

public class Calendar {

    private final WebDriver calendarDriver;
    private final WebDriverWait calendarWait;
    private final ExtentTest writeLog;

    @FindBy(xpath = "//div[@class = 'x-monthpicker-item x-monthpicker-month']")
    private List<WebElement> monthOption;

    @FindBy(xpath = "//div[@class = 'x-monthpicker-item x-monthpicker-year']")
    private List<WebElement> yearOption;

    @FindBy(xpath = "//span[@class = 'x-btn-inner' and contains(text(), 'OK')]")
    private WebElement okBtn;

    @FindBy(xpath = "//span[@class = 'x-btn-inner' and contains(text(), 'Cancel')]")
    private WebElement cancelBtn;

    @FindBy(xpath = "(//div[@class = 'x-datepicker-month']/div/em/button/span)[2]")
    private WebElement monthYear;


    // constructor
    public Calendar(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d, this);
        this.calendarDriver = d;
        this.calendarWait = w;
        this.writeLog = l;
    }

    public void selectDateFromCalendar(WebElement calendarTable, String day, String month, String year){

        this.monthYear.click();

        MonthSearched monthSearched = new MonthSearched();
        String selectMonth = monthSearched.monthSearched(month);

        for (WebElement monthI : monthOption) {
            if (monthI.getText().equals(selectMonth)) {
                monthI.click();
                this.writeLog.info(selectMonth + " month was selected");
                break;
            }
        }

        for (WebElement yearI : yearOption) {
            if (yearI.getText().equals(year)) {
                yearI.click();
                this.writeLog.info(year + " year was selected");
                break;
            }
        }

        this.okBtn.click();

        SearchInCalendarTable searchInTable = new SearchInCalendarTable(this.calendarDriver, this.calendarWait, this.writeLog);
        searchInTable.searchItem(calendarTable, day);

        int[] rowCol = (searchInTable.searchItem(calendarTable, day));
        if (rowCol[0] == -1 | rowCol[1] == -1){
            return;
        }

        //int column = Integer.parseInt(day);

        WebElement tableElement = calendarTable.findElements(By.tagName("tr")).get(rowCol[0]).findElements(By.tagName("td")).get(rowCol[1]);
        tableElement.click();
        //this.writeLog.info(day + " day was selected");
        this.writeLog.info(day + ", " + month + ", "+ year + " was selected");

    }

}
