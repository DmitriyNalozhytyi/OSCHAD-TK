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
    WebDriver webDriver;

    protected static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    Logger logger = Logger.getLogger(getClass());

    protected ChooseCommitteesPage chooseCommitteesPage;
    protected QuestionPage questionPage;
    protected MeetingsPage meetingsPage;
    protected SolutionPage solutionPage;
    protected OutlookPage outlookPage;
    protected ParentPage parentPage;
    protected AutorizationPageSafeDox autorizationPageSafeDox;
    String browser = System.getProperty("browser");


    @Before
    public void setUp(){

        initDriver();

       // File file = new File("./src/drivers/chromedriver.exe");
       // System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

       // webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        chooseCommitteesPage = new ChooseCommitteesPage(webDriver);
        questionPage = new QuestionPage(webDriver);
        meetingsPage = new MeetingsPage(webDriver);
        solutionPage = new SolutionPage(webDriver);
        outlookPage = new OutlookPage(webDriver);
        parentPage = new ParentPage(webDriver);
        autorizationPageSafeDox = new AutorizationPageSafeDox(webDriver);

    }
    @After
    public void tearDown(){

      //  webDriver.quit();
    }
   protected void checkExpectedResult(String message, boolean actualResult){
       Assert.assertEquals(message, true, actualResult);
   }

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
     //           protected void finished(Description description) {
     //               logger.info(String.format("Finished test: %s::%s", description.getClassName(), description.getMethodName()));
    //                try {
    //                    webDriver.quit();
   //         } catch (Exception e) {
    //           logger.error(e);
    //        }
    //    }


    };




}
