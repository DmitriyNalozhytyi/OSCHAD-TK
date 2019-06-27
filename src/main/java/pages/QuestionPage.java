package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class QuestionPage extends ParentPage {
    public QuestionPage(WebDriver webDriver) {
        super(webDriver);
    }


    @FindBy(xpath = ".//*[@id='createNewItem']")
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

    @FindBy(id = "lsrte_LSCMTDraftDecision_ifr")
    private WebElement fieldDraftDecision;

    @FindBy(id = "sendForApproval")
    private WebElement buttonStartWorkFlow;

    @FindBy(id = "addNewStage")
    private  WebElement buttonCreateStep;

    @FindBy(id = "LSCMTStagesN_dbfef24f-5310-4a07-9976-8773a86a84d8_$NumberField")
    private  WebElement fieldNumberStepInNewFrame;

    @FindBy(id = "LSCMTStagesEx_a407fb50-774d-4cd8-bc7b-9ad14e83902f_$ClientPeoplePicker_EditorInput")
    private WebElement fieldExecutor;

    @FindBy(id = "LSCMTStagesTerm_d0e47b26-212e-4a9f-94f7-3a3ad873811a_$NumberField")
    private  WebElement fieldTermTask;

    @FindBy(id = "ctl00_ctl43_g_a88f2c3d_16fb_4e2e_a94a_33b2b355870c_ctl00_toolBarTbl_RightRptControls_ctl00_ctl00_diidIOSaveItem")
    private  WebElement buttonCreate1StStep;

    @FindBy(id = "LSCMTStagesExType_051b2411-8af1-4486-b0e7-7cb00ca7fec5_$RadioButtonChoiceField2")
    private WebElement checkBoxSecretary;

    @FindBy(id="startRoute")
    private WebElement buttonStartRoute;

    @FindBy (className ="lsrte_LSCMTComments_ifr")
    private WebElement closeFormWithSteps;

 //   @FindBy (xpath = "//*[@class = 'ls-tab active-tab']")
  //  private WebElement tabTasksOnQuestionCard;

    @FindBy (className ="info-counter")
    private WebElement tabTasksOnQuestionCard;

    @FindBy (className = "ls-tasks-link")
    private WebElement firstQuestionTask;

    @FindBy (className = "ls-tasks-buttons")
    private WebElement buttonAgreeTaskForm;

   @FindBy(id = "lsrte_LSCMTComments_ifr")
    private WebElement commFieldQuestTask;

   @FindBy (className = "ls-tasks-link")
   private WebElement secretaryQuestionTask;



    // creating question card:

    public void clickOnButtonCreateQuestion() {
        actionsWithOurElements.clickOnElement(createQuestionCardButton);
        // webDriver.findElement(By.xpath(".//*[@id='createNewItem']")).click();
        // webDriver.findElement(By.cssSelector("#createNewItem")).click();
       }

    public void enterTextInToFieldTitle(String fieldText) {
        actionsWithOurElements.openFirstFrame(fieldTitle);
       // webDriver.switchTo().frame(webDriver.findElements(By.tagName("iframe")).size() - 1);
        actionsWithOurElements.enterTextInToElement(fieldTitle, fieldText);
            //webDriver.findElement(By.cssSelector("input[id^='Title_']")).sendKeys(name);
    }

    public void enterTextInToFieldShortContent(String fieldText) {
        actionsWithOurElements.enterTextInToElement(fieldShortContent, fieldText);
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
       actionsWithOurElements.enterTextInToElement(fieldDesiredMeetingDate, fieldText);
    }

    public void enterTextInToFieldPresenters(String fieldText) {
        actionsWithOurElements.enterTextInToElement(fieldPresenters, fieldText);
    }

    public void enterTextInToFieldInvited(String fieldText) {
        actionsWithOurElements.enterTextInToElement(fieldInvited, fieldText);
    }

    public void enterTextInToFieldReportTime(String fieldText) {
        fieldReportTime.clear();
        actionsWithOurElements.enterTextInToElement(fieldReportTime,fieldText);
    }

    public void enterTextInToFieldDraftDecision(String fieldText) {
        actionsWithOurElements.enterTextInToElement(fieldDraftDecision, fieldText);
    }

    public void clickOnButtonSaveQuestionCard() {
        actionsWithOurElements.clickOnElement(buttonSaveQuestionCard);
    }

    // question card created and save

    // starting WorkFlow:

        public void clickOnButtonStartWorkflowInNewFrame() {
        actionsWithOurElements.changeFrameWithWait(buttonStartWorkFlow);
        actionsWithOurElements.clickOnElement(buttonStartWorkFlow);
    }


    // ER:

  //  public boolean isStartFlowButtonPresent() {
  //      try {
   //         Thread.sleep(10000);
   //         return webDriver.findElement(By.id("sendForApproval")).isDisplayed();
  //      } catch (Exception e) {
  //          return false;
  //      }
  //  }

    // open new frame:

    public void clickOnButtonCreateStep() {
        actionsWithOurElements.changeFrameWithWait(buttonCreateStep);
        actionsWithOurElements.clickOnElement(buttonCreateStep);
    }

    public void enterTextInToFieldNumberStepInNewFrame(String fieldText) {
        actionsWithOurElements.changeFrameWithWait(fieldNumberStepInNewFrame);
        actionsWithOurElements.enterTextInToElement(fieldNumberStepInNewFrame, fieldText);
    }

    public void enterTextInToFieldExecutor(String fieldText) {
        actionsWithOurElements.enterTextInToPeopePickerFieldUsingEnter(fieldExecutor, fieldText);
    }

   public void enterTextInToFieldTermTask(String fieldText) {
        actionsWithOurElements.enterTextInToElement(fieldTermTask, fieldText);
    }

    public void clickOnButtonCreate1StStep() {
        actionsWithOurElements.clickOnElement(buttonCreate1StStep);
    }

    public void chooseRadioButtonSecretary() {
        actionsWithOurElements.clickOnElement(checkBoxSecretary);
    }

    public void clickOnButtonStartRoute() {
        actionsWithOurElements.changeFrameWithWait(buttonStartRoute);
        actionsWithOurElements.clickOnElement(buttonStartRoute);
       }

    public void closeFormWithSteps() {
        actionsWithOurElements.quiteFromAllFrames(closeFormWithSteps);
        actionsWithOurElements.clickOnLastElement();

    }

    public void openTasksOnQuestionCard() {
        actionsWithOurElements.changeFrameWithWait(tabTasksOnQuestionCard);
        actionsWithOurElements.clickOnElement(tabTasksOnQuestionCard);

    }

    public void clickOn1stTaskQuestion() {
        actionsWithOurElements.clickOnElement(firstQuestionTask);
    }

    public void enterTextInToFieldCommQuestionTask(String fieldText) {
        actionsWithOurElements.changeFrameWithWait(commFieldQuestTask);
        actionsWithOurElements.enterTextInToElement(commFieldQuestTask, fieldText);
    }

    public void clickOnButtonAggreeOnTaskForm() {
       // actionsWithOurElements.changeFrameWithWait(buttonAgreeTaskForm);



          //  try {
                List<WebElement> actionButtons = webDriver.findElements(By.className("ls-tasks-buttons"));

                System.out.println(actionButtons.size() + " - number of same elements");
                if(actionButtons.size() > 0) {
                    actionButtons.get(actionButtons.size()-4).click();
                    System.out.println("actionButtons was clicked");
                }else{
                    System.out.println("!!! number of same elements '0'!!! ");
                }
       // }






    }


    public void clickOnSecretaryTaskQuestion() {
        actionsWithOurElements.changeFrameWithWait(secretaryQuestionTask);
        actionsWithOurElements.clickOnElement(secretaryQuestionTask);
    }
}







