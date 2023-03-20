package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;

public class SettingsSteps extends BasePage {

    @When("I click settings")
    public void iClickSettings() {
        instanceOf(SettingsPage.class).clickSettings();
    }

    @And("I change visibility to public")
    public void theyChangeVisibilityToPublic() {
        instanceOf(SettingsPage.class).clickChange();
        instanceOf(SettingsPage.class).changeToPublic();
        //add Assert
    }

    @Then("I can see the correct Workspace visibility has changed")
    public void iCanSeeTheCorrectWorkspaceChanged() {
        instanceOf(SettingsPage.class).workspaceMessage();
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, "Abdullah Darsot’s Workspace (abdullahdarsotsworkspace) | Trello");
    }

    @And("I change visibility to private")
    public void iChangeVisibilityToPrivate() {
        instanceOf(SettingsPage.class).clickChange();
        instanceOf(SettingsPage.class).changeToPrivate();
    }
}