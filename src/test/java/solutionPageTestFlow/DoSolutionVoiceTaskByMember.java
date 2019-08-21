package solutionPageTestFlow;

import org.junit.Test;
import parentTest.ParentTest;

public class DoSolutionVoiceTaskByMember extends ParentTest {

    @Test
    public void doVoitingTaskByMember (){
        chooseCommitteesPage.openChooseCommitteesPageAfterAutorizationByMember();
        chooseCommitteesPage.clickOnTK();
        meetingsPage.openMeetingsPage();
        meetingsPage.openListOfOpenedMeetings();
        meetingsPage.openLastOpenMeeting();
        meetingsPage.tabDocumentsInMeetingCard();
        meetingsPage.openCreatedSolutionFromMeetingCard();
        solutionPage.chooseTasksTabInSolutionCard();
        solutionPage.chooseTaskVoitingForMember();
        solutionPage.enterTextInToFieldCommentsInVoitingTast("yes member");
        solutionPage.chooseYesVoitingTask();
        parentPage.exitTest();



    }
}
