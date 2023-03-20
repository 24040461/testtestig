package utils.drivers;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static utils.selenium.Settings.hubUrl;

public class ChromeRemoteWebDriver {

    public static RemoteWebDriver loadChromeDriver(String chromeArgument) throws Exception{
        ChromeOptions options = new ChromeOptions();
        options.addArguments(chromeArgument);
        return new RemoteWebDriver(new URL("http://"+hubUrl+":4444/wd/hub"), options);
    }
}