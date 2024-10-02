package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestPracticeForm {

    @BeforeAll
    static void beforeAll() {
//        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";  /* падала ошибка в тесте, так как страница долго загружалась */
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Jon");
        $("#lastName").setValue("Smith");
        $("#userEmail").setValue("jon@smith.com");
        $("label[class=custom-control-label]").click();
        $("#userNumber").setValue("7926813093");
        $("#dateOfBirthInput").click();
        $("[class=react-datepicker__year-select]>[value='2000']").click();
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__year-select]>[value='2000']").click();
        $("[class=react-datepicker__month-select]>[value='10']").click();
        $(".react-datepicker__month .react-datepicker__day--024").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbies-checkbox-1+label").click();
        $("#hobbies-checkbox-2+label").click();
        $("#hobbies-checkbox-3+label").click();
        $("#uploadPicture").scrollIntoView(true);
        $("#uploadPicture").uploadFromClasspath("Capture.JPG");
        $("#currentAddress").setValue("Another street 1");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").click();


        $(".table-responsive").shouldHave(text("Jon Smith"));
        $(".table-responsive").shouldHave(text("jon@smith.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("7926813093"));
        $(".table-responsive").shouldHave(text("24 November,2000"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").shouldHave(text("NCR Noida"));
        $("#closeLargeModal").click();
    }

}
