package autorizationSafeDoxTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AutorizationSafeDoxTest extends ParentTest {

    @Test
public void Autorization (){

        autorizationPageSafeDox.openAutorizedForm();
        autorizationPageSafeDox.enterLogPass("Dmytro.Nalozhytyi@lizard-soft.com");
        // invalid login less 14 p 24
        // logger less 14 p 17
        autorizationPageSafeDox.clickOnNextButton();
        autorizationPageSafeDox.chooseWorkAccount ();

}

}
