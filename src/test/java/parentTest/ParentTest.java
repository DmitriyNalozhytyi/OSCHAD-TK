package parentTest;

import chooseCommitteesTest.ChooseCommitteesTest;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ChooseCommitteesPage;
import pages.QuestionPage;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;

    protected static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    protected ChooseCommitteesPage chooseCommitteesPage;
    protected QuestionPage questionPage;

    @Before
    public void setUp(){
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        chooseCommitteesPage = new ChooseCommitteesPage(webDriver);
        questionPage = new QuestionPage(webDriver);
    }
    @After
    public void tearDown(){
        webDriver.quit();
    }
   protected void checkExpectedResult(String message, boolean actualResult){
       Assert.assertEquals(message, true, actualResult);
   }
}
