package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

import java.time.Duration;

public class SwagLabsLoginPage {

    private WebDriver driver;


    public SwagLabsLoginPage(WebDriver driver){
        this.driver=driver;}


    private By userNameBox= By.id("user-name");
    private By passwordBox=By.id("password");
    private By loginBtn=By.id("login-button");
    private By headerText=By.className("app_logo");
    private By burgerMenuBtn=By.id("react-burger-menu-btn");
    private By logoutBtn= By.id("logout_sidebar_link");


    public void enterUserNameAndPassword(String user,String pass)   {
        driver.findElement(userNameBox).sendKeys(user);
        driver.findElement(passwordBox).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
    public String getHeaderText(){
        return driver.findElement(headerText).getText();
    }
    public void clickOnBurgerMenu(){
        driver.findElement(burgerMenuBtn).click();
    }

    public void clickOnLogout() {

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(logoutBtn)));
        WaitUtils wait=new WaitUtils(driver);
        wait.waitForVisibility(logoutBtn);
        driver.findElement(logoutBtn).click();
    }

}
