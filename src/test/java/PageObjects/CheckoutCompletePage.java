package PageObjects;

import BaseClass.BaseClass;
import Utilities.Logs;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutCompletePage extends BaseClass {


    @FindBy(xpath = "//div[@class='header_label']")
    WebElement Logo;

    @FindBy(xpath = "//span[@class='title']")
    WebElement Title;

    @FindBy(xpath = "//h2[@class=\"complete-header\"]")
    WebElement thankYouHeading;

    @FindBy(xpath = "//div[@class=\"complete-text\"]")
    WebElement completeText;

    @FindBy(id = "back-to-products")
    WebElement backHomeButton;


    public void validateLogo(String ExpectedLogo){
        Logs.info("Validating LOGO Actual: "+Logo.getText()+" Expected: "+ExpectedLogo);
        Assert.assertEquals(Logo.getText(),ExpectedLogo);
    }

    public void validateTitle(String ExpectedTitle){
        Logs.info("Validating Title Actual: "+Title.getText()+" Expected: "+ExpectedTitle);
        Assert.assertEquals(Title.getText(),ExpectedTitle);
    }

    public void validateHeaading(String ExpectedHeading){
        Logs.info("Validating thankYouHeading Actual: "+thankYouHeading.getText()+" Expected: "+ExpectedHeading);
        Assert.assertEquals(thankYouHeading.getText(),ExpectedHeading);
    }

    public void validatecompleteText(String ExpectedAllText){
        Logs.info("Validating AllText Actual: "+completeText.getText()+" Expected: "+ExpectedAllText);
        Assert.assertEquals(completeText.getText(),ExpectedAllText);
    }

    public HomePage backHomeClick(){
        backHomeButton.click();
        return new HomePage();
    }



    public CheckoutCompletePage(){
        PageFactory.initElements(getDriver(),this);
    }
}
