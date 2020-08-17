package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hpsf.Date;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pageObjects.WebPages.LoginPage;

import java.lang.reflect.Method;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static utils.AppParams.*;

public class ExtentManager extends GenericDriver {

    private static  ExtentReports   extent;
    protected       String          reportName;

    public static   ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    public static   ThreadLocal<ExtentTest> writeLog = new ThreadLocal<ExtentTest>();
    private         Calendar calendar = Calendar.getInstance();
    private         SimpleDateFormat formater = new SimpleDateFormat("ddMMyyyy-HHmmss");


    @BeforeSuite
    public void beforeSuite() {

        this.reportName = "Test Report - "+ testedVersion +".html";
        //this.reportName = "Test Report - "+ testedVersion + "-" + formater.format(calendar.getTime())+ ".html";

        extent = ExtentManager.createInstance(".\\src\\main\\reports\\" + this.reportName);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(".\\src\\main\\reports\\");
        extent.attachReporter(htmlReporter);
    }

    @BeforeClass
    public synchronized void beforeClass() {
        ExtentTest parent = extent.createTest(getClass().getSimpleName());
        parentTest.set(parent);
    }

//    @BeforeMethod
//    public synchronized void beforeMethod(Method method) {
//        ExtentTest child = parentTest.get().createNode(method.getName());
//        child.assignCategory(getClass().getSimpleName());
//        test.set(child);
//    }

    @AfterMethod
    public synchronized void afterMethod(ITestResult result, Method method) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            writeLog.get().log(Status.FAIL, MarkupHelper.createLabel("Test Case: " + result.getName() + " - FAILED due to below issues:", ExtentColor.RED));
            writeLog.get().fail(result.getThrowable().getMessage());
            //get screenshot with the error
            writeLog.get().fail("Snapshot below: " + writeLog.get().addScreenCaptureFromPath(this.capture(method)));
        }
        else if (result.getStatus() == ITestResult.SKIP){
            writeLog.get().log(Status.SKIP, MarkupHelper.createLabel("Test Case: " + result.getName()+" - SKIPPED",ExtentColor.ORANGE));
            writeLog.get().skip(result.getThrowable().getMessage());
        }
        else
        {
            writeLog.get().log(Status.PASS, MarkupHelper.createLabel("Test Case: " + result.getName()+" - PASSED",ExtentColor.GREEN));
            //writeLog.get().pass("Test passed");
        }

        extent.flush();
    }
//    @AfterSuite
//    public void close(){
//        this.extent.close();
//    }

    // -------------------------------------------------------------------------------------------------------
    // Private methods

    private String capture( Method method) throws IOException {

        File screenFile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
        String path = (".\\src\\main\\reports\\ErrorScreenshots\\" + method.getName()+ "-" + formater.format(calendar.getTime()) + ".png");

        File destination = new File(path);
        FileUtils.copyFile(screenFile, destination);

        String[] relativePath = destination.toString().split("reports");
        String screenshotPath = ".\\" + relativePath[1];
        return screenshotPath;
    }

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance(".\\src\\main\\reports\\test-output\\extent.html");
        return extent;
    }

    public static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Astrow automation testing");
        htmlReporter.config().setReportName("Astrow automation testing");
        htmlReporter.config().setEncoding("utf-8");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        String nameOS = System.getProperty("os.name");
        String versionOS = System.getProperty("os.version");
        String architectureOS = System.getProperty("os.arch");

        extent.setSystemInfo("Tested version: ", testedVersion);
        extent.setSystemInfo("Author name:", authorName);
        extent.setSystemInfo("Browser: ", String.valueOf(driverType));
        extent.setSystemInfo("OS: ",nameOS);
        extent.setSystemInfo("Version OS: ",versionOS);
        extent.setSystemInfo("Architecture OS: ",architectureOS);

//        extent.setSystemInfo("Browser: ",browserName);
//        extent.setSystemInfo("Browser version: ", browserVersion);
//
//        Capabilities browserCap = ((RemoteWebDriver) this.driver).getCapabilities();
//        String browserName = browserCap.getBrowserName();
//        String browserVersion = browserCap.getVersion();

        return extent;
    }
    // -------------------------------------------------------------------------------------------------------
    // Public methods

    public void createTestReport(String testName, String testDescription) {
        ExtentTest child = parentTest.get().createNode(testName, testDescription);
        child.assignCategory(getClass().getSimpleName());
        writeLog.set(child);

    }

}
