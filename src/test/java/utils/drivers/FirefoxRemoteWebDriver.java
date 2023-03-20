package utils.drivers;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static utils.selenium.Settings.hubUrl;

public class FirefoxRemoteWebDriver {

    public static RemoteWebDriver loadFirefoxDriver(String firefoxArgument) throws Exception {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(firefoxArgument);
        return new RemoteWebDriver(new URL("http://"+hubUrl+":4444/wd/hub"), options);
    }
}