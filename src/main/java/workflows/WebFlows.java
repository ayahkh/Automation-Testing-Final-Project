package workflows;


import extentions.DBActions;
import extentions.UIActions;
import extentions.Verifications;
import io.qameta.allure.Step;

import utilities.CommonOps;

import java.util.List;


public class WebFlows extends CommonOps {

    @Step("Business Flow: login")
    public static void login(String user,String pass){
        UIActions.updateText(parabankLogin.txt_username,user);
        UIActions.updateText(parabankLogin.txt_password,pass);
        UIActions.click(parabankLogin.btn_login);

    }

    @Step("Business Flow: login to ParaBank with DB Credentials")
    public static void loginDB(){
        String query="SELECT name, password FROM Employees WHERE id='5' ";
     List<String> creds=   DBActions.getCredentials(query);
        UIActions.updateText(parabankLogin.txt_username,creds.get(0));
        UIActions.updateText(parabankLogin.txt_password,creds.get(1));
        UIActions.click(parabankLogin.btn_login);

    }


    @Step("Business Flow: open new account")
    public static void openNewAccount(String account_type,String account_from){
        UIActions.click(parabankBottomLeftMenu.btn_open);
        UIActions.updateDropDown(parabankOpenNewAccount.select_type,account_type);
        UIActions.updateDropDown(parabankOpenNewAccount.select_account,account_from);
        UIActions.click(parabankOpenNewAccount.btn_open);

    }
    @Step("Business Flow: Search and Find Transactions")
    public static void findTransactions(String amount, String shouldExist ){
        UIActions.updateTextHuman(parabankFindTransactions.txt_amount,amount);
        UIActions.click(parabankFindTransactions.btn_findbyamount);
if(shouldExist.equalsIgnoreCase("exists"))
    Verifications.existenceOfElement(parabankTransactionsResults.table_rows);

else if(shouldExist.equalsIgnoreCase("not-exists"))
    Verifications.nonExistenceOfElement(parabankTransactionsResults.table_rows);
else
    throw new RuntimeException("Invalid Expected Output Option in DDT, Should be exists or not-exists");

    }
}
