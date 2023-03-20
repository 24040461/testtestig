package utils.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.drivers.ChromeWebDriver;
import utils.selenium.DriverController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CucumberHooks extends ChromeWebDriver{

    @Before("@Web")
    public void beforeWeb() throws Exception {
        Properties browserProps = new Properties();
        browserProps.load(new FileInputStream("src/test/resources/config.properties"));

        String browser = browserProps.getProperty("browserName");

        if (browser.equalsIgnoreCase("chrome")) {
            DriverController.instance.startChrome("--disable-extensions");
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            DriverController.instance.startFirefox("--disable-extensions");
        }
    }

    @Before("@Chrome")
    public void beforeChrome() throws Exception {
        DriverController.instance.startChrome("--disable-extensions");
    }

    @Before("@Firefox")
    public void beforeFirefox() throws Exception {
        DriverController.instance.startFirefox("--disable-extensions");
    }

    @Before("@HeadlessChrome")
    public void beforeChromeHeadless() throws Exception {
        DriverController.instance.startChrome("--headless");
    }

    @Before("@HeadlessFirefox")
    public void beforeHeadlessFirefox() throws Exception {
        DriverController.instance.startFirefox("--headless");
    }

    @After (order = 0)
    public void stopWebDriver() {

        DriverController.instance.stopWebDriver();
    }

    @After (order = 1)
    public void tearDownGetScreenshots(Scenario scenario) {
        if (scenario.isFailed()){
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte [] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }

    }

}
