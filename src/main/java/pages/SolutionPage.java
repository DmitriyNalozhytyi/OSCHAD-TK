package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class SolutionPage extends ParentPage {
    public SolutionPage(WebDriver webDriver) {
        super(webDriver);
    }


    @Step
    public void openSolutionPage() {
        try {
            webDriver.get("https://ob-committees.ext5.lizard.net.ua/sites/tk/Lists/LSCMTSolutionsList/NewForm.aspx");
            System.out.println("MeetingsPage was opened");
        } catch (Exception e) {
            System.out.println("Can not open MeetingsPage" + e);
            Assert.fail("Can not open MeetingsPage" + e);
        }
    }





}