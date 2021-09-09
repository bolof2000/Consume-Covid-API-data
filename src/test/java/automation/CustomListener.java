package automation;

import org.slf4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener{


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getStartMillis());
        System.out.println(result.getTestClass());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getStatus());
    }


    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println(context.getStartDate());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println(context.getPassedTests().getAllResults());
    }
}
