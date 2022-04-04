package pageobjects.parabank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FindTransactionsPage {

    @FindBy(how= How.XPATH, using="//input[@id='criteria.amount']")
    public WebElement txt_amount;

    @FindBy(how= How.XPATH, using="//div[9]/button")
    public WebElement btn_findbyamount;

}
