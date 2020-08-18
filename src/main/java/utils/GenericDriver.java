package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class GenericDriver {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private   DriverManager driverManager;


    @BeforeMethod
    public void initDriver() {
        this.driverManager = DriverManagerFactory.getDriverManager(AppParams.driverType);
        this.driver = this.driverManager.getWebDriver();
        this.wait = new WebDriverWait(this.driver, 30);
        this.wait.until(webDriver -> ((JavascriptExecutor) this.driver).executeScript("return document.readyState").equals("complete") && ((JavascriptExecutor) this.driver).executeScript("return document.visibilityState").equals("visible"));
    }

    @AfterMethod
    public void quitDriver() {

        this.driverManager.quitWebDriver();
    }


    @FindBy(xpath = "//*[contains(text(),'Please wait')]")
    private WebElement pleaseWait;

    @FindBy(xpath = "//*[contains(text(),'Loading')]")
    private WebElement loading;

    public void waitPageToBeLoaded() {

        try {
            this.wait.until(ExpectedConditions.visibilityOf(loading));
        }
        catch(Exception ignored) {
        }

        try {
            this.wait.until(ExpectedConditions.visibilityOf(pleaseWait));
        }
        catch(Exception ignored) {
        }

        try {
            while ((this.driver.findElement(By.xpath("//*[contains(text(),'Please wait')]")).isDisplayed()) | (this.driver.findElement(By.xpath("//*[contains(text(),'Loading')]")).isDisplayed())){

                Thread.sleep(1000);
            }
        }
        catch(Exception ignored) {
        }
    }


    public void checkPageIsReady() {

        JavascriptExecutor js = (JavascriptExecutor) this.driver;

        //check ready state  - complete and visibilityState - visible
        if ((js.executeScript("return document.visibilityState").toString().equals("visible")) && (js.executeScript("return document.readyState").toString().equals("complete"))) {
            System.out.println("Page Is loaded.");
            //return;
        }
    }

}
