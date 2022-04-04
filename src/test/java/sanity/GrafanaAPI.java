package sanity;

import extentions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.APIFlows;


@Listeners(utilities.Listeners.class)
public class GrafanaAPI extends CommonOps {

    @Test(description = "Test01 - Verify Team")
    @Description("This Test Verifies Team Property")
    public void test01_verifyTeam() {

        Verifications.verifyText(APIFlows.getTeamProperty("teams[0].name"),"automation");

    }

    @Test(description = "Test02 - Add Team And Verify")
    @Description("This Test Adds a New Team and Verifies")
    public void test02_addTeamAndVerify() {

        APIFlows.postTeam("NewTeam","New@team.com");
        Verifications.verifyText(APIFlows.getTeamProperty("teams[0].name"),"NewTeam");

    }

   @Test(description = "Test03 - Update Team And Verify")
    @Description("This Test Updates a Team and Verifies")
   public void test03_updateTeamAndVerify() {
        String id =APIFlows.getTeamProperty("teams[0].id");
        APIFlows.updateTeam("NewTeam","New@hotmail.com",id);
      Verifications.verifyText(APIFlows.getTeamProperty("teams[0].email"),"New@hotmail.com");

    }


    @Test(description = "Test04 - Delete Team And Verify")
    @Description("This Test Deletes a Team and Verifies")
    public void test04_deleteTeamAndVerify() {
        String id =APIFlows.getTeamProperty("teams[0].id");
        APIFlows.deleteTeam(id);
        Verifications.verifyText(APIFlows.getTeamProperty("totalCount"),"1");

    }



}
