package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Board extends BasePage{


    @FindBy(xpath = "//*[@id=\"board\"]/div/form/a")
    public WebElement addList;

    @FindBy(xpath = "//*[@id=\"board\"]/div/form/input")
    public WebElement addListName;

    @FindBy(xpath = "//*[@id=\"board\"]/div/form/div/input")
    public WebElement submitNewList;

    public void addList() {
        elementHelpers.weClick(addList);
        instanceOf(BasePage.class);
    }

    public void addListName(String text) {
        elementHelpers.weSendKeys(addListName, text, true);
        elementHelpers.weClick(submitNewList);
        instanceOf(BasePage.class);
    }



}