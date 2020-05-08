package parentTest;

import io.qameta.allure.Attachment;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {

    // прокидываение драйвера: 1) создаем объект webDriver перед секцией @Before
    // (вынесли за рамки метода, чтобы он был виден не только в нем, но и за его пределами)

    WebDriver webDriver;

    // создаем объект для работы с Excel, который будет работать с файлами .propesties
    // этот объект "configProperties"сможет идти в эти файлы и забирать оттуда данные,
    // при этом ConfigFactory создает набор этих значений (ключ-значение; ключ-значение),
    // , которые описанны в классе ConfigProperties (папка libs)

    protected static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    // подключаем Logger - создаем объект, который будет писать лог

    Logger logger = Logger.getLogger(getClass());

    // прокидываение драйвера: 2) объявляем объекты пейджей перед секцией @Before
    // (вынесли за рамки метода, чтобы они были видны не только в нем, но и за его пределами)
    // , которым на вход (в секции @Before)быдем давать webDriver

    protected ChooseCommitteesPage chooseCommitteesPage;
    protected QuestionPage questionPage;
    protected MeetingsPage meetingsPage;
    protected SolutionPage solutionPage;
    protected OutlookPage outlookPage;
    protected ParentPage parentPage;
    protected AutorizationPageSafeDox autorizationPageSafeDox;

    // обьявляем переменную (используем библиотеку System ) в которой будет храниться указание, какой браузер.
    // а сама обработка этой переменной (browser) будет происходить именно в методе "public void initDriver()"

    //в классе System определены методы, предназначенные для работы с системными свойствами класса Properties.
    // Здесь мы получаем путь к текущему каталогу в виде текстовой строки класса String.

    String browser = System.getProperty("browser");

    // секция @Before запускается перед каждым тестом - в ней мы говорим, чтобы все страницы работали с одним браузером,
    // т.е. тут инициализируем webDriver и объекты пейджей

    @Before
    public void setUp(){

        // прокидываение драйвера: 3) (инициация webDriver) в секции @Before.
        // по классике это была строчка webDriver = new ChromeDriver();, когда работали только с Хромом

        // следующие 3 строки - это инициализация Хрома, однако, для работы с разными браузерами мы этот блок перенесли
        // в приватный метод (public void initDriver()), который под секцией @Before

        // File file = new File("./src/drivers/chromedriver.exe");
        // System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        // webDriver = new ChromeDriver();

        // а в том месте, где удалили - вызовем этот метод "initDriver();":

        initDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // прокидываение драйвера: 4) инициализируем объекты пейджей ( говорим, чтобы эти объекты работали с браузером webDriver - даем на вход webDriver):
        //  прокидывания webDriver рассмотрим на примере класса с тестами "QuestionTestFlow" и классом страницы "QuestionPage"  (топаем туда)

        chooseCommitteesPage = new ChooseCommitteesPage(webDriver);
        questionPage = new QuestionPage(webDriver);
        meetingsPage = new MeetingsPage(webDriver);
        solutionPage = new SolutionPage(webDriver);
        outlookPage = new OutlookPage(webDriver);
        parentPage = new ParentPage(webDriver);
        autorizationPageSafeDox = new AutorizationPageSafeDox(webDriver);
    }

    // секция @After запускается после каждого теста

    @After

    public void tearDown(){

        // метод .quit() - закрывает все открытые окна,завершает работу браузера и сервисов, и освобождает все ресурсы.

        //  webDriver.quit();

    }

    // метод для проверки ожидаемого результата. в нем:
    // Assert (джейюнитовский) . в нем любой assertEquals
    //  в параметрах для Assert - в actualResult приходит true/false и сравнивается со 2м параметром (true):
    // - если пришло true , то true=true - программа идет дальше
    // - если пришло false, то true не равно false - в результате віводится сообщение, которое в 3м параметре "message"

   protected void checkExpectedResult(String message, boolean actualResult){
       Assert.assertEquals(message, true, actualResult);
   }

   // Мы перенесли инициацию хрома в отдельный метод initDriver (из секции @Before)
   // в котором будем инициализировать разные браузеры (обрабатіваем переменную "browser")
    // здесь метод  toLowerCase – понижает браузер до нижнего регистра, если ошибемся(необязательный)

   public void initDriver() {

       if (browser == null || "chrome".equals(browser.toLowerCase())) {
           File file = new File("./src/drivers/chromedriver.exe");
           System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

           webDriver = new ChromeDriver();
       } else if ("firefox".equals(browser)) {
           File file = new File("./src/drivers/geckodriver.exe");
           System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
           FirefoxOptions profile = new FirefoxOptions();
           profile.addPreference("browser.startup.page", 0);
           profile.addPreference("browser.startup.homepage_override.mstone", "ignore");

           webDriver = new FirefoxDriver();
       } else if ("iedriver".equals(browser)){
           File file1 = new File("./src/drivers/IEDriverServer.exe");
           System.setProperty("webdriver.ie.driver", file1.getAbsolutePath());
           DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
           capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
           capabilities.setCapability("ignoreZoomSetting",true);
           capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);

           webDriver = new InternetExplorerDriver();

       }
   }

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        String fileName;
        @Override
        protected void failed(Throwable e, Description description) {
            screenshot();
        }
        @Attachment(value = "Page screenshot", type = "image/png")
        public byte[] saveScreenshot(byte[] screenShot) {
            return screenShot;
        }
        public void screenshot() {
            if (webDriver == null) {
                logger.info("Driver for screenshot not found");
                return;
            }
            saveScreenshot(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES));
        }

     //     @Override
     //  protected void finished(Description description) {
     //  logger.info(String.format("Finished test: %s::%s", description.getClassName(), description.getMethodName()));
     //                try {
     //                    webDriver.quit();
     //         } catch (Exception e) {
     //           logger.error(e);
     //        }
     //    }

    };

}
