package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
        this.wait.until(webDriver -> ((JavascriptExecutor) this.driver).executeScript("return document.readyState").equals("complete"));
    }

    @AfterMethod
    public void quitDriver() {

        this.driverManager.quitWebDriver();
    }

    public void waitForPageLoaded() {

        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");

                    }
                };

        try {
            Thread.sleep(2000);
            //WebDriverWait wait = new WebDriverWait(this.driver, 30);
            this.wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
}
