package selenium.components;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginComponent extends AbstractComponent{

    WebElement passwordInput;
    WebElement usernameInput;


    public LoginComponent(WebDriver driver) {
        super(driver);
    }

    public void clickToLogin() {

    }

    public void  enterCredential (String username, String password){
        passwordInput = wait
                .until((Function<WebDriver, WebElement>) driver-> driver.findElement(By.id("mailbox:password")));
        usernameInput = wait
                .until((Function<WebDriver, WebElement>) driver -> driver.findElement(By.id("mailbox:login")));
        usernameInput.clear();
        usernameInput.sendKeys(username);

        passwordInput.clear();
        passwordInput.sendKeys(password);
    }


}
