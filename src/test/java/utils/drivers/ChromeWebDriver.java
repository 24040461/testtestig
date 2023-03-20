package utils.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeWebDriver {

    public static WebDriver driver;

    public static void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }

    public static WebDriver loadChromeDriver(String chromeArgument) {
        setupChromeDriver();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments(chromeArgument);

        driver = new ChromeDriver(options);
        //driver = new RemoteWebDriver(options);
        return driver;
    }
}