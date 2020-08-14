package pageObjects.Controls;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DropDown {

    private final WebDriver dropDownDriver;
    private final WebDriverWait dropDownWait;
    private final ExtentTest writeLog;

    // constructor
    public DropDown(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d, this);
        this.dropDownDriver = d;
        this.dropDownWait = w;
        this.writeLog = l;
    }

    public void dropDownSelect(WebElement list, String searchedElement) {

        this.dropDownWait.until(ExpectedConditions.visibilityOf(list));
        List<WebElement> dropDownElements = list.findElements(By.tagName("li"));

        for (int i = 1; i < dropDownElements.size(); i++) {

            if (dropDownElements.get(i).getText().contains(searchedElement)) {
                this.writeLog.info(searchedElement + " was selected");
                dropDownElements.get(i).click();
            }
        }
    }
}
