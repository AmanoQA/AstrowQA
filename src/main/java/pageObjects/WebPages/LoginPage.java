package pageObjects.WebPages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppParams;


public class LoginPage  {
    private final WebDriver loginPageDriver;
    private final WebDriverWait loginPageWait;
    private final ExtentTest writeLog;

    @FindBy(xpath = "//input[@placeholder='User name']")
    private WebElement userNameTextBox;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//input[@type='button']")
    private WebElement rememberMe;

    @FindBy(xpath = "//span[text()='Login']")
    private WebElement loginBtn;

    @FindBy(xpath = "//span[@class ='x-btn-inner clsTopLogout' and text()='Logout']")
    private WebElement logoutBtn;

    @FindBy(xpath = "//*[contains(text(),'Hello')]")
    private WebElement hello;

    @FindBy(xpath = "//*[@id = 'login_domain']")
    private WebElement domainCloudTextBox;

    @FindBy(xpath = "//*[@id = 'login_username']")
    private WebElement userNameCloudTextBox;

    @FindBy(xpath = "//*[@id = 'login_password']")
    private WebElement passwordCloudTextBox;

    @FindBy(xpath = "//*[@id = 'imgRememberMe']")
    private WebElement rememberMeCloud;

    @FindBy(xpath = "//*[@id = 'loginButton']")
    private WebElement loginCloudBtn;


    // constructor
    public LoginPage(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d,this);
        this.loginPageDriver = d;
        this.loginPageWait = w;
        this.writeLog = l;
    }

    public void login(String domainCloud, String userName, String password){

        if (AppParams.runOn.equals("cloud")){
            this.setDomainCloud(domainCloud);
            this.setUserNameCloud(userName);
            this.setPasswordCloud(password);
            this.clickLoginCloud();
        }

        else {
            this.setUserName(userName);
            this.setPassword(password);
            this.clickLogin();
        }
    }

    public void login(String domainCloud, String userName, String password, String rememberMeCheck){

        if (AppParams.runOn.equals("cloud")){
            this.setDomainCloud(domainCloud);
            this.setUserNameCloud(userName);
            this.setPasswordCloud(password);
            this.clickRememberMeCloud(rememberMeCheck);
            this.clickLoginCloud();
        }

        else {
            this.setUserName(userName);
            this.setPassword(password);
            this.clickRememberMe(rememberMeCheck);
            this.clickLogin();
        }
    }

    public void doLogin(String domainCloud, String user, String password){
        this.login(domainCloud, user,password);
    }

    public void clickLogout(){
        this.loginPageWait.until(ExpectedConditions.visibilityOf(logoutBtn));
        this.writeLog.info("Click on Logout button");
        this.logoutBtn.click();
    }

    // Local------------------------------------------------
    public void setUserName(String userName){

        this.loginPageWait.until(ExpectedConditions.visibilityOf(userNameTextBox));
        this.writeLog.info("Enter UserName: " + userName);
        this.userNameTextBox.sendKeys(userName);
    }

    public void setPassword(String password){

        this.loginPageWait.until(ExpectedConditions.visibilityOf(passwordTextBox));
        this.writeLog.info("Enter Password: " + password);
        this.passwordTextBox.sendKeys(password);
    }

    public void clickLogin(){

        this.loginPageWait.until(ExpectedConditions.visibilityOf(loginBtn));
        this.writeLog.info("Click on Login button");
        this.loginBtn.click();
    }

    public void clickRememberMe(String option){

        this.loginPageWait.until(ExpectedConditions.visibilityOf(rememberMe));

        if(option.equals("check")) {
            if (rememberMe.getAttribute("aria-checked").equals("false")){
                this.writeLog.info("Remember me: " + option);
                this.rememberMe.click();
            }
        }
        else if(option.equals("uncheck")){
            if (rememberMe.getAttribute("aria-checked").equals("true")){
                this.writeLog.info("Remember me: " + option);
                this.rememberMe.click();
            }
        }

    }

    public void clickRememberMeCloud(String option){

        this.loginPageWait.until(ExpectedConditions.visibilityOf(rememberMeCloud));

        if(option.equals("check")) {
            if (rememberMeCloud.getAttribute("class").equals("divCheckbox ckunchecked")){
                this.writeLog.info("Remember me: " + option);
                this.rememberMeCloud.click();
            }
        }
        else if(option.equals("uncheck")){
            if (rememberMeCloud.getAttribute("class").equals("divCheckbox ckchecked")){
                this.writeLog.info("Remember me: " + option);
                this.rememberMeCloud.click();
            }
        }

    }

    // Cloud------------------------------------------------

    public void setDomainCloud(String domainCloud){

        this.loginPageWait.until(ExpectedConditions.visibilityOf(domainCloudTextBox));
        this.writeLog.info("Enter Domain: " + domainCloud);
        this.domainCloudTextBox.sendKeys(domainCloud);
    }

    public void setUserNameCloud(String userNameCloud){

        this.loginPageWait.until(ExpectedConditions.visibilityOf(userNameCloudTextBox));
        this.writeLog.info("Enter UserName: " + userNameCloud);
        this.userNameCloudTextBox.sendKeys(userNameCloud);
    }


    public void setPasswordCloud(String passwordCloud){

        this.loginPageWait.until(ExpectedConditions.visibilityOf(passwordCloudTextBox));
        this.writeLog.info("Enter Password: " + passwordCloud);
        this.passwordCloudTextBox.sendKeys(passwordCloud);
    }

    public void clickLoginCloud(){

        this.loginPageWait.until(ExpectedConditions.visibilityOf(loginCloudBtn));
        this.writeLog.info("Click on Login button");
        this.loginCloudBtn.click();
    }
    //---------------------------------------------------------

    public boolean checkAccount(String userName){
        boolean isLogIn;
        this.loginPageWait.until(ExpectedConditions.visibilityOf(logoutBtn));
        this.loginPageWait.until(ExpectedConditions.visibilityOf(hello));
        isLogIn = this.logoutBtn.getText().contains("Logout") && hello.getText().contains("Hello, " + userName);
        this.writeLog.info("Check if Logout button is displayed and \"Hello, "+ userName + "\" message is displayed");

        return isLogIn;
    }

    public boolean checkRememberMe(String checkUserName, String checkPassword){

        boolean isDisplayed = false;

        if ((this.loginPageDriver.manage().getCookieNamed("loginUser").getValue().equals(checkUserName)) &&
                (this.loginPageDriver.manage().getCookieNamed("loginPassword").getValue().equals(checkPassword)) &&
                (this.loginPageDriver.manage().getCookieNamed("loginRemember").getValue().equals("true"))){
            isDisplayed = true;
            return isDisplayed;
        }
        return isDisplayed;
    }


}
