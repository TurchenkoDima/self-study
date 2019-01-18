package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.pages.LoginPage;

public class MailTest {

    LoginPage loginPage;

    @DataProvider(name = "loginData")
    public Object[][] loginData(){
        return new Object[][]{
                {"375445930312vk@mail.ru","bk-zhlobin#13"}
        };
    }

    @BeforeSuite
    public void testbefore(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://mail.ru/");
        loginPage = new LoginPage(driver);
    }

    @Test(dataProvider = "loginData")
    public void oneCanLoginToMail(String username, String password){
        loginPage.open();
        loginPage.enterCredential(username, password);

    }
}
