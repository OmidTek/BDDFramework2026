package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class DriverFactory {
    private static ThreadLocal< WebDriver> tlDriver=new ThreadLocal<>();
    //private static WebDriver driver;
    public static Logger logger;

    public static void initiateDriver(String browserType) {
        logger = LogManager.getLogger(DriverFactory.class);
        switch (browserType.toLowerCase()) {
            case "chrome":
                tlDriver.set(new ChromeDriver());
                break;
            case "edge":
                tlDriver.set(new EdgeDriver());
                break;
            case "firefox":
                tlDriver.set(new FirefoxDriver());
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }

        tlDriver.get().manage().deleteAllCookies();
        tlDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
       // tlDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        tlDriver.get().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }


    public static void quitDriver(){

        if(tlDriver.get() != null){
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }

}
