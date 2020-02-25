package chooseCommitteesTest;

import org.junit.Test;
import parentTest.ParentTest;

public class ChooseCommitteesTest extends ParentTest {

    @Test
    public void validLogin(){
        chooseCommitteesPage.openChooseCommitteesPageAfterAutorization();
          chooseCommitteesPage.clickOnTK();
        questionPage.clickOnButtonCreateQuestion();

    }

}

