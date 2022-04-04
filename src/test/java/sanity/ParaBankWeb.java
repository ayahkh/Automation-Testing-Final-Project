package sanity;


import extentions.UIActions;
import extentions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;
import static org.testng.AssertJUnit.fail;


@Listeners(utilities.Listeners.class)
public class ParaBankWeb extends CommonOps {

    @Test(description="Test01 - Verify Table Title")
    @Description("This Test login and verifies the table title")
    public void test01_verifyTableTitle(){
        WebFlows.login("john","demo");
        Verifications.verifyTextInElement(parabankMain.title_Overview,"Accounts Overview");
    }



    @Test(description="Test02 - Verify Number Of Accounts")
    @Description("This Test clicks on accounts overview and verifies the number of accounts")
    public void test02_verifyNumberOfAccounts(){
        UIActions.click(parabankBottomLeftMenu.btn_accounts);
        Verifications.verifyNumberOfElements(parabankAccountsOverview.account_rows,1);
    }

    @Test(description="Test03 - Verify New Account")
    @Description("This Test verifies if new account has been added")
   public void test03_verifyNewAccount(){
       try {
           WebFlows.openNewAccount("SAVINGS", "13344");
           Verifications.verifyNumberOfElements(parabankAccountsOverview.account_rows, 2);
       }
       catch (ArrayIndexOutOfBoundsException e) {
           System.out.println("please enter a valid account" + e);
           fail("please enter a valid account" + e);

        }

       }

    @Test(description="Test04 - Verify Welcome Options")
    @Description("This Test verifies if welcome options are displayed (using soft assertion)")
    public void test04_verifyWelcomeOptions(){
        Verifications.visibilityOfElements(parabankMain.list_Welcome);
    }

    @Test(description="Test05 - Verify Home Icon")
    @Description("This Test verifies the home image using sikuli tool)")
    public void test05_verifyHomeIcon(){
        Verifications.visualElement("ParabankHomeIcon");
    }

    @Test(description="Test06 - Search Transactions",dataProvider = "data-provider-amounts", dataProviderClass = utilities.ManageDDT.class)
    @Description("This Test searches the transactions using ddt)")
    public void test06_searchTransactions(String amount, String shouldExist){
        UIActions.click(parabankBottomLeftMenu.btn_find);
        WebFlows.findTransactions(amount,shouldExist);

    }



}

