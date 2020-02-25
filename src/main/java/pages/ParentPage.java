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
    // less 13 - p 30:
    Logger logger = Logger.getLogger(getClass());


    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
       // Для того, чтобы Selenium создал все элементы на этой странице, описанными @FindBy- на нужно дать ему команду – создай все объекты. (команда PageFactory)для инициации обьектов через @FindBy. иначе не увидит обьектов:
        PageFactory.initElements(webDriver, this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);

    }

    public void exitTest() {
        webDriver.quit();
    }


}

