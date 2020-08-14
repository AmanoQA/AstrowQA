package utils;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;
    protected abstract void createWebDriver();
    //public String testApp = "http://localhost/Astrow9.0.2-RTM";

    public void quitWebDriver(){
        if(null != driver){
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getWebDriver(){

        if(null == driver){
            createWebDriver();
            driver.get(AppParams.url);
        }
        return driver;
    }
}
