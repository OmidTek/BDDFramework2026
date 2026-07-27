package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ShoppingJewelryPage {

    private WebDriver driver;

    public ShoppingJewelryPage(WebDriver driver) {
        this.driver = driver;
    }

    private By menuJewelryBtn = By.xpath("//ul[@class='top-menu']//a[starts-with(text(),'Jewelry')]");
    private By createOwnBtn = By.xpath("//h2/a[text()='Create Your Own Jewelry']");
    private By pageHeader = By.tagName("h1");
    private By product_attribute_71_9_15 = By.id("product_attribute_71_9_15");
    private By lengthBox = By.id("product_attribute_71_10_16");
    private By radioBtnLadybug = By.cssSelector("input#product_attribute_71_11_17_48");
    private By radioBtnHeart = By.cssSelector("input#product_attribute_71_11_17_49");
    private By radioBtnStar = By.cssSelector("input#product_attribute_71_11_17_50");
    private By radioBtnNone = By.cssSelector("input#product_attribute_71_11_17_51");
    private By qtyBox = By.cssSelector("input#addtocart_71_EnteredQuantity");
    private By addToCartBtn = By.cssSelector("input#add-to-cart-button-71");
    private By shoppingCartLink=By.xpath("//span[text()='Shopping cart']/parent::a");
    private By shoppinpPageHeader=By.tagName("h1");

    public void clickOnJewelryBtn() {
        driver.findElement(menuJewelryBtn).click();
    }

    public void clickOnCreateYourOwnJewelry() {
        driver.findElement(createOwnBtn).click();
    }

    public String getPageHeaderText() {
        return driver.findElement(pageHeader).getText();
    }

    public void selectMatrial(String matrial) {
        Select select = new Select(driver.findElement(product_attribute_71_9_15));
        select.selectByContainsVisibleText(matrial);
    }

    public void enterLength(String l) {
        driver.findElement(lengthBox).sendKeys(l);
    }

    public void selectLadybug() {
        driver.findElement(radioBtnLadybug).click();
    }

    public void selectStar() {
        driver.findElement(radioBtnStar).click();
    }

    public void selectHeart() {
        driver.findElement(radioBtnHeart).click();
    }

    public void selectNone() {
        driver.findElement(radioBtnNone).click();
    }

    public void enterQtyNumber(String num) {
        driver.findElement(qtyBox).clear();
        driver.findElement(qtyBox).sendKeys(num);
    }

    public void setAddToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public void clickOnShoppingCartLink(){
        driver.findElement(shoppingCartLink).click();
    }
    public String getShoppingCartText(){
        return driver.findElement(shoppinpPageHeader).getText();
    }



}