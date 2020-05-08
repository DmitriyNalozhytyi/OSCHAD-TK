package сardFormsTest;

import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;


//Указываем аннотацию @RunWith (инструмент, которій будет подставлять в переменные разные данные и запускать блок @Test с этими данными) -
// Скажем junit-y , что данный класс LoginWithParams, в котором написан этот тест нужно запускать с параметрами

@RunWith(Parameterized.class)

public class QuestionCardFormTest extends ParentTest {

    // тут мы просто обьявили переменные:
    String title;
    String shortContent;
  //  String affilliation;
  //  String priotity;
  //  String orderMeeting;
    String desiredMeetingDate;
    String presenters;
    String invited;
    String reportTime;
    String draftDecision;

    public QuestionCardFormTest(String title, String shortContent, String desiredMeetingDate, String presenters, String invited, String reportTime, String draftDecision) {

        //, String desiredMeetingDate, String presenters, String invited, String reportTime, String draftDecision

        // здесь, в конструкторе, мы передаем значения, непосредственно в переменные с помощью "this." (значения до єтого передаются в параметры этого конструктора)
        this.title = title;
        this.shortContent = shortContent;
        this.desiredMeetingDate = desiredMeetingDate;
        this.presenters = presenters;
        this.invited = invited;
        this.reportTime = reportTime;
        this.draftDecision = draftDecision;
    }


    // Исключение в Java — это объект, который описывает исключительное состояние, воз­никшее в каком-либо участке программного кода.
    // Когда возникает ис­ключительное состояние, создается объект класса Exception. Этот объект пересылается в метод, обрабатывающий данный тип исключительной ситуации.

    //Оператор throw используется для возбуждения исключения «вручную».

    //Подключили класс ошибки (IOException) напрямую к методу зарезервированным словом "throws" (метод указан в {}):

    //Класс InputStream. Базовый класс InputStream представляет классы, которые получают данные из различных источников

    //configProperties - объект, который умеет ходить в файл ConfigProperties и по ключу достать значение: DATA_FILE_PATH - ключ, а значение - .//src//main//java//data//(путь к папке)
    // в итоге стринги в скобках склеиваются и получается путь к файлу: .//src//main//java//data//testDataSuitQuestionCardForm.xls


//@Parameterized.Parameters говорит о том, что дальше будет идти метод, который будет генерить эти тестовые данные)
// (Collection, массив Arrays.asList (new Object [] [] {}))

    @Parameterized.Parameters(name = "Parameters are {0} and {1} and {2} and {3} and {4} and {5} and {6} ")

    public static Collection testData() throws IOException {
// след 2 строки - путь к нашему файлу:
        //в 3-й строке (с return) - создаем объект (называем SpreadsheetData), даем ему путь (из первых 2х строк) и говорим:
        //пойди в этот файл и с вкладки "InvalidLogOn" получи все что там есть и getData преобразовывает к тому виду, что каждая строка - набор данных. и это все возвращаем
        InputStream spreadsheet
                = new FileInputStream(configProperties.DATA_FILE_PATH()+"testDataSuitQuestionCardForm.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();
    }

    @Test
    public void checkFieldsQuestionCardForm()  {

        chooseCommitteesPage.openChooseCommitteesPageAfterAutorization();
        chooseCommitteesPage.clickOnTK();
        questionPage.clickOnButtonCreateQuestion();
        //QuestionCard
       // questionPage.enterTextInToFieldTitle("LOL LOL LOL");
        questionPage.enterTextInToFieldTitle(title);
        //questionPage.enterTextInToFieldShortContent(" korotkiy zmist text");
        questionPage.enterTextInToFieldShortContent(shortContent);
        questionPage.chooseValueAffilliationInDD();
        questionPage.chooseValuePriorityInDD();
        questionPage.chooseValueOrderMeetingInDD();
       // questionPage.enterTextInToFieldDesiredMeetingDate("11.10.2019");
        questionPage.enterTextInToFieldDesiredMeetingDate(desiredMeetingDate);
      //  questionPage.enterTextInToFieldPresenters("Марк Леон");
        questionPage.enterTextInToFieldPresenters(presenters);
      //  questionPage.enterTextInToFieldInvited("Стелла Орен");
        questionPage.enterTextInToFieldInvited(invited);
      //  questionPage.enterTextInToFieldReportTime("60");
        questionPage.enterTextInToFieldReportTime(reportTime);
      //  questionPage.enterTextInToFieldDraftDecision("проект решения...");
        questionPage.enterTextInToFieldDraftDecision(draftDecision);
        questionPage.clickOnButtonSaveQuestionCard();
        checkExpectedResult(
                "StartWorkFlowButton is NOT present",
                questionPage.isStartFlowButtonPresent()
        );
    }
}
