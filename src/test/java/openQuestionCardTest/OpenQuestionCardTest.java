package openQuestionCardTest;

        import org.junit.Test;
        import parentTest.ParentTest;

public class OpenQuestionCardTest extends ParentTest {

    @Test
    public void clickOnCreateQuestionButton(){
        //preConditions
        chooseCommitteesPage.openChooseCommitteesPageAfterAutorization();
        chooseCommitteesPage.clickOnTK();
        questionPage.clickOnButtonCreateQuestion();
        //QuestionCard
        questionPage.enterTextInToFieldTitle("New Question");
        questionPage.enterTextInToFieldShortContent(" korotkiy zmist text");
        questionPage.chooseValueAffilliationInDD();
        questionPage.chooseValuePriorityInDD();
        questionPage.chooseValueOrderMeetingInDD();
        questionPage.enterTextInToFieldDesiredMeetingDate("11.10.2019");
        questionPage.enterTextInToFieldPresenters("Марк Леон");
        questionPage.enterTextInToFieldInvited("Стелла Орен");
        questionPage.enterTextInToFieldReportTime("60");
        questionPage.enterTextInToFieldDraftDecision("проект решения...");
        questionPage.clickOnButtonSaveQuestionCard();
        //question card is created
        questionPage.clickOnButtonStartWorkflowInNewFrame();
        // open form to create steps
        questionPage.clickOnButtonCreateStep();
        questionPage.enterTextInToFieldNumberStepInNewFrame("1");
        questionPage.enterTextInToFieldExecutor("Марк Леон");
        questionPage.enterTextInToFieldTermTask("1");
        questionPage.clickOnButtonCreate1StStep();
        // created 1st step (people picker)
        questionPage.clickOnButtonCreateStep();
        questionPage.enterTextInToFieldNumberStepInNewFrame("2");
        questionPage.chooseRadioButtonSecretary();
        questionPage.enterTextInToFieldTermTask("2");
        questionPage.clickOnButtonCreate1StStep();
        // created all steps
        questionPage.clickOnButtonStartRoute();
        // WorkFlow Started
        questionPage.closeFormWithSteps();
        questionPage.openTasksOnQuestionCard();
        questionPage.clickOn1stTaskQuestion();
        questionPage.enterTextInToFieldCommQuestionTask("dfgdfgdfgd");
        questionPage.clickOnButtonAggreeOnTaskForm();
        questionPage.clickOnSecretaryTaskQuestion();
        questionPage.enterTextInToFieldCommQuestionTask("GGGGGGGG");
        questionPage.clickOnButtonAggreeOnTaskForm();

     //   checkExpectedResult(
       //         "StartFlow button is not present",
        //        questionPage.isStartFlowButtonPresent()
        //);



    }
}
