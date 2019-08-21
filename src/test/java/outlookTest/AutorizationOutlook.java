package outlookTest;

import org.junit.Test;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

public class AutorizationOutlook extends ParentTest {

    @Parameterized.Parameters

    @Test

    public void outlookAutorized(){
        outlookPage.openAutirizedForm();
        outlookPage.inputEmail("Dmytro.Nalozhytyi@lizard-soft.com");
        outlookPage.clickOnButtonOnOnAutorizationForm();
        outlookPage.chooseWorkRecord();
        outlookPage.inputPass("ufkkfrnbrf23");
        outlookPage.clickOnButtonOnOnAutorizationForm();
        outlookPage.clickOnButtonOkQuiteFromSystem();
        outlookPage.chooseCurrentMail();
      //  outlookPage.openLink();
    }


}
