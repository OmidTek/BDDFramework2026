package stepDefinitions;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigReader;

public class CucumberHooks {


    @Before(order = 1)
    public void launchBrowser() {
        DriverFactory.initiateDriver(ConfigReader.getProperty("browser"));
    }

    @Before(order = 2)
    public void addBrowserName(Scenario scenario) {
        scenario.attach(ConfigReader.getProperty("browser").getBytes(), "text/plain", "Browser");
    }


    @After(order = 2)
    public void screenshotFalied(Scenario scenario) {
        if (scenario.isFailed()) {
            screenshotAndAttach(scenario);
        }
    }

    @After(order = 1)
    public void tearDown() {
        DriverFactory.quitDriver();
    }



    public void screenshotAndAttach(Scenario scenario) {
        byte[] sourcePath = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
       scenario.attach(sourcePath, "image/png", scenario.getName().replace(" ", "_"));
    }}
