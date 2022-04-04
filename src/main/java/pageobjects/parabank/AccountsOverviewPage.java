package pageobjects.parabank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class AccountsOverviewPage {
    @FindBy(how= How.CSS, using="tr[ng-repeat='account in accounts']")
    public List<WebElement> account_rows;



}
