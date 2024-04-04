package PageObjects;

import BaseClass.BaseClass;
import Utilities.Logs;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.text.DecimalFormat;
import java.util.List;

public class CheckoutOverviewPage extends BaseClass {


    @FindBy(xpath = "//div[@class='header_label']")
    WebElement Logo;

    @FindBy(xpath = "//span[@class='title']")
    WebElement Title;

    @FindBy(id = "finish")
    WebElement finish;

    @FindBy(id = "cancel")
    WebElement cancelButton;

    @FindAll({
            @FindBy(xpath = "//div[@class='inventory_item_price']")
    })
    List<WebElement> productPriceList;

    @FindAll({
            @FindBy(xpath = "//div[@class='cart_item']")
    })
    WebElement listCartItems;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    WebElement subTotal;

    @FindBy(xpath = "//div[@class=\"summary_tax_label\"]")
    WebElement tax;


    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    WebElement Total;

    public void validateTitle(String title){
        Logs.info("Validating Title Actual : "+ Title.getText()+" Expected: "+title);
        Assert.assertEquals(Title.getText(),title);
    }

    public Double getTax(){
        return Double.parseDouble(tax.getText().substring(6));
    }

    public Double getSubTotal(){
        return Double.parseDouble(subTotal.getText().substring(13));
    }

    public Double getTotal(){
        return Double.parseDouble(Total.getText().substring(8));
    }

    public Double validateSubTotal(){
        Double subTotal=0.00;
        for (WebElement ele: productPriceList) {
            subTotal = subTotal + Double.parseDouble(ele.getText().substring(1));
        }

        Logs.info("Comapring the total price of items and the subtotal Actual: "+getSubTotal()+" Expected: "+subTotal);
        Assert.assertEquals(subTotal,getSubTotal());
        return subTotal;
    }

    public Double validateTax(){
        Double tax = Double.valueOf((getSubTotal()/100)*8);

        DecimalFormat df = new DecimalFormat("#.##");

        Assert.assertEquals(getTax(),Double.parseDouble(df.format(tax)));
        Logs.info("Calculating Tax on SubTotal Actual: "+getTax()+" Expected: "+df.format(tax));
        return tax;
    }

    public void validateTotal(){

        Logs.info("Calculating the total  Actual: "+getTotal()+" Expected" +getSubTotal()+getTax());
        Assert.assertEquals(getTotal(),getTax()+getSubTotal());
    }

    public CheckoutCompletePage finishClick(){
        finish.click();
        return new CheckoutCompletePage();
    }

    public HomePage cancelClick(){
        cancelButton.click();
        return new HomePage();
    }
    public CheckoutOverviewPage(){
        PageFactory.initElements(getDriver(),this);
    }
}
