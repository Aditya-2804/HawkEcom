package TestCases;

import BaseClass.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class seleniumTesting extends BaseClass {


    public static void main(String[] args) throws Exception{

//        moveZerosToEnd(new int[]{1,6,9,0,3,0,1});
//        moveZerosToBegining(new int[]{1,6,9,0,3,0,1});

//        int[] arr = new int[]{1,2,3,4,5,6};
//        int[] arr1 = new int[]{7,8,9,0};
//        Arrays.stream(mergerTwoArrays(arr,arr1)).forEach(System.out::print);
//        Arrays.stream(arr).sorted().skip(1).limit(2).forEach(System.out::print);

    }

    public static int[] mergerTwoArrays(int[] array1, int[] array2){
        int lenght1 = array1.length;
        int lenght2 = array2.length;
        int[] mergedArray = new int[lenght2+lenght1];

        for (int i=0; i<lenght1; i++){
            mergedArray[i]=array1[i];
        }
        for (int i=0; i<lenght2;i++){
            mergedArray[lenght1+i]=array2[i];
        }

        return mergedArray;
    }

    public static void moveZerosToEnd(int[] arr){
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0){
                arr[count++]=arr[i];
            }
        }

        while (count<n){
            arr[count++]=0;
        }

        for (int i : arr) {
            System.out.print(i+",");
        }

    }

    public static void moveZerosToBegining(int[] arr){
        int n = arr.length;
        int count = n-1;


        System.out.println(" ");
        for (int i = n-1; i>=0 ; i--){
            if (arr[i] != 0){
                arr[count--]=arr[i];
            }
        }

        while (count>= 0){
            arr[count--]=0;
        }

        Arrays.stream(arr).forEach(i -> System.out.print(i+","));

    }

    public static String processString(String input)
    {
        // Regular expression to find all alphabetic substrings
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(input);
        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            if (!result.isEmpty()) {
                result.append(".");
            }
            result.append(matcher.group()); }
        return result.toString();
    }

    @DataProvider(name = "testdata")
    public Object[][] testData(){
        Object[][] data = new Object[7][1];
        data[0][0]=" Shoes";
        data[1][0]=" laptop";
        data[2][0]=" Shirts";
        data[3][0]=" watches";
        data[4][0]=" belts";
        data[5][0]=" Braceletes for Men";
        data[6][0]=" Home Deecor";

        return data;
    }

    @Test(dataProvider = "testdata")
    public void dataproTest(String string){

        WebDriver driver1 = new EdgeDriver();
        driver1.get("");
        System.out.println(string);
    }


    public void iteratorandEnumerations(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
        Iterator<String> iterator = arrayList.iterator();
        System.out.println("Array List Elements are :");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


        Vector<Object> vector = new Vector<>();
        vector.add("StrignBuffer");
        vector.add(14);
        vector.add(12.47593);
        vector.add(true);

        System.out.println("Vector Elements are :");
        Enumeration<Object> enumeration = vector.elements();

        while(enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }
    }

    public void javaScriptExecutorPractises() throws Exception{
     LaunchBrowser();
     JavascriptExecutor jse = (JavascriptExecutor) getDriver();
     jse.executeScript("window.scrollBy(0,600)");
     Thread.sleep(3*1000);
     jse.executeScript("window.scrollBy(0,-550)");
     Thread.sleep(3*1000);
     jse.executeScript("arguments[0].scrollIntoView(true);",getDriver().findElement(By.id("dte")))   ;
     Thread.sleep(3*1000);
     jse.executeScript("location.reload()");
     System.out.println(jse.executeScript("return document.title").toString());
     jse.executeScript("arguments[0].scrollIntoView(true);",getDriver().findElement(By.id("ta1")));
     Thread.sleep(3*1000);
     jse.executeScript("document.getElementById('ta1').value='Unable to find version of CDP to use for 130.0.2849.80. You may need to include a dependency on a specific version';");
     Thread.sleep(3*1000);
     jse.executeScript("arguments[0].click();",getDriver().findElement(By.id("drop1")));
     jse.executeScript("alert('congratulations on completeing the javaScriptExecutor')");
    }


}
