package TestCases;

import BaseClass.BaseClass;
import DriverActions.DriverActions;
import PageObjects.*;
import Utilities.Logs;
import Utilities.Utils;
import org.testng.annotations.*;

public class EndToEndTestcase extends BaseClass {

    LoginPage loginPage;
    HomePage homePage;
    yourCartPage yourCartPage;
    CheckoutInfoPage checkoutInfoPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutCompletePage checkoutCompletePage;

    @BeforeMethod(groups = {"Sanity","Smoke","Regression"})
    public void Setup() throws Exception{
        LaunchBrowser();
    }

    @Test
    public void Login() throws Exception{

        Logs.startTestcase("End To End Testcase");
        Logs.info("Loging in using admins credentials");
        loginPage = new LoginPage();
        loginPage.Login(Utils.getConfigUserName(), Utils.getConfigPassword());
        homePage = new HomePage();
        DriverActions.waitForSeconds(3);
    }

    @Test(dependsOnMethods = "Login")
    public void addItemToCart() throws Exception{

        homePage.validateTitle("Products");

        Logs.info("Checking if the cart is empty or not from HomePage");
        if (homePage.isCartEmpty()){
            homePage.FirstProductAddtocartClick();
        }
        yourCartPage = homePage.ValidateShopingCartButton();
        DriverActions.waitForSeconds(3);
        Logs.info("Navigating to Your Cart Page");


        yourCartPage.ValidateTitle("Your Cart");
        checkoutInfoPage = yourCartPage.checkOutClick();
        DriverActions.waitForSeconds(3);
    }

    @Test(dependsOnMethods = "addItemToCart")
    public void Checkout() throws Exception{

        Logs.info("Navigating to Checkout: Your Information Page");
        checkoutInfoPage.validateTitle("Checkout: Your Information");
        Logs.info("Filling in the information");
        checkoutInfoPage.setFirstName("Aditya");
        checkoutInfoPage.setLastnameInput("N");
        checkoutInfoPage.setPostalcodeInput("431001");

        checkoutOverviewPage = checkoutInfoPage.continueClick();
        DriverActions.waitForSeconds(3);
        Logs.info("Navigating to Checkout: Overview Page");

        checkoutOverviewPage.validateTitle("Checkout: Overview");
        checkoutCompletePage = checkoutOverviewPage.finishClick();
        DriverActions.waitForSeconds(3);


        Logs.info("Navigating to Checkout: Complete! Page");
        checkoutCompletePage.validateTitle("Checkout: Complete!");
        checkoutCompletePage.validateHeaading("Thank you for your order!");
        checkoutCompletePage.validatecompleteText("Your order has been dispatched, and will arrive just as fast as the pony can get there!");

        homePage = checkoutCompletePage.backHomeClick();
    }

    @AfterClass(groups = {"Sanity","Smoke","Regression"})
    public void Teardown(){
        CloseBrowser();
    }
//
//    @AfterSuite
//    public void TearDown(){
//        CloseBrowser();
//    }
}
