package meetingPageTestFlow;

import org.junit.Test;
import parentTest.ParentTest;

public class MeetingTestFlowToCreatedSolutionTasks extends ParentTest {

    @Test()
    public void meetingTestFlowToCreatedSolutionTasks() {

        chooseCommitteesPage.openChooseCommitteesPageAfterAutorization();
        chooseCommitteesPage.clickOnTK();
        meetingsPage.openMeetingsPage();
        meetingsPage.clickOnButtonCreateMeeting();
        meetingsPage.enterTextInToFieldMeetingsDate("11.10.2020");
        // meetingsPage.enterTextInToFieldMeetingsDate(meetingsDate);
        meetingsPage.enterTextInToFieldMeetingsDateStart("12.10.2020");
        // meetingsPage.enterTextInToFieldMeetingsDateStart(meetingsDateStart);
        meetingsPage.chooseHoursMeetingsDateStartInDD();
        meetingsPage.chooseMinutesMeetingsDateStartInDD();
        meetingsPage.enterTextInToFieldMeetingsDateFinish("13.10.2020");
        //meetingsPage.enterTextInToFieldMeetingsDateFinish(meetingsDateFinish);
        meetingsPage.chooseHoursMeetingsDateFinishInDD();
        meetingsPage.chooseMinutesMeetingsDateFinishInDD();
        meetingsPage.enterTextInToFieldMeetingsPlace("TEST_PLACE");
        // meetingsPage.enterTextInToFieldMeetingsPlace(meetingsPlace);
        meetingsPage.chooseMeetingsTypeInDD();
        meetingsPage.chooseRegularInDD();
// try
        meetingsPage.enterTextInToFieldChairman("Алла Сорока");
        //meetingsPage.enterTextInToFieldChairman(chairman);

        //meetingsPage.enterTextInToFieldMembers("Aртем Аронов");

        meetingsPage.enterTextInToFieldClerk("Марк Леон");
        //meetingsPage.enterTextInToFieldClerk(clerk);
// try
        //     meetingsPage.enterTextInToFieldAdvisories("Андре Грин");
        //meetingsPage.enterTextInToFieldAdvisories(advisories);
        meetingsPage.enterTextInToFieldInvited("Андре Грин");
        // meetingsPage.enterTextInToFieldInvited(invited);
        meetingsPage.enterTextInToFieldSpeakers("Андре Грин");
        //meetingsPage.enterTextInToFieldSpeakers(speakers);
        meetingsPage.enterTextInToFieldComments("comment");
        //meetingsPage.enterTextInToFieldComments(comments);
        meetingsPage.enterTextInToFieldDateForProtocol("14.10.2020");
        //meetingsPage.enterTextInToFieldDateForProtocol(dateForProtocol);
        meetingsPage.chooseHoursDateForProtocol();
        meetingsPage.chooseMinutesDateForProtocol();
        meetingsPage.clickOnButtonSaveMeetingCard();

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
        parentPage.exitTest();
    }

}
