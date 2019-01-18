package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.components.AbstractComponent;

public class MainPage extends AbstractComponent {

    @FindBy(id = "PH_user-email")
    WebElement usernameLabel;

    @FindBy(id = "//*[@id=\"b-nav_folders\"]//span[@class = \"b-nav__item__text b-nav__item__text_unread\"]")
    WebElement incomingMessageLabel;

    @FindBy(className = "pm-logo__link__pic")
    WebElement mainLogoImg;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogined(String username){
        if(!mainLogoImg.isDisplayed())
            return false;
        if(!incomingMessageLabel.isDisplayed())
            return false;
        return usernameLabel.getText().equals(username);
    }
}
