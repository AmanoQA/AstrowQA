package utils;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FireFoxDriverManager extends DriverManager{

    @Override
    protected void createWebDriver() {

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("intl.accept_languages", "en-GB");

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);

        System.setProperty("webdriver.gecko.driver", ".\\src\\main\\resources\\geckodriver.exe");
        this.driver = new FirefoxDriver(options);

        this.driver.manage().window().maximize();
        this.driver.manage().deleteAllCookies();
    }
}
