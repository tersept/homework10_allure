package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideIssueNameTest {
    @Test
    void checkNameTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("eroshenkoam/allure-example");
        $(".header-search-input").pressEnter();

        $("a[href*='eroshenkoam/allure-example']").click();
        $("#issues-tab").click();
        $("#issue_80_link").shouldHave(Condition.text("e.sh"));
    }


}
