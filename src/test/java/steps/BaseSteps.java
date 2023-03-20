package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;

public class BaseSteps extends BasePage {


    @When("I click on my profile")
    public void iClickOnMyProfile() {
        instanceOf(BasePage.class).clickUserProfile();
    }

    @And("I click log out")
    public void iClickLogOut() {
        instanceOf(BasePage.class).clickLogOut();
        instanceOf(BasePage.class).confirmLogout.isDisplayed();
    }

    @Then("I am sent back to Trello home page")
    public void iAmSentBackToTrelloHomePage() {
        delay();
        Assert.assertEquals(driver.getCurrentUrl(), "https://trello.com/home");
    }


}