import org.testng.annotations.Factory;

public class SecondTestFactory {

    @Factory
        public Object[] factoryMethod() {
        return new Object[] { new SecondTest(1,1), new SecondTest(1,1) };
    }
}
