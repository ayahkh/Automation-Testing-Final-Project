package sanity;

import extentions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class ToDoListElectron extends CommonOps {

    @Test(description="Test01 - Add and Verify New Task")
    @Description("This Test adds and verifies a new task")
    public void test01_AddandVerifyNewTask(){
        ElectronFlows.addNewTask("learn java");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(),1);
    }

    @Test(description="Test02 - Add and Verify New Tasks")
    @Description("This Test adds and verifies  new tasks")
    public void test02_AddandVerifyNewTasks(){
        ElectronFlows.addNewTask("learn java");
        ElectronFlows.addNewTask("learn python");
        ElectronFlows.addNewTask("learn excel");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(),3);
    }


}
