package TestCases;

import BaseClass.BaseClass;
import PageObjects.LoginPage;
import Utilities.Logs;
import Utilities.Utils;
import com.google.common.collect.Ordering;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class logInPagecases extends BaseClass {

    public LoginPage loginPage;

    @BeforeMethod(groups = {"Sanity","Smoke","Regression"})
    public void setUp() throws Exception{
        LaunchBrowser();
    }


    @Test(groups = "Smoke")
    public void ValidateLogo() throws Exception{

        loginPage = new LoginPage();
        loginPage.ValidateLogoCssValues();

        loginPage.ValidateTitle("Swag Labs");
        loginPage.ValidateUserNamePlaceholder("Username");
        loginPage.ValidatePasswordPlaceholder("Password");

        System.out.println("Accepted Passwords: "+loginPage.AcceptedPasswordList());
        System.out.println("Accepted UserNames: "+loginPage.AcceptedUsersList());
    }
//

//    @Test
//    public void test(){
//        List<String> list  =new ArrayList<>();
//
//
//
//        list.add("A");
//        list.add("B");
//        list.add("C");
//        list.add("D");
//        list.add("E");
//
//        list.forEach(test-> System.out.println("Test"+test));
//
//        System.out.println("Is it Sorted  : "+Ordering.natural().isOrdered(list));
//
//
//
//    }
//
@Test(groups = "Sanity")
public void ValidateAccepedUsersAndPasswordslabel(){
        loginPage = new LoginPage();
        loginPage.validateUsernameAcceptedLabel("Accepted usernames are:");
        loginPage.validatePasswordAcceptedLabel("Password for all users:");
    }

@Test(dependsOnMethods = "ValidateAccepedUsersAndPasswordslabel",groups = {"Sanity","Smoke"})
public void Login() throws Exception{
        loginPage.Login(Utils.getConfigUserName(), Utils.getConfigPassword());
    }


    @AfterMethod(groups = {"Sanity","Smoke","Regression"})
    public void Teardown(){
        CloseBrowser();
    }

//    @BeforeTest
//    public void BeforeTest(){
//        System.out.println("BeforeTest");
//    }
//
//    @AfterTest
//    public void AfterTest(){
//        System.out.println("AfterTest");
//    }
//    @BeforeMethod
//    public void BeforeMethod(){
//        System.out.println("BeforeMethod");
//    }
//    @AfterMethod
//    public void AfterMethod(){
//        System.out.println("AfterMethod");
//    }
//    @BeforeSuite
//    public void BeforeSuite(){
//        System.out.println("BeforeSuite");
//    }
//    @AfterSuite
//    public void AfterSuite(){
//        System.out.println("AfterSuite");
//    }
//    @Test
//    public void Test(){
//        System.out.println("======Test");
//    }
//
//    @Test
//    public void Test2(){
//        System.out.println("======Test2");
//    }
//
//    @BeforeClass
//    public void BeforeClass(){
//        System.out.println("BeforeClass");
//    }
//
//    @AfterClass
//    public void AfterClass(){
//        System.out.println("AfterClass");
//    }


}
