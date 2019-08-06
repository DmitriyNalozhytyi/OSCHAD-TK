package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SolutionPage extends ParentPage {
    public SolutionPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "LSCMTCommentingTerm_8942a13b-864a-4db4-8739-19f48644980c_$DateTimeFieldDate")
    private WebElement commentingTerm;

    @FindBy(id = "lsrte_mainSolutionText_ifr")
    private WebElement solutionText;

    @FindBy(id = "addDecisionPoint")
    private WebElement addDicisionPoint;

    @FindBy(id = "lsrte_pointText_1_ifr")
    private WebElement pointText;

    @FindBy(id = "responsibleUsers_1_TopSpan_EditorInput")
    private WebElement responsibleUsers;

    @FindBy(id = "pointDueDate_1_input")
    private WebElement pointDueData;

    @FindBy(id = "pointDeclarative_1")
    private WebElement checkBoxPointDeclarative;

    @FindBy(id = "ctl00_ctl43_g_da786971_9822_420f_8d18_efc80b67d510_ctl00_toolBarTbl_RightRptControls_ctl00_ctl00_diidIOSaveItem")
    private WebElement buttonSaveSolutionCard;


    @FindBy(id = "startVoting")
    private WebElement buttonStartVoiting;


    @FindBy(id = "LSCMTVotingTerm_87d4545d-9baf-43d5-92d9-563f6abf5f0f_$DateTimeFieldDate")
    private WebElement fieldVoitingTerm;




    @FindBy(id = "ctl00_ctl43_g_0841cb6b_d3f6_44d5_a123_a8518c724878_ctl00_toolBarTbl_RightRptControls_ctl00_ctl00_diidIOSaveItem")
    private WebElement buttonSaveVoitingTerm;
    @Step
    public void openSolutionPage() {
        try {
            webDriver.get("https://ob-committees.ext5.lizard.net.ua/sites/tk/Lists/LSCMTSolutionsList/NewForm.aspx");
            System.out.println("MeetingsPage was opened");
        } catch (Exception e) {
            System.out.println("Can not open MeetingsPage" + e);
            Assert.fail("Can not open MeetingsPage" + e);
        }
    }

    @Step
    public void enterTextInToFieldCommentingTerm(String fieldText) {
        actionsWithOurElements.changeFrameWithWait(commentingTerm);
        actionsWithOurElements.enterTextInToElement(commentingTerm, fieldText);
    }

    @Step
    public void chooseHoursCommentingTermInDD() {
        Select dropDown = new Select(webDriver.findElement(By.id("LSCMTCommentingTerm_8942a13b-864a-4db4-8739-19f48644980c_$DateTimeFieldDateHours")));
        dropDown.selectByIndex(3);
    }

    @Step
    public void chooseMinutesCommentingTermInDD() {
        Select dropDown = new Select(webDriver.findElement(By.id("LSCMTCommentingTerm_8942a13b-864a-4db4-8739-19f48644980c_$DateTimeFieldDateMinutes")));
        dropDown.selectByIndex(3);
    }

    @Step
    public void enterTextInToFieldMainSolutionText(String fieldText) {
        actionsWithOurElements.enterTextInToElement(solutionText, fieldText);
    }

    @Step
    public void clickOnButtonAddDicisionPoint() {
        actionsWithOurElements.clickOnElement(addDicisionPoint);
    }

    @Step
    public void enterTextInToFieldPointText(String fieldText) {
        actionsWithOurElements.enterTextInToElement(pointText, fieldText);
    }

    @Step
    public void enterTextInToFieldResponsibleUsers(String fieldText) {
        actionsWithOurElements.enterTextInToPeopePickerFieldUsingEnter(responsibleUsers, fieldText);
    }

    public void enterTextInToFieldPointDueData(String fieldText) {
        actionsWithOurElements.enterTextInToElement(pointDueData, fieldText);
    }

    public void chooseCheckBoxPointDeclarative() {
        actionsWithOurElements.clickOnElement(checkBoxPointDeclarative);
    }

    public void clickOnButtonSaveSolutionCard() {
        actionsWithOurElements.clickOnElement(buttonSaveSolutionCard);
    }

    public void closeSolutionCard() {
        actionsWithOurElements.quiteFromAllFrames(buttonSaveSolutionCard);
        actionsWithOurElements.clickOnLastElement();
    }

    public void chooseSolutionTabInSolutionCard() {
        actionsWithOurElements.changeFrameWithWait(buttonSaveSolutionCard);
        List<WebElement> inactiveTabsOnMeetingCard = webDriver.findElements(By.className("inactive-tab"));

        System.out.println(inactiveTabsOnMeetingCard.size() + " - number of tabs on Meeting Card");
        if (inactiveTabsOnMeetingCard.size() > 0) {
            inactiveTabsOnMeetingCard.get(inactiveTabsOnMeetingCard.size() - 4).click();
            logger.info("tab Solutin opened");
        } else {
            logger.info("!!! number of same elements '0'!!! ");

        }

    }


    public void clickOnButtonStartVoiting() {
        actionsWithOurElements.clickOnElement(buttonStartVoiting);
   //     actionsWithOurElements.changeFrameWithWait(buttonStartVoiting);

     //   try {
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.alertIsPresent());
        //   Alert alert = webDriver.switchTo().alert();
       //     System.out.println(alert.getText());
       //    alert.accept();
       //     Assert.assertTrue(alert.getText().contains("Thanks."));

      //  } catch (Exception e) {
      //      exception handling
     //  }
        webDriver.switchTo().alert().accept();

////////////////////////////////////////
   //     public static void HandleAlert(WebDriver webDriver, WebDriverWait wait) {
     //       if (wait == null) {
       //         wait = new WebDriverWait(webDriver, 5);
         //   }

         //   try {
           //     Alert alert = wait.Until(new ExpectedCondition<Alert> {
             //       return new ExpectedCondition<Alert>() {
               //         @Override
                 //       public Alert apply(WebDriver driver) {
                   //         try {
                     //           return driver.switchTo().alert();
                       //     } catch (NoAlertPresentException e) {
                         //       return null;
     //                       }
       //                 }
         //           }
           //     });
             //   alert.Accept();
     //       } catch (WebDriverTimeoutException) { /* Ignore */ }
      //  }

    }

    public void enterTextInToFieldVoitingTerm(String fieldText) {
        actionsWithOurElements.changeFrameWithWait(buttonStartVoiting);
        actionsWithOurElements.enterTextInToElement(fieldVoitingTerm, fieldText);
    }


    public void chooseHoursInToFieldVoitingTermInDD() {
        Select dropDown = new Select(webDriver.findElement(By.id("LSCMTVotingTerm_87d4545d-9baf-43d5-92d9-563f6abf5f0f_$DateTimeFieldDateHours")));
        dropDown.selectByIndex(1);
    }

    public void chooseMinutesInToFieldVoitingTermInDD() {
        Select dropDown = new Select(webDriver.findElement(By.id("LSCMTVotingTerm_87d4545d-9baf-43d5-92d9-563f6abf5f0f_$DateTimeFieldDateHours")));
        dropDown.selectByIndex(1);
    }

    public void clickOnButtonSave() {

        actionsWithOurElements.clickOnElement(buttonSaveVoitingTerm);
    }
//https://www.urlencoder.org/
    //COMPETENCE\mark.leonLjrevtyn33 (двоеточие между логином и паролем не указываем, т.к. «:» будет инкодировано как «%3A». Доставим потом. Либо же по очереди инкодировать логин и пароль)
   //competence\alla.sorokaLjrevtyn0   = competence%5Calla.sorokaLjrevtyn0

    public void registraionByChairMan() {
        webDriver.close();
        try {
            webDriver.get("https://competence%5Calla.soroka:Ljrevtyn0@ob-committees.ext5.lizard.net.ua/SitePages/Home.aspx");
            System.out.println("Alla Soroka autorized");
        }catch (Exception e) {
            System.out.println("Can not open CommitteesPageAfterAutorization by Alla Soroka" + e);
            Assert.fail("Can not open CommitteesPageAfterAutorization by Alla Soroka" + e);
        }
    }
}