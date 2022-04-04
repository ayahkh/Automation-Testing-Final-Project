package utilities;

import org.openqa.selenium.support.PageFactory;
import pageobjects.parabank.*;

public class ManagePages extends Base {
    public static void initParaBank(){
    parabankLogin = PageFactory.initElements(driver, pageobjects.parabank.LoginPage.class);
    parabankMain = PageFactory.initElements(driver, pageobjects.parabank.MainPage.class);
    parabankBottomLeftMenu= PageFactory.initElements(driver, BottomLeftMenuPage.class);
    parabankAccountsOverview= PageFactory.initElements(driver, AccountsOverviewPage.class);
    parabankOpenNewAccount=PageFactory.initElements(driver, OpenNewAccountPage.class);
    parabankFindTransactions=PageFactory.initElements(driver, FindTransactionsPage.class);
    parabankTransactionsResults=PageFactory.initElements(driver, TransactionsResultsPage.class);
    }

   public static void initMortgage(){
       mortgageMain = new pageobjects.mortgage.MainPage(mobileDriver);
    }

    public static void initToDo(){
        todoMain= PageFactory.initElements(driver,pageobjects.todo.MainPage.class);
    }

    public static void initCalculator(){
        calcMain=PageFactory.initElements(driver,pageobjects.calculator.MainPage.class);
    }
}
