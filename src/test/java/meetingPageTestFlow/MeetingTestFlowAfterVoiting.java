package meetingPageTestFlow;

import org.junit.Test;
import parentTest.ParentTest;

public class MeetingTestFlowAfterVoiting extends ParentTest {

    @Test
    public void workWithMeetingByClerkAfterVoiting () {
        chooseCommitteesPage.openChooseCommitteesPageAfterAutorization();
        chooseCommitteesPage.clickOnTK();
        meetingsPage.openMeetingsPage();
        meetingsPage.openListOfOpenedMeetings();
        meetingsPage.openLastOpenMeeting();
        meetingsPage.tabDocumentsInMeetingCard();
        meetingsPage.clickOnButtonStartTasksForImplementation();
        parentPage.exitTest();
    }
}
