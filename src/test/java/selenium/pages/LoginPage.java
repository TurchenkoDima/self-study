package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.components.LoginComponent;

public class LoginPage extends AbstractPage {

    private final String BASE_URL = "https://mail.ru/";

    private LoginComponent loginComponent;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        loginComponent = new LoginComponent(driver);
    }

    @Override
    public void open() {
        driver.navigate().to(BASE_URL);
    }

    public void enterCredential(String username, String password){
        loginComponent.enterCredential(username,password);
    }

}
