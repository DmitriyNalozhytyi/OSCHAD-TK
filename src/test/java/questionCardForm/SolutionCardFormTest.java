package questionCardForm;

import org.junit.Test;
import parentTest.ParentTest;

public class SolutionCardFormTest extends ParentTest {


    @Test

    public void checkFieldsSolutionCardForm()  {

        chooseCommitteesPage.openChooseCommitteesPageAfterAutorization();
        chooseCommitteesPage.clickOnTK();
        solutionPage.openSolutionPage();
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












    //    meetingsPage.openMeetingsPage();
  //      meetingsPage.clickOnButtonCreateMeeting();
        //   meetingsPage.enterTextInToFieldMeetingsDate("11.10.2020");
  //      meetingsPage.enterTextInToFieldMeetingsDate(meetingsDate);
        //   meetingsPage.enterTextInToFieldMeetingsDateStart("12.10.2020");

   //     checkExpectedResult(
   //             "StartMeetingButton is NOT present",
      //          meetingsPage.isStartMeetingButtonPresent()
    //    );



    }




}
