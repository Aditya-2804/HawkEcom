package BaseClass;

import DriverActions.DriverActions;
import Utilities.ExtentManager;
import Utilities.Logs;
import Utilities.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.builder.api.PropertyComponentBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class BaseClass {

//    public static WebDriver driver;

    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    public static Utils utils= new Utils();


    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void LaunchBrowser() throws Exception{
        WebDriverManager.edgedriver().setup();
//        if (driver==null){
            if (utils.getConfigBrowser().equalsIgnoreCase("edge")){
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                Logs.Debug("Launch Edge Browser Launchung");
            }
            if (utils.getConfigBrowser().equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
            }
            if (utils.getConfigBrowser().equalsIgnoreCase("safari")){
                WebDriverManager.safaridriver().setup();
                driver.set(new SafariDriver());
            }
//        }
        getDriver().get(utils.getConfigURLEcom());
        getDriver().manage().window().maximize();
    }

    @BeforeSuite
    public void setExtentReport(){
        ExtentManager.setExtent();
    }

    @AfterSuite
    public void endReport(){
        ExtentManager.endReport();
    }

    public static void CloseBrowser(){
        if (driver != null){
            getDriver().quit();
        }
    }



}
