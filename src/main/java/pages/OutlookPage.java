package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OutlookPage extends ParentPage {
    public OutlookPage(WebDriver webDriver) {
        super(webDriver);
    }


    @FindBy(className = "ltr_override")
    private WebElement loginOutlook;

    @FindBy(id = "idSIButton9")
    private WebElement buttonOnOnAutorizationForm;

    @FindBy(className = "tile")
    private WebElement workRecord;


    @FindBy(className = "form-control")
    private WebElement passwordAutorization;

    @FindBy(id = "idSIButton9")
    private WebElement buttonOkQuiteFromSystem;


   // _1xP-XmXM1GGHpRKCCeOKjP
   @FindBy(className = "_1xP-XmXM1GGHpRKCCeOKjP")
   private WebElement lastMessageInOutlook;






    public void openAutirizedForm() {
        try {
            webDriver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=13&ct=1565073016&rver=7.0.6737.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26RpsCsrfState%3d318ddb89-4824-afb1-845c-a5e96ffaf652&id=292841&aadredir=1&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=90015");
            System.out.println("Outlook autorization form was opened");
        }catch (Exception e) {
            System.out.println("Can not open CommitteesPageAfterAutorization" + e);
            Assert.fail("Can not open CommitteesPageAfterAutorization" + e);
        }
    }

    public void inputEmail(String fieldText) {
        actionsWithOurElements.enterTextInToElement(loginOutlook, fieldText);
    }

    public void clickOnButtonOnOnAutorizationForm() {
        actionsWithOurElements.clickOnElement(buttonOnOnAutorizationForm);
    }

    public void chooseWorkRecord() {
        actionsWithOurElements.clickOnElement(workRecord);
    }

    public void inputPass(String fieldText) {
        actionsWithOurElements.enterTextInToElement(passwordAutorization, fieldText);
    }

    public void clickOnButtonOkQuiteFromSystem() {
        actionsWithOurElements.clickOnElement(buttonOkQuiteFromSystem);
    }


    public void chooseCurrentMail() {

       actionsWithOurElements.clickOnElement(lastMessageInOutlook);

       // if we need choose one of 75 messages - use this:

//        List<WebElement> inactiveTabsOnMeetingCard = webDriver.findElements(By.className("_1xP-XmXM1GGHpRKCCeOKjP"));
 //       System.out.println(inactiveTabsOnMeetingCard.size() + " - number of tabs on Meeting Card");
  //      if(inactiveTabsOnMeetingCard.size() > 0) {
   //         inactiveTabsOnMeetingCard.get(inactiveTabsOnMeetingCard.size()-74).click();
    //        logger.info("tab PD opened");
    //    }else{
    //        logger.info("!!! number of same elements '0'!!! ");

     //   }


    }

    public void openLink() {
        webDriver.findElement(By.xpath("//a[@href='https://chercher.tech/java/close-quit-browser-selenium-webdriver']")).click();
    }
}
