import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import resources.IgnoreTest;

public class SecondTest {

    private int exp;
    private int fact;

    public SecondTest(int exp, int fact) {
        this.exp = exp;
        this.fact = fact;
    }

    @Test(groups = "unit")
    public void testMethod(){
        Assert.assertEquals(fact,exp);
    }
    @IgnoreTest
    @Parameters({"aa","bb"})
    @Test(groups = "unit", alwaysRun = true)
    public void secondTest(int exp,int fact){
        Assert.assertEquals(fact,exp);
    }

}
