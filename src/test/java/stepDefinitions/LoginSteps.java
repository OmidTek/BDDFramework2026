package stepDefinitions;

import base.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DemoWebShopMainPage;
import utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginSteps {

    private DemoWebShopMainPage dwsmp;
    final Logger log = LogManager.getLogger(LoginSteps.class);

    @Given("navigate to the Demo Web Shop")
    public void navigate_to_the_demo_web_shop() {
        dwsmp=new DemoWebShopMainPage(DriverFactory.getDriver());
      DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
      log.info("navigate to the Demo Web Shop");
    }
    @When("click on login button on header")
    public void click_on_login_button_on_header() {
        dwsmp.clickHeaderLoginBtn();
        log.info("click on login button on header");
    }
    @Then("should be show Welcome Please Sign In")
    public void should_be_show_welcome_please_sign_in() {
        dwsmp.getWelcomeSignInText();
        Assert.assertEquals(dwsmp.getWelcomeSignInText(),"Welcome, Please Sign In!");
        log.info("should be show Welcome Please Sign In");
    }
    @Then("enter the valid email {string}")
    public void enter_the_valid_email(String string) {
        dwsmp.enterEmailBox(ConfigReader.getProperty("username"));
        log.info("enter the valid email {string}");
    }
    @Then("enter the valid password {string}")
    public void enter_the_valid_password(String string) {
        dwsmp.enterPassword(ConfigReader.getProperty("password"));
        log.info("enter the valid password {string}");
    }
    @Then("click on login button")
    public void click_on_login_button() {
        dwsmp.clickOnSubmitBtn();
        log.info("click on login button");
    }
    @Then("should be logged in successfully")
    public void should_be_logged_in_successfully() {
        Assert.assertEquals(dwsmp.getAccountInfoText(),ConfigReader.getProperty("username"));
        log.info("should be logged in successfully");
    }


}
