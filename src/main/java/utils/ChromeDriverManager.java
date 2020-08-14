package utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

    @Override
    protected void createWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("lang=en-GB");

        System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");

        this.driver = new ChromeDriver(options);
        this.driver.manage().deleteAllCookies();

    }
}
