package TestCases;

import BaseClass.BaseClass;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class Tests extends BaseClass {


    public void readExcel(String filePath,String fileName,String sheetName) throws IOException {

        //Creating object of File Class to open a file
        File file = new File(filePath+"//"+fileName);

        //Create an object of FileinputStream class to read the file
        FileInputStream fileInputStream = new FileInputStream(file);

//      Assigning as null Initialising it according to the extension
        Workbook workbook = null;

//        Finding the fille extension by FileName
        String fileExtension = fileName.substring(fileName.indexOf("."));
        System.out.println("Extension: "+fileExtension);

        if (fileExtension.equals(".xlsx")){
            workbook = new XSSFWorkbook(fileInputStream);
        } else if (fileExtension.equals(".xls")) {
            workbook  = new HSSFWorkbook(fileInputStream);
        }

//        Read the Sheet inside a workbook by its Name
        Sheet sheet  = workbook.getSheet(sheetName);

//        Find the Number of rows in the Excel
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

//        Creating a loop over al the Rows in the Excel to Read
        for (int i=0; i<rowCount+1 ;i++){
            Row row = sheet.getRow(i);
            //Create a loop to print cell values in a row
            for (int j=0; j< row.getLastCellNum(); j++){
                //Print Excel data in console
                System.out.print(row.getCell(j).getStringCellValue()+" || ");
            }
            System.out.println();
        }
    }

    public void getPasswordForUser(String filePath, String fileName, String sheetName, String userName) throws Exception{

        File file = new File(filePath+"/"+fileName);
        FileInputStream fileInputStream = new FileInputStream(file);

        Workbook workbook = null;
        String fileExtension = fileName.substring(fileName.indexOf("."));
        if (fileExtension.equals(".xlsx")){
            workbook = new XSSFWorkbook(fileInputStream);
        } else if (fileExtension.equals(".xls")) {
            workbook = new HSSFWorkbook(fileInputStream);
        }

        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum()- sheet.getFirstRowNum();

        int passwordColumnindex = 0;


        for (int i=0; i< rowCount+1; i++){
            Row row = sheet.getRow(i);

            if (i == 0) {

                for (int j =0; j<row.getLastCellNum();j++){
                    if (row.getCell(j).getStringCellValue().equals("Password")){
                        passwordColumnindex =j;
                        System.out.println("Password column index is: "+j);
                    }
                }

            }
            if (row.getCell(0).getStringCellValue().equals(userName)){
                System.out.println("Value: "+row.getCell(passwordColumnindex).getStringCellValue());
            }
        }
    }

    public void  readPasswordForUser(String filePath,String fileName,  String sheet,String userName,String column) throws Exception{

        File file = new File(filePath+"/"+fileName);
        FileInputStream fileInputStream = new FileInputStream(file);

        Workbook workbook=null;
        String fileExtension = fileName.substring(fileName.indexOf("."));

        if (fileExtension.equals(".xlsx")){
            workbook = new XSSFWorkbook(fileInputStream);
        } else if (fileExtension.equals(".xls")) {
            workbook = new HSSFWorkbook(fileInputStream);
        }

        Sheet sheet1 = workbook.getSheet(sheet);

        int rowCount = sheet1.getLastRowNum() - sheet1.getFirstRowNum();
        int columnIndex =0;

        for (int i = 0; i < rowCount+1; i++) {
            Row row = sheet1.getRow(i);
            if (i == 0) {
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    if (column.equals(row.getCell(j).getStringCellValue())){
                        columnIndex=j;
                    }
                }
            }
            if (userName.equals(row.getCell(0).getStringCellValue())){
                System.out.println("The "+column+" For "+userName+" is "+row.getCell(columnIndex).getStringCellValue());
            }
        }

    }

    public void writeData(String filePath, String fileName, String sheetName, String[] dataToWrite) throws IOException{

        File file = new File(filePath+"/"+fileName);
        FileInputStream fileInputStream = new FileInputStream(file);

        Workbook workbook = null;

        String fileExtension = fileName.substring(fileName.indexOf("."));

        if (fileExtension.equals(".xlsx")){
            workbook = new XSSFWorkbook(fileInputStream);
        } else if (fileExtension.equals(".xls")) {
            workbook = new HSSFWorkbook(fileInputStream);
        }

        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

        Row row = sheet.getRow(0);

        Row newRow = sheet.createRow(rowCount+1);
        for (int i = 0; i<row.getLastCellNum() ;i++){
            Cell cell  = newRow.createCell(i);
            cell.setCellValue(dataToWrite[i]);
        }

        fileInputStream.close();

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);

        fileOutputStream.close();
    }

//    public void getValueFromExcel(String filepath,String sheetName,String correspondingValue, String columnWhereValueFrom, String columnValueWeNeed) throws Exception{
//        File file = new File(filepath);
//        FileInputStream fileInputStream = new FileInputStream(file);
//
//        Workbook workbook = null;
//        String fileExtension = filepath.substring(filepath.indexOf("."));
//
//        if (fileExtension.equals(".xlsx")) {
//            workbook = new XSSFWorkbook(fileInputStream);
//        }else if (fileExtension.equals(".xls")){
//            workbook = new HSSFWorkbook(fileInputStream);
//        }
//
//        Sheet sheet = workbook.getSheet(sheetName);
//        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
//        HashMap<String,Integer> hashMap = new HashMap<String, Integer>();
//
//        for (int i = 0; i < rowCount+1; i++) {
//            Row row = sheet.getRow(i);
//            if (i == 0) {
//                for (int j = 0; j < row.getLastCellNum(); j++) {
//                    if (columnWhereValueFrom.equals(row.getCell(j).getStringCellValue()) || columnValueWeNeed.equals(row.getCell(j).getStringCellValue())) {
//                        hashMap.put(row.getCell(j).getStringCellValue(),j);
//                        System.out.println("Columns are :"+row.getCell(j).getStringCellValue());
//                    }
//                }
//            }
//            if (row.getCell(hashMap.get(columnWhereValueFrom)).getStringCellValue().equals(correspondingValue)) {
//                System.out.println("Matched");
//                System.out.println( "The "+columnValueWeNeed+" for "+ correspondingValue+" is "+row.getCell(hashMap.get(columnValueWeNeed)).getStringCellValue());
//            }
//        }
//    }

    public void readFromExcel(String filePath,String sheetNAme,String value ,String columnFrom,String columnValueNeededToBeFetched)
    throws Exception{

        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);

        Workbook workbook =null;
        String fileExtension = filePath.substring(filePath.indexOf("."));

        if (fileExtension.equals(".xlsx")) {
            workbook = new XSSFWorkbook(fileInputStream);
        } else if (fileExtension.equals(".xls")) {
            workbook = new HSSFWorkbook(fileInputStream);
        }

        Sheet sheet = workbook.getSheet(sheetNAme);
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        HashMap<String,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < rowCount+1; i++) {
            Row row = sheet.getRow(i);
            if (i==0){
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    hashMap.put(row.getCell(j).getStringCellValue(),j);
                }
            }
            if (row.getCell(hashMap.get(columnFrom)).getStringCellValue().equals(value)) {
                System.out.println("Matched");
                System.out.println("The "+columnValueNeededToBeFetched+" for "+columnFrom+" "+value+"  is"+row.getCell(hashMap.get(columnValueNeededToBeFetched)).getStringCellValue());
            }
        }
    }


//    @Test
    public void readData() throws Exception{

//        writeData(System.getProperty("user.dir"),"TestData.xlsx","Credentials",new String[]{"WriteTo this","checking"});
//        readExcel(System.getProperty("user.dir"),"TestData.xlsx","Credentials");
//        getPasswordForUser(System.getProperty("user.dir"),"TestData.xlsx","Credentials","FaceBook");
//        readPasswordForUser(System.getProperty("user.dir"),"TestData.xlsx","Sample","Erica","email");
//        getValueFromExcel(System.getProperty("user.dir")+"/"+"TestData.xlsx","Sample","0178967409","phone","email");
        readFromExcel(System.getProperty("user.dir")+"/"+"TestData.xlsx","Sample","darrelldillon573@slingacademy.com","email","address");

    }


    @DataProvider(name="TestData")
    public Object[][] getData(){
        return new Object[][]{
                {"UserAnme","Passwords"},
                {"Adi","Pass"}

        };
    }

    @Test(dataProvider = "TestData")
    public void settingDSata(String username,String pass){
        System.out.println("Username: "+username+" Pass: "+pass);
    }


    public void readExcel(String filepath,String sheetName, String value, String columnWhereValuesIsFrom,String columnWhereValuesIsFetched)
            throws Exception{

        File file =  new File(filepath);
        FileInputStream fileInputStream = new FileInputStream(file);

        Workbook workbook = null;
        String fileExtenssion = filepath.substring(filepath.indexOf("."));

        if (fileExtenssion.equals(".xlsx")) {
            workbook = new XSSFWorkbook(fileInputStream);
        } else if (fileExtenssion.equals(".xls")) {
            workbook = new HSSFWorkbook(fileInputStream);
        }

        Sheet sheet = workbook.getSheet(sheetName);
        HashMap<String,Integer> headingsColumn = new HashMap<>();
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        for (int i = 0; i < rowCount+1; i++) {
            Row row = sheet.getRow(i);
            if (i == 0) {
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    headingsColumn.put(row.getCell(j).getStringCellValue(),j);
                    System.out.println(row.getCell(j).getStringCellValue()+" || "+j);
                }
            }
            if (row.getCell(headingsColumn.get(columnWhereValuesIsFrom)).getStringCellValue().equals(value)) {
                System.out.println("Matched");
                System.out.println("The "+columnWhereValuesIsFetched+" for "+columnWhereValuesIsFrom+" "+value+" is "+row.getCell(headingsColumn.get(columnWhereValuesIsFetched)).getStringCellValue());
            }
        }

    }


    public void readExcel12(String filepath, String sheetName, String value,String columnWhereValueIsFrom, String columnFromValueWeNeed)
    throws Exception{
        File file = new File(filepath);
        FileInputStream fileInputStream = new FileInputStream(file);

        Workbook workbook = null;
        String fileExtension= filepath.substring(filepath.indexOf("."));

        if (fileExtension.equals(".xlsx")){
            workbook = new XSSFWorkbook(fileInputStream);
        } else if (fileExtension.equals(".xls")) {
            workbook = new HSSFWorkbook(fileInputStream);
        }

        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        HashMap<String,Integer> columnHeadings = new HashMap<>();

        for (int i = 0; i <rowCount+1 ; i++) {
            Row row = sheet.getRow(i);
            if (i==0){
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    columnHeadings.put(row.getCell(j).getStringCellValue(),j);
                }
            }
            if (row.getCell(columnHeadings.get(columnWhereValueIsFrom)).equals(value)) {
                System.out.println(row.getCell(columnHeadings.get(columnFromValueWeNeed)).getStringCellValue());
            }
        }    }



    @Test
    public void uploadDownloadFies() throws Exception{

        LaunchBrowser();
        getDriver().findElement(By.id("fileuploadtest")).click();
        Thread.sleep(5*1000);
        getDriver().findElement(By.id("fileinput")).sendKeys(System.getProperty("user.dir")+"//README.md");

        Thread.sleep(5*1000);
        getDriver().findElement(By.xpath("//input[@type=\"submit\"]")).click();

        Thread.sleep(5*1000);
        Assert.assertEquals(getDriver().findElement(By.xpath("//div[@class=\"explanation\"]")).getText(),"You uploaded a file. This is the result.\n" +
                "        ");

        Assert.assertEquals(getDriver().findElement(By.id("uploadedfilename")).getText(),"README.md");
    }
}
