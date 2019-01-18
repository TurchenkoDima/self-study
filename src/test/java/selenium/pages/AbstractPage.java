package selenium.pages;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import selenium.components.AbstractComponent;

import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {

    protected WebDriver driver;

    public abstract void open();

    public AbstractPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
}
