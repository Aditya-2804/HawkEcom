package TestCases;

import BaseClass.BaseClass;
import DriverActions.DriverActions;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.yourCartPage;
import Utilities.Logs;
import Utilities.Utils;
import com.google.common.collect.Ordering;
import org.apache.logging.log4j.core.config.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.List;

import static DriverActions.DriverActions.CurrentWinHandler;

public class homePageTestCases extends BaseClass {

    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void Setup() throws Exception{
        LaunchBrowser();
    }
    public LoginPage loginPage;
    public HomePage homePage;
    public yourCartPage yourCartPage;


    public void NavidateToHomePage() throws Exception{
        loginPage = new LoginPage();
        DriverActions.waitForSeconds(3);
        loginPage.Login(Utils.getConfigUserName(),Utils.getConfigPassword());
        DriverActions.waitForSeconds(3);
    }

    @Test
    public void testiFrames() throws Exception{
        getDriver().get(utils.getConfigURLTestPage());
        WebElement button = getDriver().findElement(By.id(""));
        button.click();

        WebElement iframe = getDriver().findElement(By.xpath(""));
    }

    @Test(groups = "Sanity")
    public void ValidateHeader() throws Exception{
        NavidateToHomePage();
        homePage = new HomePage();
        String[] ExpecetdMenuList={"All Items","About","Logout","Reset App State"};
        List<String> list = Arrays.asList(ExpecetdMenuList);

        Logs.info("Validating the  logo");
        homePage.ValidateLogo("Swag Labs");

        Logs.info("Validating the Menu Items");
//        homePage.MenuClick();
        homePage.ValidateMenuList(list);
        homePage.CloseMenuNav();

        Logs.info("Validating the Shopping Cart Button");
        yourCartPage = homePage.ValidateShopingCartButton();
        yourCartPage.ValidateTitle("Your Cart");
        DriverActions.navigateBack();
    }

    @Test(groups = {"Smoke","Sanity"})
    public void VallidateSecondaryHeader() throws Exception{

        NavidateToHomePage();
        String[] expectedSortOptions = {"Name (A to Z)","Name (Z to A)","Price (low to high)","Price (high to low)"};
        List<String> ExpectedOptions = Arrays.asList(expectedSortOptions);

        homePage = new HomePage();
        homePage.ValidateSortOptions(ExpectedOptions);

        Logs.info("Validating Price (low to high) Sort");
        Logs.info("Is Items Sorted from Price (low to high)v: "+Ordering.natural().isOrdered(homePage.validatePriceLotToHigh()));

        Logs.info("Validaating Price (high to low) sort");
        Logs.info("Is Items Sorted from Price (high to low): "+Ordering.natural().reverse().isOrdered(homePage.validatePriceHighToLow()));

        Logs.info("validating Name (A to Z) Sort");
        Logs.info("is Items Sorted From Name (A to Z): "+Ordering.natural().isOrdered(homePage.validateNameAtoZ()));

        Logs.info("validating Name (Z to A) Sort");
        Logs.info("is Items Sorted From Name (Z to A): "+ Ordering.natural().reverse().isOrdered(homePage.validateNameZtoA()));

    }

    @Test(groups = "Smoke")
    public void ValidateFooter() throws Exception{

        NavidateToHomePage();
        String CurrentWinHandler = CurrentWinHandler();
        homePage = new HomePage();

        String TwitterLink = homePage.twitterlink();
        String FacebookLink = homePage.facebooklink();
        String LinnkedInLink = homePage.linkedinlink();

        homePage.twitterClick();
        getDriver().switchTo().window(CurrentWinHandler);
        homePage.facebookClick();
        getDriver().switchTo().window(CurrentWinHandler);
        homePage.linkedinClick();
        getDriver().switchTo().window(CurrentWinHandler);

        DriverActions.waitForSeconds(5);
        for (String windowHandle : getDriver().getWindowHandles()) {
            if (!windowHandle.equals(CurrentWinHandler)){
                getDriver().switchTo().window(windowHandle);
                Thread.sleep(1);
                if (getDriver().getTitle().equals("X")){
                    Assert.assertEquals(TwitterLink,getDriver().getCurrentUrl());
                    Logs.info("Verifying Twitter Link with Actual Link: "+getDriver().getCurrentUrl());
                }
                if (getDriver().getTitle().equals("Sauce Labs | San Francisco CA | Facebook")) {
                    Assert.assertEquals(FacebookLink,getDriver().getCurrentUrl());
                    Logs.info("Verifying Facebook Link with Actual Link: "+getDriver().getCurrentUrl());
                }
                if (getDriver().getTitle().equals("Sauce Labs | LinkedIn")){
                    Assert.assertEquals(LinnkedInLink,getDriver().getCurrentUrl());
                    Logs.info("Verifying LinkedIn Link with Actual Link: "+getDriver().getCurrentUrl());
                }
            }
        }
    }

    @AfterMethod(groups = {"Sanity","Smoke","Regression"})
    public void Teardown(){
        CloseBrowser();
    }


}
