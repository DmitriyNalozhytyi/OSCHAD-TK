package solutionPageTestFlow;

import org.junit.Test;
import parentTest.ParentTest;

public class DoSolutionVoiceTaskByChairMan extends ParentTest {

    @Test
    public void doVoitingTaskByChairMan (){
        chooseCommitteesPage.openChooseCommitteesPageAfterAutorizationByChairMan();
        chooseCommitteesPage.clickOnTK();
        meetingsPage.openMeetingsPage();
        meetingsPage.openListOfOpenedMeetings();
        meetingsPage.openLastOpenMeeting();
        meetingsPage.tabDocumentsInMeetingCard();
        meetingsPage.openCreatedSolutionFromMeetingCard();
        solutionPage.chooseTasksTabInSolutionCard();
        solutionPage.chooseTaskVoitingForChairMan();
        solutionPage.enterTextInToFieldCommentsInVoitingTast("yes chairman");
        solutionPage.chooseYesVoitingTask();
        parentPage.exitTest();

    }

}
