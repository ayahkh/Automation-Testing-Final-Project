package pageobjects.parabank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class OpenNewAccountPage {

    @FindBy(how= How.CSS, using="select[id='type']")
    public WebElement select_type;

    @FindBy(how= How.CSS, using="select[id='fromAccountId']")
    public WebElement select_account;

    @FindBy(how= How.CSS, using="input[type='submit']")
    public WebElement btn_open;

}
