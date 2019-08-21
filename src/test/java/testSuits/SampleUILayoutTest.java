package testSuits;

//import com.galenframework.api.Galen;
//import com.galenframework.reports.GalenTestInfo;
//import com.galenframework.reports.HtmlReportBuilder;
//import com.galenframework.reports.model.LayoutReport;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import parentTest.ParentTest;


//

//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;


import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


// need extance ParentTest
    public class SampleUILayoutTest  {
        private static final String lambdaTestpage = "src/resourses/specs/lambdatest.gspec";
        private static final String baseURL = "https://www.lambdatest.com/";
        private WebDriver webDriver;
  //
  //        private LayoutReport layoutReport;

        /* initialize webdriver, make sure you download chrome driver in http://chromedriver.chromium.org/downloads
        and drop the exe file under resources folder
         */
 /*       @BeforeClass
        public void init() {
            //declaration and instantiation of Objects/variables
            System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
            webDriver = new ChromeDriver();
            //triggers chrome to launch for directing it towards the base url
            webDriver.get(baseURL);
            //Maximize the browser window
            webDriver.manage().window().maximize();
        }

        @Test
        public void checkLogoVisibleAndImageVerification() throws IOException {
            //Executing Layout check and obtaining the Layout report
            layoutReport = Galen.checkLayout(webDriver, lambdaTestpage, Arrays.asList("desktop"));
        }

        @AfterMethod
        public void reportUpdate() {
            try {
                //Creating a list of tests
                List<GalenTestInfo> tests = new LinkedList<>();
                //The object you create will be consisting the information regarding the test
                GalenTestInfo test = GalenTestInfo.fromString("Test Automation Using Galen Framework");
                //Adding layout report to the test report
                test.getReport().layout(layoutReport, "Verify logo present and log image comparison");
                tests.add(test);
                //Exporting all test report to html
                new HtmlReportBuilder().build(tests, "target/galen-html-reports");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @AfterClass
        public void tearDown() {
            //Close and Quit the driver.
            webDriver.quit();
       }
*/

}

//need to add in pom:

/* dependancy:

<!-- https://mvnrepository.com/artifact/com.galenframework/galen-java-support -->
<dependency>
<groupId>com.galenframework</groupId>
<artifactId>galen-java-support</artifactId>
<version>2.0.9</version>
</dependency>

<dependency>
<groupId>org.testng</groupId>
<artifactId>testng</artifactId>
<version>6.9.10</version>
<scope>test</scope>
</dependency>

*/