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

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogined(String username){

        return usernameLabel.getText().equals(username);
    }
}
