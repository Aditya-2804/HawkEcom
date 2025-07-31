package TestCases;

import BaseClass.BaseClass;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class probs extends BaseClass implements ITestListener {


    public static void main(String[] args) throws Exception {

        // Input: 123456  Output: 162534
//        addInBetween("123456");

        // input: a3b5  output: aaabbbbb
//        charRepeat("a3b5c1");

//        readvalueFromExcel(System.getProperty("user.dir")+"/"+"TestData.xlsx","Sample","phone"
//                ,"email","darrelldillon573@slingacademy.com");
//        Output should be : (156)423-0600x52870

        //input: abcd Output: ab ac ad bc bd cd
//        System.out.println("Output : "+twoSubStrings("abcd"));

//        dynamicTable("Amelia");

//        System.out.println(lowerString("India AS "));

//        ExcelVAlues(System.getProperty("user.dir")+"/"+"TestData.xlsx","Sample","email","davidbenson257@slingacademy.com","address");


//        System.out.println("REverse: "+reverseStringPreserveSpaces("I am Legend"));
        expandString("a3b4");
//        int[] arr = {-4,4,2,5,10};
//        for (int i = 0; i < arr.length; i++) {
//            if (i==arr[i]){
//                System.out.println("Matched : "+i);
//            }
//        }

    }



    public static  String lowerString(String str){
        return  str.toLowerCase();
    }
    public static void ExcelVAlues(String filepath, String sheetName,String columnOfrelatedValue, String relatedValue,String columnOfValue) throws Exception{
        File file = new File(filepath);
        FileInputStream fileInputStream = new FileInputStream(file);
        String fileExtension= filepath.substring(filepath.indexOf("."));
        Workbook workbook = null;
        if (fileExtension.equals(".xlsx")){
            workbook = new XSSFWorkbook(fileInputStream);
        } else if (fileExtension.equals(".xls")) {
            workbook = new HSSFWorkbook(fileInputStream);
        }
        assert workbook != null;
        Sheet sheet = workbook.getSheet(sheetName);
        int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        HashMap<String,Integer> columnNames = new HashMap<>();
        for (int i = 0; i < rowcount; i++) {
            Row row = sheet.getRow(i);
            if (i == 0) {
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    columnNames.put(row.getCell(j).getStringCellValue(),j);
                }
            }
            if (row.getCell(columnNames.get(columnOfrelatedValue)).getStringCellValue().equals(relatedValue)){
                System.out.println(row.getCell(columnNames.get(columnOfValue)));
            }
        }
    }

    public  static  String reverseStringPreserveSpaces(String string){

        //Input : I am Legend       Output: d ne gelmaiI

        StringBuilder sb = new StringBuilder(string);
        sb.reverse();

        for (int i = 0; i < string.length(); i++) {
            if (sb.charAt(i) == ' '){
                sb.deleteCharAt(i);
            }
            if (string.charAt(i)==' '){
                sb.insert(i," ");
            }
        }
        return sb.toString();
    }

    public static void expandString(String string){


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {

            char currentChars = string.charAt(i);

            if (Character.isLetter(currentChars)){
                if (i+1 < string.length() && Character.isDigit(string.charAt(i+1))){
                    int count = Character.getNumericValue(string.charAt(i+1));
                    for (int j=0; j<=count;j++){
                        System.out.print(currentChars);
                        sb.append(currentChars);
                    }
                }
            }

        }
        System.out.println(sb);
    }




    public static void readvalueFromExcel(String filepath,String sheetName,String columnOfValue,
                                     String columnOfCorrespondingValue, String correspondinValue) throws Exception{

        File file = new File(filepath);
        FileInputStream fileInputStream = new FileInputStream(file);

        String fileExtension = filepath.substring(filepath.indexOf("."));
        System.out.println("Extension: "+fileExtension);
        Workbook workbook = null;

        if (fileExtension.equals(".xlsx")) {
            workbook = new XSSFWorkbook(fileInputStream);
        } else if (fileExtension.equals(".xls")) {
            workbook = new HSSFWorkbook(fileInputStream);
        }

        Sheet sheet = workbook.getSheet(sheetName);
        HashMap<String,Integer> headings = new HashMap<>();
        int rowcount = sheet.getLastRowNum()-sheet.getFirstRowNum();


        for (int i = 0; i < rowcount+1; i++) {
            Row row = sheet.getRow(i);

            if (i==0){
                for (int j=0; j < row.getLastCellNum(); j++){
                    headings.put(row.getCell(j).getStringCellValue(),j);
                }
            }

//            System.out.println("Test: "+row.getCell(headings.get(columnOfValue)).getStringCellValue());

            if (row.getCell(headings.get(columnOfCorrespondingValue)).getStringCellValue().equals(correspondinValue)) {
                System.out.println("2. Here is your value: "+row.getCell(headings.get(columnOfValue)).getStringCellValue());
            }
        }
        System.out.println(Arrays.asList(headings));

    }

    private static void charRepeat(String input) {

        HashMap<Character, String> decod = new HashMap<>();
        String output = "";

        for (int i = 0; i < input.length(); i++) {

            if (!Character.isDigit(input.charAt(i))){
                decod.put(input.charAt(i), String.valueOf(input.charAt(i+1)));
                System.out.println(i+" Iteration charat(i): "+input.charAt(i));
                System.out.println(i+" Iteration charat(i+1): "+input.charAt(i+1));
            }
        }

        System.out.println(Arrays.asList(decod));


//        for (int i = 0; i < ; i++) {
//
//        }
    }


    public static void dynamicTable(String FirstName) throws Exception{
        LaunchBrowser();
        getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(05*1000);
        getDriver().findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
        getDriver().findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
        getDriver().findElement(By.xpath("//button[@type=\"submit\"]")).click();

        Thread.sleep(05*1000);
        getDriver().findElement(By.xpath("(//ul/li)[2]")).click();

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        javascriptExecutor.executeScript("window.scrollBy(0,1000)");
//        WebElement lines = getDriver().findElement(By.xpath("//div[@role=\"table\"]/div[2]/div[3]/div/div[3]"));

        Thread.sleep(05*1000);
        List<WebElement> rows = getDriver().findElements(By.xpath("//div[@role=\"table\"]/div[2]/child::div"));

        for (int i = 1; i < rows.size(); i++) {
            WebElement element = getDriver().findElement(By.xpath("//div[@role=\"table\"]/div[2]/div["+i+"]/div/div[3]"));
            System.out.println("FirstNames: "+element.getText());

            if (element.getText().equals(FirstName)){
                WebElement id = getDriver().findElement(By.xpath("//div[@role=\"table\"]/div[2]/div["+i+"]/div/div[2]"));
                WebElement lastName = getDriver().findElement(By.xpath("//div[@role=\"table\"]/div[2]/div["+i+"]/div/div[4]"));
                WebElement JobTitile = getDriver().findElement(By.xpath("//div[@role=\"table\"]/div[2]/div["+i+"]/div/div[5]"));
                WebElement Staus = getDriver().findElement(By.xpath("//div[@role=\"table\"]/div[2]/div["+i+"]/div/div[6]"));
                WebElement suBUnit = getDriver().findElement(By.xpath("//div[@role=\"table\"]/div[2]/div["+i+"]/div/div[7]"));

                System.out.println("Details for "+FirstName+"\n ID: "+id.getText()+"\n lastName: "+lastName.getText()+"\n JobTitle: "+JobTitile.getText()+
                        "\n Status: "+Staus.getText()+"\n subUnit: "+suBUnit.getText());
                break;

            }

        }







    }

    private static String twoSubStrings(String str){

        String result="";
        char[] ch = str.toCharArray();

        for (int i = 0; i < ch.length-1; i++) {
            for (int j = i; j < ch.length-1; j++) {
                System.out.print(ch[i]+""+ch[j+1]+" ");
                result = String.valueOf(ch[i]).concat(String.valueOf(ch[j+1]))+" ";
            }
        }

        System.out.println("RESLT: "+result);
        return result;
    }

    public static void addInBetween(String input){
        String output="";

        for (int i = 0; i <Math.ceil((double) input.length() /2) ; i++) {
                output=output+input.charAt(i);
                output=output+input.charAt(input.length()-1-i);

                System.out.println(i+" iterations"+output);
        }
        trimOutput(input,output);

    }

    private static void trimOutput(String input,String output) {
        if (input.length()%2 != 0) {
            System.out.println("Odd: "+output.substring(0,output.length()-1));
        }
    }

}