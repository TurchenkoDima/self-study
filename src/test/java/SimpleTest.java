import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import resources.IgnoreTest;

@Listeners(SimpleTestListener.class)

public class SimpleTest {

    @DataProvider(name = "datatest")
    public Object[][] datatest(){
        return new Object [][]{
                {1,1},
                //{1,2},
                //{2,3},
                {5,5},
                {10,10}
        };
    }



    @Test(groups = "unit", dataProvider = "datatest", alwaysRun = true)
    public void firstTest(int exp,int fact){
        Assert.assertEquals(fact,exp);
    }

    @IgnoreTest(enabled = false)
    @Parameters({"aa","bb"})
    @Test(groups = "unit")
    public void thirdTest(){
        Assert.assertTrue(true);
    }

}
