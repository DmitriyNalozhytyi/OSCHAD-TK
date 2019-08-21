package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class ParentPage {
    WebDriver webDriver;
    ActionsWithOurElements actionsWithOurElements;
    Logger logger = Logger.getLogger(getClass());


    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);

    }

    public void exitTest() {
        webDriver.quit();
    }


}

