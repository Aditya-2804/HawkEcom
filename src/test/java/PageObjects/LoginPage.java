package PageObjects;

import BaseClass.BaseClass;
import DriverActions.DriverActions;
import Utilities.Logs;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BaseClass {

    DriverActions actions = new DriverActions();

    @FindBy(xpath = "//div[@class='login_logo']")
    WebElement loginlogo;

    @FindBy(id = "user-name")
    WebElement LoginUserName;

    @FindBy(id = "password")
    WebElement loginPassword;

    @FindBy(id = "login-button")
    WebElement LoginButton;

    @FindBy(xpath = "//div[@class='login_credentials']/h4")
    WebElement UsernameAcceptedLabel;

    @FindBy(xpath = "//div[@class='login_credentials']/br")
    WebElement AcceptedUsername;

    @FindBy(xpath = "//div[@class='login_password']/h4")
    WebElement PasswordAcceptedLabel;

    @FindBy(xpath = "//div[@class='login_password']")
    WebElement AcceptedPasswordlist;

    @FindBy(xpath = "//div[@class='login_credentials']")
    WebElement AcceptedUsersList;


    public LoginPage(){
        PageFactory.initElements(getDriver(),this);
    }


    public void ValidateTitle(String ExpectedHeading){
        Assert.assertEquals(loginlogo.getText(),ExpectedHeading);
        Logs.info("Validating the Title");

    }

    public void ValidateUserNamePlaceholder(String ExpectedPlaceHolder){
        Assert.assertEquals(LoginUserName.getAttribute("placeholder"),ExpectedPlaceHolder);
        Logs.info("Validating the User PlaceHolder");
    }

    public void ValidatePasswordPlaceholder(String ExpectedPlaceHolder){
        Assert.assertEquals(loginPassword.getAttribute("placeholder"),ExpectedPlaceHolder);
        Logs.info("Validating the Password PlaceHolder");
    }

    public void ValidateLogoCssValues() throws Exception{
        Thread.sleep(5*1000);
        String fontsize = loginlogo.getCssValue("font-size");
        String fontfamily = loginlogo.getCssValue("font-family");
        String lineheight = loginlogo.getCssValue("line-height");
        String textalign = loginlogo.getCssValue("text-align");
        String backgroundcolor = loginlogo.getCssValue("background-color");
        String color = loginlogo.getCssValue("color");
        String height = loginlogo.getCssValue("height");

        System.out.println("fontSize : "+fontsize+"\nFontFamily :"+fontfamily+"\nlineheight :"+lineheight+"\ntextalign : "
                +textalign+"\nbackgroundcolor : "+backgroundcolor+"\ncolor :"+color+"\nheight :"+height);
    }

    public void Login(String userName, String password) throws Exception{

        LoginUserName.sendKeys(userName);
        loginPassword.sendKeys(password);

        LoginButton.click();
        actions.waitForSeconds(5);
    }

    public void validateUsernameAcceptedLabel(String Expected){
        Logs.info("Validating the UserNames Acceped labels");
        Assert.assertEquals(UsernameAcceptedLabel.getText(),Expected);
    }

    public void validatePasswordAcceptedLabel(String Expected){
        Logs.info("Validating the UserNames Acceped labels");
        Assert.assertEquals(PasswordAcceptedLabel.getText(),Expected);
    }

    public String AcceptedUsersList(){
        return AcceptedUsersList.getText();
    }

    public String AcceptedPasswordList(){
        return AcceptedPasswordlist.getText();
    }

    public void Test(){
        System.out.println("Testing the usernames :"+AcceptedUsername);
    }

}
