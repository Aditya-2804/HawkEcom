package TestCases;

import BaseClass.BaseClass;
import DriverActions.DriverActions;
import PageObjects.*;
import Utilities.Logs;
import Utilities.Utils;
import org.testng.annotations.*;

public class CheckoutOverViewTestCases extends BaseClass {

    public LoginPage loginPage;
    public HomePage homePage;
    public yourCartPage yourCartPage;

    public CheckoutInfoPage checkoutInfoPage;

    public CheckoutOverviewPage checkoutOverviewPage;


    @BeforeMethod(groups = {"Sanity","Smoke","Regression"})
    public void SetUp() throws Exception{
        LaunchBrowser();
    }
    @AfterMethod(groups = {"Sanity","Smoke","Regression"})
    public void Teardown(){
        CloseBrowser();
    }




    public void navigateToCheckoutOverView() throws Exception{

        loginPage = new LoginPage();
        loginPage.Login(Utils.getConfigUserName(),Utils.getConfigPassword());
        homePage = new HomePage();


        if (homePage.isCartEmpty()){
            homePage.FirstProductAddtocartClick();
        }
        DriverActions.waitForSeconds(5);
        yourCartPage = homePage.ValidateShopingCartButton();
        DriverActions.waitForSeconds(3);

        checkoutInfoPage = yourCartPage.checkOutClick();
        DriverActions.waitForSeconds(3);

        checkoutInfoPage.fillIntheInfo("Aditya","N","431007");

        checkoutOverviewPage = checkoutInfoPage.continueClick();

    }

    @Test(groups = "Sanity")
    public void validateheader() throws Exception{

        navigateToCheckoutOverView();
        checkoutOverviewPage.validateTitle("Checkout: Overview");


    }

    @Test(groups = {"Smoke","Regression"})
    public void validateTaxAndTotal() throws Exception{

        navigateToCheckoutOverView();
        checkoutOverviewPage.validateSubTotal();
        checkoutOverviewPage.validateTax();
        checkoutOverviewPage.validateTotal();

        homePage = checkoutOverviewPage.cancelClick();
        Logs.info("Heading to Home Page");
        homePage.validateTitle("Products");

    }

}
