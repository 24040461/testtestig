package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;

public class BoardSteps extends BasePage {

    @When("I click a board")
    public void iClickABoard(){
        instanceOf(BasePage.class).selectBoard();
    }

    @Then("I can see the board title")
    public void iCanSeeTheBoardTitle(){
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle,"test Crate Board | Trello");
    }

    @And("I add a list")
    public void iAddAList() {
        instanceOf(Board.class).addList();
        instanceOf(Board.class).addListName("test");
    }

}