package pageobjects.parabank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {
    @FindBy(how= How.CLASS_NAME, using="title")
    public WebElement title_Overview;

    @FindBy(how= How.XPATH, using="//ul[@class='button']/li")
    public List<WebElement> list_Welcome;

}
