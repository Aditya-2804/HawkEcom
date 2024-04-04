package PageObjects;

import BaseClass.BaseClass;
import DriverActions.DriverActions;
import Utilities.Logs;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.collections.CollectionUtils;

import javax.xml.xpath.XPath;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage extends BaseClass {

    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement Logo;

    @FindBy(xpath = "//span[@class='title']")
    WebElement Title;

    @FindBy(id = "shopping_cart_container")
    WebElement Shoppingcart;

    @FindBy(id= "react-burger-menu-btn")
    WebElement BurgerMenuButton;

    @FindAll({
            @FindBy(xpath = "//nav/a")
    })
    List<WebElement> MenuListElements;

    @FindAll({
            @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    })
    List<WebElement> EmptyshoppingCartBadge;

    @FindAll({
            @FindBy(xpath = "//div[@class='inventory_item_price']")
    })
    List<WebElement> productPriceList;

    @FindAll({
            @FindBy(xpath = "//div[@class='inventory_item_name']")
    })
    List<WebElement> productNameList;



    @FindBy(id = "react-burger-cross-btn")
    WebElement MenuClose;

    @FindBy(xpath = "//span[@class='title']")
    WebElement ProductLabel;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement sortButtoon;

    @FindBy(xpath = "//div[@class=\"inventory_list\"]/div[1]/div[@class=\"inventory_item_description\"]/div/a")
    WebElement firstProduct;

    @FindBy(xpath = "//div[@class=\"inventory_list\"]/div[1]/div[@class=\"inventory_item_description\"]/div/div[@class=\"inventory_item_desc\"]")
    WebElement firstPrductDesc;

    @FindBy(xpath = "//div[@class=\"inventory_list\"]/div[1]/div[@class=\"inventory_item_description\"]/div[2]/div[@class=\"inventory_item_price\"]")
    WebElement firstProsuctPrice;

    @FindBy(xpath = "//div[@class=\"inventory_list\"]/div[1]/div[@class=\"inventory_item_description\"]/div[2]/button")
    WebElement firstProductAddtocart;


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

    @FindBy(xpath = "//select[@class=\"product_sort_container\"]")
    WebElement Sort;

    public HomePage(){
        PageFactory.initElements(getDriver(),this);
    }

    public void ValidateLogo(String Expected){
        Logs.info("Validating the title");
        Assert.assertEquals(Logo.getText(),Expected);
    }

    public void validateTitle(String ExpectedTitle){
        Logs.info("Validating Title Actual: "+Title.getText()+" Expected: "+ExpectedTitle);
        Assert.assertEquals(Title.getText(),ExpectedTitle);
    }

    public void MenuClick(){
        BurgerMenuButton.click();
    }

    public void ValidateMenuList(List<String> ExpectedMenuList){

        BurgerMenuButton.click();
        List<String> Menus = new ArrayList<>();
        for (int i = 0; i < MenuListElements.size(); i++) {
          Menus.add(MenuListElements.get(i).getText());
        }

        for (String s : ExpectedMenuList) {
            if (Menus.contains(s)) {
                Logs.info("Menus Present: " + s);
            } else {
                Logs.Error("Menu item is not present in the list: " + s);
            }
        }

    }

    public void CloseMenuNav() throws Exception{
        try{
            MenuClose.click();
        }catch (ElementClickInterceptedException exception){
            DriverActions.waitForSeconds(2);
            MenuClose.click();
        }
    }

    public yourCartPage ValidateShopingCartButton(){
        Shoppingcart.click();
        return new yourCartPage();
    }

    public boolean isCartEmpty(){
        return EmptyshoppingCartBadge.isEmpty();
    }

    public void ValidateSortOptions(List<String> ExpectedOptions){
        Select sort = new Select(Sort);
        List<String> Sortoptions =  new ArrayList<>();


        for (WebElement option : sort.getOptions()) {
            Sortoptions.add(option.getText());
            System.out.println("Sort Options: "+option.getText());
        }

        for (String option: ExpectedOptions) {
            if (Sortoptions.contains(option)){
                Logs.info("Sort Options is present as Expected :"+option);
            }else {
                Logs.Error("This option is not present to sort: "+option);
            }
        }
    }

    public ProductDescriptionPage firstProductClick(){
        firstProduct.click();
        return new ProductDescriptionPage();
    }

    public List<Double> validatePriceLotToHigh(){

        Select select = new Select(sortButtoon);
        select.selectByVisibleText("Price (low to high)");

        List<Double> priceList = new ArrayList<>();

        productPriceList.forEach(element -> priceList.add(Double.parseDouble(element.getText().substring(1))));
        return priceList;
    }

    public List<Double> validatePriceHighToLow(){

        Select select = new Select(sortButtoon);
        select.selectByVisibleText("Price (high to low)");

        List<Double> priceList = new ArrayList<>();

        productPriceList.forEach(element -> priceList.add(Double.parseDouble(element.getText().substring(1))));
        return priceList;
    }

    public List<String> validateNameAtoZ(){

        Select select = new Select(sortButtoon);
        select.selectByVisibleText("Name (A to Z)");

        List<String> AtoZList = new ArrayList<>();

        productNameList.forEach(element -> AtoZList.add(element.getText()));
        return AtoZList;
    }

    public List<String> validateNameZtoA(){

        Select select = new Select(sortButtoon);
        select.selectByVisibleText("Name (Z to A)");

        List<String> nameList = new ArrayList<>();

        productNameList.forEach(element -> nameList.add(element.getText()));
        return nameList;
    }

    public String getfirstProductName(){
        return firstProduct.getText();
    }

    public String getFirstProductDesc(){
        return firstPrductDesc.getText();
    }

    public String getFirstProductPrice(){
        return firstProsuctPrice.getText();
    }

    public void FirstProductAddtocartClick(){
        firstProductAddtocart.click();
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





}
