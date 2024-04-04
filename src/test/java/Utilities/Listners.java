package Utilities;

import BaseClass.BaseClass;
import DriverActions.DriverActions;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class Listners extends ExtentManager implements ITestListener {

    public void onTestStart(ITestResult result){
        System.out.println("TESTNAME: "+result.getMethod().getMethodName());
//        extentTest = extentReports.createTest(result.getTestName());
//        extentTest.createNode(result.getTestName());
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
        extentTest.createNode(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result){
        if (result.getStatus() == ITestResult.SUCCESS){
            extentTest.log(Status.PASS,"Pass test case NAme is: "+result.getMethod().getMethodName());
        }
    }

    public void onTestFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE){
            try{
                extentTest.log(Status.FAIL,
                        MarkupHelper.createLabel(result.getMethod().getMethodName()+" - Test case failed ", ExtentColor.RED ));
                extentTest.log(Status.FAIL,
                        MarkupHelper.createLabel(result.getThrowable() +" - Test Case Failed", ExtentColor.RED));

                String imgPath = DriverActions.screenShot(BaseClass.getDriver(),result.getName());
                extentTest.fail("ScreenShot is attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
            }catch (Exception exception){
                exception.getMessage();
            }
            extentTest.log(Status.FAIL,"Failed Testcase Name is: "+result.getMethod().getMethodName());
        }
    }

    public void onTestSkipped(ITestResult result){
        if (result.getStatus() == ITestResult.SKIP){
            extentTest.log(Status.SKIP,"Skipped testcase is : "+result.getMethod().getMethodName());
        }
    }
}
