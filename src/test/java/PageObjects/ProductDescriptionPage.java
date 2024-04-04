package PageObjects;

import BaseClass.BaseClass;
import DriverActions.DriverActions;
import Utilities.Logs;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ProductDescriptionPage extends BaseClass {

    @FindBy(xpath = "//div[@class='header_label']")
    WebElement Logo;

    @FindBy(xpath = "//div[@class='header_label']")
    WebElement Title;

    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerMenu;

    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    WebElement ProductName;

    @FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
    WebElement ProductdDescripton;

    @FindBy(xpath = "//div[@class='inventory_details_price']")
    WebElement ProductPrice;

    @FindBy(id = "back-to-products")
    WebElement BackToProductButton;

    @FindBy(id = "shopping_cart_container")
    WebElement CartHeaderButton;

    @FindAll({
            @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    })
    List<WebElement> EmptyshoppingCartBadge;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement shoppingCartBadge;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeFromCartCartButton;

    @FindBy(xpath = "//div[@class=\"inventory_details_desc_container\"]/button")
    WebElement addOrRemoveFromCartbutton;

    @FindBy(xpath = "//ul[@class=\"social\"]/li[1]")
    WebElement twitterfooter;

    @FindBy(xpath = "(//li/a)[1]")
    WebElement twitterLink;

    @FindBy(xpath = "//ul[@class=\"social\"]/li[2]")
    WebElement facebookFooter;

    @FindBy(xpath = "(//li/a)[2]")
    WebElement facebookLink;

    @FindBy(xpath = "//ul[@class=\"social\"]/li[3]")
    WebElement linkedinFooter;

    @FindBy(xpath = "(//li/a)[3]")
    WebElement linkedInLink;


    public void ValidateTitle(String ExpectedTitle){
        Assert.assertEquals(Title.getText(),ExpectedTitle);
    }



    public void vallidateName(String ExpectedName){
        Logs.info("validating the product Name: "+ExpectedName);
        Assert.assertEquals(ProductName.getText(),ExpectedName);
    }

    public void vallidateDesc(String ExpectedDesc){
        Logs.info("validating the product Description: "+ExpectedDesc);
        Assert.assertEquals(ProductdDescripton.getText(),ExpectedDesc);
    }

    public void vallidatePrice(String ExpectedPrice){
        Logs.info("validating the product Price: "+ExpectedPrice);
        Assert.assertEquals(ProductPrice.getText(),ExpectedPrice);
    }


    public void ValidateAddToRemoveFromCartButton(){
        if (addOrRemoveFromCartbutton.getText().equals("Add to cart")){
            addOrRemoveFromCartbutton.click();
            Logs.info("After adding the item to the cart Button Dispalyed is :"+addOrRemoveFromCartbutton.getText());
            Assert.assertEquals(addOrRemoveFromCartbutton.getText(),"Remove");
        }else{
            addOrRemoveFromCartbutton.click();
            Logs.info("After Removing the item from the cart Button Dispalyed is :"+addOrRemoveFromCartbutton.getText());
            Assert.assertEquals(addOrRemoveFromCartbutton.getText(),"Add to cart");
        }
    }


    public void ClickOnBurgerMenu() throws Exception{
        burgerMenu.click();
        DriverActions.waitForSeconds(6);
    }


    public void AddToCartButtonClick() throws Exception{
        addToCartButton.click();
        DriverActions.waitForSeconds(6);
    }

    public void RemoveFromCartButtonClick() throws Exception{
        removeFromCartCartButton.click();
        DriverActions.waitForSeconds(6);
    }

    public HomePage BackToProductClick() throws Exception{
        BackToProductButton.click();
        DriverActions.waitForSeconds(5);
        return new HomePage();
    }

    public yourCartPage CartHeaderClick() throws Exception{
        CartHeaderButton.click();
        return new yourCartPage();
    }

    public void validateCartHeaderCount(){

        if (EmptyshoppingCartBadge.isEmpty()){
            addOrRemoveFromCartbutton.click();
            Logs.info("Adding an item to an Empty cart Number of items in the cart is now: "+shoppingCartBadge.getText());
            Assert.assertEquals(shoppingCartBadge.getText(),"1");
        }else {
            int totalNumberofCartUtems = Integer.parseInt(shoppingCartBadge.getText());
            Logs.info("Count of Cart items Before removing " +totalNumberofCartUtems);
            addOrRemoveFromCartbutton.click();
            if (totalNumberofCartUtems == 1){
                Logs.info("the Cart is empty since the last item is removed successfully");
                Logs.info("IS The shopping cart Empty?? :"+EmptyshoppingCartBadge.isEmpty());
            }else {
                Assert.assertEquals(shoppingCartBadge.getText(),String.valueOf(totalNumberofCartUtems-1));
                Logs.info("Count of Cart items After removing " +totalNumberofCartUtems);
            }
        }
    }

    public HomePage backToProductClick(){
        BackToProductButton.click();
        return new HomePage();
    }



    public void twitterClick(){
        twitterfooter.click();
    }

    public void facebookClick(){
        facebookFooter.click();
    }

    public void linkedinClick(){
        linkedinFooter.click();
    }

    public String twitterlink(){
        return twitterLink.getAttribute("href");
    }

    public String facebooklink(){
        return facebookLink.getAttribute("href");
    }

    public String linkedinlink(){
        return linkedInLink.getAttribute("href");
    }




    public ProductDescriptionPage(){
        PageFactory.initElements(getDriver(),this);
    }
}
