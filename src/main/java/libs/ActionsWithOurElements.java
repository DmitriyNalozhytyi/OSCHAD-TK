package libs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ActionsWithOurElements {
    WebDriver webDriver;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait10 = new WebDriverWait(webDriver, 60);
    }

    WebDriverWait wait10;

    public void enterTextInToElement(WebElement element, String text) {
        try {
            element.sendKeys(text);
            System.out.println(text + "was input into element");
        } catch (Exception e) {
            System.out.println("Can't enter text in to field" + e);
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
            System.out.println(element + "Element was clicked");
        } catch (Exception e) {
            System.out.println("Can't click on Element");
            printErrorAndStopTest(e);
        }
    }

     public void changeFrameWithWait(WebElement element) {
        try {
            webDriver.switchTo().defaultContent();
            Thread.sleep(7000);
            webDriver.switchTo().frame(webDriver.findElements(By.tagName("iframe")).size() - 1);
            Thread.sleep(7000);
         //   element.click();
            System.out.println("Frame was changed");
        }catch (Exception e) {
            System.out.println("Can't change frame");
            printErrorAndStopTest(e);
        }
    }

    public void quiteFromAllFrames(WebElement element) {
        try {
            Thread.sleep(7000);
            webDriver.switchTo().defaultContent();
            Thread.sleep(7000);
            System.out.println("quite from All Frames");
        }catch (Exception e) {
            System.out.println("Can't change frame");
            printErrorAndStopTest(e);
        }
    }

    public void enterTextInToPeopePickerFieldUsingEnter(WebElement element, String text) {
        try {
            element.sendKeys(text);
            Thread.sleep(5000);
            element.sendKeys(Keys.ENTER);
            Thread.sleep(5000);
            System.out.println(text + "was input into element");
        } catch (Exception e) {
            System.out.println("Can't enter text in to fieldExecutor" + e);
            printErrorAndStopTest(e);
        }

   }
    public void openFirstFrame (WebElement element) {
        try {
            webDriver.switchTo().frame(webDriver.findElements(By.tagName("iframe")).size() - 1);
            System.out.println("First Frame was open");

        }catch (Exception e) {
            System.out.println("Can't change frame");
            printErrorAndStopTest(e);
        }
    }

    public void clickOnLastElement() {
        try {
            List<WebElement> closeButtons = webDriver.findElements(By.className("ms-dlgCloseBtn"));

            System.out.println(closeButtons.size() + " - number of same elements");
            if(closeButtons.size() > 0) {
                closeButtons.get(closeButtons.size()-1).click();
                System.out.println("CloseButton was clicked");
            }else{
                System.out.println("!!! number of same elements '0'!!! ");
            }
            }catch (Exception e) {
                System.out.println("Can't enter text in to fieldExecutor" + e);
                printErrorAndStopTest(e);
            }
    }
}


