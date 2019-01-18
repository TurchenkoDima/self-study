import org.apache.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;



public class SimpleSuiteListener implements ISuiteListener {

    final static Logger logger = (Logger) Logger.getLogger(SimpleSuiteListener.class);

    @Override
    public void onStart(ISuite iSuite) {
        //System.out.println("The name of the suite :"+iSuite.getName());
        logger.info("The name of the suite :"+iSuite.getName());
    }

    @Override
    public void onFinish(ISuite iSuite) {
        System.out.println("That`s all!");
        iSuite.getAllMethods().forEach(x->logger.info(x.getMethodName()+": "+x.getDescription()));
        System.out.println("That`s all!");
    }
}
