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

public class BasePage extends Page {

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div[5]/button")
    public WebElement clickUserProfile;

    @FindBy(xpath = "//button[@class='yTThzZMDkelhke' and @data-testid='account-menu-logout']/span[text()='Log out']")
    public WebElement clickLogOut;

    @FindBy(xpath = "//*[contains(text(), 'test Crate Board')]")
    public WebElement selectBoard;

    @FindBy(id = "logout-submit")
    public WebElement confirmLogout;


    protected WebElementHelpers elementHelpers = new WebElementHelpers();

    public WebDriver driver = browser();

    public static void navigateToBaseUrl() {
        String baseUrl = Settings.baseUrl;
        browser().navigate().to(baseUrl);
        System.out.println("Welcome to Product - Selenium Automation Framework");
    }

    public void delay(){
        elementHelpers.weWaitForSeconds();
    }

    public void clickUserProfile() {
        elementHelpers.weClick(clickUserProfile);
        instanceOf(BasePage.class);
    }

    public void clickLogOut() {
        elementHelpers.weClick(clickLogOut);
        instanceOf(BasePage.class);
    }

    public void selectBoard() {
        elementHelpers.weClick(selectBoard);
        instanceOf(BasePage.class);
    }


}