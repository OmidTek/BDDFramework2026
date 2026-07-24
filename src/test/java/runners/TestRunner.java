package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
// @RunWith(Cucumber.class)   for JUnit


@CucumberOptions(
features = "src/test/resources/features",
glue={"stepDefinitions"},
tags="@login",
dryRun = false,
publish = false,
monochrome = true
        ,   plugin = {
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "html:target/site/cucumberReport.html" }
        //snippets = SnippetType.CAMELCASE
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
