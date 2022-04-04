package extentions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.*;


public class Verifications extends CommonOps {

    @Step("Verify Text In Element")
    public static void verifyTextInElement(WebElement elem, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }

    @Step("Verify Number Of Elements")
    public static void verifyNumberOfElements(List<WebElement> elems, int expected){
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        assertEquals(elems.size(), expected);

    }

    @Step("Verify Visibility Of Elements")
   public static void visibilityOfElements(List<WebElement> elems){
        for(WebElement elem: elems){
            softAssert.assertTrue(elem.isDisplayed(),"Sorry " + elem.getText()+"isn't displayed");
        }
        softAssert.assertAll("some elements weren't displayed");
}

@Step("Verify Element Visually")
public static void visualElement(String expectedImageName)
{
    try {
        screen.find(getData("ImageRepo") + expectedImageName +".png");
    } catch (FindFailed findFailed) {
        System.out.println("Error Comparing Image File:"+ findFailed);
        fail("Error Comparing Image File:"+ findFailed);
    }
}

@Step("Verify Element Displayed")
    public static void existenceOfElement(List<WebElement>elements){
        assertTrue(elements.size()>0);

}

    @Step("Verify Element Not Displayed")
    public static void nonExistenceOfElement(List<WebElement>elements){
        assertFalse(elements.size()>0);

    }

    @Step("Verify If Text is Equal to Text")
    public static void verifyText(String actual, String expected){
        assertEquals(actual,expected);
    }

    @Step("Verify Number with Number")
    public static void verifyNumber(int actual, int expected){
        assertEquals(actual,expected);
    }
}
