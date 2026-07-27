package stepDefinitions;

import base.BrowserContext;
import base.DriverFactory;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.ScenarioContext;
import utils.ScreenshotUtils;

import static base.BrowserContext.getBrowser;


public class CucumberHooks {

    private static final Logger log = LogManager.getLogger(CucumberHooks.class);
    private String browser ;



    @Before(order = 1)
    public void launchBrowser() {
       // DriverFactory.initiateDriver(ConfigReader.getProperty("browser"));
        browser=BrowserContext.getBrowser();
        DriverFactory.initiateDriver(browser);
    }

    @Before(order = 2)
    public void beforeScenario(Scenario scenario) {
        ScenarioContext.setScenario(scenario);
        log.info("Starting Scenario: {}", scenario.getName());
    }

//    @Before(order = 3)
//    public void addBrowserName(Scenario scenario) {
//        scenario.attach(ConfigReader.getProperty("browser").getBytes(), "text/plain", "Browser");
//    }

    @Before(order = 3)
    public void addBrowserName() {

        ExtentCucumberAdapter.addTestStepLog(
                "Browser: " + ConfigReader.getProperty("browser")
        );

    }


    @After(order = 3)
    public void screenshotFailed(Scenario scenario) {

        if (scenario.isFailed()) {

            ScreenshotUtils.capture( "Failed_" +
                    scenario.getName().replace(" ", "_"));

        }

    }

    @After (order=2)
    public void afterScenario(Scenario scenario) {

        log.info(
                "Finished Scenario: {} - {}",
                scenario.getName(),
                scenario.getStatus());

    }

    @After(order = 1)
    public void tearDown() {
        DriverFactory.quitDriver();
        ScenarioContext.removeScenario();
    }
}