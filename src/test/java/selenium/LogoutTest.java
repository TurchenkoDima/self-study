package selenium;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.pages.LoginPage;
import selenium.pages.MainPage;
import selenium.util.DriverSingleton;

public class LogoutTest {
    private WebDriver driver;
    private static final String USERNAME = "375445930312vk@mail.ru";
    private static final String PASSWORD = "bk-zhlobin#13";

    @BeforeSuite()
    public void testbefore(){
        driver = DriverSingleton.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.enterCredential(USERNAME, PASSWORD);
    }

    @Test()
    public void oneCanLogOut(){
        MainPage mainPage = new MainPage(driver);
        mainPage.logout();
        Assert.assertTrue(mainPage.isLoginout()) ;
    }

    @AfterSuite
    public void testafter(){
        DriverSingleton.closeDriver();
    }
}
