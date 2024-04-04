package PageObjects;

import BaseClass.BaseClass;
import Utilities.Logs;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class yourCartPage extends BaseClass {


    @FindBy(xpath = "//div[@class='header_label']")
    WebElement Logo;

    @FindBy(xpath = "//span[@class='title']")
    WebElement Title;

    @FindAll({
            @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    })
    List<WebElement> EmptyshoppingCartBadge;

    @FindAll({
            @FindBy(xpath = "//div[@class=\"cart_item\"]")
    })
    List<WebElement> listOfItemsInCart;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement shoppingCartBadge;

    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerMenu;

    @FindBy(xpath = "//div[@class='cart_quantity_label']")
    WebElement quantityLabel;

    @FindBy(xpath = "//div[@class='cart_desc_label']")
    WebElement descriptionLabel;

    @FindBy(xpath = "//div[@class='cart_quantity']")
    WebElement cartQuantity;

//    @FindBy(id = "item_4_title_link")
//    WebElement cartitemLabel;

    @FindAll({
            @FindBy(xpath = "//div[@class=\"cart_item\"]")
    })
    List<WebElement> totalCartitemslist;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    WebElement cartItemname;

    @FindBy(xpath = "//div[@class='inventory_item_desc']")
    WebElement cartItemDescription;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    WebElement cartItemPrice;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement cartRemoveItem;

    @FindBy(id = "continue-shopping")
    WebElement continueShopping;

    @FindBy(id = "checkout")
    WebElement checkout;

//      //div[@class="cart_item"][1]/div/a/div  ======   Dynamic item title
//    //div[@class="cart_item"][1]/div[2]/div[@class='inventory_item_desc']  ========= Dynamic item desc
//    //div[@class="cart_item"][1]/div[2]/div[@class='item_pricebar']/div   ====        Dynamic item price
//    //div[@class="cart_item"][1]/div[2]/div[@class='item_pricebar']/button =====    dynamic remove button




    public yourCartPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public void ValidateTitle(String ExpectedTitle){
        Assert.assertEquals(Title.getText(),ExpectedTitle);
    }

    public boolean isCartEmpty(){
        return EmptyshoppingCartBadge.isEmpty();
    }

//    public void validateProductName(){
//        Assert.assertEquals(;
//    }

    public int getTotaCartItems(){
        return Integer.parseInt(shoppingCartBadge.getText());
    }

    public int getitemsPresentInCart(){
        return listOfItemsInCart.size();
    }


    public void validateItemName(String Expected){
        Logs.info("Validating Item Name Actual: "+cartItemname.getText()+" Expected: "+Expected);
        Assert.assertEquals(cartItemname.getText(),Expected);
    }

    public void validateItemDesc(String Expected){
        Logs.info("Validating Item Descriptiojn Actual: "+cartItemDescription.getText()+" Expected: "+Expected);
        Assert.assertEquals(cartItemDescription.getText(),Expected);
    }

    public void validateItemPrice(String Expected){
        Logs.info("Validating Item Price Actual: "+cartItemPrice.getText()+" Expected: "+Expected);
        Assert.assertEquals(cartItemPrice.getText(),Expected);
    }

    public void cartItemRemoveClick(){
        cartRemoveItem.click();
    }

    public void ValidateHeaderCartitemsCount(){
        int shoppingCartBadgeCount = Integer.parseInt(shoppingCartBadge.getText());
        int actualNumberofItemsInCart = listOfItemsInCart.size();

        Logs.info("Validating the Number of items in cart with Badge\nActual Cart Items: "+actualNumberofItemsInCart+" Count on the Header Badge : "+shoppingCartBadgeCount);
        Assert.assertEquals(shoppingCartBadgeCount,actualNumberofItemsInCart);
    }

    public HomePage continueShoppingCllick(){
        continueShopping.click();
        return new HomePage();
    }

    public CheckoutInfoPage checkOutClick(){
        checkout.click();
        return new CheckoutInfoPage();
    }
}
