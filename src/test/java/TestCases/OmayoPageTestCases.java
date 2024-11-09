package TestCases;

import BaseClass.BaseClass;
import PageObjects.omayoTestPage;
import Utilities.Logs;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class OmayoPageTestCases extends BaseClass {

    omayoTestPage omayoTestPage = new omayoTestPage();

    @BeforeMethod
    public void setUp() throws Exception{
        LaunchBrowser();
    }

//    @Test
//    public void validatetitle() throws Exception{
//    }
//
    @Test
    public void validateHeaders(){

        omayoTestPage = new omayoTestPage();
        Logs.info("Validating the title");
        Assert.assertEquals(omayoTestPage.title.getText(),"omayo (QAFox.com)");

        Logs.info("Validating Headers");
        Assert.assertEquals(omayoTestPage.homeheader.getText(),"Home");
        Logs.info("Validating CSS values");
//        Assert.assertEquals(omayoTestPage.homeheader.getCssValue("font-weight"),"normal");
        Assert.assertEquals(omayoTestPage.homeheader.getCssValue("line-height"),"35px");

        omayoTestPage.blogsheader.click();
        omayoTestPage.blogDropDownOption1.click();
        getDriver().navigate().back();

        omayoTestPage.blogsheader.click();
        omayoTestPage.blogDropDownOptionSeleniumByArun.click();
        getDriver().navigate().back();
    }

    @Test
    public void validateHalfOfFirstColumn() throws Exception{

        omayoTestPage = new omayoTestPage();
        Logs.info("Validate delayedTextafter10Sec");
        Assert.assertEquals(omayoTestPage.delayedTextafter10Sec.getText(),"");
        Thread.sleep(11*1000);
        Assert.assertEquals(omayoTestPage.delayedTextafter10Sec.getText(),"This text is displayed after 10 seconds of wait.");


        Logs.info("Validating multiSelect");
        Select multiSelect = new Select(omayoTestPage.multiselect);
        multiSelect.selectByIndex(0);
        multiSelect.selectByIndex(2);
        multiSelect.selectByIndex(3);

//        System.out.println(Arrays.asList(multiSelect.getAllSelectedOptions()).forEach(););
        ArrayList<String> selectedOptions = new ArrayList<>();
        for (WebElement element:multiSelect.getAllSelectedOptions()) {
            selectedOptions.add(element.getText());
        }
        System.out.println(Arrays.asList(selectedOptions));
        Assert.assertTrue(selectedOptions.contains("Volvo"));
        Assert.assertTrue(selectedOptions.contains("Hyundai"));
        Assert.assertTrue(selectedOptions.contains("Audi"));
        multiSelect.deselectAll();
        System.out.println(Arrays.asList(multiSelect.getAllSelectedOptions()));


        Logs.info("Validating DropDown");
        Select dropdown = new Select(omayoTestPage.dropDown1);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Older Newsletters");
        dropdown.selectByVisibleText("doc 2");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"doc 2");

        Logs.info("Validating textBoxWithPreloadedText");
//        System.out.println("Preloaded Text : "+omayoTestPage.textBoxWithPreloadedText.getText());
//        System.out.println("Preloaded InnerText : "+omayoTestPage.textBoxWithPreloadedText.getAttribute("innerText"));
        System.out.println("Preloaded InnerText : "+omayoTestPage.textBoxWithPreloadedText.getAttribute("value"));

        Assert.assertEquals(omayoTestPage.textBoxWithPreloadedText.getAttribute("value"),"Selenium WebDriver");
        omayoTestPage.textBoxWithPreloadedText.clear();
        omayoTestPage.textBoxWithPreloadedText.sendKeys("Validating textBoxWithPreloadedText");
        Assert.assertEquals(omayoTestPage.textBoxWithPreloadedText.getAttribute("value"),"Validating textBoxWithPreloadedText");
    }


//    @Test
//    public void validateDropdown(){
//    }
//    @Test
//    public void validatetextBoxWithPreloadedText(){
//    }

    @Test
    public void validateNewTab(){
        Logs.info("Validating in New Tab");
        omayoTestPage = new omayoTestPage();

        String currentHandle = getDriver().getWindowHandle();
        omayoTestPage.newTab.click();
        Set<String> handles = getDriver().getWindowHandles();
        for (String handle:handles) {
            if (!handle.equals(currentHandle)){
                getDriver().switchTo().window(handle);
            }
        }
        getDriver().findElement(By.xpath("//a[contains(text(),\"Difference between close( ) and quit( ) Selenium WebDriver commands\")]")).click();
        handles = getDriver().getWindowHandles();
        for (String handle:handles) {
            if (!handle.equals(currentHandle)){
                getDriver().switchTo().window(handle);
            }
        }

        System.out.println("Question :"+getDriver().findElement(By.xpath("//h3")).getText());

    }

    @Test
    public void validateSecondHalfOfFirstColumn() throws Exception{
        omayoTestPage = new omayoTestPage();
        Logs.info("Validate Disabled/Enabled Button");
        System.out.println("Is button Enabled: "+omayoTestPage.disabledButton.isEnabled());
        System.out.println("Is button Enabled: "+omayoTestPage.enabledButton.isEnabled());

        Logs.info("Validate Disabled TextBox");
        System.out.println("disabledTextBox : "+omayoTestPage.disabledTextBox.isEnabled());
        Assert.assertEquals(omayoTestPage.disabledTextBox.getText(),"");
//        omayoTestPage.disabledTextBox.sendKeys("omayoTestPage.disabledTextBox");
//        Assert.assertEquals(omayoTestPage.disabledTextBox.getText(),"");

        Logs.info("Validate Alerts");
        omayoTestPage.alertInput.click();
        Alert alert = getDriver().switchTo().alert();
        System.out.println("Alerts clicked: "+alert.getText());
        alert.accept();


        Logs.info("Validate UnableDisable");
        System.out.println("IS My Button Enabled: "+omayoTestPage.mybtn.isEnabled());
        omayoTestPage.tryitButton.click();
        Thread.sleep(4*1000);
        System.out.println("IS My Button Enabled: "+omayoTestPage.mybtn.isEnabled());

        Logs.info("VAlidate myOptionsDisabled Disabled");
        System.out.println("IS My myOptions Enabled: "+omayoTestPage.myOptionsDisabled.isEnabled());
        omayoTestPage.CheckthisButton.click();
        Thread.sleep(11*1000);
        System.out.println("IS My myOptions Enabled: "+omayoTestPage.myOptionsDisabled.isEnabled());

        Logs.info("validate doubleClickButton");
        Actions actions = new Actions(getDriver());
        actions.doubleClick(omayoTestPage.doubleClickButton).build().perform();
        Assert.assertEquals(alert.getText(),"Double Click Successfull");
        alert.accept();
        Thread.sleep(2*1000);
        actions.doubleClick(omayoTestPage.doubleclick).build().perform();
    }

//    @Test
//    public void validatedisabledTextBox(){
//    }
//    @Test
//    public void validatealertInput(){
//    }
//    @Test
//    public void validatedelayedTextafter10Sec() throws Exception{
//       }
    @Test
    public void validatepopUpWindow(){
        omayoTestPage = new omayoTestPage();
        Logs.info("Validate popUpWindow");
        omayoTestPage.popUpWindow.click();
        String curenthandle = getDriver().getWindowHandle();

        Set<String> handles = getDriver().getWindowHandles();
        for (String handle:handles) {
            if (!handle.equals(curenthandle)){
                getDriver().switchTo().window(handle);
                System.out.println(getDriver().findElement(By.xpath("//h3")).getText());
            }
        }
    }
    @Test
    public void validateuploadFile() throws Exception{
        omayoTestPage = new omayoTestPage();
        Logs.info("VAlidate uploadFile");
        omayoTestPage.uploadFile.sendKeys("C:\\Users\\Aditya\\Desktop\\New Text Document.txt");
//        Assert.assertEquals(,"New Text Document.txt");
        Thread.sleep(5*1000);
        System.out.println(omayoTestPage.uploadFile.getText());
    }
//
//    @Test
//    public void validateUnableDisable() throws Exception{
//    }
//
//    @Test
//    public void validatemyOptionsDisabled() throws Exception{
//    }
//    ///////////////////////////////////////////////////////////////////////
//    @Test
//    public void validatedoubleClickButton() throws Exception{
//    }

    @Test
    public void validateMiddleColumn() throws Exception{

        omayoTestPage = new omayoTestPage();
        Logs.info("Validate Text Area");
        Assert.assertEquals(omayoTestPage.textArea.getText(),"");
        omayoTestPage.textArea.sendKeys("Validate Text Area");
        Thread.sleep(3*1000);

        Logs.info("Validate Text Area");
        Thread.sleep(5*1000);
        System.out.println(omayoTestPage.iframe1);
//        getDriver().switchTo().frame(omayoTestPage.iframe1);
        getDriver().switchTo().frame("iframe1");
        Actions actions = new Actions(getDriver());
        actions.moveToElement(omayoTestPage.eleWithiniframe1).click().build().perform();
        System.out.println("within Iframe Element text: "+omayoTestPage.eleWithiniframe1.getText());
        getDriver().switchTo().parentFrame();
        getDriver().switchTo().frame(omayoTestPage.iframe2);
        System.out.println("within Iframe2 Element text: "+omayoTestPage.eleWithiniframe2.getText());
        getDriver().switchTo().parentFrame();
//        Assert.assertEquals(omayoTestPage.textArea.getText(),"Validate Text Area");

    }

    //
//    @Test
//    public void validatetextArea(){
//    }

//    @Test
//    public void validateiFrames() throws Exception{
//    }

    @Test
    public void validateThirdColumn() throws Exception{

        omayoTestPage = new omayoTestPage();
        Logs.info("validate RadioButton");
        omayoTestPage.femaleRadiButton.click();
        Assert.assertTrue(omayoTestPage.femaleRadiButton.isSelected());
        Assert.assertFalse(omayoTestPage.maleradio1.isSelected());

        omayoTestPage.maleradio1.click();
        Assert.assertTrue(omayoTestPage.maleradio1.isSelected());
        Assert.assertFalse(omayoTestPage.femaleRadiButton.isSelected());

        Logs.info("validate alert1");
        omayoTestPage.alert1.click();
        Alert alert = getDriver().switchTo().alert();
        Assert.assertEquals(alert.getText(),"Hello");
        alert.accept();

        Logs.info("Validate geCconfirmation");
        omayoTestPage.geCconfirmation.click();
        Assert.assertEquals(alert.getText(),"Press OK to confirm");
        alert.dismiss();

        Logs.info("Validate prompt");
        omayoTestPage.prompt.click();
        Assert.assertEquals(alert.getText(),"What is your name?");
        alert.sendKeys("Anonymous");
        alert.accept();

        Logs.info("Validate readonlyTextBox");
//        Assert.assertEquals(omayoTestPage.readonlyTextBox.getText(),"ReadThisText");
//        omayoTestPage.readonlyTextBox.sendKeys("Validate readonlyTextBox");
//        Assert.assertEquals(omayoTestPage.readonlyTextBox.getText(),"ReadThisText");

        Logs.info("Validate Select a vehicle radioButton");

        Logs.info("Bike radio Button click");
        omayoTestPage.bikeradio.click();
        Assert.assertTrue(omayoTestPage.bikeradio.isSelected());
        Assert.assertFalse(omayoTestPage.bicycleradio.isSelected());
        Assert.assertFalse(omayoTestPage.carradio.isSelected());

        Logs.info("Bicycle radio Button click");
        omayoTestPage.bicycleradio.click();
        Assert.assertFalse(omayoTestPage.bikeradio.isSelected());
        Assert.assertTrue(omayoTestPage.bicycleradio.isSelected());
        Assert.assertFalse(omayoTestPage.carradio.isSelected());

        Logs.info("Car radio Button click");
        omayoTestPage.carradio.click();
        Assert.assertFalse(omayoTestPage.bikeradio.isSelected());
        Assert.assertFalse(omayoTestPage.bicycleradio.isSelected());
        Assert.assertTrue(omayoTestPage.carradio.isSelected());

        Logs.info("Validate Blog Search");
        omayoTestPage.blogSearchinput.sendKeys("Selenium143");
        omayoTestPage.blogSearchButton.click();
        Thread.sleep(3*1000);

        Assert.assertTrue(omayoTestPage.blogSearchResults.getText().contains("No posts matching the query: "));

        Logs.info("Validate Delayed Dropdown");
        omayoTestPage.dropdown.click();
        Thread.sleep(3*1000);
        omayoTestPage.dropdownFlipkart.click();
        getDriver().navigate().back();

//        Assert.assertEquals(omayoTestPage.blogSearchResults.getText(),"No posts matching the query: ");
    }


//    @Test
//    public void validateRadioButton(){
//    }
//    ///////////////////////////////////////////////////////
//    @Test
//    public void validatealert1(){
//    }
/////////////////////////////////////////////////////////
//    @Test
//    public void validateCheckBox(){
//        Logs.info("validate CheckBox");
//    }
//
//    @Test
//    public void validatereadonlyTextBox(){
//    }
//////////////////////////////////////////
//    @Test
//    public void validateprompt(){
//    }
//    ////////////////////////////////////////
//    @Test
//    public void validategeConfirmation(){
//    }
//
//    @Test
//    public void validateSelectvehicle(){
//    }
//
//    @Test
//    public void validateDelayeddropdown() throws Exception{
//    }
//
//    @Test
//    public void validateBlogSearch() throws Exception{
//    }

    @AfterMethod
    public void TearDown(){
        CloseBrowser();
    }
}
