package utils.selenium;

import io.github.cdimascio.dotenv.Dotenv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.drivers.ChromeRemoteWebDriver;
import utils.drivers.ChromeWebDriver;
import utils.drivers.FirefoxRemoteWebDriver;
import utils.drivers.FirefoxWebDriver;

public class DriverController {

    public static DriverController instance = new DriverController();

    WebDriver webDriver;
    Dotenv dotenv = Dotenv.load();

    private static Logger log = LogManager.getLogger(DriverController.class.getName());

    public void startChrome(String arg) throws Exception {
        if(instance.webDriver != null) return;
        if (System.getenv("LOCAL")==null) {
            String local = dotenv.get("LOCAL");
            assert local != null;
            if (local.equals("true")) {
                instance.webDriver = ChromeWebDriver.loadChromeDriver(arg);
            }
        }

        else if(System.getenv("LOCAL").trim().equals("false")) {
            instance.webDriver = ChromeRemoteWebDriver.loadChromeDriver(arg);
        }
    }

    public void startFirefox(String arg) throws Exception {
        if(instance.webDriver != null) return;
        if (System.getenv("LOCAL")==null) {
            String local = dotenv.get("LOCAL");
            assert local != null;
            if (local.equals("true")) {
                instance.webDriver = FirefoxWebDriver.loadFirefoxDriver(arg);
            }
        }

        else if(System.getenv("LOCAL").trim().equals("false")) {
            instance.webDriver = FirefoxRemoteWebDriver.loadFirefoxDriver(arg);
        }
    }

    public void stopWebDriver() {
        if (instance.webDriver == null) return;

        try
        {
            instance.webDriver.quit();
        }
        catch (Exception e)
        {
            log.error(e + "::WebDriver stop error");
        }

        instance.webDriver = null;
        log.debug(":: WebDriver stopped");
    }
}