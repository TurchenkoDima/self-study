package selenium.components;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginComponent extends AbstractComponent{

    private WebElement passwordInput;
    private WebElement usernameInput;
    private WebElement loginButton;


    public LoginComponent(WebDriver driver) {
        super(driver);
    }

    public void  enterCredential (String username, String password){
        passwordInput = wait
                .until((Function<WebDriver, WebElement>) driver -> driver.findElement(By.id("mailbox:password")));
        usernameInput = wait
                .until((Function<WebDriver, WebElement>) driver -> driver.findElement(By.id("mailbox:login")));
        usernameInput.clear();
        usernameInput.sendKeys(username);

        passwordInput.clear();
        passwordInput.sendKeys(password);

        loginButton = wait
                //.until((Function<WebDriver, WebElement>) driver -> driver.findElement(By.xpath("//*[@value = 'Войти']")));
                .until((Function<WebDriver, WebElement>) driver -> driver.findElement(By.id("mailbox:submit")));
        Actions actions = new Actions(driver);
        actions.moveToElement(loginButton).click().perform();
    }
}
