package TestCases;

import BaseClass.BaseClass;
import DriverActions.DriverActions;
import PageObjects.*;
import Utilities.Logs;
import Utilities.Utils;
import org.testng.Assert;
import org.testng.annotations.*;

public class CheckInfoTestcases extends BaseClass {


    LoginPage loginPage;
    HomePage homePage;
    yourCartPage yourCartPage;
    CheckoutInfoPage checkoutInfoPage;
    CheckoutOverviewPage checkoutOverviewPage;




    @BeforeMethod(groups = {"Sanity","Smoke","Regression"})
    public void Setup() throws Exception{
        LaunchBrowser();
    }

    @AfterMethod(groups = {"Sanity","Smoke","Regression"})
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
