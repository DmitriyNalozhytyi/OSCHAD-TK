package questionCardForm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)

public class QuestionCardForm extends ParentTest {

    String titleField;
    String shortContent;

    public QuestionCardForm (String titleField, String shortContent) {
        this.titleField = titleField;
        this.shortContent = shortContent;
    }

    @Parameterized.Parameters
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Sasha"," Kooooo4545"},
                {"Sasha2"," Кооо24545"}
        });
    }
    @Test

    public void checkFieldsQuestionCardForm() {

        chooseCommitteesPage.openChooseCommitteesPageAfterAutorization();
        chooseCommitteesPage.clickOnTK();
        questionPage.clickOnButtonCreateQuestion();
        //QuestionCard
       // questionPage.enterTextInToFieldTitle("New Question");
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
        checkExpectedResult(
                "StartWorkFlowButton is NOT present",
                questionPage.isStartFlowButtonPresent()
        );
    }




}
