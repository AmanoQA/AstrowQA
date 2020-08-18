package pageObjects.Controls;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidationMessage {

    private final WebDriver validationMessageDriver;
    private final WebDriverWait validationMessageWait;
    private final ExtentTest writeLog;

    @FindBy(xpath = "//span[contains(@id, 'component')]")
    private WebElement message;

    // constructor
    public ValidationMessage(WebDriver d, WebDriverWait w, ExtentTest l) {

        PageFactory.initElements(d, this);
        this.validationMessageDriver = d;
        this.validationMessageWait = w;
        this.writeLog = l;
    }

    public boolean checkValidationMessage(String messageToBeChecked){
        boolean isDisplayed = false;
        this.validationMessageWait.until(ExpectedConditions.visibilityOf(message));
        String messageDisplayed = this.message.getText();

        if (messageDisplayed.equals(messageToBeChecked)){
            this.writeLog.info("Validation message is connect: " + "\" " + messageToBeChecked + " \"");
            isDisplayed = true;
        }
        else {
            this.writeLog.error("Validation message " + "\" " + messageToBeChecked + " \"" + " was not displayed ");
        }
        return isDisplayed;
    }
}
