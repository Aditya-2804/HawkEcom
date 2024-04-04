package PageObjects;

import BaseClass.BaseClass;
import Utilities.Logs;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutInfoPage extends BaseClass {


    @FindBy(xpath = "//div[@class='header_label']")
    WebElement Logo;

    @FindBy(xpath = "//span[@class='title']")
    WebElement Title;


    @FindBy(id = "first-name")
    WebElement firstnameInput;
    @FindBy(id = "last-name")
    WebElement lastnameInput;
    @FindBy(id = "postal-code")
    WebElement postalcodeInput;

    @FindBy(id = "cancel")
    WebElement cancelButton;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(xpath = "//h3")
    WebElement errorButton;






    public CheckoutInfoPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public void validateLogo(String ExpectedLogo){
        Logs.info("Validating Logo Actual :"+Logo.getText()+" Expected: "+ExpectedLogo);
        Assert.assertEquals(Logo.getText(),ExpectedLogo);
    }

    public void validateTitle(String ExpectedTitle){
        Logs.info("Validating Title Actual :"+Title.getText()+" Expected: "+ExpectedTitle);
        Assert.assertEquals(Title.getText(),ExpectedTitle);
    }


    public void setFirstName(String Fname){
        Logs.info("Setting FirstName to :"+Fname);
        firstnameInput.sendKeys(Fname);
    }
    public void clearFirstName(){
        firstnameInput.clear();
    }

    public void setLastnameInput(String Lname){
        Logs.info("Setting Lname to :"+Lname);
        lastnameInput.sendKeys(Lname);
    }

    public void clearLasttName(){
        lastnameInput.clear();
    }

    public void setPostalcodeInput(String postal){
        Logs.info("Setting postal to :"+postal);
        postalcodeInput.sendKeys(postal);
    }

    public void clearPostalcodeInput(){
        postalcodeInput.clear();
    }

    public void fillIntheInfo(String Fname,String Lname, String Postal){

        firstnameInput.sendKeys(Fname);
        lastnameInput.sendKeys(Lname);
        postalcodeInput.sendKeys(Postal);

    }

    public void validateFirstNamePlaceholder(String ExpectedFName){
        Logs.info("validateFirstNamePlaceholder Actual: "+firstnameInput.getText()+" Expected: "+ExpectedFName);
        Assert.assertEquals(firstnameInput.getText(),ExpectedFName);
    }

    public void validateLastNamePlaceholder(String ExpectedLName){
        Logs.info("validateLastNamePlaceholder Actual: "+lastnameInput.getText()+" Expected: "+ExpectedLName);
        Assert.assertEquals(lastnameInput.getText(),ExpectedLName);
    }

    public void validatepostalPlaceholder(String ExpectedPostal){
        Logs.info("validatepostalPlaceholder Actual: "+postalcodeInput.getText()+" Expected: "+ExpectedPostal);
        Assert.assertEquals(postalcodeInput.getText(),ExpectedPostal);
    }

    public String getErrorMeassage(){
        return errorButton.getText();
    }

    public yourCartPage cancelClick(){
        cancelButton.click();
        return new yourCartPage();
    }

    public CheckoutOverviewPage continueClick(){
        continueButton.click();
        return new CheckoutOverviewPage();
    }




}
