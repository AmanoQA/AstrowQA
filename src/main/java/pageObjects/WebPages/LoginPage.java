package pageObjects.WebPages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage  {
    private final WebDriver loginPageDriver;
    private final WebDriverWait loginPageWait;
    private final ExtentTest writeLog;

    @FindBy(xpath = "//input[@placeholder='User name']")
    private WebElement userNameTextBox;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//span[text()='Login']")
    private WebElement loginBtn;

    @FindBy(xpath = "//span[@class ='x-btn-inner clsTopLogout' and text()='Logout']")
    private WebElement logoutBtn;

    @FindBy(xpath = "//*[contains(text(),'Hello')]")
    private WebElement hello;


    // constructor
    public LoginPage(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d,this);
        this.loginPageDriver = d;
        this.loginPageWait = w;
        this.writeLog = l;
    }

    public void login(String userName, String password){
        this.setUserName(userName);
        this.setPassword(password);
        this.clickLogin();
    }

    public void doLogin(String user, String password){
        this.login(user,password);
    }

    // ------------------------------------------------
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

    public boolean checkAccount(String userName){
        boolean isLogIn;
        this.loginPageWait.until(ExpectedConditions.visibilityOf(logoutBtn));
        this.loginPageWait.until(ExpectedConditions.visibilityOf(hello));
        isLogIn = this.logoutBtn.getText().contains("Logout") && hello.getText().contains("Hello, " + userName);
        this.writeLog.info("Check if Logout button is displayed and \"Hello, "+ userName + "\" message is displayed");

        return isLogIn;
    }


}
