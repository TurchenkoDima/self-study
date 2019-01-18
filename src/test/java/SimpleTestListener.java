import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SimpleTestListener implements ITestListener {

    final static Logger logger = (Logger) Logger.getLogger(SimpleSuiteListener.class);
    private long time;


    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info(iTestResult.getTestClass()+ " " + iTestResult.getName()+" started!!!");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        time = iTestResult.getEndMillis()-iTestResult.getStartMillis();
        iTestResult.getMethod().setDescription(String.valueOf(time));
        //Data.setToMap(iTestResult.getMethod().getMethodName(),iTestResult.getEndMillis()-iTestResult.getStartMillis());
        logger.info(iTestResult.getTestClass()+ " " + iTestResult.getName()+" finished success!!!");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("The name of the testcase failed is :"+iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
