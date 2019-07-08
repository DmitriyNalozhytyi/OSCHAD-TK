package questionCardForm;

import libs.ExcelDriver;
import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

@RunWith(Parameterized.class)

public class QuestionCardForm extends ParentTest {

    String titleField;
    String shortContent;

    public QuestionCardForm (String titleField, String shortContent) {
        this.titleField = titleField;
        this.shortContent = shortContent;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
        InputStream spreadsheet
                = new FileInputStream(configProperties.DATA_FILE_PATH()+"testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();
    }

    @Test

    public void checkFieldsQuestionCardForm()  {

        chooseCommitteesPage.openChooseCommitteesPageAfterAutorization();
        chooseCommitteesPage.clickOnTK();
        questionPage.clickOnButtonCreateQuestion();
        //QuestionCard
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
