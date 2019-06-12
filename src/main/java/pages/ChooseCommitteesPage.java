package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;



public class ChooseCommitteesPage extends ParentPage {
    public ChooseCommitteesPage (WebDriver webDriver){
        super(webDriver);

    }



    public void openChooseCommitteesPageAfterAutorization(){
        try {
            webDriver.get("https://COMPETENCE%5Cmark.leon:Ljrevtyn33@ob-committees.ext5.lizard.net.ua/SitePages/Home.aspx");
            System.out.println("CommitteesPageAfterAutorization was opened");
        }catch (Exception e) {
            System.out.println("Can not open CommitteesPageAfterAutorization" + e);
            Assert.fail("Can not open CommitteesPageAfterAutorization" + e);
        }
    }


    public void clickOnTK() {
        try{
            webDriver.findElement(By.xpath(".//*[@href='https://ob-committees.ext5.lizard.net.ua/sites/tk']")).click();
           //webDriver.findElement(By.xpath(".//p[@title='Технічний комітет')).click();
        }catch (Exception e) {
            System.out.println("Can't open QuestionListTK" + e);
            Assert.fail("Can't open QuestionListTK" + e);
        }

    }
}


