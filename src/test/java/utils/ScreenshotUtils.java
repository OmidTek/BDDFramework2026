package utils;

import base.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtils {

    public static void capture(String name) {

        if (DriverFactory.getDriver() == null) {
            throw new RuntimeException("Driver is null. Cannot take screenshot.");
        }

        if (ScenarioContext.getScenario() == null) {
            throw new RuntimeException("Scenario is null. Cannot attach screenshot.");
        }

        byte[] screenshot =
                ((TakesScreenshot) DriverFactory.getDriver())
                        .getScreenshotAs(OutputType.BYTES);

        ScenarioContext.getScenario().attach(
                screenshot,
                "image/png",
                name);
    }

}
