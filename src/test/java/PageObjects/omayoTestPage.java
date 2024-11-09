package PageObjects;

import BaseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class omayoTestPage extends BaseClass {

    @FindBy(xpath = "//h1[@class=\"title\"]")
    public WebElement title;
    @FindBy(id = "home")
    public WebElement homeheader;
    @FindBy(id = "blogsmenu")
    public WebElement blogsheader;
    @FindBy(xpath = "//li/ul/li[1]")
    public WebElement blogDropDownOption1;
    @FindBy(xpath = "//li/ul/li[1]")
    public WebElement blogDropDownOptionSelenium143;
    @FindBy(xpath = "//li/ul/li[2]")
    public WebElement blogDropDownOptionSeleniumByArun;
    @FindBy(xpath = "//li/ul/li[3]")
    public WebElement blogDropDownOptionSeleniumOneByArun;
    @FindBy(xpath = "//li/ul/li[4]")
    public WebElement blogDropDownOptionSeleniumTwoByArun;
    @FindBy(id = "multiselect1")
    public WebElement multiselect;
    @FindBy(id = "drop1")
    public WebElement dropDown1;
    @FindBy(id = "textbox1")
    public WebElement textBoxWithPreloadedText;
    @FindBy(id = "link1")
    public WebElement linkSelenium143;
    @FindBy(xpath = "//h2[contains(text(),\"Opens In New Window Link\")]/following-sibling::div/a")
    public WebElement newTab;
    @FindBy(id = "but1")
    public WebElement disabledButton;
    @FindBy(id="but2")
    public WebElement enabledButton;
    @FindBy(id="tb2")
    public WebElement disabledTextBox;
//    @FindBy(xpath = "//div[@id=\"HTML10\"]/div/button[contains(text(),\"Submit\")]")
//    public WebElement sameNameButtonsSubmit;
//    @FindBy(xpath = "//div[@id=\"HTML10\"]/div/button[contains(text(),\"Login\")]")
//    public WebElement sameNameButtonsLogin;
//    @FindBy(xpath = "//div[@id=\"HTML10\"]/div/button[contains(text(),\"Register\")]")
//    public WebElement sameNameButtonsRegister;
    @FindBy(id = "alert2")
    public WebElement alertInput;
    @FindBy(id = "delayedText")
    public WebElement delayedTextafter10Sec;
    @FindBy(xpath = "//p/a[contains(text(),\"Open a popup window\")]")
    public WebElement popUpWindow;
    @FindBy(id = "uploadfile")
    public WebElement uploadFile;

    //Click the button try it button to disable the button after 3 seconds.
    @FindBy(id = "myBtn")
    public WebElement mybtn;
    @FindBy(xpath = "//button[@id=\"myBtn\"]/../button[2]")
    public WebElement tryitButton;

    //The above Mr Option will be enabled in 10 seconds after clicking on below Check this button
    @FindBy(id = "dte")
    public WebElement myOptionsDisabled;
    @FindBy(xpath = "//div[@id=\"HTML47\"]/div/button")
    public WebElement CheckthisButton;

    @FindBy(xpath = "//div[@id=\"HTML46\"]/div/button")
    public WebElement doubleClickButton;
    @FindBy(xpath = "//input[@id=\"radio1\"]")
    public WebElement maleradio1;
    @FindBy(xpath = "//input[@id=\"radio2\"]")
    public WebElement femaleRadiButton;
    @FindBy(xpath = "//input[@id=\"alert1\"]")
    public WebElement alert1;
    @FindBy(id = "checkbox1")
    public WebElement oracngecheckbox1;
    @FindBy(id = "checkbox2")
    public WebElement bluecheckbox;
    @FindBy(id = "rotb")
    public WebElement readonlyTextBox;
    @FindBy(id = "prompt")
    public  WebElement prompt;
    @FindBy(id = "confirm")
    public WebElement geCconfirmation;
    @FindBy(id = "hbutton")
    public  WebElement hiddenButton;


//    Select a vehicle
    @FindBy(xpath = "//input[@value=\"Bike\"]")
    public WebElement bikeradio;
    @FindBy(xpath = "//input[@value=\"Bicycle\"]")
    public  WebElement bicycleradio;
    @FindBy(xpath = "//input[@value=\"Car\"]")
    public  WebElement carradio;

//    Select multiple options

    @FindBy(xpath = "//input[@value=\"Pen\" and @name=\"accessories\"]")
    public  WebElement Penradio;
    @FindBy(xpath = "//input[@value=\"Book\" and @name=\"accessories\"]")
    public WebElement Bookradio;
    @FindBy(xpath = "//input[@value=\"Laptop\" and @name=\"accessories\"]")
    public   WebElement Laptopradio;
    @FindBy(xpath = "//input[@value=\"Bag\" and @name=\"accessories\"]")
    public  WebElement Bagradio;

    @FindBy(id = "testdoubleclick")
    public  WebElement doubleclick;


    @FindBy(xpath = "//button[@class=\"dropbtn\"]")
    public  WebElement dropdown;
    @FindBy(xpath = "//div[@id=\"myDropdown\"]/a[1]")
    public   WebElement dropdownFacebook;
    @FindBy(xpath = "//div[@id=\"myDropdown\"]/a[2]")
    public   WebElement dropdownFlipkart;
    @FindBy(xpath = "//div[@id=\"myDropdown\"]/a[3]")
    public  WebElement dropdownGmail;

//    Search This Blog
    @FindBy(xpath = "//td/input[@title=\"search\" and @type=\"text\"]")
    public  WebElement blogSearchinput;
    @FindBy(xpath = "//td/input[@title=\"search\" and @type=\"submit\"]")
    public  WebElement blogSearchButton;
    @FindBy(xpath = "(//div[@class=\"status-msg-body\"])[1]")
    public   WebElement blogSearchResults;

    @FindBy(id = "ta1")
    public  WebElement textArea;

    @FindBy(id ="iframe1")
    public   WebElement iframe1;
    @FindBy(id ="iframe2")
    public  WebElement iframe2;
    @FindBy(xpath = "(//a[contains(text(),\"What is Selenium?\")])")
    public WebElement eleWithiniframe1;
    @FindBy(xpath = "//a[contains(text(),\"How to use Firepath?\")]")
    public WebElement eleWithiniframe2;





    public omayoTestPage(){
        PageFactory.initElements(getDriver(),this);
    }
}
