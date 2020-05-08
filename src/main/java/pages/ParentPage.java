package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



public class ParentPage {

    // прокидываение драйвера: 6.1) вот именно сюда ( WebDriver webDriver;) запишет его с помощью (this.webDriver = webDriver;)
    // в локальную (внутреннюю) переменную для класса ParentPage,с которой будут работать все методы пейджей (в QuestionPage в том же числе):

    WebDriver webDriver;

    ActionsWithOurElements actionsWithOurElements;

    //создаем объект, который будет писать лог и проверяем, чтобы заимпортилась библиотека

    Logger logger = Logger.getLogger(getClass());

    // прокидываение драйвера: 6) пишем конструктор, который:

    // - приймет на вход webDriver  (public ParentPage(WebDriver webDriver))
    // - и запишет его с помощью сеттера (this.webDriver = webDriver;) в локальную (внутреннюю) переменную для класса ParentPage,
    // с которой будут работать все методы QuestionPage

        public ParentPage(WebDriver webDriver) {
            this.webDriver = webDriver;

            // здесь эта команда (PageFactory) говорит Selenium-у – пойди,  в той странице, с которой идет обращение (нарпимер QuestionPage),
            // проинициализируй в этом драйвере все элементы, описанные в @FindBy , иначе Selenium не увидит обьектов!!!
            // здесь в параметрах - 1й параметр говорит, что в том браузере, с которым мы работаем, а 2-й говорит, опиши все страницы этой пейджи, т.е:

        PageFactory.initElements(webDriver, this);

        actionsWithOurElements = new ActionsWithOurElements(webDriver);

    }

     //метод .quite(закрытие браузера)
     // есть метод .close - но только закрывает  вкладки

    public void exitTest() {
        webDriver.quit();
    }
}

