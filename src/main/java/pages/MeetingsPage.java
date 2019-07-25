package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MeetingsPage extends ParentPage {
    public MeetingsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//*[@id='createNewItem']")
    private WebElement createMeetingCardButton;

    @FindBy(id = "LSCMTMeetingsDate_bb1b9fe4-be0f-4dca-a2c7-00648c66f9bd_$DateTimeFieldDate")
    private WebElement meetingsDate;

    @FindBy(id = "LSCMTMeetingsDateStart_d68e93fa-24fb-430a-979d-8eae632e86cf_$DateTimeFieldDate")
    private WebElement meetingsDateStart;

    @FindBy(id = "LSCMTMeetingsDateFinish_630cd823-d2a4-4e57-b431-ecfcbe25a631_$DateTimeFieldDate")
    private WebElement meetingsDateFinish;

    @FindBy(id = "LSCMTMeetingsPlace_b3d60184-80be-4cd0-9c85-96dc832360c4_$TextField")
    private WebElement meetingsPlace;

    @FindBy(id = "LSCMTChairman_cb342a13-b819-4c38-aba1-0506edd26131_$ClientPeoplePicker_EditorInput")
    private WebElement fieldChairman;

    @FindBy(className = "sp-peoplepicker-delImage")
    private WebElement deleteUserInPeoplePicker;

    @FindBy(id = "LSCMTMembers_375a776d-4e56-4beb-a8ee-d8d84673622f_$ClientPeoplePicker_EditorInput")
    private WebElement members;

    @FindBy(id = "LSCMTClerk_3f64f882-a3e3-4398-9c4b-3383ef7d7eed_$ClientPeoplePicker_EditorInput")
    private WebElement clerk;

    @FindBy(id = "LSCMTAdvisories_98986183-820d-4906-a549-10d60185ec54_$ClientPeoplePicker_EditorInput")
    private WebElement advisories;

    @FindBy(id = "LSCMTInvited_fff39c82-f839-4127-8396-db601f1d53aa_$ClientPeoplePicker_EditorInput")
    private WebElement invited;

    @FindBy(id = "LSCMTSpeakers_4a581e98-389f-4898-bde9-b144c7db833f_$ClientPeoplePicker_EditorInput")
    private WebElement speakers;

    @FindBy(id = "LSCMTComments_ca062879-69b8-4d64-bd4d-64c5dd100dcd_$TextField")
    private WebElement comments;

    @FindBy(id = "LSCMTDateForProtocol_299cca24-1ab1-4654-8507-4d40125c77bd_$DateTimeFieldDate")
    private WebElement dateForProtocol;

    @FindBy(id = "ctl00_ctl43_g_3cf592d7_ef16_4c69_a2ce_275007d99080_ctl00_toolBarTbl_RightRptControls_ctl00_ctl00_diidIOSaveItem")
    private WebElement buttonSaveMeetingCard;

    @FindBy(id = "startMeeting")
    private WebElement buttonStartMeeting;

    @Step
    public void openMeetingsPage() {
        try {
            webDriver.get("https://ob-committees.ext5.lizard.net.ua/sites/tk/lists/LSCMTMeetingsList");
            System.out.println("MeetingsPage was opened");
        } catch (Exception e) {
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
    @Step
    public void enterTextInToFieldMeetingsDateStart(String fieldText) {
        actionsWithOurElements.clearField(meetingsDateStart);
        actionsWithOurElements.enterTextInToElement(meetingsDateStart, fieldText);
    }
    @Step
    public void chooseHoursMeetingsDateStartInDD() {
        Select dropDown = new Select(webDriver.findElement(By.id("LSCMTMeetingsDateStart_d68e93fa-24fb-430a-979d-8eae632e86cf_$DateTimeFieldDateHours")));
        dropDown.selectByIndex(3);
    }
    @Step
    public void chooseMinutesMeetingsDateStartInDD() {
        Select dropDown = new Select(webDriver.findElement(By.id("LSCMTMeetingsDateStart_d68e93fa-24fb-430a-979d-8eae632e86cf_$DateTimeFieldDateMinutes")));
        dropDown.selectByIndex(2);
    }
    @Step
    public void enterTextInToFieldMeetingsDateFinish(String fieldText) {
        actionsWithOurElements.clearField(meetingsDateFinish);
        actionsWithOurElements.enterTextInToElement(meetingsDateFinish, fieldText);
    }
    @Step
    public void chooseHoursMeetingsDateFinishInDD() {
        Select dropDown = new Select(webDriver.findElement(By.id("LSCMTMeetingsDateFinish_630cd823-d2a4-4e57-b431-ecfcbe25a631_$DateTimeFieldDateHours")));
        dropDown.selectByIndex(3);
    }
    @Step
    public void chooseMinutesMeetingsDateFinishInDD() {
        Select dropDown = new Select(webDriver.findElement(By.id("LSCMTMeetingsDateFinish_630cd823-d2a4-4e57-b431-ecfcbe25a631_$DateTimeFieldDateMinutes")));
        dropDown.selectByIndex(1);
    }
    @Step
    public void enterTextInToFieldMeetingsPlace(String fieldText) {
        actionsWithOurElements.clearField(meetingsPlace);
        actionsWithOurElements.enterTextInToElement(meetingsPlace, fieldText);
    }
    @Step
    public void chooseMeetingsTypeInDD() {
        Select dropDown = new Select(webDriver.findElement(By.id("LSCMTMeetingType_a2e84a2d-6ace-47bf-93bc-04c058cb4256_$DropDownChoice")));
        dropDown.selectByIndex(1);
    }
    @Step
    public void chooseRegularInDD() {
        Select dropDown = new Select(webDriver.findElement(By.id("LSCMTMeetingPriority_757a0099-9387-494d-b3d9-b4f4b29373a9_$DropDownChoice")));
        dropDown.selectByIndex(1);
    }
    @Step
    public void enterTextInToFieldChairman(String fieldText) {
        actionsWithOurElements.clickOnElement(deleteUserInPeoplePicker);
       // actionsWithOurElements.clearField(fieldChairman);
        actionsWithOurElements.enterTextInToElement(fieldChairman, fieldText);
    }
    @Step
    public void enterTextInToFieldMembers(String fieldText) {
     //   actionsWithOurElements.deleteMember();
 // actionsWithOurElements.clickOnElement(deleteUserInPeoplePicker);
        actionsWithOurElements.enterTextInToElement(members, fieldText);
    }
    @Step
    public void enterTextInToFieldClerk(String fieldText) {
      //  actionsWithOurElements.deleteClerk();
        try {
            List<WebElement> closeButtons = webDriver.findElements(By.className("sp-peoplepicker-delImage"));
            logger.info(closeButtons.size() + " - number of same elements");
            //System.out.println(closeButtons.size() + " - number of same elements");
            if (closeButtons.size() > 0) {
                closeButtons.get(closeButtons.size() - 1).click();
                logger.info("Second element was clicked");
                // System.out.println("CloseButton was clicked");
            } else {
                logger.info("!!! number of same elements '0'!!! ");
                //  System.out.println("!!! number of same elements '0'!!! ");
            }
        } catch (Exception e) {
            logger.info("Can't click jn second element" + e);
          //   System.out.println("Can't enter text in to fieldExecutor" + e);
           // printErrorAndStopTest(e);
        }
        actionsWithOurElements.enterTextInToElement(clerk, fieldText);
    }
    @Step
    public void enterTextInToFieldAdvisories(String fieldText) {
        actionsWithOurElements.enterTextInToElement(advisories, fieldText);
    }
    @Step
    public void enterTextInToFieldInvited(String fieldText) {
        actionsWithOurElements.enterTextInToElement(invited, fieldText);
    }
    @Step
    public void enterTextInToFieldSpeakers(String fieldText) {
        actionsWithOurElements.enterTextInToElement(speakers, fieldText);
    }
    @Step
    public void enterTextInToFieldComments(String fieldText) {
        actionsWithOurElements.enterTextInToElement(comments, fieldText);
    }
    @Step
    public void enterTextInToFieldDateForProtocol(String fieldText) {
        actionsWithOurElements.clearField(dateForProtocol);
        actionsWithOurElements.enterTextInToElement(dateForProtocol, fieldText);
    }
    @Step
    public void chooseHoursDateForProtocol() {
        Select dropDown = new Select(webDriver.findElement(By.id("LSCMTDateForProtocol_299cca24-1ab1-4654-8507-4d40125c77bd_$DateTimeFieldDateHours")));
        dropDown.selectByIndex(3);
    }
    @Step
    public void chooseMinutesDateForProtocol() {
        Select dropDown = new Select(webDriver.findElement(By.id("LSCMTDateForProtocol_299cca24-1ab1-4654-8507-4d40125c77bd_$DateTimeFieldDateMinutes")));
        dropDown.selectByIndex(3);
    }
    @Step
    public void clickOnButtonSaveMeetingCard() {
        actionsWithOurElements.clickOnElement(buttonSaveMeetingCard);
    }
    @Step
    public boolean isStartMeetingButtonPresent() {
        actionsWithOurElements.changeFrameWithWait(buttonStartMeeting);
        return actionsWithOurElements.isElementPresent(buttonStartMeeting);
    }
}
