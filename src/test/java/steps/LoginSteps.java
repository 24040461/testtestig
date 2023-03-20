package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.BasePage;
import pages.LoginPage;
import utils.config.ConfigurationParser;

import java.io.IOException;
import java.util.Properties;

public class LoginSteps extends BasePage {

    Properties userDetails = null;

    public LoginSteps() throws IOException {
        this.userDetails = ConfigurationParser.parse("C:\\Users\\callu\\eclipse-workspace\\AutomationFrameworkMain1-master\\src\\test\\resources\\environment\\UserDetails.properties");
    }

    @Given("I enter valid login details")
    public void iEnterValidLoginDetails() {
        BasePage.navigateToBaseUrl();
        instanceOf(LoginPage.class).enterUsername(userDetails.getProperty("User.name"));
        instanceOf(LoginPage.class).clickContinue();
        instanceOf(LoginPage.class).enterPassword(userDetails.getProperty("User.password"));
        instanceOf(BasePage.class).delay();
        instanceOf(LoginPage.class).clickLogin();
    }

    @Given("I enter invalid details")
    public void iEnterInvalidDetails() {
        BasePage.navigateToBaseUrl();
        instanceOf(LoginPage.class).enterUsername(userDetails.getProperty("inValid.name"));
        instanceOf(LoginPage.class).clickContinue();
        instanceOf(LoginPage.class).enterPassword(userDetails.getProperty("inValid.password"));
        instanceOf(BasePage.class).delay();
    }

    @Then("I can see the correct board")
    public void iCanSeeTheCorrectBoard() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://trello.com/b/eanRWb3V/test-crate-board");
    }

    @When("I click submit")
    public void iClickSubmit() {
        instanceOf(LoginPage.class).clickInvalidLogin();
        instanceOf(BasePage.class).delay();
    }

    @Then("I can see the error message")
    public void iCanSeeTheErrorMessage() {
        instanceOf(LoginPage.class).errorMessageIsDisplayed();
    }


    @Given("I enter username {string} and password {string}")
    public void iEnterUsernameAndPassword(String text, String text1) {
        BasePage.navigateToBaseUrl();
        instanceOf(LoginPage.class).enterUsername(text);
        instanceOf(LoginPage.class).clickContinue();
        instanceOf(LoginPage.class).enterPassword(text1);
        instanceOf(BasePage.class).delay();
        instanceOf(LoginPage.class).clickLogin();
    }

    @Given("I enter invalid username {string} and password {string}")
    public void iEnterInvalidUsernameAndPassword(String text, String text1) {
        BasePage.navigateToBaseUrl();
        instanceOf(LoginPage.class).enterUsername(text);
        instanceOf(LoginPage.class).clickContinue();
        instanceOf(LoginPage.class).enterPassword(text1);

    }

}
