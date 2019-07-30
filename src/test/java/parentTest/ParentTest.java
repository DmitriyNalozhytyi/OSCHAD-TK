package parentTest;

import chooseCommitteesTest.ChooseCommitteesTest;
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
import pages.ChooseCommitteesPage;
import pages.MeetingsPage;
import pages.QuestionPage;
import pages.SolutionPage;

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

    @Before
    public void setUp(){
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        chooseCommitteesPage = new ChooseCommitteesPage(webDriver);
        questionPage = new QuestionPage(webDriver);
        meetingsPage = new MeetingsPage(webDriver);
        solutionPage = new SolutionPage(webDriver);
    }
    @After
    public void tearDown(){

      //  webDriver.quit();
    }
   protected void checkExpectedResult(String message, boolean actualResult){
       Assert.assertEquals(message, true, actualResult);
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

        @Override
                protected void finished(Description description) {
                    logger.info(String.format("Finished test: %s::%s", description.getClassName(), description.getMethodName()));
                    try {
                        webDriver.quit();
            } catch (Exception e) {
               logger.error(e);
            }
        }
    };




}
