package testSuits;

import meetingPageTestFlow.MeetingTestFlowAfterVoiting;
import meetingPageTestFlow.MeetingTestFlowToCreatedSolutionTasks;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import outlookTest.AutorizationOutlook;
import questionPageTestFlow.QuestionTestFlow;
import solutionPageTestFlow.DoSolutionVoiceTaskByChairMan;
import solutionPageTestFlow.DoSolutionVoiceTaskByMember;


//(«@RunWith(Suite.class)» (аннотация для запуска тестов из определенных классов) «@Suite.SuiteClasses»
// ( аннатоция для перечисление классов, которе необходимо ранить))

@RunWith(Suite.class)
@Suite.SuiteClasses({

        QuestionTestFlow.class,
        MeetingTestFlowToCreatedSolutionTasks.class,
        DoSolutionVoiceTaskByMember.class,
        DoSolutionVoiceTaskByChairMan.class,
        MeetingTestFlowAfterVoiting.class,
   //     AutorizationOutlook.class



})

public class TestFlowSuiteEndToEnd {
}
