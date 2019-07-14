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

    String title;
    String shortContent;
  //  String affilliation;
  //  String priotity;
  //  String orderMeeting;
    String desiredMeetingDate;
    String presenters;
    String invited;
    String reportTime;
    String draftDecision;

    public QuestionCardForm(String title, String shortContent, String desiredMeetingDate, String presenters, String invited, String reportTime, String draftDecision) {

        //, String desiredMeetingDate, String presenters, String invited, String reportTime, String draftDecision
        this.title = title;
        this.shortContent = shortContent;
        this.desiredMeetingDate = desiredMeetingDate;
        this.presenters = presenters;
        this.invited = invited;
        this.reportTime = reportTime;
        this.draftDecision = draftDecision;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1} and {2} and {3} and {4} and {5} and {6} ")

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
       // questionPage.enterTextInToFieldTitle("LOL LOL LOL");
        questionPage.enterTextInToFieldTitle(title);
        //questionPage.enterTextInToFieldShortContent(" korotkiy zmist text");
        questionPage.enterTextInToFieldShortContent(shortContent);
        questionPage.chooseValueAffilliationInDD();
        questionPage.chooseValuePriorityInDD();
        questionPage.chooseValueOrderMeetingInDD();
       // questionPage.enterTextInToFieldDesiredMeetingDate("11.10.2019");
        questionPage.enterTextInToFieldDesiredMeetingDate(desiredMeetingDate);
      //  questionPage.enterTextInToFieldPresenters("Марк Леон");
        questionPage.enterTextInToFieldPresenters(presenters);
      //  questionPage.enterTextInToFieldInvited("Стелла Орен");
        questionPage.enterTextInToFieldInvited(invited);
      //  questionPage.enterTextInToFieldReportTime("60");
        questionPage.enterTextInToFieldReportTime(reportTime);
      //  questionPage.enterTextInToFieldDraftDecision("проект решения...");
        questionPage.enterTextInToFieldDraftDecision(draftDecision);
        questionPage.clickOnButtonSaveQuestionCard();
        checkExpectedResult(
                "StartWorkFlowButton is NOT present",
                questionPage.isStartFlowButtonPresent()
        );
    }




}
