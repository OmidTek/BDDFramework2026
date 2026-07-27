package stepDefinitions;

import base.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.ShoppingJewelryPage;
import utils.ScreenshotUtils;

import java.util.List;
import java.util.Map;

public class ShoppingJewelrySteps {

    private static final Logger log = LogManager.getLogger(ShoppingJewelrySteps.class);
    private ShoppingJewelryPage sjp= new ShoppingJewelryPage(DriverFactory.getDriver());


    @When("user click on the Jewelry button on top menu")
    public void user_click_on_the_jewelry_button_on_top_menu() {
     sjp.clickOnJewelryBtn();
    }
    @When("user select the Create Your Own Jewelry")
    public void user_select_the_create_your_own_jewelry() {
       sjp.clickOnCreateYourOwnJewelry();
        ScreenshotUtils.capture("test");
    }
    @Then("user should be on the Create Your Own Jewelry page")
    public void user_should_be_on_the_create_your_own_jewelry_page() {
        Assert.assertTrue(sjp.getPageHeaderText().contains("Create Your Own Jewelry"));
    }
    @When("user fill out following fields")
    public void user_fill_out_following_fields(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String,String>> data=dataTable.asMaps();
        sjp.selectMatrial(data.get(0).get("Material"));
        sjp.enterLength(data.get(0).get("Length in cm"));
        switch (data.get(0).get("Pendant")){
            case "Ladybug":sjp.selectLadybug();break;
            case "Heart":sjp.selectHeart();break;
            case "Star":sjp.selectStar();break;
            case "None":sjp.selectNone();break;
            default:sjp.selectNone();
        }
        sjp.enterQtyNumber(data.get(0).get("Qty"));
        ScreenshotUtils.capture("user_fill_out_following_fields");
    }

    @When("And the user adds the item to the cart")
    public void and_the_user_adds_the_item_to_the_cart() {
       sjp.setAddToCart();
    }
    @When("user click on the shopping cart button")
    public void user_click_on_the_shopping_cart_button() {
        sjp.clickOnShoppingCartLink();
    }
    @Then("user should be on Shopping cart page")
    public void user_should_be_on_shopping_cart_page() {
         Assert.assertEquals(sjp.getShoppingCartText(),"Shopping cart");
    }


}
