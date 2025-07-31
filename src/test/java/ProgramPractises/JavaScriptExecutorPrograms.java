package ProgramPractises;

import Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class JavaScriptExecutorPrograms {

    public static void main(String[] args) throws Exception{

        WebDriver driver = setUp("https://www.saucedemo.com/");
        loginToSauceLabs(driver);
        Thread.sleep(2*1000);
//        System.out.println("Scrolling now");
//        scrollByJSE(driver,0,600);
        clickByJSE(driver);


    }

    private static void loginToSauceLabs(WebDriver driver) throws Exception {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2*1000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    private static void scrollByJSE(WebDriver driver, int x, int y) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy("+x+","+y+")");
        System.out.println("Scrolled");
    }

    private static void clickByJSE(WebDriver driver){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.id("shopping_cart_container"));
        jse.executeScript("arguments[0].click();",element);
    }

    public static WebDriver setUp(String URL){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        return driver;
    }


}
