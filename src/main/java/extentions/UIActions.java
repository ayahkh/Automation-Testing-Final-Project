package extentions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;
import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOps {


    @Step("Click on Element")
    public static void click(WebElement elem){

        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();

    }

    @Step("Update Text of Element")
    public static void updateText(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Update Text of Element as Human")
    public static void updateTextHuman(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
       for(char ch: text.toCharArray()) {
           Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
           elem.sendKeys(ch + "");
       }
       }


    @Step("Update DropDown Element")
    public static void updateDropDown(WebElement elem,String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropDown= new Select(elem);
        dropDown.selectByVisibleText(text);
    }

    @Step("Hover Over Element")
    public static void mouseHover(WebElement elem){

         action.moveToElement(elem).click().build().perform();
    }

    @Step("Insert Key")
    public static void insertKey(WebElement elem, Keys value){

        elem.sendKeys(value);
    }

}
