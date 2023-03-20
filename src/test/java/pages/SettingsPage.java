package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends BasePage{

    @FindBy(xpath = "//*[@id='content']//ul/li[5]/a")
    public WebElement settingsButton;

    @FindBy(xpath ="//div[@id=\"content\"]//nav//ul/li[1]//span[2]//span/span" )
    public WebElement expandWorkspace;

    @FindBy(xpath = "//button[@class=\"bxgKMAm3lq5BpA SEj5vUdI3VvxDc\" and text()=\"Change\"]")
    public WebElement changeVisibility;

    @FindBy(xpath = "//nav//li[2]/button")
    public WebElement makePublic;

    @FindBy(xpath = "//nav//li[1]/button")
    public WebElement makePrivate;

    @FindBy(xpath = "//span[@class='oc6pWDlCz6LG6R']")
    public WebElement publicOrPrivateMessage;

    public void clickSettings(){
        elementHelpers.weClick(expandWorkspace);
        elementHelpers.weClick(settingsButton);
    }

    public void clickChange(){
        elementHelpers.weClick(changeVisibility);
    }

    public void changeToPublic(){
        elementHelpers.weClick(makePublic);
    }

    public void workspaceMessage(){
        elementHelpers.weElementIsDisplayed(publicOrPrivateMessage);
    }

    public void changeToPrivate(){
        elementHelpers.weClick(makePrivate);
    }
}
