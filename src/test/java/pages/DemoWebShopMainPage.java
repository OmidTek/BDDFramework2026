package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoWebShopMainPage {
   private WebDriver driver;
   public DemoWebShopMainPage(WebDriver driver){
       this.driver=driver;
   }

   private By headerLoginBtn=By.linkText("Log in");
   private By welcomeSignIn=By.tagName("h1");
   private By emailBox=By.cssSelector("#Email");
   private By passwordBox=By.name("Password");
   private By submitBtn=By.xpath("//input [@value='Log in']");
   private By acountInfoHeader=By.xpath("//*[@class='header-links']//a[@class='account']");





   public void clickHeaderLoginBtn(){
       driver.findElement(headerLoginBtn).click();
   }

   public String getWelcomeSignInText(){
      return driver.findElement(welcomeSignIn).getText();
   }

   public void enterEmailBox(String email){
       driver.findElement(emailBox).sendKeys(email);
   }

   public void enterPassword(String password){
       driver.findElement(passwordBox).sendKeys(password);
   }

   public void clickOnSubmitBtn(){
       driver.findElement(submitBtn).click();
   }

    public String getAccountInfoText(){
        return driver.findElement(acountInfoHeader).getText();
    }

}
