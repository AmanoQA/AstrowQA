package utils;

import org.openqa.selenium.ie.InternetExplorerDriver;


public class IEDriverManager extends DriverManager{
    protected void createWebDriver() {

        System.setProperty("webdriver.ie.driver", ".\\src\\main\\resources\\IEDriverServer.exe");

        this.driver = new InternetExplorerDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().deleteAllCookies();
    }
}
