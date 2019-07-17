package libs;


import org.apache.log4j.Logger;
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
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait10 = new WebDriverWait(webDriver, 60);
    }

    WebDriverWait wait10;

    public void enterTextInToElement(WebElement element, String text) {
        try {
            element.sendKeys(text);
            logger.info(text + "was input into element");
            //System.out.println(text + "was input into element");
        } catch (Exception e) {
            System.out.println("Can't enter text in to field" + e);
            printErrorAndStopTest(e);
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.info("Can't work with element" + e);
        //System.out.println("Can't work with element" + e);
        Assert.fail("Can't work with element" + e);
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked");
            //System.out.println(element + "Element was clicked");
        } catch (Exception e) {
            System.out.println("Can't click on Element");
            printErrorAndStopTest(e);
        }
    }

     public void changeFrameWithWait(WebElement element) {
        try {
            webDriver.switchTo().defaultContent();
            Thread.sleep(15000);
            webDriver.switchTo().frame(webDriver.findElements(By.tagName("iframe")).size() - 1);
            Thread.sleep(15000);
         //   element.click();
            logger.info("Frame was changed");
           // System.out.println("Frame was changed");
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
            logger.info("quite from All Frames");
            //System.out.println("quite from All Frames");
        }catch (Exception e) {
            logger.info("quite from All Frames");
            //System.out.println("Can't change frame");
            printErrorAndStopTest(e);
        }
    }

    public void enterTextInToPeopePickerFieldUsingEnter(WebElement element, String text) {
        try {
            element.sendKeys(text);
            Thread.sleep(5000);
            element.sendKeys(Keys.ENTER);
            Thread.sleep(5000);
            logger.info(text + "was input into element");
           // System.out.println(text + "was input into element");
        } catch (Exception e) {
            logger.info("Can't enter text in to fieldExecutor" + e);
            //System.out.println("Can't enter text in to fieldExecutor" + e);
            printErrorAndStopTest(e);
        }

   }
    public void openFirstFrame (WebElement element) {
        try {
            webDriver.switchTo().frame(webDriver.findElements(By.tagName("iframe")).size() - 1);
            logger.info("First Frame was open");
            //System.out.println("First Frame was open");

        }catch (Exception e) {
            logger.info("Can't change frame");
            //System.out.println("Can't change frame");
            printErrorAndStopTest(e);
        }
    }

    public void clickOnLastElement() {
        try {
            List<WebElement> closeButtons = webDriver.findElements(By.className("ms-dlgCloseBtn"));

            logger.info(closeButtons.size() + " - number of same elements");
            //System.out.println(closeButtons.size() + " - number of same elements");
            if(closeButtons.size() > 0) {
                closeButtons.get(closeButtons.size()-1).click();
                logger.info("CloseButton was clicked");
               // System.out.println("CloseButton was clicked");
            }else{
                logger.info("!!! number of same elements '0'!!! ");
              //  System.out.println("!!! number of same elements '0'!!! ");
            }
            }catch (Exception e) {
                logger.info("Can't enter text in to fieldExecutor" + e);
               // System.out.println("Can't enter text in to fieldExecutor" + e);
                printErrorAndStopTest(e);
            }
    }

    public boolean isElementPresent(WebElement webElement){
        try {
            boolean isDisplayed = webElement.isDisplayed();
            logger.info("Element is displayed -->" + isDisplayed);
            return webElement.isDisplayed();
        }catch (Exception e){
            logger.info("Element is displayed --> false");
            return false;
        }
    }
}


