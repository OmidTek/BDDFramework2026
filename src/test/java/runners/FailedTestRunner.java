package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



    @CucumberOptions(
            features = "@target/failed_scenarios.txt",
            glue = "stepDefinitions"
    )
    public class FailedTestRunner extends AbstractTestNGCucumberTests {
    }
