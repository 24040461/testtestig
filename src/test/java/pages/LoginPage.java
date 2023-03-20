package pages;

import static utils.selenium.Driver.browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.helpers.WebDriverHelpers;
import utils.helpers.WebElementHelpers;
import utils.selenium.Settings;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "user")
    public WebElement enterUsername;

    @FindBy(id = "password")
    public WebElement enterPassword;

    @FindBy(id = "login")
    public WebElement clickNext;

    @FindBy(id = "login-submit")
    public WebElement clickLogin;

    @FindBy(id = "login")
    public WebElement invalidLogin;

    @FindBy(id = "error")
    public WebElement errorMessage;

    protected WebElementHelpers elementHelpers = new WebElementHelpers();


    public void enterUsername(String searchTerm){
        elementHelpers.weSendKeys(enterUsername,searchTerm,true);
    }

    public void clickContinue(){
        elementHelpers.weClick(clickNext);
    }

    public void enterPassword(String searchTerm){
        elementHelpers.weSendKeys(enterPassword,searchTerm,true);
    }

    public void clickLogin() {
        elementHelpers.weClick(clickLogin);
    }

    public void clickInvalidLogin() {
        elementHelpers.weClick(invalidLogin);
    }

    public void errorMessageIsDisplayed() {
        elementHelpers.weElementIsDisplayed(errorMessage);
    }
}
