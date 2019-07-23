package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MeetingsPage extends ParentPage {
    public MeetingsPage (WebDriver webDriver) {
        super(webDriver);
    }



    @FindBy(xpath = ".//*[@id='createNewItem']")
    private WebElement createMeetingCardButton;

    @FindBy(id = "LSCMTMeetingsDate_bb1b9fe4-be0f-4dca-a2c7-00648c66f9bd_$DateTimeFieldDate")
    private WebElement meetingsDate;

    @FindBy(id = "LSCMTMeetingsDateStart_d68e93fa-24fb-430a-979d-8eae632e86cf_$DateTimeFieldDate")
    private WebElement meetingsDateFinish;



    @Step
    public void openMeetingsPage(){
        try {
            webDriver.get("https://ob-committees.ext5.lizard.net.ua/sites/tk/lists/LSCMTMeetingsList");
            System.out.println("MeetingsPage was opened");
        }catch (Exception e) {
            System.out.println("Can not open MeetingsPage" + e);
            Assert.fail("Can not open MeetingsPage" + e);
        }
    }

    @Step
    public void clickOnButtonCreateMeeting() {
        actionsWithOurElements.clickOnElement(createMeetingCardButton);

    }

    @Step
    public void enterTextInToFieldMeetingsDate(String fieldText) {
        actionsWithOurElements.changeFrameWithWait(meetingsDate);
        actionsWithOurElements.clearField(meetingsDate);
        actionsWithOurElements.enterTextInToElement(meetingsDate, fieldText);
    }

    public void chooseHoursMeetingsDateStartinDD() {
        Select dropDown = new Select(webDriver.findElement(By.id("LSCMTMeetingsDateStart_d68e93fa-24fb-430a-979d-8eae632e86cf_$DateTimeFieldDateHours")));
        dropDown.selectByIndex(3);

    }
    @Step
    public void enterTextInToFieldMeetingsDateStart(String fieldText) {
        actionsWithOurElements.clearField(meetingsDateFinish);
        actionsWithOurElements.enterTextInToElement(meetingsDateFinish, fieldText);

    }

    public void chooseMinutesMeetingsDateStartinDD() {
        Select dropDown = new Select(webDriver.findElement(By.id("LSCMTMeetingsDateStart_d68e93fa-24fb-430a-979d-8eae632e86cf_$DateTimeFieldDateMinutes")));
        dropDown.selectByIndex(3);

    }
}

