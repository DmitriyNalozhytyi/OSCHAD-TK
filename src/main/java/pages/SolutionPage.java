package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SolutionPage extends ParentPage {
    public SolutionPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "LSCMTCommentingTerm_8942a13b-864a-4db4-8739-19f48644980c_$DateTimeFieldDate")
    private WebElement commentingTerm;

    @FindBy(id = "lsrte_mainSolutionText_ifr")
    private WebElement solutionText;

    @FindBy(id = "addDecisionPoint")
    private WebElement addDicisionPoint;

    @FindBy(id = "lsrte_pointText_1_ifr")
    private WebElement pointText;

    @FindBy(id = "responsibleUsers_1_TopSpan_EditorInput")
    private WebElement responsibleUsers;

    @FindBy(id = "pointDueDate_1_input")
    private WebElement pointDueData;

    @FindBy(id = "pointDeclarative_1")
    private WebElement checkBoxPointDeclarative;

    @FindBy(id = "ctl00_ctl43_g_da786971_9822_420f_8d18_efc80b67d510_ctl00_toolBarTbl_RightRptControls_ctl00_ctl00_diidIOSaveItem")
    private WebElement buttonSaveSolutionCard;





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
    @Step
    public void enterTextInToFieldCommentingTerm(String fieldText) {
        actionsWithOurElements.changeFrameWithWait(commentingTerm);
        actionsWithOurElements.enterTextInToElement(commentingTerm, fieldText);
    }
    @Step
    public void chooseHoursCommentingTermInDD() {
            Select dropDown = new Select(webDriver.findElement(By.id("LSCMTCommentingTerm_8942a13b-864a-4db4-8739-19f48644980c_$DateTimeFieldDateHours")));
            dropDown.selectByIndex(3);
    }
    @Step
    public void chooseMinutesCommentingTermInDD() {
        Select dropDown = new Select(webDriver.findElement(By.id("LSCMTCommentingTerm_8942a13b-864a-4db4-8739-19f48644980c_$DateTimeFieldDateMinutes")));
        dropDown.selectByIndex(3);
    }
    @Step
    public void enterTextInToFieldMainSolutionText(String fieldText) {
        actionsWithOurElements.enterTextInToElement(solutionText, fieldText);
    }
    @Step
    public void clickOnButtonAddDicisionPoint() {
        actionsWithOurElements.clickOnElement(addDicisionPoint);
    }
    @Step
    public void enterTextInToFieldPointText(String fieldText) {
        actionsWithOurElements.enterTextInToElement(pointText, fieldText);
    }
    @Step
    public void enterTextInToFieldResponsibleUsers(String fieldText) {
        actionsWithOurElements.enterTextInToPeopePickerFieldUsingEnter(responsibleUsers, fieldText);
    }

    public void enterTextInToFieldPointDueData(String fieldText) {
        actionsWithOurElements.enterTextInToElement(pointDueData, fieldText);
    }

    public void chooseCheckBoxPointDeclarative() {
        actionsWithOurElements.clickOnElement(checkBoxPointDeclarative);
    }

    public void clickOnButtonSaveSolutionCard() {
        actionsWithOurElements.clickOnElement(buttonSaveSolutionCard);
    }
}