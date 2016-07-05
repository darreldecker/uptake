package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverBase {
    public String testingDomain = System.getProperty("test.domain","http://www.uptake.com").toLowerCase();
    public String desiredBrowser = System.getProperty("test.browser", "chrome").toLowerCase();

    public static WebDriver driver = null;
    public static WebDriverWait wait;

    public WebDriver createDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            if (desiredBrowser.contains("firefox")) {
                desiredCapabilities = DesiredCapabilities.firefox();
            }

            if (desiredBrowser.contains("safari")) {
                desiredCapabilities = DesiredCapabilities.safari();
                SafariOptions safariOptions = new SafariOptions();
                safariOptions.setUseCleanSession(true);
                desiredCapabilities.setCapability(SafariOptions.CAPABILITY, safariOptions);
            }

            if (desiredBrowser.contains("ie")) {
                desiredCapabilities = DesiredCapabilities.internetExplorer();
            }

            if (desiredBrowser.contains("chrome")) {
                // This is only the osx driver
                System.setProperty("webdriver.chrome.driver", "./src/lib/chromedriver");
                desiredCapabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("allow-running-insecure-content");
                options.addArguments("test-type");
                desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);

//                Map<String, String> mobileEmulation = new HashMap<String, String>();
//                mobileEmulation.put("deviceName", "Google Nexus 5");
//
//                Map<String, Object> chromeOptions = new HashMap<String, Object>();
//                chromeOptions.put("mobileEmulation", mobileEmulation);
//                desiredCapabilities = DesiredCapabilities.chrome();
//                desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            }


                if (desiredBrowser.contains("firefox")) {
                    driver = new FirefoxDriver(desiredCapabilities);
                }

                if (desiredBrowser.contains("safari")) {
                    driver = new SafariDriver(desiredCapabilities);
                }

                if (desiredBrowser.contains("ie")) {
                    driver = new InternetExplorerDriver(desiredCapabilities);
                }

                if (desiredBrowser.contains("chrome")) {
                    driver = new ChromeDriver(desiredCapabilities);
                }

        return driver;
    }

    public static void quitDriver() {
            driver.quit();
        driver = null;
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
