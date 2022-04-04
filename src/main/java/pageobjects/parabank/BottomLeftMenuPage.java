package pageobjects.parabank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BottomLeftMenuPage {
    @FindBy(how= How.XPATH, using="//a[text()='Accounts Overview']")
    public WebElement btn_accounts;

    @FindBy(how= How.XPATH, using="//a[text()='Find Transactions']")
    public WebElement btn_find;

    @FindBy(how= How.XPATH, using="//a[text()='Request Loan']")
    public WebElement btn_request;

    @FindBy(how= How.XPATH, using="//a[text()='Open New Account']")
    public WebElement btn_open;



}
