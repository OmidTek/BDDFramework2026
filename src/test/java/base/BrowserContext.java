package base;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrowserContext {

     private static String browserName ;

    @Parameters("browser")
    @Test
    public static void setBrowser(String browser) {
        browserName=browser;
    }
    public static  String getBrowser() {
       return browserName;
    }
}
