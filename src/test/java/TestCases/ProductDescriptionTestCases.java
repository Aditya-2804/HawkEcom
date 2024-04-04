package TestCases;

import BaseClass.BaseClass;
import DriverActions.DriverActions;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.ProductDescriptionPage;
import PageObjects.yourCartPage;
import Utilities.Logs;
import Utilities.Utils;
import org.testng.Assert;
import org.testng.annotations.*;

import static DriverActions.DriverActions.CurrentWinHandler;

public class ProductDescriptionTestCases extends BaseClass {

    @BeforeMethod(groups = {"Sanity","Smoke","Regression"})
    public void Setup() throws Exception{
        LaunchBrowser();
    }
    public LoginPage loginPage;
    public HomePage homePage;
    public PageObjects.yourCartPage yourCartPage;
    public ProductDescriptionPage productDescriptionPage;
    String productName;
    String productDesc;
    String productPrice;



    public void NavigateToProductDesc() throws Exception{

        Logs.startTestcase("Product Description");
        loginPage = new LoginPage();
        DriverActions.waitForSeconds(3);
        loginPage.Login(Utils.getConfigUserName(),Utils.getConfigPassword());
        DriverActions.waitForSeconds(3);
        homePage = new HomePage();
        productName = homePage.getfirstProductName();
        productDesc = homePage.getFirstProductDesc();
        productPrice = homePage.getFirstProductPrice();
        productDescriptionPage = homePage.firstProductClick();
    }

    @Test(groups = "Sanity")
    public void ValidateHeader() throws Exception{

        NavigateToProductDesc();
        productDescriptionPage.ValidateTitle("Swag Labs");
        Logs.info("Validating Title");

        DriverActions.waitForSeconds(2);
        productDescriptionPage.validateCartHeaderCount();

        yourCartPage = productDescriptionPage.CartHeaderClick();
        DriverActions.waitForSeconds(2);
        yourCartPage.ValidateTitle("Your Cart");
        Logs.info("Validating the navigating to the cart page");
        DriverActions.navigateBack();
        DriverActions.waitForSeconds(2);

        Logs.info("Validating Back to Products Button");
        homePage = productDescriptionPage.backToProductClick();
        homePage.ValidateLogo("Swag Labs");
        DriverActions.waitForSeconds(2);
        homePage.firstProductClick();
        DriverActions.waitForSeconds(2);

    }

    @Test(dependsOnMethods = "ValidateHeader", groups = "Smoke")
    public void Validateproduct() throws Exception{

        NavigateToProductDesc();
        Logs.info("Validating the products Name, Desc and Price");
        productDescriptionPage.vallidateName(productName);
        productDescriptionPage.vallidateDesc(productDesc);
        productDescriptionPage.vallidatePrice(productPrice);

        Logs.info("Validating add or remove Button");
        productDescriptionPage.ValidateAddToRemoveFromCartButton();
    }


    @Test(dependsOnMethods = "Validateproduct",groups = "Smoke")
    public void ValidateFooter() throws Exception{

        NavigateToProductDesc();
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
