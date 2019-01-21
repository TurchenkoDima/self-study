package selenium.pages;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.components.AbstractComponent;

import java.util.concurrent.TimeUnit;

public class MainPage {

    private WebDriver driver;
    private static final String logoutPhraseOnMainPage = "Регистрация";

    //@FindBy(className = "pm-logo__link__pic")
    private WebElement usernameLabel;

    //@FindBy(xpath = "//*[@id='b-nav_folders']//span[@class= 'b-nav__item__text b-nav__item__text_unread']")
    private WebElement incomingMessageLabel;

    //@FindBy(id = "PH_user-email")
    private WebElement mainLogoImg;

    //@FindBy(className = "b-toolbar__btn__text b-toolbar__btn__text_pad")
    private WebElement writeMessageButton;

    //@FindBy(xpath = "//*[text()='выход']")
    //@FindBy(id = "PH_logoutLink")
    //private WebElement logoutButton;

    public MainPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLogined(String username){
        usernameLabel = new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.id("PH_user-email")));
        if(!usernameLabel.getText().equals(username))
            return false;
        writeMessageButton = new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By
                        .className("b-toolbar__btn__text b-toolbar__btn__text_pad")));
        if(writeMessageButton.isDisplayed())
            return false;
        incomingMessageLabel = new WebDriverWait(driver, 30).until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath("//*[@id='b-nav_folders']//span[@class= 'b-nav__item__text b-nav__item__text_unread']")));
        return !incomingMessageLabel.isDisplayed();
    }

    public void logout() {

        //logoutButton = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("PH_logoutLink")));

        WebElement logoutButton = new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.id("PH_logoutLink")));
        driver.get(logoutButton.getAttribute("href"));
    }

    public boolean isLoginout(){
        usernameLabel = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("PH_user-email")));
        return usernameLabel.getText().equals(logoutPhraseOnMainPage);
    }
}
