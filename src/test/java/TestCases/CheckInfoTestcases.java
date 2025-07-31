package TestCases;

import BaseClass.BaseClass;
import DriverActions.DriverActions;
import PageObjects.*;
import Utilities.Logs;
import Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CheckInfoTestcases extends BaseClass {


    LoginPage loginPage;
    HomePage homePage;
    yourCartPage yourCartPage;
    CheckoutInfoPage checkoutInfoPage;
    CheckoutOverviewPage checkoutOverviewPage;




    @BeforeMethod(alwaysRun = true)
    public void Setup() throws Exception{
        LaunchBrowser();
    }

    @AfterMethod(alwaysRun = true)
    public void Teardown(){
        CloseBrowser();
    }


    public void NavigateToCheckout() throws Exception{

        loginPage = new LoginPage();
        loginPage.Login(Utils.getConfigUserName(),Utils.getConfigPassword());
        homePage = new HomePage();


        if (homePage.isCartEmpty()){
            homePage.FirstProductAddtocartClick();
            yourCartPage = homePage.ValidateShopingCartButton();
        }else {
            yourCartPage = homePage.ValidateShopingCartButton();
        }
        DriverActions.waitForSeconds(3);

        checkoutInfoPage = yourCartPage.checkOutClick();
        DriverActions.waitForSeconds(3);

    }

//    @Test
    public void interviewPreparation() throws Exception{
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.co.in/");
        WebElement searchGoogle = driver.findElement(By.id("APjFqb"));
        searchGoogle.sendKeys("interview preparation");
        searchGoogle.sendKeys(Keys.ENTER);

        Thread.sleep(3*1000);
        WebElement page3 = driver.findElement(By.xpath("//a[@aria-label='Page 3']"));
        page3.click();

        WebElement link4 = driver.findElement(By.xpath("//div[@id='rso']/div[4]//a"));
        String url4 = link4.getAttribute("href");


       /* Response response = RestAssured()
       .geiven(url
       .then
       Asssert
       .statuscode(200)

*/
        driver.get(url4);


    }


    @Test(groups = "Sanity")
    public void ValidateHeader() throws Exception{

        NavigateToCheckout();
        checkoutInfoPage.validateLogo("Swag Labs");
        checkoutInfoPage.validateTitle("Checkout: Your Information");
    }

    @Test(groups = {"Sanity","Smoke"})
    public void ValidateBody() throws Exception{

        NavigateToCheckout();
        checkoutInfoPage.clearFirstName();
        checkoutInfoPage.clearLasttName();
        checkoutInfoPage.clearPostalcodeInput();

        checkoutInfoPage.continueClick();

        Logs.info("Validating the Error Message on empty Fields");
        Assert.assertEquals(checkoutInfoPage.getErrorMeassage(),"Error: First Name is required");

        checkoutInfoPage.setFirstName("Aditya");

        checkoutInfoPage.continueClick();

        Logs.info("Validating the Error Message on empty LastName Fields");
        Assert.assertEquals(checkoutInfoPage.getErrorMeassage(),"Error: Last Name is required");

        checkoutInfoPage.setLastnameInput("N");

        checkoutInfoPage.continueClick();

        Logs.info("Validating the Error Message on empty Postal Fields");
        Assert.assertEquals(checkoutInfoPage.getErrorMeassage(),"Error: Postal Code is required");


        checkoutInfoPage.setPostalcodeInput("43101");

        checkoutOverviewPage =checkoutInfoPage.continueClick();

    }
}
