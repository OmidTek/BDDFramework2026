package stepDefinitions;

import base.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import pages.SwagLabsLoginPage;

public class SwagLabsLoginSteps {
    private SwagLabsLoginPage sllp = new SwagLabsLoginPage(DriverFactory.getDriver());
    private static final Logger log = LogManager.getLogger(ShoppingJewelrySteps.class);

    @Given("the user opens the page {string}")
    public void the_user_opens_the_page(String url) {
        DriverFactory.getDriver().get(url);
        log.info("the user opens the page");
    }

    @When("the user enters the username {string} and password {string}")
    public void the_user_enters_the_username_and_password(String userName, String password) {
        sllp.enterUserNameAndPassword(userName, password);
        log.info("the user enters the username"+ userName+"and password"+password);
    }


    @Then("the user should be on the main page")
    public void the_user_should_be_on_the_main_page() {
        Assert.assertEquals(sllp.getHeaderText(), "Swag Labs");
        log.info("the user on the main page");
    }

    @When("the user clicks the burger menu")
    public void the_user_clicks_the_burger_menu() {
        sllp.clickOnBurgerMenu();
        log.info("the user clicks the burger menu");
    }

    @When("the user logs out")
    public void the_user_logs_out() {
        sllp.clickOnLogout();
        log.info("the user logs out");
    }

}
