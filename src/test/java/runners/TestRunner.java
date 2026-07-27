package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
// @RunWith(Cucumber.class)   for JUnit


@CucumberOptions(
features = "src/test/resources/features",
glue={"stepDefinitions"},
tags=" @test or @shopping",
dryRun = false,
publish = false,
monochrome = true
        ,   plugin =  {
        "pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }

//        "html:target/site/cucumberReport.html" }
        //snippets = SnippetType.CAMELCASE
)

public class TestRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }

}
