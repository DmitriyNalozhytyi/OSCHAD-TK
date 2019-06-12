package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.ClickElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuestionPage extends ParentPage {
    public QuestionPage(WebDriver webDriver) {
        super(webDriver);
    }



    @FindBy(xpath = ".//*[@id='createNewItem']" )
    private WebElement createQuestionCardButton;

    @FindBy(id = "Title_fa564e0f-0c70-4ab9-b863-0177e6ddd247_$TextField")
    private WebElement fieldTitle;

    @FindBy(id = "lsrte_LSCMTDescription_ifr")
    private WebElement fieldShortContent;

    @FindBy(id = "LSCMTMeetingsDateW_0af791ae-d23f-460e-8425-baffe9827924_$DateTimeFieldDate")
    private WebElement fieldDesiredMeetingDate;

    @FindBy(id = "LSCMTSpeakers_4a581e98-389f-4898-bde9-b144c7db833f_$ClientPeoplePicker_EditorInput")
    private WebElement fieldPresenters;

    @FindBy(id = "ctl00_ctl43_g_5d43284d_2b8a_4759_8b16_9bbb54547421_ctl00_toolBarTbl_RightRptControls_ctl00_ctl00_diidIOSaveItem")
    private WebElement buttonSaveQuestionCard;

    @FindBy(id = "sendForApproval")
    private WebElement buttonStartFlow;

    @FindBy(id = "LSCMTAffiliation_af97b2b3-70ac-4e57-877b-5ce4e9a0fc81_$DropDownChoice")
    private WebElement menuDictionary;

    @FindBy(id = "LSCMTInvited_fff39c82-f839-4127-8396-db601f1d53aa_$ClientPeoplePicker_EditorInput")
    private WebElement fieldInvited;

    @FindBy(id = "LSCMTReportTime_82d8b287-ecd9-4263-914b-e67a7f2011c1_$NumberField")
    private WebElement fieldReportTime;

    @FindBy(id ="lsrte_LSCMTDraftDecision_ifr")
    private WebElement fieldDraftDecision;

    @FindBy(id = "sendForApproval")
    private WebElement buttonStartWorkFlow;



    public void clickOnButtonCreateQuestion() {
        try{
            createQuestionCardButton.click();
           // webDriver.findElement(By.xpath(".//*[@id='createNewItem']")).click();
           // webDriver.findElement(By.cssSelector("#createNewItem")).click();

        }catch (Exception e) {
            System.out.println("Can't open QuestionCardTK" + e);
            Assert.fail("Can't open QuestionCardTK" + e);
        }
    }

    public void enterTextInToFieldTitle(String fieldText) {
        try{
            webDriver.switchTo().frame(webDriver.findElements(By.tagName("iframe")).size()-1);
            actionsWithOurElements.enterTextInToElement(fieldTitle, fieldText);
            //webDriver.findElement(By.cssSelector("input[id^='Title_']")).sendKeys(name);
        }catch (Exception e) {
             System.out.println("Can't enter text in to fieldTitle" + e);
             Assert.fail("Can't enter text in to fieldTitle" + e);
        }
    }

    public void enterTextInToFieldShortContent(String fieldText) {
        try{
            actionsWithOurElements.enterTextInToElement(fieldShortContent, fieldText);
        }catch (Exception e) {
            System.out.println("Can't enter text in to fieldShortContent" + e);
            Assert.fail("Can't enter text in to fieldShortContent" + e);
        }
    }

    public void chooseValueAffilliationInDD() {
        Select dropDown = new Select(webDriver.findElement(By.id("LSCMTAffiliation_af97b2b3-70ac-4e57-877b-5ce4e9a0fc81_$DropDownChoice")));
        dropDown.selectByIndex(3);
    }

    public void chooseValuePriorityInDD() {
        Select dropDown = new Select(webDriver.findElement(By.id("LSCMTPriority_a35dfcee-a2d8-43b8-990a-706615bfbf48_$DropDownChoice")));
        dropDown.selectByIndex(0);
    }

    public void chooseValueOrderMeetingInDD() {
        Select dropDown = new Select(webDriver.findElement(By.id("LSCMTMeetingPriority_757a0099-9387-494d-b3d9-b4f4b29373a9_$DropDownChoice")));
        dropDown.selectByIndex(1);
    }

    public void enterTextInToFieldDesiredMeetingDate(String fieldText) {
        try{
            actionsWithOurElements.enterTextInToElement(fieldDesiredMeetingDate, fieldText);
        }catch (Exception e) {
            System.out.println("Can't enter text in to fieldDesiredMeetingDate" + e);
            Assert.fail("Can't enter text in to fieldDesiredMeetingDate" + e);
        }
    }

    public void enterTextInToFieldPresenters(String fieldText) {
        try{
            fieldPresenters.sendKeys(fieldText);
         }catch (Exception e) {
            System.out.println("Can't enter text in to fieldPresenters" + e);
            Assert.fail("Can't enter text in to fieldPresenters" + e);
        }
    }

    public void enterTextInToFieldInvited(String fieldText) {
        try{
            fieldInvited.sendKeys(fieldText);
         }catch (Exception e) {
            System.out.println("Can't enter text in to fieldInvited" + e);
            Assert.fail("Can't enter text in to fieldInvited" + e);
        }
    }

    public void enterTextInToFieldReportTime(String s) {
        try{
        fieldReportTime.clear();
        fieldReportTime.sendKeys(s);
        }catch (Exception e) {
        System.out.println("Can't enter text in to fieldReportTime" + e);
        Assert.fail("Can't enter text in to fieldReportTime" + e);
        }
    }

    public void enterTextInToFieldDraftDecision(String fieldText) {
        try{
            actionsWithOurElements.enterTextInToElement(fieldDraftDecision, fieldText);
        }catch (Exception e) {
            System.out.println("Can't enter text in to fieldDraftDecision" + e);
            Assert.fail("Can't enter text in to fieldDraftDecision" + e);
        }
    }

    public void clickOnButtonSaveQuestionCard() {
        actionsWithOurElements.clickOnElement(buttonSaveQuestionCard);
     }

    public void clickOnButtonStartWorkflow() {
         actionsWithOurElements.clickOnElementFrame(buttonStartWorkFlow);
    }
}







