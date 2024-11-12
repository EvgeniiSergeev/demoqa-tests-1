package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestAutomationPracticeFormWithPageObject {

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
        registrationPge.open()
                .setFirstName("Jon")
                .setGender("Other")
                .setBirthDay("10", "October", "2000" )
                .checkFormAppears();


//        $(".table-responsive").shouldHave(text("Jon Smith"));
//        $(".table-responsive").shouldHave(text("jon@smith.com"));
//        $(".table-responsive").shouldHave(text("Male"));
//        $(".table-responsive").shouldHave(text("7926813093"));
        registrationPage.checkResults("Full Name", "Alex Egorov");

    }

}
