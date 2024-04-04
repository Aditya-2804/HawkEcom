package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {

    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public static ExtentHtmlReporter extentHtmlReporter;

    public static void setExtent(){

        extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport"+System.currentTimeMillis()+".html");
        extentHtmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        extentReports.setSystemInfo("HostName","MyHost");
        extentReports.setSystemInfo("ProjectName","SauceLabs");
        extentReports.setSystemInfo("Tester","Aditya");
        extentReports.setSystemInfo("OS","Win10");
        extentReports.setSystemInfo("Browser","Edge");

    }

    public static void endReport(){
        extentReports.flush();
    }

}
