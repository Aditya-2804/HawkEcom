package TestCases;

import BaseClass.BaseClass;
import DriverActions.DriverActions;
import PageObjects.CheckoutInfoPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.yourCartPage;
import Utilities.Logs;
import Utilities.Utils;
import org.testng.Assert;
import org.testng.annotations.*;

import static DriverActions.DriverActions.CurrentWinHandler;

public class YourCartTestcases extends BaseClass {

    private LoginPage loginPage;
    private HomePage homePage;
    private yourCartPage yourCartPage;

    String ProductName;
    String ProductDesc;
    String ProductPrice;

    boolean cartEmpty;

    private CheckoutInfoPage checkoutInfoPage;

    @BeforeMethod(groups = {"Sanity","Smoke","Regression"})
    public void Setup() throws Exception{
        LaunchBrowser();
    }

    @AfterMethod(groups = {"Sanity","Smoke","Regression"})
    public void Teardown(){
        CloseBrowser();
    }

    public void NavigatetoCart() throws Exception{
        loginPage = new LoginPage();
        loginPage.Login(Utils.getConfigUserName(),Utils.getConfigPassword());
        homePage = new HomePage();

        ProductName = homePage.getfirstProductName();
        ProductDesc = homePage.getFirstProductDesc();
        ProductPrice = homePage.getFirstProductPrice();

        cartEmpty=homePage.isCartEmpty();
        if (cartEmpty){
            homePage.FirstProductAddtocartClick();
            yourCartPage = homePage.ValidateShopingCartButton();
        }else {
            yourCartPage = homePage.ValidateShopingCartButton();
        }
        DriverActions.waitForSeconds(3);

    }

    @Test(groups = "Sanity")
    public void ValidateHeader() throws Exception{

        NavigatetoCart();
        yourCartPage.ValidateTitle("Your Cart");
        yourCartPage.ValidateHeaderCartitemsCount();



//        checkoutInfoPage = yourCartPage.checkOutClick();
    }


    @Test(groups = "Smoke")
    public void ValidateCartItems() throws Exception{

        NavigatetoCart();

        if (cartEmpty){
           yourCartPage.validateItemName(ProductName);
           yourCartPage.validateItemDesc(ProductDesc);
           yourCartPage.validateItemPrice(ProductPrice);
        }
        int totalNumberOfItems = yourCartPage.getTotaCartItems();

        for (int i = 0; i < totalNumberOfItems; i++) {
            yourCartPage.cartItemRemoveClick();
            DriverActions.waitForSeconds(1);
        }

        Logs.info("Validate if the Cart is Empty, Total items in the cart is: "+yourCartPage.getitemsPresentInCart());
        homePage = yourCartPage.continueShoppingCllick();
        Logs.info("Navigate to the Home Page");
        homePage.validateTitle("Products");
        homePage.firstProductClick();
    }

    @Test(groups = "Smoke")
    public void ValidateFooter() throws Exception{

        NavigatetoCart();
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

}
