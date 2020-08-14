package pageObjects.Controls;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterTime {

    private final WebDriver enterTimeDriver;
    private final WebDriverWait enterTimeWait;

    // constructor
    public EnterTime(WebDriver d, WebDriverWait w) {

        PageFactory.initElements(d, this);
        this.enterTimeDriver = d;
        this.enterTimeWait = w;
    }

    public void enterTime(WebElement field, String time, String click)  {

        Actions actions = new Actions(this.enterTimeDriver);
        if (click.toLowerCase().equals("yes")){
            actions.moveToElement(field).click(field).perform();
        }

        for (int i = 0; i < time.length(); i++) {
            actions.moveToElement(field).sendKeys(String.valueOf(time.charAt(i))).perform();
        }
    }


    //    public void enterTime1(WebElement field, String time)  {
//
//        for (int i = 0; i < time.length(); i++) {
//            field.click();
//            field.sendKeys(String.valueOf(time.charAt(i)));
//        }
//        this.dpPageDriver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
//    }
}
