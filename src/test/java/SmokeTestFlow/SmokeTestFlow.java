package SmokeTestFlow;

        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.junit.runners.Parameterized;
        import parentTest.ParentTest;

        import java.util.Arrays;
        import java.util.Collection;

@RunWith(Parameterized.class)

public class SmokeTestFlow extends ParentTest {

    String titleField;
    String shortContent;

    public SmokeTestFlow(String titleField, String shortContent) {
        this.titleField = titleField;
        this.shortContent = shortContent;
    }

    @Parameterized.Parameters
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Question"," Short Content"},
            //    {"Sasha2","Кооо2"}
        });
    }

    @Test
    public void clickOnCreateQuestionButton(){
        //preConditions
        chooseCommitteesPage.openChooseCommitteesPageAfterAutorization();
        chooseCommitteesPage.clickOnTK();
        questionPage.clickOnButtonCreateQuestion();
        //QuestionCard
      //  questionPage.enterTextInToFieldTitle("New Question");
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
        questionPage.enterTextInToFieldDraftDecision(" проект решения...");
        questionPage.clickOnButtonSaveQuestionCard();
        //question card is created
        questionPage.clickOnButtonStartWorkflowInNewFrame();
        // open form to create steps
        questionPage.clickOnButtonCreateStep();
        questionPage.enterTextInToFieldNumberStepInNewFrame("1");
        questionPage.enterTextInToFieldExecutor("Марк Леон");
        questionPage.enterTextInToFieldTermTask("1");
        questionPage.clickOnButtonCreate1StStep();
        // created 1st step (people picker)
        questionPage.clickOnButtonCreateStep();
        questionPage.enterTextInToFieldNumberStepInNewFrame("2");
        questionPage.chooseRadioButtonSecretary();
        questionPage.enterTextInToFieldTermTask("2");
        questionPage.clickOnButtonCreate1StStep();
        // created all steps
        questionPage.clickOnButtonStartRoute();
        // WorkFlow Started
        questionPage.closeFormWithSteps();
        questionPage.openTasksOnQuestionCard();
        questionPage.clickOn1stTaskQuestion();
        questionPage.enterTextInToFieldCommQuestionTask("dfgdfgdfgd");
        questionPage.clickOnButtonAggreeOnTaskForm();
        questionPage.clickOnSecretaryTaskQuestion();
        questionPage.enterTextInToFieldCommQuestionTask("GGGGGGGG");
        questionPage.clickOnButtonAggreeOnTaskForm();
        questionPage.closeQuestionCard();

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
        meetingsPage.enterTextInToFieldMeetingsPlace("уганда");
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
        meetingsPage.enterTextInToFieldAdvisories("Андре Грин");
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

     //   checkExpectedResult(
       //         "StartFlow button is not present",
        //        questionPage.isStartFlowButtonPresent()
        //);

    }

}
