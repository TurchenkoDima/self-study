package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import selenium.components.LoginComponent;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private final String BASE_URL = "https://mail.ru/";
    private WebDriver driver;
    private Wait wait;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
        wait = new FluentWait<>(driver)
                //.withTimeout(30, TimeUnit.SECONDS)
                //.pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        //PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(BASE_URL);
    }

    public void enterCredential(String username, String password){
        LoginComponent loginComponent = new LoginComponent(driver);
        loginComponent.enterCredential(username,password);
    }
}
