package sanity;

import extentions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class ParabankWebDB extends CommonOps {
    @Test(description="Test01 - login With DB")
    @Description("This Test login to Parabank using DB credentials and verifies the table title")
    public void test01_loginWithDB(){
        WebFlows.loginDB();
        Verifications.verifyTextInElement(parabankMain.title_Overview,"Accounts Overview");
    }

}
