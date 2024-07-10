package Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;
import org.testng.Reporter;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserManager {

    Environment environment = new Environment();

    String url = environment.PortalBaseUrl;

    @SuppressWarnings("deprecation")
    public static WebDriver getDriver(String browser, String url) {
        WebDriver driver = null;
        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            if (driver == null) {

                ChromeOptions options = new ChromeOptions();
                //options.addArguments("--headless");
                options.addArguments("--disable-web-security");
                options.addArguments("--disable-site-isolation-trials");

                driver = new ChromeDriver(options);
            }
        } else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            if (driver == null) {

                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                driver = new FirefoxDriver(options);
            }

        } else if (browser.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();
            if (driver == null) {

                EdgeOptions options = new EdgeOptions();
                //options.addArguments("--headless");
                driver = new EdgeDriver(options);
            }

        } else {
            Assert.assertTrue(false, "No Browser Found");
        }


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        SessionId s = ((RemoteWebDriver) driver).getSessionId();

        Reporter.log("This is Session ID: "+ s, true);
        return driver;



    }

    public void enviroment() {
        WebDriver driver = null;

        driver.get(url);
    }

}