package stepDefinitions;

import base.DriverFactory;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.YamlReader;

public class GetUrlYaml {

    private static final Logger log =
            LogManager.getLogger(GetUrlYaml.class);

    @Given("user opens the website using the YAML configuration")
    public void user_opens_the_website_using_the_yaml_configuration()
            throws InterruptedException {

        String url = YamlReader.getEnvironmentUrl();

        DriverFactory.getDriver().get(url);

        Thread.sleep(10000);

        log.info("Navigate to " + url +
                " environment: " + YamlReader.get("environment"));
    }
}
