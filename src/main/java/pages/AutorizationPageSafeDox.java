package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutorizationPageSafeDox extends ParentPage {
    public AutorizationPageSafeDox(WebDriver webDriver) {
        super(webDriver);
    }


    @FindBy(id = "i0116")
    private WebElement login;

    @FindBy(id = "idSIButton9")
    private WebElement nextButton;

    @FindBy(id = "aadTile")
    private WebElement chooseWorkAcc;




    public void openAutorizedForm() {
        try {
            webDriver.get("https://ls-safedox-front.azurewebsites.net/admin");

            System.out.println("SafeDoxAutorization was opened");
        }catch (Exception e) {
            System.out.println("Can not open CommitteesPageAfterAutorization" + e);
            Assert.fail("Can not open SafeDoxAutorization" + e);
        }
    }

    public void enterLogPass(String fieldText) {

        actionsWithOurElements.enterTextInToElement(login, fieldText);

    }

    public void clickOnNextButton() {
        actionsWithOurElements.clickOnElement(nextButton);
    }

    public void chooseWorkAccount() {
        actionsWithOurElements.clickOnElement(chooseWorkAcc);
    }
}
