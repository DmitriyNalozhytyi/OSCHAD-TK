package libs;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    }
