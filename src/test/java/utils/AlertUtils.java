package utils;

import org.openqa.selenium.WebDriver;

public class AlertUtils {


    private WebDriver driver;

    public AlertUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void sendKeys(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

}
