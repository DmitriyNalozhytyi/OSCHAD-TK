package questionPageTestFlow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;


//Указываем аннотацию @RunWith (инструмент, которій будет подставлять в переменные разные данные и запускать блок @Test с этими данными) -
// Скажем junit-y , что данный класс LoginWithParams, в котором написан этот тест нужно запускать с параметрами

@RunWith(Parameterized.class)

public class QuestionTestFlow extends ParentTest {

    String titleField;
    String shortContent;

    public QuestionTestFlow(String titleField, String shortContent) {
        this.titleField = titleField;
        this.shortContent = shortContent;
    }

    //здесь аннотация @Parameterized.Parameters говорит о том, что дальше будет идти метод, который будет генерить эти тестовые данные)
    //(Collection, массив Arrays.asList (new Object [] [] {}))

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {"Question", " Short Content"},
                //    {"Sasha2","Кооо2"}
        });
    }

    @Test()
    public void fromCreateAndAproveQuestionToMeetingStartSolution() {
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
        questionPage.enterTextInToFieldDraftDecision(" проект решения...");
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
        parentPage.exitTest();
    }

}
