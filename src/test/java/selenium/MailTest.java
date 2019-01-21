package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import selenium.pages.LoginPage;
import selenium.pages.MainPage;
import selenium.util.DriverSingleton;

public class MailTest {

    private WebDriver driver;

    @DataProvider(name = "loginData")
    public Object[][] loginData(){
        return new Object[][]{
                {"375445930312vk@mail.ru","bk-zhlobin#13"}
        };
    }

    @BeforeSuite
    public void testbefore(){
        driver = DriverSingleton.getDriver();
    }

    @Test(dataProvider = "loginData")
    public void oneCanLoginToMail(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.enterCredential(username, password);
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isLogined(username));
    }

    @AfterSuite
    public void testafter(){
        DriverSingleton.closeDriver();
    }
}
