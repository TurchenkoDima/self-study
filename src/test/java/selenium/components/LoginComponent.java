package selenium.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginComponent extends AbstractComponent{

    @FindBy(id = "mailbox:login")
    WebElement usernameInput;

    @FindBy(id = "mailbox:password")
    WebElement passwordInput;

    public LoginComponent(WebDriver driver) {
        super(driver);
    }

    public void clickToLogin() {

    }

    public void  enterCredential (String username, String password){
        usernameInput.clear();
        usernameInput.sendKeys(username);

        passwordInput.clear();
        passwordInput.sendKeys(password);
    }


}
