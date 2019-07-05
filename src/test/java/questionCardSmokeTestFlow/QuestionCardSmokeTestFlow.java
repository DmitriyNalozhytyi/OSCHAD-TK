package questionCardSmokeTestFlow;

        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.junit.runners.Parameterized;
        import parentTest.ParentTest;

        import java.util.Arrays;
        import java.util.Collection;


@RunWith(Parameterized.class)

public class QuestionCardSmokeTestFlow extends ParentTest {

    String titleField;
    String shortContent;

    public QuestionCardSmokeTestFlow(String titleField, String shortContent) {
        this.titleField = titleField;
        this.shortContent = shortContent;
    }

    @Parameterized.Parameters
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Sasha","Kooooo"},
                {"Sasha2","Кооо2"}
        });
    }

    @Test
    public void clickOnCreateQuestionButton(){
        //preConditions
        chooseCommitteesPage.openChooseCommitteesPageAfterAutorization();
        chooseCommitteesPage.clickOnTK();
        questionPage.clickOnButtonCreateQuestion();
        //QuestionCard
      //  questionPage.enterTextInToFieldTitle("New Question");
        questionPage.enterTextInToFieldTitle(titleField);
       // questionPage.enterTextInToFieldShortContent(" korotkiy zmist text");
        questionPage.enterTextInToFieldShortContent(shortContent);
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
        questionPage.closeQuestionCard();





     //   checkExpectedResult(
       //         "StartFlow button is not present",
        //        questionPage.isStartFlowButtonPresent()
        //);



    }

}
