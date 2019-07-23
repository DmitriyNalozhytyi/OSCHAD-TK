package questionCardForm;

import org.junit.Test;
import parentTest.ParentTest;


//@RunWith(Parameterized.class)

public class MeetingCardFormTest extends ParentTest {

 //   String meetingsDate;

  //  String meetingsDateStart;
 //   String hoursmeetingsDateStart;
 //   String minutesmeetingsDateStart;

   // String meetingsDateFinish;
    //String hoursMeetingsDateFinish;
    //String minutesMeetingsDateFinish;

  //  String meetingsPlace;
  //  String meetingsType;
  //  String chairman;
  //  String members;
   // String advisories;
   // String speakers;
   // String comments;
//
  //  String dateForProtocol;
   // String hoursdateForProtocol;
   // String minutesdateForProtocol;

  //  public MeetingCardFormTest(String meetingsDate) {


   //     this.meetingsDate = meetingsDate;

  //  }

  //  @Parameterized.Parameters(name = "Parameters are {0} and {1} and {2} and {3} and {4} and {5} and {6} ")

//    public static Collection testDataMeetingCardForm() throws IOException {
 //       InputStream spreadsheet
 //               = new FileInputStream(configProperties.DATA_FILE_PATH()+"testDataSuit.xls");
  //      return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();
  //  }

    @Test

    public void checkFieldsQuestionCardForm()  {

        chooseCommitteesPage.openChooseCommitteesPageAfterAutorization();
        chooseCommitteesPage.clickOnTK();
        meetingsPage.openMeetingsPage();
        meetingsPage.clickOnButtonCreateMeeting();
        meetingsPage.enterTextInToFieldMeetingsDate("11.10.2020");
        meetingsPage.enterTextInToFieldMeetingsDateStart("12.10.2020");
        meetingsPage.chooseHoursMeetingsDateStartinDD();
        meetingsPage.chooseMinutesMeetingsDateStartinDD();

   //     questionPage.clickOnButtonCreateQuestion();

        //QuestionCard
        // questionPage.enterTextInToFieldTitle("LOL LOL LOL");
     //   questionPage.enterTextInToFieldTitle(title);
        //questionPage.enterTextInToFieldShortContent(" korotkiy zmist text");
    //    questionPage.enterTextInToFieldShortContent(shortContent);
     //   questionPage.chooseValueAffilliationInDD();
     //   questionPage.chooseValuePriorityInDD();
       // questionPage.chooseValueOrderMeetingInDD();
        // questionPage.enterTextInToFieldDesiredMeetingDate("11.10.2019");
      //  questionPage.enterTextInToFieldDesiredMeetingDate(desiredMeetingDate);
        //  questionPage.enterTextInToFieldPresenters("Марк Леон");
      //  questionPage.enterTextInToFieldPresenters(presenters);
        //  questionPage.enterTextInToFieldInvited("Стелла Орен");
      //  questionPage.enterTextInToFieldInvited(invited);
        //  questionPage.enterTextInToFieldReportTime("60");
      //  questionPage.enterTextInToFieldReportTime(reportTime);
        //  questionPage.enterTextInToFieldDraftDecision("проект решения...");
      //  questionPage.enterTextInToFieldDraftDecision(draftDecision);
       // questionPage.clickOnButtonSaveQuestionCard();
     //   checkExpectedResult(
      //          "StartWorkFlowButton is NOT present",
      //          questionPage.isStartFlowButtonPresent()
      //  );
    }






}
