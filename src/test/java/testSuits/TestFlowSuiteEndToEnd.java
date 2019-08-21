package testSuits;

import meetingPageTestFlow.MeetingTestFlowAfterVoiting;
import meetingPageTestFlow.MeetingTestFlowToCreatedSolutionTasks;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import outlookTest.AutorizationOutlook;
import questionPageTestFlow.QuestionTestFlow;
import solutionPageTestFlow.DoSolutionVoiceTaskByChairMan;
import solutionPageTestFlow.DoSolutionVoiceTaskByMember;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        QuestionTestFlow.class,
        MeetingTestFlowToCreatedSolutionTasks.class,
        DoSolutionVoiceTaskByMember.class,
        DoSolutionVoiceTaskByChairMan.class,
        MeetingTestFlowAfterVoiting.class,
        AutorizationOutlook.class



})

public class TestFlowSuiteEndToEnd {
}
