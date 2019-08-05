package questionCardForm;

import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;


@RunWith(Parameterized.class)

public class MeetingCardFormTest extends ParentTest {

    String meetingsDate;

    String meetingsDateStart;
    //String hoursmeetingsDateStart;
    //String minutesmeetingsDateStart;

    String meetingsDateFinish;
    //String hoursMeetingsDateFinish;
    //String minutesMeetingsDateFinish;

    String meetingsPlace;
    //String meetingsType;
    //String regular;

    String chairman;
  //  String members;
    String clerk;
    String advisories;
    String invited;
    String speakers;
    String comments;
//
    String dateForProtocol;
   // String hoursdateForProtocol;
   // String minutesdateForProtocol;

    public MeetingCardFormTest(String meetingsDate, String meetingsDateStart, String meetingsDateFinish, String meetingsPlace, String chairman, String clerk, String advisories, String invited, String speakers, String comments, String dateForProtocol) {


        this.meetingsDate = meetingsDate;
        this.meetingsDateStart = meetingsDateStart;
        this.meetingsDateFinish = meetingsDateFinish;
        this.meetingsPlace = meetingsPlace;
        this.chairman = chairman;
        this.clerk = clerk;
        this.advisories = advisories;
        this.invited = invited;
        this.speakers = speakers;
        this.comments = comments;
        this.dateForProtocol = dateForProtocol;

    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1} and {2} and {3} and {4} and {5} and {6} ")

    public static Collection testDataMeetingCardForm() throws IOException {
        InputStream spreadsheet
                = new FileInputStream(configProperties.DATA_FILE_PATH()+"testDataSuitMeetingCardForm.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();
    }

    @Test

    public void checkFieldsQuestionCardForm()  {

        chooseCommitteesPage.openChooseCommitteesPageAfterAutorization();
        chooseCommitteesPage.clickOnTK();
        meetingsPage.openMeetingsPage();
        meetingsPage.clickOnButtonCreateMeeting();
     //   meetingsPage.enterTextInToFieldMeetingsDate("11.10.2020");
        meetingsPage.enterTextInToFieldMeetingsDate(meetingsDate);
     //   meetingsPage.enterTextInToFieldMeetingsDateStart("12.10.2020");
        meetingsPage.enterTextInToFieldMeetingsDateStart(meetingsDateStart);
        meetingsPage.chooseHoursMeetingsDateStartInDD();
        meetingsPage.chooseMinutesMeetingsDateStartInDD();
      //  meetingsPage.enterTextInToFieldMeetingsDateFinish("13.10.2020");
        meetingsPage.enterTextInToFieldMeetingsDateFinish(meetingsDateFinish);
        meetingsPage.chooseHoursMeetingsDateFinishInDD();
        meetingsPage.chooseMinutesMeetingsDateFinishInDD();
       // meetingsPage.enterTextInToFieldMeetingsPlace("уганда");
        meetingsPage.enterTextInToFieldMeetingsPlace(meetingsPlace);
        meetingsPage.chooseMeetingsTypeInDD();
        meetingsPage.chooseRegularInDD();
// costil
      //  meetingsPage.enterTextInToFieldChairman("Алла Сорока");
        meetingsPage.enterTextInToFieldChairman(chairman);

        //meetingsPage.enterTextInToFieldMembers("Aртем Аронов");

        //meetingsPage.enterTextInToFieldClerk("Марк Леон");
        meetingsPage.enterTextInToFieldClerk(clerk);
// costil
      //  meetingsPage.enterTextInToFieldAdvisories("Андре Грин");
        meetingsPage.enterTextInToFieldAdvisories(advisories);
      //  meetingsPage.enterTextInToFieldInvited("Андре Грин");
        meetingsPage.enterTextInToFieldInvited(invited);
      //  meetingsPage.enterTextInToFieldSpeakers("Андре Грин");
        meetingsPage.enterTextInToFieldSpeakers(speakers);
      //  meetingsPage.enterTextInToFieldComments("comment");
        meetingsPage.enterTextInToFieldComments(comments);
      //  meetingsPage.enterTextInToFieldDateForProtocol("14.10.2020");
        meetingsPage.enterTextInToFieldDateForProtocol(dateForProtocol);
        meetingsPage.chooseHoursDateForProtocol();
        meetingsPage.chooseMinutesDateForProtocol();
        meetingsPage.clickOnButtonSaveMeetingCard();

        //
        meetingsPage.clickOnStartMeetingButton();
        meetingsPage.tabDocumentsInMeetingCard();
        meetingsPage.clickOnButtonAddQuestionsToMeeting();

        meetingsPage.chooseQuestionToPDforMeetingCard();
        meetingsPage.clickOnButtonAddQuestionsFromList();
        meetingsPage.clickOnButtonCreateSolutionOnMeetingCard();

        solutionPage.enterTextInToFieldCommentingTerm("13.10.2020");
        solutionPage.chooseHoursCommentingTermInDD();
        solutionPage.chooseMinutesCommentingTermInDD();
        solutionPage.enterTextInToFieldMainSolutionText(" text rishennya");
        solutionPage.clickOnButtonAddDicisionPoint();
        solutionPage.enterTextInToFieldPointText(" punkt rishennya");
        solutionPage.enterTextInToFieldResponsibleUsers("Марк Леон");
        solutionPage.enterTextInToFieldPointDueData("13.10.2022");
        solutionPage.chooseCheckBoxPointDeclarative();
        solutionPage.clickOnButtonSaveSolutionCard();
        solutionPage.closeSolutionCard();
        meetingsPage.openCreatedSolutionFromMeetingCard();
        solutionPage.chooseSolutionTabInSolutionCard();
        solutionPage.clickOnButtonStartVoiting();
        solutionPage.enterTextInToFieldVoitingTerm("13.10.2020");
        solutionPage.chooseHoursInToFieldVoitingTermInDD();
        solutionPage.chooseMinutesInToFieldVoitingTermInDD();
        solutionPage.clickOnButtonSave();








        //   checkExpectedResult(
       //                  "StartMeetingButton is NOT present",
       //                   meetingsPage.isStartMeetingButtonPresent()
        //          );



    }






}
