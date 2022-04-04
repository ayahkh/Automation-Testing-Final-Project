package sanity;

import extentions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;


@Listeners(utilities.Listeners.class)
public class MortgageMobile extends CommonOps {

    @Test(description="Test01 - Verify Mortgage")
    @Description("This Test fills in mortgage fields and calculates repayment")
    public void test01_verifyMortgage(){
        MobileFlows.calculateMortgage("1000","3","4");
        Verifications.verifyTextInElement(mortgageMain.txt_repayment,"£30.03");
    }

}
