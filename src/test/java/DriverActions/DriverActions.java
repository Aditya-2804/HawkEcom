package DriverActions;

import BaseClass.BaseClass;
import Utilities.Logs;
import org.apache.commons.io.FileUtils;
import org.apache.velocity.texen.util.FileUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DriverActions extends BaseClass {

    public static void waitForSeconds(int durationInSec) throws Exception{
        Thread.sleep(durationInSec * 1000L);
    }
    
    public static void MoveToElement(WebElement to){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(to).build().perform();
    }

    public static void jseClick(WebElement element){

        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].click()",getDriver());
    }

    public static void navigateBack(){
        getDriver().navigate().back();
    }

    public static void navigateForward(){
        getDriver().navigate().forward();
        Logs.info("Forwarding....");
    }


    public static String CurrentWinHandler(){
        Logs.info("Getting CurrentWindow Handler :"+getDriver().getWindowHandle());
        return getDriver().getWindowHandle();
    }

    public static String screenShot(WebDriver webDriver, String filename){
        String datename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir")+"\\ScreenShots\\"+filename+"_"+datename+".png";

        try{
            FileUtils.copyFile(source,new File(destination));
        }catch (Exception e){
            e.getMessage();
        }


        return destination;
    }

    public static void switchToChildTab(){
//        driver.getWindowHandles().forEach(handler-> );
        getDriver().getWindowHandles().forEach(child -> getDriver().switchTo().window(child));
    }
}
