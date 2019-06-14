package libs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithOurElements {
    WebDriver webDriver;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait10 = new WebDriverWait(webDriver, 60);
    }

    WebDriverWait wait10;

    public void enterTextInToElement(WebElement element, String text) {
        try {
            //element.click();
            // element.clear();
            element.sendKeys(text);
            System.out.println(text + "was input into element");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }



    private void printErrorAndStopTest(Exception e) {
        System.out.println("Can't work with element" + e);
        Assert.fail("Can't work with element" + e);
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            System.out.println("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

        public void clickOnElementFrame (WebElement element){
            try {
               Thread.sleep(10000);
               element.click();
               System.out.println("Element was clicked");
            } catch (Exception e) {
                printErrorAndStopTest(e);
            }
        }

    public void clickOnElementChangeFrame(WebElement element) {
        try {
            webDriver.switchTo().defaultContent();
            Thread.sleep(10000);
            webDriver.switchTo().frame(webDriver.findElements(By.tagName("iframe")).size() - 1);
            Thread.sleep(10000);
            element.click();
        }catch (Exception e) {
            printErrorAndStopTest(e);
        }


    }

    public void enterTextInToElementInNewFrame(WebElement webElement, String text) {
        try {
            webDriver.switchTo().defaultContent();
            Thread.sleep(10000);
            webDriver.switchTo().frame(webDriver.findElements(By.tagName("iframe")).size() - 1);
            Thread.sleep(10000);
            webElement.sendKeys(text);
        }catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }


    public void choosePeopleInPeopePickerField(WebElement element, String text) {
        try {

            element.sendKeys(text);
           Select dropDown = new Select(webDriver.findElement(By.id("LSCMTStagesEx_a407fb50-774d-4cd8-bc7b-9ad14e83902f_$ClientPeoplePicker_AutoFillDiv_MenuList")));
            dropDown.selectByIndex(0);
            System.out.println(text + "was input into element");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }

    }
}




