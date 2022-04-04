package pageobjects.parabank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class TransactionsResultsPage {
    @FindBy(how= How.XPATH, using="//td")
    public List<WebElement> table_rows;

}
