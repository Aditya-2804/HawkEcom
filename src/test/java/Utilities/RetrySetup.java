package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetrySetup implements IRetryAnalyzer {

    private int retryCount = 0;

    private static final int MAXRETRIES = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount < MAXRETRIES){
            retryCount++;
            System.out.println(" Retrying the test "+iTestResult.getName()+" For Times: "+retryCount);
            return true;
        }
        return false;
    }
}
