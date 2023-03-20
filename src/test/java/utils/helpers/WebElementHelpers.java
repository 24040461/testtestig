package utils.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static utils.selenium.Driver.browser;
import static utils.selenium.Settings.weHighlightedColour;

public class WebElementHelpers {
    int sec = 10;
    public WebDriverWait weWaitForSeconds() {

        WebDriver driver = browser();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));;
        return wait;
    }

    public void weElementIsDisplayed(WebElement element) {
        weWaitForSeconds().until(ExpectedConditions.visibilityOf(element));
    }

    public void weElementToBeClickable(WebElement element) {
        weWaitForSeconds().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void weHighlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) browser();
        js.executeScript(weHighlightedColour, element);
    }

    public void weClick(WebElement element) {
        weElementToBeClickable(element);
        weHighlightElement(element);
        element.click();
    }

    public void weSendKeys(WebElement element, String text, boolean clearFirst) {
        weElementIsDisplayed(element);
        if (clearFirst) weClick(element);
        element.sendKeys(text);
    }

    public void weElementIsInvisible(WebElement element) {
        weWaitForSeconds().until(ExpectedConditions.invisibilityOf(element));
    }

    public String weGetAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }
}
